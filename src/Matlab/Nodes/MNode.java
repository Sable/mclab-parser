package Matlab.Nodes;

import Matlab.DotNet.*;
import Matlab.Utils.*;

public abstract class MNode extends Node implements IMNode
{
    // region PROPERTIES:

    // region COMMENT PROPERTIES:

    @Structure(Index = -100)
    public Iterable<CommentNode> GetComments()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), CommentNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected MNode()
    {
        super();
    }

    // endregion
}
