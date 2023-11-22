package id.dana.data.paymentsetting.repository.source.session;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreferencePaymentSettingEntityData_Factory implements Factory<PreferencePaymentSettingEntityData> {
    private final Provider<PaymentSettingPreference> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferencePaymentSettingEntityData(this.MyBillsEntityDataFactory.get());
    }
}
