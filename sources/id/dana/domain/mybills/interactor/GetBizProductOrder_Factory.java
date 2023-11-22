package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBizProductOrder_Factory implements Factory<GetBizProductOrder> {
    private final Provider<MyBillsRepository> myBillsRepositoryProvider;

    public GetBizProductOrder_Factory(Provider<MyBillsRepository> provider) {
        this.myBillsRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBizProductOrder get() {
        return newInstance(this.myBillsRepositoryProvider.get());
    }

    public static GetBizProductOrder_Factory create(Provider<MyBillsRepository> provider) {
        return new GetBizProductOrder_Factory(provider);
    }

    public static GetBizProductOrder newInstance(MyBillsRepository myBillsRepository) {
        return new GetBizProductOrder(myBillsRepository);
    }
}
