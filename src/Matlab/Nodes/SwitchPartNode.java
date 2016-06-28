package Matlab.Nodes;

import Matlab.DotNet.*;

public class SwitchPartNode extends PartNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ExpressionNode GetExpression()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public SwitchPartNode()
    {
        super();
    }

    // endregion
}
