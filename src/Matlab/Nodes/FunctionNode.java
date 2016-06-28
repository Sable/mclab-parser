package Matlab.Nodes;

import Matlab.DotNet.*;

public class FunctionNode extends OuterNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

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

    @Structure(Index = 3)
    public Iterable<StatementNode> GetStatements()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), StatementNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public FunctionNode()
    {
        super();
    }

    // endregion
}
