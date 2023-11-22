package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R;

/* loaded from: classes.dex */
public final class ViewGroupCompat {
    private ViewGroupCompat() {
    }

    public static int PlaceComponentResult(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.getAuthRequestContext(viewGroup);
        }
        return 0;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext(viewGroup);
        }
        Boolean bool = (Boolean) viewGroup.getTag(R.id.isAuth);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.getCallingPid(viewGroup) == null) ? false : true;
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static int getAuthRequestContext(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static boolean getAuthRequestContext(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }
}
