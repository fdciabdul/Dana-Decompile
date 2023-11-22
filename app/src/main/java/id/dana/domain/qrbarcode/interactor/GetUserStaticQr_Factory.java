package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserStaticQr_Factory implements Factory<GetUserStaticQr> {
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public GetUserStaticQr_Factory(Provider<QrBarcodeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserStaticQr get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetUserStaticQr_Factory create(Provider<QrBarcodeRepository> provider) {
        return new GetUserStaticQr_Factory(provider);
    }

    public static GetUserStaticQr newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new GetUserStaticQr(qrBarcodeRepository);
    }
}
