package id.dana.miniprogram.di;

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
import id.dana.di.component.ApplicationComponent;
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
import id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity;
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

/* loaded from: classes5.dex */
public final class DaggerMissingRequiredUserInfoComponent {
    private DaggerMissingRequiredUserInfoComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public RestoreUrlModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ApplicationComponent PlaceComponentResult;
        public OauthModule getAuthRequestContext;
        public ServicesModule lookAheadTest;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class MissingRequiredUserInfoComponentImpl implements MissingRequiredUserInfoComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<ThreadExecutor> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServiceWithCacheFirst> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GetCashierNativeConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetDecodeTciCoListConfig> C;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<FeatureContract.Presenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeviceInformationProvider> DatabaseTableConfigUtil;
        private Provider<GetFavoriteServiceRemote> E;
        private Provider<GetFavoriteServices> F;
        private Provider<OauthRepository> FillAnimation;
        private Provider<ProductPageManager> FlowViewUtil$textChanges$1;
        private Provider<PostExecutionThread> FlowViewUtil$textChanges$2;
        private Provider<ScanQrView> FlowableCreate$BufferAsyncEmitter;
        private Provider<SaveShowToolTip> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureServicesHandler> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFeedConfig> G;
        private Provider<DanaCustomH5> GetContactSyncConfig;
        private Provider<GetIsCardBindingV2Enabled> H;
        private Provider<GetKycLevel> I;
        private Provider<GetNearbyConfig> J;
        private Provider<ServicesRepository> JsonParseException;
        private Provider<GetMissionDetail> K;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetPayerSplitBillDetail> L;
        private Provider<GetNickname> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetRawServices> N;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetPromoCenterVersion> O;
        private Provider<ScanResultMapper> OtpRegistrationPresenter$input$1;
        private Provider<ScanQrContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetReferralConsult> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<FeatureCardBinding> PrepareContext;
        private Provider<UserEducationRepository> PromoCategoryPresenter$1;
        private Provider<GetQrisCpmSendmoneyConfig> Q;
        private Provider<LiteAccountRepository> QrExpiredActivity;
        private Provider<GetServiceHighlighted> R;
        private Provider<UserRepository> ReferralMapper_Factory;
        private Provider<RestoreUrlView> RequestMoneyQrContract$View;
        private Provider<GetService> S;
        private Provider<FeatureContract.View> SizeSelectors$OrSelector;
        private Provider<FeatureView> SubSequence;
        private Provider<GetQrBindingConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetServicesByName> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByKey> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetSettingByKey> T;
        private Provider<MyReferralConsultRepository> TypeProjectionImpl;
        private Provider<ReadDeepLinkProperties> TypefaceCompatApi26Impl;
        private Provider<GetSplitBillConfig> U;
        private Provider<GetUpdateAvailability> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesWithCategory> W;
        private Provider<GetUserId> X;
        private Provider<GetUserInfoWithKyc> Y;
        private Provider<GetUserStatusInfo> Z;

        /* renamed from: a */
        private Provider<IsNativeDecodeEnabled> f8214a;
        private Provider<UserConsentRepository> access$getCapacity$p;
        private Provider<CardBindingRepository> access$throwIllegalArgumentType;
        private final MissingRequiredUserInfoComponentImpl b;
        private Provider<IsNeedToShowToolTip> c;
        private Provider<UpdateServiceHighlighted> checkRegisteredUserAndSendOtp;
        private Provider<PayerModelListMapper> connectForeground;
        private Provider<IsOfflineF2FPay> d;
        private Provider<MyReferralConsultMapper> e;
        private Provider<MixpanelDeeplinkTracker> f;
        private Provider<GetWhitelistedSubMerchantId> flip;
        private Provider<OauthPresenter> g;
        private Provider<CheckDeepLinkActionVisibility> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<ScanQrPresenter> getCardNumberOCR;
        private Provider<SettingRepository> getContainerAuth;
        private Provider<ServicesPresenter> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<SplitBillRepository> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<GenerateLinkRepository> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private Provider<OauthView> h;
        private Provider<PromoQuestRepository> i;
        private Provider<RestoreUrl> initAnimators;
        private Provider<DeepLinkPayloadModelMapper> initRecordTimeStamp;
        private Provider<GetRequestMoneyInfoFeature> isAuth;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> isAuto;
        private Provider<FeatureConfigRepository> isLayoutRequested;
        private Provider<PaylaterRepository> j;
        private Provider<Activity> k;
        private Provider<FeedsConfigRepository> l;
        private Provider<CheckWhitelistedValidDomain> lookAheadTest;
        private Provider<FamilyAccountRepository> m;
        private Provider<ConnectionStatusReceiver> moveToNextValue;
        private Provider<OauthContract.Presenter> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<RestoreUrlContract.Presenter> f8215o;
        private Provider<SplitBillHistoryToSplitBillModelMapper> onDecodeSuccess;
        private Provider<PushVerifyTracker> p;
        private Provider<ScanQrContract.View> q;
        private Provider<ReadLinkPropertiesContract.Presenter> r;
        private Provider<FeatureSplitBill> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ThirdPartyServicesMapper> f5899reduceIndexedz1zDJgo;
        private Provider<ValidateNativelyDecodedQr> retainOrRemoveAllInternal;
        private Provider<RestoreUrlContract.View> s;
        private Provider<CheckShowReferralCodeFeature> scheduleImpl;
        private Provider<ShortenerRepository> secondaryHash;
        private Provider<SSLPinningRepository> setNetAuthId;
        private Provider<GetUserLoanInfo> shouldRecycleViewType;
        private Provider<OauthContract.View> t;
        private Provider<DeepLinkContract.View> u;
        private Provider<QrBarcodeRepository> v;
        private Provider<ServiceCategoryMapper> verifyNotNull;
        private Provider<ReadLinkPropertiesPresenter> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<ServicesContract.View> x;
        private Provider<RestoreUrlPresenter> y;
        private Provider<SaveShowDialog> z;

        public /* synthetic */ MissingRequiredUserInfoComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private MissingRequiredUserInfoComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.b = this;
            this.PlaceComponentResult = applicationComponent;
            this.ApiStatus$AvailableSince = new ThreadExecutorProvider(applicationComponent);
            this.setNetAuthId = new SSLPinningRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.isLayoutRequested = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, featureConfigRepositoryProvider);
            this.d = create;
            this.moveToNextValue = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.ApiStatus$AvailableSince, this.setNetAuthId, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.k = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.FlowableCreate$BufferAsyncEmitter = authRequestContext2;
            this.q = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.v = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.v);
            this.OtpRegistrationPresenter$input$1 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.DatabaseTableConfigUtil = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = userRepositoryProvider;
            this.Z = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetCashierNativeConfig_Factory.create(this.isLayoutRequested);
            this.f8214a = IsNativeDecodeEnabled_Factory.create(this.isLayoutRequested);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.isLayoutRequested);
            this.C = create2;
            this.retainOrRemoveAllInternal = ValidateNativelyDecodedQr_Factory.create(create2);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.v);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetQrBindingConfig_Factory.create(this.isLayoutRequested);
            this.isAuto = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.isLayoutRequested);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.j = providePaylaterRepositoryProvider;
            this.shouldRecycleViewType = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = userEducationRepositoryProvider;
            this.Q = GetQrisCpmSendmoneyConfig_Factory.create(this.isLayoutRequested, userEducationRepositoryProvider);
            this.z = SaveShowDialog_Factory.create(this.PromoCategoryPresenter$1);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.q, this.getValueOfTouchPositionAbsolute, this.D, this.OtpRegistrationPresenter$input$1, this.DatabaseTableConfigUtil, this.Z, this.BottomSheetCardBindingView$watcherCardNumberView$1, GetNativelyDecodedQr_Factory.create(), this.f8214a, this.retainOrRemoveAllInternal, this.getNameOrBuilderList, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.isAuto, this.shouldRecycleViewType, this.Q, this.z));
            this.getCardNumberOCR = authRequestContext3;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.RequestMoneyQrContract$View = authRequestContext4;
            this.s = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.secondaryHash = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, shortenerRepositoryProvider);
            this.initAnimators = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.s, create3));
            this.y = authRequestContext5;
            this.f8215o = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.TypeProjectionImpl = myReferralConsultRepositoryProvider;
            this.P = GetReferralConsult_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, myReferralConsultRepositoryProvider);
            this.scheduleImpl = CheckShowReferralCodeFeature_Factory.create(this.isLayoutRequested);
            this.e = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getContainerAuth = settingRepositoryProvider;
            this.T = GetSettingByKey_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.FlowViewUtil$textChanges$1 = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.T, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getIndexName = splitBillRepositoryProvider;
            this.L = GetPayerSplitBillDetail_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, splitBillRepositoryProvider);
            this.connectForeground = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.connectForeground);
            this.onDecodeSuccess = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.L, PlaceComponentResult);
            this.U = GetSplitBillConfig_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.isLayoutRequested);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.isLayoutRequested);
            this.isAuth = create4;
            Provider<GetSplitBillConfig> provider = this.U;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.readMicros = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.i = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.K = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.f = MyBillsEntityDataFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.m = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.H = BuiltInFictitiousFunctionClassFactory;
            this.PrepareContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.f));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.P, this.scheduleImpl, this.e, this.A, this.getCallingPid, this.whenAvailable, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.GetContactSyncConfig, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.PrepareContext, this.shouldRecycleViewType, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda6));
            this.SubSequence = authRequestContext6;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.JsonParseException = servicesRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByKey_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.verifyNotNull = authRequestContext7;
            this.f5899reduceIndexedz1zDJgo = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.FillAnimation = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.FillAnimation, create6);
            this.B = create7;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SizeSelectors$OrSelector, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.f5899reduceIndexedz1zDJgo, create7, this.DatabaseTableConfigUtil));
            this.getAuthRequestContext = CheckDeepLinkActionVisibility_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.isLayoutRequested);
            this.lookAheadTest = CheckWhitelistedValidDomain_Factory.create(this.isLayoutRequested);
            this.J = GetNearbyConfig_Factory.create(this.isLayoutRequested);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.l = provideFeedsConfigRepositoryProvider;
            this.G = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.O = GetPromoCenterVersion_Factory.create(this.isLayoutRequested);
            this.V = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.isLayoutRequested);
            this.p = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.JsonParseException);
            this.S = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.SizeSelectors$OrSelector, this.FragmentBottomSheetPaymentSettingBinding, this.getAuthRequestContext, this.lookAheadTest, this.J, this.G, this.O, this.V, this.getErrorConfigVersion, this.p, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext8;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.h = authRequestContext9;
            this.t = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.I = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.Y = GetUserInfoWithKyc_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.ReferralMapper_Factory);
            this.M = GetNickname_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.flip = GetWhitelistedSubMerchantId_Factory.create(this.isLayoutRequested);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.isLayoutRequested);
            Provider<OauthContract.View> provider2 = this.t;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.I, this.Y, this.M, this.flip, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.g = KClassImpl$Data$declaredNonStaticMembers$2;
            this.n = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.x = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.c = IsNeedToShowToolTip_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.PromoCategoryPresenter$1);
            this.FlowableReduce$ReduceSubscriber = SaveShowToolTip_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.PromoCategoryPresenter$1);
            this.W = GetServicesWithCategory_Factory.create(this.JsonParseException);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.JsonParseException);
            this.E = GetFavoriteServiceRemote_Factory.create(this.JsonParseException);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetServicesByName_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.JsonParseException);
            this.F = GetFavoriteServices_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, this.JsonParseException);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckFavoriteServicesFeature_Factory.create(this.isLayoutRequested);
            this.N = GetRawServices_Factory.create(this.JsonParseException);
            this.AppCompatEmojiTextHelper = GetFavoriteServiceWithCacheFirst_Factory.create(this.JsonParseException);
            this.R = GetServiceHighlighted_Factory.create(this.JsonParseException);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.JsonParseException);
            this.checkRegisteredUserAndSendOtp = create9;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.x, this.B, this.f5899reduceIndexedz1zDJgo, this.c, this.FlowableReduce$ReduceSubscriber, this.W, this.getOnBoardingScenario, this.E, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.F, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.N, this.AppCompatEmojiTextHelper, this.R, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.OtpRegistrationPresenter$input$2, this.f8215o, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.n, this.getDefaultSenderId, applicationProvider, this.shouldRecycleViewType));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext10;
            this.u = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.TypefaceCompatApi26Impl = ReadDeepLinkProperties_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.initRecordTimeStamp = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.QrExpiredActivity = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.ApiStatus$AvailableSince, this.FlowViewUtil$textChanges$2, liteAccountRepositoryProvider);
            this.X = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.u, this.TypefaceCompatApi26Impl, this.initRecordTimeStamp, create10, this.f));
            this.w = authRequestContext11;
            this.r = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BannerEntityDataFactory_Factory());
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.miniprogram.di.MissingRequiredUserInfoComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MissingRequiredUserInfoDialogActivity missingRequiredUserInfoDialogActivity) {
            ((BaseActivity) missingRequiredUserInfoDialogActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(missingRequiredUserInfoDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(missingRequiredUserInfoDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested));
            missingRequiredUserInfoDialogActivity.readLinkPropertiesPresenter = this.r.get();
        }
    }
}
