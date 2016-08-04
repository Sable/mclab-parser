package Matlab.Transformer;

import ast.*;
import ast.Properties;
import ast.Enumeration;
import natlab.*;
import natlab.toolkits.filehandling.*;

import Matlab.Utils.*;
import Matlab.Nodes.*;
import Matlab.DotNet.*;
import Matlab.Aspect.Nodes.*;

import java.util.*;
import java.lang.reflect.*;

public class NodeToAstTransformer
{
    // region STATIC METHODS:

    // region MAIN METHODS:

    public static CompilationUnits Transform(UnitNode node)
    {
        return (CompilationUnits)NodeToAstTransformer.Process(node);
    }

    // endregion

    // region PROCESS METHODS:

    private static Object Process(IMNode node)
    {
        return NodeToAstTransformer.Process(node, "Visit");
    }

    private static Object Process(IMNode node, String methodName)
    {
        try
        {
            Method method = NodeToAstTransformer.class.getDeclaredMethod(methodName, node.getClass());

            method.setAccessible(true);

            Object object = method.invoke(null, node);

            if (object instanceof ASTNode && node instanceof InternalNode)
            {
                NodeToAstTransformer.CopyLineAndColumnFields((InternalNode)node, (ASTNode)object);
            }

            if (object instanceof ASTNode && node instanceof ICommentableNode)
            {
                NodeToAstTransformer.CopyCommentNodes((ICommentableNode)node, (ASTNode)object);
            }

            if (object instanceof ASTNode)
            {
                NodeToAstTransformer.CopyRelativeChildIndexField(node, (ASTNode)object);
            }

            return object;
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    // endregion

    // region WORKER METHODS:

    // region EXTERNAL NODES:
    
    private static CompilationUnits Visit(UnitNode node)
    {
        CompilationUnits returnAst = new CompilationUnits();

        for(FileNode fileNode : node.GetFiles())
        {
            Object object = NodeToAstTransformer.Process(fileNode);

            if (object instanceof Program)
            {
                returnAst.addProgram((Program)object);
            }
            else if (object instanceof Iterable<?>)
            {
                for(Program program : (Iterable<Program>)object)
                {
                    returnAst.addProgram(program);
                }
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static Iterable<Program> Visit(ClassFileNode node)
    {
        ClassNode classNode = node.GetClass();

        ClassDef classDef = (ClassDef)NodeToAstTransformer.Process(classNode);

        NodeToAstTransformer.CopyRelativeChildIndexField(node, classDef);

        classDef.setFile(new FileFile(node.GetPath()));

        LinkedList<Function> functionLinkedList = new LinkedList<Function>();

        for (FunctionNode functionNode : node.GetFunctions())
        {
            Function function = (Function)NodeToAstTransformer.Process(functionNode);

            functionLinkedList.add(function);
        }

        FunctionList functionList = new FunctionList();

        NodeToAstTransformer.CopyRelativeChildIndexField(node, functionList);

        functionList.setFile(new FileFile(node.GetPath()));

        for(Function function: functionLinkedList)
        {
            functionList.addFunction(function);
        }

        LinkedList<Program> returnAst = new LinkedList<Program>();

        returnAst.add(classDef);

        returnAst.add(functionList);

        return returnAst;
    }

    private static FunctionList Visit(FunctionFileNode node)
    {
        FunctionList returnAst = new FunctionList();

        returnAst.setFile(new FileFile(node.GetPath()));

        for(FunctionNode functionNode : node.GetFunctions())
        {
            Function function = (Function)NodeToAstTransformer.Process(functionNode);

            returnAst.addFunction(function);
        }

        return returnAst;
    }

    private static Script Visit(ScriptFileNode node)
    {
        Script returnAst = new Script();

        returnAst.setFile(new FileFile(node.GetPath()));

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    // endregion

    // region INTERNAL NODES:

    // region OUTER NODES:

    private static Function Visit(FunctionNode node)
    {
        Function returnAst = new Function();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(functionName);

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Object object = NodeToAstTransformer.Process(statementNode);

            if (object instanceof Stmt)
            {
                returnAst.addStmt((Stmt)object);
            }
            else if (object instanceof Function)
            {
                returnAst.addNestedFunction((Function)object);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static ClassDef Visit(ClassNode node)
    {
        ClassDef returnAst = new ClassDef();

        for(AttributeNode attributeNode : node.GetAttributes())
        {
            Attribute attribute = (Attribute)NodeToAstTransformer.Process(attributeNode);

            returnAst.addAttribute(attribute);
        }

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name.getID());

        for (ClassRefNode classRefNode : node.GetBaseClasses())
        {
            Name name2 = (Name)NodeToAstTransformer.Process(classRefNode.GetName());

            SuperClass superClass = new SuperClass();

            superClass.setName(name2.getID());

            returnAst.addSuperClass(superClass);

            NodeToAstTransformer.CopyRelativeChildIndexField(classRefNode, superClass);
        }

        for (SectionNode sectionNode : node.GetSections())
        {
            if (sectionNode instanceof PropertySectionNode)
            {
                Properties properties = (Properties)NodeToAstTransformer.Process(sectionNode);

                returnAst.addProperty(properties);
            }
            else if (sectionNode instanceof MethodSectionNode)
            {
                Methods methods = (Methods)NodeToAstTransformer.Process(sectionNode);

                returnAst.addMethod(methods);
            }
            else if (sectionNode instanceof EventSectionNode)
            {
                ClassEvents events = (ClassEvents)NodeToAstTransformer.Process(sectionNode);

                returnAst.addClassEvent(events);
            }
            else if (sectionNode instanceof EnumerationSectionNode)
            {
                Enumerations enumerations = (Enumerations)NodeToAstTransformer.Process(sectionNode);

                returnAst.addEnumeration(enumerations);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static ClassEvents Visit(EventSectionNode node)
    {
        ClassEvents returnAst = new ClassEvents();

        for(AttributeNode attributeNode : node.GetAttributes())
        {
            Attribute attribute = (Attribute)NodeToAstTransformer.Process(attributeNode);

            returnAst.addAttribute(attribute);
        }

        for(EventNode eventNode : node.GetEvents())
        {
            Event event = (Event)NodeToAstTransformer.Process(eventNode);

            returnAst.addEvent(event);
        }

        return returnAst;
    }

    private static Properties Visit(PropertySectionNode node)
    {
        Properties returnAst = new Properties();

        for(AttributeNode attributeNode : node.GetAttributes())
        {
            Attribute attribute = (Attribute)NodeToAstTransformer.Process(attributeNode);

            returnAst.addAttribute(attribute);
        }

        for(PropertyNode propertyNode : node.GetProperties())
        {
            Property property = (Property)NodeToAstTransformer.Process(propertyNode);

            returnAst.addProperty(property);
        }

        return returnAst;
    }

    private static Methods Visit(MethodSectionNode node)
    {
        Methods returnAst = new Methods();

        for (AttributeNode attributeNode : node.GetAttributes())
        {
            Attribute attribute = (Attribute)NodeToAstTransformer.Process(attributeNode);

            returnAst.addAttribute(attribute);
        }

        for (MethodNode methodNode : node.GetMethods())
        {
            boolean isPropertyAccess = (DotNetEnumerable.Count(methodNode.GetName().GetIds()) > 1);

            if (methodNode instanceof RegularMethodNode)
            {
                if (isPropertyAccess)
                {
                    PropertyAccess propertyAccess = (PropertyAccess)NodeToAstTransformer.Process(methodNode, "VisitDirect");

                    returnAst.addPropAcc(propertyAccess);
                }
                else
                {
                    Function function = (Function)NodeToAstTransformer.Process(methodNode);

                    returnAst.addFunction(function);
                }
            }
            else if (methodNode instanceof ExternalMethodNode)
            {
                if (isPropertyAccess)
                {
                    PropertyAccessSignature propertyAccessSignature = (PropertyAccessSignature)NodeToAstTransformer.Process(methodNode, "VisitDirect");

                    returnAst.addPropAccSig(propertyAccessSignature);
                }
                else
                {
                    Signature signature = (Signature)NodeToAstTransformer.Process(methodNode);

                    returnAst.addSignature(signature);
                }
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static Enumerations Visit(EnumerationSectionNode node)
    {
        Enumerations returnAst = new Enumerations();

        for (AttributeNode attributeNode : node.GetAttributes())
        {
            Attribute attribute = (Attribute) NodeToAstTransformer.Process(attributeNode);

            returnAst.addAttribute(attribute);
        }

        for (EnumerationNode enumerationNode : node.GetEnumerations())
        {
            Enumeration enumeration = (Enumeration)NodeToAstTransformer.Process(enumerationNode);

            returnAst.addEnumeration(enumeration);
        }

        return returnAst;
    }

    private static Event Visit(EventNode node)
    {
        Event returnAst = new Event();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name.getID());

        return returnAst;
    }

    private static Property Visit(PropertyNode node)
    {
        Property returnAst = new Property();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name.getID());

        if (node.GetValue() != null)
        {
            Expr expr = (Expr) NodeToAstTransformer.Process(node.GetValue());

            returnAst.setExpr(expr);
        }
        else
        {
            // This is for backwards compatibility with McLab's AST:

            ParameterizedExpr expr = new ParameterizedExpr();

            NameExpr nameExpr = new NameExpr();

            Name name2 = new Name();

            name2.setID("$_GET_NO_EXPRESSION");

            nameExpr.setName(name2);

            expr.setTarget(nameExpr);

            returnAst.setExpr(expr);
        }

        return returnAst;
    }

    private static Function Visit(RegularMethodNode node)
    {
        Function returnAst = new Function();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(functionName);

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Object object = NodeToAstTransformer.Process(statementNode);

            if (object instanceof Stmt)
            {
                returnAst.addStmt((Stmt)object);
            }
            else if (object instanceof Function)
            {
                returnAst.addNestedFunction((Function)object);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static Signature Visit(ExternalMethodNode node)
    {
        Signature returnAst = new Signature();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(functionName.getID());

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        return returnAst;
    }

    private static PropertyAccess VisitDirect(RegularMethodNode node)
    {
        PropertyAccess returnAst = new PropertyAccess();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        String fullName = functionName.getID();

        int index = fullName.indexOf(".");

        returnAst.setAccess(fullName.substring(0, index));

        returnAst.setName(fullName.substring(index + 1));

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Object object = NodeToAstTransformer.Process(statementNode);

            if (object instanceof Stmt)
            {
                returnAst.addStmt((Stmt)object);
            }
            else if (object instanceof Function)
            {
                returnAst.addNestedFunction((Function)object);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static PropertyAccessSignature VisitDirect(ExternalMethodNode node)
    {
        PropertyAccessSignature returnAst = new PropertyAccessSignature();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        String fullName = functionName.getID();

        int index = fullName.indexOf(".");

        returnAst.setAccess(fullName.substring(0, index));

        returnAst.setName(fullName.substring(index + 1));

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        return returnAst;
    }

    private static Enumeration Visit(EnumerationNode node)
    {
        Enumeration returnAst = new Enumeration();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name.getID());

        for (ExpressionNode expressionNode : node.GetArguments())
        {
            Expr expr = (Expr)NodeToAstTransformer.Process(expressionNode);

            returnAst.addExpr(expr);
        }

        return returnAst;
    }

    private static Attribute Visit(AttributeNode node)
    {
        Attribute returnAst = new Attribute();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetValue());

        returnAst.setKey(name.getID());

        returnAst.setExpr(expr);

        return returnAst;
    }

    // endregion

    // region INNER NODES:

    // region STATEMENT NODES:

    private static ExprStmt Visit(ActionNode node)
    {
        ExprStmt returnAst = new ExprStmt();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setExpr(expr);

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static AssignStmt Visit(AssignmentNode node)
    {
        AssignStmt returnAst = new AssignStmt();

        Expr lhs = (Expr)NodeToAstTransformer.Process(node.GetLValue());

        Expr rhs = (Expr)NodeToAstTransformer.Process(node.GetValue());

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setLHS(lhs);

        returnAst.setRHS(rhs);

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static ShellCommandStmt Visit(BangNode node)
    {
        ShellCommandStmt returnAst = new ShellCommandStmt();

        StringLiteralExpr stringLiteral = (StringLiteralExpr)NodeToAstTransformer.Process(node.GetString());

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setCommand(stringLiteral.getValue());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static BreakStmt Visit(BreakNode node)
    {
        BreakStmt returnAst = new BreakStmt();

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static ContinueStmt Visit(ContinueNode node)
    {
        ContinueStmt returnAst = new ContinueStmt();

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static ForStmt Visit(ForNode node)
    {
        ForStmt returnAst = new ForStmt();

        NameExpr nameExpr = (NameExpr)NodeToAstTransformer.Process(node.GetVar());

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetRange());

        AssignStmt assignStmt = new AssignStmt();

        assignStmt.setLHS(nameExpr);

        assignStmt.setRHS(expr);

        assignStmt.setOutputSuppressed(true);

        returnAst.setAssignStmt(assignStmt);

        NodeToAstTransformer.CopyRelativeChildIndexField(node.GetVar(), assignStmt);

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        returnAst.setisParfor(false);

        return returnAst;
    }

    private static GlobalStmt Visit(GlobalNode node)
    {
        GlobalStmt returnAst = new GlobalStmt();

        for(VarNode varNode : node.GetVars())
        {
            NameExpr nameExpr = (NameExpr)NodeToAstTransformer.Process(varNode);

            returnAst.addName(nameExpr.getName());
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static IfStmt Visit(IfNode node)
    {
        IfStmt returnAst = new IfStmt();

        IfBlock ifBlock = (IfBlock) NodeToAstTransformer.Process(node.GetIfPart());
        
        returnAst.addIfBlock(ifBlock);
        
        for (ElseIfPartNode elseIfPartNode : node.GetElseIfParts())
        {
            IfBlock ifBlock2 = (IfBlock)NodeToAstTransformer.Process(elseIfPartNode);
            
            returnAst.addIfBlock(ifBlock2);
        }
        
        if (node.GetElsePart() != null)
        {
            ElseBlock elseBlock = (ElseBlock)NodeToAstTransformer.Process(node.GetElsePart());

            returnAst.setElseBlock(elseBlock);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);
        
        return returnAst;
    }
    
    private static Function Visit(NestedFunctionNode node)
    {
        Function returnAst = new Function();

        for(OutputNode outputNode : node.GetOutputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(outputNode);

            returnAst.addOutputParam(name);
        }

        Name functionName = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(functionName);

        for (InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Object object = NodeToAstTransformer.Process(statementNode);

            if (object instanceof Stmt)
            {
                returnAst.addStmt((Stmt)object);
            }
            else if (object instanceof Function)
            {
                returnAst.addNestedFunction((Function)object);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static ForStmt Visit(ParforNode node)
    {
        ForStmt returnAst = new ForStmt();

        NameExpr nameExpr = (NameExpr)NodeToAstTransformer.Process(node.GetVar());

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetRange());

        AssignStmt assignStmt = new AssignStmt();

        assignStmt.setLHS(nameExpr);

        assignStmt.setRHS(expr);

        assignStmt.setOutputSuppressed(true);

        returnAst.setAssignStmt(assignStmt);

        if (node.GetWorkers() != null)
        {
            Expr expr2 = (Expr)NodeToAstTransformer.Process(node.GetWorkers());

            returnAst.setWorker(expr2);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        returnAst.setisParfor(true);

        return returnAst;
    }

    private static PersistentStmt Visit(PersistentNode node)
    {
        PersistentStmt returnAst = new PersistentStmt();

        for(VarNode varNode : node.GetVars())
        {
            NameExpr nameExpr = (NameExpr)NodeToAstTransformer.Process(varNode);

            returnAst.addName(nameExpr.getName());
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static ReturnStmt Visit(ReturnNode node)
    {
        ReturnStmt returnAst = new ReturnStmt();

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static SpmdStmt Visit(SpmdNode node)
    {
        // The SpmdStmt node is new, but McLab is not prepared to do analyses on
        // programs that contain such a node, so we're emitting a warning here

        System.err.println("Warning: File contains an spmd statement!");

        SpmdStmt returnAst = new SpmdStmt();

        if (node.GetMinWorkers() != null)
        {
            Expr expr = (Expr)NodeToAstTransformer.Process(node.GetMinWorkers());

            returnAst.setMinWorker(expr);
        }

        if (node.GetMaxWorkers() != null)
        {
            Expr expr = (Expr)NodeToAstTransformer.Process(node.GetMaxWorkers());

            returnAst.setMaxWorker(expr);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static SwitchStmt Visit(SwitchNode node)
    {
        SwitchStmt returnAst = new SwitchStmt();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetSwitchPart());

        returnAst.setExpr(expr);

        for (CasePartNode casePartNode : node.GetCaseParts())
        {
            SwitchCaseBlock switchCaseBlock = (SwitchCaseBlock)NodeToAstTransformer.Process(casePartNode);

            returnAst.addSwitchCaseBlock(switchCaseBlock);
        }

        if (node.GetOtherwisePart() != null)
        {
            DefaultCaseBlock defaultCaseBlock = (DefaultCaseBlock)NodeToAstTransformer.Process(node.GetOtherwisePart());

            returnAst.setDefaultCaseBlock(defaultCaseBlock);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static TryStmt Visit(TryNode node)
    {
        TryStmt returnAst = new TryStmt();

        LinkedList<Stmt> tryStatements = (LinkedList<Stmt>)NodeToAstTransformer.Process(node.GetTryPart());

        for (Stmt stmt : tryStatements)
        {
            returnAst.addTryStmt(stmt);
        }

        NodeToAstTransformer.CopyCommentNodes(node.GetTryPart(), returnAst);

        int childCountInTryPart = DotNetEnumerable.Count(node.GetChildren());

        int commentCountInTryPart = DotNetEnumerable.Count(node.GetComments());

        if (node.GetCatchPart() != null)
        {
            Name name = (Name) NodeToAstTransformer.Process(node.GetCatchPart(), "VisitDirect");

            if (name != null)
            {
                returnAst.setCatchName(name);
            }

            LinkedList<Stmt> catchStatements = (LinkedList<Stmt>) NodeToAstTransformer.Process(node.GetCatchPart());

            for (Stmt stmt : catchStatements)
            {
                returnAst.addCatchStmt(stmt);
            }

            NodeToAstTransformer.CopyCommentNodes(node.GetCatchPart(), returnAst);

            for (Stmt stmt : returnAst.getCatchStmts())
            {
                NodeToAstTransformer.CopyRelativeChildIndexField(stmt.GetRelativeChildIndex() + childCountInTryPart, stmt);
            }

            for (int i=commentCountInTryPart; i< returnAst.getComments().size(); i++)
            {
                HelpComment helpComment = (HelpComment)returnAst.getComments().get(i);

                NodeToAstTransformer.CopyRelativeChildIndexField(helpComment.GetRelativeChildIndex() + childCountInTryPart, helpComment);
            }
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    private static WhileStmt Visit(WhileNode node)
    {
        WhileStmt returnAst = new WhileStmt();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.setExpr(expr);

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        boolean isOutputSuppressed = (boolean)NodeToAstTransformer.Process(node.GetTerminator());

        returnAst.setOutputSuppressed(isOutputSuppressed);

        return returnAst;
    }

    // endregion

    // region PART NODES:

    private static IfBlock Visit(IfPartNode node)
    {
        IfBlock returnAst = new IfBlock();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.setCondition(expr);

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt  = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    private static IfBlock Visit(ElseIfPartNode node)
    {
        IfBlock returnAst = new IfBlock();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.setCondition(expr);

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt  = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    private static ElseBlock Visit(ElsePartNode node)
    {
        ElseBlock returnAst = new ElseBlock();

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    private static Expr Visit(SwitchPartNode node)
    {
        Expr returnAst = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        return returnAst;
    }

    private static SwitchCaseBlock Visit(CasePartNode node)
    {
        SwitchCaseBlock returnAst = new SwitchCaseBlock();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.setExpr(expr);

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    private static DefaultCaseBlock Visit(OtherwisePartNode node)
    {
        DefaultCaseBlock returnAst = new DefaultCaseBlock();

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.addStmt(stmt);
        }

        return returnAst;
    }

    private static LinkedList<Stmt> Visit(TryPartNode node)
    {
        LinkedList<Stmt> returnAst = new LinkedList<Stmt>();

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.add(stmt);
        }

        return returnAst;
    }

    private static LinkedList<Stmt> Visit(CatchPartNode node)
    {
        LinkedList<Stmt> returnAst = new LinkedList<Stmt>();

        for (StatementNode statementNode : node.GetStatements())
        {
            Stmt stmt = (Stmt)NodeToAstTransformer.Process(statementNode);

            returnAst.add(stmt);
        }

        return returnAst;
    }

    private static Name VisitDirect(CatchPartNode node)
    {
        Name returnAst = new Name();

        if (node.GetVar() != null)
        {
            returnAst = (Name)NodeToAstTransformer.Process(node.GetVar().GetName());
        }
        else
        {
            returnAst = null;
        }

        return returnAst;
    }

    // endregion

    // region EXPRESSION NODES:

    // region N-ARY NODES:

    private static RangeExpr Visit(ColonNode node)
    {
        RangeExpr returnAst = new RangeExpr();

        int count = DotNetEnumerable.Count(node.GetOperands());

        if (count == 2)
        {
            Expr lower = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(0));

            Expr upper = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(1));

            returnAst.setLower(lower);

            returnAst.setUpper(upper);
        }
        else if (count >= 3)
        {
            Expr lower = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(0));

            for (int i=1; i<count-2; i++)
            {
                Expr other = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(i));

                returnAst.addOther(other);
            }

            Expr incr = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(count-2));

            Expr upper = (Expr)NodeToAstTransformer.Process((MNode)((NodeCollection)node.GetChildren()).GetIndex(count-1));

            returnAst.setLower(lower);

            returnAst.setIncr(incr);

            returnAst.setUpper(upper);
        }
        else
        {
            throw new InternalException();
        }

        return returnAst;
    }

    private static Row Visit(HCatNode node)
    {
        Row returnAst = new Row();

        for(ExpressionNode expressionNode : node.GetOperands())
        {
            Expr expr = (Expr)NodeToAstTransformer.Process(expressionNode);

            returnAst.addElement(expr);
        }

        return returnAst;
    }

    private static LinkedList<Row> Visit(VCatNode node)
    {
        LinkedList<Row> returnAst = new LinkedList<Row>();

        for (HCatNode hCatNode : node.GetOperands())
        {
            Row row = (Row)NodeToAstTransformer.Process(hCatNode);

            returnAst.add(row);
        }

        return returnAst;
    }

    // endregion

    // region BINARY NODES:

    private static PlusExpr Visit(PlusNode node)
    {
        PlusExpr returnAst = new PlusExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static MinusExpr Visit(MinusNode node)
    {
        MinusExpr returnAst = new MinusExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static ETimesExpr Visit(TimesNode node)
    {
        ETimesExpr returnAst = new ETimesExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static MTimesExpr Visit(MTimesNode node)
    {
        MTimesExpr returnAst = new MTimesExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static ELDivExpr Visit(LDivNode node)
    {
        ELDivExpr returnAst = new ELDivExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static MLDivExpr Visit(MLDivNode node)
    {
        MLDivExpr returnAst = new MLDivExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static EDivExpr Visit(RDivNode node)
    {
        EDivExpr returnAst = new EDivExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static MDivExpr Visit(MRDivNode node)
    {
        MDivExpr returnAst = new MDivExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static EPowExpr Visit(PowNode node)
    {
        EPowExpr returnAst = new EPowExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static MPowExpr Visit(MPowNode node)
    {
        MPowExpr returnAst = new MPowExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static EQExpr Visit(EqNode node)
    {
        EQExpr returnAst = new EQExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static NEExpr Visit(NotEqNode node)
    {
        NEExpr returnAst = new NEExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static LTExpr Visit(LtNode node)
    {
        LTExpr returnAst = new LTExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static LEExpr Visit(LtEqNode node)
    {
        LEExpr returnAst = new LEExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static GTExpr Visit(GtNode node)
    {
        GTExpr returnAst = new GTExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static GEExpr Visit(GtEqNode node)
    {
        GEExpr returnAst = new GEExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static AndExpr Visit(AndNode node)
    {
        AndExpr returnAst = new AndExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static ShortCircuitAndExpr Visit(ShortAndNode node)
    {
        ShortCircuitAndExpr returnAst = new ShortCircuitAndExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static OrExpr Visit(OrNode node)
    {
        OrExpr returnAst = new OrExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static ShortCircuitOrExpr Visit(ShortOrNode node)
    {
        ShortCircuitOrExpr returnAst = new ShortCircuitOrExpr();

        NodeToAstTransformer.AddOperands(node, returnAst);

        return returnAst;
    }

    private static void AddOperands(BinaryNode node, BinaryExpr ast)
    {
        Expr left = (Expr)NodeToAstTransformer.Process(node.GetLeftOperand());

        Expr right = (Expr)NodeToAstTransformer.Process(node.GetRightOperand());

        ast.setLHS(left);

        ast.setRHS(right);
    }

    // endregion

    // region UNARY NODES:

    private static UPlusExpr Visit(PositiveNode node)
    {
        UPlusExpr returnAst = new UPlusExpr();

        NodeToAstTransformer.AddOperand(node, returnAst);

        return returnAst;
    }

    private static UMinusExpr Visit(NegativeNode node)
    {
        UMinusExpr returnAst = new UMinusExpr();

        NodeToAstTransformer.AddOperand(node, returnAst);

        return returnAst;
    }

    private static ArrayTransposeExpr Visit(TransNode node)
    {
        ArrayTransposeExpr returnAst = new ArrayTransposeExpr();

        NodeToAstTransformer.AddOperand(node, returnAst);

        return returnAst;
    }

    private static MTransposeExpr Visit(CTransNode node)
    {
        MTransposeExpr returnAst = new MTransposeExpr();

        NodeToAstTransformer.AddOperand(node, returnAst);

        return returnAst;
    }

    private static NotExpr Visit(NotNode node)
    {
        NotExpr returnAst = new NotExpr();

        NodeToAstTransformer.AddOperand(node, returnAst);

        return returnAst;
    }

    private static void AddOperand(UnaryNode node, UnaryExpr ast)
    {
        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        ast.setOperand(expr);
    }

    // endregion

    // region ATOMIC NODES:

    // region BASIC NODES:

    private static ColonExpr Visit(AllNode node)
    {
        return new ColonExpr();
    }

    private static EndExpr Visit(EndNode node)
    {
        return new EndExpr();
    }

    private static LiteralExpr Visit(ImaginaryNode node)
    {
        String text = node.GetText();

        if (NodeToAstTransformer.TryParseInteger(text))
        {
            IntLiteralExpr returnAst = new IntLiteralExpr();

            DecIntNumericLiteralValue value = new DecIntNumericLiteralValue(text, true);

            returnAst.setValue(value);

            return returnAst;
        }
        else
        {
            FPLiteralExpr returnAst = new FPLiteralExpr();

            FPNumericLiteralValue value = new FPNumericLiteralValue(text, true);

            returnAst.setValue(value);

            return returnAst;
        }
    }

    private static LiteralExpr Visit(RealNode node)
    {
        String text = node.GetText();

        if (NodeToAstTransformer.TryParseInteger(text))
        {
            IntLiteralExpr returnAst = new IntLiteralExpr();

            DecIntNumericLiteralValue value = new DecIntNumericLiteralValue(text, false);

            returnAst.setValue(value);

            return returnAst;
        }
        else
        {
            FPLiteralExpr returnAst = new FPLiteralExpr();

            text = text.replace('d', 'e').replace('D', 'E');

            FPNumericLiteralValue value = new FPNumericLiteralValue(text, false);

            returnAst.setValue(value);

            return returnAst;
        }
    }

    private static StringLiteralExpr Visit(StringNode node)
    {
        StringLiteralExpr returnAst = new StringLiteralExpr();

        returnAst.setValue(node.GetText());

        return returnAst;
    }

    private static NameExpr Visit(VarNode node)
    {
        NameExpr returnAst = new NameExpr();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name);

        return returnAst;
    }

    private static boolean TryParseInteger(String text)
    {
        for (int i=0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            if (!(c >= '0' && c <= '9'))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean TryParseDouble(String text)
    {
        return text.contains(".");
    }

    // endregion

    // region ARRAY NODES:

    private static CellArrayExpr Visit(CellArrayNode node)
    {
        CellArrayExpr returnAst = new CellArrayExpr();

        VCatNode vCatNode = node.GetContents();

        if (vCatNode != null)
        {
            LinkedList<Row> rows = (LinkedList<Row>)NodeToAstTransformer.Process(vCatNode);

            for(Row row : rows)
            {
                returnAst.addRow(row);
            }
        }

        return returnAst;
    }

    private static MatrixExpr Visit(RegularArrayNode node)
    {
        MatrixExpr returnAst = new MatrixExpr();

        VCatNode vCatNode = node.GetContents();

        if (vCatNode != null)
        {
            LinkedList<Row> rows = (LinkedList<Row>)NodeToAstTransformer.Process(vCatNode);

            for(Row row : rows)
            {
                returnAst.addRow(row);
            }
        }

        return returnAst;
    }

    // endregion

    // region CHAIN NODES:

    private static ParameterizedExpr Visit(DotExpressionNode node)
    {
        ParameterizedExpr returnAst = new ParameterizedExpr();

        NameExpr nameExpr = new NameExpr();

        Name name = new Name();

        name.setID("$_GET_FIELD");

        nameExpr.setName(name);

        returnAst.setTarget(nameExpr);

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        returnAst.addArg(expr);

        Expr expr2 = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.addArg(expr2);

        return returnAst;
    }

    private static DotExpr Visit(DotNameNode node)
    {
        DotExpr returnAst = new DotExpr();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setTarget(expr);

        returnAst.setField(name);

        return returnAst;
    }

    private static ParameterizedExpr Visit(ParenthesisNode node)
    {
        ParameterizedExpr returnAst = new ParameterizedExpr();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        returnAst.setTarget(expr);

        for (ExpressionNode expressionNode : node.GetArguments())
        {
            Expr expr2 = (Expr)NodeToAstTransformer.Process(expressionNode);

            returnAst.addArg(expr2);
        }

        return returnAst;
    }

    private static CellIndexExpr Visit(CurlyBraceNode node)
    {
        CellIndexExpr returnAst = new CellIndexExpr();

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        returnAst.setTarget(expr);

        for (ExpressionNode expressionNode : node.GetArguments())
        {
            Expr expr2 = (Expr)NodeToAstTransformer.Process(expressionNode);

            returnAst.addArg(expr2);
        }

        return returnAst;
    }

    private static ParameterizedExpr Visit(AtBaseNode node)
    {
        ParameterizedExpr returnAst = new ParameterizedExpr();

        NameExpr nameExpr = new NameExpr();

        Name name = new Name();

        name.setID("$_GET_BASE_CLASS");

        nameExpr.setName(name);

        returnAst.setTarget(nameExpr);

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetOperand());

        returnAst.addArg(expr);

        StringLiteralExpr expr2 = new StringLiteralExpr();

        Name name2 = (Name)NodeToAstTransformer.Process(node.GetClass().GetName());

        expr2.setValue(name2.getID());

        returnAst.addArg(expr2);

        return returnAst;
    }

    // endregion

    // region DELEGATE NODES:

    private static LambdaExpr Visit(AnonymousFunctionNode node)
    {
        LambdaExpr returnAst = new LambdaExpr();

        for(InputNode inputNode : node.GetInputs())
        {
            Name name = (Name)NodeToAstTransformer.Process(inputNode);

            returnAst.addInputParam(name);
        }

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetExpression());

        returnAst.setBody(expr);

        return returnAst;
    }

    private static FunctionHandleExpr Visit(FunctionHandleNode node)
    {
        FunctionHandleExpr returnAst = new FunctionHandleExpr();

        Name name = (Name)NodeToAstTransformer.Process(node.GetFunction().GetName());

        returnAst.setName(name);

        return returnAst;
    }

    // endregion

    // region METACLASS NODES:

    private static ParameterizedExpr Visit(MetaclassNode node)
    {
        ParameterizedExpr returnAst = new ParameterizedExpr();

        NameExpr nameExpr = new NameExpr();

        Name name = new Name();

        name.setID("$_GET_METACLASS");

        nameExpr.setName(name);

        returnAst.setTarget(nameExpr);

        Name name2 = (Name)NodeToAstTransformer.Process(node.GetClass().GetName());

        StringLiteralExpr expr = new StringLiteralExpr();

        expr.setValue(name2.getID());

        returnAst.addArg(expr);

        return returnAst;
    }

    // endregion

    // region STORAGE NODES:

    private static MatrixExpr Visit(StorageNode node)
    {
        MatrixExpr returnAst = new MatrixExpr();

        Row row = new Row();

        for(ISimpleLValueNode iSimpleLValueNode : node.GetLValues())
        {
            ExpressionNode expressionNode = (ExpressionNode)iSimpleLValueNode;

            Expr expr = (Expr)NodeToAstTransformer.Process(expressionNode);

            row.addElement(expr);
        }

        returnAst.addRow(row);

        return returnAst;
    }

    // endregion

    // endregion

    // endregion

    // region IO NODES:

    private static Name Visit(InputNode node)
    {
        Name returnAst = (Name)NodeToAstTransformer.Process(node.GetName());

        return returnAst;
    }

    private static Name Visit(OutputNode node)
    {
        Name returnAst = (Name)NodeToAstTransformer.Process(node.GetName());

        return returnAst;
    }

    // endregion

    // region TERMINATOR NODES:

    private static boolean Visit(PrintNode node)
    {
        return false;
    }

    private static boolean Visit(NoPrintNode node)
    {
        return true;
    }

    // endregion

    // endregion

    // region REFERENCE NODES:

    private static Object Visit(ClassRefNode node)
    {
        throw new InternalException();
    }

    private static Object Visit(FunctionRefNode node)
    {
        throw new InternalException();
    }

    // endregion

    // region UTILITY NODES:

    private static String Visit(IdNode node)
    {
        return node.GetText();
    }

    private static Name Visit(NameNode node)
    {
        Name returnAst = new Name();

        LinkedList<String> linkedList = new LinkedList<String>();

        for (IdNode idNode : node.GetIds())
        {
            String value = (String)NodeToAstTransformer.Process(idNode);

            linkedList.add(value);
        }

        returnAst.setID(String.join(".", linkedList));

        return returnAst;
    }

    // endregion

    // region COMMENT NODES:

    private static HelpComment Visit(CommentNode node)
    {
        if (node.GetText().startsWith("%{"))
        {
            OneLineHelpComment returnAst = new OneLineHelpComment();

            returnAst.setText(node.GetText());

            return returnAst;
        }
        else
        {
            MultiLineHelpComment returnAst = new MultiLineHelpComment();

            returnAst.setText(node.GetText());

            return returnAst;
        }
    }

    // endregion

    // endregion

    // region ASPECT METHODS:

    private static AspectDef Visit(AspectFileNode node)
    {
        AspectDef returnAst = (AspectDef)NodeToAstTransformer.Process(node.GetAspect());

        return returnAst;
    }

    private static AspectDef Visit(AspectNode node)
    {
        AspectDef returnAst = new AspectDef();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name.getID());

        for (SectionNode sectionNode : node.GetSections())
        {
            if (sectionNode instanceof PropertySectionNode)
            {
                Properties properties = (Properties)NodeToAstTransformer.Process(sectionNode);

                returnAst.addProperty(properties);
            }
            else if (sectionNode instanceof MethodSectionNode)
            {
                Methods methods = (Methods)NodeToAstTransformer.Process(sectionNode);

                returnAst.addMethod(methods);
            }
            else if (sectionNode instanceof EventSectionNode)
            {
                ClassEvents events = (ClassEvents)NodeToAstTransformer.Process(sectionNode);

                returnAst.addClassEvent(events);
            }
            else if (sectionNode instanceof EnumerationSectionNode)
            {
                Enumerations enumerations = (Enumerations)NodeToAstTransformer.Process(sectionNode);

                returnAst.addEnumeration(enumerations);
            }
            else if (sectionNode instanceof AspectActionSectionNode)
            {
                Actions actions = (Actions)NodeToAstTransformer.Process(sectionNode);

                returnAst.addAction(actions);
            }
            else if (sectionNode instanceof AspectPatternSectionNode)
            {
                Patterns patterns = (Patterns)NodeToAstTransformer.Process(sectionNode);

                returnAst.addPattern(patterns);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static Actions Visit(AspectActionSectionNode node)
    {
        Actions returnAst = new Actions();

        for(AspectActionNode actionNode : node.GetAspectActions())
        {
            Action action = (Action)NodeToAstTransformer.Process(actionNode);

            returnAst.addAction(action);
        }

        return returnAst;
    }

    private static Patterns Visit(AspectPatternSectionNode node)
    {
        Patterns returnAst = new Patterns();

        for(AspectPatternNode patternNode : node.GetAspectPatterns())
        {
            Pattern pattern = (Pattern)NodeToAstTransformer.Process(patternNode);

            returnAst.addPattern(pattern);
        }

        return returnAst;
    }

    private static Action Visit(AspectActionNode node)
    {
        Action returnAst = new Action();

        Name name = (Name)NodeToAstTransformer.Process(node.GetActionName());

        returnAst.setName(name.getID());

        Name type = (Name)NodeToAstTransformer.Process(node.GetActionType());

        returnAst.setType(type.getID());

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetAspectExpression());

        returnAst.setExpr(expr);

        for(InputNode inputNode : node.GetInputs())
        {
            Name inputName = (Name)NodeToAstTransformer.Process(inputNode.GetName());

            returnAst.addInputParam(inputName);
        }

        for (StatementNode statementNode : node.GetStatements())
        {
            Object object = NodeToAstTransformer.Process(statementNode);

            if (object instanceof Stmt)
            {
                returnAst.addStmt((Stmt)object);
            }
            else if (object instanceof Function)
            {
                returnAst.addNestedFunction((Function)object);
            }
            else
            {
                throw new InternalException();
            }
        }

        return returnAst;
    }

    private static Pattern Visit(AspectPatternNode node)
    {
        Pattern returnAst = new Pattern();

        Name name = (Name)NodeToAstTransformer.Process(node.GetPatternName());

        returnAst.setName(name.getID());

        Expr expr = (Expr)NodeToAstTransformer.Process(node.GetValue());

        returnAst.setExpr(expr);

        return returnAst;
    }

    private static Selector Visit(AspectSelectorNode node)
    {
        Selector returnAst = new Selector();

        for(NameNode nameNode : node.GetElements())
        {
            Name name = (Name) NodeToAstTransformer.Process(nameNode);

            returnAst.addElement(name);
        }

        return returnAst;
    }

    private static TypeSignature Visit(AspectTypeSignatureNode node)
    {
        TypeSignature returnAst = new TypeSignature();

        Name name = (Name)NodeToAstTransformer.Process(node.GetType());

        returnAst.setType(name);

        return returnAst;
    }

    private static DimensionSignature Visit(AspectDimensionSignatureNode node)
    {
        DimensionSignature returnAst = new DimensionSignature();

        for(NameNode nameNode : node.GetDimensions())
        {
            Name name = (Name)NodeToAstTransformer.Process(nameNode);

            returnAst.addDimension(name);
        }

        return returnAst;
    }

    private static FullSignature Visit(AspectFullSignatureNode node)
    {
        FullSignature returnAst = new FullSignature();

        if (node.GetTypeSignature() != null)
        {
            TypeSignature typeSignature = (TypeSignature)NodeToAstTransformer.Process(node.GetTypeSignature());

            returnAst.setTypeSignature(typeSignature);
        }

        if (node.GetDimensionSignature() != null)
        {
            DimensionSignature dimensionSignature = (DimensionSignature)NodeToAstTransformer.Process(node.GetDimensionSignature());

            returnAst.setDimensionSignature(dimensionSignature);
        }

        return returnAst;
    }

    private static Input Visit(AspectInputNode node)
    {
        Input returnAst = new Input();

        for(AspectFullSignatureNode fullSignatureNode : node.GetFullSignatures())
        {
            FullSignature fullSignature = (FullSignature)NodeToAstTransformer.Process(fullSignatureNode);

            returnAst.addFullSignature(fullSignature);
        }

        return returnAst;
    }

    private static Output Visit(AspectOutputNode node)
    {
        Output returnAst = new Output();

        for(AspectFullSignatureNode fullSignatureNode : node.GetFullSignatures())
        {
            FullSignature fullSignature = (FullSignature)NodeToAstTransformer.Process(fullSignatureNode);

            returnAst.addFullSignature(fullSignature);
        }

        return returnAst;
    }

    private static PatternName Visit(AspectNameNode node)
    {
        PatternName returnAst = new PatternName();

        Name name = (Name)NodeToAstTransformer.Process(node.GetName());

        returnAst.setName(name);

        return returnAst;
    }

    private static PatternGet Visit(AspectGetNode node)
    {
        PatternGet returnAst = new PatternGet();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        if (node.GetFullSignature() != null)
        {
            FullSignature fullSignature = (FullSignature)NodeToAstTransformer.Process(node.GetFullSignature());

            returnAst.setFullSignature(fullSignature);
        }

        return returnAst;
    }

    private static PatternSet Visit(AspectSetNode node)
    {
        PatternSet returnAst = new PatternSet();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        if (node.GetFullSignature() != null)
        {
            FullSignature fullSignature = (FullSignature)NodeToAstTransformer.Process(node.GetFullSignature());

            returnAst.setFullSignature(fullSignature);
        }

        return returnAst;
    }

    private static PatternCall Visit(AspectCallNode node)
    {
        PatternCall returnAst = new PatternCall();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        Input input = (Input)NodeToAstTransformer.Process(node.GetInput());

        returnAst.setInput(input);

        Output output = (Output)NodeToAstTransformer.Process(node.GetOutput());

        returnAst.setOutput(output);

        return returnAst;
    }

    private static PatternExecution Visit(AspectExecutionNode node)
    {
        PatternExecution returnAst = new PatternExecution();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        Input input = (Input)NodeToAstTransformer.Process(node.GetInput());

        returnAst.setInput(input);

        Output output = (Output)NodeToAstTransformer.Process(node.GetOutput());

        returnAst.setOutput(output);

        return returnAst;
    }

    private static PatternMainExecution Visit(AspectMainExecutionNode node)
    {
        PatternMainExecution returnAst = new PatternMainExecution();

        return returnAst;
    }

    private static PatternLoop Visit(AspectLoopNode node)
    {
        PatternLoop returnAst = new PatternLoop();

        if (node.GetLoopType() != null)
        {
            Name type = (Name)NodeToAstTransformer.Process(node.GetLoopType());

            returnAst.setType(type);
        }

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        return returnAst;
    }

    private static PatternLoopHead Visit(AspectLoopHeadNode node)
    {
        PatternLoopHead returnAst = new PatternLoopHead();

        if (node.GetLoopType() != null)
        {
            Name type = (Name)NodeToAstTransformer.Process(node.GetLoopType());

            returnAst.setType(type);
        }

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        return returnAst;
    }

    private static PatternLoopBody Visit(AspectLoopBodyNode node)
    {
        PatternLoopBody returnAst = new PatternLoopBody();

        if (node.GetLoopType() != null)
        {
            Name type = (Name)NodeToAstTransformer.Process(node.GetLoopType());

            returnAst.setType(type);
        }

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        return returnAst;
    }

    private static PatternAnnotate Visit(AspectAnnotateNode node)
    {
        PatternAnnotate returnAst = new PatternAnnotate();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        for(AspectSelectorNode selectorNode : node.GetSelectors())
        {
            Selector selector = (Selector)NodeToAstTransformer.Process(selectorNode);

            returnAst.addSelector(selector);
        }

        return returnAst;
    }

    private static PatternOperator Visit(AspectOperatorNode node)
    {
        PatternOperator returnAst = new PatternOperator();

        Name name = (Name)NodeToAstTransformer.Process(node.GetOperatorType());

        returnAst.setType(name);

        for(AspectFullSignatureNode signatureNode : node.GetOperandSignatures())
        {
            FullSignature fullSignature = (FullSignature) NodeToAstTransformer.Process(signatureNode);

            returnAst.addFullSignature(fullSignature);
        }

        return returnAst;
    }

    private static PatternWithin Visit(AspectWithinNode node)
    {
        PatternWithin returnAst = new PatternWithin();

        Name name = (Name)NodeToAstTransformer.Process(node.GetIdentifier());

        returnAst.setIdentifier(name);

        Name type = (Name)NodeToAstTransformer.Process(node.GetScopeType());

        returnAst.setType(type);

        return returnAst;
    }

    private static PatternDimension Visit(AspectDimensionNode node)
    {
        PatternDimension returnAst = new PatternDimension();

        DimensionSignature dimensionSignature = (DimensionSignature)NodeToAstTransformer.Process(node.GetDimension());

        returnAst.setDimensionSignature(dimensionSignature);

        return returnAst;
    }

    private static PatternIsType Visit(AspectIsTypeNode node)
    {
        PatternIsType returnAst = new PatternIsType();

        TypeSignature typeSignature = (TypeSignature) NodeToAstTransformer.Process(node.GetTypeSignature());

        returnAst.setTypeSignature(typeSignature);

        return returnAst;
    }

    // endregion

    // endregion

    // region COPY METHODS:

    private static void CopyLineAndColumnFields(InternalNode node, ASTNode ast)
    {
        ast.setStartLine(node.GetLine());

        ast.setStartColumn(node.GetColumn());
    }

    private static void CopyCommentNodes(ICommentableNode node, ASTNode ast)
    {
        for(CommentNode commentNode : NodeToAstTransformer.GetCommentNodes(node))
        {
            HelpComment helpComment = (HelpComment)NodeToAstTransformer.Process(commentNode);

            ast.addComment(helpComment);
        }

        for (INode childNode : node.GetChildren())
        {
            if (childNode instanceof CommentNode)
            {
                HelpComment helpComment = (HelpComment)NodeToAstTransformer.Process((CommentNode)childNode);

                if (ast instanceof Script)
                {
                    ((Script)ast).addHelpComment(helpComment);
                }
                else if (ast instanceof Function)
                {
                    ((Function)ast).addHelpComment(helpComment);
                }
                else if (ast instanceof ClassDef)
                {
                    ((ClassDef)ast).addHelpComment(helpComment);
                }
                else if (ast instanceof AspectDef)
                {
                    ((AspectDef)ast).addHelpComment(helpComment);
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
    }

    private static LinkedList<CommentNode> GetCommentNodes(ICommentableNode node)
    {
        LinkedList<CommentNode> list = new LinkedList<CommentNode>();

        for (INode child : node.GetChildren())
        {
            if (child instanceof CommentNode)
            {
                list.add((CommentNode)child);
            }
        }

        return list;
    }

    private static void CopyRelativeChildIndexField(IMNode node, ASTNode ast)
    {
        if (node.GetParent() != null)
        {
            int indexInParent = DotNetEnumerable.IndexOf(node.GetParent().GetChildren(), node);

            ast.SetRelativeChildIndex(indexInParent);
        }
    }

    private static void CopyRelativeChildIndexField(int value, ASTNode ast)
    {
        ast.SetRelativeChildIndex(value);
    }

    // endregion

    // endregion
}
