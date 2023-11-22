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
import id.dana.contract.deeplink.DeepLinkModule_ProvideViewFactory;
import id.dana.contract.deeplink.DeepLinkView;
import id.dana.contract.deeplink.DeepLinkView_Factory;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.FeatureModule_ProvidePresenterFactory;
import id.dana.contract.deeplink.FeatureModule_ProvideViewFactory;
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
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.contract.promodiscovery.PromoDiscoveryPresenter;
import id.dana.contract.promodiscovery.PromoDiscoveryPresenter_Factory;
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
import id.dana.di.modules.PromoDiscoveryModule;
import id.dana.di.modules.PromoDiscoveryModule_ProvidePresenterFactory;
import id.dana.di.modules.PromoDiscoveryModule_ProvidePromoDiscoveryAnalyticTrackerFactory;
import id.dana.di.modules.PromoDiscoveryModule_ProvideViewFactory;
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
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.domain.geocode.interactor.GetLatestSubdivision_Factory;
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
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList_Factory;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.domain.promocenter.interactor.GetPromoList_Factory;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.domain.promodiscovery.interactor.GetDanaDealsThumbnail;
import id.dana.domain.promodiscovery.interactor.GetDanaDealsThumbnail_Factory;
import id.dana.domain.promodiscovery.interactor.GetFourKingsPromo;
import id.dana.domain.promodiscovery.interactor.GetFourKingsPromo_Factory;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion_Factory;
import id.dana.domain.promodiscovery.interactor.GetPromoDiscoverySectionConfig;
import id.dana.domain.promodiscovery.interactor.GetPromoDiscoverySectionConfig_Factory;
import id.dana.domain.promodiscovery.interactor.SwitchFourKingsPromoRedDot;
import id.dana.domain.promodiscovery.interactor.SwitchFourKingsPromoRedDot_Factory;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
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
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.promodiscovery.views.PromoDiscoveryFragment;
import id.dana.promodiscovery.views.PromoDiscoveryFragment_MembersInjector;
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
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPromoDiscoveryComponent {
    private DaggerPromoDiscoveryComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public PromoDiscoveryModule PlaceComponentResult;
        public OauthModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public ServicesModule lookAheadTest;
        public ScanQrModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PromoDiscoveryComponentImpl implements PromoDiscoveryComponent {
        private Provider<GetDanaDealsThumbnail> A;
        private Provider<ScanQrView> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServices> AppCompatEmojiTextHelper;
        private Provider<GeocodeRepository> B;
        private Provider<GetAuthCode> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> C;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<PromoQuestRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DanaCustomH5> DatabaseTableConfigUtil;
        private Provider<GetDefaultServiceWithCategory> E;
        private Provider<GetFourKingsPromo> F;
        private Provider<IsNativeDecodeEnabled> FillAnimation;
        private Provider<MyReferralConsultMapper> FlowViewUtil$textChanges$1;
        private Provider<OauthPresenter> FlowViewUtil$textChanges$2;
        private Provider<UserConsentRepository> FlowableConcatMapEagerPublisher;
        private Provider<ReadDeepLinkProperties> FlowableCreate$BufferAsyncEmitter;
        private Provider<ThreadExecutor> FlowableKt$toIterable$1;
        private Provider<QrBarcodeRepository> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureServicesHandler> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceWithCacheFirst> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetFeedConfig> H;
        private Provider<GetFavoriteServiceRemote> I;
        private Provider<SettingRepository> InitSecurePreferenceAccount;
        private Provider<GetIsCardBindingV2Enabled> J;
        private Provider<RestoreUrlPresenter> JsonParseException;
        private Provider<GetMerchantQrWhitelist> K;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetLatestSubdivision> L;
        private Provider<GetKycLevel> M;
        private Provider<CheckConsultFamilyAccount> MyBillsEntityDataFactory;
        private Provider<GetPromoCenterVersion> N;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ThirdPartyServicesMapper> NewMerchantCategoryAdapter;
        private Provider<GetNickname> O;
        private Provider<ServicesContract.View> OtpRegistrationPresenter$input$1;
        private Provider<Activity> OtpRegistrationPresenter$input$2;
        private Provider<GetPromoCategorizedList> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<FeaturePresenter> PrepareContext;
        private Provider<ServicesPresenter> PromoCategoryPresenter$1;
        private Provider<GetPayerSplitBillDetail> Q;
        private Provider<GetUserLoanInfo> QrExpiredActivity;
        private Provider<GetQrBindingConfig> R;
        private Provider<ShortenerRepository> ReferralMapper_Factory;
        private Provider<OauthContract.View> RequestMoneyQrContract$View;
        private Provider<GetQrisCpmSendmoneyConfig> S;
        private Provider<SplitBillHistoryToSplitBillModelMapper> SendMoneyScenario;
        private Provider<FeedsConfigRepository> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetNearbyConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetPromoDiscoverySectionConfig> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetPromoList> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetReferralConsult> T;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> TypeProjectionImpl;
        private Provider<OauthContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetServiceHighlighted> U;
        private Provider<GetRequestMoneyInfoFeature> V;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetService> W;
        private Provider<GetServicesByKey> X;
        private Provider<GetServicesWithCategory> Y;
        private Provider<GetSplitBillConfig> Z;

        /* renamed from: a */
        private Provider<GetUserStatusInfo> f8153a;
        private Provider<ScanQrPresenter> access$getCapacity$p;
        private Provider<SwitchFourKingsPromoRedDot> access$setShowcaseShowing$p;
        private final PromoDiscoveryComponentImpl access$throwIllegalArgumentType;
        private Provider<GetWhitelistedSubMerchantId> b;
        private Provider<GetUserId> c;
        private Provider<ServiceCategoryMapper> checkRegisteredUserAndSendOtp;
        private Provider<OauthView> connectForeground;
        private Provider<GetUserInfoWithKyc> d;
        private Provider<IsNeedToShowToolTip> e;
        private Provider<MixpanelDeeplinkTracker> f;
        private Provider<GetServicesByName> flip;
        private Provider<LiteAccountRepository> g;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<DeepLinkContract.View> getCardNumberOCR;
        private Provider<ReferralSettingConfigRunner> getContainerAuth;
        private Provider<RestoreUrl> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<UserRepository> getFontAssetManager;
        private Provider<SaveShowToolTip> getIndexName;
        private Provider<GetMissionDetail> getNameOrBuilderList;
        private Provider<GetDecodeTciCoListConfig> getOnBoardingScenario;
        private Provider<UpdateServiceHighlighted> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private Provider<OauthRepository> h;
        private Provider<MyReferralConsultRepository> i;
        private Provider<FeatureContract.View> initAnimators;
        private Provider<DeepLinkView> initRecordTimeStamp;
        private Provider<SplitBillRepository> insertActivities;
        private Provider<GetRawServices> isAuth;
        private Provider<GetUpdateAvailability> isAuto;
        private Provider<FeatureOauth> isLayoutRequested;
        private Provider<ValidateNativelyDecodedQr> isRegionMiniProgram;
        private Provider<ProductPageManager> j;
        private Provider<PromoCenterRepository> k;
        private Provider<PayerModelListMapper> l;
        private Provider<CheckFavoriteServicesFeature> lookAheadTest;
        private Provider<PostExecutionThread> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private final PromoDiscoveryModule n;
        private Provider<FeatureCardBinding> newProxyInstance;

        /* renamed from: o */
        private Provider<PromoDiscoveryRepository> f8154o;
        private Provider<SaveShowDialog> onDecodeSuccess;
        private Provider<PromoDiscoveryPresenter> p;
        private Provider<PromoDiscoveryContract.Presenter> q;
        private Provider<CardBindingRepository> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ScanResultMapper> f5876reduceIndexedz1zDJgo;
        private Provider<ServicesRepository> retainOrRemoveAllInternal;
        private Provider<UserEducationRepository> rotateTo;
        private Provider<FamilyAccountRepository> s;
        private Provider<CheckWhitelistedValidDomain> scheduleImpl;
        private Provider<RestoreUrlView> secondaryHash;
        private Provider<RestoreUrlContract.View> setNetAuthId;
        private Provider<GetSettingByKey> shouldRecycleViewType;
        private Provider<PaylaterRepository> t;
        private Provider<PushVerifyTracker> u;
        private Provider<FeatureContract.Presenter> v;
        private Provider<ReadLinkPropertiesPresenter> verifyNotNull;
        private Provider<RestoreUrlContract.Presenter> w;
        private Provider<GenerateReferralDeepLink> whenAvailable;
        private Provider<ScanQrContract.Presenter> x;
        private Provider<ScanQrContract.View> y;
        private Provider<PromoDiscoveryContract.View> z;

        public /* synthetic */ PromoDiscoveryComponentImpl(PromoDiscoveryModule promoDiscoveryModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(promoDiscoveryModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private PromoDiscoveryComponentImpl(PromoDiscoveryModule promoDiscoveryModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.access$throwIllegalArgumentType = this;
            this.n = promoDiscoveryModule;
            this.getAuthRequestContext = applicationComponent;
            this.z = DoubleCheck.getAuthRequestContext(PromoDiscoveryModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(promoDiscoveryModule));
            PromoDiscoveryRepositoryProvider promoDiscoveryRepositoryProvider = new PromoDiscoveryRepositoryProvider(applicationComponent);
            this.f8154o = promoDiscoveryRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetPromoDiscoverySectionConfig_Factory.create(promoDiscoveryRepositoryProvider);
            PromoCenterRepositoryProvider promoCenterRepositoryProvider = new PromoCenterRepositoryProvider(applicationComponent);
            this.k = promoCenterRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetPromoList_Factory.create(promoCenterRepositoryProvider);
            this.P = GetPromoCategorizedList_Factory.create(this.k);
            this.A = GetDanaDealsThumbnail_Factory.create(this.f8154o);
            this.getCallingPid = new GenerateLinkRepositoryProvider(applicationComponent);
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.i = myReferralConsultRepositoryProvider;
            this.getContainerAuth = ReferralSettingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getCallingPid, myReferralConsultRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = featureConfigRepositoryProvider;
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(featureConfigRepositoryProvider);
            this.FlowViewUtil$textChanges$1 = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.F = GetFourKingsPromo_Factory.create(this.f8154o);
            this.access$setShowcaseShowing$p = SwitchFourKingsPromoRedDot_Factory.create(this.f8154o);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.B = geocodeRepositoryProvider;
            this.L = GetLatestSubdivision_Factory.create(geocodeRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = servicesRepositoryProvider;
            GetService_Factory create = GetService_Factory.create(servicesRepositoryProvider);
            this.W = create;
            Provider<PromoDiscoveryContract.View> provider = this.z;
            Provider<GetPromoDiscoverySectionConfig> provider2 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
            Provider<GetPromoList> provider3 = this.SummaryVoucherView$$ExternalSyntheticLambda2;
            PromoDiscoveryPresenter_Factory authRequestContext = PromoDiscoveryPresenter_Factory.getAuthRequestContext(provider, provider2, provider3, provider3, this.P, this.A, this.getContainerAuth, this.getErrorConfigVersion, this.FlowViewUtil$textChanges$1, this.F, this.access$setShowcaseShowing$p, this.L, create);
            this.p = authRequestContext;
            this.q = DoubleCheck.getAuthRequestContext(PromoDiscoveryModule_ProvidePresenterFactory.PlaceComponentResult(promoDiscoveryModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.OtpRegistrationPresenter$input$2 = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.ApiStatus$AvailableSince = authRequestContext3;
            this.y = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.FlowableKt$toIterable$1 = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.m = postExecutionThreadProvider;
            this.D = GetDecodedQrisTopUp_Factory.create(this.FlowableKt$toIterable$1, postExecutionThreadProvider, this.FlowableReduce$ReduceSubscriber);
            this.f5876reduceIndexedz1zDJgo = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getFontAssetManager = userRepositoryProvider;
            this.f8153a = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetCashierNativeConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.FillAnimation = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getOnBoardingScenario = create2;
            this.isRegionMiniProgram = ValidateNativelyDecodedQr_Factory.create(create2);
            this.K = GetMerchantQrWhitelist_Factory.create(this.FlowableReduce$ReduceSubscriber);
            this.R = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.TypeProjectionImpl = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.t = providePaylaterRepositoryProvider;
            this.QrExpiredActivity = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.rotateTo = userEducationRepositoryProvider;
            this.S = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, userEducationRepositoryProvider);
            this.onDecodeSuccess = SaveShowDialog_Factory.create(this.rotateTo);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.y, this.getValueOfTouchPositionAbsolute, this.D, this.f5876reduceIndexedz1zDJgo, this.GetContactSyncConfig, this.f8153a, this.VerifyPinStateManager$executeRiskChallenge$2$1, GetNativelyDecodedQr_Factory.create(), this.FillAnimation, this.isRegionMiniProgram, this.K, this.R, this.TypeProjectionImpl, this.QrExpiredActivity, this.S, this.onDecodeSuccess));
            this.access$getCapacity$p = authRequestContext4;
            this.x = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            Provider<RestoreUrlView> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            this.secondaryHash = authRequestContext5;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.FlowableKt$toIterable$1, this.m, shortenerRepositoryProvider);
            this.getDefaultSenderId = create3;
            Provider<RestoreUrlPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.setNetAuthId, create3));
            this.JsonParseException = authRequestContext6;
            this.w = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            this.T = GetReferralConsult_Factory.create(this.FlowableKt$toIterable$1, this.m, this.i);
            this.whenAvailable = GenerateReferralDeepLink_Factory.create(this.FlowableKt$toIterable$1, this.m, this.getCallingPid);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.InitSecurePreferenceAccount = settingRepositoryProvider;
            this.shouldRecycleViewType = GetSettingByKey_Factory.create(this.FlowableKt$toIterable$1, this.m, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.j = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeatureSettingMore_Factory.PlaceComponentResult(this.shouldRecycleViewType, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.insertActivities = splitBillRepositoryProvider;
            this.Q = GetPayerSplitBillDetail_Factory.create(this.FlowableKt$toIterable$1, this.m, splitBillRepositoryProvider);
            this.l = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.l);
            this.SendMoneyScenario = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.Q, PlaceComponentResult);
            this.Z = GetSplitBillConfig_Factory.create(this.FlowableKt$toIterable$1, this.m, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.FlowableKt$toIterable$1, this.m, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.V = create4;
            Provider<GetSplitBillConfig> provider4 = this.Z;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider4, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.getNameOrBuilderList = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.f = MyBillsEntityDataFactory;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.s = provideFamilyAccountRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.r = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.J = BuiltInFictitiousFunctionClassFactory;
            this.newProxyInstance = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.f));
            Provider<FeatureView> authRequestContext7 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.T, this.getErrorConfigVersion, this.FlowViewUtil$textChanges$1, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.SubSequence, this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.DatabaseTableConfigUtil, FeatureHome_Factory.MyBillsEntityDataFactory(), this.isLayoutRequested, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.newProxyInstance, this.QrExpiredActivity, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.readMicros = authRequestContext7;
            this.initAnimators = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext7));
            this.X = GetServicesByKey_Factory.create(this.FlowableKt$toIterable$1, this.m, this.retainOrRemoveAllInternal);
            ServiceCategoryMapper_Factory authRequestContext8 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.checkRegisteredUserAndSendOtp = authRequestContext8;
            this.NewMerchantCategoryAdapter = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext8);
            this.h = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.h, create6);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create7;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initAnimators, this.X, this.NewMerchantCategoryAdapter, create7, this.GetContactSyncConfig));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.FlowableKt$toIterable$1, this.m, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.scheduleImpl = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = provideFeedsConfigRepositoryProvider;
            this.H = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.N = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.isAuto = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvidePushVerifyTrackerProvider providePushVerifyTrackerProvider = new ProvidePushVerifyTrackerProvider(applicationComponent);
            this.u = providePushVerifyTrackerProvider;
            Provider<FeaturePresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.initAnimators, this.FragmentBottomSheetPaymentSettingBinding, this.PlaceComponentResult, this.scheduleImpl, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.H, this.N, this.isAuto, this.moveToNextValue, providePushVerifyTrackerProvider, this.W));
            this.PrepareContext = authRequestContext9;
            this.v = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext9));
            OauthView_Factory authRequestContext10 = OauthView_Factory.getAuthRequestContext(this.isLayoutRequested);
            this.connectForeground = authRequestContext10;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext10));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.M = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.d = GetUserInfoWithKyc_Factory.create(this.FlowableKt$toIterable$1, this.m, this.getFontAssetManager);
            this.O = GetNickname_Factory.create(this.FlowableKt$toIterable$1, this.m, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.b = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.C = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<OauthContract.View> provider5 = this.RequestMoneyQrContract$View;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider5, oauthParamsModelMapper_Factory, this.M, this.d, this.O, this.b, this.C);
            this.FlowViewUtil$textChanges$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.OtpRegistrationPresenter$input$1 = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.e = IsNeedToShowToolTip_Factory.create(this.FlowableKt$toIterable$1, this.m, this.rotateTo);
            this.getIndexName = SaveShowToolTip_Factory.create(this.FlowableKt$toIterable$1, this.m, this.rotateTo);
            this.Y = GetServicesWithCategory_Factory.create(this.retainOrRemoveAllInternal);
            this.E = GetDefaultServiceWithCategory_Factory.create(this.retainOrRemoveAllInternal);
            this.I = GetFavoriteServiceRemote_Factory.create(this.retainOrRemoveAllInternal);
            this.flip = GetServicesByName_Factory.create(this.FlowableKt$toIterable$1, this.m, this.retainOrRemoveAllInternal);
            this.AppCompatEmojiTextHelper = GetFavoriteServices_Factory.create(this.FlowableKt$toIterable$1, this.m, this.retainOrRemoveAllInternal);
            this.lookAheadTest = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.isAuth = GetRawServices_Factory.create(this.retainOrRemoveAllInternal);
            this.G = GetFavoriteServiceWithCacheFirst_Factory.create(this.retainOrRemoveAllInternal);
            this.U = GetServiceHighlighted_Factory.create(this.retainOrRemoveAllInternal);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.retainOrRemoveAllInternal);
            this.getReadyFragment = create8;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.OtpRegistrationPresenter$input$1, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NewMerchantCategoryAdapter, this.e, this.getIndexName, this.Y, this.E, this.I, this.flip, this.X, this.AppCompatEmojiTextHelper, this.lookAheadTest, this.isAuth, this.G, this.U, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext11 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.x, this.w, this.v, this.TypefaceCompatApi26Impl, this.PromoCategoryPresenter$1, applicationProvider, this.QrExpiredActivity));
            this.initRecordTimeStamp = authRequestContext11;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext11));
            this.FlowableCreate$BufferAsyncEmitter = ReadDeepLinkProperties_Factory.create(this.FlowableKt$toIterable$1, this.m);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.g = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.FlowableKt$toIterable$1, this.m, liteAccountRepositoryProvider);
            this.c = create9;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.getCardNumberOCR, this.FlowableCreate$BufferAsyncEmitter, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create9, this.f));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoDiscoveryRepositoryProvider implements Provider<PromoDiscoveryRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromoDiscoveryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoDiscoveryRepository get() {
                return (PromoDiscoveryRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoCenterRepositoryProvider implements Provider<PromoCenterRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromoCenterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoCenterRepository get() {
                return (PromoCenterRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.d());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
        public static final class GeocodeRepositoryProvider implements Provider<GeocodeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GeocodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeocodeRepository get() {
                return (GeocodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SendMoneyScenario());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.applyTrimPathIfNeeded());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ConcurrentKt());
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
            private final ApplicationComponent PlaceComponentResult;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.PromoDiscoveryComponent
        public final void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment promoDiscoveryFragment) {
            PromoDiscoveryFragment_MembersInjector.MyBillsEntityDataFactory(promoDiscoveryFragment, this.q.get());
            promoDiscoveryFragment.promoDiscoveryTracker = PromoDiscoveryModule_ProvidePromoDiscoveryAnalyticTrackerFactory.getAuthRequestContext(this.n, (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()));
            promoDiscoveryFragment.readLinkPropertiesPresenter = DoubleCheck.MyBillsEntityDataFactory(this.verifyNotNull);
        }
    }
}
