package Matlab.Nodes;

import Matlab.DotNet.*;

public class MethodSectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<MethodNode> GetMethods()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), MethodNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public MethodSectionNode()
    {
        super();
    }

    // endregion
}