package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
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
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfilePresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfileViewFactory;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter_Factory;
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
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.staticqr.GetStaticQrModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.GetStaticQrModule_ProvideViewFactory;
import id.dana.contract.staticqr.GetStaticQrPresenter;
import id.dana.contract.staticqr.GetStaticQrPresenter_Factory;
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
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaCustomH5_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.DanaPlusModule;
import id.dana.di.modules.DanaPlusModule_ProvideDanaPlusPresenterFactory;
import id.dana.di.modules.DanaPlusModule_ProvideDanaPlusPresenterViewFactory;
import id.dana.di.modules.GoldInvestmentModule;
import id.dana.di.modules.GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.GoldInvestmentModule_ProvideView$app_productionReleaseFactory;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentPresenterFactory;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentViewFactory;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.MyProfileModule_ProvidePresenterFactory;
import id.dana.di.modules.MyProfileModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SavingModule_ProvideSavingPresenterFactory;
import id.dana.di.modules.SavingModule_ProvideSavingViewFactory;
import id.dana.di.modules.UserStatementModule;
import id.dana.di.modules.UserStatementModule_ProvidePresenterFactory;
import id.dana.di.modules.UserStatementModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetAllBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetAvatarUrl_Factory;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.account.interactor.GetNickname_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility_Factory;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.account.interactor.UploadAvatar_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink_Factory;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
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
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility_Factory;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain_Factory;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.interactor.CheckFeatureInvestment;
import id.dana.domain.investment.interactor.CheckFeatureInvestment_Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
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
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache_Factory;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig_Factory;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData_Factory;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp_Factory;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.GetSettingByKey_Factory;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetSettingCollection_Factory;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag_Factory;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp_Factory;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig_Factory;
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
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr_Factory;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr_Factory;
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
import id.dana.domain.recurring.subscription.RecurringSubscriptionRepository;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription_Factory;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache_Factory;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.interactor.GetReferralTracker_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.registration.interactor.GetChatBotTimestamp_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingEmptyState_Factory;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.GetSavingSummary_Factory;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.interactor.InitSavingCreate_Factory;
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
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement_Factory;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetStatementDetail;
import id.dana.domain.statement.interactor.GetStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementDisableDetail;
import id.dana.domain.statement.interactor.GetStatementDisableDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementSummary;
import id.dana.domain.statement.interactor.GetStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetTotalStatements;
import id.dana.domain.statement.interactor.GetTotalStatements_Factory;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.uploadfiles.ClearFiles_Factory;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetBalance_Factory;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig_Factory;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.user.interactor.GetUserStatusInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveShowDialog;
import id.dana.domain.usereducation.interactor.SaveShowDialog_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.domain.version.interactor.GetUpdateAvailability_Factory;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal_Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.investment.contract.DanaPlusContract;
import id.dana.investment.contract.GoldInvestmentContract;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter_Factory;
import id.dana.investment.presenter.DanaPlusPresenter;
import id.dana.investment.presenter.DanaPlusPresenter_Factory;
import id.dana.investment.presenter.GoldInvestmentPresenter;
import id.dana.investment.presenter.GoldInvestmentPresenter_Factory;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ReferralTrackerModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.MyProfilePresenter;
import id.dana.myprofile.NewMyProfileFragment;
import id.dana.myprofile.NewMyProfileFragment_MembersInjector;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.pay.PayCardInfoMapper_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingPresenter;
import id.dana.savings.presenter.SavingPresenter_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney_v2.tracker.ApiHitTimer_Factory;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementPresenter;
import id.dana.statement.UserStatementPresenter_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerNewMyProfileComponent {
    private DaggerNewMyProfileComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public RestoreUrlModule DatabaseTableConfigUtil;
        public QueryPayMethodModule GetContactSyncConfig;
        public DanaPlusModule KClassImpl$Data$declaredNonStaticMembers$2;
        public DeepLinkModule MyBillsEntityDataFactory;
        public GenerateDeepLinkModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public OauthModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public MyProfileModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda8;
        public BottomSheetOnBoardingModule PlaceComponentResult;
        public UserStatementModule PrepareContext;
        public FeatureModule getAuthRequestContext;
        public GoldInvestmentModule getErrorConfigVersion;
        public PayLaterModule initRecordTimeStamp;
        public SavingModule isLayoutRequested;
        public GetBalanceModule lookAheadTest;
        public GetStaticQrModule moveToNextValue;
        public ServicesModule newProxyInstance;
        public InvestmentModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class NewMyProfileComponentImpl implements NewMyProfileComponent {

        /* renamed from: $r8$lambda$7jSe-jJ0etbd9VooMli6zMuqlA0 */
        private Provider<ServiceCategoryMapper> f5861$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0;

        /* renamed from: $r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M */
        private Provider<SavingContract.Presenter> f5862$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
        private Provider<RecurringSubscriptionRepository> $r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0;
        private Provider<ReadDeepLinkProperties> $r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8;
        private Provider<FaceAuthPopUpConsultationRepository> A;
        private Provider<GetWalletConfigFromLocal> ApiStatus$AvailableSince;
        private Provider<QrBarcodeRepository> AppCategory;
        private Provider<FeatureScanQR> AppCompatEmojiTextHelper;
        private Provider<ProfileQrDeepLinkPresenter> ArrayTable$1;
        private Provider<Activity> ArrayTable$2;
        private final PayLaterModule ArrayTable$3;
        private Provider<DeviceInformationProvider> B;
        private Provider<FamilyAccountRepository> BannerEntityDataFactory_Factory;
        private Provider<OauthPresenter> BaseSocialFeedContract$Presenter;
        private Provider<DeepLinkView> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<DeepLinkRepository> C;
        private Provider<LiteAccountRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<ServicesRepository> CacheBuilderSpec$AccessDurationParser;
        private Provider<ProductPageManager> CheckPromoQuestFeature;
        private Provider<PayLaterPresenter> ConcurrentKt;
        private Provider<TwilioEnrollmentEligibilityRepository> ContentDeliveryCacheEntityDataFactory;
        private Provider<ScanQrPresenter> CreateOrderTopUpFamilyBalance;
        private Provider<SaveReferralEngagementDialogCache> CreateRemoteWorkerExtension;
        private Provider<FeatureConfigRepository> D;
        private Provider<ScanQrView> DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider;
        private Provider<SavingContract.View> DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl;
        private Provider<ValidateNativelyDecodedQr> DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider;
        private Provider<UserRepository> DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider;
        private Provider<FeatureContract.View> DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider;
        private Provider<GetQrisTcicoConfig> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckUsernameConfig> DatabaseTableConfigUtil;
        private Provider<DanaPlusContract.Presenter> DebugCoroutineInfoImpl;
        private Provider<FamilyAccountSettingConfigRunner> E;
        private Provider<GetBalanceContract.View> EmergencyNotifActivity$getEmergencyNotifModule$1;
        private Provider<FeatureServicesHandler> F;
        private Provider<PayLaterContract.View> FamilyDashboardPresenter_Factory;
        private Provider<ScanResultMapper> FamilyManageAvailableServicesAdapter;
        private Provider<GetKycLevel> FillAnimation;
        private Provider<BottomSheetOnBoardingContract.Presenter> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetNearbyConfig> FlowViewUtil$textChanges$1;
        private Provider<GetPayCardConfig> FlowViewUtil$textChanges$2;
        private Provider<KybSettingConfigRunner> FlowableConcatMapEagerPublisher;
        private Provider<GetStatementDetail> FlowableCreate$BufferAsyncEmitter;
        private Provider<IsNativeDecodeEnabled> FlowableKt$toIterable$1;
        private Provider<GetStatementDisableDetail> FlowableReduce$ReduceSubscriber;
        private Provider<UpdateServiceHighlighted> FontsContractCompat$FontRequestCallback;
        private Provider<DanaCustomH5> FragmentBottomSheetPaymentSettingBinding;
        private Provider<FeaturePresenter> G;
        private Provider<CheckWhitelistedValidDomain> GetContactSyncConfig;
        private Provider<UploadAvatar> GetExpressPurchaseResponse$PriceEntity;
        private Provider<QueryPayMethodPresenter> GetTopUpUserConsult;
        private Provider<FeaturePushVerify> H;
        private Provider<FeaturePromoQuest> I;
        private Provider<ReferralTrackerRepository> ISO8601Utils;
        private Provider<ThreadExecutor> ImageCaptureViewModel$getTipUploadPhoto$1;
        private Provider<UserInfoMapper> ImageCaptureViewModel$getTipUploadPhoto$2;
        private Provider<SaveShowDialog> ImageWithDescriptionView$showImage$1;
        private Provider<GoldSettingConfigRunner> InitSecurePreferenceAccount;
        private Provider<HomeWidgetClearable> InvestmentWalletAdapter;
        private Provider<FeatureView> J;
        private Provider<GetUserConfigProfileNewFlag> JsonParseException;
        private Provider<FeatureSplitBillPay> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ServicesPresenter> KeyEvent$DispatcherState;
        private Provider<ForceLogout> L;
        private Provider<SavingCategoryRepository> ListenerMethod;
        private Provider<FeatureSettingMore> M;
        private Provider<CardBindingRepository> MultiLanguageHttpClient;
        private Provider<CheckConsultFamilyAccount> MyBillsEntityDataFactory;
        private Provider<GenerateLinkRepository> N;
        private Provider<MyProfileContract.View> NavigationMenuPresenter$HeaderViewHolder;
        private Provider<SetBalanceVisibility> NearbyConstantsKt;
        private Provider<CheckFeatureInvestment> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ClearAllDanapolyData> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DanaPlusInvestmentPresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ClearKybData> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ContactRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<ClearAllFeedsUsecase> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ClearCachePayLaterLoanWhitelist> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<InitSavingCreate> NewMerchantCategoryAdapter;
        private Provider<GenerateProfileQrDeepLink> O;
        private Provider<GetTotalStatements> OtpRegistrationPresenter$input$1;
        private Provider<GetPromoCenterVersion> OtpRegistrationPresenter$input$2;
        private Provider<GetAddingNameWhitelistedMerchantId> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<GetBalanceContract.Presenter> PlaybackStateCompat$MediaKeyAction;
        private Provider<FeatureContract.Presenter> PrefetchDownloadStatus;
        private Provider<ClearFiles> PrepareContext;
        private Provider<GoldInvestmentPresenter> PromoCategoryPresenter$1;
        private Provider<GenerateReferralDeepLink> Q;
        private Provider<GetFavoriteServiceRemote> QrExpiredActivity;
        private Provider<GetAllStatementDetail> R;
        private Provider<GetWhitelistedSubMerchantId> ReferralMapper_Factory;
        private Provider<WalletConfigRepository> RepaymentPlan;
        private Provider<GetSingleBalance> RequestMoneyQrContract$View;
        private Provider<UserStatementPresenter> ResourceResponseInfo;
        private Provider<GetAuthCode> S;
        private Provider<DanaPlusContract.View> SchedulerPoolFactory;
        private Provider<OauthView> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<OauthRepository> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<GlobalNetworkRepository> SendMoneyScenario;
        private Provider<UserStatementRepository> SightCameraView$ICameraFrameListener;
        private Provider<GetRequestMoneyInfoFeature> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<PayerModelListMapper> f5863x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<PromoQuestRepository> f5864x461046da;
        private Provider<RestoreUrl> SplitReferralConfigEntityData_Factory;
        private Provider<GetStaticQrContract.View> SplitSavingConfigEntityData;
        private Provider<DeepLinkContract.View> StandardRowSortedTable$1;
        private Provider<DeepLinkPayloadModelMapper> SubSequence;
        private Provider<GoldInvestmentContract.View> SubmitReceiptResultModel$Creator;
        private Provider<GetAllBalanceVisibility> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetAllStatementSummary> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetAvatarUrl> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetCashierNativeConfig> T;
        private Provider<UpdatePayLaterLoanCache> TimeoutError;
        private Provider<InvestmentRepository> TrackerKey$GlobalSearchOpenProperties;
        private Provider<UserSecurityQuestionStateRepository> TrustRiskLogin$Params;
        private Provider<RestoreUrlPresenter> TwilioRepository;
        private Provider<GetIsCardBindingV2Enabled> TypeProjectionImpl;
        private Provider<PushVerifyTracker> TypeToken$TypeSet;
        private Provider<GetServicesByKey> TypefaceCompatApi26Impl;
        private Provider<GetBottomSheetOnBoarding> U;
        private Provider<GoldInvestmentContract.Presenter> UnicastProcessor$UnicastQueueSubscription;
        private Provider<GetBalance> V;
        private Provider<DynamicUrlWrapper> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeatureCardBinding> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<FeedInitRepository> View$OnClickListener;
        private Provider<SettingRepository> ViewInputOtpBinding;
        private Provider<GetChatBotTimestamp> W;
        private Provider<BottomSheetOnBoardingContract.View> WithdrawSavedCardChannelView;
        private Provider<Logout> WrappedDrawableState;
        private Provider<GetBalanceVisibility> X;
        private Provider<GetCountRecurringSubscription> Y;
        private Provider<GetDanaHomeBalanceConfig> Z;

        /* renamed from: a */
        private Provider<GetEmptyUserInfo> f8136a;
        private Provider<GetUserStatusInfo> access$getCapacity$p;
        private Provider<RegistrationRepository> access$getFeaturedBankListAdapter$p;
        private Provider<SavingPresenter> access$getServiceItemDecorator$p;
        private Provider<IsOfflineF2FPay> access$setShowcaseShowing$p;
        private Provider<StopOfflinePay> access$showKycAmlEddDialog;
        private Provider<GetPayLaterCacheLoanWhitelist> access$throwIllegalArgumentType;
        private Provider<SavePaylaterRotationDelayTime> allowedTargets;
        private Provider<PayAssetRepository> applyTrimPathIfNeeded;
        private Provider<GetEnableAddNewCard> b;
        private Provider<GetFavoriteServiceWithCacheFirst> c;
        private Provider<UserStatementContract.Presenter> checkMarmotConfig;
        private Provider<RestoreUrlContract.Presenter> checkParameterIsNotNull;
        private Provider<GetUserLoanInfo> checkRegisteredUserAndSendOtp;
        private Provider<GetMerchantQrWhitelist> connectForeground;
        private Provider<ReferralSettingConfigRunner> connectionSpecs;
        private Provider<PostExecutionThread> containsObjectForKey;
        private Provider<ScanQrContract.Presenter> createJavaMethod;
        private Provider<ShortenerRepository> createSecondaryAnimatorProvider;
        private Provider<GetDefaultServiceWithCategory> d;
        private Provider<RestoreUrlContract.View> doCommonLog;
        private Provider<GetFeedConfig> e;
        private final MyProfileModule encodingStream;
        private Provider<GetLastHideRedDotTimestamp> f;
        private Provider<GetDecodeTciCoListConfig> flip;
        private Provider<QrPayRepository> flow;
        private Provider<ReferralRepository> fromContextOrNull;
        private Provider<GetFavoriteServices> g;
        private Provider<BottomSheetOnBoardingPresenter> getAuthRequestContext;
        private Provider<DanaSessionManager> getCallingPid;
        private Provider<GetStatementSummary> getCardNumberOCR;
        private Provider<GetUpdateAvailability> getContainerAuth;
        private Provider<GetUserInfoWithKyc> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<FeedsConfigRepository> getExceptionOrNull;
        private Provider<KybRepository> getFontAssetManager;
        private Provider<UploadFilesRepository> getGnBenefitEntityDanaProtection;
        private Provider<GetUserInvestmentSummary> getIndexName;
        private Provider<FeatureSplitBill> getNameOrBuilderList;
        private Provider<RestoreUrlView> getNrCsiRsrp;
        private Provider<SaveProfileNewFlagUserConfig> getNrCsiRsrq;
        private Provider<FeatureOauth> getOnBoardingScenario;
        private Provider<PaylaterRepository> getOpPackageName;
        private Provider<DanapolyClearRepository> getPhoneMask;
        private Provider<MixpanelDeeplinkTracker> getRawPath;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> getReadyFragment;
        private Provider<InvestmentContract.Presenter> getRecommendationData;
        private Provider<RemoveDeepLinkPayload> getSavingConfigPresenter;
        private Provider<ServicesContract.View> getStackFromEnd;
        private Provider<DanaPlusSettingConfigRunner> getSupportButtonTintMode;
        private Provider<MyReferralConsultRepository> getTextEndPadding;
        private Provider<QueryPayMethod> getTypeMappings;
        private Provider<FeatureFamilyAccount> getValueOfTouchPositionAbsolute;

        /* renamed from: getWalletV3RecommendationConfig$lambda-193 */
        private Provider<ScanQrContract.View> f5865getWalletV3RecommendationConfig$lambda193;
        private Provider<OauthContract.View> glVertexAttrib1fv;
        private Provider<GetNickname> h;
        private Provider<GetMissionDetail> i;
        private Provider<SavingRepository> indexOfAny;
        private Provider<GetServicesWithCategory> initAnimators;
        private Provider<CheckMyBillsVersionConfig> initRecordTimeStamp;
        private Provider<IsNeedToShowToolTip> insertActivities;
        private Provider<UserStatementContract.View> isAllowRetry;
        private Provider<GetBalancePresenter> isAuth;
        private Provider<GetDecodedQrBarcode> isAuto;
        private final NewMyProfileComponentImpl isInfoWindowShown;
        private Provider<ClearCacheFavoriteServices> isLayoutRequested;
        private Provider<IsOfflinePayInitialized> isRegionMiniProgram;
        private Provider<GenerateDeepLinkContract.ProfilePresenter> isTmpDetached;
        private Provider<UserEducationRepository> itemClicked$core;
        private Provider<GetPayLaterLoanStatusWhitelist> j;
        private Provider<GetProfileCompletionData> k;
        private Provider<GetPayerSplitBillDetail> l;
        private Provider<CheckDeepLinkActionVisibility> lookAheadTest;
        private Provider<GetPaylaterRotationDelayTime> m;
        private Provider<CheckGoalsBalanceFeature> moveToNextValue;
        private Provider<OauthContract.Presenter> murmurHash64WithSeed;
        private Provider<GetProfileCompletionVisibility> n;
        private Provider<ClearAllSyncEngineUseCase> newProxyInstance;

        /* renamed from: o */
        private Provider<GetQrisCpmSendmoneyConfig> f8137o;
        private Provider<GetUserDynamicQr> onDecodeSuccess;
        private Provider<SplitBillHistoryToSplitBillModelMapper> onGetActiveNotifications;
        private Provider<SaveShowToolTip> onLayoutDirectionChanged;
        private Provider<InvestmentContract.View> onPolygonsChanged;
        private Provider<QueryPayMethodContract.Presenter> onTooManyRedirects;
        private Provider<GetStaticQrContract.Presenter> outerType;
        private Provider<GetQrBindingConfig> p;
        private Provider<UserEmailAddressRepository> parametersAsMap;
        private Provider<GetReferralTracker> q;
        private Provider<GetRawServices> r;
        private Provider<DanaPlusStarAmSettingConfigRunner> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<GetUserStaticQr> f5866reduceIndexedz1zDJgo;
        private Provider<ReadLinkPropertiesPresenter> removeFloat;
        private Provider<InitOfflinePay> retainOrRemoveAllInternal;
        private Provider<LoginRepository> rotateTo;
        private Provider<SaveLastHideRedDotTimestamp> roundToPowerOfTwo;
        private Provider<GetReferralConsult> s;
        private Provider<ThirdPartyServicesMapper> saveNickname;
        private Provider<CheckFeatureDownloadStatement> scheduleImpl;
        private Provider<GetUserId> secondaryHash;
        private Provider<SaveDisplayBottomSheetOnBoarding> setAkuEntranceOpen;
        private Provider<QueryPayMethodContract.View> setIndex$kotlin_stdlib;
        private Provider<UserConsentRepository> setMatchingBeaconTypeCode;
        private Provider<GetSettingByKey> setNetAuthId;
        private Provider<SetPayLaterLoanCache> setRibbonLineTopText;
        private Provider<GenerateDeepLinkContract.ProfileView> setValuePrefixBytes;
        private Provider<GetDecodedQrisTopUp> shouldRecycleViewType;
        private Provider<ReadLinkPropertiesContract.Presenter> storeUserConfig;
        private Provider<GetSavingEmptyState> t;
        private Provider<SplitBillRepository> targetValue;
        private Provider<GetSavingSummary> u;
        private Provider<MyReferralConsultMapper> useDaemonThreadFactory;
        private Provider<GetServicesByName> v;
        private Provider<GetStaticQrPresenter> verifyNotNull;
        private Provider<GetService> w;
        private Provider<DanaPlusPresenter> whenAvailable;
        private Provider<GetServiceHighlighted> x;
        private Provider<GetSettingCollection> y;
        private Provider<GetSplitBillConfig> z;

        public /* synthetic */ NewMyProfileComponentImpl(MyProfileModule myProfileModule, GetBalanceModule getBalanceModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, QueryPayMethodModule queryPayMethodModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, UserStatementModule userStatementModule, SavingModule savingModule, InvestmentModule investmentModule, GoldInvestmentModule goldInvestmentModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PayLaterModule payLaterModule, DanaPlusModule danaPlusModule, ApplicationComponent applicationComponent, byte b) {
            this(myProfileModule, getBalanceModule, getStaticQrModule, generateDeepLinkModule, queryPayMethodModule, bottomSheetOnBoardingModule, userStatementModule, savingModule, investmentModule, goldInvestmentModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, payLaterModule, danaPlusModule, applicationComponent);
        }

        private NewMyProfileComponentImpl(MyProfileModule myProfileModule, GetBalanceModule getBalanceModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, QueryPayMethodModule queryPayMethodModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, UserStatementModule userStatementModule, SavingModule savingModule, InvestmentModule investmentModule, GoldInvestmentModule goldInvestmentModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PayLaterModule payLaterModule, DanaPlusModule danaPlusModule, ApplicationComponent applicationComponent) {
            ApiHitTimer_Factory apiHitTimer_Factory;
            ApiHitTimer_Factory apiHitTimer_Factory2;
            PayCardInfoMapper_Factory payCardInfoMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.isInfoWindowShown = this;
            this.PlaceComponentResult = applicationComponent;
            this.encodingStream = myProfileModule;
            this.ArrayTable$3 = payLaterModule;
            this.EmergencyNotifActivity$getEmergencyNotifModule$1 = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvideViewFactory.MyBillsEntityDataFactory(getBalanceModule));
            this.ImageCaptureViewModel$getTipUploadPhoto$1 = new ThreadExecutorProvider(applicationComponent);
            this.containsObjectForKey = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider = userRepositoryProvider;
            this.V = GetBalance_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, userRepositoryProvider);
            this.RequestMoneyQrContract$View = GetSingleBalance_Factory.create(this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.X = GetBalanceVisibility_Factory.create(accountRepositoryProvider);
            this.NearbyConstantsKt = SetBalanceVisibility_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetAllBalanceVisibility_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.Z = GetDanaHomeBalanceConfig_Factory.create(this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.TrackerKey$GlobalSearchOpenProperties = provideInvestmentRepositoryProvider;
            this.getIndexName = GetUserInvestmentSummary_Factory.create(provideInvestmentRepositoryProvider);
            Provider<GetBalancePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GetBalancePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.EmergencyNotifActivity$getEmergencyNotifModule$1, this.V, this.RequestMoneyQrContract$View, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.X, this.NearbyConstantsKt, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.Z, this.getIndexName));
            this.isAuth = authRequestContext;
            this.PlaybackStateCompat$MediaKeyAction = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvidePresenterFactory.getAuthRequestContext(getBalanceModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new ContextProvider(applicationComponent);
            this.SplitSavingConfigEntityData = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvideViewFactory.MyBillsEntityDataFactory(getStaticQrModule));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.AppCategory = qrBarcodeRepositoryProvider;
            this.f5866reduceIndexedz1zDJgo = GetUserStaticQr_Factory.create(qrBarcodeRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.D = featureConfigRepositoryProvider;
            this.onDecodeSuccess = GetUserDynamicQr_Factory.create(this.AppCategory, featureConfigRepositoryProvider);
            GetQrisTcicoConfig_Factory create = GetQrisTcicoConfig_Factory.create(this.D);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = create;
            Provider<Context> provider = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Provider<GetStaticQrContract.View> provider2 = this.SplitSavingConfigEntityData;
            Provider<GetUserStaticQr> provider3 = this.f5866reduceIndexedz1zDJgo;
            Provider<GetUserDynamicQr> provider4 = this.onDecodeSuccess;
            apiHitTimer_Factory = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<GetStaticQrPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(GetStaticQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(provider, provider2, provider3, provider4, create, apiHitTimer_Factory));
            this.verifyNotNull = authRequestContext2;
            this.outerType = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvidePresenterFactory.PlaceComponentResult(getStaticQrModule, authRequestContext2));
            this.isAllowRetry = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvideViewFactory.getAuthRequestContext(userStatementModule));
            UserStatementRepositoryProvider userStatementRepositoryProvider = new UserStatementRepositoryProvider(applicationComponent);
            this.SightCameraView$ICameraFrameListener = userStatementRepositoryProvider;
            this.getCardNumberOCR = GetStatementSummary_Factory.create(userStatementRepositoryProvider);
            this.FlowableCreate$BufferAsyncEmitter = GetStatementDetail_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetAllStatementSummary_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.OtpRegistrationPresenter$input$1 = GetTotalStatements_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.R = GetAllStatementDetail_Factory.create(this.SightCameraView$ICameraFrameListener);
            this.scheduleImpl = CheckFeatureDownloadStatement_Factory.create(this.D);
            GetStatementDisableDetail_Factory create2 = GetStatementDisableDetail_Factory.create(this.D);
            this.FlowableReduce$ReduceSubscriber = create2;
            Provider<UserStatementPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(UserStatementPresenter_Factory.getAuthRequestContext(this.isAllowRetry, this.getCardNumberOCR, this.FlowableCreate$BufferAsyncEmitter, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.OtpRegistrationPresenter$input$1, this.R, this.scheduleImpl, create2));
            this.ResourceResponseInfo = authRequestContext3;
            this.checkMarmotConfig = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(userStatementModule, authRequestContext3));
            this.NavigationMenuPresenter$HeaderViewHolder = MyProfileModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(myProfileModule);
            this.ImageCaptureViewModel$getTipUploadPhoto$2 = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.GetExpressPurchaseResponse$PriceEntity = UploadAvatar_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.BuiltInFictitiousFunctionClassFactory);
            this.B = new DeviceInformationProviderProvider(applicationComponent);
            this.rotateTo = new LoginRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.InvestmentWalletAdapter = provideHomeWidgetClearableProvider;
            this.L = ForceLogout_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.rotateTo, this.SendMoneyScenario, provideHomeWidgetClearableProvider);
            this.WrappedDrawableState = Logout_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.rotateTo, this.InvestmentWalletAdapter, this.SendMoneyScenario);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = contractRepositoryProvider;
            this.newProxyInstance = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.View$OnClickListener = provideFeedInitRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.CacheBuilderSpec$AccessDurationParser = servicesRepositoryProvider;
            this.isLayoutRequested = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.getPhoneMask = provideDanapolyClearRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.getFontAssetManager = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext4 = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext4;
            this.getCallingPid = DanaSessionManager_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.B, this.L, this.WrappedDrawableState, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda1, authRequestContext4);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.itemClicked$core = userEducationRepositoryProvider;
            this.insertActivities = IsNeedToShowToolTip_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, userEducationRepositoryProvider);
            this.onLayoutDirectionChanged = SaveShowToolTip_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.itemClicked$core);
            this.A = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.ContentDeliveryCacheEntityDataFactory = new TwilioEnrollmentEligibilityRepositoryProvider(applicationComponent);
            this.parametersAsMap = new UserEmailAddressRepositoryProvider(applicationComponent);
            UserSecurityQuestionStateRepositoryProvider userSecurityQuestionStateRepositoryProvider = new UserSecurityQuestionStateRepositoryProvider(applicationComponent);
            this.TrustRiskLogin$Params = userSecurityQuestionStateRepositoryProvider;
            this.k = GetProfileCompletionData_Factory.create(this.A, this.ContentDeliveryCacheEntityDataFactory, this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider, this.parametersAsMap, userSecurityQuestionStateRepositoryProvider);
            this.n = GetProfileCompletionVisibility_Factory.create(this.D);
            this.DatabaseTableConfigUtil = CheckUsernameConfig_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.D);
            this.getDefaultSenderId = GetUserInfoWithKyc_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetAvatarUrl_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.BuiltInFictitiousFunctionClassFactory);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.ViewInputOtpBinding = settingRepositoryProvider;
            this.y = GetSettingCollection_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, settingRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = CheckShowReferralCodeFeature_Factory.create(this.D);
            this.useDaemonThreadFactory = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.FlowableConcatMapEagerPublisher = KybSettingConfigRunner_Factory.getAuthRequestContext(this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.ImageCaptureViewModel$getTipUploadPhoto$2);
            this.N = new GenerateLinkRepositoryProvider(applicationComponent);
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.getTextEndPadding = myReferralConsultRepositoryProvider;
            this.connectionSpecs = ReferralSettingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.N, myReferralConsultRepositoryProvider);
            this.getSupportButtonTintMode = DanaPlusSettingConfigRunner_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getIndexName);
            this.readMicros = DanaPlusStarAmSettingConfigRunner_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getIndexName);
            this.InitSecurePreferenceAccount = GoldSettingConfigRunner_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getIndexName);
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.fromContextOrNull = referralRepositoryProvider;
            this.CreateRemoteWorkerExtension = SaveReferralEngagementDialogCache_Factory.create(referralRepositoryProvider);
            this.E = FamilyAccountSettingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = provideFamilyAccountRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            ProvideUploadFilesRepositoryProvider provideUploadFilesRepositoryProvider = new ProvideUploadFilesRepositoryProvider(applicationComponent);
            this.getGnBenefitEntityDanaProtection = provideUploadFilesRepositoryProvider;
            this.PrepareContext = ClearFiles_Factory.create(provideUploadFilesRepositoryProvider);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.RepaymentPlan = provideWalletConfigRepositoryProvider;
            this.ApiStatus$AvailableSince = GetWalletConfigFromLocal_Factory.create(provideWalletConfigRepositoryProvider);
            ReferralTrackerRepositoryProvider referralTrackerRepositoryProvider = new ReferralTrackerRepositoryProvider(applicationComponent);
            this.ISO8601Utils = referralTrackerRepositoryProvider;
            this.q = GetReferralTracker_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, referralTrackerRepositoryProvider);
            this.JsonParseException = GetUserConfigProfileNewFlag_Factory.create(this.ViewInputOtpBinding);
            this.getNrCsiRsrq = SaveProfileNewFlagUserConfig_Factory.create(this.ViewInputOtpBinding);
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.C = deepLinkRepositoryProvider;
            this.getSavingConfigPresenter = RemoveDeepLinkPayload_Factory.create(deepLinkRepositoryProvider);
            ProvideRecurringSubscriptionRepositoryProvider provideRecurringSubscriptionRepositoryProvider = new ProvideRecurringSubscriptionRepositoryProvider(applicationComponent);
            this.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0 = provideRecurringSubscriptionRepositoryProvider;
            this.Y = GetCountRecurringSubscription_Factory.create(provideRecurringSubscriptionRepositoryProvider);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = liteAccountRepositoryProvider;
            this.secondaryHash = GetUserId_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, liteAccountRepositoryProvider);
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.access$getFeaturedBankListAdapter$p = registrationRepositoryProvider;
            this.W = GetChatBotTimestamp_Factory.create(registrationRepositoryProvider);
            this.f = GetLastHideRedDotTimestamp_Factory.create(this.ViewInputOtpBinding);
            this.roundToPowerOfTwo = SaveLastHideRedDotTimestamp_Factory.create(this.ViewInputOtpBinding);
            this.w = GetService_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.O = GenerateProfileQrDeepLink_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.N);
            Provider<GenerateDeepLinkContract.ProfileView> authRequestContext5 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfileViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.setValuePrefixBytes = authRequestContext5;
            Provider<Context> provider5 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Provider<GenerateProfileQrDeepLink> provider6 = this.O;
            apiHitTimer_Factory2 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<ProfileQrDeepLinkPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(ProfileQrDeepLinkPresenter_Factory.PlaceComponentResult(provider5, provider6, authRequestContext5, apiHitTimer_Factory2));
            this.ArrayTable$1 = authRequestContext6;
            this.isTmpDetached = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfilePresenterFactory.PlaceComponentResult(generateDeepLinkModule, authRequestContext6));
            this.setIndex$kotlin_stdlib = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(queryPayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.applyTrimPathIfNeeded = payAssetRepositoryProvider;
            this.b = GetEnableAddNewCard_Factory.create(payAssetRepositoryProvider);
            this.getTypeMappings = QueryPayMethod_Factory.create(this.applyTrimPathIfNeeded);
            this.access$setShowcaseShowing$p = IsOfflineF2FPay_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.D);
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.flow = qrPayRepositoryProvider;
            this.retainOrRemoveAllInternal = InitOfflinePay_Factory.create(qrPayRepositoryProvider);
            this.access$showKycAmlEddDialog = StopOfflinePay_Factory.create(this.flow);
            this.isRegionMiniProgram = IsOfflinePayInitialized_Factory.create(this.flow);
            this.FlowViewUtil$textChanges$2 = GetPayCardConfig_Factory.create(this.D, this.applyTrimPathIfNeeded);
            Provider<QueryPayMethodContract.View> provider7 = this.setIndex$kotlin_stdlib;
            Provider<GetEnableAddNewCard> provider8 = this.b;
            Provider<QueryPayMethod> provider9 = this.getTypeMappings;
            payCardInfoMapper_Factory = PayCardInfoMapper_Factory.InstanceHolder.BuiltInFictitiousFunctionClassFactory;
            Provider<QueryPayMethodPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(QueryPayMethodPresenter_Factory.MyBillsEntityDataFactory(provider7, provider8, provider9, payCardInfoMapper_Factory, this.access$setShowcaseShowing$p, this.retainOrRemoveAllInternal, this.B, this.access$showKycAmlEddDialog, this.isRegionMiniProgram, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.FlowViewUtil$textChanges$2));
            this.GetTopUpUserConsult = authRequestContext7;
            this.onTooManyRedirects = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(queryPayMethodModule, authRequestContext7));
            this.WithdrawSavedCardChannelView = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.U = GetBottomSheetOnBoarding_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.itemClicked$core);
            SaveDisplayBottomSheetOnBoarding_Factory create3 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.itemClicked$core);
            this.setAkuEntranceOpen = create3;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.WithdrawSavedCardChannelView, this.U, create3);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingViewFactory.MyBillsEntityDataFactory(savingModule));
            this.indexOfAny = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.ListenerMethod = savingCategoryRepositoryProvider;
            this.u = GetSavingSummary_Factory.create(this.indexOfAny, savingCategoryRepositoryProvider);
            this.NewMerchantCategoryAdapter = InitSavingCreate_Factory.create(this.indexOfAny, this.ListenerMethod);
            this.moveToNextValue = CheckGoalsBalanceFeature_Factory.create(this.D);
            GetSavingEmptyState_Factory create4 = GetSavingEmptyState_Factory.create(this.indexOfAny);
            this.t = create4;
            Provider<SavingPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(SavingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl, this.u, this.getDefaultSenderId, this.NewMerchantCategoryAdapter, this.moveToNextValue, create4));
            this.access$getServiceItemDecorator$p = authRequestContext8;
            this.f5862$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingPresenterFactory.BuiltInFictitiousFunctionClassFactory(savingModule, authRequestContext8));
            this.onPolygonsChanged = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(investmentModule));
            CheckFeatureInvestment_Factory create5 = CheckFeatureInvestment_Factory.create(this.D);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create5;
            Provider<DanaPlusInvestmentPresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(DanaPlusInvestmentPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.onPolygonsChanged, create5, this.getIndexName));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext9;
            this.getRecommendationData = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentPresenterFactory.PlaceComponentResult(investmentModule, authRequestContext9));
            Provider<GoldInvestmentContract.View> authRequestContext10 = DoubleCheck.getAuthRequestContext(GoldInvestmentModule_ProvideView$app_productionReleaseFactory.getAuthRequestContext(goldInvestmentModule));
            this.SubmitReceiptResultModel$Creator = authRequestContext10;
            Provider<GoldInvestmentPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(GoldInvestmentPresenter_Factory.PlaceComponentResult(authRequestContext10, this.getIndexName));
            this.PromoCategoryPresenter$1 = authRequestContext11;
            this.UnicastProcessor$UnicastQueueSubscription = DoubleCheck.getAuthRequestContext(GoldInvestmentModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(goldInvestmentModule, authRequestContext11));
            Provider<Activity> authRequestContext12 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.ArrayTable$2 = authRequestContext12;
            Provider<ScanQrView> authRequestContext13 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext12));
            this.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider = authRequestContext13;
            this.f5865getWalletV3RecommendationConfig$lambda193 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext13));
            this.isAuto = GetDecodedQrBarcode_Factory.create(this.AppCategory);
            this.shouldRecycleViewType = GetDecodedQrisTopUp_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.AppCategory);
            this.FamilyManageAvailableServicesAdapter = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.access$getCapacity$p = GetUserStatusInfo_Factory.create(this.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider);
            this.T = GetCashierNativeConfig_Factory.create(this.D);
            this.FlowableKt$toIterable$1 = IsNativeDecodeEnabled_Factory.create(this.D);
            GetDecodeTciCoListConfig_Factory create6 = GetDecodeTciCoListConfig_Factory.create(this.D);
            this.flip = create6;
            this.DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider = ValidateNativelyDecodedQr_Factory.create(create6);
            this.connectForeground = GetMerchantQrWhitelist_Factory.create(this.AppCategory);
            this.p = GetQrBindingConfig_Factory.create(this.D);
            this.getReadyFragment = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.D);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.getOpPackageName = providePaylaterRepositoryProvider;
            this.checkRegisteredUserAndSendOtp = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.f8137o = GetQrisCpmSendmoneyConfig_Factory.create(this.D, this.itemClicked$core);
            this.ImageWithDescriptionView$showImage$1 = SaveShowDialog_Factory.create(this.itemClicked$core);
            Provider<ScanQrPresenter> authRequestContext14 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.f5865getWalletV3RecommendationConfig$lambda193, this.isAuto, this.shouldRecycleViewType, this.FamilyManageAvailableServicesAdapter, this.B, this.access$getCapacity$p, this.T, GetNativelyDecodedQr_Factory.create(), this.FlowableKt$toIterable$1, this.DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider, this.connectForeground, this.p, this.getReadyFragment, this.checkRegisteredUserAndSendOtp, this.f8137o, this.ImageWithDescriptionView$showImage$1));
            this.CreateOrderTopUpFamilyBalance = authRequestContext14;
            this.createJavaMethod = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext14));
            Provider<RestoreUrlView> authRequestContext15 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.getNrCsiRsrp = authRequestContext15;
            this.doCommonLog = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext15));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.createSecondaryAnimatorProvider = shortenerRepositoryProvider;
            RestoreUrl_Factory create7 = RestoreUrl_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, shortenerRepositoryProvider);
            this.SplitReferralConfigEntityData_Factory = create7;
            Provider<RestoreUrlPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.doCommonLog, create7));
            this.TwilioRepository = authRequestContext16;
            this.checkParameterIsNotNull = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext16));
            this.s = GetReferralConsult_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.getTextEndPadding);
            this.Q = GenerateReferralDeepLink_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.N);
            this.setNetAuthId = GetSettingByKey_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.ViewInputOtpBinding);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.CheckPromoQuestFeature = productPageManagerProvider;
            this.M = FeatureSettingMore_Factory.PlaceComponentResult(this.setNetAuthId, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.targetValue = splitBillRepositoryProvider;
            this.l = GetPayerSplitBillDetail_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, splitBillRepositoryProvider);
            this.f5863x461046d9 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.f5863x461046d9);
            this.onGetActiveNotifications = PlaceComponentResult;
            this.K = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.l, PlaceComponentResult);
            this.z = GetSplitBillConfig_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.D);
            GetRequestMoneyInfoFeature_Factory create8 = GetRequestMoneyInfoFeature_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.D);
            this.SizeSelectors$OrSelector = create8;
            Provider<GetSplitBillConfig> provider10 = this.z;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getNameOrBuilderList = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider10, create8, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.f5864x461046da = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create9 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.i = create9;
            this.I = FeaturePromoQuest_Factory.getAuthRequestContext(create9, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.AppCompatEmojiTextHelper = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.getRawPath = MyBillsEntityDataFactory;
            this.getOnBoardingScenario = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = dynamicUrlWrapperProvider;
            this.getValueOfTouchPositionAbsolute = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.MultiLanguageHttpClient = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory2 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.TypeProjectionImpl = BuiltInFictitiousFunctionClassFactory2;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            this.H = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.getRawPath));
            Provider<FeatureView> authRequestContext17 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.s, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.useDaemonThreadFactory, this.Q, this.M, this.K, this.getNameOrBuilderList, this.I, this.AppCompatEmojiTextHelper, this.FragmentBottomSheetPaymentSettingBinding, FeatureHome_Factory.MyBillsEntityDataFactory(), this.getOnBoardingScenario, FeatureKyb_Factory.getAuthRequestContext(), this.getValueOfTouchPositionAbsolute, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.checkRegisteredUserAndSendOtp, FeatureMyBills_Factory.PlaceComponentResult(), this.H));
            this.J = authRequestContext17;
            this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext17));
            this.TypefaceCompatApi26Impl = GetServicesByKey_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.CacheBuilderSpec$AccessDurationParser);
            ServiceCategoryMapper_Factory authRequestContext18 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.f5861$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0 = authRequestContext18;
            this.saveNickname = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext18);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.setMatchingBeaconTypeCode = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create10 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.f8136a = create10;
            GetAuthCode_Factory create11 = GetAuthCode_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, create10);
            this.S = create11;
            this.F = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider, this.TypefaceCompatApi26Impl, this.saveNickname, create11, this.B));
            this.lookAheadTest = CheckDeepLinkActionVisibility_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.D);
            this.GetContactSyncConfig = CheckWhitelistedValidDomain_Factory.create(this.D);
            this.FlowViewUtil$textChanges$1 = GetNearbyConfig_Factory.create(this.D);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.getExceptionOrNull = provideFeedsConfigRepositoryProvider;
            this.e = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.OtpRegistrationPresenter$input$2 = GetPromoCenterVersion_Factory.create(this.D);
            this.getContainerAuth = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.initRecordTimeStamp = CheckMyBillsVersionConfig_Factory.create(this.D);
            ProvidePushVerifyTrackerProvider providePushVerifyTrackerProvider = new ProvidePushVerifyTrackerProvider(applicationComponent);
            this.TypeToken$TypeSet = providePushVerifyTrackerProvider;
            Provider<FeaturePresenter> authRequestContext19 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider, this.F, this.lookAheadTest, this.GetContactSyncConfig, this.FlowViewUtil$textChanges$1, this.e, this.OtpRegistrationPresenter$input$2, this.getContainerAuth, this.initRecordTimeStamp, providePushVerifyTrackerProvider, this.w));
            this.G = authRequestContext19;
            this.PrefetchDownloadStatus = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext19));
            OauthView_Factory authRequestContext20 = OauthView_Factory.getAuthRequestContext(this.getOnBoardingScenario);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = authRequestContext20;
            this.glVertexAttrib1fv = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext20));
            this.FillAnimation = GetKycLevel_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.h = GetNickname_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.BuiltInFictitiousFunctionClassFactory);
            this.ReferralMapper_Factory = GetWhitelistedSubMerchantId_Factory.create(this.D);
            this.P = GetAddingNameWhitelistedMerchantId_Factory.create(this.D);
            Provider<OauthContract.View> provider11 = this.glVertexAttrib1fv;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider11, oauthParamsModelMapper_Factory, this.FillAnimation, this.getDefaultSenderId, this.h, this.ReferralMapper_Factory, this.P);
            this.BaseSocialFeedContract$Presenter = KClassImpl$Data$declaredNonStaticMembers$2;
            this.murmurHash64WithSeed = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.getStackFromEnd = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.initAnimators = GetServicesWithCategory_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.d = GetDefaultServiceWithCategory_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.QrExpiredActivity = GetFavoriteServiceRemote_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.v = GetServicesByName_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.CacheBuilderSpec$AccessDurationParser);
            this.g = GetFavoriteServices_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey, this.CacheBuilderSpec$AccessDurationParser);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.D);
            this.r = GetRawServices_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.c = GetFavoriteServiceWithCacheFirst_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.x = GetServiceHighlighted_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            UpdateServiceHighlighted_Factory create12 = UpdateServiceHighlighted_Factory.create(this.CacheBuilderSpec$AccessDurationParser);
            this.FontsContractCompat$FontRequestCallback = create12;
            this.KeyEvent$DispatcherState = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getStackFromEnd, this.S, this.saveNickname, this.insertActivities, this.onLayoutDirectionChanged, this.initAnimators, this.d, this.QrExpiredActivity, this.v, this.TypefaceCompatApi26Impl, this.g, this.getErrorConfigVersion, this.r, this.c, this.x, create12));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext21 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.createJavaMethod, this.checkParameterIsNotNull, this.PrefetchDownloadStatus, this.murmurHash64WithSeed, this.KeyEvent$DispatcherState, applicationProvider, this.checkRegisteredUserAndSendOtp));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = authRequestContext21;
            this.StandardRowSortedTable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext21));
            this.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 = ReadDeepLinkProperties_Factory.create(this.ImageCaptureViewModel$getTipUploadPhoto$1, this.containsObjectForKey);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            DeepLinkPayloadModelMapper_Factory BuiltInFictitiousFunctionClassFactory3 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.SubSequence = BuiltInFictitiousFunctionClassFactory3;
            Provider<ReadLinkPropertiesPresenter> authRequestContext22 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.StandardRowSortedTable$1, this.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8, BuiltInFictitiousFunctionClassFactory3, this.secondaryHash, this.getRawPath));
            this.removeFloat = authRequestContext22;
            this.storeUserConfig = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext22));
            this.FamilyDashboardPresenter_Factory = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ClearCachePayLaterLoanWhitelist_Factory.create(this.getOpPackageName, this.CacheBuilderSpec$AccessDurationParser);
            this.access$throwIllegalArgumentType = GetPayLaterCacheLoanWhitelist_Factory.create(this.getOpPackageName);
            this.allowedTargets = SavePaylaterRotationDelayTime_Factory.create(this.getOpPackageName);
            this.m = GetPaylaterRotationDelayTime_Factory.create(this.getOpPackageName);
            this.j = GetPayLaterLoanStatusWhitelist_Factory.create(this.getOpPackageName);
            this.TimeoutError = UpdatePayLaterLoanCache_Factory.create(this.getOpPackageName, this.CacheBuilderSpec$AccessDurationParser);
            SetPayLaterLoanCache_Factory create13 = SetPayLaterLoanCache_Factory.create(this.getOpPackageName, this.CacheBuilderSpec$AccessDurationParser);
            this.setRibbonLineTopText = create13;
            this.ConcurrentKt = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.FamilyDashboardPresenter_Factory, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.access$throwIllegalArgumentType, this.checkRegisteredUserAndSendOtp, this.allowedTargets, this.m, this.j, this.TimeoutError, create13));
            Provider<DanaPlusContract.View> authRequestContext23 = DoubleCheck.getAuthRequestContext(DanaPlusModule_ProvideDanaPlusPresenterViewFactory.MyBillsEntityDataFactory(danaPlusModule));
            this.SchedulerPoolFactory = authRequestContext23;
            DanaPlusPresenter_Factory MyBillsEntityDataFactory2 = DanaPlusPresenter_Factory.MyBillsEntityDataFactory(authRequestContext23, this.getIndexName);
            this.whenAvailable = MyBillsEntityDataFactory2;
            this.DebugCoroutineInfoImpl = DoubleCheck.getAuthRequestContext(DanaPlusModule_ProvideDanaPlusPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(danaPlusModule, MyBillsEntityDataFactory2));
        }

        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.TypefaceCompatApi26Impl());
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
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SendMoneyScenario());
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
        public static final class UserStatementRepositoryProvider implements Provider<UserStatementRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserStatementRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserStatementRepository get() {
                return (UserStatementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.DebugCoroutineInfoImpl());
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
            private final ApplicationComponent PlaceComponentResult;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.G());
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
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.r());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.l());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.i());
            }
        }

        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent PlaceComponentResult;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ArrayTable$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentEligibilityRepositoryProvider implements Provider<TwilioEnrollmentEligibilityRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            TwilioEnrollmentEligibilityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioEnrollmentEligibilityRepository get() {
                return (TwilioEnrollmentEligibilityRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.mo2240x461046d9());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserEmailAddressRepositoryProvider implements Provider<UserEmailAddressRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserEmailAddressRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEmailAddressRepository get() {
                return (UserEmailAddressRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.mo2241x461046da());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserSecurityQuestionStateRepositoryProvider implements Provider<UserSecurityQuestionStateRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserSecurityQuestionStateRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserSecurityQuestionStateRepository get() {
                return (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneMask());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isInfoWindowShown());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent getAuthRequestContext;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.P());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ReferralRepositoryProvider implements Provider<ReferralRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ReferralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralRepository get() {
                return (ReferralRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NewMerchantCategoryAdapter());
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
        public static final class ProvideUploadFilesRepositoryProvider implements Provider<UploadFilesRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideUploadFilesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UploadFilesRepository get() {
                return (UploadFilesRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ApiStatus$AvailableSince());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideWalletConfigRepositoryProvider implements Provider<WalletConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideWalletConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ WalletConfigRepository get() {
                return (WalletConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getIndexName());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ReferralTrackerRepositoryProvider implements Provider<ReferralTrackerRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ReferralTrackerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralTrackerRepository get() {
                return (ReferralTrackerRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getReadyFragment());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideRecurringSubscriptionRepositoryProvider implements Provider<RecurringSubscriptionRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideRecurringSubscriptionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecurringSubscriptionRepository get() {
                return (RecurringSubscriptionRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.OtpRegistrationPresenter$input$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.AppCompatEmojiTextHelper());
            }
        }

        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.rotateTo());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.X());
            }
        }

        /* loaded from: classes4.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent getAuthRequestContext;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PromoCategoryPresenter$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.useDaemonThreadFactory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getTextEndPadding());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.setNetAuthId());
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
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.shouldRecycleViewType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ConcurrentKt());
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
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext());
            }
        }

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
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WithdrawSavedCardChannelView());
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
            private final ApplicationComponent PlaceComponentResult;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.PlaceComponentResult.FlowableCreate$BufferAsyncEmitter());
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

        @Override // id.dana.di.component.NewMyProfileComponent
        public final void MyBillsEntityDataFactory(NewMyProfileFragment newMyProfileFragment) {
            ReferralTrackerModelMapper_Factory referralTrackerModelMapper_Factory;
            newMyProfileFragment.getBalancePresenter = this.PlaybackStateCompat$MediaKeyAction.get();
            NewMyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, this.outerType.get());
            NewMyProfileFragment_MembersInjector.getAuthRequestContext(newMyProfileFragment, this.checkMarmotConfig.get());
            NewMyProfileFragment_MembersInjector.PlaceComponentResult(newMyProfileFragment, (ProductPageManager) Preconditions.PlaceComponentResult(this.PlaceComponentResult.shouldRecycleViewType()));
            MyProfileModule myProfileModule = this.encodingStream;
            Lazy MyBillsEntityDataFactory = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Lazy MyBillsEntityDataFactory2 = DoubleCheck.MyBillsEntityDataFactory(this.NavigationMenuPresenter$HeaderViewHolder);
            Lazy MyBillsEntityDataFactory3 = DoubleCheck.MyBillsEntityDataFactory(this.ImageCaptureViewModel$getTipUploadPhoto$2);
            Lazy MyBillsEntityDataFactory4 = DoubleCheck.MyBillsEntityDataFactory(this.GetExpressPurchaseResponse$PriceEntity);
            Lazy MyBillsEntityDataFactory5 = DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid);
            Lazy MyBillsEntityDataFactory6 = DoubleCheck.MyBillsEntityDataFactory(this.insertActivities);
            Lazy MyBillsEntityDataFactory7 = DoubleCheck.MyBillsEntityDataFactory(this.onLayoutDirectionChanged);
            Lazy MyBillsEntityDataFactory8 = DoubleCheck.MyBillsEntityDataFactory(this.k);
            Lazy MyBillsEntityDataFactory9 = DoubleCheck.MyBillsEntityDataFactory(this.n);
            Lazy MyBillsEntityDataFactory10 = DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
            Lazy MyBillsEntityDataFactory11 = DoubleCheck.MyBillsEntityDataFactory(this.getDefaultSenderId);
            Lazy MyBillsEntityDataFactory12 = DoubleCheck.MyBillsEntityDataFactory(this.SummaryVoucherView$$ExternalSyntheticLambda2);
            Lazy MyBillsEntityDataFactory13 = DoubleCheck.MyBillsEntityDataFactory(this.y);
            Lazy MyBillsEntityDataFactory14 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            Lazy MyBillsEntityDataFactory15 = DoubleCheck.MyBillsEntityDataFactory(this.useDaemonThreadFactory);
            Lazy MyBillsEntityDataFactory16 = DoubleCheck.MyBillsEntityDataFactory(this.FlowableConcatMapEagerPublisher);
            Lazy MyBillsEntityDataFactory17 = DoubleCheck.MyBillsEntityDataFactory(this.connectionSpecs);
            Lazy MyBillsEntityDataFactory18 = DoubleCheck.MyBillsEntityDataFactory(this.getSupportButtonTintMode);
            Lazy MyBillsEntityDataFactory19 = DoubleCheck.MyBillsEntityDataFactory(this.readMicros);
            Lazy MyBillsEntityDataFactory20 = DoubleCheck.MyBillsEntityDataFactory(this.InitSecurePreferenceAccount);
            Lazy MyBillsEntityDataFactory21 = DoubleCheck.MyBillsEntityDataFactory(this.CreateRemoteWorkerExtension);
            Lazy MyBillsEntityDataFactory22 = DoubleCheck.MyBillsEntityDataFactory(this.E);
            Lazy MyBillsEntityDataFactory23 = DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            Lazy MyBillsEntityDataFactory24 = DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext);
            Lazy MyBillsEntityDataFactory25 = DoubleCheck.MyBillsEntityDataFactory(this.ApiStatus$AvailableSince);
            Lazy MyBillsEntityDataFactory26 = DoubleCheck.MyBillsEntityDataFactory(this.q);
            referralTrackerModelMapper_Factory = ReferralTrackerModelMapper_Factory.InstanceHolder.getAuthRequestContext;
            NewMyProfileFragment_MembersInjector.MyBillsEntityDataFactory(newMyProfileFragment, MyProfileModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(myProfileModule, new MyProfilePresenter(MyBillsEntityDataFactory, MyBillsEntityDataFactory2, MyBillsEntityDataFactory3, MyBillsEntityDataFactory4, MyBillsEntityDataFactory5, MyBillsEntityDataFactory6, MyBillsEntityDataFactory7, MyBillsEntityDataFactory8, MyBillsEntityDataFactory9, MyBillsEntityDataFactory10, MyBillsEntityDataFactory11, MyBillsEntityDataFactory12, MyBillsEntityDataFactory13, MyBillsEntityDataFactory14, MyBillsEntityDataFactory15, MyBillsEntityDataFactory16, MyBillsEntityDataFactory17, MyBillsEntityDataFactory18, MyBillsEntityDataFactory19, MyBillsEntityDataFactory20, MyBillsEntityDataFactory21, MyBillsEntityDataFactory22, MyBillsEntityDataFactory23, MyBillsEntityDataFactory24, MyBillsEntityDataFactory25, MyBillsEntityDataFactory26, DoubleCheck.MyBillsEntityDataFactory(referralTrackerModelMapper_Factory), DoubleCheck.MyBillsEntityDataFactory(this.JsonParseException), DoubleCheck.MyBillsEntityDataFactory(this.getNrCsiRsrq), DoubleCheck.MyBillsEntityDataFactory(this.getSavingConfigPresenter), DoubleCheck.MyBillsEntityDataFactory(this.Y), DoubleCheck.MyBillsEntityDataFactory(this.secondaryHash), DoubleCheck.MyBillsEntityDataFactory(this.W), DoubleCheck.MyBillsEntityDataFactory(this.f), DoubleCheck.MyBillsEntityDataFactory(this.roundToPowerOfTwo), DoubleCheck.MyBillsEntityDataFactory(this.w))));
            NewMyProfileFragment_MembersInjector.PlaceComponentResult(newMyProfileFragment, this.isTmpDetached.get());
            NewMyProfileFragment_MembersInjector.PlaceComponentResult(newMyProfileFragment, this.onTooManyRedirects.get());
            NewMyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.get());
            NewMyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(newMyProfileFragment, this.f5862$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM.get());
            newMyProfileFragment.dynamicUrlWrapper = (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext());
            newMyProfileFragment.investmentPresenter = this.getRecommendationData.get();
            NewMyProfileFragment_MembersInjector.getAuthRequestContext(newMyProfileFragment, this.UnicastProcessor$UnicastQueueSubscription.get());
            newMyProfileFragment.readLinkPropertiesPresenter = this.storeUserConfig.get();
            NewMyProfileFragment_MembersInjector.MyBillsEntityDataFactory(newMyProfileFragment, PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.ArrayTable$3, this.ConcurrentKt.get()));
            newMyProfileFragment.danaPlusPresenter = this.DebugCoroutineInfoImpl.get();
        }
    }
}
