package id.dana.mybills.domain.interactor;

import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
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
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1 extends SuspendLambda implements Function3<FlowCollector<? super CumulateDueDatePaylaterResult>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1(Continuation<? super GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super CumulateDueDatePaylaterResult> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1 getInquirySubscriptionPaylaterWithDestination$getCumulateBill$1 = new GetInquirySubscriptionPaylaterWithDestination$getCumulateBill$1(continuation);
        getInquirySubscriptionPaylaterWithDestination$getCumulateBill$1.L$0 = flowCollector;
        return getInquirySubscriptionPaylaterWithDestination$getCumulateBill$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.mybills.data.model.response.PagingInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ?? r4 = 0;
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(new CumulateDueDatePaylaterResult(r4, r4, 3, r4), this) == coroutine_suspended) {
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
