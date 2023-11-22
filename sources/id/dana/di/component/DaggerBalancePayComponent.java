package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payasset.ChangePayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.ChangePayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.ChangePayMethodPresenter;
import id.dana.contract.payasset.ChangePayMethodPresenter_Factory;
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
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.contract.user.GetUserInfoModule_ProvidePresenterFactory;
import id.dana.contract.user.GetUserInfoModule_ProvideViewFactory;
import id.dana.contract.user.GetUserInfoPresenter;
import id.dana.contract.user.GetUserInfoPresenter_Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
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
import id.dana.domain.payasset.interactor.ChangePayMethod;
import id.dana.domain.payasset.interactor.ChangePayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.interactor.GetOtpInitResult;
import id.dana.domain.qrpay.interactor.GetOtpInitResult_Factory;
import id.dana.domain.qrpay.interactor.GetPaymentCode;
import id.dana.domain.qrpay.interactor.GetPaymentCode_Factory;
import id.dana.domain.qrpay.interactor.GetPaymentResult;
import id.dana.domain.qrpay.interactor.GetPaymentResult_Factory;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData_Factory;
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
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.pay.BalancePayFragment;
import id.dana.pay.BalancePayFragment_MembersInjector;
import id.dana.pay.BalanceQrisPayFragment;
import id.dana.pay.BalanceQrisPayFragment_MembersInjector;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerBalancePayComponent {
    private DaggerBalancePayComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GetUserInfoModule BuiltInFictitiousFunctionClassFactory;
        public ChangePayMethodModule KClassImpl$Data$declaredNonStaticMembers$2;
        public GetPaymentResultModule MyBillsEntityDataFactory;
        public OfflinePayModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;
        public PayQrModule lookAheadTest;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final BalancePayComponent getAuthRequestContext() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, GetPaymentResultModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, PayQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, GetUserInfoModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, ChangePayMethodModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, OfflinePayModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ApplicationComponent.class);
            return new BalancePayComponentImpl(this.MyBillsEntityDataFactory, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getAuthRequestContext, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class BalancePayComponentImpl implements BalancePayComponent {
        private Provider<OfflinePayContract.View> A;
        private Provider<GetPaymentResultContract.View> B;
        private Provider<PayQrContract.View> BottomSheetCardBindingView$watcherCardNumberView$1;
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<RestartOfflinePay> C;
        private Provider<ThreadExecutor> D;
        private Provider<GlobalNetworkRepository> DatabaseTableConfigUtil;
        private Provider<StopOfflinePay> E;
        private Provider<UserRepository> F;
        private Provider<PayQrPresenter> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetQrisPaymentData> GetContactSyncConfig;
        private Provider<ClearAllPaymentCodes> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ChangePayMethod> MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetUserInfoPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetUniPaymentResult> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetUserInfoContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PayAssetRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ChangePayMethodContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<OfflinePayPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ChangePayMethodPresenter> PlaceComponentResult;
        private Provider<IsCashierEntryPointEnabled> PrepareContext;
        private Provider<ChangePayMethodContract.View> SubSequence;
        private Provider<QrPayRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<StartOfflinePay> VerifyPinStateManager$executeRiskChallenge$2$2;
        private final BalancePayComponentImpl getAuthRequestContext;
        private Provider<GetUserInfoContract.View> getCallingPid;
        private Provider<GetPaymentResultPresenter> getErrorConfigVersion;
        private Provider<SetSeedExtra> getOnBoardingScenario;
        private Provider<PayQrContract.Presenter> getSupportButtonTintMode;
        private Provider<UserInfoMapper> getValueOfTouchPositionAbsolute;
        private Provider<GetUserInfo> initRecordTimeStamp;
        private Provider<PauseOfflinePay> isLayoutRequested;
        private Provider<GetPaymentCode> lookAheadTest;
        private Provider<GetOtpInitResult> moveToNextValue;
        private Provider<IsQrisEnable> newProxyInstance;
        private Provider<GetPaymentResultContract.Presenter> readMicros;
        private Provider<GetPaymentResult> scheduleImpl;
        private Provider<OfflinePayContract.Presenter> whenAvailable;

        /* synthetic */ BalancePayComponentImpl(GetPaymentResultModule getPaymentResultModule, PayQrModule payQrModule, GetUserInfoModule getUserInfoModule, ChangePayMethodModule changePayMethodModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent, byte b) {
            this(getPaymentResultModule, payQrModule, getUserInfoModule, changePayMethodModule, offlinePayModule, applicationComponent);
        }

        private BalancePayComponentImpl(GetPaymentResultModule getPaymentResultModule, PayQrModule payQrModule, GetUserInfoModule getUserInfoModule, ChangePayMethodModule changePayMethodModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.SubSequence = DoubleCheck.getAuthRequestContext(ChangePayMethodModule_ProvideViewFactory.MyBillsEntityDataFactory(changePayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = payAssetRepositoryProvider;
            this.MyBillsEntityDataFactory = ChangePayMethod_Factory.create(payAssetRepositoryProvider);
            this.D = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.D, this.NetworkUserEntityData$$ExternalSyntheticLambda3, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = create;
            Provider<ChangePayMethodPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(ChangePayMethodPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.SubSequence, this.MyBillsEntityDataFactory, create));
            this.PlaceComponentResult = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(ChangePayMethodModule_ProvidePresenterFactory.PlaceComponentResult(changePayMethodModule, authRequestContext));
            this.getCallingPid = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvideViewFactory.getAuthRequestContext(getUserInfoModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.F = userRepositoryProvider;
            this.initRecordTimeStamp = GetUserInfo_Factory.create(userRepositoryProvider);
            UserInfoMapper_Factory PlaceComponentResult = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.getValueOfTouchPositionAbsolute = PlaceComponentResult;
            Provider<GetUserInfoPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(GetUserInfoPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getCallingPid, this.initRecordTimeStamp, PlaceComponentResult));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(getUserInfoModule, authRequestContext2));
            Provider<OfflinePayContract.View> authRequestContext3 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvideViewFactory.getAuthRequestContext(offlinePayModule));
            this.A = authRequestContext3;
            OfflinePayPresenter_Factory authRequestContext4 = OfflinePayPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, authRequestContext3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext4;
            this.whenAvailable = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(offlinePayModule, authRequestContext4));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(PayQrModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(payQrModule));
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = qrPayRepositoryProvider;
            this.getOnBoardingScenario = SetSeedExtra_Factory.create(qrPayRepositoryProvider);
            this.moveToNextValue = GetOtpInitResult_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.newProxyInstance = IsQrisEnable_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.PrepareContext = IsCashierEntryPointEnabled_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.lookAheadTest = GetPaymentCode_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.GetContactSyncConfig = GetQrisPaymentData_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1, QrisPaymentData_Factory.create(), this.F);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = StartOfflinePay_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.E = StopOfflinePay_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.isLayoutRequested = PauseOfflinePay_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            RestartOfflinePay_Factory create2 = RestartOfflinePay_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            this.C = create2;
            Provider<PayQrPresenter> authRequestContext5 = DoubleCheck.getAuthRequestContext(PayQrPresenter_Factory.PlaceComponentResult(this.BottomSheetCardBindingView$watcherCardNumberView$1, this.getOnBoardingScenario, this.moveToNextValue, this.newProxyInstance, this.PrepareContext, this.lookAheadTest, this.GetContactSyncConfig, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.E, this.isLayoutRequested, create2, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext5;
            this.getSupportButtonTintMode = DoubleCheck.getAuthRequestContext(PayQrModule_ProvidePresenterFactory.PlaceComponentResult(payQrModule, authRequestContext5));
            this.B = DoubleCheck.getAuthRequestContext(GetPaymentResultModule_ProvideViewFactory.getAuthRequestContext(getPaymentResultModule));
            this.scheduleImpl = GetPaymentResult_Factory.create(this.VerifyPinStateManager$executeRiskChallenge$2$1);
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = globalNetworkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetUniPaymentResult_Factory.create(globalNetworkRepositoryProvider);
            ClearAllPaymentCodes_Factory create3 = ClearAllPaymentCodes_Factory.create(this.DatabaseTableConfigUtil);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create3;
            GetPaymentResultPresenter_Factory authRequestContext6 = GetPaymentResultPresenter_Factory.getAuthRequestContext(this.B, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create3);
            this.getErrorConfigVersion = authRequestContext6;
            this.readMicros = DoubleCheck.getAuthRequestContext(GetPaymentResultModule_ProvidePresenterFactory.PlaceComponentResult(getPaymentResultModule, authRequestContext6));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent PlaceComponentResult;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.X());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
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
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent PlaceComponentResult;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PromoCategoryPresenter$1());
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

        @Override // id.dana.di.component.BalancePayComponent
        public final void PlaceComponentResult(BalancePayFragment balancePayFragment) {
            balancePayFragment.changePayMethodPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda6.get();
            BalancePayFragment_MembersInjector.getAuthRequestContext(balancePayFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            BalancePayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(balancePayFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext()));
            BalancePayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(balancePayFragment, this.whenAvailable.get());
            BalancePayFragment_MembersInjector.getAuthRequestContext(balancePayFragment, this.getSupportButtonTintMode.get());
        }

        @Override // id.dana.di.component.BalancePayComponent
        public final void MyBillsEntityDataFactory(BalanceQrisPayFragment balanceQrisPayFragment) {
            BalanceQrisPayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(balanceQrisPayFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
            BalanceQrisPayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(balanceQrisPayFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext()));
            BalanceQrisPayFragment_MembersInjector.getAuthRequestContext(balanceQrisPayFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
            BalanceQrisPayFragment_MembersInjector.MyBillsEntityDataFactory(balanceQrisPayFragment, this.whenAvailable.get());
            balanceQrisPayFragment.payQrPresenter = this.getSupportButtonTintMode.get();
            BalanceQrisPayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(balanceQrisPayFragment, this.readMicros.get());
        }
    }
}
