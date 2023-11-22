package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetMonthlyAmountMyBills_Factory implements Factory<GetMonthlyAmountMyBills> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMonthlyAmountMyBills(this.getAuthRequestContext.get());
    }
}
