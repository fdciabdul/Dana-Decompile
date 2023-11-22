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
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.contract.oauth.OauthGrantPresenter;
import id.dana.contract.oauth.OauthGrantPresenter_Factory;
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
import id.dana.di.modules.OauthGrantModule;
import id.dana.di.modules.OauthGrantModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthGrantModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetAvatarUrl_Factory;
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
import id.dana.domain.featureconfig.interactor.GetShowAlipayConnectBrandConfig;
import id.dana.domain.featureconfig.interactor.GetShowAlipayConnectBrandConfig_Factory;
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
import id.dana.domain.oauth.interactor.ConfirmScopes;
import id.dana.domain.oauth.interactor.ConfirmScopes_Factory;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId_Factory;
import id.dana.domain.oauth.interactor.GetGnBindingBenefits;
import id.dana.domain.oauth.interactor.GetGnBindingBenefits_Factory;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.interactor.GetQrBindingConfig_Factory;
import id.dana.domain.oauth.interactor.GetScopes;
import id.dana.domain.oauth.interactor.GetScopes_Factory;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId_Factory;
import id.dana.domain.oauth.interactor.GnAuthAgreement;
import id.dana.domain.oauth.interactor.GnAuthAgreement_Factory;
import id.dana.domain.oauth.interactor.GnAuthApply;
import id.dana.domain.oauth.interactor.GnAuthApply_Factory;
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
import id.dana.oauth.ScopeAdapter_Factory;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.oauth.activity.OauthGrantActivity_MembersInjector;
import id.dana.oauth.mapper.OauthInitModelMapper;
import id.dana.oauth.mapper.OauthInitModelMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.oauth.mapper.ScopeModelMapper_Factory;
import id.dana.oauth.tracker.MixpanelOauthGrantTracker;
import id.dana.oauth.tracker.MixpanelOauthGrantTracker_Factory;
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

/* loaded from: classes2.dex */
public final class DaggerOauthGrantComponent {
    private DaggerOauthGrantComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public OauthGrantModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public OauthModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public ServicesModule lookAheadTest;
        public RestoreUrlModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class OauthGrantComponentImpl implements OauthGrantComponent {
        private Provider<GenerateLinkRepository> A;
        private Provider<RestoreUrlView> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServiceWithCacheFirst> AppCompatEmojiTextHelper;
        private Provider<GetAddingNameWhitelistedMerchantId> B;
        private Provider<GetAvatarUrl> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAuthCode> C;
        private Provider<UserConsentRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<GetDefaultServiceWithCategory> D;
        private Provider<OauthView> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkView> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrBarcode> E;
        private Provider<GetFeedConfig> F;
        private Provider<GnAuthApply> FillAnimation;
        private Provider<MyReferralConsultMapper> FlowViewUtil$textChanges$1;
        private Provider<IsOfflineF2FPay> FlowViewUtil$textChanges$2;
        private Provider<UserEducationRepository> FlowableConcatMapEagerPublisher;
        private Provider<DeepLinkContract.View> FlowableCreate$BufferAsyncEmitter;
        private Provider<SettingRepository> FlowableKt$toIterable$1;
        private Provider<OauthContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePushVerify> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceRemote> G;
        private Provider<DeepLinkPayloadModelMapper> GetContactSyncConfig;
        private Provider<GetFavoriteServices> H;
        private Provider<GetEmptyUserInfo> I;
        private Provider<ScanQrView> InitSecurePreferenceAccount;
        private Provider<GetMissionDetail> J;
        private Provider<RestoreUrl> JsonParseException;
        private Provider<GetGnBindingBenefits> K;
        private Provider<CheckConsultFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetKycLevel> L;
        private Provider<GetIsCardBindingV2Enabled> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetPayerSplitBillDetail> N;
        private Provider<ConfirmScopes> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ThirdPartyServicesMapper> NewMerchantCategoryAdapter;
        private Provider<GetNearbyConfig> O;
        private Provider<RestoreUrlContract.View> OtpRegistrationPresenter$input$1;
        private Provider<PayerModelListMapper> OtpRegistrationPresenter$input$2;
        private Provider<GetPromoCenterVersion> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<DeviceInformationProvider> PrepareContext;
        private Provider<ServiceCategoryMapper> PromoCategoryPresenter$1;
        private Provider<GetPhoneNumber> Q;
        private Provider<GetUserId> QrExpiredActivity;
        private Provider<GetRawServices> R;
        private Provider<ServicesPresenter> ReferralMapper_Factory;
        private Provider<OauthContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetReferralConsult> S;
        private Provider<ScanResultMapper> SendMoneyScenario;
        private Provider<PromoQuestRepository> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBill> SubSequence;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetRequestMoneyInfoFeature> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetQrBindingConfig> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetService> T;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> TypeProjectionImpl;
        private Provider<ScanQrContract.Presenter> TypefaceCompatApi26Impl;
        private Provider<GetScopes> U;
        private Provider<GetServiceHighlighted> V;
        private Provider<GenerateReferralDeepLink> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDecodedQrisTopUp> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesByName> W;
        private Provider<GetServicesByKey> X;
        private Provider<GetSplitBillConfig> Y;
        private Provider<GetServicesWithCategory> Z;

        /* renamed from: a */
        private Provider<GetWhitelistedSubMerchantId> f8146a;
        private Provider<SaveShowToolTip> access$getCapacity$p;
        private Provider<SplitBillHistoryToSplitBillModelMapper> access$setShowcaseShowing$p;
        private Provider<MyReferralConsultRepository> access$throwIllegalArgumentType;
        private Provider<GetUserStatusInfo> b;
        private Provider<GetUserInfoWithKyc> c;
        private Provider<ScanQrPresenter> checkRegisteredUserAndSendOtp;
        private Provider<MixpanelOauthGrantTracker> connectForeground;
        private Provider<GetUserLoanInfo> d;
        private Provider<IsNeedToShowToolTip> e;
        private Provider<IsNativeDecodeEnabled> f;
        private Provider<GetSettingByKey> flip;
        private Provider<GnAuthAgreement> g;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<FeatureServicesHandler> getCallingPid;
        private Provider<ServicesContract.View> getCardNumberOCR;
        private Provider<ReadDeepLinkProperties> getContainerAuth;
        private Provider<RestoreUrlPresenter> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<UserRepository> getFontAssetManager;
        private Provider<SSLPinningRepository> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetCashierNativeConfig> getOnBoardingScenario;
        private Provider<ShortenerRepository> getReadyFragment;
        private Provider<FeatureView> getSupportButtonTintMode;
        private Provider<GetDecodeTciCoListConfig> getValueOfTouchPositionAbsolute;
        private Provider<LiteAccountRepository> h;
        private Provider<MixpanelDeeplinkTracker> i;
        private Provider<ReadLinkPropertiesContract.Presenter> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<SplitBillRepository> insertActivities;
        private Provider<GetQrisCpmSendmoneyConfig> isAuth;
        private Provider<GetUpdateAvailability> isAuto;
        private Provider<DynamicUrlWrapper> isLayoutRequested;
        private Provider<ThreadExecutor> isRegionMiniProgram;
        private final OauthGrantComponentImpl j;
        private Provider<OauthPresenter> k;
        private Provider<OauthInitModelMapper> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<OauthGrantPresenter> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<PostExecutionThread> n;
        private Provider<FeatureFamilyAccount> newProxyInstance;

        /* renamed from: o */
        private Provider<OauthRepository> f8147o;
        private Provider<QrBarcodeRepository> onDecodeSuccess;
        private Provider<ProductPageManager> p;
        private Provider<CardBindingRepository> q;
        private Provider<FeedsConfigRepository> r;
        private Provider<FeatureSettingMore> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<SaveShowDialog> f5873reduceIndexedz1zDJgo;
        private Provider<ServicesRepository> retainOrRemoveAllInternal;
        private Provider<UpdateServiceHighlighted> rotateTo;
        private Provider<FamilyAccountRepository> s;
        private Provider<CheckShowReferralCodeFeature> scheduleImpl;
        private Provider<ReadLinkPropertiesPresenter> secondaryHash;
        private Provider<ScanQrContract.View> setNetAuthId;
        private Provider<GetShowAlipayConnectBrandConfig> shouldRecycleViewType;
        private Provider<Activity> t;
        private Provider<RestoreUrlContract.Presenter> u;
        private Provider<ValidateNativelyDecodedQr> useDaemonThreadFactory;
        private Provider<FeatureContract.Presenter> v;
        private Provider<FeatureContract.View> verifyNotNull;
        private Provider<OauthGrantContract.Presenter> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<PaylaterRepository> x;
        private Provider<PushVerifyTracker> y;
        private Provider<OauthGrantContract.View> z;

        public /* synthetic */ OauthGrantComponentImpl(OauthGrantModule oauthGrantModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(oauthGrantModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private OauthGrantComponentImpl(OauthGrantModule oauthGrantModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            ScopeModelMapper_Factory scopeModelMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.j = this;
            this.getAuthRequestContext = applicationComponent;
            this.isRegionMiniProgram = new ThreadExecutorProvider(applicationComponent);
            this.getIndexName = new SSLPinningRepositoryProvider(applicationComponent);
            this.n = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.isRegionMiniProgram, this.n, featureConfigRepositoryProvider);
            this.FlowViewUtil$textChanges$2 = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.isRegionMiniProgram, this.getIndexName, create);
            OauthRepositoryProvider oauthRepositoryProvider = new OauthRepositoryProvider(applicationComponent);
            this.f8147o = oauthRepositoryProvider;
            this.U = GetScopes_Factory.create(this.isRegionMiniProgram, this.n, oauthRepositoryProvider);
            this.z = DoubleCheck.getAuthRequestContext(OauthGrantModule_ProvideViewFactory.PlaceComponentResult(oauthGrantModule));
            scopeModelMapper_Factory = ScopeModelMapper_Factory.InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
            this.l = OauthInitModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(scopeModelMapper_Factory);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.h = liteAccountRepositoryProvider;
            this.Q = GetPhoneNumber_Factory.create(this.isRegionMiniProgram, this.n, liteAccountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ConfirmScopes_Factory.create(this.isRegionMiniProgram, this.n, this.f8147o);
            this.g = GnAuthAgreement_Factory.create(this.isRegionMiniProgram, this.n, this.f8147o);
            this.FillAnimation = GnAuthApply_Factory.create(this.isRegionMiniProgram, this.n, this.f8147o);
            this.K = GetGnBindingBenefits_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.shouldRecycleViewType = GetShowAlipayConnectBrandConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = contextProvider;
            this.connectForeground = MixpanelOauthGrantTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            GetAvatarUrl_Factory create2 = GetAvatarUrl_Factory.create(this.isRegionMiniProgram, this.n, accountRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create2;
            Provider<OauthGrantPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(OauthGrantPresenter_Factory.getAuthRequestContext(this.U, this.z, this.l, this.Q, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.g, this.FillAnimation, this.K, this.shouldRecycleViewType, this.connectForeground, create2));
            this.m = authRequestContext;
            this.w = DoubleCheck.getAuthRequestContext(OauthGrantModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthGrantModule, authRequestContext));
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.t = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.InitSecurePreferenceAccount = authRequestContext3;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = qrBarcodeRepositoryProvider;
            this.E = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDecodedQrisTopUp_Factory.create(this.isRegionMiniProgram, this.n, this.onDecodeSuccess);
            this.SendMoneyScenario = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.PrepareContext = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getFontAssetManager = userRepositoryProvider;
            this.b = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.getOnBoardingScenario = GetCashierNativeConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.f = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetDecodeTciCoListConfig_Factory create3 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.getValueOfTouchPositionAbsolute = create3;
            this.useDaemonThreadFactory = ValidateNativelyDecodedQr_Factory.create(create3);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.onDecodeSuccess);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.TypeProjectionImpl = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.x = providePaylaterRepositoryProvider;
            this.d = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = userEducationRepositoryProvider;
            this.isAuth = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, userEducationRepositoryProvider);
            this.f5873reduceIndexedz1zDJgo = SaveShowDialog_Factory.create(this.FlowableConcatMapEagerPublisher);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.setNetAuthId, this.E, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.SendMoneyScenario, this.PrepareContext, this.b, this.getOnBoardingScenario, GetNativelyDecodedQr_Factory.create(), this.f, this.useDaemonThreadFactory, this.getNameOrBuilderList, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.TypeProjectionImpl, this.d, this.isAuth, this.f5873reduceIndexedz1zDJgo));
            this.checkRegisteredUserAndSendOtp = authRequestContext4;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            Provider<RestoreUrlView> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            this.ApiStatus$AvailableSince = authRequestContext5;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.getReadyFragment = shortenerRepositoryProvider;
            RestoreUrl_Factory create4 = RestoreUrl_Factory.create(this.isRegionMiniProgram, this.n, shortenerRepositoryProvider);
            this.JsonParseException = create4;
            Provider<RestoreUrlPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.OtpRegistrationPresenter$input$1, create4));
            this.getDefaultSenderId = authRequestContext6;
            this.u = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = myReferralConsultRepositoryProvider;
            this.S = GetReferralConsult_Factory.create(this.isRegionMiniProgram, this.n, myReferralConsultRepositoryProvider);
            this.scheduleImpl = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.FlowViewUtil$textChanges$1 = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.A = generateLinkRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GenerateReferralDeepLink_Factory.create(this.isRegionMiniProgram, this.n, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = settingRepositoryProvider;
            this.flip = GetSettingByKey_Factory.create(this.isRegionMiniProgram, this.n, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.p = productPageManagerProvider;
            this.readMicros = FeatureSettingMore_Factory.PlaceComponentResult(this.flip, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.insertActivities = splitBillRepositoryProvider;
            this.N = GetPayerSplitBillDetail_Factory.create(this.isRegionMiniProgram, this.n, splitBillRepositoryProvider);
            this.OtpRegistrationPresenter$input$2 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.OtpRegistrationPresenter$input$2);
            this.access$setShowcaseShowing$p = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.N, PlaceComponentResult);
            this.Y = GetSplitBillConfig_Factory.create(this.isRegionMiniProgram, this.n, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetRequestMoneyInfoFeature_Factory create5 = GetRequestMoneyInfoFeature_Factory.create(this.isRegionMiniProgram, this.n, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create5;
            Provider<GetSplitBillConfig> provider = this.Y;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.SubSequence = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create5, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create6 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.J = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeaturePromoQuest_Factory.getAuthRequestContext(create6, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.i = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.s = provideFamilyAccountRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.isLayoutRequested = dynamicUrlWrapperProvider;
            this.newProxyInstance = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.q = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.M = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.i));
            Provider<FeatureView> authRequestContext7 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.S, this.scheduleImpl, this.FlowViewUtil$textChanges$1, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.readMicros, this.whenAvailable, this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda3, FeatureKyb_Factory.getAuthRequestContext(), this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.d, FeatureMyBills_Factory.PlaceComponentResult(), this.FragmentBottomSheetPaymentSettingBinding));
            this.getSupportButtonTintMode = authRequestContext7;
            this.verifyNotNull = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext7));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = servicesRepositoryProvider;
            this.X = GetServicesByKey_Factory.create(this.isRegionMiniProgram, this.n, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext8 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.PromoCategoryPresenter$1 = authRequestContext8;
            this.NewMerchantCategoryAdapter = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext8);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create7 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.I = create7;
            GetAuthCode_Factory create8 = GetAuthCode_Factory.create(this.f8147o, create7);
            this.C = create8;
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.verifyNotNull, this.X, this.NewMerchantCategoryAdapter, create8, this.PrepareContext));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.isRegionMiniProgram, this.n, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.O = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.r = provideFeedsConfigRepositoryProvider;
            this.F = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.P = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.isAuto = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.y = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create9 = GetService_Factory.create(this.retainOrRemoveAllInternal);
            this.T = create9;
            Provider<FeaturePresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.verifyNotNull, this.getCallingPid, this.PlaceComponentResult, this.lookAheadTest, this.O, this.F, this.P, this.isAuto, this.moveToNextValue, this.y, create9));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext9;
            this.v = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext9));
            OauthView_Factory authRequestContext10 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = authRequestContext10;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext10));
            this.L = GetKycLevel_Factory.create(this.MyBillsEntityDataFactory);
            this.c = GetUserInfoWithKyc_Factory.create(this.isRegionMiniProgram, this.n, this.getFontAssetManager);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetNickname_Factory.create(this.isRegionMiniProgram, this.n, this.MyBillsEntityDataFactory);
            this.f8146a = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.B = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Provider<OauthContract.View> provider2 = this.FlowableReduce$ReduceSubscriber;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.L, this.c, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.f8146a, this.B);
            this.k = KClassImpl$Data$declaredNonStaticMembers$2;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.getCardNumberOCR = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.e = IsNeedToShowToolTip_Factory.create(this.isRegionMiniProgram, this.n, this.FlowableConcatMapEagerPublisher);
            this.access$getCapacity$p = SaveShowToolTip_Factory.create(this.isRegionMiniProgram, this.n, this.FlowableConcatMapEagerPublisher);
            this.Z = GetServicesWithCategory_Factory.create(this.retainOrRemoveAllInternal);
            this.D = GetDefaultServiceWithCategory_Factory.create(this.retainOrRemoveAllInternal);
            this.G = GetFavoriteServiceRemote_Factory.create(this.retainOrRemoveAllInternal);
            this.W = GetServicesByName_Factory.create(this.isRegionMiniProgram, this.n, this.retainOrRemoveAllInternal);
            this.H = GetFavoriteServices_Factory.create(this.isRegionMiniProgram, this.n, this.retainOrRemoveAllInternal);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.R = GetRawServices_Factory.create(this.retainOrRemoveAllInternal);
            this.AppCompatEmojiTextHelper = GetFavoriteServiceWithCacheFirst_Factory.create(this.retainOrRemoveAllInternal);
            this.V = GetServiceHighlighted_Factory.create(this.retainOrRemoveAllInternal);
            UpdateServiceHighlighted_Factory create10 = UpdateServiceHighlighted_Factory.create(this.retainOrRemoveAllInternal);
            this.rotateTo = create10;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getCardNumberOCR, this.C, this.NewMerchantCategoryAdapter, this.e, this.access$getCapacity$p, this.Z, this.D, this.G, this.W, this.X, this.H, this.getErrorConfigVersion, this.R, this.AppCompatEmojiTextHelper, this.V, create10));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext11 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.TypefaceCompatApi26Impl, this.u, this.v, this.RequestMoneyQrContract$View, this.ReferralMapper_Factory, applicationProvider, this.d));
            this.DatabaseTableConfigUtil = authRequestContext11;
            this.FlowableCreate$BufferAsyncEmitter = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext11));
            this.getContainerAuth = ReadDeepLinkProperties_Factory.create(this.isRegionMiniProgram, this.n);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.GetContactSyncConfig = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            GetUserId_Factory create11 = GetUserId_Factory.create(this.isRegionMiniProgram, this.n, this.h);
            this.QrExpiredActivity = create11;
            Provider<ReadLinkPropertiesPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.FlowableCreate$BufferAsyncEmitter, this.getContainerAuth, this.GetContactSyncConfig, create11, this.i));
            this.secondaryHash = authRequestContext12;
            this.initAnimators = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
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

        /* loaded from: classes4.dex */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType());
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
            private final ApplicationComponent getAuthRequestContext;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.QrExpiredActivity());
            }
        }

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
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$throwIllegalArgumentType());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        @Override // id.dana.di.component.OauthGrantComponent
        public final void getAuthRequestContext(OauthGrantActivity oauthGrantActivity) {
            ((BaseActivity) oauthGrantActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oauthGrantActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(oauthGrantActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            OauthGrantActivity_MembersInjector.PlaceComponentResult(oauthGrantActivity, this.w.get());
            OauthGrantActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oauthGrantActivity, this.initAnimators.get());
            OauthGrantActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(oauthGrantActivity, ScopeAdapter_Factory.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }
}
