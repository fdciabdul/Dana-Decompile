package id.dana.sendmoney.summary.state;

import dagger.internal.Factory;
import id.dana.sendmoney.summary.state.confirmation.OtcConfirmationSummary;
import id.dana.sendmoney.summary.state.validation.OtcValidationSummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OtcSendMoneySummary_Factory implements Factory<OtcSendMoneySummary> {
    private final Provider<OtcValidationSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<OtcConfirmationSummary> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtcSendMoneySummary(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
