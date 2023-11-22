package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMerchantQrWhitelist_Factory implements Factory<GetMerchantQrWhitelist> {
    private final Provider<QrBarcodeRepository> qrBarcodeRepositoryProvider;

    public GetMerchantQrWhitelist_Factory(Provider<QrBarcodeRepository> provider) {
        this.qrBarcodeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMerchantQrWhitelist get() {
        return newInstance(this.qrBarcodeRepositoryProvider.get());
    }

    public static GetMerchantQrWhitelist_Factory create(Provider<QrBarcodeRepository> provider) {
        return new GetMerchantQrWhitelist_Factory(provider);
    }

    public static GetMerchantQrWhitelist newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new GetMerchantQrWhitelist(qrBarcodeRepository);
    }
}
