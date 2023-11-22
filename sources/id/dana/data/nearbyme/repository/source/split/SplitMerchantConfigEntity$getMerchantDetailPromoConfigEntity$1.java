package id.dana.data.nearbyme.repository.source.split;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity", f = "SplitMerchantConfigEntity.kt", i = {}, l = {47}, m = "getMerchantDetailPromoConfigEntity", n = {}, s = {})
/* loaded from: classes2.dex */
public final class SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SplitMerchantConfigEntity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1(SplitMerchantConfigEntity splitMerchantConfigEntity, Continuation<? super SplitMerchantConfigEntity$getMerchantDetailPromoConfigEntity$1> continuation) {
        super(continuation);
        this.this$0 = splitMerchantConfigEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMerchantDetailPromoConfigEntity(this);
    }
}
