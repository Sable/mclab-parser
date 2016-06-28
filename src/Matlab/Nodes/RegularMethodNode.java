package Matlab.Nodes;

import Matlab.DotNet.*;

public class RegularMethodNode extends MethodNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 3)
    public Iterable<StatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), StatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public RegularMethodNode()
    {
        super();
    }

    // endregion
}
