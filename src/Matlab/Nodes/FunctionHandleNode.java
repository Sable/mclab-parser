package Matlab.Nodes;

import Matlab.DotNet.*;

public class FunctionHandleNode extends DelegateNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public FunctionRefNode GetFunction()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), FunctionRefNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public FunctionHandleNode()
    {
        super();
    }

    // endregion
}