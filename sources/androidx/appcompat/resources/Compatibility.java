package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class Compatibility {
    private Compatibility() {
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static int BuiltInFictitiousFunctionClassFactory(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }
    }

    /* loaded from: classes.dex */
    public static class Api18Impl {
        private Api18Impl() {
        }

        public static void PlaceComponentResult(ObjectAnimator objectAnimator, boolean z) {
            objectAnimator.setAutoCancel(z);
        }
    }

    /* loaded from: classes.dex */
    public static class Api15Impl {
        private Api15Impl() {
        }

        public static void PlaceComponentResult(Resources resources, int i, int i2, TypedValue typedValue, boolean z) {
            resources.getValueForDensity(i, i2, typedValue, z);
        }
    }
}
