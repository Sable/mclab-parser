package Matlab.Aspect.Nodes;

import Matlab.Nodes.*;
import Matlab.DotNet.*;

public class AspectOperatorNode extends AspectTargetNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetOperatorType()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public Iterable<AspectFullSignatureNode> GetOperandSignatures()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AspectFullSignatureNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public AspectOperatorNode()
    {
        super();
    }

    // endregion
}