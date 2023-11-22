package ru.noties.markwon.renderer.html2.tag;

import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public class HeadingHandler extends SimpleTagHandler {
    private final int MyBillsEntityDataFactory;

    public HeadingHandler(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // ru.noties.markwon.renderer.html2.tag.SimpleTagHandler
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableConfiguration spannableConfiguration, HtmlTag htmlTag) {
        return spannableConfiguration.MyBillsEntityDataFactory.getAuthRequestContext(spannableConfiguration.scheduleImpl, this.MyBillsEntityDataFactory);
    }
}
