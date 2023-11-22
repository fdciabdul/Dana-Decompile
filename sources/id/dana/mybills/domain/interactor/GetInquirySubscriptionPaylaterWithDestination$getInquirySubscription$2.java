package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.model.BizProductDestination;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/mybills/domain/model/BizProductDestination;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2 extends SuspendLambda implements Function3<FlowCollector<? super BizProductDestination>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2(Continuation<? super GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super BizProductDestination> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2 getInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2 = new GetInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2(continuation);
        getInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2.L$0 = flowCollector;
        return getInquirySubscriptionPaylaterWithDestination$getInquirySubscription$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [java.lang.Long, java.lang.Integer] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ?? r16 = 0;
            String str = "FAILED";
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(new BizProductDestination(null, null, null, null, null, null, null, null, null, null, r16, r16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, -1, 1835007, null), this) == coroutine_suspended) {
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
