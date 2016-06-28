package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectInputNode extends InnerNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<AspectFullSignatureNode> GetFullSignatures()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AspectFullSignatureNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectInputNode()
    {
        super();
    }

    // endregion
}
