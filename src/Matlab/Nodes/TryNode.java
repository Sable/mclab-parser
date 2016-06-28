package Matlab.Nodes;

import Matlab.DotNet.*;

public class TryNode extends RegularStatementNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public TryPartNode GetTryPart()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), TryPartNode.class));
    }

    @Structure(Index = 1)
    public CatchPartNode GetCatchPart()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), CatchPartNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public TryNode()
    {
        super();
    }

    // endregion
}
