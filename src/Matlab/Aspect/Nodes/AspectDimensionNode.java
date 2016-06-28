package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectDimensionNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public AspectDimensionSignatureNode GetDimension()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), AspectDimensionSignatureNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectDimensionNode()
    {
        super();
    }

    // endregion
}