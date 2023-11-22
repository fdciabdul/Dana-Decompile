package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.SimpleProducerScopeImpl", f = "SimpleChannelFlow.kt", i = {0, 0}, l = {97}, m = "awaitClose", n = {"block", "job"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class SimpleProducerScopeImpl$awaitClose$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SimpleProducerScopeImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleProducerScopeImpl$awaitClose$1(SimpleProducerScopeImpl<T> simpleProducerScopeImpl, Continuation<? super SimpleProducerScopeImpl$awaitClose$1> continuation) {
        super(continuation);
        this.this$0 = simpleProducerScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.MyBillsEntityDataFactory(null, this);
    }
}
