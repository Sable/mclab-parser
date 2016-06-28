package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class ArrayNode extends AtomicNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public VCatNode GetContents()
    {
        VCatNode root = DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), VCatNode.class));

        return (DotNetEnumerable.Count(root.GetOperands()) != 0 ? root : null);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected ArrayNode()
    {
        super();
    }

    // endregion
}

