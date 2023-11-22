package id.dana.drawable.merchantdetail;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class MerchantDetailView$setupAdapter$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MerchantDetailView$setupAdapter$1(Object obj) {
        super(0, obj, MerchantDetailView.class, "onLoadMoreReviewClicked", "onLoadMoreReviewClicked()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MerchantDetailView.access$onLoadMoreReviewClicked((MerchantDetailView) this.receiver);
    }
}
