package androidx.view;

import android.view.View;
import android.view.ViewParent;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "it", BridgeDSL.INVOKE, "(Landroid/view/View;)Landroid/view/View;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1  reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
final class C0205x8c7c000a extends Lambda implements Function1<View, View> {
    public static final C0205x8c7c000a INSTANCE = new C0205x8c7c000a();

    C0205x8c7c000a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final View invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
