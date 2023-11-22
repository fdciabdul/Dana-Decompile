package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [T1, T2] */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@"}, d2 = {"T1", "T2", "R", "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", f = "FlowExt.kt", i = {}, l = {139, 139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1<T1, T2> extends SuspendLambda implements Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleProducerScope<R> $$this$simpleChannelFlow;
    final /* synthetic */ Function4<T1, T2, CombineSource, Continuation<? super R>, Object> $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(SimpleProducerScope<R> simpleProducerScope, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1> continuation) {
        super(4, continuation);
        this.$$this$simpleChannelFlow = simpleProducerScope;
        this.$transform = function4;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(T1 t1, T2 t2, CombineSource combineSource, Continuation<? super Unit> continuation) {
        FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 = new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(this.$$this$simpleChannelFlow, this.$transform, continuation);
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$0 = t1;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$1 = t2;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.L$2 = combineSource;
        return flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function4
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, CombineSource combineSource, Continuation<? super Unit> continuation) {
        return invoke2((FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1<T1, T2>) obj, obj2, combineSource, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SimpleProducerScope simpleProducerScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            CombineSource combineSource = (CombineSource) this.L$2;
            SimpleProducerScope simpleProducerScope2 = this.$$this$simpleChannelFlow;
            Function4<T1, T2, CombineSource, Continuation<? super R>, Object> function4 = this.$transform;
            this.L$0 = simpleProducerScope2;
            this.L$1 = null;
            this.label = 1;
            obj = function4.invoke(obj2, obj3, combineSource, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            simpleProducerScope = simpleProducerScope2;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            simpleProducerScope = (SimpleProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (simpleProducerScope.send(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend$$forInline(Object obj) {
        Object obj2 = this.L$0;
        Object obj3 = this.L$1;
        CombineSource combineSource = (CombineSource) this.L$2;
        InlineMarker.mark(0);
        this.$$this$simpleChannelFlow.send(this.$transform.invoke(obj2, obj3, combineSource, this), this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
