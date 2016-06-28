package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class MethodNode extends MemberNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 1)
    public Iterable<InputNode> GetInputs()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), InputNode.class);
    }

    @Structure(Index = 2)
    public Iterable<OutputNode> GetOutputs()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), OutputNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected MethodNode()
    {
        super();
    }

    // endregion
}
