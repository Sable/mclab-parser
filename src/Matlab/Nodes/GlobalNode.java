package Matlab.Nodes;

import Matlab.DotNet.*;

public class GlobalNode extends RegularStatementNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<VarNode> GetVars()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), VarNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public GlobalNode()
    {
        super();
    }

    // endregion
}