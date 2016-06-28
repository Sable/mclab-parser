package Matlab.Nodes;

import Matlab.DotNet.*;

public class SwitchNode extends RegularStatementNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public SwitchPartNode GetSwitchPart()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), SwitchPartNode.class));
    }

    @Structure(Index = 1)
    public Iterable<CasePartNode> GetCaseParts()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), CasePartNode.class);
    }

    @Structure(Index = 2)
    public OtherwisePartNode GetOtherwisePart()
    {
        return DotNetEnumerable.FirstOrDefault(DotNetEnumerable.OfType(this.GetChildren(), OtherwisePartNode.class));
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public SwitchNode()
    {
        super();
    }

    // endregion
}
