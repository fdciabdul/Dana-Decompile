package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ImageViewCompat {
    public static ColorStateList PlaceComponentResult(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            if (imageView instanceof TintableImageSourceView) {
                return ((TintableImageSourceView) imageView).getSupportImageTintList();
            }
            return null;
        }
        return imageView.getImageTintList();
    }

    public static void BuiltInFictitiousFunctionClassFactory(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(imageView, colorStateList);
            if (Build.VERSION.SDK_INT != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        } else if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode MyBillsEntityDataFactory(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.MyBillsEntityDataFactory(imageView);
        }
        if (imageView instanceof TintableImageSourceView) {
            return ((TintableImageSourceView) imageView).getSupportImageTintMode();
        }
        return null;
    }

    public static void getAuthRequestContext(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.MyBillsEntityDataFactory(imageView, mode);
            if (Build.VERSION.SDK_INT != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        } else if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        static PorterDuff.Mode MyBillsEntityDataFactory(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        static void MyBillsEntityDataFactory(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }
}
