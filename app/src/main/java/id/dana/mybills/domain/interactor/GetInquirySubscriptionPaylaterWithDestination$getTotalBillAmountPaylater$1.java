package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.model.BizProductDestination;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/mybills/domain/model/BizProductDestination;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {0}, l = {138, 140, 142}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1 extends SuspendLambda implements Function2<FlowCollector<? super BizProductDestination>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination.Params $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1(GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, GetInquirySubscriptionPaylaterWithDestination.Params params, Continuation<? super GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1> continuation) {
        super(2, continuation);
        this.this$0 = getInquirySubscriptionPaylaterWithDestination;
        this.$param = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1 getInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1 = new GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1(this.this$0, this.$param, continuation);
        getInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1.L$0 = obj;
        return getInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BizProductDestination> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8f
        L1e:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L71
        L26:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination r12 = r11.this$0
            java.util.HashMap<java.lang.String, id.dana.mybills.domain.model.BizProductDestination> r12 = r12.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r5 = r11.$param
            java.lang.String r5 = r5.BuiltInFictitiousFunctionClassFactory
            java.lang.Object r12 = r12.get(r5)
            id.dana.mybills.domain.model.BizProductDestination r12 = (id.dana.mybills.domain.model.BizProductDestination) r12
            if (r12 == 0) goto L50
            boolean r5 = r12.isInquirySuccess()
            if (r5 == 0) goto L50
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.label = r2
            java.lang.Object r12 = r1.emit(r12, r3)
            if (r12 != r0) goto L8f
            return r0
        L50:
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination r12 = r11.this$0
            id.dana.mybills.domain.model.CumulateDueDateParamRequest r2 = new id.dana.mybills.domain.model.CumulateDueDateParamRequest
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 7
            r10 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r5 = r11.$param
            kotlinx.coroutines.flow.Flow r12 = id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination.PlaceComponentResult(r12, r2, r5)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.first(r12, r2)
            if (r12 != r0) goto L71
            return r0
        L71:
            id.dana.mybills.domain.model.BizProductDestination r12 = (id.dana.mybills.domain.model.BizProductDestination) r12
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination r2 = r11.this$0
            java.util.HashMap<java.lang.String, id.dana.mybills.domain.model.BizProductDestination> r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            java.util.Map r2 = (java.util.Map) r2
            id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$Params r4 = r11.$param
            java.lang.String r4 = r4.BuiltInFictitiousFunctionClassFactory
            r2.put(r4, r12)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r4 = 0
            r11.L$0 = r4
            r11.label = r3
            java.lang.Object r12 = r1.emit(r12, r2)
            if (r12 != r0) goto L8f
            return r0
        L8f:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$getTotalBillAmountPaylater$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
