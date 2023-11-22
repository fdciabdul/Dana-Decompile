package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
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
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.contract.staticqr.DecodeQrImageModule;
import id.dana.contract.staticqr.DecodeQrImageModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.DecodeQrImageModule_ProvideViewFactory;
import id.dana.contract.staticqr.DecodeQrImagePresenter;
import id.dana.contract.staticqr.DecodeQrImagePresenter_Factory;
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
import id.dana.di.modules.ScanQrAnalyticModule;
import id.dana.di.modules.ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetKycLevel_Factory;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.account.interactor.GetNickname_Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
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
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.GetUserLoanInfo_Factory;
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
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.scanner.ScannerFragment;
import id.dana.scanner.ScannerFragment_MembersInjector;
import id.dana.scanner.gallery.RxQRDecode;
import id.dana.scanner.gallery.RxQRDecode_Factory;
import id.dana.scanner.tracker.ScannerMixpanelTracker;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.TimerUtil_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerScannerComponent {
    private DaggerScannerComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public CheckoutH5EventModule BuiltInFictitiousFunctionClassFactory;
        public ServicesModule DatabaseTableConfigUtil;
        public ScanQrAnalyticModule GetContactSyncConfig;
        public BottomSheetOnBoardingModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public OauthModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public DecodeQrImageModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public GlobalNetworkModule lookAheadTest;
        public FeatureModule moveToNextValue;
        public PlayStoreReviewModules scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ScannerComponentImpl implements ScannerComponent {
        private Provider<FeatureView> A;
        private Provider<ReadLinkPropertiesContract.Presenter> ApiStatus$AvailableSince;
        private Provider<GetDecodedQrisTopUp> AppCompatEmojiTextHelper;
        private Provider<ShortenerRepository> ArrayTable$1;
        private Provider<SettingRepository> ArrayTable$2;
        private final ScannerComponentImpl ArrayTable$3;
        private Provider<GenerateLinkRepository> B;
        private Provider<UserEducationRepository> BannerEntityDataFactory_Factory;
        private Provider<SaveDisplayBottomSheetOnBoarding> BaseSocialFeedContract$Presenter;
        private Provider<FeatureSettingMore> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureSplitBill> C;
        private Provider<ReadDeepLinkProperties> CYFMonitor$ChallengeActionCallback;
        private Provider<ScanQrView> CheckPromoQuestFeature;
        private Provider<ServicesPresenter> ConcurrentKt;
        private Provider<GetAddingNameWhitelistedMerchantId> D;
        private Provider<LiteAccountRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DanaCustomH5> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> DebugCoroutineInfoImpl;
        private Provider<GetCashierNativeConfig> E;
        private Provider<GetCheckoutH5Event> F;
        private Provider<GetUserStatusInfo> FillAnimation;
        private Provider<SplitBillRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GlobalNetworkRepository> FlowViewUtil$textChanges$1;
        private Provider<GlobalNetworkPresenter> FlowViewUtil$textChanges$2;
        private Provider<ReadLinkPropertiesPresenter> FlowableConcatMapEagerPublisher;
        private Provider<PaylaterRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<DeepLinkContract.View> FlowableKt$toIterable$1;
        private Provider<FeedsConfigRepository> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureCardBinding> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> G;
        private Provider<DeepLinkPayloadModelMapper> GetContactSyncConfig;
        private Provider<GetDecodedQrBarcode> H;
        private Provider<GetDecodeTciCoListConfig> I;
        private Provider<RestoreUrlContract.View> InitSecurePreferenceAccount;
        private Provider<GetDeepLinkPayload> J;
        private Provider<RestoreUrlContract.Presenter> JsonParseException;
        private Provider<GetDefaultServiceWithCategory> K;
        private Provider<CheckDeepLinkActionVisibility> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetFavoriteServiceRemote> L;
        private Provider<GetEmptyUserInfo> M;
        private Provider<BottomSheetOnBoardingPresenter> MyBillsEntityDataFactory;
        private Provider<GetFeedConfig> N;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DecodeGnQr> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DecodeQrImagePresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeepLinkRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DeepLinkPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<FeatureContract.View> NewMerchantCategoryAdapter;
        private Provider<GetIsCardBindingV2Enabled> O;
        private Provider<PlayStoreReviewContract.Presenter> OtpRegistrationPresenter$input$1;
        private Provider<MixpanelDeeplinkTracker> OtpRegistrationPresenter$input$2;
        private Provider<GetFavoriteServices> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<DeviceInformationProvider> PrepareContext;
        private Provider<CheckoutH5EventContract.View> PromoCategoryPresenter$1;
        private Provider<GetGnCScanBBlacklistedCountry> Q;
        private Provider<GetServicesWithCategory> QrExpiredActivity;
        private Provider<GetNearbyConfig> R;
        private Provider<ScanQrContract.View> ReferralMapper_Factory;
        private Provider<ProductPageManager> RequestMoneyQrContract$View;
        private Provider<GetMissionDetail> S;
        private Provider<ThirdPartyServicesMapper> SchedulerPoolFactory;
        private Provider<SaveShowToolTip> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<SaveShowDialog> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<ScannerMixpanelTracker> SendMoneyScenario;
        private Provider<OauthRepository> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<ServiceCategoryMapper> f5878x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<ServicesRepository> f5879x461046da;
        private Provider<FeatureServicesHandler> SubSequence;
        private Provider<GetKycLevel> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetMerchantQrWhitelist> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetPayRequest> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetQrisCpmSendmoneyConfig> T;
        private Provider<GetUserLoanInfo> TypeProjectionImpl;
        private Provider<PostExecutionThread> TypefaceCompatApi26Impl;
        private Provider<GetPayerSplitBillDetail> U;
        private Provider<GetPhoneNumber> V;
        private Provider<FeatureSplitBillPay> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetBottomSheetOnBoarding> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<UpdateServiceHighlighted> View$OnClickListener;
        private Provider<GetQrBindingConfig> W;
        private Provider<SplitBillHistoryToSplitBillModelMapper> WithdrawSavedCardChannelView;
        private Provider<RestoreUrlPresenter> WrappedDrawableState;
        private Provider<GetPromoCenterVersion> X;
        private Provider<GetReferralConsult> Y;
        private Provider<GetService> Z;

        /* renamed from: a */
        private Provider<GetSettingByKey> f8157a;
        private Provider<PushVerifyTracker> access$getCapacity$p;
        private Provider<ServicesContract.View> access$setShowcaseShowing$p;
        private Provider<IsCScanBEnabled> access$throwIllegalArgumentType;
        private Provider<SaveLastPlayStoreReviewShow> applyTrimPathIfNeeded;
        private Provider<GetSplitBillConfig> b;
        private Provider<GetServicesByKey> c;
        private Provider<FeatureContract.Presenter> checkRegisteredUserAndSendOtp;
        private Provider<GetWalletOauth> connectForeground;
        private Provider<ScanResultMapper> containsObjectForKey;
        private Provider<GetServicesByName> d;
        private Provider<GetUserId> e;
        private Provider<RestoreUrlView> encodingStream;
        private Provider<GetUpdateAvailability> f;
        private Provider<GetRawServices> flip;
        private Provider<GetUserInfoWithKyc> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<FeaturePushVerify> getCallingPid;
        private Provider<FamilyAccountRepository> getCardNumberOCR;
        private Provider<ScanQrContract.Presenter> getContainerAuth;
        private Provider<CheckoutH5EventContract.Presenter> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<ValidateNativelyDecodedQr> getExceptionOrNull;
        private Provider<GlobalNetworkContract.View> getFontAssetManager;
        private Provider<DeepLinkContract.Presenter> getIndexName;
        private Provider<GetFavoriteServiceWithCacheFirst> getNameOrBuilderList;
        private Provider<GenerateReferralDeepLink> getOnBoardingScenario;
        private Provider<UserConsentRepository> getPhoneMask;
        private Provider<RxQRDecode> getRawPath;
        private Provider<OauthContract.View> getReadyFragment;
        private Provider<FeaturePresenter> getSupportButtonTintMode;
        private Provider<SaveAlipayConnectServiceFirstTime> getTextEndPadding;
        private Provider<GetAuthCode> getValueOfTouchPositionAbsolute;
        private Provider<H5EventRepository> h;
        private Provider<GetWhitelistedSubMerchantId> i;
        private Provider<BottomSheetOnBoardingContract.View> initAnimators;
        private Provider<Context> initRecordTimeStamp;
        private Provider<GlobalNetworkContract.Presenter> insertActivities;
        private Provider<GetNickname> isAuth;
        private Provider<GetServiceHighlighted> isAuto;
        private Provider<ScanQrPresenter> isInfoWindowShown;
        private Provider<DeeplinkTrackerFactory> isLayoutRequested;
        private Provider<QrBarcodeRepository> isRegionMiniProgram;
        private Provider<InitSessionDeepLink> j;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> k;
        private Provider<IsNativeDecodeEnabled> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<IsAlipayConnectServiceFirstTime> m;
        private Provider<CheckoutH5EventPresenter> moveToNextValue;
        private Provider<IsNeedToShowPlayStoreReview> n;
        private Provider<DeepLinkView> newProxyInstance;

        /* renamed from: o */
        private Provider<IsNeedToShowToolTip> f8158o;
        private Provider<PlayStoreReviewContract.View> onDecodeSuccess;
        private Provider<UserRepository> onPolygonsChanged;
        private Provider<MixpanelGlobalNetworkTracker> p;
        private Provider<MyReferralConsultMapper> q;
        private Provider<OauthPresenter> r;
        private Provider<FeatureScanQR> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<OauthContract.Presenter> f5880reduceIndexedz1zDJgo;
        private Provider<DecodeQrImageContract.View> retainOrRemoveAllInternal;
        private Provider<RemoveDeepLinkPayload> rotateTo;
        private Provider<MyReferralConsultRepository> s;
        private Provider<CheckMyBillsVersionConfig> scheduleImpl;
        private Provider<DecodeQrImageContract.Presenter> secondaryHash;
        private Provider<PromoQuestRepository> setNetAuthId;
        private Provider<GetRequestMoneyInfoFeature> shouldRecycleViewType;
        private Provider<OauthView> t;
        private Provider<PlayStoreReviewRepository> u;
        private Provider<RestoreUrl> useDaemonThreadFactory;
        private Provider<PayerModelListMapper> v;
        private Provider<CardBindingRepository> verifyNotNull;
        private Provider<OpenMerchantCashier> w;
        private Provider<FeaturePromoQuest> whenAvailable;
        private Provider<PlayStoreReviewPresenter> x;
        private Provider<BottomSheetOnBoardingContract.Presenter> y;
        private Provider<Activity> z;

        public /* synthetic */ ScannerComponentImpl(ScanQrModule scanQrModule, DecodeQrImageModule decodeQrImageModule, DeepLinkModule deepLinkModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, GlobalNetworkModule globalNetworkModule, ScanQrAnalyticModule scanQrAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(scanQrModule, decodeQrImageModule, deepLinkModule, restoreUrlModule, featureModule, oauthModule, servicesModule, playStoreReviewModules, checkoutH5EventModule, bottomSheetOnBoardingModule, globalNetworkModule, scanQrAnalyticModule, applicationComponent);
        }

        private ScannerComponentImpl(ScanQrModule scanQrModule, DecodeQrImageModule decodeQrImageModule, DeepLinkModule deepLinkModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, GlobalNetworkModule globalNetworkModule, ScanQrAnalyticModule scanQrAnalyticModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullstoryDeeplinkTracker_Factory fullstoryDeeplinkTracker_Factory;
            this.ArrayTable$3 = this;
            this.retainOrRemoveAllInternal = DoubleCheck.getAuthRequestContext(DecodeQrImageModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(decodeQrImageModule));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.initRecordTimeStamp = contextProvider;
            RxQRDecode_Factory MyBillsEntityDataFactory = RxQRDecode_Factory.MyBillsEntityDataFactory(contextProvider);
            this.getRawPath = MyBillsEntityDataFactory;
            Provider<DecodeQrImagePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(DecodeQrImagePresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.retainOrRemoveAllInternal, MyBillsEntityDataFactory, this.initRecordTimeStamp));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(DecodeQrImageModule_ProvidePresenterFactory.PlaceComponentResult(decodeQrImageModule, authRequestContext));
            this.DebugCoroutineInfoImpl = new ThreadExecutorProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = new PostExecutionThreadProvider(applicationComponent);
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.h = h5eventRepositoryProvider;
            this.F = GetCheckoutH5Event_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, h5eventRepositoryProvider);
            CheckoutH5EventModule_ProvideViewFactory PlaceComponentResult = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            this.PromoCategoryPresenter$1 = PlaceComponentResult;
            CheckoutH5EventPresenter_Factory BuiltInFictitiousFunctionClassFactory = CheckoutH5EventPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.F, PlaceComponentResult);
            this.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
            this.getDefaultSenderId = CheckoutH5EventModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(checkoutH5EventModule, BuiltInFictitiousFunctionClassFactory);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.u = playStoreReviewRepositoryProvider;
            this.n = IsNeedToShowPlayStoreReview_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, playStoreReviewRepositoryProvider);
            this.applyTrimPathIfNeeded = SaveLastPlayStoreReviewShow_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.u);
            Provider<PlayStoreReviewContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.onDecodeSuccess = authRequestContext2;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory2 = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.n, this.applyTrimPathIfNeeded, authRequestContext2);
            this.x = MyBillsEntityDataFactory2;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory2));
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.z = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.CheckPromoQuestFeature = authRequestContext4;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = qrBarcodeRepositoryProvider;
            this.H = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.AppCompatEmojiTextHelper = GetDecodedQrisTopUp_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.isRegionMiniProgram);
            this.containsObjectForKey = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.PrepareContext = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.onPolygonsChanged = userRepositoryProvider;
            this.FillAnimation = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = featureConfigRepositoryProvider;
            this.E = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.l = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.I = create;
            this.getExceptionOrNull = ValidateNativelyDecodedQr_Factory.create(create);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetMerchantQrWhitelist_Factory.create(this.isRegionMiniProgram);
            this.W = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.k = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = providePaylaterRepositoryProvider;
            this.TypeProjectionImpl = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = userEducationRepositoryProvider;
            this.T = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, userEducationRepositoryProvider);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = SaveShowDialog_Factory.create(this.BannerEntityDataFactory_Factory);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, this.ReferralMapper_Factory, this.H, this.AppCompatEmojiTextHelper, this.containsObjectForKey, this.PrepareContext, this.FillAnimation, this.E, GetNativelyDecodedQr_Factory.create(), this.l, this.getExceptionOrNull, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.W, this.k, this.TypeProjectionImpl, this.T, this.SecuritySettingsActivity$createPinLauncher$2$2));
            this.isInfoWindowShown = authRequestContext5;
            this.getContainerAuth = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            this.getFontAssetManager = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = globalNetworkRepositoryProvider;
            this.access$throwIllegalArgumentType = IsCScanBEnabled_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, globalNetworkRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DecodeGnQr_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.FlowViewUtil$textChanges$1);
            this.w = OpenMerchantCashier_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.FlowViewUtil$textChanges$1);
            this.Q = GetGnCScanBBlacklistedCountry_Factory.create(this.FlowViewUtil$textChanges$1);
            this.g = GetUserInfoWithKyc_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.onPolygonsChanged);
            this.p = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(this.initRecordTimeStamp);
            this.G = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.FlowViewUtil$textChanges$1);
            this.m = IsAlipayConnectServiceFirstTime_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.FlowViewUtil$textChanges$1);
            this.getTextEndPadding = SaveAlipayConnectServiceFirstTime_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.FlowViewUtil$textChanges$1);
            this.connectForeground = GetWalletOauth_Factory.create(this.FlowViewUtil$textChanges$1);
            this.SizeSelectors$OrSelector = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getPhoneMask = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.M = create2;
            this.getValueOfTouchPositionAbsolute = GetAuthCode_Factory.create(this.SizeSelectors$OrSelector, create2);
            GetPayRequest_Factory create3 = GetPayRequest_Factory.create(this.FlowViewUtil$textChanges$1);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = create3;
            Provider<GlobalNetworkPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.getFontAssetManager, this.access$throwIllegalArgumentType, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.w, this.Q, this.g, this.p, this.G, this.m, this.getTextEndPadding, this.connectForeground, this.getValueOfTouchPositionAbsolute, create3));
            this.FlowViewUtil$textChanges$2 = authRequestContext6;
            this.insertActivities = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext6));
            Provider<RestoreUrlView> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            this.encodingStream = authRequestContext7;
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = shortenerRepositoryProvider;
            RestoreUrl_Factory create4 = RestoreUrl_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, shortenerRepositoryProvider);
            this.useDaemonThreadFactory = create4;
            Provider<RestoreUrlPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.InitSecurePreferenceAccount, create4));
            this.WrappedDrawableState = authRequestContext8;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext8));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.s = myReferralConsultRepositoryProvider;
            this.Y = GetReferralConsult_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, myReferralConsultRepositoryProvider);
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.q = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.B = generateLinkRepositoryProvider;
            this.getOnBoardingScenario = GenerateReferralDeepLink_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.ArrayTable$2 = settingRepositoryProvider;
            this.f8157a = GetSettingByKey_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.RequestMoneyQrContract$View = productPageManagerProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = FeatureSettingMore_Factory.PlaceComponentResult(this.f8157a, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = splitBillRepositoryProvider;
            this.U = GetPayerSplitBillDetail_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, splitBillRepositoryProvider);
            this.v = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult2 = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.v);
            this.WithdrawSavedCardChannelView = PlaceComponentResult2;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.U, PlaceComponentResult2);
            this.b = GetSplitBillConfig_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            GetRequestMoneyInfoFeature_Factory create5 = GetRequestMoneyInfoFeature_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.shouldRecycleViewType = create5;
            Provider<GetSplitBillConfig> provider = this.b;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.C = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create5, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.setNetAuthId = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create6 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.S = create6;
            this.whenAvailable = FeaturePromoQuest_Factory.getAuthRequestContext(create6, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.readMicros = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.initRecordTimeStamp));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory3 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp);
            this.OtpRegistrationPresenter$input$2 = MyBillsEntityDataFactory3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory3));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.getCardNumberOCR = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.verifyNotNull = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory2 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.O = BuiltInFictitiousFunctionClassFactory2;
            this.FragmentBottomSheetPaymentSettingBinding = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.OtpRegistrationPresenter$input$2));
            Provider<FeatureView> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.Y, this.getErrorConfigVersion, this.q, this.getOnBoardingScenario, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.C, this.whenAvailable, this.readMicros, this.DatabaseTableConfigUtil, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda6, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.FragmentBottomSheetPaymentSettingBinding, this.TypeProjectionImpl, FeatureMyBills_Factory.PlaceComponentResult(), this.getCallingPid));
            this.A = authRequestContext9;
            this.NewMerchantCategoryAdapter = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext9));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.f5879x461046da = servicesRepositoryProvider;
            this.c = GetServicesByKey_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext10 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.initRecordTimeStamp);
            this.f5878x461046d9 = authRequestContext10;
            ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory3 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext10);
            this.SchedulerPoolFactory = BuiltInFictitiousFunctionClassFactory3;
            this.SubSequence = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NewMerchantCategoryAdapter, this.c, BuiltInFictitiousFunctionClassFactory3, this.getValueOfTouchPositionAbsolute, this.PrepareContext));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckDeepLinkActionVisibility_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.R = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = provideFeedsConfigRepositoryProvider;
            this.N = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.X = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.f = GetUpdateAvailability_Factory.create(this.initRecordTimeStamp);
            this.scheduleImpl = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.access$getCapacity$p = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.f5879x461046da);
            this.Z = create7;
            Provider<FeaturePresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.NewMerchantCategoryAdapter, this.SubSequence, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.R, this.N, this.X, this.f, this.scheduleImpl, this.access$getCapacity$p, create7));
            this.getSupportButtonTintMode = authRequestContext11;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext11));
            OauthView_Factory authRequestContext12 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.t = authRequestContext12;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext12));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.isAuth = GetNickname_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.PlaceComponentResult);
            this.i = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.D = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Provider<OauthContract.View> provider2 = this.getReadyFragment;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.g, this.isAuth, this.i, this.D);
            this.r = KClassImpl$Data$declaredNonStaticMembers$2;
            this.f5880reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.access$setShowcaseShowing$p = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.f8158o = IsNeedToShowToolTip_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.BannerEntityDataFactory_Factory);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = SaveShowToolTip_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.BannerEntityDataFactory_Factory);
            this.QrExpiredActivity = GetServicesWithCategory_Factory.create(this.f5879x461046da);
            this.K = GetDefaultServiceWithCategory_Factory.create(this.f5879x461046da);
            this.L = GetFavoriteServiceRemote_Factory.create(this.f5879x461046da);
            this.d = GetServicesByName_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.f5879x461046da);
            this.P = GetFavoriteServices_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.f5879x461046da);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.flip = GetRawServices_Factory.create(this.f5879x461046da);
            this.getNameOrBuilderList = GetFavoriteServiceWithCacheFirst_Factory.create(this.f5879x461046da);
            this.isAuto = GetServiceHighlighted_Factory.create(this.f5879x461046da);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.f5879x461046da);
            this.View$OnClickListener = create8;
            this.ConcurrentKt = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.access$setShowcaseShowing$p, this.getValueOfTouchPositionAbsolute, this.SchedulerPoolFactory, this.f8158o, this.SecuritySettingsActivity$createPinLauncher$2$1, this.QrExpiredActivity, this.K, this.L, this.d, this.c, this.P, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.flip, this.getNameOrBuilderList, this.isAuto, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext13 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.getContainerAuth, this.JsonParseException, this.checkRegisteredUserAndSendOtp, this.f5880reduceIndexedz1zDJgo, this.ConcurrentKt, applicationProvider, this.TypeProjectionImpl));
            this.newProxyInstance = authRequestContext13;
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext13));
            this.CYFMonitor$ChallengeActionCallback = ReadDeepLinkProperties_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.GetContactSyncConfig = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, liteAccountRepositoryProvider);
            this.e = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext14 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.FlowableKt$toIterable$1, this.CYFMonitor$ChallengeActionCallback, this.GetContactSyncConfig, create9, this.OtpRegistrationPresenter$input$2));
            this.FlowableConcatMapEagerPublisher = authRequestContext14;
            this.ApiStatus$AvailableSince = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext14));
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = deepLinkRepositoryProvider;
            this.j = InitSessionDeepLink_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, deepLinkRepositoryProvider);
            this.J = GetDeepLinkPayload_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.V = GetPhoneNumber_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider);
            this.rotateTo = RemoveDeepLinkPayload_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<MixpanelDeeplinkTracker> provider3 = this.OtpRegistrationPresenter$input$2;
            fullstoryDeeplinkTracker_Factory = FullstoryDeeplinkTracker_Factory.InstanceHolder.getAuthRequestContext;
            DeeplinkTrackerFactory_Factory authRequestContext15 = DeeplinkTrackerFactory_Factory.getAuthRequestContext(provider3, fullstoryDeeplinkTracker_Factory);
            this.isLayoutRequested = authRequestContext15;
            Provider<DeepLinkPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(DeepLinkPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.FlowableKt$toIterable$1, this.j, this.J, this.V, this.GetContactSyncConfig, this.rotateTo, authRequestContext15));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext16;
            this.getIndexName = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvidePresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext16));
            this.initAnimators = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetBottomSheetOnBoarding_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.BannerEntityDataFactory_Factory);
            SaveDisplayBottomSheetOnBoarding_Factory create10 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.DebugCoroutineInfoImpl, this.TypefaceCompatApi26Impl, this.BannerEntityDataFactory_Factory);
            this.BaseSocialFeedContract$Presenter = create10;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory4 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initAnimators, this.VerifyPinStateManager$executeRiskChallenge$2$2, create10);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory4;
            this.y = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory4));
            this.SendMoneyScenario = ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory.getAuthRequestContext(scanQrAnalyticModule, this.initRecordTimeStamp);
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.Z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent getAuthRequestContext;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ConcurrentKt());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.QrExpiredActivity());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.access$throwIllegalArgumentType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent PlaceComponentResult;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        @Override // id.dana.di.component.ScannerComponent
        public final void MyBillsEntityDataFactory(ScannerFragment scannerFragment) {
            scannerFragment.decodePresenter = this.secondaryHash.get();
            ScannerFragment_MembersInjector.PlaceComponentResult(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.getDefaultSenderId));
            ScannerFragment_MembersInjector.moveToNextValue(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.OtpRegistrationPresenter$input$1));
            ScannerFragment_MembersInjector.scheduleImpl(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.getContainerAuth));
            ScannerFragment_MembersInjector.MyBillsEntityDataFactory(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.insertActivities));
            ScannerFragment_MembersInjector.getErrorConfigVersion(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.ApiStatus$AvailableSince));
            ScannerFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.getIndexName));
            ScannerFragment_MembersInjector.lookAheadTest(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.JsonParseException));
            scannerFragment.featurePresenter = DoubleCheck.MyBillsEntityDataFactory(this.checkRegisteredUserAndSendOtp);
            scannerFragment.scanQrPresenter = DoubleCheck.MyBillsEntityDataFactory(this.getContainerAuth);
            scannerFragment.timerUtil = DoubleCheck.MyBillsEntityDataFactory(TimerUtil_Factory.getAuthRequestContext());
            ScannerFragment_MembersInjector.getAuthRequestContext(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.y));
            ScannerFragment_MembersInjector.GetContactSyncConfig(scannerFragment, DoubleCheck.MyBillsEntityDataFactory(this.SendMoneyScenario));
        }
    }
}
