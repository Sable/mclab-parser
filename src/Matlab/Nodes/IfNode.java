package Matlab.Nodes;

import Matlab.DotNet.*;

public class IfNode extends RegularStatementNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public IfPartNode GetIfPart()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), IfPartNode.class));
    }

    @Structure(Index = 1)
    public Iterable<ElseIfPartNode> GetElseIfParts()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), ElseIfPartNode.class);
    }

    @Structure(Index = 2)
    public ElsePartNode GetElsePart()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), ElsePartNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public IfNode()
    {
        super();
    }

    // endregion
}
