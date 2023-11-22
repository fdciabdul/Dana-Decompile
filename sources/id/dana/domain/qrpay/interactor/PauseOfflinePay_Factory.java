package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PauseOfflinePay_Factory implements Factory<PauseOfflinePay> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public PauseOfflinePay_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PauseOfflinePay get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static PauseOfflinePay_Factory create(Provider<QrPayRepository> provider) {
        return new PauseOfflinePay_Factory(provider);
    }

    public static PauseOfflinePay newInstance(QrPayRepository qrPayRepository) {
        return new PauseOfflinePay(qrPayRepository);
    }
}
