package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectSelectorNode extends InnerNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<NameNode> GetElements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), NameNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectSelectorNode()
    {
        super();
    }

    // endregion
}
