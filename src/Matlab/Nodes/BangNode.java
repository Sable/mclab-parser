package Matlab.Nodes;

import Matlab.DotNet.*;

public class BangNode extends RegularStatementNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public StringNode GetString()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), StringNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public BangNode()
    {
        super();
    }

    // endregion
}

