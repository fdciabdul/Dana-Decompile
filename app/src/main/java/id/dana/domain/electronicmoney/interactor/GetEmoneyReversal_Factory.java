package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetEmoneyReversal_Factory implements Factory<GetEmoneyReversal> {
    private final Provider<ElectronicmoneyRepository> repositoryProvider;

    public GetEmoneyReversal_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetEmoneyReversal get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetEmoneyReversal_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new GetEmoneyReversal_Factory(provider);
    }

    public static GetEmoneyReversal newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new GetEmoneyReversal(electronicmoneyRepository);
    }
}
