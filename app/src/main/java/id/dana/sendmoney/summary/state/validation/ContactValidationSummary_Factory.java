package id.dana.sendmoney.summary.state.validation;

import dagger.internal.Factory;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ContactValidationSummary_Factory implements Factory<ContactValidationSummary> {
    private final Provider<SendMoneySummaryContract.Presenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactValidationSummary(this.MyBillsEntityDataFactory.get());
    }
}
