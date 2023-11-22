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
import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.contract.promoquest.quest.MissionPresenter;
import id.dana.contract.promoquest.quest.MissionPresenter_Factory;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.contract.promoquest.redeem.RedeemMissionPresenter;
import id.dana.contract.promoquest.redeem.RedeemMissionPresenter_Factory;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.contract.promoquest.redeem.RedeemQuestPresenter;
import id.dana.contract.promoquest.redeem.RedeemQuestPresenter_Factory;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.contract.promoquest.track.TrackQuestPresenter;
import id.dana.contract.promoquest.track.TrackQuestPresenter_Factory;
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
import id.dana.di.modules.MissionModule;
import id.dana.di.modules.MissionModule_ProvideQuestPresenterFactory;
import id.dana.di.modules.MissionModule_ProvideQuestViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.RedeemQuestModule;
import id.dana.di.modules.RedeemQuestModule_ProvideRedeemQuestPresenterFactory;
import id.dana.di.modules.RedeemQuestModule_ProvideRedeemQuestViewFactory;
import id.dana.di.modules.RedeemUserMissionModule;
import id.dana.di.modules.RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory;
import id.dana.di.modules.RedeemUserMissionModule_ProvideRedeemMissionViewFactory;
import id.dana.di.modules.TrackQuestModule;
import id.dana.di.modules.TrackQuestModule_ProvideTrackQuestPresenterFactory;
import id.dana.di.modules.TrackQuestModule_ProvideTrackQuestViewFactory;
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
import id.dana.domain.featureconfig.interactor.GetTnCReferralMissionConfig;
import id.dana.domain.featureconfig.interactor.GetTnCReferralMissionConfig_Factory;
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
import id.dana.domain.promoquest.interactor.RedeemMission;
import id.dana.domain.promoquest.interactor.RedeemMission_Factory;
import id.dana.domain.promoquest.interactor.RedeemQuest;
import id.dana.domain.promoquest.interactor.RedeemQuest_Factory;
import id.dana.domain.promoquest.interactor.TrackUserQuest;
import id.dana.domain.promoquest.interactor.TrackUserQuest_Factory;
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
import id.dana.domain.sslpinning.SSLPinningRepository;
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
import id.dana.promoquest.activity.MissionDetailActivity;
import id.dana.promoquest.activity.MissionDetailActivity_MembersInjector;
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
public final class DaggerMissionComponent {
    private DaggerMissionComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MissionModule BuiltInFictitiousFunctionClassFactory;
        public TrackQuestModule GetContactSyncConfig;
        public OauthModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public RedeemUserMissionModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ApplicationComponent PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public RedeemQuestModule getErrorConfigVersion;
        public ServicesModule lookAheadTest;
        public RestoreUrlModule moveToNextValue;
        public ScanQrModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MissionComponentImpl implements MissionComponent {
        private Provider<GetAuthCode> A;
        private Provider<SaveShowToolTip> ApiStatus$AvailableSince;
        private Provider<GetFeedConfig> AppCompatEmojiTextHelper;
        private Provider<GetCashierNativeConfig> B;
        private Provider<GenerateReferralDeepLink> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetDecodeTciCoListConfig> C;
        private Provider<UpdateServiceHighlighted> CYFMonitor$ChallengeActionCallback;
        private Provider<GetFavoriteServiceRemote> D;
        private Provider<RestoreUrlContract.Presenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkPayloadModelMapper> DatabaseTableConfigUtil;
        private Provider<GetDefaultServiceWithCategory> E;
        private Provider<GetFavoriteServices> F;
        private Provider<MyReferralConsultMapper> FillAnimation;
        private Provider<PayerModelListMapper> FlowViewUtil$textChanges$1;
        private Provider<OauthRepository> FlowViewUtil$textChanges$2;
        private Provider<ThreadExecutor> FlowableConcatMapEagerPublisher;
        private Provider<ReadDeepLinkProperties> FlowableCreate$BufferAsyncEmitter;
        private Provider<ServicesRepository> FlowableKt$toIterable$1;
        private Provider<ReadLinkPropertiesPresenter> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceWithCacheFirst> G;
        private Provider<DeepLinkView> GetContactSyncConfig;
        private Provider<GetIsCardBindingV2Enabled> H;
        private Provider<GetKycLevel> I;
        private Provider<ServiceCategoryMapper> InitSecurePreferenceAccount;
        private Provider<GetPayerSplitBillDetail> J;
        private Provider<RedeemMission> JsonParseException;
        private Provider<GetMerchantQrWhitelist> K;
        private Provider<CheckConsultFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMissionDetail> L;
        private Provider<GetNearbyConfig> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetRawServices> N;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ShortenerRepository> NewMerchantCategoryAdapter;
        private Provider<GetQrisCpmSendmoneyConfig> O;
        private Provider<QrBarcodeRepository> OtpRegistrationPresenter$input$1;
        private Provider<PaylaterRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetQrBindingConfig> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<FeatureFamilyAccount> PrepareContext;
        private Provider<ServicesPresenter> PromoCategoryPresenter$1;
        private Provider<GetPromoCenterVersion> Q;
        private Provider<IsOfflineF2FPay> QrExpiredActivity;
        private Provider<GetServicesByName> R;
        private Provider<ScanResultMapper> ReferralMapper_Factory;
        private Provider<OauthContract.View> RequestMoneyQrContract$View;
        private Provider<GetService> S;
        private Provider<ScanQrPresenter> SendMoneyScenario;
        private Provider<ReadLinkPropertiesContract.Presenter> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetReferralConsult> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetRequestMoneyInfoFeature> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByKey> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesWithCategory> T;
        private Provider<MissionPresenter> TypeProjectionImpl;
        private Provider<RedeemMissionContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetUpdateAvailability> U;
        private Provider<GetSplitBillConfig> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDecodedQrisTopUp> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetTnCReferralMissionConfig> W;
        private Provider<UserConsentRepository> WrappedDrawableState;
        private Provider<GetSettingByKey> X;
        private Provider<GetUserId> Y;
        private Provider<GetWhitelistedSubMerchantId> Z;

        /* renamed from: a */
        private Provider<LiteAccountRepository> f8128a;
        private Provider<SaveShowDialog> access$getCapacity$p;
        private Provider<SplitBillHistoryToSplitBillModelMapper> access$setShowcaseShowing$p;
        private Provider<ProductPageManager> access$throwIllegalArgumentType;
        private Provider<IsNeedToShowToolTip> b;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> c;
        private Provider<RestoreUrlView> checkRegisteredUserAndSendOtp;
        private Provider<OauthView> connectForeground;
        private Provider<IsNativeDecodeEnabled> d;
        private Provider<MixpanelDeeplinkTracker> e;
        private Provider<UserEducationRepository> encodingStream;
        private final MissionComponentImpl f;
        private Provider<GetUserLoanInfo> flip;
        private Provider<MyReferralConsultRepository> g;
        private Provider<CheckDeepLinkActionVisibility> getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<DeepLinkContract.View> getCardNumberOCR;
        private Provider<RestoreUrlPresenter> getContainerAuth;
        private Provider<RedeemMissionPresenter> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<TrackUserQuest> getFontAssetManager;
        private Provider<SSLPinningRepository> getIndexName;
        private Provider<GetNickname> getNameOrBuilderList;
        private Provider<GetEmptyUserInfo> getOnBoardingScenario;
        private Provider<SettingRepository> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<ValidateNativelyDecodedQr> getTextEndPadding;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private Provider<PostExecutionThread> h;
        private Provider<OauthPresenter> i;
        private Provider<ScanQrContract.View> initAnimators;
        private Provider<DeviceInformationProvider> initRecordTimeStamp;
        private Provider<SplitBillRepository> insertActivities;
        private Provider<GetServiceHighlighted> isAuth;
        private Provider<GetUserStatusInfo> isAuto;
        private Provider<FeatureOauth> isLayoutRequested;
        private Provider<TrackQuestPresenter> isRegionMiniProgram;
        private Provider<Activity> j;
        private Provider<FamilyAccountRepository> k;
        private Provider<FeedsConfigRepository> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<PromoQuestRepository> m;
        private Provider<ConnectionStatusReceiver> moveToNextValue;
        private Provider<ScanQrContract.Presenter> n;
        private Provider<DynamicUrlWrapper> newProxyInstance;

        /* renamed from: o */
        private Provider<CardBindingRepository> f8129o;
        private Provider<RedeemQuest> onDecodeSuccess;
        private Provider<FeatureContract.Presenter> p;
        private Provider<PushVerifyTracker> q;
        private Provider<MissionContract.Presenter> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrl> f5857reduceIndexedz1zDJgo;
        private Provider<ScanQrView> retainOrRemoveAllInternal;
        private Provider<ThirdPartyServicesMapper> rotateTo;
        private Provider<MissionContract.View> s;
        private Provider<CheckFavoriteServicesFeature> scheduleImpl;
        private Provider<RedeemQuestPresenter> secondaryHash;
        private Provider<TrackQuestContract.View> setNetAuthId;
        private Provider<GetUserInfoWithKyc> shouldRecycleViewType;
        private Provider<OauthContract.Presenter> t;
        private Provider<RedeemQuestContract.Presenter> u;
        private Provider<UserRepository> useDaemonThreadFactory;
        private Provider<RedeemQuestContract.View> v;
        private Provider<ServicesContract.View> verifyNotNull;
        private Provider<RedeemMissionContract.View> w;
        private Provider<FeatureSettingMore> whenAvailable;
        private Provider<TrackQuestContract.Presenter> x;
        private Provider<RestoreUrlContract.View> y;
        private Provider<FeatureContract.View> z;

        public /* synthetic */ MissionComponentImpl(MissionModule missionModule, RedeemQuestModule redeemQuestModule, TrackQuestModule trackQuestModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, RedeemUserMissionModule redeemUserMissionModule, ApplicationComponent applicationComponent, byte b) {
            this(missionModule, redeemQuestModule, trackQuestModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, redeemUserMissionModule, applicationComponent);
        }

        private MissionComponentImpl(MissionModule missionModule, RedeemQuestModule redeemQuestModule, TrackQuestModule trackQuestModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, RedeemUserMissionModule redeemUserMissionModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.f = this;
            this.PlaceComponentResult = applicationComponent;
            this.FlowableConcatMapEagerPublisher = new ThreadExecutorProvider(applicationComponent);
            this.getIndexName = new SSLPinningRepositoryProvider(applicationComponent);
            this.h = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, featureConfigRepositoryProvider);
            this.QrExpiredActivity = create;
            this.moveToNextValue = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.FlowableConcatMapEagerPublisher, this.getIndexName, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.j = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.retainOrRemoveAllInternal = authRequestContext2;
            this.initAnimators = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDecodedQrisTopUp_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.OtpRegistrationPresenter$input$1);
            this.ReferralMapper_Factory = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.initRecordTimeStamp = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.useDaemonThreadFactory = userRepositoryProvider;
            this.isAuto = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.B = GetCashierNativeConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.d = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.C = create2;
            this.getTextEndPadding = ValidateNativelyDecodedQr_Factory.create(create2);
            this.K = GetMerchantQrWhitelist_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.P = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.c = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = providePaylaterRepositoryProvider;
            this.flip = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.encodingStream = userEducationRepositoryProvider;
            this.O = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, userEducationRepositoryProvider);
            this.access$getCapacity$p = SaveShowDialog_Factory.create(this.encodingStream);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initAnimators, this.getValueOfTouchPositionAbsolute, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.ReferralMapper_Factory, this.initRecordTimeStamp, this.isAuto, this.B, GetNativelyDecodedQr_Factory.create(), this.d, this.getTextEndPadding, this.K, this.P, this.c, this.flip, this.O, this.access$getCapacity$p));
            this.SendMoneyScenario = authRequestContext3;
            this.n = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.checkRegisteredUserAndSendOtp = authRequestContext4;
            this.y = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.NewMerchantCategoryAdapter = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, shortenerRepositoryProvider);
            this.f5857reduceIndexedz1zDJgo = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.y, create3));
            this.getContainerAuth = authRequestContext5;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.g = myReferralConsultRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetReferralConsult_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.FillAnimation = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getCallingPid = generateLinkRepositoryProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GenerateReferralDeepLink_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getReadyFragment = settingRepositoryProvider;
            this.X = GetSettingByKey_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.access$throwIllegalArgumentType = productPageManagerProvider;
            this.whenAvailable = FeatureSettingMore_Factory.PlaceComponentResult(this.X, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.insertActivities = splitBillRepositoryProvider;
            this.J = GetPayerSplitBillDetail_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, splitBillRepositoryProvider);
            this.FlowViewUtil$textChanges$1 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.FlowViewUtil$textChanges$1);
            this.access$setShowcaseShowing$p = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.J, PlaceComponentResult);
            this.V = GetSplitBillConfig_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create4;
            Provider<GetSplitBillConfig> provider = this.V;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.m = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.L = create5;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.e = MyBillsEntityDataFactory;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.k = provideFamilyAccountRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.newProxyInstance = dynamicUrlWrapperProvider;
            this.PrepareContext = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.f8129o = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.H = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.e));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FillAnimation, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.whenAvailable, this.SubSequence, this.getSupportButtonTintMode, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.isLayoutRequested, FeatureKyb_Factory.getAuthRequestContext(), this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.flip, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda6));
            this.readMicros = authRequestContext6;
            this.z = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = servicesRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByKey_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.InitSecurePreferenceAccount = authRequestContext7;
            this.rotateTo = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.FlowViewUtil$textChanges$2 = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.WrappedDrawableState = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.getOnBoardingScenario = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.FlowViewUtil$textChanges$2, create6);
            this.A = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.z, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.rotateTo, create7, this.initRecordTimeStamp));
            this.getAuthRequestContext = CheckDeepLinkActionVisibility_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.M = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.l = provideFeedsConfigRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.Q = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.U = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.q = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.FlowableKt$toIterable$1);
            this.S = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.z, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getAuthRequestContext, this.lookAheadTest, this.M, this.AppCompatEmojiTextHelper, this.Q, this.U, this.getErrorConfigVersion, this.q, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext8;
            this.p = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.isLayoutRequested);
            this.connectForeground = authRequestContext9;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.I = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.shouldRecycleViewType = GetUserInfoWithKyc_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.useDaemonThreadFactory);
            this.getNameOrBuilderList = GetNickname_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.MyBillsEntityDataFactory);
            this.Z = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Provider<OauthContract.View> provider2 = this.RequestMoneyQrContract$View;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.I, this.shouldRecycleViewType, this.getNameOrBuilderList, this.Z, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.i = KClassImpl$Data$declaredNonStaticMembers$2;
            this.t = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.verifyNotNull = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.b = IsNeedToShowToolTip_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.encodingStream);
            this.ApiStatus$AvailableSince = SaveShowToolTip_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.encodingStream);
            this.T = GetServicesWithCategory_Factory.create(this.FlowableKt$toIterable$1);
            this.E = GetDefaultServiceWithCategory_Factory.create(this.FlowableKt$toIterable$1);
            this.D = GetFavoriteServiceRemote_Factory.create(this.FlowableKt$toIterable$1);
            this.R = GetServicesByName_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.FlowableKt$toIterable$1);
            this.F = GetFavoriteServices_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.FlowableKt$toIterable$1);
            this.scheduleImpl = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.N = GetRawServices_Factory.create(this.FlowableKt$toIterable$1);
            this.G = GetFavoriteServiceWithCacheFirst_Factory.create(this.FlowableKt$toIterable$1);
            this.isAuth = GetServiceHighlighted_Factory.create(this.FlowableKt$toIterable$1);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.FlowableKt$toIterable$1);
            this.CYFMonitor$ChallengeActionCallback = create9;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.verifyNotNull, this.A, this.rotateTo, this.b, this.ApiStatus$AvailableSince, this.T, this.E, this.D, this.R, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.F, this.scheduleImpl, this.N, this.G, this.isAuth, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.n, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.p, this.t, this.PromoCategoryPresenter$1, applicationProvider, this.flip));
            this.GetContactSyncConfig = authRequestContext10;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.FlowableCreate$BufferAsyncEmitter = ReadDeepLinkProperties_Factory.create(this.FlowableConcatMapEagerPublisher, this.h);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.f8128a = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, liteAccountRepositoryProvider);
            this.Y = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.getCardNumberOCR, this.FlowableCreate$BufferAsyncEmitter, this.DatabaseTableConfigUtil, create10, this.e));
            this.FlowableReduce$ReduceSubscriber = authRequestContext11;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(TrackQuestModule_ProvideTrackQuestViewFactory.getAuthRequestContext(trackQuestModule));
            TrackUserQuest_Factory create11 = TrackUserQuest_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.m);
            this.getFontAssetManager = create11;
            TrackQuestPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = TrackQuestPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.setNetAuthId, create11);
            this.isRegionMiniProgram = KClassImpl$Data$declaredNonStaticMembers$22;
            this.x = DoubleCheck.getAuthRequestContext(TrackQuestModule_ProvideTrackQuestPresenterFactory.BuiltInFictitiousFunctionClassFactory(trackQuestModule, KClassImpl$Data$declaredNonStaticMembers$22));
            this.v = DoubleCheck.getAuthRequestContext(RedeemQuestModule_ProvideRedeemQuestViewFactory.MyBillsEntityDataFactory(redeemQuestModule));
            RedeemQuest_Factory create12 = RedeemQuest_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.m);
            this.onDecodeSuccess = create12;
            RedeemQuestPresenter_Factory authRequestContext12 = RedeemQuestPresenter_Factory.getAuthRequestContext(this.v, create12);
            this.secondaryHash = authRequestContext12;
            this.u = DoubleCheck.getAuthRequestContext(RedeemQuestModule_ProvideRedeemQuestPresenterFactory.BuiltInFictitiousFunctionClassFactory(redeemQuestModule, authRequestContext12));
            this.s = DoubleCheck.getAuthRequestContext(MissionModule_ProvideQuestViewFactory.MyBillsEntityDataFactory(missionModule));
            GetTnCReferralMissionConfig_Factory create13 = GetTnCReferralMissionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.W = create13;
            Provider<MissionPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(MissionPresenter_Factory.PlaceComponentResult(this.s, this.L, create13, PromoQuestMapper_Factory.MyBillsEntityDataFactory()));
            this.TypeProjectionImpl = authRequestContext13;
            this.r = DoubleCheck.getAuthRequestContext(MissionModule_ProvideQuestPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(missionModule, authRequestContext13));
            this.w = DoubleCheck.getAuthRequestContext(RedeemUserMissionModule_ProvideRedeemMissionViewFactory.MyBillsEntityDataFactory(redeemUserMissionModule));
            RedeemMission_Factory create14 = RedeemMission_Factory.create(this.FlowableConcatMapEagerPublisher, this.h, this.m);
            this.JsonParseException = create14;
            RedeemMissionPresenter_Factory MyBillsEntityDataFactory2 = RedeemMissionPresenter_Factory.MyBillsEntityDataFactory(this.w, create14);
            this.getDefaultSenderId = MyBillsEntityDataFactory2;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory.MyBillsEntityDataFactory(redeemUserMissionModule, MyBillsEntityDataFactory2));
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
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
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
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.applyTrimPathIfNeeded());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.QrExpiredActivity());
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

        @Override // id.dana.di.component.MissionComponent
        public final void PlaceComponentResult(MissionDetailActivity missionDetailActivity) {
            ((BaseActivity) missionDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(missionDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(missionDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            MissionDetailActivity_MembersInjector.MyBillsEntityDataFactory(missionDetailActivity, this.SizeSelectors$OrSelector.get());
            missionDetailActivity.trackPresenter = this.x.get();
            MissionDetailActivity_MembersInjector.MyBillsEntityDataFactory(missionDetailActivity, this.u.get());
            missionDetailActivity.missionPresenter = this.r.get();
            MissionDetailActivity_MembersInjector.getAuthRequestContext(missionDetailActivity, this.TypefaceCompatApi26Impl.get());
            MissionDetailActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(missionDetailActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
        }
    }
}
