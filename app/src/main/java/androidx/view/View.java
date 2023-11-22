package androidx.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;Landroidx/activity/OnBackPressedDispatcherOwner;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.activity.ViewTreeOnBackPressedDispatcherOwner  reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class View {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(android.view.View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(onBackPressedDispatcherOwner, "");
        view.setTag(R.id.getAuthRequestContext, onBackPressedDispatcherOwner);
    }
}
