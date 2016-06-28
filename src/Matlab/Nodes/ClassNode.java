package Matlab.Nodes;

import Matlab.DotNet.*;

public class ClassNode extends OuterNode implements ICommentableNode
{
    // region PROPERTIES:

    // region STRUCTURE PROPERTIES:

    @Structure(Index = 0)
    public NameNode GetName()
    {
        return DotNetEnumerable.First(DotNetEnumerable.OfType(this.GetChildren(), NameNode.class));
    }

    @Structure(Index = 1)
    public Iterable<ClassRefNode> GetBaseClasses()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), ClassRefNode.class);
    }

    @Structure(Index = 2)
    public Iterable<AttributeNode> GetAttributes()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), AttributeNode.class);
    }

    @Structure(Index = 3)
    public Iterable<SectionNode> GetSections()
    {
        return DotNetEnumerable.OfType(this.GetChildren(), SectionNode.class);
    }

    // endregion

    // endregion

    // region CONSTRUCTORS:

    public ClassNode()
    {
        super();
    }

    // endregion
}