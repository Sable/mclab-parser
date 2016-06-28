package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectActionSectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<AspectActionNode> GetAspectActions()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AspectActionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectActionSectionNode()
    {
        super();
    }
}
