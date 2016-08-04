# `Matlab.Parser`

## Introduction:

This project is a parser for Matlab 8.1 (R2013a). The parser processes M-files written in Matlab and builds ASTs from their content. The ASTs use the node hierarchy utilized by the [Sable Research Group](http://www.sable.mcgill.ca) at the School of Computer Science, McGill University. The ASTs can be serialized to XML for later inspection. The parser processes AspectMATLAB code files as well. AspectMATLAB has been defined by the Sable Research Group.

## Development:

The project has been written in the Java programming language using IntelliJ IDEA 2016.1. The code has been largely ported from a fully operational Matlab parser I had previously written in C#, which can be found [here](https://github.com/samuel-suffos/matlab-parser). The project is also partly written in ANTLR 3.5.2. The necessary ANTLR Runtime is redistributed with this project. The code depends also on a modified version of library `McLabCore.jar`, which is also redistributed with the project. The original `McLabCore.jar` library can be found [here](https://github.com/Sable/mclab-core).

## Contents:

The contents of this repository is an IntelliJ IDEA project made of several modules:

* `Matlab.Info` - Contains information about the project.
* `Matlab.DotNet` - Contains utility classes that facilitated migration from C# to Java.
* `Matlab.Utils` - Contains utility classes for the project.
* `Matlab.Nodes` - Contains an internal hierarchy of nodes to represent Matlab code.
* `Matlab.Aspect.Nodes` - Contains an internal hierarchy of nodes to represent AspectMatlab code.
* `Matlab.Recognizer` - The reusable parsing API.
* `Matlab.Transformer` - Contains code to transform internal AST nodes to the AST nodes used by the Sable Research Group.
* `Matlab.Parser` - The parsing tool, which uses the parsing API and the AST transformer.

The project depends on a couple of libraries which can be found under the `lib` directory (plus the necessary LICENSE and README files):

* `antlr-3.5.2-runtime.jar` - ANTLR 3.5.2 Runtime.
* `McLabCore.jar` - Modified version of the original homonymous library. (See the `MCLABCORE` directory for more information.)

## How to use the project:

* To test the program type `java -jar Matlab.Parser.jar` and press `Enter`. Information about the program version and a short copyright notice should be printed on the screen.

* To display help, type `java -jar Matlab.Parser.jar /help`.

* To parse `<file1>` ... `<fileN>` and generate `<file>`, type `java -jar Matlab.Parser.jar /out: <file> /files: <file1> ... <fileN>`. Let `<file>` = `'?'` to generate no output file. Let `<file>` = `'*'` to generate an output file for each processed file.

* To parse files whose names match `<pattern>` in current directory (and subdirectories) and generate `<file>`, type `java -jar Matlab.Parser.jar /out: <file> /pattern: <pattern>`. Let `<file>` = `'?'` to generate no output file. Let `<file>` = `'*'` to generate an output file for each processed file.

## Examples:

* To process files `file1.m` and `file2.m` and generate file `files.xml` containing the XML serialization of a combined AST built from their content, type `java -jar Matlab.Parser.jar /out: files.xml /files: file1.m file2.m`.

* To analyze file `file1.m` and file `"D:\file2.m"` for syntactic correctness but without generating any output file (that is, just to be notified of any syntactic problems with the files' contents), type `java -jar Matlab.Parser.jar /out: '?' /files: file1.m "D:\file2.m"`.

* To process files `file1.m` and `file2.m` and generate new files (that is, files `file1.m.xml` and `file2.m.xml`) with the XML serialization of each input file's AST, type `java -jar Matlab.Parser.jar /out: '*' /files: file1.m file2.m`.

* To process all files whose names match pattern `*.m` in the current working directory (and its subdirectories) and generate file `files.xml` containing the XML serialization of a combined AST built from their content, type `java -jar Matlab.Parser.jar /out: files.xml /pattern: '*'.m`.

* To analyze all files whose names match pattern `*.m` in the current working directory (and its subdirectories) for syntactic correctness but without generating any output file (that is, just to be notified of any syntactic problems with the files' contents), type `java -jar Matlab.Parser.jar /out: '?' /pattern: '*'.m`.

* To process all files whose names match pattern `*.m` in the current working directory (and its subdirectories) and generate new files with the XML serialization of each input file's AST, type `java -jar Matlab.Parser.jar /out: '*' /pattern: '*'.m`.

## More about the project:

To the best of my current knowledge, this program deals correctly with Matlab's tricky command syntax. Also, to the best of my current knowledge, this program correctly identifies the complex conjugate transpose operator (`'`). Properly handling Matlab's command syntax and properly identifying the complex conjugate transpose operator is where Matlab parsers have their most significant problems. Again, to the best of my knowledge, this parser deals appropriately with white-space separators in the contexts where they are significant. It should be pointed out, however, that Matlab's documentaion doesn't go into too much detail when talking about the syntax of the above mentioned elements. So, let me know if you find any bugs with my parser! In Matlab, you may want to use the `pcode` function as a means to test a file for syntactic correctness.

I have tested this project on a collection of close to 75,000 valid M-files that are distributed as part of the Matlab suite, version R2013a. (Note that not all files with `.m` extension distributed with Matlab are intended to be valid M-files. Some of them, for instance, are code templates, and contain invalid characters surrounding identifiers.) The parser is able to parse 100% of those valid M-files, without complaining. Evidence such as this suggests that, at least on valid input, `Matlab.Parser` is quite robust. (And believe me, some of those valid M-files use quite tricky Matlab syntax!)

You may find it interesting to know that, during testing, I discovered that a small set of the M-files distributed with Matlab R2013a that are clearly intended to be valid M-files contain syntax errors. Even Matlab's own `pcode` function rejects them!

## License:

[The BSD 3-Clause License]

Copyright (c) 2016, Samuel Suffos

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
