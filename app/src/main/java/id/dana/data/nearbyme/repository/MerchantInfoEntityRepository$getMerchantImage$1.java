package id.dana.data.nearbyme.repository;

import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$1", f = "MerchantInfoEntityRepository.kt", i = {0, 1}, l = {101, 102, 103}, m = "invokeSuspend", n = {"$this$flow", "$this$invokeSuspend_u24lambda_u2d0"}, s = {"L$0", "L$3"})
/* loaded from: classes2.dex */
final class MerchantInfoEntityRepository$getMerchantImage$1 extends SuspendLambda implements Function2<FlowCollector<? super MerchantImageResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $merchantId;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ String $shopId;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MerchantInfoEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantInfoEntityRepository$getMerchantImage$1(MerchantInfoEntityRepository merchantInfoEntityRepository, String str, String str2, int i, int i2, Continuation<? super MerchantInfoEntityRepository$getMerchantImage$1> continuation) {
        super(2, continuation);
        this.this$0 = merchantInfoEntityRepository;
        this.$merchantId = str;
        this.$shopId = str2;
        this.$pageNum = i;
        this.$pageSize = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MerchantInfoEntityRepository$getMerchantImage$1 merchantInfoEntityRepository$getMerchantImage$1 = new MerchantInfoEntityRepository$getMerchantImage$1(this.this$0, this.$merchantId, this.$shopId, this.$pageNum, this.$pageSize, continuation);
        merchantInfoEntityRepository$getMerchantImage$1.L$0 = obj;
        return merchantInfoEntityRepository$getMerchantImage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super MerchantImageResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((MerchantInfoEntityRepository$getMerchantImage$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r7 = r16
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L48
            if (r0 == r3) goto L3e
            if (r0 == r2) goto L20
            if (r0 != r1) goto L18
            kotlin.ResultKt.throwOnFailure(r17)
            goto La9
        L18:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L20:
            int r0 = r7.I$1
            int r2 = r7.I$0
            java.lang.Object r3 = r7.L$3
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult r3 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult) r3
            java.lang.Object r4 = r7.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r7.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r7.L$0
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r6 = (id.dana.data.nearbyme.repository.MerchantInfoEntityRepository) r6
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r15 = r3
            r3 = r2
            r2 = r4
            r4 = r5
            r5 = r15
            goto L8f
        L3e:
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            kotlin.ResultKt.throwOnFailure(r17)
            r3 = r17
            goto L6b
        L48:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r4 = r7.this$0
            id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData r9 = id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.access$getNetworkMerchantInfoEntityData$p(r4)
            java.lang.String r10 = r7.$merchantId
            java.lang.String r11 = r7.$shopId
            int r12 = r7.$pageNum
            int r13 = r7.$pageSize
            r14 = r7
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r7.L$0 = r0
            r7.label = r3
            java.lang.Object r3 = r9.getMerchantImage(r10, r11, r12, r13, r14)
            if (r3 != r8) goto L6b
            return r8
        L6b:
            id.dana.data.nearbyme.repository.MerchantInfoEntityRepository r6 = r7.this$0
            java.lang.String r4 = r7.$merchantId
            java.lang.String r5 = r7.$shopId
            int r9 = r7.$pageNum
            int r10 = r7.$pageSize
            id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult r3 = (id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult) r3
            r7.L$0 = r6
            r7.L$1 = r4
            r7.L$2 = r5
            r7.L$3 = r3
            r7.I$0 = r9
            r7.I$1 = r10
            r7.label = r2
            java.lang.Object r0 = r0.emit(r3, r7)
            if (r0 != r8) goto L8c
            return r8
        L8c:
            r2 = r5
            r5 = r3
            r3 = r9
        L8f:
            id.dana.data.nearbyme.repository.source.session.LocalMerchantInfoEntityData r0 = id.dana.data.nearbyme.repository.MerchantInfoEntityRepository.access$getLocalMerchantInfoEntityData$p(r6)
            r6 = 0
            r7.L$0 = r6
            r7.L$1 = r6
            r7.L$2 = r6
            r7.L$3 = r6
            r7.label = r1
            r1 = r4
            r4 = r10
            r6 = r16
            java.lang.Object r0 = r0.saveMerchantImage(r1, r2, r3, r4, r5, r6)
            if (r0 != r8) goto La9
            return r8
        La9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantInfoEntityRepository$getMerchantImage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
