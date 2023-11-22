package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;

/* loaded from: classes6.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static void MyBillsEntityDataFactory(ScaleGestureDetector scaleGestureDetector, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }
    }

    /* loaded from: classes6.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }
}
