package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQuickBuyMyBills_Factory implements Factory<GetQuickBuyMyBills> {
    private final Provider<MyBillsRepository> repositoryProvider;

    public GetQuickBuyMyBills_Factory(Provider<MyBillsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQuickBuyMyBills get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetQuickBuyMyBills_Factory create(Provider<MyBillsRepository> provider) {
        return new GetQuickBuyMyBills_Factory(provider);
    }

    public static GetQuickBuyMyBills newInstance(MyBillsRepository myBillsRepository) {
        return new GetQuickBuyMyBills(myBillsRepository);
    }
}
