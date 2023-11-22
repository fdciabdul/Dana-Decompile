package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {188, 227, 205}, m = "onNext", n = {"this", "value", "index", "this", "value", "$this$withLock_u24default$iv", "index", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class UnbatchedFlowCombiner$onNext$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbatchedFlowCombiner$onNext$1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, Continuation<? super UnbatchedFlowCombiner$onNext$1> continuation) {
        super(continuation);
        this.this$0 = unbatchedFlowCombiner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.MyBillsEntityDataFactory(0, null, this);
    }
}
