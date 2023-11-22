package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0004\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\t\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "p0", "Landroid/os/Bundle;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "PlaceComponentResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FragmentKt {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void PlaceComponentResult(Fragment fragment, String str, final Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics.checkNotNullParameter(fragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function2, "");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str2, Bundle bundle) {
                FragmentKt.getAuthRequestContext(Function2.this, str2, bundle);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(Function2 function2, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        function2.invoke(str, bundle);
    }
}
