package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.model.QrisPaymentData;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisPaymentData_Factory implements Factory<GetQrisPaymentData> {
    private final Provider<QrPayRepository> qrPayRepositoryProvider;
    private final Provider<QrisPaymentData> qrisPaymentDataProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public GetQrisPaymentData_Factory(Provider<QrPayRepository> provider, Provider<QrisPaymentData> provider2, Provider<UserRepository> provider3) {
        this.qrPayRepositoryProvider = provider;
        this.qrisPaymentDataProvider = provider2;
        this.userRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetQrisPaymentData get() {
        return newInstance(this.qrPayRepositoryProvider.get(), this.qrisPaymentDataProvider.get(), this.userRepositoryProvider.get());
    }

    public static GetQrisPaymentData_Factory create(Provider<QrPayRepository> provider, Provider<QrisPaymentData> provider2, Provider<UserRepository> provider3) {
        return new GetQrisPaymentData_Factory(provider, provider2, provider3);
    }

    public static GetQrisPaymentData newInstance(QrPayRepository qrPayRepository, QrisPaymentData qrisPaymentData, UserRepository userRepository) {
        return new GetQrisPaymentData(qrPayRepository, qrisPaymentData, userRepository);
    }
}
