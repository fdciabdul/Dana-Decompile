package id.dana.expresspurchase.di;

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
import id.dana.cancelsurvey.di.CancelSurveyModule;
import id.dana.cancelsurvey.di.CancelSurveyModule_ProvideCancelSurveyPresenterFactory;
import id.dana.cancelsurvey.di.CancelSurveyModule_ProvideCancelSurveyViewFactory;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.cancelsurvey.presenter.CancelSurveyPresenter;
import id.dana.cancelsurvey.presenter.CancelSurveyPresenter_Factory;
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
import id.dana.data.toggle.SplitFacade;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ExpressPurchaseAnalyticModule;
import id.dana.di.modules.ExpressPurchaseAnalyticModule_ProvideExpressPurchaseAnalyticTrackerFactory;
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
import id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason;
import id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason_Factory;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason_Factory;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.expresspurchase.interaction.DealsExpressOrderQueryByCondition;
import id.dana.domain.expresspurchase.interaction.DealsExpressOrderQueryByCondition_Factory;
import id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase_Factory;
import id.dana.domain.expresspurchase.interaction.GetDealsShopLocation;
import id.dana.domain.expresspurchase.interaction.GetDealsShopLocation_Factory;
import id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase_Factory;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyDeals_Factory;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyGold;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyGold_Factory;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyInsurance_Factory;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference_Factory;
import id.dana.domain.expresspurchase.interaction.ValidateGoldProduct;
import id.dana.domain.expresspurchase.interaction.ValidateGoldProduct_Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
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
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.presenter.ExpressPurchasePresenter;
import id.dana.expresspurchase.presenter.ExpressPurchasePresenter_Factory;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.expresspurchase.view.ExpressPurchaseActivity_MembersInjector;
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

/* loaded from: classes5.dex */
public final class DaggerExpressPurchaseComponent {
    private DaggerExpressPurchaseComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public ExpressPurchaseAnalyticModule MyBillsEntityDataFactory;
        public FeatureModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public CancelSurveyModule PlaceComponentResult;
        public ExpressPurchaseModule getAuthRequestContext;
        public ServicesModule getErrorConfigVersion;
        public RestoreUrlModule lookAheadTest;
        public OauthModule moveToNextValue;
        public ScanQrModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ExpressPurchaseComponentImpl implements ExpressPurchaseComponent {
        private Provider<FeatureServicesHandler> A;
        private Provider<RestoreUrlPresenter> ApiStatus$AvailableSince;
        private Provider<GetDecodeTciCoListConfig> AppCompatEmojiTextHelper;
        private Provider<FeatureSplitBill> B;
        private Provider<UserRepository> BaseSocialFeedContract$Presenter;
        private Provider<FeatureSplitBillPay> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CancelSurveyPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureScanQR> C;
        private Provider<ServicesRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<GenerateReferralDeepLink> D;
        private Provider<OauthPresenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DanaCustomH5> DatabaseTableConfigUtil;
        private Provider<GetAddingNameWhitelistedMerchantId> E;
        private Provider<GetAuthCode> F;
        private Provider<GetUserInfoWithKyc> FillAnimation;
        private Provider<GetWhitelistedSubMerchantId> FlowViewUtil$textChanges$1;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> FlowViewUtil$textChanges$2;
        private Provider<SplitBillRepository> FlowableConcatMapEagerPublisher;
        private Provider<ReadLinkPropertiesContract.Presenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<ServiceCategoryMapper> FlowableKt$toIterable$1;
        private Provider<ScanQrContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureConfigRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDealsShopLocation> G;
        private Provider<ConsultCancelSurveyReason> GetContactSyncConfig;
        private Provider<GetDecodedQrBarcode> H;
        private Provider<GetCashierNativeConfig> I;
        private Provider<SaveShowDialog> InitSecurePreferenceAccount;
        private Provider<GetFavoriteServiceWithCacheFirst> J;
        private Provider<RestoreUrlContract.View> JsonParseException;
        private Provider<GetEmptyUserInfo> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetDefaultServiceWithCategory> L;
        private Provider<GetDecodedQrisTopUp> M;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetMerchantQrWhitelist> N;
        private Provider<CheckFavoriteServicesFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DealsExpressOrderQueryByCondition> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ExpressPurchasePresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private final ExpressPurchaseComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ExpressPurchaseRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private final ExpressPurchaseAnalyticModule NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ScanQrPresenter> NewMerchantCategoryAdapter;
        private Provider<GetFeedConfig> O;
        private Provider<SplitFacade> OtpRegistrationPresenter$input$1;
        private Provider<PayerModelListMapper> OtpRegistrationPresenter$input$2;
        private Provider<GetKycLevel> P;
        private Provider<CheckConsultFamilyAccount> PlaceComponentResult;
        private Provider<DeviceInformationProvider> PrepareContext;
        private Provider<SSLPinningRepository> PromoCategoryPresenter$1;
        private Provider<GetIsCardBindingV2Enabled> Q;
        private Provider<GetServicesByKey> QrExpiredActivity;
        private Provider<GetNearbyConfig> R;
        private Provider<SaveLastActionToPreference> ReferralMapper_Factory;
        private Provider<ExpressPurchaseContract.Presenter> RequestMoneyQrContract$View;
        private Provider<GetMissionDetail> S;
        private Provider<UserEducationRepository> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<ValidateNativelyDecodedQr> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<SaveShowToolTip> SendMoneyScenario;
        private Provider<ProductPageManager> SizeSelectors$OrSelector;
        private Provider<FeaturePushVerify> SubSequence;
        private Provider<GetFavoriteServices> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetPayerSplitBillDetail> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetQrBindingConfig> T;
        private Provider<GetUserLoanInfo> TypeProjectionImpl;
        private Provider<FeedsConfigRepository> TypefaceCompatApi26Impl;
        private Provider<GetPromoCenterVersion> U;
        private Provider<GetQrisCpmSendmoneyConfig> V;
        private Provider<FeatureSettingMore> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetAddOnOfferExpressPurchase> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetQuickBuyDeals> W;
        private Provider<UpdateServiceHighlighted> WrappedDrawableState;
        private Provider<GetQuickBuyGold> X;
        private Provider<GetRequestMoneyInfoFeature> Y;
        private Provider<GetQuickBuyInsurance> Z;

        /* renamed from: a */
        private Provider<GetSettingByKey> f8191a;
        private Provider<ReadLinkPropertiesPresenter> access$getCapacity$p;
        private Provider<ScanQrView> access$setShowcaseShowing$p;
        private Provider<LiteAccountRepository> access$throwIllegalArgumentType;
        private Provider<ValidateGoldProduct> applyTrimPathIfNeeded;
        private Provider<GetServicesByName> b;
        private Provider<GetServicesWithCategory> c;
        private Provider<QrBarcodeRepository> checkRegisteredUserAndSendOtp;
        private Provider<IsNeedToShowToolTip> connectForeground;
        private Provider<GetService> d;
        private Provider<GetUpdateAvailability> e;
        private Provider<ThirdPartyServicesMapper> encodingStream;
        private Provider<GetUserId> f;
        private Provider<GetRawServices> flip;
        private Provider<GetSplitBillConfig> g;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<FeaturePresenter> getCallingPid;
        private Provider<ExpressPurchaseContract.View> getCardNumberOCR;
        private Provider<OauthContract.View> getContainerAuth;
        private Provider<DeepLinkContract.View> getDefaultSenderId;
        private Provider<CheckWhitelistedValidDomain> getErrorConfigVersion;
        private Provider<SettingRepository> getFontAssetManager;
        private Provider<RestoreUrl> getIndexName;
        private Provider<GetFavoriteServiceRemote> getNameOrBuilderList;
        private Provider<GenerateLinkRepository> getOnBoardingScenario;
        private Provider<ThreadExecutor> getRawPath;
        private Provider<ServicesPresenter> getReadyFragment;
        private Provider<FeatureOauth> getSupportButtonTintMode;
        private Provider<UserConsentRepository> getTextEndPadding;
        private Provider<FeatureView> getValueOfTouchPositionAbsolute;
        private Provider<IsNativeDecodeEnabled> h;
        private Provider<GetUserStatusInfo> i;
        private Provider<FeatureContract.Presenter> initAnimators;
        private Provider<ConnectionStatusReceiver> initRecordTimeStamp;
        private Provider<ScanResultMapper> insertActivities;
        private Provider<GetPaylaterOfferExpressPurchase> isAuth;
        private Provider<GetServiceHighlighted> isAuto;
        private Provider<DeepLinkView> isLayoutRequested;
        private Provider<SplitBillHistoryToSplitBillModelMapper> isRegionMiniProgram;
        private Provider<IsOfflineF2FPay> j;
        private Provider<MyReferralConsultMapper> k;
        private Provider<MixpanelDeeplinkTracker> l;
        private Provider<CheckShowReferralCodeFeature> lookAheadTest;
        private Provider<MyReferralConsultRepository> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<PostExecutionThread> n;
        private Provider<DynamicUrlWrapper> newProxyInstance;

        /* renamed from: o */
        private Provider<OauthRepository> f8192o;
        private Provider<ServicesContract.View> onDecodeSuccess;
        private Provider<OauthView> p;
        private Provider<PromoQuestRepository> q;
        private Provider<CancelSurveyContract.Presenter> r;
        private Provider<FeaturePromoQuest> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ReadDeepLinkProperties> f5888reduceIndexedz1zDJgo;
        private Provider<RestoreUrlView> retainOrRemoveAllInternal;
        private Provider<ShortenerRepository> rotateTo;
        private Provider<Activity> s;
        private Provider<CheckDeepLinkActionVisibility> scheduleImpl;
        private Provider<FeatureContract.View> secondaryHash;
        private Provider<OauthContract.Presenter> setNetAuthId;
        private Provider<GetReferralConsult> shouldRecycleViewType;
        private Provider<CancelSurveyRepository> t;
        private Provider<CardBindingRepository> u;
        private Provider<SubmitCancelSurveyReason> useDaemonThreadFactory;
        private Provider<PaylaterRepository> v;
        private Provider<PushVerifyTracker> verifyNotNull;
        private Provider<CancelSurveyContract.View> w;
        private Provider<FeatureFamilyAccount> whenAvailable;
        private Provider<FamilyAccountRepository> x;
        private Provider<RestoreUrlContract.Presenter> y;
        private Provider<ScanQrContract.Presenter> z;

        public /* synthetic */ ExpressPurchaseComponentImpl(ExpressPurchaseModule expressPurchaseModule, CancelSurveyModule cancelSurveyModule, ExpressPurchaseAnalyticModule expressPurchaseAnalyticModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(expressPurchaseModule, cancelSurveyModule, expressPurchaseAnalyticModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private ExpressPurchaseComponentImpl(ExpressPurchaseModule expressPurchaseModule, CancelSurveyModule cancelSurveyModule, ExpressPurchaseAnalyticModule expressPurchaseAnalyticModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = expressPurchaseAnalyticModule;
            this.getRawPath = new ThreadExecutorProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = new SSLPinningRepositoryProvider(applicationComponent);
            this.n = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getRawPath, this.n, featureConfigRepositoryProvider);
            this.j = create;
            this.initRecordTimeStamp = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getRawPath, this.PromoCategoryPresenter$1, create);
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(ExpressPurchaseModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(expressPurchaseModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ContextProvider(applicationComponent);
            ExpressPurchaseRepositoryProvider expressPurchaseRepositoryProvider = new ExpressPurchaseRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = expressPurchaseRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetAddOnOfferExpressPurchase_Factory.create(expressPurchaseRepositoryProvider);
            this.ReferralMapper_Factory = SaveLastActionToPreference_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.Z = GetQuickBuyInsurance_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.W = GetQuickBuyDeals_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.applyTrimPathIfNeeded = ValidateGoldProduct_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            OauthRepositoryProvider oauthRepositoryProvider = new OauthRepositoryProvider(applicationComponent);
            this.f8192o = oauthRepositoryProvider;
            this.X = GetQuickBuyGold_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, oauthRepositoryProvider);
            this.OtpRegistrationPresenter$input$1 = new ProvideSplitFacadeProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getTextEndPadding = userConsentRepositoryProvider;
            this.isAuth = GetPaylaterOfferExpressPurchase_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6, userConsentRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DealsExpressOrderQueryByCondition_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            GetDealsShopLocation_Factory create2 = GetDealsShopLocation_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.G = create2;
            Provider<ExpressPurchasePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(ExpressPurchasePresenter_Factory.PlaceComponentResult(this.getCardNumberOCR, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.ReferralMapper_Factory, this.Z, this.W, this.applyTrimPathIfNeeded, this.X, this.OtpRegistrationPresenter$input$1, this.isAuth, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext;
            this.RequestMoneyQrContract$View = DoubleCheck.getAuthRequestContext(ExpressPurchaseModule_ProvidePresenterFactory.getAuthRequestContext(expressPurchaseModule, authRequestContext));
            this.w = DoubleCheck.getAuthRequestContext(CancelSurveyModule_ProvideCancelSurveyViewFactory.BuiltInFictitiousFunctionClassFactory(cancelSurveyModule));
            ProvideCancelSurveyRepositoryProvider provideCancelSurveyRepositoryProvider = new ProvideCancelSurveyRepositoryProvider(applicationComponent);
            this.t = provideCancelSurveyRepositoryProvider;
            this.GetContactSyncConfig = ConsultCancelSurveyReason_Factory.create(provideCancelSurveyRepositoryProvider);
            SubmitCancelSurveyReason_Factory create3 = SubmitCancelSurveyReason_Factory.create(this.t);
            this.useDaemonThreadFactory = create3;
            CancelSurveyPresenter_Factory authRequestContext2 = CancelSurveyPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.w, this.GetContactSyncConfig, create3);
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext2;
            this.r = DoubleCheck.getAuthRequestContext(CancelSurveyModule_ProvideCancelSurveyPresenterFactory.getAuthRequestContext(cancelSurveyModule, authRequestContext2));
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.s = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.access$setShowcaseShowing$p = authRequestContext4;
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.checkRegisteredUserAndSendOtp = qrBarcodeRepositoryProvider;
            this.H = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.M = GetDecodedQrisTopUp_Factory.create(this.getRawPath, this.n, this.checkRegisteredUserAndSendOtp);
            this.insertActivities = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.PrepareContext = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.BaseSocialFeedContract$Presenter = userRepositoryProvider;
            this.i = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            this.I = GetCashierNativeConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.h = IsNativeDecodeEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            GetDecodeTciCoListConfig_Factory create4 = GetDecodeTciCoListConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.AppCompatEmojiTextHelper = create4;
            this.SecuritySettingsActivity$createPinLauncher$2$2 = ValidateNativelyDecodedQr_Factory.create(create4);
            this.N = GetMerchantQrWhitelist_Factory.create(this.checkRegisteredUserAndSendOtp);
            this.T = GetQrBindingConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.FlowViewUtil$textChanges$2 = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.v = providePaylaterRepositoryProvider;
            this.TypeProjectionImpl = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = userEducationRepositoryProvider;
            this.V = GetQrisCpmSendmoneyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, userEducationRepositoryProvider);
            this.InitSecurePreferenceAccount = SaveShowDialog_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$1);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.FlowableReduce$ReduceSubscriber, this.H, this.M, this.insertActivities, this.PrepareContext, this.i, this.I, GetNativelyDecodedQr_Factory.create(), this.h, this.SecuritySettingsActivity$createPinLauncher$2$2, this.N, this.T, this.FlowViewUtil$textChanges$2, this.TypeProjectionImpl, this.V, this.InitSecurePreferenceAccount));
            this.NewMerchantCategoryAdapter = authRequestContext5;
            this.z = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            this.retainOrRemoveAllInternal = authRequestContext6;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.rotateTo = shortenerRepositoryProvider;
            RestoreUrl_Factory create5 = RestoreUrl_Factory.create(this.getRawPath, this.n, shortenerRepositoryProvider);
            this.getIndexName = create5;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.JsonParseException, create5));
            this.ApiStatus$AvailableSince = authRequestContext7;
            this.y = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.m = myReferralConsultRepositoryProvider;
            this.shouldRecycleViewType = GetReferralConsult_Factory.create(this.getRawPath, this.n, myReferralConsultRepositoryProvider);
            this.lookAheadTest = CheckShowReferralCodeFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.k = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = generateLinkRepositoryProvider;
            this.D = GenerateReferralDeepLink_Factory.create(this.getRawPath, this.n, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.getFontAssetManager = settingRepositoryProvider;
            this.f8191a = GetSettingByKey_Factory.create(this.getRawPath, this.n, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.SizeSelectors$OrSelector = productPageManagerProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FeatureSettingMore_Factory.PlaceComponentResult(this.f8191a, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.FlowableConcatMapEagerPublisher = splitBillRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetPayerSplitBillDetail_Factory.create(this.getRawPath, this.n, splitBillRepositoryProvider);
            this.OtpRegistrationPresenter$input$2 = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.OtpRegistrationPresenter$input$2);
            this.isRegionMiniProgram = PlaceComponentResult;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.SummaryVoucherView$$ExternalSyntheticLambda2, PlaceComponentResult);
            this.g = GetSplitBillConfig_Factory.create(this.getRawPath, this.n, this.FragmentBottomSheetPaymentSettingBinding);
            GetRequestMoneyInfoFeature_Factory create6 = GetRequestMoneyInfoFeature_Factory.create(this.getRawPath, this.n, this.FragmentBottomSheetPaymentSettingBinding);
            this.Y = create6;
            Provider<GetSplitBillConfig> provider = this.g;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.B = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create6, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.q = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create7 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.S = create7;
            this.readMicros = FeaturePromoQuest_Factory.getAuthRequestContext(create7, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.C = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.l = MyBillsEntityDataFactory;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.x = provideFamilyAccountRepositoryProvider;
            this.PlaceComponentResult = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.newProxyInstance = dynamicUrlWrapperProvider;
            this.whenAvailable = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.u = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.Q = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.SubSequence = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.l));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.shouldRecycleViewType, this.lookAheadTest, this.k, this.D, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.B, this.readMicros, this.C, this.DatabaseTableConfigUtil, FeatureHome_Factory.MyBillsEntityDataFactory(), this.getSupportButtonTintMode, FeatureKyb_Factory.getAuthRequestContext(), this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.TypeProjectionImpl, FeatureMyBills_Factory.PlaceComponentResult(), this.SubSequence));
            this.getValueOfTouchPositionAbsolute = authRequestContext8;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = servicesRepositoryProvider;
            this.QrExpiredActivity = GetServicesByKey_Factory.create(this.getRawPath, this.n, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext9 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.FlowableKt$toIterable$1 = authRequestContext9;
            this.encodingStream = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext9);
            GetEmptyUserInfo_Factory create8 = GetEmptyUserInfo_Factory.create(this.getTextEndPadding);
            this.K = create8;
            GetAuthCode_Factory create9 = GetAuthCode_Factory.create(this.f8192o, create8);
            this.F = create9;
            this.A = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.secondaryHash, this.QrExpiredActivity, this.encodingStream, create9, this.PrepareContext));
            this.scheduleImpl = CheckDeepLinkActionVisibility_Factory.create(this.getRawPath, this.n, this.FragmentBottomSheetPaymentSettingBinding);
            this.getErrorConfigVersion = CheckWhitelistedValidDomain_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.R = GetNearbyConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = provideFeedsConfigRepositoryProvider;
            this.O = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.U = GetPromoCenterVersion_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.e = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.verifyNotNull = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create10 = GetService_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.d = create10;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.secondaryHash, this.A, this.scheduleImpl, this.getErrorConfigVersion, this.R, this.O, this.U, this.e, this.moveToNextValue, this.verifyNotNull, create10));
            this.getCallingPid = authRequestContext10;
            this.initAnimators = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.getSupportButtonTintMode);
            this.p = authRequestContext11;
            this.getContainerAuth = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            this.P = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.FillAnimation = GetUserInfoWithKyc_Factory.create(this.getRawPath, this.n, this.BaseSocialFeedContract$Presenter);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetNickname_Factory.create(this.getRawPath, this.n, this.getAuthRequestContext);
            this.FlowViewUtil$textChanges$1 = GetWhitelistedSubMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.E = GetAddingNameWhitelistedMerchantId_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            Provider<OauthContract.View> provider2 = this.getContainerAuth;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.P, this.FillAnimation, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.FlowViewUtil$textChanges$1, this.E);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = KClassImpl$Data$declaredNonStaticMembers$2;
            this.setNetAuthId = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.onDecodeSuccess = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.connectForeground = IsNeedToShowToolTip_Factory.create(this.getRawPath, this.n, this.SecuritySettingsActivity$createPinLauncher$2$1);
            this.SendMoneyScenario = SaveShowToolTip_Factory.create(this.getRawPath, this.n, this.SecuritySettingsActivity$createPinLauncher$2$1);
            this.c = GetServicesWithCategory_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.L = GetDefaultServiceWithCategory_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.getNameOrBuilderList = GetFavoriteServiceRemote_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.b = GetServicesByName_Factory.create(this.getRawPath, this.n, this.CYFMonitor$ChallengeActionCallback);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetFavoriteServices_Factory.create(this.getRawPath, this.n, this.CYFMonitor$ChallengeActionCallback);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckFavoriteServicesFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.flip = GetRawServices_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.J = GetFavoriteServiceWithCacheFirst_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.isAuto = GetServiceHighlighted_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            UpdateServiceHighlighted_Factory create11 = UpdateServiceHighlighted_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            this.WrappedDrawableState = create11;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.onDecodeSuccess, this.F, this.encodingStream, this.connectForeground, this.SendMoneyScenario, this.c, this.L, this.getNameOrBuilderList, this.b, this.QrExpiredActivity, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.flip, this.J, this.isAuto, create11));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.z, this.y, this.initAnimators, this.setNetAuthId, this.getReadyFragment, applicationProvider, this.TypeProjectionImpl));
            this.isLayoutRequested = authRequestContext12;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.f5888reduceIndexedz1zDJgo = ReadDeepLinkProperties_Factory.create(this.getRawPath, this.n);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = liteAccountRepositoryProvider;
            GetUserId_Factory create12 = GetUserId_Factory.create(this.getRawPath, this.n, liteAccountRepositoryProvider);
            this.f = create12;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.getDefaultSenderId, this.f5888reduceIndexedz1zDJgo, this.NetworkUserEntityData$$ExternalSyntheticLambda7, create12, this.l));
            this.access$getCapacity$p = authRequestContext13;
            this.FlowableCreate$BufferAsyncEmitter = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class ExpressPurchaseRepositoryProvider implements Provider<ExpressPurchaseRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ExpressPurchaseRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ExpressPurchaseRepository get() {
                return (ExpressPurchaseRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.newProxyInstance());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideSplitFacadeProvider implements Provider<SplitFacade> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideSplitFacadeProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitFacade get() {
                return (SplitFacade) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.secondaryHash());
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
        public static final class ProvideCancelSurveyRepositoryProvider implements Provider<CancelSurveyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideCancelSurveyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CancelSurveyRepository get() {
                return (CancelSurveyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypeProjectionImpl());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ConcurrentKt());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        @Override // id.dana.expresspurchase.di.ExpressPurchaseComponent
        public final void getAuthRequestContext(ExpressPurchaseActivity expressPurchaseActivity) {
            ((BaseActivity) expressPurchaseActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(expressPurchaseActivity, DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(expressPurchaseActivity, DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding));
            expressPurchaseActivity.expressPurchasePresenter = this.RequestMoneyQrContract$View.get();
            expressPurchaseActivity.cancelSurveyPresenter = this.r.get();
            expressPurchaseActivity.readDeepLinkPropertiesPresenter = this.FlowableCreate$BufferAsyncEmitter.get();
            ExpressPurchaseActivity_MembersInjector.getAuthRequestContext(expressPurchaseActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext()));
            ExpressPurchaseActivity_MembersInjector.PlaceComponentResult(expressPurchaseActivity, ExpressPurchaseAnalyticModule_ProvideExpressPurchaseAnalyticTrackerFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8, (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue())));
        }
    }
}
