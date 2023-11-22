package id.dana.sendmoney.summary.state.confirmation;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class LinkConfirmationSummary_Factory implements Factory<LinkConfirmationSummary> {
    private final Provider<SendMoneyConfirmationBankContract.Presenter> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LinkConfirmationSummary(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
