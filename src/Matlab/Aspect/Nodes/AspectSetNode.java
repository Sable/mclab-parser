package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectSetNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetIdentifier()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public AspectFullSignatureNode GetFullSignature()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), AspectFullSignatureNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectSetNode()
    {
        super();
    }

    // endregion
}