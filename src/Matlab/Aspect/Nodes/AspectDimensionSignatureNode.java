package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectDimensionSignatureNode extends AspectSignatureNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<NameNode> GetDimensions()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), NameNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectDimensionSignatureNode()
    {
        super();
    }

    // endregion
}
