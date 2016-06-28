package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class SectionNode extends OuterNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<AttributeNode> GetAttributes()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AttributeNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected SectionNode()
    {
        super();
    }

    // endregion
}