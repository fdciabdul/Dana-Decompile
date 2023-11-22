package id.dana.sendmoney.summary.state.lasttransfer;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BankLastTransferSummary_Factory implements Factory<BankLastTransferSummary> {
    private final Provider<SendMoneyConfirmationContract.Presenter> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankLastTransferSummary(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
