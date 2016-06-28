package Matlab.Nodes;

import Matlab.DotNet.*;

public class VarNode extends BasicNode implements ISimpleLValueNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public VarNode()
    {
        super();
    }

    // endregion
}
