package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.HomeTabActivity_MembersInjector;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.presenter.HomeTabPresenter;
import id.dana.animation.presenter.HomeTabPresenter_Factory;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.CashierEventHandler_Factory;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;
import id.dana.contract.contact.DanaContactPresenter_Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeepLinkModule_ProvideReadPropertiesPresenterFactory;
import id.dana.contract.deeplink.DeepLinkModule_ProvideViewFactory;
import id.dana.contract.deeplink.DeepLinkView;
import id.dana.contract.deeplink.DeepLinkView_Factory;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.FeatureModule_ProvidePresenterFactory;
import id.dana.contract.deeplink.FeatureModule_ProvideViewFactory;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter_Factory;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.contract.deeplink.path.FeatureCardBinding_Factory;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeatureFamilyAccount;
import id.dana.contract.deeplink.path.FeatureFamilyAccount_Factory;
import id.dana.contract.deeplink.path.FeatureHome_Factory;
import id.dana.contract.deeplink.path.FeatureKyb_Factory;
import id.dana.contract.deeplink.path.FeatureMyBills_Factory;
import id.dana.contract.deeplink.path.FeatureOauth;
import id.dana.contract.deeplink.path.FeatureOauth_Factory;
import id.dana.contract.deeplink.path.FeaturePresenter;
import id.dana.contract.deeplink.path.FeaturePresenter_Factory;
import id.dana.contract.deeplink.path.FeaturePromoQuest;
import id.dana.contract.deeplink.path.FeaturePromoQuest_Factory;
import id.dana.contract.deeplink.path.FeaturePushVerify;
import id.dana.contract.deeplink.path.FeaturePushVerify_Factory;
import id.dana.contract.deeplink.path.FeatureScanQR;
import id.dana.contract.deeplink.path.FeatureScanQR_Factory;
import id.dana.contract.deeplink.path.FeatureServicesHandler;
import id.dana.contract.deeplink.path.FeatureServicesHandler_Factory;
import id.dana.contract.deeplink.path.FeatureSettingMore;
import id.dana.contract.deeplink.path.FeatureSettingMore_Factory;
import id.dana.contract.deeplink.path.FeatureSplitBill;
import id.dana.contract.deeplink.path.FeatureSplitBillPay;
import id.dana.contract.deeplink.path.FeatureSplitBillPay_Factory;
import id.dana.contract.deeplink.path.FeatureSplitBill_Factory;
import id.dana.contract.deeplink.path.FeatureView;
import id.dana.contract.deeplink.path.FeatureView_Factory;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import id.dana.contract.deeplink.path.OauthPresenter_Factory;
import id.dana.contract.deeplink.path.OauthView;
import id.dana.contract.deeplink.path.OauthView_Factory;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker_Factory;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.services.ServicesModule_ProvideViewFactory;
import id.dana.contract.services.ServicesPresenter;
import id.dana.contract.services.ServicesPresenter_Factory;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.shortener.RestoreUrlModule_ProvidePresenterFactory;
import id.dana.contract.shortener.RestoreUrlModule_ProvideViewFactory;
import id.dana.contract.shortener.RestoreUrlPresenter;
import id.dana.contract.shortener.RestoreUrlPresenter_Factory;
import id.dana.contract.shortener.RestoreUrlView;
import id.dana.contract.shortener.RestoreUrlView_Factory;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.contract.staticqr.ScanQrModule_ProvideActivityFactory;
import id.dana.contract.staticqr.ScanQrModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.ScanQrModule_ProvideViewFactory;
import id.dana.contract.staticqr.ScanQrPresenter;
import id.dana.contract.staticqr.ScanQrPresenter_Factory;
import id.dana.contract.staticqr.ScanQrView;
import id.dana.contract.staticqr.ScanQrView_Factory;
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaCustomH5_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.devicestats.DeviceStatsAnalyticsEntityData;
import id.dana.data.devicestats.DeviceStatsPreferenceEntityData;
import id.dana.data.devicestats.FileDirectoriesSizeMapper_Factory;
import id.dana.data.devicestats.FileSystemStatsRepository;
import id.dana.data.devicestats.FileSystemStatsRepository_Factory;
import id.dana.data.devicestats.di.DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory;
import id.dana.data.devicestats.di.DeviceStatsModule_ProvideDeviceStatsPreferenceFactory;
import id.dana.data.devicestats.entity.FileSystemStorageEntity;
import id.dana.data.devicestats.entity.FileSystemStorageEntity_Factory;
import id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData;
import id.dana.data.devicestats.entity.SplitDeviceStatsConfigEntityData_Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.DanaContactModule_ProvidePresenterFactory;
import id.dana.di.modules.DanaContactModule_ProvideViewFactory;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.GlobalNetworkModule_ProvidesPresenterFactory;
import id.dana.di.modules.GlobalNetworkModule_ProvidesViewFactory;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.HomeTabModules_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.HomeTabModules_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.KycAmlEddModule;
import id.dana.di.modules.KycAmlEddModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.KycRenewalModule;
import id.dana.di.modules.KycRenewalModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.PaymentSettingModule;
import id.dana.di.modules.PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.PaymentSettingModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.di.modules.ReferralDialogModule;
import id.dana.di.modules.ReferralDialogModule_ProvidePresenterFactory;
import id.dana.di.modules.ReferralDialogModule_ProvideViewFactory;
import id.dana.di.modules.TncSummaryModules;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryPresenterFactory;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryViewFactory;
import id.dana.di.modules.UserConfigModule;
import id.dana.di.modules.UserConfigModule_ProvideUserConfigPresenterFactory;
import id.dana.di.modules.UserConfigModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.account.interactor.GetNickname_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.IsFirstTime;
import id.dana.domain.account.interactor.IsFirstTime_Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting_Factory;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.devicestats.storage.FileDirectorySizeReportScheduler;
import id.dana.domain.devicestats.storage.FileDirectorySizeReportScheduler_Factory;
import id.dana.domain.devicestats.storage.ScheduleDeviceStatsReport;
import id.dana.domain.devicestats.storage.ScheduleDeviceStatsReport_Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain_Factory;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetDealsConfig;
import id.dana.domain.featureconfig.interactor.GetDealsConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr_Factory;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetPayRequest_Factory;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth_Factory;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled_Factory;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier_Factory;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.home.HomePassiveBioRepository;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked_Factory;
import id.dana.domain.home.interactor.SavePassiveBioTracked;
import id.dana.domain.home.interactor.SavePassiveBioTracked_Factory;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig_Factory;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig_Factory;
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig;
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig_Factory;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult;
import id.dana.domain.kycamledd.interactor.GetKycAmlEddConsult_Factory;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc_Factory;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import id.dana.domain.kycrenewal.interactor.GetKycRenewal;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalButtonClicked;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalButtonClicked_Factory;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckDismiss_Factory;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckQuery_Factory;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckShow;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckShow_Factory;
import id.dana.domain.kycrenewal.interactor.GetKycRenewal_Factory;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalButtonClick;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalButtonClick_Factory;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckDismiss_Factory;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckQuery_Factory;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckShow;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckShow_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.CheckSession_Factory;
import id.dana.domain.login.interactor.GetIsSessionChecked;
import id.dana.domain.login.interactor.GetIsSessionChecked_Factory;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.login.interactor.SaveIsSessionChecked_Factory;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId_Factory;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.interactor.GetQrBindingConfig_Factory;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.GetUserLoanInfo_Factory;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import id.dana.domain.paymentsetting.interactor.PaymentSettingCheck;
import id.dana.domain.paymentsetting.interactor.PaymentSettingCheck_Factory;
import id.dana.domain.paymentsetting.interactor.SavePaymentSettingCheck;
import id.dana.domain.paymentsetting.interactor.SavePaymentSettingCheck_Factory;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication_Factory;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.GetSettingByKey_Factory;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication_Factory;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion_Factory;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.domain.promoquest.interactor.GetMissionDetail_Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.GetDecodeTciCoListConfig;
import id.dana.domain.qrbarcode.interactor.GetDecodeTciCoListConfig_Factory;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode_Factory;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrisTopUp;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrisTopUp_Factory;
import id.dana.domain.qrbarcode.interactor.GetMerchantQrWhitelist;
import id.dana.domain.qrbarcode.interactor.GetMerchantQrWhitelist_Factory;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr_Factory;
import id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig;
import id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig_Factory;
import id.dana.domain.qrbarcode.interactor.IsNativeDecodeEnabled;
import id.dana.domain.qrbarcode.interactor.IsNativeDecodeEnabled_Factory;
import id.dana.domain.qrbarcode.interactor.ValidateNativelyDecodedQr;
import id.dana.domain.qrbarcode.interactor.ValidateNativelyDecodedQr_Factory;
import id.dana.domain.recentcontact.interactor.GetDanaContact;
import id.dana.domain.recentcontact.interactor.GetDanaContact_Factory;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.CheckDialogDailyLimit;
import id.dana.domain.referral.interactor.CheckDialogDailyLimit_Factory;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referral.interactor.GetReferralEngagementDialog;
import id.dana.domain.referral.interactor.GetReferralEngagementDialog_Factory;
import id.dana.domain.referral.interactor.SaveReferralDialogDailyLimit;
import id.dana.domain.referral.interactor.SaveReferralDialogDailyLimit_Factory;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache_Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll_Factory;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature_Factory;
import id.dana.domain.services.interactor.GetDefaultServiceWithCategory;
import id.dana.domain.services.interactor.GetDefaultServiceWithCategory_Factory;
import id.dana.domain.services.interactor.GetFavoriteServiceRemote;
import id.dana.domain.services.interactor.GetFavoriteServiceRemote_Factory;
import id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst;
import id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst_Factory;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.GetFavoriteServices_Factory;
import id.dana.domain.services.interactor.GetRawServices;
import id.dana.domain.services.interactor.GetRawServices_Factory;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.services.interactor.GetServiceHighlighted;
import id.dana.domain.services.interactor.GetServiceHighlighted_Factory;
import id.dana.domain.services.interactor.GetService_Factory;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.domain.services.interactor.GetServicesByKey_Factory;
import id.dana.domain.services.interactor.GetServicesByName;
import id.dana.domain.services.interactor.GetServicesByName_Factory;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.services.interactor.GetServicesWithCategory_Factory;
import id.dana.domain.services.interactor.UpdateServiceHighlighted;
import id.dana.domain.services.interactor.UpdateServiceHighlighted_Factory;
import id.dana.domain.shortener.interactor.RestoreUrl;
import id.dana.domain.shortener.interactor.RestoreUrl_Factory;
import id.dana.domain.shortener.repository.ShortenerRepository;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail_Factory;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState_Factory;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact_Factory;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode_Factory;
import id.dana.domain.user.interactor.GetUserCohort;
import id.dana.domain.user.interactor.GetUserCohort_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.interactor.GetUserPan;
import id.dana.domain.user.interactor.GetUserPan_Factory;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.user.interactor.GetUserStatusInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowDialog;
import id.dana.domain.usereducation.interactor.SaveShowDialog_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.domain.version.interactor.GetUpdateAvailability_Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter_Factory;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker_Factory;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.KycAmlEddPresenter;
import id.dana.kycamledd.KycAmlEddPresenter_Factory;
import id.dana.kycrenewal.KycRenewalContract;
import id.dana.kycrenewal.KycRenewalPresenter;
import id.dana.kycrenewal.KycRenewalPresenter_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper_Factory;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.onboarding.referral.ReferralDialogContract;
import id.dana.onboarding.referral.ReferralDialogPresenter;
import id.dana.onboarding.referral.ReferralDialogPresenter_Factory;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.paymentsetting.PaymentSettingPresenter;
import id.dana.paymentsetting.PaymentSettingPresenter_Factory;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.richview.contactselector.UserContactMapper_Factory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.ContactProvider_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.social.utils.FeedsContentAction;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.synccontact.SyncContactUtil_Factory;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.TncSummaryPresenter;
import id.dana.tncsummary.TncSummaryPresenter_Factory;
import id.dana.userconfig.UserConfigContract;
import id.dana.userconfig.UserConfigPresenter;
import id.dana.userconfig.UserConfigPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerHomeTabActivityComponent {
    private DaggerHomeTabActivityComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public RestoreUrlModule DatabaseTableConfigUtil;
        public PlayStoreReviewModules GetContactSyncConfig;
        public DanaContactModule KClassImpl$Data$declaredNonStaticMembers$2;
        public GlobalNetworkModule MyBillsEntityDataFactory;
        public KycRenewalModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public TncSummaryModules NetworkUserEntityData$$ExternalSyntheticLambda7;
        public UserConfigModule NetworkUserEntityData$$ExternalSyntheticLambda8;
        public FeatureModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public ReferralDialogModule initRecordTimeStamp;
        public KycAmlEddModule lookAheadTest;
        public HomeTabModules moveToNextValue;
        public PaymentSettingModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class HomeTabActivityComponentImpl implements HomeTabActivityComponent {

        /* renamed from: $r8$lambda$7jSe-jJ0etbd9VooMli6zMuqlA0 */
        private Provider<ServicesRepository> f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0;

        /* renamed from: $r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M */
        private Provider<PaymentSettingContract.View> f5839$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
        private Provider<DanaContactContract.View> $r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0;
        private Provider<ReferralDialogPresenter> $r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8;
        private Provider<DynamicUrlWrapper> A;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> ApiStatus$AvailableSince;
        private Provider<RecentRecipientRepository> AppCategory;
        private Provider<FeatureView> AppCompatEmojiTextHelper;
        private Provider<DeviceStatsAnalyticsEntityData> ArrayTable$1;
        private Provider<DeviceStatsPreferenceEntityData> ArrayTable$2;
        private Provider<ContactInjectionRepository> ArrayTable$3;
        private Provider<FeatureCardBinding> B;
        private Provider<FirebasePerformanceMonitor> BannerEntityDataFactory_Factory;
        private Provider<PlayStoreReviewRepository> BaseSocialFeedContract$Presenter;
        private Provider<FeatureFamilyAccount> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureConfigRepository> C;
        private Provider<MyReferralConsultRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<ServiceCategoryMapper> CacheBuilderSpec$AccessDurationParser;
        private Provider<Activity> CheckPromoQuestFeature;
        private Provider<CredentialRepository> ConcurrentKt;
        private Provider<SyncContactRepository> ContentDeliveryCacheEntityDataFactory;
        private Provider<SaveShowDialog> CreateOrderTopUpFamilyBalance;
        private Provider<SavePaymentSettingCheck> CreateRemoteWorkerExtension;
        private Provider<FeaturePushVerify> D;
        private Provider<ScanQrView> DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider;
        private Provider<KycAmlEddContract.View> DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
        private Provider<RecentContactRepository> DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider;
        private Provider<GetReferralEngagementDialog> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckHomePassiveBioTracked> DatabaseTableConfigUtil;
        private Provider<FeedsShareRepository> DebugCoroutineInfoImpl;
        private Provider<FeaturePresenter> E;
        private Provider<RestoreUrlContract.View> EmergencyNotifActivity$getEmergencyNotifModule$1;
        private Provider<FeatureSettingMore> F;
        private Provider<OauthContract.View> FamilyDashboardPresenter_Factory;
        private Provider<ScanResultMapper> FamilyManageAvailableServicesAdapter;
        private Provider<GetMerchantQrWhitelist> FillAnimation;
        private Provider<FamilyAccountRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetPasswordLastModifiedWithConfigChecking> FlowViewUtil$textChanges$1;
        private Provider<GetNearbyConfig> FlowViewUtil$textChanges$2;
        private Provider<MixpanelGlobalNetworkTracker> FlowableConcatMapEagerPublisher;
        private Provider<GlobalNetworkPresenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<KycRenewalRepository> FlowableKt$toIterable$1;
        private Provider<GetUserStatusInfo> FlowableReduce$ReduceSubscriber;
        private Provider<ThreadExecutor> FontsContractCompat$FontRequestCallback;
        private Provider<Context> FragmentBottomSheetPaymentSettingBinding;
        private Provider<FileDirectorySizeReportScheduler> G;
        private Provider<CheckShowReferralCodeFeature> GetContactSyncConfig;
        private Provider<TncSummaryRepository> GetExpressPurchaseResponse$PriceEntity;
        private Provider<RestoreUrlPresenter> GetTopUpUserConsult;
        private Provider<FeatureSplitBillPay> H;
        private Provider<FeatureSplitBill> I;
        private Provider<SaveIsSessionChecked> ISO8601Utils;
        private Provider<ThirdPartyServicesMapper> ImageCaptureViewModel$getTipUploadPhoto$1;
        private Provider<UserConfigPresenter> ImageCaptureViewModel$getTipUploadPhoto$2;
        private Provider<SaveReferralDialogDailyLimit> ImageWithDescriptionView$showImage$1;
        private Provider<KycAmlEddPresenter> InitSecurePreferenceAccount;
        private Provider<CardBindingRepository> InvestmentWalletAdapter;
        private Provider<GenerateReferralDeepLink> J;
        private Provider<InitPaymentAuthentication> JsonParseException;
        private Provider<FileSystemStatsRepository> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SettingRepository> KeyEvent$DispatcherState;
        private Provider<FirebaseAnalytics> L;
        private Provider<SaveReferralEngagementDialogCache> ListenerMethod;
        private Provider<FileSystemStorageEntity> M;
        private Provider<DanaContactContract.Presenter> MultiLanguageHttpClient;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> N;
        private Provider<GlobalNetworkContract.Presenter> NavigationMenuPresenter$HeaderViewHolder;
        private Provider<ServicesPresenter> NearbyConstantsKt;
        private Provider<CheckConsultFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CheckSession> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ControlSwitchPaymentAuthentication> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<ContentResolver> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ContactProvider> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DanaContactPresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<CheckSyncProcessCompleteState> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<MixpanelAnalytics> NewMerchantCategoryAdapter;
        private Provider<GetAutoRouteInitialSetting> O;
        private Provider<GetWhitelistedSubMerchantId> OtpRegistrationPresenter$input$1;
        private Provider<GetRawServices> OtpRegistrationPresenter$input$2;
        private Provider<GetCashierNativeConfig> P;
        private Provider<AutoRouteRepository> PlaceComponentResult;
        private Provider<FeatureContract.Presenter> PlaybackStateCompat$MediaKeyAction;
        private Provider<PushVerifyTracker> PrefetchDownloadStatus;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> PrepareContext;
        private Provider<KycAmlEddRepository> PromoCategoryPresenter$1;
        private Provider<GetAuthCode> Q;
        private Provider<GetKycRenewalButtonClicked> QrExpiredActivity;
        private Provider<GetDanaContact> R;
        private Provider<IsNeedToShowToolTip> ReferralMapper_Factory;
        private Provider<ReadLinkPropertiesPresenter> RepaymentPlan;
        private Provider<GetUserLoanInfo> RequestMoneyQrContract$View;
        private Provider<GetDealsConfig> S;
        private Provider<HomePassiveBioRepository> SchedulerPoolFactory;
        private Provider<PlayStoreReviewPresenter> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<PaymentSettingPresenter> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<IsOfflineF2FPay> SendMoneyScenario;
        private Provider<UserRepository> SightCameraView$ICameraFrameListener;
        private Provider<GetResetAndChangePinNativeEntryConfig> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<PromoQuestRepository> f5840x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<EventTrackerQueue> f5841x461046da;
        private Provider<SaveLastPlayStoreReviewShow> SplitReferralConfigEntityData_Factory;
        private Provider<FeatureContract.View> SplitSavingConfigEntityData;
        private Provider<UserConfigContract.View> StandardRowSortedTable$1;
        private Provider<DeepLinkPayloadModelMapper> SubSequence;
        private Provider<HomeTabContract.View> SubmitReceiptResultModel$Creator;
        private Provider<GetContactInjectionConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetDecodeTciCoListConfig> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetDefaultServiceWithCategory> T;
        private Provider<TncSummaryPresenter> TimeoutError;
        private Provider<PaylaterRepository> TrackerKey$GlobalSearchOpenProperties;
        private Provider<ValidateNativelyDecodedQr> TrustRiskLogin$Params;
        private Provider<SSLPinningRepository> TwilioRepository;
        private Provider<GetKycRenewalCheckQuery> TypeProjectionImpl;
        private Provider<RiskTracker> TypeToken$TypeSet;
        private Provider<GetSplitBillConfig> TypefaceCompatApi26Impl;
        private Provider<GetDecodedQrisTopUp> U;
        private Provider<HomeTabContract.Presenter> UnicastProcessor$UnicastQueueSubscription;
        private Provider<GetEmptyUserInfo> V;
        private Provider<FeatureOauth> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeaturePromoQuest> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetContactsUseCase> View$OnClickListener;
        private Provider<SplitBillHistoryToSplitBillModelMapper> ViewInputOtpBinding;
        private Provider<GetFavoriteServiceWithCacheFirst> W;
        private Provider<FeedsConfigRepository> WithdrawSavedCardChannelView;
        private Provider<PayerModelListMapper> WrappedDrawableState;
        private Provider<GetFavoriteServiceRemote> X;
        private Provider<GetFeatureHoldLoginConfig> Y;
        private Provider<GetGnCScanBBlacklistedCountry> Z;

        /* renamed from: a */
        private Provider<GetKycLevel> f8118a;
        private Provider<IsNeedToShowPlayStoreReview> access$getCapacity$p;
        private Provider<RestoreUrlView> access$getFeaturedBankListAdapter$p;
        private Provider<ScanQrPresenter> access$getServiceItemDecorator$p;
        private Provider<MigrateRecentRecipientConfigToRoom> access$setShowcaseShowing$p;
        private Provider<SubmitEddAmlKyc> access$showKycAmlEddDialog;
        private Provider<GetPromoCenterVersion> access$throwIllegalArgumentType;
        private Provider<SaveKycRenewalCheckDismiss> allowedTargets;
        private Provider<PaymentSettingRepository> applyTrimPathIfNeeded;
        private Provider<GetIsSessionChecked> b;
        private Provider<GetKycRenewalCheckDismiss> c;
        private Provider<ReferralDialogContract.Presenter> checkMarmotConfig;
        private Provider<ReadLinkPropertiesContract.Presenter> checkParameterIsNotNull;
        private Provider<IsFirstTime> checkRegisteredUserAndSendOtp;
        private Provider<GetMissionDetail> connectForeground;
        private Provider<RestoreUrl> connectionSpecs;
        private Provider<ProductPageManager> containsObjectForKey;
        private Provider<ResetPinRepository> createJavaMethod;
        private Provider<ShortenerRepository> createSecondaryAnimatorProvider;
        private Provider<GetKycAmlEddConsult> d;
        private Provider<DeepLinkContract.View> doCommonLog;
        private Provider<GetKycRenewal> e;
        private Provider<PaymentSettingCheck> encodingStream;
        private Provider<GetLastSyncedContact> f;
        private Provider<GetFavoriteServices> flip;
        private Provider<ReadDeepLinkProperties> flow;
        private Provider<ReferralEngagementDialogRepository> fromContextOrNull;
        private Provider<GetKycRenewalCheckShow> g;
        private Provider<AnalyticsTrackerFactory> getAuthRequestContext;
        private Provider<DeviceInformationProvider> getCallingPid;
        private Provider<GetWalletOauth> getCardNumberOCR;
        private final HomeTabActivityComponentImpl getContainerAuth;
        private Provider<HomeTabPresenter> getDefaultSenderId;
        private Provider<CheckDialogDailyLimit> getErrorConfigVersion;
        private Provider<PlayStoreReviewContract.Presenter> getExceptionOrNull;
        private Provider<OauthPresenter> getFontAssetManager;
        private Provider<KycRenewalContract.View> getGnBenefitEntityDanaProtection;
        private Provider<IsCScanBEnabled> getIndexName;
        private Provider<GenerateLinkRepository> getNameOrBuilderList;
        private Provider<SaveKycRenewalCheckShow> getNrCsiRsrp;
        private Provider<SaveShareFeedConsent> getNrCsiRsrq;
        private Provider<FeatureServicesHandler> getOnBoardingScenario;
        private Provider<RestoreUrlContract.Presenter> getOpPackageName;
        private Provider<HomeConfigRepository> getPhoneMask;
        private Provider<OauthView> getRawPath;
        private Provider<LiteAccountRepository> getReadyFragment;
        private Provider<PlayStoreReviewContract.View> getRecommendationData;
        private Provider<SaveAlipayConnectServiceFirstTime> getSavingConfigPresenter;
        private Provider<ScanQrContract.View> getStackFromEnd;
        private Provider<DeepLinkView> getSupportButtonTintMode;
        private Provider<OpenMerchantCashier> getTextEndPadding;
        private Provider<ReferralRepository> getTypeMappings;
        private Provider<FeatureScanQR> getValueOfTouchPositionAbsolute;

        /* renamed from: getWalletV3RecommendationConfig$lambda-193 */
        private Provider<ServicesContract.View> f5842getWalletV3RecommendationConfig$lambda193;
        private Provider<QrBarcodeRepository> glVertexAttrib1fv;
        private Provider<GetNickname> h;
        private Provider<GetMixpanelStorageConfig> i;
        private Provider<SaveShowToolTip> indexOfAny;
        private Provider<GetUserId> initAnimators;
        private Provider<CheckMyBillsVersionConfig> initRecordTimeStamp;
        private Provider<LoginRepository> insertActivities;
        private Provider<GlobalNetworkContract.View> isAllowRetry;
        private Provider<GetDecodedQrBarcode> isAuth;
        private Provider<GetIsCardBindingV2Enabled> isAuto;
        private Provider<PostExecutionThread> isInfoWindowShown;
        private Provider<ConsultForceDanaVizEnroll> isLayoutRequested;
        private Provider<MyReferralConsultMapper> isRegionMiniProgram;
        private Provider<UserConfigContract.Presenter> isTmpDetached;
        private Provider<UserConsentRepository> itemClicked$core;
        private Provider<GetQrisCpmSendmoneyConfig> j;
        private Provider<GetPayerSplitBillDetail> k;
        private Provider<GetPayRequest> l;
        private Provider<CheckDeepLinkActionVisibility> lookAheadTest;
        private Provider<GetQrBindingConfig> m;
        private Provider<CashierEventHandler> moveToNextValue;
        private Provider<TncSummaryContract.View> murmurHash64WithSeed;
        private Provider<GetReferralConsult> n;
        private Provider<CheckWhitelistedValidDomain> newProxyInstance;

        /* renamed from: o */
        private Provider<GetRequestMoneyInfoFeature> f8119o;
        private Provider<IsAlipayConnectServiceFirstTime> onDecodeSuccess;
        private Provider<SplitBillRepository> onGetActiveNotifications;
        private Provider<SavePassiveBioTracked> onLayoutDirectionChanged;
        private Provider<PaymentSettingContract.Presenter> onPolygonsChanged;
        private Provider<OauthContract.Presenter> onTooManyRedirects;
        private Provider<ScanQrContract.Presenter> outerType;
        private Provider<GetQueryUserDataConfig> p;
        private Provider<UserEducationRepository> parametersAsMap;
        private Provider<GetServiceHighlighted> q;
        private Provider<GetServicesByKey> r;
        private Provider<DecodeGnQr> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<IsNativeDecodeEnabled> f5843reduceIndexedz1zDJgo;
        private Provider<RecordAgreementOnlyAgreementKey> removeFloat;
        private Provider<KycRenewalPresenter> retainOrRemoveAllInternal;
        private Provider<MixpanelDeeplinkTracker> rotateTo;
        private Provider<SaveKycRenewalCheckQuery> roundToPowerOfTwo;
        private Provider<GetService> s;
        private Provider<SwitchAutoRouting> saveNickname;
        private Provider<CheckContactSyncFeature> scheduleImpl;
        private Provider<GlobalNetworkRepository> secondaryHash;
        private Provider<SaveKycRenewalButtonClick> setAkuEntranceOpen;
        private Provider<ReferralDialogContract.View> setIndex$kotlin_stdlib;
        private Provider<UpdateServiceHighlighted> setMatchingBeaconTypeCode;
        private Provider<GetUserPan> setNetAuthId;
        private Provider<ScheduleDeviceStatsReport> setRibbonLineTopText;
        private Provider<TncSummaryContract.Presenter> setValuePrefixBytes;
        private Provider<GetFeedConfig> shouldRecycleViewType;
        private Provider<SplitFacade> storeUserConfig;
        private Provider<GetServicesByName> t;
        private Provider<SplitDeviceStatsConfigEntityData> targetValue;
        private Provider<GetSummaryTncConfigWithSpaceCode> u;
        private Provider<OauthRepository> useDaemonThreadFactory;
        private Provider<GetSettingByKey> v;
        private Provider<GetVoiceAssistantConfig> verifyNotNull;
        private Provider<GetUpdateAvailability> w;
        private Provider<DanaCustomH5> whenAvailable;
        private Provider<GetServicesWithCategory> x;
        private Provider<GetUserInfoWithKyc> y;
        private Provider<GetUserCohort> z;

        public /* synthetic */ HomeTabActivityComponentImpl(PlayStoreReviewModules playStoreReviewModules, DanaContactModule danaContactModule, TncSummaryModules tncSummaryModules, UserConfigModule userConfigModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, KycRenewalModule kycRenewalModule, KycAmlEddModule kycAmlEddModule, GlobalNetworkModule globalNetworkModule, ReferralDialogModule referralDialogModule, PaymentSettingModule paymentSettingModule, HomeTabModules homeTabModules, ApplicationComponent applicationComponent, byte b) {
            this(playStoreReviewModules, danaContactModule, tncSummaryModules, userConfigModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, kycRenewalModule, kycAmlEddModule, globalNetworkModule, referralDialogModule, paymentSettingModule, homeTabModules, applicationComponent);
        }

        private HomeTabActivityComponentImpl(PlayStoreReviewModules playStoreReviewModules, DanaContactModule danaContactModule, TncSummaryModules tncSummaryModules, UserConfigModule userConfigModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, KycRenewalModule kycRenewalModule, KycAmlEddModule kycAmlEddModule, GlobalNetworkModule globalNetworkModule, ReferralDialogModule referralDialogModule, PaymentSettingModule paymentSettingModule, HomeTabModules homeTabModules, ApplicationComponent applicationComponent) {
            PaymentSecurityInitMapper_Factory paymentSecurityInitMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.getContainerAuth = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.FontsContractCompat$FontRequestCallback = new ThreadExecutorProvider(applicationComponent);
            this.TwilioRepository = new SSLPinningRepositoryProvider(applicationComponent);
            this.isInfoWindowShown = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.C = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, featureConfigRepositoryProvider);
            this.SendMoneyScenario = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.FontsContractCompat$FontRequestCallback, this.TwilioRepository, create);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.BaseSocialFeedContract$Presenter = playStoreReviewRepositoryProvider;
            this.access$getCapacity$p = IsNeedToShowPlayStoreReview_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, playStoreReviewRepositoryProvider);
            this.SplitReferralConfigEntityData_Factory = SaveLastPlayStoreReviewShow_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.BaseSocialFeedContract$Presenter);
            Provider<PlayStoreReviewContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.getRecommendationData = authRequestContext;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.access$getCapacity$p, this.SplitReferralConfigEntityData_Factory, authRequestContext);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = MyBillsEntityDataFactory;
            this.getExceptionOrNull = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            this.FragmentBottomSheetPaymentSettingBinding = new ContextProvider(applicationComponent);
            this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0 = DanaContactModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(danaContactModule);
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider = recentContactRepositoryProvider;
            this.R = GetDanaContact_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, recentContactRepositoryProvider);
            SyncContactRepositoryProvider syncContactRepositoryProvider = new SyncContactRepositoryProvider(applicationComponent);
            this.ContentDeliveryCacheEntityDataFactory = syncContactRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = CheckSyncProcessCompleteState_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, syncContactRepositoryProvider);
            this.f = GetLastSyncedContact_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.ContentDeliveryCacheEntityDataFactory);
            this.scheduleImpl = CheckContactSyncFeature_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.C);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.DebugCoroutineInfoImpl = provideFeedsShareRepositoryProvider;
            this.getNrCsiRsrq = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(provideFeedsShareRepositoryProvider);
            ContentResolverProvider contentResolverProvider = new ContentResolverProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = contentResolverProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = ContactProvider_Factory.PlaceComponentResult(contentResolverProvider);
            this.View$OnClickListener = new ProvideGetContactsUseCaseProvider(applicationComponent);
            ProvideContactInjectionRepositoryProvider provideContactInjectionRepositoryProvider = new ProvideContactInjectionRepositoryProvider(applicationComponent);
            this.ArrayTable$3 = provideContactInjectionRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetContactInjectionConfig_Factory.create(this.C, provideContactInjectionRepositoryProvider);
            DanaContactPresenter_Factory authRequestContext2 = DanaContactPresenter_Factory.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0, this.R, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.f, this.scheduleImpl, SyncContactUtil_Factory.BuiltInFictitiousFunctionClassFactory(), this.getNrCsiRsrq, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.View$OnClickListener, UserContactMapper_Factory.MyBillsEntityDataFactory(), this.SummaryVoucherView$$ExternalSyntheticLambda0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext2;
            this.MultiLanguageHttpClient = DanaContactModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(danaContactModule, authRequestContext2);
            this.murmurHash64WithSeed = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryViewFactory.getAuthRequestContext(tncSummaryModules));
            TncSummaryRepositoryProvider tncSummaryRepositoryProvider = new TncSummaryRepositoryProvider(applicationComponent);
            this.GetExpressPurchaseResponse$PriceEntity = tncSummaryRepositoryProvider;
            this.u = GetSummaryTncConfigWithSpaceCode_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, tncSummaryRepositoryProvider);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.itemClicked$core = userConsentRepositoryProvider;
            this.PrepareContext = ConsultAgreementOnlyParamSpaceCodes_Factory.create(userConsentRepositoryProvider);
            RecordAgreementOnlyAgreementKey_Factory create2 = RecordAgreementOnlyAgreementKey_Factory.create(this.itemClicked$core);
            this.removeFloat = create2;
            TncSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = TncSummaryPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.murmurHash64WithSeed, this.u, this.PrepareContext, create2);
            this.TimeoutError = KClassImpl$Data$declaredNonStaticMembers$2;
            this.setValuePrefixBytes = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryPresenterFactory.PlaceComponentResult(tncSummaryModules, KClassImpl$Data$declaredNonStaticMembers$2));
            this.f5839$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM = PaymentSettingModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(paymentSettingModule);
            PaymentSettingRepositoryProvider paymentSettingRepositoryProvider = new PaymentSettingRepositoryProvider(applicationComponent);
            this.applyTrimPathIfNeeded = paymentSettingRepositoryProvider;
            this.encodingStream = PaymentSettingCheck_Factory.create(paymentSettingRepositoryProvider);
            this.CreateRemoteWorkerExtension = SavePaymentSettingCheck_Factory.create(this.applyTrimPathIfNeeded);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.KeyEvent$DispatcherState = settingRepositoryProvider;
            this.v = GetSettingByKey_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, settingRepositoryProvider);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = autoRouteRepositoryProvider;
            this.O = GetAutoRouteInitialSetting_Factory.create(autoRouteRepositoryProvider);
            this.saveNickname = SwitchAutoRouting_Factory.create(this.PlaceComponentResult);
            this.JsonParseException = InitPaymentAuthentication_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.KeyEvent$DispatcherState);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = ControlSwitchPaymentAuthentication_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.KeyEvent$DispatcherState);
            Provider<PaymentSettingContract.View> provider = this.f5839$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
            Provider<PaymentSettingCheck> provider2 = this.encodingStream;
            Provider<SavePaymentSettingCheck> provider3 = this.CreateRemoteWorkerExtension;
            Provider<GetSettingByKey> provider4 = this.v;
            Provider<GetAutoRouteInitialSetting> provider5 = this.O;
            Provider<SwitchAutoRouting> provider6 = this.saveNickname;
            Provider<InitPaymentAuthentication> provider7 = this.JsonParseException;
            paymentSecurityInitMapper_Factory = PaymentSecurityInitMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            PaymentSettingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = PaymentSettingPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider, provider2, provider3, provider4, provider5, provider6, provider7, paymentSecurityInitMapper_Factory, this.NetworkUserEntityData$$ExternalSyntheticLambda3, PaymentSecuritySwitchMapper_Factory.getAuthRequestContext());
            this.SecuritySettingsActivity$createPinLauncher$2$2 = KClassImpl$Data$declaredNonStaticMembers$22;
            this.onPolygonsChanged = PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(paymentSettingModule, KClassImpl$Data$declaredNonStaticMembers$22);
            this.getGnBenefitEntityDanaProtection = KycRenewalModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(kycRenewalModule);
            KycRenewalRepositoryProvider kycRenewalRepositoryProvider = new KycRenewalRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = kycRenewalRepositoryProvider;
            this.e = GetKycRenewal_Factory.create(kycRenewalRepositoryProvider);
            this.TypeProjectionImpl = GetKycRenewalCheckQuery_Factory.create(this.FlowableKt$toIterable$1);
            this.roundToPowerOfTwo = SaveKycRenewalCheckQuery_Factory.create(this.FlowableKt$toIterable$1);
            this.g = GetKycRenewalCheckShow_Factory.create(this.FlowableKt$toIterable$1);
            this.getNrCsiRsrp = SaveKycRenewalCheckShow_Factory.create(this.FlowableKt$toIterable$1);
            this.c = GetKycRenewalCheckDismiss_Factory.create(this.FlowableKt$toIterable$1);
            this.allowedTargets = SaveKycRenewalCheckDismiss_Factory.create(this.FlowableKt$toIterable$1);
            this.QrExpiredActivity = GetKycRenewalButtonClicked_Factory.create(this.FlowableKt$toIterable$1);
            SaveKycRenewalButtonClick_Factory create3 = SaveKycRenewalButtonClick_Factory.create(this.FlowableKt$toIterable$1);
            this.setAkuEntranceOpen = create3;
            this.retainOrRemoveAllInternal = KycRenewalPresenter_Factory.MyBillsEntityDataFactory(this.getGnBenefitEntityDanaProtection, this.e, this.TypeProjectionImpl, this.roundToPowerOfTwo, this.g, this.getNrCsiRsrp, this.c, this.allowedTargets, this.QrExpiredActivity, create3);
            this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl = KycAmlEddModule_ProvideView$app_productionReleaseFactory.getAuthRequestContext(kycAmlEddModule);
            KycAmlEddRepositoryProvider kycAmlEddRepositoryProvider = new KycAmlEddRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = kycAmlEddRepositoryProvider;
            this.d = GetKycAmlEddConsult_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, kycAmlEddRepositoryProvider);
            SubmitEddAmlKyc_Factory create4 = SubmitEddAmlKyc_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.PromoCategoryPresenter$1);
            this.access$showKycAmlEddDialog = create4;
            this.InitSecurePreferenceAccount = KycAmlEddPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl, this.d, create4);
            this.isAllowRetry = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.secondaryHash = globalNetworkRepositoryProvider;
            this.getIndexName = IsCScanBEnabled_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, globalNetworkRepositoryProvider);
            this.readMicros = DecodeGnQr_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.secondaryHash);
            this.getTextEndPadding = OpenMerchantCashier_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.secondaryHash);
            this.Z = GetGnCScanBBlacklistedCountry_Factory.create(this.secondaryHash);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.SightCameraView$ICameraFrameListener = userRepositoryProvider;
            this.y = GetUserInfoWithKyc_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, userRepositoryProvider);
            this.FlowableConcatMapEagerPublisher = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.secondaryHash);
            this.onDecodeSuccess = IsAlipayConnectServiceFirstTime_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.secondaryHash);
            this.getSavingConfigPresenter = SaveAlipayConnectServiceFirstTime_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.secondaryHash);
            this.getCardNumberOCR = GetWalletOauth_Factory.create(this.secondaryHash);
            this.useDaemonThreadFactory = new OauthRepositoryProvider(applicationComponent);
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(this.itemClicked$core);
            this.V = create5;
            this.Q = GetAuthCode_Factory.create(this.useDaemonThreadFactory, create5);
            GetPayRequest_Factory create6 = GetPayRequest_Factory.create(this.secondaryHash);
            this.l = create6;
            Provider<GlobalNetworkPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.isAllowRetry, this.getIndexName, this.readMicros, this.getTextEndPadding, this.Z, this.y, this.FlowableConcatMapEagerPublisher, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.onDecodeSuccess, this.getSavingConfigPresenter, this.getCardNumberOCR, this.Q, create6));
            this.FlowableCreate$BufferAsyncEmitter = authRequestContext3;
            this.NavigationMenuPresenter$HeaderViewHolder = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext3));
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.AppCategory = recentRecipientRepositoryProvider;
            this.access$setShowcaseShowing$p = MigrateRecentRecipientConfigToRoom_Factory.create(recentRecipientRepositoryProvider);
            this.setNetAuthId = GetUserPan_Factory.create(this.SightCameraView$ICameraFrameListener);
            Provider<UserConfigContract.View> authRequestContext4 = DoubleCheck.getAuthRequestContext(UserConfigModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(userConfigModule));
            this.StandardRowSortedTable$1 = authRequestContext4;
            UserConfigPresenter_Factory authRequestContext5 = UserConfigPresenter_Factory.getAuthRequestContext(this.access$setShowcaseShowing$p, this.setNetAuthId, authRequestContext4);
            this.ImageCaptureViewModel$getTipUploadPhoto$2 = authRequestContext5;
            this.isTmpDetached = DoubleCheck.getAuthRequestContext(UserConfigModule_ProvideUserConfigPresenterFactory.BuiltInFictitiousFunctionClassFactory(userConfigModule, authRequestContext5));
            this.SubmitReceiptResultModel$Creator = HomeTabModules_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(homeTabModules);
            ProvideHomeConfigEntityRepositoryProvider provideHomeConfigEntityRepositoryProvider = new ProvideHomeConfigEntityRepositoryProvider(applicationComponent);
            this.getPhoneMask = provideHomeConfigEntityRepositoryProvider;
            this.i = GetMixpanelStorageConfig_Factory.create(provideHomeConfigEntityRepositoryProvider);
            this.verifyNotNull = GetVoiceAssistantConfig_Factory.create(this.getPhoneMask);
            this.z = GetUserCohort_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.TypeToken$TypeSet = new ProvideRiskTrackerProvider(applicationComponent);
            ProvideHomePassiveBioRepositoryProvider provideHomePassiveBioRepositoryProvider = new ProvideHomePassiveBioRepositoryProvider(applicationComponent);
            this.SchedulerPoolFactory = provideHomePassiveBioRepositoryProvider;
            this.DatabaseTableConfigUtil = CheckHomePassiveBioTracked_Factory.create(provideHomePassiveBioRepositoryProvider);
            this.onLayoutDirectionChanged = SavePassiveBioTracked_Factory.create(this.SchedulerPoolFactory);
            ProvideCredentialRepositoryProvider provideCredentialRepositoryProvider = new ProvideCredentialRepositoryProvider(applicationComponent);
            this.ConcurrentKt = provideCredentialRepositoryProvider;
            this.FlowViewUtil$textChanges$1 = GetPasswordLastModifiedWithConfigChecking_Factory.create(provideCredentialRepositoryProvider);
            this.p = GetQueryUserDataConfig_Factory.create(this.C);
            this.Y = GetFeatureHoldLoginConfig_Factory.create(this.getPhoneMask);
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.createJavaMethod = provideResetPinRepositoryProvider;
            this.isLayoutRequested = ConsultForceDanaVizEnroll_Factory.create(provideResetPinRepositoryProvider, this.SightCameraView$ICameraFrameListener);
            this.SizeSelectors$OrSelector = GetResetAndChangePinNativeEntryConfig_Factory.create(this.C);
            this.M = FileSystemStorageEntity_Factory.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding);
            ProvideSplitFacadeProvider provideSplitFacadeProvider = new ProvideSplitFacadeProvider(applicationComponent);
            this.storeUserConfig = provideSplitFacadeProvider;
            this.targetValue = SplitDeviceStatsConfigEntityData_Factory.MyBillsEntityDataFactory(provideSplitFacadeProvider);
            this.ArrayTable$2 = DeviceStatsModule_ProvideDeviceStatsPreferenceFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.FragmentBottomSheetPaymentSettingBinding);
            DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory MyBillsEntityDataFactory2 = DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding);
            this.ArrayTable$1 = MyBillsEntityDataFactory2;
            FileSystemStatsRepository_Factory KClassImpl$Data$declaredNonStaticMembers$23 = FileSystemStatsRepository_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.M, this.targetValue, this.ArrayTable$2, MyBillsEntityDataFactory2, FileDirectoriesSizeMapper_Factory.MyBillsEntityDataFactory());
            this.K = KClassImpl$Data$declaredNonStaticMembers$23;
            FileDirectorySizeReportScheduler_Factory create7 = FileDirectorySizeReportScheduler_Factory.create(KClassImpl$Data$declaredNonStaticMembers$23);
            this.G = create7;
            this.setRibbonLineTopText = ScheduleDeviceStatsReport_Factory.create(create7);
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.insertActivities = loginRepositoryProvider;
            this.b = GetIsSessionChecked_Factory.create(loginRepositoryProvider);
            this.ISO8601Utils = SaveIsSessionChecked_Factory.create(this.insertActivities);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = CheckSession_Factory.create(this.insertActivities);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            IsFirstTime_Factory create8 = IsFirstTime_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, accountRepositoryProvider);
            this.checkRegisteredUserAndSendOtp = create8;
            HomeTabPresenter_Factory BuiltInFictitiousFunctionClassFactory = HomeTabPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.SubmitReceiptResultModel$Creator, this.i, this.verifyNotNull, this.z, this.TypeToken$TypeSet, this.DatabaseTableConfigUtil, this.onLayoutDirectionChanged, this.FlowViewUtil$textChanges$1, this.p, this.Y, this.isLayoutRequested, this.SizeSelectors$OrSelector, this.setRibbonLineTopText, this.b, this.ISO8601Utils, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create8);
            this.getDefaultSenderId = BuiltInFictitiousFunctionClassFactory;
            this.UnicastProcessor$UnicastQueueSubscription = HomeTabModules_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(homeTabModules, BuiltInFictitiousFunctionClassFactory);
            this.flow = ReadDeepLinkProperties_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown);
            Provider<Activity> authRequestContext6 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.CheckPromoQuestFeature = authRequestContext6;
            Provider<ScanQrView> authRequestContext7 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext6));
            this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider = authRequestContext7;
            this.getStackFromEnd = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext7));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.glVertexAttrib1fv = qrBarcodeRepositoryProvider;
            this.isAuth = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.U = GetDecodedQrisTopUp_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.glVertexAttrib1fv);
            this.FamilyManageAvailableServicesAdapter = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.getCallingPid = new DeviceInformationProviderProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = GetUserStatusInfo_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.P = GetCashierNativeConfig_Factory.create(this.C);
            this.f5843reduceIndexedz1zDJgo = IsNativeDecodeEnabled_Factory.create(this.C);
            GetDecodeTciCoListConfig_Factory create9 = GetDecodeTciCoListConfig_Factory.create(this.C);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create9;
            this.TrustRiskLogin$Params = ValidateNativelyDecodedQr_Factory.create(create9);
            this.FillAnimation = GetMerchantQrWhitelist_Factory.create(this.glVertexAttrib1fv);
            this.m = GetQrBindingConfig_Factory.create(this.C);
            this.ApiStatus$AvailableSince = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.C);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.TrackerKey$GlobalSearchOpenProperties = providePaylaterRepositoryProvider;
            this.RequestMoneyQrContract$View = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.parametersAsMap = userEducationRepositoryProvider;
            this.j = GetQrisCpmSendmoneyConfig_Factory.create(this.C, userEducationRepositoryProvider);
            this.CreateOrderTopUpFamilyBalance = SaveShowDialog_Factory.create(this.parametersAsMap);
            Provider<ScanQrPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.FragmentBottomSheetPaymentSettingBinding, this.getStackFromEnd, this.isAuth, this.U, this.FamilyManageAvailableServicesAdapter, this.getCallingPid, this.FlowableReduce$ReduceSubscriber, this.P, GetNativelyDecodedQr_Factory.create(), this.f5843reduceIndexedz1zDJgo, this.TrustRiskLogin$Params, this.FillAnimation, this.m, this.ApiStatus$AvailableSince, this.RequestMoneyQrContract$View, this.j, this.CreateOrderTopUpFamilyBalance));
            this.access$getServiceItemDecorator$p = authRequestContext8;
            this.outerType = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext8));
            Provider<RestoreUrlView> authRequestContext9 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding));
            this.access$getFeaturedBankListAdapter$p = authRequestContext9;
            this.EmergencyNotifActivity$getEmergencyNotifModule$1 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext9));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.createSecondaryAnimatorProvider = shortenerRepositoryProvider;
            RestoreUrl_Factory create10 = RestoreUrl_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, shortenerRepositoryProvider);
            this.connectionSpecs = create10;
            Provider<RestoreUrlPresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.EmergencyNotifActivity$getEmergencyNotifModule$1, create10));
            this.GetTopUpUserConsult = authRequestContext10;
            this.getOpPackageName = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext10));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = myReferralConsultRepositoryProvider;
            this.n = GetReferralConsult_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, myReferralConsultRepositoryProvider);
            this.GetContactSyncConfig = CheckShowReferralCodeFeature_Factory.create(this.C);
            this.isRegionMiniProgram = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getNameOrBuilderList = generateLinkRepositoryProvider;
            this.J = GenerateReferralDeepLink_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, generateLinkRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.containsObjectForKey = productPageManagerProvider;
            this.F = FeatureSettingMore_Factory.PlaceComponentResult(this.v, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.onGetActiveNotifications = splitBillRepositoryProvider;
            this.k = GetPayerSplitBillDetail_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, splitBillRepositoryProvider);
            this.WrappedDrawableState = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.WrappedDrawableState);
            this.ViewInputOtpBinding = PlaceComponentResult;
            this.H = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.k, PlaceComponentResult);
            this.TypefaceCompatApi26Impl = GetSplitBillConfig_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.C);
            GetRequestMoneyInfoFeature_Factory create11 = GetRequestMoneyInfoFeature_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.C);
            this.f8119o = create11;
            Provider<GetSplitBillConfig> provider8 = this.TypefaceCompatApi26Impl;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.I = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider8, create11, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.f5840x461046d9 = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create12 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.connectForeground = create12;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = FeaturePromoQuest_Factory.getAuthRequestContext(create12, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.getValueOfTouchPositionAbsolute = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.whenAvailable = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.FragmentBottomSheetPaymentSettingBinding));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory3 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding);
            this.rotateTo = MyBillsEntityDataFactory3;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory3));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = provideFamilyAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.A = dynamicUrlWrapperProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.InvestmentWalletAdapter = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory2 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.isAuto = BuiltInFictitiousFunctionClassFactory2;
            this.B = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            this.D = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.rotateTo));
            Provider<FeatureView> authRequestContext11 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.n, this.GetContactSyncConfig, this.isRegionMiniProgram, this.J, this.F, this.H, this.I, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.getValueOfTouchPositionAbsolute, this.whenAvailable, FeatureHome_Factory.MyBillsEntityDataFactory(), this.VerifyPinStateManager$executeRiskChallenge$2$1, FeatureKyb_Factory.getAuthRequestContext(), this.BottomSheetCardBindingView$watcherCardNumberView$1, this.B, this.RequestMoneyQrContract$View, FeatureMyBills_Factory.PlaceComponentResult(), this.D));
            this.AppCompatEmojiTextHelper = authRequestContext11;
            this.SplitSavingConfigEntityData = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext11));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0 = servicesRepositoryProvider;
            this.r = GetServicesByKey_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext12 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding);
            this.CacheBuilderSpec$AccessDurationParser = authRequestContext12;
            ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory3 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext12);
            this.ImageCaptureViewModel$getTipUploadPhoto$1 = BuiltInFictitiousFunctionClassFactory3;
            this.getOnBoardingScenario = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SplitSavingConfigEntityData, this.r, BuiltInFictitiousFunctionClassFactory3, this.Q, this.getCallingPid));
            this.lookAheadTest = CheckDeepLinkActionVisibility_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.C);
            this.newProxyInstance = CheckWhitelistedValidDomain_Factory.create(this.C);
            this.FlowViewUtil$textChanges$2 = GetNearbyConfig_Factory.create(this.C);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.WithdrawSavedCardChannelView = provideFeedsConfigRepositoryProvider;
            this.shouldRecycleViewType = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.access$throwIllegalArgumentType = GetPromoCenterVersion_Factory.create(this.C);
            this.w = GetUpdateAvailability_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.initRecordTimeStamp = CheckMyBillsVersionConfig_Factory.create(this.C);
            this.PrefetchDownloadStatus = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create13 = GetService_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.s = create13;
            Provider<FeaturePresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.SplitSavingConfigEntityData, this.getOnBoardingScenario, this.lookAheadTest, this.newProxyInstance, this.FlowViewUtil$textChanges$2, this.shouldRecycleViewType, this.access$throwIllegalArgumentType, this.w, this.initRecordTimeStamp, this.PrefetchDownloadStatus, create13));
            this.E = authRequestContext13;
            this.PlaybackStateCompat$MediaKeyAction = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext13));
            OauthView_Factory authRequestContext14 = OauthView_Factory.getAuthRequestContext(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.getRawPath = authRequestContext14;
            this.FamilyDashboardPresenter_Factory = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext14));
            this.f8118a = GetKycLevel_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.h = GetNickname_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.BuiltInFictitiousFunctionClassFactory);
            this.OtpRegistrationPresenter$input$1 = GetWhitelistedSubMerchantId_Factory.create(this.C);
            this.N = GetAddingNameWhitelistedMerchantId_Factory.create(this.C);
            Provider<OauthContract.View> provider9 = this.FamilyDashboardPresenter_Factory;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$24 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider9, oauthParamsModelMapper_Factory, this.f8118a, this.y, this.h, this.OtpRegistrationPresenter$input$1, this.N);
            this.getFontAssetManager = KClassImpl$Data$declaredNonStaticMembers$24;
            this.onTooManyRedirects = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$24));
            this.f5842getWalletV3RecommendationConfig$lambda193 = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.ReferralMapper_Factory = IsNeedToShowToolTip_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.parametersAsMap);
            this.indexOfAny = SaveShowToolTip_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.parametersAsMap);
            this.x = GetServicesWithCategory_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.T = GetDefaultServiceWithCategory_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.X = GetFavoriteServiceRemote_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.t = GetServicesByName_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.flip = GetFavoriteServices_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckFavoriteServicesFeature_Factory.create(this.C);
            this.OtpRegistrationPresenter$input$2 = GetRawServices_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.W = GetFavoriteServiceWithCacheFirst_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.q = GetServiceHighlighted_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            UpdateServiceHighlighted_Factory create14 = UpdateServiceHighlighted_Factory.create(this.f5838$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0);
            this.setMatchingBeaconTypeCode = create14;
            this.NearbyConstantsKt = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.f5842getWalletV3RecommendationConfig$lambda193, this.Q, this.ImageCaptureViewModel$getTipUploadPhoto$1, this.ReferralMapper_Factory, this.indexOfAny, this.x, this.T, this.X, this.t, this.r, this.flip, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.OtpRegistrationPresenter$input$2, this.W, this.q, create14));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext15 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.outerType, this.getOpPackageName, this.PlaybackStateCompat$MediaKeyAction, this.onTooManyRedirects, this.NearbyConstantsKt, applicationProvider, this.RequestMoneyQrContract$View));
            this.getSupportButtonTintMode = authRequestContext15;
            this.doCommonLog = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext15));
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.SubSequence = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.S = GetDealsConfig_Factory.create(this.C);
            this.moveToNextValue = CashierEventHandler_Factory.BuiltInFictitiousFunctionClassFactory(this.P);
            this.setIndex$kotlin_stdlib = DoubleCheck.getAuthRequestContext(ReferralDialogModule_ProvideViewFactory.MyBillsEntityDataFactory(referralDialogModule));
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.getTypeMappings = referralRepositoryProvider;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = GetReferralEngagementDialog_Factory.create(referralRepositoryProvider, this.C, this.CYFMonitor$ChallengeActionCallback);
            this.ListenerMethod = SaveReferralEngagementDialogCache_Factory.create(this.getTypeMappings);
            ReferralEngagementDialogRepositoryProvider referralEngagementDialogRepositoryProvider = new ReferralEngagementDialogRepositoryProvider(applicationComponent);
            this.fromContextOrNull = referralEngagementDialogRepositoryProvider;
            this.ImageWithDescriptionView$showImage$1 = SaveReferralDialogDailyLimit_Factory.create(referralEngagementDialogRepositoryProvider);
            CheckDialogDailyLimit_Factory create15 = CheckDialogDailyLimit_Factory.create(this.fromContextOrNull, this.getTypeMappings);
            this.getErrorConfigVersion = create15;
            Provider<ReferralDialogPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(ReferralDialogPresenter_Factory.PlaceComponentResult(this.setIndex$kotlin_stdlib, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.ListenerMethod, this.ImageWithDescriptionView$showImage$1, create15));
            this.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 = authRequestContext16;
            this.checkMarmotConfig = DoubleCheck.getAuthRequestContext(ReferralDialogModule_ProvidePresenterFactory.MyBillsEntityDataFactory(referralDialogModule, authRequestContext16));
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.getReadyFragment = liteAccountRepositoryProvider;
            GetUserId_Factory create16 = GetUserId_Factory.create(this.FontsContractCompat$FontRequestCallback, this.isInfoWindowShown, liteAccountRepositoryProvider);
            this.initAnimators = create16;
            Provider<ReadLinkPropertiesPresenter> authRequestContext17 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.doCommonLog, this.flow, this.SubSequence, create16, this.rotateTo));
            this.RepaymentPlan = authRequestContext17;
            this.checkParameterIsNotNull = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext17));
            this.BannerEntityDataFactory_Factory = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.f5841x461046da = provideEventTrackerQueueProvider;
            this.L = FirebaseAnalytics_Factory.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this.BannerEntityDataFactory_Factory, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$25 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.FragmentBottomSheetPaymentSettingBinding, this.f5841x461046da);
            this.NewMerchantCategoryAdapter = KClassImpl$Data$declaredNonStaticMembers$25;
            Provider<FirebaseAnalytics> provider10 = this.L;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.getAuthRequestContext = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider10, KClassImpl$Data$declaredNonStaticMembers$25, fullStoryAnalytics_Factory);
        }

        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.Z());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
            }
        }

        /* loaded from: classes4.dex */
        public static final class RecentContactRepositoryProvider implements Provider<RecentContactRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ReferralMapper_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SyncContactRepositoryProvider implements Provider<SyncContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SyncContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SyncContactRepository get() {
                return (SyncContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.containsObjectForKey());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContentResolverProvider implements Provider<ContentResolver> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContentResolverProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContentResolver get() {
                return (ContentResolver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideGetContactsUseCaseProvider implements Provider<GetContactsUseCase> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideGetContactsUseCaseProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GetContactsUseCase get() {
                return (GetContactsUseCase) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.p());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideContactInjectionRepositoryProvider implements Provider<ContactInjectionRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideContactInjectionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactInjectionRepository get() {
                return (ContactInjectionRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.h());
            }
        }

        /* loaded from: classes4.dex */
        public static final class TncSummaryRepositoryProvider implements Provider<TncSummaryRepository> {
            private final ApplicationComponent PlaceComponentResult;

            TncSummaryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TncSummaryRepository get() {
                return (TncSummaryRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$3());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PaymentSettingRepositoryProvider implements Provider<PaymentSettingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            PaymentSettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaymentSettingRepository get() {
                return (PaymentSettingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.U());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isInfoWindowShown());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent PlaceComponentResult;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.scheduleImpl());
            }
        }

        /* loaded from: classes4.dex */
        public static final class KycRenewalRepositoryProvider implements Provider<KycRenewalRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            KycRenewalRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KycRenewalRepository get() {
                return (KycRenewalRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.F());
            }
        }

        /* loaded from: classes4.dex */
        public static final class KycAmlEddRepositoryProvider implements Provider<KycAmlEddRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            KycAmlEddRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KycAmlEddRepository get() {
                return (KycAmlEddRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.I());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SubSequence());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent getAuthRequestContext;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$setShowcaseShowing$p());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomeConfigEntityRepositoryProvider implements Provider<HomeConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideHomeConfigEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeConfigRepository get() {
                return (HomeConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.n());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideRiskTrackerProvider implements Provider<RiskTracker> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideRiskTrackerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RiskTracker get() {
                return (RiskTracker) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getDefaultSenderId());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomePassiveBioRepositoryProvider implements Provider<HomePassiveBioRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideHomePassiveBioRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomePassiveBioRepository get() {
                return (HomePassiveBioRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SizeSelectors$OrSelector());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideCredentialRepositoryProvider implements Provider<CredentialRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideCredentialRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CredentialRepository get() {
                return (CredentialRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowViewUtil$textChanges$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getContainerAuth());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideSplitFacadeProvider implements Provider<SplitFacade> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideSplitFacadeProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitFacade get() {
                return (SplitFacade) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.secondaryHash());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.G());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SendMoneyScenario());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.setNetAuthId());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.applyTrimPathIfNeeded());
            }
        }

        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.P());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent PlaceComponentResult;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent PlaceComponentResult;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.PlaceComponentResult.shouldRecycleViewType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ConcurrentKt());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.QrExpiredActivity());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.k());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.z());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.access$throwIllegalArgumentType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent getAuthRequestContext;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ReferralRepositoryProvider implements Provider<ReferralRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ReferralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralRepository get() {
                return (ReferralRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NewMerchantCategoryAdapter());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ReferralEngagementDialogRepositoryProvider implements Provider<ReferralEngagementDialogRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ReferralEngagementDialogRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralEngagementDialogRepository get() {
                return (ReferralEngagementDialogRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FlowableKt$toIterable$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.OtpRegistrationPresenter$input$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.j());
            }
        }

        @Override // id.dana.di.component.HomeTabActivityComponent
        public final void BuiltInFictitiousFunctionClassFactory(HomeTabActivity homeTabActivity) {
            ((BaseActivity) homeTabActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.C));
            HomeTabActivity_MembersInjector.moveToNextValue(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.getExceptionOrNull));
            HomeTabActivity_MembersInjector.getAuthRequestContext(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.MultiLanguageHttpClient));
            HomeTabActivity_MembersInjector.GetContactSyncConfig(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.setValuePrefixBytes));
            HomeTabActivity_MembersInjector.getErrorConfigVersion(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.onPolygonsChanged));
            HomeTabActivity_MembersInjector.scheduleImpl(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.retainOrRemoveAllInternal));
            HomeTabActivity_MembersInjector.lookAheadTest(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.InitSecurePreferenceAccount));
            homeTabActivity.globalNetworkPresenter = DoubleCheck.MyBillsEntityDataFactory(this.NavigationMenuPresenter$HeaderViewHolder);
            HomeTabActivity_MembersInjector.DatabaseTableConfigUtil(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.isTmpDetached));
            homeTabActivity.homeTabPresenter = DoubleCheck.MyBillsEntityDataFactory(this.UnicastProcessor$UnicastQueueSubscription);
            homeTabActivity.feedsContentAction = new FeedsContentAction((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), DoubleCheck.MyBillsEntityDataFactory(this.flow), DoubleCheck.MyBillsEntityDataFactory(this.doCommonLog), DoubleCheck.MyBillsEntityDataFactory(this.SubSequence), DoubleCheck.MyBillsEntityDataFactory(this.rotateTo), DoubleCheck.MyBillsEntityDataFactory(this.A), DoubleCheck.MyBillsEntityDataFactory(this.S), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.RequestMoneyQrContract$View));
            homeTabActivity.referralDialogPresenter = DoubleCheck.MyBillsEntityDataFactory(this.checkMarmotConfig);
            HomeTabActivity_MembersInjector.MyBillsEntityDataFactory(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.checkParameterIsNotNull));
            HomeTabActivity_MembersInjector.PlaceComponentResult(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.A));
            homeTabActivity.homeTrackerImpl = new HomeTrackerImpl(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            HomeTabActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(homeTabActivity, DoubleCheck.MyBillsEntityDataFactory(this.FlowableConcatMapEagerPublisher));
        }
    }
}
