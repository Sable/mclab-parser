package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectSelectorCompoundNode extends AspectSelectorNode
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

    public AspectSelectorCompoundNode()
    {
        super();
    }

    // endregion
}
