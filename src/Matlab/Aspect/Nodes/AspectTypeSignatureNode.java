package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectTypeSignatureNode extends AspectSignatureNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetType()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectTypeSignatureNode()
    {
        super();
    }

    // endregion
}
