package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectLoopNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetLoopType()
    {
        if(DotNetEnumerable.Count(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class)) == 1)
        {
            return null;
        }
        else
        {
            return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
        }
    }

    @Structure(Index = 1)
    public NameNode GetIdentifier()
    {
        if(DotNetEnumerable.Count(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class)) == 1)
        {
            return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
        }
        else
        {
            return DotNetEnumerable.First(DotNetEnumerable.Skip(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class),1));
        }
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectLoopNode()
    {
        super();
    }

    // endregion
}