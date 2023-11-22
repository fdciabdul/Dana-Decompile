package id.dana.data.account.repository.source.preference;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.twilio.repository.source.local.TwilioConsultBackendPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceAccountEntityData_Factory implements Factory<PreferenceAccountEntityData> {
    private final Provider<SecuredAccountPreferences> accountPreferencesProvider;
    private final Provider<LoginLogoutSubject> loginLogoutSubjectProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;
    private final Provider<TwilioConsultBackendPreferences> twilioConsultBackendPreferencesProvider;

    public PreferenceAccountEntityData_Factory(Provider<SecuredAccountPreferences> provider, Provider<SecurityGuardFacade> provider2, Provider<TwilioConsultBackendPreferences> provider3, Provider<LoginLogoutSubject> provider4) {
        this.accountPreferencesProvider = provider;
        this.securityGuardFacadeProvider = provider2;
        this.twilioConsultBackendPreferencesProvider = provider3;
        this.loginLogoutSubjectProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final PreferenceAccountEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.accountPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityGuardFacadeProvider), DoubleCheck.MyBillsEntityDataFactory(this.twilioConsultBackendPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.loginLogoutSubjectProvider));
    }

    public static PreferenceAccountEntityData_Factory create(Provider<SecuredAccountPreferences> provider, Provider<SecurityGuardFacade> provider2, Provider<TwilioConsultBackendPreferences> provider3, Provider<LoginLogoutSubject> provider4) {
        return new PreferenceAccountEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static PreferenceAccountEntityData newInstance(Lazy<SecuredAccountPreferences> lazy, Lazy<SecurityGuardFacade> lazy2, Lazy<TwilioConsultBackendPreferences> lazy3, Lazy<LoginLogoutSubject> lazy4) {
        return new PreferenceAccountEntityData(lazy, lazy2, lazy3, lazy4);
    }
}
