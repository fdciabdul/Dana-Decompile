package id.dana.sendmoney.summary.state.lasttransfer;

import dagger.internal.Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ContactLastTransferSummary_Factory implements Factory<ContactLastTransferSummary> {
    private final Provider<SendMoneyConfirmationContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactLastTransferSummary(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
