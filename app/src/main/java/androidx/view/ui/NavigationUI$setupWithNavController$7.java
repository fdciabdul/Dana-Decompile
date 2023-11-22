package androidx.view.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.view.NavController;
import androidx.view.NavDestination;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/navigation/ui/NavigationUI$setupWithNavController$7;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "Landroidx/navigation/NavController;", "p0", "Landroidx/navigation/NavDestination;", "p1", "Landroid/os/Bundle;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavigationUI$setupWithNavController$7 implements NavController.OnDestinationChangedListener {
    final /* synthetic */ NavController BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ WeakReference<NavigationView> getAuthRequestContext;

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavController p0, NavDestination p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        NavigationView navigationView = this.getAuthRequestContext.get();
        if (navigationView == null) {
            NavController navController = this.BuiltInFictitiousFunctionClassFactory;
            NavigationUI$setupWithNavController$7 navigationUI$setupWithNavController$7 = this;
            Intrinsics.checkNotNullParameter(navigationUI$setupWithNavController$7, "");
            navController.newProxyInstance.remove(navigationUI$setupWithNavController$7);
            return;
        }
        Menu menu = navigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "");
            item.setChecked(NavigationUI.MyBillsEntityDataFactory(p1, item.getItemId()));
        }
    }
}
