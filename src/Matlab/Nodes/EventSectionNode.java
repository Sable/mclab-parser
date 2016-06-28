package Matlab.Nodes;

import Matlab.DotNet.*;

public class EventSectionNode extends SectionNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<EventNode> GetEvents()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), EventNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public EventSectionNode()
    {
        super();
    }

    // endregion
}