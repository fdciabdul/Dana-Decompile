package at.wirecube.additiveanimations.helper;

import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* loaded from: classes3.dex */
public class EaseInOutPathInterpolator {
    public static Interpolator MyBillsEntityDataFactory() {
        return PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(0.25f, 0.1f, 0.25f, 1.0f);
    }
}
