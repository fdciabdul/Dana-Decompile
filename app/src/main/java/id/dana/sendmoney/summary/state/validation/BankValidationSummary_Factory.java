package id.dana.sendmoney.summary.state.validation;

import dagger.internal.Factory;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BankValidationSummary_Factory implements Factory<BankValidationSummary> {
    private final Provider<SendMoneySummaryContract.Presenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankValidationSummary(this.MyBillsEntityDataFactory.get());
    }
}
