package androidx.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/navigation/Navigation;", "", "Landroid/view/View;", "p0", "Landroidx/navigation/NavController;", "MyBillsEntityDataFactory", "(Landroid/view/View;)Landroidx/navigation/NavController;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;Landroidx/navigation/NavController;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Navigation {
    public static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View p0, NavController p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.setTag(C0212R.id.nav_controller_view_tag, p1);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NavDirections navDirections, View view) {
        Intrinsics.checkNotNullParameter(navDirections, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        NavController MyBillsEntityDataFactory = MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullParameter(navDirections, "");
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(navDirections.getPlaceComponentResult(), navDirections.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(int i, Bundle bundle, View view) {
        Intrinsics.checkNotNullExpressionValue(view, "");
        MyBillsEntityDataFactory(view).KClassImpl$Data$declaredNonStaticMembers$2(i, bundle, (NavOptions) null);
    }

    public static final /* synthetic */ NavController getAuthRequestContext(View view) {
        Object tag = view.getTag(C0212R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @JvmStatic
    public static final NavController MyBillsEntityDataFactory(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NavController navController = (NavController) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(p0, new Function1<View, View>() { // from class: androidx.navigation.Navigation$findViewNavController$1
            @Override // kotlin.jvm.functions.Function1
            public final View invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, NavController>() { // from class: androidx.navigation.Navigation$findViewNavController$2
            @Override // kotlin.jvm.functions.Function1
            public final NavController invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                Navigation navigation = Navigation.INSTANCE;
                return Navigation.getAuthRequestContext(view);
            }
        }));
        if (navController != null) {
            return navController;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(p0);
        sb.append(" does not have a NavController set");
        throw new IllegalStateException(sb.toString());
    }
}
