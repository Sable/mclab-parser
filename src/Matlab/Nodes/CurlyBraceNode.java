package Matlab.Nodes;

import Matlab.DotNet.*;

public class CurlyBraceNode extends ChainNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<ExpressionNode> GetArguments()
    {
        return DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class),1);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public CurlyBraceNode()
    {
        super();
    }

    // endregion
}
