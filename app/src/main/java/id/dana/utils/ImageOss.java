package id.dana.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.alibaba.griver.image.framework.api.APImageFormat;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class ImageOss {
    private static final String[] BuiltInFictitiousFunctionClassFactory = {APImageFormat.SUFFIX_JPG, APImageFormat.SUFFIX_PNG, "bmp", APImageFormat.SUFFIX_GIF, APImageFormat.SUFFIX_WEBP, "tiff"};

    /* loaded from: classes5.dex */
    public interface EventListener {
        void PlaceComponentResult(String str, ImageView imageView);
    }

    private ImageOss() {
    }

    public static void MyBillsEntityDataFactory(final String str, final ImageView imageView, final EventListener eventListener) {
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.utils.ImageOss.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                EventListener.this.PlaceComponentResult(ImageOss.KClassImpl$Data$declaredNonStaticMembers$2(str, imageView), imageView);
                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, int i) {
        if (i <= 0 || i > 4096 || !PlaceComponentResult(str)) {
            return str;
        }
        return String.format(context.getString(id.dana.R.string.image_oss_resize_url_format), str, String.format(context.getString(id.dana.R.string.image_oss_width_param), String.valueOf(i)));
    }

    private static boolean PlaceComponentResult(String str) {
        if (str != null && BuiltInFictitiousFunctionClassFactory(str)) {
            String substring = str.substring(str.lastIndexOf(46) + 1);
            if (!TextUtils.isEmpty(substring) && KClassImpl$Data$declaredNonStaticMembers$2(substring)) {
                return true;
            }
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return (!str.contains(".") || str.indexOf(46) == 0 || str.lastIndexOf(46) == str.length() - 1) ? false : true;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return Arrays.asList(BuiltInFictitiousFunctionClassFactory).contains(str);
    }

    static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(String str, ImageView imageView) {
        return KClassImpl$Data$declaredNonStaticMembers$2(imageView.getContext(), str, imageView.getWidth());
    }
}
