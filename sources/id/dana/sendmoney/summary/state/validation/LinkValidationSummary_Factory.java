package id.dana.sendmoney.summary.state.validation;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.ExpiryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class LinkValidationSummary_Factory implements Factory<LinkValidationSummary> {
    private final Provider<ExpiryContract.Presenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LinkValidationSummary(this.MyBillsEntityDataFactory.get());
    }
}
