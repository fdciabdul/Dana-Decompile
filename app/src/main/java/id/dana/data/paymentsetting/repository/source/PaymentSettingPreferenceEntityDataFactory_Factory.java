package id.dana.data.paymentsetting.repository.source;

import dagger.internal.Factory;
import id.dana.data.paymentsetting.repository.source.session.PaymentSettingPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaymentSettingPreferenceEntityDataFactory_Factory implements Factory<PaymentSettingPreferenceEntityDataFactory> {
    private final Provider<PaymentSettingPreference> getAuthRequestContext;

    private PaymentSettingPreferenceEntityDataFactory_Factory(Provider<PaymentSettingPreference> provider) {
        this.getAuthRequestContext = provider;
    }

    public static PaymentSettingPreferenceEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<PaymentSettingPreference> provider) {
        return new PaymentSettingPreferenceEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSettingPreferenceEntityDataFactory(this.getAuthRequestContext.get());
    }
}
