package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.splitbill.tracker.SplitBillMixpanelTracker;
import id.dana.splitbill.view.SplitBillDetailsActivity;
import id.dana.splitbill.view.SplitBillDetailsActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSplitBillDetailsComponent {
    private DaggerSplitBillDetailsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillDetailsComponentImpl implements SplitBillDetailsComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsOfflineF2FPay> MyBillsEntityDataFactory;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private final SplitBillDetailsComponentImpl getErrorConfigVersion;
        private Provider<ThreadExecutor> lookAheadTest;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ SplitBillDetailsComponentImpl(ApplicationComponent applicationComponent, byte b) {
            this(applicationComponent);
        }

        private SplitBillDetailsComponentImpl(ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            this.PlaceComponentResult = applicationComponent;
            this.lookAheadTest = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.lookAheadTest, this.scheduleImpl, create);
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
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

        @Override // id.dana.di.component.SplitBillDetailsComponent
        public final void getAuthRequestContext(SplitBillDetailsActivity splitBillDetailsActivity) {
            ((BaseActivity) splitBillDetailsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(splitBillDetailsActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(splitBillDetailsActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            SplitBillDetailsActivity_MembersInjector.PlaceComponentResult(splitBillDetailsActivity, new SplitBillMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
        }
    }
}
