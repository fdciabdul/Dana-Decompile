package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class StopOfflinePay_Factory implements Factory<StopOfflinePay> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public StopOfflinePay_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final StopOfflinePay get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static StopOfflinePay_Factory create(Provider<QrPayRepository> provider) {
        return new StopOfflinePay_Factory(provider);
    }

    public static StopOfflinePay newInstance(QrPayRepository qrPayRepository) {
        return new StopOfflinePay(qrPayRepository);
    }
}
