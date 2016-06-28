package Matlab.Nodes;

import Matlab.DotNet.*;

public class AnonymousFunctionNode extends DelegateNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<InputNode> GetInputs()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), InputNode.class);
    }

    @Structure(Index = 1)
    public ExpressionNode GetExpression()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AnonymousFunctionNode()
    {
        super();
    }

    // endregion
}
