package Matlab.Nodes;

import Matlab.DotNet.*;

public class CatchPartNode extends PartNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public VarNode GetVar()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), VarNode.class));
    }

    @Structure(Index = 1)
    public Iterable<RegularStatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), RegularStatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public CatchPartNode()
    {
        super();
    }

    // endregion
}
