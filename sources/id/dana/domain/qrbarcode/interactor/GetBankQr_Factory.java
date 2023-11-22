package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetBankQr_Factory implements Factory<GetBankQr> {
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public GetBankQr_Factory(Provider<QrBarcodeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBankQr get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetBankQr_Factory create(Provider<QrBarcodeRepository> provider) {
        return new GetBankQr_Factory(provider);
    }

    public static GetBankQr newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new GetBankQr(qrBarcodeRepository);
    }
}
