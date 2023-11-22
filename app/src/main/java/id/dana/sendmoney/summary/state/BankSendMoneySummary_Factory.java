package id.dana.sendmoney.summary.state;

import dagger.internal.Factory;
import id.dana.sendmoney.summary.state.confirmation.BankConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.BankLastTransferSummary;
import id.dana.sendmoney.summary.state.validation.BankValidationSummary;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BankSendMoneySummary_Factory implements Factory<BankSendMoneySummary> {
    private final Provider<BankValidationSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BankLastTransferSummary> PlaceComponentResult;
    private final Provider<BankConfirmationSummary> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankSendMoneySummary(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
