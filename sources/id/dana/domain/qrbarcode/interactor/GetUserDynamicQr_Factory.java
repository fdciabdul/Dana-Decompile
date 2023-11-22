package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserDynamicQr_Factory implements Factory<GetUserDynamicQr> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<QrBarcodeRepository> qrBarcodeRepositoryProvider;

    public GetUserDynamicQr_Factory(Provider<QrBarcodeRepository> provider, Provider<FeatureConfigRepository> provider2) {
        this.qrBarcodeRepositoryProvider = provider;
        this.featureConfigRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetUserDynamicQr get() {
        return newInstance(this.qrBarcodeRepositoryProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static GetUserDynamicQr_Factory create(Provider<QrBarcodeRepository> provider, Provider<FeatureConfigRepository> provider2) {
        return new GetUserDynamicQr_Factory(provider, provider2);
    }

    public static GetUserDynamicQr newInstance(QrBarcodeRepository qrBarcodeRepository, FeatureConfigRepository featureConfigRepository) {
        return new GetUserDynamicQr(qrBarcodeRepository, featureConfigRepository);
    }
}
