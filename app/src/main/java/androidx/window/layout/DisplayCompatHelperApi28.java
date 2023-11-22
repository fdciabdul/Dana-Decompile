package androidx.window.layout;

import android.view.DisplayCutout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006"}, d2 = {"Landroidx/window/layout/DisplayCompatHelperApi28;", "", "Landroid/view/DisplayCutout;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/DisplayCutout;)I", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DisplayCompatHelperApi28 {
    public static final DisplayCompatHelperApi28 INSTANCE = new DisplayCompatHelperApi28();

    private DisplayCompatHelperApi28() {
    }

    public final int PlaceComponentResult(DisplayCutout p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.getSafeInsetLeft();
    }

    public final int MyBillsEntityDataFactory(DisplayCutout p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.getSafeInsetTop();
    }

    public final int getAuthRequestContext(DisplayCutout p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.getSafeInsetRight();
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(DisplayCutout p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.getSafeInsetBottom();
    }
}
