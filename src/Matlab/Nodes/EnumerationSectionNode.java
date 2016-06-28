package Matlab.Nodes;

import Matlab.DotNet.*;

public class EnumerationSectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<EnumerationNode> GetEnumerations()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), EnumerationNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public EnumerationSectionNode()
    {
        super();
    }

    // endregion
}