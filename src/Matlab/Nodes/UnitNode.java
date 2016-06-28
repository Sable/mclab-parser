package Matlab.Nodes;

import Matlab.DotNet.*;

public class UnitNode extends ExternalNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<FileNode> GetFiles()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), FileNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public UnitNode()
    {
        super();
    }

    // endregion
}