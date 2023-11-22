package id.dana.data.referralwidget;

import dagger.internal.Factory;
import id.dana.data.referralwidget.mapper.ReferralWidgetMapper;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralWidgetEntityRepository_Factory implements Factory<ReferralWidgetEntityRepository> {
    private final Provider<ReferralWidgetEntityDataFactory> referralWidgetEntityDataFactoryProvider;
    private final Provider<ReferralWidgetMapper> referralWidgetMapperProvider;

    public ReferralWidgetEntityRepository_Factory(Provider<ReferralWidgetEntityDataFactory> provider, Provider<ReferralWidgetMapper> provider2) {
        this.referralWidgetEntityDataFactoryProvider = provider;
        this.referralWidgetMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralWidgetEntityRepository get() {
        return newInstance(this.referralWidgetEntityDataFactoryProvider.get(), this.referralWidgetMapperProvider.get());
    }

    public static ReferralWidgetEntityRepository_Factory create(Provider<ReferralWidgetEntityDataFactory> provider, Provider<ReferralWidgetMapper> provider2) {
        return new ReferralWidgetEntityRepository_Factory(provider, provider2);
    }

    public static ReferralWidgetEntityRepository newInstance(ReferralWidgetEntityDataFactory referralWidgetEntityDataFactory, ReferralWidgetMapper referralWidgetMapper) {
        return new ReferralWidgetEntityRepository(referralWidgetEntityDataFactory, referralWidgetMapper);
    }
}
