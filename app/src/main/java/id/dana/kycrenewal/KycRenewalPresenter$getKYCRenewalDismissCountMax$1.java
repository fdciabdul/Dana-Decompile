package id.dana.kycrenewal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import dagger.Lazy;
import id.dana.kycrenewal.KycRenewalContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class KycRenewalPresenter$getKYCRenewalDismissCountMax$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ KycRenewalPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KycRenewalPresenter$getKYCRenewalDismissCountMax$1(KycRenewalPresenter kycRenewalPresenter) {
        super(1);
        this.this$0 = kycRenewalPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        Lazy lazy;
        if (i == 1) {
            lazy = this.this$0.lookAheadTest;
            ((KycRenewalContract.View) lazy.get()).PlaceComponentResult();
        }
    }
}
