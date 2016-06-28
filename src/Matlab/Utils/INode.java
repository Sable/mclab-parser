package Matlab.Utils;

public interface INode
{
    // region PROPERTIES:

    INode GetParent();

    Iterable<? extends INode> GetChildren();

    boolean GetIsRoot();

    boolean GetIsLeaf();

    // endregion
}