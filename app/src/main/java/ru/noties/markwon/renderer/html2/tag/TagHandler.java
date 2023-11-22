package ru.noties.markwon.renderer.html2.tag;

import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public abstract class TagHandler {
    public abstract void MyBillsEntityDataFactory(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, HtmlTag htmlTag);

    /* JADX INFO: Access modifiers changed from: protected */
    public static void PlaceComponentResult(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, HtmlTag.Block block) {
        for (HtmlTag.Block block2 : block.lookAheadTest()) {
            if (block2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                TagHandler KClassImpl$Data$declaredNonStaticMembers$2 = spannableConfiguration.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(block2.getErrorConfigVersion());
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(spannableConfiguration, spannableBuilder, block2);
                } else {
                    PlaceComponentResult(spannableConfiguration, spannableBuilder, block2);
                }
            }
        }
    }
}
