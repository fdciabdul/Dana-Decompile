package org.commonmark.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class HeadingParser extends AbstractBlockParser {
    private static Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("^#{1,6}(?:[ \t]+|$)");
    private static Pattern KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("(^| ) *#+ *$");
    private static Pattern MyBillsEntityDataFactory = Pattern.compile("^(?:=+|-+) *$");
    private final Heading PlaceComponentResult;
    private final String getAuthRequestContext;

    public HeadingParser(int i, String str) {
        Heading heading = new Heading();
        this.PlaceComponentResult = heading;
        heading.getAuthRequestContext = i;
        this.getAuthRequestContext = str;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        return BlockContinue.MyBillsEntityDataFactory();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void MyBillsEntityDataFactory(InlineParser inlineParser) {
        inlineParser.MyBillsEntityDataFactory(this.getAuthRequestContext, this.PlaceComponentResult);
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.BuiltInFictitiousFunctionClassFactory() >= 4) {
                return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            CharSequence scheduleImpl = parserState.scheduleImpl();
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = parserState.NetworkUserEntityData$$ExternalSyntheticLambda0();
            CharSequence BuiltInFictitiousFunctionClassFactory = matchedBlockParser.BuiltInFictitiousFunctionClassFactory();
            Matcher matcher = HeadingParser.BuiltInFictitiousFunctionClassFactory.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length()));
            if (matcher.find()) {
                return BlockStart.BuiltInFictitiousFunctionClassFactory(new HeadingParser(matcher.group(0).trim().length(), HeadingParser.KClassImpl$Data$declaredNonStaticMembers$2.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0 + matcher.group(0).length(), scheduleImpl.length())).replaceAll(""))).KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl.length());
            }
            if (BuiltInFictitiousFunctionClassFactory != null) {
                Matcher matcher2 = HeadingParser.MyBillsEntityDataFactory.matcher(scheduleImpl.subSequence(NetworkUserEntityData$$ExternalSyntheticLambda0, scheduleImpl.length()));
                if (matcher2.find()) {
                    return BlockStart.BuiltInFictitiousFunctionClassFactory(new HeadingParser(matcher2.group(0).charAt(0) == '=' ? 1 : 2, BuiltInFictitiousFunctionClassFactory.toString())).KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl.length()).getAuthRequestContext();
                }
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
