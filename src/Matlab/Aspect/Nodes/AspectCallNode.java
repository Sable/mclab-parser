package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectCallNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetIdentifier()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public AspectInputNode GetInput()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), AspectInputNode.class));
    }

    @Structure(Index = 2)
    public AspectOutputNode GetOutput()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), AspectOutputNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectCallNode()
    {
        super();
    }

    // endregion
}