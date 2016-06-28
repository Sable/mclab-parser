package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class BinaryNode extends ExpressionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ExpressionNode GetLeftOperand()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    @Structure(Index = 1)
    public ExpressionNode GetRightOperand()
    {
        return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class),1));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected BinaryNode()
    {
        super();
    }

    // endregion
}
