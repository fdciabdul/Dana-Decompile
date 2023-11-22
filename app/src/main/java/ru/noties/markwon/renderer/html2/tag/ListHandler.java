package ru.noties.markwon.renderer.html2.tag;

import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public class ListHandler extends TagHandler {
    @Override // ru.noties.markwon.renderer.html2.tag.TagHandler
    public final void MyBillsEntityDataFactory(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        int i;
        Object KClassImpl$Data$declaredNonStaticMembers$2;
        if (htmlTag.getAuthRequestContext()) {
            HtmlTag.Block PlaceComponentResult = htmlTag.PlaceComponentResult();
            boolean equals = "ol".equals(PlaceComponentResult.getErrorConfigVersion());
            boolean equals2 = "ul".equals(PlaceComponentResult.getErrorConfigVersion());
            if (equals || equals2) {
                int i2 = 0;
                HtmlTag.Block block = PlaceComponentResult;
                while (true) {
                    block = block.scheduleImpl();
                    if (block == null) {
                        break;
                    } else if ("ul".equals(block.getErrorConfigVersion()) || "ol".equals(block.getErrorConfigVersion())) {
                        i2++;
                    }
                }
                int i3 = 1;
                for (HtmlTag.Block block2 : PlaceComponentResult.lookAheadTest()) {
                    PlaceComponentResult(spannableConfiguration, spannableBuilder, block2);
                    if ("li".equals(block2.getErrorConfigVersion())) {
                        if (equals) {
                            i = i3 + 1;
                            KClassImpl$Data$declaredNonStaticMembers$2 = spannableConfiguration.MyBillsEntityDataFactory.PlaceComponentResult(spannableConfiguration.scheduleImpl, i3);
                        } else {
                            i = i3;
                            KClassImpl$Data$declaredNonStaticMembers$2 = spannableConfiguration.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(spannableConfiguration.scheduleImpl, i2);
                        }
                        SpannableBuilder.PlaceComponentResult(spannableBuilder, KClassImpl$Data$declaredNonStaticMembers$2, block2.moveToNextValue(), block2.MyBillsEntityDataFactory());
                        i3 = i;
                    }
                }
            }
        }
    }
}
