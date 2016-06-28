package Matlab.Nodes;

import Matlab.DotNet.*;

public class ScriptFileNode extends FileNode
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

    public ScriptFileNode()
    {
        super();
    }

    // endregion
}
