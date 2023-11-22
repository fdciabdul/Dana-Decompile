package androidx.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "Landroidx/savedstate/SavedStateRegistryOwner;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;Landroidx/savedstate/SavedStateRegistryOwner;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.savedstate.ViewTreeSavedStateRegistryOwner  reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0216ViewTreeSavedStateRegistryOwner {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(view, "");
        view.setTag(C0214R.id.PlaceComponentResult, savedStateRegistryOwner);
    }
}
