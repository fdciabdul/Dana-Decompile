package id.dana.data.account.clear.repository.source.preference;

import android.app.Application;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.data.danaprotection.repository.source.local.DanaProtectionInfoPreference;
import id.dana.data.deeplink.repository.source.local.DeepLinkPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferences;
import id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData;
import id.dana.data.homeinfo.repository.source.local.MaintenanceBroadcastPreference;
import id.dana.data.kycrenewal.repository.source.session.KycRenewalPreference;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.nearbyme.repository.source.local.PreferenceMerchantReviewFormEntityData;
import id.dana.data.promotion.repository.source.persistence.PromoPreference;
import id.dana.data.pushverify.source.local.LocalPushVerifyPreferenceEntityData;
import id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData;
import id.dana.data.referral.repository.source.local.ReferralPreferences;
import id.dana.data.registration.source.local.LocalRegistrationEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData;
import id.dana.data.storage.GeneralPreferences;
import id.dana.data.user.source.persistence.LocalUserInfoData;
import id.dana.data.user.source.persistence.UserInfoPreference;
import id.dana.data.userconfig.repository.source.local.UserConfigPreference;
import id.dana.data.userconsent.repository.source.local.UserConsentPreference;
import id.dana.data.usercredential.repository.source.local.CredentialPreference;
import id.dana.data.userpersonalization.source.local.UserPersonalizationPreferences;
import id.dana.data.wallet_v3.repository.source.local.WalletV3Preference;
import id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PreferenceClearAccountEntityData_Factory implements Factory<PreferenceClearAccountEntityData> {
    private final Provider<Application> contextProvider;
    private final Provider<CredentialPreference> credentialPreferenceProvider;
    private final Provider<DanaProtectionInfoPreference> danaProtectionInfoPreferenceProvider;
    private final Provider<DeepLinkPreferences> deepLinkPreferencesProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<H5ResponseCachePreferences> h5ResponseCachePreferencesProvider;
    private final Provider<KycRenewalPreference> kycRenewalPreferenceProvider;
    private final Provider<LocalPushVerifyPreferenceEntityData> localPushVerifyPreferenceEntityDataProvider;
    private final Provider<LocalRegistrationEntityData> localRegistrationEntityDataProvider;
    private final Provider<LocalUserInfoData> localUserInfoDataProvider;
    private final Provider<MaintenanceBroadcastPreference> maintenanceBroadcastPreferenceProvider;
    private final Provider<PreferenceMerchantReviewFormEntityData> merchantReviewPreferenceProvider;
    private final Provider<MiniProgramPreference> miniProgramPreferenceProvider;
    private final Provider<PersistenceHomeWidgetEntityData> persistenceHomeWidgetEntityDataProvider;
    private final Provider<PersistenceWalletV3EntityData> persistenceWalletV3EntityDataProvider;
    private final Provider<PromoPreference> promoPreferenceProvider;
    private final Provider<PersistenceRecentPayerEntityData> recentPayerEntityDataProvider;
    private final Provider<PersistenceRecentRecipientEntityData> recentRecipientEntityDataProvider;
    private final Provider<ReferralPreferences> referralPreferencesProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;
    private final Provider<SharedPrefCashierConfig> sharedPrefCashierConfigProvider;
    private final Provider<SharedPrefScannerConfig> sharedPrefScannerConfigProvider;
    private final Provider<SharedPrefSplitAttributes> sharedPrefSplitAttributesProvider;
    private final Provider<PersistenceSplitBillEntityData> splitBillEntityDataProvider;
    private final Provider<UserConfigPreference> userConfigPreferenceProvider;
    private final Provider<UserConsentPreference> userConsentPreferenceProvider;
    private final Provider<UserInfoPreference> userInfoPreferenceProvider;
    private final Provider<UserPersonalizationPreferences> userPersonalizationPreferencesProvider;
    private final Provider<WalletV3Preference> walletV3PreferenceProvider;

    public PreferenceClearAccountEntityData_Factory(Provider<DeepLinkPreferences> provider, Provider<H5ResponseCachePreferences> provider2, Provider<PersistenceRecentPayerEntityData> provider3, Provider<ReferralPreferences> provider4, Provider<PersistenceSplitBillEntityData> provider5, Provider<UserConfigPreference> provider6, Provider<PromoPreference> provider7, Provider<Application> provider8, Provider<PreferenceMerchantReviewFormEntityData> provider9, Provider<KycRenewalPreference> provider10, Provider<MaintenanceBroadcastPreference> provider11, Provider<UserConsentPreference> provider12, Provider<UserPersonalizationPreferences> provider13, Provider<UserInfoPreference> provider14, Provider<SharedPrefSplitAttributes> provider15, Provider<LocalUserInfoData> provider16, Provider<PersistenceWalletV3EntityData> provider17, Provider<WalletV3Preference> provider18, Provider<LocalRegistrationEntityData> provider19, Provider<PersistenceRecentRecipientEntityData> provider20, Provider<CredentialPreference> provider21, Provider<LocalPushVerifyPreferenceEntityData> provider22, Provider<DanaProtectionInfoPreference> provider23, Provider<SharedPrefCashierConfig> provider24, Provider<SharedPrefScannerConfig> provider25, Provider<PersistenceHomeWidgetEntityData> provider26, Provider<MiniProgramPreference> provider27, Provider<GeneralPreferences> provider28, Provider<SecurityGuardFacade> provider29) {
        this.deepLinkPreferencesProvider = provider;
        this.h5ResponseCachePreferencesProvider = provider2;
        this.recentPayerEntityDataProvider = provider3;
        this.referralPreferencesProvider = provider4;
        this.splitBillEntityDataProvider = provider5;
        this.userConfigPreferenceProvider = provider6;
        this.promoPreferenceProvider = provider7;
        this.contextProvider = provider8;
        this.merchantReviewPreferenceProvider = provider9;
        this.kycRenewalPreferenceProvider = provider10;
        this.maintenanceBroadcastPreferenceProvider = provider11;
        this.userConsentPreferenceProvider = provider12;
        this.userPersonalizationPreferencesProvider = provider13;
        this.userInfoPreferenceProvider = provider14;
        this.sharedPrefSplitAttributesProvider = provider15;
        this.localUserInfoDataProvider = provider16;
        this.persistenceWalletV3EntityDataProvider = provider17;
        this.walletV3PreferenceProvider = provider18;
        this.localRegistrationEntityDataProvider = provider19;
        this.recentRecipientEntityDataProvider = provider20;
        this.credentialPreferenceProvider = provider21;
        this.localPushVerifyPreferenceEntityDataProvider = provider22;
        this.danaProtectionInfoPreferenceProvider = provider23;
        this.sharedPrefCashierConfigProvider = provider24;
        this.sharedPrefScannerConfigProvider = provider25;
        this.persistenceHomeWidgetEntityDataProvider = provider26;
        this.miniProgramPreferenceProvider = provider27;
        this.generalPreferencesProvider = provider28;
        this.securityGuardFacadeProvider = provider29;
    }

    @Override // javax.inject.Provider
    public final PreferenceClearAccountEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.deepLinkPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.h5ResponseCachePreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.recentPayerEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.referralPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.splitBillEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.userConfigPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.promoPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.contextProvider), DoubleCheck.MyBillsEntityDataFactory(this.merchantReviewPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.kycRenewalPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.maintenanceBroadcastPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.userConsentPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.userPersonalizationPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.userInfoPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefSplitAttributesProvider), DoubleCheck.MyBillsEntityDataFactory(this.localUserInfoDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.persistenceWalletV3EntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.walletV3PreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.localRegistrationEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.recentRecipientEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.credentialPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.localPushVerifyPreferenceEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.danaProtectionInfoPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefCashierConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefScannerConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.persistenceHomeWidgetEntityDataProvider), DoubleCheck.MyBillsEntityDataFactory(this.miniProgramPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityGuardFacadeProvider));
    }

    public static PreferenceClearAccountEntityData_Factory create(Provider<DeepLinkPreferences> provider, Provider<H5ResponseCachePreferences> provider2, Provider<PersistenceRecentPayerEntityData> provider3, Provider<ReferralPreferences> provider4, Provider<PersistenceSplitBillEntityData> provider5, Provider<UserConfigPreference> provider6, Provider<PromoPreference> provider7, Provider<Application> provider8, Provider<PreferenceMerchantReviewFormEntityData> provider9, Provider<KycRenewalPreference> provider10, Provider<MaintenanceBroadcastPreference> provider11, Provider<UserConsentPreference> provider12, Provider<UserPersonalizationPreferences> provider13, Provider<UserInfoPreference> provider14, Provider<SharedPrefSplitAttributes> provider15, Provider<LocalUserInfoData> provider16, Provider<PersistenceWalletV3EntityData> provider17, Provider<WalletV3Preference> provider18, Provider<LocalRegistrationEntityData> provider19, Provider<PersistenceRecentRecipientEntityData> provider20, Provider<CredentialPreference> provider21, Provider<LocalPushVerifyPreferenceEntityData> provider22, Provider<DanaProtectionInfoPreference> provider23, Provider<SharedPrefCashierConfig> provider24, Provider<SharedPrefScannerConfig> provider25, Provider<PersistenceHomeWidgetEntityData> provider26, Provider<MiniProgramPreference> provider27, Provider<GeneralPreferences> provider28, Provider<SecurityGuardFacade> provider29) {
        return new PreferenceClearAccountEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29);
    }

    public static PreferenceClearAccountEntityData newInstance(Lazy<DeepLinkPreferences> lazy, Lazy<H5ResponseCachePreferences> lazy2, Lazy<PersistenceRecentPayerEntityData> lazy3, Lazy<ReferralPreferences> lazy4, Lazy<PersistenceSplitBillEntityData> lazy5, Lazy<UserConfigPreference> lazy6, Lazy<PromoPreference> lazy7, Lazy<Application> lazy8, Lazy<PreferenceMerchantReviewFormEntityData> lazy9, Lazy<KycRenewalPreference> lazy10, Lazy<MaintenanceBroadcastPreference> lazy11, Lazy<UserConsentPreference> lazy12, Lazy<UserPersonalizationPreferences> lazy13, Lazy<UserInfoPreference> lazy14, Lazy<SharedPrefSplitAttributes> lazy15, Lazy<LocalUserInfoData> lazy16, Lazy<PersistenceWalletV3EntityData> lazy17, Lazy<WalletV3Preference> lazy18, Lazy<LocalRegistrationEntityData> lazy19, Lazy<PersistenceRecentRecipientEntityData> lazy20, Lazy<CredentialPreference> lazy21, Lazy<LocalPushVerifyPreferenceEntityData> lazy22, Lazy<DanaProtectionInfoPreference> lazy23, Lazy<SharedPrefCashierConfig> lazy24, Lazy<SharedPrefScannerConfig> lazy25, Lazy<PersistenceHomeWidgetEntityData> lazy26, Lazy<MiniProgramPreference> lazy27, Lazy<GeneralPreferences> lazy28, Lazy<SecurityGuardFacade> lazy29) {
        return new PreferenceClearAccountEntityData(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, lazy15, lazy16, lazy17, lazy18, lazy19, lazy20, lazy21, lazy22, lazy23, lazy24, lazy25, lazy26, lazy27, lazy28, lazy29);
    }
}
