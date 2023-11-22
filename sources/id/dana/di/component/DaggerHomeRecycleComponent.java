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
import id.dana.animation.HomeRecycleFragment;
import id.dana.animation.HomeRecycleFragment_MembersInjector;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.presenter.HomeTabPresenter;
import id.dana.animation.presenter.HomeTabPresenter_Factory;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.tracker.HomeTrackerImpl_Factory;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.CashierEventHandler_Factory;
import id.dana.cashier.tracker.PaylaterMixpanelTracker;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
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
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchPresenterFactory;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchViewFactory;
import id.dana.contract.globalsearch.GlobalSearchPresenter;
import id.dana.contract.globalsearch.GlobalSearchPresenter_Factory;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.homeinfo.HomeInfoModule_ProvidePresenterFactory;
import id.dana.contract.homeinfo.HomeInfoModule_ProvideViewFactory;
import id.dana.contract.homeinfo.HomeInfoPresenter;
import id.dana.contract.homeinfo.HomeInfoPresenter_Factory;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.contract.inbox.UnreadInboxModule;
import id.dana.contract.inbox.UnreadInboxModule_ProvidePresenterFactory;
import id.dana.contract.inbox.UnreadInboxModule_ProvideViewFactory;
import id.dana.contract.inbox.UnreadInboxPresenter;
import id.dana.contract.inbox.UnreadInboxPresenter_Factory;
import id.dana.contract.ott.OttVerifyContract;
import id.dana.contract.ott.OttVerifyModule;
import id.dana.contract.ott.OttVerifyModule_ProvidePresenterFactory;
import id.dana.contract.ott.OttVerifyModule_ProvideViewFactory;
import id.dana.contract.ott.OttVerifyPresenter;
import id.dana.contract.ott.OttVerifyPresenter_Factory;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payasset.QueryPayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.QueryPayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.QueryPayMethodPresenter;
import id.dana.contract.payasset.QueryPayMethodPresenter_Factory;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterModule_ProvideView$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterPresenter;
import id.dana.contract.paylater.PayLaterPresenter_Factory;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.contract.permission.PermissionStateModule;
import id.dana.contract.permission.PermissionStateModule_ProvidePresenterFactory;
import id.dana.contract.permission.PermissionStateModule_ProvideViewFactory;
import id.dana.contract.permission.PermissionStatePresenter;
import id.dana.contract.permission.PermissionStatePresenter_Factory;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.services.ServicesModule_ProvidePresenterFactory;
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
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.contract.user.GetBalanceModule_ProvidePresenterFactory;
import id.dana.contract.user.GetBalanceModule_ProvideViewFactory;
import id.dana.contract.user.GetBalancePresenter;
import id.dana.contract.user.GetBalancePresenter_Factory;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.contract.user.GetUserInfoModule_ProvidePresenterFactory;
import id.dana.contract.user.GetUserInfoModule_ProvideViewFactory;
import id.dana.contract.user.GetUserInfoPresenter;
import id.dana.contract.user.GetUserInfoPresenter_Factory;
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaCustomH5_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
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
import id.dana.di.modules.BiometricAnalyticModule;
import id.dana.di.modules.BiometricAnalyticModule_ProvidePassiveBioAnalyticTrackerFactory;
import id.dana.di.modules.GeofenceModule;
import id.dana.di.modules.GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory;
import id.dana.di.modules.GeofenceModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.GlobalNetworkModule_ProvidesPresenterFactory;
import id.dana.di.modules.GlobalNetworkModule_ProvidesViewFactory;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.HomeTabModules_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.HomeTabModules_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetAllBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility_Factory;
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
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility_Factory;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
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
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain_Factory;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime_Factory;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig_Factory;
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
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence_Factory;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.domain.geofence.interactor.GetListPoi;
import id.dana.domain.geofence.interactor.GetListPoi_Factory;
import id.dana.domain.geofence.interactor.PoiNotify;
import id.dana.domain.geofence.interactor.PoiNotify_Factory;
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
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.home.HomePassiveBioRepository;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked_Factory;
import id.dana.domain.home.interactor.SavePassiveBioTracked;
import id.dana.domain.home.interactor.SavePassiveBioTracked_Factory;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig_Factory;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetHomeInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig_Factory;
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
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig;
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig_Factory;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.CheckSession_Factory;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.GetIsSessionChecked;
import id.dana.domain.login.interactor.GetIsSessionChecked_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.login.interactor.SaveIsSessionChecked_Factory;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories_Factory;
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
import id.dana.domain.notificationcenter.interactor.HasNewInbox;
import id.dana.domain.notificationcenter.interactor.HasNewInbox_Factory;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId_Factory;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.interactor.GetQrBindingConfig_Factory;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.ott.interactor.GetOttVerify;
import id.dana.domain.ott.interactor.GetOttVerify_Factory;
import id.dana.domain.ott.repository.OttRepository;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard_Factory;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.interactor.QueryPayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
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
import id.dana.domain.permission.PermissionRepository;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission_Factory;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.GetSettingByKey_Factory;
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
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.interactor.InitOfflinePay;
import id.dana.domain.qrpay.interactor.InitOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized_Factory;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll_Factory;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature_Factory;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
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
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetBalance_Factory;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig_Factory;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.interactor.GetUserCohort;
import id.dana.domain.user.interactor.GetUserCohort_Factory;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.user.interactor.GetUserStatusInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
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
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword_Factory;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled_Factory;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState_Factory;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState_Factory;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl_Factory;
import id.dana.explore.domain.sku.interactor.GetSkuExplore;
import id.dana.explore.domain.sku.interactor.GetSkuExplore_Factory;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization_Factory;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeoFencePresenter_Factory;
import id.dana.geofence.GeofenceContract;
import id.dana.geofence.GeofenceManager;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter_Factory;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker_Factory;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
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
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper_Factory;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper_Factory;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.pay.PayCardInfoMapper_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
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
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase_Factory;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission_Factory;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase_Factory;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission_Factory;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.WalletH5ServicesImplementation_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerHomeRecycleComponent {
    private DaggerHomeRecycleComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public PayLaterModule DatabaseTableConfigUtil;
        public UnreadInboxModule FragmentBottomSheetPaymentSettingBinding;
        public OttVerifyModule GetContactSyncConfig;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public GetBalanceModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public LogoutModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public HomeTabModules NetworkUserEntityData$$ExternalSyntheticLambda2;
        public RestoreUrlModule NetworkUserEntityData$$ExternalSyntheticLambda7;
        public PermissionStateModule NetworkUserEntityData$$ExternalSyntheticLambda8;
        public BiometricAnalyticModule PlaceComponentResult;
        public ScanQrModule PrepareContext;
        public GeofenceModule getAuthRequestContext;
        public GetUserInfoModule getErrorConfigVersion;
        public OauthModule initRecordTimeStamp;
        public ServicesModule isLayoutRequested;
        public HomeInfoModule lookAheadTest;
        public GlobalNetworkModule moveToNextValue;
        public QueryPayMethodModule newProxyInstance;
        public GlobalSearchModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class HomeRecycleComponentImpl implements HomeRecycleComponent {

        /* renamed from: $r8$lambda$7jSe-jJ0etbd9VooMli6zMuqlA0 */
        private Provider<QueryPayMethodContract.Presenter> f5831$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0;
        private Provider<RecentRecipientRepository> $r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY;

        /* renamed from: $r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M */
        private Provider<OpenMerchantCashier> f5832$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
        private Provider<NotificationCenterRepository> $r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0;
        private Provider<FamilyAccountRepository> $r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8;
        private Provider<DeviceInformationProvider> A;
        private Provider<GetSearchByKeyword> ApiStatus$AvailableSince;
        private Provider<DanapolyClearRepository> AppCategory;
        private Provider<FeatureServicesHandler> AppCompatEmojiTextHelper;
        private Provider<HomeDataModelMapper> ArrayTable$1;
        private Provider<HomeInfoMapper> ArrayTable$2;
        private Provider<HasNewInbox> ArrayTable$3;
        private Provider<UserInfoMapper> AttributeView;
        private Provider<DeepLinkView> B;
        private Provider<HomeTabPresenter> BannerEntityDataFactory_Factory;
        private Provider<ReadLinkPropertiesPresenter> BarcodeUtil$$ExternalSyntheticLambda0;
        private Provider<SaveLocationPermissionSuggestionState> BarcodeUtil$$ExternalSyntheticLambda1;
        private Provider<GetWhitelistedSubMerchantId> BaseSocialFeedContract$Presenter;
        private Provider<DynamicUrlWrapper> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<SaveIsSessionChecked> BridgeActivity;
        private final BiometricAnalyticModule BuiltInFictitiousFunctionClassFactory;
        private Provider<FaceAuthPopUpConsultationRepository> C;
        private Provider<GetUpdatedHomeData> CYFMonitor$ChallengeActionCallback;
        private Provider<OauthContract.Presenter> CacheBuilderSpec$AccessDurationParser;
        private Provider<GlobalNetworkPresenter> CheckPromoQuestFeature;
        private Provider<UserPersonalizationRepository> Clause;
        private Provider<ScanQrView> Code128Reader;
        private Provider<H5EventRepository> ConcurrentKt;
        private Provider<ResetPinRepository> ContentDeliveryCacheEntityDataFactory;
        private Provider<ReadDeepLinkProperties> CreateCredentialCustomException;
        private Provider<PayLaterContract.Presenter> CreateOrderTopUpFamilyBalance;
        private Provider<LogoutContract.View> CreateRemoteWorkerExtension;
        private Provider<FeatureOauth> D;
        private Provider<HomeTabContract.Presenter> DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider;
        private Provider<OauthPresenter> DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
        private Provider<RestoreUrlContract.View> DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider;
        private Provider<OauthContract.View> DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider;
        private Provider<CredentialRepository> DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider;
        private Provider<GetMerchantReviewSummary> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckHomePassiveBioTracked> DatabaseTableConfigUtil;
        private Provider<HomeTrackerImpl> DebugCoroutineInfoImpl;
        private Provider<SavePaylaterRotationDelayTime> DeserializedCallableMemberDescriptor;
        private Provider<ScanResultMapper> DialogTncInformation_ViewBinding;
        private Provider<FeaturePresenter> E;
        private Provider<PayAssetRepository> EmergencyNotifActivity$getEmergencyNotifModule$1;
        private Provider<ServiceCategoryMapper> EventLoopImplBase$DelayedRunnableTask;
        private Provider<FeatureScanQR> F;
        private Provider<OttRepository> FamilyDashboardPresenter_Factory;
        private Provider<RestoreUrlContract.Presenter> FamilyManageAvailableServicesAdapter;
        private Provider<GetFavoriteServiceRemote> FillAnimation;
        private Provider<SetPayLaterLoanCache> FloatPoint;
        private Provider<HomeInfoRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetGlobalSearchConfig> FlowViewUtil$textChanges$1;
        private Provider<GetFeedConfig> FlowViewUtil$textChanges$2;
        private Provider<GetUserCohort> FlowableConcatMapEagerPublisher;
        private Provider<GetPopularSearch> FlowableCreate$BufferAsyncEmitter;
        private Provider<GetSkuExplore> FlowableKt$toIterable$1;
        private Provider<GetPopularSearchPlaceholder> FlowableReduce$ReduceSubscriber;
        private Provider<ReadLinkPropertiesContract.Presenter> FontsContractCompat$FontRequestCallback;
        private Provider<ClearKybData> FragmentBottomSheetPaymentSettingBinding;
        private Provider<FeaturePushVerify> G;
        private Provider<CheckSession> GetContactSyncConfig;
        private Provider<HomeTabContract.View> GetExpressPurchaseResponse$PriceEntity;
        private Provider<DeviceStatsPreferenceEntityData> GetTopUpUserConsult;
        private Provider<ValidateNativelyDecodedQr> GifDrawableTransformation;
        private Provider<ThirdPartyServicesMapper> GroupRecipientPermissionHelper;
        private Provider<FeatureSettingMore> H;
        private Provider<HomeInfoContract.View> HttpClientAttributesExtractorBuilder;
        private Provider<FeaturePromoQuest> I;
        private Provider<FirebasePerformanceMonitor> ISO8601Utils;
        private Provider<ProductInfoRepository> ImageCaptureViewModel$getTipUploadPhoto$1;
        private Provider<SplitFacade> ImageCaptureViewModel$getTipUploadPhoto$2;
        private Provider<LocationPermissionSubject> ImageWithDescriptionView$showImage$1;
        private Provider<GetServiceHighlighted> InitSecurePreferenceAccount;
        private Provider<IsFeatureGlobalSearchEnabled> InvestmentWalletAdapter;
        private Provider<ScheduleDeviceStatsReport> ItemSnapshotList;
        private Provider<FeatureSplitBillPay> J;
        private Provider<GetRecentSearch> JsonParseException;
        private Provider<FeatureSplitBill> K;
        private Provider<AnalyticsTrackerFactory> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetUserInfoContract.Presenter> KeyEvent$DispatcherState;
        private Provider<FileSystemStatsRepository> L;
        private Provider<SetBalanceVisibility> LinearSmoothScroller;
        private Provider<ScanQrContract.View> ListPopupWindow$Api29Impl;
        private Provider<MerchantReviewFormRepository> ListenerMethod;
        private Provider<FeatureView> M;
        private Provider<RestoreUrlPresenter> MapPageContract$Presenter;
        private Provider<LoginRepository> MultiLanguageHttpClient;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GenerateReferralDeepLink> N;
        private Provider<PermissionStatePresenter> NavigationMenuPresenter$HeaderViewHolder;
        private Provider<FeatureContract.Presenter> NearbyConstantsKt;
        private Provider<CheckDeniedLocationPermission> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckShouldSuggestLocationPermissionDialog> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ConsultForceDanaVizEnroll> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<ClearCacheFavoriteServices> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ClearFaceAuthSuggestionState> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ClearCachePayLaterLoanWhitelist> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<ClearAllDanapolyData> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetSplitBillConfig> NewMerchantCategoryAdapter;
        private Provider<FirebaseAnalytics> O;
        private Provider<UpdateServiceHighlighted> OcrImagePreprocessingConfigModel;
        private Provider<UserRepository> OrAudience;
        private Provider<GetPrepaidCheckoutUrl> OtpRegistrationPresenter$input$1;
        private Provider<GetMerchantSubcategories> OtpRegistrationPresenter$input$2;
        private Provider<ForceLogout> P;
        private Provider<SplitBillRepository> PaylaterRegistrationCooldownCache;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<IsOfflineF2FPay> PlaybackStateCompat$MediaKeyAction;
        private Provider<MixpanelAnalytics> PrefetchDownloadStatus;
        private Provider<ClearAllSyncEngineUseCase> PrepareContext;
        private Provider<GetServicesByKey> PromoCategoryPresenter$1;
        private Provider<SaveShowDialog> PromoExploreModule_ProvidesPresenterFactory;
        private Provider<FileSystemStorageEntity> Q;
        private Provider<GetDecodedQrBarcode> QrExpiredActivity;
        private Provider<GetUserInfoContract.View> QueryPayMethod;
        private Provider<GetAuthCode> R;
        private Provider<GetServicesWithCategory> ReferralMapper_Factory;
        private Provider<PromoQuestRepository> RepaymentPlan;
        private Provider<GetPhoneNumber> RequestMoneyQrContract$View;
        private Provider<GetBalanceContract.View> ResourceResponseInfo;
        private Provider<GetAddingNameWhitelistedMerchantId> S;
        private Provider<InitOfflinePay> SchedulerPoolFactory;
        private Provider<QueryPayMethodContract.View> SearchConditionEntityKt;
        private Provider<GetWalletOauth> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<GetUserStatusInfo> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<SaveIsSyncPermission> SeekBarStopChangeEvent;
        private Provider<GetServicesByName> SendMoneyScenario;
        private Provider<OttVerifyContract.View> ServiceStarter;
        private Provider<DeepLinkContract.View> SightCameraView$ICameraFrameListener;
        private Provider<GetMixpanelStorageConfig> SizeSelectors$OrSelector;
        private Provider<ThreadExecutor> SokalSneathDissimilarity;
        private Provider<QueryPayMethodPresenter> SourceParamUtil$DanaKagetClaimSource;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<GlobalSearchPresenter> f5833x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<HomeInfoPresenter> f5834x461046da;
        private Provider<HomeOmniRepository> SplitReferralConfigEntityData_Factory;
        private Provider<OttVerifyPresenter> SplitSavingConfigEntityData;
        private Provider<PayLaterPresenter> StandardRowSortedTable$1;
        private Provider<ContactRepository> SubSequence;
        private Provider<PermissionStateContract.View> SubmitReceiptRequest;
        private Provider<OauthView> SubmitReceiptResultModel$Creator;
        private Provider<GenerateLinkRepository> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetAllBalanceVisibility> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GeoFenceRepository> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<UserEducationRepository> SwitchFaceAuthContract;
        private Provider<GetBalanceVisibility> T;
        private Provider<UnreadInboxPresenter> TaskListBlock;
        private Provider<PushVerifyTracker> TimeoutError;
        private Provider<IsNativeDecodeEnabled> TrackerKey$GlobalSearchOpenProperties;
        private Provider<FeatureContract.View> TrustRiskLogin$Params;
        private Provider<GlobalSearchContract.View> TwilioRepository;
        private Provider<GetFavoriteServices> TypeProjectionImpl;
        private Provider<MixpanelGlobalNetworkTracker> TypeToken$TypeSet;
        private Provider<GetOttVerify> TypefaceCompatApi26Impl;
        private Provider<GetBalancePresenter> U;
        private Provider<LiteAccountRepository> UnicastProcessor$UnicastQueueSubscription;
        private Provider<GetBalance> V;
        private Provider<UnreadInboxContract.View> VerifyPasswordFacade;
        private Provider<DeepLinkPayloadModelMapper> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeatureConfigRepository> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<ScanQrPresenter> VerifyPushDerollRequest;
        private Provider<IsCScanBEnabled> View$OnClickListener;
        private Provider<OttVerifyContract.Presenter> ViewInputOtpBinding;
        private Provider<GetCashierNativeConfig> W;
        private Provider<ShortenerRepository> WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1;
        private final HomeRecycleComponentImpl WithdrawSavedCardChannelView;
        private Provider<GetUserInfoPresenter> WrappedDrawableState;
        private Provider<GetAutoCompleteByKeyword> X;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> Y;
        private Provider<GetCurrentPOICacheTime> Z;

        /* renamed from: a */
        private Provider<GetEmptyUserInfo> f8114a;
        private Provider<GetReviewableMerchantForm> access$getCapacity$p;
        private Provider<GeofenceManager> access$getFeaturedBankListAdapter$p;
        private Provider<GetBalanceContract.Presenter> access$getServiceItemDecorator$p;
        private Provider<SplitDeviceStatsConfigEntityData> access$loadDashboardData;
        private Provider<GetSingleBalance> access$setShowcaseShowing$p;
        private Provider<ScanQrContract.Presenter> access$showKycAmlEddDialog;
        private Provider<GetIsSessionChecked> access$throwIllegalArgumentType;
        private Provider<SetRetryIntervalGeoFence> addAutoLogActivity;
        private Provider<InvestmentRepository> allowedTargets;
        private Provider<GetUserLoanInfo> applyTrimPathIfNeeded;
        private Provider<GetDefaultServiceWithCategory> b;
        private Provider<QueryPayMethod> buildStats;
        private Provider<GetDecodeTciCoListConfig> c;
        private Provider<Logout> checkMarmotConfig;
        private Provider<MerchantCategoriesRepository> checkParameterIsNotNull;
        private Provider<GetResetAndChangePinNativeEntryConfig> checkRegisteredUserAndSendOtp;
        private Provider<GlobalNetworkContract.Presenter> clearMerchantList;
        private Provider<SettingRepository> clearStatesNotIn;
        private Provider<GetGnCScanBBlacklistedCountry> connectForeground;
        private Provider<GlobalSearchRepository> connectionSpecs;
        private Provider<GlobalNetworkRepository> containsObjectForKey;
        private Provider<LogoutPresenter> createJavaMethod;
        private Provider<UnreadInboxContract.Presenter> createSecondaryAnimatorProvider;
        private Provider<GetDecodedQrisTopUp> d;
        private Provider<PoiNotify> doCommonLog;
        private Provider<GetFeatureHoldLoginConfig> e;
        private Provider<GetUserInfo> encodingStream;
        private Provider<GetEnableAddNewCard> f;
        private Provider<GetConfigRepeatBackgroundJobUseCase> flip;
        private Provider<Activity> flow;
        private Provider<SetPaylaterChannel> forEach;
        private Provider<FeedInitRepository> fromContextOrNull;
        private Provider<GetFavoriteServiceWithCacheFirst> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<DanaSessionManager> getCallingPid;
        private Provider<GetPromoCenterVersion> getCardNumberOCR;
        private Provider<GetQueryUserDataConfig> getContainerAuth;
        private Provider<GetQrisCpmSendmoneyConfig> getDefaultSenderId;
        private Provider<ServicesRepository> getDirName;
        private Provider<CheckDeepLinkActionVisibility> getErrorConfigVersion;
        private Provider<IsNeedToShowToolTip> getExceptionOrNull;
        private Provider<GetUpdateAvailability> getFontAssetManager;
        private Provider<OauthRepository> getGnBenefitEntityDanaProtection;
        private Provider<GetRequestMoneyInfoFeature> getIndexName;
        private Provider<UserConsentRepository> getKybKaFilter;
        private Provider<QrBarcodeRepository> getLastClearRequest;
        private Provider<SetHintSwipeVisibilityState> getMessaging;
        private Provider<FileDirectorySizeReportScheduler> getNameOrBuilderList;
        private Provider<HomeWidgetClearable> getNrCsiRsrp;
        private Provider<CardBindingRepository> getNrCsiRsrq;
        private Provider<FeatureFamilyAccount> getOnBoardingScenario;
        private Provider<KybRepository> getOpPackageName;
        private Provider<IsAlipayConnectServiceFirstTime> getPhoneMask;
        private Provider<GetUserInfoWithKyc> getRawPath;
        private Provider<GetSettingByKey> getReadyFragment;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> getRecommendationData;
        private Provider<GlobalSearchContract.Presenter> getSavingConfigPresenter;
        private Provider<SaveAlipayConnectServiceFirstTime> getSharingAgreementIds;
        private Provider<PayerModelListMapper> getStackFromEnd;
        private Provider<Context> getSupportButtonTintMode;
        private Provider<GetUserInvestmentSummary> getTextEndPadding;
        private Provider<WalletH5ServicesImplementation> getThread;
        private Provider<EventTrackerQueue> getTypeMappings;
        private Provider<FeatureCardBinding> getValueOfTouchPositionAbsolute;

        /* renamed from: getWalletV3RecommendationConfig$lambda-193 */
        private Provider<PermissionRepository> f5835getWalletV3RecommendationConfig$lambda193;
        private Provider<DeviceStatsAnalyticsEntityData> glVertexAttrib1fv;
        private Provider<GetHintSwipeVisibilityState> h;
        private Provider<GetGeoFenceConfig> i;
        private Provider<PaylaterRepository> indexOfAny;
        private Provider<GetPaylaterChannel> initAnimators;
        private Provider<CheckShouldShowUserPersonalization> initRecordTimeStamp;
        private Provider<RestoreUrlView> initResult;
        private Provider<GetSurveyInfo> insertActivities;
        private Provider<ProductPageManager> isAllowRetry;
        private Provider<GeoFencePresenter> isAuth;
        private Provider<GetDanaHomeBalanceConfig> isAuto;
        private Provider<GetVoiceAssistantConfig> isInfoWindowShown;
        private Provider<CheckWhitelistedValidDomain> isLayoutRequested;
        private Provider<GetUserConfig> isRegionMiniProgram;
        private Provider<NearbyShopsModelMapper> isTmpDetached;
        private Provider<PayLaterContract.View> itemClicked$core;
        private Provider<GetIsCardBindingV2Enabled> j;
        private Provider<GetHomeSearchBarVisibility> k;
        private Provider<GetHomeInfo> l;
        private Provider<RestoreUrl> longitude;
        private Provider<CheckFavoriteServicesFeature> lookAheadTest;
        private Provider<GetIsSyncPermission> m;
        private Provider<CashierEventHandler> moveToNextValue;
        private Provider<MyReferralConsultMapper> murmurHash64WithSeed;
        private Provider<GetListPoi> n;
        private Provider<ClearAllFeedsUsecase> newProxyInstance;

        /* renamed from: o */
        private Provider<GetMerchantQrWhitelist> f8115o;
        private Provider<ServicesContract.View> onCubeAppPerfEvent;
        private Provider<GetQrBindingConfig> onDecodeSuccess;
        private Provider<PermissionStateContract.Presenter> onGetActiveNotifications;
        private Provider<LogoutContract.Presenter> onLayoutDirectionChanged;
        private Provider<SavePassiveBioTracked> onLoadComplete;
        private Provider<IsFirstTime> onPolygonsChanged;
        private Provider<MerchantInfoRepository> onTooManyRedirects;
        private Provider<IsOfflinePayInitialized> outerType;
        private Provider<GetKycLevel> p;
        private Provider<StartupConfigEntityData> parametersAsMap;
        private Provider<GetNearbyConfig> q;
        private Provider<GetMissionDetail> r;
        private Provider<DanaCustomH5> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<GetReferralConsult> f5836reduceIndexedz1zDJgo;
        private Provider<FeedsConfigRepository> removeFloat;
        private Provider<GlobalNetworkContract.View> resetSizeCounter;
        private Provider<GetService> retainOrRemoveAllInternal;
        private Provider<GetSyncPermissionConfigUseCase> rotateTo;
        private Provider<HomePassiveBioRepository> roundToPowerOfTwo;
        private Provider<GetOnlineMerchant> s;
        private Provider<RiskTracker> saveNickname;
        private Provider<CheckConsultFamilyAccount> scheduleImpl;
        private Provider<GetRawServices> secondaryHash;
        private Provider<HomeConfigRepository> setAkuEntranceOpen;
        private Provider<SaveShowToolTip> setBackgroundTime;
        private Provider<StopOfflinePay> setBackgroundTint;
        private Provider<SplitBillHistoryToSplitBillModelMapper> setDistrictAdcode;
        private Provider<PostExecutionThread> setIndex$kotlin_stdlib;
        private Provider<GeofenceContract.View> setMatchingBeaconTypeCode;
        private Provider<GetPayerSplitBillDetail> setNetAuthId;
        private Provider<SaveRecentSearch> setNewRibbon;
        private Provider<HomeInfoContract.Presenter> setRibbonLineTopText;
        private Provider<UpdatePayLaterLoanCache> setValue;
        private Provider<MixpanelDeeplinkTracker> setValuePrefixBytes;
        private Provider<GetCheckoutH5Event> shouldRecycleViewType;
        private Provider<MyReferralConsultRepository> storeUserConfig;
        private Provider<GetNickname> t;
        private Provider<ServicesContract.Presenter> targetValue;
        private Provider<ServicesPresenter> timer;
        private Provider<SetDeniedLocationPermission> times;
        private Provider<QrPayRepository> toFullstoryConfig;
        private Provider<GetPayLaterLoanStatusWhitelist> u;
        private Provider<GetUserId> useDaemonThreadFactory;
        private Provider<GetPayCardConfig> v;
        private Provider<GetProcessingTransaction> verifyNotNull;
        private Provider<GetPasswordLastModifiedWithConfigChecking> w;
        private Provider<DecodeGnQr> whenAvailable;
        private Provider<GetPayLaterCacheLoanWhitelist> x;
        private Provider<GetPayRequest> y;
        private Provider<GetPaylaterRotationDelayTime> z;

        public /* synthetic */ HomeRecycleComponentImpl(GetBalanceModule getBalanceModule, UnreadInboxModule unreadInboxModule, QueryPayMethodModule queryPayMethodModule, HomeInfoModule homeInfoModule, GeofenceModule geofenceModule, LogoutModule logoutModule, GlobalSearchModule globalSearchModule, GetUserInfoModule getUserInfoModule, OttVerifyModule ottVerifyModule, PermissionStateModule permissionStateModule, GlobalNetworkModule globalNetworkModule, PayLaterModule payLaterModule, HomeTabModules homeTabModules, BiometricAnalyticModule biometricAnalyticModule, ServicesModule servicesModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ApplicationComponent applicationComponent, byte b) {
            this(getBalanceModule, unreadInboxModule, queryPayMethodModule, homeInfoModule, geofenceModule, logoutModule, globalSearchModule, getUserInfoModule, ottVerifyModule, permissionStateModule, globalNetworkModule, payLaterModule, homeTabModules, biometricAnalyticModule, servicesModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, applicationComponent);
        }

        private HomeRecycleComponentImpl(GetBalanceModule getBalanceModule, UnreadInboxModule unreadInboxModule, QueryPayMethodModule queryPayMethodModule, HomeInfoModule homeInfoModule, GeofenceModule geofenceModule, LogoutModule logoutModule, GlobalSearchModule globalSearchModule, GetUserInfoModule getUserInfoModule, OttVerifyModule ottVerifyModule, PermissionStateModule permissionStateModule, GlobalNetworkModule globalNetworkModule, PayLaterModule payLaterModule, HomeTabModules homeTabModules, BiometricAnalyticModule biometricAnalyticModule, ServicesModule servicesModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ApplicationComponent applicationComponent) {
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            ShopOpenHourListMapper_Factory shopOpenHourListMapper_Factory;
            PayCardInfoMapper_Factory payCardInfoMapper_Factory;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.WithdrawSavedCardChannelView = this;
            this.BuiltInFictitiousFunctionClassFactory = biometricAnalyticModule;
            this.PlaceComponentResult = applicationComponent;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new DynamicUrlWrapperProvider(applicationComponent);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.getSupportButtonTintMode = contextProvider;
            this.access$getFeaturedBankListAdapter$p = GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory.MyBillsEntityDataFactory(geofenceModule, contextProvider);
            this.SokalSneathDissimilarity = new ThreadExecutorProvider(applicationComponent);
            this.setIndex$kotlin_stdlib = new PostExecutionThreadProvider(applicationComponent);
            GeofenceRepositoryProvider geofenceRepositoryProvider = new GeofenceRepositoryProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = geofenceRepositoryProvider;
            this.doCommonLog = PoiNotify_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, geofenceRepositoryProvider);
            this.n = GetListPoi_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.SummaryVoucherView$$ExternalSyntheticLambda2);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = featureConfigRepositoryProvider;
            this.i = GetGeoFenceConfig_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, featureConfigRepositoryProvider);
            this.Z = GetCurrentPOICacheTime_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.SummaryVoucherView$$ExternalSyntheticLambda2);
            this.addAutoLogActivity = SetRetryIntervalGeoFence_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.SummaryVoucherView$$ExternalSyntheticLambda2);
            GeofenceModule_ProvideView$app_productionReleaseFactory PlaceComponentResult = GeofenceModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(geofenceModule);
            this.setMatchingBeaconTypeCode = PlaceComponentResult;
            this.isAuth = DoubleCheck.getAuthRequestContext(GeoFencePresenter_Factory.MyBillsEntityDataFactory(this.doCommonLog, this.n, this.i, this.Z, this.addAutoLogActivity, PlaceComponentResult));
            this.ResourceResponseInfo = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvideViewFactory.MyBillsEntityDataFactory(getBalanceModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.OrAudience = userRepositoryProvider;
            this.V = GetBalance_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, userRepositoryProvider);
            this.access$setShowcaseShowing$p = GetSingleBalance_Factory.create(this.OrAudience);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.T = GetBalanceVisibility_Factory.create(accountRepositoryProvider);
            this.LinearSmoothScroller = SetBalanceVisibility_Factory.create(this.MyBillsEntityDataFactory);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetAllBalanceVisibility_Factory.create(this.MyBillsEntityDataFactory);
            this.isAuto = GetDanaHomeBalanceConfig_Factory.create(this.OrAudience);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.allowedTargets = provideInvestmentRepositoryProvider;
            this.getTextEndPadding = GetUserInvestmentSummary_Factory.create(provideInvestmentRepositoryProvider);
            Provider<GetBalancePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GetBalancePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.ResourceResponseInfo, this.V, this.access$setShowcaseShowing$p, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.T, this.LinearSmoothScroller, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.isAuto, this.getTextEndPadding));
            this.U = authRequestContext;
            this.access$getServiceItemDecorator$p = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvidePresenterFactory.getAuthRequestContext(getBalanceModule, authRequestContext));
            this.HttpClientAttributesExtractorBuilder = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(homeInfoModule));
            HomeRepositoryProvider homeRepositoryProvider = new HomeRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = homeRepositoryProvider;
            this.l = GetHomeInfo_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, homeRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext2 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.getSupportButtonTintMode);
            this.EventLoopImplBase$DelayedRunnableTask = authRequestContext2;
            this.GroupRecipientPermissionHelper = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            this.ArrayTable$2 = HomeInfoMapper_Factory.PlaceComponentResult(BaseResponseMapper_Factory.MyBillsEntityDataFactory(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.GroupRecipientPermissionHelper);
            this.CYFMonitor$ChallengeActionCallback = GetUpdatedHomeData_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            Provider<HomeInfoMapper> provider = this.ArrayTable$2;
            PromotionMapper_Factory BuiltInFictitiousFunctionClassFactory = PromotionMapper_Factory.BuiltInFictitiousFunctionClassFactory();
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.ArrayTable$1 = HomeDataModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(provider, BuiltInFictitiousFunctionClassFactory, feedsModelMapper_Factory, HasNewModelMapper_Factory.MyBillsEntityDataFactory());
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.SwitchFaceAuthContract = userEducationRepositoryProvider;
            this.getExceptionOrNull = IsNeedToShowToolTip_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, userEducationRepositoryProvider);
            this.setBackgroundTime = SaveShowToolTip_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.SwitchFaceAuthContract);
            this.ListenerMethod = new ProvideMerchantReviewRepositoryProvider(applicationComponent);
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.onTooManyRedirects = merchantInfoRepositoryProvider;
            this.access$getCapacity$p = GetReviewableMerchantForm_Factory.create(this.ListenerMethod, merchantInfoRepositoryProvider, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            MerchantSubcategoriesMapper_Factory authRequestContext3 = MerchantSubcategoriesMapper_Factory.getAuthRequestContext();
            shopOpenHourListMapper_Factory = ShopOpenHourListMapper_Factory.InstanceHolder.getAuthRequestContext;
            this.isTmpDetached = NearbyShopsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext3, shopOpenHourListMapper_Factory);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY = recentRecipientRepositoryProvider;
            this.isRegionMiniProgram = GetUserConfig_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, recentRecipientRepositoryProvider);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = GetMerchantReviewSummary_Factory.create(this.onTooManyRedirects);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.SubSequence = contractRepositoryProvider;
            this.rotateTo = GetSyncPermissionConfigUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            this.m = GetIsSyncPermission_Factory.PlaceComponentResult(this.SubSequence);
            this.SeekBarStopChangeEvent = SaveIsSyncPermission_Factory.MyBillsEntityDataFactory(this.SubSequence);
            this.flip = GetConfigRepeatBackgroundJobUseCase_Factory.getAuthRequestContext(this.SubSequence);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.indexOfAny = providePaylaterRepositoryProvider;
            this.forEach = SetPaylaterChannel_Factory.create(providePaylaterRepositoryProvider);
            this.parametersAsMap = new ProvideStartupConfigEntityDataProvider(applicationComponent);
            ProvideHomeOmniRepositoryProvider provideHomeOmniRepositoryProvider = new ProvideHomeOmniRepositoryProvider(applicationComponent);
            this.SplitReferralConfigEntityData_Factory = provideHomeOmniRepositoryProvider;
            this.insertActivities = GetSurveyInfo_Factory.create(provideHomeOmniRepositoryProvider);
            this.initAnimators = GetPaylaterChannel_Factory.create(this.SplitReferralConfigEntityData_Factory);
            this.verifyNotNull = GetProcessingTransaction_Factory.create(this.SplitReferralConfigEntityData_Factory);
            Provider<HomeInfoPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(HomeInfoPresenter_Factory.getAuthRequestContext(this.HttpClientAttributesExtractorBuilder, this.l, this.ArrayTable$2, this.CYFMonitor$ChallengeActionCallback, this.ArrayTable$1, this.getExceptionOrNull, this.setBackgroundTime, this.access$getCapacity$p, this.isTmpDetached, this.isRegionMiniProgram, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.rotateTo, this.m, this.SeekBarStopChangeEvent, this.flip, MerchantAverageRatingMapper_Factory.PlaceComponentResult(), this.forEach, this.parametersAsMap, this.insertActivities, this.initAnimators, this.verifyNotNull));
            this.f5834x461046da = authRequestContext4;
            this.setRibbonLineTopText = DoubleCheck.getAuthRequestContext(HomeInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(homeInfoModule, authRequestContext4));
            this.CreateRemoteWorkerExtension = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            this.A = new DeviceInformationProviderProvider(applicationComponent);
            this.MultiLanguageHttpClient = new LoginRepositoryProvider(applicationComponent);
            this.containsObjectForKey = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.getNrCsiRsrp = provideHomeWidgetClearableProvider;
            this.P = ForceLogout_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.MultiLanguageHttpClient, this.containsObjectForKey, provideHomeWidgetClearableProvider);
            this.checkMarmotConfig = Logout_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.MultiLanguageHttpClient, this.getNrCsiRsrp, this.containsObjectForKey);
            this.PrepareContext = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(this.SubSequence);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.fromContextOrNull = provideFeedInitRepositoryProvider;
            this.newProxyInstance = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.getDirName = servicesRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.AppCategory = provideDanapolyClearRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.getOpPackageName = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext5 = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext5;
            this.getCallingPid = DanaSessionManager_Factory.getAuthRequestContext(this.getSupportButtonTintMode, this.A, this.P, this.checkMarmotConfig, this.PrepareContext, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda7, authRequestContext5);
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.C = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = create;
            Provider<LogoutPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.CreateRemoteWorkerExtension, this.getCallingPid, create));
            this.createJavaMethod = authRequestContext6;
            this.onLayoutDirectionChanged = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext6));
            ProvideGlobalSearchRepositoryProvider provideGlobalSearchRepositoryProvider = new ProvideGlobalSearchRepositoryProvider(applicationComponent);
            this.connectionSpecs = provideGlobalSearchRepositoryProvider;
            this.ApiStatus$AvailableSince = GetSearchByKeyword_Factory.BuiltInFictitiousFunctionClassFactory(provideGlobalSearchRepositoryProvider);
            this.X = GetAutoCompleteByKeyword_Factory.getAuthRequestContext(this.connectionSpecs);
            this.InvestmentWalletAdapter = IsFeatureGlobalSearchEnabled_Factory.BuiltInFictitiousFunctionClassFactory(this.connectionSpecs);
            MerchantCategoriesRepositoryProvider merchantCategoriesRepositoryProvider = new MerchantCategoriesRepositoryProvider(applicationComponent);
            this.checkParameterIsNotNull = merchantCategoriesRepositoryProvider;
            this.OtpRegistrationPresenter$input$2 = GetMerchantSubcategories_Factory.create(merchantCategoriesRepositoryProvider);
            this.secondaryHash = GetRawServices_Factory.create(this.getDirName);
            this.h = GetHintSwipeVisibilityState_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.connectionSpecs);
            this.getMessaging = SetHintSwipeVisibilityState_Factory.BuiltInFictitiousFunctionClassFactory(this.connectionSpecs);
            this.FlowableCreate$BufferAsyncEmitter = GetPopularSearch_Factory.PlaceComponentResult(this.connectionSpecs);
            this.getGnBenefitEntityDanaProtection = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getKybKaFilter = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.f8114a = create2;
            this.R = GetAuthCode_Factory.create(this.getGnBenefitEntityDanaProtection, create2);
            this.BarcodeUtil$$ExternalSyntheticLambda1 = SaveLocationPermissionSuggestionState_Factory.PlaceComponentResult(this.connectionSpecs);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckShouldSuggestLocationPermissionDialog_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.connectionSpecs);
            this.TwilioRepository = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(globalSearchModule));
            this.JsonParseException = GetRecentSearch_Factory.MyBillsEntityDataFactory(this.connectionSpecs);
            this.setNewRibbon = SaveRecentSearch_Factory.MyBillsEntityDataFactory(this.connectionSpecs);
            this.FlowableReduce$ReduceSubscriber = GetPopularSearchPlaceholder_Factory.BuiltInFictitiousFunctionClassFactory(this.connectionSpecs);
            this.FlowViewUtil$textChanges$1 = GetGlobalSearchConfig_Factory.BuiltInFictitiousFunctionClassFactory(this.connectionSpecs);
            this.k = GetHomeSearchBarVisibility_Factory.PlaceComponentResult(this.connectionSpecs);
            ProvideProductInfoEntityRepositoryProvider provideProductInfoEntityRepositoryProvider = new ProvideProductInfoEntityRepositoryProvider(applicationComponent);
            this.ImageCaptureViewModel$getTipUploadPhoto$1 = provideProductInfoEntityRepositoryProvider;
            this.FlowableKt$toIterable$1 = GetSkuExplore_Factory.MyBillsEntityDataFactory(provideProductInfoEntityRepositoryProvider, this.getDirName, this.connectionSpecs);
            this.OtpRegistrationPresenter$input$1 = GetPrepaidCheckoutUrl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.ImageCaptureViewModel$getTipUploadPhoto$1);
            this.s = GetOnlineMerchant_Factory.MyBillsEntityDataFactory(this.connectionSpecs);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.UnicastProcessor$UnicastQueueSubscription = liteAccountRepositoryProvider;
            this.useDaemonThreadFactory = GetUserId_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, liteAccountRepositoryProvider);
            UserPersonalizationRepositoryProvider userPersonalizationRepositoryProvider = new UserPersonalizationRepositoryProvider(applicationComponent);
            this.Clause = userPersonalizationRepositoryProvider;
            CheckShouldShowUserPersonalization_Factory KClassImpl$Data$declaredNonStaticMembers$2 = CheckShouldShowUserPersonalization_Factory.KClassImpl$Data$declaredNonStaticMembers$2(userPersonalizationRepositoryProvider, this.MyBillsEntityDataFactory, this.connectionSpecs);
            this.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<GlobalSearchPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(GlobalSearchPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getSupportButtonTintMode, this.ApiStatus$AvailableSince, this.X, this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$2, this.secondaryHash, this.h, this.getMessaging, this.FlowableCreate$BufferAsyncEmitter, this.R, this.BarcodeUtil$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.TwilioRepository, this.JsonParseException, this.setNewRibbon, this.FlowableReduce$ReduceSubscriber, this.FlowViewUtil$textChanges$1, this.k, this.FlowableKt$toIterable$1, this.OtpRegistrationPresenter$input$1, this.s, this.useDaemonThreadFactory, KClassImpl$Data$declaredNonStaticMembers$2));
            this.f5833x461046d9 = authRequestContext7;
            this.getSavingConfigPresenter = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchPresenterFactory.getAuthRequestContext(globalSearchModule, authRequestContext7));
            this.QueryPayMethod = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvideViewFactory.getAuthRequestContext(getUserInfoModule));
            this.encodingStream = GetUserInfo_Factory.create(this.OrAudience);
            UserInfoMapper_Factory PlaceComponentResult2 = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.AttributeView = PlaceComponentResult2;
            Provider<GetUserInfoPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(GetUserInfoPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.QueryPayMethod, this.encodingStream, PlaceComponentResult2));
            this.WrappedDrawableState = authRequestContext8;
            this.KeyEvent$DispatcherState = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(getUserInfoModule, authRequestContext8));
            this.SearchConditionEntityKt = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(queryPayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.EmergencyNotifActivity$getEmergencyNotifModule$1 = payAssetRepositoryProvider;
            this.f = GetEnableAddNewCard_Factory.create(payAssetRepositoryProvider);
            this.buildStats = QueryPayMethod_Factory.create(this.EmergencyNotifActivity$getEmergencyNotifModule$1);
            this.PlaybackStateCompat$MediaKeyAction = IsOfflineF2FPay_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.toFullstoryConfig = qrPayRepositoryProvider;
            this.SchedulerPoolFactory = InitOfflinePay_Factory.create(qrPayRepositoryProvider);
            this.setBackgroundTint = StopOfflinePay_Factory.create(this.toFullstoryConfig);
            this.outerType = IsOfflinePayInitialized_Factory.create(this.toFullstoryConfig);
            this.v = GetPayCardConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2, this.EmergencyNotifActivity$getEmergencyNotifModule$1);
            Provider<QueryPayMethodContract.View> provider2 = this.SearchConditionEntityKt;
            Provider<GetEnableAddNewCard> provider3 = this.f;
            Provider<QueryPayMethod> provider4 = this.buildStats;
            payCardInfoMapper_Factory = PayCardInfoMapper_Factory.InstanceHolder.BuiltInFictitiousFunctionClassFactory;
            Provider<QueryPayMethodPresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(QueryPayMethodPresenter_Factory.MyBillsEntityDataFactory(provider2, provider3, provider4, payCardInfoMapper_Factory, this.PlaybackStateCompat$MediaKeyAction, this.SchedulerPoolFactory, this.A, this.setBackgroundTint, this.outerType, this.getSupportButtonTintMode, this.v));
            this.SourceParamUtil$DanaKagetClaimSource = authRequestContext9;
            this.f5831$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0 = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(queryPayMethodModule, authRequestContext9));
            this.VerifyPasswordFacade = DoubleCheck.getAuthRequestContext(UnreadInboxModule_ProvideViewFactory.PlaceComponentResult(unreadInboxModule));
            NotificationCenterRepositoryProvider notificationCenterRepositoryProvider = new NotificationCenterRepositoryProvider(applicationComponent);
            this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0 = notificationCenterRepositoryProvider;
            HasNewInbox_Factory create3 = HasNewInbox_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, notificationCenterRepositoryProvider);
            this.ArrayTable$3 = create3;
            Provider<UnreadInboxPresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(UnreadInboxPresenter_Factory.PlaceComponentResult(this.VerifyPasswordFacade, create3));
            this.TaskListBlock = authRequestContext10;
            this.createSecondaryAnimatorProvider = DoubleCheck.getAuthRequestContext(UnreadInboxModule_ProvidePresenterFactory.getAuthRequestContext(unreadInboxModule, authRequestContext10));
            GetCashierNativeConfig_Factory create4 = GetCashierNativeConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.W = create4;
            this.moveToNextValue = CashierEventHandler_Factory.BuiltInFictitiousFunctionClassFactory(create4);
            this.SubmitReceiptRequest = PermissionStateModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(permissionStateModule);
            PermissionRepositoryProvider permissionRepositoryProvider = new PermissionRepositoryProvider(applicationComponent);
            this.f5835getWalletV3RecommendationConfig$lambda193 = permissionRepositoryProvider;
            this.times = SetDeniedLocationPermission_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, permissionRepositoryProvider);
            CheckDeniedLocationPermission_Factory create5 = CheckDeniedLocationPermission_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.f5835getWalletV3RecommendationConfig$lambda193);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create5;
            Provider<PermissionStatePresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(PermissionStatePresenter_Factory.getAuthRequestContext(this.SubmitReceiptRequest, this.times, create5));
            this.NavigationMenuPresenter$HeaderViewHolder = authRequestContext11;
            this.onGetActiveNotifications = PermissionStateModule_ProvidePresenterFactory.PlaceComponentResult(permissionStateModule, authRequestContext11);
            this.ServiceStarter = DoubleCheck.getAuthRequestContext(OttVerifyModule_ProvideViewFactory.PlaceComponentResult(ottVerifyModule));
            OttRepositoryProvider ottRepositoryProvider = new OttRepositoryProvider(applicationComponent);
            this.FamilyDashboardPresenter_Factory = ottRepositoryProvider;
            this.TypefaceCompatApi26Impl = GetOttVerify_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, ottRepositoryProvider);
            GetPhoneNumber_Factory create6 = GetPhoneNumber_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.UnicastProcessor$UnicastQueueSubscription);
            this.RequestMoneyQrContract$View = create6;
            Provider<OttVerifyPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(OttVerifyPresenter_Factory.PlaceComponentResult(this.getSupportButtonTintMode, this.ServiceStarter, this.TypefaceCompatApi26Impl, create6));
            this.SplitSavingConfigEntityData = authRequestContext12;
            this.ViewInputOtpBinding = DoubleCheck.getAuthRequestContext(OttVerifyModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(ottVerifyModule, authRequestContext12));
            this.ImageWithDescriptionView$showImage$1 = new ProvideLocationPermissionSubjectProvider(applicationComponent);
            this.resetSizeCounter = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            this.View$OnClickListener = IsCScanBEnabled_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.containsObjectForKey);
            this.whenAvailable = DecodeGnQr_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.containsObjectForKey);
            this.f5832$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM = OpenMerchantCashier_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.containsObjectForKey);
            this.connectForeground = GetGnCScanBBlacklistedCountry_Factory.create(this.containsObjectForKey);
            this.getRawPath = GetUserInfoWithKyc_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.OrAudience);
            this.TypeToken$TypeSet = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(this.getSupportButtonTintMode);
            this.Y = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.containsObjectForKey);
            this.getPhoneMask = IsAlipayConnectServiceFirstTime_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.containsObjectForKey);
            this.getSharingAgreementIds = SaveAlipayConnectServiceFirstTime_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.containsObjectForKey);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = GetWalletOauth_Factory.create(this.containsObjectForKey);
            GetPayRequest_Factory create7 = GetPayRequest_Factory.create(this.containsObjectForKey);
            this.y = create7;
            Provider<GlobalNetworkPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.resetSizeCounter, this.View$OnClickListener, this.whenAvailable, this.f5832$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM, this.connectForeground, this.getRawPath, this.TypeToken$TypeSet, this.Y, this.getPhoneMask, this.getSharingAgreementIds, this.SecuritySettingsActivity$createPinLauncher$2$1, this.R, create7));
            this.CheckPromoQuestFeature = authRequestContext13;
            this.clearMerchantList = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext13));
            this.itemClicked$core = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = ClearCachePayLaterLoanWhitelist_Factory.create(this.indexOfAny, this.getDirName);
            this.x = GetPayLaterCacheLoanWhitelist_Factory.create(this.indexOfAny);
            this.applyTrimPathIfNeeded = GetUserLoanInfo_Factory.create(this.indexOfAny);
            this.DeserializedCallableMemberDescriptor = SavePaylaterRotationDelayTime_Factory.create(this.indexOfAny);
            this.z = GetPaylaterRotationDelayTime_Factory.create(this.indexOfAny);
            this.u = GetPayLaterLoanStatusWhitelist_Factory.create(this.indexOfAny);
            this.setValue = UpdatePayLaterLoanCache_Factory.create(this.indexOfAny, this.getDirName);
            SetPayLaterLoanCache_Factory create8 = SetPayLaterLoanCache_Factory.create(this.indexOfAny, this.getDirName);
            this.FloatPoint = create8;
            Provider<PayLaterPresenter> authRequestContext14 = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.itemClicked$core, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.x, this.applyTrimPathIfNeeded, this.DeserializedCallableMemberDescriptor, this.z, this.u, this.setValue, create8));
            this.StandardRowSortedTable$1 = authRequestContext14;
            this.CreateOrderTopUpFamilyBalance = PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule, authRequestContext14);
            this.GetExpressPurchaseResponse$PriceEntity = HomeTabModules_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(homeTabModules);
            ProvideHomeConfigEntityRepositoryProvider provideHomeConfigEntityRepositoryProvider = new ProvideHomeConfigEntityRepositoryProvider(applicationComponent);
            this.setAkuEntranceOpen = provideHomeConfigEntityRepositoryProvider;
            this.SizeSelectors$OrSelector = GetMixpanelStorageConfig_Factory.create(provideHomeConfigEntityRepositoryProvider);
            this.isInfoWindowShown = GetVoiceAssistantConfig_Factory.create(this.setAkuEntranceOpen);
            this.FlowableConcatMapEagerPublisher = GetUserCohort_Factory.create(this.OrAudience);
            this.saveNickname = new ProvideRiskTrackerProvider(applicationComponent);
            ProvideHomePassiveBioRepositoryProvider provideHomePassiveBioRepositoryProvider = new ProvideHomePassiveBioRepositoryProvider(applicationComponent);
            this.roundToPowerOfTwo = provideHomePassiveBioRepositoryProvider;
            this.DatabaseTableConfigUtil = CheckHomePassiveBioTracked_Factory.create(provideHomePassiveBioRepositoryProvider);
            this.onLoadComplete = SavePassiveBioTracked_Factory.create(this.roundToPowerOfTwo);
            ProvideCredentialRepositoryProvider provideCredentialRepositoryProvider = new ProvideCredentialRepositoryProvider(applicationComponent);
            this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider = provideCredentialRepositoryProvider;
            this.w = GetPasswordLastModifiedWithConfigChecking_Factory.create(provideCredentialRepositoryProvider);
            this.getContainerAuth = GetQueryUserDataConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.e = GetFeatureHoldLoginConfig_Factory.create(this.setAkuEntranceOpen);
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.ContentDeliveryCacheEntityDataFactory = provideResetPinRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = ConsultForceDanaVizEnroll_Factory.create(provideResetPinRepositoryProvider, this.OrAudience);
            this.checkRegisteredUserAndSendOtp = GetResetAndChangePinNativeEntryConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.Q = FileSystemStorageEntity_Factory.getAuthRequestContext(this.getSupportButtonTintMode);
            ProvideSplitFacadeProvider provideSplitFacadeProvider = new ProvideSplitFacadeProvider(applicationComponent);
            this.ImageCaptureViewModel$getTipUploadPhoto$2 = provideSplitFacadeProvider;
            this.access$loadDashboardData = SplitDeviceStatsConfigEntityData_Factory.MyBillsEntityDataFactory(provideSplitFacadeProvider);
            this.GetTopUpUserConsult = DeviceStatsModule_ProvideDeviceStatsPreferenceFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getSupportButtonTintMode);
            DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory MyBillsEntityDataFactory = DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory.MyBillsEntityDataFactory(this.getSupportButtonTintMode);
            this.glVertexAttrib1fv = MyBillsEntityDataFactory;
            FileSystemStatsRepository_Factory KClassImpl$Data$declaredNonStaticMembers$22 = FileSystemStatsRepository_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.Q, this.access$loadDashboardData, this.GetTopUpUserConsult, MyBillsEntityDataFactory, FileDirectoriesSizeMapper_Factory.MyBillsEntityDataFactory());
            this.L = KClassImpl$Data$declaredNonStaticMembers$22;
            FileDirectorySizeReportScheduler_Factory create9 = FileDirectorySizeReportScheduler_Factory.create(KClassImpl$Data$declaredNonStaticMembers$22);
            this.getNameOrBuilderList = create9;
            this.ItemSnapshotList = ScheduleDeviceStatsReport_Factory.create(create9);
            this.access$throwIllegalArgumentType = GetIsSessionChecked_Factory.create(this.MultiLanguageHttpClient);
            this.BridgeActivity = SaveIsSessionChecked_Factory.create(this.MultiLanguageHttpClient);
            this.GetContactSyncConfig = CheckSession_Factory.create(this.MultiLanguageHttpClient);
            IsFirstTime_Factory create10 = IsFirstTime_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.MyBillsEntityDataFactory);
            this.onPolygonsChanged = create10;
            HomeTabPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = HomeTabPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.GetExpressPurchaseResponse$PriceEntity, this.SizeSelectors$OrSelector, this.isInfoWindowShown, this.FlowableConcatMapEagerPublisher, this.saveNickname, this.DatabaseTableConfigUtil, this.onLoadComplete, this.w, this.getContainerAuth, this.e, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.checkRegisteredUserAndSendOtp, this.ItemSnapshotList, this.access$throwIllegalArgumentType, this.BridgeActivity, this.GetContactSyncConfig, create10);
            this.BannerEntityDataFactory_Factory = BuiltInFictitiousFunctionClassFactory2;
            this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider = HomeTabModules_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(homeTabModules, BuiltInFictitiousFunctionClassFactory2);
            this.ISO8601Utils = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.getTypeMappings = provideEventTrackerQueueProvider;
            this.O = FirebaseAnalytics_Factory.PlaceComponentResult(this.getSupportButtonTintMode, this.ISO8601Utils, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$23 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getSupportButtonTintMode, this.getTypeMappings);
            this.PrefetchDownloadStatus = KClassImpl$Data$declaredNonStaticMembers$23;
            Provider<FirebaseAnalytics> provider5 = this.O;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult3 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider5, KClassImpl$Data$declaredNonStaticMembers$23, fullStoryAnalytics_Factory);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult3;
            this.DebugCoroutineInfoImpl = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3);
            this.setValuePrefixBytes = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.getSupportButtonTintMode);
            this.onCubeAppPerfEvent = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.ReferralMapper_Factory = GetServicesWithCategory_Factory.create(this.getDirName);
            this.b = GetDefaultServiceWithCategory_Factory.create(this.getDirName);
            this.FillAnimation = GetFavoriteServiceRemote_Factory.create(this.getDirName);
            this.SendMoneyScenario = GetServicesByName_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.getDirName);
            this.PromoCategoryPresenter$1 = GetServicesByKey_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.getDirName);
            this.TypeProjectionImpl = GetFavoriteServices_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.getDirName);
            this.lookAheadTest = CheckFavoriteServicesFeature_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.g = GetFavoriteServiceWithCacheFirst_Factory.create(this.getDirName);
            this.InitSecurePreferenceAccount = GetServiceHighlighted_Factory.create(this.getDirName);
            UpdateServiceHighlighted_Factory create11 = UpdateServiceHighlighted_Factory.create(this.getDirName);
            this.OcrImagePreprocessingConfigModel = create11;
            Provider<ServicesPresenter> authRequestContext15 = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.getSupportButtonTintMode, this.onCubeAppPerfEvent, this.R, this.GroupRecipientPermissionHelper, this.getExceptionOrNull, this.setBackgroundTime, this.ReferralMapper_Factory, this.b, this.FillAnimation, this.SendMoneyScenario, this.PromoCategoryPresenter$1, this.TypeProjectionImpl, this.lookAheadTest, this.secondaryHash, this.g, this.InitSecurePreferenceAccount, create11));
            this.timer = authRequestContext15;
            this.targetValue = ServicesModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(servicesModule, authRequestContext15);
            Provider<Activity> authRequestContext16 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.flow = authRequestContext16;
            Provider<ScanQrView> authRequestContext17 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext16));
            this.Code128Reader = authRequestContext17;
            this.ListPopupWindow$Api29Impl = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext17));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.getLastClearRequest = qrBarcodeRepositoryProvider;
            this.QrExpiredActivity = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.d = GetDecodedQrisTopUp_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.getLastClearRequest);
            this.DialogTncInformation_ViewBinding = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.SecuritySettingsActivity$createPinLauncher$2$2 = GetUserStatusInfo_Factory.create(this.OrAudience);
            this.TrackerKey$GlobalSearchOpenProperties = IsNativeDecodeEnabled_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            GetDecodeTciCoListConfig_Factory create12 = GetDecodeTciCoListConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.c = create12;
            this.GifDrawableTransformation = ValidateNativelyDecodedQr_Factory.create(create12);
            this.f8115o = GetMerchantQrWhitelist_Factory.create(this.getLastClearRequest);
            this.onDecodeSuccess = GetQrBindingConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.getRecommendationData = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.getDefaultSenderId = GetQrisCpmSendmoneyConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2, this.SwitchFaceAuthContract);
            this.PromoExploreModule_ProvidesPresenterFactory = SaveShowDialog_Factory.create(this.SwitchFaceAuthContract);
            Provider<ScanQrPresenter> authRequestContext18 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getSupportButtonTintMode, this.ListPopupWindow$Api29Impl, this.QrExpiredActivity, this.d, this.DialogTncInformation_ViewBinding, this.A, this.SecuritySettingsActivity$createPinLauncher$2$2, this.W, GetNativelyDecodedQr_Factory.create(), this.TrackerKey$GlobalSearchOpenProperties, this.GifDrawableTransformation, this.f8115o, this.onDecodeSuccess, this.getRecommendationData, this.applyTrimPathIfNeeded, this.getDefaultSenderId, this.PromoExploreModule_ProvidesPresenterFactory));
            this.VerifyPushDerollRequest = authRequestContext18;
            this.access$showKycAmlEddDialog = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext18));
            Provider<RestoreUrlView> authRequestContext19 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.getSupportButtonTintMode));
            this.initResult = authRequestContext19;
            this.DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext19));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1 = shortenerRepositoryProvider;
            RestoreUrl_Factory create13 = RestoreUrl_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, shortenerRepositoryProvider);
            this.longitude = create13;
            Provider<RestoreUrlPresenter> authRequestContext20 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider, create13));
            this.MapPageContract$Presenter = authRequestContext20;
            this.FamilyManageAvailableServicesAdapter = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext20));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.storeUserConfig = myReferralConsultRepositoryProvider;
            this.f5836reduceIndexedz1zDJgo = GetReferralConsult_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = CheckShowReferralCodeFeature_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.murmurHash64WithSeed = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = generateLinkRepositoryProvider;
            this.N = GenerateReferralDeepLink_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.clearStatesNotIn = settingRepositoryProvider;
            this.getReadyFragment = GetSettingByKey_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.isAllowRetry = productPageManagerProvider;
            this.H = FeatureSettingMore_Factory.PlaceComponentResult(this.getReadyFragment, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.PaylaterRegistrationCooldownCache = splitBillRepositoryProvider;
            this.setNetAuthId = GetPayerSplitBillDetail_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, splitBillRepositoryProvider);
            this.getStackFromEnd = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult4 = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.getStackFromEnd);
            this.setDistrictAdcode = PlaceComponentResult4;
            this.J = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.setNetAuthId, PlaceComponentResult4);
            this.NewMerchantCategoryAdapter = GetSplitBillConfig_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            GetRequestMoneyInfoFeature_Factory create14 = GetRequestMoneyInfoFeature_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.getIndexName = create14;
            Provider<GetSplitBillConfig> provider6 = this.NewMerchantCategoryAdapter;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.K = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider6, create14, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.RepaymentPlan = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create15 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.r = create15;
            this.I = FeaturePromoQuest_Factory.getAuthRequestContext(create15, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.F = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.readMicros = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.getSupportButtonTintMode));
            this.D = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(this.setValuePrefixBytes));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 = provideFamilyAccountRepositoryProvider;
            CheckConsultFamilyAccount_Factory create16 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.scheduleImpl = create16;
            this.getOnBoardingScenario = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(create16, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.getNrCsiRsrq = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory3 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.j = BuiltInFictitiousFunctionClassFactory3;
            this.getValueOfTouchPositionAbsolute = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3);
            this.G = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.setValuePrefixBytes));
            Provider<FeatureView> authRequestContext21 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.f5836reduceIndexedz1zDJgo, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.murmurHash64WithSeed, this.N, this.H, this.J, this.K, this.I, this.F, this.readMicros, FeatureHome_Factory.MyBillsEntityDataFactory(), this.D, FeatureKyb_Factory.getAuthRequestContext(), this.getOnBoardingScenario, this.getValueOfTouchPositionAbsolute, this.applyTrimPathIfNeeded, FeatureMyBills_Factory.PlaceComponentResult(), this.G));
            this.M = authRequestContext21;
            Provider<FeatureContract.View> authRequestContext22 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext21));
            this.TrustRiskLogin$Params = authRequestContext22;
            this.AppCompatEmojiTextHelper = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext22, this.PromoCategoryPresenter$1, this.GroupRecipientPermissionHelper, this.R, this.A));
            this.getErrorConfigVersion = CheckDeepLinkActionVisibility_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.isLayoutRequested = CheckWhitelistedValidDomain_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.q = GetNearbyConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.removeFloat = provideFeedsConfigRepositoryProvider;
            this.FlowViewUtil$textChanges$2 = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.getCardNumberOCR = GetPromoCenterVersion_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.getFontAssetManager = GetUpdateAvailability_Factory.create(this.getSupportButtonTintMode);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = CheckMyBillsVersionConfig_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.TimeoutError = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create17 = GetService_Factory.create(this.getDirName);
            this.retainOrRemoveAllInternal = create17;
            Provider<FeaturePresenter> authRequestContext23 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.TrustRiskLogin$Params, this.AppCompatEmojiTextHelper, this.getErrorConfigVersion, this.isLayoutRequested, this.q, this.FlowViewUtil$textChanges$2, this.getCardNumberOCR, this.getFontAssetManager, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.TimeoutError, create17));
            this.E = authRequestContext23;
            this.NearbyConstantsKt = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext23));
            OauthView_Factory authRequestContext24 = OauthView_Factory.getAuthRequestContext(this.D);
            this.SubmitReceiptResultModel$Creator = authRequestContext24;
            this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext24));
            this.p = GetKycLevel_Factory.create(this.MyBillsEntityDataFactory);
            this.t = GetNickname_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, this.MyBillsEntityDataFactory);
            this.BaseSocialFeedContract$Presenter = GetWhitelistedSubMerchantId_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.S = GetAddingNameWhitelistedMerchantId_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            Provider<OauthContract.View> provider7 = this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$24 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider7, oauthParamsModelMapper_Factory, this.p, this.getRawPath, this.t, this.BaseSocialFeedContract$Presenter, this.S);
            this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl = KClassImpl$Data$declaredNonStaticMembers$24;
            this.CacheBuilderSpec$AccessDurationParser = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$24));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext25 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.access$showKycAmlEddDialog, this.FamilyManageAvailableServicesAdapter, this.NearbyConstantsKt, this.CacheBuilderSpec$AccessDurationParser, this.timer, applicationProvider, this.applyTrimPathIfNeeded));
            this.B = authRequestContext25;
            this.SightCameraView$ICameraFrameListener = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext25));
            this.CreateCredentialCustomException = ReadDeepLinkProperties_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            DeepLinkPayloadModelMapper_Factory BuiltInFictitiousFunctionClassFactory4 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = BuiltInFictitiousFunctionClassFactory4;
            Provider<ReadLinkPropertiesPresenter> authRequestContext26 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.SightCameraView$ICameraFrameListener, this.CreateCredentialCustomException, BuiltInFictitiousFunctionClassFactory4, this.useDaemonThreadFactory, this.setValuePrefixBytes));
            this.BarcodeUtil$$ExternalSyntheticLambda0 = authRequestContext26;
            this.FontsContractCompat$FontRequestCallback = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext26));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.ConcurrentKt = h5eventRepositoryProvider;
            GetCheckoutH5Event_Factory create18 = GetCheckoutH5Event_Factory.create(this.SokalSneathDissimilarity, this.setIndex$kotlin_stdlib, h5eventRepositoryProvider);
            this.shouldRecycleViewType = create18;
            this.getThread = WalletH5ServicesImplementation_Factory.create(create18);
        }

        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent PlaceComponentResult;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class GeofenceRepositoryProvider implements Provider<GeoFenceRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GeofenceRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeoFenceRepository get() {
                return (GeoFenceRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.readMicros());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypefaceCompatApi26Impl());
            }
        }

        /* loaded from: classes4.dex */
        public static final class HomeRepositoryProvider implements Provider<HomeInfoRepository> {
            private final ApplicationComponent getAuthRequestContext;

            HomeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeInfoRepository get() {
                return (HomeInfoRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.B());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ProvideMerchantReviewRepositoryProvider implements Provider<MerchantReviewFormRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideMerchantReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantReviewFormRepository get() {
                return (MerchantReviewFormRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.x());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$setShowcaseShowing$p());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ProvideStartupConfigEntityDataProvider implements Provider<StartupConfigEntityData> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideStartupConfigEntityDataProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ StartupConfigEntityData get() {
                return (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.onDecodeSuccess());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomeOmniRepositoryProvider implements Provider<HomeOmniRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideHomeOmniRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeOmniRepository get() {
                return (HomeOmniRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.t());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent PlaceComponentResult;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent getAuthRequestContext;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.G());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SubSequence());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.PlaceComponentResult.r());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.l());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.i());
            }
        }

        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideGlobalSearchRepositoryProvider implements Provider<GlobalSearchRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideGlobalSearchRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSearchRepository get() {
                return (GlobalSearchRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.o());
            }
        }

        /* loaded from: classes4.dex */
        public static final class MerchantCategoriesRepositoryProvider implements Provider<MerchantCategoriesRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MerchantCategoriesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantCategoriesRepository get() {
                return (MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.K());
            }
        }

        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideProductInfoEntityRepositoryProvider implements Provider<ProductInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideProductInfoEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductInfoRepository get() {
                return (ProductInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowableReduce$ReduceSubscriber());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.AppCompatEmojiTextHelper());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserPersonalizationRepositoryProvider implements Provider<UserPersonalizationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserPersonalizationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserPersonalizationRepository get() {
                return (UserPersonalizationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SchedulerPoolFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent PlaceComponentResult;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.X());
            }
        }

        /* loaded from: classes4.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PromoCategoryPresenter$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class NotificationCenterRepositoryProvider implements Provider<NotificationCenterRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            NotificationCenterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ NotificationCenterRepository get() {
                return (NotificationCenterRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.R());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PermissionRepositoryProvider implements Provider<PermissionRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PermissionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PermissionRepository get() {
                return (PermissionRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.flip());
            }
        }

        /* loaded from: classes4.dex */
        public static final class OttRepositoryProvider implements Provider<OttRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            OttRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OttRepository get() {
                return (OttRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.T());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideLocationPermissionSubjectProvider implements Provider<LocationPermissionSubject> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideLocationPermissionSubjectProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LocationPermissionSubject get() {
                return (LocationPermissionSubject) Preconditions.PlaceComponentResult(this.PlaceComponentResult.w());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomeConfigEntityRepositoryProvider implements Provider<HomeConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideHomeConfigEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeConfigRepository get() {
                return (HomeConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.n());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideRiskTrackerProvider implements Provider<RiskTracker> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideRiskTrackerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RiskTracker get() {
                return (RiskTracker) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getDefaultSenderId());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideHomePassiveBioRepositoryProvider implements Provider<HomePassiveBioRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideHomePassiveBioRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomePassiveBioRepository get() {
                return (HomePassiveBioRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SizeSelectors$OrSelector());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideCredentialRepositoryProvider implements Provider<CredentialRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideCredentialRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CredentialRepository get() {
                return (CredentialRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.FlowViewUtil$textChanges$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getContainerAuth());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideSplitFacadeProvider implements Provider<SplitFacade> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideSplitFacadeProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitFacade get() {
                return (SplitFacade) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.secondaryHash());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$2());
            }
        }

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
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.applyTrimPathIfNeeded());
            }
        }

        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.P());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isInfoWindowShown());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType());
            }
        }

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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.k());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.z());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$throwIllegalArgumentType());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        @Override // id.dana.di.component.HomeRecycleComponent
        public final void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment) {
            homeRecycleFragment.dynamicUrlWrapper = DoubleCheck.MyBillsEntityDataFactory(this.BottomSheetCardBindingView$watcherCardNumberView$1);
            HomeRecycleFragment_MembersInjector.getAuthRequestContext(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.access$getFeaturedBankListAdapter$p));
            HomeRecycleFragment_MembersInjector.getErrorConfigVersion(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.isAuth));
            HomeRecycleFragment_MembersInjector.scheduleImpl(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.access$getServiceItemDecorator$p));
            HomeRecycleFragment_MembersInjector.initRecordTimeStamp(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.setRibbonLineTopText));
            HomeRecycleFragment_MembersInjector.GetContactSyncConfig(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.onLayoutDirectionChanged));
            HomeRecycleFragment_MembersInjector.moveToNextValue(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.getSavingConfigPresenter));
            HomeRecycleFragment_MembersInjector.lookAheadTest(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.KeyEvent$DispatcherState));
            HomeRecycleFragment_MembersInjector.PrepareContext(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.f5831$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0));
            homeRecycleFragment.unreadInboxPresenter = DoubleCheck.MyBillsEntityDataFactory(this.createSecondaryAnimatorProvider);
            HomeRecycleFragment_MembersInjector.MyBillsEntityDataFactory(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            HomeRecycleFragment_MembersInjector.isLayoutRequested(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.onGetActiveNotifications));
            HomeRecycleFragment_MembersInjector.newProxyInstance(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.ViewInputOtpBinding));
            homeRecycleFragment.locationPermissionSubject = DoubleCheck.MyBillsEntityDataFactory(this.ImageWithDescriptionView$showImage$1);
            homeRecycleFragment.globalNetworkPresenter = DoubleCheck.MyBillsEntityDataFactory(this.clearMerchantList);
            homeRecycleFragment.payLaterPresenter = DoubleCheck.MyBillsEntityDataFactory(this.CreateOrderTopUpFamilyBalance);
            homeRecycleFragment.homeTabPresenter = DoubleCheck.MyBillsEntityDataFactory(this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider);
            HomeRecycleFragment_MembersInjector.PlaceComponentResult(homeRecycleFragment, BiometricAnalyticModule_ProvidePassiveBioAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
            HomeRecycleFragment_MembersInjector.DatabaseTableConfigUtil(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.DebugCoroutineInfoImpl));
            HomeRecycleFragment_MembersInjector.PlaceComponentResult(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.setValuePrefixBytes));
            homeRecycleFragment.servicePresenter = DoubleCheck.MyBillsEntityDataFactory(this.targetValue);
            homeRecycleFragment.readLinkPropertiesPresenter = DoubleCheck.MyBillsEntityDataFactory(this.FontsContractCompat$FontRequestCallback);
            homeRecycleFragment.walletH5ServicesImplementation = DoubleCheck.MyBillsEntityDataFactory(this.getThread);
            HomeRecycleFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(homeRecycleFragment, DoubleCheck.MyBillsEntityDataFactory(this.A));
            HomeRecycleFragment_MembersInjector.PlaceComponentResult(homeRecycleFragment, new PaylaterMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
            HomeRecycleFragment_MembersInjector.getAuthRequestContext(homeRecycleFragment, this.NearbyConstantsKt.get());
        }
    }
}
