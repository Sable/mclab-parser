package Matlab.Nodes;

import Matlab.DotNet.*;

public class CasePartNode extends PartNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ExpressionNode GetExpression()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    @Structure(Index = 1)
    public Iterable<RegularStatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), RegularStatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public CasePartNode()
    {
        super();
    }

    // endregion
}
