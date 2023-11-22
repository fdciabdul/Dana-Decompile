package id.dana.sendmoney_v2.landing.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
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
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.contract.sendmoney.RecipientPresenter;
import id.dana.contract.sendmoney.RecipientPresenter_Factory;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter_Factory;
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
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.BillerX2BModule_ProvidePresenterFactory;
import id.dana.di.modules.BillerX2BModule_ProvideViewFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.RecipientActivityModule_ProvidePresenterFactory;
import id.dana.di.modules.RecipientActivityModule_ProvideViewFactory;
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
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
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
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentcontact.interactor.SaveRecentContact_Factory;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig_Factory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature_Factory;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix_Factory;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature_Factory;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B_Factory;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative_Factory;
import id.dana.domain.sendmoney.interactor.GetIsUserCertifiedGlobalSend;
import id.dana.domain.sendmoney.interactor.GetIsUserCertifiedGlobalSend_Factory;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitTransferMoney_Factory;
import id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend;
import id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
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
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
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
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransferVerifyUser;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransferVerifyUser_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sendmoney_v2.landing.SendMoneyActivity_MembersInjector;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter;
import id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyLandingModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyLandingModule_ProvidePresenterFactory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyLandingModule_ProvideViewFactory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
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

/* loaded from: classes5.dex */
public final class DaggerSendMoneyLandingComponent {
    private DaggerSendMoneyLandingComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public BillerX2BModule BuiltInFictitiousFunctionClassFactory;
        public ServicesModule GetContactSyncConfig;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public CheckoutH5EventModule MyBillsEntityDataFactory;
        public PlayStoreReviewModules NetworkUserEntityData$$ExternalSyntheticLambda0;
        public SendMoneyTrackerModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        public SendMoneyLandingModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public DeepLinkModule PlaceComponentResult;
        public BottomSheetOnBoardingModule getAuthRequestContext;
        public FeatureModule getErrorConfigVersion;
        public ScanQrModule initRecordTimeStamp;
        public RestoreUrlModule lookAheadTest;
        public RecipientActivityModule moveToNextValue;
        public OauthModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class SendMoneyLandingComponentImpl implements SendMoneyLandingComponent {
        private Provider<FeatureView> A;
        private Provider<PushVerifyTracker> ApiStatus$AvailableSince;
        private Provider<GetDecodedQrisTopUp> AppCompatEmojiTextHelper;
        private Provider<SendDigitalMoneyRepository> ArrayTable$1;
        private Provider<SendMoneyRepository> ArrayTable$2;
        private Provider<SaveShowDialog> ArrayTable$3;
        private Provider<FeatureSettingMore> B;
        private Provider<ServicesRepository> BannerEntityDataFactory_Factory;
        private Provider<SaveLastPlayStoreReviewShow> BaseSocialFeedContract$Presenter;
        private Provider<GenerateLinkRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureSplitBillPay> C;
        private Provider<ReadDeepLinkProperties> CYFMonitor$ChallengeActionCallback;
        private Provider<ScanResultMapper> CheckPromoQuestFeature;
        private Provider<ScanQrView> ConcurrentKt;
        private Provider<GetAuthCode> D;
        private Provider<MixpanelDeeplinkTracker> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckMyBillsVersionConfig> DatabaseTableConfigUtil;
        private Provider<ShortenerRepository> DebugCoroutineInfoImpl;
        private Provider<GenerateReferralDeepLink> E;
        private Provider<GetDecodedQrBarcode> F;
        private Provider<GetUserId> FillAnimation;
        private Provider<SendMoneyHomePresenter> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetWhitelistedSubMerchantId> FlowViewUtil$textChanges$1;
        private Provider<GetUserStatusInfo> FlowViewUtil$textChanges$2;
        private Provider<RecipientPresenter> FlowableConcatMapEagerPublisher;
        private Provider<PaylaterRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<DeepLinkContract.View> FlowableKt$toIterable$1;
        private Provider<PlayStoreReviewContract.Presenter> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureConfigRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetCashierNativeConfig> G;
        private Provider<ConnectionStatusReceiver> GetContactSyncConfig;
        private Provider<GetDecodeTciCoListConfig> H;
        private Provider<GetCheckoutH5Event> I;
        private Provider<BillerX2BContract.View> InitSecurePreferenceAccount;
        private Provider<SplitBillHistoryToSplitBillModelMapper> InvestmentWalletAdapter;
        private Provider<GetFavoriteServiceWithCacheFirst> J;
        private Provider<OauthContract.Presenter> JsonParseException;
        private Provider<GetEmptyUserInfo> K;
        private Provider<BottomSheetOnBoardingPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetFavoriteServiceRemote> L;
        private Provider<GetDefaultServiceWithCategory> M;
        private Provider<ValidateNativelyDecodedQr> MultiLanguageHttpClient;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetFeedConfig> N;
        private Provider<CheckConsultFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final CheckoutH5EventModule NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<QrBarcodeRepository> NewMerchantCategoryAdapter;
        private Provider<GetIsUserCertifiedGlobalSend> O;
        private Provider<BillerX2BContract.Presenter> OtpRegistrationPresenter$input$1;
        private Provider<LiteAccountRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetFeatureSendMoneyCashierNative> P;
        private Provider<BillerX2BPresenter> PlaceComponentResult;
        private Provider<UserConsentRepository> PlaybackStateCompat$MediaKeyAction;
        private Provider<DeepLinkView> PrepareContext;
        private Provider<ScanQrContract.View> PromoCategoryPresenter$1;
        private Provider<GetIsCardBindingV2Enabled> Q;
        private Provider<GetServicesWithCategory> QrExpiredActivity;
        private Provider<GetPayerSplitBillDetail> R;
        private Provider<RestoreUrlContract.View> ReferralMapper_Factory;
        private Provider<FamilyAccountRepository> RequestMoneyQrContract$View;
        private Provider<GetNearbyConfig> S;
        private Provider<ServicesPresenter> SchedulerPoolFactory;
        private Provider<SaveRecentGroup> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<SaveRecentBank> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<FeatureContract.View> SendMoneyScenario;
        private Provider<OauthView> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<ScanQrPresenter> f5923x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<SendMoneyMixpanelTracker> f5924x461046da;
        private Provider<FeaturePresenter> SubSequence;
        private Provider<GetKycLevel> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetMerchantQrWhitelist> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetReferralConsult> T;
        private Provider<ThirdPartyServicesMapper> TrackerKey$GlobalSearchOpenProperties;
        private Provider<GetUserInfo> TypeProjectionImpl;
        private Provider<Activity> TypefaceCompatApi26Impl;
        private Provider<GetRawServices> U;
        private Provider<GetQrisCpmSendmoneyConfig> V;
        private Provider<FeatureSplitBill> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<ServiceCategoryMapper> View$OnClickListener;
        private Provider<GetPromoCenterVersion> W;
        private final SendMoneyLandingComponentImpl WithdrawSavedCardChannelView;
        private Provider<RestoreUrl> WrappedDrawableState;
        private Provider<GetQrBindingConfig> X;
        private Provider<GetRequestMoneyInfoFeature> Y;
        private Provider<GetService> Z;

        /* renamed from: a */
        private Provider<GetSettingByKey> f8233a;
        private Provider<CheckoutH5EventContract.View> access$getCapacity$p;
        private Provider<QueryCardWithoutPrefix> access$setShowcaseShowing$p;
        private Provider<IsNativeDecodeEnabled> access$throwIllegalArgumentType;
        private Provider<SaveRecentContact> applyTrimPathIfNeeded;
        private Provider<GetSmartFrictionConfig> b;
        private Provider<GetServicesByName> c;
        private Provider<RecipientContract.View> checkRegisteredUserAndSendOtp;
        private Provider<GlobalSendRepository> connectForeground;
        private Provider<SaveShowToolTip> containsObjectForKey;
        private Provider<GetSplitBillConfig> d;
        private Provider<GetUserInfoWithKyc> e;
        private Provider<SSLPinningRepository> encodingStream;
        private Provider<GetUpdateAvailability> f;
        private Provider<GetReferralSendMoneyConfig> flip;
        private Provider<GetUserLoanInfo> g;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<FeatureServicesHandler> getCallingPid;
        private Provider<PlayStoreReviewContract.View> getCardNumberOCR;
        private Provider<ScanQrContract.Presenter> getContainerAuth;
        private Provider<FeatureContract.Presenter> getDefaultSenderId;
        private Provider<CheckDeepLinkActionVisibility> getErrorConfigVersion;
        private Provider<UpdateServiceHighlighted> getExceptionOrNull;
        private Provider<ReadLinkPropertiesPresenter> getFontAssetManager;
        private Provider<SendMoneyAnalyticTracker> getIndexName;
        private Provider<GetFavoriteServices> getNameOrBuilderList;
        private Provider<GetAllBillerX2B> getOnBoardingScenario;
        private Provider<UserRepository> getOpPackageName;
        private Provider<SettingRepository> getPhoneMask;
        private Provider<SaveDisplayBottomSheetOnBoarding> getRawPath;
        private Provider<KycAndDebitPayOptionContract.View> getReadyFragment;
        private Provider<ThreadExecutor> getRecommendationData;
        private Provider<FeaturePromoQuest> getSupportButtonTintMode;
        private Provider<RestoreUrlPresenter> getTextEndPadding;
        private Provider<GetBottomSheetOnBoarding> getValueOfTouchPositionAbsolute;
        private Provider<H5EventRepository> h;
        private Provider<InitGlobalTransferVerifyUser> i;
        private Provider<BottomSheetOnBoardingContract.View> initAnimators;
        private Provider<CheckWhitelistedValidDomain> initRecordTimeStamp;
        private Provider<ServicesContract.View> insertActivities;
        private Provider<GetMissionDetail> isAuth;
        private Provider<GetServicesByKey> isAuto;
        private Provider<SaveIsUserCertifiedGlobalSend> isInfoWindowShown;
        private Provider<Context> isLayoutRequested;
        private Provider<ReferralConfigRepository> isRegionMiniProgram;
        private Provider<IsNeedToShowPlayStoreReview> j;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> k;
        private Provider<IsNeedToShowToolTip> l;
        private Provider<CheckCardNoPrefixFeature> lookAheadTest;
        private Provider<InitTransferMoney> m;
        private Provider<CheckFavoriteServicesFeature> moveToNextValue;
        private Provider<MyReferralConsultMapper> n;
        private Provider<DeviceInformationProvider> newProxyInstance;

        /* renamed from: o */
        private Provider<MyReferralConsultRepository> f8234o;
        private Provider<KycAndDebitPayOptionContract.Presenter> onDecodeSuccess;
        private Provider<SplitBillRepository> onPolygonsChanged;
        private Provider<UserEducationRepository> outerType;
        private Provider<IsOfflineF2FPay> p;
        private Provider<OauthPresenter> q;
        private Provider<PlayStoreReviewPresenter> r;
        private Provider<FeatureScanQR> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ReadLinkPropertiesContract.Presenter> f5925reduceIndexedz1zDJgo;
        private Provider<OauthContract.View> retainOrRemoveAllInternal;
        private Provider<RecentRecipientRepository> rotateTo;
        private Provider<OauthRepository> s;
        private Provider<CheckBelowKitkatDialogX2BFeature> scheduleImpl;
        private Provider<RestoreUrlContract.Presenter> secondaryHash;
        private Provider<CardBindingRepository> setNetAuthId;
        private Provider<GetServiceHighlighted> shouldRecycleViewType;
        private Provider<PayerModelListMapper> t;
        private Provider<PlayStoreReviewRepository> u;
        private Provider<RestoreUrlView> useDaemonThreadFactory;
        private Provider<ProductPageManager> v;
        private Provider<RecipientContract.Presenter> verifyNotNull;
        private Provider<PromoQuestRepository> w;
        private Provider<FeaturePushVerify> whenAvailable;
        private Provider<PostExecutionThread> x;
        private Provider<FeedsConfigRepository> y;
        private Provider<BottomSheetOnBoardingContract.Presenter> z;

        public /* synthetic */ SendMoneyLandingComponentImpl(RecipientActivityModule recipientActivityModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, SendMoneyLandingModule sendMoneyLandingModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent, byte b) {
            this(recipientActivityModule, bottomSheetOnBoardingModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, sendMoneyLandingModule, billerX2BModule, sendMoneyTrackerModule, playStoreReviewModules, checkoutH5EventModule, applicationComponent);
        }

        private SendMoneyLandingComponentImpl(RecipientActivityModule recipientActivityModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, SendMoneyLandingModule sendMoneyLandingModule, BillerX2BModule billerX2BModule, SendMoneyTrackerModule sendMoneyTrackerModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.WithdrawSavedCardChannelView = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = checkoutH5EventModule;
            this.getRecommendationData = new ThreadExecutorProvider(applicationComponent);
            this.encodingStream = new SSLPinningRepositoryProvider(applicationComponent);
            this.x = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getRecommendationData, this.x, featureConfigRepositoryProvider);
            this.p = create;
            this.GetContactSyncConfig = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getRecommendationData, this.encodingStream, create);
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvideViewFactory.getAuthRequestContext(recipientActivityModule));
            this.scheduleImpl = CheckBelowKitkatDialogX2BFeature_Factory.create(this.getRecommendationData, this.x, this.FragmentBottomSheetPaymentSettingBinding);
            ReferralConfigRepositoryProvider referralConfigRepositoryProvider = new ReferralConfigRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = referralConfigRepositoryProvider;
            this.flip = GetReferralSendMoneyConfig_Factory.create(this.getRecommendationData, this.x, referralConfigRepositoryProvider);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.rotateTo = recentRecipientRepositoryProvider;
            this.SecuritySettingsActivity$createPinLauncher$2$2 = SaveRecentBank_Factory.create(this.getRecommendationData, this.x, recentRecipientRepositoryProvider);
            this.applyTrimPathIfNeeded = SaveRecentContact_Factory.create(this.getRecommendationData, this.x, this.rotateTo);
            this.b = GetSmartFrictionConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            SaveRecentGroup_Factory create2 = SaveRecentGroup_Factory.create(this.rotateTo);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = create2;
            Provider<RecipientPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(RecipientPresenter_Factory.PlaceComponentResult(this.checkRegisteredUserAndSendOtp, this.scheduleImpl, this.flip, this.SecuritySettingsActivity$createPinLauncher$2$2, this.applyTrimPathIfNeeded, this.b, create2));
            this.FlowableConcatMapEagerPublisher = authRequestContext;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(RecipientActivityModule_ProvidePresenterFactory.getAuthRequestContext(recipientActivityModule, authRequestContext));
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvideViewFactory.getAuthRequestContext(billerX2BModule));
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.ArrayTable$2 = sendMoneyRepositoryProvider;
            this.getOnBoardingScenario = GetAllBillerX2B_Factory.create(sendMoneyRepositoryProvider);
            SendDigitalMoneyRepositoryProvider sendDigitalMoneyRepositoryProvider = new SendDigitalMoneyRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = sendDigitalMoneyRepositoryProvider;
            this.lookAheadTest = CheckCardNoPrefixFeature_Factory.create(sendDigitalMoneyRepositoryProvider);
            this.access$setShowcaseShowing$p = QueryCardWithoutPrefix_Factory.create(this.ArrayTable$1);
            this.s = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.PlaybackStateCompat$MediaKeyAction = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create3 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.K = create3;
            this.D = GetAuthCode_Factory.create(this.s, create3);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.newProxyInstance = deviceInformationProviderProvider;
            Provider<BillerX2BPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(BillerX2BPresenter_Factory.PlaceComponentResult(this.InitSecurePreferenceAccount, this.getOnBoardingScenario, this.lookAheadTest, this.access$setShowcaseShowing$p, this.D, deviceInformationProviderProvider, this.SecuritySettingsActivity$createPinLauncher$2$2));
            this.PlaceComponentResult = authRequestContext2;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(BillerX2BModule_ProvidePresenterFactory.PlaceComponentResult(billerX2BModule, authRequestContext2));
            this.initAnimators = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.outerType = userEducationRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetBottomSheetOnBoarding_Factory.create(this.getRecommendationData, this.x, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create4 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.getRecommendationData, this.x, this.outerType);
            this.getRawPath = create4;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initAnimators, this.getValueOfTouchPositionAbsolute, create4);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            this.z = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            this.isLayoutRequested = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.TypefaceCompatApi26Impl = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.ConcurrentKt = authRequestContext4;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.NewMerchantCategoryAdapter = qrBarcodeRepositoryProvider;
            this.F = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.AppCompatEmojiTextHelper = GetDecodedQrisTopUp_Factory.create(this.getRecommendationData, this.x, this.NewMerchantCategoryAdapter);
            this.CheckPromoQuestFeature = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getOpPackageName = userRepositoryProvider;
            this.FlowViewUtil$textChanges$2 = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.G = GetCashierNativeConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.access$throwIllegalArgumentType = IsNativeDecodeEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            GetDecodeTciCoListConfig_Factory create5 = GetDecodeTciCoListConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.H = create5;
            this.MultiLanguageHttpClient = ValidateNativelyDecodedQr_Factory.create(create5);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetMerchantQrWhitelist_Factory.create(this.NewMerchantCategoryAdapter);
            this.X = GetQrBindingConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.k = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = providePaylaterRepositoryProvider;
            this.g = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.V = GetQrisCpmSendmoneyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.outerType);
            this.ArrayTable$3 = SaveShowDialog_Factory.create(this.outerType);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, this.PromoCategoryPresenter$1, this.F, this.AppCompatEmojiTextHelper, this.CheckPromoQuestFeature, this.newProxyInstance, this.FlowViewUtil$textChanges$2, this.G, GetNativelyDecodedQr_Factory.create(), this.access$throwIllegalArgumentType, this.MultiLanguageHttpClient, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.X, this.k, this.g, this.V, this.ArrayTable$3));
            this.f5923x461046d9 = authRequestContext5;
            this.getContainerAuth = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.isLayoutRequested));
            this.useDaemonThreadFactory = authRequestContext6;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.DebugCoroutineInfoImpl = shortenerRepositoryProvider;
            RestoreUrl_Factory create6 = RestoreUrl_Factory.create(this.getRecommendationData, this.x, shortenerRepositoryProvider);
            this.WrappedDrawableState = create6;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.ReferralMapper_Factory, create6));
            this.getTextEndPadding = authRequestContext7;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.f8234o = myReferralConsultRepositoryProvider;
            this.T = GetReferralConsult_Factory.create(this.getRecommendationData, this.x, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = CheckShowReferralCodeFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.n = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = generateLinkRepositoryProvider;
            this.E = GenerateReferralDeepLink_Factory.create(this.getRecommendationData, this.x, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getPhoneMask = settingRepositoryProvider;
            this.f8233a = GetSettingByKey_Factory.create(this.getRecommendationData, this.x, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.v = productPageManagerProvider;
            this.B = FeatureSettingMore_Factory.PlaceComponentResult(this.f8233a, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.onPolygonsChanged = splitBillRepositoryProvider;
            this.R = GetPayerSplitBillDetail_Factory.create(this.getRecommendationData, this.x, splitBillRepositoryProvider);
            this.t = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.t);
            this.InvestmentWalletAdapter = PlaceComponentResult;
            this.C = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.R, PlaceComponentResult);
            this.d = GetSplitBillConfig_Factory.create(this.getRecommendationData, this.x, this.FragmentBottomSheetPaymentSettingBinding);
            GetRequestMoneyInfoFeature_Factory create7 = GetRequestMoneyInfoFeature_Factory.create(this.getRecommendationData, this.x, this.FragmentBottomSheetPaymentSettingBinding);
            this.Y = create7;
            Provider<GetSplitBillConfig> provider = this.d;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create7, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.w = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create8 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.isAuth = create8;
            this.getSupportButtonTintMode = FeaturePromoQuest_Factory.getAuthRequestContext(create8, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.readMicros = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.isLayoutRequested));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.isLayoutRequested);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.RequestMoneyQrContract$View = provideFamilyAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.setNetAuthId = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory2 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.Q = BuiltInFictitiousFunctionClassFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.T, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.n, this.E, this.B, this.C, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getSupportButtonTintMode, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda8, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda5, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.g, FeatureMyBills_Factory.PlaceComponentResult(), this.whenAvailable));
            this.A = authRequestContext8;
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = servicesRepositoryProvider;
            this.isAuto = GetServicesByKey_Factory.create(this.getRecommendationData, this.x, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext9 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.isLayoutRequested);
            this.View$OnClickListener = authRequestContext9;
            ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory3 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext9);
            this.TrackerKey$GlobalSearchOpenProperties = BuiltInFictitiousFunctionClassFactory3;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SendMoneyScenario, this.isAuto, BuiltInFictitiousFunctionClassFactory3, this.D, this.newProxyInstance));
            this.getErrorConfigVersion = CheckDeepLinkActionVisibility_Factory.create(this.getRecommendationData, this.x, this.FragmentBottomSheetPaymentSettingBinding);
            this.initRecordTimeStamp = CheckWhitelistedValidDomain_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.S = GetNearbyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.y = provideFeedsConfigRepositoryProvider;
            this.N = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.W = GetPromoCenterVersion_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.f = GetUpdateAvailability_Factory.create(this.isLayoutRequested);
            this.DatabaseTableConfigUtil = CheckMyBillsVersionConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.ApiStatus$AvailableSince = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create9 = GetService_Factory.create(this.BannerEntityDataFactory_Factory);
            this.Z = create9;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.SendMoneyScenario, this.getCallingPid, this.getErrorConfigVersion, this.initRecordTimeStamp, this.S, this.N, this.W, this.f, this.DatabaseTableConfigUtil, this.ApiStatus$AvailableSince, create9));
            this.SubSequence = authRequestContext10;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.SizeSelectors$OrSelector = authRequestContext11;
            this.retainOrRemoveAllInternal = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.e = GetUserInfoWithKyc_Factory.create(this.getRecommendationData, this.x, this.getOpPackageName);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetNickname_Factory.create(this.getRecommendationData, this.x, this.getAuthRequestContext);
            this.FlowViewUtil$textChanges$1 = GetWhitelistedSubMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetAddingNameWhitelistedMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            Provider<OauthContract.View> provider2 = this.retainOrRemoveAllInternal;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.e, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.FlowViewUtil$textChanges$1, this.VerifyPinStateManager$executeRiskChallenge$2$2);
            this.q = KClassImpl$Data$declaredNonStaticMembers$2;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.insertActivities = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.l = IsNeedToShowToolTip_Factory.create(this.getRecommendationData, this.x, this.outerType);
            this.containsObjectForKey = SaveShowToolTip_Factory.create(this.getRecommendationData, this.x, this.outerType);
            this.QrExpiredActivity = GetServicesWithCategory_Factory.create(this.BannerEntityDataFactory_Factory);
            this.M = GetDefaultServiceWithCategory_Factory.create(this.BannerEntityDataFactory_Factory);
            this.L = GetFavoriteServiceRemote_Factory.create(this.BannerEntityDataFactory_Factory);
            this.c = GetServicesByName_Factory.create(this.getRecommendationData, this.x, this.BannerEntityDataFactory_Factory);
            this.getNameOrBuilderList = GetFavoriteServices_Factory.create(this.getRecommendationData, this.x, this.BannerEntityDataFactory_Factory);
            this.moveToNextValue = CheckFavoriteServicesFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.U = GetRawServices_Factory.create(this.BannerEntityDataFactory_Factory);
            this.J = GetFavoriteServiceWithCacheFirst_Factory.create(this.BannerEntityDataFactory_Factory);
            this.shouldRecycleViewType = GetServiceHighlighted_Factory.create(this.BannerEntityDataFactory_Factory);
            UpdateServiceHighlighted_Factory create10 = UpdateServiceHighlighted_Factory.create(this.BannerEntityDataFactory_Factory);
            this.getExceptionOrNull = create10;
            this.SchedulerPoolFactory = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.isLayoutRequested, this.insertActivities, this.D, this.TrackerKey$GlobalSearchOpenProperties, this.l, this.containsObjectForKey, this.QrExpiredActivity, this.M, this.L, this.c, this.isAuto, this.getNameOrBuilderList, this.moveToNextValue, this.U, this.J, this.shouldRecycleViewType, create10));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.getContainerAuth, this.secondaryHash, this.getDefaultSenderId, this.JsonParseException, this.SchedulerPoolFactory, applicationProvider, this.g));
            this.PrepareContext = authRequestContext12;
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.CYFMonitor$ChallengeActionCallback = ReadDeepLinkProperties_Factory.create(this.getRecommendationData, this.x);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = liteAccountRepositoryProvider;
            GetUserId_Factory create11 = GetUserId_Factory.create(this.getRecommendationData, this.x, liteAccountRepositoryProvider);
            this.FillAnimation = create11;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.FlowableKt$toIterable$1, this.CYFMonitor$ChallengeActionCallback, this.NetworkUserEntityData$$ExternalSyntheticLambda7, create11, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider));
            this.getFontAssetManager = authRequestContext13;
            this.f5925reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
            this.m = InitTransferMoney_Factory.create(this.getRecommendationData, this.x, this.ArrayTable$2);
            this.P = GetFeatureSendMoneyCashierNative_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(SendMoneyLandingModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendMoneyLandingModule));
            this.TypeProjectionImpl = GetUserInfo_Factory.create(this.getOpPackageName);
            GlobalSendRepositoryProvider globalSendRepositoryProvider = new GlobalSendRepositoryProvider(applicationComponent);
            this.connectForeground = globalSendRepositoryProvider;
            this.i = InitGlobalTransferVerifyUser_Factory.PlaceComponentResult(globalSendRepositoryProvider);
            this.isInfoWindowShown = SaveIsUserCertifiedGlobalSend_Factory.create(this.ArrayTable$2);
            GetIsUserCertifiedGlobalSend_Factory create12 = GetIsUserCertifiedGlobalSend_Factory.create(this.ArrayTable$2);
            this.O = create12;
            SendMoneyHomePresenter_Factory PlaceComponentResult2 = SendMoneyHomePresenter_Factory.PlaceComponentResult(this.isLayoutRequested, this.m, this.P, this.D, this.getReadyFragment, this.TypeProjectionImpl, this.i, this.isInfoWindowShown, create12);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = PlaceComponentResult2;
            this.onDecodeSuccess = DoubleCheck.getAuthRequestContext(SendMoneyLandingModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyLandingModule, PlaceComponentResult2));
            SendMoneyMixpanelTracker_Factory authRequestContext14 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.isLayoutRequested);
            this.f5924x461046da = authRequestContext14;
            this.getIndexName = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext14));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.h = h5eventRepositoryProvider;
            this.I = GetCheckoutH5Event_Factory.create(this.getRecommendationData, this.x, h5eventRepositoryProvider);
            this.access$getCapacity$p = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.u = playStoreReviewRepositoryProvider;
            this.j = IsNeedToShowPlayStoreReview_Factory.create(this.getRecommendationData, this.x, playStoreReviewRepositoryProvider);
            this.BaseSocialFeedContract$Presenter = SaveLastPlayStoreReviewShow_Factory.create(this.getRecommendationData, this.x, this.u);
            Provider<PlayStoreReviewContract.View> authRequestContext15 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.getCardNumberOCR = authRequestContext15;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory2 = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.j, this.BaseSocialFeedContract$Presenter, authRequestContext15);
            this.r = MyBillsEntityDataFactory2;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class ReferralConfigRepositoryProvider implements Provider<ReferralConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ReferralConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralConfigRepository get() {
                return (ReferralConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.insertActivities());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendDigitalMoneyRepositoryProvider implements Provider<SendDigitalMoneyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SendDigitalMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendDigitalMoneyRepository get() {
                return (SendDigitalMoneyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.encodingStream());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent PlaceComponentResult;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class GlobalSendRepositoryProvider implements Provider<GlobalSendRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GlobalSendRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSendRepository get() {
                return (GlobalSendRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.whenAvailable());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        @Override // id.dana.sendmoney_v2.landing.di.component.SendMoneyLandingComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyActivity sendMoneyActivity) {
            ((BaseActivity) sendMoneyActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendMoneyActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(sendMoneyActivity, DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding));
            SendMoneyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendMoneyActivity, this.verifyNotNull.get());
            SendMoneyActivity_MembersInjector.getAuthRequestContext(sendMoneyActivity, this.OtpRegistrationPresenter$input$1.get());
            SendMoneyActivity_MembersInjector.PlaceComponentResult(sendMoneyActivity, this.z.get());
            SendMoneyActivity_MembersInjector.PlaceComponentResult(sendMoneyActivity, this.f5925reduceIndexedz1zDJgo.get());
            SendMoneyActivity_MembersInjector.PlaceComponentResult(sendMoneyActivity, this.onDecodeSuccess.get());
            sendMoneyActivity.sendMoneyAnalyticTracker = this.getIndexName.get();
            SendMoneyActivity_MembersInjector.PlaceComponentResult(sendMoneyActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext()));
            SendMoneyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendMoneyActivity, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            SendMoneyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendMoneyActivity, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.I), DoubleCheck.MyBillsEntityDataFactory(this.access$getCapacity$p))));
            sendMoneyActivity.playStoreReviewPresenter = this.FlowableReduce$ReduceSubscriber.get();
        }
    }
}
