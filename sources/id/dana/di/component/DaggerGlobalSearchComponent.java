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
import id.dana.contract.globalsearch.AbstractGlobalSearchView;
import id.dana.contract.globalsearch.AbstractGlobalSearchView_MembersInjector;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchAnalyticTrackerFactory;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchPresenterFactory;
import id.dana.contract.globalsearch.GlobalSearchModule_ProvideGlobalSearchViewFactory;
import id.dana.contract.globalsearch.GlobalSearchPresenter;
import id.dana.contract.globalsearch.GlobalSearchPresenter_Factory;
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
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
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
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog_Factory;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword_Factory;
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
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.globalsearch.view.GlobalSearchFragment;
import id.dana.globalsearch.view.SeeAllFragment;
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
public final class DaggerGlobalSearchComponent {
    private DaggerGlobalSearchComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public DeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public RestoreUrlModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public CheckoutH5EventModule PlaceComponentResult;
        public FeatureModule getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public PlayStoreReviewModules lookAheadTest;
        public GlobalSearchModule moveToNextValue;
        public ScanQrModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class GlobalSearchComponentImpl implements GlobalSearchComponent {
        private Provider<GenerateReferralDeepLink> A;
        private Provider<FeatureContract.Presenter> ApiStatus$AvailableSince;
        private Provider<GetEmptyUserInfo> AppCompatEmojiTextHelper;
        private Provider<SplitBillRepository> ArrayTable$1;
        private Provider<ThreadExecutor> ArrayTable$2;
        private Provider<ServiceCategoryMapper> ArrayTable$3;
        private Provider<FeatureView> B;
        private Provider<UserEducationRepository> BannerEntityDataFactory_Factory;
        private Provider<ScanQrPresenter> BaseSocialFeedContract$Presenter;
        private Provider<GetAddingNameWhitelistedMerchantId> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<GenerateLinkRepository> C;
        private Provider<ReadLinkPropertiesPresenter> CYFMonitor$ChallengeActionCallback;
        private Provider<ServicesRepository> CheckPromoQuestFeature;
        private Provider<SettingRepository> ConcurrentKt;
        private Provider<GetAutoCompleteByKeyword> D;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<Context> DatabaseTableConfigUtil;
        private Provider<UserConsentRepository> DebugCoroutineInfoImpl;
        private Provider<GetCheckoutH5Event> E;
        private Provider<GetDefaultServiceWithCategory> F;
        private Provider<GetSkuExplore> FillAnimation;
        private Provider<ShortenerRepository> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetUserLoanInfo> FlowViewUtil$textChanges$1;
        private Provider<GetUpdateAvailability> FlowViewUtil$textChanges$2;
        private Provider<ReadDeepLinkProperties> FlowableConcatMapEagerPublisher;
        private Provider<FamilyAccountRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<FeatureContract.View> FlowableKt$toIterable$1;
        private Provider<BottomSheetOnBoardingContract.View> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureOauth> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDecodeTciCoListConfig> G;
        private Provider<CheckWhitelistedValidDomain> GetContactSyncConfig;
        private Provider<GetDecodedQrBarcode> H;
        private Provider<GetDecodedQrisTopUp> I;
        private Provider<ReadLinkPropertiesContract.Presenter> InitSecurePreferenceAccount;
        private Provider<ValidateNativelyDecodedQr> InvestmentWalletAdapter;
        private Provider<GetFavoriteServices> J;
        private Provider<GlobalSearchContract.View> JsonParseException;
        private Provider<GetFavoriteServiceRemote> K;
        private Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetFeedConfig> L;
        private Provider<GetFavoriteServiceWithCacheFirst> M;
        private Provider<CheckConsultFamilyAccount> MyBillsEntityDataFactory;
        private Provider<GetMerchantQrWhitelist> N;
        private Provider<CheckShouldSuggestLocationPermissionDialog> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeaturePromoQuest> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DeepLinkPayloadModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ServicesContract.View> NewMerchantCategoryAdapter;
        private Provider<GetKycLevel> O;
        private Provider<BottomSheetOnBoardingContract.Presenter> OtpRegistrationPresenter$input$1;
        private Provider<IsFeatureGlobalSearchEnabled> OtpRegistrationPresenter$input$2;
        private Provider<GetHomeSearchBarVisibility> P;
        private Provider<BottomSheetOnBoardingPresenter> PlaceComponentResult;
        private Provider<DynamicUrlWrapper> PrepareContext;
        private Provider<PushVerifyTracker> PromoCategoryPresenter$1;
        private Provider<GetIsCardBindingV2Enabled> Q;
        private Provider<GetServiceHighlighted> QrExpiredActivity;
        private Provider<GetOnlineMerchant> R;
        private Provider<ScanQrContract.View> ReferralMapper_Factory;
        private Provider<ProductPageManager> RequestMoneyQrContract$View;
        private Provider<GetMerchantSubcategories> S;
        private Provider<UserRepository> SchedulerPoolFactory;
        private Provider<ScanResultMapper> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<SaveShowToolTip> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<ProductInfoRepository> SendMoneyScenario;
        private Provider<MyReferralConsultRepository> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<SetHintSwipeVisibilityState> f5828x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private Provider<SplitBillHistoryToSplitBillModelMapper> f5829x461046da;
        private Provider<FeatureSplitBillPay> SubSequence;
        private Provider<GetHintSwipeVisibilityState> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetNickname> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetMissionDetail> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetPrepaidCheckoutUrl> T;
        private Provider<GetServicesWithCategory> TypeProjectionImpl;
        private Provider<OauthRepository> TypefaceCompatApi26Impl;
        private Provider<GetPayerSplitBillDetail> U;
        private Provider<GetPromoCenterVersion> V;
        private Provider<FeatureSplitBill> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetCashierNativeConfig> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<UserPersonalizationRepository> View$OnClickListener;
        private Provider<GetPopularSearch> W;
        private Provider<ThirdPartyServicesMapper> WithdrawSavedCardChannelView;
        private Provider<SaveLocationPermissionSuggestionState> WrappedDrawableState;
        private Provider<GetPopularSearchPlaceholder> X;
        private Provider<GetReferralConsult> Y;
        private Provider<GetQrisCpmSendmoneyConfig> Z;

        /* renamed from: a */
        private Provider<GetRequestMoneyInfoFeature> f8112a;
        private Provider<PlayStoreReviewContract.View> access$getCapacity$p;
        private Provider<RestoreUrlContract.View> access$setShowcaseShowing$p;
        private final GlobalSearchModule access$throwIllegalArgumentType;
        private Provider<ScanQrView> applyTrimPathIfNeeded;
        private Provider<GetService> b;
        private Provider<GetSearchByKeyword> c;
        private Provider<OauthContract.Presenter> checkRegisteredUserAndSendOtp;
        private Provider<GetUserStatusInfo> connectForeground;
        private Provider<ServicesPresenter> containsObjectForKey;
        private Provider<GetServicesByKey> d;
        private Provider<GetSplitBillConfig> e;
        private Provider<SaveLastPlayStoreReviewShow> encodingStream;
        private Provider<GetSettingByKey> f;
        private Provider<GetRecentSearch> flip;
        private Provider<GetServicesByName> g;
        private Provider<Application> getAuthRequestContext;
        private Provider<FeatureSettingMore> getCallingPid;
        private Provider<GlobalSearchContract.Presenter> getCardNumberOCR;
        private Provider<GlobalSearchRepository> getContainerAuth;
        private Provider<PaylaterRepository> getDefaultSenderId;
        private Provider<CheckFavoriteServicesFeature> getErrorConfigVersion;
        private Provider<QrBarcodeRepository> getFontAssetManager;
        private Provider<RestoreUrlContract.Presenter> getIndexName;
        private Provider<GetGlobalSearchConfig> getNameOrBuilderList;
        private Provider<GetBottomSheetOnBoarding> getOnBoardingScenario;
        private Provider<UpdateServiceHighlighted> getPhoneMask;
        private Provider<SaveDisplayBottomSheetOnBoarding> getRawPath;
        private Provider<OauthContract.View> getReadyFragment;
        private Provider<FeatureScanQR> getSupportButtonTintMode;
        private Provider<RestoreUrlView> getTextEndPadding;
        private Provider<GetAuthCode> getValueOfTouchPositionAbsolute;
        private Provider<GetUserInfoWithKyc> h;
        private Provider<GetUserId> i;
        private Provider<Activity> initAnimators;
        private final CheckoutH5EventModule initRecordTimeStamp;
        private Provider<DeepLinkContract.View> insertActivities;
        private Provider<GetNearbyConfig> isAuth;
        private Provider<GetQrBindingConfig> isAuto;
        private Provider<SaveShowDialog> isInfoWindowShown;
        private Provider<DeviceInformationProvider> isLayoutRequested;
        private Provider<RestoreUrl> isRegionMiniProgram;
        private Provider<H5EventRepository> j;
        private Provider<GlobalSearchPresenter> k;
        private final GlobalSearchComponentImpl l;
        private Provider<CheckDeepLinkActionVisibility> lookAheadTest;
        private Provider<GetWhitelistedSubMerchantId> m;
        private Provider<CheckShouldShowUserPersonalization> moveToNextValue;
        private Provider<IsNeedToShowToolTip> n;
        private Provider<DeepLinkView> newProxyInstance;

        /* renamed from: o */
        private Provider<IsNeedToShowPlayStoreReview> f8113o;
        private Provider<CardBindingRepository> onDecodeSuccess;
        private Provider<IsNativeDecodeEnabled> p;
        private Provider<LiteAccountRepository> q;
        private Provider<MyReferralConsultMapper> r;
        private Provider<FeaturePushVerify> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<ScanQrContract.Presenter> f5830reduceIndexedz1zDJgo;
        private Provider<CheckoutH5EventContract.View> retainOrRemoveAllInternal;
        private Provider<RestoreUrlPresenter> rotateTo;
        private Provider<MixpanelDeeplinkTracker> s;
        private Provider<CheckMyBillsVersionConfig> scheduleImpl;
        private Provider<PlayStoreReviewContract.Presenter> secondaryHash;
        private Provider<PlayStoreReviewRepository> setNetAuthId;
        private Provider<GetRawServices> shouldRecycleViewType;
        private Provider<MerchantCategoriesRepository> t;
        private Provider<OauthView> u;
        private Provider<SaveRecentSearch> useDaemonThreadFactory;
        private Provider<PayerModelListMapper> v;
        private Provider<FeedsConfigRepository> verifyNotNull;
        private Provider<OauthPresenter> w;
        private Provider<FeatureServicesHandler> whenAvailable;
        private Provider<PlayStoreReviewPresenter> x;
        private Provider<PromoQuestRepository> y;
        private Provider<PostExecutionThread> z;

        public /* synthetic */ GlobalSearchComponentImpl(GlobalSearchModule globalSearchModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent, byte b) {
            this(globalSearchModule, playStoreReviewModules, checkoutH5EventModule, bottomSheetOnBoardingModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private GlobalSearchComponentImpl(GlobalSearchModule globalSearchModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.l = this;
            this.initRecordTimeStamp = checkoutH5EventModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.access$throwIllegalArgumentType = globalSearchModule;
            this.DatabaseTableConfigUtil = new ContextProvider(applicationComponent);
            ProvideGlobalSearchRepositoryProvider provideGlobalSearchRepositoryProvider = new ProvideGlobalSearchRepositoryProvider(applicationComponent);
            this.getContainerAuth = provideGlobalSearchRepositoryProvider;
            this.c = GetSearchByKeyword_Factory.BuiltInFictitiousFunctionClassFactory(provideGlobalSearchRepositoryProvider);
            this.D = GetAutoCompleteByKeyword_Factory.getAuthRequestContext(this.getContainerAuth);
            this.OtpRegistrationPresenter$input$2 = IsFeatureGlobalSearchEnabled_Factory.BuiltInFictitiousFunctionClassFactory(this.getContainerAuth);
            MerchantCategoriesRepositoryProvider merchantCategoriesRepositoryProvider = new MerchantCategoriesRepositoryProvider(applicationComponent);
            this.t = merchantCategoriesRepositoryProvider;
            this.S = GetMerchantSubcategories_Factory.create(merchantCategoriesRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.CheckPromoQuestFeature = servicesRepositoryProvider;
            this.shouldRecycleViewType = GetRawServices_Factory.create(servicesRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetHintSwipeVisibilityState_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getContainerAuth);
            this.f5828x461046d9 = SetHintSwipeVisibilityState_Factory.BuiltInFictitiousFunctionClassFactory(this.getContainerAuth);
            this.W = GetPopularSearch_Factory.PlaceComponentResult(this.getContainerAuth);
            this.TypefaceCompatApi26Impl = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.DebugCoroutineInfoImpl = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.AppCompatEmojiTextHelper = create;
            this.getValueOfTouchPositionAbsolute = GetAuthCode_Factory.create(this.TypefaceCompatApi26Impl, create);
            this.WrappedDrawableState = SaveLocationPermissionSuggestionState_Factory.PlaceComponentResult(this.getContainerAuth);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShouldSuggestLocationPermissionDialog_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getContainerAuth);
            this.JsonParseException = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(globalSearchModule));
            this.flip = GetRecentSearch_Factory.MyBillsEntityDataFactory(this.getContainerAuth);
            this.useDaemonThreadFactory = SaveRecentSearch_Factory.MyBillsEntityDataFactory(this.getContainerAuth);
            this.X = GetPopularSearchPlaceholder_Factory.BuiltInFictitiousFunctionClassFactory(this.getContainerAuth);
            this.getNameOrBuilderList = GetGlobalSearchConfig_Factory.BuiltInFictitiousFunctionClassFactory(this.getContainerAuth);
            this.P = GetHomeSearchBarVisibility_Factory.PlaceComponentResult(this.getContainerAuth);
            ProvideProductInfoEntityRepositoryProvider provideProductInfoEntityRepositoryProvider = new ProvideProductInfoEntityRepositoryProvider(applicationComponent);
            this.SendMoneyScenario = provideProductInfoEntityRepositoryProvider;
            this.FillAnimation = GetSkuExplore_Factory.MyBillsEntityDataFactory(provideProductInfoEntityRepositoryProvider, this.CheckPromoQuestFeature, this.getContainerAuth);
            this.ArrayTable$2 = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.z = postExecutionThreadProvider;
            this.T = GetPrepaidCheckoutUrl_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.ArrayTable$2, postExecutionThreadProvider, this.SendMoneyScenario);
            this.R = GetOnlineMerchant_Factory.MyBillsEntityDataFactory(this.getContainerAuth);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.q = liteAccountRepositoryProvider;
            this.i = GetUserId_Factory.create(this.ArrayTable$2, this.z, liteAccountRepositoryProvider);
            this.View$OnClickListener = new UserPersonalizationRepositoryProvider(applicationComponent);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepositoryProvider;
            CheckShouldShowUserPersonalization_Factory KClassImpl$Data$declaredNonStaticMembers$2 = CheckShouldShowUserPersonalization_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.View$OnClickListener, accountRepositoryProvider, this.getContainerAuth);
            this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<GlobalSearchPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GlobalSearchPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.c, this.D, this.OtpRegistrationPresenter$input$2, this.S, this.shouldRecycleViewType, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.f5828x461046d9, this.W, this.getValueOfTouchPositionAbsolute, this.WrappedDrawableState, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.JsonParseException, this.flip, this.useDaemonThreadFactory, this.X, this.getNameOrBuilderList, this.P, this.FillAnimation, this.T, this.R, this.i, KClassImpl$Data$declaredNonStaticMembers$2));
            this.k = authRequestContext;
            this.getCardNumberOCR = DoubleCheck.getAuthRequestContext(GlobalSearchModule_ProvideGlobalSearchPresenterFactory.getAuthRequestContext(globalSearchModule, authRequestContext));
            Provider<Activity> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.initAnimators = authRequestContext2;
            Provider<ScanQrView> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext2));
            this.applyTrimPathIfNeeded = authRequestContext3;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext3));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.getFontAssetManager = qrBarcodeRepositoryProvider;
            this.H = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.I = GetDecodedQrisTopUp_Factory.create(this.ArrayTable$2, this.z, this.getFontAssetManager);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.isLayoutRequested = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.SchedulerPoolFactory = userRepositoryProvider;
            this.connectForeground = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = featureConfigRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.p = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.G = create2;
            this.InvestmentWalletAdapter = ValidateNativelyDecodedQr_Factory.create(create2);
            this.N = GetMerchantQrWhitelist_Factory.create(this.getFontAssetManager);
            this.isAuto = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.getDefaultSenderId = providePaylaterRepositoryProvider;
            this.FlowViewUtil$textChanges$1 = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = userEducationRepositoryProvider;
            this.Z = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5, userEducationRepositoryProvider);
            this.isInfoWindowShown = SaveShowDialog_Factory.create(this.BannerEntityDataFactory_Factory);
            Provider<ScanQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.ReferralMapper_Factory, this.H, this.I, this.SecuritySettingsActivity$createPinLauncher$2$1, this.isLayoutRequested, this.connectForeground, this.VerifyPinStateManager$executeRiskChallenge$2$2, GetNativelyDecodedQr_Factory.create(), this.p, this.InvestmentWalletAdapter, this.N, this.isAuto, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.FlowViewUtil$textChanges$1, this.Z, this.isInfoWindowShown));
            this.BaseSocialFeedContract$Presenter = authRequestContext4;
            this.f5830reduceIndexedz1zDJgo = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext4));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.j = h5eventRepositoryProvider;
            this.E = GetCheckoutH5Event_Factory.create(this.ArrayTable$2, this.z, h5eventRepositoryProvider);
            this.retainOrRemoveAllInternal = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.setNetAuthId = playStoreReviewRepositoryProvider;
            this.f8113o = IsNeedToShowPlayStoreReview_Factory.create(this.ArrayTable$2, this.z, playStoreReviewRepositoryProvider);
            this.encodingStream = SaveLastPlayStoreReviewShow_Factory.create(this.ArrayTable$2, this.z, this.setNetAuthId);
            Provider<PlayStoreReviewContract.View> authRequestContext5 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.access$getCapacity$p = authRequestContext5;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.f8113o, this.encodingStream, authRequestContext5);
            this.x = MyBillsEntityDataFactory;
            this.secondaryHash = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil));
            this.getTextEndPadding = authRequestContext6;
            this.access$setShowcaseShowing$p = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.ArrayTable$2, this.z, shortenerRepositoryProvider);
            this.isRegionMiniProgram = create3;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.access$setShowcaseShowing$p, create3));
            this.rotateTo = authRequestContext7;
            this.getIndexName = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.SizeSelectors$OrSelector = myReferralConsultRepositoryProvider;
            this.Y = GetReferralConsult_Factory.create(this.ArrayTable$2, this.z, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.r = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.C = generateLinkRepositoryProvider;
            this.A = GenerateReferralDeepLink_Factory.create(this.ArrayTable$2, this.z, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.ConcurrentKt = settingRepositoryProvider;
            this.f = GetSettingByKey_Factory.create(this.ArrayTable$2, this.z, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.RequestMoneyQrContract$View = productPageManagerProvider;
            this.getCallingPid = FeatureSettingMore_Factory.PlaceComponentResult(this.f, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.ArrayTable$1 = splitBillRepositoryProvider;
            this.U = GetPayerSplitBillDetail_Factory.create(this.ArrayTable$2, this.z, splitBillRepositoryProvider);
            this.v = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.v);
            this.f5829x461046da = PlaceComponentResult;
            this.SubSequence = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.U, PlaceComponentResult);
            this.e = GetSplitBillConfig_Factory.create(this.ArrayTable$2, this.z, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.ArrayTable$2, this.z, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.f8112a = create4;
            Provider<GetSplitBillConfig> provider = this.e;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.y = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.DatabaseTableConfigUtil));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory2 = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
            this.s = MyBillsEntityDataFactory2;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = provideFamilyAccountRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.PrepareContext = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.Q = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.readMicros = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.s));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.Y, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.r, this.A, this.getCallingPid, this.SubSequence, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getSupportButtonTintMode, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.FragmentBottomSheetPaymentSettingBinding, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.FlowViewUtil$textChanges$1, FeatureMyBills_Factory.PlaceComponentResult(), this.readMicros));
            this.B = authRequestContext8;
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            this.d = GetServicesByKey_Factory.create(this.ArrayTable$2, this.z, this.CheckPromoQuestFeature);
            ServiceCategoryMapper_Factory authRequestContext9 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.DatabaseTableConfigUtil);
            this.ArrayTable$3 = authRequestContext9;
            ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory2 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext9);
            this.WithdrawSavedCardChannelView = BuiltInFictitiousFunctionClassFactory2;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.FlowableKt$toIterable$1, this.d, BuiltInFictitiousFunctionClassFactory2, this.getValueOfTouchPositionAbsolute, this.isLayoutRequested));
            this.lookAheadTest = CheckDeepLinkActionVisibility_Factory.create(this.ArrayTable$2, this.z, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.GetContactSyncConfig = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.isAuth = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.verifyNotNull = provideFeedsConfigRepositoryProvider;
            this.L = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.V = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.FlowViewUtil$textChanges$2 = GetUpdateAvailability_Factory.create(this.DatabaseTableConfigUtil);
            this.scheduleImpl = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.PromoCategoryPresenter$1 = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create6 = GetService_Factory.create(this.CheckPromoQuestFeature);
            this.b = create6;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.FlowableKt$toIterable$1, this.whenAvailable, this.lookAheadTest, this.GetContactSyncConfig, this.isAuth, this.L, this.V, this.FlowViewUtil$textChanges$2, this.scheduleImpl, this.PromoCategoryPresenter$1, create6));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext10;
            this.ApiStatus$AvailableSince = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding);
            this.u = authRequestContext11;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            this.O = GetKycLevel_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.h = GetUserInfoWithKyc_Factory.create(this.ArrayTable$2, this.z, this.SchedulerPoolFactory);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetNickname_Factory.create(this.ArrayTable$2, this.z, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.m = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            Provider<OauthContract.View> provider2 = this.getReadyFragment;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.O, this.h, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.m, this.BottomSheetCardBindingView$watcherCardNumberView$1);
            this.w = KClassImpl$Data$declaredNonStaticMembers$22;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$22));
            this.NewMerchantCategoryAdapter = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.n = IsNeedToShowToolTip_Factory.create(this.ArrayTable$2, this.z, this.BannerEntityDataFactory_Factory);
            this.SecuritySettingsActivity$createPinLauncher$2$2 = SaveShowToolTip_Factory.create(this.ArrayTable$2, this.z, this.BannerEntityDataFactory_Factory);
            this.TypeProjectionImpl = GetServicesWithCategory_Factory.create(this.CheckPromoQuestFeature);
            this.F = GetDefaultServiceWithCategory_Factory.create(this.CheckPromoQuestFeature);
            this.K = GetFavoriteServiceRemote_Factory.create(this.CheckPromoQuestFeature);
            this.g = GetServicesByName_Factory.create(this.ArrayTable$2, this.z, this.CheckPromoQuestFeature);
            this.J = GetFavoriteServices_Factory.create(this.ArrayTable$2, this.z, this.CheckPromoQuestFeature);
            this.getErrorConfigVersion = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.M = GetFavoriteServiceWithCacheFirst_Factory.create(this.CheckPromoQuestFeature);
            this.QrExpiredActivity = GetServiceHighlighted_Factory.create(this.CheckPromoQuestFeature);
            UpdateServiceHighlighted_Factory create7 = UpdateServiceHighlighted_Factory.create(this.CheckPromoQuestFeature);
            this.getPhoneMask = create7;
            this.containsObjectForKey = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.NewMerchantCategoryAdapter, this.getValueOfTouchPositionAbsolute, this.WithdrawSavedCardChannelView, this.n, this.SecuritySettingsActivity$createPinLauncher$2$2, this.TypeProjectionImpl, this.F, this.K, this.g, this.d, this.J, this.getErrorConfigVersion, this.shouldRecycleViewType, this.M, this.QrExpiredActivity, create7));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.getAuthRequestContext = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.f5830reduceIndexedz1zDJgo, this.getIndexName, this.ApiStatus$AvailableSince, this.checkRegisteredUserAndSendOtp, this.containsObjectForKey, applicationProvider, this.FlowViewUtil$textChanges$1));
            this.newProxyInstance = authRequestContext12;
            this.insertActivities = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.FlowableConcatMapEagerPublisher = ReadDeepLinkProperties_Factory.create(this.ArrayTable$2, this.z);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            DeepLinkPayloadModelMapper_Factory BuiltInFictitiousFunctionClassFactory3 = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = BuiltInFictitiousFunctionClassFactory3;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.insertActivities, this.FlowableConcatMapEagerPublisher, BuiltInFictitiousFunctionClassFactory3, this.i, this.s));
            this.CYFMonitor$ChallengeActionCallback = authRequestContext13;
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
            this.FlowableReduce$ReduceSubscriber = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.getOnBoardingScenario = GetBottomSheetOnBoarding_Factory.create(this.ArrayTable$2, this.z, this.BannerEntityDataFactory_Factory);
            SaveDisplayBottomSheetOnBoarding_Factory create8 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.ArrayTable$2, this.z, this.BannerEntityDataFactory_Factory);
            this.getRawPath = create8;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory4 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.FlowableReduce$ReduceSubscriber, this.getOnBoardingScenario, create8);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory4;
            this.OtpRegistrationPresenter$input$1 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory4));
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
        public static final class ProvideGlobalSearchRepositoryProvider implements Provider<GlobalSearchRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideGlobalSearchRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSearchRepository get() {
                return (GlobalSearchRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.o());
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
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SecuritySettingsActivity$createPinLauncher$2$1());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WithdrawSavedCardChannelView());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideProductInfoEntityRepositoryProvider implements Provider<ProductInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideProductInfoEntityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductInfoRepository get() {
                return (ProductInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FlowableReduce$ReduceSubscriber());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
        public static final class UserPersonalizationRepositoryProvider implements Provider<UserPersonalizationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserPersonalizationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserPersonalizationRepository get() {
                return (UserPersonalizationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SchedulerPoolFactory());
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
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
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
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
            private final ApplicationComponent getAuthRequestContext;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.getAuthRequestContext.shouldRecycleViewType());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.k());
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
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent PlaceComponentResult;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        @Override // id.dana.di.component.GlobalSearchComponent
        public final void BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment globalSearchFragment) {
            AbstractGlobalSearchView_MembersInjector.MyBillsEntityDataFactory(globalSearchFragment, this.getCardNumberOCR.get());
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(globalSearchFragment, this.f5830reduceIndexedz1zDJgo.get());
            AbstractGlobalSearchView_MembersInjector.BuiltInFictitiousFunctionClassFactory(globalSearchFragment, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.initRecordTimeStamp, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.E), DoubleCheck.MyBillsEntityDataFactory(this.retainOrRemoveAllInternal))));
            ((AbstractGlobalSearchView) globalSearchFragment).playStoreReviewPresenter = this.secondaryHash.get();
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(globalSearchFragment, this.InitSecurePreferenceAccount.get());
            AbstractGlobalSearchView_MembersInjector.MyBillsEntityDataFactory(globalSearchFragment, this.OtpRegistrationPresenter$input$1.get());
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(globalSearchFragment, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            globalSearchFragment.globalSearchAnalyticTracker = GlobalSearchModule_ProvideGlobalSearchAnalyticTrackerFactory.MyBillsEntityDataFactory(this.access$throwIllegalArgumentType, (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()));
        }

        @Override // id.dana.di.component.GlobalSearchComponent
        public final void MyBillsEntityDataFactory(SeeAllFragment seeAllFragment) {
            AbstractGlobalSearchView_MembersInjector.MyBillsEntityDataFactory(seeAllFragment, this.getCardNumberOCR.get());
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(seeAllFragment, this.f5830reduceIndexedz1zDJgo.get());
            AbstractGlobalSearchView_MembersInjector.BuiltInFictitiousFunctionClassFactory(seeAllFragment, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.initRecordTimeStamp, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.E), DoubleCheck.MyBillsEntityDataFactory(this.retainOrRemoveAllInternal))));
            ((AbstractGlobalSearchView) seeAllFragment).playStoreReviewPresenter = this.secondaryHash.get();
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(seeAllFragment, this.InitSecurePreferenceAccount.get());
            AbstractGlobalSearchView_MembersInjector.MyBillsEntityDataFactory(seeAllFragment, this.OtpRegistrationPresenter$input$1.get());
            AbstractGlobalSearchView_MembersInjector.getAuthRequestContext(seeAllFragment, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
        }
    }
}
