package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectFullSignatureNode extends AspectSignatureNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public AspectTypeSignatureNode GetTypeSignature()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), AspectTypeSignatureNode.class));
    }

    @Structure(Index = 1)
    public AspectDimensionSignatureNode GetDimensionSignature()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), AspectDimensionSignatureNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectFullSignatureNode()
    {
        super();
    }

    // endregion
}
