package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CollectionKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetHighlightPayTransaction$buildUseCase$1", f = "GetHighlightPayTransaction.kt", i = {0}, l = {56, 58}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class GetHighlightPayTransaction$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends HighlightTransactionPay>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetHighlightPayTransaction.Params $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetHighlightPayTransaction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetHighlightPayTransaction$buildUseCase$1(GetHighlightPayTransaction.Params params, GetHighlightPayTransaction getHighlightPayTransaction, Continuation<? super GetHighlightPayTransaction$buildUseCase$1> continuation) {
        super(2, continuation);
        this.$param = params;
        this.this$0 = getHighlightPayTransaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetHighlightPayTransaction$buildUseCase$1 getHighlightPayTransaction$buildUseCase$1 = new GetHighlightPayTransaction$buildUseCase$1(this.$param, this.this$0, continuation);
        getHighlightPayTransaction$buildUseCase$1.L$0 = obj;
        return getHighlightPayTransaction$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends HighlightTransactionPay>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<HighlightTransactionPay>>) flowCollector, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<HighlightTransactionPay>> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetHighlightPayTransaction$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Flow flatMapMerge$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            flatMapMerge$default = FlowKt__MergeKt.flatMapMerge$default(FlowKt.asFlow(this.$param.MyBillsEntityDataFactory), 0, new AnonymousClass1(this.$param, this.this$0, null), 1, null);
            this.L$0 = flowCollector;
            this.label = 1;
            obj = FlowKt__CollectionKt.toList$default(flatMapMerge$default, null, this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = obj;
        this.label = 2;
        if (flowCollector.emit((List) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "request", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetHighlightPayTransaction$buildUseCase$1$1", f = "GetHighlightPayTransaction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.mybills.domain.interactor.GetHighlightPayTransaction$buildUseCase$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<HighlightTransactionPayRequest, Continuation<? super Flow<? extends HighlightTransactionPay>>, Object> {
        final /* synthetic */ GetHighlightPayTransaction.Params $param;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GetHighlightPayTransaction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GetHighlightPayTransaction.Params params, GetHighlightPayTransaction getHighlightPayTransaction, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$param = params;
            this.this$0 = getHighlightPayTransaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$param, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(HighlightTransactionPayRequest highlightTransactionPayRequest, Continuation<? super Flow<HighlightTransactionPay>> continuation) {
            return ((AnonymousClass1) create(highlightTransactionPayRequest, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* bridge */ /* synthetic */ Object invoke(HighlightTransactionPayRequest highlightTransactionPayRequest, Continuation<? super Flow<? extends HighlightTransactionPay>> continuation) {
            return invoke2(highlightTransactionPayRequest, (Continuation<? super Flow<HighlightTransactionPay>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MyBillsRepository myBillsRepository;
            MyBillsRepository myBillsRepository2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HighlightTransactionPayRequest highlightTransactionPayRequest = (HighlightTransactionPayRequest) this.L$0;
                if (this.$param.getGetAuthRequestContext()) {
                    myBillsRepository2 = this.this$0.getAuthRequestContext;
                    return myBillsRepository2.PlaceComponentResult(highlightTransactionPayRequest);
                }
                myBillsRepository = this.this$0.getAuthRequestContext;
                return FlowKt.m4649catch(myBillsRepository.PlaceComponentResult(highlightTransactionPayRequest), new C01761(highlightTransactionPayRequest, null));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "id.dana.mybills.domain.interactor.GetHighlightPayTransaction$buildUseCase$1$1$1", f = "GetHighlightPayTransaction.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: id.dana.mybills.domain.interactor.GetHighlightPayTransaction$buildUseCase$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C01761 extends SuspendLambda implements Function3<FlowCollector<? super HighlightTransactionPay>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ HighlightTransactionPayRequest $request;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01761(HighlightTransactionPayRequest highlightTransactionPayRequest, Continuation<? super C01761> continuation) {
                super(3, continuation);
                this.$request = highlightTransactionPayRequest;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super HighlightTransactionPay> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C01761 c01761 = new C01761(this.$request, continuation);
                c01761.L$0 = flowCollector;
                c01761.L$1 = th;
                return c01761.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    String subscriptionId = this.$request.getSubscriptionId();
                    String message = th.getMessage();
                    if (message == null) {
                        message = "Unknown";
                    }
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(new HighlightTransactionPay(subscriptionId, null, null, null, message, false), this) == coroutine_suspended) {
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
}
