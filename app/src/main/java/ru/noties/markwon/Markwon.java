package ru.noties.markwon;

import android.content.Context;
import java.util.Arrays;
import java.util.Iterator;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.internal.util.Substring;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.PostProcessor;
import org.commonmark.parser.block.BlockParser;
import ru.noties.markwon.renderer.SpannableRenderer;
import ru.noties.markwon.tasklist.TaskListExtension;

/* loaded from: classes6.dex */
public abstract class Markwon {
    public static CharSequence MyBillsEntityDataFactory(Context context, String str) {
        SpannableConfiguration BuiltInFictitiousFunctionClassFactory = SpannableConfiguration.BuiltInFictitiousFunctionClassFactory(context);
        Parser.Builder builder = new Parser.Builder();
        int i = 0;
        for (Extension extension : Arrays.asList(StrikethroughExtension.BuiltInFictitiousFunctionClassFactory(), TablesExtension.BuiltInFictitiousFunctionClassFactory(), TaskListExtension.KClassImpl$Data$declaredNonStaticMembers$2())) {
            if (extension instanceof Parser.ParserExtension) {
                ((Parser.ParserExtension) extension).BuiltInFictitiousFunctionClassFactory(builder);
            }
        }
        Parser parser = new Parser(builder, i == 1 ? (byte) 1 : (byte) 0);
        DocumentParser documentParser = new DocumentParser(parser.PlaceComponentResult, parser.MyBillsEntityDataFactory());
        while (true) {
            int BuiltInFictitiousFunctionClassFactory2 = Parsing.BuiltInFictitiousFunctionClassFactory(str, i);
            if (BuiltInFictitiousFunctionClassFactory2 == -1) {
                break;
            }
            documentParser.getAuthRequestContext(Substring.KClassImpl$Data$declaredNonStaticMembers$2(str, i, BuiltInFictitiousFunctionClassFactory2));
            i = BuiltInFictitiousFunctionClassFactory2 + 1;
            if (i < str.length() && str.charAt(BuiltInFictitiousFunctionClassFactory2) == '\r' && str.charAt(i) == '\n') {
                i = BuiltInFictitiousFunctionClassFactory2 + 2;
            }
        }
        if (str.length() > 0 && (i == 0 || i < str.length())) {
            documentParser.getAuthRequestContext(Substring.KClassImpl$Data$declaredNonStaticMembers$2(str, i, str.length()));
        }
        documentParser.KClassImpl$Data$declaredNonStaticMembers$2(documentParser.getAuthRequestContext);
        Iterator<BlockParser> it = documentParser.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().MyBillsEntityDataFactory(documentParser.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        Node node = documentParser.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        Iterator<PostProcessor> it2 = parser.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it2.hasNext()) {
            node = it2.next().BuiltInFictitiousFunctionClassFactory();
        }
        new SpannableRenderer();
        return SpannableRenderer.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, node);
    }

    private Markwon() {
    }
}
