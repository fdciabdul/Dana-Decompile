package kotlinx.coroutines.flow;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "emittedItem", "", BridgeDSL.INVOKE, "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class FlowKt__DelayKt$debounce$3<T> extends Lambda implements Function1<T, Long> {
    final /* synthetic */ Function1<T, Duration> $$timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounce$3(Function1<? super T, Duration> function1) {
        super(1);
        this.$$timeout = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Long invoke(Object obj) {
        return invoke((FlowKt__DelayKt$debounce$3<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(T t) {
        return Long.valueOf(DelayKt.m4625toDelayMillisLRDsOJo(this.$$timeout.invoke(t).getRawValue()));
    }
}
