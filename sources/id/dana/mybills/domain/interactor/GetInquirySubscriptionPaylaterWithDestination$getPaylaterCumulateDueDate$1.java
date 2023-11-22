package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.CumulateDueDateParamRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/mybills/domain/model/BizProductDestination;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {0, 0}, l = {154, 174}, m = "invokeSuspend", n = {"$this$flow", "totalAmount"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1 extends SuspendLambda implements Function2<FlowCollector<? super BizProductDestination>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination.Params $params;
    final /* synthetic */ CumulateDueDateParamRequest $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1(GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, CumulateDueDateParamRequest cumulateDueDateParamRequest, GetInquirySubscriptionPaylaterWithDestination.Params params, Continuation<? super GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1> continuation) {
        super(2, continuation);
        this.this$0 = getInquirySubscriptionPaylaterWithDestination;
        this.$request = cumulateDueDateParamRequest;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1 getInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1 = new GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1(this.this$0, this.$request, this.$params, continuation);
        getInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1.L$0 = obj;
        return getInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BizProductDestination> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01d5 A[RETURN] */
    /* JADX WARN: Type inference failed for: r14v1, types: [id.dana.domain.nearbyme.model.MoneyView, java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0059 -> B:16:0x005c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r68) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getPaylaterCumulateDueDate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
