package Matlab.Nodes;

import Matlab.DotNet.*;

public abstract class ChainNode extends AtomicNode implements ISimpleLValueNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public ISimpleLValueNode GetOperand()
    {
        return (ISimpleLValueNode)DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), ExpressionNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    protected ChainNode()
    {
        super();
    }

    // endregion
}
