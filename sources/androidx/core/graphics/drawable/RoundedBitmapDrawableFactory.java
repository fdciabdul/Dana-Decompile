package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.view.GravityCompat;

/* loaded from: classes6.dex */
public final class RoundedBitmapDrawableFactory {

    /* loaded from: classes6.dex */
    static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void PlaceComponentResult(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, rect, rect2, 0);
        }
    }

    public static RoundedBitmapDrawable MyBillsEntityDataFactory(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RoundedBitmapDrawable21(resources, bitmap);
        }
        return new DefaultRoundedBitmapDrawable(resources, bitmap);
    }

    private RoundedBitmapDrawableFactory() {
    }
}
