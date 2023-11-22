package androidx.view.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.view.ActivityNavigator;
import androidx.view.NavBackStackEntry;
import androidx.view.NavController;
import androidx.view.NavDestination;
import androidx.view.NavGraph;
import androidx.view.NavOptions;
import androidx.view.ui.AppBarConfiguration;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0011J\u001b\u0010\u000e\u001a\u00020\n*\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u000e\u0010\u0014J#\u0010\u000e\u001a\u00020\n*\u00020\u00122\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015H\u0001¢\u0006\u0004\b\u000e\u0010\u0016"}, d2 = {"Landroidx/navigation/ui/NavigationUI;", "", "Landroid/view/View;", "p0", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getAuthRequestContext", "(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/navigation/NavController;", "Landroidx/navigation/ui/AppBarConfiguration;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)Z", "Landroid/view/MenuItem;", "MyBillsEntityDataFactory", "(Landroid/view/MenuItem;Landroidx/navigation/NavController;)Z", "p2", "(Landroid/view/MenuItem;Landroidx/navigation/NavController;Z)Z", "Landroidx/navigation/NavDestination;", "", "(Landroidx/navigation/NavDestination;I)Z", "", "(Landroidx/navigation/NavDestination;Ljava/util/Set;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavigationUI {
    public static final NavigationUI INSTANCE = new NavigationUI();

    private NavigationUI() {
    }

    @JvmStatic
    private static boolean MyBillsEntityDataFactory(MenuItem p0, NavController p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        builder.moveToNextValue = true;
        NavBackStackEntry lastOrNull = p1.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        Intrinsics.checkNotNull(navDestination);
        NavGraph navGraph = navDestination.moveToNextValue;
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.MyBillsEntityDataFactory(p0.getItemId(), true) instanceof ActivityNavigator.Destination) {
            builder.MyBillsEntityDataFactory = R.anim.res_0x7f010048_kclassimpl_data_declarednonstaticmembers_2;
            builder.BuiltInFictitiousFunctionClassFactory = R.anim.getAuthRequestContext_res_0x7f010049;
            builder.getAuthRequestContext = R.anim.BuiltInFictitiousFunctionClassFactory_res_0x7f01004a;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.anim.MyBillsEntityDataFactory_res_0x7f01004b;
        } else {
            builder.MyBillsEntityDataFactory = R.animator.MyBillsEntityDataFactory;
            builder.BuiltInFictitiousFunctionClassFactory = R.animator.res_0x7f020022_kclassimpl_data_declarednonstaticmembers_2;
            builder.getAuthRequestContext = R.animator.getAuthRequestContext;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.animator.BuiltInFictitiousFunctionClassFactory;
        }
        if ((p0.getOrder() & 196608) == 0) {
            NavGraph.Companion companion = NavGraph.INSTANCE;
            builder.PlaceComponentResult = NavGraph.Companion.MyBillsEntityDataFactory(p1.getAuthRequestContext()).getErrorConfigVersion;
            builder.scheduleImpl = null;
            builder.lookAheadTest = false;
            builder.getErrorConfigVersion = true;
        }
        try {
            p1.KClassImpl$Data$declaredNonStaticMembers$2(p0.getItemId(), (Bundle) null, builder.KClassImpl$Data$declaredNonStaticMembers$2());
            NavBackStackEntry lastOrNull2 = p1.PlaceComponentResult.lastOrNull();
            NavDestination navDestination2 = lastOrNull2 != null ? lastOrNull2.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (navDestination2 != null) {
                if (MyBillsEntityDataFactory(navDestination2, p0.getItemId())) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    @NavigationUiSaveStateControl
    @JvmStatic
    private static boolean MyBillsEntityDataFactory(MenuItem p0, NavController p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if ((!p2) == false) {
            throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
        }
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        NavBackStackEntry lastOrNull = p1.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        Intrinsics.checkNotNull(navDestination);
        NavGraph navGraph = navDestination.moveToNextValue;
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.MyBillsEntityDataFactory(p0.getItemId(), true) instanceof ActivityNavigator.Destination) {
            builder.MyBillsEntityDataFactory = R.anim.res_0x7f010048_kclassimpl_data_declarednonstaticmembers_2;
            builder.BuiltInFictitiousFunctionClassFactory = R.anim.getAuthRequestContext_res_0x7f010049;
            builder.getAuthRequestContext = R.anim.BuiltInFictitiousFunctionClassFactory_res_0x7f01004a;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.anim.MyBillsEntityDataFactory_res_0x7f01004b;
        } else {
            builder.MyBillsEntityDataFactory = R.animator.MyBillsEntityDataFactory;
            builder.BuiltInFictitiousFunctionClassFactory = R.animator.res_0x7f020022_kclassimpl_data_declarednonstaticmembers_2;
            builder.getAuthRequestContext = R.animator.getAuthRequestContext;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.animator.BuiltInFictitiousFunctionClassFactory;
        }
        if ((p0.getOrder() & 196608) == 0) {
            NavGraph.Companion companion = NavGraph.INSTANCE;
            NavOptions.Builder.getAuthRequestContext(builder, NavGraph.Companion.MyBillsEntityDataFactory(p1.getAuthRequestContext()).getErrorConfigVersion, false);
        }
        try {
            p1.KClassImpl$Data$declaredNonStaticMembers$2(p0.getItemId(), (Bundle) null, builder.KClassImpl$Data$declaredNonStaticMembers$2());
            NavBackStackEntry lastOrNull2 = p1.PlaceComponentResult.lastOrNull();
            NavDestination navDestination2 = lastOrNull2 != null ? lastOrNull2.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (navDestination2 != null) {
                if (MyBillsEntityDataFactory(navDestination2, p0.getItemId())) {
                    return true;
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return false;
    }

    public static final boolean PlaceComponentResult(NavController navController, NavigationView navigationView, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(navigationView, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(menuItem, navController);
        if (MyBillsEntityDataFactory) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> authRequestContext = getAuthRequestContext(navigationView);
                if (authRequestContext != null) {
                    authRequestContext.setState(5);
                }
            }
        }
        return MyBillsEntityDataFactory;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(NavController navController, boolean z, NavigationView navigationView, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(navigationView, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(menuItem, navController, z);
        if (MyBillsEntityDataFactory) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> authRequestContext = getAuthRequestContext(navigationView);
                if (authRequestContext != null) {
                    authRequestContext.setState(5);
                }
            }
        }
        return MyBillsEntityDataFactory;
    }

    @JvmStatic
    private static BottomSheetBehavior<?> getAuthRequestContext(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ViewGroup.LayoutParams layoutParams = p0.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = p0.getParent();
            if (parent instanceof View) {
                return getAuthRequestContext((View) parent);
            }
            return null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        return null;
    }

    public static final boolean PlaceComponentResult(NavController navController, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        return MyBillsEntityDataFactory(menuItem, navController);
    }

    public static final boolean getAuthRequestContext(NavController navController, boolean z, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        return MyBillsEntityDataFactory(menuItem, navController, z);
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(NavDestination navDestination, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(navDestination, "");
        NavDestination.Companion companion = NavDestination.getAuthRequestContext;
        Iterator<NavDestination> it = NavDestination.Companion.getAuthRequestContext(navDestination).iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            if (it.next().getErrorConfigVersion == i) {
                z = true;
            }
        } while (!z);
        return true;
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(NavDestination navDestination, Set<Integer> set) {
        Intrinsics.checkNotNullParameter(navDestination, "");
        Intrinsics.checkNotNullParameter(set, "");
        NavDestination.Companion companion = NavDestination.getAuthRequestContext;
        Iterator<NavDestination> it = NavDestination.Companion.getAuthRequestContext(navDestination).iterator();
        while (it.hasNext()) {
            if (set.contains(Integer.valueOf(it.next().getErrorConfigVersion))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "");
        BuiltInFictitiousFunctionClassFactory(navController, appBarConfiguration);
    }

    public static /* synthetic */ void PlaceComponentResult(NavController navController, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(appBarConfiguration, "");
        BuiltInFictitiousFunctionClassFactory(navController, appBarConfiguration);
    }

    @JvmStatic
    private static boolean BuiltInFictitiousFunctionClassFactory(NavController p0, AppBarConfiguration p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Openable openable = p1.KClassImpl$Data$declaredNonStaticMembers$2;
        NavBackStackEntry lastOrNull = p0.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        Set<Integer> set = p1.BuiltInFictitiousFunctionClassFactory;
        if (openable != null && navDestination != null && MyBillsEntityDataFactory(navDestination, set)) {
            openable.open();
            return true;
        } else if (p0.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return true;
        } else {
            AppBarConfiguration.OnNavigateUpListener onNavigateUpListener = p1.MyBillsEntityDataFactory;
            if (onNavigateUpListener != null) {
                return onNavigateUpListener.PlaceComponentResult();
            }
            return false;
        }
    }
}
