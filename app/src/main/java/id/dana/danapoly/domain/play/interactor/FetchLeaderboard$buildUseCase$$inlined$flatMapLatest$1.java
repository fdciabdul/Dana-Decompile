package id.dana.danapoly.domain.play.interactor;

import id.dana.danapoly.domain.config.model.DanapolyEvent;
import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import id.dana.danapoly.domain.play.interactor.FetchLeaderboard;
import id.dana.danapoly.domain.play.model.GetLeaderboard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1", f = "FetchLeaderboard.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GetLeaderboard>, DanapolyEvent, Continuation<? super Unit>, Object> {
    final /* synthetic */ FetchLeaderboard.Params $param$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FetchLeaderboard this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1(Continuation continuation, FetchLeaderboard.Params params, FetchLeaderboard fetchLeaderboard) {
        super(3, continuation);
        this.$param$inlined = params;
        this.this$0 = fetchLeaderboard;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super GetLeaderboard> flowCollector, DanapolyEvent danapolyEvent, Continuation<? super Unit> continuation) {
        FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1 fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1 = new FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1(continuation, this.$param$inlined, this.this$0);
        fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1.L$0 = flowCollector;
        fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1.L$1 = danapolyEvent;
        return fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DanapolyPlayRepository danapolyPlayRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1 fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1 = this;
            final DanapolyEvent danapolyEvent = (DanapolyEvent) this.L$1;
            String str = this.$param$inlined.PlaceComponentResult;
            if (!(str.length() > 0)) {
                str = null;
            }
            if (str == null) {
                str = danapolyEvent.getEventId();
            }
            danapolyPlayRepository = this.this$0.MyBillsEntityDataFactory;
            final Flow<GetLeaderboard> KClassImpl$Data$declaredNonStaticMembers$2 = danapolyPlayRepository.KClassImpl$Data$declaredNonStaticMembers$2(str);
            Flow<GetLeaderboard> flow = new Flow<GetLeaderboard>() { // from class: id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super GetLeaderboard> flowCollector2, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector2, danapolyEvent), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ DanapolyEvent $PlaceComponentResult;
                    final /* synthetic */ FlowCollector $getAuthRequestContext;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2", f = "FetchLeaderboard.kt", i = {}, l = {225}, m = "emit", n = {}, s = {})
                    /* renamed from: id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes4.dex */
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

                    public AnonymousClass2(FlowCollector flowCollector, DanapolyEvent danapolyEvent) {
                        this.$getAuthRequestContext = flowCollector;
                        this.$PlaceComponentResult = danapolyEvent;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r6
                            id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2$1 r0 = (id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 + r2
                            r0.label = r6
                            goto L19
                        L14:
                            id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2$1 r0 = new id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda-2$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L19:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L4e
                        L2a:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L32:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            id.dana.danapoly.domain.play.model.GetLeaderboard r5 = (id.dana.danapoly.domain.play.model.GetLeaderboard) r5
                            id.dana.danapoly.domain.config.model.DanapolyEvent r2 = r4.$PlaceComponentResult
                            java.lang.Long r2 = r2.getExpiryDate()
                            r5.setEventExpiryDate(r2)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L4e
                            return r1
                        L4e:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.domain.play.interactor.FetchLeaderboard$buildUseCase$lambda2$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, fetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1) == coroutine_suspended) {
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
