package androidx.view.fragment;

import androidx.fragment.app.Fragment;
import androidx.view.NavController;
import androidx.view.fragment.NavHostFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavController;", "getAuthRequestContext", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FragmentKt {
    public static final NavController getAuthRequestContext(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        NavHostFragment.Companion companion = NavHostFragment.INSTANCE;
        return NavHostFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(fragment);
    }
}
