package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GenerateEmoneyTransId_Factory implements Factory<GenerateEmoneyTransId> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public GenerateEmoneyTransId_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GenerateEmoneyTransId get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static GenerateEmoneyTransId_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new GenerateEmoneyTransId_Factory(provider);
    }

    public static GenerateEmoneyTransId newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new GenerateEmoneyTransId(electronicmoneyRepository);
    }
}
