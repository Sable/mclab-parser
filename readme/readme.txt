
THIS FILE CONTAINS SOME HELP:

I)

In the "McLabCore" project, the following files were modified or added:
- natlab.ast (modified)
- natlabModifications.jadd (added)
- AST2XML.jrag (modified)
The modifications and additions are backwards compatible to the best of my knowledge.
The new McLabCore.jar so generated is a dependency of this project. It can be found in the "lib" folder.

II)

To use the project from the command line, type:
java –jar Matlab.Parser.jar /help

Here's another example:
java –jar Matlab.Parser.jar /out: files.xml /files: file1.m file2.m

III)

To use the project programmatically:

// ------------------------------------------------------------------------------------------
String inputPath = ... ;

boolean buildTree = true ;

String outputPath = ... ;

Result<UnitNode> result = MRecognizer.RecognizeFile(inputPath, buildTree, new Notifier());

if (result.GetReport().GetIsOk())
{
    UnitNode node = result.GetValue();

    CompilationUnits compilationUnits = NodeToAstTransformer.Transform(node);

    Document document = AstToXmlTransformer.Transform(compilationUnits);

    Program.Save(document, outputPath);
}
// ------------------------------------------------------------------------------------------