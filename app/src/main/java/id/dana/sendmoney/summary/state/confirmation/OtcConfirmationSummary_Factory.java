package id.dana.sendmoney.summary.state.confirmation;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OtcConfirmationSummary_Factory implements Factory<OtcConfirmationSummary> {
    private final Provider<SendMoneyConfirmationContract.Presenter> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtcConfirmationSummary(this.PlaceComponentResult.get());
    }
}
