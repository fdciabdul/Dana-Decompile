package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.animation.tab.HomeTabFragment_MembersInjector;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.tracker.HomeTrackerImpl_Factory;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.CashierEventHandler_Factory;
import id.dana.connectivity.ConnectivityMonitorContract;
import id.dana.connectivity.ConnectivityMonitorModule;
import id.dana.connectivity.ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory;
import id.dana.connectivity.ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory;
import id.dana.connectivity.ConnectivityMonitorPresenter;
import id.dana.connectivity.ConnectivityMonitorPresenter_Factory;
import id.dana.contract.account.FirstTimeContract;
import id.dana.contract.account.FirstTimeModule;
import id.dana.contract.account.FirstTimeModule_ProvidePresenterFactory;
import id.dana.contract.account.FirstTimeModule_ProvideViewFactory;
import id.dana.contract.account.FirstTimePresenter;
import id.dana.contract.account.FirstTimePresenter_Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeepLinkModule_ProvidePresenterFactory;
import id.dana.contract.deeplink.DeepLinkModule_ProvideReadPropertiesPresenterFactory;
import id.dana.contract.deeplink.DeepLinkModule_ProvideViewFactory;
import id.dana.contract.deeplink.DeepLinkPresenter;
import id.dana.contract.deeplink.DeepLinkPresenter_Factory;
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
import id.dana.contract.deeplink.tracker.DeeplinkTrackerFactory;
import id.dana.contract.deeplink.tracker.DeeplinkTrackerFactory_Factory;
import id.dana.contract.deeplink.tracker.FullstoryDeeplinkTracker_Factory;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker_Factory;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.homeinfo.HomeInfoModule_ProvidePresenterFactory;
import id.dana.contract.homeinfo.HomeInfoModule_ProvideViewFactory;
import id.dana.contract.homeinfo.HomeInfoPresenter;
import id.dana.contract.homeinfo.HomeInfoPresenter_Factory;
import id.dana.contract.homeinfo.HomeRevampContract;
import id.dana.contract.homeinfo.HomeRevampModule;
import id.dana.contract.homeinfo.HomeRevampModule_ProvidePresenterFactory;
import id.dana.contract.homeinfo.HomeRevampModule_ProvideViewFactory;
import id.dana.contract.homeinfo.HomeRevampPresenter;
import id.dana.contract.homeinfo.HomeRevampPresenter_Factory;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationModule;
import id.dana.contract.notification.PushNotificationModule_ProvidePresenterFactory;
import id.dana.contract.notification.PushNotificationModule_ProvideViewFactory;
import id.dana.contract.notification.PushNotificationPresenter;
import id.dana.contract.notification.PushNotificationPresenter_Factory;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterModule_ProvideView$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterPresenter;
import id.dana.contract.paylater.PayLaterPresenter_Factory;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.contract.promotion.InterstitialPromotionBannerModule;
import id.dana.contract.promotion.InterstitialPromotionBannerModule_ProvidePresenterFactory;
import id.dana.contract.promotion.InterstitialPromotionBannerModule_ProvideViewFactory;
import id.dana.contract.promotion.InterstitialPromotionBannerPresenter;
import id.dana.contract.promotion.InterstitialPromotionBannerPresenter_Factory;
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
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.di.modules.QrisCrossBorderModule;
import id.dana.di.modules.QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.QrisCrossBorderModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.FinishFirstTime;
import id.dana.domain.account.interactor.FinishFirstTime_Factory;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.account.interactor.GetNickname_Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.IsFirstTime;
import id.dana.domain.account.interactor.IsFirstTime_Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.connectionbar.ConnectionBarRepository;
import id.dana.domain.connectionbar.interactor.GetIsFeatureConnectionBarWithSignalOn;
import id.dana.domain.connectionbar.interactor.GetIsFeatureConnectionBarWithSignalOn_Factory;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload_Factory;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink_Factory;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties_Factory;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload_Factory;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility_Factory;
import id.dana.domain.featureconfig.interactor.CheckInterstitialBannerFeature;
import id.dana.domain.featureconfig.interactor.CheckInterstitialBannerFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature;
import id.dana.domain.featureconfig.interactor.CheckPushNotifDiagnosticFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain_Factory;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetHomeInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel_Factory;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction_Factory;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData_Factory;
import id.dana.domain.homeinfo.interactor.GetUserConfig;
import id.dana.domain.homeinfo.interactor.GetUserConfig_Factory;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig_Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm_Factory;
import id.dana.domain.notificationcenter.interactor.BindApp;
import id.dana.domain.notificationcenter.interactor.BindApp_Factory;
import id.dana.domain.notificationcenter.interactor.ReportDevice;
import id.dana.domain.notificationcenter.interactor.ReportDevice_Factory;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId_Factory;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.interactor.GetQrBindingConfig_Factory;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime_Factory;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.GetUserLoanInfo_Factory;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime_Factory;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache_Factory;
import id.dana.domain.paylater.interactor.SetPaylaterChannel;
import id.dana.domain.paylater.interactor.SetPaylaterChannel_Factory;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache_Factory;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature;
import id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature_Factory;
import id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData;
import id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData_Factory;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.domain.preventscreenshot.interactor.GetPreventScreenshotConfig;
import id.dana.domain.preventscreenshot.interactor.GetPreventScreenshotConfig_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetProfileRevampConfig;
import id.dana.domain.profilemenu.interactor.GetProfileRevampConfig_Factory;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.GetSettingByKey_Factory;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion_Factory;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.domain.promoquest.interactor.GetMissionDetail_Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.promotion.interactor.GetInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.GetInterstitialPromotionBanner_Factory;
import id.dana.domain.promotion.interactor.ReadInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.ReadInterstitialPromotionBanner_Factory;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerGapTime;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerGapTime_Factory;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerResetTime;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerResetTime_Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
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
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import id.dana.domain.qriscrossborder.interactor.GetQrisCountryCodeByLocation;
import id.dana.domain.qriscrossborder.interactor.GetQrisCountryCodeByLocation_Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderConfig;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderConfig_Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderContent;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderContent_Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderCountries;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderCountries_Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.GetQrisCurrentCountryCode_Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.GetQrisOriginCountryCode_Factory;
import id.dana.domain.qriscrossborder.interactor.SaveQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisCurrentCountryCode_Factory;
import id.dana.domain.qriscrossborder.interactor.SaveQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisOriginCountryCode_Factory;
import id.dana.domain.qriscrossborder.interactor.SendRiskEventWithParams;
import id.dana.domain.qriscrossborder.interactor.SendRiskEventWithParams_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
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
import id.dana.domain.transactionhistory.interactor.GetTransactionHistoryConfig;
import id.dana.domain.transactionhistory.interactor.GetTransactionHistoryConfig_Factory;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt;
import id.dana.domain.twilio.interactor.SaveTwilioChallengeAttempt_Factory;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken;
import id.dana.domain.twilio.interactor.UpdateTwilioPushToken_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.user.interactor.GetUserStatusInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowDialog;
import id.dana.domain.usereducation.interactor.SaveShowDialog_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.domain.version.interactor.GetUpdateAvailability_Factory;
import id.dana.domain.wallet_v3.interactor.GetWalletConfig;
import id.dana.domain.wallet_v3.interactor.GetWalletConfig_Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig_Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.h5event.CheckoutH5EventPresenter_Factory;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled_Factory;
import id.dana.kyb.domain.interactor.IsQrisPaymentEnabled;
import id.dana.kyb.domain.interactor.IsQrisPaymentEnabled_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.HasNewModelMapper_Factory;
import id.dana.mapper.HomeDataModelMapper;
import id.dana.mapper.HomeDataModelMapper_Factory;
import id.dana.mapper.HomeInfoMapper;
import id.dana.mapper.HomeInfoMapper_Factory;
import id.dana.mapper.PromotionMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import id.dana.qriscrossborder.QrisCrossBorderPresenter;
import id.dana.qriscrossborder.QrisCrossBorderPresenter_Factory;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase_Factory;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission_Factory;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase_Factory;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerHomeTabComponent {
    private DaggerHomeTabComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public RestoreUrlModule DatabaseTableConfigUtil;
        public QrisCrossBorderModule GetContactSyncConfig;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ConnectivityMonitorModule MyBillsEntityDataFactory;
        public FirstTimeModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public PayLaterModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public PushNotificationModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda8;
        public DeepLinkModule PlaceComponentResult;
        public ScanQrModule PrepareContext;
        public CheckoutH5EventModule getAuthRequestContext;
        public HomeInfoModule getErrorConfigVersion;
        public PlayStoreReviewModules initRecordTimeStamp;
        public HomeRevampModule lookAheadTest;
        public OauthModule moveToNextValue;
        public InterstitialPromotionBannerModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class HomeTabComponentImpl implements HomeTabComponent {

        /* renamed from: $r8$lambda$7jSe-jJ0etbd9VooMli6zMuqlA0 */
        private Provider<SplitBillRepository> f5844$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0;

        /* renamed from: $r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M */
        private Provider<InterstitialPromotionBannerContract.View> f5845$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
        private Provider<RestoreUrlContract.View> $r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0;
        private Provider<RestoreUrlPresenter> $r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8;
        private Provider<FeaturePresenter> A;
        private Provider<InitSessionDeepLink> ApiStatus$AvailableSince;
        private Provider<ReadDeepLinkProperties> AppCategory;
        private Provider<FirstTimePresenter> AppCompatEmojiTextHelper;
        private Provider<FamilyAccountRepository> ArrayTable$1;
        private Provider<HomeOmniRepository> ArrayTable$2;
        private Provider<ConnectionBarRepository> ArrayTable$3;
        private Provider<FeatureScanQR> B;
        private Provider<MerchantReviewFormRepository> BannerEntityDataFactory_Factory;
        private Provider<PromotionRepository> BaseSocialFeedContract$Presenter;
        private Provider<FeatureOauth> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<BindApp> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeaturePromoQuest> C;
        private Provider<NearbyShopsModelMapper> CYFMonitor$ChallengeActionCallback;
        private Provider<SplitBillHistoryToSplitBillModelMapper> CacheBuilderSpec$AccessDurationParser;
        private Provider<EventTrackerQueue> CheckPromoQuestFeature;
        private Provider<ConnectivityMonitorContract.Presenter> ConcurrentKt;
        private Provider<UpdateTwilioPushToken> ContentDeliveryCacheEntityDataFactory;
        private Provider<ServicesRepository> CreateOrderTopUpFamilyBalance;
        private Provider<SaveTwilioChallengeAttempt> CreateRemoteWorkerExtension;
        private Provider<FeatureServicesHandler> D;
        private Provider<ServicesPresenter> DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider;
        private Provider<HomeRevampContract.View> DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
        private Provider<ReadLinkPropertiesPresenter> DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider;
        private Provider<GetReferralConsult> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckShowReferralCodeFeature> DatabaseTableConfigUtil;
        private Provider<CardBindingRepository> DebugCoroutineInfoImpl;
        private Provider<FeatureSplitBillPay> E;
        private Provider<FirstTimeContract.View> EmergencyNotifActivity$getEmergencyNotifModule$1;
        private Provider<FinishFirstTime> F;
        private Provider<FeatureContract.View> FamilyDashboardPresenter_Factory;
        private Provider<ServiceCategoryMapper> FamilyManageAvailableServicesAdapter;
        private Provider<GetPaylaterChannel> FillAnimation;
        private Provider<FeedsConfigRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetQrisCpmSendmoneyConfig> FlowViewUtil$textChanges$1;
        private Provider<GetProfileRevampConfig> FlowViewUtil$textChanges$2;
        private Provider<OauthPresenter> FlowableConcatMapEagerPublisher;
        private Provider<GetWalletConfig> FlowableCreate$BufferAsyncEmitter;
        private Provider<LiteAccountRepository> FlowableKt$toIterable$1;
        private Provider<GetWhitelistedSubMerchantId> FlowableReduce$ReduceSubscriber;
        private Provider<UserRepository> FontsContractCompat$FontRequestCallback;
        private Provider<DeeplinkTrackerFactory> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GenerateLinkRepository> G;
        private Provider<CheckWhitelistedValidDomain> GetContactSyncConfig;
        private Provider<ReportDevice> GetTopUpUserConsult;
        private Provider<GenerateReferralDeepLink> H;
        private Provider<FirebaseAnalytics> I;
        private Provider<SaveInterstitialBannerResetTime> ISO8601Utils;
        private Provider<ValidateNativelyDecodedQr> ImageCaptureViewModel$getTipUploadPhoto$1;
        private Provider<ScanResultMapper> ImageWithDescriptionView$showImage$1;
        private Provider<IsKybNativeEnabled> InitSecurePreferenceAccount;
        private Provider<PayLaterContract.Presenter> InvestmentWalletAdapter;
        private Provider<GetAuthCode> J;
        private Provider<HomeInfoPresenter> JsonParseException;
        private Provider<GetCashierNativeConfig> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ShortenerRepository> KeyEvent$DispatcherState;
        private Provider<GetConfigRepeatBackgroundJobUseCase> L;
        private Provider<ScanQrPresenter> ListenerMethod;
        private Provider<GetCheckoutH5Event> M;
        private Provider<OauthContract.Presenter> MultiLanguageHttpClient;
        private Provider<AnalyticsTrackerFactory> MyBillsEntityDataFactory;
        private Provider<GetDecodeTciCoListConfig> N;
        private Provider<CheckoutH5EventContract.View> NavigationMenuPresenter$HeaderViewHolder;
        private Provider<SettingRepository> NearbyConstantsKt;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CheckoutH5EventPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<DeepLinkRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<DeepLinkPresenter> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ClearCachePayLaterLoanWhitelist> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<IsQrisPaymentEnabled> NewMerchantCategoryAdapter;
        private Provider<GetDeepLinkPayload> O;
        private Provider<H5EventRepository> OtpRegistrationPresenter$input$1;
        private Provider<GetServiceHighlighted> OtpRegistrationPresenter$input$2;
        private Provider<GetDefaultServiceWithCategory> P;
        private Provider<CashierEventHandler> PlaceComponentResult;
        private Provider<RestoreUrlContract.Presenter> PlaybackStateCompat$MediaKeyAction;
        private Provider<FirstTimeContract.Presenter> PrefetchDownloadStatus;
        private Provider<ContactRepository> PrepareContext;
        private Provider<IsFirstTime> PromoCategoryPresenter$1;
        private Provider<GetDecodedQrisTopUp> Q;
        private Provider<GetPayLaterCacheLoanWhitelist> QrExpiredActivity;
        private Provider<GetFavoriteServices> R;
        private Provider<IsNativeDecodeEnabled> ReferralMapper_Factory;
        private Provider<QrBarcodeRepository> RepaymentPlan;
        private Provider<GetUserConfig> RequestMoneyQrContract$View;
        private Provider<GetFeedConfig> S;
        private Provider<PaylaterRepository> SchedulerPoolFactory;
        private Provider<PromoQuestRepository> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<ProductPageManager> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<IsNeedToShowPlayStoreReview> SendMoneyScenario;
        private Provider<GetServicesByKey> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<ConnectivityMonitorContract.View> f5846x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<FirebasePerformanceMonitor> f5847x461046da;
        private Provider<SaveShowDialog> SplitReferralConfigEntityData_Factory;
        private Provider<OauthContract.View> SplitSavingConfigEntityData;
        private Provider<DeepLinkContract.View> StandardRowSortedTable$1;
        private Provider<FeatureCardBinding> SubSequence;
        private Provider<PushNotificationContract.View> SubmitReceiptResultModel$Creator;
        private Provider<GetDecodedQrBarcode> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetFavoriteServiceWithCacheFirst> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetEmptyUserInfo> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetIsCardBindingV2Enabled> T;
        private Provider<UserEducationRepository> TimeoutError;
        private Provider<QrisCrossBorderContract.Presenter> TrackerKey$GlobalSearchOpenProperties;
        private Provider<SaveInterstitialBannerGapTime> TwilioRepository;
        private Provider<GetProcessingTransaction> TypeProjectionImpl;
        private Provider<QrisCrossBorderContract.View> TypeToken$TypeSet;
        private Provider<GetSplitBillConfig> TypefaceCompatApi26Impl;
        private Provider<GetHomeInfo> U;
        private Provider<DeepLinkContract.Presenter> UnicastProcessor$UnicastQueueSubscription;
        private Provider<GetInterstitialPromotionBanner> V;
        private Provider<FeaturePushVerify> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeatureView> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<PermissionPromptRepository> View$OnClickListener;
        private Provider<UpdatePayLaterLoanCache> ViewInputOtpBinding;
        private Provider<GetGlobalSearchConfig> W;
        private Provider<GlobalSearchRepository> WithdrawSavedCardChannelView;
        private Provider<PayerModelListMapper> WrappedDrawableState;
        private Provider<GetIsFeatureConnectionBarWithSignalOn> X;
        private Provider<GetKycLevel> Y;
        private Provider<GetMerchantQrWhitelist> Z;

        /* renamed from: a */
        private Provider<GetNearbyConfig> f8120a;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> access$getCapacity$p;
        private Provider<SaveIsSyncPermission> access$getFeaturedBankListAdapter$p;
        private Provider<SetPayLaterLoanCache> access$getServiceItemDecorator$p;
        private Provider<MixpanelAnalytics> access$setShowcaseShowing$p;
        private Provider<ThirdPartyServicesMapper> access$showKycAmlEddDialog;
        private Provider<GetQrisCrossBorderCountries> access$throwIllegalArgumentType;
        private Provider<SaveQrisCurrentCountryCode> allowedTargets;
        private Provider<PostExecutionThread> applyTrimPathIfNeeded;
        private Provider<GetNickname> b;
        private Provider<GetPayerSplitBillDetail> c;
        private Provider<PushVerifyTracker> checkMarmotConfig;
        private Provider<HomeRevampContract.Presenter> checkParameterIsNotNull;
        private final HomeTabComponentImpl checkRegisteredUserAndSendOtp;
        private Provider<GetPromoCenterVersion> connectForeground;
        private Provider<SaveLastPlayStoreReviewShow> connectionSpecs;
        private Provider<Activity> containsObjectForKey;
        private Provider<HomeInfoContract.Presenter> createJavaMethod;
        private Provider<UpdateServiceHighlighted> createSecondaryAnimatorProvider;
        private Provider<GetPayLaterLoanStatusWhitelist> d;
        private Provider<PushNotificationRepository> doCommonLog;
        private Provider<GetPhoneNumber> e;
        private Provider<OauthView> encodingStream;
        private Provider<GetPreventScreenshotConfig> f;
        private Provider<GetMissionDetail> flip;
        private Provider<QrisCrossBorderPresenter> flow;
        private Provider<RecentRecipientRepository> fromContextOrNull;
        private Provider<GetPaylaterRotationDelayTime> g;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<DynamicUrlWrapper> getCallingPid;
        private Provider<GlobalNetworkRepository> getCardNumberOCR;
        private Provider<HomeInfoRepository> getContainerAuth;
        private Provider<HomeInfoMapper> getDefaultSenderId;
        private Provider<CheckInterstitialBannerFeature> getErrorConfigVersion;
        private Provider<PlayStoreReviewContract.View> getExceptionOrNull;
        private Provider<MyReferralConsultRepository> getFontAssetManager;
        private Provider<ScanQrContract.View> getGnBenefitEntityDanaProtection;
        private Provider<HomeTrackerImpl> getIndexName;
        private Provider<GetAddingNameWhitelistedMerchantId> getNameOrBuilderList;
        private Provider<SaveQrisOriginCountryCode> getNrCsiRsrp;
        private Provider<ScanQrView> getNrCsiRsrq;
        private Provider<FeatureSettingMore> getOnBoardingScenario;
        private Provider<PushNotificationContract.Presenter> getOpPackageName;
        private Provider<PlayStoreReviewContract.Presenter> getPhoneMask;
        private Provider<PlayStoreReviewPresenter> getRawPath;
        private Provider<KybRepository> getReadyFragment;
        private Provider<InterstitialPromotionBannerContract.Presenter> getRecommendationData;
        private Provider<RestoreUrlView> getSavingConfigPresenter;
        private Provider<ServicesContract.View> getStackFromEnd;
        private Provider<FeatureConfigRepository> getSupportButtonTintMode;
        private Provider<PayLaterPresenter> getTextEndPadding;
        private Provider<RestoreUrl> getTypeMappings;
        private Provider<FeatureSplitBill> getValueOfTouchPositionAbsolute;

        /* renamed from: getWalletV3RecommendationConfig$lambda-193 */
        private Provider<PushNotificationPresenter> f5848getWalletV3RecommendationConfig$lambda193;
        private Provider<ReadInterstitialPromotionBanner> glVertexAttrib1fv;
        private Provider<GetQrisCountryCodeByLocation> h;
        private Provider<GetQrBindingConfig> i;
        private Provider<SendRiskEventWithParams> indexOfAny;
        private Provider<GetUserLoanInfo> initAnimators;
        private Provider<CheckPushNotifDiagnosticFeature> initRecordTimeStamp;
        private Provider<MerchantInfoRepository> insertActivities;
        private Provider<WalletConfigRepository> isAllowRetry;
        private Provider<GetFavoriteServiceRemote> isAuth;
        private Provider<GetIsSyncPermission> isAuto;
        private Provider<PlayStoreReviewRepository> isInfoWindowShown;
        private Provider<DanaCustomH5> isLayoutRequested;
        private Provider<MixpanelDeeplinkTracker> isRegionMiniProgram;
        private Provider<QrisCrossBorderRepository> isTmpDetached;
        private Provider<GetQrisCrossBorderConfig> j;
        private Provider<GetQrisCrossBorderContent> k;
        private Provider<GetQrisCurrentCountryCode> l;
        private Provider<CheckLocationPermissionPromptFeature> lookAheadTest;
        private Provider<GetQrisOriginCountryCode> m;
        private Provider<CheckDeepLinkActionVisibility> moveToNextValue;
        private Provider<StartupConfigEntityData> murmurHash64WithSeed;
        private Provider<GetRequestMoneyInfoFeature> n;
        private Provider<ConnectivityMonitorPresenter> newProxyInstance;

        /* renamed from: o */
        private Provider<GetReviewableMerchantForm> f8121o;
        private Provider<HomeDataModelMapper> onDecodeSuccess;
        private Provider<ThreadExecutor> onGetActiveNotifications;
        private Provider<SaveShowToolTip> onLayoutDirectionChanged;
        private Provider<ScanQrContract.Presenter> onPolygonsChanged;
        private Provider<CheckoutH5EventContract.Presenter> onTooManyRedirects;
        private Provider<FeatureContract.Presenter> outerType;
        private Provider<GetRawServices> p;
        private Provider<GetServicesByName> q;
        private Provider<GetSettingByKey> r;
        private Provider<FeatureFamilyAccount> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<InterstitialPromotionBannerPresenter> f5849reduceIndexedz1zDJgo;
        private Provider<RemoveDeepLinkPayload> removeFloat;
        private Provider<IsNeedToShowToolTip> retainOrRemoveAllInternal;
        private Provider<MyReferralConsultMapper> rotateTo;
        private Provider<SaveNumberOfLocationPermissionShownData> roundToPowerOfTwo;
        private Provider<GetService> s;
        private Provider<UserConsentRepository> saveNickname;
        private Provider<CheckConsultFamilyAccount> scheduleImpl;
        private Provider<HomeRevampPresenter> secondaryHash;
        private Provider<SavePaylaterRotationDelayTime> setAkuEntranceOpen;
        private Provider<HomeInfoContract.View> setIndex$kotlin_stdlib;
        private Provider<GetUserInfoWithKyc> setNetAuthId;
        private Provider<SetPaylaterChannel> setRibbonLineTopText;
        private Provider<ReadLinkPropertiesContract.Presenter> setValuePrefixBytes;
        private Provider<GetMerchantReviewSummary> shouldRecycleViewType;
        private Provider<PayLaterContract.View> storeUserConfig;
        private Provider<GetServicesWithCategory> t;
        private Provider<TwilioSdkRepository> targetValue;
        private Provider<GetTransactionHistoryConfig> u;
        private Provider<OauthRepository> useDaemonThreadFactory;
        private Provider<GetSyncPermissionConfigUseCase> v;
        private Provider<GetUserStatusInfo> verifyNotNull;
        private Provider<GetUpdateAvailability> w;
        private Provider<DeviceInformationProvider> whenAvailable;
        private Provider<GetSurveyInfo> x;
        private Provider<GetUserId> y;
        private Provider<GetUpdatedHomeData> z;

        public /* synthetic */ HomeTabComponentImpl(HomeRevampModule homeRevampModule, FirstTimeModule firstTimeModule, HomeInfoModule homeInfoModule, InterstitialPromotionBannerModule interstitialPromotionBannerModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PushNotificationModule pushNotificationModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, QrisCrossBorderModule qrisCrossBorderModule, ConnectivityMonitorModule connectivityMonitorModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent, byte b) {
            this(homeRevampModule, firstTimeModule, homeInfoModule, interstitialPromotionBannerModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, pushNotificationModule, playStoreReviewModules, checkoutH5EventModule, qrisCrossBorderModule, connectivityMonitorModule, payLaterModule, applicationComponent);
        }

        private HomeTabComponentImpl(HomeRevampModule homeRevampModule, FirstTimeModule firstTimeModule, HomeInfoModule homeInfoModule, InterstitialPromotionBannerModule interstitialPromotionBannerModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PushNotificationModule pushNotificationModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, QrisCrossBorderModule qrisCrossBorderModule, ConnectivityMonitorModule connectivityMonitorModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullstoryDeeplinkTracker_Factory fullstoryDeeplinkTracker_Factory;
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.checkRegisteredUserAndSendOtp = this;
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = featureConfigRepositoryProvider;
            GetCashierNativeConfig_Factory create = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.K = create;
            this.PlaceComponentResult = CashierEventHandler_Factory.BuiltInFictitiousFunctionClassFactory(create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.containsObjectForKey = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.getNrCsiRsrq = authRequestContext2;
            this.getGnBenefitEntityDanaProtection = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.RepaymentPlan = qrBarcodeRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.onGetActiveNotifications = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.applyTrimPathIfNeeded = postExecutionThreadProvider;
            this.Q = GetDecodedQrisTopUp_Factory.create(this.onGetActiveNotifications, postExecutionThreadProvider, this.RepaymentPlan);
            this.ImageWithDescriptionView$showImage$1 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.whenAvailable = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.FontsContractCompat$FontRequestCallback = userRepositoryProvider;
            this.verifyNotNull = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.ReferralMapper_Factory = IsNativeDecodeEnabled_Factory.create(this.getSupportButtonTintMode);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.getSupportButtonTintMode);
            this.N = create2;
            this.ImageCaptureViewModel$getTipUploadPhoto$1 = ValidateNativelyDecodedQr_Factory.create(create2);
            this.Z = GetMerchantQrWhitelist_Factory.create(this.RepaymentPlan);
            this.i = GetQrBindingConfig_Factory.create(this.getSupportButtonTintMode);
            this.access$getCapacity$p = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.getSupportButtonTintMode);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.SchedulerPoolFactory = providePaylaterRepositoryProvider;
            this.initAnimators = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.TimeoutError = userEducationRepositoryProvider;
            this.FlowViewUtil$textChanges$1 = GetQrisCpmSendmoneyConfig_Factory.create(this.getSupportButtonTintMode, userEducationRepositoryProvider);
            this.SplitReferralConfigEntityData_Factory = SaveShowDialog_Factory.create(this.TimeoutError);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.getGnBenefitEntityDanaProtection, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.Q, this.ImageWithDescriptionView$showImage$1, this.whenAvailable, this.verifyNotNull, this.K, GetNativelyDecodedQr_Factory.create(), this.ReferralMapper_Factory, this.ImageCaptureViewModel$getTipUploadPhoto$1, this.Z, this.i, this.access$getCapacity$p, this.initAnimators, this.FlowViewUtil$textChanges$1, this.SplitReferralConfigEntityData_Factory));
            this.ListenerMethod = authRequestContext3;
            this.onPolygonsChanged = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.getSavingConfigPresenter = authRequestContext4;
            this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.KeyEvent$DispatcherState = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, shortenerRepositoryProvider);
            this.getTypeMappings = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0, create3));
            this.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 = authRequestContext5;
            this.PlaybackStateCompat$MediaKeyAction = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.getFontAssetManager = myReferralConsultRepositoryProvider;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = GetReferralConsult_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, myReferralConsultRepositoryProvider);
            this.DatabaseTableConfigUtil = CheckShowReferralCodeFeature_Factory.create(this.getSupportButtonTintMode);
            this.rotateTo = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.G = generateLinkRepositoryProvider;
            this.H = GenerateReferralDeepLink_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.NearbyConstantsKt = settingRepositoryProvider;
            this.r = GetSettingByKey_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = productPageManagerProvider;
            this.getOnBoardingScenario = FeatureSettingMore_Factory.PlaceComponentResult(this.r, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.f5844$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0 = splitBillRepositoryProvider;
            this.c = GetPayerSplitBillDetail_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, splitBillRepositoryProvider);
            this.WrappedDrawableState = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.WrappedDrawableState);
            this.CacheBuilderSpec$AccessDurationParser = PlaceComponentResult;
            this.E = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.c, PlaceComponentResult);
            this.TypefaceCompatApi26Impl = GetSplitBillConfig_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getSupportButtonTintMode);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getSupportButtonTintMode);
            this.n = create4;
            Provider<GetSplitBillConfig> provider = this.TypefaceCompatApi26Impl;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getValueOfTouchPositionAbsolute = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.flip = create5;
            this.C = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.B = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.isRegionMiniProgram = MyBillsEntityDataFactory;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = provideFamilyAccountRepositoryProvider;
            this.scheduleImpl = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.getCallingPid = dynamicUrlWrapperProvider;
            this.readMicros = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.DebugCoroutineInfoImpl = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.T = BuiltInFictitiousFunctionClassFactory;
            this.SubSequence = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.isRegionMiniProgram));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.DatabaseTableConfigUtil, this.rotateTo, this.H, this.getOnBoardingScenario, this.E, this.getValueOfTouchPositionAbsolute, this.C, this.B, this.isLayoutRequested, FeatureHome_Factory.MyBillsEntityDataFactory(), this.BottomSheetCardBindingView$watcherCardNumberView$1, FeatureKyb_Factory.getAuthRequestContext(), this.readMicros, this.SubSequence, this.initAnimators, FeatureMyBills_Factory.PlaceComponentResult(), this.VerifyPinStateManager$executeRiskChallenge$2$1));
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = authRequestContext6;
            this.FamilyDashboardPresenter_Factory = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.CreateOrderTopUpFamilyBalance = servicesRepositoryProvider;
            this.SizeSelectors$OrSelector = GetServicesByKey_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.FamilyManageAvailableServicesAdapter = authRequestContext7;
            this.access$showKycAmlEddDialog = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.useDaemonThreadFactory = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.saveNickname = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.useDaemonThreadFactory, create6);
            this.J = create7;
            this.D = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.FamilyDashboardPresenter_Factory, this.SizeSelectors$OrSelector, this.access$showKycAmlEddDialog, create7, this.whenAvailable));
            this.moveToNextValue = CheckDeepLinkActionVisibility_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getSupportButtonTintMode);
            this.GetContactSyncConfig = CheckWhitelistedValidDomain_Factory.create(this.getSupportButtonTintMode);
            this.f8120a = GetNearbyConfig_Factory.create(this.getSupportButtonTintMode);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = provideFeedsConfigRepositoryProvider;
            this.S = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.connectForeground = GetPromoCenterVersion_Factory.create(this.getSupportButtonTintMode);
            this.w = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckMyBillsVersionConfig_Factory.create(this.getSupportButtonTintMode);
            this.checkMarmotConfig = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.s = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.FamilyDashboardPresenter_Factory, this.D, this.moveToNextValue, this.GetContactSyncConfig, this.f8120a, this.S, this.connectForeground, this.w, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.checkMarmotConfig, create8));
            this.A = authRequestContext8;
            this.outerType = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.encodingStream = authRequestContext9;
            this.SplitSavingConfigEntityData = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.Y = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.setNetAuthId = GetUserInfoWithKyc_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.FontsContractCompat$FontRequestCallback);
            this.b = GetNickname_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getAuthRequestContext);
            this.FlowableReduce$ReduceSubscriber = GetWhitelistedSubMerchantId_Factory.create(this.getSupportButtonTintMode);
            this.getNameOrBuilderList = GetAddingNameWhitelistedMerchantId_Factory.create(this.getSupportButtonTintMode);
            Provider<OauthContract.View> provider2 = this.SplitSavingConfigEntityData;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.Y, this.setNetAuthId, this.b, this.FlowableReduce$ReduceSubscriber, this.getNameOrBuilderList);
            this.FlowableConcatMapEagerPublisher = KClassImpl$Data$declaredNonStaticMembers$2;
            this.MultiLanguageHttpClient = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.getStackFromEnd = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.retainOrRemoveAllInternal = IsNeedToShowToolTip_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.TimeoutError);
            this.onLayoutDirectionChanged = SaveShowToolTip_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.TimeoutError);
            this.t = GetServicesWithCategory_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.P = GetDefaultServiceWithCategory_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.isAuth = GetFavoriteServiceRemote_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.q = GetServicesByName_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.CreateOrderTopUpFamilyBalance);
            this.R = GetFavoriteServices_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.CreateOrderTopUpFamilyBalance);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckFavoriteServicesFeature_Factory.create(this.getSupportButtonTintMode);
            this.p = GetRawServices_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetFavoriteServiceWithCacheFirst_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.OtpRegistrationPresenter$input$2 = GetServiceHighlighted_Factory.create(this.CreateOrderTopUpFamilyBalance);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.CreateOrderTopUpFamilyBalance);
            this.createSecondaryAnimatorProvider = create9;
            this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.getStackFromEnd, this.J, this.access$showKycAmlEddDialog, this.retainOrRemoveAllInternal, this.onLayoutDirectionChanged, this.t, this.P, this.isAuth, this.q, this.SizeSelectors$OrSelector, this.R, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.p, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.OtpRegistrationPresenter$input$2, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.onPolygonsChanged, this.PlaybackStateCompat$MediaKeyAction, this.outerType, this.MultiLanguageHttpClient, this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider, applicationProvider, this.initAnimators));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext10;
            this.StandardRowSortedTable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = deepLinkRepositoryProvider;
            this.ApiStatus$AvailableSince = InitSessionDeepLink_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, deepLinkRepositoryProvider);
            this.O = GetDeepLinkPayload_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = liteAccountRepositoryProvider;
            this.e = GetPhoneNumber_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, liteAccountRepositoryProvider);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.removeFloat = RemoveDeepLinkPayload_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Provider<MixpanelDeeplinkTracker> provider3 = this.isRegionMiniProgram;
            fullstoryDeeplinkTracker_Factory = FullstoryDeeplinkTracker_Factory.InstanceHolder.getAuthRequestContext;
            DeeplinkTrackerFactory_Factory authRequestContext11 = DeeplinkTrackerFactory_Factory.getAuthRequestContext(provider3, fullstoryDeeplinkTracker_Factory);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext11;
            Provider<DeepLinkPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.StandardRowSortedTable$1, this.ApiStatus$AvailableSince, this.O, this.e, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.removeFloat, authRequestContext11));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext12;
            this.UnicastProcessor$UnicastQueueSubscription = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvidePresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
            this.EmergencyNotifActivity$getEmergencyNotifModule$1 = DoubleCheck.getAuthRequestContext(FirstTimeModule_ProvideViewFactory.getAuthRequestContext(firstTimeModule));
            this.PromoCategoryPresenter$1 = IsFirstTime_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getAuthRequestContext);
            FinishFirstTime_Factory create10 = FinishFirstTime_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getAuthRequestContext);
            this.F = create10;
            Provider<FirstTimePresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(FirstTimePresenter_Factory.MyBillsEntityDataFactory(this.EmergencyNotifActivity$getEmergencyNotifModule$1, this.PromoCategoryPresenter$1, create10));
            this.AppCompatEmojiTextHelper = authRequestContext13;
            this.PrefetchDownloadStatus = DoubleCheck.getAuthRequestContext(FirstTimeModule_ProvidePresenterFactory.getAuthRequestContext(firstTimeModule, authRequestContext13));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = h5eventRepositoryProvider;
            this.M = GetCheckoutH5Event_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, h5eventRepositoryProvider);
            CheckoutH5EventModule_ProvideViewFactory PlaceComponentResult2 = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            this.NavigationMenuPresenter$HeaderViewHolder = PlaceComponentResult2;
            CheckoutH5EventPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = CheckoutH5EventPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.M, PlaceComponentResult2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = BuiltInFictitiousFunctionClassFactory2;
            this.onTooManyRedirects = CheckoutH5EventModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(checkoutH5EventModule, BuiltInFictitiousFunctionClassFactory2);
            this.setIndex$kotlin_stdlib = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(homeInfoModule));
            HomeRepositoryProvider homeRepositoryProvider = new HomeRepositoryProvider(applicationComponent);
            this.getContainerAuth = homeRepositoryProvider;
            this.U = GetHomeInfo_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, homeRepositoryProvider);
            this.getDefaultSenderId = HomeInfoMapper_Factory.PlaceComponentResult(BaseResponseMapper_Factory.MyBillsEntityDataFactory(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.access$showKycAmlEddDialog);
            this.z = GetUpdatedHomeData_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getContainerAuth);
            Provider<HomeInfoMapper> provider4 = this.getDefaultSenderId;
            PromotionMapper_Factory BuiltInFictitiousFunctionClassFactory3 = PromotionMapper_Factory.BuiltInFictitiousFunctionClassFactory();
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.onDecodeSuccess = HomeDataModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(provider4, BuiltInFictitiousFunctionClassFactory3, feedsModelMapper_Factory, HasNewModelMapper_Factory.MyBillsEntityDataFactory());
            this.BannerEntityDataFactory_Factory = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.insertActivities = merchantInfoRepositoryProvider;
            this.f8121o = GetReviewableMerchantForm_Factory.create(this.BannerEntityDataFactory_Factory, merchantInfoRepositoryProvider, this.getSupportButtonTintMode);
            MerchantSubcategoriesMapper_Factory authRequestContext14 = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.CYFMonitor$ChallengeActionCallback = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext14, shopOpenHourListMapper_Factory);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.fromContextOrNull = recentRecipientRepositoryProvider;
            this.RequestMoneyQrContract$View = GetUserConfig_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, recentRecipientRepositoryProvider);
            this.shouldRecycleViewType = GetMerchantReviewSummary_Factory.create(this.insertActivities);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.PrepareContext = contractRepositoryProvider;
            this.v = GetSyncPermissionConfigUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            this.isAuto = GetIsSyncPermission_Factory.PlaceComponentResult(this.PrepareContext);
            this.access$getFeaturedBankListAdapter$p = SaveIsSyncPermission_Factory.MyBillsEntityDataFactory(this.PrepareContext);
            this.L = GetConfigRepeatBackgroundJobUseCase_Factory.getAuthRequestContext(this.PrepareContext);
            this.setRibbonLineTopText = SetPaylaterChannel_Factory.create(this.SchedulerPoolFactory);
            this.murmurHash64WithSeed = new ProvideStartupConfigEntityDataProvider(applicationComponent);
            ProvideHomeOmniRepositoryProvider provideHomeOmniRepositoryProvider = new ProvideHomeOmniRepositoryProvider(applicationComponent);
            this.ArrayTable$2 = provideHomeOmniRepositoryProvider;
            this.x = GetSurveyInfo_Factory.create(provideHomeOmniRepositoryProvider);
            this.FillAnimation = GetPaylaterChannel_Factory.create(this.ArrayTable$2);
            this.TypeProjectionImpl = GetProcessingTransaction_Factory.create(this.ArrayTable$2);
            Provider<HomeInfoPresenter> authRequestContext15 = DoubleCheck.getAuthRequestContext(HomeInfoPresenter_Factory.getAuthRequestContext(this.setIndex$kotlin_stdlib, this.U, this.getDefaultSenderId, this.z, this.onDecodeSuccess, this.retainOrRemoveAllInternal, this.onLayoutDirectionChanged, this.f8121o, this.CYFMonitor$ChallengeActionCallback, this.RequestMoneyQrContract$View, this.shouldRecycleViewType, this.v, this.isAuto, this.access$getFeaturedBankListAdapter$p, this.L, MerchantAverageRatingMapper_Factory.PlaceComponentResult(), this.setRibbonLineTopText, this.murmurHash64WithSeed, this.x, this.FillAnimation, this.TypeProjectionImpl));
            this.JsonParseException = authRequestContext15;
            this.createJavaMethod = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(homeInfoModule, authRequestContext15));
            this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl = DoubleCheck.getAuthRequestContext(HomeRevampModule_ProvideViewFactory.PlaceComponentResult(homeRevampModule));
            ProvideGlobalSearchRepositoryProvider provideGlobalSearchRepositoryProvider = new ProvideGlobalSearchRepositoryProvider(applicationComponent);
            this.WithdrawSavedCardChannelView = provideGlobalSearchRepositoryProvider;
            this.W = GetGlobalSearchConfig_Factory.BuiltInFictitiousFunctionClassFactory(provideGlobalSearchRepositoryProvider);
            this.FlowViewUtil$textChanges$2 = GetProfileRevampConfig_Factory.create(this.getSupportButtonTintMode);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.getReadyFragment = kybRepositoryProvider;
            this.InitSecurePreferenceAccount = IsKybNativeEnabled_Factory.BuiltInFictitiousFunctionClassFactory(kybRepositoryProvider);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.isAllowRetry = provideWalletConfigRepositoryProvider;
            this.FlowableCreate$BufferAsyncEmitter = GetWalletConfig_Factory.create(provideWalletConfigRepositoryProvider);
            this.NewMerchantCategoryAdapter = IsQrisPaymentEnabled_Factory.getAuthRequestContext(this.getReadyFragment);
            ProvidePermissionPromptRepositoryProvider providePermissionPromptRepositoryProvider = new ProvidePermissionPromptRepositoryProvider(applicationComponent);
            this.View$OnClickListener = providePermissionPromptRepositoryProvider;
            this.lookAheadTest = CheckLocationPermissionPromptFeature_Factory.create(providePermissionPromptRepositoryProvider);
            this.roundToPowerOfTwo = SaveNumberOfLocationPermissionShownData_Factory.create(this.View$OnClickListener);
            this.u = GetTransactionHistoryConfig_Factory.create(this.getSupportButtonTintMode);
            GetPreventScreenshotConfig_Factory create11 = GetPreventScreenshotConfig_Factory.create(this.getSupportButtonTintMode);
            this.f = create11;
            HomeRevampPresenter_Factory BuiltInFictitiousFunctionClassFactory4 = HomeRevampPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl, this.W, this.FlowViewUtil$textChanges$2, this.InitSecurePreferenceAccount, this.FlowableCreate$BufferAsyncEmitter, this.NewMerchantCategoryAdapter, this.lookAheadTest, this.roundToPowerOfTwo, this.u, create11);
            this.secondaryHash = BuiltInFictitiousFunctionClassFactory4;
            this.checkParameterIsNotNull = DoubleCheck.getAuthRequestContext(HomeRevampModule_ProvidePresenterFactory.getAuthRequestContext(homeRevampModule, BuiltInFictitiousFunctionClassFactory4));
            this.f5845$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM = DoubleCheck.getAuthRequestContext(InterstitialPromotionBannerModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(interstitialPromotionBannerModule));
            PromotionRepositoryProvider promotionRepositoryProvider = new PromotionRepositoryProvider(applicationComponent);
            this.BaseSocialFeedContract$Presenter = promotionRepositoryProvider;
            this.V = GetInterstitialPromotionBanner_Factory.create(promotionRepositoryProvider);
            this.glVertexAttrib1fv = ReadInterstitialPromotionBanner_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.BaseSocialFeedContract$Presenter);
            this.TwilioRepository = SaveInterstitialBannerGapTime_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.BaseSocialFeedContract$Presenter);
            this.ISO8601Utils = SaveInterstitialBannerResetTime_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.BaseSocialFeedContract$Presenter);
            CheckInterstitialBannerFeature_Factory create12 = CheckInterstitialBannerFeature_Factory.create(this.getSupportButtonTintMode);
            this.getErrorConfigVersion = create12;
            Provider<InterstitialPromotionBannerPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(InterstitialPromotionBannerPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.f5845$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM, this.V, this.glVertexAttrib1fv, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.TwilioRepository, this.ISO8601Utils, create12));
            this.f5849reduceIndexedz1zDJgo = authRequestContext16;
            this.getRecommendationData = DoubleCheck.getAuthRequestContext(InterstitialPromotionBannerModule_ProvidePresenterFactory.PlaceComponentResult(interstitialPromotionBannerModule, authRequestContext16));
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.isInfoWindowShown = playStoreReviewRepositoryProvider;
            this.SendMoneyScenario = IsNeedToShowPlayStoreReview_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, playStoreReviewRepositoryProvider);
            this.connectionSpecs = SaveLastPlayStoreReviewShow_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.isInfoWindowShown);
            Provider<PlayStoreReviewContract.View> authRequestContext17 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.getExceptionOrNull = authRequestContext17;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory2 = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.SendMoneyScenario, this.connectionSpecs, authRequestContext17);
            this.getRawPath = MyBillsEntityDataFactory2;
            this.getPhoneMask = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory2));
            this.SubmitReceiptResultModel$Creator = DoubleCheck.getAuthRequestContext(PushNotificationModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(pushNotificationModule));
            this.initRecordTimeStamp = CheckPushNotifDiagnosticFeature_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.getSupportButtonTintMode);
            PushNotificationRepositoryProvider pushNotificationRepositoryProvider = new PushNotificationRepositoryProvider(applicationComponent);
            this.doCommonLog = pushNotificationRepositoryProvider;
            this.GetTopUpUserConsult = ReportDevice_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, pushNotificationRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = BindApp_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.doCommonLog);
            TwilioEntityRepositoryProvider twilioEntityRepositoryProvider = new TwilioEntityRepositoryProvider(applicationComponent);
            this.targetValue = twilioEntityRepositoryProvider;
            this.ContentDeliveryCacheEntityDataFactory = UpdateTwilioPushToken_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, twilioEntityRepositoryProvider);
            SaveTwilioChallengeAttempt_Factory create13 = SaveTwilioChallengeAttempt_Factory.create(this.targetValue);
            this.CreateRemoteWorkerExtension = create13;
            Provider<PushNotificationPresenter> authRequestContext18 = DoubleCheck.getAuthRequestContext(PushNotificationPresenter_Factory.MyBillsEntityDataFactory(this.SubmitReceiptResultModel$Creator, this.initRecordTimeStamp, this.GetTopUpUserConsult, this.BuiltInFictitiousFunctionClassFactory, this.ContentDeliveryCacheEntityDataFactory, create13));
            this.f5848getWalletV3RecommendationConfig$lambda193 = authRequestContext18;
            this.getOpPackageName = DoubleCheck.getAuthRequestContext(PushNotificationModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(pushNotificationModule, authRequestContext18));
            this.TypeToken$TypeSet = QrisCrossBorderModule_ProvideView$app_productionReleaseFactory.getAuthRequestContext(qrisCrossBorderModule);
            this.j = GetQrisCrossBorderConfig_Factory.create(this.getSupportButtonTintMode);
            this.access$throwIllegalArgumentType = GetQrisCrossBorderCountries_Factory.create(this.getSupportButtonTintMode);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.getCardNumberOCR = globalNetworkRepositoryProvider;
            this.h = GetQrisCountryCodeByLocation_Factory.create(globalNetworkRepositoryProvider);
            ProvideQrisCrossBorderRepositoryProvider provideQrisCrossBorderRepositoryProvider = new ProvideQrisCrossBorderRepositoryProvider(applicationComponent);
            this.isTmpDetached = provideQrisCrossBorderRepositoryProvider;
            this.l = GetQrisCurrentCountryCode_Factory.create(provideQrisCrossBorderRepositoryProvider);
            this.m = GetQrisOriginCountryCode_Factory.create(this.isTmpDetached);
            this.getNrCsiRsrp = SaveQrisOriginCountryCode_Factory.create(this.isTmpDetached);
            this.allowedTargets = SaveQrisCurrentCountryCode_Factory.create(this.isTmpDetached);
            this.k = GetQrisCrossBorderContent_Factory.create(this.getSupportButtonTintMode);
            SendRiskEventWithParams_Factory create14 = SendRiskEventWithParams_Factory.create(this.getCardNumberOCR);
            this.indexOfAny = create14;
            QrisCrossBorderPresenter_Factory PlaceComponentResult3 = QrisCrossBorderPresenter_Factory.PlaceComponentResult(this.TypeToken$TypeSet, this.j, this.access$throwIllegalArgumentType, this.h, this.l, this.m, this.getNrCsiRsrp, this.allowedTargets, this.k, create14);
            this.flow = PlaceComponentResult3;
            this.TrackerKey$GlobalSearchOpenProperties = QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(qrisCrossBorderModule, PlaceComponentResult3);
            this.AppCategory = ReadDeepLinkProperties_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded);
            GetUserId_Factory create15 = GetUserId_Factory.create(this.onGetActiveNotifications, this.applyTrimPathIfNeeded, this.FlowableKt$toIterable$1);
            this.y = create15;
            Provider<ReadLinkPropertiesPresenter> authRequestContext19 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.StandardRowSortedTable$1, this.AppCategory, this.NetworkUserEntityData$$ExternalSyntheticLambda4, create15, this.isRegionMiniProgram));
            this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider = authRequestContext19;
            this.setValuePrefixBytes = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext19));
            this.f5846x461046d9 = DoubleCheck.getAuthRequestContext(ConnectivityMonitorModule_ProvideConnectivityMonitorViewFactory.getAuthRequestContext(connectivityMonitorModule));
            ProvideConnectionBarRepositoryProvider provideConnectionBarRepositoryProvider = new ProvideConnectionBarRepositoryProvider(applicationComponent);
            this.ArrayTable$3 = provideConnectionBarRepositoryProvider;
            GetIsFeatureConnectionBarWithSignalOn_Factory create16 = GetIsFeatureConnectionBarWithSignalOn_Factory.create(provideConnectionBarRepositoryProvider);
            this.X = create16;
            ConnectivityMonitorPresenter_Factory MyBillsEntityDataFactory3 = ConnectivityMonitorPresenter_Factory.MyBillsEntityDataFactory(this.f5846x461046d9, create16);
            this.newProxyInstance = MyBillsEntityDataFactory3;
            this.ConcurrentKt = DoubleCheck.getAuthRequestContext(ConnectivityMonitorModule_ProvideConnectivityMonitorPresenterFactory.MyBillsEntityDataFactory(connectivityMonitorModule, MyBillsEntityDataFactory3));
            this.storeUserConfig = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ClearCachePayLaterLoanWhitelist_Factory.create(this.SchedulerPoolFactory, this.CreateOrderTopUpFamilyBalance);
            this.QrExpiredActivity = GetPayLaterCacheLoanWhitelist_Factory.create(this.SchedulerPoolFactory);
            this.setAkuEntranceOpen = SavePaylaterRotationDelayTime_Factory.create(this.SchedulerPoolFactory);
            this.g = GetPaylaterRotationDelayTime_Factory.create(this.SchedulerPoolFactory);
            this.d = GetPayLaterLoanStatusWhitelist_Factory.create(this.SchedulerPoolFactory);
            this.ViewInputOtpBinding = UpdatePayLaterLoanCache_Factory.create(this.SchedulerPoolFactory, this.CreateOrderTopUpFamilyBalance);
            SetPayLaterLoanCache_Factory create17 = SetPayLaterLoanCache_Factory.create(this.SchedulerPoolFactory, this.CreateOrderTopUpFamilyBalance);
            this.access$getServiceItemDecorator$p = create17;
            Provider<PayLaterPresenter> authRequestContext20 = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.storeUserConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.QrExpiredActivity, this.initAnimators, this.setAkuEntranceOpen, this.g, this.d, this.ViewInputOtpBinding, create17));
            this.getTextEndPadding = authRequestContext20;
            this.InvestmentWalletAdapter = PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule, authRequestContext20);
            this.f5847x461046da = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.CheckPromoQuestFeature = provideEventTrackerQueueProvider;
            this.I = FirebaseAnalytics_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.f5847x461046da, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$22 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.CheckPromoQuestFeature);
            this.access$setShowcaseShowing$p = KClassImpl$Data$declaredNonStaticMembers$22;
            Provider<FirebaseAnalytics> provider5 = this.I;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult4 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider5, KClassImpl$Data$declaredNonStaticMembers$22, fullStoryAnalytics_Factory);
            this.MyBillsEntityDataFactory = PlaceComponentResult4;
            this.getIndexName = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent PlaceComponentResult;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SendMoneyScenario());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent getAuthRequestContext;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.setNetAuthId());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isInfoWindowShown());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent getAuthRequestContext;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.getAuthRequestContext.shouldRecycleViewType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ConcurrentKt());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent PlaceComponentResult;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.QrExpiredActivity());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent getAuthRequestContext;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent PlaceComponentResult;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$throwIllegalArgumentType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent PlaceComponentResult;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class HomeRepositoryProvider implements Provider<HomeInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            HomeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeInfoRepository get() {
                return (HomeInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideMerchantReviewRepositoryProvider implements Provider<MerchantReviewFormRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideMerchantReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantReviewFormRepository get() {
                return (MerchantReviewFormRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideStartupConfigEntityDataProvider implements Provider<StartupConfigEntityData> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideStartupConfigEntityDataProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ StartupConfigEntityData get() {
                return (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.PlaceComponentResult.onDecodeSuccess());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeOmniRepositoryProvider implements Provider<HomeOmniRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideHomeOmniRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeOmniRepository get() {
                return (HomeOmniRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.t());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideGlobalSearchRepositoryProvider implements Provider<GlobalSearchRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideGlobalSearchRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSearchRepository get() {
                return (GlobalSearchRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.o());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideWalletConfigRepositoryProvider implements Provider<WalletConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideWalletConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ WalletConfigRepository get() {
                return (WalletConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getIndexName());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvidePermissionPromptRepositoryProvider implements Provider<PermissionPromptRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePermissionPromptRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PermissionPromptRepository get() {
                return (PermissionPromptRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.y());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromotionRepositoryProvider implements Provider<PromotionRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PromotionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromotionRepository get() {
                return (PromotionRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.Z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PushNotificationRepositoryProvider implements Provider<PushNotificationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PushNotificationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushNotificationRepository get() {
                return (PushNotificationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.retainOrRemoveAllInternal());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TwilioEntityRepositoryProvider implements Provider<TwilioSdkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            TwilioEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioSdkRepository get() {
                return (TwilioSdkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ArrayTable$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideQrisCrossBorderRepositoryProvider implements Provider<QrisCrossBorderRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideQrisCrossBorderRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrisCrossBorderRepository get() {
                return (QrisCrossBorderRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getCardNumberOCR());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideConnectionBarRepositoryProvider implements Provider<ConnectionBarRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideConnectionBarRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ConnectionBarRepository get() {
                return (ConnectionBarRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.OtpRegistrationPresenter$input$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j());
            }
        }

        @Override // id.dana.di.component.HomeTabComponent
        public final void PlaceComponentResult(HomeTabFragment homeTabFragment) {
            HomeTabFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            HomeTabFragment_MembersInjector.MyBillsEntityDataFactory(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.UnicastProcessor$UnicastQueueSubscription));
            HomeTabFragment_MembersInjector.getAuthRequestContext(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid));
            HomeTabFragment_MembersInjector.PlaceComponentResult(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.outerType));
            homeTabFragment.firstTimePresenter = DoubleCheck.MyBillsEntityDataFactory(this.PrefetchDownloadStatus);
            HomeTabFragment_MembersInjector.scheduleImpl(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.onTooManyRedirects));
            HomeTabFragment_MembersInjector.lookAheadTest(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.createJavaMethod));
            HomeTabFragment_MembersInjector.moveToNextValue(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.checkParameterIsNotNull));
            HomeTabFragment_MembersInjector.DatabaseTableConfigUtil(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.getRecommendationData));
            homeTabFragment.playStoreReviewPresenter = DoubleCheck.MyBillsEntityDataFactory(this.getPhoneMask);
            HomeTabFragment_MembersInjector.initRecordTimeStamp(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.getOpPackageName));
            HomeTabFragment_MembersInjector.GetContactSyncConfig(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.TrackerKey$GlobalSearchOpenProperties));
            HomeTabFragment_MembersInjector.newProxyInstance(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.setValuePrefixBytes));
            homeTabFragment.restoreUrlPresenter = DoubleCheck.MyBillsEntityDataFactory(this.PlaybackStateCompat$MediaKeyAction);
            homeTabFragment.scanQrPresenter = DoubleCheck.MyBillsEntityDataFactory(this.onPolygonsChanged);
            homeTabFragment.connectivityMonitorPresenter = DoubleCheck.MyBillsEntityDataFactory(this.ConcurrentKt);
            homeTabFragment.payLaterPresenter = DoubleCheck.MyBillsEntityDataFactory(this.InvestmentWalletAdapter);
            HomeTabFragment_MembersInjector.getErrorConfigVersion(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.getIndexName));
            HomeTabFragment_MembersInjector.PrepareContext(homeTabFragment, DoubleCheck.MyBillsEntityDataFactory(this.murmurHash64WithSeed));
        }
    }
}
