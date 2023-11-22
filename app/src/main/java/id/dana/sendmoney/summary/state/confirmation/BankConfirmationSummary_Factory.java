package id.dana.sendmoney.summary.state.confirmation;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BankConfirmationSummary_Factory implements Factory<BankConfirmationSummary> {
    private final Provider<SendMoneyConfirmationBankContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankConfirmationSummary(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
