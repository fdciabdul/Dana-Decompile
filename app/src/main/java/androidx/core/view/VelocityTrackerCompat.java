package androidx.core.view;

import android.view.VelocityTracker;

@Deprecated
/* loaded from: classes6.dex */
public final class VelocityTrackerCompat {
    @Deprecated
    public static float PlaceComponentResult(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    @Deprecated
    public static float getAuthRequestContext(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }

    private VelocityTrackerCompat() {
    }
}
