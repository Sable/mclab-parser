package Matlab.Parser;

import Matlab.DotNet.*;
import Matlab.Info.Information;
import Matlab.Utils.*;
import Matlab.Nodes.*;
import Matlab.Recognizer.*;
import Matlab.Transformer.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import natlab.toolkits.filehandling.FileFile;
import natlab.toolkits.filehandling.GenericFile;
import org.w3c.dom.Document;
import java.io.File;
import java.util.*;
import java.util.function.*;
import java.util.regex.*;
import java.nio.file.*;

import ast.*;

public class Program
{
    // region STATIC METHODS:

    // region MAIN METHOD:

    public static void main(String[] args)
    {
        try
        {
            DotNetConsole.WriteLine();

            Program.PrintHeader();

            if (args.length == 0)
            {
                System.exit(0);
                
                return;
            }
            else if (args.length == 1 && args[0].equals("/help"))
            {
                Program.PrintHelp();

                System.exit(0);
                
                return;
            }
            else if (args.length >= 4 && args[0].equals("/out:") && args[2].equals("/files:"))
            {
                Output output = Program.GetOutput(args[1]);

                int exitCode = Program.ParseFilesByName(output, (output == Output.SingleFile ? args[1] : null), DotNetEnumerable.Skip(DotNetEnumerable.ToIterable(args),3));
                
                System.exit(exitCode);
                
                return;
            }
            else if (args.length == 4 && args[0].equals("/out:") && args[2].equals("/pattern:"))
            {
                Output output = Program.GetOutput(args[1]);

                String pattern = Program.FixPattern(args[3]);

                int exitCode = Program.ParseFilesByPattern(output, (output == Output.SingleFile ? args[1] : null), pattern, true);
                
                System.exit(exitCode);
                
                return;
            }
            else
            {
                Program.PrintArgumentErrorMessage();

                System.exit(1);
                
                return;
            }
        }
        catch (Exception ex)
        {
            Program.PrintExecutionErrorMessage(ex.getMessage());

            System.exit(1);
            
            return;
        }
    }

    // endregion

    // region OUTPUT METHODS:

    private static Output GetOutput(String text)
    {
        switch (text)
        {
            case "'?'":
                return Output.NoFile;
            case "'*'":
                return Output.MultiFile;
            default:
                return Output.SingleFile;
        }
    }

    // endregion

    // region PRINT METHODS:

    private static void PrintHeader()
    {
        DotNetConsole.WriteLine("%1$s (version %2$s)", Information.MatlabParser, Information.Version);

        DotNetConsole.WriteLine(Information.Copyright);

        DotNetConsole.WriteLine(Information.AllRightsReserved);
    }

    private static void PrintHelp()
    {
        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("- To display help, type:");

        DotNetConsole.WriteLine("  java -jar %1$s.jar /help", Information.MatlabParser);

        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("- To parse <file1> ... <fileN> and generate <file>, type:");

        DotNetConsole.WriteLine("  java -jar %1$s.jar /out: <file> /files: <file1> ... <fileN>", Information.MatlabParser);

        DotNetConsole.WriteLine("  Let <file> = '?' to generate no output file.");

        DotNetConsole.WriteLine("  Let <file> = '*' to generate an output file for each processed file.");

        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("- To parse files whose names match <pattern> in current directory (and subdirectories) and generate <file>, type:");

        DotNetConsole.WriteLine("  java -jar %1$s.jar /out: <file> /pattern: <pattern>", Information.MatlabParser);

        DotNetConsole.WriteLine("  (Make sure you escape wildcard character * and ? between single quotes in <pattern>.)");

        DotNetConsole.WriteLine("  Let <file> = '?' to generate no output file.");

        DotNetConsole.WriteLine("  Let <file> = '*' to generate an output file for each processed file.");
    }

    private static void PrintArgumentErrorMessage()
    {
        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("Argument error.");

        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("- To display help, type:");

        DotNetConsole.WriteLine("  %1$s /help", Information.MatlabParser);
    }

    private static void PrintExecutionErrorMessage(String message)
    {
        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("Execution error.");

        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine(message);
    }

    // endregion

    // region FIND METHODS:

    private static Iterable<String> FindPathsByPattern(String pattern, boolean recurse)
    {
        try
        {
            LinkedList<String> paths = new LinkedList<String>();

            int depth = (recurse ? Integer.MAX_VALUE : 1);

            String regex = Program.ConvertPatternToRegex(pattern);

            java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);

            Predicate<String> predicate = p.asPredicate();

            Files.walk(Paths.get(DotNetEnvironment.GetCurrentDirectory()), depth)
                    .filter(x -> predicate.test(x.getFileName().toString()))
                    .forEach(x -> paths.addLast(x.toString()));

            return paths;
        }
        catch(Exception ex)
        {
            throw new RuntimeException("CHECKED EXCEPTION", ex);
        }
    }

    // endregion

    // region PARSE METHODS:

    private static int ParseFilesByName(Output output, String outputName, Iterable<String> inputNames)
    {
        HashSet<String> inputNameSet = new HashSet<String>();

        LinkedList<String> inputPaths = new LinkedList<String>();

        for (String inputName : inputNames)
        {
            if (inputNameSet.add(inputName))
            {
                inputPaths.addLast(Paths.get(inputName).toAbsolutePath().toString());
            }
        }

        String outputPath = (outputName == null ? null : Paths.get(outputName).toAbsolutePath().toString());

        return Program.ParseFiles(output, outputPath, inputPaths);
    }

    private static int ParseFilesByPattern(Output output, String outputName, String pattern, boolean recurse)
    {
        Iterable<String> inputPaths = Program.FindPathsByPattern(pattern, recurse);

        String outputPath = (outputName == null ? null : Paths.get(outputName).toAbsolutePath().toString());

        return Program.ParseFiles(output, outputPath, inputPaths);
    }

    // endregion

    // region WORKER METHODS:

    private static int ParseFiles(Output output, String outputPath, Iterable<String> inputPaths)
    {
        DotNetConsole.WriteLine();

        DotNetConsole.WriteLine("Parsing...");

        int exitCode;

        if (output == Output.SingleFile || output == Output.NoFile)
        {
            exitCode = Program.ParseFilesToSingleOrNoFile(outputPath, inputPaths);
        }
        else
        {
            exitCode = Program.ParseFilesToMultipleFiles(inputPaths);
        }

        if (exitCode == 0)
        {
            DotNetConsole.WriteLine();

            DotNetConsole.WriteLine("Parsing completed successfully.");
        }
        else
        {
            DotNetConsole.WriteLine();

            DotNetConsole.WriteLine("Errors occurred during parsing.");
        }

        return exitCode;
    }

    private static int ParseFilesToSingleOrNoFile(String outputPath, Iterable<String> inputPaths)
    {
        boolean buildTree = (outputPath != null);

        Result<UnitNode> result = MRecognizer.RecognizeFiles(inputPaths, buildTree, new Notifier());

        if (result.GetReport().GetIsOk())
        {
            if (buildTree)
            {
                Program.SerializeTree(result.GetValue(), outputPath);
            }

            return 0;
        }
        else
        {
            return 1;
        }
    }

    private static int ParseFilesToMultipleFiles(Iterable<String> inputPaths)
    {
        boolean buildTree = true;

        boolean ok = true;

        for (String inputPath : inputPaths)
        {
            Result<UnitNode> result = MRecognizer.RecognizeFile(inputPath, buildTree, new Notifier());

            if (result.GetReport().GetIsOk())
            {
                if (buildTree)
                {
                    Program.SerializeTree(result.GetValue(), inputPath + ".xml");
                }
            }
            else
            {
                ok = false;
            }
        }

        return (ok ? 0 : 1);
    }

    private static void SerializeTree(UnitNode node, String filePath)
    {
        // NEW:

        CompilationUnits compilationUnits = NodeToAstTransformer.Transform(node);

        Document document = AstToXmlTransformer.Transform(compilationUnits);

        Program.Save(document, filePath);

        // OLD:

        //Document document = StandardNodeToXmlBuilder.Build(node);

        //Document document = NaiveNodeToXmlBuilder.Build(node);

        //Program.Save(document, filePath);
    }

    private static void Save(Document document, String path)
    {
        try
        {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new File(path));

            transformer.transform(source, result);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("CHECKED EXCEPTION", ex);
        }
    }

    // endregion

    // region PATTERN METHODS:

    private static String FixPattern(String pattern)
    {
        return pattern.replace("'*'", "*").replace("'?'", "?");
    }

    private static String ConvertPatternToRegex(String pattern) {
        if (pattern == null) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();

        char[] chars = pattern.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '*')
            {
                buffer.append(".*");
            }
            else if (chars[i] == '?')
            {
                buffer.append(".");
            }
            else if ("+()^$.{}[]|\\".indexOf(chars[i]) != -1)
            {
                buffer.append('\\').append(chars[i]); // prefix all metacharacters with backslash
            }
            else
            {
                buffer.append(chars[i]);
            }
        }

        String regex = buffer.toString();

        return ("^" + regex + "$");
    }

    // endregion

    // endregion
}