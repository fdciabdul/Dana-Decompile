package ru.noties.markwon.renderer.html2.tag;

import android.text.TextUtils;
import java.util.Map;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;
import ru.noties.markwon.renderer.ImageSize;
import ru.noties.markwon.renderer.html2.CssInlineStyleParser;

/* loaded from: classes6.dex */
public class ImageHandler extends SimpleTagHandler {
    private final ImageSizeParser BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes6.dex */
    interface ImageSizeParser {
        ImageSize KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map);
    }

    public static ImageHandler MyBillsEntityDataFactory() {
        return new ImageHandler(new ImageSizeParserImpl(CssInlineStyleParser.BuiltInFictitiousFunctionClassFactory()));
    }

    private ImageHandler(ImageSizeParser imageSizeParser) {
        this.BuiltInFictitiousFunctionClassFactory = imageSizeParser;
    }

    @Override // ru.noties.markwon.renderer.html2.tag.SimpleTagHandler
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableConfiguration spannableConfiguration, HtmlTag htmlTag) {
        String str = htmlTag.BuiltInFictitiousFunctionClassFactory().get("src");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return spannableConfiguration.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(spannableConfiguration.scheduleImpl, spannableConfiguration.lookAheadTest.PlaceComponentResult(str), spannableConfiguration.KClassImpl$Data$declaredNonStaticMembers$2, spannableConfiguration.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(htmlTag.BuiltInFictitiousFunctionClassFactory()), false);
    }
}
