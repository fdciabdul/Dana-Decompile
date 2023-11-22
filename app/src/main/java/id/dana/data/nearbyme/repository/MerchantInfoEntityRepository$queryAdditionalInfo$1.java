package id.dana.data.nearbyme.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.data.nearbyme.repository.MerchantInfoEntityRepository", f = "MerchantInfoEntityRepository.kt", i = {}, l = {167}, m = "queryAdditionalInfo", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MerchantInfoEntityRepository$queryAdditionalInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MerchantInfoEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantInfoEntityRepository$queryAdditionalInfo$1(MerchantInfoEntityRepository merchantInfoEntityRepository, Continuation<? super MerchantInfoEntityRepository$queryAdditionalInfo$1> continuation) {
        super(continuation);
        this.this$0 = merchantInfoEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queryAdditionalInfo(null, null, this);
    }
}
