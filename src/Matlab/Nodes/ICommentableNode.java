package Matlab.Nodes;

public interface ICommentableNode extends IMNode
{
    Iterable<CommentNode> GetComments();
}