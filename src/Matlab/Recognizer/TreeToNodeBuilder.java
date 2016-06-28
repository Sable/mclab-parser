package Matlab.Recognizer;

import Matlab.Aspect.Nodes.*;
import Matlab.Utils.*;
import Matlab.Nodes.*;
import org.antlr.runtime.tree.*;

class TreeToNodeBuilder
{
    // region STATIC METHODS:

    // region MAIN METHODS:

    public static FileNode Build(String path, Tree tree)
    {
        Checker.CheckNotNull(path);

        Checker.CheckNotNull(tree);

        FileNode node = (FileNode)TreeToNodeBuilder.BuildNode(tree);

        node.SetPath(path);

        return node;
    }

    // endregion

    // region BUILDER METHODS:

    private static MNode BuildNode(Tree tree)
    {
        MNode node = TreeToNodeBuilder.BuildNode(tree.getType());

        if (node instanceof InternalNode)
        {
            InternalNode internalNode = (InternalNode)node;

            internalNode.SetIndex((((CommonTree)tree).getToken() != null ? ((CommonTree)tree).getToken().getTokenIndex() : -1));

            internalNode.SetMinIndex(tree.getTokenStartIndex());

            internalNode.SetMaxIndex(tree.getTokenStopIndex());

            internalNode.SetLine(tree.getLine());

            internalNode.SetColumn(tree.getCharPositionInLine() + 1);

            internalNode.SetText(tree.getText());
        }

        for (int i = 0; i < tree.getChildCount(); i++)
        {
            MNode childNode = TreeToNodeBuilder.BuildNode(tree.getChild(i));

            node.GetChildren().Add(childNode);
        }

        return node;
    }

    private static MNode BuildNode(int type)
    {
        switch (type)
        {
            case MatlabParser.CLASSFILE:
                return new ClassFileNode();
            case MatlabParser.FUNCTIONFILE:
                return new FunctionFileNode();
            case MatlabParser.SCRIPTFILE:
                return new ScriptFileNode();
            case MatlabParser.FUNCTION:
                return new FunctionNode();
            case MatlabParser.CLASSDEF:
                return new ClassNode();
            case MatlabParser.EVENTSECTION:
                return new EventSectionNode();
            case MatlabParser.PROPERTYSECTION:
                return new PropertySectionNode();
            case MatlabParser.METHODSECTION:
                return new MethodSectionNode();
            case MatlabParser.ENUMERATIONSECTION:
                return new EnumerationSectionNode();
            case MatlabParser.EVENT:
                return new EventNode();
            case MatlabParser.PROPERTY:
                return new PropertyNode();
            case MatlabParser.REGULARMETHOD:
                return new RegularMethodNode();
            case MatlabParser.EXTERNALMETHOD:
                return new ExternalMethodNode();
            case MatlabParser.ENUMERATION:
                return new EnumerationNode();
            case MatlabParser.ATTRIBUTE:
                return new AttributeNode();
            case MatlabParser.ACTION:
                return new ActionNode();
            case MatlabParser.ASSIGN:
                return new AssignmentNode();
            case MatlabParser.EXCLAMATION:
                return new BangNode();
            case MatlabParser.BREAK:
                return new BreakNode();
            case MatlabParser.CONTINUE:
                return new ContinueNode();
            case MatlabParser.FOR:
                return new ForNode();
            case MatlabParser.GLOBAL:
                return new GlobalNode();
            case MatlabParser.IFELSE:
                return new IfNode();
            case MatlabParser.NESTEDFUNCTION:
                return new NestedFunctionNode();
            case MatlabParser.PARFOR:
                return new ParforNode();
            case MatlabParser.PERSISTENT:
                return new PersistentNode();
            case MatlabParser.RETURN:
                return new ReturnNode();
            case MatlabParser.SPMD:
                return new SpmdNode();
            case MatlabParser.SWITCHCASE:
                return new SwitchNode();
            case MatlabParser.TRYCATCH:
                return new TryNode();
            case MatlabParser.WHILE:
                return new WhileNode();
            case MatlabParser.IF:
                return new IfPartNode();
            case MatlabParser.ELSEIF:
                return new ElseIfPartNode();
            case MatlabParser.ELSE:
                return new ElsePartNode();
            case MatlabParser.SWITCH:
                return new SwitchPartNode();
            case MatlabParser.CASE:
                return new CasePartNode();
            case MatlabParser.OTHERWISE:
                return new OtherwisePartNode();
            case MatlabParser.TRY:
                return new TryPartNode();
            case MatlabParser.CATCH:
                return new CatchPartNode();
            case MatlabParser.COLON:
                return new ColonNode();
            case MatlabParser.HCAT:
                return new HCatNode();
            case MatlabParser.VCAT:
                return new VCatNode();
            case MatlabParser.PLUS:
                return new PlusNode();
            case MatlabParser.MINUS:
                return new MinusNode();
            case MatlabParser.TIMES:
                return new TimesNode();
            case MatlabParser.MTIMES:
                return new MTimesNode();
            case MatlabParser.LDIV:
                return new LDivNode();
            case MatlabParser.MLDIV:
                return new MLDivNode();
            case MatlabParser.RDIV:
                return new RDivNode();
            case MatlabParser.MRDIV:
                return new MRDivNode();
            case MatlabParser.POW:
                return new PowNode();
            case MatlabParser.MPOW:
                return new MPowNode();
            case MatlabParser.TRANS:
                return new TransNode();
            case MatlabParser.CTRANS:
                return new CTransNode();
            case MatlabParser.EQ:
                return new EqNode();
            case MatlabParser.NOTEQ:
                return new NotEqNode();
            case MatlabParser.LT:
                return new LtNode();
            case MatlabParser.LTEQ:
                return new LtEqNode();
            case MatlabParser.GT:
                return new GtNode();
            case MatlabParser.GTEQ:
                return new GtEqNode();
            case MatlabParser.AND:
                return new AndNode();
            case MatlabParser.SHORTAND:
                return new ShortAndNode();
            case MatlabParser.OR:
                return new OrNode();
            case MatlabParser.SHORTOR:
                return new ShortOrNode();
            case MatlabParser.POSITIVE:
                return new PositiveNode();
            case MatlabParser.NEGATIVE:
                return new NegativeNode();
            case MatlabParser.NOT:
                return new NotNode();
            case MatlabParser.ALL:
                return new AllNode();
            case MatlabParser.END:
                return new EndNode();
            case MatlabParser.IMAGINARY:
                return new ImaginaryNode();
            case MatlabParser.REAL:
                return new RealNode();
            case MatlabParser.STRING:
                return new StringNode();
            case MatlabParser.CELLARRAY:
                return new CellArrayNode();
            case MatlabParser.REGULARARRAY:
                return new RegularArrayNode();
            case MatlabParser.VAR:
                return new VarNode();
            case MatlabParser.DOTEXPRESSION:
                return new DotExpressionNode();
            case MatlabParser.DOTNAME:
                return new DotNameNode();
            case MatlabParser.PARENTHESIS:
                return new ParenthesisNode();
            case MatlabParser.CURLYBRACE:
                return new CurlyBraceNode();
            case MatlabParser.ATBASE:
                return new AtBaseNode();
            case MatlabParser.ANONYMOUSFUNCTION:
                return new AnonymousFunctionNode();
            case MatlabParser.FUNCTIONHANDLE:
                return new FunctionHandleNode();
            case MatlabParser.QUESTION:
                return new MetaclassNode();
            case MatlabParser.STORAGE:
                return new StorageNode();
            case MatlabParser.INPUT:
                return new InputNode();
            case MatlabParser.OUTPUT:
                return new OutputNode();
            case MatlabParser.PRINT:
                return new PrintNode();
            case MatlabParser.NOPRINT:
                return new NoPrintNode();
            case MatlabParser.CLASSREF:
                return new ClassRefNode();
            case MatlabParser.FUNCTIONREF:
                return new FunctionRefNode();
            case MatlabParser.ID:
                return new IdNode();
            case MatlabParser.NAME:
                return new NameNode();

            case MatlabParser.ASPECTFILE:
                return new AspectFileNode();
            case MatlabParser.ASPECTDEF:
                return new AspectNode();
            case MatlabParser.ASPECTACTIONSECTION:
                return new AspectActionSectionNode();
            case MatlabParser.ASPECTPATTERNSECTION:
                return new AspectPatternSectionNode();
            case MatlabParser.ASPECTACTION:
                return new AspectActionNode();
            case MatlabParser.ASPECTPATTERN:
                return new AspectPatternNode();
            case MatlabParser.ASPECTTYPESIGNATURE:
                return new AspectTypeSignatureNode();
            case MatlabParser.ASPECTDIMENSIONSIGNATURE:
                return new AspectDimensionSignatureNode();
            case MatlabParser.ASPECTFULLSIGNATURE:
                return new AspectFullSignatureNode();
            case MatlabParser.ASPECTNAME:
                return new AspectNameNode();
            case MatlabParser.ASPECTGET:
                return new AspectGetNode();
            case MatlabParser.ASPECTSET:
                return new AspectSetNode();
            case MatlabParser.ASPECTCALL:
                return new AspectCallNode();
            case MatlabParser.ASPECTEXECUTION:
                return new AspectExecutionNode();
            case MatlabParser.ASPECTMAINEXECUTION:
                return new AspectMainExecutionNode();
            case MatlabParser.ASPECTLOOP:
                return new AspectLoopNode();
            case MatlabParser.ASPECTLOOPBODY:
                return new AspectLoopBodyNode();
            case MatlabParser.ASPECTLOOPHEAD:
                return new AspectLoopHeadNode();
            case MatlabParser.ASPECTANNOTATE:
                return new AspectAnnotateNode();
            case MatlabParser.ASPECTOPERATOR:
                return new AspectOperatorNode();
            case MatlabParser.ASPECTWITHIN:
                return new AspectWithinNode();
            case MatlabParser.ASPECTDIMENSION:
                return new AspectDimensionNode();
            case MatlabParser.ASPECTISTYPE:
                return new AspectIsTypeNode();
            case MatlabParser.ASPECTINPUT:
                return new AspectInputNode();
            case MatlabParser.ASPECTOUTPUT:
                return new AspectOutputNode();
            case MatlabParser.ASPECTSELECTOR:
                return new AspectSelectorNode();

            default:
                throw new InternalException();
        }
    }

    // endregion

    // endregion
}
