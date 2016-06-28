package Matlab.Recognizer;

import Matlab.DotNet.*;
import org.antlr.runtime.*;
import java.util.function.*;

abstract class MatlabLexerBase extends Lexer
{
    // region CONSTRUCTORS:

    protected MatlabLexerBase()
    {
        super();
    }

    protected MatlabLexerBase(CharStream input)
    {
        super(input);
    }

    protected MatlabLexerBase(CharStream input, RecognizerSharedState state)
    {
        super(input, state);
    }

    // endregion

    // region GROUP MEMBERS:

    // region MACHINE GROUP:

    protected int machine_TokenType = Integer.MIN_VALUE;

    protected Channel machine_TokenChannel = Channel.Default;

    protected Mode machine_LexerMode = Mode.Default;

    protected void Machine_Update(int tokenType, Channel tokenChannel, Mode lexerMode) { throw new DotNetNotImplementedException(); }

    protected void Machine_Update(String text, int tokenType, Channel tokenChannel, Mode lexerMode) { throw new DotNetNotImplementedException(); }

    protected boolean Machine_InMode(Mode mode) { throw new DotNetNotImplementedException(); }

    // endregion

    // region LINE GROUP:

    protected boolean Line_StartPrecedes() { throw new DotNetNotImplementedException(); }

    protected boolean Line_EndFollows() { throw new DotNetNotImplementedException(); }

    // endregion

    // region SPACES GROUP:

    protected boolean Spaces_SpacesPrecedeInLine() { throw new DotNetNotImplementedException(); }
    // endregion

    // region TEXT GROUP:

    protected boolean Text_TextFollows(String text) { throw new DotNetNotImplementedException(); }

    protected boolean Text_ThreeDotsFollow() { throw new DotNetNotImplementedException(); }

    protected boolean Text_TwoDotsAndNoDotFollow() { throw new DotNetNotImplementedException(); }

    // endregion

    // region QUOTATION GROUP:

    protected DotNetList<Token> quotation_MeaningfulTokenList = new DotNetList<Token>();

    protected void Quotation_AddTokenIfMeaningful(Token token) { throw new DotNetNotImplementedException(); }

    protected int Quotation_FindLastOrDefaultIndex(int upToIndex, Predicate<Token> predicate) { throw new DotNetNotImplementedException(); }

    protected boolean Quotation_TransposeIsEnabledAfterKeyword(int keywordIndex) { throw new DotNetNotImplementedException(); }

    protected boolean Quotation_TransposeIsEnabledAfterClosingParenthesis(int closingParenthesisIndex) { throw new DotNetNotImplementedException(); }

    protected boolean Quotation_TransposeIsEnabled() { throw new DotNetNotImplementedException(); }

    // endregion

    // endregion
}
