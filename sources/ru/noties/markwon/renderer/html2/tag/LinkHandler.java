package ru.noties.markwon.renderer.html2.tag;

import android.text.TextUtils;
import com.caverock.androidsvg.SVGParser;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public class LinkHandler extends SimpleTagHandler {
    @Override // ru.noties.markwon.renderer.html2.tag.SimpleTagHandler
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableConfiguration spannableConfiguration, HtmlTag htmlTag) {
        String str = htmlTag.BuiltInFictitiousFunctionClassFactory().get(SVGParser.XML_STYLESHEET_ATTR_HREF);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return spannableConfiguration.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(spannableConfiguration.scheduleImpl, spannableConfiguration.lookAheadTest.PlaceComponentResult(str), spannableConfiguration.moveToNextValue);
    }
}
