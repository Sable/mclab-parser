package Matlab.Recognizer;

import org.antlr.runtime.*;
import Matlab.DotNet.*;
import Matlab.Utils.*;
import Matlab.Nodes.*;

class NodeCommenter
{
    // region STATIC METHODS:

    // region MAIN METHODS:

    public static void InsertComments(FileNode node, TokenStream tokens)
    {
        for (int i = 0; i < tokens.size(); i++)
        {
            Token token = tokens.get(i);

            if (token.getType() == MatlabLexer.LINECOMMENT || token.getType() == MatlabLexer.BLOCKCOMMENT)
            {
                CommentNode commentNode = NodeCommenter.BuildCommentNode(token);

                NodeCommenter.InsertCommentNode(node, commentNode);
            }
        }
    }

    // endregion

    // region TEXT METHODS:

    private static String RemoveWeirdCharacters(String input)
    {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<input.length(); i++)
        {
            char character = input.charAt(i);

            if (!Character.isISOControl(character))
            {
                builder.append(character);
            }
        }

        return builder.toString();
    }

    // endregion

    // region BUILD METHODS:

    private static CommentNode BuildCommentNode(Token token)
    {
        CommentNode commentNode = new CommentNode();

        commentNode.SetLine(token.getLine());

        commentNode.SetColumn(token.getCharPositionInLine() + 1);

        commentNode.SetText(NodeCommenter.RemoveWeirdCharacters(token.getText()));

        commentNode.SetIndex(token.getTokenIndex());

        commentNode.SetMinIndex(token.getTokenIndex());

        commentNode.SetMaxIndex(token.getTokenIndex());

        return commentNode;
    }

    // endregion

    // region INSERT METHODS:

    private static void InsertCommentNode(FileNode node, CommentNode commentNode)
    {
        MNode parent = NodeCommenter.FindClosestParent(node, commentNode);

        ICommentableNode commentableNode = NodeCommenter.FindClosestCommentableAncestorOrSelf(parent);

        NodeCommenter.LocalInsertCommentNode(commentableNode, commentNode);
    }

    private static void LocalInsertCommentNode(ICommentableNode containerNode, CommentNode commentNode)
    {
        NodeCollection nodeCollection = (NodeCollection)containerNode.GetChildren();

        for (int i = 0; i < nodeCollection.GetCount(); i++)
        {
            if (((InternalNode)nodeCollection.GetIndex(i)).GetMaxIndex() > commentNode.GetIndex())
            {
                nodeCollection.Insert(i, commentNode);

                return;
            }
        }

        nodeCollection.Add(commentNode);
    }

    // endregion

    // region FIND METHODS:

    private static MNode FindClosestParent(MNode container, CommentNode commentNode)
    {
        Iterable<InternalNode> toLeft = DotNetEnumerable.Where(DotNetEnumerable.Cast(container.GetChildren(), InternalNode.class), x -> x.GetMinIndex() < commentNode.GetIndex());

        if (DotNetEnumerable.Count(toLeft) == 0)
        {
            return container;
        }
        else
        {
            int maxIndex = DotNetEnumerable.Max(DotNetEnumerable.Select(toLeft, x -> new Integer(x.GetMaxIndex())));

            InternalNode node = DotNetEnumerable.Single(DotNetEnumerable.Where(toLeft, x -> x.GetMaxIndex() == maxIndex));

            if (commentNode.GetIndex() < node.GetMaxIndex())
            {
                return NodeCommenter.FindClosestParent(node, commentNode);
            }
            else
            {
                return container;
            }
        }
    }

    private static ICommentableNode FindClosestCommentableAncestorOrSelf(MNode node)
    {
        while (node != null && !(node instanceof ICommentableNode))
        {
            node = (MNode)node.GetParent();
        }

        return (ICommentableNode)node;
    }

    // endregion

    // endregion
}