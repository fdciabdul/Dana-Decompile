package id.dana.di.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.announcement.AnnouncementPresenter;
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
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterModule_ProvideView$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterPresenter;
import id.dana.contract.paylater.PayLaterPresenter_Factory;
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
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.AnnouncementModule;
import id.dana.di.modules.AnnouncementModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.AnnouncementModule_ProvideView$app_productionReleaseFactory;
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
import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.announcement.interactor.SaveGnAnnouncementId;
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
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist_Factory;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime_Factory;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.GetUserLoanInfo_Factory;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime_Factory;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache_Factory;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache_Factory;
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
import id.dana.richview.NewBannerView;
import id.dana.richview.NewBannerView_MembersInjector;
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
public final class DaggerNewBannerComponent {
    private DaggerNewBannerComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public DeepLinkModule MyBillsEntityDataFactory;
        public PayLaterModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public OauthModule PlaceComponentResult;
        public AnnouncementModule getAuthRequestContext;
        public RestoreUrlModule getErrorConfigVersion;
        public ServicesModule moveToNextValue;
        public ScanQrModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewBannerComponentImpl implements NewBannerComponent {
        private Provider<GetCashierNativeConfig> A;
        private Provider<ServiceCategoryMapper> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServiceRemote> AppCompatEmojiTextHelper;
        private Provider<GetAuthCode> B;
        private Provider<GenerateReferralDeepLink> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private Provider<GetDecodeTciCoListConfig> D;
        private Provider<FeedsConfigRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<ClearCachePayLaterLoanWhitelist> DatabaseTableConfigUtil;
        private Provider<GetDecodedQrisTopUp> E;
        private Provider<GetFavoriteServiceWithCacheFirst> F;
        private Provider<MixpanelDeeplinkTracker> FillAnimation;
        private Provider<OauthRepository> FlowViewUtil$textChanges$1;
        private Provider<OauthView> FlowViewUtil$textChanges$2;
        private Provider<ReadLinkPropertiesPresenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<UpdateServiceHighlighted> FlowableKt$toIterable$1;
        private Provider<RestoreUrlView> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePushVerify> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetIsCardBindingV2Enabled> G;
        private Provider<Context> GetContactSyncConfig;
        private Provider<GetFeedConfig> H;
        private Provider<GetFavoriteServices> I;
        private Provider<SplitBillHistoryToSplitBillModelMapper> InitSecurePreferenceAccount;
        private Provider<GetMissionDetail> J;
        private Provider<SaveShowDialog> JsonParseException;
        private Provider<GetKycLevel> K;
        private final AnnouncementModule KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetNearbyConfig> L;
        private Provider<GetNickname> M;
        private Provider<Application> MyBillsEntityDataFactory;
        private Provider<GetPayLaterLoanStatusWhitelist> N;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<UserRepository> NewMerchantCategoryAdapter;
        private Provider<GetPayerSplitBillDetail> O;
        private Provider<SavePaylaterRotationDelayTime> OtpRegistrationPresenter$input$1;
        private Provider<Activity> OtpRegistrationPresenter$input$2;
        private Provider<GetPaylaterRotationDelayTime> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<FeatureCardBinding> PrepareContext;
        private Provider<SplitBillRepository> PromoCategoryPresenter$1;
        private Provider<GetPayLaterCacheLoanWhitelist> Q;
        private Provider<GetUserLoanInfo> QrExpiredActivity;
        private Provider<GetRawServices> R;
        private Provider<ThreadExecutor> ReferralMapper_Factory;
        private Provider<DeepLinkContract.View> RequestMoneyQrContract$View;
        private Provider<GetRequestMoneyInfoFeature> S;
        private Provider<ShortenerRepository> SendMoneyScenario;
        private Provider<RestoreUrlContract.Presenter> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetPromoCenterVersion> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetQrBindingConfig> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetQrisCpmSendmoneyConfig> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetServicesWithCategory> T;
        private Provider<LiteAccountRepository> TypeProjectionImpl;
        private Provider<RestoreUrlContract.View> TypefaceCompatApi26Impl;
        private Provider<GetServiceHighlighted> U;
        private Provider<GetService> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetEmptyUserInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesByName> W;
        private Provider<GetServicesByKey> X;
        private Provider<GetSplitBillConfig> Y;
        private Provider<GetUserInfoWithKyc> Z;

        /* renamed from: a */
        private Provider<IsNativeDecodeEnabled> f8134a;
        private Provider<ServicesRepository> access$getCapacity$p;
        private Provider<UserEducationRepository> access$setShowcaseShowing$p;
        private Provider<PayLaterPresenter> access$throwIllegalArgumentType;
        private Provider<GetUserStatusInfo> b;
        private Provider<GetWhitelistedSubMerchantId> c;
        private Provider<ServicesPresenter> checkRegisteredUserAndSendOtp;
        private Provider<OauthPresenter> connectForeground;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> d;
        private Provider<MyReferralConsultRepository> e;
        private Provider<IsNeedToShowToolTip> f;
        private Provider<GetUserId> flip;
        private Provider<MyReferralConsultMapper> g;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<FeatureSplitBill> getCallingPid;
        private Provider<RestoreUrl> getCardNumberOCR;
        private Provider<ScanQrPresenter> getContainerAuth;
        private Provider<ScanQrView> getDefaultSenderId;
        private Provider<CheckDeepLinkActionVisibility> getErrorConfigVersion;
        private Provider<ValidateNativelyDecodedQr> getFontAssetManager;
        private Provider<SettingRepository> getIndexName;
        private Provider<GetMerchantQrWhitelist> getNameOrBuilderList;
        private Provider<GetDefaultServiceWithCategory> getOnBoardingScenario;
        private Provider<UpdatePayLaterLoanCache> getReadyFragment;
        private Provider<FeatureView> getSupportButtonTintMode;
        private Provider<GetDecodedQrBarcode> getValueOfTouchPositionAbsolute;
        private final NewBannerComponentImpl h;
        private final PayLaterModule i;
        private Provider<QrBarcodeRepository> initAnimators;
        private Provider<DeepLinkPayloadModelMapper> initRecordTimeStamp;
        private Provider<UserConsentRepository> insertActivities;
        private Provider<GetReferralConsult> isAuth;
        private Provider<GetUpdateAvailability> isAuto;
        private Provider<DynamicUrlWrapper> isLayoutRequested;
        private Provider<PromoQuestRepository> j;
        private Provider<PostExecutionThread> k;
        private Provider<ProductPageManager> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<PayerModelListMapper> m;
        private Provider<CheckFavoriteServicesFeature> moveToNextValue;
        private Provider<CardBindingRepository> n;
        private Provider<FeatureConfigRepository> newProxyInstance;

        /* renamed from: o */
        private Provider<FamilyAccountRepository> f8135o;
        private Provider<ScanResultMapper> onDecodeSuccess;
        private Provider<PaylaterRepository> p;
        private Provider<PushVerifyTracker> q;
        private Provider<OauthContract.Presenter> r;
        private Provider<FeatureSettingMore> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<SetPayLaterLoanCache> f5860reduceIndexedz1zDJgo;
        private Provider<ThirdPartyServicesMapper> retainOrRemoveAllInternal;
        private Provider<ScanQrContract.Presenter> s;
        private Provider<CheckWhitelistedValidDomain> scheduleImpl;
        private Provider<SaveShowToolTip> secondaryHash;
        private Provider<OauthContract.View> setNetAuthId;
        private Provider<GetSettingByKey> shouldRecycleViewType;
        private Provider<FeatureContract.Presenter> t;
        private Provider<FeatureContract.View> u;
        private Provider<PayLaterContract.View> v;
        private Provider<RestoreUrlPresenter> verifyNotNull;
        private Provider<ScanQrContract.View> w;
        private Provider<FeatureServicesHandler> whenAvailable;
        private Provider<ReadLinkPropertiesContract.Presenter> x;
        private Provider<ServicesContract.View> y;
        private Provider<ReadDeepLinkProperties> z;

        public /* synthetic */ NewBannerComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, AnnouncementModule announcementModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, announcementModule, payLaterModule, applicationComponent);
        }

        private NewBannerComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, AnnouncementModule announcementModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.h = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = announcementModule;
            this.getAuthRequestContext = applicationComponent;
            this.i = payLaterModule;
            this.ReferralMapper_Factory = new ThreadExecutorProvider(applicationComponent);
            this.k = new PostExecutionThreadProvider(applicationComponent);
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.e = myReferralConsultRepositoryProvider;
            this.isAuth = GetReferralConsult_Factory.create(this.ReferralMapper_Factory, this.k, myReferralConsultRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.newProxyInstance = featureConfigRepositoryProvider;
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(featureConfigRepositoryProvider);
            this.g = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GenerateReferralDeepLink_Factory.create(this.ReferralMapper_Factory, this.k, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getIndexName = settingRepositoryProvider;
            this.shouldRecycleViewType = GetSettingByKey_Factory.create(this.ReferralMapper_Factory, this.k, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.l = productPageManagerProvider;
            this.readMicros = FeatureSettingMore_Factory.PlaceComponentResult(this.shouldRecycleViewType, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = splitBillRepositoryProvider;
            this.O = GetPayerSplitBillDetail_Factory.create(this.ReferralMapper_Factory, this.k, splitBillRepositoryProvider);
            this.m = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.m);
            this.InitSecurePreferenceAccount = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.O, PlaceComponentResult);
            this.Y = GetSplitBillConfig_Factory.create(this.ReferralMapper_Factory, this.k, this.newProxyInstance);
            GetRequestMoneyInfoFeature_Factory create = GetRequestMoneyInfoFeature_Factory.create(this.ReferralMapper_Factory, this.k, this.newProxyInstance);
            this.S = create;
            Provider<GetSplitBillConfig> provider = this.Y;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getCallingPid = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.j = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create2 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.J = create2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeaturePromoQuest_Factory.getAuthRequestContext(create2, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.GetContactSyncConfig = contextProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(contextProvider));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.GetContactSyncConfig);
            this.FillAnimation = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.f8135o = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.isLayoutRequested = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.n = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.G = BuiltInFictitiousFunctionClassFactory;
            this.PrepareContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.p = providePaylaterRepositoryProvider;
            this.QrExpiredActivity = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.FillAnimation));
            Provider<FeatureView> authRequestContext = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.isAuth, this.lookAheadTest, this.g, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.readMicros, this.SubSequence, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda1, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda4, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.PrepareContext, this.QrExpiredActivity, FeatureMyBills_Factory.PlaceComponentResult(), this.FragmentBottomSheetPaymentSettingBinding));
            this.getSupportButtonTintMode = authRequestContext;
            this.u = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = servicesRepositoryProvider;
            this.X = GetServicesByKey_Factory.create(this.ReferralMapper_Factory, this.k, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext2 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.GetContactSyncConfig);
            this.ApiStatus$AvailableSince = authRequestContext2;
            this.retainOrRemoveAllInternal = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            this.FlowViewUtil$textChanges$1 = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.insertActivities = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create3 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create3;
            this.B = GetAuthCode_Factory.create(this.FlowViewUtil$textChanges$1, create3);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = deviceInformationProviderProvider;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.u, this.X, this.retainOrRemoveAllInternal, this.B, deviceInformationProviderProvider));
            this.getErrorConfigVersion = CheckDeepLinkActionVisibility_Factory.create(this.ReferralMapper_Factory, this.k, this.newProxyInstance);
            this.scheduleImpl = CheckWhitelistedValidDomain_Factory.create(this.newProxyInstance);
            this.L = GetNearbyConfig_Factory.create(this.newProxyInstance);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = provideFeedsConfigRepositoryProvider;
            this.H = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetPromoCenterVersion_Factory.create(this.newProxyInstance);
            this.isAuto = GetUpdateAvailability_Factory.create(this.GetContactSyncConfig);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckMyBillsVersionConfig_Factory.create(this.newProxyInstance);
            this.q = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create4 = GetService_Factory.create(this.access$getCapacity$p);
            this.V = create4;
            Provider<FeaturePresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.u, this.whenAvailable, this.getErrorConfigVersion, this.scheduleImpl, this.L, this.H, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.isAuto, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.q, create4));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext3;
            this.t = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext3));
            Provider<Activity> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.OtpRegistrationPresenter$input$2 = authRequestContext4;
            Provider<ScanQrView> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext4));
            this.getDefaultSenderId = authRequestContext5;
            this.w = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext5));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.initAnimators = qrBarcodeRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.E = GetDecodedQrisTopUp_Factory.create(this.ReferralMapper_Factory, this.k, this.initAnimators);
            this.onDecodeSuccess = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NewMerchantCategoryAdapter = userRepositoryProvider;
            this.b = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.A = GetCashierNativeConfig_Factory.create(this.newProxyInstance);
            this.f8134a = IsNativeDecodeEnabled_Factory.create(this.newProxyInstance);
            GetDecodeTciCoListConfig_Factory create5 = GetDecodeTciCoListConfig_Factory.create(this.newProxyInstance);
            this.D = create5;
            this.getFontAssetManager = ValidateNativelyDecodedQr_Factory.create(create5);
            this.getNameOrBuilderList = GetMerchantQrWhitelist_Factory.create(this.initAnimators);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetQrBindingConfig_Factory.create(this.newProxyInstance);
            this.d = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.newProxyInstance);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.access$setShowcaseShowing$p = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetQrisCpmSendmoneyConfig_Factory.create(this.newProxyInstance, userEducationRepositoryProvider);
            this.JsonParseException = SaveShowDialog_Factory.create(this.access$setShowcaseShowing$p);
            Provider<ScanQrPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig, this.w, this.getValueOfTouchPositionAbsolute, this.E, this.onDecodeSuccess, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.b, this.A, GetNativelyDecodedQr_Factory.create(), this.f8134a, this.getFontAssetManager, this.getNameOrBuilderList, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.d, this.QrExpiredActivity, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.JsonParseException));
            this.getContainerAuth = authRequestContext6;
            this.s = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext6));
            Provider<RestoreUrlView> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            this.FlowableReduce$ReduceSubscriber = authRequestContext7;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = shortenerRepositoryProvider;
            RestoreUrl_Factory create6 = RestoreUrl_Factory.create(this.ReferralMapper_Factory, this.k, shortenerRepositoryProvider);
            this.getCardNumberOCR = create6;
            Provider<RestoreUrlPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.TypefaceCompatApi26Impl, create6));
            this.verifyNotNull = authRequestContext8;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.FlowViewUtil$textChanges$2 = authRequestContext9;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.K = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.Z = GetUserInfoWithKyc_Factory.create(this.ReferralMapper_Factory, this.k, this.NewMerchantCategoryAdapter);
            this.M = GetNickname_Factory.create(this.ReferralMapper_Factory, this.k, this.PlaceComponentResult);
            this.c = GetWhitelistedSubMerchantId_Factory.create(this.newProxyInstance);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.newProxyInstance);
            Provider<OauthContract.View> provider2 = this.setNetAuthId;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.K, this.Z, this.M, this.c, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.connectForeground = KClassImpl$Data$declaredNonStaticMembers$2;
            this.r = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.y = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.f = IsNeedToShowToolTip_Factory.create(this.ReferralMapper_Factory, this.k, this.access$setShowcaseShowing$p);
            this.secondaryHash = SaveShowToolTip_Factory.create(this.ReferralMapper_Factory, this.k, this.access$setShowcaseShowing$p);
            this.T = GetServicesWithCategory_Factory.create(this.access$getCapacity$p);
            this.getOnBoardingScenario = GetDefaultServiceWithCategory_Factory.create(this.access$getCapacity$p);
            this.AppCompatEmojiTextHelper = GetFavoriteServiceRemote_Factory.create(this.access$getCapacity$p);
            this.W = GetServicesByName_Factory.create(this.ReferralMapper_Factory, this.k, this.access$getCapacity$p);
            this.I = GetFavoriteServices_Factory.create(this.ReferralMapper_Factory, this.k, this.access$getCapacity$p);
            this.moveToNextValue = CheckFavoriteServicesFeature_Factory.create(this.newProxyInstance);
            this.R = GetRawServices_Factory.create(this.access$getCapacity$p);
            this.F = GetFavoriteServiceWithCacheFirst_Factory.create(this.access$getCapacity$p);
            this.U = GetServiceHighlighted_Factory.create(this.access$getCapacity$p);
            UpdateServiceHighlighted_Factory create7 = UpdateServiceHighlighted_Factory.create(this.access$getCapacity$p);
            this.FlowableKt$toIterable$1 = create7;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.GetContactSyncConfig, this.y, this.B, this.retainOrRemoveAllInternal, this.f, this.secondaryHash, this.T, this.getOnBoardingScenario, this.AppCompatEmojiTextHelper, this.W, this.X, this.I, this.moveToNextValue, this.R, this.F, this.U, create7));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.MyBillsEntityDataFactory = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.s, this.SizeSelectors$OrSelector, this.t, this.r, this.checkRegisteredUserAndSendOtp, applicationProvider, this.QrExpiredActivity));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext10;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.z = ReadDeepLinkProperties_Factory.create(this.ReferralMapper_Factory, this.k);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.initRecordTimeStamp = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.TypeProjectionImpl = liteAccountRepositoryProvider;
            GetUserId_Factory create8 = GetUserId_Factory.create(this.ReferralMapper_Factory, this.k, liteAccountRepositoryProvider);
            this.flip = create8;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.RequestMoneyQrContract$View, this.z, this.initRecordTimeStamp, create8, this.FillAnimation));
            this.FlowableCreate$BufferAsyncEmitter = authRequestContext11;
            this.x = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
            this.v = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.DatabaseTableConfigUtil = ClearCachePayLaterLoanWhitelist_Factory.create(this.p, this.access$getCapacity$p);
            this.Q = GetPayLaterCacheLoanWhitelist_Factory.create(this.p);
            this.OtpRegistrationPresenter$input$1 = SavePaylaterRotationDelayTime_Factory.create(this.p);
            this.P = GetPaylaterRotationDelayTime_Factory.create(this.p);
            this.N = GetPayLaterLoanStatusWhitelist_Factory.create(this.p);
            this.getReadyFragment = UpdatePayLaterLoanCache_Factory.create(this.p, this.access$getCapacity$p);
            SetPayLaterLoanCache_Factory create9 = SetPayLaterLoanCache_Factory.create(this.p, this.access$getCapacity$p);
            this.f5860reduceIndexedz1zDJgo = create9;
            this.access$throwIllegalArgumentType = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.v, this.DatabaseTableConfigUtil, this.Q, this.QrExpiredActivity, this.OtpRegistrationPresenter$input$1, this.P, this.N, this.getReadyFragment, create9));
        }

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
            private final ApplicationComponent MyBillsEntityDataFactory;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isInfoWindowShown());
            }
        }

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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.applyTrimPathIfNeeded());
            }
        }

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

        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.NewBannerComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(NewBannerView newBannerView) {
            NewBannerView_MembersInjector.MyBillsEntityDataFactory(newBannerView, this.t.get());
            NewBannerView_MembersInjector.getAuthRequestContext(newBannerView, this.x.get());
            NewBannerView_MembersInjector.getAuthRequestContext(newBannerView, this.SizeSelectors$OrSelector.get());
            newBannerView.scanQrPresenter = this.s.get();
            NewBannerView_MembersInjector.getAuthRequestContext(newBannerView, AnnouncementModule_ProvidePresenter$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, new AnnouncementPresenter(AnnouncementModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), new SaveGnAnnouncementId((AnnouncementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getAuthRequestContext())))));
            NewBannerView_MembersInjector.PlaceComponentResult(newBannerView, (HomeWidgetEntityData) Preconditions.PlaceComponentResult(this.getAuthRequestContext.s()));
            NewBannerView_MembersInjector.getAuthRequestContext(newBannerView, PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.i, this.access$throwIllegalArgumentType.get()));
        }
    }
}
