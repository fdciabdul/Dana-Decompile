package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class StartOfflinePay_Factory implements Factory<StartOfflinePay> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public StartOfflinePay_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final StartOfflinePay get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static StartOfflinePay_Factory create(Provider<QrPayRepository> provider) {
        return new StartOfflinePay_Factory(provider);
    }

    public static StartOfflinePay newInstance(QrPayRepository qrPayRepository) {
        return new StartOfflinePay(qrPayRepository);
    }
}
