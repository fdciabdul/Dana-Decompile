package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class TooltipCompat {
    public static void PlaceComponentResult(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 26) {
            TooltipCompatHandler.KClassImpl$Data$declaredNonStaticMembers$2(view, charSequence);
        } else {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }
    }
}
