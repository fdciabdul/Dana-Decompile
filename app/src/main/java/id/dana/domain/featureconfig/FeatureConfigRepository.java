package id.dana.domain.featureconfig;

import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import id.dana.domain.featureconfig.model.CashierPaymentAutorouteConfig;
import id.dana.domain.featureconfig.model.ContactInjectionConfig;
import id.dana.domain.featureconfig.model.DealsConfig;
import id.dana.domain.featureconfig.model.DeepLinkFeatureSwitchModel;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.ExpiryInfo;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import id.dana.domain.featureconfig.model.GeofenceConfig;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.MarmotConfig;
import id.dana.domain.featureconfig.model.MccListConfig;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.featureconfig.model.ShowAlipayConnectBrandConfig;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.domain.featureconfig.model.TwilioTimeoutConfig;
import id.dana.domain.featureconfig.model.UgcConfig;
import id.dana.domain.login.model.LoginRegisterConfig;
import id.dana.domain.maintenance.model.BroadcastSavingStateResult;
import id.dana.domain.maintenance.model.MaintenanceBroadcast;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.NearbyWidgetConfig;
import id.dana.domain.oauth.model.GnBindingBenefit;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.domain.promocenter.model.PromoAdsConfig;
import id.dana.domain.qriscrossborder.model.QrisCrossBorderContent;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.x2l.model.BannerConfig;
import id.dana.domain.sendmoney.x2l.model.SocialLink;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.domain.transactionhistory.model.TransactionHistoryConfig;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;

/* loaded from: classes2.dex */
public interface FeatureConfigRepository {
    Observable<DeepLinkFeatureSwitchModel> checkDeepLinkFeatureVisibility(String str);

    Observable<Boolean> checkDexguardHookCheckFeature();

    Observable<Boolean> checkDexguardRootCheckFeature();

    Observable<Boolean> checkDexguardTamperCheckFeature();

    Observable<Boolean> checkIsResendWhatsAppEnable();

    Observable<Boolean> checkVisibilityFeature(String str);

    Observable<Set<String>> getAddingNameWhitelistedSubMerchantId();

    Observable<Boolean> getAppShortcutEnabled();

    Observable<BroadcastSavingStateResult> getBroadcastSavingState(String str);

    Observable<CashierPaymentAutorouteConfig> getCashierAutorouteConfig();

    Observable<CashierMerchantWhitelistConfig> getCashierMerchantWhitelistConfig();

    Observable<List<String>> getCashierNativeEntryPoints();

    Observable<ContactInjectionConfig> getContactInjectionConfig();

    Observable<List<String>> getCustomLoading3dsUrls();

    Observable<DanaProtectionWidgetConfig> getDanaProtectionWidgetConfig();

    Observable<DealsConfig> getDealsConfig();

    Observable<Long> getDecodeQrTimeout();

    Observable<MccListConfig> getDecodeTciCoListConfig();

    Observable<DonationCampaignConfig> getDonationCampaignConfig();

    Observable<EmergencyNotificationConfig> getEmergencyNotifConfig();

    Observable<ExpressPayInfo> getEnableExpressPayInfo();

    Observable<List<ExpiryInfo>> getExpiryChoice();

    Observable<List<ExpiryTimeConfig>> getExpiryTimeConfig();

    Observable<DanaVizEntryPointConfig> getFeatureDanaVizEntryPointConfig();

    Observable<Boolean> getFeatureForcedFirstCard();

    Observable<List<String>> getFeatureSendMoneyCashierNative();

    Observable<Set<String>> getFeatureSkipButtonMerchantList();

    Observable<GeofenceConfig> getGeofenceConfig();

    Observable<List<GnBindingBenefit>> getGnBindingBenefits();

    Observable<HelpButtonChatBot> getHelpButtonChatbotConfig();

    Observable<LoginRegisterConfig> getLoginRegisterConfig();

    Observable<MarmotConfig> getMarmotConfig();

    Observable<Integer> getMaxBankAccount();

    Observable<Integer> getMinimumRadiusInMeter();

    Observable<HashMap<String, Object>> getMultipleValueConfig(String str);

    Observable<NearbyConfig> getNearbyConfig();

    Observable<NearbyWidgetConfig> getNearbyWidgetConfig();

    Observable<OnboardingWarningTextConfig> getOnboardingWarningTextConfig();

    Observable<Integer> getPaymentCodeDigit();

    Observable<List<PersonalizedReferralConfig>> getPersonalizedReferralConfig();

    Observable<List<String>> getPreventScreenshotConfig();

    Observable<PromoAdsConfig> getPromoAdsFeatureConfig();

    Observable<Boolean> getPromoBannerSliderItemNewSizeEnabled();

    Observable<PromoCenterConfig> getPromoCenterConfig();

    Observable<Integer> getPromoCenterVersion();

    Observable<QrBindingConfig> getQrBindingConfig();

    Observable<Integer> getQrCount();

    Observable<List<String>> getQrisCpmPrefixes();

    Observable<QrisCrossBorderContent> getQrisCrossBorderContent(String str);

    Observable<List<String>> getQrisCrossBorderSupportedCountries();

    Observable<QrisTciCoConfig> getQrisTcicoConfig();

    Observable<QueryUserDataConfig> getQueryUserDataConfig();

    Observable<ReferralMessageTemplateConfig> getReferralMessageTemplate();

    Observable<RequestMoneyInfo> getRequestMoneyInfo();

    Observable<ResetAndChangePinNativeEntryConfig> getResetAndChangePinNativeConfig();

    Observable<Boolean> getSendMoneyFeedConfig();

    Observable<Integer> getSendMoneyNoteCharLimit();

    Observable<Long> getSendMoneyRefundTimeout();

    Observable<BannerConfig> getSendToLinkBannerConfig();

    Observable<ShowAlipayConnectBrandConfig> getShowAlipayConnectBrandConfig();

    Observable<SmartFrictionConfig> getSmartFrictionConfig();

    Observable<List<SocialLink>> getSocialLinks();

    Observable<List<String>> getSocialMediaCategoryShare();

    Observable<SplitBillConfig> getSplitBillConfig();

    Observable<List<String>> getStatementDisableDetailConfig();

    Observable<SyncContactSplitConfigModel> getSyncContactWithNameConfig();

    Observable<String> getTnCReferralMissionConfig();

    Observable<TransactionHistoryConfig> getTransactionHistoryConfig();

    Observable<Boolean> getTwilioManualCheckConfig();

    Observable<TwilioTimeoutConfig> getTwilioTimeoutConfig();

    Observable<String> getUGCBannerConfig();

    Observable<UgcConfig> getUgcFeatureConfig();

    Observable<List<String>> getValidDomainWhitelisted();

    Observable<List<String>> getWhitelistedSubMerchantId();

    Observable<Unit> initHereConfig();

    Observable<Boolean> isBranchDeepLinkEnable();

    Observable<Boolean> isCScanBEnabled();

    Observable<Boolean> isCameraCardEnable();

    Observable<Boolean> isChangeUsernameEnabled();

    Observable<Boolean> isContactSyncEnable();

    Observable<Boolean> isFaceLoginEnable();

    Observable<Boolean> isFavoriteServicesEnable();

    Observable<Boolean> isFeatureAnnouncementEnable();

    Observable<Boolean> isFeatureAutoRoutingEnable();

    Observable<Boolean> isFeatureCashierDeeplinkKybEnabled();

    Observable<Boolean> isFeatureCashierEnable();

    Observable<Boolean> isFeatureElectronicMoneyBannerEnable();

    Observable<Boolean> isFeatureFeedHighlightEnabled();

    Observable<Boolean> isFeatureGnProxyEnable();

    Observable<Boolean> isFeatureGoalsBalanceEnable();

    Observable<Boolean> isFeatureInvestmentEnabled();

    Observable<Boolean> isFeatureMixPayEnable();

    Observable<Boolean> isFeatureNativeDecodeEnable();

    Observable<Boolean> isFeaturePaylaterCicilScannerEnabled();

    Observable<Boolean> isFeaturePaymentKeyboardEnable();

    Observable<Boolean> isFeatureQrisCrossBorderEnable();

    Observable<Boolean> isFeatureTncCardPaymentEnabled();

    Observable<Boolean> isFeedInboxTabEnable();

    Observable<Boolean> isFirebaseLoginPerformanceTrackerOn();

    Observable<Boolean> isFirebaseRegisterPerformanceTrackerOn();

    Observable<Boolean> isFrozenAccountChatbotEnabled();

    Observable<Boolean> isInterstitialBannerEnabled();

    Observable<Boolean> isKnowYourBusinessEnable();

    Observable<Boolean> isKnowledgeBasedAuthEnable(String str);

    Observable<Boolean> isLeaderboardEntryEnable();

    Observable<Boolean> isLogoutEnable();

    Observable<Boolean> isMePageNewEnabled();

    Observable<Boolean> isMerchantCategoryFilterEnable();

    Observable<Boolean> isNearbyMeEnable();

    Observable<Boolean> isNearbyMeMapViewEnable();

    Observable<Boolean> isNearbyReviewPageEnabled();

    Observable<Boolean> isOfflineF2FPay();

    Observable<Boolean> isProfileCompletionWidgetEnable();

    Observable<Boolean> isPromoCenterEnable();

    Observable<Boolean> isPromoClaimEnable();

    Observable<Boolean> isPromoQuestEnable();

    Observable<Boolean> isPushNotifDiagnosticEnable();

    Observable<Boolean> isQrisEnable();

    Observable<Boolean> isQrisTopUpEnable();

    Observable<Boolean> isRejectFakeNumberEnabled();

    Observable<Boolean> isSendMoneyPeerToCashEnable();

    Observable<Boolean> isSendToBankEnable();

    Observable<Boolean> isSendToLinkEnable();

    Observable<Boolean> isShowReferralCode();

    Observable<Boolean> isStatementDownloadEnable();

    Observable<Boolean> isStatementEnable();

    Observable<Boolean> isTwilioEnrollmentEnable();

    Observable<Boolean> isX2BPreKitkatDialogEnable();

    Observable<Boolean> isX2PEnable();

    Observable<Boolean> isX2XVoucherEnable();

    Observable<MaintenanceBroadcast> observeMaintenanceBroadcast();

    Observable<BroadcastSavingStateResult> setBroadcastSavingState(String str);
}
