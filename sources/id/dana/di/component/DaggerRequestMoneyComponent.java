package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
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
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker_Factory;
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaCustomH5_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.UserBankModule;
import id.dana.di.modules.UserBankModule_ProvidePresenterFactory;
import id.dana.di.modules.UserBankModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.bank.interactor.AddUserBank;
import id.dana.domain.bank.interactor.DeleteUserBank;
import id.dana.domain.bank.interactor.GetUserBanks;
import id.dana.domain.bank.interactor.InitRequestMoney;
import id.dana.domain.bank.interactor.SaveUserBanks;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink_Factory;
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
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig_Factory;
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
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.referral.interactor.GetReferralConsult_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.services.interactor.GetService_Factory;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.domain.services.interactor.GetServicesByKey_Factory;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail_Factory;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.domain.version.interactor.GetUpdateAvailability_Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.mapper.ThirdPartyServicesMapper_Factory;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.requestmoney.RequestMoneyActivity;
import id.dana.requestmoney.RequestMoneyActivity_MembersInjector;
import id.dana.requestmoney.bank.UserBankPresenter;
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
public final class DaggerRequestMoneyComponent {
    private DaggerRequestMoneyComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public UserBankModule BuiltInFictitiousFunctionClassFactory;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;
        public FeatureModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class RequestMoneyComponentImpl implements RequestMoneyComponent {
        private Provider<GetPayerSplitBillDetail> A;
        private Provider<GetUserLoanInfo> AppCompatEmojiTextHelper;
        private Provider<GetMissionDetail> B;
        private Provider<GetIsCardBindingV2Enabled> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetNearbyConfig> C;
        private Provider<GetReferralConsult> D;
        private Provider<FeatureFamilyAccount> DatabaseTableConfigUtil;
        private Provider<GetRequestMoneyInfoFeature> E;
        private Provider<MyReferralConsultMapper> F;
        private Provider<FeatureSettingMore> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetSplitBillConfig> G;
        private Provider<FeatureOauth> GetContactSyncConfig;
        private Provider<GetUpdateAvailability> H;
        private Provider<MixpanelDeeplinkTracker> I;
        private Provider<MyReferralConsultRepository> J;
        private Provider<ProductPageManager> K;
        private Provider<BottomSheetOnBoardingPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<OauthRepository> L;
        private Provider<PayerModelListMapper> M;
        private Provider<CheckMyBillsVersionConfig> MyBillsEntityDataFactory;
        private Provider<BottomSheetOnBoardingContract.View> N;
        private Provider<CheckShowReferralCodeFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<FeatureCardBinding> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GenerateLinkRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<FeatureSplitBillPay> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FeatureView> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FeatureSplitBill> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FeatureScanQR> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<FeedsConfigRepository> O;
        private Provider<FamilyAccountRepository> P;
        private Provider<CheckDeepLinkActionVisibility> PlaceComponentResult;
        private Provider<FeaturePresenter> PrepareContext;
        private Provider<PromoQuestRepository> Q;
        private Provider<PushVerifyTracker> R;
        private Provider<FeatureContract.View> S;
        private Provider<GetBottomSheetOnBoarding> SubSequence;
        private Provider<BottomSheetOnBoardingContract.Presenter> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<CardBindingRepository> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<FeatureContract.Presenter> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<ServiceCategoryMapper> T;
        private Provider<SettingRepository> U;
        private Provider<SaveDisplayBottomSheetOnBoarding> V;
        private Provider<GetPromoCenterVersion> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetService> VerifyPinStateManager$executeRiskChallenge$2$2;
        private final RequestMoneyComponentImpl W;
        private Provider<ServicesRepository> X;
        private final UserBankModule Y;
        private Provider<ThirdPartyServicesMapper> Z;
        private Provider<UserEducationRepository> b;
        private Provider<UserConsentRepository> c;
        private Provider<ThreadExecutor> flip;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<GetAuthCode> getCallingPid;
        private Provider<CheckWhitelistedValidDomain> getErrorConfigVersion;
        private Provider<PostExecutionThread> getNameOrBuilderList;
        private Provider<GetSettingByKey> getOnBoardingScenario;
        private Provider<GenerateReferralDeepLink> getSupportButtonTintMode;
        private Provider<GetServicesByKey> getValueOfTouchPositionAbsolute;
        private Provider<DynamicUrlWrapper> initRecordTimeStamp;
        private Provider<PaylaterRepository> isAuth;
        private Provider<SplitBillHistoryToSplitBillModelMapper> isAuto;
        private Provider<FeatureServicesHandler> isLayoutRequested;
        private Provider<Context> lookAheadTest;
        private Provider<DanaCustomH5> moveToNextValue;
        private Provider<FeaturePromoQuest> newProxyInstance;
        private Provider<GetFeedConfig> readMicros;
        private Provider<DeviceInformationProvider> scheduleImpl;
        private Provider<SplitBillRepository> shouldRecycleViewType;
        private Provider<GetEmptyUserInfo> whenAvailable;

        public /* synthetic */ RequestMoneyComponentImpl(UserBankModule userBankModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, FeatureModule featureModule, ApplicationComponent applicationComponent, byte b) {
            this(userBankModule, bottomSheetOnBoardingModule, featureModule, applicationComponent);
        }

        private RequestMoneyComponentImpl(UserBankModule userBankModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, FeatureModule featureModule, ApplicationComponent applicationComponent) {
            RequestMoneyInfoModelMapper_Factory requestMoneyInfoModelMapper_Factory;
            this.W = this;
            this.Y = userBankModule;
            this.getAuthRequestContext = applicationComponent;
            this.N = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.flip = new ThreadExecutorProvider(applicationComponent);
            this.getNameOrBuilderList = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.b = userEducationRepositoryProvider;
            this.SubSequence = GetBottomSheetOnBoarding_Factory.create(this.flip, this.getNameOrBuilderList, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create = SaveDisplayBottomSheetOnBoarding_Factory.create(this.flip, this.getNameOrBuilderList, this.b);
            this.V = create;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.N, this.SubSequence, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.J = myReferralConsultRepositoryProvider;
            this.D = GetReferralConsult_Factory.create(this.flip, this.getNameOrBuilderList, myReferralConsultRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = featureConfigRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckShowReferralCodeFeature_Factory.create(featureConfigRepositoryProvider);
            this.F = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = generateLinkRepositoryProvider;
            this.getSupportButtonTintMode = GenerateReferralDeepLink_Factory.create(this.flip, this.getNameOrBuilderList, generateLinkRepositoryProvider);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.U = settingRepositoryProvider;
            this.getOnBoardingScenario = GetSettingByKey_Factory.create(this.flip, this.getNameOrBuilderList, settingRepositoryProvider);
            ProductPageManagerProvider productPageManagerProvider = new ProductPageManagerProvider(applicationComponent);
            this.K = productPageManagerProvider;
            this.FragmentBottomSheetPaymentSettingBinding = FeatureSettingMore_Factory.PlaceComponentResult(this.getOnBoardingScenario, productPageManagerProvider);
            SplitBillRepositoryProvider splitBillRepositoryProvider = new SplitBillRepositoryProvider(applicationComponent);
            this.shouldRecycleViewType = splitBillRepositoryProvider;
            this.A = GetPayerSplitBillDetail_Factory.create(this.flip, this.getNameOrBuilderList, splitBillRepositoryProvider);
            this.M = PayerModelListMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayerModelMapper_Factory.MyBillsEntityDataFactory());
            SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult = SplitBillHistoryToSplitBillModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.M);
            this.isAuto = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FeatureSplitBillPay_Factory.BuiltInFictitiousFunctionClassFactory(this.A, PlaceComponentResult);
            this.G = GetSplitBillConfig_Factory.create(this.flip, this.getNameOrBuilderList, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            GetRequestMoneyInfoFeature_Factory create2 = GetRequestMoneyInfoFeature_Factory.create(this.flip, this.getNameOrBuilderList, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.E = create2;
            Provider<GetSplitBillConfig> provider = this.G;
            requestMoneyInfoModelMapper_Factory = RequestMoneyInfoModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FeatureSplitBill_Factory.MyBillsEntityDataFactory(provider, create2, requestMoneyInfoModelMapper_Factory);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.Q = promoQuestRepositoryProvider;
            GetMissionDetail_Factory create3 = GetMissionDetail_Factory.create(promoQuestRepositoryProvider);
            this.B = create3;
            this.newProxyInstance = FeaturePromoQuest_Factory.getAuthRequestContext(create3, PromoQuestMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(FeatureScanQR_Factory.PlaceComponentResult());
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.lookAheadTest = contextProvider;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(DanaCustomH5_Factory.create(contextProvider));
            MixpanelDeeplinkTracker_Factory MyBillsEntityDataFactory = MixpanelDeeplinkTracker_Factory.MyBillsEntityDataFactory(this.lookAheadTest);
            this.I = MyBillsEntityDataFactory;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(FeatureOauth_Factory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.P = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.initRecordTimeStamp = dynamicUrlWrapperProvider;
            this.DatabaseTableConfigUtil = FeatureFamilyAccount_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dynamicUrlWrapperProvider);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory2 = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = BuiltInFictitiousFunctionClassFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.isAuth = providePaylaterRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetUserLoanInfo_Factory.create(providePaylaterRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(FeaturePushVerify_Factory.getAuthRequestContext(this.I));
            Provider<FeatureView> authRequestContext = DoubleCheck.getAuthRequestContext(FeatureView_Factory.getAuthRequestContext(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.F, this.getSupportButtonTintMode, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.moveToNextValue, FeatureHome_Factory.MyBillsEntityDataFactory(), this.GetContactSyncConfig, FeatureKyb_Factory.getAuthRequestContext(), this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.AppCompatEmojiTextHelper, FeatureMyBills_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext;
            this.S = DoubleCheck.getAuthRequestContext(FeatureModule_ProvideViewFactory.PlaceComponentResult(featureModule, authRequestContext));
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.X = servicesRepositoryProvider;
            this.getValueOfTouchPositionAbsolute = GetServicesByKey_Factory.create(this.flip, this.getNameOrBuilderList, servicesRepositoryProvider);
            ServiceCategoryMapper_Factory authRequestContext2 = ServiceCategoryMapper_Factory.getAuthRequestContext(this.lookAheadTest);
            this.T = authRequestContext2;
            this.Z = ThirdPartyServicesMapper_Factory.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            this.L = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.c = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create4 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.whenAvailable = create4;
            this.getCallingPid = GetAuthCode_Factory.create(this.L, create4);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.scheduleImpl = deviceInformationProviderProvider;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(FeatureServicesHandler_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.S, this.getValueOfTouchPositionAbsolute, this.Z, this.getCallingPid, deviceInformationProviderProvider));
            this.PlaceComponentResult = CheckDeepLinkActionVisibility_Factory.create(this.flip, this.getNameOrBuilderList, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getErrorConfigVersion = CheckWhitelistedValidDomain_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.C = GetNearbyConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            ProvideFeedsConfigRepositoryProvider provideFeedsConfigRepositoryProvider = new ProvideFeedsConfigRepositoryProvider(applicationComponent);
            this.O = provideFeedsConfigRepositoryProvider;
            this.readMicros = GetFeedConfig_Factory.MyBillsEntityDataFactory(provideFeedsConfigRepositoryProvider);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetPromoCenterVersion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.H = GetUpdateAvailability_Factory.create(this.lookAheadTest);
            this.MyBillsEntityDataFactory = CheckMyBillsVersionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.R = new ProvidePushVerifyTrackerProvider(applicationComponent);
            GetService_Factory create5 = GetService_Factory.create(this.X);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = create5;
            Provider<FeaturePresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(FeaturePresenter_Factory.PlaceComponentResult(this.S, this.isLayoutRequested, this.PlaceComponentResult, this.getErrorConfigVersion, this.C, this.readMicros, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.H, this.MyBillsEntityDataFactory, this.R, create5));
            this.PrepareContext = authRequestContext3;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(FeatureModule_ProvidePresenterFactory.getAuthRequestContext(featureModule, authRequestContext3));
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.P());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProductPageManagerProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ProductPageManager get() {
                return (ProductPageManager) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.shouldRecycleViewType());
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
        public static final class ProvideFeedsConfigRepositoryProvider implements Provider<FeedsConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsConfigRepository get() {
                return (FeedsConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$throwIllegalArgumentType());
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

        @Override // id.dana.di.component.RequestMoneyComponent
        public final void PlaceComponentResult(RequestMoneyActivity requestMoneyActivity) {
            RequestMoneyActivity_MembersInjector.getAuthRequestContext(requestMoneyActivity, UserBankModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.Y, new UserBankPresenter(UserBankModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.Y), new GetUserBanks((UserBankRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$getCapacity$p())), new SaveUserBanks((UserBankRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$getCapacity$p())), new AddUserBank((UserBankRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$getCapacity$p())), new DeleteUserBank((UserBankRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$getCapacity$p())), new InitRequestMoney((UserBankRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$getCapacity$p())))));
            RequestMoneyActivity_MembersInjector.MyBillsEntityDataFactory(requestMoneyActivity, this.SummaryVoucherView$$ExternalSyntheticLambda0.get());
            RequestMoneyActivity_MembersInjector.getAuthRequestContext(requestMoneyActivity, this.SummaryVoucherView$$ExternalSyntheticLambda2.get());
        }
    }
}
