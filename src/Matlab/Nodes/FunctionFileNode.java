package Matlab.Nodes;

import Matlab.DotNet.*;

public class FunctionFileNode extends FileNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<FunctionNode> GetFunctions()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), FunctionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public FunctionFileNode()
    {
        super();
    }

    // endregion
}