package id.dana.data.globalnetwork;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.geocode.repository.source.GeocodeEntityDataFactory;
import id.dana.data.globalnetwork.mapper.ForexResultMapper;
import id.dana.data.globalnetwork.mapper.GnConsultMapper;
import id.dana.data.globalnetwork.source.GlobalNetworkDataFactory;
import id.dana.data.globalnetwork.source.GnConfigDataFactory;
import id.dana.data.globalnetwork.source.GnPaymentDataFactory;
import id.dana.data.globalnetwork.source.UniPaymentDataFactory;
import id.dana.data.globalnetwork.source.local.PreferenceGnPaymentEntityData;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.risk.riskevent.SendRiskEventEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalNetworkEntityRepository_Factory implements Factory<GlobalNetworkEntityRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<ForexResultMapper> forexResultMapperProvider;
    private final Provider<GeocodeEntityDataFactory> geocodeEntityDataFactoryProvider;
    private final Provider<GlobalNetworkDataFactory> globalNetworkDataFactoryProvider;
    private final Provider<GnConfigDataFactory> gnConfigDataFactoryProvider;
    private final Provider<GnConsultMapper> gnConsultMapperProvider;
    private final Provider<GnPaymentDataFactory> gnPaymentDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PreferenceGnPaymentEntityData> preferenceGnPaymentEntityDataProvider;
    private final Provider<SendRiskEventEntityDataFactory> sendRiskEventEntityDataFactoryProvider;
    private final Provider<UniPaymentDataFactory> uniPaymentDataFactoryProvider;
    private final Provider<UserLocation> userLocationProvider;

    public GlobalNetworkEntityRepository_Factory(Provider<GlobalNetworkDataFactory> provider, Provider<ForexResultMapper> provider2, Provider<GnConsultMapper> provider3, Provider<GnPaymentDataFactory> provider4, Provider<UniPaymentDataFactory> provider5, Provider<PreferenceGnPaymentEntityData> provider6, Provider<UserLocation> provider7, Provider<SendRiskEventEntityDataFactory> provider8, Provider<GnConfigDataFactory> provider9, Provider<GeocodeEntityDataFactory> provider10, Provider<Context> provider11, Provider<HoldLoginV1EntityRepository> provider12) {
        this.globalNetworkDataFactoryProvider = provider;
        this.forexResultMapperProvider = provider2;
        this.gnConsultMapperProvider = provider3;
        this.gnPaymentDataFactoryProvider = provider4;
        this.uniPaymentDataFactoryProvider = provider5;
        this.preferenceGnPaymentEntityDataProvider = provider6;
        this.userLocationProvider = provider7;
        this.sendRiskEventEntityDataFactoryProvider = provider8;
        this.gnConfigDataFactoryProvider = provider9;
        this.geocodeEntityDataFactoryProvider = provider10;
        this.contextProvider = provider11;
        this.holdLoginV1EntityRepositoryProvider = provider12;
    }

    @Override // javax.inject.Provider
    public final GlobalNetworkEntityRepository get() {
        return newInstance(this.globalNetworkDataFactoryProvider.get(), this.forexResultMapperProvider.get(), this.gnConsultMapperProvider.get(), this.gnPaymentDataFactoryProvider.get(), this.uniPaymentDataFactoryProvider.get(), this.preferenceGnPaymentEntityDataProvider.get(), this.userLocationProvider.get(), this.sendRiskEventEntityDataFactoryProvider.get(), this.gnConfigDataFactoryProvider.get(), this.geocodeEntityDataFactoryProvider.get(), this.contextProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static GlobalNetworkEntityRepository_Factory create(Provider<GlobalNetworkDataFactory> provider, Provider<ForexResultMapper> provider2, Provider<GnConsultMapper> provider3, Provider<GnPaymentDataFactory> provider4, Provider<UniPaymentDataFactory> provider5, Provider<PreferenceGnPaymentEntityData> provider6, Provider<UserLocation> provider7, Provider<SendRiskEventEntityDataFactory> provider8, Provider<GnConfigDataFactory> provider9, Provider<GeocodeEntityDataFactory> provider10, Provider<Context> provider11, Provider<HoldLoginV1EntityRepository> provider12) {
        return new GlobalNetworkEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static GlobalNetworkEntityRepository newInstance(GlobalNetworkDataFactory globalNetworkDataFactory, ForexResultMapper forexResultMapper, GnConsultMapper gnConsultMapper, GnPaymentDataFactory gnPaymentDataFactory, UniPaymentDataFactory uniPaymentDataFactory, PreferenceGnPaymentEntityData preferenceGnPaymentEntityData, UserLocation userLocation, SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory, GnConfigDataFactory gnConfigDataFactory, GeocodeEntityDataFactory geocodeEntityDataFactory, Context context, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new GlobalNetworkEntityRepository(globalNetworkDataFactory, forexResultMapper, gnConsultMapper, gnPaymentDataFactory, uniPaymentDataFactory, preferenceGnPaymentEntityData, userLocation, sendRiskEventEntityDataFactory, gnConfigDataFactory, geocodeEntityDataFactory, context, holdLoginV1EntityRepository);
    }
}
