package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.feeds.UserFeedsContract;
import id.dana.contract.feeds.UserFeedsModule;
import id.dana.contract.feeds.UserFeedsModule_ProvidePresenterFactory;
import id.dana.contract.feeds.UserFeedsModule_ProvideViewFactory;
import id.dana.contract.feeds.UserFeedsPresenter;
import id.dana.contract.feeds.UserFeedsPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.feeds.interactor.DeleteFeeds;
import id.dana.domain.feeds.interactor.DeleteFeeds_Factory;
import id.dana.domain.feeds.interactor.GetUserFeeds;
import id.dana.domain.feeds.interactor.GetUserFeeds_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.feeds.mapper.FeedsModelMapper_Factory;
import id.dana.feeds.views.UserFeedsActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerFeedsComponent {
    private DaggerFeedsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;
        public UserFeedsModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class FeedsComponentImpl implements FeedsComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<SSLPinningRepository> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final FeedsComponentImpl MyBillsEntityDataFactory;
        private Provider<FeedsRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<UserFeedsPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<DeleteFeeds> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<UserFeedsContract.View> initRecordTimeStamp;
        private Provider<UserFeedsContract.Presenter> lookAheadTest;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<GetUserFeeds> scheduleImpl;

        public /* synthetic */ FeedsComponentImpl(UserFeedsModule userFeedsModule, ApplicationComponent applicationComponent, byte b) {
            this(userFeedsModule, applicationComponent);
        }

        private FeedsComponentImpl(UserFeedsModule userFeedsModule, ApplicationComponent applicationComponent) {
            FeedsModelMapper_Factory feedsModelMapper_Factory;
            this.MyBillsEntityDataFactory = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.GetContactSyncConfig, create);
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(UserFeedsModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(userFeedsModule));
            FeedsRepositoryProvider feedsRepositoryProvider = new FeedsRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = feedsRepositoryProvider;
            this.scheduleImpl = GetUserFeeds_Factory.create(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, feedsRepositoryProvider);
            DeleteFeeds_Factory create2 = DeleteFeeds_Factory.create(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.getAuthRequestContext = create2;
            Provider<UserFeedsContract.View> provider = this.initRecordTimeStamp;
            Provider<GetUserFeeds> provider2 = this.scheduleImpl;
            feedsModelMapper_Factory = FeedsModelMapper_Factory.InstanceHolder.PlaceComponentResult;
            Provider<UserFeedsPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(UserFeedsPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, create2, feedsModelMapper_Factory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(UserFeedsModule_ProvidePresenterFactory.MyBillsEntityDataFactory(userFeedsModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
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
        /* loaded from: classes8.dex */
        public static final class FeedsRepositoryProvider implements Provider<FeedsRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeedsRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsRepository get() {
                return (FeedsRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4());
            }
        }

        @Override // id.dana.di.component.FeedsComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(UserFeedsActivity userFeedsActivity) {
            ((BaseActivity) userFeedsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(userFeedsActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(userFeedsActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            userFeedsActivity.presenter = this.lookAheadTest.get();
        }
    }
}
