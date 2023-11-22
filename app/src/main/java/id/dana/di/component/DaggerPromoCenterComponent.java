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
import id.dana.contract.promocenter.promo.PromoCenterPresenter;
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
import id.dana.di.modules.PromoCenterModule;
import id.dana.di.modules.PromoCenterModule_ProvidePromoCenterPresenterFactory;
import id.dana.di.modules.PromoCenterModule_ProvidePromoViewFactory;
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
import id.dana.domain.promocenter.interactor.GetPromoAds;
import id.dana.domain.promocenter.interactor.GetPromoAdsConfigFeature;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
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
import id.dana.promocenter.mapper.PromoAdsModelMapper;
import id.dana.promocenter.mapper.PromoCategoryModelMapper;
import id.dana.promocenter.views.PromoCenterActivity;
import id.dana.promocenter.views.PromoCenterActivity_MembersInjector;
import id.dana.promodiscovery.views.PromoDiscoveryListActivity;
import id.dana.promodiscovery.views.PromoDiscoveryListActivity_MembersInjector;
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
public final class DaggerPromoCenterComponent {
    private DaggerPromoCenterComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public PromoCenterModule KClassImpl$Data$declaredNonStaticMembers$2;
        public OauthModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public ScanQrModule lookAheadTest;
        public ServicesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final PromoCenterComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, PromoCenterModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, OauthModule.class);
            if (this.scheduleImpl == null) {
                this.scheduleImpl = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new PromoCenterComponentImpl(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.getErrorConfigVersion, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.scheduleImpl, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class PromoCenterComponentImpl implements PromoCenterComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<SplitBillHistoryToSplitBillModelMapper> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServices> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GetDecodeTciCoListConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckDeepLinkActionVisibility> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAddingNameWhitelistedMerchantId> C;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<ScanQrContract.Presenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkPayloadModelMapper> DatabaseTableConfigUtil;
        private Provider<GetFavoriteServiceRemote> E;
        private Provider<GetIsCardBindingV2Enabled> F;
        private Provider<OauthRepository> FillAnimation;
        private final PromoCenterModule FlowViewUtil$textChanges$1;
        private Provider<PostExecutionThread> FlowViewUtil$textChanges$2;
        private Provider<SaveShowDialog> FlowableCreate$BufferAsyncEmitter;
        private Provider<SaveShowToolTip> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFeedConfig> G;
        private Provider<DeepLinkView> GetContactSyncConfig;
        private Provider<GetFavoriteServiceWithCacheFirst> H;
        private Provider<GetKycLevel> I;
        private Provider<UserConsentRepository> InitSecurePreferenceAccount;
        private Provider<GetNearbyConfig> J;
        private Provider<ServiceCategoryMapper> JsonParseException;
        private Provider<GetNickname> K;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMissionDetail> L;
        private Provider<GetPayerSplitBillDetail> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetReferralConsult> N;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetQrBindingConfig> O;
        private Provider<ScanQrView> OtpRegistrationPresenter$input$1;
        private Provider<RestoreUrlContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetPromoCenterVersion> P;
        private Provider<CheckConsultFamilyAccount> PlaceComponentResult;
        private Provider<FeatureConfigRepository> PrepareContext;
        private Provider<ValidateNativelyDecodedQr> PromoCategoryPresenter$1;
        private Provider<GetQrisCpmSendmoneyConfig> Q;
        private Provider<IsNeedToShowToolTip> QrExpiredActivity;
        private Provider<GetServicesByKey> R;
        private Provider<UserRepository> ReferralMapper_Factory;
        private Provider<ReadLinkPropertiesPresenter> RequestMoneyQrContract$View;
        private Provider<GetServiceHighlighted> S;
        private Provider<ScanQrContract.View> SizeSelectors$OrSelector;
        private Provider<FeatureView> SubSequence;
        private Provider<GetRawServices> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetRequestMoneyInfoFeature> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetService> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetSettingByKey> T;
        private Provider<MyReferralConsultRepository> TypeProjectionImpl;
        private Provider<DeepLinkContract.View> TypefaceCompatApi26Impl;
        private Provider<GetUserId> U;
        private Provider<GetServicesWithCategory> V;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetSplitBillConfig> W;
        private Provider<GetUpdateAvailability> X;
        private Provider<GetUserStatusInfo> Y;
        private Provider<GetWhitelistedSubMerchantId> Z;

        /* renamed from: a */
        private Provider<IsOfflineF2FPay> f8151a;
        private Provider<ThreadExecutor> access$getCapacity$p;
        private Provider<FamilyAccountRepository> access$throwIllegalArgumentType;
        private Provider<MixpanelDeeplinkTracker> b;
        private Provider<LiteAccountRepository> c;
        private Provider<SplitBillRepository> checkRegisteredUserAndSendOtp;
        private Provider<ProductPageManager> connectForeground;
        private Provider<IsNativeDecodeEnabled> d;
        private Provider<OauthPresenter> e;
        private Provider<MyReferralConsultMapper> f;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> flip;
        private Provider<OauthView> g;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<ScanResultMapper> getCardNumberOCR;
        private Provider<SettingRepository> getContainerAuth;
        private Provider<ServicesRepository> getDefaultSenderId;
        private Provider<CheckMyBillsVersionConfig> getErrorConfigVersion;
        private Provider<ThirdPartyServicesMapper> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private final PromoCenterComponentImpl h;
        private Provider<PayerModelListMapper> i;
        private Provider<RestoreUrlPresenter> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<GetServicesByName> isAuth;
        private Provider<GetUserInfoWithKyc> isAuto;
        private Provider<DynamicUrlWrapper> isLayoutRequested;
        private Provider<FeedsConfigRepository> j;
        private Provider<PromoQuestRepository> k;
        private Provider<Activity> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<CardBindingRepository> m;
        private Provider<CheckFavoriteServicesFeature> moveToNextValue;
        private Provider<PaylaterRepository> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<FeatureContract.Presenter> f8152o;
        private Provider<ServicesPresenter> onDecodeSuccess;
        private Provider<OauthContract.Presenter> p;
        private Provider<FeatureContract.View> q;
        private Provider<ReadLinkPropertiesContract.Presenter> r;
        private Provider<FeatureSplitBillPay> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<UpdateServiceHighlighted> f5875reduceIndexedz1zDJgo;
        private Provider<UserEducationRepository> retainOrRemoveAllInternal;
        private Provider<PushVerifyTracker> s;
        private Provider<ConnectionStatusReceiver> scheduleImpl;
        private Provider<ShortenerRepository> secondaryHash;
        private Provider<RestoreUrlView> setNetAuthId;
        private Provider<GetUserLoanInfo> shouldRecycleViewType;
        private Provider<RestoreUrlContract.View> t;
        private Provider<ReadDeepLinkProperties> u;
        private Provider<QrBarcodeRepository> v;
        private Provider<ScanQrPresenter> verifyNotNull;
        private Provider<ServicesContract.View> w;
        private Provider<FeatureSettingMore> whenAvailable;
        private Provider<OauthContract.View> x;
        private Provider<SSLPinningRepository> y;
        private Provider<RestoreUrl> z;

        /* synthetic */ PromoCenterComponentImpl(PromoCenterModule promoCenterModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(promoCenterModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private PromoCenterComponentImpl(PromoCenterModule promoCenterModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.h = this;
            this.getAuthRequestContext = applicationComponent;
            this.FlowViewUtil$textChanges$1 = promoCenterModule;
            this.access$getCapacity$p = new ThreadExecutorProvider(applicationComponent);
            this.y = new SSLPinningRepositoryProvider(applicationComponent);
            this.FlowViewUtil$textChanges$2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PrepareContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, featureConfigRepositoryProvider);
            this.f8151a = create;
            this.scheduleImpl = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.access$getCapacity$p, this.y, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.l = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.OtpRegistrationPresenter$input$1 = authRequestContext2;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.v = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.v);
            this.getCardNumberOCR = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = userRepositoryProvider;
            this.Y = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetCashierNativeConfig_Factory.create(this.PrepareContext);
            this.d = IsNativeDecodeEnabled_Factory.create(this.PrepareContext);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.PrepareContext);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create2;
            this.PromoCategoryPresenter$1 = ValidateNativelyDecodedQr_Factory.create(create2);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.v);
            this.O = GetQrBindingConfig_Factory.create(this.PrepareContext);
            this.flip = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.PrepareContext);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.n = providePaylaterRepositoryProvider;
            this.shouldRecycleViewType = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = userEducationRepositoryProvider;
            this.Q = GetQrisCpmSendmoneyConfig_Factory.create(this.PrepareContext, userEducationRepositoryProvider);
            this.FlowableCreate$BufferAsyncEmitter = SaveShowDialog_Factory.create(this.retainOrRemoveAllInternal);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.SizeSelectors$OrSelector, this.getValueOfTouchPositionAbsolute, this.D, this.getCardNumberOCR, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.Y, this.VerifyPinStateManager$executeRiskChallenge$2$1, GetNativelyDecodedQr_Factory.create(), this.d, this.PromoCategoryPresenter$1, this.getNameOrBuilderList, this.O, this.flip, this.shouldRecycleViewType, this.Q, this.FlowableCreate$BufferAsyncEmitter));
            this.verifyNotNull = authRequestContext3;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.setNetAuthId = authRequestContext4;
            this.t = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.secondaryHash = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, shortenerRepositoryProvider);
            this.z = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.t, create3));
            this.initAnimators = authRequestContext5;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.TypeProjectionImpl = myReferralConsultRepositoryProvider;
            this.N = GetReferralConsult_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.PrepareContext);
            this.f = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getCallingPid = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getContainerAuth = settingRepositoryProvider;
            this.T = GetSettingByKey_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.connectForeground = productPageManagerProvider;
            this.whenAvailable = FeatureSettingMore_Factory.PlaceComponentResult(this.T, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.checkRegisteredUserAndSendOtp = splitBillRepositoryProvider;
            this.M = GetPayerSplitBillDetail_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, splitBillRepositoryProvider);
            this.i = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.i);
            this.ApiStatus$AvailableSince = PlaceComponentResult;
            this.readMicros = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.M, PlaceComponentResult);
            this.W = GetSplitBillConfig_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.PrepareContext);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.PrepareContext);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = create4;
            Provider<GetSplitBillConfig> provider = this.W;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.k = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.L = create5;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.b = MyBillsEntityDataFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideFamilyAccountRepositoryProvider;
            this.PlaceComponentResult = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.isLayoutRequested = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.m = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.F = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.b));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.N, this.lookAheadTest, this.f, this.A, this.whenAvailable, this.readMicros, this.getSupportButtonTintMode, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.shouldRecycleViewType, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda4));
            this.SubSequence = authRequestContext6;
            this.q = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = servicesRepositoryProvider;
            this.R = GetServicesByKey_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.JsonParseException = authRequestContext7;
            this.getIndexName = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.FillAnimation = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.InitSecurePreferenceAccount = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.FillAnimation, create6);
            this.B = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.q, this.R, this.getIndexName, create7, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            this.BuiltInFictitiousFunctionClassFactory = CheckDeepLinkActionVisibility_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckWhitelistedValidDomain_Factory.create(this.PrepareContext);
            this.J = GetNearbyConfig_Factory.create(this.PrepareContext);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.j = provideFeedsConfigRepositoryProvider;
            this.G = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.P = GetPromoCenterVersion_Factory.create(this.PrepareContext);
            this.X = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion = CheckMyBillsVersionConfig_Factory.create(this.PrepareContext);
            this.s = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.getDefaultSenderId);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.q, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.J, this.G, this.P, this.X, this.getErrorConfigVersion, this.s, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext8;
            this.f8152o = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.g = authRequestContext9;
            this.x = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            this.I = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.isAuto = GetUserInfoWithKyc_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.ReferralMapper_Factory);
            this.K = GetNickname_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.Z = GetWhitelistedSubMerchantId_Factory.create(this.PrepareContext);
            this.C = GetAddingNameWhitelistedMerchantId_Factory.create(this.PrepareContext);
            Provider<OauthContract.View> provider2 = this.x;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.I, this.isAuto, this.K, this.Z, this.C);
            this.e = KClassImpl$Data$declaredNonStaticMembers$2;
            this.p = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.w = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.QrExpiredActivity = IsNeedToShowToolTip_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.retainOrRemoveAllInternal);
            this.FlowableReduce$ReduceSubscriber = SaveShowToolTip_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.retainOrRemoveAllInternal);
            this.V = GetServicesWithCategory_Factory.create(this.getDefaultSenderId);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.getDefaultSenderId);
            this.E = GetFavoriteServiceRemote_Factory.create(this.getDefaultSenderId);
            this.isAuth = GetServicesByName_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.getDefaultSenderId);
            this.AppCompatEmojiTextHelper = GetFavoriteServices_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.getDefaultSenderId);
            this.moveToNextValue = CheckFavoriteServicesFeature_Factory.create(this.PrepareContext);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetRawServices_Factory.create(this.getDefaultSenderId);
            this.H = GetFavoriteServiceWithCacheFirst_Factory.create(this.getDefaultSenderId);
            this.S = GetServiceHighlighted_Factory.create(this.getDefaultSenderId);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.getDefaultSenderId);
            this.f5875reduceIndexedz1zDJgo = create9;
            this.onDecodeSuccess = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.w, this.B, this.getIndexName, this.QrExpiredActivity, this.FlowableReduce$ReduceSubscriber, this.V, this.getOnBoardingScenario, this.E, this.isAuth, this.R, this.AppCompatEmojiTextHelper, this.moveToNextValue, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.H, this.S, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.OtpRegistrationPresenter$input$2, this.f8152o, this.p, this.onDecodeSuccess, applicationProvider, this.shouldRecycleViewType));
            this.GetContactSyncConfig = authRequestContext10;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.u = ReadDeepLinkProperties_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.c = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, liteAccountRepositoryProvider);
            this.U = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.TypefaceCompatApi26Impl, this.u, this.DatabaseTableConfigUtil, create10, this.b));
            this.RequestMoneyQrContract$View = authRequestContext11;
            this.r = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
        }

        private PromoCenterPresenter PlaceComponentResult() {
            return new PromoCenterPresenter(PromoCenterModule_ProvidePromoViewFactory.getAuthRequestContext(this.FlowViewUtil$textChanges$1), new PromoCategoryModelMapper(new PromoAdsModelMapper()), new PromoAdsModelMapper(), new GetPromoCategorizedList((PromoCenterRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.d())), new GetPromoList((PromoCenterRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.d())), new GetPromoAdsConfigFeature((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetPromoAds((PromoCenterRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.d()), (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto())));
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
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
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

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
            private final ApplicationComponent getAuthRequestContext;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.setNetAuthId());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.P());
            }
        }

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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.shouldRecycleViewType());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ConcurrentKt());
            }
        }

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

        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent getAuthRequestContext;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PrepareContext());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
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
            private final ApplicationComponent getAuthRequestContext;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowableCreate$BufferAsyncEmitter());
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
            private final ApplicationComponent getAuthRequestContext;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.PromoCenterComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterActivity promoCenterActivity) {
            ((BaseActivity) promoCenterActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(promoCenterActivity, DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(promoCenterActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            promoCenterActivity.promoCenterPresenter = PromoCenterModule_ProvidePromoCenterPresenterFactory.getAuthRequestContext(this.FlowViewUtil$textChanges$1, PlaceComponentResult());
            PromoCenterActivity_MembersInjector.MyBillsEntityDataFactory(promoCenterActivity, this.r.get());
        }

        @Override // id.dana.di.component.PromoCenterComponent
        public final void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryListActivity promoDiscoveryListActivity) {
            ((BaseActivity) promoDiscoveryListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(promoDiscoveryListActivity, DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(promoDiscoveryListActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            PromoDiscoveryListActivity_MembersInjector.getAuthRequestContext(promoDiscoveryListActivity, PromoCenterModule_ProvidePromoCenterPresenterFactory.getAuthRequestContext(this.FlowViewUtil$textChanges$1, PlaceComponentResult()));
            PromoDiscoveryListActivity_MembersInjector.getAuthRequestContext(promoDiscoveryListActivity, this.r.get());
        }
    }
}
