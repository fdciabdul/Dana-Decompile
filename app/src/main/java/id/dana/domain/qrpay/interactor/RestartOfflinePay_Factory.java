package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestartOfflinePay_Factory implements Factory<RestartOfflinePay> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public RestartOfflinePay_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RestartOfflinePay get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static RestartOfflinePay_Factory create(Provider<QrPayRepository> provider) {
        return new RestartOfflinePay_Factory(provider);
    }

    public static RestartOfflinePay newInstance(QrPayRepository qrPayRepository) {
        return new RestartOfflinePay(qrPayRepository);
    }
}
