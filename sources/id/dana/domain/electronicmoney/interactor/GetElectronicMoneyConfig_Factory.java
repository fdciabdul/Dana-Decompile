package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetElectronicMoneyConfig_Factory implements Factory<GetElectronicMoneyConfig> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public GetElectronicMoneyConfig_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetElectronicMoneyConfig get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static GetElectronicMoneyConfig_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new GetElectronicMoneyConfig_Factory(provider);
    }

    public static GetElectronicMoneyConfig newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new GetElectronicMoneyConfig(electronicmoneyRepository);
    }
}
