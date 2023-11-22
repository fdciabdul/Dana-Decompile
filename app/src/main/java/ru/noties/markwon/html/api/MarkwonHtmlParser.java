package ru.noties.markwon.html.api;

import java.util.List;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public abstract class MarkwonHtmlParser {

    /* loaded from: classes6.dex */
    public interface FlushAction<T> {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<T> list);
    }

    public abstract void BuiltInFictitiousFunctionClassFactory();

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(int i, FlushAction<HtmlTag.Inline> flushAction);

    public abstract void getAuthRequestContext(int i, FlushAction<HtmlTag.Block> flushAction);

    public abstract <T extends Appendable & CharSequence> void getAuthRequestContext(T t, String str);

    public static MarkwonHtmlParser getAuthRequestContext() {
        return new MarkwonHtmlParserNoOp();
    }
}
