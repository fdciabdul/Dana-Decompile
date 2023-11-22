package id.dana.core.ui.glide;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.svg.SvgLoader;

/* loaded from: classes4.dex */
public class ImageAttacherFactory {
    protected ImageAttacherStrategy PlaceComponentResult(String str, BaseImageAttacher.AdditionalData additionalData) {
        if (SvgLoader.getAuthRequestContext(str)) {
            return new ImageSvgAttacher(str, additionalData);
        }
        return new ImagePngAttacher(str, additionalData);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ImageView imageView, String str, int i) {
        ImageAttacherStrategy imageDrawableAttacher;
        if (!TextUtils.isEmpty(str)) {
            imageDrawableAttacher = PlaceComponentResult(str, null);
        } else {
            imageDrawableAttacher = new ImageDrawableAttacher(i, null);
        }
        imageDrawableAttacher.KClassImpl$Data$declaredNonStaticMembers$2(context, imageView);
    }

    public final void PlaceComponentResult(Context context, ImageView imageView, String str, int i, BaseImageAttacher.AdditionalData additionalData) {
        ImageAttacherStrategy imageDrawableAttacher;
        if (!TextUtils.isEmpty(str)) {
            imageDrawableAttacher = PlaceComponentResult(str, additionalData);
        } else {
            imageDrawableAttacher = new ImageDrawableAttacher(i, additionalData);
        }
        imageDrawableAttacher.KClassImpl$Data$declaredNonStaticMembers$2(context, imageView);
    }
}
