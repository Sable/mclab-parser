package Matlab.Nodes;

import Matlab.DotNet.*;

public class MetaclassNode extends AtomicNode implements ISimpleLValueNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ClassRefNode GetClass()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ClassRefNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public MetaclassNode()
    {
        super();
    }

    // endregion
}
