package org.commonmark.ext.gfm.tables.internal;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Block;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Node;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class TableBlockParser extends AbstractBlockParser {
    private static Pattern BuiltInFictitiousFunctionClassFactory = null;
    private static String KClassImpl$Data$declaredNonStaticMembers$2 = "\\s*:?-{3,}:?\\s*";
    private boolean MyBillsEntityDataFactory;
    private final List<CharSequence> PlaceComponentResult;
    private final TableBlock getAuthRequestContext;
    private String moveToNextValue;

    /* synthetic */ TableBlockParser(CharSequence charSequence, byte b) {
        this(charSequence);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("\\|");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("\\|?\\s*|");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("\\|\\s*|\\|?(?:");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("\\|)+");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("\\|?\\s*");
        BuiltInFictitiousFunctionClassFactory = Pattern.compile(sb.toString());
    }

    private TableBlockParser(CharSequence charSequence) {
        this.getAuthRequestContext = new TableBlock();
        ArrayList arrayList = new ArrayList();
        this.PlaceComponentResult = arrayList;
        this.MyBillsEntityDataFactory = true;
        this.moveToNextValue = "";
        arrayList.add(charSequence);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        if (parserState.scheduleImpl().toString().contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
        }
        return BlockContinue.MyBillsEntityDataFactory();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
        if (this.MyBillsEntityDataFactory) {
            this.MyBillsEntityDataFactory = false;
            this.moveToNextValue = charSequence.toString();
            return;
        }
        this.PlaceComponentResult.add(charSequence);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void MyBillsEntityDataFactory(InlineParser inlineParser) {
        CustomNode tableHead = new TableHead();
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(tableHead);
        List<String> authRequestContext = getAuthRequestContext(this.moveToNextValue);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = authRequestContext.iterator();
        while (true) {
            TableCell.Alignment alignment = null;
            if (!it.hasNext()) {
                break;
            }
            String trim = it.next().trim();
            boolean startsWith = trim.startsWith(":");
            boolean endsWith = trim.endsWith(":");
            if (startsWith && endsWith) {
                alignment = TableCell.Alignment.CENTER;
            } else if (startsWith) {
                alignment = TableCell.Alignment.LEFT;
            } else if (endsWith) {
                alignment = TableCell.Alignment.RIGHT;
            }
            arrayList.add(alignment);
        }
        Iterator<CharSequence> it2 = this.PlaceComponentResult.iterator();
        boolean z = true;
        int i = -1;
        while (it2.hasNext()) {
            List<String> authRequestContext2 = getAuthRequestContext(it2.next());
            Node tableRow = new TableRow();
            if (i == -1) {
                i = authRequestContext2.size();
            }
            int i2 = 0;
            while (i2 < i) {
                String str = i2 < authRequestContext2.size() ? authRequestContext2.get(i2) : "";
                TableCell.Alignment alignment2 = i2 < arrayList.size() ? (TableCell.Alignment) arrayList.get(i2) : null;
                TableCell tableCell = new TableCell();
                tableCell.MyBillsEntityDataFactory = z;
                tableCell.BuiltInFictitiousFunctionClassFactory = alignment2;
                inlineParser.MyBillsEntityDataFactory(str.trim(), tableCell);
                tableRow.KClassImpl$Data$declaredNonStaticMembers$2(tableCell);
                i2++;
            }
            tableHead.KClassImpl$Data$declaredNonStaticMembers$2(tableRow);
            if (z) {
                tableHead = new TableBody();
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(tableHead);
                z = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> getAuthRequestContext(CharSequence charSequence) {
        String trim = charSequence.toString().trim();
        if (trim.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            trim = trim.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (z) {
                sb.append(charAt);
                z = false;
            } else if (charAt == '\\') {
                sb.append(charAt);
                z = true;
            } else if (charAt == '|') {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(charAt);
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    /* loaded from: classes6.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public final BlockStart MyBillsEntityDataFactory(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            CharSequence scheduleImpl = parserState.scheduleImpl();
            CharSequence BuiltInFictitiousFunctionClassFactory = matchedBlockParser.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory != null && BuiltInFictitiousFunctionClassFactory.toString().contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) && !BuiltInFictitiousFunctionClassFactory.toString().contains("\n")) {
                CharSequence subSequence = scheduleImpl.subSequence(parserState.MyBillsEntityDataFactory(), scheduleImpl.length());
                if (TableBlockParser.BuiltInFictitiousFunctionClassFactory.matcher(subSequence).matches() && TableBlockParser.getAuthRequestContext(subSequence).size() >= TableBlockParser.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory).size()) {
                    return BlockStart.BuiltInFictitiousFunctionClassFactory(new TableBlockParser(BuiltInFictitiousFunctionClassFactory, (byte) 0)).KClassImpl$Data$declaredNonStaticMembers$2(parserState.MyBillsEntityDataFactory()).getAuthRequestContext();
                }
            }
            return BlockStart.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
