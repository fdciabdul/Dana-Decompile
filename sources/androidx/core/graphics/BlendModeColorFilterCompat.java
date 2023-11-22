package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeUtils;

/* loaded from: classes3.dex */
public class BlendModeColorFilterCompat {
    public static ColorFilter MyBillsEntityDataFactory(int i, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object authRequestContext = BlendModeUtils.Api29Impl.getAuthRequestContext(blendModeCompat);
            if (authRequestContext != null) {
                return Api29Impl.MyBillsEntityDataFactory(i, authRequestContext);
            }
            return null;
        }
        PorterDuff.Mode MyBillsEntityDataFactory = BlendModeUtils.MyBillsEntityDataFactory(blendModeCompat);
        if (MyBillsEntityDataFactory != null) {
            return new PorterDuffColorFilter(i, MyBillsEntityDataFactory);
        }
        return null;
    }

    private BlendModeColorFilterCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static ColorFilter MyBillsEntityDataFactory(int i, Object obj) {
            return new BlendModeColorFilter(i, (BlendMode) obj);
        }
    }
}
