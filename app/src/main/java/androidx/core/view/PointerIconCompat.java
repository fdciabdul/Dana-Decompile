package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public final class PointerIconCompat {
    private final PointerIcon KClassImpl$Data$declaredNonStaticMembers$2;

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pointerIcon;
    }

    public final Object PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static PointerIconCompat PlaceComponentResult(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(Api24Impl.PlaceComponentResult(context, i));
        }
        return new PointerIconCompat(null);
    }

    /* loaded from: classes3.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static PointerIcon PlaceComponentResult(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }
    }
}
