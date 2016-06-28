package Matlab.Nodes;

import Matlab.DotNet.*;

public class VCatNode extends NaryNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<HCatNode> GetOperands()
    {
        return DotNetEnumerable.Where(DotNetEnumerable.OfType(this.GetChildren(), HCatNode.class), x -> DotNetEnumerable.Count(x.GetOperands()) != 0);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public VCatNode()
    {
        super();
    }

    // endregion
}
