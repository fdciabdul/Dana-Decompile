package id.dana.mybills.di;

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
import id.dana.cashier.CashierEventHandler;
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
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.CheckoutH5EventModule_ProvidePresenterFactory;
import id.dana.di.modules.CheckoutH5EventModule_ProvideViewFactory;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.GlobalNetworkModule_ProvidesPresenterFactory;
import id.dana.di.modules.GlobalNetworkModule_ProvidesViewFactory;
import id.dana.di.modules.MyBillsModule;
import id.dana.di.modules.MyBillsModule_ProvidePresenterFactory;
import id.dana.di.modules.MyBillsModule_ProvideViewFactory;
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
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr_Factory;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetPayRequest_Factory;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth_Factory;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled_Factory;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier_Factory;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig_Factory;
import id.dana.domain.mybills.interactor.CheckSplitService;
import id.dana.domain.mybills.interactor.CheckSplitService_Factory;
import id.dana.domain.mybills.interactor.GetBizProductOrder;
import id.dana.domain.mybills.interactor.GetBizProductOrder_Factory;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction_Factory;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination_Factory;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills_Factory;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills_Factory;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView_Factory;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills_Factory;
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
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
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
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter_Factory;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker_Factory;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.mapper.DeepLinkPayloadModelMapper_Factory;
import id.dana.mapper.ScanResultMapper;
import id.dana.mapper.ScanResultMapper_Factory;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.mybills.MyBillsActivity;
import id.dana.mybills.MyBillsActivity_MembersInjector;
import id.dana.mybills.di.MyBillsContract;
import id.dana.mybills.view.AddNewBillsActivity;
import id.dana.mybills.view.AddNewBillsActivity_MembersInjector;
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

/* loaded from: classes5.dex */
public final class DaggerMyBillsComponent {
    private DaggerMyBillsComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public DeepLinkModule BuiltInFictitiousFunctionClassFactory;
        public ScanQrModule DatabaseTableConfigUtil;
        public FeatureModule KClassImpl$Data$declaredNonStaticMembers$2;
        public CheckoutH5EventModule MyBillsEntityDataFactory;
        public RestoreUrlModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public ServicesModule NetworkUserEntityData$$ExternalSyntheticLambda2;
        public BottomSheetOnBoardingModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;
        public OauthModule getErrorConfigVersion;
        public MyBillsModule lookAheadTest;
        public PlayStoreReviewModules moveToNextValue;
        public GlobalNetworkModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final MyBillsComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, MyBillsModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, OauthModule.class);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, PlayStoreReviewModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, CheckoutH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, BottomSheetOnBoardingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, GlobalNetworkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ApplicationComponent.class);
            return new MyBillsComponentImpl(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.scheduleImpl, this.getAuthRequestContext, (byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public static final class MyBillsComponentImpl implements MyBillsComponent {
        private Provider<FeatureSplitBill> A;
        private Provider<CardBindingRepository> ApiStatus$AvailableSince;
        private Provider<GetCheckoutH5Event> AppCompatEmojiTextHelper;
        private Provider<ScanResultMapper> ArrayTable$1;
        private Provider<ServicesRepository> ArrayTable$2;
        private Provider<SaveLastPlayStoreReviewShow> ArrayTable$3;
        private Provider<FeatureView> B;
        private Provider<SplitBillRepository> BannerEntityDataFactory_Factory;
        private Provider<SaveDisplayBottomSheetOnBoarding> BaseSocialFeedContract$Presenter;
        private Provider<GenerateLinkRepository> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<FeatureSplitBillPay> C;
        private Provider<GlobalNetworkContract.Presenter> CYFMonitor$ChallengeActionCallback;
        private Provider<ScanQrView> CheckPromoQuestFeature;
        private Provider<ScanQrPresenter> ConcurrentKt;
        private Provider<GetBizProductOrder> D;
        private Provider<IsNativeDecodeEnabled> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CheckWhitelistedValidDomain> DatabaseTableConfigUtil;
        private Provider<SplitBillHistoryToSplitBillModelMapper> DebugCoroutineInfoImpl;
        private Provider<GetAddingNameWhitelistedMerchantId> E;
        private Provider<GetDecodedQrisTopUp> F;
        private Provider<GetSplitBillConfig> FillAnimation;
        private Provider<ServiceCategoryMapper> FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        private Provider<GetUpdateAvailability> FlowViewUtil$textChanges$1;
        private Provider<GetUserStatusInfo> FlowViewUtil$textChanges$2;
        private Provider<OauthContract.View> FlowableConcatMapEagerPublisher;
        private Provider<ProductPageManager> FlowableCreate$BufferAsyncEmitter;
        private Provider<MyBillsContract.View> FlowableKt$toIterable$1;
        private Provider<PlayStoreReviewRepository> FlowableReduce$ReduceSubscriber;
        private Provider<FeatureOauth> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetDecodeTciCoListConfig> G;
        private final CheckoutH5EventModule GetContactSyncConfig;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> H;
        private Provider<GetDecodedQrBarcode> I;
        private Provider<RestoreUrlContract.Presenter> InitSecurePreferenceAccount;
        private Provider<ThreadExecutor> InvestmentWalletAdapter;
        private Provider<GetFavoriteServices> J;
        private Provider<BottomSheetOnBoardingContract.View> JsonParseException;
        private Provider<GetFavoriteServiceWithCacheFirst> K;
        private Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetEmptyUserInfo> L;
        private Provider<GetFavoriteServiceRemote> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetFeedConfig> N;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DanaCustomH5> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeaturePresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DynamicUrlWrapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DecodeGnQr> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ScanQrContract.View> NewMerchantCategoryAdapter;
        private Provider<GetInquirySubscriptionPaylaterWithDestination> O;
        private Provider<PostExecutionThread> OtpRegistrationPresenter$input$1;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> OtpRegistrationPresenter$input$2;
        private Provider<GetHighlightPayTransaction> P;
        private Provider<CheckConsultFamilyAccount> PlaceComponentResult;
        private Provider<DeepLinkPayloadModelMapper> PrepareContext;
        private Provider<PushVerifyTracker> PromoCategoryPresenter$1;
        private Provider<GetIsCardBindingV2Enabled> Q;
        private Provider<GetRequestMoneyInfoFeature> QrExpiredActivity;
        private Provider<GetMissionDetail> R;
        private Provider<OauthContract.Presenter> ReferralMapper_Factory;
        private Provider<OauthView> RequestMoneyQrContract$View;
        private Provider<GetListHighlightMyBills> S;
        private Provider<ShortenerRepository> SchedulerPoolFactory;
        private Provider<SaveAlipayConnectServiceFirstTime> SecuritySettingsActivity$createPinLauncher$2$1;
        private Provider<RestoreUrlView> SecuritySettingsActivity$createPinLauncher$2$2;
        private Provider<FeatureContract.Presenter> SendMoneyScenario;
        private Provider<MixpanelDeeplinkTracker> SizeSelectors$OrSelector;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$1 */
        private Provider<SaveShowDialog> f5906x461046d9;

        /* renamed from: SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1$2 */
        private final ServicesModule f5907x461046da;
        private Provider<FeatureServicesHandler> SubSequence;
        private Provider<GetGnCScanBBlacklistedCountry> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetMerchantQrWhitelist> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetMonthlyAmountMyBills> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetNickname> T;
        private Provider<UpdateServiceHighlighted> TrackerKey$GlobalSearchOpenProperties;
        private Provider<GetSingleBalance> TypeProjectionImpl;
        private Provider<MyReferralConsultMapper> TypefaceCompatApi26Impl;
        private Provider<GetNearbyConfig> U;
        private Provider<GetPayRequest> V;
        private Provider<GenerateReferralDeepLink> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetAuthCode> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<SettingRepository> View$OnClickListener;
        private Provider<GetMonthlyWithConsultView> W;
        private Provider<ServicesPresenter> WithdrawSavedCardChannelView;
        private Provider<QrBarcodeRepository> WrappedDrawableState;
        private Provider<GetPayerSplitBillDetail> X;
        private Provider<GetQrisCpmSendmoneyConfig> Y;
        private Provider<GetQrBindingConfig> Z;

        /* renamed from: a */
        private Provider<GetServiceHighlighted> f8219a;
        private Provider<PlayStoreReviewContract.Presenter> access$getCapacity$p;
        private Provider<ReadLinkPropertiesContract.Presenter> access$setShowcaseShowing$p;
        private Provider<GlobalNetworkRepository> access$throwIllegalArgumentType;
        private Provider<RestoreUrl> applyTrimPathIfNeeded;
        private Provider<GetService> b;
        private Provider<GetReferralConsult> c;
        private Provider<MyBillsContract.Presenter> checkRegisteredUserAndSendOtp;
        private Provider<GetUserLoanInfo> connectForeground;
        private Provider<SaveShowToolTip> containsObjectForKey;
        private Provider<GetServicesByKey> d;
        private Provider<GetServicesByName> e;
        private Provider<ReadDeepLinkProperties> encodingStream;
        private Provider<GetSettingByKey> f;
        private Provider<GetQuickBuyMyBills> flip;
        private Provider<GetServicesWithCategory> g;
        private Provider<BottomSheetOnBoardingPresenter> getAuthRequestContext;
        private Provider<FeatureScanQR> getCallingPid;
        private Provider<PromoQuestRepository> getCardNumberOCR;
        private Provider<FeedsConfigRepository> getContainerAuth;
        private Provider<BottomSheetOnBoardingContract.Presenter> getDefaultSenderId;
        private Provider<CheckSplitService> getErrorConfigVersion;
        private Provider<UserConsentRepository> getExceptionOrNull;
        private Provider<CheckoutH5EventContract.View> getFontAssetManager;
        private Provider<PlayStoreReviewContract.View> getIndexName;
        private Provider<GetDefaultServiceWithCategory> getNameOrBuilderList;
        private Provider<GetBottomSheetOnBoarding> getOnBoardingScenario;
        private Provider<ValidateNativelyDecodedQr> getOpPackageName;
        private Provider<ThirdPartyServicesMapper> getPhoneMask;
        private Provider<ReadLinkPropertiesPresenter> getRawPath;
        private Provider<RestoreUrlContract.View> getReadyFragment;
        private Provider<UserEducationRepository> getRecommendationData;
        private Provider<FeaturePromoQuest> getSupportButtonTintMode;
        private Provider<GlobalNetworkContract.View> getTextEndPadding;
        private Provider<GetCashierNativeConfig> getValueOfTouchPositionAbsolute;
        private Provider<GetUserInfoWithKyc> h;
        private Provider<GetUserId> i;
        private Provider<PlayStoreReviewPresenter> initAnimators;
        private Provider<Context> initRecordTimeStamp;
        private Provider<ServicesContract.View> insertActivities;
        private Provider<GetKycLevel> isAuth;
        private Provider<GetPromoCenterVersion> isAuto;
        private Provider<SSLPinningRepository> isInfoWindowShown;
        private Provider<DeepLinkView> isLayoutRequested;
        private Provider<DeepLinkContract.View> isRegionMiniProgram;
        private Provider<H5EventRepository> j;
        private Provider<GlobalNetworkPresenter> k;
        private Provider<GetWhitelistedSubMerchantId> l;
        private Provider<CheckFavoriteServicesFeature> lookAheadTest;
        private Provider<GetWalletOauth> m;
        private Provider<CheckMyBillsVersionConfig> moveToNextValue;
        private Provider<IsAlipayConnectServiceFirstTime> n;
        private Provider<DeviceInformationProvider> newProxyInstance;

        /* renamed from: o */
        private Provider<IsNeedToShowPlayStoreReview> f8220o;
        private Provider<MyBillsRepository> onDecodeSuccess;
        private Provider<UserRepository> onPolygonsChanged;
        private Provider<IsCScanBEnabled> p;
        private Provider<LiteAccountRepository> q;
        private Provider<IsNeedToShowToolTip> r;
        private Provider<FeatureSettingMore> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<PaylaterRepository> f5908reduceIndexedz1zDJgo;
        private Provider<ScanQrContract.Presenter> retainOrRemoveAllInternal;
        private Provider<FeatureContract.View> rotateTo;
        private Provider<IsOfflineF2FPay> s;
        private Provider<CheckDeepLinkActionVisibility> scheduleImpl;
        private Provider<FamilyAccountRepository> secondaryHash;
        private Provider<PayerModelListMapper> setNetAuthId;
        private Provider<GetRawServices> shouldRecycleViewType;
        private Provider<MixpanelGlobalNetworkTracker> t;
        private final MyBillsComponentImpl u;
        private Provider<RestoreUrlPresenter> useDaemonThreadFactory;
        private Provider<MyReferralConsultRepository> v;
        private Provider<Activity> verifyNotNull;
        private Provider<MyBillsPresenter> w;
        private Provider<FeaturePushVerify> whenAvailable;
        private Provider<OauthPresenter> x;
        private Provider<OpenMerchantCashier> y;
        private Provider<OauthRepository> z;

        /* synthetic */ MyBillsComponentImpl(MyBillsModule myBillsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, GlobalNetworkModule globalNetworkModule, ApplicationComponent applicationComponent, byte b) {
            this(myBillsModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, playStoreReviewModules, checkoutH5EventModule, bottomSheetOnBoardingModule, globalNetworkModule, applicationComponent);
        }

        private MyBillsComponentImpl(MyBillsModule myBillsModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, PlayStoreReviewModules playStoreReviewModules, CheckoutH5EventModule checkoutH5EventModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, GlobalNetworkModule globalNetworkModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.u = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.f5907x461046da = servicesModule;
            this.GetContactSyncConfig = checkoutH5EventModule;
            this.InvestmentWalletAdapter = new ThreadExecutorProvider(applicationComponent);
            this.isInfoWindowShown = new SSLPinningRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, featureConfigRepositoryProvider);
            this.s = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.InvestmentWalletAdapter, this.isInfoWindowShown, create);
            this.FlowableKt$toIterable$1 = DoubleCheck.getAuthRequestContext(MyBillsModule_ProvideViewFactory.MyBillsEntityDataFactory(myBillsModule));
            this.newProxyInstance = new DeviceInformationProviderProvider(applicationComponent);
            ProvideMyBillsRepositoryProvider provideMyBillsRepositoryProvider = new ProvideMyBillsRepositoryProvider(applicationComponent);
            this.onDecodeSuccess = provideMyBillsRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = GetMonthlyAmountMyBills_Factory.create(provideMyBillsRepositoryProvider);
            this.S = GetListHighlightMyBills_Factory.create(this.onDecodeSuccess);
            this.flip = GetQuickBuyMyBills_Factory.create(this.onDecodeSuccess);
            this.getErrorConfigVersion = CheckSplitService_Factory.create(this.onDecodeSuccess);
            this.D = GetBizProductOrder_Factory.create(this.onDecodeSuccess);
            this.P = GetHighlightPayTransaction_Factory.create(this.onDecodeSuccess);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.onPolygonsChanged = userRepositoryProvider;
            this.TypeProjectionImpl = GetSingleBalance_Factory.create(userRepositoryProvider);
            this.W = GetMonthlyWithConsultView_Factory.create(this.onDecodeSuccess);
            this.O = GetInquirySubscriptionPaylaterWithDestination_Factory.create(this.onDecodeSuccess);
            MyBillsPresenter_Factory authRequestContext = MyBillsPresenter_Factory.getAuthRequestContext(this.FlowableKt$toIterable$1, this.newProxyInstance, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.S, this.flip, this.getErrorConfigVersion, this.D, this.P, this.TypeProjectionImpl, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.W, this.O);
            this.w = authRequestContext;
            this.checkRegisteredUserAndSendOtp = DoubleCheck.getAuthRequestContext(MyBillsModule_ProvidePresenterFactory.MyBillsEntityDataFactory(myBillsModule, authRequestContext));
            this.initRecordTimeStamp = new ContextProvider(applicationComponent);
            this.insertActivities = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.z = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getExceptionOrNull = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.L = create2;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetAuthCode_Factory.create(this.z, create2);
            ServiceCategoryMapper_Factory authRequestContext2 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.initRecordTimeStamp);
            this.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = authRequestContext2;
            this.getPhoneMask = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getRecommendationData = userEducationRepositoryProvider;
            this.r = IsNeedToShowToolTip_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, userEducationRepositoryProvider);
            this.containsObjectForKey = SaveShowToolTip_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.getRecommendationData);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.ArrayTable$2 = servicesRepositoryProvider;
            this.g = GetServicesWithCategory_Factory.create(servicesRepositoryProvider);
            this.getNameOrBuilderList = GetDefaultServiceWithCategory_Factory.create(this.ArrayTable$2);
            this.M = GetFavoriteServiceRemote_Factory.create(this.ArrayTable$2);
            this.e = GetServicesByName_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.ArrayTable$2);
            this.d = GetServicesByKey_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.ArrayTable$2);
            this.J = GetFavoriteServices_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.ArrayTable$2);
            this.lookAheadTest = CheckFavoriteServicesFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.shouldRecycleViewType = GetRawServices_Factory.create(this.ArrayTable$2);
            this.K = GetFavoriteServiceWithCacheFirst_Factory.create(this.ArrayTable$2);
            this.f8219a = GetServiceHighlighted_Factory.create(this.ArrayTable$2);
            UpdateServiceHighlighted_Factory create3 = UpdateServiceHighlighted_Factory.create(this.ArrayTable$2);
            this.TrackerKey$GlobalSearchOpenProperties = create3;
            this.WithdrawSavedCardChannelView = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.insertActivities, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.getPhoneMask, this.r, this.containsObjectForKey, this.g, this.getNameOrBuilderList, this.M, this.e, this.d, this.J, this.lookAheadTest, this.shouldRecycleViewType, this.K, this.f8219a, create3));
            Provider<Activity> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.verifyNotNull = authRequestContext3;
            Provider<ScanQrView> authRequestContext4 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext3));
            this.CheckPromoQuestFeature = authRequestContext4;
            this.NewMerchantCategoryAdapter = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext4));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.WrappedDrawableState = qrBarcodeRepositoryProvider;
            this.I = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.F = GetDecodedQrisTopUp_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.WrappedDrawableState);
            this.ArrayTable$1 = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.FlowViewUtil$textChanges$2 = GetUserStatusInfo_Factory.create(this.onPolygonsChanged);
            this.getValueOfTouchPositionAbsolute = GetCashierNativeConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = IsNativeDecodeEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            GetDecodeTciCoListConfig_Factory create4 = GetDecodeTciCoListConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.G = create4;
            this.getOpPackageName = ValidateNativelyDecodedQr_Factory.create(create4);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetMerchantQrWhitelist_Factory.create(this.WrappedDrawableState);
            this.Z = GetQrBindingConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.OtpRegistrationPresenter$input$2 = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.f5908reduceIndexedz1zDJgo = providePaylaterRepositoryProvider;
            this.connectForeground = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.Y = GetQrisCpmSendmoneyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.getRecommendationData);
            this.f5906x461046d9 = SaveShowDialog_Factory.create(this.getRecommendationData);
            Provider<ScanQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, this.NewMerchantCategoryAdapter, this.I, this.F, this.ArrayTable$1, this.newProxyInstance, this.FlowViewUtil$textChanges$2, this.getValueOfTouchPositionAbsolute, GetNativelyDecodedQr_Factory.create(), this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, this.getOpPackageName, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.Z, this.OtpRegistrationPresenter$input$2, this.connectForeground, this.Y, this.f5906x461046d9));
            this.ConcurrentKt = authRequestContext5;
            this.retainOrRemoveAllInternal = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext5));
            Provider<RestoreUrlView> authRequestContext6 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp));
            this.SecuritySettingsActivity$createPinLauncher$2$2 = authRequestContext6;
            this.getReadyFragment = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext6));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.SchedulerPoolFactory = shortenerRepositoryProvider;
            RestoreUrl_Factory create5 = RestoreUrl_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, shortenerRepositoryProvider);
            this.applyTrimPathIfNeeded = create5;
            Provider<RestoreUrlPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.getReadyFragment, create5));
            this.useDaemonThreadFactory = authRequestContext7;
            this.InitSecurePreferenceAccount = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext7));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.v = myReferralConsultRepositoryProvider;
            this.c = GetReferralConsult_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShowReferralCodeFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.TypefaceCompatApi26Impl = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = generateLinkRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GenerateReferralDeepLink_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.View$OnClickListener = settingRepositoryProvider;
            this.f = GetSettingByKey_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = productPageManagerProvider;
            this.readMicros = FeatureSettingMore_Factory.PlaceComponentResult(this.f, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.BannerEntityDataFactory_Factory = splitBillRepositoryProvider;
            this.X = GetPayerSplitBillDetail_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, splitBillRepositoryProvider);
            this.setNetAuthId = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.setNetAuthId);
            this.DebugCoroutineInfoImpl = PlaceComponentResult;
            this.C = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.X, PlaceComponentResult);
            this.FillAnimation = GetSplitBillConfig_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            GetRequestMoneyInfoFeature_Factory create6 = GetRequestMoneyInfoFeature_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.QrExpiredActivity = create6;
            Provider<GetSplitBillConfig> provider = this.FillAnimation;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.A = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create6, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.getCardNumberOCR = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create7 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.R = create7;
            this.getSupportButtonTintMode = FeaturePromoQuest_Factory.getAuthRequestContext(create7, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.getCallingPid = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.initRecordTimeStamp));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp);
            this.SizeSelectors$OrSelector = MyBillsEntityDataFactory;
            this.FragmentBottomSheetPaymentSettingBinding = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.secondaryHash = provideFamilyAccountRepositoryProvider;
            this.PlaceComponentResult = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = dynamicUrlWrapperProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.ApiStatus$AvailableSince = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.Q = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.whenAvailable = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.SizeSelectors$OrSelector));
            Provider<FeatureView> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.c, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.TypefaceCompatApi26Impl, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.readMicros, this.C, this.A, this.getSupportButtonTintMode, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, FeatureHome_Factory.MyBillsEntityDataFactory(), this.FragmentBottomSheetPaymentSettingBinding, FeatureKyb_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.connectForeground, FeatureMyBills_Factory.PlaceComponentResult(), this.whenAvailable));
            this.B = authRequestContext8;
            Provider<FeatureContract.View> authRequestContext9 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext8));
            this.rotateTo = authRequestContext9;
            this.SubSequence = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext9, this.d, this.getPhoneMask, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.newProxyInstance));
            this.scheduleImpl = CheckDeepLinkActionVisibility_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.DatabaseTableConfigUtil = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.U = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.getContainerAuth = provideFeedsConfigRepositoryProvider;
            this.N = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.isAuto = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.FlowViewUtil$textChanges$1 = GetUpdateAvailability_Factory.create(this.initRecordTimeStamp);
            this.moveToNextValue = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.PromoCategoryPresenter$1 = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create8 = GetService_Factory.create(this.ArrayTable$2);
            this.b = create8;
            Provider<FeaturePresenter> authRequestContext10 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.rotateTo, this.SubSequence, this.scheduleImpl, this.DatabaseTableConfigUtil, this.U, this.N, this.isAuto, this.FlowViewUtil$textChanges$1, this.moveToNextValue, this.PromoCategoryPresenter$1, create8));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext10;
            this.SendMoneyScenario = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext10));
            OauthView_Factory authRequestContext11 = OauthView_Factory.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding);
            this.RequestMoneyQrContract$View = authRequestContext11;
            this.FlowableConcatMapEagerPublisher = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext11));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.isAuth = GetKycLevel_Factory.create(accountRepositoryProvider);
            this.h = GetUserInfoWithKyc_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.onPolygonsChanged);
            this.T = GetNickname_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.MyBillsEntityDataFactory);
            this.l = GetWhitelistedSubMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.E = GetAddingNameWhitelistedMerchantId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Provider<OauthContract.View> provider2 = this.FlowableConcatMapEagerPublisher;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider2, oauthParamsModelMapper_Factory, this.isAuth, this.h, this.T, this.l, this.E);
            this.x = KClassImpl$Data$declaredNonStaticMembers$2;
            this.ReferralMapper_Factory = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationProvider;
            Provider<DeepLinkView> authRequestContext12 = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.retainOrRemoveAllInternal, this.InitSecurePreferenceAccount, this.SendMoneyScenario, this.ReferralMapper_Factory, this.WithdrawSavedCardChannelView, applicationProvider, this.connectForeground));
            this.isLayoutRequested = authRequestContext12;
            this.isRegionMiniProgram = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext12));
            this.encodingStream = ReadDeepLinkProperties_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.PrepareContext = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.q = liteAccountRepositoryProvider;
            GetUserId_Factory create9 = GetUserId_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, liteAccountRepositoryProvider);
            this.i = create9;
            Provider<ReadLinkPropertiesPresenter> authRequestContext13 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.isRegionMiniProgram, this.encodingStream, this.PrepareContext, create9, this.SizeSelectors$OrSelector));
            this.getRawPath = authRequestContext13;
            this.access$setShowcaseShowing$p = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext13));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.j = h5eventRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetCheckoutH5Event_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, h5eventRepositoryProvider);
            this.getFontAssetManager = CheckoutH5EventModule_ProvideViewFactory.PlaceComponentResult(checkoutH5EventModule);
            this.JsonParseException = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.getOnBoardingScenario = GetBottomSheetOnBoarding_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.getRecommendationData);
            SaveDisplayBottomSheetOnBoarding_Factory create10 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.getRecommendationData);
            this.BaseSocialFeedContract$Presenter = create10;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.JsonParseException, this.getOnBoardingScenario, create10);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
            this.getDefaultSenderId = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory2));
            this.getTextEndPadding = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = globalNetworkRepositoryProvider;
            this.p = IsCScanBEnabled_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, globalNetworkRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DecodeGnQr_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.access$throwIllegalArgumentType);
            this.y = OpenMerchantCashier_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.access$throwIllegalArgumentType);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetGnCScanBBlacklistedCountry_Factory.create(this.access$throwIllegalArgumentType);
            this.t = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(this.initRecordTimeStamp);
            this.H = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.access$throwIllegalArgumentType);
            this.n = IsAlipayConnectServiceFirstTime_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.access$throwIllegalArgumentType);
            this.SecuritySettingsActivity$createPinLauncher$2$1 = SaveAlipayConnectServiceFirstTime_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.access$throwIllegalArgumentType);
            this.m = GetWalletOauth_Factory.create(this.access$throwIllegalArgumentType);
            GetPayRequest_Factory create11 = GetPayRequest_Factory.create(this.access$throwIllegalArgumentType);
            this.V = create11;
            Provider<GlobalNetworkPresenter> authRequestContext14 = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.getTextEndPadding, this.p, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.y, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.h, this.t, this.H, this.n, this.SecuritySettingsActivity$createPinLauncher$2$1, this.m, this.VerifyPinStateManager$executeRiskChallenge$2$2, create11));
            this.k = authRequestContext14;
            this.CYFMonitor$ChallengeActionCallback = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext14));
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.FlowableReduce$ReduceSubscriber = playStoreReviewRepositoryProvider;
            this.f8220o = IsNeedToShowPlayStoreReview_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, playStoreReviewRepositoryProvider);
            this.ArrayTable$3 = SaveLastPlayStoreReviewShow_Factory.create(this.InvestmentWalletAdapter, this.OtpRegistrationPresenter$input$1, this.FlowableReduce$ReduceSubscriber);
            Provider<PlayStoreReviewContract.View> authRequestContext15 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.getIndexName = authRequestContext15;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory2 = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.f8220o, this.ArrayTable$3, authRequestContext15);
            this.initAnimators = MyBillsEntityDataFactory2;
            this.access$getCapacity$p = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory2));
        }

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
        public static final class ProvideMyBillsRepositoryProvider implements Provider<MyBillsRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideMyBillsRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyBillsRepository get() {
                return (MyBillsRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.initAnimators());
            }
        }

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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent PlaceComponentResult;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* loaded from: classes5.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SubSequence());
            }
        }

        /* loaded from: classes5.dex */
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

        @Override // id.dana.mybills.di.MyBillsComponent
        public final void PlaceComponentResult(MyBillsActivity myBillsActivity) {
            ((BaseActivity) myBillsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(myBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            MyBillsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myBillsActivity, this.checkRegisteredUserAndSendOtp.get());
            MyBillsActivity_MembersInjector.MyBillsEntityDataFactory(myBillsActivity, ServicesModule_ProvidePresenterFactory.getAuthRequestContext(this.f5907x461046da, this.WithdrawSavedCardChannelView.get()));
            myBillsActivity.readLinkPropertiesPresenter = this.access$setShowcaseShowing$p.get();
            MyBillsActivity_MembersInjector.getAuthRequestContext(myBillsActivity, CheckoutH5EventModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.GetContactSyncConfig, new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.AppCompatEmojiTextHelper), DoubleCheck.MyBillsEntityDataFactory(this.getFontAssetManager))));
            MyBillsActivity_MembersInjector.MyBillsEntityDataFactory(myBillsActivity, this.getDefaultSenderId.get());
            MyBillsActivity_MembersInjector.MyBillsEntityDataFactory(myBillsActivity, this.CYFMonitor$ChallengeActionCallback.get());
            MyBillsActivity_MembersInjector.PlaceComponentResult(myBillsActivity, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            MyBillsActivity_MembersInjector.getAuthRequestContext(myBillsActivity, this.access$getCapacity$p.get());
            MyBillsActivity_MembersInjector.PlaceComponentResult(myBillsActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext()));
            MyBillsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(myBillsActivity, new CashierEventHandler(DoubleCheck.MyBillsEntityDataFactory(this.getValueOfTouchPositionAbsolute)));
            MyBillsActivity_MembersInjector.PlaceComponentResult(myBillsActivity, this.SendMoneyScenario.get());
        }

        @Override // id.dana.mybills.di.MyBillsComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsActivity addNewBillsActivity) {
            ((BaseActivity) addNewBillsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(addNewBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(addNewBillsActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            AddNewBillsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(addNewBillsActivity, this.checkRegisteredUserAndSendOtp.get());
            AddNewBillsActivity_MembersInjector.MyBillsEntityDataFactory(addNewBillsActivity, ServicesModule_ProvidePresenterFactory.getAuthRequestContext(this.f5907x461046da, this.WithdrawSavedCardChannelView.get()));
        }
    }
}
