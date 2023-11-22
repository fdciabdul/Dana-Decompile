package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDecodedQrBarcode_Factory implements Factory<GetDecodedQrBarcode> {
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public GetDecodedQrBarcode_Factory(Provider<QrBarcodeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDecodedQrBarcode get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetDecodedQrBarcode_Factory create(Provider<QrBarcodeRepository> provider) {
        return new GetDecodedQrBarcode_Factory(provider);
    }

    public static GetDecodedQrBarcode newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new GetDecodedQrBarcode(qrBarcodeRepository);
    }
}
