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
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.animation.promocenter.NewPromoCenterPresenter;
import id.dana.animation.promocenter.NewPromoCenterPresenter_Factory;
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
import id.dana.contract.feeds.GlobalFeedsContract;
import id.dana.contract.feeds.GlobalFeedsModule;
import id.dana.contract.feeds.GlobalFeedsModule_ProvidePresenterFactory;
import id.dana.contract.feeds.GlobalFeedsModule_ProvideViewFactory;
import id.dana.contract.feeds.GlobalFeedsPresenter;
import id.dana.contract.feeds.GlobalFeedsPresenter_Factory;
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
import id.dana.di.modules.NewPromoCenterModule;
import id.dana.di.modules.NewPromoCenterModule_ProvidePresenterFactory;
import id.dana.di.modules.NewPromoCenterModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
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
import id.dana.domain.featureconfig.interactor.GetPromoCenterConfig;
import id.dana.domain.featureconfig.interactor.GetPromoCenterConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.interactor.GetGlobalFeeds_Factory;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig_Factory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.interactor.GetNewsWidgetActivitiesFromPersistence;
import id.dana.domain.home.interactor.GetNewsWidgetActivitiesFromPersistence_Factory;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence_Factory;
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
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
import id.dana.richview.NewPromoCenterView;
import id.dana.richview.NewPromoCenterView_MembersInjector;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNewPromoCenterComponent {
    private DaggerNewPromoCenterComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public NewPromoCenterModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public GlobalFeedsModule PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public OauthModule lookAheadTest;
        public ScanQrModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewPromoCenterComponentImpl implements NewPromoCenterComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<RestoreUrlPresenter> ApiStatus$AvailableSince;
        private Provider<GetEmptyUserInfo> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GetAddingNameWhitelistedMerchantId> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private Provider<ThirdPartyServicesMapper> CYFMonitor$ChallengeActionCallback;
        private Provider<GetDefaultServiceWithCategory> D;
        private Provider<Activity> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DynamicUrlWrapper> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrisTopUp> E;
        private Provider<GetFavoriteServices> F;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> FillAnimation;
        private Provider<MixpanelAnalytics> FlowViewUtil$textChanges$1;
        private Provider<MyReferralConsultMapper> FlowViewUtil$textChanges$2;
        private Provider<UpdateServiceHighlighted> FlowableConcatMapEagerPublisher;
        private Provider<ScanQrContract.View> FlowableCreate$BufferAsyncEmitter;
        private Provider<ShortenerRepository> FlowableKt$toIterable$1;
        private Provider<RestoreUrlContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceRemote> G;
        private Provider<DeepLinkView> GetContactSyncConfig;
        private Provider<GetFeedConfig> H;
        private Provider<GetFavoriteServiceWithCacheFirst> I;
        private Provider<SaveShowToolTip> InitSecurePreferenceAccount;
        private Provider<GetIsCardBindingV2Enabled> J;
        private Provider<DeepLinkContract.View> JsonParseException;
        private Provider<GetKycLevel> K;
        private Provider<CheckDeepLinkActionVisibility> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMerchantQrWhitelist> L;
        private Provider<GetGlobalFeeds> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetNearbyConfig> N;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<SettingRepository> NewMerchantCategoryAdapter;
        private Provider<GetPayerSplitBillDetail> O;
        private Provider<FeatureContract.View> OtpRegistrationPresenter$input$1;
        private Provider<ProductPageManager> OtpRegistrationPresenter$input$2;
        private Provider<GetNickname> P;
        private Provider<AnalyticsTrackerFactory> PlaceComponentResult;
        private Provider<FeaturePresenter> PrepareContext;
        private Provider<ScanResultMapper> PromoCategoryPresenter$1;
        private Provider<GetNewsWidgetActivitiesFromPersistence> Q;
        private Provider<GetUserInfoWithKyc> QrExpiredActivity;
        private Provider<GetRawServices> R;
        private Provider<ServiceCategoryMapper> ReferralMapper_Factory;
        private Provider<ReadLinkPropertiesContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetPromoCenterVersion> S;
        private Provider<ScanQrView> SendMoneyScenario;
        private Provider<CardBindingRepository> SizeSelectors$OrSelector;
        private Provider<FirebaseAnalytics> SubSequence;
        private Provider<GetPromoCenterConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetQrBindingConfig> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesByKey> T;
        private Provider<LiteAccountRepository> TypeProjectionImpl;
        private Provider<ScanQrContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetServicesByName> U;
        private Provider<GetServiceHighlighted> V;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDecodedQrBarcode> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetRequestMoneyInfoFeature> W;
        private Provider<UserRepository> WrappedDrawableState;
        private Provider<GetService> X;
        private Provider<GetServicesWithCategory> Y;
        private Provider<GetSettingByKey> Z;

        /* renamed from: a */
        private Provider<GetUserLoanInfo> f8138a;
        private Provider<RestoreUrlView> access$getCapacity$p;
        private Provider<ServicesPresenter> access$setShowcaseShowing$p;
        private Provider<OauthPresenter> access$throwIllegalArgumentType;
        private Provider<GetUserStatusInfo> b;
        private Provider<GlobalFeedsPresenter> c;
        private Provider<SaveNewsWidgetActivitiesIntoPersistence> checkRegisteredUserAndSendOtp;
        private final NewPromoCenterComponentImpl connectForeground;
        private Provider<GetWhitelistedSubMerchantId> d;
        private Provider<HomeTrackerImpl> e;
        private Provider<ValidateNativelyDecodedQr> encodingStream;
        private Provider<IsNeedToShowToolTip> f;
        private Provider<GetSplitBillConfig> flip;
        private Provider<IsNativeDecodeEnabled> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<FeatureSplitBillPay> getCallingPid;
        private Provider<NewPromoCenterContract.View> getCardNumberOCR;
        private Provider<QrBarcodeRepository> getContainerAuth;
        private Provider<ReadLinkPropertiesPresenter> getDefaultSenderId;
        private Provider<Context> getErrorConfigVersion;
        private Provider<SplitBillRepository> getFontAssetManager;
        private Provider<SaveShowDialog> getIndexName;
        private Provider<GetMissionDetail> getNameOrBuilderList;
        private Provider<GetDecodeTciCoListConfig> getOnBoardingScenario;
        private Provider<ServicesRepository> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetDefaultFeedFromConfig> getValueOfTouchPositionAbsolute;
        private Provider<MixpanelDeeplinkTracker> h;
        private Provider<MyReferralConsultRepository> i;
        private Provider<FeatureContract.Presenter> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<SplitBillHistoryToSplitBillModelMapper> insertActivities;
        private Provider<GetReferralConsult> isAuth;
        private Provider<GetUserId> isAuto;
        private Provider<FeatureFamilyAccount> isLayoutRequested;
        private Provider<ThreadExecutor> isRegionMiniProgram;
        private Provider<OauthRepository> j;
        private Provider<OauthView> k;
        private Provider<PayerModelListMapper> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<NewPromoCenterPresenter> m;
        private Provider<CheckShowReferralCodeFeature> moveToNextValue;
        private Provider<PromoQuestRepository> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<EventTrackerQueue> f8139o;
        private Provider<ReadDeepLinkProperties> onDecodeSuccess;
        private Provider<PostExecutionThread> p;
        private Provider<FirebasePerformanceMonitor> q;
        private Provider<FamilyAccountRepository> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrl> f5867reduceIndexedz1zDJgo;
        private Provider<ScanQrPresenter> retainOrRemoveAllInternal;
        private Provider<UserConsentRepository> rotateTo;
        private Provider<FeedsConfigRepository> s;
        private Provider<CheckMyBillsVersionConfig> scheduleImpl;
        private Provider<ServicesContract.View> secondaryHash;
        private Provider<GlobalFeedsContract.View> setNetAuthId;
        private Provider<GetUpdateAvailability> shouldRecycleViewType;
        private Provider<HomeWidgetRepository> t;
        private Provider<PaylaterRepository> u;
        private Provider<UserEducationRepository> useDaemonThreadFactory;
        private Provider<NewPromoCenterContract.Presenter> v;
        private Provider<OauthContract.View> verifyNotNull;
        private Provider<GlobalFeedsContract.Presenter> w;
        private Provider<FeedsRepository> whenAvailable;
        private Provider<RestoreUrlContract.Presenter> x;
        private Provider<OauthContract.Presenter> y;
        private Provider<PushVerifyTracker> z;

        public /* synthetic */ NewPromoCenterComponentImpl(NewPromoCenterModule newPromoCenterModule, GlobalFeedsModule globalFeedsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(newPromoCenterModule, globalFeedsModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private NewPromoCenterComponentImpl(NewPromoCenterModule newPromoCenterModule, GlobalFeedsModule globalFeedsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.connectForeground = this;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(GlobalFeedsModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(globalFeedsModule));
            this.isRegionMiniProgram = new ThreadExecutorProvider(applicationComponent);
            this.p = new PostExecutionThreadProvider(applicationComponent);
            FeedsRepositoryProvider feedsRepositoryProvider = new FeedsRepositoryProvider(applicationComponent);
            this.whenAvailable = feedsRepositoryProvider;
            this.M = GetGlobalFeeds_Factory.create(this.isRegionMiniProgram, this.p, feedsRepositoryProvider);
            this.getValueOfTouchPositionAbsolute = GetDefaultFeedFromConfig_Factory.create(this.isRegionMiniProgram, this.p, this.whenAvailable);
            ProvideHomeWidgetRepositoryProvider provideHomeWidgetRepositoryProvider = new ProvideHomeWidgetRepositoryProvider(applicationComponent);
            this.t = provideHomeWidgetRepositoryProvider;
            this.checkRegisteredUserAndSendOtp = SaveNewsWidgetActivitiesIntoPersistence_Factory.create(provideHomeWidgetRepositoryProvider);
            Provider<GlobalFeedsContract.View> provider = this.setNetAuthId;
            Provider<GetGlobalFeeds> provider2 = this.M;
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            Provider<GlobalFeedsPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GlobalFeedsPresenter_Factory.BuiltInFictitiousFunctionClassFactory(provider, provider2, feedsModelMapper_Factory, this.getValueOfTouchPositionAbsolute, this.checkRegisteredUserAndSendOtp));
            this.c = authRequestContext;
            this.w = DoubleCheck.getAuthRequestContext(GlobalFeedsModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(globalFeedsModule, authRequestContext));
            this.getCardNumberOCR = NewPromoCenterModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(newPromoCenterModule);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = featureConfigRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetPromoCenterConfig_Factory.create(this.isRegionMiniProgram, this.p, featureConfigRepositoryProvider);
            this.S = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetNewsWidgetActivitiesFromPersistence_Factory create = GetNewsWidgetActivitiesFromPersistence_Factory.create(this.t);
            this.Q = create;
            Provider<NewPromoCenterPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(NewPromoCenterPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getCardNumberOCR, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.S, create, this.checkRegisteredUserAndSendOtp));
            this.m = authRequestContext2;
            this.v = NewPromoCenterModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(newPromoCenterModule, authRequestContext2);
            this.getErrorConfigVersion = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.SendMoneyScenario = authRequestContext4;
            this.FlowableCreate$BufferAsyncEmitter = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.getContainerAuth = qrBarcodeRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.E = GetDecodedQrisTopUp_Factory.create(this.isRegionMiniProgram, this.p, this.getContainerAuth);
            this.PromoCategoryPresenter$1 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.WrappedDrawableState = userRepositoryProvider;
            this.b = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetCashierNativeConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.g = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getOnBoardingScenario = create2;
            this.encodingStream = ValidateNativelyDecodedQr_Factory.create(create2);
            this.L = GetMerchantQrWhitelist_Factory.create(this.getContainerAuth);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.FillAnimation = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.u = providePaylaterRepositoryProvider;
            this.f8138a = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.useDaemonThreadFactory = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, userEducationRepositoryProvider);
            this.getIndexName = SaveShowDialog_Factory.create(this.useDaemonThreadFactory);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.FlowableCreate$BufferAsyncEmitter, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.E, this.PromoCategoryPresenter$1, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.b, this.VerifyPinStateManager$executeRiskChallenge$2$1, GetNativelyDecodedQr_Factory.create(), this.g, this.encodingStream, this.L, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.FillAnimation, this.f8138a, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.getIndexName));
            this.retainOrRemoveAllInternal = authRequestContext5;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.getErrorConfigVersion));
            this.access$getCapacity$p = authRequestContext6;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.isRegionMiniProgram, this.p, shortenerRepositoryProvider);
            this.f5867reduceIndexedz1zDJgo = create3;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.FlowableReduce$ReduceSubscriber, create3));
            this.ApiStatus$AvailableSince = authRequestContext7;
            this.x = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.i = myReferralConsultRepositoryProvider;
            this.isAuth = GetReferralConsult_Factory.create(this.isRegionMiniProgram, this.p, myReferralConsultRepositoryProvider);
            this.moveToNextValue = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.FlowViewUtil$textChanges$2 = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.isRegionMiniProgram, this.p, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.NewMerchantCategoryAdapter = settingRepositoryProvider;
            this.Z = GetSettingByKey_Factory.create(this.isRegionMiniProgram, this.p, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeatureSettingMore_Factory.PlaceComponentResult(this.Z, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getFontAssetManager = splitBillRepositoryProvider;
            this.O = GetPayerSplitBillDetail_Factory.create(this.isRegionMiniProgram, this.p, splitBillRepositoryProvider);
            this.l = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.l);
            this.insertActivities = PlaceComponentResult;
            this.getCallingPid = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.O, PlaceComponentResult);
            this.flip = GetSplitBillConfig_Factory.create(this.isRegionMiniProgram, this.p, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.isRegionMiniProgram, this.p, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.W = create4;
            Provider<GetSplitBillConfig> provider3 = this.flip;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider3, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.n = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.getNameOrBuilderList = create5;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.getErrorConfigVersion));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.getErrorConfigVersion);
            this.h = MyBillsEntityDataFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.r = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.DatabaseTableConfigUtil = dynamicUrlWrapperProvider;
            this.isLayoutRequested = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.J = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.h));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.isAuth, this.moveToNextValue, this.FlowViewUtil$textChanges$2, this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.getCallingPid, this.getSupportButtonTintMode, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.f8138a, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.readMicros = authRequestContext8;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.getReadyFragment = servicesRepositoryProvider;
            this.T = GetServicesByKey_Factory.create(this.isRegionMiniProgram, this.p, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext9 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.getErrorConfigVersion);
            this.ReferralMapper_Factory = authRequestContext9;
            this.CYFMonitor$ChallengeActionCallback = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext9);
            this.j = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.rotateTo = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.AppCompatEmojiTextHelper = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.j, create6);
            this.B = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.OtpRegistrationPresenter$input$1, this.T, this.CYFMonitor$ChallengeActionCallback, create7, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckDeepLinkActionVisibility_Factory.create(this.isRegionMiniProgram, this.p, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.N = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.s = provideFeedsConfigRepositoryProvider;
            this.H = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.shouldRecycleViewType = GetUpdateAvailability_Factory.create(this.getErrorConfigVersion);
            this.scheduleImpl = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.z = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.getReadyFragment);
            this.X = create8;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.OtpRegistrationPresenter$input$1, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.N, this.H, this.S, this.shouldRecycleViewType, this.scheduleImpl, this.z, create8));
            this.PrepareContext = authRequestContext10;
            this.initAnimators = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.k = authRequestContext11;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.K = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.QrExpiredActivity = GetUserInfoWithKyc_Factory.create(this.isRegionMiniProgram, this.p, this.WrappedDrawableState);
            this.P = GetNickname_Factory.create(this.isRegionMiniProgram, this.p, this.BuiltInFictitiousFunctionClassFactory);
            this.d = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<OauthContract.View> provider4 = this.verifyNotNull;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider4, oauthParamsModelMapper_Factory, this.K, this.QrExpiredActivity, this.P, this.d, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.access$throwIllegalArgumentType = KClassImpl$Data$declaredNonStaticMembers$2;
            this.y = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.secondaryHash = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.f = IsNeedToShowToolTip_Factory.create(this.isRegionMiniProgram, this.p, this.useDaemonThreadFactory);
            this.InitSecurePreferenceAccount = SaveShowToolTip_Factory.create(this.isRegionMiniProgram, this.p, this.useDaemonThreadFactory);
            this.Y = GetServicesWithCategory_Factory.create(this.getReadyFragment);
            this.D = GetDefaultServiceWithCategory_Factory.create(this.getReadyFragment);
            this.G = GetFavoriteServiceRemote_Factory.create(this.getReadyFragment);
            this.U = GetServicesByName_Factory.create(this.isRegionMiniProgram, this.p, this.getReadyFragment);
            this.F = GetFavoriteServices_Factory.create(this.isRegionMiniProgram, this.p, this.getReadyFragment);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.R = GetRawServices_Factory.create(this.getReadyFragment);
            this.I = GetFavoriteServiceWithCacheFirst_Factory.create(this.getReadyFragment);
            this.V = GetServiceHighlighted_Factory.create(this.getReadyFragment);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.getReadyFragment);
            this.FlowableConcatMapEagerPublisher = create9;
            this.access$setShowcaseShowing$p = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.secondaryHash, this.B, this.CYFMonitor$ChallengeActionCallback, this.f, this.InitSecurePreferenceAccount, this.Y, this.D, this.G, this.U, this.T, this.F, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.R, this.I, this.V, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.TypefaceCompatApi26Impl, this.x, this.initAnimators, this.y, this.access$setShowcaseShowing$p, applicationProvider, this.f8138a));
            this.GetContactSyncConfig = authRequestContext12;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.onDecodeSuccess = ReadDeepLinkProperties_Factory.create(this.isRegionMiniProgram, this.p);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.TypeProjectionImpl = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.isRegionMiniProgram, this.p, liteAccountRepositoryProvider);
            this.isAuto = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.JsonParseException, this.onDecodeSuccess, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create10, this.h));
            this.getDefaultSenderId = authRequestContext13;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
            this.q = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.f8139o = provideEventTrackerQueueProvider;
            this.SubSequence = FirebaseAnalytics_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.q, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$22 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.f8139o);
            this.FlowViewUtil$textChanges$1 = KClassImpl$Data$declaredNonStaticMembers$22;
            Provider<FirebaseAnalytics> provider5 = this.SubSequence;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult2 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider5, KClassImpl$Data$declaredNonStaticMembers$22, fullStoryAnalytics_Factory);
            this.PlaceComponentResult = PlaceComponentResult2;
            this.e = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
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
        public static final class FeedsRepositoryProvider implements Provider<FeedsRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeedsRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsRepository get() {
                return (FeedsRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetRepositoryProvider implements Provider<HomeWidgetRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideHomeWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetRepository get() {
                return (HomeWidgetRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.q());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
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
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.applyTrimPathIfNeeded());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isInfoWindowShown());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent getAuthRequestContext;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        @Override // id.dana.di.component.NewPromoCenterComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(NewPromoCenterView newPromoCenterView) {
            NewPromoCenterView_MembersInjector.BuiltInFictitiousFunctionClassFactory(newPromoCenterView, DoubleCheck.MyBillsEntityDataFactory(this.w));
            NewPromoCenterView_MembersInjector.PlaceComponentResult(newPromoCenterView, DoubleCheck.MyBillsEntityDataFactory(this.v));
            NewPromoCenterView_MembersInjector.MyBillsEntityDataFactory(newPromoCenterView, DoubleCheck.MyBillsEntityDataFactory(this.RequestMoneyQrContract$View));
            newPromoCenterView.homeTrackerImpl = DoubleCheck.MyBillsEntityDataFactory(this.e);
        }
    }
}
