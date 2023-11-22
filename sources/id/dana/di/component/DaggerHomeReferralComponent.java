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
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter_Factory;
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
import id.dana.di.modules.HomeReferralModule;
import id.dana.di.modules.HomeReferralModule_ProvidePresenterFactory;
import id.dana.di.modules.HomeReferralModule_ProvideViewFactory;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.di.modules.MissionSummaryModule_ProvideMissionSummaryPresenterFactory;
import id.dana.di.modules.MissionSummaryModule_ProvideMissionSummaryViewFactory;
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
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature;
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature_Factory;
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
import id.dana.domain.promoquest.interactor.GetMissions;
import id.dana.domain.promoquest.interactor.GetMissions_Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.promotion.interactor.GetHomeReferralBanner;
import id.dana.domain.promotion.interactor.GetHomeReferralBanner_Factory;
import id.dana.domain.promotion.interactor.GetHomeReferralP2PBanner;
import id.dana.domain.promotion.interactor.GetHomeReferralP2PBanner_Factory;
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
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.referral.interactor.GetReferralStatusConsult;
import id.dana.domain.referral.interactor.GetReferralStatusConsult_Factory;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.interactor.GetReferralHomeConfig;
import id.dana.domain.referralconfig.interactor.GetReferralHomeConfig_Factory;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig_Factory;
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
import id.dana.mapper.LeaderboardMapper_Factory;
import id.dana.mapper.ReferralStatusMapper_Factory;
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
import id.dana.richview.homereferral.HomeReferralContract;
import id.dana.richview.homereferral.HomeReferralPresenter;
import id.dana.richview.homereferral.HomeReferralPresenter_Factory;
import id.dana.richview.homereferral.HomeReferralView;
import id.dana.richview.homereferral.HomeReferralView_MembersInjector;
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

/* loaded from: classes8.dex */
public final class DaggerHomeReferralComponent {
    private DaggerHomeReferralComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public DeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public HomeReferralModule PlaceComponentResult;
        public MissionSummaryModule getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public ScanQrModule lookAheadTest;
        public RestoreUrlModule moveToNextValue;
        public ServicesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class HomeReferralComponentImpl implements HomeReferralComponent {
        private Provider<GetDecodeTciCoListConfig> A;
        private Provider<SaveShowToolTip> ApiStatus$AvailableSince;
        private Provider<GetHomeReferralBanner> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GetCashierNativeConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> C;
        private Provider<UpdateServiceHighlighted> CYFMonitor$ChallengeActionCallback;
        private Provider<GetFavoriteServiceWithCacheFirst> D;
        private Provider<ProductPageManager> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkView> DatabaseTableConfigUtil;
        private Provider<GetEmptyUserInfo> E;
        private Provider<GetFeedConfig> F;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> FillAnimation;
        private Provider<LiteAccountRepository> FlowViewUtil$textChanges$1;
        private Provider<MixpanelDeeplinkTracker> FlowViewUtil$textChanges$2;
        private Provider<UserRepository> FlowableConcatMapEagerPublisher;
        private Provider<QrBarcodeRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<ThreadExecutor> FlowableKt$toIterable$1;
        private Provider<HomeReferralContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureServicesHandler> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetIsCardBindingV2Enabled> G;
        private Provider<DynamicUrlWrapper> GetContactSyncConfig;
        private Provider<GetFavoriteServices> H;
        private Provider<GetHomeReferralP2PBanner> I;
        private Provider<ServicesPresenter> InitSecurePreferenceAccount;
        private Provider<GetMissions> J;
        private Provider<RestoreUrlPresenter> JsonParseException;
        private Provider<GetMissionDetail> K;
        private Provider<CheckFavoriteServicesFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetNearbyConfig> L;
        private Provider<GetKycLevel> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetPromoCenterVersion> N;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ThirdPartyServicesMapper> NewMerchantCategoryAdapter;
        private Provider<GetQrBindingConfig> O;
        private Provider<ReadDeepLinkProperties> OtpRegistrationPresenter$input$1;
        private Provider<FamilyAccountRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetQrisCpmSendmoneyConfig> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<FeatureFamilyAccount> PrepareContext;
        private Provider<ServicesRepository> PromoCategoryPresenter$1;
        private Provider<GetPayerSplitBillDetail> Q;
        private Provider<GetWhitelistedSubMerchantId> QrExpiredActivity;
        private Provider<GetReferralHomeConfig> R;
        private Provider<ScanResultMapper> ReferralMapper_Factory;
        private Provider<ReadLinkPropertiesContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetReferralSendMoneyConfig> S;
        private Provider<SettingRepository> SendMoneyScenario;
        private Provider<CardBindingRepository> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetRawServices> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetReferralStatusConsult> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesByKey> T;
        private Provider<IsNeedToShowToolTip> TypeProjectionImpl;
        private Provider<FeatureContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetService> U;
        private Provider<GetServicesByName> V;
        private Provider<GetDecodedQrBarcode> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetFavoriteServiceRemote> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServiceHighlighted> W;
        private Provider<GetRequestMoneyInfoFeature> X;
        private Provider<GetUpdateAvailability> Y;
        private Provider<GetSplitBillConfig> Z;

        /* renamed from: a */
        private Provider<GetUserLoanInfo> f8116a;
        private Provider<SaveShowDialog> access$getCapacity$p;
        private Provider<SplitBillRepository> access$setShowcaseShowing$p;
        private Provider<OauthView> access$throwIllegalArgumentType;
        private Provider<GetUserInfoWithKyc> b;
        private final HomeReferralComponentImpl c;
        private Provider<ScanQrPresenter> checkRegisteredUserAndSendOtp;
        private Provider<MissionSummaryPresenter> connectForeground;
        private Provider<GetUserStatusInfo> d;
        private final HomeReferralModule e;
        private Provider<IsNativeDecodeEnabled> f;
        private Provider<GetUserId> flip;
        private Provider<HomeReferralPresenter> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<ServicesContract.View> getCardNumberOCR;
        private Provider<RestoreUrl> getContainerAuth;
        private Provider<ReadLinkPropertiesPresenter> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<UserEducationRepository> getFontAssetManager;
        private Provider<ScanQrView> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<SplitBillHistoryToSplitBillModelMapper> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetDecodedQrisTopUp> getValueOfTouchPositionAbsolute;
        private Provider<MyReferralConsultMapper> h;
        private Provider<MyReferralConsultRepository> i;
        private Provider<OauthContract.View> initAnimators;
        private Provider<DeviceInformationProvider> initRecordTimeStamp;
        private Provider<ShortenerRepository> insertActivities;
        private Provider<GetReferralConsult> isAuth;
        private Provider<GetServicesWithCategory> isAuto;
        private Provider<FeatureConfigRepository> isLayoutRequested;
        private Provider<UserConsentRepository> isRegionMiniProgram;
        private Provider<OauthRepository> j;
        private Provider<PostExecutionThread> k;
        private Provider<PayerModelListMapper> l;
        private Provider<CheckPromoQuestFeature> lookAheadTest;
        private Provider<OauthPresenter> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<Activity> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<PromoQuestRepository> f8117o;
        private Provider<ReferralConfigRepository> onDecodeSuccess;
        private Provider<PromotionRepository> p;
        private Provider<FeedsConfigRepository> q;
        private Provider<PaylaterRepository> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrlView> f5837reduceIndexedz1zDJgo;
        private Provider<ServiceCategoryMapper> retainOrRemoveAllInternal;
        private Provider<ValidateNativelyDecodedQr> rotateTo;
        private Provider<MissionSummaryContract.View> s;
        private Provider<CheckWhitelistedValidDomain> scheduleImpl;
        private Provider<ReferralRepository> secondaryHash;
        private Provider<RestoreUrlContract.View> setNetAuthId;
        private Provider<GetSettingByKey> shouldRecycleViewType;
        private Provider<MissionSummaryContract.Presenter> t;
        private Provider<OauthContract.Presenter> u;
        private Provider<RestoreUrlContract.Presenter> v;
        private Provider<DeepLinkContract.View> verifyNotNull;
        private Provider<PushVerifyTracker> w;
        private Provider<GenerateReferralDeepLink> whenAvailable;
        private Provider<ScanQrContract.Presenter> x;
        private Provider<ScanQrContract.View> y;
        private Provider<FeatureContract.View> z;

        public /* synthetic */ HomeReferralComponentImpl(HomeReferralModule homeReferralModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, MissionSummaryModule missionSummaryModule, ApplicationComponent applicationComponent, byte b) {
            this(homeReferralModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, missionSummaryModule, applicationComponent);
        }

        private HomeReferralComponentImpl(HomeReferralModule homeReferralModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, MissionSummaryModule missionSummaryModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            LeaderboardMapper_Factory leaderboardMapper_Factory;
            this.c = this;
            this.e = homeReferralModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.n = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.getIndexName = authRequestContext2;
            this.y = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = qrBarcodeRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.FlowableKt$toIterable$1 = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.k = postExecutionThreadProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrisTopUp_Factory.create(this.FlowableKt$toIterable$1, postExecutionThreadProvider, this.FlowableCreate$BufferAsyncEmitter);
            this.ReferralMapper_Factory = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.initRecordTimeStamp = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = userRepositoryProvider;
            this.d = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.isLayoutRequested = featureConfigRepositoryProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.f = IsNativeDecodeEnabled_Factory.create(this.isLayoutRequested);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.isLayoutRequested);
            this.A = create;
            this.rotateTo = ValidateNativelyDecodedQr_Factory.create(create);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.FlowableCreate$BufferAsyncEmitter);
            this.O = GetQrBindingConfig_Factory.create(this.isLayoutRequested);
            this.FillAnimation = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.isLayoutRequested);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.r = providePaylaterRepositoryProvider;
            this.f8116a = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getFontAssetManager = userEducationRepositoryProvider;
            this.P = GetQrisCpmSendmoneyConfig_Factory.create(this.isLayoutRequested, userEducationRepositoryProvider);
            this.access$getCapacity$p = SaveShowDialog_Factory.create(this.getFontAssetManager);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.y, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getValueOfTouchPositionAbsolute, this.ReferralMapper_Factory, this.initRecordTimeStamp, this.d, this.BottomSheetCardBindingView$watcherCardNumberView$1, GetNativelyDecodedQr_Factory.create(), this.f, this.rotateTo, this.getNameOrBuilderList, this.O, this.FillAnimation, this.f8116a, this.P, this.access$getCapacity$p));
            this.checkRegisteredUserAndSendOtp = authRequestContext3;
            this.x = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            this.f5837reduceIndexedz1zDJgo = authRequestContext4;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.insertActivities = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.FlowableKt$toIterable$1, this.k, shortenerRepositoryProvider);
            this.getContainerAuth = create2;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.setNetAuthId, create2));
            this.JsonParseException = authRequestContext5;
            this.v = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.i = myReferralConsultRepositoryProvider;
            this.isAuth = GetReferralConsult_Factory.create(this.FlowableKt$toIterable$1, this.k, myReferralConsultRepositoryProvider);
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(this.isLayoutRequested);
            this.h = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getCallingPid = generateLinkRepositoryProvider;
            this.whenAvailable = GenerateReferralDeepLink_Factory.create(this.FlowableKt$toIterable$1, this.k, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = settingRepositoryProvider;
            this.shouldRecycleViewType = GetSettingByKey_Factory.create(this.FlowableKt$toIterable$1, this.k, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureSettingMore_Factory.PlaceComponentResult(this.shouldRecycleViewType, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.access$setShowcaseShowing$p = splitBillRepositoryProvider;
            this.Q = GetPayerSplitBillDetail_Factory.create(this.FlowableKt$toIterable$1, this.k, splitBillRepositoryProvider);
            this.l = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.l);
            this.getReadyFragment = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.Q, PlaceComponentResult);
            this.Z = GetSplitBillConfig_Factory.create(this.FlowableKt$toIterable$1, this.k, this.isLayoutRequested);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.FlowableKt$toIterable$1, this.k, this.isLayoutRequested);
            this.X = create3;
            Provider<GetSplitBillConfig> provider = this.Z;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.f8117o = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.K = create4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.FlowViewUtil$textChanges$2 = MyBillsEntityDataFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.GetContactSyncConfig = dynamicUrlWrapperProvider;
            this.PrepareContext = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.G = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.FlowViewUtil$textChanges$2));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.isAuth, this.getErrorConfigVersion, this.h, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.SubSequence, this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.f8116a, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda5));
            this.readMicros = authRequestContext6;
            this.z = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = servicesRepositoryProvider;
            this.T = GetServicesByKey_Factory.create(this.FlowableKt$toIterable$1, this.k, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.retainOrRemoveAllInternal = authRequestContext7;
            this.NewMerchantCategoryAdapter = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.j = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.E = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.j, create5);
            this.B = create6;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.z, this.T, this.NewMerchantCategoryAdapter, create6, this.initRecordTimeStamp));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.FlowableKt$toIterable$1, this.k, this.isLayoutRequested);
            this.scheduleImpl = CheckWhitelistedValidDomain_Factory.create(this.isLayoutRequested);
            this.L = GetNearbyConfig_Factory.create(this.isLayoutRequested);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.q = provideFeedsConfigRepositoryProvider;
            this.F = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.N = GetPromoCenterVersion_Factory.create(this.isLayoutRequested);
            this.Y = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.isLayoutRequested);
            this.w = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.PromoCategoryPresenter$1);
            this.U = create7;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.z, this.FragmentBottomSheetPaymentSettingBinding, this.PlaceComponentResult, this.scheduleImpl, this.L, this.F, this.N, this.Y, this.moveToNextValue, this.w, create7));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext8;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.access$throwIllegalArgumentType = authRequestContext9;
            this.initAnimators = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.M = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.b = GetUserInfoWithKyc_Factory.create(this.FlowableKt$toIterable$1, this.k, this.FlowableConcatMapEagerPublisher);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetNickname_Factory.create(this.FlowableKt$toIterable$1, this.k, this.BuiltInFictitiousFunctionClassFactory);
            this.QrExpiredActivity = GetWhitelistedSubMerchantId_Factory.create(this.isLayoutRequested);
            this.C = GetAddingNameWhitelistedMerchantId_Factory.create(this.isLayoutRequested);
            Provider<OauthContract.View> provider2 = this.initAnimators;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.M, this.b, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.QrExpiredActivity, this.C);
            this.m = KClassImpl$Data$declaredNonStaticMembers$2;
            this.u = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.getCardNumberOCR = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.TypeProjectionImpl = IsNeedToShowToolTip_Factory.create(this.FlowableKt$toIterable$1, this.k, this.getFontAssetManager);
            this.ApiStatus$AvailableSince = SaveShowToolTip_Factory.create(this.FlowableKt$toIterable$1, this.k, this.getFontAssetManager);
            this.isAuto = GetServicesWithCategory_Factory.create(this.PromoCategoryPresenter$1);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.PromoCategoryPresenter$1);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetFavoriteServiceRemote_Factory.create(this.PromoCategoryPresenter$1);
            this.V = GetServicesByName_Factory.create(this.FlowableKt$toIterable$1, this.k, this.PromoCategoryPresenter$1);
            this.H = GetFavoriteServices_Factory.create(this.FlowableKt$toIterable$1, this.k, this.PromoCategoryPresenter$1);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckFavoriteServicesFeature_Factory.create(this.isLayoutRequested);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetRawServices_Factory.create(this.PromoCategoryPresenter$1);
            this.D = GetFavoriteServiceWithCacheFirst_Factory.create(this.PromoCategoryPresenter$1);
            this.W = GetServiceHighlighted_Factory.create(this.PromoCategoryPresenter$1);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.PromoCategoryPresenter$1);
            this.CYFMonitor$ChallengeActionCallback = create8;
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getCardNumberOCR, this.B, this.NewMerchantCategoryAdapter, this.TypeProjectionImpl, this.ApiStatus$AvailableSince, this.isAuto, this.getOnBoardingScenario, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.V, this.T, this.H, this.KClassImpl$Data$declaredNonStaticMembers$2, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.D, this.W, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.x, this.v, this.TypefaceCompatApi26Impl, this.u, this.InitSecurePreferenceAccount, applicationProvider, this.f8116a));
            this.DatabaseTableConfigUtil = authRequestContext10;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.OtpRegistrationPresenter$input$1 = ReadDeepLinkProperties_Factory.create(this.FlowableKt$toIterable$1, this.k);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.FlowableKt$toIterable$1, this.k, liteAccountRepositoryProvider);
            this.flip = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.verifyNotNull, this.OtpRegistrationPresenter$input$1, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create9, this.FlowViewUtil$textChanges$2));
            this.getDefaultSenderId = authRequestContext11;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
            this.lookAheadTest = CheckPromoQuestFeature_Factory.create(this.isLayoutRequested);
            this.J = GetMissions_Factory.create(this.f8117o);
            this.s = DoubleCheck.getAuthRequestContext(MissionSummaryModule_ProvideMissionSummaryViewFactory.getAuthRequestContext(missionSummaryModule));
            MissionSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = MissionSummaryPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, this.J, PromoQuestMapper_Factory.MyBillsEntityDataFactory(), this.s);
            this.connectForeground = KClassImpl$Data$declaredNonStaticMembers$22;
            this.t = DoubleCheck.getAuthRequestContext(MissionSummaryModule_ProvideMissionSummaryPresenterFactory.MyBillsEntityDataFactory(missionSummaryModule, KClassImpl$Data$declaredNonStaticMembers$22));
            ReferralConfigRepositoryProvider referralConfigRepositoryProvider = new ReferralConfigRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = referralConfigRepositoryProvider;
            this.R = GetReferralHomeConfig_Factory.create(this.FlowableKt$toIterable$1, this.k, referralConfigRepositoryProvider);
            this.S = GetReferralSendMoneyConfig_Factory.create(this.FlowableKt$toIterable$1, this.k, this.onDecodeSuccess);
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.secondaryHash = referralRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetReferralStatusConsult_Factory.create(this.FlowableKt$toIterable$1, this.k, referralRepositoryProvider);
            PromotionRepositoryProvider promotionRepositoryProvider = new PromotionRepositoryProvider(applicationComponent);
            this.p = promotionRepositoryProvider;
            this.I = GetHomeReferralP2PBanner_Factory.create(this.FlowableKt$toIterable$1, this.k, promotionRepositoryProvider);
            this.AppCompatEmojiTextHelper = GetHomeReferralBanner_Factory.create(this.FlowableKt$toIterable$1, this.k, this.p);
            this.FlowableReduce$ReduceSubscriber = HomeReferralModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(homeReferralModule);
            Provider<GetReferralHomeConfig> provider3 = this.R;
            Provider<GetReferralSendMoneyConfig> provider4 = this.S;
            Provider<GetReferralStatusConsult> provider5 = this.SummaryVoucherView$$ExternalSyntheticLambda2;
            Provider<GetHomeReferralP2PBanner> provider6 = this.I;
            Provider<GetHomeReferralBanner> provider7 = this.AppCompatEmojiTextHelper;
            leaderboardMapper_Factory = LeaderboardMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.g = DoubleCheck.getAuthRequestContext(HomeReferralPresenter_Factory.PlaceComponentResult(provider3, provider4, provider5, provider6, provider7, leaderboardMapper_Factory, ReferralStatusMapper_Factory.BuiltInFictitiousFunctionClassFactory(), this.FlowableReduce$ReduceSubscriber));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.setNetAuthId());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.QrExpiredActivity());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ReferralConfigRepositoryProvider implements Provider<ReferralConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ReferralConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralConfigRepository get() {
                return (ReferralConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.insertActivities());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PromotionRepositoryProvider implements Provider<PromotionRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromotionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromotionRepository get() {
                return (PromotionRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.a());
            }
        }

        @Override // id.dana.di.component.HomeReferralComponent
        public final void BuiltInFictitiousFunctionClassFactory(HomeReferralView homeReferralView) {
            HomeReferralView_MembersInjector.getAuthRequestContext(homeReferralView, this.RequestMoneyQrContract$View.get());
            homeReferralView.missionSummaryPresenter = this.t.get();
            homeReferralView.presenter = HomeReferralModule_ProvidePresenterFactory.getAuthRequestContext(this.e, this.g.get());
        }
    }
}
