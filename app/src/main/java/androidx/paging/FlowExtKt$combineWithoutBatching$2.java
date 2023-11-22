package androidx.paging;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2", f = "FlowExt.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowExtKt$combineWithoutBatching$2<R> extends SuspendLambda implements Function2<SimpleProducerScope<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T2> $otherFlow;
    final /* synthetic */ Flow<T1> $this_combineWithoutBatching;
    final /* synthetic */ Function4<T1, T2, CombineSource, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$combineWithoutBatching$2(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super FlowExtKt$combineWithoutBatching$2> continuation) {
        super(2, continuation);
        this.$this_combineWithoutBatching = flow;
        this.$otherFlow = flow2;
        this.$transform = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtKt$combineWithoutBatching$2 flowExtKt$combineWithoutBatching$2 = new FlowExtKt$combineWithoutBatching$2(this.$this_combineWithoutBatching, this.$otherFlow, this.$transform, continuation);
        flowExtKt$combineWithoutBatching$2.L$0 = obj;
        return flowExtKt$combineWithoutBatching$2;
    }

    public final Object invoke(SimpleProducerScope<R> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((FlowExtKt$combineWithoutBatching$2) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CompletableJob Job$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, null));
            Job$default = JobKt__JobKt.Job$default(null, 1, null);
            Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i2 = 0;
            int i3 = 0;
            while (i2 < 2) {
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope, Job$default, null, new FlowExtKt$combineWithoutBatching$2$1$1(flowArr[i2], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i3, null), 2, null);
                i2++;
                i3++;
            }
            this.label = 1;
            if (simpleProducerScope.MyBillsEntityDataFactory(new AnonymousClass2(Job$default), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CompletableJob Job$default;
        SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
        AtomicInteger atomicInteger = new AtomicInteger(2);
        UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, null));
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
        int i = 0;
        int i2 = 0;
        while (i < 2) {
            BuildersKt__Builders_commonKt.launch$default(simpleProducerScope, Job$default, null, new FlowExtKt$combineWithoutBatching$2$1$1(flowArr[i], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i2, null), 2, null);
            i++;
            i2++;
        }
        InlineMarker.mark(0);
        simpleProducerScope.MyBillsEntityDataFactory(new AnonymousClass2(Job$default), this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T1", "T2", "R", "", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ CompletableJob $$parentJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CompletableJob completableJob) {
            super(0);
            this.$$parentJob = completableJob;
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Job.DefaultImpls.cancel$default(this.$$parentJob, null, 1, null);
        }
    }
}
