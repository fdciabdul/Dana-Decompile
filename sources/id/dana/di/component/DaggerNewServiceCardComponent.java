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
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.tracker.HomeTrackerImpl_Factory;
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
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterModule_ProvideView$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterPresenter;
import id.dana.contract.paylater.PayLaterPresenter_Factory;
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
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaCustomH5_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.GlobalNetworkModule_ProvidesPresenterFactory;
import id.dana.di.modules.GlobalNetworkModule_ProvidesViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.account.interactor.GetNickname_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility_Factory;
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
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
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
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.domain.version.interactor.GetUpdateAvailability_Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter_Factory;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker_Factory;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.h5event.CheckoutH5EventPresenter_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.richview.servicescard.ServiceCardV2View;
import id.dana.richview.servicescard.ServiceCardV2View_MembersInjector;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNewServiceCardComponent {
    private DaggerNewServiceCardComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FeatureModule BuiltInFictitiousFunctionClassFactory;
        public CheckoutH5EventModule KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public PayLaterModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public DeepLinkModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public OauthModule lookAheadTest;
        public GlobalNetworkModule moveToNextValue;
        public PlayStoreReviewModules scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewServiceCardComponentImpl implements NewServiceCardComponent {
        private Provider<FeatureView> A;
        private Provider<PayLaterContract.Presenter> ApiStatus$AvailableSince;
        private Provider<GetDecodeTciCoListConfig> AppCompatEmojiTextHelper;
        private Provider<ServiceCategoryMapper> ArrayTable$1;
        private Provider<ScanResultMapper> ArrayTable$2;
        private Provider<SaveShowToolTip> ArrayTable$3;
        private Provider<GenerateReferralDeepLink> B;
        private Provider<SettingRepository> BannerEntityDataFactory_Factory;
        private Provider<SaveLastPlayStoreReviewShow> BaseSocialFeedContract$Presenter;
        private Provider<FeatureSplitBill> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private Provider<FeatureContract.View> CYFMonitor$ChallengeActionCallback;
        private Provider<SavePaylaterRotationDelayTime> CheckPromoQuestFeature;
        private Provider<SaveShowDialog> ConcurrentKt;
        private Provider<GetBottomSheetOnBoarding> D;
        private Provider<LiteAccountRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<Context> DatabaseTableConfigUtil;
        private Provider<SplitBillHistoryToSplitBillModelMapper> DebugCoroutineInfoImpl;
        private Provider<GetAddingNameWhitelistedMerchantId> E;
        private Provider<GetDefaultServiceWithCategory> F;
        private Provider<GetUserStatusInfo> FillAnimation;
        private Provider<ServicesRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<H5EventRepository> FlowViewUtil$textChanges$1;
        private Provider<GetWalletOauth> FlowViewUtil$textChanges$2;
        private Provider<GlobalNetworkContract.Presenter> FlowableConcatMapEagerPublisher;
        private Provider<EventTrackerQueue> FlowableCreate$BufferAsyncEmitter;
        private Provider<ReadLinkPropertiesContract.Presenter> FlowableKt$toIterable$1;
        private Provider<BottomSheetOnBoardingContract.Presenter> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureConfigRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> G;
        private Provider<DanaCustomH5> GetContactSyncConfig;
        private Provider<GetDecodedQrBarcode> H;
        private Provider<GetDecodedQrisTopUp> I;
        private Provider<PushVerifyTracker> InitSecurePreferenceAccount;
        private Provider<UserEducationRepository> InvestmentWalletAdapter;
        private Provider<GetFavoriteServiceWithCacheFirst> J;
        private Provider<HomeWidgetEntityData> JsonParseException;
        private Provider<GetFeedConfig> K;
        private Provider<BottomSheetOnBoardingPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetFavoriteServiceRemote> L;
        private Provider<GetEmptyUserInfo> M;
        private Provider<AnalyticsTrackerFactory> MyBillsEntityDataFactory;
        private Provider<GetGnCScanBBlacklistedCountry> N;
        private Provider<CheckDeepLinkActionVisibility> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ClearCachePayLaterLoanWhitelist> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DecodeGnQr> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<PayLaterContract.View> NewMerchantCategoryAdapter;
        private Provider<GetMerchantQrWhitelist> O;
        private Provider<Activity> OtpRegistrationPresenter$input$1;
        private Provider<IsNeedToShowPlayStoreReview> OtpRegistrationPresenter$input$2;
        private Provider<GetIsCardBindingV2Enabled> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<UserRepository> PlaybackStateCompat$MediaKeyAction;
        private Provider<FeatureCardBinding> PrepareContext;
        private Provider<OauthContract.Presenter> PromoCategoryPresenter$1;
        private Provider<GetKycLevel> Q;
        private Provider<GetSplitBillConfig> QrExpiredActivity;
        private Provider<GetNearbyConfig> R;
        private Provider<ScanQrContract.Presenter> ReferralMapper_Factory;
        private Provider<PostExecutionThread> RequestMoneyQrContract$View;
        private Provider<GetPayLaterCacheLoanWhitelist> S;
        private Provider<SplitBillRepository> SchedulerPoolFactory;
        private Provider<SaveAlipayConnectServiceFirstTime> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<RestoreUrlView> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<RestoreUrlContract.Presenter> SendMoneyScenario;
        private Provider<OauthPresenter> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<ScanQrPresenter> f5868x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<ServicesPresenter> f5869x461046da;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetMissionDetail> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetPayRequest> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetQrisCpmSendmoneyConfig> T;
        private Provider<UpdateServiceHighlighted> TrackerKey$GlobalSearchOpenProperties;
        private Provider<GetUpdateAvailability> TypeProjectionImpl;
        private Provider<OpenMerchantCashier> TypefaceCompatApi26Impl;
        private Provider<GetPaylaterRotationDelayTime> U;
        private Provider<GetQrBindingConfig> V;
        private Provider<FirebaseAnalytics> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetCheckoutH5Event> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<ThirdPartyServicesMapper> View$OnClickListener;
        private Provider<GetPromoCenterVersion> W;
        private Provider<SetPayLaterLoanCache> WithdrawSavedCardChannelView;
        private Provider<ReadLinkPropertiesPresenter> WrappedDrawableState;
        private Provider<GetPayerSplitBillDetail> X;
        private Provider<GetReferralConsult> Y;
        private Provider<GetService> Z;

        /* renamed from: a */
        private Provider<GetServicesWithCategory> f8140a;
        private Provider<CheckoutH5EventContract.Presenter> access$getCapacity$p;
        private Provider<ServicesContract.View> access$setShowcaseShowing$p;
        private Provider<IsAlipayConnectServiceFirstTime> access$throwIllegalArgumentType;
        private Provider<SaveDisplayBottomSheetOnBoarding> applyTrimPathIfNeeded;
        private Provider<GetServicesByKey> b;
        private Provider<GetSettingByKey> c;
        private Provider<PlayStoreReviewContract.Presenter> checkRegisteredUserAndSendOtp;
        private Provider<GlobalNetworkRepository> connectForeground;
        private Provider<ScanQrView> containsObjectForKey;
        private Provider<GetServicesByName> d;
        private Provider<GetUserInfoWithKyc> e;
        private Provider<RestoreUrlPresenter> encodingStream;
        private Provider<GetUserId> f;
        private Provider<GetServiceHighlighted> flip;
        private Provider<GetUserLoanInfo> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<FeatureScanQR> getCallingPid;
        private Provider<BottomSheetOnBoardingContract.View> getCardNumberOCR;
        private Provider<FirebasePerformanceMonitor> getContainerAuth;
        private Provider<CardBindingRepository> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<UserConsentRepository> getExceptionOrNull;
        private Provider<OauthContract.View> getFontAssetManager;
        private Provider<PlayStoreReviewContract.View> getIndexName;
        private Provider<GetFavoriteServices> getNameOrBuilderList;
        private Provider<GetCashierNativeConfig> getOnBoardingScenario;
        private Provider<ValidateNativelyDecodedQr> getOpPackageName;
        private Provider<ShortenerRepository> getPhoneMask;
        private Provider<QrBarcodeRepository> getRawPath;
        private Provider<ScanQrContract.View> getReadyFragment;
        private Provider<UpdatePayLaterLoanCache> getRecommendationData;
        private Provider<FeaturePushVerify> getSupportButtonTintMode;
        private Provider<ReadDeepLinkProperties> getTextEndPadding;
        private Provider<GetAuthCode> getValueOfTouchPositionAbsolute;
        private Provider<GetWhitelistedSubMerchantId> h;
        private Provider<GlobalNetworkPresenter> i;
        private Provider<PlayStoreReviewRepository> initAnimators;
        private Provider<CheckoutH5EventPresenter> initRecordTimeStamp;
        private Provider<CheckoutH5EventContract.View> insertActivities;
        private Provider<GetPayLaterLoanStatusWhitelist> isAuth;
        private Provider<GetRawServices> isAuto;
        private Provider<RestoreUrl> isInfoWindowShown;
        private Provider<DeviceInformationProvider> isLayoutRequested;
        private Provider<RestoreUrlContract.View> isRegionMiniProgram;
        private Provider<IsNativeDecodeEnabled> j;
        private Provider<HomeTrackerImpl> k;
        private Provider<IsCScanBEnabled> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<MixpanelDeeplinkTracker> n;
        private Provider<DeepLinkPayloadModelMapper> newProxyInstance;

        /* renamed from: o */
        private Provider<IsNeedToShowToolTip> f8141o;
        private Provider<FeedsConfigRepository> onDecodeSuccess;
        private Provider<ThreadExecutor> onPolygonsChanged;
        private Provider<MixpanelAnalytics> p;
        private Provider<MyReferralConsultRepository> q;
        private final NewServiceCardComponentImpl r;
        private Provider<FeatureServicesHandler> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ServicesContract.Presenter> f5870reduceIndexedz1zDJgo;
        private Provider<FeatureContract.Presenter> retainOrRemoveAllInternal;
        private Provider<DeepLinkContract.View> rotateTo;
        private Provider<MyReferralConsultMapper> s;
        private Provider<CheckFavoriteServicesFeature> scheduleImpl;
        private Provider<PaylaterRepository> secondaryHash;
        private Provider<PlayStoreReviewPresenter> setNetAuthId;
        private Provider<GetRequestMoneyInfoFeature> shouldRecycleViewType;
        private Provider<MixpanelGlobalNetworkTracker> t;
        private Provider<OauthRepository> u;
        private Provider<GlobalNetworkContract.View> useDaemonThreadFactory;
        private Provider<PayerModelListMapper> v;
        private Provider<FamilyAccountRepository> verifyNotNull;
        private Provider<PayLaterPresenter> w;
        private Provider<FeatureSettingMore> whenAvailable;
        private Provider<OauthView> x;
        private Provider<PromoQuestRepository> y;
        private Provider<ProductPageManager> z;

        public /* synthetic */ NewServiceCardComponentImpl(PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, GlobalNetworkModule globalNetworkModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent, byte b) {
            this(playStoreReviewModules, checkoutH5EventModule, bottomSheetOnBoardingModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, globalNetworkModule, payLaterModule, applicationComponent);
        }

        private NewServiceCardComponentImpl(PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, GlobalNetworkModule globalNetworkModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.r = this;
            this.isLayoutRequested = new DeviceInformationProviderProvider(applicationComponent);
            this.useDaemonThreadFactory = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            this.onPolygonsChanged = new ThreadExecutorProvider(applicationComponent);
            this.RequestMoneyQrContract$View = new PostExecutionThreadProvider(applicationComponent);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.connectForeground = globalNetworkRepositoryProvider;
            this.l = IsCScanBEnabled_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, globalNetworkRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DecodeGnQr_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.connectForeground);
            this.TypefaceCompatApi26Impl = OpenMerchantCashier_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.connectForeground);
            this.N = GetGnCScanBBlacklistedCountry_Factory.create(this.connectForeground);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.PlaybackStateCompat$MediaKeyAction = userRepositoryProvider;
            this.e = GetUserInfoWithKyc_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, userRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.DatabaseTableConfigUtil = contextProvider;
            this.t = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(contextProvider);
            this.G = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.connectForeground);
            this.access$throwIllegalArgumentType = IsAlipayConnectServiceFirstTime_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.connectForeground);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = SaveAlipayConnectServiceFirstTime_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.connectForeground);
            this.FlowViewUtil$textChanges$2 = GetWalletOauth_Factory.create(this.connectForeground);
            this.u = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getExceptionOrNull = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.M = create;
            this.getValueOfTouchPositionAbsolute = GetAuthCode_Factory.create(this.u, create);
            GetPayRequest_Factory create2 = GetPayRequest_Factory.create(this.connectForeground);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create2;
            Provider<GlobalNetworkPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.useDaemonThreadFactory, this.l, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.TypefaceCompatApi26Impl, this.N, this.e, this.t, this.G, this.access$throwIllegalArgumentType, this.SecuritySettingsActivity$createPinLauncher$2$1, this.FlowViewUtil$textChanges$2, this.getValueOfTouchPositionAbsolute, create2));
            this.i = authRequestContext;
            this.FlowableConcatMapEagerPublisher = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = h5eventRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetCheckoutH5Event_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, h5eventRepositoryProvider);
            CheckoutH5EventModule_ProvideViewFactory PlaceComponentResult = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            this.insertActivities = PlaceComponentResult;
            CheckoutH5EventPresenter_Factory BuiltInFictitiousFunctionClassFactory = CheckoutH5EventPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.VerifyPinStateManager$executeRiskChallenge$2$2, PlaceComponentResult);
            this.initRecordTimeStamp = BuiltInFictitiousFunctionClassFactory;
            this.access$getCapacity$p = CheckoutH5EventModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(checkoutH5EventModule, BuiltInFictitiousFunctionClassFactory);
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.InvestmentWalletAdapter = userEducationRepositoryProvider;
            this.D = GetBottomSheetOnBoarding_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create3 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.InvestmentWalletAdapter);
            this.applyTrimPathIfNeeded = create3;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getCardNumberOCR, this.D, create3);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory2));
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.initAnimators = playStoreReviewRepositoryProvider;
            this.OtpRegistrationPresenter$input$2 = IsNeedToShowPlayStoreReview_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, playStoreReviewRepositoryProvider);
            this.BaseSocialFeedContract$Presenter = SaveLastPlayStoreReviewShow_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.initAnimators);
            Provider<PlayStoreReviewContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.getIndexName = authRequestContext2;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.OtpRegistrationPresenter$input$2, this.BaseSocialFeedContract$Presenter, authRequestContext2);
            this.setNetAuthId = MyBillsEntityDataFactory;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            this.access$setShowcaseShowing$p = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            ServiceCategoryMapper_Factory authRequestContext3 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.DatabaseTableConfigUtil);
            this.ArrayTable$1 = authRequestContext3;
            this.View$OnClickListener = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext3);
            this.f8141o = IsNeedToShowToolTip_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.InvestmentWalletAdapter);
            this.ArrayTable$3 = SaveShowToolTip_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.InvestmentWalletAdapter);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = servicesRepositoryProvider;
            this.f8140a = GetServicesWithCategory_Factory.create(servicesRepositoryProvider);
            this.F = GetDefaultServiceWithCategory_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.L = GetFavoriteServiceRemote_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.d = GetServicesByName_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.b = GetServicesByKey_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.getNameOrBuilderList = GetFavoriteServices_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = featureConfigRepositoryProvider;
            this.scheduleImpl = CheckFavoriteServicesFeature_Factory.create(featureConfigRepositoryProvider);
            this.isAuto = GetRawServices_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.J = GetFavoriteServiceWithCacheFirst_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.flip = GetServiceHighlighted_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            UpdateServiceHighlighted_Factory create4 = UpdateServiceHighlighted_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.TrackerKey$GlobalSearchOpenProperties = create4;
            Provider<ServicesPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.access$setShowcaseShowing$p, this.getValueOfTouchPositionAbsolute, this.View$OnClickListener, this.f8141o, this.ArrayTable$3, this.f8140a, this.F, this.L, this.d, this.b, this.getNameOrBuilderList, this.scheduleImpl, this.isAuto, this.J, this.flip, create4));
            this.f5869x461046da = authRequestContext4;
            this.f5870reduceIndexedz1zDJgo = ServicesModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(servicesModule, authRequestContext4);
            Provider<Activity> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.OtpRegistrationPresenter$input$1 = authRequestContext5;
            Provider<ScanQrView> authRequestContext6 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext5));
            this.containsObjectForKey = authRequestContext6;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext6));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.getRawPath = qrBarcodeRepositoryProvider;
            this.H = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.I = GetDecodedQrisTopUp_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.getRawPath);
            this.ArrayTable$2 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.FillAnimation = GetUserStatusInfo_Factory.create(this.PlaybackStateCompat$MediaKeyAction);
            this.getOnBoardingScenario = GetCashierNativeConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.j = IsNativeDecodeEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            GetDecodeTciCoListConfig_Factory create5 = GetDecodeTciCoListConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.AppCompatEmojiTextHelper = create5;
            this.getOpPackageName = ValidateNativelyDecodedQr_Factory.create(create5);
            this.O = GetMerchantQrWhitelist_Factory.create(this.getRawPath);
            this.V = GetQrBindingConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.m = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.secondaryHash = providePaylaterRepositoryProvider;
            this.g = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.T = GetQrisCpmSendmoneyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.InvestmentWalletAdapter);
            this.ConcurrentKt = SaveShowDialog_Factory.create(this.InvestmentWalletAdapter);
            Provider<ScanQrPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.getReadyFragment, this.H, this.I, this.ArrayTable$2, this.isLayoutRequested, this.FillAnimation, this.getOnBoardingScenario, GetNativelyDecodedQr_Factory.create(), this.j, this.getOpPackageName, this.O, this.V, this.m, this.g, this.T, this.ConcurrentKt));
            this.f5868x461046d9 = authRequestContext7;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext7));
            Provider<RestoreUrlView> authRequestContext8 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil));
            this.SecuritySettingsActivity$createPinLauncher$2$2 = authRequestContext8;
            this.isRegionMiniProgram = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext8));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.getPhoneMask = shortenerRepositoryProvider;
            RestoreUrl_Factory create6 = RestoreUrl_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, shortenerRepositoryProvider);
            this.isInfoWindowShown = create6;
            Provider<RestoreUrlPresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.isRegionMiniProgram, create6));
            this.encodingStream = authRequestContext9;
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext9));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.q = myReferralConsultRepositoryProvider;
            this.Y = GetReferralConsult_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, myReferralConsultRepositoryProvider);
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.s = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.B = GenerateReferralDeepLink_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = settingRepositoryProvider;
            this.c = GetSettingByKey_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.z = productPageManagerProvider;
            this.whenAvailable = FeatureSettingMore_Factory.PlaceComponentResult(this.c, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.SchedulerPoolFactory = splitBillRepositoryProvider;
            this.X = GetPayerSplitBillDetail_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, splitBillRepositoryProvider);
            this.v = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult2 = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.v);
            this.DebugCoroutineInfoImpl = PlaceComponentResult2;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.X, PlaceComponentResult2);
            this.QrExpiredActivity = GetSplitBillConfig_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FragmentBottomSheetPaymentSettingBinding);
            GetRequestMoneyInfoFeature_Factory create7 = GetRequestMoneyInfoFeature_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FragmentBottomSheetPaymentSettingBinding);
            this.shouldRecycleViewType = create7;
            Provider<GetSplitBillConfig> provider = this.QrExpiredActivity;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create7, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.y = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create8 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = create8;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeaturePromoQuest_Factory.getAuthRequestContext(create8, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.DatabaseTableConfigUtil));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory2 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
            this.n = MyBillsEntityDataFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.verifyNotNull = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory3 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.P = BuiltInFictitiousFunctionClassFactory3;
            this.PrepareContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3);
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.n));
            Provider<FeatureView> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.Y, this.getErrorConfigVersion, this.s, this.B, this.whenAvailable, this.SubSequence, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getCallingPid, this.GetContactSyncConfig, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda3, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.PrepareContext, this.g, FeatureMyBills_Factory.PlaceComponentResult(), this.getSupportButtonTintMode));
            this.A = authRequestContext10;
            Provider<FeatureContract.View> authRequestContext11 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext10));
            this.CYFMonitor$ChallengeActionCallback = authRequestContext11;
            this.readMicros = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext11, this.b, this.View$OnClickListener, this.getValueOfTouchPositionAbsolute, this.isLayoutRequested));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckDeepLinkActionVisibility_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.FragmentBottomSheetPaymentSettingBinding);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.R = GetNearbyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = provideFeedsConfigRepositoryProvider;
            this.K = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.W = GetPromoCenterVersion_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.TypeProjectionImpl = GetUpdateAvailability_Factory.create(this.DatabaseTableConfigUtil);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.InitSecurePreferenceAccount = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create9 = GetService_Factory.create(this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.Z = create9;
            Provider<FeaturePresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.CYFMonitor$ChallengeActionCallback, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.R, this.K, this.W, this.TypeProjectionImpl, this.moveToNextValue, this.InitSecurePreferenceAccount, create9));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext12;
            this.retainOrRemoveAllInternal = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext12));
            OauthView_Factory authRequestContext13 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.x = authRequestContext13;
            this.getFontAssetManager = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext13));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.Q = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetNickname_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, this.PlaceComponentResult);
            this.h = GetWhitelistedSubMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.E = GetAddingNameWhitelistedMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            Provider<OauthContract.View> provider2 = this.getFontAssetManager;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.Q, this.e, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.h, this.E);
            this.SizeSelectors$OrSelector = KClassImpl$Data$declaredNonStaticMembers$2;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext14 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.ReferralMapper_Factory, this.SendMoneyScenario, this.retainOrRemoveAllInternal, this.PromoCategoryPresenter$1, this.f5869x461046da, applicationProvider, this.g));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = authRequestContext14;
            this.rotateTo = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext14));
            this.getTextEndPadding = ReadDeepLinkProperties_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.newProxyInstance = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.onPolygonsChanged, this.RequestMoneyQrContract$View, liteAccountRepositoryProvider);
            this.f = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext15 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.rotateTo, this.getTextEndPadding, this.newProxyInstance, create10, this.n));
            this.WrappedDrawableState = authRequestContext15;
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext15));
            this.NewMerchantCategoryAdapter = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ClearCachePayLaterLoanWhitelist_Factory.create(this.secondaryHash, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.S = GetPayLaterCacheLoanWhitelist_Factory.create(this.secondaryHash);
            this.CheckPromoQuestFeature = SavePaylaterRotationDelayTime_Factory.create(this.secondaryHash);
            this.U = GetPaylaterRotationDelayTime_Factory.create(this.secondaryHash);
            this.isAuth = GetPayLaterLoanStatusWhitelist_Factory.create(this.secondaryHash);
            this.getRecommendationData = UpdatePayLaterLoanCache_Factory.create(this.secondaryHash, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            SetPayLaterLoanCache_Factory create11 = SetPayLaterLoanCache_Factory.create(this.secondaryHash, this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
            this.WithdrawSavedCardChannelView = create11;
            Provider<PayLaterPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.NewMerchantCategoryAdapter, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.S, this.g, this.CheckPromoQuestFeature, this.U, this.isAuth, this.getRecommendationData, create11));
            this.w = authRequestContext16;
            this.ApiStatus$AvailableSince = PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule, authRequestContext16);
            this.JsonParseException = new ProvideHomeWidgetEntityDataProvider(applicationComponent);
            this.getContainerAuth = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = provideEventTrackerQueueProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FirebaseAnalytics_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.getContainerAuth, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$22 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil, this.FlowableCreate$BufferAsyncEmitter);
            this.p = KClassImpl$Data$declaredNonStaticMembers$22;
            Provider<FirebaseAnalytics> provider3 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult3 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider3, KClassImpl$Data$declaredNonStaticMembers$22, fullStoryAnalytics_Factory);
            this.MyBillsEntityDataFactory = PlaceComponentResult3;
            this.k = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3);
        }

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
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
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SubSequence());
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
            private final ApplicationComponent getAuthRequestContext;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent getAuthRequestContext;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1());
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
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent getAuthRequestContext;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SendMoneyScenario());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.setNetAuthId());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.applyTrimPathIfNeeded());
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
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.shouldRecycleViewType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ConcurrentKt());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.QrExpiredActivity());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.k());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.z());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.access$throwIllegalArgumentType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowableCreate$BufferAsyncEmitter());
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

        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetEntityDataProvider implements Provider<HomeWidgetEntityData> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetEntityDataProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetEntityData get() {
                return (HomeWidgetEntityData) Preconditions.PlaceComponentResult(this.PlaceComponentResult.s());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.PlaceComponentResult.j());
            }
        }

        @Override // id.dana.di.component.NewServiceCardComponent
        public final void BuiltInFictitiousFunctionClassFactory(ServiceCardV2View serviceCardV2View) {
            ServiceCardV2View_MembersInjector.BuiltInFictitiousFunctionClassFactory(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested));
            serviceCardV2View.globalNetworkPresenter = DoubleCheck.MyBillsEntityDataFactory(this.FlowableConcatMapEagerPublisher);
            ServiceCardV2View_MembersInjector.getAuthRequestContext(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.access$getCapacity$p));
            ServiceCardV2View_MembersInjector.scheduleImpl(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.FlowableReduce$ReduceSubscriber));
            ServiceCardV2View_MembersInjector.getErrorConfigVersion(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.checkRegisteredUserAndSendOtp));
            serviceCardV2View.presenter = DoubleCheck.MyBillsEntityDataFactory(this.f5870reduceIndexedz1zDJgo);
            ServiceCardV2View_MembersInjector.initRecordTimeStamp(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.FlowableKt$toIterable$1));
            ServiceCardV2View_MembersInjector.moveToNextValue(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.ApiStatus$AvailableSince));
            ServiceCardV2View_MembersInjector.lookAheadTest(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.JsonParseException));
            ServiceCardV2View_MembersInjector.MyBillsEntityDataFactory(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.retainOrRemoveAllInternal));
            ServiceCardV2View_MembersInjector.PlaceComponentResult(serviceCardV2View, DoubleCheck.MyBillsEntityDataFactory(this.k));
        }
    }
}
