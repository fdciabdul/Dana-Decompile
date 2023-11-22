package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory;
import id.dana.di.modules.PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview_Factory;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow_Factory;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.playstorereview.PlayStoreReviewActivity;
import id.dana.playstorereview.PlayStoreReviewActivity_MembersInjector;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.PlayStoreReviewPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerPlayStoreReviewComponent {
    private DaggerPlayStoreReviewComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public PlayStoreReviewModules PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class PlayStoreReviewComponentImpl implements PlayStoreReviewComponent {
        private Provider<IsOfflineF2FPay> BuiltInFictitiousFunctionClassFactory;
        private Provider<SaveLastPlayStoreReviewShow> DatabaseTableConfigUtil;
        private Provider<SSLPinningRepository> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsNeedToShowPlayStoreReview> MyBillsEntityDataFactory;
        private Provider<PlayStoreReviewPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<PlayStoreReviewContract.View> initRecordTimeStamp;
        private Provider<PlayStoreReviewContract.Presenter> lookAheadTest;
        private final PlayStoreReviewComponentImpl moveToNextValue;
        private Provider<PlayStoreReviewRepository> scheduleImpl;

        public /* synthetic */ PlayStoreReviewComponentImpl(PlayStoreReviewModules playStoreReviewModules, ApplicationComponent applicationComponent, byte b) {
            this(playStoreReviewModules, applicationComponent);
        }

        private PlayStoreReviewComponentImpl(PlayStoreReviewModules playStoreReviewModules, ApplicationComponent applicationComponent) {
            this.moveToNextValue = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, create);
            PlayStoreReviewRepositoryProvider playStoreReviewRepositoryProvider = new PlayStoreReviewRepositoryProvider(applicationComponent);
            this.scheduleImpl = playStoreReviewRepositoryProvider;
            this.MyBillsEntityDataFactory = IsNeedToShowPlayStoreReview_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getErrorConfigVersion, playStoreReviewRepositoryProvider);
            this.DatabaseTableConfigUtil = SaveLastPlayStoreReviewShow_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getErrorConfigVersion, this.scheduleImpl);
            Provider<PlayStoreReviewContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewViewFactory.getAuthRequestContext(playStoreReviewModules));
            this.initRecordTimeStamp = authRequestContext;
            PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory = PlayStoreReviewPresenter_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.DatabaseTableConfigUtil, authRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(PlayStoreReviewModules_ProvidePlayStoreReviewPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(playStoreReviewModules, MyBillsEntityDataFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PlayStoreReviewRepositoryProvider implements Provider<PlayStoreReviewRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PlayStoreReviewRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PlayStoreReviewRepository get() {
                return (PlayStoreReviewRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.Z());
            }
        }

        @Override // id.dana.di.component.PlayStoreReviewComponent
        public final void MyBillsEntityDataFactory(PlayStoreReviewActivity playStoreReviewActivity) {
            ((BaseActivity) playStoreReviewActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(playStoreReviewActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(playStoreReviewActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            PlayStoreReviewActivity_MembersInjector.MyBillsEntityDataFactory(playStoreReviewActivity, this.lookAheadTest.get());
        }
    }
}
