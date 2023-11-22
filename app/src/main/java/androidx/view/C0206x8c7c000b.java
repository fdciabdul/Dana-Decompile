package androidx.view;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Landroidx/activity/OnBackPressedDispatcherOwner;", BridgeDSL.INVOKE, "(Landroid/view/View;)Landroidx/activity/OnBackPressedDispatcherOwner;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2  reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes.dex */
final class C0206x8c7c000b extends Lambda implements Function1<View, OnBackPressedDispatcherOwner> {
    public static final C0206x8c7c000b INSTANCE = new C0206x8c7c000b();

    C0206x8c7c000b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final OnBackPressedDispatcherOwner invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        Object tag = view.getTag(R.id.getAuthRequestContext);
        if (tag instanceof OnBackPressedDispatcherOwner) {
            return (OnBackPressedDispatcherOwner) tag;
        }
        return null;
    }
}
