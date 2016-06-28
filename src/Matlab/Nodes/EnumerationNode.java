package Matlab.Nodes;

import Matlab.DotNet.*;

public class EnumerationNode extends MemberNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<ExpressionNode> GetArguments()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public EnumerationNode()
    {
        super();
    }

    // endregion
}