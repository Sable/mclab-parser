package Matlab.Aspect.Nodes;

import Matlab.DotNet.*;
import Matlab.Nodes.*;

public class AspectNode extends OuterNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public Iterable<SectionNode> GetSections()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), SectionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectNode()
    {
        super();
    }

    // endregion
}
