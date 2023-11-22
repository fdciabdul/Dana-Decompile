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
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterModule_ProvideView$app_productionReleaseFactory;
import id.dana.contract.paylater.PayLaterPresenter;
import id.dana.contract.paylater.PayLaterPresenter_Factory;
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
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
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
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
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
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.user.interactor.GetUserStatusInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
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
import id.dana.service.ServicesActivity;
import id.dana.service.ServicesActivity_MembersInjector;
import id.dana.splitbill.mapper.PayerModelListMapper;
import id.dana.splitbill.mapper.PayerModelListMapper_Factory;
import id.dana.splitbill.mapper.PayerModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerServiceComponent {
    private DaggerServiceComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public CheckoutH5EventModule KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public ScanQrModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public DeepLinkModule PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public ServicesModule initRecordTimeStamp;
        public RestoreUrlModule lookAheadTest;
        public PayLaterModule moveToNextValue;
        public PlayStoreReviewModules scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ServiceComponentImpl implements ServiceComponent {
        private Provider<FeatureSplitBill> A;
        private Provider<ReadLinkPropertiesPresenter> ApiStatus$AvailableSince;
        private Provider<GetDefaultServiceWithCategory> AppCompatEmojiTextHelper;
        private Provider<UserEducationRepository> ArrayTable$3;
        private Provider<FeatureView> B;
        private Provider<ThirdPartyServicesMapper> BaseSocialFeedContract$Presenter;
        private Provider<GetAddingNameWhitelistedMerchantId> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private final ServicesModule CYFMonitor$ChallengeActionCallback;
        private Provider<ValidateNativelyDecodedQr> ConcurrentKt;
        private Provider<GetDecodeTciCoListConfig> D;
        private Provider<PlayStoreReviewPresenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<ClearCachePayLaterLoanWhitelist> DatabaseTableConfigUtil;
        private Provider<GetCheckoutH5Event> E;
        private Provider<GetFavoriteServiceRemote> F;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> FillAnimation;
        private Provider<IsNeedToShowPlayStoreReview> FlowViewUtil$textChanges$1;
        private Provider<MixpanelDeeplinkTracker> FlowViewUtil$textChanges$2;
        private Provider<ServiceCategoryMapper> FlowableConcatMapEagerPublisher;
        private Provider<CheckoutH5EventContract.View> FlowableCreate$BufferAsyncEmitter;
        private Provider<SavePaylaterRotationDelayTime> FlowableKt$toIterable$1;
        private Provider<PayLaterContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureConfigRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDecodedQrBarcode> G;
        private Provider<ConnectionStatusReceiver> GetContactSyncConfig;
        private Provider<GetEmptyUserInfo> H;
        private Provider<GetDecodedQrisTopUp> I;
        private Provider<RestoreUrl> InitSecurePreferenceAccount;
        private Provider<GetKycLevel> J;
        private Provider<RestoreUrlContract.View> JsonParseException;
        private Provider<GetFavoriteServiceWithCacheFirst> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetIsCardBindingV2Enabled> L;
        private Provider<GetFavoriteServices> M;
        private Provider<BottomSheetOnBoardingPresenter> MyBillsEntityDataFactory;
        private Provider<GetPayLaterCacheLoanWhitelist> N;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final CheckoutH5EventModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ScanQrPresenter> NewMerchantCategoryAdapter;
        private Provider<GetMissionDetail> O;
        private Provider<OauthContract.Presenter> OtpRegistrationPresenter$input$1;
        private Provider<PlayStoreReviewRepository> OtpRegistrationPresenter$input$2;
        private Provider<GetNickname> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<DeepLinkPayloadModelMapper> PrepareContext;
        private Provider<SSLPinningRepository> PromoCategoryPresenter$1;
        private Provider<GetNearbyConfig> Q;
        private Provider<GetSplitBillConfig> QrExpiredActivity;
        private Provider<GetPayerSplitBillDetail> R;
        private Provider<SaveLastPlayStoreReviewShow> ReferralMapper_Factory;
        private Provider<FeatureContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetQrBindingConfig> S;
        private Provider<UpdateServiceHighlighted> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<ThreadExecutor> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<SaveDisplayBottomSheetOnBoarding> SendMoneyScenario;
        private Provider<ProductPageManager> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<UserRepository> f5881x461046d9;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetMerchantQrWhitelist> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetPromoCenterVersion> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetPaylaterRotationDelayTime> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetRequestMoneyInfoFeature> T;
        private Provider<IsNativeDecodeEnabled> TypeProjectionImpl;
        private Provider<FamilyAccountRepository> TypefaceCompatApi26Impl;
        private Provider<GetQrisCpmSendmoneyConfig> U;
        private Provider<GetReferralConsult> V;
        private Provider<GenerateReferralDeepLink> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetServiceHighlighted> W;
        private Provider<ShortenerRepository> WrappedDrawableState;
        private Provider<GetRawServices> X;
        private Provider<GetServicesByKey> Y;
        private Provider<GetSettingByKey> Z;

        /* renamed from: a */
        private Provider<GetUserInfoWithKyc> f8159a;
        private Provider<RestoreUrlPresenter> access$getCapacity$p;
        private Provider<SaveShowDialog> access$setShowcaseShowing$p;
        private Provider<OauthPresenter> access$throwIllegalArgumentType;
        private Provider<SplitBillRepository> applyTrimPathIfNeeded;
        private Provider<GetUserLoanInfo> b;
        private Provider<GetUpdateAvailability> c;
        private Provider<ReadDeepLinkProperties> checkRegisteredUserAndSendOtp;
        private Provider<LiteAccountRepository> connectForeground;
        private Provider<UserConsentRepository> containsObjectForKey;
        private Provider<GetUserId> d;
        private Provider<GetWhitelistedSubMerchantId> e;
        private Provider<ServicesRepository> encodingStream;
        private Provider<H5EventRepository> f;
        private Provider<GetService> flip;
        private Provider<GetUserStatusInfo> g;
        private Provider<CheckConsultFamilyAccount> getAuthRequestContext;
        private Provider<FeaturePushVerify> getCallingPid;
        private Provider<ReadLinkPropertiesContract.Presenter> getCardNumberOCR;
        private Provider<ServicesContract.View> getContainerAuth;
        private Provider<ScanQrContract.View> getDefaultSenderId;
        private Provider<CheckDeepLinkActionVisibility> getErrorConfigVersion;
        private final ServiceComponentImpl getFontAssetManager;
        private Provider<QrBarcodeRepository> getIndexName;
        private Provider<GetFeedConfig> getNameOrBuilderList;
        private Provider<GetBottomSheetOnBoarding> getOnBoardingScenario;
        private Provider<SetPayLaterLoanCache> getRawPath;
        private Provider<ScanQrView> getReadyFragment;
        private Provider<FeatureSettingMore> getSupportButtonTintMode;
        private Provider<SplitBillHistoryToSplitBillModelMapper> getTextEndPadding;
        private Provider<GetAuthCode> getValueOfTouchPositionAbsolute;
        private Provider<IsNeedToShowToolTip> h;
        private Provider<IsOfflineF2FPay> i;
        private Provider<PlayStoreReviewContract.Presenter> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<SaveShowToolTip> insertActivities;
        private Provider<GetPayLaterLoanStatusWhitelist> isAuth;
        private Provider<GetServicesByName> isAuto;
        private Provider<UpdatePayLaterLoanCache> isInfoWindowShown;
        private Provider<DeviceInformationProvider> isLayoutRequested;
        private Provider<ServicesPresenter> isRegionMiniProgram;
        private Provider<OauthRepository> j;
        private Provider<MyReferralConsultRepository> k;
        private Provider<OauthView> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<MyReferralConsultMapper> m;
        private Provider<CheckFavoriteServicesFeature> moveToNextValue;
        private Provider<PayLaterPresenter> n;
        private Provider<FeatureCardBinding> newProxyInstance;

        /* renamed from: o */
        private final PayLaterModule f8160o;
        private Provider<FeatureContract.View> onDecodeSuccess;
        private Provider<PayerModelListMapper> p;
        private Provider<PromoQuestRepository> q;
        private Provider<PostExecutionThread> r;
        private Provider<FeatureServicesHandler> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<DeepLinkContract.View> f5882reduceIndexedz1zDJgo;
        private Provider<RestoreUrlView> retainOrRemoveAllInternal;
        private Provider<ScanResultMapper> rotateTo;
        private Provider<Activity> s;
        private Provider<CheckWhitelistedValidDomain> scheduleImpl;
        private Provider<OauthContract.View> secondaryHash;
        private Provider<ScanQrContract.Presenter> setNetAuthId;
        private Provider<GetServicesWithCategory> shouldRecycleViewType;
        private Provider<BottomSheetOnBoardingContract.Presenter> t;
        private Provider<CardBindingRepository> u;
        private Provider<SettingRepository> useDaemonThreadFactory;
        private Provider<PaylaterRepository> v;
        private Provider<PushVerifyTracker> verifyNotNull;
        private Provider<BottomSheetOnBoardingContract.View> w;
        private Provider<FeatureScanQR> whenAvailable;
        private Provider<FeedsConfigRepository> x;
        private Provider<RestoreUrlContract.Presenter> y;
        private Provider<PlayStoreReviewContract.View> z;

        public /* synthetic */ ServiceComponentImpl(PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent, byte b) {
            this(playStoreReviewModules, checkoutH5EventModule, bottomSheetOnBoardingModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, payLaterModule, applicationComponent);
        }

        private ServiceComponentImpl(PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PayLaterModule payLaterModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.getFontAssetManager = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = checkoutH5EventModule;
            this.CYFMonitor$ChallengeActionCallback = servicesModule;
            this.f8160o = payLaterModule;
            this.SecuritySettingsActivity$createPinLauncher$2$2 = new ThreadExecutorProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = new SSLPinningRepositoryProvider(applicationComponent);
            this.r = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, featureConfigRepositoryProvider);
            this.i = create;
            this.GetContactSyncConfig = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.SecuritySettingsActivity$createPinLauncher$2$2, this.PromoCategoryPresenter$1, create);
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.f = h5eventRepositoryProvider;
            this.E = GetCheckoutH5Event_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, h5eventRepositoryProvider);
            this.FlowableCreate$BufferAsyncEmitter = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$2 = playStoreReviewRepositoryProvider;
            this.FlowViewUtil$textChanges$1 = IsNeedToShowPlayStoreReview_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, playStoreReviewRepositoryProvider);
            this.ReferralMapper_Factory = SaveLastPlayStoreReviewShow_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.OtpRegistrationPresenter$input$2);
            Provider<PlayStoreReviewContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.z = authRequestContext;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.FlowViewUtil$textChanges$1, this.ReferralMapper_Factory, authRequestContext);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = MyBillsEntityDataFactory;
            this.initAnimators = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            this.getContainerAuth = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.j = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.containsObjectForKey = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.H = create2;
            this.getValueOfTouchPositionAbsolute = GetAuthCode_Factory.create(this.j, create2);
            ServiceCategoryMapper_Factory authRequestContext2 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.FlowableConcatMapEagerPublisher = authRequestContext2;
            this.BaseSocialFeedContract$Presenter = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.ArrayTable$3 = userEducationRepositoryProvider;
            this.h = IsNeedToShowToolTip_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, userEducationRepositoryProvider);
            this.insertActivities = SaveShowToolTip_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.ArrayTable$3);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.encodingStream = servicesRepositoryProvider;
            this.shouldRecycleViewType = GetServicesWithCategory_Factory.create(servicesRepositoryProvider);
            this.AppCompatEmojiTextHelper = GetDefaultServiceWithCategory_Factory.create(this.encodingStream);
            this.F = GetFavoriteServiceRemote_Factory.create(this.encodingStream);
            this.isAuto = GetServicesByName_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.encodingStream);
            this.Y = GetServicesByKey_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.encodingStream);
            this.M = GetFavoriteServices_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.encodingStream);
            this.moveToNextValue = CheckFavoriteServicesFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.X = GetRawServices_Factory.create(this.encodingStream);
            this.K = GetFavoriteServiceWithCacheFirst_Factory.create(this.encodingStream);
            this.W = GetServiceHighlighted_Factory.create(this.encodingStream);
            UpdateServiceHighlighted_Factory create3 = UpdateServiceHighlighted_Factory.create(this.encodingStream);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = create3;
            this.isRegionMiniProgram = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getContainerAuth, this.getValueOfTouchPositionAbsolute, this.BaseSocialFeedContract$Presenter, this.h, this.insertActivities, this.shouldRecycleViewType, this.AppCompatEmojiTextHelper, this.F, this.isAuto, this.Y, this.M, this.moveToNextValue, this.X, this.K, this.W, create3));
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.s = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.getReadyFragment = authRequestContext4;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.getIndexName = qrBarcodeRepositoryProvider;
            this.G = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.I = GetDecodedQrisTopUp_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.getIndexName);
            this.rotateTo = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.isLayoutRequested = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.f5881x461046d9 = userRepositoryProvider;
            this.g = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetCashierNativeConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.TypeProjectionImpl = IsNativeDecodeEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            GetDecodeTciCoListConfig_Factory create4 = GetDecodeTciCoListConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.D = create4;
            this.ConcurrentKt = ValidateNativelyDecodedQr_Factory.create(create4);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetMerchantQrWhitelist_Factory.create(this.getIndexName);
            this.S = GetQrBindingConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.FillAnimation = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.v = providePaylaterRepositoryProvider;
            this.b = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.U = GetQrisCpmSendmoneyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.ArrayTable$3);
            this.access$setShowcaseShowing$p = SaveShowDialog_Factory.create(this.ArrayTable$3);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getDefaultSenderId, this.G, this.I, this.rotateTo, this.isLayoutRequested, this.g, this.VerifyPinStateManager$executeRiskChallenge$2$2, GetNativelyDecodedQr_Factory.create(), this.TypeProjectionImpl, this.ConcurrentKt, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.S, this.FillAnimation, this.b, this.U, this.access$setShowcaseShowing$p));
            this.NewMerchantCategoryAdapter = authRequestContext5;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.retainOrRemoveAllInternal = authRequestContext6;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.WrappedDrawableState = shortenerRepositoryProvider;
            RestoreUrl_Factory create5 = RestoreUrl_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, shortenerRepositoryProvider);
            this.InitSecurePreferenceAccount = create5;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.JsonParseException, create5));
            this.access$getCapacity$p = authRequestContext7;
            this.y = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.k = myReferralConsultRepositoryProvider;
            this.V = GetReferralConsult_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.m = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GenerateReferralDeepLink_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.useDaemonThreadFactory = settingRepositoryProvider;
            this.Z = GetSettingByKey_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.SizeSelectors$OrSelector = productPageManagerProvider;
            this.getSupportButtonTintMode = FeatureSettingMore_Factory.PlaceComponentResult(this.Z, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.applyTrimPathIfNeeded = splitBillRepositoryProvider;
            this.R = GetPayerSplitBillDetail_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, splitBillRepositoryProvider);
            this.p = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.p);
            this.getTextEndPadding = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.R, PlaceComponentResult);
            this.QrExpiredActivity = GetSplitBillConfig_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.FragmentBottomSheetPaymentSettingBinding);
            GetRequestMoneyInfoFeature_Factory create6 = GetRequestMoneyInfoFeature_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.FragmentBottomSheetPaymentSettingBinding);
            this.T = create6;
            Provider<GetSplitBillConfig> provider = this.QrExpiredActivity;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.A = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create6, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.q = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create7 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.O = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeaturePromoQuest_Factory.getAuthRequestContext(create7, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory2 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.FlowViewUtil$textChanges$2 = MyBillsEntityDataFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = provideFamilyAccountRepositoryProvider;
            this.getAuthRequestContext = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.u = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.L = BuiltInFictitiousFunctionClassFactory;
            this.newProxyInstance = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.FlowViewUtil$textChanges$2));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.V, this.lookAheadTest, this.m, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.getSupportButtonTintMode, this.SubSequence, this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.whenAvailable, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda6, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.newProxyInstance, this.b, FeatureMyBills_Factory.PlaceComponentResult(), this.getCallingPid));
            this.B = authRequestContext8;
            Provider<FeatureContract.View> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            this.onDecodeSuccess = authRequestContext9;
            this.readMicros = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext9, this.Y, this.BaseSocialFeedContract$Presenter, this.getValueOfTouchPositionAbsolute, this.isLayoutRequested));
            this.getErrorConfigVersion = CheckDeepLinkActionVisibility_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.FragmentBottomSheetPaymentSettingBinding);
            this.scheduleImpl = CheckWhitelistedValidDomain_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.Q = GetNearbyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.x = provideFeedsConfigRepositoryProvider;
            this.getNameOrBuilderList = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetPromoCenterVersion_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.c = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckMyBillsVersionConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.verifyNotNull = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.encodingStream);
            this.flip = create8;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.onDecodeSuccess, this.readMicros, this.getErrorConfigVersion, this.scheduleImpl, this.Q, this.getNameOrBuilderList, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.c, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.verifyNotNull, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext10;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.l = authRequestContext11;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.J = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.f8159a = GetUserInfoWithKyc_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.f5881x461046d9);
            this.P = GetNickname_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.BuiltInFictitiousFunctionClassFactory);
            this.e = GetWhitelistedSubMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            Provider<OauthContract.View> provider2 = this.secondaryHash;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.J, this.f8159a, this.P, this.e, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.access$throwIllegalArgumentType = KClassImpl$Data$declaredNonStaticMembers$2;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.setNetAuthId, this.y, this.RequestMoneyQrContract$View, this.OtpRegistrationPresenter$input$1, this.isRegionMiniProgram, applicationProvider, this.b));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = authRequestContext12;
            this.f5882reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.checkRegisteredUserAndSendOtp = ReadDeepLinkProperties_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.PrepareContext = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.connectForeground = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, liteAccountRepositoryProvider);
            this.d = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.f5882reduceIndexedz1zDJgo, this.checkRegisteredUserAndSendOtp, this.PrepareContext, create9, this.FlowViewUtil$textChanges$2));
            this.ApiStatus$AvailableSince = authRequestContext13;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
            this.w = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.getOnBoardingScenario = GetBottomSheetOnBoarding_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.ArrayTable$3);
            SaveDisplayBottomSheetOnBoarding_Factory create10 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2, this.r, this.ArrayTable$3);
            this.SendMoneyScenario = create10;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.w, this.getOnBoardingScenario, create10);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
            this.t = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory2));
            this.FlowableReduce$ReduceSubscriber = PayLaterModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(payLaterModule);
            this.DatabaseTableConfigUtil = ClearCachePayLaterLoanWhitelist_Factory.create(this.v, this.encodingStream);
            this.N = GetPayLaterCacheLoanWhitelist_Factory.create(this.v);
            this.FlowableKt$toIterable$1 = SavePaylaterRotationDelayTime_Factory.create(this.v);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetPaylaterRotationDelayTime_Factory.create(this.v);
            this.isAuth = GetPayLaterLoanStatusWhitelist_Factory.create(this.v);
            this.isInfoWindowShown = UpdatePayLaterLoanCache_Factory.create(this.v, this.encodingStream);
            SetPayLaterLoanCache_Factory create11 = SetPayLaterLoanCache_Factory.create(this.v, this.encodingStream);
            this.getRawPath = create11;
            this.n = DoubleCheck.getAuthRequestContext(PayLaterPresenter_Factory.getAuthRequestContext(this.FlowableReduce$ReduceSubscriber, this.DatabaseTableConfigUtil, this.N, this.b, this.FlowableKt$toIterable$1, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.isAuth, this.isInfoWindowShown, create11));
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
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.Z());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
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
            private final ApplicationComponent PlaceComponentResult;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BannerEntityDataFactory_Factory());
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
            private final ApplicationComponent PlaceComponentResult;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ConcurrentKt());
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
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$throwIllegalArgumentType());
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
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.ServiceComponent
        public final void PlaceComponentResult(ServicesActivity servicesActivity) {
            ((BaseActivity) servicesActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesActivity, DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(servicesActivity, DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding));
            ServicesActivity_MembersInjector.MyBillsEntityDataFactory(servicesActivity, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            ServicesActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesActivity, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.E), DoubleCheck.MyBillsEntityDataFactory(this.FlowableCreate$BufferAsyncEmitter))));
            ServicesActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesActivity, this.initAnimators.get());
            ServicesActivity_MembersInjector.MyBillsEntityDataFactory(servicesActivity, ServicesModule_ProvidePresenterFactory.getAuthRequestContext(this.CYFMonitor$ChallengeActionCallback, this.isRegionMiniProgram.get()));
            ServicesActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesActivity, this.getCardNumberOCR.get());
            servicesActivity.onBoardingServicePresenter = this.t.get();
            ServicesActivity_MembersInjector.PlaceComponentResult(servicesActivity, PayLaterModule_ProvidePresenter$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.f8160o, this.n.get()));
            ServicesActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(servicesActivity, this.RequestMoneyQrContract$View.get());
        }
    }
}
