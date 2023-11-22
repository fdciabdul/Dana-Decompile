package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaymentCode_Factory implements Factory<GetPaymentCode> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public GetPaymentCode_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPaymentCode get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static GetPaymentCode_Factory create(Provider<QrPayRepository> provider) {
        return new GetPaymentCode_Factory(provider);
    }

    public static GetPaymentCode newInstance(QrPayRepository qrPayRepository) {
        return new GetPaymentCode(qrPayRepository);
    }
}
