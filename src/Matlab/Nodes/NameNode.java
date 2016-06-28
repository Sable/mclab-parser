package Matlab.Nodes;

import Matlab.DotNet.*;

public class NameNode extends UtilityNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<IdNode> GetIds()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), IdNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public NameNode()
    {
        super();
    }

    // endregion
}
