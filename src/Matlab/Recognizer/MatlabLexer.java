// $ANTLR 3.5.2 D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3 2016-06-10 18:48:01

package Matlab.Recognizer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class MatlabLexer extends MatlabLexerBase {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASPECT=5;
	public static final int ASSIGN=6;
	public static final int AT=7;
	public static final int BANG_MODE=8;
	public static final int BLOCKCOMMENT=9;
	public static final int BREAK=10;
	public static final int CASE=11;
	public static final int CATCH=12;
	public static final int CLASSDEF=13;
	public static final int COLON=14;
	public static final int COMMA=15;
	public static final int COMMAND=16;
	public static final int COMMAND_MODE=17;
	public static final int CONTINUE=18;
	public static final int CTRANS=19;
	public static final int DEFAULTBLOCK=20;
	public static final int DEFAULTBLOCK1=21;
	public static final int DEFAULTBLOCK2=22;
	public static final int DEFAULTBLOCK3=23;
	public static final int DEFAULTBLOCK4=24;
	public static final int DEFAULT_MODE=25;
	public static final int DIGIT=26;
	public static final int DOT=27;
	public static final int DOTDOT=28;
	public static final int ELLIPSIS=29;
	public static final int ELSE=30;
	public static final int ELSEIF=31;
	public static final int END=32;
	public static final int EOL=33;
	public static final int EQ=34;
	public static final int EXCLAMATION=35;
	public static final int EXP=36;
	public static final int FOR=37;
	public static final int FUNCTION=38;
	public static final int GLOBAL=39;
	public static final int GT=40;
	public static final int GTEQ=41;
	public static final int ID=42;
	public static final int IF=43;
	public static final int IMAGINARY=44;
	public static final int IMG=45;
	public static final int LCURLY=46;
	public static final int LDIV=47;
	public static final int LETTER=48;
	public static final int LINE=49;
	public static final int LINECOMMENT=50;
	public static final int LINECOMMENT1=51;
	public static final int LINECOMMENT2=52;
	public static final int LINECOMMENT3=53;
	public static final int LPAREN=54;
	public static final int LSQUARE=55;
	public static final int LT=56;
	public static final int LTEQ=57;
	public static final int MINUS=58;
	public static final int MLDIV=59;
	public static final int MPOW=60;
	public static final int MRDIV=61;
	public static final int MTIMES=62;
	public static final int NOT=63;
	public static final int NOTEQ=64;
	public static final int NUMBER=65;
	public static final int OR=66;
	public static final int OTHERWISE=67;
	public static final int PARFOR=68;
	public static final int PERSISTENT=69;
	public static final int PLUS=70;
	public static final int POINT=71;
	public static final int POW=72;
	public static final int QUESTION=73;
	public static final int QUOTATION=74;
	public static final int RCURLY=75;
	public static final int RDIV=76;
	public static final int REAL=77;
	public static final int RETURN=78;
	public static final int RPAREN=79;
	public static final int RSQUARE=80;
	public static final int SEMICOLON=81;
	public static final int SHORTAND=82;
	public static final int SHORTOR=83;
	public static final int SIGN=84;
	public static final int SPACES=85;
	public static final int SPMD=86;
	public static final int START=87;
	public static final int STRING=88;
	public static final int STRINGBLOCK=89;
	public static final int SWITCH=90;
	public static final int TIMES=91;
	public static final int TRANS=92;
	public static final int TRY=93;
	public static final int UNKNOWN=94;
	public static final int WHILE=95;
	public static final int WS=96;

	// delegates
	// delegators
	public MatlabLexerBase[] getDelegates() {
		return new MatlabLexerBase[] {};
	}

	public MatlabLexer() {} 
	public MatlabLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public MatlabLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3"; }

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:46:7: ({...}? => DEFAULT_MODE |{...}? => COMMAND_MODE |{...}? => BANG_MODE )
			int alt1=3;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='%') && ((((Spaces_SpacesPrecedeInLine())&&(Machine_InMode(Mode.Default)))||((!Spaces_SpacesPrecedeInLine())&&(Machine_InMode(Mode.Default)))||((Spaces_SpacesPrecedeInLine())&&(Machine_InMode(Mode.Command)))||(Machine_InMode(Mode.Bang))||(((!Spaces_SpacesPrecedeInLine())||(Spaces_SpacesPrecedeInLine()))&&((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Command))))||((!Spaces_SpacesPrecedeInLine())&&(Machine_InMode(Mode.Command)))))) {
				int LA1_1 = input.LA(2);
				if ( (((Machine_InMode(Mode.Default))&&((!Spaces_SpacesPrecedeInLine())||(Spaces_SpacesPrecedeInLine())))) ) {
					alt1=1;
				}
				else if ( ((((!Spaces_SpacesPrecedeInLine())||(Spaces_SpacesPrecedeInLine()))&&(Machine_InMode(Mode.Command)))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='.') && (((Machine_InMode(Mode.Default))||(((Text_ThreeDotsFollow())||(!Text_ThreeDotsFollow()))&&(Machine_InMode(Mode.Command)))||(Machine_InMode(Mode.Bang))||((!Text_ThreeDotsFollow())&&(Machine_InMode(Mode.Command)))))) {
				int LA1_2 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((((Text_ThreeDotsFollow())||(!Text_ThreeDotsFollow()))&&(Machine_InMode(Mode.Command)))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='\t'||LA1_0==' ') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_3 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='\r') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_4 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='\n') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_5 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='\'') && (((((!Quotation_TransposeIsEnabled())||(Quotation_TransposeIsEnabled()))&&(Machine_InMode(Mode.Default)))||(Machine_InMode(Mode.Bang))||((Machine_InMode(Mode.Default))&&(!Quotation_TransposeIsEnabled()))||((Machine_InMode(Mode.Default))&&(Quotation_TransposeIsEnabled()))||(Machine_InMode(Mode.Command))))) {
				int LA1_6 = input.LA(2);
				if ( ((LA1_6 >= '\u0000' && LA1_6 <= '\t')||(LA1_6 >= '\u000B' && LA1_6 <= '\f')||(LA1_6 >= '\u000E' && LA1_6 <= '\uFFFF')) && ((Machine_InMode(Mode.Command)))) {
					alt1=2;
				}
				else if ( ((((!Quotation_TransposeIsEnabled())||(Quotation_TransposeIsEnabled()))&&(Machine_InMode(Mode.Default)))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA1_0 >= '0' && LA1_0 <= '9')) && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_7 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_8 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='+') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_9 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='-') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_10 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='*') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_11 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='/') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_12 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 12, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='\\') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_13 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 13, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='^') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_14 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 14, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='=') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_15 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 15, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='~') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_16 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 16, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='<') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_17 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 17, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='>') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_18 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 18, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='&') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_19 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 19, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='|') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_20 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 20, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==',') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_21 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 21, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==';') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_22 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 22, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==':') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_23 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 23, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='(') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_24 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 24, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==')') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_25 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 25, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='[') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_26 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 26, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==']') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_27 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 27, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='{') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_28 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 28, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='}') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_29 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 29, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='@') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_30 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 30, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='?') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_31 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 31, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0=='!') && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_32 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 32, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\b')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\u001F')||(LA1_0 >= '\"' && LA1_0 <= '$')||(LA1_0 >= '_' && LA1_0 <= '`')||(LA1_0 >= '\u007F' && LA1_0 <= '\uFFFF')) && (((Machine_InMode(Mode.Default))||(Machine_InMode(Mode.Bang))||(Machine_InMode(Mode.Command))))) {
				int LA1_33 = input.LA(2);
				if ( ((Machine_InMode(Mode.Default))) ) {
					alt1=1;
				}
				else if ( ((Machine_InMode(Mode.Command))) ) {
					alt1=2;
				}
				else if ( ((Machine_InMode(Mode.Bang))) ) {
					alt1=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 33, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			switch (alt1) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:46:9: {...}? => DEFAULT_MODE
					{
					if ( !((Machine_InMode(Mode.Default))) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "START", "Machine_InMode(Mode.Default)");
					}
					mDEFAULT_MODE(); if (state.failed) return;

					if ( state.backtracking==0 ) { _type = machine_TokenType; _channel = machine_TokenChannel.ToInt(); }
					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:47:9: {...}? => COMMAND_MODE
					{
					if ( !((Machine_InMode(Mode.Command))) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "START", "Machine_InMode(Mode.Command)");
					}
					mCOMMAND_MODE(); if (state.failed) return;

					if ( state.backtracking==0 ) { _type = machine_TokenType; _channel = machine_TokenChannel.ToInt(); }
					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:48:9: {...}? => BANG_MODE
					{
					if ( !((Machine_InMode(Mode.Bang))) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "START", "Machine_InMode(Mode.Bang)");
					}
					mBANG_MODE(); if (state.failed) return;

					if ( state.backtracking==0 ) { _type = machine_TokenType; _channel = machine_TokenChannel.ToInt(); }
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "DEFAULT_MODE"
	public final void mDEFAULT_MODE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:51:23: ( LINECOMMENT1 | LINECOMMENT2 | LINECOMMENT3 | BLOCKCOMMENT | ELLIPSIS | SPACES | EOL | DOTDOT | ( STRING )=> STRING | QUOTATION | CTRANS | REAL | IMAGINARY | ID | PLUS | MINUS | MTIMES | TIMES | MRDIV | RDIV | MLDIV | LDIV | MPOW | POW | TRANS | EQ | NOTEQ | LT | LTEQ | GT | GTEQ | NOT | AND | SHORTAND | OR | SHORTOR | ASSIGN | COMMA | SEMICOLON | COLON | DOT | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | AT | QUESTION | EXCLAMATION | UNKNOWN )
			int alt2=51;
			alt2 = dfa2.predict(input);
			switch (alt2) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:51:25: LINECOMMENT1
					{
					mLINECOMMENT1(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Default); }
					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:52:25: LINECOMMENT2
					{
					mLINECOMMENT2(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Default); }
					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:53:10: LINECOMMENT3
					{
					mLINECOMMENT3(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Default); }
					}
					break;
				case 4 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:54:10: BLOCKCOMMENT
					{
					mBLOCKCOMMENT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(BLOCKCOMMENT, Channel.Spaces, Mode.Default); }
					}
					break;
				case 5 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:55:10: ELLIPSIS
					{
					mELLIPSIS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(ELLIPSIS, Channel.Spaces, Mode.Default); }
					}
					break;
				case 6 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:56:10: SPACES
					{
					mSPACES(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SPACES, Channel.Spaces, Mode.Default); }
					}
					break;
				case 7 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:57:10: EOL
					{
					mEOL(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(EOL, Channel.Default, Mode.Default); }
					}
					break;
				case 8 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:58:10: DOTDOT
					{
					mDOTDOT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DOTDOT, Channel.Default, Mode.Default); }
					}
					break;
				case 9 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:59:10: ( STRING )=> STRING
					{
					mSTRING(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(STRING, Channel.Default, Mode.Default); }
					}
					break;
				case 10 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:60:10: QUOTATION
					{
					mQUOTATION(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(QUOTATION, Channel.Default, Mode.Default); }
					}
					break;
				case 11 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:61:10: CTRANS
					{
					mCTRANS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(CTRANS, Channel.Default, Mode.Default); }
					}
					break;
				case 12 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:62:10: REAL
					{
					mREAL(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(REAL, Channel.Default, Mode.Default); }
					}
					break;
				case 13 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:63:10: IMAGINARY
					{
					mIMAGINARY(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(IMAGINARY, Channel.Default, Mode.Default); }
					}
					break;
				case 14 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:64:10: ID
					{
					mID(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(getText(), ID, Channel.Default, Mode.Default); }
					}
					break;
				case 15 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:65:10: PLUS
					{
					mPLUS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(PLUS, Channel.Default, Mode.Default); }
					}
					break;
				case 16 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:66:10: MINUS
					{
					mMINUS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(MINUS, Channel.Default, Mode.Default); }
					}
					break;
				case 17 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:67:10: MTIMES
					{
					mMTIMES(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(MTIMES, Channel.Default, Mode.Default); }
					}
					break;
				case 18 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:68:10: TIMES
					{
					mTIMES(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(TIMES, Channel.Default, Mode.Default); }
					}
					break;
				case 19 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:69:10: MRDIV
					{
					mMRDIV(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(MRDIV, Channel.Default, Mode.Default); }
					}
					break;
				case 20 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:70:10: RDIV
					{
					mRDIV(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(RDIV, Channel.Default, Mode.Default); }
					}
					break;
				case 21 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:71:10: MLDIV
					{
					mMLDIV(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(MLDIV, Channel.Default, Mode.Default); }
					}
					break;
				case 22 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:72:10: LDIV
					{
					mLDIV(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LDIV, Channel.Default, Mode.Default); }
					}
					break;
				case 23 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:73:10: MPOW
					{
					mMPOW(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(MPOW, Channel.Default, Mode.Default); }
					}
					break;
				case 24 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:74:10: POW
					{
					mPOW(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(POW, Channel.Default, Mode.Default); }
					}
					break;
				case 25 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:75:10: TRANS
					{
					mTRANS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(TRANS, Channel.Default, Mode.Default); }
					}
					break;
				case 26 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:76:10: EQ
					{
					mEQ(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(EQ, Channel.Default, Mode.Default); }
					}
					break;
				case 27 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:77:10: NOTEQ
					{
					mNOTEQ(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(NOTEQ, Channel.Default, Mode.Default); }
					}
					break;
				case 28 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:78:10: LT
					{
					mLT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LT, Channel.Default, Mode.Default); }
					}
					break;
				case 29 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:79:10: LTEQ
					{
					mLTEQ(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LTEQ, Channel.Default, Mode.Default); }
					}
					break;
				case 30 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:80:10: GT
					{
					mGT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(GT, Channel.Default, Mode.Default); }
					}
					break;
				case 31 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:81:10: GTEQ
					{
					mGTEQ(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(GTEQ, Channel.Default, Mode.Default); }
					}
					break;
				case 32 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:82:10: NOT
					{
					mNOT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(NOT, Channel.Default, Mode.Default); }
					}
					break;
				case 33 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:83:10: AND
					{
					mAND(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(AND, Channel.Default, Mode.Default); }
					}
					break;
				case 34 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:84:10: SHORTAND
					{
					mSHORTAND(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SHORTAND, Channel.Default, Mode.Default); }
					}
					break;
				case 35 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:85:10: OR
					{
					mOR(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(OR, Channel.Default, Mode.Default); }
					}
					break;
				case 36 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:86:10: SHORTOR
					{
					mSHORTOR(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SHORTOR, Channel.Default, Mode.Default); }
					}
					break;
				case 37 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:87:10: ASSIGN
					{
					mASSIGN(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(ASSIGN, Channel.Default, Mode.Default); }
					}
					break;
				case 38 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:88:10: COMMA
					{
					mCOMMA(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(COMMA, Channel.Default, Mode.Default); }
					}
					break;
				case 39 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:89:10: SEMICOLON
					{
					mSEMICOLON(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SEMICOLON, Channel.Default, Mode.Default); }
					}
					break;
				case 40 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:90:10: COLON
					{
					mCOLON(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(COLON, Channel.Default, Mode.Default); }
					}
					break;
				case 41 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:91:10: DOT
					{
					mDOT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DOT, Channel.Default, Mode.Default); }
					}
					break;
				case 42 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:92:10: LPAREN
					{
					mLPAREN(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LPAREN, Channel.Default, Mode.Default); }
					}
					break;
				case 43 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:93:10: RPAREN
					{
					mRPAREN(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(RPAREN, Channel.Default, Mode.Default); }
					}
					break;
				case 44 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:94:10: LSQUARE
					{
					mLSQUARE(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LSQUARE, Channel.Default, Mode.Default); }
					}
					break;
				case 45 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:95:10: RSQUARE
					{
					mRSQUARE(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(RSQUARE, Channel.Default, Mode.Default); }
					}
					break;
				case 46 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:96:10: LCURLY
					{
					mLCURLY(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LCURLY, Channel.Default, Mode.Default); }
					}
					break;
				case 47 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:97:10: RCURLY
					{
					mRCURLY(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(RCURLY, Channel.Default, Mode.Default); }
					}
					break;
				case 48 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:98:10: AT
					{
					mAT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(AT, Channel.Default, Mode.Default); }
					}
					break;
				case 49 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:99:10: QUESTION
					{
					mQUESTION(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(QUESTION, Channel.Default, Mode.Default); }
					}
					break;
				case 50 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:100:10: EXCLAMATION
					{
					mEXCLAMATION(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(EXCLAMATION, Channel.Default, Mode.Bang); }
					}
					break;
				case 51 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:101:10: UNKNOWN
					{
					mUNKNOWN(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(UNKNOWN, Channel.Default, Mode.Default); }
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT_MODE"

	// $ANTLR start "COMMAND_MODE"
	public final void mCOMMAND_MODE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:104:23: ( LINECOMMENT1 | LINECOMMENT2 | LINECOMMENT3 | BLOCKCOMMENT | ELLIPSIS | SPACES | EOL | COMMA | SEMICOLON | STRINGBLOCK | DEFAULTBLOCK1 | DEFAULTBLOCK2 | DEFAULTBLOCK3 | DEFAULTBLOCK4 )
			int alt3=14;
			alt3 = dfa3.predict(input);
			switch (alt3) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:104:25: LINECOMMENT1
					{
					mLINECOMMENT1(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Command); }
					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:105:25: LINECOMMENT2
					{
					mLINECOMMENT2(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Command); }
					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:106:10: LINECOMMENT3
					{
					mLINECOMMENT3(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINECOMMENT, Channel.Skipped, Mode.Command); }
					}
					break;
				case 4 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:107:10: BLOCKCOMMENT
					{
					mBLOCKCOMMENT(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(BLOCKCOMMENT, Channel.Spaces, Mode.Command); }
					}
					break;
				case 5 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:108:10: ELLIPSIS
					{
					mELLIPSIS(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(ELLIPSIS, Channel.Spaces, Mode.Command); }
					}
					break;
				case 6 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:109:10: SPACES
					{
					mSPACES(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SPACES, Channel.Spaces, Mode.Command); }
					}
					break;
				case 7 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:110:10: EOL
					{
					mEOL(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(EOL, Channel.Default, Mode.Default); }
					}
					break;
				case 8 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:111:10: COMMA
					{
					mCOMMA(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(COMMA, Channel.Default, Mode.Default); }
					}
					break;
				case 9 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:112:10: SEMICOLON
					{
					mSEMICOLON(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(SEMICOLON, Channel.Default, Mode.Default); }
					}
					break;
				case 10 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:113:10: STRINGBLOCK
					{
					mSTRINGBLOCK(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(STRINGBLOCK, Channel.Default, Mode.Command); }
					}
					break;
				case 11 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:114:10: DEFAULTBLOCK1
					{
					mDEFAULTBLOCK1(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DEFAULTBLOCK, Channel.Default, Mode.Command); }
					}
					break;
				case 12 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:115:10: DEFAULTBLOCK2
					{
					mDEFAULTBLOCK2(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DEFAULTBLOCK, Channel.Default, Mode.Command); }
					}
					break;
				case 13 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:116:10: DEFAULTBLOCK3
					{
					mDEFAULTBLOCK3(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DEFAULTBLOCK, Channel.Default, Mode.Command); }
					}
					break;
				case 14 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:117:10: DEFAULTBLOCK4
					{
					mDEFAULTBLOCK4(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(DEFAULTBLOCK, Channel.Default, Mode.Command); }
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMAND_MODE"

	// $ANTLR start "BANG_MODE"
	public final void mBANG_MODE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:120:20: ( EOL | LINE )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\n'||LA4_0=='\r') ) {
				alt4=1;
			}
			else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:120:22: EOL
					{
					mEOL(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(EOL, Channel.Default, Mode.Default); }
					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:121:10: LINE
					{
					mLINE(); if (state.failed) return;

					if ( state.backtracking==0 ) { Machine_Update(LINE, Channel.Default, Mode.Bang); }
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BANG_MODE"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:126:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:128:16: ( '0' .. '9' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "EXP"
	public final void mEXP() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:130:14: ( 'e' | 'E' | 'd' | 'D' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( (input.LA(1) >= 'D' && input.LA(1) <= 'E')||(input.LA(1) >= 'd' && input.LA(1) <= 'e') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXP"

	// $ANTLR start "IMG"
	public final void mIMG() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:132:14: ( 'i' | 'j' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( (input.LA(1) >= 'i' && input.LA(1) <= 'j') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMG"

	// $ANTLR start "SIGN"
	public final void mSIGN() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:134:15: ( '+' | '-' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIGN"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:136:16: ( '.' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:136:18: '.'
			{
			match('.'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POINT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:138:13: ( ' ' | '\\t' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:17: ( ( ( DIGIT )+ ( '.' ( DIGIT )* )? | '.' ( DIGIT )+ ) ( EXP ( SIGN )? ( DIGIT )+ )? )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:19: ( ( DIGIT )+ ( '.' ( DIGIT )* )? | '.' ( DIGIT )+ ) ( EXP ( SIGN )? ( DIGIT )+ )?
			{
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:19: ( ( DIGIT )+ ( '.' ( DIGIT )* )? | '.' ( DIGIT )+ )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
				alt9=1;
			}
			else if ( (LA9_0=='.') ) {
				alt9=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:20: ( DIGIT )+ ( '.' ( DIGIT )* )?
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:20: ( DIGIT )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:29: ( '.' ( DIGIT )* )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='.') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:30: '.' ( DIGIT )*
							{
							match('.'); if (state.failed) return;
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:34: ( DIGIT )*
							loop6:
							while (true) {
								int alt6=2;
								int LA6_0 = input.LA(1);
								if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
									alt6=1;
								}

								switch (alt6) {
								case 1 :
									// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
										state.failed=false;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return;}
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop6;
								}
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:47: '.' ( DIGIT )+
					{
					match('.'); if (state.failed) return;
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:51: ( DIGIT )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt8 >= 1 ) break loop8;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(8, input);
							throw eee;
						}
						cnt8++;
					}

					}
					break;

			}

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:61: ( EXP ( SIGN )? ( DIGIT )+ )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= 'D' && LA12_0 <= 'E')||(LA12_0 >= 'd' && LA12_0 <= 'e')) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:62: EXP ( SIGN )? ( DIGIT )+
					{
					mEXP(); if (state.failed) return;

					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:66: ( SIGN )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='+'||LA10_0=='-') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:140:74: ( DIGIT )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "LINECOMMENT1"
	public final void mLINECOMMENT1() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:146:23: ({...}? => '%' (~ ( '\\r' | '\\n' ) )* )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:146:25: {...}? => '%' (~ ( '\\r' | '\\n' ) )*
			{
			if ( !((!Spaces_SpacesPrecedeInLine())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LINECOMMENT1", "!Spaces_SpacesPrecedeInLine()");
			}
			match('%'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:146:64: (~ ( '\\r' | '\\n' ) )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop13;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINECOMMENT1"

	// $ANTLR start "LINECOMMENT2"
	public final void mLINECOMMENT2() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:148:23: ({...}? => '%' '{' ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:148:25: {...}? => '%' '{' ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )*
			{
			if ( !((Spaces_SpacesPrecedeInLine())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LINECOMMENT2", "Spaces_SpacesPrecedeInLine()");
			}
			match('%'); if (state.failed) return;
			match('{'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:148:67: ( WS )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='\t'||LA14_0==' ') ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop14;
				}
			}

			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '!' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:148:101: (~ ( '\\r' | '\\n' ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop15;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINECOMMENT2"

	// $ANTLR start "LINECOMMENT3"
	public final void mLINECOMMENT3() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:150:23: ({...}? => '%' (~ ( '{' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* )? )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:150:25: {...}? => '%' (~ ( '{' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* )?
			{
			if ( !((Spaces_SpacesPrecedeInLine())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LINECOMMENT3", "Spaces_SpacesPrecedeInLine()");
			}
			match('%'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:150:63: (~ ( '{' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= 'z')||(LA17_0 >= '|' && LA17_0 <= '\uFFFF')) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:150:64: ~ ( '{' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )*
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= 'z')||(input.LA(1) >= '|' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:150:85: (~ ( '\\r' | '\\n' ) )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( ((LA16_0 >= '\u0000' && LA16_0 <= '\t')||(LA16_0 >= '\u000B' && LA16_0 <= '\f')||(LA16_0 >= '\u000E' && LA16_0 <= '\uFFFF')) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINECOMMENT3"

	// $ANTLR start "BLOCKCOMMENT"
	public final void mBLOCKCOMMENT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:152:23: ({...}? => '%' '{' ( WS )* EOL ( ( WS )* BLOCKCOMMENT | ( WS )* EOL | ( WS )* ~ ( '%' | ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' EOL | ( WS )* '%' ~ ( '{' | '}' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' ( '{' | '}' ) ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL )* ( WS )* '%' '}' ( WS )* EOL )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:152:25: {...}? => '%' '{' ( WS )* EOL ( ( WS )* BLOCKCOMMENT | ( WS )* EOL | ( WS )* ~ ( '%' | ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' EOL | ( WS )* '%' ~ ( '{' | '}' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' ( '{' | '}' ) ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL )* ( WS )* '%' '}' ( WS )* EOL
			{
			if ( !((Spaces_SpacesPrecedeInLine())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "BLOCKCOMMENT", "Spaces_SpacesPrecedeInLine()");
			}
			match('%'); if (state.failed) return;
			match('{'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:153:33: ( WS )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0=='\t'||LA18_0==' ') ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop18;
				}
			}

			mEOL(); if (state.failed) return;

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:154:25: ( ( WS )* BLOCKCOMMENT | ( WS )* EOL | ( WS )* ~ ( '%' | ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' EOL | ( WS )* '%' ~ ( '{' | '}' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' ( '{' | '}' ) ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL )*
			loop29:
			while (true) {
				int alt29=7;
				alt29 = dfa29.predict(input);
				switch (alt29) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:154:30: ( WS )* BLOCKCOMMENT
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:154:30: ( WS )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0=='\t'||LA19_0==' ') ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop19;
						}
					}

					mBLOCKCOMMENT(); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:155:19: ( WS )* EOL
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:155:19: ( WS )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0=='\t'||LA20_0==' ') ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop20;
						}
					}

					mEOL(); if (state.failed) return;

					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:156:19: ( WS )* ~ ( '%' | ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:156:19: ( WS )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0=='\t'||LA21_0==' ') ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop21;
						}
					}

					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '!' && input.LA(1) <= '$')||(input.LA(1) >= '&' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:156:59: (~ ( '\\r' | '\\n' ) )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\t')||(LA22_0 >= '\u000B' && LA22_0 <= '\f')||(LA22_0 >= '\u000E' && LA22_0 <= '\uFFFF')) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop22;
						}
					}

					mEOL(); if (state.failed) return;

					}
					break;
				case 4 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:157:19: ( WS )* '%' EOL
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:157:19: ( WS )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0=='\t'||LA23_0==' ') ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop23;
						}
					}

					match('%'); if (state.failed) return;
					mEOL(); if (state.failed) return;

					}
					break;
				case 5 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:158:19: ( WS )* '%' ~ ( '{' | '}' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:158:19: ( WS )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0=='\t'||LA24_0==' ') ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop24;
						}
					}

					match('%'); if (state.failed) return;
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:158:56: (~ ( '\\r' | '\\n' ) )*
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( ((LA25_0 >= '\u0000' && LA25_0 <= '\t')||(LA25_0 >= '\u000B' && LA25_0 <= '\f')||(LA25_0 >= '\u000E' && LA25_0 <= '\uFFFF')) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop25;
						}
					}

					mEOL(); if (state.failed) return;

					}
					break;
				case 6 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:159:19: ( WS )* '%' ( '{' | '}' ) ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL
					{
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:159:19: ( WS )*
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0=='\t'||LA26_0==' ') ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop26;
						}
					}

					match('%'); if (state.failed) return;
					if ( input.LA(1)=='{'||input.LA(1)=='}' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:159:41: ( WS )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0=='\t'||LA27_0==' ') ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop27;
						}
					}

					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '!' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:159:75: (~ ( '\\r' | '\\n' ) )*
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( ((LA28_0 >= '\u0000' && LA28_0 <= '\t')||(LA28_0 >= '\u000B' && LA28_0 <= '\f')||(LA28_0 >= '\u000E' && LA28_0 <= '\uFFFF')) ) {
							alt28=1;
						}

						switch (alt28) {
						case 1 :
							// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop28;
						}
					}

					mEOL(); if (state.failed) return;

					}
					break;

				default :
					break loop29;
				}
			}

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:161:25: ( WS )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0=='\t'||LA30_0==' ') ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop30;
				}
			}

			match('%'); if (state.failed) return;
			match('}'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:161:39: ( WS )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0=='\t'||LA31_0==' ') ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop31;
				}
			}

			mEOL(); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BLOCKCOMMENT"

	// $ANTLR start "ELLIPSIS"
	public final void mELLIPSIS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:165:19: ({...}? => '...' (~ ( '\\r' | '\\n' ) )* EOL )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:165:21: {...}? => '...' (~ ( '\\r' | '\\n' ) )* EOL
			{
			if ( !((Text_ThreeDotsFollow())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "ELLIPSIS", "Text_ThreeDotsFollow()");
			}
			match("..."); if (state.failed) return;

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:165:55: (~ ( '\\r' | '\\n' ) )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( ((LA32_0 >= '\u0000' && LA32_0 <= '\t')||(LA32_0 >= '\u000B' && LA32_0 <= '\f')||(LA32_0 >= '\u000E' && LA32_0 <= '\uFFFF')) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop32;
				}
			}

			mEOL(); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELLIPSIS"

	// $ANTLR start "DOTDOT"
	public final void mDOTDOT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:167:16: ( '..' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:167:18: '..'
			{
			match(".."); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOTDOT"

	// $ANTLR start "SPACES"
	public final void mSPACES() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:169:17: ( ( WS )+ )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:169:19: ( WS )+
			{
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:169:19: ( WS )+
			int cnt33=0;
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0=='\t'||LA33_0==' ') ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt33 >= 1 ) break loop33;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(33, input);
					throw eee;
				}
				cnt33++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPACES"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:171:14: ( '\\r\\n' | '\\r' | '\\n' )
			int alt34=3;
			int LA34_0 = input.LA(1);
			if ( (LA34_0=='\r') ) {
				int LA34_1 = input.LA(2);
				if ( (LA34_1=='\n') ) {
					alt34=1;
				}

				else {
					alt34=2;
				}

			}
			else if ( (LA34_0=='\n') ) {
				alt34=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:171:16: '\\r\\n'
					{
					match("\r\n"); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:171:25: '\\r'
					{
					match('\r'); if (state.failed) return;
					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:171:32: '\\n'
					{
					match('\n'); if (state.failed) return;
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:175:17: ({...}? => '\\'' ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )* '\\'' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:175:19: {...}? => '\\'' ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )* '\\''
			{
			if ( !((!Quotation_TransposeIsEnabled())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "STRING", "!Quotation_TransposeIsEnabled()");
			}
			match('\''); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:175:61: ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )*
			loop35:
			while (true) {
				int alt35=3;
				int LA35_0 = input.LA(1);
				if ( (LA35_0=='\'') ) {
					int LA35_1 = input.LA(2);
					if ( (LA35_1=='\'') ) {
						alt35=1;
					}

				}
				else if ( ((LA35_0 >= '\u0000' && LA35_0 <= '\t')||(LA35_0 >= '\u000B' && LA35_0 <= '\f')||(LA35_0 >= '\u000E' && LA35_0 <= '&')||(LA35_0 >= '(' && LA35_0 <= '\uFFFF')) ) {
					alt35=2;
				}

				switch (alt35) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:175:62: '\\'\\''
					{
					match("''"); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:175:71: ~ ( '\\'' | '\\r' | '\\n' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop35;
				}
			}

			match('\''); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "QUOTATION"
	public final void mQUOTATION() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:177:20: ({...}? => '\\'' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:177:22: {...}? => '\\''
			{
			if ( !((!Quotation_TransposeIsEnabled())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "QUOTATION", "!Quotation_TransposeIsEnabled()");
			}
			match('\''); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTATION"

	// $ANTLR start "CTRANS"
	public final void mCTRANS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:179:17: ({...}? => '\\'' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:179:19: {...}? => '\\''
			{
			if ( !((Quotation_TransposeIsEnabled())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "CTRANS", "Quotation_TransposeIsEnabled()");
			}
			match('\''); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CTRANS"

	// $ANTLR start "REAL"
	public final void mREAL() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:183:15: ( NUMBER )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:183:17: NUMBER
			{
			mNUMBER(); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REAL"

	// $ANTLR start "IMAGINARY"
	public final void mIMAGINARY() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:185:20: ( NUMBER IMG )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:185:22: NUMBER IMG
			{
			mNUMBER(); if (state.failed) return;

			mIMG(); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMAGINARY"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:187:13: ( LETTER ( '_' | LETTER | DIGIT )* )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:187:15: LETTER ( '_' | LETTER | DIGIT )*
			{
			mLETTER(); if (state.failed) return;

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:187:22: ( '_' | LETTER | DIGIT )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( ((LA36_0 >= '0' && LA36_0 <= '9')||(LA36_0 >= 'A' && LA36_0 <= 'Z')||LA36_0=='_'||(LA36_0 >= 'a' && LA36_0 <= 'z')) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop36;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:191:15: ( '+' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:191:17: '+'
			{
			match('+'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:193:16: ( '-' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:193:18: '-'
			{
			match('-'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MTIMES"
	public final void mMTIMES() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:195:17: ( '*' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:195:19: '*'
			{
			match('*'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MTIMES"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:197:16: ( '.*' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:197:18: '.*'
			{
			match(".*"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "MRDIV"
	public final void mMRDIV() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:199:16: ( '/' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:199:18: '/'
			{
			match('/'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MRDIV"

	// $ANTLR start "RDIV"
	public final void mRDIV() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:201:15: ( './' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:201:17: './'
			{
			match("./"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RDIV"

	// $ANTLR start "MLDIV"
	public final void mMLDIV() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:203:16: ( '\\\\' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:203:18: '\\\\'
			{
			match('\\'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MLDIV"

	// $ANTLR start "LDIV"
	public final void mLDIV() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:205:15: ( '.\\\\' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:205:17: '.\\\\'
			{
			match(".\\"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LDIV"

	// $ANTLR start "MPOW"
	public final void mMPOW() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:207:15: ( '^' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:207:17: '^'
			{
			match('^'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MPOW"

	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:209:14: ( '.^' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:209:16: '.^'
			{
			match(".^"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POW"

	// $ANTLR start "TRANS"
	public final void mTRANS() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:211:16: ( '.\\'' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:211:18: '.\\''
			{
			match(".'"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRANS"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:215:13: ( '==' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:215:15: '=='
			{
			match("=="); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "NOTEQ"
	public final void mNOTEQ() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:217:16: ( '~=' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:217:18: '~='
			{
			match("~="); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTEQ"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:219:13: ( '<' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:219:15: '<'
			{
			match('<'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "LTEQ"
	public final void mLTEQ() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:221:15: ( '<=' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:221:17: '<='
			{
			match("<="); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTEQ"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:223:13: ( '>' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:223:15: '>'
			{
			match('>'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "GTEQ"
	public final void mGTEQ() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:225:15: ( '>=' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:225:17: '>='
			{
			match(">="); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTEQ"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:229:14: ( '~' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:229:16: '~'
			{
			match('~'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:231:14: ( '&' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:231:16: '&'
			{
			match('&'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "SHORTAND"
	public final void mSHORTAND() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:233:19: ( '&&' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:233:21: '&&'
			{
			match("&&"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHORTAND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:235:13: ( '|' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:235:15: '|'
			{
			match('|'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "SHORTOR"
	public final void mSHORTOR() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:237:18: ( '||' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:237:20: '||'
			{
			match("||"); if (state.failed) return;

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHORTOR"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:241:17: ( '=' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:241:19: '='
			{
			match('='); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:243:16: ( ',' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:243:18: ','
			{
			match(','); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:245:20: ( ';' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:245:22: ';'
			{
			match(';'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:247:16: ( ':' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:247:18: ':'
			{
			match(':'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:249:14: ( '.' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:249:16: '.'
			{
			match('.'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:251:17: ( '(' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:251:19: '('
			{
			match('('); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:253:17: ( ')' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:253:19: ')'
			{
			match(')'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LSQUARE"
	public final void mLSQUARE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:255:18: ( '[' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:255:20: '['
			{
			match('['); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSQUARE"

	// $ANTLR start "RSQUARE"
	public final void mRSQUARE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:257:18: ( ']' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:257:20: ']'
			{
			match(']'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSQUARE"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:259:17: ( '{' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:259:19: '{'
			{
			match('{'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:261:17: ( '}' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:261:19: '}'
			{
			match('}'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:263:13: ( '@' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:263:15: '@'
			{
			match('@'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "QUESTION"
	public final void mQUESTION() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:265:19: ( '?' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:265:21: '?'
			{
			match('?'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUESTION"

	// $ANTLR start "EXCLAMATION"
	public final void mEXCLAMATION() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:267:22: ( '!' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:267:24: '!'
			{
			match('!'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCLAMATION"

	// $ANTLR start "UNKNOWN"
	public final void mUNKNOWN() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:271:18: (~ ( '%' | '.' | ' ' | '\\t' | '\\r' | '\\n' | '0' .. '9' | '\\'' | 'a' .. 'z' | 'A' .. 'Z' | '+' | '-' | '*' | '\\\\' | '/' | '^' | '=' | '~' | '<' | '>' | '&' | '|' | ',' | ';' | ':' | '(' | '[' | '{' | ')' | ']' | '}' | '@' | '?' | '!' ) )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '\"' && input.LA(1) <= '$')||(input.LA(1) >= '_' && input.LA(1) <= '`')||(input.LA(1) >= '\u007F' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNKNOWN"

	// $ANTLR start "STRINGBLOCK"
	public final void mSTRINGBLOCK() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:275:22: ( '\\'' ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )* '\\'' )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:275:24: '\\'' ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )* '\\''
			{
			match('\''); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:275:29: ( '\\'\\'' |~ ( '\\'' | '\\r' | '\\n' ) )*
			loop37:
			while (true) {
				int alt37=3;
				int LA37_0 = input.LA(1);
				if ( (LA37_0=='\'') ) {
					int LA37_1 = input.LA(2);
					if ( (LA37_1=='\'') ) {
						alt37=1;
					}

				}
				else if ( ((LA37_0 >= '\u0000' && LA37_0 <= '\t')||(LA37_0 >= '\u000B' && LA37_0 <= '\f')||(LA37_0 >= '\u000E' && LA37_0 <= '&')||(LA37_0 >= '(' && LA37_0 <= '\uFFFF')) ) {
					alt37=2;
				}

				switch (alt37) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:275:30: '\\'\\''
					{
					match("''"); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:275:39: ~ ( '\\'' | '\\r' | '\\n' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop37;
				}
			}

			match('\''); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRINGBLOCK"

	// $ANTLR start "DEFAULTBLOCK1"
	public final void mDEFAULTBLOCK1() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:24: ( ( '(' | '[' | '{' ) ( DEFAULTBLOCK1 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )* ( ')' | ']' | '}' )? )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:26: ( '(' | '[' | '{' ) ( DEFAULTBLOCK1 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )* ( ')' | ']' | '}' )?
			{
			if ( input.LA(1)=='('||input.LA(1)=='['||input.LA(1)=='{' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:44: ( DEFAULTBLOCK1 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )*
			loop38:
			while (true) {
				int alt38=4;
				int LA38_0 = input.LA(1);
				if ( (LA38_0=='('||LA38_0=='['||LA38_0=='{') ) {
					alt38=1;
				}
				else if ( (LA38_0=='.') && ((!Text_ThreeDotsFollow()))) {
					alt38=2;
				}
				else if ( ((LA38_0 >= '\u0000' && LA38_0 <= '\t')||(LA38_0 >= '\u000B' && LA38_0 <= '\f')||(LA38_0 >= '\u000E' && LA38_0 <= '\'')||(LA38_0 >= '*' && LA38_0 <= '-')||(LA38_0 >= '/' && LA38_0 <= ':')||(LA38_0 >= '<' && LA38_0 <= 'Z')||LA38_0=='\\'||(LA38_0 >= '^' && LA38_0 <= 'z')||LA38_0=='|'||(LA38_0 >= '~' && LA38_0 <= '\uFFFF')) ) {
					alt38=3;
				}

				switch (alt38) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:45: DEFAULTBLOCK1
					{
					mDEFAULTBLOCK1(); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:61: DEFAULTBLOCK3
					{
					mDEFAULTBLOCK3(); if (state.failed) return;

					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:77: ~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\'')||(input.LA(1) >= '*' && input.LA(1) <= '-')||(input.LA(1) >= '/' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop38;
				}
			}

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:277:142: ( ')' | ']' | '}' )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==')'||LA39_0==']'||LA39_0=='}') ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)==')'||input.LA(1)==']'||input.LA(1)=='}' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULTBLOCK1"

	// $ANTLR start "DEFAULTBLOCK2"
	public final void mDEFAULTBLOCK2() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:24: ( ( ')' | ']' | '}' ) ( DEFAULTBLOCK2 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )* ( '(' | '[' | '{' )? )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:26: ( ')' | ']' | '}' ) ( DEFAULTBLOCK2 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )* ( '(' | '[' | '{' )?
			{
			if ( input.LA(1)==')'||input.LA(1)==']'||input.LA(1)=='}' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:44: ( DEFAULTBLOCK2 | DEFAULTBLOCK3 |~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' ) )*
			loop40:
			while (true) {
				int alt40=4;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==')'||LA40_0==']'||LA40_0=='}') ) {
					alt40=1;
				}
				else if ( (LA40_0=='.') && ((!Text_ThreeDotsFollow()))) {
					alt40=2;
				}
				else if ( ((LA40_0 >= '\u0000' && LA40_0 <= '\t')||(LA40_0 >= '\u000B' && LA40_0 <= '\f')||(LA40_0 >= '\u000E' && LA40_0 <= '\'')||(LA40_0 >= '*' && LA40_0 <= '-')||(LA40_0 >= '/' && LA40_0 <= ':')||(LA40_0 >= '<' && LA40_0 <= 'Z')||LA40_0=='\\'||(LA40_0 >= '^' && LA40_0 <= 'z')||LA40_0=='|'||(LA40_0 >= '~' && LA40_0 <= '\uFFFF')) ) {
					alt40=3;
				}

				switch (alt40) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:45: DEFAULTBLOCK2
					{
					mDEFAULTBLOCK2(); if (state.failed) return;

					}
					break;
				case 2 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:61: DEFAULTBLOCK3
					{
					mDEFAULTBLOCK3(); if (state.failed) return;

					}
					break;
				case 3 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:77: ~ ( '(' | '[' | '{' | ')' | ']' | '}' | '.' | ';' | '\\r' | '\\n' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\'')||(input.LA(1) >= '*' && input.LA(1) <= '-')||(input.LA(1) >= '/' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop40;
				}
			}

			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:279:142: ( '(' | '[' | '{' )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0=='('||LA41_0=='['||LA41_0=='{') ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( input.LA(1)=='('||input.LA(1)=='['||input.LA(1)=='{' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULTBLOCK2"

	// $ANTLR start "DEFAULTBLOCK3"
	public final void mDEFAULTBLOCK3() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:281:24: ({...}? => '.' ( '.' )? )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:281:26: {...}? => '.' ( '.' )?
			{
			if ( !((!Text_ThreeDotsFollow())) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "DEFAULTBLOCK3", "!Text_ThreeDotsFollow()");
			}
			match('.'); if (state.failed) return;
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:281:59: ( '.' )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0=='.') ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:281:60: '.'
					{
					match('.'); if (state.failed) return;
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULTBLOCK3"

	// $ANTLR start "DEFAULTBLOCK4"
	public final void mDEFAULTBLOCK4() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:283:24: ( (~ ( '\\'' | '(' | '[' | '{' | ')' | ']' | '}' | '.' | '%' | ' ' | '\\t' | ',' | ';' | '\\r' | '\\n' ) )+ )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:283:26: (~ ( '\\'' | '(' | '[' | '{' | ')' | ']' | '}' | '.' | '%' | ' ' | '\\t' | ',' | ';' | '\\r' | '\\n' ) )+
			{
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:283:26: (~ ( '\\'' | '(' | '[' | '{' | ')' | ']' | '}' | '.' | '%' | ' ' | '\\t' | ',' | ';' | '\\r' | '\\n' ) )+
			int cnt43=0;
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( ((LA43_0 >= '\u0000' && LA43_0 <= '\b')||(LA43_0 >= '\u000B' && LA43_0 <= '\f')||(LA43_0 >= '\u000E' && LA43_0 <= '\u001F')||(LA43_0 >= '!' && LA43_0 <= '$')||LA43_0=='&'||(LA43_0 >= '*' && LA43_0 <= '+')||LA43_0=='-'||(LA43_0 >= '/' && LA43_0 <= ':')||(LA43_0 >= '<' && LA43_0 <= 'Z')||LA43_0=='\\'||(LA43_0 >= '^' && LA43_0 <= 'z')||LA43_0=='|'||(LA43_0 >= '~' && LA43_0 <= '\uFFFF')) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\b')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\u001F')||(input.LA(1) >= '!' && input.LA(1) <= '$')||input.LA(1)=='&'||(input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt43 >= 1 ) break loop43;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(43, input);
					throw eee;
				}
				cnt43++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULTBLOCK4"

	// $ANTLR start "LINE"
	public final void mLINE() throws RecognitionException {
		try {
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:287:15: ( (~ ( '\\r' | '\\n' ) )+ )
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:287:17: (~ ( '\\r' | '\\n' ) )+
			{
			// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:287:17: (~ ( '\\r' | '\\n' ) )+
			int cnt44=0;
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( ((LA44_0 >= '\u0000' && LA44_0 <= '\t')||(LA44_0 >= '\u000B' && LA44_0 <= '\f')||(LA44_0 >= '\u000E' && LA44_0 <= '\uFFFF')) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt44 >= 1 ) break loop44;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(44, input);
					throw eee;
				}
				cnt44++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:1:8: ( START )
		// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:1:10: START
		{
		mSTART(); if (state.failed) return;

		}

	}

	// $ANTLR start synpred1_MatlabLexer
	public final void synpred1_MatlabLexer_fragment() throws RecognitionException {
		// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:59:10: ( STRING )
		// D:\\!USERS\\SAMUEL\\DOCUMENTS\\IdeaProjects\\MatlabParser\\src\\Matlab\\Recognizer\\MatlabLexer.g3:59:11: STRING
		{
		mSTRING(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_MatlabLexer

	public final boolean synpred1_MatlabLexer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_MatlabLexer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA2 dfa2 = new DFA2(this);
	protected DFA3 dfa3 = new DFA3(this);
	protected DFA29 dfa29 = new DFA29(this);
	static final String DFA2_eotS =
		"\2\uffff\1\53\3\uffff\1\62\7\uffff\1\65\1\67\1\71\1\73\1\75\1\77\20\uffff"+
		"\1\104\5\uffff\1\62\5\uffff\1\62\24\uffff\1\62\1\uffff\1\62";
	static final String DFA2_eofS =
		"\110\uffff";
	static final String DFA2_minS =
		"\1\0\1\173\1\47\2\uffff\1\0\1\56\7\uffff\4\75\1\46\1\174\15\uffff\1\0"+
		"\2\uffff\1\56\5\uffff\1\60\5\uffff\1\60\1\53\16\uffff\1\0\4\uffff\3\60";
	static final String DFA2_maxS =
		"\1\uffff\1\173\1\136\2\uffff\1\uffff\1\152\7\uffff\4\75\1\46\1\174\15"+
		"\uffff\1\uffff\2\uffff\1\56\5\uffff\1\152\5\uffff\1\152\1\71\16\uffff"+
		"\1\uffff\4\uffff\1\152\1\71\1\152";
	static final String DFA2_acceptS =
		"\3\uffff\1\6\1\7\2\uffff\1\16\1\17\1\20\1\21\1\23\1\25\1\27\6\uffff\1"+
		"\46\1\47\1\50\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\uffff"+
		"\1\1\1\3\1\uffff\1\22\1\24\1\26\1\30\1\31\1\uffff\1\51\2\11\1\12\1\13"+
		"\2\uffff\1\14\1\15\1\32\1\45\1\33\1\40\1\35\1\34\1\37\1\36\1\42\1\41\1"+
		"\44\1\43\1\uffff\1\2\1\4\1\5\1\10\3\uffff";
	static final String DFA2_specialS =
		"\1\2\1\3\3\uffff\1\1\33\uffff\1\4\2\uffff\1\5\33\uffff\1\0\7\uffff}>";
	static final String[] DFA2_transitionS = {
			"\11\40\1\3\1\4\2\40\1\4\22\40\1\3\1\37\3\40\1\1\1\22\1\5\1\27\1\30\1"+
			"\12\1\10\1\24\1\11\1\2\1\13\12\6\1\26\1\25\1\20\1\16\1\21\1\36\1\35\32"+
			"\7\1\31\1\14\1\32\1\15\2\40\32\7\1\33\1\23\1\34\1\17\uff81\40",
			"\1\41",
			"\1\51\2\uffff\1\45\3\uffff\1\44\1\46\12\52\42\uffff\1\47\1\uffff\1\50",
			"",
			"",
			"\12\55\1\uffff\2\55\1\uffff\31\55\1\54\uffd8\55",
			"\1\60\1\uffff\12\6\12\uffff\2\61\36\uffff\2\61\3\uffff\2\63",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\64",
			"\1\66",
			"\1\70",
			"\1\72",
			"\1\74",
			"\1\76",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\11\101\1\100\1\102\2\101\1\102\22\101\1\100\uffdf\101",
			"",
			"",
			"\1\103",
			"",
			"",
			"",
			"",
			"",
			"\12\52\12\uffff\2\61\36\uffff\2\61\3\uffff\2\63",
			"",
			"",
			"",
			"",
			"",
			"\12\105\12\uffff\2\61\36\uffff\2\61\3\uffff\2\63",
			"\1\106\1\uffff\1\106\2\uffff\12\107",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\11\101\1\100\1\102\2\101\1\102\22\101\1\100\uffdf\101",
			"",
			"",
			"",
			"",
			"\12\105\12\uffff\2\61\36\uffff\2\61\3\uffff\2\63",
			"\12\107",
			"\12\107\57\uffff\2\63"
	};

	static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
	static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
	static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
	static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
	static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
	static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
	static final short[][] DFA2_transition;

	static {
		int numStates = DFA2_transitionS.length;
		DFA2_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
		}
	}

	protected class DFA2 extends DFA {

		public DFA2(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 2;
			this.eot = DFA2_eot;
			this.eof = DFA2_eof;
			this.min = DFA2_min;
			this.max = DFA2_max;
			this.accept = DFA2_accept;
			this.special = DFA2_special;
			this.transition = DFA2_transition;
		}
		@Override
		public String getDescription() {
			return "51:10: fragment DEFAULT_MODE : ( LINECOMMENT1 | LINECOMMENT2 | LINECOMMENT3 | BLOCKCOMMENT | ELLIPSIS | SPACES | EOL | DOTDOT | ( STRING )=> STRING | QUOTATION | CTRANS | REAL | IMAGINARY | ID | PLUS | MINUS | MTIMES | TIMES | MRDIV | RDIV | MLDIV | LDIV | MPOW | POW | TRANS | EQ | NOTEQ | LT | LTEQ | GT | GTEQ | NOT | AND | SHORTAND | OR | SHORTOR | ASSIGN | COMMA | SEMICOLON | COLON | DOT | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | AT | QUESTION | EXCLAMATION | UNKNOWN );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA2_64 = input.LA(1);
						 
						int index2_64 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA2_64 >= '\u0000' && LA2_64 <= '\b')||(LA2_64 >= '\u000B' && LA2_64 <= '\f')||(LA2_64 >= '\u000E' && LA2_64 <= '\u001F')||(LA2_64 >= '!' && LA2_64 <= '\uFFFF')) && ((Spaces_SpacesPrecedeInLine()))) {s = 65;}
						else if ( (LA2_64=='\t'||LA2_64==' ') && ((Spaces_SpacesPrecedeInLine()))) {s = 64;}
						else if ( (LA2_64=='\n'||LA2_64=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 66;}
						 
						input.seek(index2_64);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA2_5 = input.LA(1);
						 
						int index2_5 = input.index();
						input.rewind();
						s = -1;
						if ( (LA2_5=='\'') && ((synpred1_MatlabLexer()&&(!Quotation_TransposeIsEnabled())))) {s = 44;}
						else if ( ((LA2_5 >= '\u0000' && LA2_5 <= '\t')||(LA2_5 >= '\u000B' && LA2_5 <= '\f')||(LA2_5 >= '\u000E' && LA2_5 <= '&')||(LA2_5 >= '(' && LA2_5 <= '\uFFFF')) && ((synpred1_MatlabLexer()&&(!Quotation_TransposeIsEnabled())))) {s = 45;}
						else if ( ((!Quotation_TransposeIsEnabled())) ) {s = 46;}
						else if ( ((Quotation_TransposeIsEnabled())) ) {s = 47;}
						 
						input.seek(index2_5);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA2_0 = input.LA(1);
						 
						int index2_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA2_0=='%') && (((!Spaces_SpacesPrecedeInLine())||(Spaces_SpacesPrecedeInLine())))) {s = 1;}
						else if ( (LA2_0=='.') ) {s = 2;}
						else if ( (LA2_0=='\t'||LA2_0==' ') ) {s = 3;}
						else if ( (LA2_0=='\n'||LA2_0=='\r') ) {s = 4;}
						else if ( (LA2_0=='\'') && (((!Quotation_TransposeIsEnabled())||(Quotation_TransposeIsEnabled())))) {s = 5;}
						else if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {s = 6;}
						else if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {s = 7;}
						else if ( (LA2_0=='+') ) {s = 8;}
						else if ( (LA2_0=='-') ) {s = 9;}
						else if ( (LA2_0=='*') ) {s = 10;}
						else if ( (LA2_0=='/') ) {s = 11;}
						else if ( (LA2_0=='\\') ) {s = 12;}
						else if ( (LA2_0=='^') ) {s = 13;}
						else if ( (LA2_0=='=') ) {s = 14;}
						else if ( (LA2_0=='~') ) {s = 15;}
						else if ( (LA2_0=='<') ) {s = 16;}
						else if ( (LA2_0=='>') ) {s = 17;}
						else if ( (LA2_0=='&') ) {s = 18;}
						else if ( (LA2_0=='|') ) {s = 19;}
						else if ( (LA2_0==',') ) {s = 20;}
						else if ( (LA2_0==';') ) {s = 21;}
						else if ( (LA2_0==':') ) {s = 22;}
						else if ( (LA2_0=='(') ) {s = 23;}
						else if ( (LA2_0==')') ) {s = 24;}
						else if ( (LA2_0=='[') ) {s = 25;}
						else if ( (LA2_0==']') ) {s = 26;}
						else if ( (LA2_0=='{') ) {s = 27;}
						else if ( (LA2_0=='}') ) {s = 28;}
						else if ( (LA2_0=='@') ) {s = 29;}
						else if ( (LA2_0=='?') ) {s = 30;}
						else if ( (LA2_0=='!') ) {s = 31;}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\b')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\u001F')||(LA2_0 >= '\"' && LA2_0 <= '$')||(LA2_0 >= '_' && LA2_0 <= '`')||(LA2_0 >= '\u007F' && LA2_0 <= '\uFFFF')) ) {s = 32;}
						 
						input.seek(index2_0);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA2_1 = input.LA(1);
						 
						int index2_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA2_1=='{') && ((Spaces_SpacesPrecedeInLine()))) {s = 33;}
						else if ( ((!Spaces_SpacesPrecedeInLine())) ) {s = 34;}
						else if ( ((Spaces_SpacesPrecedeInLine())) ) {s = 35;}
						 
						input.seek(index2_1);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA2_33 = input.LA(1);
						 
						int index2_33 = input.index();
						input.rewind();
						s = -1;
						if ( (LA2_33=='\t'||LA2_33==' ') && ((Spaces_SpacesPrecedeInLine()))) {s = 64;}
						else if ( ((LA2_33 >= '\u0000' && LA2_33 <= '\b')||(LA2_33 >= '\u000B' && LA2_33 <= '\f')||(LA2_33 >= '\u000E' && LA2_33 <= '\u001F')||(LA2_33 >= '!' && LA2_33 <= '\uFFFF')) && ((Spaces_SpacesPrecedeInLine()))) {s = 65;}
						else if ( (LA2_33=='\n'||LA2_33=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 66;}
						 
						input.seek(index2_33);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA2_36 = input.LA(1);
						 
						int index2_36 = input.index();
						input.rewind();
						s = -1;
						if ( (LA2_36=='.') && ((Text_ThreeDotsFollow()))) {s = 67;}
						else s = 68;
						 
						input.seek(index2_36);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 2, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA3_eotS =
		"\2\uffff\1\17\13\uffff\1\17\5\uffff";
	static final String DFA3_eofS =
		"\24\uffff";
	static final String DFA3_minS =
		"\1\0\1\173\1\56\10\uffff\1\0\2\uffff\1\56\1\uffff\1\0\3\uffff";
	static final String DFA3_maxS =
		"\1\uffff\1\173\1\56\10\uffff\1\uffff\2\uffff\1\56\1\uffff\1\uffff\3\uffff";
	static final String DFA3_acceptS =
		"\3\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\16\1\uffff\1\1\1\3\1\uffff"+
		"\1\15\1\uffff\1\2\1\4\1\5";
	static final String DFA3_specialS =
		"\1\3\1\4\1\1\10\uffff\1\5\2\uffff\1\0\1\uffff\1\2\3\uffff}>";
	static final String[] DFA3_transitionS = {
			"\11\12\1\3\1\4\2\12\1\4\22\12\1\3\4\12\1\1\1\12\1\7\1\10\1\11\2\12\1"+
			"\5\1\12\1\2\14\12\1\6\37\12\1\10\1\12\1\11\35\12\1\10\1\12\1\11\uff82"+
			"\12",
			"\1\13",
			"\1\16",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\11\21\1\20\1\22\2\21\1\22\22\21\1\20\uffdf\21",
			"",
			"",
			"\1\23",
			"",
			"\11\21\1\20\1\22\2\21\1\22\22\21\1\20\uffdf\21",
			"",
			"",
			""
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	protected class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}
		@Override
		public String getDescription() {
			return "104:10: fragment COMMAND_MODE : ( LINECOMMENT1 | LINECOMMENT2 | LINECOMMENT3 | BLOCKCOMMENT | ELLIPSIS | SPACES | EOL | COMMA | SEMICOLON | STRINGBLOCK | DEFAULTBLOCK1 | DEFAULTBLOCK2 | DEFAULTBLOCK3 | DEFAULTBLOCK4 );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA3_14 = input.LA(1);
						 
						int index3_14 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_14=='.') && ((Text_ThreeDotsFollow()))) {s = 19;}
						else s = 15;
						 
						input.seek(index3_14);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA3_2 = input.LA(1);
						 
						int index3_2 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_2=='.') && (((Text_ThreeDotsFollow())||(!Text_ThreeDotsFollow())))) {s = 14;}
						else s = 15;
						 
						input.seek(index3_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA3_16 = input.LA(1);
						 
						int index3_16 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA3_16 >= '\u0000' && LA3_16 <= '\b')||(LA3_16 >= '\u000B' && LA3_16 <= '\f')||(LA3_16 >= '\u000E' && LA3_16 <= '\u001F')||(LA3_16 >= '!' && LA3_16 <= '\uFFFF')) && ((Spaces_SpacesPrecedeInLine()))) {s = 17;}
						else if ( (LA3_16=='\t'||LA3_16==' ') && ((Spaces_SpacesPrecedeInLine()))) {s = 16;}
						else if ( (LA3_16=='\n'||LA3_16=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 18;}
						 
						input.seek(index3_16);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA3_0 = input.LA(1);
						 
						int index3_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_0=='%') && (((!Spaces_SpacesPrecedeInLine())||(Spaces_SpacesPrecedeInLine())))) {s = 1;}
						else if ( (LA3_0=='.') && (((Text_ThreeDotsFollow())||(!Text_ThreeDotsFollow())))) {s = 2;}
						else if ( (LA3_0=='\t'||LA3_0==' ') ) {s = 3;}
						else if ( (LA3_0=='\n'||LA3_0=='\r') ) {s = 4;}
						else if ( (LA3_0==',') ) {s = 5;}
						else if ( (LA3_0==';') ) {s = 6;}
						else if ( (LA3_0=='\'') ) {s = 7;}
						else if ( (LA3_0=='('||LA3_0=='['||LA3_0=='{') ) {s = 8;}
						else if ( (LA3_0==')'||LA3_0==']'||LA3_0=='}') ) {s = 9;}
						else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\b')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\u001F')||(LA3_0 >= '!' && LA3_0 <= '$')||LA3_0=='&'||(LA3_0 >= '*' && LA3_0 <= '+')||LA3_0=='-'||(LA3_0 >= '/' && LA3_0 <= ':')||(LA3_0 >= '<' && LA3_0 <= 'Z')||LA3_0=='\\'||(LA3_0 >= '^' && LA3_0 <= 'z')||LA3_0=='|'||(LA3_0 >= '~' && LA3_0 <= '\uFFFF')) ) {s = 10;}
						 
						input.seek(index3_0);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA3_1 = input.LA(1);
						 
						int index3_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_1=='{') && ((Spaces_SpacesPrecedeInLine()))) {s = 11;}
						else if ( ((!Spaces_SpacesPrecedeInLine())) ) {s = 12;}
						else if ( ((Spaces_SpacesPrecedeInLine())) ) {s = 13;}
						 
						input.seek(index3_1);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA3_11 = input.LA(1);
						 
						int index3_11 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_11=='\t'||LA3_11==' ') && ((Spaces_SpacesPrecedeInLine()))) {s = 16;}
						else if ( ((LA3_11 >= '\u0000' && LA3_11 <= '\b')||(LA3_11 >= '\u000B' && LA3_11 <= '\f')||(LA3_11 >= '\u000E' && LA3_11 <= '\u001F')||(LA3_11 >= '!' && LA3_11 <= '\uFFFF')) && ((Spaces_SpacesPrecedeInLine()))) {s = 17;}
						else if ( (LA3_11=='\n'||LA3_11=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 18;}
						 
						input.seek(index3_11);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 3, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA29_eotS =
		"\24\uffff";
	static final String DFA29_eofS =
		"\24\uffff";
	static final String DFA29_minS =
		"\3\0\2\uffff\3\0\2\uffff\2\0\2\uffff\1\0\1\uffff\1\0\3\uffff";
	static final String DFA29_maxS =
		"\3\uffff\2\uffff\3\uffff\2\uffff\2\uffff\2\uffff\1\uffff\1\uffff\1\uffff"+
		"\3\uffff";
	static final String DFA29_acceptS =
		"\3\uffff\1\2\1\3\3\uffff\1\5\1\4\2\uffff\1\7\1\6\1\uffff\1\1\1\uffff\3"+
		"\1";
	static final String DFA29_specialS =
		"\1\10\1\6\1\0\2\uffff\1\1\1\7\1\2\2\uffff\1\3\1\11\2\uffff\1\4\1\uffff"+
		"\1\5\3\uffff}>";
	static final String[] DFA29_transitionS = {
			"\11\4\1\1\1\3\2\4\1\3\22\4\1\1\4\4\1\2\uffda\4",
			"\11\4\1\1\1\3\2\4\1\3\22\4\1\1\4\4\1\5\uffda\4",
			"\12\10\1\11\2\10\1\11\155\10\1\7\1\10\1\6\uff82\10",
			"",
			"",
			"\12\10\1\11\2\10\1\11\155\10\1\12\1\10\1\6\uff82\10",
			"\11\15\1\13\1\14\2\15\1\14\22\15\1\13\uffdf\15",
			"\11\15\1\16\1\17\2\15\1\17\22\15\1\16\uffdf\15",
			"",
			"",
			"\11\15\1\20\1\21\2\15\1\21\22\15\1\20\uffdf\15",
			"\11\15\1\13\1\14\2\15\1\14\22\15\1\13\uffdf\15",
			"",
			"",
			"\11\15\1\16\1\22\2\15\1\17\22\15\1\16\uffdf\15",
			"",
			"\11\15\1\20\1\23\2\15\1\21\22\15\1\20\uffdf\15",
			"",
			"",
			""
	};

	static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
	static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
	static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
	static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
	static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
	static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
	static final short[][] DFA29_transition;

	static {
		int numStates = DFA29_transitionS.length;
		DFA29_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
		}
	}

	protected class DFA29 extends DFA {

		public DFA29(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 29;
			this.eot = DFA29_eot;
			this.eof = DFA29_eof;
			this.min = DFA29_min;
			this.max = DFA29_max;
			this.accept = DFA29_accept;
			this.special = DFA29_special;
			this.transition = DFA29_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 154:25: ( ( WS )* BLOCKCOMMENT | ( WS )* EOL | ( WS )* ~ ( '%' | ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' EOL | ( WS )* '%' ~ ( '{' | '}' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL | ( WS )* '%' ( '{' | '}' ) ( WS )* ~ ( ' ' | '\\t' | '\\r' | '\\n' ) (~ ( '\\r' | '\\n' ) )* EOL )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA29_2 = input.LA(1);
						s = -1;
						if ( (LA29_2=='}') ) {s = 6;}
						else if ( (LA29_2=='{') ) {s = 7;}
						else if ( ((LA29_2 >= '\u0000' && LA29_2 <= '\t')||(LA29_2 >= '\u000B' && LA29_2 <= '\f')||(LA29_2 >= '\u000E' && LA29_2 <= 'z')||LA29_2=='|'||(LA29_2 >= '~' && LA29_2 <= '\uFFFF')) ) {s = 8;}
						else if ( (LA29_2=='\n'||LA29_2=='\r') ) {s = 9;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA29_5 = input.LA(1);
						s = -1;
						if ( (LA29_5=='}') ) {s = 6;}
						else if ( (LA29_5=='{') ) {s = 10;}
						else if ( ((LA29_5 >= '\u0000' && LA29_5 <= '\t')||(LA29_5 >= '\u000B' && LA29_5 <= '\f')||(LA29_5 >= '\u000E' && LA29_5 <= 'z')||LA29_5=='|'||(LA29_5 >= '~' && LA29_5 <= '\uFFFF')) ) {s = 8;}
						else if ( (LA29_5=='\n'||LA29_5=='\r') ) {s = 9;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA29_7 = input.LA(1);
						 
						int index29_7 = input.index();
						input.rewind();
						s = -1;
						if ( (LA29_7=='\t'||LA29_7==' ') ) {s = 14;}
						else if ( (LA29_7=='\n'||LA29_7=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 15;}
						else if ( ((LA29_7 >= '\u0000' && LA29_7 <= '\b')||(LA29_7 >= '\u000B' && LA29_7 <= '\f')||(LA29_7 >= '\u000E' && LA29_7 <= '\u001F')||(LA29_7 >= '!' && LA29_7 <= '\uFFFF')) ) {s = 13;}
						 
						input.seek(index29_7);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA29_10 = input.LA(1);
						s = -1;
						if ( (LA29_10=='\t'||LA29_10==' ') ) {s = 16;}
						else if ( (LA29_10=='\n'||LA29_10=='\r') ) {s = 17;}
						else if ( ((LA29_10 >= '\u0000' && LA29_10 <= '\b')||(LA29_10 >= '\u000B' && LA29_10 <= '\f')||(LA29_10 >= '\u000E' && LA29_10 <= '\u001F')||(LA29_10 >= '!' && LA29_10 <= '\uFFFF')) ) {s = 13;}
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA29_14 = input.LA(1);
						 
						int index29_14 = input.index();
						input.rewind();
						s = -1;
						if ( (LA29_14=='\r') && ((Spaces_SpacesPrecedeInLine()))) {s = 15;}
						else if ( (LA29_14=='\n') && ((Spaces_SpacesPrecedeInLine()))) {s = 18;}
						else if ( (LA29_14=='\t'||LA29_14==' ') ) {s = 14;}
						else if ( ((LA29_14 >= '\u0000' && LA29_14 <= '\b')||(LA29_14 >= '\u000B' && LA29_14 <= '\f')||(LA29_14 >= '\u000E' && LA29_14 <= '\u001F')||(LA29_14 >= '!' && LA29_14 <= '\uFFFF')) ) {s = 13;}
						 
						input.seek(index29_14);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA29_16 = input.LA(1);
						s = -1;
						if ( (LA29_16=='\r') ) {s = 17;}
						else if ( (LA29_16=='\n') ) {s = 19;}
						else if ( (LA29_16=='\t'||LA29_16==' ') ) {s = 16;}
						else if ( ((LA29_16 >= '\u0000' && LA29_16 <= '\b')||(LA29_16 >= '\u000B' && LA29_16 <= '\f')||(LA29_16 >= '\u000E' && LA29_16 <= '\u001F')||(LA29_16 >= '!' && LA29_16 <= '\uFFFF')) ) {s = 13;}
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA29_1 = input.LA(1);
						s = -1;
						if ( (LA29_1=='%') ) {s = 5;}
						else if ( (LA29_1=='\t'||LA29_1==' ') ) {s = 1;}
						else if ( (LA29_1=='\n'||LA29_1=='\r') ) {s = 3;}
						else if ( ((LA29_1 >= '\u0000' && LA29_1 <= '\b')||(LA29_1 >= '\u000B' && LA29_1 <= '\f')||(LA29_1 >= '\u000E' && LA29_1 <= '\u001F')||(LA29_1 >= '!' && LA29_1 <= '$')||(LA29_1 >= '&' && LA29_1 <= '\uFFFF')) ) {s = 4;}
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA29_6 = input.LA(1);
						s = -1;
						if ( (LA29_6=='\t'||LA29_6==' ') ) {s = 11;}
						else if ( (LA29_6=='\n'||LA29_6=='\r') ) {s = 12;}
						else if ( ((LA29_6 >= '\u0000' && LA29_6 <= '\b')||(LA29_6 >= '\u000B' && LA29_6 <= '\f')||(LA29_6 >= '\u000E' && LA29_6 <= '\u001F')||(LA29_6 >= '!' && LA29_6 <= '\uFFFF')) ) {s = 13;}
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA29_0 = input.LA(1);
						s = -1;
						if ( (LA29_0=='\t'||LA29_0==' ') ) {s = 1;}
						else if ( (LA29_0=='%') ) {s = 2;}
						else if ( (LA29_0=='\n'||LA29_0=='\r') ) {s = 3;}
						else if ( ((LA29_0 >= '\u0000' && LA29_0 <= '\b')||(LA29_0 >= '\u000B' && LA29_0 <= '\f')||(LA29_0 >= '\u000E' && LA29_0 <= '\u001F')||(LA29_0 >= '!' && LA29_0 <= '$')||(LA29_0 >= '&' && LA29_0 <= '\uFFFF')) ) {s = 4;}
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA29_11 = input.LA(1);
						s = -1;
						if ( (LA29_11=='\n'||LA29_11=='\r') ) {s = 12;}
						else if ( (LA29_11=='\t'||LA29_11==' ') ) {s = 11;}
						else if ( ((LA29_11 >= '\u0000' && LA29_11 <= '\b')||(LA29_11 >= '\u000B' && LA29_11 <= '\f')||(LA29_11 >= '\u000E' && LA29_11 <= '\u001F')||(LA29_11 >= '!' && LA29_11 <= '\uFFFF')) ) {s = 13;}
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 29, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
