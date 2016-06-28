package Matlab.Nodes;

import Matlab.DotNet.*;

public class ParforNode extends RegularStatementNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public VarNode GetVar()
    {
        return (VarNode)DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    @Structure(Index = 1)
    public ExpressionNode GetRange()
    {
        return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class),1));
    }

    @Structure(Index = 2)
    public ExpressionNode GetWorkers()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class),2));
    }

    @Structure(Index = 3)
    public Iterable<RegularStatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), RegularStatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public ParforNode()
    {
        super();
    }

    // endregion
}
