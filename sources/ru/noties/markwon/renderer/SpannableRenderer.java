package ru.noties.markwon.renderer;

import org.commonmark.node.Node;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.SpannableStringBuilderImpl;

/* loaded from: classes6.dex */
public class SpannableRenderer {
    public static CharSequence getAuthRequestContext(SpannableConfiguration spannableConfiguration, Node node) {
        SpannableBuilder spannableBuilder = new SpannableBuilder();
        node.KClassImpl$Data$declaredNonStaticMembers$2(new SpannableMarkdownVisitor(spannableConfiguration, spannableBuilder));
        SpannableStringBuilderImpl spannableStringBuilderImpl = new SpannableStringBuilderImpl(spannableBuilder.getAuthRequestContext);
        for (SpannableBuilder.Span span : spannableBuilder.BuiltInFictitiousFunctionClassFactory) {
            spannableStringBuilderImpl.setSpan(span.PlaceComponentResult, span.BuiltInFictitiousFunctionClassFactory, span.getAuthRequestContext, span.MyBillsEntityDataFactory);
        }
        return spannableStringBuilderImpl;
    }
}
