package Matlab.Recognizer;

import Matlab.DotNet.*;
import Matlab.Utils.*;
import Matlab.Nodes.*;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class MRecognizer
{
    // region STATIC METHODS:

    // region MAIN METHODS:

    public static Result<UnitNode> RecognizeText(String text, boolean buildTree)
    {
        Checker.CheckNotNull(text);

        Result<FileNode> result = MRecognizer.Recognize("", text, buildTree);

        if (buildTree && result.GetIsOk())
        {
            ArrayList<FileNode> arrayList = new ArrayList<FileNode>();

            arrayList.add(result.GetValue());

            UnitNode node = MRecognizer.CreateUnitNode(arrayList);

            return new Result<UnitNode>(node, result.GetReport());
        }
        else
        {
            return new Result<UnitNode>(null, result.GetReport());
        }
    }

    public static Result<UnitNode> RecognizeFile(String path, boolean buildTree, INotifier notifier)
    {
        Checker.CheckNotNull(path);

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add(path);

        return MRecognizer.RecognizeFiles(arrayList, buildTree, notifier);
    }

    public static Result<UnitNode> RecognizeFiles(Iterable<String> paths, boolean buildTree, INotifier notifier)
    {
        Checker.CheckNotNull(paths);

        try
        {
            Report report = new Report();

            LinkedList<FileNode> nodes = new LinkedList<FileNode>();

            for (String path : paths)
            {
                String text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

                Result<FileNode> result = MRecognizer.Recognize(path, text, (buildTree && report.GetIsOk()));

                if (notifier != null)
                {
                    notifier.Notify(path, result.GetReport());
                }

                report.AddRange(result.GetReport());

                if (buildTree && report.GetIsOk())
                {
                    nodes.addLast(result.GetValue());
                }
                else
                {
                    nodes = null;
                }
            }

            if (buildTree && report.GetIsOk())
            {
                UnitNode node = MRecognizer.CreateUnitNode(nodes);

                return new Result<UnitNode>(node, new ReadOnlyReport(report));
            }
            else
            {
                return new Result<UnitNode>(null, new ReadOnlyReport(report));
            }
        }
        catch(Exception ex)
        {
            throw new RuntimeException("CHECKED EXCEPTION", ex);
        }
    }

    // endregion

    // region WORKER METHODS:

    private static Result<FileNode> Recognize(String path, String text, boolean buildTree)
    {
        Report report = null;

        CommandMarker commandMarker = new CommandMarker();

        boolean stopOnFirstError = true;

        boolean newCommand = false;

        ExtendedTokenStream tokens = null;

        Tree tree = null;

        text = MRecognizer.FixText(text);

        do
        {
            try
            {
                report = new Report();

                newCommand = false;

                ANTLRStringStream characters = new ANTLRStringStream(text);

                MatlabLexerReal lexer = new MatlabLexerReal(characters, new Configuration(path, report, commandMarker, stopOnFirstError));

                tokens = new ExtendedTokenStream(lexer, Channel.GetDefaultInt());

                MatlabParserReal parser = new MatlabParserReal(tokens, new Configuration(path, report, commandMarker, stopOnFirstError));

                MatlabParser.file_return scope = parser.file();

                tree = (Tree)scope.getTree();
            }
            catch (CommandException ex)
            {
                newCommand = true;
            }
            catch (StopException ex)
            {
                break;
            }
            catch (Exception ex)
            {
                report.AddError(path, 0, 0, (ex.getMessage() != null ? ex.getMessage() : ""));
            }
        }
        while (report.GetIsOk() && newCommand);

        if (report.GetIsOk() && buildTree)
        {
            FileNode buildNode = TreeToNodeBuilder.Build(path, tokens, tree);

            NodeCommenter.InsertComments(buildNode, tokens);

            return new Result<FileNode>(buildNode, new ReadOnlyReport(report));
        }
        else
        {
            return new Result<FileNode>(null, new ReadOnlyReport(report));
        }
    }

    private static String FixText(String text)
    {
        char eof = DotNetConvert.ToChar(0x1a);

        int index = 0;

        for (; index < text.length(); index++)
        {
            if (text.charAt(index) == eof)
            {
                break;
            }
        }

        if (index != text.length())
        {
            text = text.substring(0, text.length() - index);
        }

        String append = DotNetEnvironment.GetNewLine() + DotNetEnvironment.GetNewLine();

        return (text + append);
    }

    private static UnitNode CreateUnitNode(Iterable<FileNode> nodes)
    {
        UnitNode node = new UnitNode();

        node.GetChildren().AddRange(nodes);

        node.Freeze();

        return node;
    }

    // endregion

    // endregion
}
