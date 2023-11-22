package org.commonmark.internal;

import id.dana.cashier.view.InputCardNumberView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class DocumentParser implements ParserState {
    private static final Map<Class<? extends Block>, BlockParserFactory> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final Set<Class<? extends Block>> PlaceComponentResult = new LinkedHashSet(Arrays.asList(BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class));
    public final InlineParser KClassImpl$Data$declaredNonStaticMembers$2;
    public final DocumentBlockParser MyBillsEntityDataFactory;
    private boolean getErrorConfigVersion;
    private CharSequence initRecordTimeStamp;
    private boolean lookAheadTest;
    private final List<BlockParserFactory> moveToNextValue;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private int scheduleImpl = 0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    private int DatabaseTableConfigUtil = 0;
    public List<BlockParser> getAuthRequestContext = new ArrayList();
    public Set<BlockParser> BuiltInFictitiousFunctionClassFactory = new HashSet();
    private Map<Node, Boolean> GetContactSyncConfig = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(BlockQuote.class, new BlockQuoteParser.Factory());
        hashMap.put(Heading.class, new HeadingParser.Factory());
        hashMap.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        hashMap.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        hashMap.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        hashMap.put(ListBlock.class, new ListBlockParser.Factory());
        hashMap.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        NetworkUserEntityData$$ExternalSyntheticLambda0 = Collections.unmodifiableMap(hashMap);
    }

    public DocumentParser(List<BlockParserFactory> list, InlineParser inlineParser) {
        this.moveToNextValue = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = inlineParser;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.MyBillsEntityDataFactory = documentBlockParser;
        this.getAuthRequestContext.add(documentBlockParser);
        this.BuiltInFictitiousFunctionClassFactory.add(documentBlockParser);
    }

    public static List<BlockParserFactory> PlaceComponentResult(List<BlockParserFactory> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<Class<? extends Block>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(NetworkUserEntityData$$ExternalSyntheticLambda0.get(it.next()));
        }
        return arrayList;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final CharSequence scheduleImpl() {
        return this.initRecordTimeStamp;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final int MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final int PlaceComponentResult() {
        return this.scheduleImpl;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final boolean lookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // org.commonmark.parser.block.ParserState
    public final BlockParser getAuthRequestContext() {
        return this.getAuthRequestContext.get(r0.size() - 1);
    }

    public final void getAuthRequestContext(CharSequence charSequence) {
        BlockStartImpl blockStartImpl;
        this.initRecordTimeStamp = Parsing.PlaceComponentResult(charSequence);
        boolean z = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.scheduleImpl = 0;
        this.getErrorConfigVersion = false;
        List<BlockParser> list = this.getAuthRequestContext;
        int i = 1;
        for (BlockParser blockParser : list.subList(1, list.size())) {
            GetContactSyncConfig();
            BlockContinue PlaceComponentResult2 = blockParser.PlaceComponentResult(this);
            if (!(PlaceComponentResult2 instanceof BlockContinueImpl)) {
                break;
            }
            BlockContinueImpl blockContinueImpl = (BlockContinueImpl) PlaceComponentResult2;
            if (blockContinueImpl.BuiltInFictitiousFunctionClassFactory()) {
                MyBillsEntityDataFactory(blockParser);
                return;
            }
            if (blockContinueImpl.BuiltInFictitiousFunctionClassFactory != -1) {
                BuiltInFictitiousFunctionClassFactory(blockContinueImpl.BuiltInFictitiousFunctionClassFactory);
            } else if (blockContinueImpl.PlaceComponentResult != -1) {
                getAuthRequestContext(blockContinueImpl.PlaceComponentResult);
            }
            i++;
        }
        List<BlockParser> list2 = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(list2.subList(i, list2.size()));
        BlockParser blockParser2 = this.getAuthRequestContext.get(i - 1);
        boolean isEmpty = arrayList.isEmpty();
        boolean z2 = (blockParser2.MyBillsEntityDataFactory() instanceof Paragraph) || blockParser2.PlaceComponentResult();
        BlockParser blockParser3 = blockParser2;
        while (z2) {
            GetContactSyncConfig();
            if (!lookAheadTest() && (this.DatabaseTableConfigUtil >= Parsing.KClassImpl$Data$declaredNonStaticMembers$2 || !Parsing.getAuthRequestContext(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1))) {
                MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser3);
                Iterator<BlockParserFactory> it = this.moveToNextValue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        blockStartImpl = null;
                        break;
                    }
                    BlockStart MyBillsEntityDataFactory = it.next().MyBillsEntityDataFactory(this, matchedBlockParserImpl);
                    if (MyBillsEntityDataFactory instanceof BlockStartImpl) {
                        blockStartImpl = (BlockStartImpl) MyBillsEntityDataFactory;
                        break;
                    }
                }
                if (blockStartImpl != null) {
                    if (!isEmpty) {
                        KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
                        isEmpty = true;
                    }
                    if (blockStartImpl.KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
                        BuiltInFictitiousFunctionClassFactory(blockStartImpl.KClassImpl$Data$declaredNonStaticMembers$2);
                    } else if (blockStartImpl.BuiltInFictitiousFunctionClassFactory != -1) {
                        getAuthRequestContext(blockStartImpl.BuiltInFictitiousFunctionClassFactory);
                    }
                    if (blockStartImpl.MyBillsEntityDataFactory()) {
                        List<BlockParser> list3 = this.getAuthRequestContext;
                        BlockParser blockParser4 = list3.get(list3.size() - 1);
                        List<BlockParser> list4 = this.getAuthRequestContext;
                        list4.remove(list4.size() - 1);
                        this.BuiltInFictitiousFunctionClassFactory.remove(blockParser4);
                        blockParser4.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda0();
                    }
                    BlockParser[] blockParserArr = blockStartImpl.MyBillsEntityDataFactory;
                    for (BlockParser blockParser5 : blockParserArr) {
                        blockParser3 = PlaceComponentResult(blockParser5);
                        z2 = blockParser5.PlaceComponentResult();
                    }
                }
            }
            BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            break;
        }
        if (!isEmpty && !lookAheadTest()) {
            List<BlockParser> list5 = this.getAuthRequestContext;
            if (list5.get(list5.size() - 1) instanceof ParagraphParser) {
                getErrorConfigVersion();
                return;
            }
        }
        if (!isEmpty) {
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        }
        if (lookAheadTest() && blockParser3.MyBillsEntityDataFactory().scheduleImpl != null) {
            this.GetContactSyncConfig.put(blockParser3.MyBillsEntityDataFactory().scheduleImpl, Boolean.TRUE);
        }
        Block MyBillsEntityDataFactory2 = blockParser3.MyBillsEntityDataFactory();
        if (lookAheadTest() && !(MyBillsEntityDataFactory2 instanceof BlockQuote) && !(MyBillsEntityDataFactory2 instanceof FencedCodeBlock) && (!(MyBillsEntityDataFactory2 instanceof ListItem) || MyBillsEntityDataFactory2.getErrorConfigVersion != null || blockParser3 == blockParser2)) {
            z = true;
        }
        for (Node MyBillsEntityDataFactory3 = blockParser3.MyBillsEntityDataFactory(); MyBillsEntityDataFactory3 != null; MyBillsEntityDataFactory3 = MyBillsEntityDataFactory3.getAuthRequestContext()) {
            this.GetContactSyncConfig.put(MyBillsEntityDataFactory3, Boolean.valueOf(z));
        }
        if (!blockParser3.PlaceComponentResult()) {
            getErrorConfigVersion();
        } else if (!lookAheadTest()) {
            PlaceComponentResult(new ParagraphParser());
            getErrorConfigVersion();
        }
    }

    private void GetContactSyncConfig() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i2 = this.scheduleImpl;
        this.lookAheadTest = true;
        while (true) {
            if (i >= this.initRecordTimeStamp.length()) {
                break;
            }
            char charAt = this.initRecordTimeStamp.charAt(i);
            if (charAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (charAt != ' ') {
                this.lookAheadTest = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i2;
        this.DatabaseTableConfigUtil = i2 - this.scheduleImpl;
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i >= i2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i2;
            this.scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        while (true) {
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (i3 >= i || i3 == this.initRecordTimeStamp.length()) {
                break;
            }
            moveToNextValue();
        }
        this.getErrorConfigVersion = false;
    }

    private void getAuthRequestContext(int i) {
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (i >= i2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.scheduleImpl = i2;
        }
        while (this.scheduleImpl < i && this.NetworkUserEntityData$$ExternalSyntheticLambda2 != this.initRecordTimeStamp.length()) {
            moveToNextValue();
        }
        if (this.scheduleImpl > i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2--;
            this.scheduleImpl = i;
            this.getErrorConfigVersion = true;
            return;
        }
        this.getErrorConfigVersion = false;
    }

    private void moveToNextValue() {
        if (this.initRecordTimeStamp.charAt(this.NetworkUserEntityData$$ExternalSyntheticLambda2) == '\t') {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2++;
            int i = this.scheduleImpl;
            this.scheduleImpl = i + Parsing.getAuthRequestContext(i);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2++;
        this.scheduleImpl++;
    }

    private void getErrorConfigVersion() {
        CharSequence subSequence;
        if (this.getErrorConfigVersion) {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            CharSequence charSequence = this.initRecordTimeStamp;
            CharSequence subSequence2 = charSequence.subSequence(i + 1, charSequence.length());
            int authRequestContext = Parsing.getAuthRequestContext(this.scheduleImpl);
            StringBuilder sb = new StringBuilder(subSequence2.length() + authRequestContext);
            for (int i2 = 0; i2 < authRequestContext; i2++) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(subSequence2);
            subSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.initRecordTimeStamp;
            subSequence = charSequence2.subSequence(this.NetworkUserEntityData$$ExternalSyntheticLambda2, charSequence2.length());
        }
        this.getAuthRequestContext.get(r1.size() - 1).PlaceComponentResult(subSequence);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Node node) {
        while (node != null) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(node)) {
                return true;
            }
            if (!(node instanceof ListBlock) && !(node instanceof ListItem)) {
                return false;
            }
            node = node.scheduleImpl;
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        Boolean bool = this.GetContactSyncConfig.get(node);
        return bool != null && bool.booleanValue();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(List<BlockParser> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            MyBillsEntityDataFactory(list.get(size));
        }
        return true;
    }

    /* loaded from: classes6.dex */
    public static class MatchedBlockParserImpl implements MatchedBlockParser {
        private final BlockParser getAuthRequestContext;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.getAuthRequestContext = blockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public final BlockParser MyBillsEntityDataFactory() {
            return this.getAuthRequestContext;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public final CharSequence BuiltInFictitiousFunctionClassFactory() {
            BlockParser blockParser = this.getAuthRequestContext;
            if (blockParser instanceof ParagraphParser) {
                return ((ParagraphParser) blockParser).getAuthRequestContext.PlaceComponentResult.toString();
            }
            return null;
        }
    }

    private <T extends BlockParser> T PlaceComponentResult(T t) {
        while (true) {
            if (!this.getAuthRequestContext.get(r0.size() - 1).PlaceComponentResult(t.MyBillsEntityDataFactory())) {
                MyBillsEntityDataFactory(this.getAuthRequestContext.get(r0.size() - 1));
            } else {
                this.getAuthRequestContext.get(r0.size() - 1).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(t.MyBillsEntityDataFactory());
                this.getAuthRequestContext.add(t);
                this.BuiltInFictitiousFunctionClassFactory.add(t);
                return t;
            }
        }
    }

    private void MyBillsEntityDataFactory(BlockParser blockParser) {
        if (this.getAuthRequestContext.get(r0.size() - 1) == blockParser) {
            this.getAuthRequestContext.remove(r0.size() - 1);
        }
        blockParser.KClassImpl$Data$declaredNonStaticMembers$2();
        if (blockParser instanceof ParagraphParser) {
            InlineParser inlineParser = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (inlineParser instanceof ReferenceParser) {
                ((ParagraphParser) blockParser).PlaceComponentResult((ReferenceParser) inlineParser);
                return;
            }
        }
        if (blockParser instanceof ListBlockParser) {
            getAuthRequestContext((ListBlockParser) blockParser);
        }
    }

    private void getAuthRequestContext(ListBlockParser listBlockParser) {
        for (Node node = listBlockParser.PlaceComponentResult.getErrorConfigVersion; node != null; node = node.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (BuiltInFictitiousFunctionClassFactory(node) && node.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                listBlockParser.PlaceComponentResult.MyBillsEntityDataFactory = false;
                return;
            }
            for (Node node2 = node.getErrorConfigVersion; node2 != null; node2 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (BuiltInFictitiousFunctionClassFactory(node2) && (node.NetworkUserEntityData$$ExternalSyntheticLambda0 != null || node2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null)) {
                    listBlockParser.PlaceComponentResult.MyBillsEntityDataFactory = false;
                    break;
                }
            }
        }
    }
}
