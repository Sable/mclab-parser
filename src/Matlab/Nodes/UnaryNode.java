package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class UnaryNode extends ExpressionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ExpressionNode GetOperand()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected UnaryNode()
    {
        super();
    }

    // endregion
}
