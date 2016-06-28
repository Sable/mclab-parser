package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectAnnotateNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetIdentifier()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public Iterable<AspectSelectorNode> GetSelectors()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AspectSelectorNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectAnnotateNode()
    {
        super();
    }

    // endregion
}