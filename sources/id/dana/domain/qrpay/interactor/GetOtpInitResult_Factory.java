package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOtpInitResult_Factory implements Factory<GetOtpInitResult> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;

    public GetOtpInitResult_Factory(Provider<QrPayRepository> provider) {
        this.qrPayRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOtpInitResult get() {
        return newInstance(this.qrPayRepositoryProvider.get());
    }

    public static GetOtpInitResult_Factory create(Provider<QrPayRepository> provider) {
        return new GetOtpInitResult_Factory(provider);
    }

    public static GetOtpInitResult newInstance(QrPayRepository qrPayRepository) {
        return new GetOtpInitResult(qrPayRepository);
    }
}
