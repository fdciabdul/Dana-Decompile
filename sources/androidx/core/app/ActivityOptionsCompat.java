package androidx.core.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public Bundle MyBillsEntityDataFactory() {
        return null;
    }

    public static ActivityOptionsCompat PlaceComponentResult(Context context, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsCompatImpl(Api16Impl.getAuthRequestContext(context, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    /* loaded from: classes3.dex */
    static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions getAuthRequestContext;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.getAuthRequestContext = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle MyBillsEntityDataFactory() {
            return this.getAuthRequestContext.toBundle();
        }
    }

    protected ActivityOptionsCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static ActivityOptions getAuthRequestContext(Context context, int i, int i2) {
            return ActivityOptions.makeCustomAnimation(context, i, i2);
        }
    }

    /* loaded from: classes6.dex */
    static class Api23Impl {
        private Api23Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api21Impl {
        private Api21Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api24Impl {
        private Api24Impl() {
        }
    }
}
