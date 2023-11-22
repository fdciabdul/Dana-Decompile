package id.dana.data.donation.repository.source;

import dagger.internal.Factory;
import id.dana.data.donation.repository.source.network.NetworkDonationCampaignEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DonationCampaignDataFactory_Factory implements Factory<DonationCampaignDataFactory> {
    private final Provider<NetworkDonationCampaignEntityData> networkDonationCampaignEntityDataProvider;

    public DonationCampaignDataFactory_Factory(Provider<NetworkDonationCampaignEntityData> provider) {
        this.networkDonationCampaignEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DonationCampaignDataFactory get() {
        return newInstance(this.networkDonationCampaignEntityDataProvider.get());
    }

    public static DonationCampaignDataFactory_Factory create(Provider<NetworkDonationCampaignEntityData> provider) {
        return new DonationCampaignDataFactory_Factory(provider);
    }

    public static DonationCampaignDataFactory newInstance(NetworkDonationCampaignEntityData networkDonationCampaignEntityData) {
        return new DonationCampaignDataFactory(networkDonationCampaignEntityData);
    }
}
