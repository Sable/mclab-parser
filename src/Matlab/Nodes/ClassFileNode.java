package Matlab.Nodes;

import Matlab.DotNet.*;

public class ClassFileNode extends FileNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ClassNode GetClass()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ClassNode.class));
    }

    @Structure(Index = 1)
    public Iterable<FunctionNode> GetFunctions()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), FunctionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public ClassFileNode()
    {
        super();
    }

    // endregion
}
