package id.dana.data.referral.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalReferralEngagementEntityData_Factory implements Factory<LocalReferralEngagementEntityData> {
    private final Provider<ReferralEngagementPreference> referralEngagementPreferenceProvider;

    public LocalReferralEngagementEntityData_Factory(Provider<ReferralEngagementPreference> provider) {
        this.referralEngagementPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalReferralEngagementEntityData get() {
        return newInstance(this.referralEngagementPreferenceProvider.get());
    }

    public static LocalReferralEngagementEntityData_Factory create(Provider<ReferralEngagementPreference> provider) {
        return new LocalReferralEngagementEntityData_Factory(provider);
    }

    public static LocalReferralEngagementEntityData newInstance(ReferralEngagementPreference referralEngagementPreference) {
        return new LocalReferralEngagementEntityData(referralEngagementPreference);
    }
}
