package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectActionNode extends OuterNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetActionName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public NameNode GetActionType()
    {
        return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class),1));
    }

    @Structure(Index = 2)
    public ExpressionNode GetAspectExpression()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    @Structure(Index = 3)
    public Iterable<InputNode> GetInputs()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), InputNode.class);
    }

    @Structure(Index = 4)
    public Iterable<StatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), StatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectActionNode()
    {
        super();
    }

    // endregion
}
