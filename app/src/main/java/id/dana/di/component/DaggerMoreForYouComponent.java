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
import id.dana.di.modules.MoreForYouModule;
import id.dana.di.modules.MoreForYouModule_ProvideMoreForYouPresenterFactory;
import id.dana.di.modules.MoreForYouModule_ProvideMoreForYouViewFactory;
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
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import id.dana.domain.csatsurvey.interactor.DismissCsatSurvey;
import id.dana.domain.csatsurvey.interactor.DismissCsatSurvey_Factory;
import id.dana.domain.csatsurvey.interactor.GetCsatSurveyCreatedDate;
import id.dana.domain.csatsurvey.interactor.GetCsatSurveyCreatedDate_Factory;
import id.dana.domain.csatsurvey.interactor.SaveCsatSurveyCreatedDate;
import id.dana.domain.csatsurvey.interactor.SaveCsatSurveyCreatedDate_Factory;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
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
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.interactor.GetMoreForYouDataFromPersistence;
import id.dana.domain.home.interactor.GetMoreForYouDataFromPersistence_Factory;
import id.dana.domain.home.interactor.SaveMoreForYouDataIntoPersistence;
import id.dana.domain.home.interactor.SaveMoreForYouDataIntoPersistence_Factory;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetHomeInfo_Factory;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo_Factory;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.moreforyou.GetMoreForYou;
import id.dana.domain.moreforyou.GetMoreForYou_Factory;
import id.dana.domain.moreforyou.MoreForYouRepository;
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
import id.dana.richview.moreforyou.MoreForYouContract;
import id.dana.richview.moreforyou.MoreForYouModelMapper_Factory;
import id.dana.richview.moreforyou.MoreForYouPresenter;
import id.dana.richview.moreforyou.MoreForYouPresenter_Factory;
import id.dana.richview.moreforyou.MoreForYouView;
import id.dana.richview.moreforyou.MoreForYouView_MembersInjector;
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
public final class DaggerMoreForYouComponent {
    private DaggerMoreForYouComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OauthModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public DeepLinkModule PlaceComponentResult;
        public MoreForYouModule getAuthRequestContext;
        public ScanQrModule getErrorConfigVersion;
        public RestoreUrlModule lookAheadTest;
        public ServicesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MoreForYouComponentImpl implements MoreForYouComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<RestoreUrl> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServices> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GenerateLinkRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> C;
        private Provider<ShortenerRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<GetCsatSurveyCreatedDate> D;
        private Provider<PostExecutionThread> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkPayloadModelMapper> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrBarcode> E;
        private Provider<GetDefaultServiceWithCategory> F;
        private Provider<IsNativeDecodeEnabled> FillAnimation;
        private Provider<MixpanelAnalytics> FlowViewUtil$textChanges$1;
        private final MoreForYouComponentImpl FlowViewUtil$textChanges$2;
        private Provider<SplitBillRepository> FlowableConcatMapEagerPublisher;
        private Provider<PushVerifyTracker> FlowableCreate$BufferAsyncEmitter;
        private Provider<ScanQrPresenter> FlowableKt$toIterable$1;
        private Provider<ScanQrContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePresenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceRemote> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetEmptyUserInfo> H;
        private Provider<GetFavoriteServiceWithCacheFirst> I;
        private Provider<SaveCsatSurveyCreatedDate> InitSecurePreferenceAccount;
        private Provider<GetHomeInfo> J;
        private Provider<DeepLinkContract.View> JsonParseException;
        private Provider<GetFeedConfig> K;
        private Provider<CheckDeepLinkActionVisibility> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetKycLevel> L;
        private Provider<GetIsCardBindingV2Enabled> M;
        private Provider<AnalyticsTrackerFactory> MyBillsEntityDataFactory;
        private Provider<GetMoreForYouDataFromPersistence> N;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ScanResultMapper> NewMerchantCategoryAdapter;
        private Provider<GetMoreForYou> O;
        private Provider<StartupConfigEntityData> OtpRegistrationPresenter$input$1;
        private Provider<OauthView> OtpRegistrationPresenter$input$2;
        private Provider<GetMissionDetail> P;
        private Provider<CheckConsultFamilyAccount> PlaceComponentResult;
        private Provider<FeatureCardBinding> PrepareContext;
        private Provider<RestoreUrlView> PromoCategoryPresenter$1;
        private Provider<GetNickname> Q;
        private Provider<GetUserLoanInfo> QrExpiredActivity;
        private Provider<GetQrBindingConfig> R;
        private Provider<SaveShowToolTip> ReferralMapper_Factory;
        private Provider<RestoreUrlContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetPayerSplitBillDetail> S;
        private Provider<UserRepository> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<SaveMoreForYouDataIntoPersistence> SendMoneyScenario;
        private Provider<EventTrackerQueue> SizeSelectors$OrSelector;
        private Provider<FeatureView> SubSequence;
        private Provider<GetNearbyConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetPromoCenterVersion> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServiceHighlighted> T;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> TypeProjectionImpl;
        private Provider<HomeOmniRepository> TypefaceCompatApi26Impl;
        private Provider<GetServicesByKey> U;
        private Provider<GetReferralConsult> V;
        private Provider<FirebaseAnalytics> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetRequestMoneyInfoFeature> W;
        private Provider<UpdateServiceHighlighted> WrappedDrawableState;
        private Provider<GetService> X;
        private Provider<GetSplitBillConfig> Y;
        private Provider<GetServicesByName> Z;

        /* renamed from: a */
        private Provider<GetUserStatusInfo> f8130a;
        private Provider<ReadDeepLinkProperties> access$getCapacity$p;
        private Provider<ScanQrView> access$setShowcaseShowing$p;
        private Provider<MoreForYouPresenter> access$throwIllegalArgumentType;
        private Provider<ValidateNativelyDecodedQr> applyTrimPathIfNeeded;
        private Provider<GetUserInfoWithKyc> b;
        private Provider<GetUpdateAvailability> c;
        private Provider<QrBarcodeRepository> checkRegisteredUserAndSendOtp;
        private Provider<IsNeedToShowToolTip> connectForeground;
        private Provider<GetUserId> d;
        private Provider<HomeTrackerImpl> e;
        private Provider<ThreadExecutor> encodingStream;
        private Provider<HomeInfoRepository> f;
        private Provider<GetServicesWithCategory> flip;
        private Provider<GetWhitelistedSubMerchantId> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<ReadLinkPropertiesContract.Presenter> getCardNumberOCR;
        private Provider<FeatureContract.View> getContainerAuth;
        private Provider<ServicesContract.View> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<SettingRepository> getFontAssetManager;
        private Provider<ReadLinkPropertiesPresenter> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetDecodeTciCoListConfig> getOnBoardingScenario;
        private Provider<UserConsentRepository> getRawPath;
        private Provider<ServicesPresenter> getReadyFragment;
        private Provider<FeatureServicesHandler> getSupportButtonTintMode;
        private Provider<UserEducationRepository> getTextEndPadding;
        private Provider<GetDecodedQrisTopUp> getValueOfTouchPositionAbsolute;
        private Provider<LiteAccountRepository> h;
        private Provider<MixpanelDeeplinkTracker> i;
        private Provider<ScanQrContract.Presenter> initAnimators;
        private Provider<CsatSurveyRepository> initRecordTimeStamp;
        private Provider<ServiceCategoryMapper> insertActivities;
        private Provider<GetRawServices> isAuth;
        private Provider<GetSettingByKey> isAuto;
        private Provider<FeatureConfigRepository> isLayoutRequested;
        private Provider<ServicesRepository> isRegionMiniProgram;
        private Provider<MyReferralConsultMapper> j;
        private Provider<OauthRepository> k;
        private Provider<OauthPresenter> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<MyReferralConsultRepository> m;
        private Provider<Context> moveToNextValue;
        private Provider<PromoQuestRepository> n;
        private Provider<DismissCsatSurvey> newProxyInstance;

        /* renamed from: o */
        private Provider<PayerModelListMapper> f8131o;
        private Provider<RestoreUrlContract.View> onDecodeSuccess;
        private Provider<ProductPageManager> p;
        private Provider<Activity> q;
        private Provider<FirebasePerformanceMonitor> r;
        private Provider<FeatureSplitBill> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrlPresenter> f5858reduceIndexedz1zDJgo;
        private Provider<SaveShowDialog> retainOrRemoveAllInternal;
        private Provider<SplitBillHistoryToSplitBillModelMapper> rotateTo;
        private Provider<FamilyAccountRepository> s;
        private Provider<CheckFavoriteServicesFeature> scheduleImpl;
        private Provider<OauthContract.View> secondaryHash;
        private Provider<PaylaterRepository> setNetAuthId;
        private Provider<GetSurveyInfo> shouldRecycleViewType;
        private Provider<FeedsConfigRepository> t;
        private Provider<MoreForYouRepository> u;
        private Provider<ThirdPartyServicesMapper> useDaemonThreadFactory;
        private Provider<MoreForYouContract.Presenter> v;
        private Provider<OauthContract.Presenter> verifyNotNull;
        private Provider<HomeWidgetRepository> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<MoreForYouContract.View> x;
        private Provider<CardBindingRepository> y;
        private Provider<FeatureContract.Presenter> z;

        public /* synthetic */ MoreForYouComponentImpl(MoreForYouModule moreForYouModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(moreForYouModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private MoreForYouComponentImpl(MoreForYouModule moreForYouModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.FlowViewUtil$textChanges$2 = this;
            this.x = MoreForYouModule_ProvideMoreForYouViewFactory.BuiltInFictitiousFunctionClassFactory(moreForYouModule);
            this.moveToNextValue = new ContextProvider(applicationComponent);
            ProvideMoreForYouRepositoryProvider provideMoreForYouRepositoryProvider = new ProvideMoreForYouRepositoryProvider(applicationComponent);
            this.u = provideMoreForYouRepositoryProvider;
            this.O = GetMoreForYou_Factory.create(provideMoreForYouRepositoryProvider);
            this.encodingStream = new ThreadExecutorProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            HomeRepositoryProvider homeRepositoryProvider = new HomeRepositoryProvider(applicationComponent);
            this.f = homeRepositoryProvider;
            this.J = GetHomeInfo_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, homeRepositoryProvider);
            CsatSurveyRepositoryProvider csatSurveyRepositoryProvider = new CsatSurveyRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = csatSurveyRepositoryProvider;
            this.InitSecurePreferenceAccount = SaveCsatSurveyCreatedDate_Factory.create(csatSurveyRepositoryProvider);
            this.D = GetCsatSurveyCreatedDate_Factory.create(this.initRecordTimeStamp);
            this.newProxyInstance = DismissCsatSurvey_Factory.create(this.initRecordTimeStamp);
            this.OtpRegistrationPresenter$input$1 = new ProvideStartupConfigEntityDataProvider(applicationComponent);
            ProvideHomeOmniRepositoryProvider provideHomeOmniRepositoryProvider = new ProvideHomeOmniRepositoryProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = provideHomeOmniRepositoryProvider;
            this.shouldRecycleViewType = GetSurveyInfo_Factory.create(provideHomeOmniRepositoryProvider);
            ProvideHomeWidgetRepositoryProvider provideHomeWidgetRepositoryProvider = new ProvideHomeWidgetRepositoryProvider(applicationComponent);
            this.w = provideHomeWidgetRepositoryProvider;
            this.N = GetMoreForYouDataFromPersistence_Factory.create(provideHomeWidgetRepositoryProvider);
            this.SendMoneyScenario = SaveMoreForYouDataIntoPersistence_Factory.create(this.w);
            MoreForYouPresenter_Factory create = MoreForYouPresenter_Factory.create(this.x, this.moveToNextValue, this.O, MoreForYouModelMapper_Factory.create(), this.J, this.InitSecurePreferenceAccount, this.D, this.newProxyInstance, this.OtpRegistrationPresenter$input$1, this.shouldRecycleViewType, this.N, this.SendMoneyScenario);
            this.access$throwIllegalArgumentType = create;
            this.v = MoreForYouModule_ProvideMoreForYouPresenterFactory.MyBillsEntityDataFactory(moreForYouModule, create);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.q = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.access$setShowcaseShowing$p = authRequestContext2;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.checkRegisteredUserAndSendOtp = qrBarcodeRepositoryProvider;
            this.E = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.getValueOfTouchPositionAbsolute = GetDecodedQrisTopUp_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.checkRegisteredUserAndSendOtp);
            this.NewMerchantCategoryAdapter = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = userRepositoryProvider;
            this.f8130a = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.isLayoutRequested = featureConfigRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.FillAnimation = IsNativeDecodeEnabled_Factory.create(this.isLayoutRequested);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.isLayoutRequested);
            this.getOnBoardingScenario = create2;
            this.applyTrimPathIfNeeded = ValidateNativelyDecodedQr_Factory.create(create2);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.checkRegisteredUserAndSendOtp);
            this.R = GetQrBindingConfig_Factory.create(this.isLayoutRequested);
            this.TypeProjectionImpl = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.isLayoutRequested);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.setNetAuthId = providePaylaterRepositoryProvider;
            this.QrExpiredActivity = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getTextEndPadding = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetQrisCpmSendmoneyConfig_Factory.create(this.isLayoutRequested, userEducationRepositoryProvider);
            this.retainOrRemoveAllInternal = SaveShowDialog_Factory.create(this.getTextEndPadding);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, this.FlowableReduce$ReduceSubscriber, this.E, this.getValueOfTouchPositionAbsolute, this.NewMerchantCategoryAdapter, this.GetContactSyncConfig, this.f8130a, this.VerifyPinStateManager$executeRiskChallenge$2$2, GetNativelyDecodedQr_Factory.create(), this.FillAnimation, this.applyTrimPathIfNeeded, this.getNameOrBuilderList, this.R, this.TypeProjectionImpl, this.QrExpiredActivity, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.retainOrRemoveAllInternal));
            this.FlowableKt$toIterable$1 = authRequestContext3;
            this.initAnimators = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.moveToNextValue));
            this.PromoCategoryPresenter$1 = authRequestContext4;
            this.onDecodeSuccess = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, shortenerRepositoryProvider);
            this.ApiStatus$AvailableSince = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.onDecodeSuccess, create3));
            this.f5858reduceIndexedz1zDJgo = authRequestContext5;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.m = myReferralConsultRepositoryProvider;
            this.V = GetReferralConsult_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.isLayoutRequested);
            this.j = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getFontAssetManager = settingRepositoryProvider;
            this.isAuto = GetSettingByKey_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.p = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.isAuto, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = splitBillRepositoryProvider;
            this.S = GetPayerSplitBillDetail_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, splitBillRepositoryProvider);
            this.f8131o = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.f8131o);
            this.rotateTo = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.S, PlaceComponentResult);
            this.Y = GetSplitBillConfig_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.isLayoutRequested);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.isLayoutRequested);
            this.W = create4;
            Provider<GetSplitBillConfig> provider = this.Y;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.readMicros = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.n = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.P = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.moveToNextValue));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.moveToNextValue);
            this.i = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.s = provideFamilyAccountRepositoryProvider;
            this.PlaceComponentResult = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.y = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.M = BuiltInFictitiousFunctionClassFactory;
            this.PrepareContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.i));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.V, this.lookAheadTest, this.j, this.A, this.getCallingPid, this.whenAvailable, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda1, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda5, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.PrepareContext, this.QrExpiredActivity, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.SubSequence = authRequestContext6;
            this.getContainerAuth = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = servicesRepositoryProvider;
            this.U = GetServicesByKey_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.moveToNextValue);
            this.insertActivities = authRequestContext7;
            this.useDaemonThreadFactory = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.k = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getRawPath = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.H = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.k, create6);
            this.B = create7;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getContainerAuth, this.U, this.useDaemonThreadFactory, create7, this.GetContactSyncConfig));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckDeepLinkActionVisibility_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.isLayoutRequested);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckWhitelistedValidDomain_Factory.create(this.isLayoutRequested);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetNearbyConfig_Factory.create(this.isLayoutRequested);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.t = provideFeedsConfigRepositoryProvider;
            this.K = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetPromoCenterVersion_Factory.create(this.isLayoutRequested);
            this.c = GetUpdateAvailability_Factory.create(this.moveToNextValue);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.isLayoutRequested);
            this.FlowableCreate$BufferAsyncEmitter = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.isRegionMiniProgram);
            this.X = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.getContainerAuth, this.getSupportButtonTintMode, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.K, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.c, this.getErrorConfigVersion, this.FlowableCreate$BufferAsyncEmitter, create8));
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext8;
            this.z = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.OtpRegistrationPresenter$input$2 = authRequestContext9;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.L = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.b = GetUserInfoWithKyc_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.SecuritySettingsActivity$createPinLauncher$2$1);
            this.Q = GetNickname_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.BuiltInFictitiousFunctionClassFactory);
            this.g = GetWhitelistedSubMerchantId_Factory.create(this.isLayoutRequested);
            this.C = GetAddingNameWhitelistedMerchantId_Factory.create(this.isLayoutRequested);
            Provider<OauthContract.View> provider2 = this.secondaryHash;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.L, this.b, this.Q, this.g, this.C);
            this.l = KClassImpl$Data$declaredNonStaticMembers$2;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.getDefaultSenderId = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.connectForeground = IsNeedToShowToolTip_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.getTextEndPadding);
            this.ReferralMapper_Factory = SaveShowToolTip_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.getTextEndPadding);
            this.flip = GetServicesWithCategory_Factory.create(this.isRegionMiniProgram);
            this.F = GetDefaultServiceWithCategory_Factory.create(this.isRegionMiniProgram);
            this.G = GetFavoriteServiceRemote_Factory.create(this.isRegionMiniProgram);
            this.Z = GetServicesByName_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.isRegionMiniProgram);
            this.AppCompatEmojiTextHelper = GetFavoriteServices_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.isRegionMiniProgram);
            this.scheduleImpl = CheckFavoriteServicesFeature_Factory.create(this.isLayoutRequested);
            this.isAuth = GetRawServices_Factory.create(this.isRegionMiniProgram);
            this.I = GetFavoriteServiceWithCacheFirst_Factory.create(this.isRegionMiniProgram);
            this.T = GetServiceHighlighted_Factory.create(this.isRegionMiniProgram);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.isRegionMiniProgram);
            this.WrappedDrawableState = create9;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.moveToNextValue, this.getDefaultSenderId, this.B, this.useDaemonThreadFactory, this.connectForeground, this.ReferralMapper_Factory, this.flip, this.F, this.G, this.Z, this.U, this.AppCompatEmojiTextHelper, this.scheduleImpl, this.isAuth, this.I, this.T, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.initAnimators, this.RequestMoneyQrContract$View, this.z, this.verifyNotNull, this.getReadyFragment, applicationProvider, this.QrExpiredActivity));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext10;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.access$getCapacity$p = ReadDeepLinkProperties_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.h = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.encodingStream, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, liteAccountRepositoryProvider);
            this.d = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.JsonParseException, this.access$getCapacity$p, this.DatabaseTableConfigUtil, create10, this.i));
            this.getIndexName = authRequestContext11;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
            this.r = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.SizeSelectors$OrSelector = provideEventTrackerQueueProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FirebaseAnalytics_Factory.PlaceComponentResult(this.moveToNextValue, this.r, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$22 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, this.SizeSelectors$OrSelector);
            this.FlowViewUtil$textChanges$1 = KClassImpl$Data$declaredNonStaticMembers$22;
            Provider<FirebaseAnalytics> provider3 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult2 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider3, KClassImpl$Data$declaredNonStaticMembers$22, fullStoryAnalytics_Factory);
            this.MyBillsEntityDataFactory = PlaceComponentResult2;
            this.e = HomeTrackerImpl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2);
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
        public static final class ProvideMoreForYouRepositoryProvider implements Provider<MoreForYouRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideMoreForYouRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MoreForYouRepository get() {
                return (MoreForYouRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.u());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
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
        public static final class HomeRepositoryProvider implements Provider<HomeInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            HomeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeInfoRepository get() {
                return (HomeInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class CsatSurveyRepositoryProvider implements Provider<CsatSurveyRepository> {
            private final ApplicationComponent PlaceComponentResult;

            CsatSurveyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CsatSurveyRepository get() {
                return (CsatSurveyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.initRecordTimeStamp());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideStartupConfigEntityDataProvider implements Provider<StartupConfigEntityData> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideStartupConfigEntityDataProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ StartupConfigEntityData get() {
                return (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.onDecodeSuccess());
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
        public static final class ProvideHomeWidgetRepositoryProvider implements Provider<HomeWidgetRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideHomeWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetRepository get() {
                return (HomeWidgetRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.q());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent getAuthRequestContext;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$1());
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
            private final ApplicationComponent getAuthRequestContext;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent PlaceComponentResult;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.OtpRegistrationPresenter$input$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.getAuthRequestContext.j());
            }
        }

        @Override // id.dana.di.component.MoreForYouComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MoreForYouView moreForYouView) {
            MoreForYouView_MembersInjector.injectPresenter(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.v));
            MoreForYouView_MembersInjector.injectReadDeepLinkPropertiesPresenter(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.getCardNumberOCR));
            MoreForYouView_MembersInjector.injectHomeTrackerImpl(moreForYouView, DoubleCheck.MyBillsEntityDataFactory(this.e));
        }
    }
}
