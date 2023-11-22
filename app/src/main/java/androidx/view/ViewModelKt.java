package androidx.view;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "PlaceComponentResult", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelKt {
    @JvmName(name = "PlaceComponentResult")
    public static final CoroutineScope PlaceComponentResult(ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())));
        Intrinsics.checkNotNullExpressionValue(tagIfAbsent, "");
        return (CoroutineScope) tagIfAbsent;
    }
}
