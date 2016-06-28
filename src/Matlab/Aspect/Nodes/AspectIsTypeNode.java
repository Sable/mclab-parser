package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectIsTypeNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public AspectTypeSignatureNode GetTypeSignature()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), AspectTypeSignatureNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectIsTypeNode()
    {
        super();
    }

    // endregion
}