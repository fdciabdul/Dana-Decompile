package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR3\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "countOrElement", "Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "emitRef", "Lkotlin/jvm/functions/Function2;", "downstream", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final Object countOrElement;
    private final CoroutineContext emitContext;
    private final Function2<T, Continuation<? super Unit>, Object> emitRef;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.emitContext = coroutineContext;
        this.countOrElement = ThreadContextKt.threadContextElements(coroutineContext);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Object withContextUndispatched = ChannelFlowKt.withContextUndispatched(this.emitContext, t, this.countOrElement, this.emitRef, continuation);
        return withContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContextUndispatched : Unit.INSTANCE;
    }
}
