package id.dana.data.referraltracker.source;

import dagger.internal.Factory;
import id.dana.data.referraltracker.source.mock.MockReferralTrackerEntityData;
import id.dana.data.referraltracker.source.network.NetworkReferralTrackerEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralTrackerEntityDataFactory_Factory implements Factory<ReferralTrackerEntityDataFactory> {
    private final Provider<MockReferralTrackerEntityData> mockReferralTrackerEntityDataProvider;
    private final Provider<NetworkReferralTrackerEntityData> networkReferralTrackerEntityDataProvider;

    public ReferralTrackerEntityDataFactory_Factory(Provider<NetworkReferralTrackerEntityData> provider, Provider<MockReferralTrackerEntityData> provider2) {
        this.networkReferralTrackerEntityDataProvider = provider;
        this.mockReferralTrackerEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralTrackerEntityDataFactory get() {
        return newInstance(this.networkReferralTrackerEntityDataProvider.get(), this.mockReferralTrackerEntityDataProvider.get());
    }

    public static ReferralTrackerEntityDataFactory_Factory create(Provider<NetworkReferralTrackerEntityData> provider, Provider<MockReferralTrackerEntityData> provider2) {
        return new ReferralTrackerEntityDataFactory_Factory(provider, provider2);
    }

    public static ReferralTrackerEntityDataFactory newInstance(NetworkReferralTrackerEntityData networkReferralTrackerEntityData, MockReferralTrackerEntityData mockReferralTrackerEntityData) {
        return new ReferralTrackerEntityDataFactory(networkReferralTrackerEntityData, mockReferralTrackerEntityData);
    }
}
