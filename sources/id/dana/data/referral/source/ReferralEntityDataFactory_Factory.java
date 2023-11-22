package id.dana.data.referral.source;

import dagger.internal.Factory;
import id.dana.data.referral.source.local.LocalReferralEntityData;
import id.dana.data.referral.source.network.NetworkReferralEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralEntityDataFactory_Factory implements Factory<ReferralEntityDataFactory> {
    private final Provider<LocalReferralEntityData> localReferralEntityDataProvider;
    private final Provider<NetworkReferralEntityData> networkReferralEntityDataProvider;

    public ReferralEntityDataFactory_Factory(Provider<NetworkReferralEntityData> provider, Provider<LocalReferralEntityData> provider2) {
        this.networkReferralEntityDataProvider = provider;
        this.localReferralEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralEntityDataFactory get() {
        return newInstance(this.networkReferralEntityDataProvider.get(), this.localReferralEntityDataProvider.get());
    }

    public static ReferralEntityDataFactory_Factory create(Provider<NetworkReferralEntityData> provider, Provider<LocalReferralEntityData> provider2) {
        return new ReferralEntityDataFactory_Factory(provider, provider2);
    }

    public static ReferralEntityDataFactory newInstance(NetworkReferralEntityData networkReferralEntityData, LocalReferralEntityData localReferralEntityData) {
        return new ReferralEntityDataFactory(networkReferralEntityData, localReferralEntityData);
    }
}
