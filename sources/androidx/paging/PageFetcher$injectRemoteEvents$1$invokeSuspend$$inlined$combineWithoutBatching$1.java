package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Value] */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@¨\u0006\u0005"}, d2 = {"T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;", "", "androidx/paging/FlowExtKt$combineWithoutBatching$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1", f = "PageFetcher.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $otherFlow;
    final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
    final /* synthetic */ Flow $this_combineWithoutBatching;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(Flow flow, Flow flow2, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
        super(2, continuation);
        this.$this_combineWithoutBatching = flow;
        this.$otherFlow = flow2;
        this.$sourceStates$inlined = mutableLoadStateCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$this_combineWithoutBatching, this.$otherFlow, continuation, this.$sourceStates$inlined);
        pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.L$0 = obj;
        return pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1;
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@¨\u0006\u0005"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ Flow $flow;
        final /* synthetic */ AtomicInteger $incompleteFlows;
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Flow flow, AtomicInteger atomicInteger, SimpleProducerScope simpleProducerScope, UnbatchedFlowCombiner unbatchedFlowCombiner, int i, Continuation continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$incompleteFlows = atomicInteger;
            this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
            this.$index = i;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 implements FlowCollector<Object> {
            final /* synthetic */ UnbatchedFlowCombiner BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ int getAuthRequestContext;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1", f = "PageFetcher.kt", i = {}, l = {135, 138}, m = "emit", n = {}, s = {})
            /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C00041 extends ContinuationImpl {
                int label;
                /* synthetic */ Object result;

                public C00041(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return AnonymousClass1.this.emit(null, this);
                }
            }

            public AnonymousClass1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i) {
                this.BuiltInFictitiousFunctionClassFactory = unbatchedFlowCombiner;
                this.getAuthRequestContext = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[RETURN] */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.C00041
                    if (r0 == 0) goto L14
                    r0 = r7
                    androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1 r0 = (androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.C00041) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r7 = r0.label
                    int r7 = r7 + r2
                    r0.label = r7
                    goto L19
                L14:
                    androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1 r0 = new androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1
                    r0.<init>(r7)
                L19:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L39
                    if (r2 == r4) goto L35
                    if (r2 != r3) goto L2d
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L52
                L2d:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L35:
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L49
                L39:
                    kotlin.ResultKt.throwOnFailure(r7)
                    androidx.paging.UnbatchedFlowCombiner r7 = r5.BuiltInFictitiousFunctionClassFactory
                    int r2 = r5.getAuthRequestContext
                    r0.label = r4
                    java.lang.Object r6 = r7.MyBillsEntityDataFactory(r2, r6, r0)
                    if (r6 != r1) goto L49
                    return r1
                L49:
                    r0.label = r3
                    java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
                    if (r6 != r1) goto L52
                    return r1
                L52:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$flow.collect(new AnonymousClass1(this.$unbatchedFlowCombiner, this.$index), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$$this$simpleChannelFlow, null, 1, null);
                }
                return Unit.INSTANCE;
            } finally {
                if (this.$incompleteFlows.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$$this$simpleChannelFlow, null, 1, null);
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CompletableJob Job$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new AnonymousClass1(simpleProducerScope, null, this.$sourceStates$inlined));
            Job$default = JobKt__JobKt.Job$default(null, 1, null);
            Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i2 = 0;
            int i3 = 0;
            while (i2 < 2) {
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope, Job$default, null, new AnonymousClass2(flowArr[i2], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i3, null), 2, null);
                i2++;
                i3++;
            }
            this.label = 1;
            if (simpleProducerScope.MyBillsEntityDataFactory(new Function0<Unit>() { // from class: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job.DefaultImpls.cancel$default(CompletableJob.this, null, 1, null);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@¨\u0006\b"}, d2 = {"T1", "T2", "R", "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "", "androidx/paging/FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1", f = "PageFetcher.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<LoadStates, PageEvent<Value>, CombineSource, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleProducerScope simpleProducerScope, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
            super(4, continuation);
            this.$sourceStates$inlined = mutableLoadStateCollection;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(LoadStates loadStates, PageEvent<Value> pageEvent, CombineSource combineSource, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$simpleChannelFlow, continuation, this.$sourceStates$inlined);
            anonymousClass1.L$0 = loadStates;
            anonymousClass1.L$1 = pageEvent;
            anonymousClass1.L$2 = combineSource;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LoadState.NotLoading notLoading;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                Object obj3 = this.L$1;
                CombineSource combineSource = (CombineSource) this.L$2;
                SimpleProducerScope<PageEvent<Value>> simpleProducerScope = this.$$this$simpleChannelFlow;
                AnonymousClass1 anonymousClass1 = this;
                PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent) obj3;
                LoadStates loadStates = (LoadStates) obj2;
                if (combineSource != CombineSource.RECEIVER) {
                    if (loadStateUpdate instanceof PageEvent.Insert) {
                        MutableLoadStateCollection mutableLoadStateCollection = this.$sourceStates$inlined;
                        PageEvent.Insert insert = (PageEvent.Insert) loadStateUpdate;
                        LoadStates loadStates2 = insert.getErrorConfigVersion;
                        Intrinsics.checkNotNullParameter(loadStates2, "");
                        mutableLoadStateCollection.PlaceComponentResult = loadStates2.BuiltInFictitiousFunctionClassFactory;
                        mutableLoadStateCollection.BuiltInFictitiousFunctionClassFactory = loadStates2.MyBillsEntityDataFactory;
                        mutableLoadStateCollection.MyBillsEntityDataFactory = loadStates2.PlaceComponentResult;
                        loadStateUpdate = PageEvent.Insert.MyBillsEntityDataFactory(insert, insert.getErrorConfigVersion, loadStates);
                    } else if (loadStateUpdate instanceof PageEvent.Drop) {
                        MutableLoadStateCollection mutableLoadStateCollection2 = this.$sourceStates$inlined;
                        LoadType loadType = ((PageEvent.Drop) loadStateUpdate).PlaceComponentResult;
                        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
                        notLoading = LoadState.NotLoading.getAuthRequestContext;
                        mutableLoadStateCollection2.getAuthRequestContext(loadType, notLoading);
                    } else if (!(loadStateUpdate instanceof PageEvent.LoadStateUpdate)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        MutableLoadStateCollection mutableLoadStateCollection3 = this.$sourceStates$inlined;
                        PageEvent.LoadStateUpdate loadStateUpdate2 = (PageEvent.LoadStateUpdate) loadStateUpdate;
                        LoadStates loadStates3 = loadStateUpdate2.BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkNotNullParameter(loadStates3, "");
                        mutableLoadStateCollection3.PlaceComponentResult = loadStates3.BuiltInFictitiousFunctionClassFactory;
                        mutableLoadStateCollection3.BuiltInFictitiousFunctionClassFactory = loadStates3.MyBillsEntityDataFactory;
                        mutableLoadStateCollection3.MyBillsEntityDataFactory = loadStates3.PlaceComponentResult;
                        loadStateUpdate = new PageEvent.LoadStateUpdate(loadStateUpdate2.BuiltInFictitiousFunctionClassFactory, loadStates);
                    }
                } else {
                    MutableLoadStateCollection mutableLoadStateCollection4 = this.$sourceStates$inlined;
                    loadStateUpdate = new PageEvent.LoadStateUpdate(new LoadStates(mutableLoadStateCollection4.PlaceComponentResult, mutableLoadStateCollection4.MyBillsEntityDataFactory, mutableLoadStateCollection4.BuiltInFictitiousFunctionClassFactory), loadStates);
                }
                this.label = 1;
                if (simpleProducerScope.send(loadStateUpdate, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
