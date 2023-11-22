package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes3.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator PlaceComponentResult(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(path);
        }
        return new PathInterpolatorApi14(path);
    }

    public static Interpolator KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext(f, f2, f3, f4);
        }
        return new PathInterpolatorApi14(f, f2, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static PathInterpolator PlaceComponentResult(Path path) {
            return new PathInterpolator(path);
        }

        static PathInterpolator getAuthRequestContext(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }
    }
}
