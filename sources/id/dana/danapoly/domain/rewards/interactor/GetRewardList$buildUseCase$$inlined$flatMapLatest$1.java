package id.dana.danapoly.domain.rewards.interactor;

import com.alibaba.griver.image.framework.utils.FileUtils;
import id.dana.danapoly.domain.rewards.DanapolyRewardsRepository;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.domain.rewards.interactor.GetRewardList$buildUseCase$$inlined$flatMapLatest$1", f = "GetRewardList.kt", i = {}, l = {FileUtils.JPEG_MARKER_EOI}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GetRewardList$buildUseCase$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GetRewardResult>, String, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetRewardsParams $param$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ GetRewardList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRewardList$buildUseCase$$inlined$flatMapLatest$1(Continuation continuation, GetRewardsParams getRewardsParams, GetRewardList getRewardList) {
        super(3, continuation);
        this.$param$inlined = getRewardsParams;
        this.this$0 = getRewardList;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super GetRewardResult> flowCollector, String str, Continuation<? super Unit> continuation) {
        GetRewardList$buildUseCase$$inlined$flatMapLatest$1 getRewardList$buildUseCase$$inlined$flatMapLatest$1 = new GetRewardList$buildUseCase$$inlined$flatMapLatest$1(continuation, this.$param$inlined, this.this$0);
        getRewardList$buildUseCase$$inlined$flatMapLatest$1.L$0 = flowCollector;
        getRewardList$buildUseCase$$inlined$flatMapLatest$1.L$1 = str;
        return getRewardList$buildUseCase$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DanapolyRewardsRepository danapolyRewardsRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.$param$inlined.setEventId((String) this.L$1);
            danapolyRewardsRepository = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            Flow<GetRewardResult> MyBillsEntityDataFactory = danapolyRewardsRepository.MyBillsEntityDataFactory(this.$param$inlined);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, MyBillsEntityDataFactory, this) == coroutine_suspended) {
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
