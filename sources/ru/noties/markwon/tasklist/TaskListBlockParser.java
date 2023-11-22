package ru.noties.markwon.tasklist;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
class TaskListBlockParser extends AbstractBlockParser {
    private static final Pattern MyBillsEntityDataFactory = Pattern.compile("\\s*-\\s+\\[(x|X|\\s)\\]\\s+(.*)");
    private final List<Item> BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final TaskListBlock getAuthRequestContext = new TaskListBlock();

    TaskListBlockParser(String str, int i) {
        ArrayList arrayList = new ArrayList(3);
        this.BuiltInFictitiousFunctionClassFactory = arrayList;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        arrayList.add(new Item(str, i));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void MyBillsEntityDataFactory(InlineParser inlineParser) {
        for (Item item : this.BuiltInFictitiousFunctionClassFactory) {
            Matcher matcher = MyBillsEntityDataFactory.matcher(item.BuiltInFictitiousFunctionClassFactory);
            if (matcher.matches()) {
                TaskListItem taskListItem = new TaskListItem();
                taskListItem.MyBillsEntityDataFactory = getAuthRequestContext(matcher.group(1));
                taskListItem.BuiltInFictitiousFunctionClassFactory = item.getAuthRequestContext / 2;
                inlineParser.MyBillsEntityDataFactory(matcher.group(2), taskListItem);
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(taskListItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            String KClassImpl$Data$declaredNonStaticMembers$2 = TaskListBlockParser.KClassImpl$Data$declaredNonStaticMembers$2(parserState);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null && KClassImpl$Data$declaredNonStaticMembers$2.length() > 0 && TaskListBlockParser.MyBillsEntityDataFactory.matcher(KClassImpl$Data$declaredNonStaticMembers$2).matches()) {
                int length = KClassImpl$Data$declaredNonStaticMembers$2.length();
                int MyBillsEntityDataFactory = parserState.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory != 0) {
                    length = (length - MyBillsEntityDataFactory) + MyBillsEntityDataFactory;
                }
                return BlockStart.BuiltInFictitiousFunctionClassFactory(new TaskListBlockParser(KClassImpl$Data$declaredNonStaticMembers$2, parserState.BuiltInFictitiousFunctionClassFactory())).KClassImpl$Data$declaredNonStaticMembers$2(length);
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private static boolean getAuthRequestContext(String str) {
        return "X".equals(str) || "x".equals(str);
    }

    /* loaded from: classes6.dex */
    static class Item {
        final String BuiltInFictitiousFunctionClassFactory;
        final int getAuthRequestContext;

        Item(String str, int i) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = i;
        }
    }

    static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(ParserState parserState) {
        CharSequence scheduleImpl = parserState.scheduleImpl();
        if (scheduleImpl != null) {
            return scheduleImpl.toString();
        }
        return null;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        if ((charSequence != null ? charSequence.length() : 0) > 0) {
            this.BuiltInFictitiousFunctionClassFactory.add(new Item(charSequence.toString(), this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        CharSequence scheduleImpl = parserState.scheduleImpl();
        String charSequence = scheduleImpl != null ? scheduleImpl.toString() : null;
        int BuiltInFictitiousFunctionClassFactory = parserState.BuiltInFictitiousFunctionClassFactory();
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (BuiltInFictitiousFunctionClassFactory > i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 2;
        } else if (BuiltInFictitiousFunctionClassFactory < i && i > 1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i - 2;
        }
        if (charSequence != null && charSequence.length() > 0 && MyBillsEntityDataFactory.matcher(charSequence).matches()) {
            return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
        }
        return BlockContinue.MyBillsEntityDataFactory();
    }
}
