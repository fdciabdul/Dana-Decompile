package id.dana.core.ui.extension;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "PlaceComponentResult", "(Landroidx/fragment/app/Fragment;)Z", "Landroidx/fragment/app/FragmentTransaction;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/fragment/app/FragmentTransaction;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FragmentExtKt {
    public static final void BuiltInFictitiousFunctionClassFactory(FragmentTransaction fragmentTransaction) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "");
        int i = R.anim.MyBillsEntityDataFactory_res_0x7f010057;
        int i2 = R.anim.PlaceComponentResult_res_0x7f01005d;
        int i3 = R.anim.getAuthRequestContext_res_0x7f010056;
        int i4 = R.anim.lookAheadTest;
        fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        fragmentTransaction.GetContactSyncConfig = i2;
        fragmentTransaction.newProxyInstance = i3;
        fragmentTransaction.PrepareContext = i4;
    }

    public static final boolean PlaceComponentResult(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        return (fragment.isRemoving() || fragment.getActivity() == null || fragment.isDetached() || !fragment.isAdded()) ? false : true;
    }
}
