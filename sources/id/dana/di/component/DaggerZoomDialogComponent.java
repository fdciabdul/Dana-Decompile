package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.animation.view.ZoomDialog;
import id.dana.animation.view.ZoomDialog_MembersInjector;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
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
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerZoomDialogComponent {
    private DaggerZoomDialogComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OfflinePayModule BuiltInFictitiousFunctionClassFactory;
        public PayQrModule MyBillsEntityDataFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZoomDialogComponentImpl implements ZoomDialogComponent {
        private Provider<GetPaymentCode> BuiltInFictitiousFunctionClassFactory;
        private Provider<PayQrPresenter> DatabaseTableConfigUtil;
        private Provider<SetSeedExtra> FragmentBottomSheetPaymentSettingBinding;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetOtpInitResult> MyBillsEntityDataFactory;
        private Provider<GetQrisPaymentData> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PauseOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<OfflinePayContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<StopOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<StartOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<QrPayRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<RestartOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<PayQrContract.View> PrepareContext;
        private final ZoomDialogComponentImpl SubSequence;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<OfflinePayPresenter> getErrorConfigVersion;
        private Provider<PayQrContract.Presenter> initRecordTimeStamp;
        private Provider<OfflinePayContract.View> isLayoutRequested;
        private Provider<IsCashierEntryPointEnabled> lookAheadTest;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<SSLPinningRepository> newProxyInstance;
        private Provider<IsQrisEnable> scheduleImpl;

        public /* synthetic */ ZoomDialogComponentImpl(PayQrModule payQrModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent, byte b) {
            this(payQrModule, offlinePayModule, applicationComponent);
        }

        private ZoomDialogComponentImpl(PayQrModule payQrModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent) {
            this.SubSequence = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ThreadExecutorProvider(applicationComponent);
            this.newProxyInstance = new SSLPinningRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.GetContactSyncConfig, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.newProxyInstance, create);
            Provider<OfflinePayContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvideViewFactory.getAuthRequestContext(offlinePayModule));
            this.isLayoutRequested = authRequestContext;
            OfflinePayPresenter_Factory authRequestContext2 = OfflinePayPresenter_Factory.getAuthRequestContext(this.moveToNextValue, authRequestContext);
            this.getErrorConfigVersion = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(offlinePayModule, authRequestContext2));
            this.PrepareContext = DoubleCheck.getAuthRequestContext(PayQrModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(payQrModule));
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = qrPayRepositoryProvider;
            this.FragmentBottomSheetPaymentSettingBinding = SetSeedExtra_Factory.create(qrPayRepositoryProvider);
            this.MyBillsEntityDataFactory = GetOtpInitResult_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.scheduleImpl = IsQrisEnable_Factory.create(this.PlaceComponentResult);
            this.lookAheadTest = IsCashierEntryPointEnabled_Factory.create(this.PlaceComponentResult);
            this.BuiltInFictitiousFunctionClassFactory = GetPaymentCode_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetQrisPaymentData_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7, QrisPaymentData_Factory.create(), this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = StartOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = StopOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PauseOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            RestartOfflinePay_Factory create2 = RestartOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = create2;
            Provider<PayQrPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(PayQrPresenter_Factory.PlaceComponentResult(this.PrepareContext, this.FragmentBottomSheetPaymentSettingBinding, this.MyBillsEntityDataFactory, this.scheduleImpl, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, create2, this.moveToNextValue));
            this.DatabaseTableConfigUtil = authRequestContext3;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(PayQrModule_ProvidePresenterFactory.PlaceComponentResult(payQrModule, authRequestContext3));
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
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PromoCategoryPresenter$1());
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

        @Override // id.dana.di.component.ZoomDialogComponent
        public final void PlaceComponentResult(ZoomDialog zoomDialog) {
            ((BaseActivity) zoomDialog).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(zoomDialog, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(zoomDialog, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            ZoomDialog_MembersInjector.MyBillsEntityDataFactory(zoomDialog, (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory()));
            ZoomDialog_MembersInjector.BuiltInFictitiousFunctionClassFactory(zoomDialog, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
            zoomDialog.payQrPresenter = this.initRecordTimeStamp.get();
        }
    }
}
