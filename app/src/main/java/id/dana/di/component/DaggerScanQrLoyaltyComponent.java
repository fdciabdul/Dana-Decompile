package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.animation.ScanQrLoyaltyActivity;
import id.dana.animation.ScanQrLoyaltyActivity_MembersInjector;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.animation.ScanQrLoyaltyPresenter;
import id.dana.animation.ScanQrLoyaltyPresenter_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.ScanQrLoyaltyModule;
import id.dana.di.modules.ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory;
import id.dana.di.modules.ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.scanner.gallery.RxQRDecode;
import id.dana.scanner.gallery.RxQRDecode_Factory;
import id.dana.utils.TimerUtil;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerScanQrLoyaltyComponent {
    private DaggerScanQrLoyaltyComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ScanQrLoyaltyModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ScanQrLoyaltyComponentImpl implements ScanQrLoyaltyComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ScanQrLoyaltyPresenter> DatabaseTableConfigUtil;
        private final ScanQrLoyaltyComponentImpl GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<IsOfflineF2FPay> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<ScanQrLoyaltyContract.Presenter> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<RxQRDecode> moveToNextValue;
        private Provider<ScanQrLoyaltyContract.View> scheduleImpl;

        public /* synthetic */ ScanQrLoyaltyComponentImpl(ScanQrLoyaltyModule scanQrLoyaltyModule, ApplicationComponent applicationComponent, byte b) {
            this(scanQrLoyaltyModule, applicationComponent);
        }

        private ScanQrLoyaltyComponentImpl(ScanQrLoyaltyModule scanQrLoyaltyModule, ApplicationComponent applicationComponent) {
            this.GetContactSyncConfig = this;
            this.getAuthRequestContext = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.lookAheadTest, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory.MyBillsEntityDataFactory(scanQrLoyaltyModule));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            RxQRDecode_Factory MyBillsEntityDataFactory = RxQRDecode_Factory.MyBillsEntityDataFactory(contextProvider);
            this.moveToNextValue = MyBillsEntityDataFactory;
            ScanQrLoyaltyPresenter_Factory BuiltInFictitiousFunctionClassFactory = ScanQrLoyaltyPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, MyBillsEntityDataFactory, GetNativelyDecodedQr_Factory.create());
            this.DatabaseTableConfigUtil = BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(ScanQrLoyaltyModule_ProvideScanQrLoyaltyPresenterFactory.PlaceComponentResult(scanQrLoyaltyModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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

        @Override // id.dana.di.component.ScanQrLoyaltyComponent
        public final void PlaceComponentResult(ScanQrLoyaltyActivity scanQrLoyaltyActivity) {
            ((BaseActivity) scanQrLoyaltyActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(scanQrLoyaltyActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(scanQrLoyaltyActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            ScanQrLoyaltyActivity_MembersInjector.MyBillsEntityDataFactory(scanQrLoyaltyActivity, this.getErrorConfigVersion.get());
            ScanQrLoyaltyActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(scanQrLoyaltyActivity, new TimerUtil());
        }
    }
}
