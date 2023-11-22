package id.dana.sendmoney.summary.state.confirmation;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ContactConfirmationSummary_Factory implements Factory<ContactConfirmationSummary> {
    private final Provider<SendMoneyConfirmationContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactConfirmationSummary(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
