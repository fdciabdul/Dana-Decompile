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
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetModule;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetPresenter;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetPresenter_Factory;
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
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo_Factory;
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
import id.dana.globalsearch.view.GlobalSearchBottomSheetDialog;
import id.dana.globalsearch.view.GlobalSearchBottomSheetDialog_MembersInjector;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper_Factory;
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
public final class DaggerGlobalSearchBottomSheetComponent {
    private DaggerGlobalSearchBottomSheetComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OauthModule BuiltInFictitiousFunctionClassFactory;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public GlobalSearchBottomSheetModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public ServicesModule lookAheadTest;
        public RestoreUrlModule moveToNextValue;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class GlobalSearchBottomSheetComponentImpl implements GlobalSearchBottomSheetComponent {
        private Provider<GetDecodedQrisTopUp> A;
        private Provider<ThirdPartyServicesMapper> ApiStatus$AvailableSince;
        private Provider<GetKycLevel> AppCompatEmojiTextHelper;
        private Provider<GetCashierNativeConfig> B;
        private Provider<GetDecodeTciCoListConfig> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetDecodedQrBarcode> C;
        private Provider<GetEmptyUserInfo> D;
        private Provider<PaylaterRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<FeatureCardBinding> DatabaseTableConfigUtil;
        private Provider<GetDefaultServiceWithCategory> E;
        private Provider<GetFeedConfig> F;
        private Provider<OauthPresenter> FillAnimation;
        private Provider<PayerModelListMapper> FlowViewUtil$textChanges$1;
        private Provider<PostExecutionThread> FlowViewUtil$textChanges$2;
        private Provider<ScanQrView> FlowableCreate$BufferAsyncEmitter;
        private Provider<ScanQrPresenter> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureScanQR> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetMerchantInfo> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetMerchantQrWhitelist> H;
        private Provider<GetIsCardBindingV2Enabled> I;
        private Provider<ValidateNativelyDecodedQr> InitSecurePreferenceAccount;
        private Provider<GetNickname> J;
        private Provider<ServicesRepository> JsonParseException;
        private Provider<GetPayerSplitBillDetail> K;
        private Provider<CheckFavoriteServicesFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetNearbyConfig> L;
        private Provider<GetPromoCenterVersion> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetReferralConsult> N;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureSplitBillPay> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetQrisCpmSendmoneyConfig> O;
        private Provider<SaveShowDialog> OtpRegistrationPresenter$input$1;
        private Provider<RestoreUrlContract.Presenter> OtpRegistrationPresenter$input$2;
        private Provider<GetRequestMoneyInfoFeature> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<FeatureFamilyAccount> PrepareContext;
        private Provider<GetRawServices> Q;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> QrExpiredActivity;
        private Provider<GetServicesByKey> R;
        private Provider<UserConsentRepository> ReferralMapper_Factory;
        private Provider<RestoreUrlPresenter> RequestMoneyQrContract$View;
        private Provider<GetService> S;
        private Provider<UserEducationRepository> SendMoneyScenario;
        private Provider<ReadLinkPropertiesContract.Presenter> SizeSelectors$OrSelector;
        private Provider<FeatureView> SubSequence;
        private Provider<GetQrBindingConfig> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetServicesWithCategory> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetServicesByName> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetUpdateAvailability> T;
        private Provider<MyReferralConsultRepository> TypeProjectionImpl;
        private Provider<QrBarcodeRepository> TypefaceCompatApi26Impl;
        private Provider<GetUserInfoWithKyc> U;
        private Provider<GetSettingByKey> V;
        private Provider<GetAuthCode> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetFavoriteServiceRemote> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetSplitBillConfig> W;
        private Provider<GetUserId> X;
        private final GlobalSearchBottomSheetComponentImpl Y;
        private Provider<GetUserLoanInfo> Z;

        /* renamed from: a */
        private Provider<IsNeedToShowToolTip> f8110a;
        private Provider<ThreadExecutor> access$getCapacity$p;
        private Provider<FeedsConfigRepository> access$throwIllegalArgumentType;
        private Provider<IsNativeDecodeEnabled> b;
        private Provider<LiteAccountRepository> c;
        private Provider<SplitBillHistoryToSplitBillModelMapper> checkRegisteredUserAndSendOtp;
        private Provider<OauthView> connectForeground;
        private Provider<MerchantInfoRepository> d;
        private Provider<MixpanelDeeplinkTracker> e;
        private Provider<MyReferralConsultMapper> f;
        private Provider<GetWhitelistedSubMerchantId> flip;
        private Provider<OauthRepository> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<GenerateLinkRepository> getCallingPid;
        private Provider<ScanResultMapper> getCardNumberOCR;
        private Provider<SettingRepository> getContainerAuth;
        private Provider<ShortenerRepository> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<UpdateServiceHighlighted> getIndexName;
        private Provider<GetMissionDetail> getNameOrBuilderList;
        private Provider<GetFavoriteServiceWithCacheFirst> getOnBoardingScenario;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<GetFavoriteServices> getValueOfTouchPositionAbsolute;
        private Provider<ProductPageManager> h;
        private Provider<PromoQuestRepository> i;
        private Provider<RestoreUrl> initAnimators;
        private Provider<DeepLinkView> initRecordTimeStamp;
        private Provider<GetServiceHighlighted> isAuth;
        private Provider<GetUserStatusInfo> isAuto;
        private Provider<FeaturePromoQuest> isLayoutRequested;
        private Provider<GlobalSearchBottomSheetContract.View> j;
        private Provider<FamilyAccountRepository> k;
        private Provider<GlobalSearchBottomSheetContract.Presenter> l;
        private Provider<Context> lookAheadTest;
        private Provider<Activity> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<CardBindingRepository> n;
        private Provider<FeatureOauth> newProxyInstance;

        /* renamed from: o */
        private Provider<FeatureContract.Presenter> f8111o;
        private Provider<ServicesPresenter> onDecodeSuccess;
        private Provider<ScanQrContract.Presenter> p;
        private Provider<ScanQrContract.View> q;
        private Provider<PushVerifyTracker> r;
        private Provider<GenerateReferralDeepLink> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<SplitBillRepository> f5827reduceIndexedz1zDJgo;
        private Provider<UserRepository> retainOrRemoveAllInternal;
        private Provider<RestoreUrlContract.View> s;
        private Provider<DanaCustomH5> scheduleImpl;
        private Provider<ServiceCategoryMapper> secondaryHash;
        private Provider<RestoreUrlView> setNetAuthId;
        private Provider<GlobalSearchBottomSheetPresenter> shouldRecycleViewType;
        private Provider<OauthContract.Presenter> t;
        private Provider<DeepLinkContract.View> u;
        private Provider<ServicesContract.View> v;
        private Provider<SaveShowToolTip> verifyNotNull;
        private Provider<FeatureContract.View> w;
        private Provider<GetAddingNameWhitelistedMerchantId> whenAvailable;
        private Provider<OauthContract.View> x;
        private Provider<ReadLinkPropertiesPresenter> y;
        private Provider<ReadDeepLinkProperties> z;

        public /* synthetic */ GlobalSearchBottomSheetComponentImpl(GlobalSearchBottomSheetModule globalSearchBottomSheetModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(globalSearchBottomSheetModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private GlobalSearchBottomSheetComponentImpl(GlobalSearchBottomSheetModule globalSearchBottomSheetModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.Y = this;
            this.j = DoubleCheck.getAuthRequestContext(GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory.PlaceComponentResult(globalSearchBottomSheetModule));
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.d = merchantInfoRepositoryProvider;
            GetMerchantInfo_Factory create = GetMerchantInfo_Factory.create(merchantInfoRepositoryProvider);
            this.G = create;
            GlobalSearchBottomSheetPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = GlobalSearchBottomSheetPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.j, create, MerchantInfoMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            this.shouldRecycleViewType = KClassImpl$Data$declaredNonStaticMembers$2;
            this.l = DoubleCheck.getAuthRequestContext(GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory.PlaceComponentResult(globalSearchBottomSheetModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.lookAheadTest = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.m = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.FlowableCreate$BufferAsyncEmitter = authRequestContext2;
            this.q = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = qrBarcodeRepositoryProvider;
            this.C = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.access$getCapacity$p = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.FlowViewUtil$textChanges$2 = postExecutionThreadProvider;
            this.A = GetDecodedQrisTopUp_Factory.create(this.access$getCapacity$p, postExecutionThreadProvider, this.TypefaceCompatApi26Impl);
            this.getCardNumberOCR = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = userRepositoryProvider;
            this.isAuto = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = featureConfigRepositoryProvider;
            this.B = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.b = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create2;
            this.InitSecurePreferenceAccount = ValidateNativelyDecodedQr_Factory.create(create2);
            this.H = GetMerchantQrWhitelist_Factory.create(this.TypefaceCompatApi26Impl);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.QrExpiredActivity = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = providePaylaterRepositoryProvider;
            this.Z = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = userEducationRepositoryProvider;
            this.O = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, userEducationRepositoryProvider);
            this.OtpRegistrationPresenter$input$1 = SaveShowDialog_Factory.create(this.SendMoneyScenario);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.q, this.C, this.A, this.getCardNumberOCR, this.GetContactSyncConfig, this.isAuto, this.B, GetNativelyDecodedQr_Factory.create(), this.b, this.InitSecurePreferenceAccount, this.H, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.QrExpiredActivity, this.Z, this.O, this.OtpRegistrationPresenter$input$1));
            this.FlowableReduce$ReduceSubscriber = authRequestContext3;
            this.p = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.lookAheadTest));
            this.setNetAuthId = authRequestContext4;
            this.s = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, shortenerRepositoryProvider);
            this.initAnimators = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.s, create3));
            this.RequestMoneyQrContract$View = authRequestContext5;
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.TypeProjectionImpl = myReferralConsultRepositoryProvider;
            this.N = GetReferralConsult_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, myReferralConsultRepositoryProvider);
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.f = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getCallingPid = generateLinkRepositoryProvider;
            this.readMicros = GenerateReferralDeepLink_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getContainerAuth = settingRepositoryProvider;
            this.V = GetSettingByKey_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.h = productPageManagerProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureSettingMore_Factory.PlaceComponentResult(this.V, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.f5827reduceIndexedz1zDJgo = splitBillRepositoryProvider;
            this.K = GetPayerSplitBillDetail_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, splitBillRepositoryProvider);
            this.FlowViewUtil$textChanges$1 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.FlowViewUtil$textChanges$1);
            this.checkRegisteredUserAndSendOtp = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.K, PlaceComponentResult);
            this.W = GetSplitBillConfig_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.P = create4;
            Provider<GetSplitBillConfig> provider = this.W;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.i = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.getNameOrBuilderList = create5;
            this.isLayoutRequested = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.lookAheadTest));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.lookAheadTest);
            this.e = MyBillsEntityDataFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.k = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = dynamicUrlWrapperProvider;
            this.PrepareContext = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.n = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.I = BuiltInFictitiousFunctionClassFactory;
            this.DatabaseTableConfigUtil = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.e));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.N, this.getErrorConfigVersion, this.f, this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.getSupportButtonTintMode, this.isLayoutRequested, this.FragmentBottomSheetPaymentSettingBinding, this.scheduleImpl, FeatureHome_Factory.MyBillsEntityDataFactory(), this.newProxyInstance, FeatureKyb_Factory.getAuthRequestContext(), this.PrepareContext, this.DatabaseTableConfigUtil, this.Z, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda5));
            this.SubSequence = authRequestContext6;
            this.w = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.JsonParseException = servicesRepositoryProvider;
            this.R = GetServicesByKey_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.lookAheadTest);
            this.secondaryHash = authRequestContext7;
            this.ApiStatus$AvailableSince = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.g = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create6 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.D = create6;
            GetAuthCode_Factory create7 = GetAuthCode_Factory.create(this.g, create6);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.w, this.R, this.ApiStatus$AvailableSince, create7, this.GetContactSyncConfig));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.L = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideFeedsConfigRepositoryProvider;
            this.F = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.M = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.T = GetUpdateAvailability_Factory.create(this.lookAheadTest);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.r = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.JsonParseException);
            this.S = create8;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.w, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.L, this.F, this.M, this.T, this.moveToNextValue, this.r, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = authRequestContext8;
            this.f8111o = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.newProxyInstance);
            this.connectForeground = authRequestContext9;
            this.x = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.U = GetUserInfoWithKyc_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.retainOrRemoveAllInternal);
            this.J = GetNickname_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.MyBillsEntityDataFactory);
            this.flip = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.whenAvailable = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Provider<OauthContract.View> provider2 = this.x;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.AppCompatEmojiTextHelper, this.U, this.J, this.flip, this.whenAvailable);
            this.FillAnimation = KClassImpl$Data$declaredNonStaticMembers$22;
            this.t = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$22));
            this.v = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.f8110a = IsNeedToShowToolTip_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.SendMoneyScenario);
            this.verifyNotNull = SaveShowToolTip_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.SendMoneyScenario);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetServicesWithCategory_Factory.create(this.JsonParseException);
            this.E = GetDefaultServiceWithCategory_Factory.create(this.JsonParseException);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetFavoriteServiceRemote_Factory.create(this.JsonParseException);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetServicesByName_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.JsonParseException);
            this.getValueOfTouchPositionAbsolute = GetFavoriteServices_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, this.JsonParseException);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.Q = GetRawServices_Factory.create(this.JsonParseException);
            this.getOnBoardingScenario = GetFavoriteServiceWithCacheFirst_Factory.create(this.JsonParseException);
            this.isAuth = GetServiceHighlighted_Factory.create(this.JsonParseException);
            UpdateServiceHighlighted_Factory create9 = UpdateServiceHighlighted_Factory.create(this.JsonParseException);
            this.getIndexName = create9;
            this.onDecodeSuccess = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.lookAheadTest, this.v, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.ApiStatus$AvailableSince, this.f8110a, this.verifyNotNull, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.E, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.R, this.getValueOfTouchPositionAbsolute, this.KClassImpl$Data$declaredNonStaticMembers$2, this.Q, this.getOnBoardingScenario, this.isAuth, create9));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.p, this.OtpRegistrationPresenter$input$2, this.f8111o, this.t, this.onDecodeSuccess, applicationProvider, this.Z));
            this.initRecordTimeStamp = authRequestContext10;
            this.u = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.z = ReadDeepLinkProperties_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.c = liteAccountRepositoryProvider;
            GetUserId_Factory create10 = GetUserId_Factory.create(this.access$getCapacity$p, this.FlowViewUtil$textChanges$2, liteAccountRepositoryProvider);
            this.X = create10;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.u, this.z, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create10, this.e));
            this.y = authRequestContext11;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.applyTrimPathIfNeeded());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
        /* loaded from: classes4.dex */
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent PlaceComponentResult;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.PlaceComponentResult.shouldRecycleViewType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.GlobalSearchBottomSheetComponent
        public final void PlaceComponentResult(GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog) {
            GlobalSearchBottomSheetDialog_MembersInjector.BuiltInFictitiousFunctionClassFactory(globalSearchBottomSheetDialog, this.l.get());
            GlobalSearchBottomSheetDialog_MembersInjector.PlaceComponentResult(globalSearchBottomSheetDialog, this.SizeSelectors$OrSelector.get());
            GlobalSearchBottomSheetDialog_MembersInjector.PlaceComponentResult(globalSearchBottomSheetDialog, this.p.get());
        }
    }
}
