package id.dana.data.config.source;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.config.model.BindingBenefitEntity;
import id.dana.data.config.model.CitcallPermissionConfig;
import id.dana.data.config.model.DanaHomeBalanceConfig;
import id.dana.data.config.model.DanaProtectionWidgetConfigResult;
import id.dana.data.config.model.DealsConfigResult;
import id.dana.data.config.model.FullstoryConfigModel;
import id.dana.data.config.model.MarmotConfigResponse;
import id.dana.data.config.model.OtpWhatsAppConfig;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.data.config.model.PaylaterAgreementConfigResult;
import id.dana.data.config.model.PopupConfig;
import id.dana.data.config.model.PromoAdsConfigResponse;
import id.dana.data.config.model.PromoAdsLocationConfigResponse;
import id.dana.data.config.model.QrBindingConfigResult;
import id.dana.data.config.model.QrisTciCoConfigResult;
import id.dana.data.config.model.SyncPermissionConfig;
import id.dana.data.config.model.TransactionHistoryConfigEntity;
import id.dana.data.config.model.UgcConfigResult;
import id.dana.data.config.source.amcs.result.BannerConfigResult;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResult;
import id.dana.data.config.source.amcs.result.CashierPaymentAutorouteConfigResult;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.config.source.amcs.result.DonationCampaignConfigResult;
import id.dana.data.config.source.amcs.result.ExpiryInfoResult;
import id.dana.data.config.source.amcs.result.GeofenceConfigResult;
import id.dana.data.config.source.amcs.result.HelpButtonOtpLimitDevice;
import id.dana.data.config.source.amcs.result.InterstitialBannerConfigResult;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.data.config.source.amcs.result.MerchantCategoryContentResult;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.data.config.source.amcs.result.PromoCenterConfigResult;
import id.dana.data.config.source.amcs.result.QrisCrossBorderContentResult;
import id.dana.data.config.source.amcs.result.RequestMoneyInfoResult;
import id.dana.data.config.source.amcs.result.SplitBillConfigResult;
import id.dana.data.config.source.amcs.result.TermsConditionsResult;
import id.dana.data.config.source.amcs.result.TwilioTimeoutConfigResult;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.data.familyaccount.model.result.AvailableServicesConfigEntity;
import id.dana.data.familyaccount.model.result.MaxMemberLimitConfigEntity;
import id.dana.data.familyaccount.model.result.QuestionnaireDataConfigEntity;
import id.dana.data.here.model.HereConfigResponse;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import id.dana.data.profilemenu.model.ChangeUsernameEntity;
import id.dana.data.promodiscovery.repository.source.split.model.PromoCenterVersionResult;
import id.dana.data.referral.source.network.result.ReferralEngagementDialogConfigEntity;
import id.dana.data.resetpin.model.ConfigCountPinChange;
import id.dana.data.sendmoney.model.SendMoneyAddOnConfigResult;
import id.dana.data.sendmoney.model.WithdrawChannelInfoEntity;
import id.dana.data.sendmoney.x2l.model.BannerConfigEntity;
import id.dana.data.sendmoney.x2l.model.SocialLinkEntity;
import id.dana.data.webviewinterceptor.model.WebviewInterceptorEntity;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyConfig;
import id.dana.domain.featureconfig.model.AnbuConfig;
import id.dana.domain.featureconfig.model.ContactInjectionConfig;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.MccListConfig;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.featureconfig.model.ShowAlipayConnectBrandConfig;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.NearbyWidgetConfig;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.version.Version;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletSearch;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import id.dana.domain.wallet_v3.model.WalletV3RestrictedErrorCodes;
import id.dana.utils.config.model.NetworkLoggingConfig;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import org.json.JSONArray;

/* loaded from: classes.dex */
public interface ConfigEntityData {
    Observable<Boolean> checkVisibilityFeature(String str);

    Observable<List<String>> getAddingNameWhitelistedSubMerchantId();

    Observable<Boolean> getAmlEddMandatory();

    Observable<AnbuConfig> getAnbuConfig();

    Observable<List<String>> getAndMonitorCertificateWhitelist();

    Observable<Version> getAppVersion();

    Observable<Boolean> getAppWidgetEnabled();

    Observable<BannerConfigResult> getBannerConfig();

    Observable<CashierMerchantWhitelistConfigResult> getCashierMerchantWhitelistConfig();

    Observable<List<String>> getCashierNativeEntryPoints();

    Observable<CashierPaymentAutorouteConfigResult> getCashierPaymentAutorouteConfig();

    Observable<List<String>> getCertificatesUrl();

    Observable<CitcallPermissionConfig> getCitCallPermission();

    Observable<ContactSyncConfigResult> getContactSyncConfig();

    Observable<ConfigCountPinChange> getCountPinChange();

    Observable<List<String>> getCustomLoading3dsUrls();

    Observable<DanaHomeBalanceConfig> getDanaHomeBalanceConfig();

    Observable<DanaProtectionWidgetConfigResult> getDanaProtectionWidgetConfig();

    Observable<DealsConfigResult> getDealsConfig();

    Observable<Long> getDecodeQrTimeout();

    Observable<MccListConfig> getDecodeTciCoListConfig();

    Observable<DeepLinkPayloadEntity> getDeeplinkFeatureConfigByKeys(List<String> list, String str);

    Observable<List<String>> getDeeplinkFeatureConfigList();

    Observable<List<String>> getDefaultFeedFromConfig();

    Observable<DiagnosticLogConfig> getDiagnosticLogConfig();

    Observable<DonationCampaignConfigResult> getDonationCampaignConfig();

    Observable<Map<String, ElectronicMoneyConfig>> getElectronicMoneyConfig();

    Observable<EmergencyNotificationConfig> getEmergencyNotifConfig();

    Observable<Boolean> getEnableAddNewCard();

    Observable<ExpressPayInfo> getEnableExpressPayInfo();

    Observable<List<ExpiryInfoResult>> getExpiryChoice();

    Observable<List<ExpiryTimeConfig>> getExpiryTimeConfig();

    Observable<Integer> getFamilyAccountMaxMember();

    Observable<List<AvailableServicesConfigEntity>> getFamilyAvailableServices();

    Observable<Boolean> getFeatureAmlEdd();

    Observable<Boolean> getFeatureCameraCard();

    Observable<ContactInjectionConfig> getFeatureContactInjection();

    Observable<DanaVizEntryPointConfig> getFeatureDanaVizEntryPointConfig();

    Observable<Boolean> getFeatureForcedFirstCard();

    Observable<FeatureHoldLoginConfig> getFeatureHoldLoginConfig();

    Observable<List<PersonalizedReferralConfig>> getFeaturePersonalizedReferralConfig();

    Observable<PinRegularChangesConfig> getFeaturePinRegularChanges();

    Observable<PromoAdsConfigResponse> getFeaturePromoAds();

    Observable<ReferralEngagementDialogConfigEntity> getFeatureReferralEngagementDialogConfig();

    Observable<SendMoneyAddOnConfigResult> getFeatureSendMoneyAddOn();

    Observable<List<String>> getFeatureSendMoneyCashierNative();

    Observable<List<String>> getFeatureSkipButtonMerchantList();

    Observable<Integer> getFriendshipSyncProgressInterval();

    Observable<FullstoryConfigModel> getFullstoryConfig();

    Observable<GeofenceConfigResult> getGeofenceConfig();

    Observable<List<BindingBenefitEntity>> getGnBindingBenefits();

    Observable<JSONObject> getH5Entries();

    Observable<HelpButtonOtpLimitDevice> getHelpButtonOtpLimitDevice();

    Observable<HereConfigResponse> getHereConfig();

    Observable<List<JSONObject>> getHomeBannerDefaultContent();

    Observable<Map<String, String>> getHomeLandmarkUrlMap();

    Observable<InterstitialBannerConfigResult> getInterstitialBannerConfig();

    Observable<Boolean> getIsFeatureConnectionBarWithSignalOn();

    Observable<LoginRegisterConfigResult> getLoginRegisterConfig();

    Observable<MarmotConfigResponse> getMarmotConfig();

    Observable<Integer> getMaxBankAccount();

    Observable<Integer> getMaxFavoriteAccount();

    Observable<MaxMemberLimitConfigEntity> getMaxMemberLimit();

    Observable<Integer> getMaxRecentBank();

    Observable<Integer> getMaxRecentContact();

    Observable<Integer> getMaxRecentRecipient();

    Observable<Integer> getMaxSavedBank();

    Observable<JSONObject> getMerchantCategories();

    Observable<JSONArray> getMerchantOrder();

    Observable<JSONObject> getMerchantSubcategories();

    Observable<JSONObject> getMerchantTopups();

    Observable<HashMap<String, Object>> getMultipleBodyOnConfigFromFeature(String str);

    Observable<NearbyAutoSearchConfig> getNearbyAutoSearchConfig();

    Observable<NearbyConfigResult> getNearbyConfig();

    Observable<Boolean> getNearbyMeFeature();

    Observable<Boolean> getNearbyMeMapViewFeature();

    Observable<NearbyRankingConfig> getNearbyRankingConfig();

    Observable<NearbyRankingConfig> getNearbyRankingConfigV2();

    Observable<NearbyWidgetConfig> getNearbyWidgetConfig();

    Observable<NetworkLoggingConfig> getNetworkLoggingConfig();

    Observable<MerchantCategoryContentResult> getNewMerchantCategories();

    Observable<List<String>> getNewMerchantCategoryOrder(MerchantCategoryType merchantCategoryType);

    Observable<MerchantCategoryContentResult> getNewMerchantSubCategories();

    Observable<OTCAcceptExpiryTimeConfigResult> getOTCExpiryConfig();

    Observable<OnboardingWarningTextConfig> getOnboardingWarningTextConfig();

    Observable<OtpWhatsAppConfig> getOtpWhatsappConfig();

    Observable<PayLaterMethodConfig> getPayLaterMethodConfig();

    Observable<PaylaterAgreementConfigResult> getPaylaterAgreementConfig();

    Observable<Integer> getPaymentCodeDigit();

    Observable<Integer> getPinningMode();

    Observable<JSONObject> getPlayStoreReviewFeature();

    Observable<PopupConfig> getPopupConfig();

    Observable<List<String>> getPreventScreenshotConfig();

    Observable<Boolean> getProfileCompletionWidgetVisibility();

    Observable<PromoAdsLocationConfigResponse> getPromoAdsLocationConfig();

    Observable<Boolean> getPromoBannerSliderItemNewSizeEnabled();

    Observable<PromoCenterConfigResult> getPromoCenterConfig(boolean z);

    Observable<PromoCenterVersionResult> getPromoCenterVersion();

    Observable<QrBindingConfigResult> getQrBindingConfig();

    Observable<Integer> getQrCount();

    Observable<QrisCrossBorderContentResult> getQrisCrossBorderContent(String str);

    Observable<List<String>> getQrisCrossBorderSupportedCountries();

    Observable<QrisTciCoConfigResult> getQrisTcicoConfig();

    Observable<QueryUserDataConfig> getQueryUserDataConfig();

    Observable<QuestionnaireDataConfigEntity> getQuestionnaireDataFamilyAccount();

    Observable<RequestMoneyInfoResult> getRequestMoneyInfo();

    Observable<ResetAndChangePinNativeEntryConfig> getResetAndChangePinNativeConfig();

    Observable<List<String>> getSavingCategories();

    Observable<List<String>> getSavingWithdrawOptionsConfig();

    Observable<WalletSearch> getSearchCategory();

    Observable<Boolean> getSendMoneyFeedConfig();

    Observable<Integer> getSendMoneyNoteCharLimit();

    Observable<Long> getSendMoneyRefundTimeout();

    Observable<ReferralMessageTemplateConfig> getShareReferralMessageTemplate();

    Observable<ShowAlipayConnectBrandConfig> getShowAlipayConnectBrandConfig();

    Observable<SmartFrictionConfig> getSmartFrictionConfig();

    Observable<List<String>> getSocialMediaCategoryShare();

    Observable<SplitBillConfigResult> getSplitBillConfig();

    Observable<StartupConfig> getStartupConfig();

    Observable<List<String>> getStatementDisableDetailConfig();

    Observable<SyncContactSplitConfigModel> getSyncContactWithNameConfig();

    Observable<SyncPermissionConfig> getSyncPermissionScheduler();

    Observable<TermsConditionsResult> getTermsConditionsConfig();

    Observable<String> getTnCReferralMission();

    Observable<TransactionHistoryConfigEntity> getTransactionHistoryConfig();

    Observable<List<String>> getTwilioNonLogoutScenes();

    Observable<TwilioTimeoutConfigResult> getTwilioTimeoutConfig();

    Observable<String> getUGCBannerConfig();

    Observable<UgcConfigResult> getUgcConfigResult();

    Observable<UserLocationPermissionPromptConfig> getUserLocationPromptConfig();

    Observable<Boolean> getUtdidFixEnabled();

    Observable<WalletConfig> getWalletConfig();

    Observable<WalletV3RecommendationConfig> getWalletV3RecommendationConfig(String str);

    Observable<List<String>> getWalletV3RecommendationConfigKey();

    Observable<WalletV3RestrictedErrorCodes> getWalletV3RestrictedErrorCodes();

    Observable<List<WebviewInterceptorEntity>> getWebviewInterceptorConfig();

    Observable<List<String>> getWhitelistedDomain();

    Observable<List<String>> getWhitelistedSubMerchantId();

    Observable<List<WithdrawChannelInfoEntity>> getWithdrawChannelInfoConfig();

    Observable<BannerConfigEntity> getX2LBannerConfig();

    Observable<List<SocialLinkEntity>> getX2LSocialLinks();

    Observable<HelpButtonChatBot> helpButtonChatbot();

    Observable<Boolean> isBranchDeepLinkEnable();

    Observable<Boolean> isCScanBEnabled();

    Observable<ChangeUsernameEntity> isChangeUsernameEnabled();

    Observable<Boolean> isDexguardHookCheckEnable();

    Observable<Boolean> isDexguardRootCheckEnable();

    Observable<Boolean> isDexguardTamperCheckEnable();

    Observable<Boolean> isEnableSendRiskLuckyMoney();

    Observable<Boolean> isEncryptCardEnabled();

    Observable<Boolean> isFaceLoginEnabled();

    Observable<Boolean> isFavoriteServicesEnabled();

    Observable<Boolean> isFeatureAnnouncementEnable();

    Observable<Boolean> isFeatureAutoRoutingEnable();

    Observable<Boolean> isFeatureCashierDeeplinkKybEnabled();

    Observable<Boolean> isFeatureCashierEnable();

    Observable<Boolean> isFeatureElectronicMoneyBannerEnable();

    Observable<Boolean> isFeatureFeedHightlightEnabled();

    Observable<Boolean> isFeatureGnProxyEnable();

    Observable<Boolean> isFeatureGoalsBalanceEnable();

    Observable<Boolean> isFeatureInvestmentEnabled();

    Observable<Boolean> isFeatureMixPayEnable();

    Observable<Boolean> isFeatureNativeDecodeEnable();

    Observable<Boolean> isFeaturePaylaterCicilScannerEnabled();

    Observable<Boolean> isFeaturePaymentKeyboardEnable();

    Observable<Boolean> isFeatureQrisCrossBorderEnabled();

    Observable<Boolean> isFeatureSplitMigration();

    Observable<Boolean> isFeatureTncCardPaymentEnabled();

    Observable<Boolean> isFeatureVoiceAssistantEnable();

    Observable<Boolean> isFeedInboxTabEnable();

    Observable<Boolean> isFirebaseLoginPerformanceTrackerOn();

    Observable<Boolean> isFirebaseRegisterPerformanceTrackerOn();

    Observable<Boolean> isFrozenAccountChatbotEnabled();

    Observable<Boolean> isHomePersonalizedEnable();

    Observable<Boolean> isInterstitialBannerEnabled();

    Observable<Boolean> isKnowYourBusinessEnable();

    Observable<Boolean> isKnowledgeBasedAuthEnable(String str);

    Observable<Boolean> isLeaderboardEntryEnabled();

    Observable<Boolean> isLogoutEnable();

    Observable<Boolean> isMePageNewEnabled();

    Observable<Boolean> isMerchantCategoryFilterEnable();

    Observable<Boolean> isMigratePromoOperationType();

    Observable<Boolean> isMixpanelStorageTrackEnabled();

    Observable<Boolean> isNearbyReviewPageEnabled();

    Observable<Boolean> isOfflineF2FPay();

    Observable<Boolean> isPromoCenterEnable();

    Observable<Boolean> isPromoClaimEnable();

    Observable<Boolean> isPromoQuestEnable();

    Observable<Boolean> isPushNotifDiagnosticEnable();

    Observable<Boolean> isQrisEnabled();

    Observable<Boolean> isQrisTopUpEnable();

    Observable<Boolean> isReferredUserEnabled();

    Observable<Boolean> isRejectFakeNumberEnabled();

    Observable<Boolean> isResendWhatsAppEnable();

    Observable<Boolean> isSendMoneyPeerToCashEnable();

    Observable<Boolean> isSendToBankEnable();

    Observable<Boolean> isSendToLinkEnable();

    Observable<Boolean> isServiceEnabled(String str);

    Observable<Boolean> isShowReferralCode();

    Observable<Boolean> isStatementDownloadEnabled();

    Observable<Boolean> isStatementEnabled();

    Observable<Boolean> isTwilioEnrollmentEnable();

    Observable<Boolean> isTwilioManualCheckEnable();

    Observable<Boolean> isUserConfigSyncEnable(String str);

    Observable<Boolean> isX2BPreKitkatDialogEnable();

    Observable<Boolean> isX2PEnable();

    Observable<Boolean> isX2XVoucherEnable();

    Observable<List<String>> monitorCertificatesUrl();

    Observable<Integer> monitorPinningMode();

    Observable<MaintenanceBroadcastResult> observeMaintenanceBroadcast();

    Unit saveAttribute(String str, String str2);
}
