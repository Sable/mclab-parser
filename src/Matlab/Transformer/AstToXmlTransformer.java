package Matlab.Transformer;

import ast.*;
import org.w3c.dom.Document;

public class AstToXmlTransformer
{
    // region STATIC METHODS:

    public static Document Transform(CompilationUnits ast)
    {
        return ast.ASTtoXML(false);
    }

    // endregion
}
