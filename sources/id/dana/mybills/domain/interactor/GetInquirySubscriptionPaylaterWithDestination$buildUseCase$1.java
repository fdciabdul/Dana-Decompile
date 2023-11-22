package id.dana.mybills.domain.interactor;

import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.model.BizProductDestination;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lid/dana/mybills/domain/model/BizProductDestination;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1", f = "GetInquirySubscriptionPaylaterWithDestination.kt", i = {0, 0, 1, 1, 2, 2}, l = {65, 69, 73, 84}, m = "invokeSuspend", n = {"$this$flow", "listBizProductDestination", "$this$flow", "listBizProductDestination", "$this$flow", "listBizProductDestination"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes5.dex */
final class GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends BizProductDestination>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GetInquirySubscriptionPaylaterWithDestination.Params> $param;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ GetInquirySubscriptionPaylaterWithDestination this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1(List<GetInquirySubscriptionPaylaterWithDestination.Params> list, GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, Continuation<? super GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1> continuation) {
        super(2, continuation);
        this.$param = list;
        this.this$0 = getInquirySubscriptionPaylaterWithDestination;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1 getInquirySubscriptionPaylaterWithDestination$buildUseCase$1 = new GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1(this.$param, this.this$0, continuation);
        getInquirySubscriptionPaylaterWithDestination$buildUseCase$1.L$0 = obj;
        return getInquirySubscriptionPaylaterWithDestination$buildUseCase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends BizProductDestination>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<BizProductDestination>>) flowCollector, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<BizProductDestination>> flowCollector, Continuation<? super Unit> continuation) {
        return ((GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00cd -> B:24:0x00d0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00fc -> B:24:0x00d0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0117 -> B:36:0x011f). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination$buildUseCase$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
