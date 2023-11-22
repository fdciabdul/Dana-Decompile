package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageFetcherSnapshotState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "androidx/paging/FlowExtKt$simpleFlatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0}, l = {229, 244}, m = "invokeSuspend", n = {"this_$iv", "$this$withLock_u24default$iv$iv", "generationId"}, s = {"L$1", "L$2", "I$0"})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GenerationalViewportHint>, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(Continuation continuation, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, continuation);
        this.this$0 = pageFetcherSnapshot;
        this.$loadType$inlined = loadType;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super GenerationalViewportHint> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(continuation, this.this$0, this.$loadType$inlined);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$0 = flowCollector;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$1 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        final int intValue;
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        PageFetcherSnapshotState pageFetcherSnapshotState;
        HintHandler hintHandler;
        Flow<GenerationalViewportHint> flow;
        LoadState.NotLoading notLoading;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                intValue = ((Number) this.L$1).intValue();
                holder = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda1;
                mutex = holder.MyBillsEntityDataFactory;
                this.L$0 = flowCollector;
                this.L$1 = holder;
                this.L$2 = mutex;
                this.I$0 = intValue;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                intValue = this.I$0;
                mutex = (Mutex) this.L$2;
                holder = (PageFetcherSnapshotState.Holder) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pageFetcherSnapshotState = holder.PlaceComponentResult;
            LoadState KClassImpl$Data$declaredNonStaticMembers$2 = pageFetcherSnapshotState.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.$loadType$inlined);
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            if (Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$2, LoadState.NotLoading.Companion.BuiltInFictitiousFunctionClassFactory())) {
                flow = FlowKt.flowOf((Object[]) new GenerationalViewportHint[0]);
            } else {
                if (!(pageFetcherSnapshotState.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.$loadType$inlined) instanceof LoadState.Error)) {
                    MutableLoadStateCollection mutableLoadStateCollection = pageFetcherSnapshotState.GetContactSyncConfig;
                    LoadType loadType = this.$loadType$inlined;
                    LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
                    notLoading = LoadState.NotLoading.getAuthRequestContext;
                    mutableLoadStateCollection.getAuthRequestContext(loadType, notLoading);
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                hintHandler = this.this$0.PlaceComponentResult;
                final Flow drop = FlowKt.drop(hintHandler.KClassImpl$Data$declaredNonStaticMembers$2(this.$loadType$inlined), intValue == 0 ? 0 : 1);
                flow = new Flow<GenerationalViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
                    /* renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2 implements FlowCollector<ViewportHint> {
                        final /* synthetic */ int MyBillsEntityDataFactory;
                        final /* synthetic */ FlowCollector PlaceComponentResult;

                        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                        @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2", f = "PageFetcherSnapshot.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
                        /* renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2$1  reason: invalid class name */
                        /* loaded from: classes3.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, int i) {
                            this.PlaceComponentResult = flowCollector;
                            this.MyBillsEntityDataFactory = i;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                        /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(androidx.paging.ViewportHint r6, kotlin.coroutines.Continuation r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda6$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L14
                                r0 = r7
                                androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2$1 r0 = (androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda6$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L14
                                int r7 = r0.label
                                int r7 = r7 + r2
                                r0.label = r7
                                goto L19
                            L14:
                                androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2$1 r0 = new androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda-6$$inlined$map$1$2$1
                                r0.<init>(r7)
                            L19:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L32
                                if (r2 != r3) goto L2a
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L4c
                            L2a:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L32:
                                kotlin.ResultKt.throwOnFailure(r7)
                                kotlinx.coroutines.flow.FlowCollector r7 = r5.PlaceComponentResult
                                r2 = r0
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                androidx.paging.ViewportHint r6 = (androidx.paging.ViewportHint) r6
                                androidx.paging.GenerationalViewportHint r2 = new androidx.paging.GenerationalViewportHint
                                int r4 = r5.MyBillsEntityDataFactory
                                r2.<init>(r4, r6)
                                r0.label = r3
                                java.lang.Object r6 = r7.emit(r2, r0)
                                if (r6 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$lambda6$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public final Object collect(FlowCollector<? super GenerationalViewportHint> flowCollector2, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector2, intValue), continuation);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                };
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
