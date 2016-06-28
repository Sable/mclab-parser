package Matlab.Nodes;

import Matlab.DotNet.*;

public class AssignmentNode extends RegularStatementNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ILValueNode GetLValue()
    {
        return (ILValueNode)DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    @Structure(Index = 1)
    public ExpressionNode GetValue()
    {
        return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class), 1));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AssignmentNode()
    {
        super();
    }

    // endregion
}

