package Matlab.Recognizer;

import Matlab.DotNet.*;
import org.antlr.runtime.*;
import java.util.*;

abstract class MatlabParserBase extends Parser
{
    // region CONSTRUCTORS:

    protected MatlabParserBase(TokenStream input)
    {
        super(input);
    }

    protected MatlabParserBase(TokenStream input, RecognizerSharedState state)
    {
        super(input, state);
    }

    // endregion

    // region METHODS:

    // region BOOLEAN METHODS:

    protected boolean True()
    {
        return true;
    }

    protected boolean False()
    {
        return false;
    }

    // endregion

    // endregion

    // region GROUP MEMBERS:

    // region KEYWORD GROUP:

    protected boolean Keyword_EventsIdFollows() { throw new DotNetNotImplementedException(); }

    protected boolean Keyword_PropertiesIdFollows() { throw new DotNetNotImplementedException(); }

    protected boolean Keyword_MethodsIdFollows() { throw new DotNetNotImplementedException(); }

    protected boolean Keyword_EnumerationIdFollows() { throw new DotNetNotImplementedException(); }

    protected boolean Keyword_IdFollows(String keyword) { throw new DotNetNotImplementedException(); }

    // endregion

    // region COMMAND GROUP:

    protected static int[] command_SpecialOperatorsSet = { MatlabLexer.PLUS, MatlabLexer.MINUS, MatlabLexer.MTIMES, MatlabLexer.TIMES, MatlabLexer.MRDIV, MatlabLexer.RDIV, MatlabLexer.MLDIV, MatlabLexer.LDIV, MatlabLexer.MPOW, MatlabLexer.POW, MatlabLexer.EQ, MatlabLexer.NOTEQ, MatlabLexer.LT, MatlabLexer.LTEQ, MatlabLexer.GT, MatlabLexer.GTEQ, MatlabLexer.AND, MatlabLexer.SHORTAND, MatlabLexer.OR, MatlabLexer.SHORTOR, MatlabLexer.AT, MatlabLexer.COLON, MatlabLexer.EXCLAMATION };

    protected static int[] command_SpecialOperatorsFollowSet = { MatlabLexer.PLUS, MatlabLexer.MINUS, MatlabLexer.NOT, MatlabLexer.ID, MatlabLexer.REAL, MatlabLexer.IMAGINARY, MatlabLexer.STRING, MatlabLexer.LPAREN, MatlabLexer.LSQUARE, MatlabLexer.LCURLY, MatlabLexer.QUESTION, MatlabLexer.EXCLAMATION, MatlabLexer.BREAK, MatlabLexer.CASE, MatlabLexer.CATCH, MatlabLexer.CLASSDEF, MatlabLexer.CONTINUE, MatlabLexer.ELSE, MatlabLexer.ELSEIF, MatlabLexer.END, MatlabLexer.FOR, MatlabLexer.FUNCTION, MatlabLexer.GLOBAL, MatlabLexer.IF, MatlabLexer.OTHERWISE, MatlabLexer.PARFOR, MatlabLexer.PERSISTENT, MatlabLexer.RETURN, MatlabLexer.SPMD, MatlabLexer.SWITCH, MatlabLexer.TRY, MatlabLexer.WHILE };

    protected void Command_Mark() { throw new DotNetNotImplementedException(); }

    protected void Command_Abort() { throw new DotNetNotImplementedException(); }

    protected boolean Command_IsEnabled() { throw new DotNetNotImplementedException(); }

    // endregion

    // region SEPARATOR GROUP:

    protected boolean Separator_CommaFollowsOrSpacesPrecede() { throw new DotNetNotImplementedException(); }

    protected boolean Separator_SpacesPrecede() { throw new DotNetNotImplementedException(); }

    protected boolean Separator_EllipsisFollows() { throw new DotNetNotImplementedException(); }

    protected boolean Separator_EllipsisOrEolFollows() { throw new DotNetNotImplementedException(); }

    // endregion

    // region INDEX GROUP:

    protected Stack<IndexOperator> index_Stack = new Stack<IndexOperator>();

    protected IndexOperator Index_GetTop() { throw new DotNetNotImplementedException(); }

    protected void Index_EnterParenthesis() { throw new DotNetNotImplementedException(); }

    protected void Index_EnterCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Index_ExitParenthesis() { throw new DotNetNotImplementedException(); }

    protected void Index_ExitCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected boolean Index_IsActive() { throw new DotNetNotImplementedException(); }

    // endregion

    // region BALANCE GROUP:

    protected Stack<BalanceOperator> balance_Stack = new Stack<BalanceOperator>();

    protected void Balance_EnterCreationSquareBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_EnterCreationCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_EnterStorageSquareBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_EnterIndexCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_EnterParenthesis() { throw new DotNetNotImplementedException(); }

    protected void Balance_ExitCreationSquareBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_ExitCreationCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_ExitStorageSquareBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_ExitIndexCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Balance_ExitParenthesis() { throw new DotNetNotImplementedException(); }

    protected BalanceOperator Balance_GetTop() { throw new DotNetNotImplementedException(); }

    protected boolean Balance_TopIsCreationOrStoreOperator() { throw new DotNetNotImplementedException(); }

    protected boolean Balance_InCreationOrStore_SpacesOnLeftButNotOnRight() { throw new DotNetNotImplementedException(); }

    protected boolean Balance_InCreationOrStore_SpacesOnLeft() { throw new DotNetNotImplementedException(); }

    // endregion

    // region CHAIN GROUP:

    protected Stack<ChainOperator> chain_Stack = new Stack<ChainOperator>();

    protected void Chain_Begin() { throw new DotNetNotImplementedException(); }

    protected void Chain_End() { throw new DotNetNotImplementedException(); }

    protected void Chain_AddedParenthesis() { throw new DotNetNotImplementedException(); }

    protected void Chain_AddedCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected void Chain_AddedDotName() { throw new DotNetNotImplementedException(); }

    protected void Chain_AddedDotExpression() { throw new DotNetNotImplementedException(); }

    protected void Chain_AddedAtBase() { throw new DotNetNotImplementedException(); }

    protected ChainOperator Chain_GetTop() { throw new DotNetNotImplementedException(); }

    protected boolean Chain_MayAddParenthesis() { throw new DotNetNotImplementedException(); }

    protected boolean Chain_MayAddCurlyBrace() { throw new DotNetNotImplementedException(); }

    protected boolean Chain_MayAddDotName() { throw new DotNetNotImplementedException(); }

    protected boolean Chain_MayAddDotExpression() { throw new DotNetNotImplementedException(); }

    protected boolean Chain_MayAddAtBase() { throw new DotNetNotImplementedException(); }

    // endregion

    // region METHOD GROUP:

    protected boolean method_Signature = false;

    protected void Method_EnterSignature() { throw new DotNetNotImplementedException(); }

    protected void Method_ExitSignature() { throw new DotNetNotImplementedException(); }

    protected boolean Method_SignatureIsActive() { throw new DotNetNotImplementedException(); }

    // endregion

    // region TEXT GROUP:

    protected String Text_UnquoteString(String text) { throw new DotNetNotImplementedException(); }

    protected String Text_QuoteString(String text) { throw new DotNetNotImplementedException(); }

    // endregion

    // endregion
}
