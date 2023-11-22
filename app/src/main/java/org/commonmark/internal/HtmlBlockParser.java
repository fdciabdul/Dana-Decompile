package org.commonmark.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class HtmlBlockParser extends AbstractBlockParser {
    private static final Pattern[][] getAuthRequestContext = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(SimpleComparison.GREATER_THAN_OPERATION)}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    private final Pattern BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final HtmlBlock MyBillsEntityDataFactory;
    private BlockContent PlaceComponentResult;

    /* synthetic */ HtmlBlockParser(Pattern pattern, byte b) {
        this(pattern);
    }

    private HtmlBlockParser(Pattern pattern) {
        this.MyBillsEntityDataFactory = new HtmlBlock();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = new BlockContent();
        this.BuiltInFictitiousFunctionClassFactory = pattern;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return BlockContinue.MyBillsEntityDataFactory();
        }
        if (parserState.lookAheadTest() && this.BuiltInFictitiousFunctionClassFactory == null) {
            return BlockContinue.MyBillsEntityDataFactory();
        }
        return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        this.PlaceComponentResult.getAuthRequestContext(charSequence);
        Pattern pattern = this.BuiltInFictitiousFunctionClassFactory;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = this.PlaceComponentResult.PlaceComponentResult.toString();
        this.PlaceComponentResult = null;
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
            CharSequence scheduleImpl = parserState.scheduleImpl();
            if (parserState.BuiltInFictitiousFunctionClassFactory() < 4 && scheduleImpl.charAt(NetworkUserEntityData$$ExternalSyntheticLambda0) == '<') {
                for (int i = 1; i <= 7; i++) {
                    if (i != 7 || !(matchedBlockParser.MyBillsEntityDataFactory().MyBillsEntityDataFactory() instanceof Paragraph)) {
                        byte b = 0;
                        Pattern pattern = HtmlBlockParser.getAuthRequestContext[i][0];
                        Pattern pattern2 = HtmlBlockParser.getAuthRequestContext[i][1];
                        if (pattern.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length())).find()) {
                            return BlockStart.BuiltInFictitiousFunctionClassFactory(new HtmlBlockParser(pattern2, b)).KClassImpl$Data$declaredNonStaticMembers$2(parserState.MyBillsEntityDataFactory());
                        }
                    }
                }
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
