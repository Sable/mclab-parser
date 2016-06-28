package Matlab.Nodes;

import Matlab.DotNet.*;

public class PropertySectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<PropertyNode> GetProperties()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), PropertyNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public PropertySectionNode()
    {
        super();
    }

    // endregion
}
