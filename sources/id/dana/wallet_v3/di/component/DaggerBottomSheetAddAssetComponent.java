package id.dana.wallet_v3.di.component;

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
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.AnnouncementModule;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OauthModule_ProvidePresenterFactory;
import id.dana.di.modules.OauthModule_ProvideViewFactory;
import id.dana.di.modules.SavingModule;
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
import id.dana.domain.pocket.PocketRepository;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.pocket.interactor.GetLoyaltyToken_Factory;
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
import id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService_Factory;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices_Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
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
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.di.module.BottomSheetAddAssetModule;
import id.dana.wallet_v3.di.module.BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerBottomSheetAddAssetComponent {
    private DaggerBottomSheetAddAssetComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private BottomSheetAddAssetModule bottomSheetAddAssetModule;
        private DeepLinkModule deepLinkModule;
        private FeatureModule featureModule;
        private OauthModule oauthModule;
        private RestoreUrlModule restoreUrlModule;
        private ScanQrModule scanQrModule;
        private ServicesModule servicesModule;

        private Builder() {
        }

        public final Builder bottomSheetAddAssetModule(BottomSheetAddAssetModule bottomSheetAddAssetModule) {
            this.bottomSheetAddAssetModule = (BottomSheetAddAssetModule) Preconditions.getAuthRequestContext(bottomSheetAddAssetModule);
            return this;
        }

        @Deprecated
        public final Builder bottomSheetOnBoardingModule(BottomSheetOnBoardingModule bottomSheetOnBoardingModule) {
            Preconditions.getAuthRequestContext(bottomSheetOnBoardingModule);
            return this;
        }

        public final Builder deepLinkModule(DeepLinkModule deepLinkModule) {
            this.deepLinkModule = (DeepLinkModule) Preconditions.getAuthRequestContext(deepLinkModule);
            return this;
        }

        public final Builder scanQrModule(ScanQrModule scanQrModule) {
            this.scanQrModule = (ScanQrModule) Preconditions.getAuthRequestContext(scanQrModule);
            return this;
        }

        public final Builder restoreUrlModule(RestoreUrlModule restoreUrlModule) {
            this.restoreUrlModule = (RestoreUrlModule) Preconditions.getAuthRequestContext(restoreUrlModule);
            return this;
        }

        public final Builder featureModule(FeatureModule featureModule) {
            this.featureModule = (FeatureModule) Preconditions.getAuthRequestContext(featureModule);
            return this;
        }

        public final Builder oauthModule(OauthModule oauthModule) {
            this.oauthModule = (OauthModule) Preconditions.getAuthRequestContext(oauthModule);
            return this;
        }

        public final Builder servicesModule(ServicesModule servicesModule) {
            this.servicesModule = (ServicesModule) Preconditions.getAuthRequestContext(servicesModule);
            return this;
        }

        @Deprecated
        public final Builder announcementModule(AnnouncementModule announcementModule) {
            Preconditions.getAuthRequestContext(announcementModule);
            return this;
        }

        @Deprecated
        public final Builder globalNetworkModule(GlobalNetworkModule globalNetworkModule) {
            Preconditions.getAuthRequestContext(globalNetworkModule);
            return this;
        }

        @Deprecated
        public final Builder savingModule(SavingModule savingModule) {
            Preconditions.getAuthRequestContext(savingModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final BottomSheetAddAssetComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.bottomSheetAddAssetModule, BottomSheetAddAssetModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.deepLinkModule, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.scanQrModule, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.restoreUrlModule, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.featureModule, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.oauthModule, OauthModule.class);
            if (this.servicesModule == null) {
                this.servicesModule = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new BottomSheetAddAssetComponentImpl(this.bottomSheetAddAssetModule, this.deepLinkModule, this.scanQrModule, this.restoreUrlModule, this.featureModule, this.oauthModule, this.servicesModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BottomSheetAddAssetComponentImpl implements BottomSheetAddAssetComponent {
        private Provider<AccountRepository> accountRepositoryProvider;
        private final ApplicationComponent applicationComponent;
        private Provider<Application> applicationProvider;
        private final BottomSheetAddAssetComponentImpl bottomSheetAddAssetComponentImpl;
        private Provider<CheckConsultFamilyAccount> checkConsultFamilyAccountProvider;
        private Provider<CheckDeepLinkActionVisibility> checkDeepLinkActionVisibilityProvider;
        private Provider<CheckFavoriteServicesFeature> checkFavoriteServicesFeatureProvider;
        private Provider<CheckMyBillsVersionConfig> checkMyBillsVersionConfigProvider;
        private Provider<CheckShowReferralCodeFeature> checkShowReferralCodeFeatureProvider;
        private Provider<CheckWhitelistedValidDomain> checkWhitelistedValidDomainProvider;
        private Provider<Context> contextProvider;
        private Provider<DanaCustomH5> danaCustomH5Provider;
        private Provider<DeepLinkPayloadModelMapper> deepLinkPayloadModelMapperProvider;
        private Provider<DeepLinkView> deepLinkViewProvider;
        private Provider<DeviceInformationProvider> deviceInformationProvider;
        private Provider<DynamicUrlWrapper> dynamicUrlWrapperProvider;
        private Provider<FeatureCardBinding> featureCardBindingProvider;
        private Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
        private Provider<FeatureFamilyAccount> featureFamilyAccountProvider;
        private Provider<FeatureOauth> featureOauthProvider;
        private Provider<FeaturePresenter> featurePresenterProvider;
        private Provider<FeaturePromoQuest> featurePromoQuestProvider;
        private Provider<FeaturePushVerify> featurePushVerifyProvider;
        private Provider<FeatureScanQR> featureScanQRProvider;
        private Provider<FeatureServicesHandler> featureServicesHandlerProvider;
        private Provider<FeatureSettingMore> featureSettingMoreProvider;
        private Provider<FeatureSplitBillPay> featureSplitBillPayProvider;
        private Provider<FeatureSplitBill> featureSplitBillProvider;
        private Provider<FeatureView> featureViewProvider;
        private Provider<GenerateLinkRepository> generateLinkRepositoryProvider;
        private Provider<GenerateReferralDeepLink> generateReferralDeepLinkProvider;
        private Provider<GetAddingNameWhitelistedMerchantId> getAddingNameWhitelistedMerchantIdProvider;
        private Provider<GetAuthCode> getAuthCodeProvider;
        private Provider<GetBottomSheetAllService> getBottomSheetAllServiceProvider;
        private Provider<GetBottomSheetServices> getBottomSheetServicesProvider;
        private Provider<GetCashierNativeConfig> getCashierNativeConfigProvider;
        private Provider<GetCheckoutH5Event> getCheckoutH5EventProvider;
        private Provider<GetDecodeTciCoListConfig> getDecodeTciCoListConfigProvider;
        private Provider<GetDecodedQrBarcode> getDecodedQrBarcodeProvider;
        private Provider<GetDecodedQrisTopUp> getDecodedQrisTopUpProvider;
        private Provider<GetDefaultServiceWithCategory> getDefaultServiceWithCategoryProvider;
        private Provider<GetEmptyUserInfo> getEmptyUserInfoProvider;
        private Provider<GetFavoriteServiceRemote> getFavoriteServiceRemoteProvider;
        private Provider<GetFavoriteServiceWithCacheFirst> getFavoriteServiceWithCacheFirstProvider;
        private Provider<GetFavoriteServices> getFavoriteServicesProvider;
        private Provider<GetFeedConfig> getFeedConfigProvider;
        private Provider<GetIsCardBindingV2Enabled> getIsCardBindingV2EnabledProvider;
        private Provider<GetKycLevel> getKycLevelProvider;
        private Provider<GetLoyaltyToken> getLoyaltyTokenProvider;
        private Provider<GetMerchantQrWhitelist> getMerchantQrWhitelistProvider;
        private Provider<GetMissionDetail> getMissionDetailProvider;
        private Provider<GetNearbyConfig> getNearbyConfigProvider;
        private Provider<GetNickname> getNicknameProvider;
        private Provider<GetPayerSplitBillDetail> getPayerSplitBillDetailProvider;
        private Provider<GetPromoCenterVersion> getPromoCenterVersionProvider;
        private Provider<GetQrBindingConfig> getQrBindingConfigProvider;
        private Provider<GetQrisCpmSendmoneyConfig> getQrisCpmSendmoneyConfigProvider;
        private Provider<GetRawServices> getRawServicesProvider;
        private Provider<GetReferralConsult> getReferralConsultProvider;
        private Provider<GetRequestMoneyInfoFeature> getRequestMoneyInfoFeatureProvider;
        private Provider<GetServiceHighlighted> getServiceHighlightedProvider;
        private Provider<GetService> getServiceProvider;
        private Provider<GetServicesByKey> getServicesByKeyProvider;
        private Provider<GetServicesByName> getServicesByNameProvider;
        private Provider<GetServicesWithCategory> getServicesWithCategoryProvider;
        private Provider<GetSettingByKey> getSettingByKeyProvider;
        private Provider<GetSplitBillConfig> getSplitBillConfigProvider;
        private Provider<GetUpdateAvailability> getUpdateAvailabilityProvider;
        private Provider<GetUserId> getUserIdProvider;
        private Provider<GetUserInfoWithKyc> getUserInfoWithKycProvider;
        private Provider<GetUserLoanInfo> getUserLoanInfoProvider;
        private Provider<GetUserStatusInfo> getUserStatusInfoProvider;
        private Provider<GetWhitelistedSubMerchantId> getWhitelistedSubMerchantIdProvider;
        private Provider<H5EventRepository> h5eventRepositoryProvider;
        private Provider<IsFeaturePaylaterCicilScannerEnabled> isFeaturePaylaterCicilScannerEnabledProvider;
        private Provider<IsNativeDecodeEnabled> isNativeDecodeEnabledProvider;
        private Provider<IsNeedToShowToolTip> isNeedToShowToolTipProvider;
        private Provider<LiteAccountRepository> liteAccountRepositoryProvider;
        private Provider<MixpanelDeeplinkTracker> mixpanelDeeplinkTrackerProvider;
        private Provider<MyReferralConsultMapper> myReferralConsultMapperProvider;
        private Provider<MyReferralConsultRepository> myReferralConsultRepositoryProvider;
        private Provider<OauthPresenter> oauthPresenterProvider;
        private Provider<OauthRepository> oauthRepositoryProvider;
        private Provider<OauthView> oauthViewProvider;
        private Provider<PayerModelListMapper> payerModelListMapperProvider;
        private Provider<PocketRepository> pocketRepositoryProvider;
        private Provider<PostExecutionThread> postExecutionThreadProvider;
        private Provider<ProductPageManager> productPageManagerProvider;
        private Provider<PromoQuestRepository> promoQuestRepositoryProvider;
        private Provider<Activity> provideActivityProvider;
        private Provider<FamilyAccountRepository> provideFamilyAccountRepositoryProvider;
        private Provider<FeedsConfigRepository> provideFeedsConfigRepositoryProvider;
        private Provider<CardBindingRepository> provideNewCardBindingRepositoryProvider;
        private Provider<PaylaterRepository> providePaylaterRepositoryProvider;
        private Provider<ScanQrContract.Presenter> providePresenterProvider;
        private Provider<RestoreUrlContract.Presenter> providePresenterProvider2;
        private Provider<FeatureContract.Presenter> providePresenterProvider3;
        private Provider<OauthContract.Presenter> providePresenterProvider4;
        private Provider<PushVerifyTracker> providePushVerifyTrackerProvider;
        private Provider<ReadLinkPropertiesContract.Presenter> provideReadPropertiesPresenterProvider;
        private Provider<BottomSheetAddAssetContract.View> provideView$app_productionReleaseProvider;
        private Provider<ScanQrContract.View> provideViewProvider;
        private Provider<RestoreUrlContract.View> provideViewProvider2;
        private Provider<FeatureContract.View> provideViewProvider3;
        private Provider<OauthContract.View> provideViewProvider4;
        private Provider<ServicesContract.View> provideViewProvider5;
        private Provider<DeepLinkContract.View> provideViewProvider6;
        private Provider<WalletConfigRepository> provideWalletConfigRepositoryProvider;
        private Provider<QrBarcodeRepository> qrBarcodeRepositoryProvider;
        private Provider<ReadDeepLinkProperties> readDeepLinkPropertiesProvider;
        private Provider<ReadLinkPropertiesPresenter> readLinkPropertiesPresenterProvider;
        private Provider<RestoreUrlPresenter> restoreUrlPresenterProvider;
        private Provider<RestoreUrl> restoreUrlProvider;
        private Provider<RestoreUrlView> restoreUrlViewProvider;
        private Provider<SaveShowDialog> saveShowDialogProvider;
        private Provider<SaveShowToolTip> saveShowToolTipProvider;
        private Provider<ScanQrPresenter> scanQrPresenterProvider;
        private Provider<ScanQrView> scanQrViewProvider;
        private Provider<ScanResultMapper> scanResultMapperProvider;
        private Provider<ServiceCategoryMapper> serviceCategoryMapperProvider;
        private Provider<ServicesPresenter> servicesPresenterProvider;
        private Provider<ServicesRepository> servicesRepositoryProvider;
        private Provider<SettingRepository> settingRepositoryProvider;
        private Provider<ShortenerRepository> shortenerRepositoryProvider;
        private Provider<SplitBillHistoryToSplitBillModelMapper> splitBillHistoryToSplitBillModelMapperProvider;
        private Provider<SplitBillRepository> splitBillRepositoryProvider;
        private Provider<ThirdPartyServicesMapper> thirdPartyServicesMapperProvider;
        private Provider<ThreadExecutor> threadExecutorProvider;
        private Provider<UpdateServiceHighlighted> updateServiceHighlightedProvider;
        private Provider<UserConsentRepository> userConsentRepositoryProvider;
        private Provider<UserEducationRepository> userEducationRepositoryProvider;
        private Provider<UserRepository> userRepositoryProvider;
        private Provider<ValidateNativelyDecodedQr> validateNativelyDecodedQrProvider;

        private BottomSheetAddAssetComponentImpl(BottomSheetAddAssetModule bottomSheetAddAssetModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            this.bottomSheetAddAssetComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(bottomSheetAddAssetModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
            initialize2(bottomSheetAddAssetModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, servicesModule, applicationComponent);
        }

        private ServiceCategoryMapper serviceCategoryMapper() {
            return new ServiceCategoryMapper((Context) Preconditions.PlaceComponentResult(this.applicationComponent.moveToNextValue()));
        }

        private ThirdPartyServicesMapper thirdPartyServicesMapper() {
            return new ThirdPartyServicesMapper(serviceCategoryMapper());
        }

        private BottomSheetAddAssetPresenter bottomSheetAddAssetPresenter() {
            return new BottomSheetAddAssetPresenter(DoubleCheck.MyBillsEntityDataFactory(this.provideView$app_productionReleaseProvider), DoubleCheck.MyBillsEntityDataFactory(this.getBottomSheetServicesProvider), thirdPartyServicesMapper(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthCodeProvider), DoubleCheck.MyBillsEntityDataFactory(this.getKycLevelProvider), DoubleCheck.MyBillsEntityDataFactory(this.getLoyaltyTokenProvider), DoubleCheck.MyBillsEntityDataFactory(this.getBottomSheetAllServiceProvider));
        }

        private WalletH5ServicesImplementation walletH5ServicesImplementation() {
            return new WalletH5ServicesImplementation(DoubleCheck.MyBillsEntityDataFactory(this.getCheckoutH5EventProvider));
        }

        private void initialize(BottomSheetAddAssetModule bottomSheetAddAssetModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            this.provideView$app_productionReleaseProvider = BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory.create(bottomSheetAddAssetModule);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.provideWalletConfigRepositoryProvider = provideWalletConfigRepositoryProvider;
            this.getBottomSheetServicesProvider = GetBottomSheetServices_Factory.create(provideWalletConfigRepositoryProvider);
            this.oauthRepositoryProvider = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.userConsentRepositoryProvider = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.getEmptyUserInfoProvider = create;
            this.getAuthCodeProvider = GetAuthCode_Factory.create(this.oauthRepositoryProvider, create);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.accountRepositoryProvider = accountRepositoryProvider;
            this.getKycLevelProvider = GetKycLevel_Factory.create(accountRepositoryProvider);
            PocketRepositoryProvider pocketRepositoryProvider = new PocketRepositoryProvider(applicationComponent);
            this.pocketRepositoryProvider = pocketRepositoryProvider;
            this.getLoyaltyTokenProvider = GetLoyaltyToken_Factory.create(pocketRepositoryProvider);
            this.getBottomSheetAllServiceProvider = GetBottomSheetAllService_Factory.create(this.provideWalletConfigRepositoryProvider);
            this.contextProvider = new ContextProvider(applicationComponent);
            Provider<Activity> authRequestContext = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideActivityFactory.getAuthRequestContext(scanQrModule));
            this.provideActivityProvider = authRequestContext;
            Provider<ScanQrView> authRequestContext2 = DoubleCheck.getAuthRequestContext(ScanQrView_Factory.MyBillsEntityDataFactory(authRequestContext));
            this.scanQrViewProvider = authRequestContext2;
            this.provideViewProvider = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvideViewFactory.getAuthRequestContext(scanQrModule, authRequestContext2));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.qrBarcodeRepositoryProvider = qrBarcodeRepositoryProvider;
            this.getDecodedQrBarcodeProvider = GetDecodedQrBarcode_Factory.create(qrBarcodeRepositoryProvider);
            this.threadExecutorProvider = new ThreadExecutorProvider(applicationComponent);
            PostExecutionThreadProvider postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            this.postExecutionThreadProvider = postExecutionThreadProvider;
            this.getDecodedQrisTopUpProvider = GetDecodedQrisTopUp_Factory.create(this.threadExecutorProvider, postExecutionThreadProvider, this.qrBarcodeRepositoryProvider);
            this.scanResultMapperProvider = ScanResultMapper_Factory.MyBillsEntityDataFactory(BaseResponseMapper_Factory.MyBillsEntityDataFactory());
            this.deviceInformationProvider = new DeviceInformationProviderProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.userRepositoryProvider = userRepositoryProvider;
            this.getUserStatusInfoProvider = GetUserStatusInfo_Factory.create(userRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.featureConfigRepositoryProvider = featureConfigRepositoryProvider;
            this.getCashierNativeConfigProvider = GetCashierNativeConfig_Factory.create(featureConfigRepositoryProvider);
            this.isNativeDecodeEnabledProvider = IsNativeDecodeEnabled_Factory.create(this.featureConfigRepositoryProvider);
            GetDecodeTciCoListConfig_Factory create2 = GetDecodeTciCoListConfig_Factory.create(this.featureConfigRepositoryProvider);
            this.getDecodeTciCoListConfigProvider = create2;
            this.validateNativelyDecodedQrProvider = ValidateNativelyDecodedQr_Factory.create(create2);
            this.getMerchantQrWhitelistProvider = GetMerchantQrWhitelist_Factory.create(this.qrBarcodeRepositoryProvider);
            this.getQrBindingConfigProvider = GetQrBindingConfig_Factory.create(this.featureConfigRepositoryProvider);
            this.isFeaturePaylaterCicilScannerEnabledProvider = IsFeaturePaylaterCicilScannerEnabled_Factory.create(this.featureConfigRepositoryProvider);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.providePaylaterRepositoryProvider = providePaylaterRepositoryProvider;
            this.getUserLoanInfoProvider = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.userEducationRepositoryProvider = userEducationRepositoryProvider;
            this.getQrisCpmSendmoneyConfigProvider = GetQrisCpmSendmoneyConfig_Factory.create(this.featureConfigRepositoryProvider, userEducationRepositoryProvider);
            this.saveShowDialogProvider = SaveShowDialog_Factory.create(this.userEducationRepositoryProvider);
            Provider<ScanQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ScanQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.contextProvider, this.provideViewProvider, this.getDecodedQrBarcodeProvider, this.getDecodedQrisTopUpProvider, this.scanResultMapperProvider, this.deviceInformationProvider, this.getUserStatusInfoProvider, this.getCashierNativeConfigProvider, GetNativelyDecodedQr_Factory.create(), this.isNativeDecodeEnabledProvider, this.validateNativelyDecodedQrProvider, this.getMerchantQrWhitelistProvider, this.getQrBindingConfigProvider, this.isFeaturePaylaterCicilScannerEnabledProvider, this.getUserLoanInfoProvider, this.getQrisCpmSendmoneyConfigProvider, this.saveShowDialogProvider));
            this.scanQrPresenterProvider = authRequestContext3;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(ScanQrModule_ProvidePresenterFactory.MyBillsEntityDataFactory(scanQrModule, authRequestContext3));
            Provider<RestoreUrlView> authRequestContext4 = DoubleCheck.getAuthRequestContext(RestoreUrlView_Factory.MyBillsEntityDataFactory(this.contextProvider));
            this.restoreUrlViewProvider = authRequestContext4;
            this.provideViewProvider2 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvideViewFactory.PlaceComponentResult(restoreUrlModule, authRequestContext4));
            ShortenerRepositoryProvider shortenerRepositoryProvider = new ShortenerRepositoryProvider(applicationComponent);
            this.shortenerRepositoryProvider = shortenerRepositoryProvider;
            RestoreUrl_Factory create3 = RestoreUrl_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, shortenerRepositoryProvider);
            this.restoreUrlProvider = create3;
            Provider<RestoreUrlPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(RestoreUrlPresenter_Factory.MyBillsEntityDataFactory(this.provideViewProvider2, create3));
            this.restoreUrlPresenterProvider = authRequestContext5;
            this.providePresenterProvider2 = DoubleCheck.getAuthRequestContext(RestoreUrlModule_ProvidePresenterFactory.PlaceComponentResult(restoreUrlModule, authRequestContext5));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.myReferralConsultRepositoryProvider = myReferralConsultRepositoryProvider;
            this.getReferralConsultProvider = GetReferralConsult_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, myReferralConsultRepositoryProvider);
            this.checkShowReferralCodeFeatureProvider = CheckShowReferralCodeFeature_Factory.create(this.featureConfigRepositoryProvider);
            this.myReferralConsultMapperProvider = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.generateLinkRepositoryProvider = generateLinkRepositoryProvider;
            this.generateReferralDeepLinkProvider = GenerateReferralDeepLink_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.settingRepositoryProvider = settingRepositoryProvider;
            this.getSettingByKeyProvider = GetSettingByKey_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.productPageManagerProvider = productPageManagerProvider;
            this.featureSettingMoreProvider = FeatureSettingMore_Factory.PlaceComponentResult(this.getSettingByKeyProvider, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.splitBillRepositoryProvider = splitBillRepositoryProvider;
            this.getPayerSplitBillDetailProvider = GetPayerSplitBillDetail_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, splitBillRepositoryProvider);
            this.payerModelListMapperProvider = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.payerModelListMapperProvider);
            this.splitBillHistoryToSplitBillModelMapperProvider = PlaceComponentResult;
            this.featureSplitBillPayProvider = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.getPayerSplitBillDetailProvider, PlaceComponentResult);
            this.getSplitBillConfigProvider = GetSplitBillConfig_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.featureConfigRepositoryProvider);
            GetRequestMoneyInfoFeature_Factory create4 = GetRequestMoneyInfoFeature_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.featureConfigRepositoryProvider);
            this.getRequestMoneyInfoFeatureProvider = create4;
            Provider<GetSplitBillConfig> provider = this.getSplitBillConfigProvider;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.featureSplitBillProvider = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create4, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.promoQuestRepositoryProvider = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create5 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.getMissionDetailProvider = create5;
            this.featurePromoQuestProvider = FeaturePromoQuest_Factory.getAuthRequestContext(create5, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.featureScanQRProvider = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            this.danaCustomH5Provider = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(this.contextProvider));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.contextProvider);
            this.mixpanelDeeplinkTrackerProvider = MyBillsEntityDataFactory;
            this.featureOauthProvider = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.provideFamilyAccountRepositoryProvider = provideFamilyAccountRepositoryProvider;
            this.checkConsultFamilyAccountProvider = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.dynamicUrlWrapperProvider = dynamicUrlWrapperProvider;
            this.featureFamilyAccountProvider = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.checkConsultFamilyAccountProvider, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.provideNewCardBindingRepositoryProvider = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.getIsCardBindingV2EnabledProvider = BuiltInFictitiousFunctionClassFactory;
            this.featureCardBindingProvider = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            this.featurePushVerifyProvider = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.mixpanelDeeplinkTrackerProvider));
            Provider<FeatureView> authRequestContext6 = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.getReferralConsultProvider, this.checkShowReferralCodeFeatureProvider, this.myReferralConsultMapperProvider, this.generateReferralDeepLinkProvider, this.featureSettingMoreProvider, this.featureSplitBillPayProvider, this.featureSplitBillProvider, this.featurePromoQuestProvider, this.featureScanQRProvider, this.danaCustomH5Provider, FeatureHome_Factory.MyBillsEntityDataFactory(), this.featureOauthProvider, FeatureKyb_Factory.getAuthRequestContext(), this.featureFamilyAccountProvider, this.featureCardBindingProvider, this.getUserLoanInfoProvider, FeatureMyBills_Factory.PlaceComponentResult(), this.featurePushVerifyProvider));
            this.featureViewProvider = authRequestContext6;
            this.provideViewProvider3 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext6));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.servicesRepositoryProvider = servicesRepositoryProvider;
            this.getServicesByKeyProvider = GetServicesByKey_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext7 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.contextProvider);
            this.serviceCategoryMapperProvider = authRequestContext7;
            ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory2 = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext7);
            this.thirdPartyServicesMapperProvider = BuiltInFictitiousFunctionClassFactory2;
            this.featureServicesHandlerProvider = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.provideViewProvider3, this.getServicesByKeyProvider, BuiltInFictitiousFunctionClassFactory2, this.getAuthCodeProvider, this.deviceInformationProvider));
            this.checkDeepLinkActionVisibilityProvider = CheckDeepLinkActionVisibility_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.featureConfigRepositoryProvider);
            this.checkWhitelistedValidDomainProvider = CheckWhitelistedValidDomain_Factory.create(this.featureConfigRepositoryProvider);
            this.getNearbyConfigProvider = GetNearbyConfig_Factory.create(this.featureConfigRepositoryProvider);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.provideFeedsConfigRepositoryProvider = provideFeedsConfigRepositoryProvider;
            this.getFeedConfigProvider = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.getPromoCenterVersionProvider = GetPromoCenterVersion_Factory.create(this.featureConfigRepositoryProvider);
            this.getUpdateAvailabilityProvider = GetUpdateAvailability_Factory.create(this.contextProvider);
            this.checkMyBillsVersionConfigProvider = CheckMyBillsVersionConfig_Factory.create(this.featureConfigRepositoryProvider);
            this.providePushVerifyTrackerProvider = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create6 = GetService_Factory.create(this.servicesRepositoryProvider);
            this.getServiceProvider = create6;
            Provider<FeaturePresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.provideViewProvider3, this.featureServicesHandlerProvider, this.checkDeepLinkActionVisibilityProvider, this.checkWhitelistedValidDomainProvider, this.getNearbyConfigProvider, this.getFeedConfigProvider, this.getPromoCenterVersionProvider, this.getUpdateAvailabilityProvider, this.checkMyBillsVersionConfigProvider, this.providePushVerifyTrackerProvider, create6));
            this.featurePresenterProvider = authRequestContext8;
            this.providePresenterProvider3 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext8));
            OauthView_Factory authRequestContext9 = OauthView_Factory.getAuthRequestContext(this.featureOauthProvider);
            this.oauthViewProvider = authRequestContext9;
            this.provideViewProvider4 = DoubleCheck.getAuthRequestContext(OauthModule_ProvideViewFactory.getAuthRequestContext(oauthModule, authRequestContext9));
        }

        private void initialize2(BottomSheetAddAssetModule bottomSheetAddAssetModule, DeepLinkModule deepLinkModule, ScanQrModule scanQrModule, RestoreUrlModule restoreUrlModule, FeatureModule featureModule, OauthModule oauthModule, ServicesModule servicesModule, ApplicationComponent applicationComponent) {
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory;
            OauthParamsModelMapper_Factory oauthParamsModelMapper_Factory2;
            this.getUserInfoWithKycProvider = GetUserInfoWithKyc_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.userRepositoryProvider);
            this.getNicknameProvider = GetNickname_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.accountRepositoryProvider);
            this.getWhitelistedSubMerchantIdProvider = GetWhitelistedSubMerchantId_Factory.create(this.featureConfigRepositoryProvider);
            this.getAddingNameWhitelistedMerchantIdProvider = GetAddingNameWhitelistedMerchantId_Factory.create(this.featureConfigRepositoryProvider);
            Provider<OauthContract.View> provider = this.provideViewProvider4;
            oauthParamsModelMapper_Factory = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = OauthPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provider, oauthParamsModelMapper_Factory, this.getKycLevelProvider, this.getUserInfoWithKycProvider, this.getNicknameProvider, this.getWhitelistedSubMerchantIdProvider, this.getAddingNameWhitelistedMerchantIdProvider);
            this.oauthPresenterProvider = KClassImpl$Data$declaredNonStaticMembers$2;
            this.providePresenterProvider4 = DoubleCheck.getAuthRequestContext(OauthModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(oauthModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.provideViewProvider5 = ServicesModule_ProvideViewFactory.MyBillsEntityDataFactory(servicesModule);
            this.isNeedToShowToolTipProvider = IsNeedToShowToolTip_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.userEducationRepositoryProvider);
            this.saveShowToolTipProvider = SaveShowToolTip_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.userEducationRepositoryProvider);
            this.getServicesWithCategoryProvider = GetServicesWithCategory_Factory.create(this.servicesRepositoryProvider);
            this.getDefaultServiceWithCategoryProvider = GetDefaultServiceWithCategory_Factory.create(this.servicesRepositoryProvider);
            this.getFavoriteServiceRemoteProvider = GetFavoriteServiceRemote_Factory.create(this.servicesRepositoryProvider);
            this.getServicesByNameProvider = GetServicesByName_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.servicesRepositoryProvider);
            this.getFavoriteServicesProvider = GetFavoriteServices_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, this.servicesRepositoryProvider);
            this.checkFavoriteServicesFeatureProvider = CheckFavoriteServicesFeature_Factory.create(this.featureConfigRepositoryProvider);
            this.getRawServicesProvider = GetRawServices_Factory.create(this.servicesRepositoryProvider);
            this.getFavoriteServiceWithCacheFirstProvider = GetFavoriteServiceWithCacheFirst_Factory.create(this.servicesRepositoryProvider);
            this.getServiceHighlightedProvider = GetServiceHighlighted_Factory.create(this.servicesRepositoryProvider);
            UpdateServiceHighlighted_Factory create = UpdateServiceHighlighted_Factory.create(this.servicesRepositoryProvider);
            this.updateServiceHighlightedProvider = create;
            this.servicesPresenterProvider = DoubleCheck.getAuthRequestContext(ServicesPresenter_Factory.PlaceComponentResult(this.contextProvider, this.provideViewProvider5, this.getAuthCodeProvider, this.thirdPartyServicesMapperProvider, this.isNeedToShowToolTipProvider, this.saveShowToolTipProvider, this.getServicesWithCategoryProvider, this.getDefaultServiceWithCategoryProvider, this.getFavoriteServiceRemoteProvider, this.getServicesByNameProvider, this.getServicesByKeyProvider, this.getFavoriteServicesProvider, this.checkFavoriteServicesFeatureProvider, this.getRawServicesProvider, this.getFavoriteServiceWithCacheFirstProvider, this.getServiceHighlightedProvider, create));
            ApplicationProvider applicationProvider = new ApplicationProvider(applicationComponent);
            this.applicationProvider = applicationProvider;
            Provider<DeepLinkView> authRequestContext = DoubleCheck.getAuthRequestContext(DeepLinkView_Factory.getAuthRequestContext(this.providePresenterProvider, this.providePresenterProvider2, this.providePresenterProvider3, this.providePresenterProvider4, this.servicesPresenterProvider, applicationProvider, this.getUserLoanInfoProvider));
            this.deepLinkViewProvider = authRequestContext;
            this.provideViewProvider6 = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideViewFactory.PlaceComponentResult(deepLinkModule, authRequestContext));
            this.readDeepLinkPropertiesProvider = ReadDeepLinkProperties_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider);
            oauthParamsModelMapper_Factory2 = OauthParamsModelMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            this.deepLinkPayloadModelMapperProvider = DeepLinkPayloadModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(oauthParamsModelMapper_Factory2);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.liteAccountRepositoryProvider = liteAccountRepositoryProvider;
            GetUserId_Factory create2 = GetUserId_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, liteAccountRepositoryProvider);
            this.getUserIdProvider = create2;
            Provider<ReadLinkPropertiesPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(ReadLinkPropertiesPresenter_Factory.getAuthRequestContext(this.provideViewProvider6, this.readDeepLinkPropertiesProvider, this.deepLinkPayloadModelMapperProvider, create2, this.mixpanelDeeplinkTrackerProvider));
            this.readLinkPropertiesPresenterProvider = authRequestContext2;
            this.provideReadPropertiesPresenterProvider = DoubleCheck.getAuthRequestContext(DeepLinkModule_ProvideReadPropertiesPresenterFactory.getAuthRequestContext(deepLinkModule, authRequestContext2));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.h5eventRepositoryProvider = h5eventRepositoryProvider;
            this.getCheckoutH5EventProvider = GetCheckoutH5Event_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, h5eventRepositoryProvider);
        }

        @Override // id.dana.wallet_v3.di.component.BottomSheetAddAssetComponent
        public final void inject(BottomSheetAddAsset bottomSheetAddAsset) {
            injectBottomSheetAddAsset(bottomSheetAddAsset);
        }

        private BottomSheetAddAsset injectBottomSheetAddAsset(BottomSheetAddAsset bottomSheetAddAsset) {
            BottomSheetAddAsset_MembersInjector.injectBottomSheetAddAssetPresenter(bottomSheetAddAsset, bottomSheetAddAssetPresenter());
            BottomSheetAddAsset_MembersInjector.injectReadLinkPropertiesPresenter(bottomSheetAddAsset, this.provideReadPropertiesPresenterProvider.get());
            BottomSheetAddAsset_MembersInjector.injectDeviceInformationProvider(bottomSheetAddAsset, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            BottomSheetAddAsset_MembersInjector.injectWalletH5ServicesImplementation(bottomSheetAddAsset, walletH5ServicesImplementation());
            BottomSheetAddAsset_MembersInjector.injectFeaturePresenter(bottomSheetAddAsset, this.providePresenterProvider3.get());
            return bottomSheetAddAsset;
        }

        /* loaded from: classes5.dex */
        public static final class ProvideWalletConfigRepositoryProvider implements Provider<WalletConfigRepository> {
            private final ApplicationComponent applicationComponent;

            ProvideWalletConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final WalletConfigRepository get() {
                return (WalletConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.getIndexName());
            }
        }

        /* loaded from: classes5.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent applicationComponent;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.applicationComponent.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* loaded from: classes5.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent applicationComponent;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.applicationComponent.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes5.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent applicationComponent;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.applicationComponent.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PocketRepositoryProvider implements Provider<PocketRepository> {
            private final ApplicationComponent applicationComponent;

            PocketRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PocketRepository get() {
                return (PocketRepository) Preconditions.PlaceComponentResult(this.applicationComponent.Y());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent applicationComponent;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.applicationComponent.moveToNextValue());
            }
        }

        /* loaded from: classes5.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent applicationComponent;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.applicationComponent.SendMoneyScenario());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent applicationComponent;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.applicationComponent.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent applicationComponent;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.applicationComponent.isAuto());
            }
        }

        /* loaded from: classes5.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent applicationComponent;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes5.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent applicationComponent;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.applicationComponent.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent applicationComponent;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent applicationComponent;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.applicationComponent.setNetAuthId());
            }
        }

        /* loaded from: classes5.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent applicationComponent;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.applicationComponent.ArrayTable$1());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ShortenerRepositoryProvider implements Provider<ShortenerRepository> {
            private final ApplicationComponent applicationComponent;

            ShortenerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ShortenerRepository get() {
                return (ShortenerRepository) Preconditions.PlaceComponentResult(this.applicationComponent.applyTrimPathIfNeeded());
            }
        }

        /* loaded from: classes5.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent applicationComponent;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.applicationComponent.P());
            }
        }

        /* loaded from: classes5.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent applicationComponent;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* loaded from: classes5.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent applicationComponent;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.applicationComponent.isInfoWindowShown());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProductPageManagerProvider implements Provider<ProductPageManager> {
            private final ApplicationComponent applicationComponent;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.applicationComponent.shouldRecycleViewType());
            }
        }

        /* loaded from: classes5.dex */
        public static final class SplitBillRepositoryProvider implements Provider<SplitBillRepository> {
            private final ApplicationComponent applicationComponent;

            SplitBillRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final SplitBillRepository get() {
                return (SplitBillRepository) Preconditions.PlaceComponentResult(this.applicationComponent.ConcurrentKt());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent applicationComponent;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.applicationComponent.QrExpiredActivity());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent applicationComponent;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.applicationComponent.k());
            }
        }

        /* loaded from: classes5.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent applicationComponent;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.applicationComponent.PrepareContext());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent applicationComponent;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.applicationComponent.z());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent applicationComponent;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.applicationComponent.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent applicationComponent;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.access$throwIllegalArgumentType());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent applicationComponent;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.applicationComponent.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent applicationComponent;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.applicationComponent.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* loaded from: classes5.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent applicationComponent;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.applicationComponent.AppCompatEmojiTextHelper());
            }
        }

        /* loaded from: classes5.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent applicationComponent;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.applicationComponent.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }
    }
}
