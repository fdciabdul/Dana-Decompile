package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowExtKt {
    public static /* synthetic */ Flow PlaceComponentResult(Flow flow, Lifecycle lifecycle) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(state, "");
        return FlowKt.callbackFlow(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, flow, null));
    }
}
