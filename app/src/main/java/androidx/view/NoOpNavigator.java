package androidx.view;

import android.os.Bundle;
import androidx.view.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Navigator.Name("NoOp")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000f"}, d2 = {"Landroidx/navigation/NoOpNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/navigation/NavDestination;", "p0", "Landroid/os/Bundle;", "p1", "Landroidx/navigation/NavOptions;", "p2", "Landroidx/navigation/Navigator$Extras;", "p3", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "", "()Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NoOpNavigator extends Navigator<NavDestination> {
    @Override // androidx.view.Navigator
    public final NavDestination MyBillsEntityDataFactory(NavDestination p0, Bundle p1, NavOptions p2, Navigator.Extras p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Override // androidx.view.Navigator
    public final boolean MyBillsEntityDataFactory() {
        return true;
    }

    @Override // androidx.view.Navigator
    public final NavDestination KClassImpl$Data$declaredNonStaticMembers$2() {
        return new NavDestination(this);
    }
}
