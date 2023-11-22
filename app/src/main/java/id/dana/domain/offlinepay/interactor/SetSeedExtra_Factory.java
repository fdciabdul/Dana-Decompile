package id.dana.domain.offlinepay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetSeedExtra_Factory implements Factory<SetSeedExtra> {
    private final Provider<QrPayRepository> paymentRepositoryProvider;

    public SetSeedExtra_Factory(Provider<QrPayRepository> provider) {
        this.paymentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetSeedExtra get() {
        return newInstance(this.paymentRepositoryProvider.get());
    }

    public static SetSeedExtra_Factory create(Provider<QrPayRepository> provider) {
        return new SetSeedExtra_Factory(provider);
    }

    public static SetSeedExtra newInstance(QrPayRepository qrPayRepository) {
        return new SetSeedExtra(qrPayRepository);
    }
}
