package Matlab.Nodes;

import Matlab.DotNet.*;

public class ColonNode extends NaryNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<ExpressionNode> GetOperands()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public ColonNode()
    {
        super();
    }

    // endregion
}
