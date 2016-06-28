package Matlab.Nodes;

import Matlab.DotNet.*;

public class DotNameNode extends ChainNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public DotNameNode()
    {
        super();
    }

    // endregion
}
