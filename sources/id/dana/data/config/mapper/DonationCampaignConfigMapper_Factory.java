package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DonationCampaignConfigMapper_Factory implements Factory<DonationCampaignConfigMapper> {
    @Override // javax.inject.Provider
    public final DonationCampaignConfigMapper get() {
        return newInstance();
    }

    public static DonationCampaignConfigMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static DonationCampaignConfigMapper newInstance() {
        return new DonationCampaignConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DonationCampaignConfigMapper_Factory MyBillsEntityDataFactory = new DonationCampaignConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}
