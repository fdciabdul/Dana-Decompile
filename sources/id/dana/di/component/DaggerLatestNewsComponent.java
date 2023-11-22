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
import id.dana.di.modules.LatestNewsModule;
import id.dana.di.modules.LatestNewsModule_ProvidePresenterFactory;
import id.dana.di.modules.LatestNewsModule_ProvideViewFactory;
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
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.interactor.GetGlobalFeeds_Factory;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig_Factory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence_Factory;
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
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.news.LatestNewsContract;
import id.dana.news.LatestNewsFragment;
import id.dana.news.LatestNewsFragment_MembersInjector;
import id.dana.news.presenter.LatestNewsPresenter;
import id.dana.news.presenter.LatestNewsPresenter_Factory;
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
public final class DaggerLatestNewsComponent {
    private DaggerLatestNewsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public LatestNewsModule KClassImpl$Data$declaredNonStaticMembers$2;
        public DeepLinkModule MyBillsEntityDataFactory;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public FeatureModule PlaceComponentResult;
        public OauthModule getAuthRequestContext;
        public ScanQrModule getErrorConfigVersion;
        public RestoreUrlModule lookAheadTest;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class LatestNewsComponentImpl implements LatestNewsComponent {
        private Provider<GetDecodeTciCoListConfig> A;
        private Provider<ShortenerRepository> ApiStatus$AvailableSince;
        private Provider<GetIsCardBindingV2Enabled> AppCompatEmojiTextHelper;
        private Provider<GetDecodedQrBarcode> B;
        private Provider<GetAuthCode> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetCashierNativeConfig> C;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<LatestNewsContract.Presenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeviceInformationProvider> DatabaseTableConfigUtil;
        private Provider<GetDefaultServiceWithCategory> E;
        private Provider<GetGlobalFeeds> F;
        private Provider<MyReferralConsultRepository> FillAnimation;
        private Provider<OauthView> FlowViewUtil$textChanges$1;
        private Provider<ProductPageManager> FlowViewUtil$textChanges$2;
        private Provider<SaveShowToolTip> FlowableCreate$BufferAsyncEmitter;
        private Provider<RestoreUrl> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePushVerify> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServices> G;
        private Provider<DeepLinkView> GetContactSyncConfig;
        private Provider<GetFeedConfig> H;
        private Provider<GetFavoriteServiceWithCacheFirst> I;
        private Provider<UpdateServiceHighlighted> InitSecurePreferenceAccount;
        private Provider<GetMissionDetail> J;
        private Provider<ServiceCategoryMapper> JsonParseException;
        private Provider<GetNearbyConfig> K;
        private Provider<CheckConsultFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetNickname> L;
        private Provider<GetKycLevel> M;
        private Provider<CheckDeepLinkActionVisibility> MyBillsEntityDataFactory;
        private Provider<GetRawServices> N;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureSplitBillPay> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ValidateNativelyDecodedQr> NewMerchantCategoryAdapter;
        private Provider<GetPromoCenterVersion> O;
        private Provider<RestoreUrlView> OtpRegistrationPresenter$input$1;
        private Provider<CardBindingRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetQrBindingConfig> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<FeatureOauth> PrepareContext;
        private Provider<ThirdPartyServicesMapper> PromoCategoryPresenter$1;
        private Provider<GetPayerSplitBillDetail> Q;
        private final LatestNewsComponentImpl QrExpiredActivity;
        private Provider<GetReferralConsult> R;
        private Provider<ThreadExecutor> ReferralMapper_Factory;
        private Provider<QrBarcodeRepository> RequestMoneyQrContract$View;
        private Provider<GetRequestMoneyInfoFeature> S;
        private Provider<UserConsentRepository> SendMoneyScenario;
        private Provider<ReadLinkPropertiesContract.Presenter> SizeSelectors$OrSelector;
        private Provider<FeedsRepository> SubSequence;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetService> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByKey> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetSplitBillConfig> T;
        private Provider<OauthPresenter> TypeProjectionImpl;
        private Provider<FeatureContract.View> TypefaceCompatApi26Impl;
        private Provider<GetSettingByKey> U;
        private Provider<GetUpdateAvailability> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetFavoriteServiceRemote> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesByName> W;
        private Provider<GetServicesWithCategory> X;
        private Provider<GetWhitelistedSubMerchantId> Y;
        private Provider<GetUserId> Z;

        /* renamed from: a */
        private Provider<IsNativeDecodeEnabled> f8124a;
        private Provider<ServicesRepository> access$getCapacity$p;
        private Provider<Activity> access$throwIllegalArgumentType;
        private Provider<IsNeedToShowToolTip> b;
        private Provider<LatestNewsPresenter> c;
        private Provider<SplitBillHistoryToSplitBillModelMapper> checkRegisteredUserAndSendOtp;
        private Provider<PostExecutionThread> connectForeground;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> d;
        private Provider<MixpanelDeeplinkTracker> e;
        private Provider<MyReferralConsultMapper> f;
        private Provider<GetUserLoanInfo> flip;
        private Provider<LiteAccountRepository> g;
        private Provider<CheckFavoriteServicesFeature> getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<SaveNewsWidgetActivitiesIntoPersistence> getCardNumberOCR;
        private Provider<ScanQrView> getContainerAuth;
        private Provider<ServicesPresenter> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<SplitBillRepository> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetEmptyUserInfo> getOnBoardingScenario;
        private Provider<UserRepository> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetDefaultFeedFromConfig> getValueOfTouchPositionAbsolute;
        private Provider<PayerModelListMapper> h;
        private Provider<OauthRepository> i;
        private Provider<DeepLinkContract.View> initAnimators;
        private Provider<FeatureCardBinding> initRecordTimeStamp;
        private Provider<GetServiceHighlighted> isAuth;
        private Provider<GetUserStatusInfo> isAuto;
        private Provider<FeaturePresenter> isLayoutRequested;
        private Provider<PromoQuestRepository> j;
        private Provider<FeedsConfigRepository> k;
        private Provider<HomeWidgetRepository> l;
        private Provider<DanaCustomH5> lookAheadTest;
        private Provider<FamilyAccountRepository> m;
        private Provider<CheckWhitelistedValidDomain> moveToNextValue;
        private Provider<RestoreUrlContract.Presenter> n;
        private Provider<FeaturePromoQuest> newProxyInstance;

        /* renamed from: o */
        private Provider<ScanQrContract.Presenter> f8125o;
        private Provider<ScanResultMapper> onDecodeSuccess;
        private Provider<PaylaterRepository> p;
        private Provider<LatestNewsContract.View> q;
        private Provider<OauthContract.Presenter> r;
        private Provider<GenerateReferralDeepLink> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<SettingRepository> f5853reduceIndexedz1zDJgo;
        private Provider<UserEducationRepository> retainOrRemoveAllInternal;
        private Provider<PushVerifyTracker> s;
        private Provider<CheckShowReferralCodeFeature> scheduleImpl;
        private Provider<ScanQrPresenter> secondaryHash;
        private Provider<ReadDeepLinkProperties> setNetAuthId;
        private Provider<GetUserInfoWithKyc> shouldRecycleViewType;
        private Provider<FeatureContract.Presenter> t;
        private Provider<ScanQrContract.View> u;
        private Provider<OauthContract.View> v;
        private Provider<SaveShowDialog> verifyNotNull;
        private Provider<ServicesContract.View> w;
        private Provider<FeatureView> whenAvailable;
        private Provider<RestoreUrlContract.View> x;
        private Provider<ReadLinkPropertiesPresenter> y;
        private Provider<RestoreUrlPresenter> z;

        public /* synthetic */ LatestNewsComponentImpl(LatestNewsModule latestNewsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(latestNewsModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private LatestNewsComponentImpl(LatestNewsModule latestNewsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.QrExpiredActivity = this;
            this.q = DoubleCheck.getAuthRequestContext(LatestNewsModule_ProvideViewFactory.getAuthRequestContext(latestNewsModule));
            this.ReferralMapper_Factory = new ThreadExecutorProvider(applicationComponent);
            this.connectForeground = new PostExecutionThreadProvider(applicationComponent);
            FeedsRepositoryProvider feedsRepositoryProvider = new FeedsRepositoryProvider(applicationComponent);
            this.SubSequence = feedsRepositoryProvider;
            this.F = GetGlobalFeeds_Factory.create(this.ReferralMapper_Factory, this.connectForeground, feedsRepositoryProvider);
            this.getValueOfTouchPositionAbsolute = GetDefaultFeedFromConfig_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.SubSequence);
            ProvideHomeWidgetRepositoryProvider provideHomeWidgetRepositoryProvider = new ProvideHomeWidgetRepositoryProvider(applicationComponent);
            this.l = provideHomeWidgetRepositoryProvider;
            this.getCardNumberOCR = SaveNewsWidgetActivitiesIntoPersistence_Factory.create(provideHomeWidgetRepositoryProvider);
            Provider<LatestNewsContract.View> provider = this.q;
            Provider<GetGlobalFeeds> provider2 = this.F;
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            Provider<LatestNewsPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(LatestNewsPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider, provider2, feedsModelMapper_Factory, this.getValueOfTouchPositionAbsolute, this.getCardNumberOCR));
            this.c = authRequestContext;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = DoubleCheck.getAuthRequestContext(LatestNewsModule_ProvidePresenterFactory.getAuthRequestContext(latestNewsModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.access$throwIllegalArgumentType = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.getContainerAuth = authRequestContext3;
            this.u = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.RequestMoneyQrContract$View = qrBarcodeRepositoryProvider;
            this.B = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.RequestMoneyQrContract$View);
            this.onDecodeSuccess = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.DatabaseTableConfigUtil = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.getReadyFragment = userRepositoryProvider;
            this.isAuto = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = featureConfigRepositoryProvider;
            this.C = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.f8124a = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.A = create;
            this.NewMerchantCategoryAdapter = ValidateNativelyDecodedQr_Factory.create(create);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.RequestMoneyQrContract$View);
            this.P = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.d = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.p = providePaylaterRepositoryProvider;
            this.flip = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, userEducationRepositoryProvider);
            this.verifyNotNull = SaveShowDialog_Factory.create(this.retainOrRemoveAllInternal);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.u, this.B, this.D, this.onDecodeSuccess, this.DatabaseTableConfigUtil, this.isAuto, this.C, GetNativelyDecodedQr_Factory.create(), this.f8124a, this.NewMerchantCategoryAdapter, this.getNameOrBuilderList, this.P, this.d, this.flip, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.verifyNotNull));
            this.secondaryHash = authRequestContext4;
            this.f8125o = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            Provider<RestoreUrlView> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            this.OtpRegistrationPresenter$input$1 = authRequestContext5;
            this.x = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.ApiStatus$AvailableSince = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.ReferralMapper_Factory, this.connectForeground, shortenerRepositoryProvider);
            this.FlowableReduce$ReduceSubscriber = create2;
            Provider<RestoreUrlPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.x, create2));
            this.z = authRequestContext6;
            this.n = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.FillAnimation = myReferralConsultRepositoryProvider;
            this.R = GetReferralConsult_Factory.create(this.ReferralMapper_Factory, this.connectForeground, myReferralConsultRepositoryProvider);
            this.scheduleImpl = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.f = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getCallingPid = generateLinkRepositoryProvider;
            this.readMicros = GenerateReferralDeepLink_Factory.create(this.ReferralMapper_Factory, this.connectForeground, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.f5853reduceIndexedz1zDJgo = settingRepositoryProvider;
            this.U = GetSettingByKey_Factory.create(this.ReferralMapper_Factory, this.connectForeground, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.FlowViewUtil$textChanges$2 = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeatureSettingMore_Factory.PlaceComponentResult(this.U, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.getIndexName = splitBillRepositoryProvider;
            this.Q = GetPayerSplitBillDetail_Factory.create(this.ReferralMapper_Factory, this.connectForeground, splitBillRepositoryProvider);
            this.h = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.h);
            this.checkRegisteredUserAndSendOtp = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.Q, PlaceComponentResult);
            this.T = GetSplitBillConfig_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.S = create3;
            Provider<GetSplitBillConfig> provider3 = this.T;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider3, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.j = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.J = create4;
            this.newProxyInstance = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.e = MyBillsEntityDataFactory;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.m = provideFamilyAccountRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.AppCompatEmojiTextHelper = BuiltInFictitiousFunctionClassFactory;
            this.initRecordTimeStamp = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.e));
            Provider<FeatureView> authRequestContext7 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.R, this.scheduleImpl, this.f, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getSupportButtonTintMode, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.lookAheadTest, FeatureHome_Factory.MyBillsEntityDataFactory(), this.PrepareContext, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.initRecordTimeStamp, this.flip, FeatureMyBills_Factory.PlaceComponentResult(), this.FragmentBottomSheetPaymentSettingBinding));
            this.whenAvailable = authRequestContext7;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext7));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = servicesRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByKey_Factory.create(this.ReferralMapper_Factory, this.connectForeground, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext8 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.JsonParseException = authRequestContext8;
            this.PromoCategoryPresenter$1 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext8);
            this.i = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.getOnBoardingScenario = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.i, create5);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.TypefaceCompatApi26Impl, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.PromoCategoryPresenter$1, create6, this.DatabaseTableConfigUtil));
            this.MyBillsEntityDataFactory = CheckDeepLinkActionVisibility_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.moveToNextValue = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.K = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.k = provideFeedsConfigRepositoryProvider;
            this.H = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.O = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.V = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.s = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.access$getCapacity$p);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create7;
            Provider<FeaturePresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.TypefaceCompatApi26Impl, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.MyBillsEntityDataFactory, this.moveToNextValue, this.K, this.H, this.O, this.V, this.getErrorConfigVersion, this.s, create7));
            this.isLayoutRequested = authRequestContext9;
            this.t = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext9));
            OauthView_Factory authRequestContext10 = OauthView_Factory.getAuthRequestContext(this.PrepareContext);
            this.FlowViewUtil$textChanges$1 = authRequestContext10;
            this.v = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext10));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.M = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.shouldRecycleViewType = GetUserInfoWithKyc_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.getReadyFragment);
            this.L = GetNickname_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.PlaceComponentResult);
            this.Y = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Provider<OauthContract.View> provider4 = this.v;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider4, oauthParamsModelMapper_Factory, this.M, this.shouldRecycleViewType, this.L, this.Y, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.TypeProjectionImpl = KClassImpl$Data$declaredNonStaticMembers$2;
            this.r = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.w = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.b = IsNeedToShowToolTip_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.retainOrRemoveAllInternal);
            this.FlowableCreate$BufferAsyncEmitter = SaveShowToolTip_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.retainOrRemoveAllInternal);
            this.X = GetServicesWithCategory_Factory.create(this.access$getCapacity$p);
            this.E = GetDefaultServiceWithCategory_Factory.create(this.access$getCapacity$p);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetFavoriteServiceRemote_Factory.create(this.access$getCapacity$p);
            this.W = GetServicesByName_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.access$getCapacity$p);
            this.G = GetFavoriteServices_Factory.create(this.ReferralMapper_Factory, this.connectForeground, this.access$getCapacity$p);
            this.getAuthRequestContext = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.N = GetRawServices_Factory.create(this.access$getCapacity$p);
            this.I = GetFavoriteServiceWithCacheFirst_Factory.create(this.access$getCapacity$p);
            this.isAuth = GetServiceHighlighted_Factory.create(this.access$getCapacity$p);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.access$getCapacity$p);
            this.InitSecurePreferenceAccount = create8;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.w, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.PromoCategoryPresenter$1, this.b, this.FlowableCreate$BufferAsyncEmitter, this.X, this.E, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.W, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.G, this.getAuthRequestContext, this.N, this.I, this.isAuth, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext11 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.f8125o, this.n, this.t, this.r, this.getDefaultSenderId, applicationProvider, this.flip));
            this.GetContactSyncConfig = authRequestContext11;
            this.initAnimators = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext11));
            this.setNetAuthId = ReadDeepLinkProperties_Factory.create(this.ReferralMapper_Factory, this.connectForeground);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.g = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.ReferralMapper_Factory, this.connectForeground, liteAccountRepositoryProvider);
            this.Z = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.initAnimators, this.setNetAuthId, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create9, this.e));
            this.y = authRequestContext12;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        public static final class FeedsRepositoryProvider implements Provider<FeedsRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeedsRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsRepository get() {
                return (FeedsRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetRepositoryProvider implements Provider<HomeWidgetRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideHomeWidgetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetRepository get() {
                return (HomeWidgetRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.q());
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
        /* loaded from: classes4.dex */
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
            private final ApplicationComponent PlaceComponentResult;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.WithdrawSavedCardChannelView());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.LatestNewsComponent
        public final void MyBillsEntityDataFactory(LatestNewsFragment latestNewsFragment) {
            LatestNewsFragment_MembersInjector.PlaceComponentResult(latestNewsFragment, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider.get());
            latestNewsFragment.readDeepLinkPropertiesPresenter = this.SizeSelectors$OrSelector.get();
        }
    }
}
