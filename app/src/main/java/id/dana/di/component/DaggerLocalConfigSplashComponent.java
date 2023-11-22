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
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pin.LogoutPresenter;
import id.dana.challenge.pin.LogoutPresenter_Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.DeepLinkModule_ProvidePresenterFactory;
import id.dana.contract.deeplink.DeepLinkModule_ProvideViewFactory;
import id.dana.contract.deeplink.DeepLinkPresenter;
import id.dana.contract.deeplink.DeepLinkPresenter_Factory;
import id.dana.contract.deeplink.DeepLinkView;
import id.dana.contract.deeplink.DeepLinkView_Factory;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.FeatureModule_ProvidePresenterFactory;
import id.dana.contract.deeplink.FeatureModule_ProvideViewFactory;
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
import id.dana.contract.deeplink.tracker.DeeplinkTrackerFactory;
import id.dana.contract.deeplink.tracker.DeeplinkTrackerFactory_Factory;
import id.dana.contract.deeplink.tracker.FullstoryDeeplinkTracker_Factory;
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
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.LocalConfigSplashModule;
import id.dana.di.modules.LocalConfigSplashModule_ProvidesNewPresenterFactory;
import id.dana.di.modules.LocalConfigSplashModule_ProvidesViewFactory;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.LogoutModule_ProvideLogoutPresenterFactory;
import id.dana.di.modules.LogoutModule_ProvideLogoutViewFactory;
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
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.InitSecurePreferenceAccount;
import id.dana.domain.account.interactor.InitSecurePreferenceAccount_Factory;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload_Factory;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink_Factory;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload_Factory;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount_Factory;
import id.dana.domain.featureconfig.AppGeneralRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.StartupConfigEntityData;
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
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch_Factory;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.here.interactor.InitHereConfig;
import id.dana.domain.here.interactor.InitHereConfig_Factory;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.CheckSession_Factory;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.login.interactor.NotifyPay;
import id.dana.domain.login.interactor.NotifyPay_Factory;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.login.interactor.SaveIsSessionChecked_Factory;
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
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
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
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.PinCertificates_Factory;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate_Factory;
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
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper_Factory;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.onboarding.splash.LocalConfigSplashActivity_MembersInjector;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.onboarding.splash.LocalConfigSplashPresenter;
import id.dana.onboarding.splash.LocalConfigSplashPresenter_Factory;
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
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerLocalConfigSplashComponent {
    private DaggerLocalConfigSplashComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public LogoutModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FeatureModule MyBillsEntityDataFactory;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public DeepLinkModule PlaceComponentResult;
        public LocalConfigSplashModule getAuthRequestContext;
        public ScanQrModule getErrorConfigVersion;
        public RestoreUrlModule moveToNextValue;
        public OauthModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class LocalConfigSplashComponentImpl implements LocalConfigSplashComponent {
        private Provider<FeatureConfigRepository> A;
        private Provider<PaylaterRepository> ApiStatus$AvailableSince;
        private Provider<FeatureView> AppCompatEmojiTextHelper;
        private Provider<SplitBillRepository> ArrayTable$1;
        private Provider<ThirdPartyServicesMapper> ArrayTable$2;
        private Provider<ShortenerRepository> ArrayTable$3;
        private Provider<FeatureOauth> B;
        private Provider<UserEducationRepository> BannerEntityDataFactory_Factory;
        private Provider<SaveShowDialog> BaseSocialFeedContract$Presenter;
        private Provider<FeatureFamilyAccount> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeaturePromoQuest> C;
        private Provider<LocalConfigSplashContract.View> CYFMonitor$ChallengeActionCallback;
        private Provider<ServicesPresenter> CheckPromoQuestFeature;
        private Provider<ServiceCategoryMapper> ConcurrentKt;
        private Provider<FeatureScanQR> D;
        private Provider<IsNativeDecodeEnabled> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<ClearAllDanapolyData> DatabaseTableConfigUtil;
        private Provider<UserRepository> DebugCoroutineInfoImpl;
        private Provider<FeatureSettingMore> E;
        private Provider<ForceLogout> F;
        private Provider<GetServicesWithCategory> FillAnimation;
        private Provider<UpdateServiceHighlighted> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetUserId> FlowViewUtil$textChanges$1;
        private Provider<GetUserLoanInfo> FlowViewUtil$textChanges$2;
        private Provider<RestoreUrlPresenter> FlowableConcatMapEagerPublisher;
        private Provider<PromoQuestRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<DeepLinkContract.View> FlowableKt$toIterable$1;
        private Provider<DanapolyClearRepository> FlowableReduce$ReduceSubscriber;
        private Provider<DanaSessionManager> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GenerateReferralDeepLink> G;
        private Provider<ClearAllFeedsUsecase> GetContactSyncConfig;
        private Provider<FeatureSplitBill> H;
        private Provider<GenerateLinkRepository> I;
        private Provider<PushVerifyTracker> InitSecurePreferenceAccount;
        private Provider<GetCashierNativeConfig> J;
        private Provider<LogoutContract.View> JsonParseException;
        private Provider<GetAddingNameWhitelistedMerchantId> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetDecodeTciCoListConfig> L;
        private Provider<GetAuthCode> M;
        private Provider<AppGeneralRepository> MyBillsEntityDataFactory;
        private Provider<GetDecodedQrisTopUp> N;
        private Provider<CheckMyBillsVersionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckWhitelistedValidDomain> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ClearCacheFavoriteServices> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DeepLinkRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<DeepLinkView> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DeepLinkPresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ClearKybData> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ServicesContract.View> NewMerchantCategoryAdapter;
        private Provider<GetDeepLinkPayload> O;
        private Provider<ProductPageManager> OtpRegistrationPresenter$input$1;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> OtpRegistrationPresenter$input$2;
        private Provider<GetEmptyUserInfo> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<DanaCustomH5> PrepareContext;
        private Provider<DeepLinkContract.Presenter> PromoCategoryPresenter$1;
        private Provider<GetDefaultServiceWithCategory> Q;
        private Provider<GetServiceHighlighted> QrExpiredActivity;
        private Provider<GetFeedConfig> R;
        private Provider<OauthContract.Presenter> ReferralMapper_Factory;
        private Provider<PostExecutionThread> RequestMoneyQrContract$View;
        private Provider<GetFavoriteServices> S;
        private Provider<ValidateNativelyDecodedQr> SchedulerPoolFactory;
        private Provider<ScanQrPresenter> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<ScanResultMapper> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<ScanQrContract.View> SendMoneyScenario;
        private Provider<Logout> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<SettingRepository> f5854x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<SplitBillHistoryToSplitBillModelMapper> f5855x461046da;
        private Provider<FeatureCardBinding> SubSequence;
        private Provider<GetFavoriteServiceRemote> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetKycLevel> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetFavoriteServiceWithCacheFirst> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetMerchantQrWhitelist> T;
        private Provider<GetUpdateAvailability> TypeProjectionImpl;
        private Provider<MyReferralConsultRepository> TypefaceCompatApi26Impl;
        private Provider<GetNickname> U;
        private Provider<GetNearbyConfig> V;
        private Provider<FeaturePresenter> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<FeaturePushVerify> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetMissionDetail> W;
        private Provider<ThreadExecutor> WithdrawSavedCardChannelView;
        private Provider<SSLPinningRepository> WrappedDrawableState;
        private Provider<GetPayerSplitBillDetail> X;
        private Provider<GetQrisCpmSendmoneyConfig> Y;
        private Provider<GetRawServices> Z;

        /* renamed from: a */
        private Provider<GetReferralConsult> f8126a;
        private Provider<FeatureContract.Presenter> access$getCapacity$p;
        private Provider<RestoreUrlContract.View> access$setShowcaseShowing$p;
        private Provider<IsAppFirstLaunch> access$throwIllegalArgumentType;
        private Provider<SaveShowToolTip> applyTrimPathIfNeeded;
        private Provider<GetRequestMoneyInfoFeature> b;
        private Provider<GetServicesByKey> c;
        private Provider<ScanQrContract.Presenter> checkRegisteredUserAndSendOtp;
        private Provider<GetUserInfoWithKyc> connectForeground;
        private Provider<ServicesRepository> containsObjectForKey;
        private Provider<GetService> d;
        private Provider<GetSplitBillConfig> e;
        private Provider<RestoreUrl> encodingStream;
        private Provider<GetSettingByKey> f;
        private Provider<GetPromoCenterVersion> flip;
        private Provider<GetServicesByName> g;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<FaceAuthPopUpConsultationRepository> getCallingPid;
        private Provider<Activity> getCardNumberOCR;
        private Provider<FeedInitRepository> getContainerAuth;
        private Provider<FeedsConfigRepository> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<LocalConfigSplashContract.Presenter> getFontAssetManager;
        private Provider<CardBindingRepository> getIndexName;
        private Provider<GetDecodedQrBarcode> getNameOrBuilderList;
        private Provider<FeatureServicesHandler> getOnBoardingScenario;
        private Provider<UserConsentRepository> getPhoneMask;
        private Provider<RestoreUrlView> getRawPath;
        private Provider<OauthContract.View> getReadyFragment;
        private Provider<DynamicUrlWrapper> getSupportButtonTintMode;
        private Provider<SSLPinningHotUpdate> getTextEndPadding;
        private Provider<FeatureSplitBillPay> getValueOfTouchPositionAbsolute;
        private Provider<GetWhitelistedSubMerchantId> h;
        private Provider<GetUserStatusInfo> i;
        private Provider<OauthRepository> initAnimators;
        private Provider<ClearAllSyncEngineUseCase> initRecordTimeStamp;
        private Provider<FeatureContract.View> insertActivities;
        private Provider<GetIsCardBindingV2Enabled> isAuth;
        private Provider<GetPhoneNumber> isAuto;
        private Provider<ScanQrView> isInfoWindowShown;
        private Provider<ClearFaceAuthSuggestionState> isLayoutRequested;
        private Provider<QrBarcodeRepository> isRegionMiniProgram;
        private Provider<InitSecurePreferenceAccount> j;
        private Provider<GlobalNetworkRepository> k;
        private Provider<InitSessionDeepLink> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<InitHereConfig> m;
        private Provider<CheckDeepLinkActionVisibility> moveToNextValue;
        private Provider<LiteAccountRepository> n;
        private Provider<ContactRepository> newProxyInstance;

        /* renamed from: o */
        private Provider<KybRepository> f8127o;
        private Provider<HomeWidgetClearable> onDecodeSuccess;
        private Provider<IsNeedToShowToolTip> p;
        private Provider<LogoutPresenter> q;
        private final LocalConfigSplashComponentImpl r;
        private Provider<DeeplinkTrackerFactory> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrlContract.Presenter> f5856reduceIndexedz1zDJgo;
        private Provider<StartupConfigEntityData> retainOrRemoveAllInternal;
        private Provider<RemoveDeepLinkPayload> rotateTo;
        private Provider<LocalConfigSplashPresenter> s;
        private Provider<CheckSession> scheduleImpl;
        private Provider<LogoutContract.Presenter> secondaryHash;
        private Provider<PinCertificates> setNetAuthId;
        private Provider<GetQrBindingConfig> shouldRecycleViewType;
        private Provider<LoginRepository> t;
        private Provider<MixpanelDeeplinkTracker> u;
        private Provider<SaveIsSessionChecked> useDaemonThreadFactory;
        private Provider<OauthPresenter> v;
        private Provider<FamilyAccountRepository> verifyNotNull;
        private Provider<MyReferralConsultMapper> w;
        private Provider<DeviceInformationProvider> whenAvailable;
        private Provider<NotifyPay> x;
        private Provider<PayerModelListMapper> y;
        private Provider<OauthView> z;

        public /* synthetic */ LocalConfigSplashComponentImpl(LocalConfigSplashModule localConfigSplashModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, LogoutModule logoutModule, ApplicationComponent applicationComponent, byte b) {
            this(localConfigSplashModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, logoutModule, applicationComponent);
        }

        private LocalConfigSplashComponentImpl(LocalConfigSplashModule localConfigSplashModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, LogoutModule logoutModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            FullstoryDeeplinkTracker_Factory fullstoryDeeplinkTracker_Factory;
            this.r = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.getCardNumberOCR = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.isInfoWindowShown = authRequestContext2;
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = qrBarcodeRepositoryProvider;
            this.getNameOrBuilderList = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.WithdrawSavedCardChannelView = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.RequestMoneyQrContract$View = postExecutionThreadProvider;
            this.N = GetDecodedQrisTopUp_Factory.create(this.WithdrawSavedCardChannelView, postExecutionThreadProvider, this.isRegionMiniProgram);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.whenAvailable = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.DebugCoroutineInfoImpl = userRepositoryProvider;
            this.i = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.A = featureConfigRepositoryProvider;
            this.J = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = IsNativeDecodeEnabled_Factory.create(this.A);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.A);
            this.L = create;
            this.SchedulerPoolFactory = ValidateNativelyDecodedQr_Factory.create(create);
            this.T = GetMerchantQrWhitelist_Factory.create(this.isRegionMiniProgram);
            this.shouldRecycleViewType = GetQrBindingConfig_Factory.create(this.A);
            this.OtpRegistrationPresenter$input$2 = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.A);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.ApiStatus$AvailableSince = providePaylaterRepositoryProvider;
            this.FlowViewUtil$textChanges$2 = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = userEducationRepositoryProvider;
            this.Y = GetQrisCpmSendmoneyConfig_Factory.create(this.A, userEducationRepositoryProvider);
            this.BaseSocialFeedContract$Presenter = SaveShowDialog_Factory.create(this.BannerEntityDataFactory_Factory);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.SendMoneyScenario, this.getNameOrBuilderList, this.N, this.SecuritySettingsActivity$createPinLauncher$2$2, this.whenAvailable, this.i, this.J, GetNativelyDecodedQr_Factory.create(), this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.SchedulerPoolFactory, this.T, this.shouldRecycleViewType, this.OtpRegistrationPresenter$input$2, this.FlowViewUtil$textChanges$2, this.Y, this.BaseSocialFeedContract$Presenter));
            this.SecuritySettingsActivity$createPinLauncher$2$1 = authRequestContext3;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.getRawPath = authRequestContext4;
            this.access$setShowcaseShowing$p = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.ArrayTable$3 = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, shortenerRepositoryProvider);
            this.encodingStream = create2;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.access$setShowcaseShowing$p, create2));
            this.FlowableConcatMapEagerPublisher = authRequestContext5;
            this.f5856reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = myReferralConsultRepositoryProvider;
            this.f8126a = GetReferralConsult_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.A);
            this.w = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.I = generateLinkRepositoryProvider;
            this.G = GenerateReferralDeepLink_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.f5854x461046d9 = settingRepositoryProvider;
            this.f = GetSettingByKey_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = productPageManagerProvider;
            this.E = FeatureSettingMore_Factory.PlaceComponentResult(this.f, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = splitBillRepositoryProvider;
            this.X = GetPayerSplitBillDetail_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, splitBillRepositoryProvider);
            this.y = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.y);
            this.f5855x461046da = PlaceComponentResult;
            this.getValueOfTouchPositionAbsolute = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.X, PlaceComponentResult);
            this.e = GetSplitBillConfig_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.A);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.A);
            this.b = create3;
            Provider<GetSplitBillConfig> provider = this.e;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.H = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.W = create4;
            this.C = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.D = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.PrepareContext = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.u = MyBillsEntityDataFactory;
            this.B = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.verifyNotNull = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.getSupportButtonTintMode = dynamicUrlWrapperProvider;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.getIndexName = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.isAuth = BuiltInFictitiousFunctionClassFactory;
            this.SubSequence = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.u));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.f8126a, this.lookAheadTest, this.w, this.G, this.E, this.getValueOfTouchPositionAbsolute, this.H, this.C, this.D, this.PrepareContext, FeatureHome_Factory.MyBillsEntityDataFactory(), this.B, FeatureKyb_Factory.getAuthRequestContext(), this.BottomSheetCardBindingView$watcherCardNumberView$1, this.SubSequence, this.FlowViewUtil$textChanges$2, FeatureMyBills_Factory.PlaceComponentResult(), this.VerifyPinStateManager$executeRiskChallenge$2$2));
            this.AppCompatEmojiTextHelper = authRequestContext6;
            this.insertActivities = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.containsObjectForKey = servicesRepositoryProvider;
            this.c = GetServicesByKey_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.ConcurrentKt = authRequestContext7;
            this.ArrayTable$2 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.initAnimators = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getPhoneMask = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.P = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.initAnimators, create5);
            this.M = create6;
            this.getOnBoardingScenario = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.insertActivities, this.c, this.ArrayTable$2, create6, this.whenAvailable));
            this.moveToNextValue = CheckDeepLinkActionVisibility_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.A);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckWhitelistedValidDomain_Factory.create(this.A);
            this.V = GetNearbyConfig_Factory.create(this.A);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = provideFeedsConfigRepositoryProvider;
            this.R = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.flip = GetPromoCenterVersion_Factory.create(this.A);
            this.TypeProjectionImpl = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckMyBillsVersionConfig_Factory.create(this.A);
            this.InitSecurePreferenceAccount = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.containsObjectForKey);
            this.d = create7;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.insertActivities, this.getOnBoardingScenario, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.V, this.R, this.flip, this.TypeProjectionImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.InitSecurePreferenceAccount, create7));
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = authRequestContext8;
            this.access$getCapacity$p = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.B);
            this.z = authRequestContext9;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.connectForeground = GetUserInfoWithKyc_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.DebugCoroutineInfoImpl);
            this.U = GetNickname_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.getAuthRequestContext);
            this.h = GetWhitelistedSubMerchantId_Factory.create(this.A);
            this.K = GetAddingNameWhitelistedMerchantId_Factory.create(this.A);
            Provider<OauthContract.View> provider2 = this.getReadyFragment;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.connectForeground, this.U, this.h, this.K);
            this.v = KClassImpl$Data$declaredNonStaticMembers$2;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.NewMerchantCategoryAdapter = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.p = IsNeedToShowToolTip_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.BannerEntityDataFactory_Factory);
            this.applyTrimPathIfNeeded = SaveShowToolTip_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.BannerEntityDataFactory_Factory);
            this.FillAnimation = GetServicesWithCategory_Factory.create(this.containsObjectForKey);
            this.Q = GetDefaultServiceWithCategory_Factory.create(this.containsObjectForKey);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetFavoriteServiceRemote_Factory.create(this.containsObjectForKey);
            this.g = GetServicesByName_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.containsObjectForKey);
            this.S = GetFavoriteServices_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.containsObjectForKey);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.A);
            this.Z = GetRawServices_Factory.create(this.containsObjectForKey);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetFavoriteServiceWithCacheFirst_Factory.create(this.containsObjectForKey);
            this.QrExpiredActivity = GetServiceHighlighted_Factory.create(this.containsObjectForKey);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.containsObjectForKey);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = create8;
            this.CheckPromoQuestFeature = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NewMerchantCategoryAdapter, this.M, this.ArrayTable$2, this.p, this.applyTrimPathIfNeeded, this.FillAnimation, this.Q, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.g, this.c, this.S, this.getErrorConfigVersion, this.Z, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.QrExpiredActivity, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.checkRegisteredUserAndSendOtp, this.f5856reduceIndexedz1zDJgo, this.access$getCapacity$p, this.ReferralMapper_Factory, this.CheckPromoQuestFeature, applicationProvider, this.FlowViewUtil$textChanges$2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext10;
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = deepLinkRepositoryProvider;
            this.l = InitSessionDeepLink_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, deepLinkRepositoryProvider);
            this.O = GetDeepLinkPayload_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.n = liteAccountRepositoryProvider;
            this.isAuto = GetPhoneNumber_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, liteAccountRepositoryProvider);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.rotateTo = RemoveDeepLinkPayload_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            Provider<MixpanelDeeplinkTracker> provider3 = this.u;
            fullstoryDeeplinkTracker_Factory = FullstoryDeeplinkTracker_Factory.InstanceHolder.getAuthRequestContext;
            DeeplinkTrackerFactory_Factory authRequestContext11 = DeeplinkTrackerFactory_Factory.getAuthRequestContext(provider3, fullstoryDeeplinkTracker_Factory);
            this.readMicros = authRequestContext11;
            Provider<DeepLinkPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.FlowableKt$toIterable$1, this.l, this.O, this.isAuto, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.rotateTo, authRequestContext11));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext12;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvidePresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext12));
            this.CYFMonitor$ChallengeActionCallback = DoubleCheck.getAuthRequestContext(LocalConfigSplashModule_ProvidesViewFactory.getAuthRequestContext(localConfigSplashModule));
            this.x = NotifyPay_Factory.create(this.n);
            AppGeneralRepositoryProvider appGeneralRepositoryProvider = new AppGeneralRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = appGeneralRepositoryProvider;
            this.access$throwIllegalArgumentType = IsAppFirstLaunch_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, appGeneralRepositoryProvider);
            SSLPinningRepositoryProvider sSLPinningRepositoryProvider = new SSLPinningRepositoryProvider(applicationComponent);
            this.WrappedDrawableState = sSLPinningRepositoryProvider;
            this.setNetAuthId = PinCertificates_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, sSLPinningRepositoryProvider);
            this.getTextEndPadding = SSLPinningHotUpdate_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.WrappedDrawableState);
            this.FlowViewUtil$textChanges$1 = GetUserId_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.n);
            LoginRepositoryProvider loginRepositoryProvider = new LoginRepositoryProvider(applicationComponent);
            this.t = loginRepositoryProvider;
            this.scheduleImpl = CheckSession_Factory.create(loginRepositoryProvider);
            this.j = InitSecurePreferenceAccount_Factory.create(this.n);
            this.useDaemonThreadFactory = SaveIsSessionChecked_Factory.create(this.t);
            this.retainOrRemoveAllInternal = new ProvideStartupConfigEntityDataProvider(applicationComponent);
            this.m = InitHereConfig_Factory.create(this.A);
            this.k = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.onDecodeSuccess = provideHomeWidgetClearableProvider;
            this.F = ForceLogout_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.t, this.k, provideHomeWidgetClearableProvider);
            this.SizeSelectors$OrSelector = Logout_Factory.create(this.WithdrawSavedCardChannelView, this.RequestMoneyQrContract$View, this.t, this.onDecodeSuccess, this.k);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.newProxyInstance = contractRepositoryProvider;
            this.initRecordTimeStamp = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.getContainerAuth = provideFeedInitRepositoryProvider;
            this.GetContactSyncConfig = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ClearCacheFavoriteServices_Factory.create(this.containsObjectForKey);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = provideDanapolyClearRepositoryProvider;
            this.DatabaseTableConfigUtil = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.f8127o = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext13 = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext13;
            DanaSessionManager_Factory authRequestContext14 = DanaSessionManager_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.whenAvailable, this.F, this.SizeSelectors$OrSelector, this.initRecordTimeStamp, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.DatabaseTableConfigUtil, authRequestContext13);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext14;
            Provider<LocalConfigSplashPresenter> authRequestContext15 = DoubleCheck.getAuthRequestContext(LocalConfigSplashPresenter_Factory.MyBillsEntityDataFactory(this.CYFMonitor$ChallengeActionCallback, this.x, this.access$throwIllegalArgumentType, this.setNetAuthId, this.getTextEndPadding, this.isAuto, this.rotateTo, this.FlowViewUtil$textChanges$1, this.scheduleImpl, this.j, this.useDaemonThreadFactory, this.retainOrRemoveAllInternal, this.m, authRequestContext14, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.s = authRequestContext15;
            this.getFontAssetManager = DoubleCheck.getAuthRequestContext(LocalConfigSplashModule_ProvidesNewPresenterFactory.MyBillsEntityDataFactory(localConfigSplashModule, authRequestContext15));
            this.JsonParseException = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutViewFactory.getAuthRequestContext(logoutModule));
            FaceAuthPopUpConsultationRepositoryProvider faceAuthPopUpConsultationRepositoryProvider = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.getCallingPid = faceAuthPopUpConsultationRepositoryProvider;
            ClearFaceAuthSuggestionState_Factory create9 = ClearFaceAuthSuggestionState_Factory.create(faceAuthPopUpConsultationRepositoryProvider);
            this.isLayoutRequested = create9;
            Provider<LogoutPresenter> authRequestContext16 = DoubleCheck.getAuthRequestContext(LogoutPresenter_Factory.getAuthRequestContext(this.JsonParseException, this.FragmentBottomSheetPaymentSettingBinding, create9));
            this.q = authRequestContext16;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(LogoutModule_ProvideLogoutPresenterFactory.BuiltInFictitiousFunctionClassFactory(logoutModule, authRequestContext16));
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
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.applyTrimPathIfNeeded());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.shouldRecycleViewType());
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
            private final ApplicationComponent getAuthRequestContext;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.z());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AppGeneralRepositoryProvider implements Provider<AppGeneralRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AppGeneralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AppGeneralRepository get() {
                return (AppGeneralRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideStartupConfigEntityDataProvider implements Provider<StartupConfigEntityData> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideStartupConfigEntityDataProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ StartupConfigEntityData get() {
                return (StartupConfigEntityData) Preconditions.PlaceComponentResult(this.getAuthRequestContext.onDecodeSuccess());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.PlaceComponentResult.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        @Override // id.dana.di.component.LocalConfigSplashComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(LocalConfigSplashActivity localConfigSplashActivity) {
            LocalConfigSplashActivity_MembersInjector.MyBillsEntityDataFactory(localConfigSplashActivity, DoubleCheck.MyBillsEntityDataFactory(this.PromoCategoryPresenter$1));
            LocalConfigSplashActivity_MembersInjector.PlaceComponentResult(localConfigSplashActivity, DoubleCheck.MyBillsEntityDataFactory(this.getFontAssetManager));
            LocalConfigSplashActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(localConfigSplashActivity, DoubleCheck.MyBillsEntityDataFactory(this.secondaryHash));
            LocalConfigSplashActivity_MembersInjector.getAuthRequestContext(localConfigSplashActivity, (LocationPermissionSubject) Preconditions.PlaceComponentResult(this.PlaceComponentResult.w()));
        }
    }
}
