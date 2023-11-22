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
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.di.modules.OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory;
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
import id.dana.onlinemerchant.view.OnlineMerchantListView;
import id.dana.onlinemerchant.view.OnlineMerchantListView_MembersInjector;
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
public final class DaggerOnlineMerchantListViewComponent {
    private DaggerOnlineMerchantListViewComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public DeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public OauthModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public OnlineMerchantAnalyticModule PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public ServicesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class OnlineMerchantListViewComponentImpl implements OnlineMerchantListViewComponent {
        private Provider<GetDecodedQrBarcode> A;
        private Provider<UserRepository> ApiStatus$AvailableSince;
        private Provider<GetKycLevel> AppCompatEmojiTextHelper;
        private Provider<GetCashierNativeConfig> B;
        private Provider<GetAuthCode> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckDeepLinkActionVisibility> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetDecodeTciCoListConfig> C;
        private Provider<GetFavoriteServiceRemote> D;
        private Provider<PushVerifyTracker> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DynamicUrlWrapper> DatabaseTableConfigUtil;
        private Provider<GetEmptyUserInfo> E;
        private Provider<GetFeedConfig> F;
        private final OnlineMerchantListViewComponentImpl FillAnimation;
        private Provider<Activity> FlowViewUtil$textChanges$1;
        private Provider<PayerModelListMapper> FlowViewUtil$textChanges$2;
        private Provider<ScanResultMapper> FlowableCreate$BufferAsyncEmitter;
        private Provider<ServicesPresenter> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePushVerify> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetIsCardBindingV2Enabled> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetFavoriteServices> H;
        private Provider<GetMerchantQrWhitelist> I;
        private Provider<GetNickname> J;
        private Provider<ShortenerRepository> JsonParseException;
        private Provider<GetPayerSplitBillDetail> K;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetPromoCenterVersion> L;
        private Provider<GetMissionDetail> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetQrBindingConfig> N;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetReferralConsult> O;
        private Provider<ServiceCategoryMapper> OtpRegistrationPresenter$input$1;
        private Provider<ReadLinkPropertiesContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetRequestMoneyInfoFeature> P;
        private Provider<Application> PlaceComponentResult;
        private Provider<FeatureCardBinding> PrepareContext;
        private Provider<GetQrisCpmSendmoneyConfig> Q;
        private Provider<IsNeedToShowToolTip> QrExpiredActivity;
        private Provider<GetService> R;
        private Provider<RestoreUrlView> RequestMoneyQrContract$View;
        private Provider<GetServicesWithCategory> S;
        private Provider<ScanQrContract.View> SizeSelectors$OrSelector;
        private Provider<GenerateLinkRepository> SubSequence;
        private Provider<GetRawServices> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetServiceHighlighted> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByKey> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetSettingByKey> T;
        private Provider<OauthRepository> TypeProjectionImpl;
        private Provider<RestoreUrlPresenter> TypefaceCompatApi26Impl;
        private Provider<GetSplitBillConfig> U;
        private Provider<GetUpdateAvailability> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDecodedQrisTopUp> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetUserInfoWithKyc> W;
        private Provider<GetUserId> X;
        private Provider<IsNativeDecodeEnabled> Y;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> Z;

        /* renamed from: a */
        private Provider<MyReferralConsultRepository> f8148a;
        private Provider<UserConsentRepository> access$getCapacity$p;
        private Provider<FeedsConfigRepository> access$throwIllegalArgumentType;
        private Provider<MixpanelDeeplinkTracker> b;
        private Provider<LiteAccountRepository> c;
        private Provider<ThreadExecutor> checkRegisteredUserAndSendOtp;
        private Provider<ProductPageManager> connectForeground;
        private Provider<MyReferralConsultMapper> d;
        private Provider<OauthPresenter> e;
        private final OnlineMerchantAnalyticModule f;
        private Provider<GetUserStatusInfo> flip;
        private Provider<OauthView> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<FeatureView> getCallingPid;
        private Provider<ScanQrView> getCardNumberOCR;
        private Provider<SplitBillRepository> getContainerAuth;
        private Provider<SplitBillHistoryToSplitBillModelMapper> getDefaultSenderId;
        private Provider<CheckWhitelistedValidDomain> getErrorConfigVersion;
        private Provider<UserEducationRepository> getIndexName;
        private Provider<GetNearbyConfig> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<GenerateReferralDeepLink> getSupportButtonTintMode;
        private Provider<GetFavoriteServiceWithCacheFirst> getValueOfTouchPositionAbsolute;
        private Provider<PromoQuestRepository> h;
        private Provider<PostExecutionThread> i;
        private Provider<ScanQrPresenter> initAnimators;
        private Provider<DeepLinkPayloadModelMapper> initRecordTimeStamp;
        private Provider<GetServicesByName> isAuth;
        private Provider<GetWhitelistedSubMerchantId> isAuto;
        private Provider<FeatureFamilyAccount> isLayoutRequested;
        private Provider<ScanQrContract.Presenter> j;
        private Provider<CardBindingRepository> k;
        private Provider<FamilyAccountRepository> l;
        private Provider<Context> lookAheadTest;
        private Provider<PaylaterRepository> m;
        private Provider<CheckShowReferralCodeFeature> moveToNextValue;
        private Provider<RestoreUrlContract.Presenter> n;
        private Provider<FeaturePresenter> newProxyInstance;

        /* renamed from: o */
        private Provider<OauthContract.Presenter> f8149o;
        private Provider<SettingRepository> onDecodeSuccess;
        private Provider<FeatureContract.Presenter> p;
        private Provider<ServicesContract.View> q;
        private Provider<RestoreUrlContract.View> r;
        private Provider<FeatureSplitBill> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<UpdateServiceHighlighted> f5874reduceIndexedz1zDJgo;
        private Provider<ValidateNativelyDecodedQr> retainOrRemoveAllInternal;
        private Provider<OauthContract.View> s;
        private Provider<CheckFavoriteServicesFeature> scheduleImpl;
        private Provider<ThirdPartyServicesMapper> secondaryHash;
        private Provider<SaveShowToolTip> setNetAuthId;
        private Provider<GetUserLoanInfo> shouldRecycleViewType;
        private Provider<FeatureContract.View> t;
        private Provider<QrBarcodeRepository> u;
        private Provider<ReadLinkPropertiesPresenter> v;
        private Provider<ServicesRepository> verifyNotNull;
        private Provider<ReadDeepLinkProperties> w;
        private Provider<FeatureSplitBillPay> whenAvailable;
        private Provider<DeepLinkContract.View> x;
        private Provider<RestoreUrl> y;
        private Provider<SaveShowDialog> z;

        public /* synthetic */ OnlineMerchantListViewComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, onlineMerchantAnalyticModule, applicationComponent);
        }

        private OnlineMerchantListViewComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.FillAnimation = this;
            this.f = onlineMerchantAnalyticModule;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.lookAheadTest = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.FlowViewUtil$textChanges$1 = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.getCardNumberOCR = authRequestContext2;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.u = qrBarcodeRepositoryProvider;
            this.A = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.checkRegisteredUserAndSendOtp = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.i = postExecutionThreadProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDecodedQrisTopUp_Factory.create(this.checkRegisteredUserAndSendOtp, postExecutionThreadProvider, this.u);
            this.FlowableCreate$BufferAsyncEmitter = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.ApiStatus$AvailableSince = userRepositoryProvider;
            this.flip = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = featureConfigRepositoryProvider;
            this.B = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.Y = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.C = create;
            this.retainOrRemoveAllInternal = ValidateNativelyDecodedQr_Factory.create(create);
            this.I = GetMerchantQrWhitelist_Factory.create(this.u);
            this.N = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.Z = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.m = providePaylaterRepositoryProvider;
            this.shouldRecycleViewType = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getIndexName = userEducationRepositoryProvider;
            this.Q = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, userEducationRepositoryProvider);
            this.z = SaveShowDialog_Factory.create(this.getIndexName);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.SizeSelectors$OrSelector, this.A, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.FlowableCreate$BufferAsyncEmitter, this.GetContactSyncConfig, this.flip, this.B, GetNativelyDecodedQr_Factory.create(), this.Y, this.retainOrRemoveAllInternal, this.I, this.N, this.Z, this.shouldRecycleViewType, this.Q, this.z));
            this.initAnimators = authRequestContext3;
            this.j = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.lookAheadTest));
            this.RequestMoneyQrContract$View = authRequestContext4;
            this.r = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.JsonParseException = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, shortenerRepositoryProvider);
            this.y = create2;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.r, create2));
            this.TypefaceCompatApi26Impl = authRequestContext5;
            this.n = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.f8148a = myReferralConsultRepositoryProvider;
            this.O = GetReferralConsult_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, myReferralConsultRepositoryProvider);
            this.moveToNextValue = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.d = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.SubSequence = generateLinkRepositoryProvider;
            this.getSupportButtonTintMode = GenerateReferralDeepLink_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = settingRepositoryProvider;
            this.T = GetSettingByKey_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.connectForeground = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureSettingMore_Factory.PlaceComponentResult(this.T, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getContainerAuth = splitBillRepositoryProvider;
            this.K = GetPayerSplitBillDetail_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, splitBillRepositoryProvider);
            this.FlowViewUtil$textChanges$2 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.FlowViewUtil$textChanges$2);
            this.getDefaultSenderId = PlaceComponentResult;
            this.whenAvailable = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.K, PlaceComponentResult);
            this.U = GetSplitBillConfig_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.P = create3;
            Provider<GetSplitBillConfig> provider = this.U;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.readMicros = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.h = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.M = create4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.lookAheadTest));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.lookAheadTest);
            this.b = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.l = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.DatabaseTableConfigUtil = dynamicUrlWrapperProvider;
            this.isLayoutRequested = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.k = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.G = BuiltInFictitiousFunctionClassFactory;
            this.PrepareContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.b));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.O, this.moveToNextValue, this.d, this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.whenAvailable, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda8, FeatureKyb_Factory.getAuthRequestContext(), this.isLayoutRequested, this.PrepareContext, this.shouldRecycleViewType, FeatureMyBills_Factory.PlaceComponentResult(), this.FragmentBottomSheetPaymentSettingBinding));
            this.getCallingPid = authRequestContext6;
            this.t = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.verifyNotNull = servicesRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByKey_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.lookAheadTest);
            this.OtpRegistrationPresenter$input$1 = authRequestContext7;
            this.secondaryHash = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.TypeProjectionImpl = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.E = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.TypeProjectionImpl, create5);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.t, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.secondaryHash, create6, this.GetContactSyncConfig));
            this.BuiltInFictitiousFunctionClassFactory = CheckDeepLinkActionVisibility_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getErrorConfigVersion = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getNameOrBuilderList = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideFeedsConfigRepositoryProvider;
            this.F = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.L = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.V = GetUpdateAvailability_Factory.create(this.lookAheadTest);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.verifyNotNull);
            this.R = create7;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.t, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion, this.getNameOrBuilderList, this.F, this.L, this.V, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, create7));
            this.newProxyInstance = authRequestContext8;
            this.p = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.g = authRequestContext9;
            this.s = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.W = GetUserInfoWithKyc_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.ApiStatus$AvailableSince);
            this.J = GetNickname_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.isAuto = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<OauthContract.View> provider2 = this.s;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.AppCompatEmojiTextHelper, this.W, this.J, this.isAuto, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.e = KClassImpl$Data$declaredNonStaticMembers$2;
            this.f8149o = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.q = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.QrExpiredActivity = IsNeedToShowToolTip_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.getIndexName);
            this.setNetAuthId = SaveShowToolTip_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.getIndexName);
            this.S = GetServicesWithCategory_Factory.create(this.verifyNotNull);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.verifyNotNull);
            this.D = GetFavoriteServiceRemote_Factory.create(this.verifyNotNull);
            this.isAuth = GetServicesByName_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.verifyNotNull);
            this.H = GetFavoriteServices_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, this.verifyNotNull);
            this.scheduleImpl = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetRawServices_Factory.create(this.verifyNotNull);
            this.getValueOfTouchPositionAbsolute = GetFavoriteServiceWithCacheFirst_Factory.create(this.verifyNotNull);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetServiceHighlighted_Factory.create(this.verifyNotNull);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.verifyNotNull);
            this.f5874reduceIndexedz1zDJgo = create8;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.lookAheadTest, this.q, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.secondaryHash, this.QrExpiredActivity, this.setNetAuthId, this.S, this.getOnBoardingScenario, this.D, this.isAuth, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.H, this.scheduleImpl, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.getValueOfTouchPositionAbsolute, this.SummaryVoucherView$$ExternalSyntheticLambda1, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.PlaceComponentResult = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.j, this.n, this.p, this.f8149o, this.FlowableReduce$ReduceSubscriber, applicationProvider, this.shouldRecycleViewType));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext10;
            this.x = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.w = ReadDeepLinkProperties_Factory.create(this.checkRegisteredUserAndSendOtp, this.i);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.initRecordTimeStamp = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.c = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.checkRegisteredUserAndSendOtp, this.i, liteAccountRepositoryProvider);
            this.X = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.x, this.w, this.initRecordTimeStamp, create9, this.b));
            this.v = authRequestContext11;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
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

        /* loaded from: classes4.dex */
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
            private final ApplicationComponent getAuthRequestContext;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isInfoWindowShown());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.QrExpiredActivity());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.k());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.z());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.WithdrawSavedCardChannelView());
            }
        }

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

        @Override // id.dana.di.component.OnlineMerchantListViewComponent
        public final void getAuthRequestContext(OnlineMerchantListView onlineMerchantListView) {
            onlineMerchantListView.readLinkPropertiesPresenter = this.OtpRegistrationPresenter$input$2.get();
            OnlineMerchantListView_MembersInjector.BuiltInFictitiousFunctionClassFactory(onlineMerchantListView, OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory.PlaceComponentResult(this.f, (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }
    }
}
