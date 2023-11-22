package id.dana.data.referralwidget.repository.source;

import dagger.internal.Factory;
import id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData;
import id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralWidgetEntityDataFactory_Factory implements Factory<ReferralWidgetEntityDataFactory> {
    private final Provider<DefaultReferralWidgetEntityData> defaultReferralPageEntityDataProvider;
    private final Provider<SplitReferralWidgetEntityData> splitReferralWidgetEntityDataProvider;

    public ReferralWidgetEntityDataFactory_Factory(Provider<SplitReferralWidgetEntityData> provider, Provider<DefaultReferralWidgetEntityData> provider2) {
        this.splitReferralWidgetEntityDataProvider = provider;
        this.defaultReferralPageEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralWidgetEntityDataFactory get() {
        return newInstance(this.splitReferralWidgetEntityDataProvider.get(), this.defaultReferralPageEntityDataProvider.get());
    }

    public static ReferralWidgetEntityDataFactory_Factory create(Provider<SplitReferralWidgetEntityData> provider, Provider<DefaultReferralWidgetEntityData> provider2) {
        return new ReferralWidgetEntityDataFactory_Factory(provider, provider2);
    }

    public static ReferralWidgetEntityDataFactory newInstance(SplitReferralWidgetEntityData splitReferralWidgetEntityData, DefaultReferralWidgetEntityData defaultReferralWidgetEntityData) {
        return new ReferralWidgetEntityDataFactory(splitReferralWidgetEntityData, defaultReferralWidgetEntityData);
    }
}
