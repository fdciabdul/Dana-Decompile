package androidx.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/LifecycleOwner;", "PlaceComponentResult", "(Landroid/view/View;)Landroidx/lifecycle/LifecycleOwner;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.lifecycle.ViewKt  reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0207ViewKt {
    public static final LifecycleOwner PlaceComponentResult(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        return ViewTreeLifecycleOwner.KClassImpl$Data$declaredNonStaticMembers$2(view);
    }
}
