package Matlab.Nodes;

import Matlab.DotNet.*;

public class StorageNode extends AtomicNode implements ICompoundLValueNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public Iterable<ISimpleLValueNode> GetLValues()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), ISimpleLValueNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public StorageNode()
    {
        super();
    }

    // endregion
}
