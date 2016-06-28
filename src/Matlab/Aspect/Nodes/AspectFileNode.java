package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectFileNode extends FileNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public AspectNode GetAspect()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), AspectNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectFileNode()
    {
        super();
    }

    // endregion
}
