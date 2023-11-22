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
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.NotificationCenterModule;
import id.dana.di.modules.NotificationCenterModule_ProvidePresenterFactory;
import id.dana.di.modules.NotificationCenterModule_ProvideViewFactory;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
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
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
import id.dana.domain.notificationcenter.interactor.FetchUserInbox;
import id.dana.domain.notificationcenter.interactor.MarkNotificationAsRead;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
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
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
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
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.notificationcenter.NotificationCenterPresenter;
import id.dana.notificationcenter.mapper.NotificationCenterMapper;
import id.dana.notificationcenter.views.NotificationCenterFragment;
import id.dana.notificationcenter.views.NotificationCenterFragment_MembersInjector;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
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
public final class DaggerNotificationCenterComponent {
    private DaggerNotificationCenterComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public CheckoutH5EventModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public DeepLinkModule PlaceComponentResult;
        public NotificationCenterModule getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public ServicesModule lookAheadTest;
        public PlayStoreReviewModules moveToNextValue;
        public RestoreUrlModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NotificationCenterComponentImpl implements NotificationCenterComponent {
        private Provider<GetCheckoutH5Event> A;
        private Provider<ScanQrView> ApiStatus$AvailableSince;
        private Provider<GetFavoriteServices> AppCompatEmojiTextHelper;
        private Provider<GetAddingNameWhitelistedMerchantId> B;
        private Provider<GetAuthCode> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateReferralDeepLink> C;
        private Provider<ValidateNativelyDecodedQr> CYFMonitor$ChallengeActionCallback;
        private Provider<GetDecodedQrisTopUp> D;
        private Provider<PaylaterRepository> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DanaCustomH5> DatabaseTableConfigUtil;
        private Provider<GetEmptyUserInfo> E;
        private Provider<GetIsCardBindingV2Enabled> F;
        private Provider<MyReferralConsultMapper> FillAnimation;
        private Provider<OauthView> FlowViewUtil$textChanges$1;
        private final NotificationCenterModule FlowViewUtil$textChanges$2;
        private Provider<ReadDeepLinkProperties> FlowableCreate$BufferAsyncEmitter;
        private Provider<UserEducationRepository> FlowableKt$toIterable$1;
        private Provider<QrBarcodeRepository> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetFavoriteServiceWithCacheFirst> G;
        private Provider<DeviceInformationProvider> GetContactSyncConfig;
        private Provider<GetFavoriteServiceRemote> H;
        private Provider<GetFeedConfig> I;
        private Provider<SplitBillHistoryToSplitBillModelMapper> InitSecurePreferenceAccount;
        private Provider<GetMerchantQrWhitelist> J;
        private Provider<SaveShowToolTip> JsonParseException;
        private Provider<GetNickname> K;
        private Provider<CheckDeepLinkActionVisibility> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetKycLevel> L;
        private Provider<GetNearbyConfig> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetPromoCenterVersion> N;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureServicesHandler> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<UserRepository> NewMerchantCategoryAdapter;
        private Provider<GetQrisCpmSendmoneyConfig> O;
        private Provider<RestoreUrl> OtpRegistrationPresenter$input$1;
        private Provider<FamilyAccountRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetQrBindingConfig> P;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<DynamicUrlWrapper> PrepareContext;
        private Provider<ThirdPartyServicesMapper> PromoCategoryPresenter$1;
        private Provider<GetRawServices> Q;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> QrExpiredActivity;
        private Provider<GetService> R;
        private Provider<ShortenerRepository> ReferralMapper_Factory;
        private Provider<OauthContract.View> RequestMoneyQrContract$View;
        private Provider<GetServicesByKey> S;
        private Provider<SettingRepository> SendMoneyScenario;
        private Provider<RestoreUrlContract.Presenter> SizeSelectors$OrSelector;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetPayerSplitBillDetail> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetServiceHighlighted> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetReferralConsult> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetSplitBillConfig> T;
        private final NotificationCenterComponentImpl TypeProjectionImpl;
        private Provider<ScanQrContract.View> TypefaceCompatApi26Impl;
        private Provider<GetUpdateAvailability> U;
        private Provider<GetServicesWithCategory> V;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDefaultServiceWithCategory> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServicesByName> W;
        private Provider<GetSettingByKey> X;
        private Provider<GetUserInfoWithKyc> Y;
        private Provider<GetUserLoanInfo> Z;

        /* renamed from: a */
        private Provider<IsNeedToShowToolTip> f8142a;
        private Provider<ServicesPresenter> access$getCapacity$p;
        private Provider<UpdateServiceHighlighted> access$setShowcaseShowing$p;
        private Provider<PostExecutionThread> access$throwIllegalArgumentType;
        private Provider<IsNeedToShowPlayStoreReview> b;
        private Provider<H5EventRepository> c;
        private Provider<ScanResultMapper> checkRegisteredUserAndSendOtp;
        private Provider<OauthPresenter> connectForeground;
        private Provider<IsNativeDecodeEnabled> d;
        private Provider<LiteAccountRepository> e;
        private Provider<MixpanelDeeplinkTracker> f;
        private Provider<GetWhitelistedSubMerchantId> flip;
        private Provider<MyReferralConsultRepository> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<FeatureView> getCallingPid;
        private Provider<RestoreUrlPresenter> getCardNumberOCR;
        private Provider<RestoreUrlView> getContainerAuth;
        private Provider<SaveLastPlayStoreReviewShow> getDefaultSenderId;
        private final CheckoutH5EventModule getErrorConfigVersion;
        private Provider<ServicesRepository> getIndexName;
        private Provider<GetMissionDetail> getNameOrBuilderList;
        private Provider<GetDecodedQrBarcode> getOnBoardingScenario;
        private Provider<UserConsentRepository> getReadyFragment;
        private Provider<GenerateLinkRepository> getSupportButtonTintMode;
        private Provider<GetDecodeTciCoListConfig> getValueOfTouchPositionAbsolute;
        private Provider<OauthRepository> h;
        private Provider<PayerModelListMapper> i;
        private Provider<DeepLinkContract.View> initAnimators;
        private Provider<DeepLinkView> initRecordTimeStamp;
        private Provider<ThreadExecutor> insertActivities;
        private Provider<GetRequestMoneyInfoFeature> isAuth;
        private Provider<GetUserId> isAuto;
        private Provider<FeatureFamilyAccount> isLayoutRequested;
        private Provider<ProductPageManager> j;
        private Provider<PlayStoreReviewRepository> k;
        private Provider<PlayStoreReviewPresenter> l;
        private Provider<CheckFavoriteServicesFeature> lookAheadTest;
        private Provider<PromoQuestRepository> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<CardBindingRepository> n;
        private Provider<FeatureConfigRepository> newProxyInstance;

        /* renamed from: o */
        private Provider<Activity> f8143o;
        private Provider<ScanQrPresenter> onDecodeSuccess;
        private Provider<FeedsConfigRepository> p;
        private Provider<ScanQrContract.Presenter> q;
        private Provider<PlayStoreReviewContract.Presenter> r;
        private Provider<FeatureSplitBill> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ServiceCategoryMapper> f5871reduceIndexedz1zDJgo;
        private Provider<SplitBillRepository> retainOrRemoveAllInternal;
        private Provider<FeatureContract.Presenter> s;
        private Provider<CheckWhitelistedValidDomain> scheduleImpl;
        private Provider<SaveShowDialog> secondaryHash;
        private Provider<ServicesContract.View> setNetAuthId;
        private Provider<GetUserStatusInfo> shouldRecycleViewType;
        private Provider<PlayStoreReviewContract.View> t;
        private Provider<CheckoutH5EventContract.View> u;
        private Provider<OauthContract.Presenter> v;
        private Provider<ReadLinkPropertiesPresenter> verifyNotNull;
        private Provider<PushVerifyTracker> w;
        private Provider<FeatureSettingMore> whenAvailable;
        private Provider<ReadLinkPropertiesContract.Presenter> x;
        private Provider<FeatureContract.View> y;
        private Provider<RestoreUrlContract.View> z;

        public /* synthetic */ NotificationCenterComponentImpl(NotificationCenterModule notificationCenterModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent, byte b) {
            this(notificationCenterModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, playStoreReviewModules, checkoutH5EventModule, applicationComponent);
        }

        private NotificationCenterComponentImpl(NotificationCenterModule notificationCenterModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.TypeProjectionImpl = this;
            this.getErrorConfigVersion = checkoutH5EventModule;
            this.FlowViewUtil$textChanges$2 = notificationCenterModule;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.insertActivities = new ThreadExecutorProvider(applicationComponent);
            this.access$throwIllegalArgumentType = new PostExecutionThreadProvider(applicationComponent);
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.c = h5eventRepositoryProvider;
            this.A = GetCheckoutH5Event_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, h5eventRepositoryProvider);
            this.u = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.k = playStoreReviewRepositoryProvider;
            this.b = IsNeedToShowPlayStoreReview_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, playStoreReviewRepositoryProvider);
            this.getDefaultSenderId = SaveLastPlayStoreReviewShow_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.k);
            Provider<PlayStoreReviewContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.t = authRequestContext;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.b, this.getDefaultSenderId, authRequestContext);
            this.l = MyBillsEntityDataFactory;
            this.r = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.f8143o = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.ApiStatus$AvailableSince = authRequestContext3;
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = qrBarcodeRepositoryProvider;
            this.getOnBoardingScenario = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.D = GetDecodedQrisTopUp_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.FlowableReduce$ReduceSubscriber);
            this.checkRegisteredUserAndSendOtp = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NewMerchantCategoryAdapter = userRepositoryProvider;
            this.shouldRecycleViewType = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.newProxyInstance = featureConfigRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.d = IsNativeDecodeEnabled_Factory.create(this.newProxyInstance);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.newProxyInstance);
            this.getValueOfTouchPositionAbsolute = create;
            this.CYFMonitor$ChallengeActionCallback = ValidateNativelyDecodedQr_Factory.create(create);
            this.J = GetMerchantQrWhitelist_Factory.create(this.FlowableReduce$ReduceSubscriber);
            this.P = GetQrBindingConfig_Factory.create(this.newProxyInstance);
            this.QrExpiredActivity = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.newProxyInstance);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = providePaylaterRepositoryProvider;
            this.Z = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.FlowableKt$toIterable$1 = userEducationRepositoryProvider;
            this.O = GetQrisCpmSendmoneyConfig_Factory.create(this.newProxyInstance, userEducationRepositoryProvider);
            this.secondaryHash = SaveShowDialog_Factory.create(this.FlowableKt$toIterable$1);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.TypefaceCompatApi26Impl, this.getOnBoardingScenario, this.D, this.checkRegisteredUserAndSendOtp, this.GetContactSyncConfig, this.shouldRecycleViewType, this.VerifyPinStateManager$executeRiskChallenge$2$1, GetNativelyDecodedQr_Factory.create(), this.d, this.CYFMonitor$ChallengeActionCallback, this.J, this.P, this.QrExpiredActivity, this.Z, this.O, this.secondaryHash));
            this.onDecodeSuccess = authRequestContext4;
            this.q = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            Provider<RestoreUrlView> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.getContainerAuth = authRequestContext5;
            this.z = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.ReferralMapper_Factory = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, shortenerRepositoryProvider);
            this.OtpRegistrationPresenter$input$1 = create2;
            Provider<RestoreUrlPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.z, create2));
            this.getCardNumberOCR = authRequestContext6;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.g = myReferralConsultRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetReferralConsult_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShowReferralCodeFeature_Factory.create(this.newProxyInstance);
            this.FillAnimation = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = generateLinkRepositoryProvider;
            this.C = GenerateReferralDeepLink_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = settingRepositoryProvider;
            this.X = GetSettingByKey_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.j = productPageManagerProvider;
            this.whenAvailable = FeatureSettingMore_Factory.PlaceComponentResult(this.X, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = splitBillRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetPayerSplitBillDetail_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, splitBillRepositoryProvider);
            this.i = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.i);
            this.InitSecurePreferenceAccount = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.SummaryVoucherView$$ExternalSyntheticLambda0, PlaceComponentResult);
            this.T = GetSplitBillConfig_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.newProxyInstance);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.newProxyInstance);
            this.isAuth = create3;
            Provider<GetSplitBillConfig> provider = this.T;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.readMicros = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.m = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.getNameOrBuilderList = create4;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory2 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.f = MyBillsEntityDataFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.PrepareContext = dynamicUrlWrapperProvider;
            this.isLayoutRequested = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.n = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.F = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.f));
            Provider<FeatureView> authRequestContext7 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.SummaryVoucherView$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FillAnimation, this.C, this.whenAvailable, this.SubSequence, this.readMicros, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda7, FeatureKyb_Factory.getAuthRequestContext(), this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.Z, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            this.getCallingPid = authRequestContext7;
            this.y = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext7));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.getIndexName = servicesRepositoryProvider;
            this.S = GetServicesByKey_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext8 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.f5871reduceIndexedz1zDJgo = authRequestContext8;
            this.PromoCategoryPresenter$1 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext8);
            this.h = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getReadyFragment = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.E = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.h, create5);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.y, this.S, this.PromoCategoryPresenter$1, create6, this.GetContactSyncConfig));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckDeepLinkActionVisibility_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.newProxyInstance);
            this.scheduleImpl = CheckWhitelistedValidDomain_Factory.create(this.newProxyInstance);
            this.M = GetNearbyConfig_Factory.create(this.newProxyInstance);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.p = provideFeedsConfigRepositoryProvider;
            this.I = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.N = GetPromoCenterVersion_Factory.create(this.newProxyInstance);
            this.U = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.newProxyInstance);
            this.w = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.getIndexName);
            this.R = create7;
            Provider<FeaturePresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.y, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.M, this.I, this.N, this.U, this.moveToNextValue, this.w, create7));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext9;
            this.s = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext9));
            OauthView_Factory authRequestContext10 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.FlowViewUtil$textChanges$1 = authRequestContext10;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext10));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            this.L = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.Y = GetUserInfoWithKyc_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.NewMerchantCategoryAdapter);
            this.K = GetNickname_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.PlaceComponentResult);
            this.flip = GetWhitelistedSubMerchantId_Factory.create(this.newProxyInstance);
            this.B = GetAddingNameWhitelistedMerchantId_Factory.create(this.newProxyInstance);
            Provider<OauthContract.View> provider2 = this.RequestMoneyQrContract$View;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.L, this.Y, this.K, this.flip, this.B);
            this.connectForeground = KClassImpl$Data$declaredNonStaticMembers$2;
            this.v = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.setNetAuthId = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.f8142a = IsNeedToShowToolTip_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.FlowableKt$toIterable$1);
            this.JsonParseException = SaveShowToolTip_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.FlowableKt$toIterable$1);
            this.V = GetServicesWithCategory_Factory.create(this.getIndexName);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDefaultServiceWithCategory_Factory.create(this.getIndexName);
            this.H = GetFavoriteServiceRemote_Factory.create(this.getIndexName);
            this.W = GetServicesByName_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.getIndexName);
            this.AppCompatEmojiTextHelper = GetFavoriteServices_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, this.getIndexName);
            this.lookAheadTest = CheckFavoriteServicesFeature_Factory.create(this.newProxyInstance);
            this.Q = GetRawServices_Factory.create(this.getIndexName);
            this.G = GetFavoriteServiceWithCacheFirst_Factory.create(this.getIndexName);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetServiceHighlighted_Factory.create(this.getIndexName);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.getIndexName);
            this.access$setShowcaseShowing$p = create8;
            this.access$getCapacity$p = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.setNetAuthId, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.PromoCategoryPresenter$1, this.f8142a, this.JsonParseException, this.V, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.H, this.W, this.S, this.AppCompatEmojiTextHelper, this.lookAheadTest, this.Q, this.G, this.SummaryVoucherView$$ExternalSyntheticLambda1, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext11 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.q, this.SizeSelectors$OrSelector, this.s, this.v, this.access$getCapacity$p, applicationProvider, this.Z));
            this.initRecordTimeStamp = authRequestContext11;
            this.initAnimators = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext11));
            this.FlowableCreate$BufferAsyncEmitter = ReadDeepLinkProperties_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.e = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.insertActivities, this.access$throwIllegalArgumentType, liteAccountRepositoryProvider);
            this.isAuto = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.initAnimators, this.FlowableCreate$BufferAsyncEmitter, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create9, this.f));
            this.verifyNotNull = authRequestContext12;
            this.x = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.Z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent PlaceComponentResult;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.access$throwIllegalArgumentType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.NotificationCenterComponent
        public final void MyBillsEntityDataFactory(NotificationCenterFragment notificationCenterFragment) {
            NotificationCenterFragment_MembersInjector.getAuthRequestContext(notificationCenterFragment, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.getErrorConfigVersion, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.A), DoubleCheck.MyBillsEntityDataFactory(this.u))));
            NotificationCenterFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(notificationCenterFragment, this.r.get());
            notificationCenterFragment.presenter = NotificationCenterModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(this.FlowViewUtil$textChanges$2, new NotificationCenterPresenter(NotificationCenterModule_ProvideViewFactory.getAuthRequestContext(this.FlowViewUtil$textChanges$2), new NotificationCenterMapper(), new FetchUserInbox((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (NotificationCenterRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.R())), new MarkNotificationAsRead((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (NotificationCenterRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.R()))));
            NotificationCenterFragment_MembersInjector.MyBillsEntityDataFactory(notificationCenterFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext()));
            NotificationCenterFragment_MembersInjector.MyBillsEntityDataFactory(notificationCenterFragment, this.x.get());
            NotificationCenterFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(notificationCenterFragment, this.SizeSelectors$OrSelector.get());
            NotificationCenterFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(notificationCenterFragment, this.q.get());
            NotificationCenterFragment_MembersInjector.getAuthRequestContext(notificationCenterFragment, this.s.get());
        }
    }
}
