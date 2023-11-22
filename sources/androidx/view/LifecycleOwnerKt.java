package androidx.view;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "PlaceComponentResult", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;", "BuiltInFictitiousFunctionClassFactory"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LifecycleOwnerKt {
    @JvmName(name = "PlaceComponentResult")
    public static final LifecycleCoroutineScope PlaceComponentResult(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        return LifecycleKt.BuiltInFictitiousFunctionClassFactory(lifecycle);
    }
}
