package id.dana.data.referral;

import dagger.internal.Factory;
import id.dana.data.referral.source.ReferralEngagementEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralEngagementEntityRepository_Factory implements Factory<ReferralEngagementEntityRepository> {
    private final Provider<ReferralEngagementEntityDataFactory> referralEngagementEntityDataFactoryProvider;

    public ReferralEngagementEntityRepository_Factory(Provider<ReferralEngagementEntityDataFactory> provider) {
        this.referralEngagementEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ReferralEngagementEntityRepository get() {
        return newInstance(this.referralEngagementEntityDataFactoryProvider.get());
    }

    public static ReferralEngagementEntityRepository_Factory create(Provider<ReferralEngagementEntityDataFactory> provider) {
        return new ReferralEngagementEntityRepository_Factory(provider);
    }

    public static ReferralEngagementEntityRepository newInstance(ReferralEngagementEntityDataFactory referralEngagementEntityDataFactory) {
        return new ReferralEngagementEntityRepository(referralEngagementEntityDataFactory);
    }
}
