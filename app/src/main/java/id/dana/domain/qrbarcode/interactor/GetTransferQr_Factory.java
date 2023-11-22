package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTransferQr_Factory implements Factory<GetTransferQr> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public GetTransferQr_Factory(Provider<QrBarcodeRepository> provider, Provider<FeatureConfigRepository> provider2) {
        this.repositoryProvider = provider;
        this.featureConfigRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetTransferQr get() {
        return newInstance(this.repositoryProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static GetTransferQr_Factory create(Provider<QrBarcodeRepository> provider, Provider<FeatureConfigRepository> provider2) {
        return new GetTransferQr_Factory(provider, provider2);
    }

    public static GetTransferQr newInstance(QrBarcodeRepository qrBarcodeRepository, FeatureConfigRepository featureConfigRepository) {
        return new GetTransferQr(qrBarcodeRepository, featureConfigRepository);
    }
}
