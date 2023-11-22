package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.domain.nearbyme.model.MerchantCreateReview;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview", f = "CreateMerchantReview.kt", i = {}, l = {24, 26}, m = "execute", n = {}, s = {})
/* loaded from: classes4.dex */
public final class CreateMerchantReview$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreateMerchantReview this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateMerchantReview$execute$1(CreateMerchantReview createMerchantReview, Continuation<? super CreateMerchantReview$execute$1> continuation) {
        super(continuation);
        this.this$0 = createMerchantReview;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((MerchantCreateReview) null, (Continuation<? super Unit>) this);
    }
}
