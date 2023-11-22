package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetBankTransferQr_Factory implements Factory<GetBankTransferQr> {
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public GetBankTransferQr_Factory(Provider<QrBarcodeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBankTransferQr get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetBankTransferQr_Factory create(Provider<QrBarcodeRepository> provider) {
        return new GetBankTransferQr_Factory(provider);
    }

    public static GetBankTransferQr newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new GetBankTransferQr(qrBarcodeRepository);
    }
}
