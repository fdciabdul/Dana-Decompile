package id.dana.di.component;

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
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.referraltracker.ReferralTrackerPresenter;
import id.dana.contract.referraltracker.ReferralTrackerPresenter_Factory;
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
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.di.modules.ReferralTrackerModule_ProvidePresenterFactory;
import id.dana.di.modules.ReferralTrackerModule_ProvideViewFactory;
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
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate;
import id.dana.domain.featureconfig.interactor.GetReferralMessageTemplate_Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
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
import id.dana.domain.referral.interactor.GetLatestReferralCampaign;
import id.dana.domain.referral.interactor.GetLatestReferralCampaign_Factory;
import id.dana.domain.referral.interactor.GetReferralBanner;
import id.dana.domain.referral.interactor.GetReferralBanner_Factory;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign;
import id.dana.domain.referral.interactor.SaveLastSeenReferralCampaign_Factory;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.interactor.GetReferralTracker_Factory;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets;
import id.dana.domain.referralwidget.interactor.GetReferralWidgets_Factory;
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
import id.dana.domain.synccontact.interactor.SyncOneContact;
import id.dana.domain.synccontact.interactor.SyncOneContact_Factory;
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
import id.dana.mapper.ReferralTrackerModelMapper_Factory;
import id.dana.mapper.ReferralWidgetModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.MyReferralDetailActivity;
import id.dana.referral.MyReferralDetailActivity_MembersInjector;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.referral.model.ReferralBannerMapper_Factory;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper_Factory;
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
public final class DaggerReferralTrackerComponent {
    private DaggerReferralTrackerComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FeatureModule BuiltInFictitiousFunctionClassFactory;
        public OauthModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public ReferralTrackerModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public ServicesModule getErrorConfigVersion;
        public RestoreUrlModule lookAheadTest;
        public ScanQrModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ReferralTrackerComponentImpl implements ReferralTrackerComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<ScanQrPresenter> ApiStatus$AvailableSince;
        private Provider<GetKycLevel> AppCompatEmojiTextHelper;
        private Provider<GetAddingNameWhitelistedMerchantId> B;
        private Provider<GetCashierNativeConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAuthCode> C;
        private Provider<ThreadExecutor> CYFMonitor$ChallengeActionCallback;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<FeedsConfigRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkView> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrBarcode> E;
        private Provider<GetIsCardBindingV2Enabled> F;
        private Provider<IsNativeDecodeEnabled> FillAnimation;
        private Provider<OauthRepository> FlowViewUtil$textChanges$1;
        private Provider<OauthView> FlowViewUtil$textChanges$2;
        private Provider<UserEducationRepository> FlowableConcatMapEagerPublisher;
        private Provider<ReferralTrackerPresenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<SplitBillHistoryToSplitBillModelMapper> FlowableKt$toIterable$1;
        private Provider<ReferralTrackerRepository> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureScanQR> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServices> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetFeedConfig> H;
        private Provider<GetFavoriteServiceWithCacheFirst> I;
        private Provider<ServicesRepository> InitSecurePreferenceAccount;
        private Provider<GetMerchantQrWhitelist> J;
        private Provider<RestoreUrlView> JsonParseException;
        private Provider<GetNickname> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetLatestReferralCampaign> L;
        private Provider<GetMissionDetail> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetQrBindingConfig> N;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ThirdPartyServicesMapper> NewMerchantCategoryAdapter;
        private Provider<GetPayerSplitBillDetail> O;
        private Provider<ReferralWidgetRepository> OtpRegistrationPresenter$input$1;
        private Provider<CardBindingRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetQrisCpmSendmoneyConfig> P;
        private Provider<CheckConsultFamilyAccount> PlaceComponentResult;
        private Provider<FeatureConfigRepository> PrepareContext;
        private Provider<ShortenerRepository> PromoCategoryPresenter$1;
        private Provider<GetPromoCenterVersion> Q;
        private Provider<GetUserLoanInfo> QrExpiredActivity;
        private Provider<GetReferralBanner> R;
        private Provider<ServiceCategoryMapper> ReferralMapper_Factory;
        private Provider<ServicesContract.View> RequestMoneyQrContract$View;
        private Provider<GetReferralWidgets> S;
        private Provider<ServicesPresenter> SendMoneyScenario;
        private Provider<PushVerifyTracker> SizeSelectors$OrSelector;
        private Provider<FeatureView> SubSequence;
        private Provider<GetRawServices> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetReferralTracker> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetReferralConsult> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesByName> T;
        private Provider<IsNeedToShowToolTip> TypeProjectionImpl;
        private Provider<ReadLinkPropertiesContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetService> U;
        private Provider<GetServicesByKey> V;
        private Provider<GetDecodeTciCoListConfig> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServiceHighlighted> W;
        private Provider<GetRequestMoneyInfoFeature> X;
        private Provider<GetSettingByKey> Y;
        private Provider<GetServicesWithCategory> Z;

        /* renamed from: a */
        private Provider<GetUserInfoWithKyc> f8155a;
        private Provider<SaveShowDialog> access$getCapacity$p;
        private Provider<SyncContactRepository> access$setShowcaseShowing$p;
        private Provider<PayerModelListMapper> access$throwIllegalArgumentType;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> b;
        private Provider<GetUserStatusInfo> c;
        private Provider<SaveShowToolTip> checkRegisteredUserAndSendOtp;
        private Provider<MyReferralConsultRepository> connectForeground;
        private Provider<GetWhitelistedSubMerchantId> d;
        private Provider<MixpanelDeeplinkTracker> e;
        private Provider<ValidateNativelyDecodedQr> encodingStream;
        private Provider<IsOfflineF2FPay> f;
        private Provider<GetSplitBillConfig> flip;
        private Provider<LiteAccountRepository> g;
        private Provider<CheckDeepLinkActionVisibility> getAuthRequestContext;
        private Provider<FeatureSplitBill> getCallingPid;
        private final ReferralTrackerComponentImpl getCardNumberOCR;
        private Provider<SaveLastSeenReferralCampaign> getContainerAuth;
        private Provider<RestoreUrlPresenter> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<UserConsentRepository> getFontAssetManager;
        private Provider<ScanResultMapper> getIndexName;
        private Provider<GetNearbyConfig> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<SplitBillRepository> getReadyFragment;
        private Provider<FeatureSettingMore> getSupportButtonTintMode;
        private Provider<GetFavoriteServiceRemote> getValueOfTouchPositionAbsolute;
        private Provider<MyReferralConsultMapper> h;
        private Provider<OauthPresenter> i;
        private Provider<OauthContract.View> initAnimators;
        private Provider<DeepLinkPayloadModelMapper> initRecordTimeStamp;
        private Provider<SyncOneContact> insertActivities;
        private Provider<GetReferralMessageTemplate> isAuth;
        private Provider<GetUpdateAvailability> isAuto;
        private Provider<DynamicUrlWrapper> isLayoutRequested;
        private Provider<UserRepository> isRegionMiniProgram;
        private Provider<ProductPageManager> j;
        private Provider<Activity> k;
        private Provider<PostExecutionThread> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<PromoQuestRepository> m;
        private Provider<ConnectionStatusReceiver> moveToNextValue;
        private Provider<PaylaterRepository> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<ReferralTrackerContract.Presenter> f8156o;
        private Provider<RestoreUrl> onDecodeSuccess;
        private Provider<FamilyAccountRepository> p;
        private Provider<RestoreUrlContract.Presenter> q;
        private Provider<ScanQrContract.Presenter> r;
        private Provider<FeatureSplitBillPay> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ScanQrView> f5877reduceIndexedz1zDJgo;
        private Provider<SettingRepository> retainOrRemoveAllInternal;
        private Provider<UpdateServiceHighlighted> rotateTo;
        private Provider<OauthContract.Presenter> s;
        private Provider<CheckShowReferralCodeFeature> scheduleImpl;
        private Provider<SSLPinningRepository> secondaryHash;
        private Provider<ReadDeepLinkProperties> setNetAuthId;
        private Provider<GetUserId> shouldRecycleViewType;
        private Provider<FeatureContract.Presenter> t;
        private Provider<ScanQrContract.View> u;
        private Provider<FeatureContract.View> v;
        private Provider<ReadLinkPropertiesPresenter> verifyNotNull;
        private Provider<ReferralTrackerContract.View> w;
        private Provider<GenerateLinkRepository> whenAvailable;
        private Provider<RestoreUrlContract.View> x;
        private Provider<QrBarcodeRepository> y;
        private Provider<DeepLinkContract.View> z;

        public /* synthetic */ ReferralTrackerComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ReferralTrackerModule referralTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, referralTrackerModule, applicationComponent);
        }

        private ReferralTrackerComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ReferralTrackerModule referralTrackerModule, ApplicationComponent applicationComponent) {
            ReferralTrackerModelMapper_Factory referralTrackerModelMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.getCardNumberOCR = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.CYFMonitor$ChallengeActionCallback = new ThreadExecutorProvider(applicationComponent);
            this.secondaryHash = new SSLPinningRepositoryProvider(applicationComponent);
            this.l = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PrepareContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, featureConfigRepositoryProvider);
            this.f = create;
            this.moveToNextValue = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.CYFMonitor$ChallengeActionCallback, this.secondaryHash, create);
            this.w = DoubleCheck.getAuthRequestContext(ReferralTrackerModule_ProvideViewFactory.MyBillsEntityDataFactory(referralTrackerModule));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.connectForeground = myReferralConsultRepositoryProvider;
            this.getContainerAuth = SaveLastSeenReferralCampaign_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, myReferralConsultRepositoryProvider);
            this.h = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            SyncContactRepositoryProvider syncContactRepositoryProvider = new SyncContactRepositoryProvider(applicationComponent);
            this.access$setShowcaseShowing$p = syncContactRepositoryProvider;
            this.insertActivities = SyncOneContact_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, syncContactRepositoryProvider, this.PrepareContext);
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.whenAvailable = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, generateLinkRepositoryProvider);
            this.R = GetReferralBanner_Factory.create(this.connectForeground, this.CYFMonitor$ChallengeActionCallback, this.l);
            ReferralTrackerRepositoryProvider referralTrackerRepositoryProvider = new ReferralTrackerRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = referralTrackerRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetReferralTracker_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, referralTrackerRepositoryProvider);
            ReferralWidgetRepositoryProvider referralWidgetRepositoryProvider = new ReferralWidgetRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = referralWidgetRepositoryProvider;
            this.S = GetReferralWidgets_Factory.create(referralWidgetRepositoryProvider);
            this.L = GetLatestReferralCampaign_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.connectForeground);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetReferralConsult_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.connectForeground);
            this.isAuth = GetReferralMessageTemplate_Factory.create(this.PrepareContext);
            Provider<ReferralTrackerContract.View> provider = this.w;
            ReferralWidgetModelMapper_Factory PlaceComponentResult = ReferralWidgetModelMapper_Factory.PlaceComponentResult();
            Provider<SaveLastSeenReferralCampaign> provider2 = this.getContainerAuth;
            Provider<MyReferralConsultMapper> provider3 = this.h;
            Provider<SyncOneContact> provider4 = this.insertActivities;
            Provider<GenerateReferralDeepLink> provider5 = this.A;
            Provider<GetReferralBanner> provider6 = this.R;
            ReferralBannerMapper_Factory MyBillsEntityDataFactory = ReferralBannerMapper_Factory.MyBillsEntityDataFactory();
            Provider<GetReferralTracker> provider7 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
            referralTrackerModelMapper_Factory = ReferralTrackerModelMapper_Factory.InstanceHolder.getAuthRequestContext;
            ReferralTrackerPresenter_Factory PlaceComponentResult2 = ReferralTrackerPresenter_Factory.PlaceComponentResult(provider, PlaceComponentResult, provider2, provider3, provider4, provider5, provider6, MyBillsEntityDataFactory, provider7, referralTrackerModelMapper_Factory, this.S, this.L, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.isAuth);
            this.FlowableCreate$BufferAsyncEmitter = PlaceComponentResult2;
            this.f8156o = DoubleCheck.getAuthRequestContext(ReferralTrackerModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(referralTrackerModule, PlaceComponentResult2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.k = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.f5877reduceIndexedz1zDJgo = authRequestContext2;
            this.u = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.y = qrBarcodeRepositoryProvider;
            this.E = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.y);
            this.getIndexName = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = userRepositoryProvider;
            this.c = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetCashierNativeConfig_Factory.create(this.PrepareContext);
            this.FillAnimation = IsNativeDecodeEnabled_Factory.create(this.PrepareContext);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.PrepareContext);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = create2;
            this.encodingStream = ValidateNativelyDecodedQr_Factory.create(create2);
            this.J = GetMerchantQrWhitelist_Factory.create(this.y);
            this.N = GetQrBindingConfig_Factory.create(this.PrepareContext);
            this.b = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.PrepareContext);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.n = providePaylaterRepositoryProvider;
            this.QrExpiredActivity = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = userEducationRepositoryProvider;
            this.P = GetQrisCpmSendmoneyConfig_Factory.create(this.PrepareContext, userEducationRepositoryProvider);
            this.access$getCapacity$p = SaveShowDialog_Factory.create(this.FlowableConcatMapEagerPublisher);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.u, this.E, this.D, this.getIndexName, this.GetContactSyncConfig, this.c, this.BottomSheetCardBindingView$watcherCardNumberView$1, GetNativelyDecodedQr_Factory.create(), this.FillAnimation, this.encodingStream, this.J, this.N, this.b, this.QrExpiredActivity, this.P, this.access$getCapacity$p));
            this.ApiStatus$AvailableSince = authRequestContext3;
            this.r = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.JsonParseException = authRequestContext4;
            this.x = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, shortenerRepositoryProvider);
            this.onDecodeSuccess = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.x, create3));
            this.getDefaultSenderId = authRequestContext5;
            this.q = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            this.scheduleImpl = CheckShowReferralCodeFeature_Factory.create(this.PrepareContext);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = settingRepositoryProvider;
            this.Y = GetSettingByKey_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.j = productPageManagerProvider;
            this.getSupportButtonTintMode = FeatureSettingMore_Factory.PlaceComponentResult(this.Y, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getReadyFragment = splitBillRepositoryProvider;
            this.O = GetPayerSplitBillDetail_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, splitBillRepositoryProvider);
            this.access$throwIllegalArgumentType = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult3 = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.access$throwIllegalArgumentType);
            this.FlowableKt$toIterable$1 = PlaceComponentResult3;
            this.readMicros = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.O, PlaceComponentResult3);
            this.flip = GetSplitBillConfig_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.PrepareContext);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.PrepareContext);
            this.X = create4;
            Provider<GetSplitBillConfig> provider8 = this.flip;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getCallingPid = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider8, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.m = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.M = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory2 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.e = MyBillsEntityDataFactory2;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.p = provideFamilyAccountRepositoryProvider;
            this.PlaceComponentResult = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.isLayoutRequested = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.F = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.e));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda2, this.scheduleImpl, this.h, this.A, this.getSupportButtonTintMode, this.readMicros, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.QrExpiredActivity, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda4));
            this.SubSequence = authRequestContext6;
            this.v = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.InitSecurePreferenceAccount = servicesRepositoryProvider;
            this.V = GetServicesByKey_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.ReferralMapper_Factory = authRequestContext7;
            this.NewMerchantCategoryAdapter = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.FlowViewUtil$textChanges$1 = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getFontAssetManager = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.FlowViewUtil$textChanges$1, create6);
            this.C = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.v, this.V, this.NewMerchantCategoryAdapter, create7, this.GetContactSyncConfig));
            this.getAuthRequestContext = CheckDeepLinkActionVisibility_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.PrepareContext);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.PrepareContext);
            this.getNameOrBuilderList = GetNearbyConfig_Factory.create(this.PrepareContext);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = provideFeedsConfigRepositoryProvider;
            this.H = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.Q = GetPromoCenterVersion_Factory.create(this.PrepareContext);
            this.isAuto = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckMyBillsVersionConfig_Factory.create(this.PrepareContext);
            this.SizeSelectors$OrSelector = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.InitSecurePreferenceAccount);
            this.U = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.v, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getAuthRequestContext, this.lookAheadTest, this.getNameOrBuilderList, this.H, this.Q, this.isAuto, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.SizeSelectors$OrSelector, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext8;
            this.t = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.FlowViewUtil$textChanges$2 = authRequestContext9;
            this.initAnimators = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.f8155a = GetUserInfoWithKyc_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.isRegionMiniProgram);
            this.K = GetNickname_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.BuiltInFictitiousFunctionClassFactory);
            this.d = GetWhitelistedSubMerchantId_Factory.create(this.PrepareContext);
            this.B = GetAddingNameWhitelistedMerchantId_Factory.create(this.PrepareContext);
            Provider<OauthContract.View> provider9 = this.initAnimators;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider9, oauthParamsModelMapper_Factory, this.AppCompatEmojiTextHelper, this.f8155a, this.K, this.d, this.B);
            this.i = KClassImpl$Data$declaredNonStaticMembers$2;
            this.s = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.RequestMoneyQrContract$View = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.TypeProjectionImpl = IsNeedToShowToolTip_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.FlowableConcatMapEagerPublisher);
            this.checkRegisteredUserAndSendOtp = SaveShowToolTip_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.FlowableConcatMapEagerPublisher);
            this.Z = GetServicesWithCategory_Factory.create(this.InitSecurePreferenceAccount);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.InitSecurePreferenceAccount);
            this.getValueOfTouchPositionAbsolute = GetFavoriteServiceRemote_Factory.create(this.InitSecurePreferenceAccount);
            this.T = GetServicesByName_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.InitSecurePreferenceAccount);
            this.G = GetFavoriteServices_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, this.InitSecurePreferenceAccount);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.PrepareContext);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetRawServices_Factory.create(this.InitSecurePreferenceAccount);
            this.I = GetFavoriteServiceWithCacheFirst_Factory.create(this.InitSecurePreferenceAccount);
            this.W = GetServiceHighlighted_Factory.create(this.InitSecurePreferenceAccount);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.InitSecurePreferenceAccount);
            this.rotateTo = create9;
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.RequestMoneyQrContract$View, this.C, this.NewMerchantCategoryAdapter, this.TypeProjectionImpl, this.checkRegisteredUserAndSendOtp, this.Z, this.getOnBoardingScenario, this.getValueOfTouchPositionAbsolute, this.T, this.V, this.G, this.getErrorConfigVersion, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.I, this.W, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.r, this.q, this.t, this.s, this.SendMoneyScenario, applicationProvider, this.QrExpiredActivity));
            this.DatabaseTableConfigUtil = authRequestContext10;
            this.z = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.setNetAuthId = ReadDeepLinkProperties_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.initRecordTimeStamp = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.g = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.CYFMonitor$ChallengeActionCallback, this.l, liteAccountRepositoryProvider);
            this.shouldRecycleViewType = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.z, this.setNetAuthId, this.initRecordTimeStamp, create10, this.e));
            this.verifyNotNull = authRequestContext11;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
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
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent PlaceComponentResult;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SyncContactRepositoryProvider implements Provider<SyncContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SyncContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SyncContactRepository get() {
                return (SyncContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.containsObjectForKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ReferralWidgetRepositoryProvider implements Provider<ReferralWidgetRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ReferralWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralWidgetRepository get() {
                return (ReferralWidgetRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isRegionMiniProgram());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
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
            private final ApplicationComponent PlaceComponentResult;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.PlaceComponentResult.shouldRecycleViewType());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SecuritySettingsActivity$createPinLauncher$2$1());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.ReferralTrackerComponent
        public final void getAuthRequestContext(MyReferralDetailActivity myReferralDetailActivity) {
            ((BaseActivity) myReferralDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myReferralDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(myReferralDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            MyReferralDetailActivity_MembersInjector.PlaceComponentResult(myReferralDetailActivity, this.f8156o.get());
            MyReferralDetailActivity_MembersInjector.MyBillsEntityDataFactory(myReferralDetailActivity, this.TypefaceCompatApi26Impl.get());
        }
    }
}
