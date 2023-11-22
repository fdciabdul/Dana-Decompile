package androidx.view;

import android.os.Bundle;
import androidx.view.Navigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Navigator.Name("navigation")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "", "Landroidx/navigation/NavBackStackEntry;", "p0", "Landroidx/navigation/NavOptions;", "p1", "Landroidx/navigation/Navigator$Extras;", "p2", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavigatorProvider;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/navigation/NavigatorProvider;", "getAuthRequestContext", "<init>", "(Landroidx/navigation/NavigatorProvider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final NavigatorProvider getAuthRequestContext;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "");
        this.getAuthRequestContext = navigatorProvider;
    }

    @Override // androidx.view.Navigator
    public final void MyBillsEntityDataFactory(List<NavBackStackEntry> p0, NavOptions p1, Navigator.Extras p2) {
        NavDestination MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        for (NavBackStackEntry navBackStackEntry : p0) {
            NavGraph navGraph = (NavGraph) navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2;
            Bundle bundle = navBackStackEntry.getAuthRequestContext;
            int i = navGraph.PlaceComponentResult;
            String str = navGraph.MyBillsEntityDataFactory;
            if (!((i == 0 && str == null) ? false : true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("no start destination defined via app:startDestination for ");
                sb.append(navGraph.getAuthRequestContext());
                throw new IllegalStateException(sb.toString().toString());
            }
            if (str != null) {
                MyBillsEntityDataFactory = navGraph.PlaceComponentResult(str, false);
            } else {
                MyBillsEntityDataFactory = navGraph.MyBillsEntityDataFactory(i, false);
            }
            if (MyBillsEntityDataFactory != null) {
                Navigator PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(MyBillsEntityDataFactory.lookAheadTest);
                NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
                if (navigatorState != null) {
                    PlaceComponentResult.MyBillsEntityDataFactory(CollectionsKt.listOf(navigatorState.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory(bundle))), p1, p2);
                } else {
                    throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
                }
            } else {
                if (navGraph.getAuthRequestContext == null) {
                    String str2 = navGraph.MyBillsEntityDataFactory;
                    if (str2 == null) {
                        str2 = String.valueOf(navGraph.PlaceComponentResult);
                    }
                    navGraph.getAuthRequestContext = str2;
                }
                String str3 = navGraph.getAuthRequestContext;
                Intrinsics.checkNotNull(str3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("navigation destination ");
                sb2.append(str3);
                sb2.append(" is not a direct child of this NavGraph");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    @Override // androidx.view.Navigator
    public final /* synthetic */ NavGraph KClassImpl$Data$declaredNonStaticMembers$2() {
        return new NavGraph(this);
    }
}
