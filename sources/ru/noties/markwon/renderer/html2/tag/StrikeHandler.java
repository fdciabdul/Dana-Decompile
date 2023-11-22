package ru.noties.markwon.renderer.html2.tag;

import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public class StrikeHandler extends TagHandler {
    @Override // ru.noties.markwon.renderer.html2.tag.TagHandler
    public final void MyBillsEntityDataFactory(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        if (htmlTag.getAuthRequestContext()) {
            PlaceComponentResult(spannableConfiguration, spannableBuilder, htmlTag.PlaceComponentResult());
        }
        SpannableBuilder.PlaceComponentResult(spannableBuilder, spannableConfiguration.MyBillsEntityDataFactory.getAuthRequestContext(), htmlTag.moveToNextValue(), htmlTag.MyBillsEntityDataFactory());
    }
}
