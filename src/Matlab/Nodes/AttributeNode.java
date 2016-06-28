package Matlab.Nodes;

import Matlab.DotNet.*;

public class AttributeNode extends OuterNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public ExpressionNode GetValue()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AttributeNode()
    {
        super();
    }

    // endregion
}
