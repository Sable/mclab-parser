package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class RegularStatementNode extends StatementNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 100)
    public TerminatorNode GetTerminator()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), TerminatorNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected RegularStatementNode()
    {
        super();
    }

    // endregion
}
