package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsOfflinePayInitialized_Factory implements Factory<IsOfflinePayInitialized> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public IsOfflinePayInitialized_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsOfflinePayInitialized get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static IsOfflinePayInitialized_Factory create(Provider<QrPayRepository> provider) {
        return new IsOfflinePayInitialized_Factory(provider);
    }

    public static IsOfflinePayInitialized newInstance(QrPayRepository qrPayRepository) {
        return new IsOfflinePayInitialized(qrPayRepository);
    }
}
