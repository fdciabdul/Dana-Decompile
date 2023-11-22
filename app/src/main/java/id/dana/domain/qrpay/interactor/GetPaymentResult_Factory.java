package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaymentResult_Factory implements Factory<GetPaymentResult> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public GetPaymentResult_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPaymentResult get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static GetPaymentResult_Factory create(Provider<QrPayRepository> provider) {
        return new GetPaymentResult_Factory(provider);
    }

    public static GetPaymentResult newInstance(QrPayRepository qrPayRepository) {
        return new GetPaymentResult(qrPayRepository);
    }
}
