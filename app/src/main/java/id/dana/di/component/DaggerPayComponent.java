package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled_Factory;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.contract.deeplink.path.FeatureCardBinding_Factory;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payasset.QueryPayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.QueryPayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.QueryPayMethodPresenter;
import id.dana.contract.payasset.QueryPayMethodPresenter_Factory;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.contract.payqr.GetPaymentResultModule;
import id.dana.contract.payqr.GetPaymentResultModule_ProvidePresenterFactory;
import id.dana.contract.payqr.GetPaymentResultModule_ProvideViewFactory;
import id.dana.contract.payqr.GetPaymentResultPresenter;
import id.dana.contract.payqr.GetPaymentResultPresenter_Factory;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.OfflinePayModule_ProvidePresenterFactory;
import id.dana.contract.payqr.OfflinePayModule_ProvideViewFactory;
import id.dana.contract.payqr.OfflinePayPresenter;
import id.dana.contract.payqr.OfflinePayPresenter_Factory;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.payqr.PayQrModule;
import id.dana.contract.payqr.PayQrModule_ProvidePresenterFactory;
import id.dana.contract.payqr.PayQrModule_ProvideViewFactory;
import id.dana.contract.payqr.PayQrPresenter;
import id.dana.contract.payqr.PayQrPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.ClearAllPaymentCodes;
import id.dana.domain.globalnetwork.interactor.ClearAllPaymentCodes_Factory;
import id.dana.domain.globalnetwork.interactor.GetUniPaymentResult;
import id.dana.domain.globalnetwork.interactor.GetUniPaymentResult_Factory;
import id.dana.domain.offlinepay.interactor.SetSeedExtra;
import id.dana.domain.offlinepay.interactor.SetSeedExtra_Factory;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard_Factory;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.interactor.QueryPayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.interactor.GetOtpInitResult;
import id.dana.domain.qrpay.interactor.GetOtpInitResult_Factory;
import id.dana.domain.qrpay.interactor.GetPaymentCode;
import id.dana.domain.qrpay.interactor.GetPaymentCode_Factory;
import id.dana.domain.qrpay.interactor.GetPaymentResult;
import id.dana.domain.qrpay.interactor.GetPaymentResult_Factory;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData_Factory;
import id.dana.domain.qrpay.interactor.InitOfflinePay;
import id.dana.domain.qrpay.interactor.InitOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized_Factory;
import id.dana.domain.qrpay.interactor.IsQrisEnable;
import id.dana.domain.qrpay.interactor.IsQrisEnable_Factory;
import id.dana.domain.qrpay.interactor.PauseOfflinePay;
import id.dana.domain.qrpay.interactor.PauseOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.RestartOfflinePay;
import id.dana.domain.qrpay.interactor.RestartOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.StartOfflinePay;
import id.dana.domain.qrpay.interactor.StartOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay_Factory;
import id.dana.domain.qrpay.model.QrisPaymentData_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.pay.PayCardInfoMapper_Factory;
import id.dana.pay.PayFragment;
import id.dana.pay.PayFragment_MembersInjector;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPayComponent {
    private DaggerPayComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public OfflinePayModule KClassImpl$Data$declaredNonStaticMembers$2;
        public PlayStoreReviewModules MyBillsEntityDataFactory;
        public PayQrModule PlaceComponentResult;
        public GetPaymentResultModule getAuthRequestContext;
        public QueryPayMethodModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PayComponentImpl implements PayComponent {
        private Provider<CardBindingRepository> A;
        private Provider<QueryPayMethod> AppCompatEmojiTextHelper;
        private Provider<PlayStoreReviewContract.View> B;
        private Provider<PlayStoreReviewContract.Presenter> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<ClearAllPaymentCodes> BuiltInFictitiousFunctionClassFactory;
        private Provider<OfflinePayContract.Presenter> C;
        private Provider<GetPaymentResultContract.View> D;
        private Provider<GetPaymentResult> DatabaseTableConfigUtil;
        private Provider<QueryPayMethodContract.Presenter> E;
        private Provider<RestartOfflinePay> F;
        private Provider<PayAssetRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<QrPayRepository> G;
        private Provider<GetPaymentCode> GetContactSyncConfig;
        private Provider<QueryPayMethodPresenter> H;
        private Provider<QueryPayMethodContract.View> I;
        private Provider<StopOfflinePay> J;
        private Provider<StartOfflinePay> K;
        private Provider<AppLifeCycleObserver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SetSeedExtra> L;
        private Provider<ThreadExecutor> M;
        private Provider<DeviceInformationProvider> MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetQrisPaymentData> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetUniPaymentResult> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<OfflinePayPresenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<PauseOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<IsQrisEnable> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<IsOfflinePayInitialized> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GlobalNetworkRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<UserRepository> P;
        private Provider<Context> PlaceComponentResult;
        private Provider<IsCashierEntryPointEnabled> PrepareContext;
        private Provider<PlayStoreReviewRepository> SubSequence;
        private Provider<GetPaymentResultContract.Presenter> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<PayQrContract.Presenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<FeatureCardBinding> getAuthRequestContext;
        private final PayComponentImpl getCallingPid;
        private Provider<GetIsCardBindingV2Enabled> getErrorConfigVersion;
        private Provider<SaveLastPlayStoreReviewShow> getNameOrBuilderList;
        private Provider<PayQrContract.View> getOnBoardingScenario;
        private Provider<PostExecutionThread> getSupportButtonTintMode;
        private Provider<OfflinePayContract.View> getValueOfTouchPositionAbsolute;
        private Provider<GetPaymentResultPresenter> initRecordTimeStamp;
        private Provider<InitOfflinePay> isLayoutRequested;
        private Provider<GetEnableAddNewCard> lookAheadTest;
        private Provider<GetOtpInitResult> moveToNextValue;
        private Provider<IsNeedToShowPlayStoreReview> newProxyInstance;
        private Provider<PayQrPresenter> readMicros;
        private Provider<GetPayCardConfig> scheduleImpl;
        private Provider<PlayStoreReviewPresenter> whenAvailable;

        public /* synthetic */ PayComponentImpl(GetPaymentResultModule getPaymentResultModule, QueryPayMethodModule queryPayMethodModule, PayQrModule payQrModule, OfflinePayModule offlinePayModule, PlayStoreReviewModules playStoreReviewModules, ApplicationComponent applicationComponent, byte b) {
            this(getPaymentResultModule, queryPayMethodModule, payQrModule, offlinePayModule, playStoreReviewModules, applicationComponent);
        }

        private PayComponentImpl(GetPaymentResultModule getPaymentResultModule, QueryPayMethodModule queryPayMethodModule, PayQrModule payQrModule, OfflinePayModule offlinePayModule, PlayStoreReviewModules playStoreReviewModules, ApplicationComponent applicationComponent) {
            PayCardInfoMapper_Factory payCardInfoMapper_Factory;
            this.getCallingPid = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new AppLifeCycleObserverProvider(applicationComponent);
            this.D = DoubleCheck.getAuthRequestContext(GetPaymentResultModule_ProvideViewFactory.getAuthRequestContext(getPaymentResultModule));
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.G = qrPayRepositoryProvider;
            this.DatabaseTableConfigUtil = GetPaymentResult_Factory.create(qrPayRepositoryProvider);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = globalNetworkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetUniPaymentResult_Factory.create(globalNetworkRepositoryProvider);
            ClearAllPaymentCodes_Factory create = ClearAllPaymentCodes_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.BuiltInFictitiousFunctionClassFactory = create;
            GetPaymentResultPresenter_Factory authRequestContext = GetPaymentResultPresenter_Factory.getAuthRequestContext(this.D, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            this.initRecordTimeStamp = authRequestContext;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(GetPaymentResultModule_ProvidePresenterFactory.PlaceComponentResult(getPaymentResultModule, authRequestContext));
            this.M = new ThreadExecutorProvider(applicationComponent);
            this.getSupportButtonTintMode = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = IsOfflineF2FPay_Factory.create(this.M, this.getSupportButtonTintMode, featureConfigRepositoryProvider);
            Provider<OfflinePayContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvideViewFactory.getAuthRequestContext(offlinePayModule));
            this.getValueOfTouchPositionAbsolute = authRequestContext2;
            OfflinePayPresenter_Factory authRequestContext3 = OfflinePayPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda8, authRequestContext2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = authRequestContext3;
            this.C = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(offlinePayModule, authRequestContext3));
            this.getOnBoardingScenario = DoubleCheck.getAuthRequestContext(PayQrModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(payQrModule));
            this.L = SetSeedExtra_Factory.create(this.G);
            this.moveToNextValue = GetOtpInitResult_Factory.create(this.G);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = IsQrisEnable_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.PrepareContext = IsCashierEntryPointEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.GetContactSyncConfig = GetPaymentCode_Factory.create(this.G);
            this.P = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetQrisPaymentData_Factory.create(this.G, QrisPaymentData_Factory.create(), this.P);
            this.K = StartOfflinePay_Factory.create(this.G);
            this.J = StopOfflinePay_Factory.create(this.G);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = PauseOfflinePay_Factory.create(this.G);
            RestartOfflinePay_Factory create2 = RestartOfflinePay_Factory.create(this.G);
            this.F = create2;
            Provider<PayQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(PayQrPresenter_Factory.PlaceComponentResult(this.getOnBoardingScenario, this.L, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.PrepareContext, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.K, this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda4, create2, this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            this.readMicros = authRequestContext4;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = DoubleCheck.getAuthRequestContext(PayQrModule_ProvidePresenterFactory.PlaceComponentResult(payQrModule, authRequestContext4));
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.SubSequence = playStoreReviewRepositoryProvider;
            this.newProxyInstance = IsNeedToShowPlayStoreReview_Factory.create(this.M, this.getSupportButtonTintMode, playStoreReviewRepositoryProvider);
            this.getNameOrBuilderList = SaveLastPlayStoreReviewShow_Factory.create(this.M, this.getSupportButtonTintMode, this.SubSequence);
            Provider<PlayStoreReviewContract.View> authRequestContext5 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.B = authRequestContext5;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.newProxyInstance, this.getNameOrBuilderList, authRequestContext5);
            this.whenAvailable = MyBillsEntityDataFactory;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
            this.I = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(queryPayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = payAssetRepositoryProvider;
            this.lookAheadTest = GetEnableAddNewCard_Factory.create(payAssetRepositoryProvider);
            this.AppCompatEmojiTextHelper = QueryPayMethod_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.isLayoutRequested = InitOfflinePay_Factory.create(this.G);
            this.MyBillsEntityDataFactory = new DeviceInformationProviderProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = IsOfflinePayInitialized_Factory.create(this.G);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.scheduleImpl = GetPayCardConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.FragmentBottomSheetPaymentSettingBinding);
            Provider<QueryPayMethodContract.View> provider = this.I;
            Provider<GetEnableAddNewCard> provider2 = this.lookAheadTest;
            Provider<QueryPayMethod> provider3 = this.AppCompatEmojiTextHelper;
            payCardInfoMapper_Factory = PayCardInfoMapper_Factory.InstanceHolder.BuiltInFictitiousFunctionClassFactory;
            Provider<QueryPayMethodPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(QueryPayMethodPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, provider3, payCardInfoMapper_Factory, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.isLayoutRequested, this.MyBillsEntityDataFactory, this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.PlaceComponentResult, this.scheduleImpl));
            this.H = authRequestContext6;
            this.E = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(queryPayMethodModule, authRequestContext6));
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.A = provideNewCardBindingRepositoryProvider;
            GetIsCardBindingV2Enabled_Factory BuiltInFictitiousFunctionClassFactory = GetIsCardBindingV2Enabled_Factory.BuiltInFictitiousFunctionClassFactory(provideNewCardBindingRepositoryProvider);
            this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
            this.getAuthRequestContext = FeatureCardBinding_Factory.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AppLifeCycleObserverProvider implements Provider<AppLifeCycleObserver> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AppLifeCycleObserverProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AppLifeCycleObserver get() {
                return (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PromoCategoryPresenter$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
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
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
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
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.X());
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

        @Override // id.dana.di.component.PayComponent
        public final void getAuthRequestContext(PayFragment payFragment) {
            payFragment.appLifeCycleObserver = DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            PayFragment_MembersInjector.PlaceComponentResult(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$1));
            PayFragment_MembersInjector.getAuthRequestContext(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.C));
            PayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$2));
            PayFragment_MembersInjector.moveToNextValue(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.BottomSheetCardBindingView$watcherCardNumberView$1));
            PayFragment_MembersInjector.lookAheadTest(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.E));
            PayFragment_MembersInjector.MyBillsEntityDataFactory(payFragment, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
        }
    }
}
