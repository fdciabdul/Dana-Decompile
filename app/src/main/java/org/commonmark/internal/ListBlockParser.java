package org.commonmark.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class ListBlockParser extends AbstractBlockParser {
    private static Pattern getAuthRequestContext = Pattern.compile("^([*+-])(?= |\t|$)|^(\\d{1,9})([.)])(?= |\t|$)");
    final ListBlock PlaceComponentResult;

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult() {
        return true;
    }

    public ListBlockParser(ListBlock listBlock) {
        this.PlaceComponentResult = listBlock;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult(Block block) {
        return block instanceof ListItem;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return PlaceComponentResult(Character.valueOf(((BulletList) listBlock).KClassImpl$Data$declaredNonStaticMembers$2()), Character.valueOf(((BulletList) listBlock2).KClassImpl$Data$declaredNonStaticMembers$2()));
        }
        if ((listBlock instanceof OrderedList) && (listBlock2 instanceof OrderedList)) {
            return PlaceComponentResult(Character.valueOf(((OrderedList) listBlock).KClassImpl$Data$declaredNonStaticMembers$2()), Character.valueOf(((OrderedList) listBlock2).KClassImpl$Data$declaredNonStaticMembers$2()));
        }
        return false;
    }

    private static boolean PlaceComponentResult(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser MyBillsEntityDataFactory = matchedBlockParser.MyBillsEntityDataFactory();
            if (parserState.BuiltInFictitiousFunctionClassFactory() >= Parsing.KClassImpl$Data$declaredNonStaticMembers$2 && !(MyBillsEntityDataFactory instanceof ListBlockParser)) {
                return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            ListData KClassImpl$Data$declaredNonStaticMembers$2 = ListBlockParser.KClassImpl$Data$declaredNonStaticMembers$2(parserState.scheduleImpl(), parserState.NetworkUserEntityData$$ExternalSyntheticLambda0(), parserState.PlaceComponentResult() + parserState.BuiltInFictitiousFunctionClassFactory(), matchedBlockParser.BuiltInFictitiousFunctionClassFactory() != null);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            int i = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            ListItemParser listItemParser = new ListItemParser(i - parserState.PlaceComponentResult());
            if (!(MyBillsEntityDataFactory instanceof ListBlockParser) || !ListBlockParser.PlaceComponentResult((ListBlock) MyBillsEntityDataFactory.MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult)) {
                ListBlockParser listBlockParser = new ListBlockParser(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
                listBlockParser.PlaceComponentResult.MyBillsEntityDataFactory = true;
                return BlockStart.BuiltInFictitiousFunctionClassFactory(listBlockParser, listItemParser).PlaceComponentResult(i);
            }
            return BlockStart.BuiltInFictitiousFunctionClassFactory(listItemParser).PlaceComponentResult(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ListData {
        final int BuiltInFictitiousFunctionClassFactory;
        final ListBlock PlaceComponentResult;

        ListData(ListBlock listBlock, int i) {
            this.PlaceComponentResult = listBlock;
            this.BuiltInFictitiousFunctionClassFactory = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ListData KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2, boolean z) {
        OrderedList orderedList;
        Matcher matcher = getAuthRequestContext.matcher(charSequence.subSequence(i, charSequence.length()));
        if (matcher.find()) {
            String group = matcher.group(1);
            boolean z2 = false;
            if (group != null) {
                BulletList bulletList = new BulletList();
                bulletList.getAuthRequestContext = group.charAt(0);
                orderedList = bulletList;
            } else {
                String group2 = matcher.group(2);
                String group3 = matcher.group(3);
                OrderedList orderedList2 = new OrderedList();
                orderedList2.getAuthRequestContext = Integer.parseInt(group2);
                orderedList2.KClassImpl$Data$declaredNonStaticMembers$2 = group3.charAt(0);
                orderedList = orderedList2;
            }
            int end = matcher.end() - matcher.start();
            int i3 = i + end;
            int i4 = i2 + end;
            int i5 = i4;
            while (true) {
                if (i3 >= charSequence.length()) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                if (charAt != '\t') {
                    if (charAt != ' ') {
                        z2 = true;
                        break;
                    }
                    i5++;
                } else {
                    i5 += Parsing.getAuthRequestContext(i5);
                }
                i3++;
            }
            if (!z || ((!(orderedList instanceof OrderedList) || orderedList.getAuthRequestContext == 1) && z2)) {
                if (!z2 || i5 - i4 > Parsing.KClassImpl$Data$declaredNonStaticMembers$2) {
                    i5 = i4 + 1;
                }
                return new ListData(orderedList, i5);
            }
            return null;
        }
        return null;
    }
}
