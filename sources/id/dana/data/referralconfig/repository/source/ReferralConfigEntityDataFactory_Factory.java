package id.dana.data.referralconfig.repository.source;

import dagger.internal.Factory;
import id.dana.data.referralconfig.repository.source.local.DefaultReferralConfigEntityData;
import id.dana.data.referralconfig.repository.source.split.SplitReferralConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralConfigEntityDataFactory_Factory implements Factory<ReferralConfigEntityDataFactory> {
    private final Provider<DefaultReferralConfigEntityData> defaultReferralConfigEntityDataProvider;
    private final Provider<SplitReferralConfigEntityData> splitReferralConfigEntityDataProvider;

    public ReferralConfigEntityDataFactory_Factory(Provider<DefaultReferralConfigEntityData> provider, Provider<SplitReferralConfigEntityData> provider2) {
        this.defaultReferralConfigEntityDataProvider = provider;
        this.splitReferralConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralConfigEntityDataFactory get() {
        return newInstance(this.defaultReferralConfigEntityDataProvider.get(), this.splitReferralConfigEntityDataProvider.get());
    }

    public static ReferralConfigEntityDataFactory_Factory create(Provider<DefaultReferralConfigEntityData> provider, Provider<SplitReferralConfigEntityData> provider2) {
        return new ReferralConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static ReferralConfigEntityDataFactory newInstance(DefaultReferralConfigEntityData defaultReferralConfigEntityData, SplitReferralConfigEntityData splitReferralConfigEntityData) {
        return new ReferralConfigEntityDataFactory(defaultReferralConfigEntityData, splitReferralConfigEntityData);
    }
}
