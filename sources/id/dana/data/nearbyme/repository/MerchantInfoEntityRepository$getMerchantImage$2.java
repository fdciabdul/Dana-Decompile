package id.dana.data.nearbyme.repository;

import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import id.dana.data.nearbyme.repository.source.session.LocalMerchantInfoEntityData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$2", f = "MerchantInfoEntityRepository.kt", i = {0}, l = {116, 119}, m = "invokeSuspend", n = {"$this$onStart"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class MerchantInfoEntityRepository$getMerchantImage$2 extends SuspendLambda implements Function2<FlowCollector<? super MerchantImageResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $merchantId;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ String $shopId;
    final /* synthetic */ boolean $skipCache;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MerchantInfoEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantInfoEntityRepository$getMerchantImage$2(boolean z, MerchantInfoEntityRepository merchantInfoEntityRepository, String str, String str2, int i, int i2, Continuation<? super MerchantInfoEntityRepository$getMerchantImage$2> continuation) {
        super(2, continuation);
        this.$skipCache = z;
        this.this$0 = merchantInfoEntityRepository;
        this.$merchantId = str;
        this.$shopId = str2;
        this.$pageNum = i;
        this.$pageSize = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MerchantInfoEntityRepository$getMerchantImage$2 merchantInfoEntityRepository$getMerchantImage$2 = new MerchantInfoEntityRepository$getMerchantImage$2(this.$skipCache, this.this$0, this.$merchantId, this.$shopId, this.$pageNum, this.$pageSize, continuation);
        merchantInfoEntityRepository$getMerchantImage$2.L$0 = obj;
        return merchantInfoEntityRepository$getMerchantImage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super MerchantImageResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((MerchantInfoEntityRepository$getMerchantImage$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        LocalMerchantInfoEntityData localMerchantInfoEntityData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            if (!this.$skipCache) {
                localMerchantInfoEntityData = this.this$0.localMerchantInfoEntityData;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = localMerchantInfoEntityData.getMerchantImage(this.$merchantId, this.$shopId, this.$pageNum, this.$pageSize, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
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
        if (!(true ^ ((MerchantImageResult) obj).getImages().isEmpty())) {
            obj = null;
        }
        MerchantImageResult merchantImageResult = (MerchantImageResult) obj;
        if (merchantImageResult != null) {
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(merchantImageResult, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
