package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMonthlyAmountMyBills_Factory implements Factory<GetMonthlyAmountMyBills> {
    private final Provider<MyBillsRepository> repositoryProvider;

    public GetMonthlyAmountMyBills_Factory(Provider<MyBillsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMonthlyAmountMyBills get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetMonthlyAmountMyBills_Factory create(Provider<MyBillsRepository> provider) {
        return new GetMonthlyAmountMyBills_Factory(provider);
    }

    public static GetMonthlyAmountMyBills newInstance(MyBillsRepository myBillsRepository) {
        return new GetMonthlyAmountMyBills(myBillsRepository);
    }
}
