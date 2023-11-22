package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PreCreateCashierOrder_Factory implements Factory<PreCreateCashierOrder> {
    private final Provider<QrBarcodeRepository> repositoryProvider;

    public PreCreateCashierOrder_Factory(Provider<QrBarcodeRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreCreateCashierOrder get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static PreCreateCashierOrder_Factory create(Provider<QrBarcodeRepository> provider) {
        return new PreCreateCashierOrder_Factory(provider);
    }

    public static PreCreateCashierOrder newInstance(QrBarcodeRepository qrBarcodeRepository) {
        return new PreCreateCashierOrder(qrBarcodeRepository);
    }
}
