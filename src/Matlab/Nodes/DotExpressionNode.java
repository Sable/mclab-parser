package Matlab.Nodes;

import Matlab.DotNet.*;

public class DotExpressionNode extends ChainNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public ExpressionNode GetExpression()
    {
        return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class),1));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public DotExpressionNode()
    {
        super();
    }

    // endregion
}
