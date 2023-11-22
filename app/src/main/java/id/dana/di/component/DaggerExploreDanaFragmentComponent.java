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
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchAnalyticTrackerFactory;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchPresenterFactory;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchViewFactory;
import id.dana.contract.globalsearch.GlobalSearchPresenter;
import id.dana.contract.globalsearch.GlobalSearchPresenter_Factory;
import id.dana.contract.promoexplore.PromoExploreModule;
import id.dana.contract.promoexplore.PromoExploreModule_ProvidesPresenterFactory;
import id.dana.contract.promoexplore.PromoExploreModule_ProvidesViewFactory;
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
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories_Factory;
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
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace;
import id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore;
import id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword_Factory;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled_Factory;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState_Factory;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch_Factory;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState_Factory;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl_Factory;
import id.dana.explore.domain.sku.interactor.GetSkuExplore;
import id.dana.explore.domain.sku.interactor.GetSkuExplore_Factory;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization_Factory;
import id.dana.explore.popularplaces.PopularPlacesContract;
import id.dana.explore.popularplaces.PopularPlacesModule;
import id.dana.explore.popularplaces.PopularPlacesModule_ProvidePresenterFactory;
import id.dana.explore.popularplaces.PopularPlacesModule_ProvideViewFactory;
import id.dana.explore.popularplaces.PopularPlacesPresenter;
import id.dana.explore.popularplaces.PopularPlacesPresenter_Factory;
import id.dana.explore.presenter.PromoExplorePresenter;
import id.dana.explore.presenter.PromoExplorePresenter_Factory;
import id.dana.explore.view.ExploreDanaFragment;
import id.dana.explore.view.ExploreDanaFragment_MembersInjector;
import id.dana.explore.view.PromoExploreContract;
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
import id.dana.promocenter.mapper.PromoAdsModelMapper_Factory;
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
public final class DaggerExploreDanaFragmentComponent {
    private DaggerExploreDanaFragmentComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GlobalSearchModule BuiltInFictitiousFunctionClassFactory;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public RestoreUrlModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public OauthModule PlaceComponentResult;
        public DeepLinkModule getAuthRequestContext;
        public ScanQrModule getErrorConfigVersion;
        public PromoExploreModule lookAheadTest;
        public ServicesModule moveToNextValue;
        public PopularPlacesModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ExploreDanaFragmentComponentImpl implements ExploreDanaFragmentComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<FeatureContract.View> ApiStatus$AvailableSince;
        private Provider<GetExploreRecommendedPopularPlace> AppCompatEmojiTextHelper;
        private Provider<UserRepository> ArrayTable$1;
        private Provider<UserPersonalizationRepository> ArrayTable$2;
        private Provider<ThreadExecutor> ArrayTable$3;
        private Provider<FeatureView> B;
        private Provider<SetHintSwipeVisibilityState> BaseSocialFeedContract$Presenter;
        private Provider<GenerateLinkRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAuthCode> C;
        private Provider<RestoreUrlView> CYFMonitor$ChallengeActionCallback;
        private Provider<SplitBillRepository> CheckPromoQuestFeature;
        private Provider<UpdateServiceHighlighted> ConcurrentKt;
        private Provider<GetDecodeTciCoListConfig> D;
        private Provider<MixpanelDeeplinkTracker> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<DeepLinkView> DatabaseTableConfigUtil;
        private Provider<GetCashierNativeConfig> E;
        private Provider<GetEmptyUserInfo> F;
        private Provider<GetSplitBillConfig> FillAnimation;
        private Provider<UserConsentRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetUserLoanInfo> FlowViewUtil$textChanges$1;
        private Provider<GetUserId> FlowViewUtil$textChanges$2;
        private Provider<RestoreUrl> FlowableConcatMapEagerPublisher;
        private Provider<ScanQrContract.Presenter> FlowableCreate$BufferAsyncEmitter;
        private Provider<ReadDeepLinkProperties> FlowableKt$toIterable$1;
        private Provider<GlobalSearchContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeaturePromoQuest> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDefaultServiceWithCategory> G;
        private Provider<CheckWhitelistedValidDomain> GetContactSyncConfig;
        private Provider<GetFavoriteServiceWithCacheFirst> H;
        private Provider<GetFavoriteServiceRemote> I;
        private Provider<DeepLinkContract.View> InitSecurePreferenceAccount;
        private Provider<GetGlobalSearchConfig> J;
        private Provider<OauthContract.Presenter> JsonParseException;
        private Provider<GetHintSwipeVisibilityState> K;
        private Provider<CheckDeepLinkActionVisibility> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetHomeSearchBarVisibility> L;
        private Provider<GetFavoriteServices> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetMerchantQrWhitelist> N;
        private Provider<CheckShouldSuggestLocationPermissionDialog> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<Context> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureOauth> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<PromoExploreContract.View> NewMerchantCategoryAdapter;
        private Provider<GetMissionDetail> O;
        private Provider<CardBindingRepository> OtpRegistrationPresenter$input$1;
        private Provider<MyReferralConsultMapper> OtpRegistrationPresenter$input$2;
        private Provider<GetIsCardBindingV2Enabled> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<DynamicUrlWrapper> PrepareContext;
        private Provider<OauthContract.View> PromoCategoryPresenter$1;
        private Provider<GetMerchantSubcategories> Q;
        private Provider<GetSearchByKeyword> QrExpiredActivity;
        private Provider<GetNickname> R;
        private Provider<PromoExploreContract.Presenter> ReferralMapper_Factory;
        private Provider<Activity> RequestMoneyQrContract$View;
        private Provider<GetPayerSplitBillDetail> S;
        private Provider<ServicesPresenter> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<ServicesRepository> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<PopularPlacesContract.View> SendMoneyScenario;
        private Provider<MyReferralConsultRepository> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<ThirdPartyServicesMapper> f5823x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<UserEducationRepository> f5824x461046da;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetKycLevel> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetPopularSearchPlaceholder> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetOnlineMerchant> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetPromoAdsExplore> T;
        private Provider<GetSkuExplore> TypeProjectionImpl;
        private Provider<ProductPageManager> TypefaceCompatApi26Impl;
        private Provider<GetPromoCenterVersion> U;
        private Provider<GetPopularSearch> V;
        private Provider<GetAddingNameWhitelistedMerchantId> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetDecodedQrisTopUp> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetPrepaidCheckoutUrl> W;
        private Provider<ValidateNativelyDecodedQr> WithdrawSavedCardChannelView;
        private Provider<ServiceCategoryMapper> WrappedDrawableState;
        private Provider<GetQrBindingConfig> X;
        private Provider<GetRequestMoneyInfoFeature> Y;
        private Provider<GetQrisCpmSendmoneyConfig> Z;

        /* renamed from: a */
        private Provider<GetServicesByName> f8106a;
        private Provider<ReadLinkPropertiesContract.Presenter> access$getCapacity$p;
        private Provider<ReadLinkPropertiesPresenter> access$setShowcaseShowing$p;
        private final GlobalSearchModule access$throwIllegalArgumentType;
        private Provider<ShortenerRepository> applyTrimPathIfNeeded;
        private Provider<GetServicesByKey> b;
        private Provider<GetService> c;
        private Provider<ScanQrContract.View> checkRegisteredUserAndSendOtp;
        private Provider<GetUserStatusInfo> connectForeground;
        private Provider<SplitBillHistoryToSplitBillModelMapper> containsObjectForKey;
        private Provider<GetServiceHighlighted> d;
        private Provider<GetSettingByKey> e;
        private Provider<ScanQrPresenter> encodingStream;
        private Provider<GetServicesWithCategory> f;
        private Provider<GetRecentSearch> flip;
        private Provider<GetUpdateAvailability> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<PaylaterRepository> getCardNumberOCR;
        private Provider<PopularPlacesContract.Presenter> getContainerAuth;
        private Provider<FeatureContract.Presenter> getDefaultSenderId;
        private Provider<CheckShowReferralCodeFeature> getErrorConfigVersion;
        private Provider<SaveLocationPermissionSuggestionState> getFontAssetManager;
        private Provider<PushVerifyTracker> getIndexName;
        private Provider<GetFeedConfig> getNameOrBuilderList;
        private Provider<GetDecodedQrBarcode> getOnBoardingScenario;
        private Provider<SaveShowToolTip> getRawPath;
        private Provider<RestoreUrlPresenter> getReadyFragment;
        private Provider<FeatureSplitBill> getSupportButtonTintMode;
        private Provider<ScanResultMapper> getTextEndPadding;
        private Provider<GetAutoCompleteByKeyword> getValueOfTouchPositionAbsolute;
        private Provider<GetWhitelistedSubMerchantId> h;
        private Provider<GetUserInfoWithKyc> i;
        private Provider<FeedsConfigRepository> initAnimators;
        private Provider<DanaCustomH5> initRecordTimeStamp;
        private Provider<QrBarcodeRepository> insertActivities;
        private Provider<GetNearbyConfig> isAuth;
        private Provider<GetReferralConsult> isAuto;
        private Provider<SettingRepository> isInfoWindowShown;
        private Provider<DeviceInformationProvider> isLayoutRequested;
        private Provider<SaveRecentSearch> isRegionMiniProgram;
        private Provider<GlobalSearchPresenter> j;
        private Provider<IsNativeDecodeEnabled> k;
        private Provider<IsFeatureGlobalSearchEnabled> l;
        private Provider<CheckMyBillsVersionConfig> lookAheadTest;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> m;
        private Provider<CheckFavoriteServicesFeature> moveToNextValue;
        private Provider<MerchantCategoriesRepository> n;
        private final ExploreDanaFragmentComponentImpl newProxyInstance;

        /* renamed from: o */
        private Provider<LiteAccountRepository> f8107o;
        private Provider<RestoreUrlContract.Presenter> onDecodeSuccess;
        private Provider<IsNeedToShowToolTip> p;
        private Provider<OauthRepository> q;
        private Provider<PayerModelListMapper> r;
        private Provider<FeatureScanQR> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<RestoreUrlContract.View> f5825reduceIndexedz1zDJgo;
        private Provider<ServicesContract.View> retainOrRemoveAllInternal;
        private Provider<SaveShowDialog> rotateTo;
        private Provider<OauthPresenter> s;
        private Provider<CheckShouldShowUserPersonalization> scheduleImpl;
        private Provider<ProductInfoRepository> secondaryHash;
        private Provider<PromoQuestRepository> setNetAuthId;
        private Provider<GetRawServices> shouldRecycleViewType;
        private Provider<OauthView> t;
        private Provider<PromoExplorePresenter> u;
        private Provider<ScanQrView> useDaemonThreadFactory;
        private Provider<PromoCenterRepository> v;
        private Provider<GlobalSearchRepository> verifyNotNull;
        private Provider<PopularPlacesPresenter> w;
        private Provider<FeatureServicesHandler> whenAvailable;
        private Provider<PostExecutionThread> x;
        private Provider<FamilyAccountRepository> y;
        private Provider<GlobalSearchContract.Presenter> z;

        public /* synthetic */ ExploreDanaFragmentComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, GlobalSearchModule globalSearchModule, PopularPlacesModule popularPlacesModule, PromoExploreModule promoExploreModule, ApplicationComponent applicationComponent, byte b) {
            this(deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, globalSearchModule, popularPlacesModule, promoExploreModule, applicationComponent);
        }

        private ExploreDanaFragmentComponentImpl(DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, GlobalSearchModule globalSearchModule, PopularPlacesModule popularPlacesModule, PromoExploreModule promoExploreModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.newProxyInstance = this;
            this.access$throwIllegalArgumentType = globalSearchModule;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.RequestMoneyQrContract$View = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.useDaemonThreadFactory = authRequestContext2;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.insertActivities = qrBarcodeRepositoryProvider;
            this.getOnBoardingScenario = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.ArrayTable$3 = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.x = postExecutionThreadProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetDecodedQrisTopUp_Factory.create(this.ArrayTable$3, postExecutionThreadProvider, this.insertActivities);
            this.getTextEndPadding = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.isLayoutRequested = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = userRepositoryProvider;
            this.connectForeground = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = featureConfigRepositoryProvider;
            this.E = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.k = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetDecodeTciCoListConfig_Factory create = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.D = create;
            this.WithdrawSavedCardChannelView = ValidateNativelyDecodedQr_Factory.create(create);
            this.N = GetMerchantQrWhitelist_Factory.create(this.insertActivities);
            this.X = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.m = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.getCardNumberOCR = providePaylaterRepositoryProvider;
            this.FlowViewUtil$textChanges$1 = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.f5824x461046da = userEducationRepositoryProvider;
            this.Z = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, userEducationRepositoryProvider);
            this.rotateTo = SaveShowDialog_Factory.create(this.f5824x461046da);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.checkRegisteredUserAndSendOtp, this.getOnBoardingScenario, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.getTextEndPadding, this.isLayoutRequested, this.connectForeground, this.E, GetNativelyDecodedQr_Factory.create(), this.k, this.WithdrawSavedCardChannelView, this.N, this.X, this.m, this.FlowViewUtil$textChanges$1, this.Z, this.rotateTo));
            this.encodingStream = authRequestContext3;
            this.FlowableCreate$BufferAsyncEmitter = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            this.CYFMonitor$ChallengeActionCallback = authRequestContext4;
            this.f5825reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.applyTrimPathIfNeeded = shortenerRepositoryProvider;
            RestoreUrl_Factory create2 = RestoreUrl_Factory.create(this.ArrayTable$3, this.x, shortenerRepositoryProvider);
            this.FlowableConcatMapEagerPublisher = create2;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.f5825reduceIndexedz1zDJgo, create2));
            this.getReadyFragment = authRequestContext5;
            this.onDecodeSuccess = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = myReferralConsultRepositoryProvider;
            this.isAuto = GetReferralConsult_Factory.create(this.ArrayTable$3, this.x, myReferralConsultRepositoryProvider);
            this.getErrorConfigVersion = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.OtpRegistrationPresenter$input$2 = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.ArrayTable$3, this.x, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.isInfoWindowShown = settingRepositoryProvider;
            this.e = GetSettingByKey_Factory.create(this.ArrayTable$3, this.x, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.TypefaceCompatApi26Impl = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.e, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.CheckPromoQuestFeature = splitBillRepositoryProvider;
            this.S = GetPayerSplitBillDetail_Factory.create(this.ArrayTable$3, this.x, splitBillRepositoryProvider);
            this.r = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.r);
            this.containsObjectForKey = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.S, PlaceComponentResult);
            this.FillAnimation = GetSplitBillConfig_Factory.create(this.ArrayTable$3, this.x, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            GetRequestMoneyInfoFeature_Factory create3 = GetRequestMoneyInfoFeature_Factory.create(this.ArrayTable$3, this.x, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.Y = create3;
            Provider<GetSplitBillConfig> provider = this.FillAnimation;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.getSupportButtonTintMode = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create3, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.setNetAuthId = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create4 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.O = create4;
            this.FragmentBottomSheetPaymentSettingBinding = FeaturePromoQuest_Factory.getAuthRequestContext(create4, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.readMicros = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.y = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.PrepareContext = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.P = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.isAuto, this.getErrorConfigVersion, this.OtpRegistrationPresenter$input$2, this.A, this.getCallingPid, this.SubSequence, this.getSupportButtonTintMode, this.FragmentBottomSheetPaymentSettingBinding, this.readMicros, this.initRecordTimeStamp, FeatureHome_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda3, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.FlowViewUtil$textChanges$1, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda4));
            this.B = authRequestContext6;
            this.ApiStatus$AvailableSince = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = servicesRepositoryProvider;
            this.b = GetServicesByKey_Factory.create(this.ArrayTable$3, this.x, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.WrappedDrawableState = authRequestContext7;
            this.f5823x461046d9 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.q = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create5 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.F = create5;
            GetAuthCode_Factory create6 = GetAuthCode_Factory.create(this.q, create5);
            this.C = create6;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.ApiStatus$AvailableSince, this.b, this.f5823x461046d9, create6, this.isLayoutRequested));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckDeepLinkActionVisibility_Factory.create(this.ArrayTable$3, this.x, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.GetContactSyncConfig = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.isAuth = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.initAnimators = provideFeedsConfigRepositoryProvider;
            this.getNameOrBuilderList = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.U = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.g = GetUpdateAvailability_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.lookAheadTest = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.getIndexName = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create7 = GetService_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.c = create7;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.ApiStatus$AvailableSince, this.whenAvailable, this.KClassImpl$Data$declaredNonStaticMembers$2, this.GetContactSyncConfig, this.isAuth, this.getNameOrBuilderList, this.U, this.g, this.lookAheadTest, this.getIndexName, create7));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext8;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.t = authRequestContext9;
            this.PromoCategoryPresenter$1 = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.i = GetUserInfoWithKyc_Factory.create(this.ArrayTable$3, this.x, this.ArrayTable$1);
            this.R = GetNickname_Factory.create(this.ArrayTable$3, this.x, this.MyBillsEntityDataFactory);
            this.h = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Provider<OauthContract.View> provider2 = this.PromoCategoryPresenter$1;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.i, this.R, this.h, this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.s = KClassImpl$Data$declaredNonStaticMembers$2;
            this.JsonParseException = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.retainOrRemoveAllInternal = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.p = IsNeedToShowToolTip_Factory.create(this.ArrayTable$3, this.x, this.f5824x461046da);
            this.getRawPath = SaveShowToolTip_Factory.create(this.ArrayTable$3, this.x, this.f5824x461046da);
            this.f = GetServicesWithCategory_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.G = GetDefaultServiceWithCategory_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.I = GetFavoriteServiceRemote_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.f8106a = GetServicesByName_Factory.create(this.ArrayTable$3, this.x, this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.M = GetFavoriteServices_Factory.create(this.ArrayTable$3, this.x, this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.moveToNextValue = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.shouldRecycleViewType = GetRawServices_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.H = GetFavoriteServiceWithCacheFirst_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.d = GetServiceHighlighted_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            UpdateServiceHighlighted_Factory create8 = UpdateServiceHighlighted_Factory.create(this.SecuritySettingsActivity$createPinLauncher$2$2);
            this.ConcurrentKt = create8;
            this.SecuritySettingsActivity$createPinLauncher$2$1 = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.retainOrRemoveAllInternal, this.C, this.f5823x461046d9, this.p, this.getRawPath, this.f, this.G, this.I, this.f8106a, this.b, this.M, this.moveToNextValue, this.shouldRecycleViewType, this.H, this.d, create8));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext10 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.FlowableCreate$BufferAsyncEmitter, this.onDecodeSuccess, this.getDefaultSenderId, this.JsonParseException, this.SecuritySettingsActivity$createPinLauncher$2$1, applicationProvider, this.FlowViewUtil$textChanges$1));
            this.DatabaseTableConfigUtil = authRequestContext10;
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext10));
            this.FlowableKt$toIterable$1 = ReadDeepLinkProperties_Factory.create(this.ArrayTable$3, this.x);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.f8107o = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.ArrayTable$3, this.x, liteAccountRepositoryProvider);
            this.FlowViewUtil$textChanges$2 = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext11 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.InitSecurePreferenceAccount, this.FlowableKt$toIterable$1, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create9, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider));
            this.access$setShowcaseShowing$p = authRequestContext11;
            this.access$getCapacity$p = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext11));
            ProvideGlobalSearchRepositoryProvider provideGlobalSearchRepositoryProvider = new ProvideGlobalSearchRepositoryProvider(applicationComponent);
            this.verifyNotNull = provideGlobalSearchRepositoryProvider;
            this.QrExpiredActivity = GetSearchByKeyword_Factory.BuiltInFictitiousFunctionClassFactory(provideGlobalSearchRepositoryProvider);
            this.getValueOfTouchPositionAbsolute = GetAutoCompleteByKeyword_Factory.getAuthRequestContext(this.verifyNotNull);
            this.l = IsFeatureGlobalSearchEnabled_Factory.BuiltInFictitiousFunctionClassFactory(this.verifyNotNull);
            MerchantCategoriesRepositoryProvider merchantCategoriesRepositoryProvider = new MerchantCategoriesRepositoryProvider(applicationComponent);
            this.n = merchantCategoriesRepositoryProvider;
            this.Q = GetMerchantSubcategories_Factory.create(merchantCategoriesRepositoryProvider);
            this.K = GetHintSwipeVisibilityState_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.verifyNotNull);
            this.BaseSocialFeedContract$Presenter = SetHintSwipeVisibilityState_Factory.BuiltInFictitiousFunctionClassFactory(this.verifyNotNull);
            this.V = GetPopularSearch_Factory.PlaceComponentResult(this.verifyNotNull);
            this.getFontAssetManager = SaveLocationPermissionSuggestionState_Factory.PlaceComponentResult(this.verifyNotNull);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShouldSuggestLocationPermissionDialog_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.verifyNotNull);
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(globalSearchModule));
            this.flip = GetRecentSearch_Factory.MyBillsEntityDataFactory(this.verifyNotNull);
            this.isRegionMiniProgram = SaveRecentSearch_Factory.MyBillsEntityDataFactory(this.verifyNotNull);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetPopularSearchPlaceholder_Factory.BuiltInFictitiousFunctionClassFactory(this.verifyNotNull);
            this.J = GetGlobalSearchConfig_Factory.BuiltInFictitiousFunctionClassFactory(this.verifyNotNull);
            this.L = GetHomeSearchBarVisibility_Factory.PlaceComponentResult(this.verifyNotNull);
            ProvideProductInfoEntityRepositoryProvider provideProductInfoEntityRepositoryProvider = new ProvideProductInfoEntityRepositoryProvider(applicationComponent);
            this.secondaryHash = provideProductInfoEntityRepositoryProvider;
            this.TypeProjectionImpl = GetSkuExplore_Factory.MyBillsEntityDataFactory(provideProductInfoEntityRepositoryProvider, this.SecuritySettingsActivity$createPinLauncher$2$2, this.verifyNotNull);
            this.W = GetPrepaidCheckoutUrl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.ArrayTable$3, this.x, this.secondaryHash);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetOnlineMerchant_Factory.MyBillsEntityDataFactory(this.verifyNotNull);
            UserPersonalizationRepositoryProvider userPersonalizationRepositoryProvider = new UserPersonalizationRepositoryProvider(applicationComponent);
            this.ArrayTable$2 = userPersonalizationRepositoryProvider;
            CheckShouldShowUserPersonalization_Factory KClassImpl$Data$declaredNonStaticMembers$22 = CheckShouldShowUserPersonalization_Factory.KClassImpl$Data$declaredNonStaticMembers$2(userPersonalizationRepositoryProvider, this.MyBillsEntityDataFactory, this.verifyNotNull);
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$22;
            Provider<GlobalSearchPresenter> authRequestContext12 = DoubleCheck.getAuthRequestContext(GlobalSearchPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.QrExpiredActivity, this.getValueOfTouchPositionAbsolute, this.l, this.Q, this.shouldRecycleViewType, this.K, this.BaseSocialFeedContract$Presenter, this.V, this.C, this.getFontAssetManager, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FlowableReduce$ReduceSubscriber, this.flip, this.isRegionMiniProgram, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.J, this.L, this.TypeProjectionImpl, this.W, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.FlowViewUtil$textChanges$2, KClassImpl$Data$declaredNonStaticMembers$22));
            this.j = authRequestContext12;
            this.z = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchPresenterFactory.getAuthRequestContext(globalSearchModule, authRequestContext12));
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(PopularPlacesModule_ProvideViewFactory.PlaceComponentResult(popularPlacesModule));
            GetExploreRecommendedPopularPlace_Factory authRequestContext13 = GetExploreRecommendedPopularPlace_Factory.getAuthRequestContext(this.verifyNotNull);
            this.AppCompatEmojiTextHelper = authRequestContext13;
            PopularPlacesPresenter_Factory PlaceComponentResult2 = PopularPlacesPresenter_Factory.PlaceComponentResult(this.SendMoneyScenario, authRequestContext13);
            this.w = PlaceComponentResult2;
            this.getContainerAuth = DoubleCheck.getAuthRequestContext(PopularPlacesModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(popularPlacesModule, PlaceComponentResult2));
            this.NewMerchantCategoryAdapter = DoubleCheck.getAuthRequestContext(PromoExploreModule_ProvidesViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(promoExploreModule));
            PromoCenterRepositoryProvider promoCenterRepositoryProvider = new PromoCenterRepositoryProvider(applicationComponent);
            this.v = promoCenterRepositoryProvider;
            GetPromoAdsExplore_Factory authRequestContext14 = GetPromoAdsExplore_Factory.getAuthRequestContext(promoCenterRepositoryProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.verifyNotNull);
            this.T = authRequestContext14;
            PromoExplorePresenter_Factory BuiltInFictitiousFunctionClassFactory2 = PromoExplorePresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NewMerchantCategoryAdapter, authRequestContext14, PromoAdsModelMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            this.u = BuiltInFictitiousFunctionClassFactory2;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(PromoExploreModule_ProvidesPresenterFactory.getAuthRequestContext(promoExploreModule, BuiltInFictitiousFunctionClassFactory2));
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
        /* loaded from: classes4.dex */
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
            private final ApplicationComponent PlaceComponentResult;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.QrExpiredActivity());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowableCreate$BufferAsyncEmitter());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideGlobalSearchRepositoryProvider implements Provider<GlobalSearchRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideGlobalSearchRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSearchRepository get() {
                return (GlobalSearchRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.o());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantCategoriesRepositoryProvider implements Provider<MerchantCategoriesRepository> {
            private final ApplicationComponent PlaceComponentResult;

            MerchantCategoriesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantCategoriesRepository get() {
                return (MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.K());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideProductInfoEntityRepositoryProvider implements Provider<ProductInfoRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideProductInfoEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductInfoRepository get() {
                return (ProductInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.FlowableReduce$ReduceSubscriber());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserPersonalizationRepositoryProvider implements Provider<UserPersonalizationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserPersonalizationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserPersonalizationRepository get() {
                return (UserPersonalizationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SchedulerPoolFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoCenterRepositoryProvider implements Provider<PromoCenterRepository> {
            private final ApplicationComponent getAuthRequestContext;

            PromoCenterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoCenterRepository get() {
                return (PromoCenterRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.d());
            }
        }

        @Override // id.dana.di.component.ExploreDanaFragmentComponent
        public final void PlaceComponentResult(ExploreDanaFragment exploreDanaFragment) {
            ExploreDanaFragment_MembersInjector.PlaceComponentResult(exploreDanaFragment, this.access$getCapacity$p.get());
            exploreDanaFragment.globalSearchPresenter = this.z.get();
            ExploreDanaFragment_MembersInjector.PlaceComponentResult(exploreDanaFragment, this.getContainerAuth.get());
            ExploreDanaFragment_MembersInjector.getAuthRequestContext(exploreDanaFragment, this.ReferralMapper_Factory.get());
            ExploreDanaFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(exploreDanaFragment, GlobalSearchModule_ProvideGlobalSearchAnalyticTrackerFactory.MyBillsEntityDataFactory(this.access$throwIllegalArgumentType, (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
        }
    }
}
