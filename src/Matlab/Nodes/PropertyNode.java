package Matlab.Nodes;

import Matlab.DotNet.*;

public class PropertyNode extends MemberNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public ClassRefNode GetClass()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), ClassRefNode.class));
    }

    @Structure(Index = 2)
    public ExpressionNode GetValue()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public PropertyNode()
    {
        super();
    }

    // endregion
}