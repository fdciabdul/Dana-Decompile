package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.tracker.UserConsentTracker;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.miniprogram.tnc.TncServiceDialogActivity;
import id.dana.miniprogram.tnc.TncServiceDialogActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerServiceAgreementComponent {
    private DaggerServiceAgreementComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ServiceAgreementComponentImpl implements ServiceAgreementComponent {
        private Provider<PostExecutionThread> BuiltInFictitiousFunctionClassFactory;
        private Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private final ServiceAgreementComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<SSLPinningRepository> moveToNextValue;
        private Provider<ThreadExecutor> scheduleImpl;

        public /* synthetic */ ServiceAgreementComponentImpl(ApplicationComponent applicationComponent, byte b) {
            this(applicationComponent);
        }

        private ServiceAgreementComponentImpl(ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.getAuthRequestContext = applicationComponent;
            this.scheduleImpl = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new SSLPinningRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.scheduleImpl, this.moveToNextValue, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        @Override // id.dana.di.component.ServiceAgreementComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(TncServiceDialogActivity tncServiceDialogActivity) {
            ((BaseActivity) tncServiceDialogActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(tncServiceDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(tncServiceDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            TncServiceDialogActivity_MembersInjector.PlaceComponentResult(tncServiceDialogActivity, new UserConsentTracker((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue())));
        }
    }
}
