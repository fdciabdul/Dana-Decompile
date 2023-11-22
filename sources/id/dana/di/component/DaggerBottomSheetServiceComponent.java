package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.base.BaseResponseMapper_Factory;
import id.dana.bottomsheet.ServicesBottomSheetDialog;
import id.dana.bottomsheet.ServicesBottomSheetDialog_MembersInjector;
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
import id.dana.contract.services.ServicesModule_ProvidePresenterFactory;
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
public final class DaggerBottomSheetServiceComponent {
    private DaggerBottomSheetServiceComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public OauthModule KClassImpl$Data$declaredNonStaticMembers$2;
        public RestoreUrlModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public DeepLinkModule PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public ServicesModule getErrorConfigVersion;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class BottomSheetServiceComponentImpl implements BottomSheetServiceComponent {
        private Provider<GetAuthCode> A;
        private Provider<ThreadExecutor> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServiceWithCacheFirst> AppCompatEmojiTextHelper;
        private Provider<GetDecodeTciCoListConfig> B;
        private Provider<GetCashierNativeConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> C;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<ServicesContract.View> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkPayloadModelMapper> DatabaseTableConfigUtil;
        private Provider<GetEmptyUserInfo> E;
        private Provider<GetFavoriteServices> F;
        private Provider<OauthPresenter> FillAnimation;
        private Provider<ProductPageManager> FlowViewUtil$textChanges$1;
        private Provider<Activity> FlowViewUtil$textChanges$2;
        private Provider<ScanResultMapper> FlowableCreate$BufferAsyncEmitter;
        private final ServicesModule FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePresenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetKycLevel> G;
        private Provider<Context> GetContactSyncConfig;
        private Provider<GetIsCardBindingV2Enabled> H;
        private Provider<GetFeedConfig> I;
        private Provider<GetMerchantQrWhitelist> J;
        private Provider<SplitBillRepository> JsonParseException;
        private Provider<GetMissionDetail> K;
        private final BottomSheetServiceComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetPayerSplitBillDetail> L;
        private Provider<GetNickname> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetRawServices> N;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetPromoCenterVersion> O;
        private Provider<ServicesRepository> OtpRegistrationPresenter$input$1;
        private Provider<FeatureContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetReferralConsult> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<FeatureOauth> PrepareContext;
        private Provider<GetQrBindingConfig> Q;
        private Provider<LiteAccountRepository> QrExpiredActivity;
        private Provider<GetServicesByKey> R;
        private Provider<ValidateNativelyDecodedQr> ReferralMapper_Factory;
        private Provider<RestoreUrlView> RequestMoneyQrContract$View;
        private Provider<GetService> S;
        private Provider<RestoreUrlContract.View> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBill> SubSequence;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetServiceHighlighted> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByName> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesWithCategory> T;
        private Provider<OauthRepository> TypeProjectionImpl;
        private Provider<ReadDeepLinkProperties> TypefaceCompatApi26Impl;
        private Provider<GetSplitBillConfig> U;
        private Provider<GetUpdateAvailability> V;
        private Provider<GenerateReferralDeepLink> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDefaultServiceWithCategory> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetSettingByKey> W;
        private Provider<GetUserId> X;
        private Provider<GetUserInfoWithKyc> Y;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> Z;

        /* renamed from: a */
        private Provider<IsNeedToShowToolTip> f8098a;
        private Provider<UserRepository> access$getCapacity$p;
        private Provider<CardBindingRepository> access$throwIllegalArgumentType;
        private Provider<MyReferralConsultMapper> b;
        private Provider<IsNativeDecodeEnabled> c;
        private Provider<UserConsentRepository> checkRegisteredUserAndSendOtp;
        private Provider<FamilyAccountRepository> connectForeground;
        private Provider<MixpanelDeeplinkTracker> d;
        private Provider<PayerModelListMapper> e;
        private Provider<OauthView> f;
        private Provider<GetUserLoanInfo> flip;
        private Provider<MyReferralConsultRepository> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<ServicesPresenter> getCardNumberOCR;
        private Provider<SplitBillHistoryToSplitBillModelMapper> getContainerAuth;
        private Provider<SettingRepository> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<UpdateServiceHighlighted> getIndexName;
        private Provider<GetNearbyConfig> getNameOrBuilderList;
        private Provider<GetFavoriteServiceRemote> getOnBoardingScenario;
        private Provider<GenerateLinkRepository> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private Provider<PromoQuestRepository> h;
        private Provider<PostExecutionThread> i;
        private Provider<SaveShowDialog> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<GetRequestMoneyInfoFeature> isAuth;
        private Provider<GetUserStatusInfo> isAuto;
        private Provider<FeatureFamilyAccount> isLayoutRequested;
        private Provider<FeedsConfigRepository> j;
        private Provider<PaylaterRepository> k;
        private Provider<ScanQrContract.Presenter> l;
        private Provider<CheckDeepLinkActionVisibility> lookAheadTest;
        private Provider<RestoreUrlContract.Presenter> m;
        private Provider<CheckShowReferralCodeFeature> moveToNextValue;
        private Provider<ReadLinkPropertiesContract.Presenter> n;
        private Provider<FeatureConfigRepository> newProxyInstance;

        /* renamed from: o */
        private Provider<PushVerifyTracker> f8099o;
        private Provider<ShortenerRepository> onDecodeSuccess;
        private Provider<OauthContract.Presenter> p;
        private Provider<ScanQrContract.View> q;
        private Provider<FeatureContract.View> r;
        private Provider<FeatureView> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<UserEducationRepository> f5821reduceIndexedz1zDJgo;
        private Provider<OauthContract.View> s;
        private Provider<CheckFavoriteServicesFeature> scheduleImpl;
        private Provider<ThirdPartyServicesMapper> secondaryHash;
        private Provider<SaveShowToolTip> setNetAuthId;
        private Provider<GetWhitelistedSubMerchantId> shouldRecycleViewType;
        private Provider<DeepLinkContract.View> t;
        private Provider<RestoreUrlPresenter> u;
        private Provider<RestoreUrl> v;
        private Provider<ServiceCategoryMapper> verifyNotNull;
        private Provider<QrBarcodeRepository> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<ReadLinkPropertiesPresenter> x;
        private Provider<ScanQrPresenter> y;
        private Provider<ScanQrView> z;

        public /* synthetic */ BottomSheetServiceComponentImpl(ServicesModule servicesModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ApplicationComponent applicationComponent, byte b) {
            this(servicesModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, applicationComponent);
        }

        private BottomSheetServiceComponentImpl(ServicesModule servicesModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.FlowableReduce$ReduceSubscriber = servicesModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.GetContactSyncConfig = new ContextProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.TypeProjectionImpl = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.checkRegisteredUserAndSendOtp = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.E = create;
            this.A = GetAuthCode_Factory.create(this.TypeProjectionImpl, create);
            ServiceCategoryMapper_Factory authRequestContext = ServiceCategoryMapper_Factory.getAuthRequestContext(this.GetContactSyncConfig);
            this.verifyNotNull = authRequestContext;
            this.secondaryHash = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            this.ApiStatus$AvailableSince = new ThreadExecutorProvider(applicationComponent);
            this.i = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.f5821reduceIndexedz1zDJgo = userEducationRepositoryProvider;
            this.f8098a = IsNeedToShowToolTip_Factory.create(this.ApiStatus$AvailableSince, this.i, userEducationRepositoryProvider);
            this.setNetAuthId = SaveShowToolTip_Factory.create(this.ApiStatus$AvailableSince, this.i, this.f5821reduceIndexedz1zDJgo);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = servicesRepositoryProvider;
            this.T = GetServicesWithCategory_Factory.create(servicesRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDefaultServiceWithCategory_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.getOnBoardingScenario = GetFavoriteServiceRemote_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByName_Factory.create(this.ApiStatus$AvailableSince, this.i, this.OtpRegistrationPresenter$input$1);
            this.R = GetServicesByKey_Factory.create(this.ApiStatus$AvailableSince, this.i, this.OtpRegistrationPresenter$input$1);
            this.F = GetFavoriteServices_Factory.create(this.ApiStatus$AvailableSince, this.i, this.OtpRegistrationPresenter$input$1);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.newProxyInstance = featureConfigRepositoryProvider;
            this.scheduleImpl = CheckFavoriteServicesFeature_Factory.create(featureConfigRepositoryProvider);
            this.N = GetRawServices_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.AppCompatEmojiTextHelper = GetFavoriteServiceWithCacheFirst_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetServiceHighlighted_Factory.create(this.OtpRegistrationPresenter$input$1);
            UpdateServiceHighlighted_Factory create2 = UpdateServiceHighlighted_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.getIndexName = create2;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.GetContactSyncConfig, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.A, this.secondaryHash, this.f8098a, this.setNetAuthId, this.T, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.getOnBoardingScenario, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.R, this.F, this.scheduleImpl, this.N, this.AppCompatEmojiTextHelper, this.SummaryVoucherView$$ExternalSyntheticLambda1, create2));
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.FlowViewUtil$textChanges$2 = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.z = authRequestContext3;
            this.q = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.w = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.ApiStatus$AvailableSince, this.i, this.w);
            this.FlowableCreate$BufferAsyncEmitter = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = userRepositoryProvider;
            this.isAuto = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetCashierNativeConfig_Factory.create(this.newProxyInstance);
            this.c = IsNativeDecodeEnabled_Factory.create(this.newProxyInstance);
            GetDecodeTciCoListConfig_Factory create3 = GetDecodeTciCoListConfig_Factory.create(this.newProxyInstance);
            this.B = create3;
            this.ReferralMapper_Factory = ValidateNativelyDecodedQr_Factory.create(create3);
            this.J = GetMerchantQrWhitelist_Factory.create(this.w);
            this.Q = GetQrBindingConfig_Factory.create(this.newProxyInstance);
            this.Z = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.newProxyInstance);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.k = providePaylaterRepositoryProvider;
            this.flip = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetQrisCpmSendmoneyConfig_Factory.create(this.newProxyInstance, this.f5821reduceIndexedz1zDJgo);
            this.initAnimators = SaveShowDialog_Factory.create(this.f5821reduceIndexedz1zDJgo);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig, this.q, this.getValueOfTouchPositionAbsolute, this.D, this.FlowableCreate$BufferAsyncEmitter, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.isAuto, this.BottomSheetCardBindingView$watcherCardNumberView$1, GetNativelyDecodedQr_Factory.create(), this.c, this.ReferralMapper_Factory, this.J, this.Q, this.Z, this.flip, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.initAnimators));
            this.y = authRequestContext4;
            this.l = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            Provider<RestoreUrlView> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            this.RequestMoneyQrContract$View = authRequestContext5;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = shortenerRepositoryProvider;
            RestoreUrl_Factory create4 = RestoreUrl_Factory.create(this.ApiStatus$AvailableSince, this.i, shortenerRepositoryProvider);
            this.v = create4;
            Provider<RestoreUrlPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.SizeSelectors$OrSelector, create4));
            this.u = authRequestContext6;
            this.m = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.g = myReferralConsultRepositoryProvider;
            this.P = GetReferralConsult_Factory.create(this.ApiStatus$AvailableSince, this.i, myReferralConsultRepositoryProvider);
            this.moveToNextValue = CheckShowReferralCodeFeature_Factory.create(this.newProxyInstance);
            this.b = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = generateLinkRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GenerateReferralDeepLink_Factory.create(this.ApiStatus$AvailableSince, this.i, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = settingRepositoryProvider;
            this.W = GetSettingByKey_Factory.create(this.ApiStatus$AvailableSince, this.i, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.W, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.JsonParseException = splitBillRepositoryProvider;
            this.L = GetPayerSplitBillDetail_Factory.create(this.ApiStatus$AvailableSince, this.i, splitBillRepositoryProvider);
            this.e = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.e);
            this.getContainerAuth = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.L, PlaceComponentResult);
            this.U = GetSplitBillConfig_Factory.create(this.ApiStatus$AvailableSince, this.i, this.newProxyInstance);
            GetRequestMoneyInfoFeature_Factory create5 = GetRequestMoneyInfoFeature_Factory.create(this.ApiStatus$AvailableSince, this.i, this.newProxyInstance);
            this.isAuth = create5;
            Provider<GetSplitBillConfig> provider = this.U;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.SubSequence = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create5, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.h = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create6 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.K = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeaturePromoQuest_Factory.getAuthRequestContext(create6, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.GetContactSyncConfig));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.GetContactSyncConfig);
            this.d = MyBillsEntityDataFactory;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.connectForeground = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = dynamicUrlWrapperProvider;
            this.isLayoutRequested = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.H = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.d));
            Provider<FeatureView> authRequestContext7 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.P, this.moveToNextValue, this.b, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getCallingPid, this.whenAvailable, this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.PrepareContext, FeatureKyb_Factory.getAuthRequestContext(), this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.flip, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda5));
            this.readMicros = authRequestContext7;
            Provider<FeatureContract.View> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext7));
            this.r = authRequestContext8;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext8, this.R, this.secondaryHash, this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.lookAheadTest = CheckDeepLinkActionVisibility_Factory.create(this.ApiStatus$AvailableSince, this.i, this.newProxyInstance);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckWhitelistedValidDomain_Factory.create(this.newProxyInstance);
            this.getNameOrBuilderList = GetNearbyConfig_Factory.create(this.newProxyInstance);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.j = provideFeedsConfigRepositoryProvider;
            this.I = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.O = GetPromoCenterVersion_Factory.create(this.newProxyInstance);
            this.V = GetUpdateAvailability_Factory.create(this.GetContactSyncConfig);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.newProxyInstance);
            this.f8099o = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.OtpRegistrationPresenter$input$1);
            this.S = create7;
            Provider<FeaturePresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.r, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getNameOrBuilderList, this.I, this.O, this.V, this.getErrorConfigVersion, this.f8099o, create7));
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext9;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext9));
            OauthView_Factory authRequestContext10 = OauthView_Factory.getAuthRequestContext(this.PrepareContext);
            this.f = authRequestContext10;
            this.s = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext10));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.G = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.Y = GetUserInfoWithKyc_Factory.create(this.ApiStatus$AvailableSince, this.i, this.access$getCapacity$p);
            this.M = GetNickname_Factory.create(this.ApiStatus$AvailableSince, this.i, this.PlaceComponentResult);
            this.shouldRecycleViewType = GetWhitelistedSubMerchantId_Factory.create(this.newProxyInstance);
            this.C = GetAddingNameWhitelistedMerchantId_Factory.create(this.newProxyInstance);
            Provider<OauthContract.View> provider2 = this.s;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.G, this.Y, this.M, this.shouldRecycleViewType, this.C);
            this.FillAnimation = KClassImpl$Data$declaredNonStaticMembers$2;
            this.p = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext11 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.l, this.m, this.OtpRegistrationPresenter$input$2, this.p, this.getCardNumberOCR, applicationProvider, this.flip));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext11;
            this.t = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext11));
            this.TypefaceCompatApi26Impl = ReadDeepLinkProperties_Factory.create(this.ApiStatus$AvailableSince, this.i);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.QrExpiredActivity = liteAccountRepositoryProvider;
            GetUserId_Factory create8 = GetUserId_Factory.create(this.ApiStatus$AvailableSince, this.i, liteAccountRepositoryProvider);
            this.X = create8;
            Provider<ReadLinkPropertiesPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.t, this.TypefaceCompatApi26Impl, this.DatabaseTableConfigUtil, create8, this.d));
            this.x = authRequestContext12;
            this.n = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
        }

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

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.WithdrawSavedCardChannelView());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.setNetAuthId());
            }
        }

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
            private final ApplicationComponent PlaceComponentResult;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isInfoWindowShown());
            }
        }

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
            private final ApplicationComponent PlaceComponentResult;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.z());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowableCreate$BufferAsyncEmitter());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent getAuthRequestContext;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

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

        @Override // id.dana.di.component.BottomSheetServiceComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog) {
            servicesBottomSheetDialog.presenter = ServicesModule_ProvidePresenterFactory.getAuthRequestContext(this.FlowableReduce$ReduceSubscriber, this.getCardNumberOCR.get());
            ServicesBottomSheetDialog_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesBottomSheetDialog, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            ServicesBottomSheetDialog_MembersInjector.PlaceComponentResult(servicesBottomSheetDialog, this.n.get());
            servicesBottomSheetDialog.featurePresenter = this.OtpRegistrationPresenter$input$2.get();
        }
    }
}
