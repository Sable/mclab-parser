package Matlab.Nodes;

import Matlab.DotNet.*;

public class PersistentNode extends RegularStatementNode
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

    public PersistentNode()
    {
        super();
    }

    // endregion
}
