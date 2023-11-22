package id.dana.data.referral.source;

import dagger.internal.Factory;
import id.dana.data.referral.source.local.LocalReferralEngagementEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralEngagementEntityDataFactory_Factory implements Factory<ReferralEngagementEntityDataFactory> {
    private final Provider<LocalReferralEngagementEntityData> localReferralEngagementEntityDataProvider;

    public ReferralEngagementEntityDataFactory_Factory(Provider<LocalReferralEngagementEntityData> provider) {
        this.localReferralEngagementEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ReferralEngagementEntityDataFactory get() {
        return newInstance(this.localReferralEngagementEntityDataProvider.get());
    }

    public static ReferralEngagementEntityDataFactory_Factory create(Provider<LocalReferralEngagementEntityData> provider) {
        return new ReferralEngagementEntityDataFactory_Factory(provider);
    }

    public static ReferralEngagementEntityDataFactory newInstance(LocalReferralEngagementEntityData localReferralEngagementEntityData) {
        return new ReferralEngagementEntityDataFactory(localReferralEngagementEntityData);
    }
}
