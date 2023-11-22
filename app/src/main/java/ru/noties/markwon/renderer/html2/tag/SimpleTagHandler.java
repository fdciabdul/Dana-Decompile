package ru.noties.markwon.renderer.html2.tag;

import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public abstract class SimpleTagHandler extends TagHandler {
    public abstract Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableConfiguration spannableConfiguration, HtmlTag htmlTag);

    @Override // ru.noties.markwon.renderer.html2.tag.TagHandler
    public final void MyBillsEntityDataFactory(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        Object KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(spannableConfiguration, htmlTag);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            SpannableBuilder.PlaceComponentResult(spannableBuilder, KClassImpl$Data$declaredNonStaticMembers$2, htmlTag.moveToNextValue(), htmlTag.MyBillsEntityDataFactory());
        }
    }
}
