package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitOfflinePay_Factory implements Factory<InitOfflinePay> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public InitOfflinePay_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitOfflinePay get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static InitOfflinePay_Factory create(Provider<QrPayRepository> provider) {
        return new InitOfflinePay_Factory(provider);
    }

    public static InitOfflinePay newInstance(QrPayRepository qrPayRepository) {
        return new InitOfflinePay(qrPayRepository);
    }
}
