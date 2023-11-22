package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMonthlyWithConsultView_Factory implements Factory<GetMonthlyWithConsultView> {
    private final Provider<MyBillsRepository> repositoryProvider;

    public GetMonthlyWithConsultView_Factory(Provider<MyBillsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMonthlyWithConsultView get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetMonthlyWithConsultView_Factory create(Provider<MyBillsRepository> provider) {
        return new GetMonthlyWithConsultView_Factory(provider);
    }

    public static GetMonthlyWithConsultView newInstance(MyBillsRepository myBillsRepository) {
        return new GetMonthlyWithConsultView(myBillsRepository);
    }
}
