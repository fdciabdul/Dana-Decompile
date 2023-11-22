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
import id.dana.deeplink.DeeplinkNavigatorActivity;
import id.dana.deeplink.DeeplinkNavigatorActivity_MembersInjector;
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

/* loaded from: classes8.dex */
public final class DaggerDeeplinkNavigatorComponent {
    private DaggerDeeplinkNavigatorComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public OauthModule BuiltInFictitiousFunctionClassFactory;
        public DeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public RestoreUrlModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;
        public ScanQrModule getErrorConfigVersion;
        public ServicesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class DeeplinkNavigatorComponentImpl implements DeeplinkNavigatorComponent {
        private Provider<GetCashierNativeConfig> A;
        private Provider<UpdateServiceHighlighted> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServiceWithCacheFirst> AppCompatEmojiTextHelper;
        private Provider<GetAddingNameWhitelistedMerchantId> B;
        private Provider<GetAuthCode> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private Provider<GetDecodeTciCoListConfig> D;
        private Provider<PushVerifyTracker> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkPayloadModelMapper> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrisTopUp> E;
        private Provider<GetFeedConfig> F;
        private Provider<OauthPresenter> FillAnimation;
        private Provider<PostExecutionThread> FlowViewUtil$textChanges$1;
        private Provider<PayerModelListMapper> FlowViewUtil$textChanges$2;
        private Provider<ScanQrPresenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<SaveShowToolTip> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServices> G;
        private Provider<DanaCustomH5> GetContactSyncConfig;
        private Provider<GetIsCardBindingV2Enabled> H;
        private Provider<GetFavoriteServiceRemote> I;
        private Provider<UserRepository> InitSecurePreferenceAccount;
        private Provider<GetKycLevel> J;
        private Provider<SettingRepository> JsonParseException;
        private Provider<GetMissionDetail> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMerchantQrWhitelist> L;
        private Provider<GetNearbyConfig> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetQrBindingConfig> N;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final DeeplinkNavigatorComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetPromoCenterVersion> O;
        private Provider<ServiceCategoryMapper> OtpRegistrationPresenter$input$1;
        private Provider<RestoreUrlContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetPayerSplitBillDetail> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<FeatureConfigRepository> PrepareContext;
        private Provider<ValidateNativelyDecodedQr> PromoCategoryPresenter$1;
        private Provider<GetRawServices> Q;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> QrExpiredActivity;
        private Provider<GetServiceHighlighted> R;
        private Provider<UserEducationRepository> ReferralMapper_Factory;
        private Provider<RestoreUrlView> RequestMoneyQrContract$View;
        private Provider<GetRequestMoneyInfoFeature> S;
        private Provider<FeatureContract.View> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBill> SubSequence;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetReferralConsult> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByKey> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesWithCategory> T;
        private Provider<OauthRepository> TypeProjectionImpl;
        private Provider<ReadLinkPropertiesPresenter> TypefaceCompatApi26Impl;
        private Provider<GetSplitBillConfig> U;
        private Provider<GetSettingByKey> V;
        private Provider<GenerateReferralDeepLink> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesByName> W;
        private Provider<GetUpdateAvailability> X;
        private Provider<GetUserInfoWithKyc> Y;
        private Provider<GetUserStatusInfo> Z;

        /* renamed from: a */
        private Provider<IsOfflineF2FPay> f8104a;
        private Provider<UserConsentRepository> access$getCapacity$p;
        private Provider<Activity> access$throwIllegalArgumentType;
        private Provider<IsNativeDecodeEnabled> b;
        private Provider<LiteAccountRepository> c;
        private Provider<ThirdPartyServicesMapper> checkRegisteredUserAndSendOtp;
        private Provider<ProductPageManager> connectForeground;
        private Provider<IsNeedToShowToolTip> d;
        private Provider<MixpanelDeeplinkTracker> e;
        private Provider<MyReferralConsultRepository> f;
        private Provider<GetUserLoanInfo> flip;
        private Provider<MyReferralConsultMapper> g;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<ScanResultMapper> getCardNumberOCR;
        private Provider<SplitBillHistoryToSplitBillModelMapper> getContainerAuth;
        private Provider<ShortenerRepository> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<SplitBillRepository> getIndexName;
        private Provider<GetNickname> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<FeatureServicesHandler> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private Provider<PromoQuestRepository> h;
        private Provider<OauthView> i;
        private Provider<SaveShowDialog> initAnimators;
        private Provider<Context> initRecordTimeStamp;
        private Provider<GetService> isAuth;
        private Provider<GetWhitelistedSubMerchantId> isAuto;
        private Provider<FeatureFamilyAccount> isLayoutRequested;
        private Provider<PaylaterRepository> j;
        private Provider<CardBindingRepository> k;
        private Provider<FeedsConfigRepository> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<FamilyAccountRepository> m;
        private Provider<ConnectionStatusReceiver> moveToNextValue;
        private Provider<FeatureContract.Presenter> n;
        private Provider<FeatureCardBinding> newProxyInstance;

        /* renamed from: o */
        private Provider<ScanQrContract.Presenter> f8105o;
        private Provider<ServicesRepository> onDecodeSuccess;
        private Provider<OauthContract.Presenter> p;
        private Provider<ScanQrContract.View> q;
        private Provider<ReadLinkPropertiesContract.Presenter> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ThreadExecutor> f5822reduceIndexedz1zDJgo;
        private Provider<OauthContract.View> s;
        private Provider<CheckMyBillsVersionConfig> scheduleImpl;
        private Provider<ServicesPresenter> secondaryHash;
        private Provider<RestoreUrl> setNetAuthId;
        private Provider<GetUserId> shouldRecycleViewType;
        private Provider<RestoreUrlContract.View> t;
        private Provider<ReadDeepLinkProperties> u;
        private Provider<QrBarcodeRepository> v;
        private Provider<ScanQrView> verifyNotNull;
        private Provider<ServicesContract.View> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<DeepLinkContract.View> x;
        private Provider<SSLPinningRepository> y;
        private Provider<RestoreUrlPresenter> z;

        public /* synthetic */ DeeplinkNavigatorComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private DeeplinkNavigatorComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.f5822reduceIndexedz1zDJgo = new ThreadExecutorProvider(applicationComponent);
            this.y = new SSLPinningRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PrepareContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, featureConfigRepositoryProvider);
            this.f8104a = create;
            this.moveToNextValue = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.f5822reduceIndexedz1zDJgo, this.y, create);
            this.initRecordTimeStamp = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.access$throwIllegalArgumentType = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.verifyNotNull = authRequestContext2;
            this.q = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.v = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.E = GetDecodedQrisTopUp_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.v);
            this.getCardNumberOCR = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.InitSecurePreferenceAccount = userRepositoryProvider;
            this.Z = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.A = GetCashierNativeConfig_Factory.create(this.PrepareContext);
            this.b = IsNativeDecodeEnabled_Factory.create(this.PrepareContext);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.PrepareContext);
            this.D = create2;
            this.PromoCategoryPresenter$1 = ValidateNativelyDecodedQr_Factory.create(create2);
            this.L = GetMerchantQrWhitelist_Factory.create(this.v);
            this.N = GetQrBindingConfig_Factory.create(this.PrepareContext);
            this.QrExpiredActivity = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.PrepareContext);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.j = providePaylaterRepositoryProvider;
            this.flip = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetQrisCpmSendmoneyConfig_Factory.create(this.PrepareContext, userEducationRepositoryProvider);
            this.initAnimators = SaveShowDialog_Factory.create(this.ReferralMapper_Factory);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, this.q, this.getValueOfTouchPositionAbsolute, this.E, this.getCardNumberOCR, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.Z, this.A, GetNativelyDecodedQr_Factory.create(), this.b, this.PromoCategoryPresenter$1, this.L, this.N, this.QrExpiredActivity, this.flip, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.initAnimators));
            this.FlowableCreate$BufferAsyncEmitter = authRequestContext3;
            this.f8105o = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            this.RequestMoneyQrContract$View = authRequestContext4;
            this.t = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, shortenerRepositoryProvider);
            this.setNetAuthId = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.t, create3));
            this.z = authRequestContext5;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.f = myReferralConsultRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetReferralConsult_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.PrepareContext);
            this.g = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GenerateReferralDeepLink_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.JsonParseException = settingRepositoryProvider;
            this.V = GetSettingByKey_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.connectForeground = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.V, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getIndexName = splitBillRepositoryProvider;
            this.P = GetPayerSplitBillDetail_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, splitBillRepositoryProvider);
            this.FlowViewUtil$textChanges$2 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.FlowViewUtil$textChanges$2);
            this.getContainerAuth = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.P, PlaceComponentResult);
            this.U = GetSplitBillConfig_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.PrepareContext);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.PrepareContext);
            this.S = create4;
            Provider<GetSplitBillConfig> provider = this.U;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.SubSequence = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.h = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.K = create5;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.initRecordTimeStamp));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp);
            this.e = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.m = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = dynamicUrlWrapperProvider;
            this.isLayoutRequested = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.k = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.H = BuiltInFictitiousFunctionClassFactory;
            this.newProxyInstance = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.e));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda1, this.lookAheadTest, this.g, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getCallingPid, this.whenAvailable, this.SubSequence, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.GetContactSyncConfig, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda6, FeatureKyb_Factory.getAuthRequestContext(), this.isLayoutRequested, this.newProxyInstance, this.flip, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.readMicros = authRequestContext6;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = servicesRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByKey_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.initRecordTimeStamp);
            this.OtpRegistrationPresenter$input$1 = authRequestContext7;
            this.checkRegisteredUserAndSendOtp = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.TypeProjectionImpl = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.TypeProjectionImpl, create6);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create7;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SizeSelectors$OrSelector, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.checkRegisteredUserAndSendOtp, create7, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckWhitelistedValidDomain_Factory.create(this.PrepareContext);
            this.M = GetNearbyConfig_Factory.create(this.PrepareContext);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.l = provideFeedsConfigRepositoryProvider;
            this.F = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.O = GetPromoCenterVersion_Factory.create(this.PrepareContext);
            this.X = GetUpdateAvailability_Factory.create(this.initRecordTimeStamp);
            this.scheduleImpl = CheckMyBillsVersionConfig_Factory.create(this.PrepareContext);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.onDecodeSuccess);
            this.isAuth = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.SizeSelectors$OrSelector, this.getSupportButtonTintMode, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.M, this.F, this.O, this.X, this.scheduleImpl, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext8;
            this.n = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.i = authRequestContext9;
            this.s = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.J = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.Y = GetUserInfoWithKyc_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.InitSecurePreferenceAccount);
            this.getNameOrBuilderList = GetNickname_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.getAuthRequestContext);
            this.isAuto = GetWhitelistedSubMerchantId_Factory.create(this.PrepareContext);
            this.B = GetAddingNameWhitelistedMerchantId_Factory.create(this.PrepareContext);
            Provider<OauthContract.View> provider2 = this.s;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.J, this.Y, this.getNameOrBuilderList, this.isAuto, this.B);
            this.FillAnimation = KClassImpl$Data$declaredNonStaticMembers$2;
            this.p = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.w = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.d = IsNeedToShowToolTip_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.ReferralMapper_Factory);
            this.FlowableReduce$ReduceSubscriber = SaveShowToolTip_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.ReferralMapper_Factory);
            this.T = GetServicesWithCategory_Factory.create(this.onDecodeSuccess);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.onDecodeSuccess);
            this.I = GetFavoriteServiceRemote_Factory.create(this.onDecodeSuccess);
            this.W = GetServicesByName_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.onDecodeSuccess);
            this.G = GetFavoriteServices_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, this.onDecodeSuccess);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.PrepareContext);
            this.Q = GetRawServices_Factory.create(this.onDecodeSuccess);
            this.AppCompatEmojiTextHelper = GetFavoriteServiceWithCacheFirst_Factory.create(this.onDecodeSuccess);
            this.R = GetServiceHighlighted_Factory.create(this.onDecodeSuccess);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.onDecodeSuccess);
            this.ApiStatus$AvailableSince = create9;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.w, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.checkRegisteredUserAndSendOtp, this.d, this.FlowableReduce$ReduceSubscriber, this.T, this.getOnBoardingScenario, this.I, this.W, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.G, this.getErrorConfigVersion, this.Q, this.AppCompatEmojiTextHelper, this.R, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.f8105o, this.OtpRegistrationPresenter$input$2, this.n, this.p, this.secondaryHash, applicationProvider, this.flip));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext10;
            this.x = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.u = ReadDeepLinkProperties_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.c = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.f5822reduceIndexedz1zDJgo, this.FlowViewUtil$textChanges$1, liteAccountRepositoryProvider);
            this.shouldRecycleViewType = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.x, this.u, this.DatabaseTableConfigUtil, create10, this.e));
            this.TypefaceCompatApi26Impl = authRequestContext11;
            this.r = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
            private final ApplicationComponent getAuthRequestContext;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent getAuthRequestContext;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        @Override // id.dana.di.component.DeeplinkNavigatorComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DeeplinkNavigatorActivity deeplinkNavigatorActivity) {
            ((BaseActivity) deeplinkNavigatorActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(deeplinkNavigatorActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(deeplinkNavigatorActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            DeeplinkNavigatorActivity_MembersInjector.PlaceComponentResult(deeplinkNavigatorActivity, this.r.get());
        }
    }
}
