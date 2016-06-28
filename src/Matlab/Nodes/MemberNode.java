package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class MemberNode extends OuterNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected MemberNode()
    {
        super();
    }

    // endregion
}
