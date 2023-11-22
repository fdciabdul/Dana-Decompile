package id.dana.core.ui.util;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/core/ui/util/WindowManagerUtil;", "", "Landroid/app/Activity;", "p0", "Landroid/util/DisplayMetrics;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Landroid/util/DisplayMetrics;)V", "Landroid/view/WindowManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/WindowManager;Landroid/util/DisplayMetrics;)V", "Landroidx/fragment/app/FragmentActivity;", "Landroid/graphics/Point;", "PlaceComponentResult", "(Landroidx/fragment/app/FragmentActivity;)Landroid/graphics/Point;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WindowManagerUtil {
    public static final WindowManagerUtil INSTANCE = new WindowManagerUtil();

    private WindowManagerUtil() {
    }

    public static Point PlaceComponentResult(FragmentActivity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = p0.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "");
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "");
            Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "");
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                insetsIgnoringVisibility = Insets.max(insetsIgnoringVisibility, Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()));
                Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "");
            }
            return new Point(currentWindowMetrics.getBounds().width() - (insetsIgnoringVisibility.right + insetsIgnoringVisibility.left), currentWindowMetrics.getBounds().height() - (insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom));
        }
        Point point = new Point();
        p0.getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    public static void MyBillsEntityDataFactory(Activity p0, DisplayMetrics p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.BuiltInFictitiousFunctionClassFactory()) {
            p0.getWindowManager().getCurrentWindowMetrics();
        } else {
            p0.getWindowManager().getDefaultDisplay().getMetrics(p1);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(WindowManager p0, DisplayMetrics p1) {
        Display defaultDisplay;
        Rect bounds;
        Rect bounds2;
        Intrinsics.checkNotNullParameter(p1, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.BuiltInFictitiousFunctionClassFactory()) {
            if (p0 == null || (defaultDisplay = p0.getDefaultDisplay()) == null) {
                return;
            }
            defaultDisplay.getMetrics(p1);
            return;
        }
        WindowMetrics currentWindowMetrics = p0 != null ? p0.getCurrentWindowMetrics() : null;
        int i = 0;
        p1.heightPixels = (currentWindowMetrics == null || (bounds2 = currentWindowMetrics.getBounds()) == null) ? 0 : bounds2.height();
        if (currentWindowMetrics != null && (bounds = currentWindowMetrics.getBounds()) != null) {
            i = bounds.width();
        }
        p1.widthPixels = i;
    }
}
