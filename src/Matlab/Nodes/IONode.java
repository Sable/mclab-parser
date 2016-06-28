package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class IONode extends InnerNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public ClassRefNode GetClass()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), ClassRefNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected IONode()
    {
        super();
    }

    // endregion
}
