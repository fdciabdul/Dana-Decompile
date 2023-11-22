package id.dana.domain.paymentsetting.interactor;

import dagger.internal.Factory;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PaymentSettingCheck_Factory implements Factory<PaymentSettingCheck> {
    private final Provider<PaymentSettingRepository> paymentSettingRepositoryProvider;

    public PaymentSettingCheck_Factory(Provider<PaymentSettingRepository> provider) {
        this.paymentSettingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PaymentSettingCheck get() {
        return newInstance(this.paymentSettingRepositoryProvider.get());
    }

    public static PaymentSettingCheck_Factory create(Provider<PaymentSettingRepository> provider) {
        return new PaymentSettingCheck_Factory(provider);
    }

    public static PaymentSettingCheck newInstance(PaymentSettingRepository paymentSettingRepository) {
        return new PaymentSettingCheck(paymentSettingRepository);
    }
}
