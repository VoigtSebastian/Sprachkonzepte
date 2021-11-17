// Generated from ExprLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FN=1, COMMA=2, SEMICOLON=3, QUOTATION_MARK=4, CURLY_BRACKET_OPEN=5, CURLY_BRACKET_CLOSED=6, 
		PARENTHESIS_OPEN=7, PARENTHESIS_CLOSED=8, VAL=9, ASSIGN=10, RETURN=11, 
		NUMBERS=12, STRING=13, IDENTIFIER=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FN", "COMMA", "SEMICOLON", "QUOTATION_MARK", "CURLY_BRACKET_OPEN", "CURLY_BRACKET_CLOSED", 
			"PARENTHESIS_OPEN", "PARENTHESIS_CLOSED", "VAL", "ASSIGN", "RETURN", 
			"NUMBERS", "STRING", "IDENTIFIER", "DIGIT", "LETTER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fn'", "','", "';'", "'\"'", "'{'", "'}'", "'('", "')'", "'val'", 
			"'='", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FN", "COMMA", "SEMICOLON", "QUOTATION_MARK", "CURLY_BRACKET_OPEN", 
			"CURLY_BRACKET_CLOSED", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSED", "VAL", 
			"ASSIGN", "RETURN", "NUMBERS", "STRING", "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21a\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\rE\n\r\r\r"+
		"\16\rF\3\16\3\16\7\16K\n\16\f\16\16\16N\13\16\3\16\3\16\3\17\6\17S\n\17"+
		"\r\17\16\17T\3\20\3\20\3\21\3\21\3\22\6\22\\\n\22\r\22\16\22]\3\22\3\22"+
		"\3L\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\2!\2#\21\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\2b\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5(\3\2\2\2\7*\3"+
		"\2\2\2\t,\3\2\2\2\13.\3\2\2\2\r\60\3\2\2\2\17\62\3\2\2\2\21\64\3\2\2\2"+
		"\23\66\3\2\2\2\25:\3\2\2\2\27<\3\2\2\2\31D\3\2\2\2\33H\3\2\2\2\35R\3\2"+
		"\2\2\37V\3\2\2\2!X\3\2\2\2#[\3\2\2\2%&\7h\2\2&\'\7p\2\2\'\4\3\2\2\2()"+
		"\7.\2\2)\6\3\2\2\2*+\7=\2\2+\b\3\2\2\2,-\7$\2\2-\n\3\2\2\2./\7}\2\2/\f"+
		"\3\2\2\2\60\61\7\177\2\2\61\16\3\2\2\2\62\63\7*\2\2\63\20\3\2\2\2\64\65"+
		"\7+\2\2\65\22\3\2\2\2\66\67\7x\2\2\678\7c\2\289\7n\2\29\24\3\2\2\2:;\7"+
		"?\2\2;\26\3\2\2\2<=\7t\2\2=>\7g\2\2>?\7v\2\2?@\7w\2\2@A\7t\2\2AB\7p\2"+
		"\2B\30\3\2\2\2CE\5\37\20\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\32"+
		"\3\2\2\2HL\7$\2\2IK\13\2\2\2JI\3\2\2\2KN\3\2\2\2LM\3\2\2\2LJ\3\2\2\2M"+
		"O\3\2\2\2NL\3\2\2\2OP\7$\2\2P\34\3\2\2\2QS\5!\21\2RQ\3\2\2\2ST\3\2\2\2"+
		"TR\3\2\2\2TU\3\2\2\2U\36\3\2\2\2VW\t\2\2\2W \3\2\2\2XY\t\3\2\2Y\"\3\2"+
		"\2\2Z\\\t\4\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b"+
		"\22\2\2`$\3\2\2\2\7\2FLT]\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}