package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DoBrizziManualReversal_Factory implements Factory<DoBrizziManualReversal> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public DoBrizziManualReversal_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DoBrizziManualReversal get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static DoBrizziManualReversal_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new DoBrizziManualReversal_Factory(provider);
    }

    public static DoBrizziManualReversal newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new DoBrizziManualReversal(electronicmoneyRepository);
    }
}
