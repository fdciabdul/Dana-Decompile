package id.dana.data.referral.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalMyReferralConsultEntityData_Factory implements Factory<LocalMyReferralConsultEntityData> {
    private final Provider<ReferralPreferences> referralPreferencesProvider;

    public LocalMyReferralConsultEntityData_Factory(Provider<ReferralPreferences> provider) {
        this.referralPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalMyReferralConsultEntityData get() {
        return newInstance(this.referralPreferencesProvider.get());
    }

    public static LocalMyReferralConsultEntityData_Factory create(Provider<ReferralPreferences> provider) {
        return new LocalMyReferralConsultEntityData_Factory(provider);
    }

    public static LocalMyReferralConsultEntityData newInstance(ReferralPreferences referralPreferences) {
        return new LocalMyReferralConsultEntityData(referralPreferences);
    }
}
