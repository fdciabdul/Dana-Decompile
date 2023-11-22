package ru.noties.markwon.renderer.html2.tag;

import android.text.TextUtils;
import com.alipay.mobile.zebra.data.ZebraData;
import java.util.Map;
import ru.noties.markwon.renderer.ImageSize;
import ru.noties.markwon.renderer.html2.CssInlineStyleParser;
import ru.noties.markwon.renderer.html2.CssProperty;
import ru.noties.markwon.renderer.html2.tag.ImageHandler;

/* loaded from: classes6.dex */
class ImageSizeParserImpl implements ImageHandler.ImageSizeParser {
    private final CssInlineStyleParser KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSizeParserImpl(CssInlineStyleParser cssInlineStyleParser) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cssInlineStyleParser;
    }

    @Override // ru.noties.markwon.renderer.html2.tag.ImageHandler.ImageSizeParser
    public final ImageSize KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map) {
        ImageSize.Dimension dimension;
        ImageSize.Dimension dimension2;
        String str = map.get(ZebraData.ATTR_STYLE);
        if (!TextUtils.isEmpty(str)) {
            dimension = null;
            dimension2 = null;
            for (CssProperty cssProperty : this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(str)) {
                String str2 = cssProperty.getAuthRequestContext;
                if (ZebraData.ATTR_WIDTH.equals(str2)) {
                    dimension = MyBillsEntityDataFactory(cssProperty.PlaceComponentResult);
                } else if (ZebraData.ATTR_HEIGHT.equals(str2)) {
                    dimension2 = MyBillsEntityDataFactory(cssProperty.PlaceComponentResult);
                }
                if (dimension != null && dimension2 != null) {
                    break;
                }
            }
        } else {
            dimension = null;
            dimension2 = null;
        }
        if (dimension == null || dimension2 == null) {
            if (dimension == null) {
                dimension = MyBillsEntityDataFactory(map.get(ZebraData.ATTR_WIDTH));
            }
            if (dimension2 == null) {
                dimension2 = MyBillsEntityDataFactory(map.get(ZebraData.ATTR_HEIGHT));
            }
            if (dimension == null && dimension2 == null) {
                return null;
            }
            return new ImageSize(dimension, dimension2);
        }
        return new ImageSize(dimension, dimension2);
    }

    private static ImageSize.Dimension MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i = length - 1;
        int i2 = i;
        while (i2 >= 0) {
            if (Character.isDigit(str.charAt(i2))) {
                int i3 = i2 + 1;
                try {
                    return new ImageSize.Dimension(Float.parseFloat(str.substring(0, i3)), i2 == i ? null : str.substring(i3, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i2--;
        }
        return null;
    }
}
