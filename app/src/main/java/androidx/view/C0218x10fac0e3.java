package androidx.view;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "Landroidx/savedstate/SavedStateRegistryOwner;", BridgeDSL.INVOKE, "(Landroid/view/View;)Landroidx/savedstate/SavedStateRegistryOwner;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2  reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
final class C0218x10fac0e3 extends Lambda implements Function1<View, SavedStateRegistryOwner> {
    public static final C0218x10fac0e3 INSTANCE = new C0218x10fac0e3();

    C0218x10fac0e3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SavedStateRegistryOwner invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        Object tag = view.getTag(C0214R.id.PlaceComponentResult);
        if (tag instanceof SavedStateRegistryOwner) {
            return (SavedStateRegistryOwner) tag;
        }
        return null;
    }
}
