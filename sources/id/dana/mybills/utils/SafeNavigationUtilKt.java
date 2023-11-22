package id.dana.mybills.utils;

import android.os.Bundle;
import androidx.view.NavBackStackEntry;
import androidx.view.NavController;
import androidx.view.NavDestination;
import androidx.view.NavOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/navigation/NavController;", "", "p0", "p1", "Landroid/os/Bundle;", "p2", "", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavController;IILandroid/os/Bundle;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SafeNavigationUtilKt {
    public static final void MyBillsEntityDataFactory(NavController navController, int i, int i2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "");
        NavBackStackEntry lastOrNull = navController.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        boolean z = false;
        if (navDestination != null && i == navDestination.getErrorConfigVersion) {
            z = true;
        }
        if (z) {
            navController.KClassImpl$Data$declaredNonStaticMembers$2(i2, bundle, (NavOptions) null);
        }
    }
}
