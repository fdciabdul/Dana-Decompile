package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payasset.ChangePayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.ChangePayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.ChangePayMethodPresenter;
import id.dana.contract.payasset.ChangePayMethodPresenter_Factory;
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
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
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
import id.dana.domain.user.repository.UserRepository;
import id.dana.pay.CardPayFragment;
import id.dana.pay.CardPayFragment_MembersInjector;
import id.dana.pay.CardQrisPayFragment;
import id.dana.pay.CardQrisPayFragment_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCardPayComponent {
    private DaggerCardPayComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OfflinePayModule BuiltInFictitiousFunctionClassFactory;
        public PayQrModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ChangePayMethodModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final CardPayComponent KClassImpl$Data$declaredNonStaticMembers$2() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, PayQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, ChangePayMethodModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, OfflinePayModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new CardPayComponentImpl(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class CardPayComponentImpl implements CardPayComponent {
        private final CardPayComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<PayAssetRepository> DatabaseTableConfigUtil;
        private Provider<StartOfflinePay> FragmentBottomSheetPaymentSettingBinding;
        private Provider<PauseOfflinePay> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetOtpInitResult> MyBillsEntityDataFactory;
        private Provider<GetPaymentCode> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<OfflinePayPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SetSeedExtra> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<QrPayRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PayQrContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<RestartOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<ChangePayMethodContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<OfflinePayContract.View> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<ChangePayMethod> PlaceComponentResult;
        private Provider<PayQrContract.Presenter> PrepareContext;
        private Provider<ChangePayMethodPresenter> getAuthRequestContext;
        private Provider<UserRepository> getCallingPid;
        private Provider<IsOfflineF2FPay> getErrorConfigVersion;
        private Provider<PayQrPresenter> initRecordTimeStamp;
        private Provider<ChangePayMethodContract.View> isLayoutRequested;
        private Provider<GetQrisPaymentData> lookAheadTest;
        private Provider<IsCashierEntryPointEnabled> moveToNextValue;
        private Provider<OfflinePayContract.Presenter> newProxyInstance;
        private Provider<ThreadExecutor> readMicros;
        private Provider<IsQrisEnable> scheduleImpl;
        private Provider<StopOfflinePay> whenAvailable;

        /* synthetic */ CardPayComponentImpl(PayQrModule payQrModule, ChangePayMethodModule changePayMethodModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent, byte b) {
            this(payQrModule, changePayMethodModule, offlinePayModule, applicationComponent);
        }

        private CardPayComponentImpl(PayQrModule payQrModule, ChangePayMethodModule changePayMethodModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(ChangePayMethodModule_ProvideViewFactory.MyBillsEntityDataFactory(changePayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = payAssetRepositoryProvider;
            this.PlaceComponentResult = ChangePayMethod_Factory.create(payAssetRepositoryProvider);
            this.readMicros = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.readMicros, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            this.getErrorConfigVersion = create;
            Provider<ChangePayMethodPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(ChangePayMethodPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, this.PlaceComponentResult, create));
            this.getAuthRequestContext = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(ChangePayMethodModule_ProvidePresenterFactory.PlaceComponentResult(changePayMethodModule, authRequestContext));
            Provider<OfflinePayContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvideViewFactory.getAuthRequestContext(offlinePayModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext2;
            OfflinePayPresenter_Factory authRequestContext3 = OfflinePayPresenter_Factory.getAuthRequestContext(this.getErrorConfigVersion, authRequestContext2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext3;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(offlinePayModule, authRequestContext3));
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = DoubleCheck.getAuthRequestContext(PayQrModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(payQrModule));
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = qrPayRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = SetSeedExtra_Factory.create(qrPayRepositoryProvider);
            this.MyBillsEntityDataFactory = GetOtpInitResult_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.scheduleImpl = IsQrisEnable_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.moveToNextValue = IsCashierEntryPointEnabled_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetPaymentCode_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.getCallingPid = new UserRepositoryProvider(applicationComponent);
            this.lookAheadTest = GetQrisPaymentData_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, QrisPaymentData_Factory.create(), this.getCallingPid);
            this.FragmentBottomSheetPaymentSettingBinding = StartOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.whenAvailable = StopOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.GetContactSyncConfig = PauseOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            RestartOfflinePay_Factory create2 = RestartOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = create2;
            Provider<PayQrPresenter> authRequestContext4 = DoubleCheck.getAuthRequestContext(PayQrPresenter_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.MyBillsEntityDataFactory, this.scheduleImpl, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.FragmentBottomSheetPaymentSettingBinding, this.whenAvailable, this.GetContactSyncConfig, create2, this.getErrorConfigVersion));
            this.initRecordTimeStamp = authRequestContext4;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(PayQrModule_ProvidePresenterFactory.PlaceComponentResult(payQrModule, authRequestContext4));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.X());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.CardPayComponent
        public final void BuiltInFictitiousFunctionClassFactory(CardPayFragment cardPayFragment) {
            CardPayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(cardPayFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda7.get());
            CardPayFragment_MembersInjector.MyBillsEntityDataFactory(cardPayFragment, this.newProxyInstance.get());
            CardPayFragment_MembersInjector.PlaceComponentResult(cardPayFragment, this.PrepareContext.get());
        }

        @Override // id.dana.di.component.CardPayComponent
        public final void BuiltInFictitiousFunctionClassFactory(CardQrisPayFragment cardQrisPayFragment) {
            CardQrisPayFragment_MembersInjector.PlaceComponentResult(cardQrisPayFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda7.get());
            CardQrisPayFragment_MembersInjector.getAuthRequestContext(cardQrisPayFragment, this.newProxyInstance.get());
            CardQrisPayFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(cardQrisPayFragment, this.PrepareContext.get());
        }
    }
}
