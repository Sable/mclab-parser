package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectPatternSectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<AspectPatternNode> GetAspectPatterns()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AspectPatternNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectPatternSectionNode()
    {
        super();
    }

    // endregion
}
