package Matlab.Nodes;

import Matlab.DotNet.*;

public class AtBaseNode extends ChainNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public ClassRefNode GetClass()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ClassRefNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AtBaseNode()
    {
        super();
    }

    // endregion
}

