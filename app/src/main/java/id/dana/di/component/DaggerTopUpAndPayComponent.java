package id.dana.di.component;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl_Factory;
import id.dana.cashier.CashierContract;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.CashierUpdateOrder;
import id.dana.cashier.domain.interactor.CashierUpdateOrder_Factory;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog_Factory;
import id.dana.cashier.domain.interactor.CreateCashierOrder;
import id.dana.cashier.domain.interactor.CreateCashierOrder_Factory;
import id.dana.cashier.domain.interactor.DoTopUpSubmit;
import id.dana.cashier.domain.interactor.DoTopUpSubmit_Factory;
import id.dana.cashier.domain.interactor.DoTopUpVerify;
import id.dana.cashier.domain.interactor.DoTopUpVerify_Factory;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo_Factory;
import id.dana.cashier.domain.interactor.GetCashierKybProduct;
import id.dana.cashier.domain.interactor.GetCashierKybProduct_Factory;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn_Factory;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls_Factory;
import id.dana.cashier.domain.interactor.GetQueryPromotion;
import id.dana.cashier.domain.interactor.GetQueryPromotion_Factory;
import id.dana.cashier.domain.interactor.GetTopUpAgent;
import id.dana.cashier.domain.interactor.GetTopUpAgent_Factory;
import id.dana.cashier.domain.interactor.GetTopUpConsult;
import id.dana.cashier.domain.interactor.GetTopUpConsult_Factory;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayCashier_Factory;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier_Factory;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow_Factory;
import id.dana.cashier.domain.interactor.TopUpPayCashier;
import id.dana.cashier.domain.interactor.TopUpPayCashier_Factory;
import id.dana.cashier.mapper.AttributeModelMapper;
import id.dana.cashier.mapper.AttributeModelMapper_Factory;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierCheckoutModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper_Factory;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.mapper.CashierPayMethodModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper_Factory;
import id.dana.cashier.mapper.QueryPromotionModelMapper;
import id.dana.cashier.mapper.QueryPromotionModelMapper_Factory;
import id.dana.cashier.mapper.TopUpConsultModelMapper;
import id.dana.cashier.mapper.TopUpConsultModelMapper_Factory;
import id.dana.cashier.mapper.TopUpPayModelMapper;
import id.dana.cashier.mapper.TopUpPayModelMapper_Factory;
import id.dana.cashier.mapper.VoucherCashierModelsMapper;
import id.dana.cashier.mapper.VoucherCashierModelsMapper_Factory;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierPresenter_Factory;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter_Factory;
import id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment;
import id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment_MembersInjector;
import id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment;
import id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment_MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig_Factory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierModule_ProvideCashierViewFactory;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.di.modules.TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory;
import id.dana.di.modules.TopUpAndPayModule_ProvideTopUpAndPayViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting_Factory;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature_Factory;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper_Factory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerTopUpAndPayComponent {
    private DaggerTopUpAndPayComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public CashierAnalyticModule BuiltInFictitiousFunctionClassFactory;
        public CashierModule KClassImpl$Data$declaredNonStaticMembers$2;
        private FaceAuthenticationModule MyBillsEntityDataFactory;
        public TopUpAndPayModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final TopUpAndPayComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, TopUpAndPayModule.class);
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new CashierAnalyticModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, CashierModule.class);
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new FaceAuthenticationModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ApplicationComponent.class);
            return new TopUpAndPayComponentImpl(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class TopUpAndPayComponentImpl implements TopUpAndPayComponent {
        private Provider<GetTopUpConsult> A;
        private Provider<EventTrackerQueue> AppCompatEmojiTextHelper;
        private Provider<GetCustomLoading3dsUrls> B;
        private Provider<GetQueryPromotion> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final CashierAnalyticModule BuiltInFictitiousFunctionClassFactory;
        private Provider<Gson> C;
        private Provider<PayCashier> D;
        private Provider<CheckMixPayFeature> DatabaseTableConfigUtil;
        private Provider<PayQueryCashier> E;
        private Provider<FirebasePerformanceMonitor> F;
        private Provider<FeatureConfigRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<CashierContract.View> G;
        private Provider<CheckNeedToShowSmartpayDialog> GetContactSyncConfig;
        private Provider<FaceAuthentication> H;
        private Provider<PreCreateCashierOrder> I;
        private Provider<PreferenceFacade> J;
        private Provider<QrBarcodeRepository> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<InvestmentRepository> L;
        private Provider<TopUpAndPayContract.View> M;
        private Provider<AttributeModelMapper> MyBillsEntityDataFactory;
        private Provider<SharedPrefCashierConfig> N;
        private Provider<CashierCheckoutModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckAutoRouteSmartPayFeature> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CashierRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DoTopUpSubmit> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private final FaceAuthenticationModule NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DoTopUpVerify> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DanaVizTrackerImpl> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<CreateCashierOrder> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<SaveLastSmartpayActivationShow> O;
        private Provider<SwitchAutoRouting> P;
        private Provider<AnalyticsTrackerFactory> PlaceComponentResult;
        private Provider<CouponPayMethodInfoListModelMapper> PrepareContext;
        private Provider<SaveShowToolTip> Q;
        private Provider<ThreadExecutor> R;
        private Provider<TopUpPayCashier> S;
        private Provider<GetCurrencyFromCdn> SubSequence;
        private Provider<QueryPromotionModelMapper> SummaryVoucherView$$ExternalSyntheticLambda0;
        private final TopUpAndPayComponentImpl SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<TopUpAndPayPresenter> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<TopUpPayModelMapper> T;
        private Provider<UserEducationRepository> U;
        private Provider<GetTopUpAgent> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<IsNeedToShowToolTip> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<VoucherCashierModelsMapper> X;
        private Provider<AutoRouteRepository> getAuthRequestContext;
        private Provider<FirebaseAnalytics> getCallingPid;
        private Provider<CashierPayModelMapper> getErrorConfigVersion;
        private Provider<TopUpAndPayContract.Presenter> getNameOrBuilderList;
        private Provider<MixpanelAnalytics> getOnBoardingScenario;
        private Provider<GetCashierCheckoutInfo> getSupportButtonTintMode;
        private Provider<PostExecutionThread> getValueOfTouchPositionAbsolute;
        private Provider<CashierUpdateOrder> initRecordTimeStamp;
        private Provider<TopUpConsultModelMapper> isAuth;
        private Provider<Context> isLayoutRequested;
        private Provider<CashierPresenter> lookAheadTest;
        private Provider<CashierPayChannelModelsMapper> moveToNextValue;
        private Provider<CouponPayMethodInfoModelMapper> newProxyInstance;
        private Provider<GetAutoRouteInitialSetting> readMicros;
        private Provider<CashierPayMethodModelMapper> scheduleImpl;
        private Provider<GetCashierKybProduct> whenAvailable;

        /* synthetic */ TopUpAndPayComponentImpl(TopUpAndPayModule topUpAndPayModule, CashierAnalyticModule cashierAnalyticModule, CashierModule cashierModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(topUpAndPayModule, cashierAnalyticModule, cashierModule, faceAuthenticationModule, applicationComponent);
        }

        private TopUpAndPayComponentImpl(TopUpAndPayModule topUpAndPayModule, CashierAnalyticModule cashierAnalyticModule, CashierModule cashierModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = faceAuthenticationModule;
            this.BuiltInFictitiousFunctionClassFactory = cashierAnalyticModule;
            this.M = DoubleCheck.getAuthRequestContext(TopUpAndPayModule_ProvideTopUpAndPayViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(topUpAndPayModule));
            this.isLayoutRequested = new ContextProvider(applicationComponent);
            this.G = DoubleCheck.getAuthRequestContext(CashierModule_ProvideCashierViewFactory.PlaceComponentResult(cashierModule));
            CouponPayMethodInfoModelMapper_Factory PlaceComponentResult = CouponPayMethodInfoModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.newProxyInstance = PlaceComponentResult;
            CouponPayMethodInfoListModelMapper_Factory BuiltInFictitiousFunctionClassFactory = CouponPayMethodInfoListModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
            this.PrepareContext = BuiltInFictitiousFunctionClassFactory;
            VoucherCashierModelsMapper_Factory authRequestContext = VoucherCashierModelsMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            this.X = authRequestContext;
            CashierPayChannelModelsMapper_Factory PlaceComponentResult2 = CashierPayChannelModelsMapper_Factory.PlaceComponentResult(authRequestContext);
            this.moveToNextValue = PlaceComponentResult2;
            AttributeModelMapper_Factory BuiltInFictitiousFunctionClassFactory2 = AttributeModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
            CashierCheckoutModelMapper_Factory BuiltInFictitiousFunctionClassFactory3 = CashierCheckoutModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory3;
            this.scheduleImpl = CashierPayMethodModelMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3);
            this.getErrorConfigVersion = CashierPayModelMapper_Factory.getAuthRequestContext(this.MyBillsEntityDataFactory);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = QueryPromotionModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.X);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new CashierRepositoryProvider(applicationComponent);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.L = provideInvestmentRepositoryProvider;
            this.getSupportButtonTintMode = GetCashierCheckoutInfo_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, provideInvestmentRepositoryProvider);
            this.D = PayCashier_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.E = PayQueryCashier_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = CreateCashierOrder_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new DeviceInformationProviderProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = featureConfigRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CheckAutoRouteSmartPayFeature_Factory.create(featureConfigRepositoryProvider);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = autoRouteRepositoryProvider;
            this.readMicros = GetAutoRouteInitialSetting_Factory.create(autoRouteRepositoryProvider);
            this.H = FaceAuthenticationModule_ProvideFaceAuthenticationFactory.getAuthRequestContext(faceAuthenticationModule);
            this.DatabaseTableConfigUtil = CheckMixPayFeature_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = GetQueryPromotion_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.R = new ThreadExecutorProvider(applicationComponent);
            this.getValueOfTouchPositionAbsolute = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.U = userEducationRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = IsNeedToShowToolTip_Factory.create(this.R, this.getValueOfTouchPositionAbsolute, userEducationRepositoryProvider);
            this.Q = SaveShowToolTip_Factory.create(this.R, this.getValueOfTouchPositionAbsolute, this.U);
            this.initRecordTimeStamp = CashierUpdateOrder_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.whenAvailable = GetCashierKybProduct_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.F = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.AppCompatEmojiTextHelper = provideEventTrackerQueueProvider;
            this.getCallingPid = FirebaseAnalytics_Factory.PlaceComponentResult(this.isLayoutRequested, this.F, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, this.AppCompatEmojiTextHelper);
            this.getOnBoardingScenario = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.getCallingPid;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult3 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.PlaceComponentResult = PlaceComponentResult3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DanaVizTrackerImpl_Factory.PlaceComponentResult(PlaceComponentResult3);
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.K = qrBarcodeRepositoryProvider;
            this.I = PreCreateCashierOrder_Factory.create(qrBarcodeRepositoryProvider);
            this.J = new ProvideSharedPrefCashierConfigProvider(applicationComponent);
            GsonProvider gsonProvider = new GsonProvider(applicationComponent);
            this.C = gsonProvider;
            SharedPrefCashierConfig_Factory create = SharedPrefCashierConfig_Factory.create(this.J, gsonProvider);
            this.N = create;
            this.B = GetCustomLoading3dsUrls_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, create);
            this.P = SwitchAutoRouting_Factory.create(this.getAuthRequestContext);
            this.GetContactSyncConfig = CheckNeedToShowSmartpayDialog_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.O = SaveLastSmartpayActivationShow_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            GetCurrencyFromCdn_Factory create2 = GetCurrencyFromCdn_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.SubSequence = create2;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(CashierPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, this.G, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.getErrorConfigVersion, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.getSupportButtonTintMode, this.D, this.E, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.readMicros, this.H, this.DatabaseTableConfigUtil, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.Q, this.initRecordTimeStamp, this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.I, this.B, this.P, this.GetContactSyncConfig, this.O, create2));
            this.isAuth = TopUpConsultModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue);
            this.T = TopUpPayModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            this.A = GetTopUpConsult_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoTopUpSubmit_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoTopUpVerify_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetTopUpAgent_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            TopUpPayCashier_Factory create3 = TopUpPayCashier_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.S = create3;
            TopUpAndPayPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = TopUpAndPayPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, this.M, this.isAuth, this.T, this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.VerifyPinStateManager$executeRiskChallenge$2$1, create3, this.E, this.getErrorConfigVersion, this.H, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$22;
            this.getNameOrBuilderList = DoubleCheck.getAuthRequestContext(TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(topUpAndPayModule, KClassImpl$Data$declaredNonStaticMembers$22));
        }

        private static AttributeModelMapper getAuthRequestContext() {
            return new AttributeModelMapper(new CashierPayChannelModelsMapper(new VoucherCashierModelsMapper(new CouponPayMethodInfoListModelMapper(new CouponPayMethodInfoModelMapper(new CurrencyAmountModelMapper())))));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class CashierRepositoryProvider implements Provider<CashierRepository> {
            private final ApplicationComponent PlaceComponentResult;

            CashierRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CashierRepository get() {
                return (CashierRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.lookAheadTest());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.TypefaceCompatApi26Impl());
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
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent getAuthRequestContext;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.scheduleImpl());
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
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.OtpRegistrationPresenter$input$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.PlaceComponentResult.j());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.SendMoneyScenario());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideSharedPrefCashierConfigProvider implements Provider<PreferenceFacade> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideSharedPrefCashierConfigProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PreferenceFacade get() {
                return (PreferenceFacade) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.JsonParseException());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GsonProvider implements Provider<Gson> {
            private final ApplicationComponent PlaceComponentResult;

            GsonProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Gson get() {
                return (Gson) Preconditions.PlaceComponentResult(this.PlaceComponentResult.C());
            }
        }

        @Override // id.dana.di.component.TopUpAndPayComponent
        public final void getAuthRequestContext(TopUpAndPayInputFragment topUpAndPayInputFragment) {
            TopUpAndPayInputFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(topUpAndPayInputFragment, this.getNameOrBuilderList.get());
            TopUpAndPayInputFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(topUpAndPayInputFragment, (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7()));
            TopUpAndPayInputFragment_MembersInjector.getAuthRequestContext(topUpAndPayInputFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
        }

        @Override // id.dana.di.component.TopUpAndPayComponent
        public final void BuiltInFictitiousFunctionClassFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment) {
            TopUpAndPaySourceFragment_MembersInjector.MyBillsEntityDataFactory(topUpAndPaySourceFragment, new TopUpAndPayPresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), this.M.get(), new TopUpConsultModelMapper(new CashierPayChannelModelsMapper(new VoucherCashierModelsMapper(new CouponPayMethodInfoListModelMapper(new CouponPayMethodInfoModelMapper(new CurrencyAmountModelMapper()))))), new TopUpPayModelMapper(getAuthRequestContext()), new GetTopUpConsult((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new DoTopUpSubmit((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new DoTopUpVerify((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new GetTopUpAgent((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new TopUpPayCashier((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new PayQueryCashier((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new CashierPayModelMapper(getAuthRequestContext()), FaceAuthenticationModule_ProvideFaceAuthenticationFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), new DanaVizTrackerImpl(new AnalyticsTrackerFactory(new FirebaseAnalytics((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$2()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j())), new MixpanelAnalytics((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j())), new FullStoryAnalytics()))));
            TopUpAndPaySourceFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(topUpAndPaySourceFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            TopUpAndPaySourceFragment_MembersInjector.PlaceComponentResult(topUpAndPaySourceFragment, this.lookAheadTest.get());
        }
    }
}
