package id.dana.data.nearbyme.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.data.nearbyme.repository.MerchantConfigEntityRepository", f = "MerchantConfigEntityRepository.kt", i = {}, l = {50}, m = "getMerchantDetailPromoConfig", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MerchantConfigEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1(MerchantConfigEntityRepository merchantConfigEntityRepository, Continuation<? super MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1> continuation) {
        super(continuation);
        this.this$0 = merchantConfigEntityRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMerchantDetailPromoConfig(this);
    }
}
