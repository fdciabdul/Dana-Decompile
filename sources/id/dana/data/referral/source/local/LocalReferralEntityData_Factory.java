package id.dana.data.referral.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalReferralEntityData_Factory implements Factory<LocalReferralEntityData> {
    private final Provider<ReferralEngagementPreference> referralEngagementPreferenceProvider;

    public LocalReferralEntityData_Factory(Provider<ReferralEngagementPreference> provider) {
        this.referralEngagementPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalReferralEntityData get() {
        return newInstance(this.referralEngagementPreferenceProvider.get());
    }

    public static LocalReferralEntityData_Factory create(Provider<ReferralEngagementPreference> provider) {
        return new LocalReferralEntityData_Factory(provider);
    }

    public static LocalReferralEntityData newInstance(ReferralEngagementPreference referralEngagementPreference) {
        return new LocalReferralEntityData(referralEngagementPreference);
    }
}
