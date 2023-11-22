package id.dana.data.config.repository;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.mapper.DonationCampaignConfigMapper;
import id.dana.data.config.mapper.ExpiryInfoResultMapper;
import id.dana.data.config.mapper.GeofenceConfigMapper;
import id.dana.data.config.mapper.MaintenanceBroadcastResultMapper;
import id.dana.data.config.mapper.PromoCenterConfigMapper;
import id.dana.data.config.mapper.RequestMoneyInfoResultMapper;
import id.dana.data.config.mapper.SplitBillConfigMapper;
import id.dana.data.config.mapper.TwilioTimeoutConfigMapper;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.featureswitch.FeatureNonAMCSEntityDataFactory;
import id.dana.data.here.HereOauthManager;
import id.dana.data.homeinfo.repository.source.MaintenanceBroadcastDataFactory;
import id.dana.data.storage.GeneralPreferences;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeatureConfigEntityRepository_Factory implements Factory<FeatureConfigEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DanaProtectionInfoRepository> danaProtectionInfoRepositoryProvider;
    private final Provider<DonationCampaignConfigMapper> donationCampaignConfigMapperProvider;
    private final Provider<ExpiryInfoResultMapper> expiryInfoResultMapperProvider;
    private final Provider<FeatureNonAMCSEntityDataFactory> featureNonAMCSEntityDataFactoryProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<GeofenceConfigMapper> geofenceConfigMapperProvider;
    private final Provider<HereOauthManager> hereOauthManagerProvider;
    private final Provider<MaintenanceBroadcastDataFactory> maintenanceBroadcastDataFactoryProvider;
    private final Provider<MaintenanceBroadcastResultMapper> maintenanceBroadcastResultMapperProvider;
    private final Provider<PromoCenterConfigMapper> promoCenterConfigMapperProvider;
    private final Provider<RequestMoneyInfoResultMapper> requestMoneyInfoResultMapperProvider;
    private final Provider<SharedPrefScannerConfig> scannerConfigPreferenceProvider;
    private final Provider<SharedPrefCashierConfig> sharedPrefCashierConfigProvider;
    private final Provider<SplitBillConfigMapper> splitBillConfigMapperProvider;
    private final Provider<TwilioTimeoutConfigMapper> twilioTimeoutConfigMapperProvider;

    public FeatureConfigEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<MaintenanceBroadcastDataFactory> provider2, Provider<FeatureNonAMCSEntityDataFactory> provider3, Provider<MaintenanceBroadcastResultMapper> provider4, Provider<ExpiryInfoResultMapper> provider5, Provider<RequestMoneyInfoResultMapper> provider6, Provider<SplitBillConfigMapper> provider7, Provider<PromoCenterConfigMapper> provider8, Provider<GeofenceConfigMapper> provider9, Provider<DonationCampaignConfigMapper> provider10, Provider<TwilioTimeoutConfigMapper> provider11, Provider<GeneralPreferences> provider12, Provider<HereOauthManager> provider13, Provider<DanaProtectionInfoRepository> provider14, Provider<SharedPrefScannerConfig> provider15, Provider<SharedPrefCashierConfig> provider16) {
        this.configEntityDataFactoryProvider = provider;
        this.maintenanceBroadcastDataFactoryProvider = provider2;
        this.featureNonAMCSEntityDataFactoryProvider = provider3;
        this.maintenanceBroadcastResultMapperProvider = provider4;
        this.expiryInfoResultMapperProvider = provider5;
        this.requestMoneyInfoResultMapperProvider = provider6;
        this.splitBillConfigMapperProvider = provider7;
        this.promoCenterConfigMapperProvider = provider8;
        this.geofenceConfigMapperProvider = provider9;
        this.donationCampaignConfigMapperProvider = provider10;
        this.twilioTimeoutConfigMapperProvider = provider11;
        this.generalPreferencesProvider = provider12;
        this.hereOauthManagerProvider = provider13;
        this.danaProtectionInfoRepositoryProvider = provider14;
        this.scannerConfigPreferenceProvider = provider15;
        this.sharedPrefCashierConfigProvider = provider16;
    }

    @Override // javax.inject.Provider
    public final FeatureConfigEntityRepository get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.configEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.maintenanceBroadcastDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.featureNonAMCSEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.maintenanceBroadcastResultMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.expiryInfoResultMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.requestMoneyInfoResultMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.splitBillConfigMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.promoCenterConfigMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.geofenceConfigMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.donationCampaignConfigMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.twilioTimeoutConfigMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.hereOauthManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.danaProtectionInfoRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.scannerConfigPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefCashierConfigProvider));
    }

    public static FeatureConfigEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<MaintenanceBroadcastDataFactory> provider2, Provider<FeatureNonAMCSEntityDataFactory> provider3, Provider<MaintenanceBroadcastResultMapper> provider4, Provider<ExpiryInfoResultMapper> provider5, Provider<RequestMoneyInfoResultMapper> provider6, Provider<SplitBillConfigMapper> provider7, Provider<PromoCenterConfigMapper> provider8, Provider<GeofenceConfigMapper> provider9, Provider<DonationCampaignConfigMapper> provider10, Provider<TwilioTimeoutConfigMapper> provider11, Provider<GeneralPreferences> provider12, Provider<HereOauthManager> provider13, Provider<DanaProtectionInfoRepository> provider14, Provider<SharedPrefScannerConfig> provider15, Provider<SharedPrefCashierConfig> provider16) {
        return new FeatureConfigEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static FeatureConfigEntityRepository newInstance(Lazy<ConfigEntityDataFactory> lazy, Lazy<MaintenanceBroadcastDataFactory> lazy2, Lazy<FeatureNonAMCSEntityDataFactory> lazy3, Lazy<MaintenanceBroadcastResultMapper> lazy4, Lazy<ExpiryInfoResultMapper> lazy5, Lazy<RequestMoneyInfoResultMapper> lazy6, Lazy<SplitBillConfigMapper> lazy7, Lazy<PromoCenterConfigMapper> lazy8, Lazy<GeofenceConfigMapper> lazy9, Lazy<DonationCampaignConfigMapper> lazy10, Lazy<TwilioTimeoutConfigMapper> lazy11, Lazy<GeneralPreferences> lazy12, Lazy<HereOauthManager> lazy13, Lazy<DanaProtectionInfoRepository> lazy14, Lazy<SharedPrefScannerConfig> lazy15, Lazy<SharedPrefCashierConfig> lazy16) {
        return new FeatureConfigEntityRepository(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, lazy15, lazy16);
    }
}
