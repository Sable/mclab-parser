package Matlab.Nodes;

import Matlab.DotNet.*;

public class TryPartNode extends PartNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<RegularStatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), RegularStatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public TryPartNode()
    {
        super();
    }

    // endregion
}
