package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTopUpCommandEmoney_Factory implements Factory<GetTopUpCommandEmoney> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public GetTopUpCommandEmoney_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTopUpCommandEmoney get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static GetTopUpCommandEmoney_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new GetTopUpCommandEmoney_Factory(provider);
    }

    public static GetTopUpCommandEmoney newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new GetTopUpCommandEmoney(electronicmoneyRepository);
    }
}
