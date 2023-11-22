package id.dana.data.donation.repository.source;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DonationCampaignEntityRepository_Factory implements Factory<DonationCampaignEntityRepository> {
    private final Provider<DonationCampaignDataFactory> donationCampaignDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public DonationCampaignEntityRepository_Factory(Provider<DonationCampaignDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.donationCampaignDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DonationCampaignEntityRepository get() {
        return newInstance(this.donationCampaignDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static DonationCampaignEntityRepository_Factory create(Provider<DonationCampaignDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new DonationCampaignEntityRepository_Factory(provider, provider2);
    }

    public static DonationCampaignEntityRepository newInstance(DonationCampaignDataFactory donationCampaignDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new DonationCampaignEntityRepository(donationCampaignDataFactory, holdLoginV1EntityRepository);
    }
}
