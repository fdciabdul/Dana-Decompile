package id.dana.domain.paymentsetting.interactor;

import dagger.internal.Factory;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePaymentSettingCheck_Factory implements Factory<SavePaymentSettingCheck> {
    private final Provider<PaymentSettingRepository> paymentSettingRepositoryProvider;

    public SavePaymentSettingCheck_Factory(Provider<PaymentSettingRepository> provider) {
        this.paymentSettingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePaymentSettingCheck get() {
        return newInstance(this.paymentSettingRepositoryProvider.get());
    }

    public static SavePaymentSettingCheck_Factory create(Provider<PaymentSettingRepository> provider) {
        return new SavePaymentSettingCheck_Factory(provider);
    }

    public static SavePaymentSettingCheck newInstance(PaymentSettingRepository paymentSettingRepository) {
        return new SavePaymentSettingCheck(paymentSettingRepository);
    }
}
