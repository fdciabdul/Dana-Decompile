package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.userpersonalization.UserPersonalizationContract;
import id.dana.contract.userpersonalization.UserPersonalizationModule;
import id.dana.contract.userpersonalization.UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory;
import id.dana.contract.userpersonalization.UserPersonalizationModule_ProvideUserPersonalizationViewFactory;
import id.dana.contract.userpersonalization.UserPersonalizationPresenter;
import id.dana.contract.userpersonalization.UserPersonalizationPresenter_Factory;
import id.dana.di.modules.UserPersonalizationAnalyticModule;
import id.dana.di.modules.UserPersonalizationAnalyticModule_ProvidesUserPersonalizationAnalyticTrackerFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization_Factory;
import id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization;
import id.dana.explore.domain.userpersonalization.interactor.CreateUserPersonalization_Factory;
import id.dana.explore.domain.userpersonalization.interactor.GetPersonalizationOptions;
import id.dana.explore.domain.userpersonalization.interactor.GetPersonalizationOptions_Factory;
import id.dana.explore.domain.userpersonalization.interactor.SaveUserPersonalizationShown;
import id.dana.explore.domain.userpersonalization.interactor.SaveUserPersonalizationShown_Factory;
import id.dana.userpersonalization.UserPersonalizationActivity;
import id.dana.userpersonalization.UserPersonalizationActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerUserPersonalizationComponent {
    private DaggerUserPersonalizationComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public UserPersonalizationModule MyBillsEntityDataFactory;
        public UserPersonalizationAnalyticModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class UserPersonalizationComponentImpl implements UserPersonalizationComponent {
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<UserPersonalizationContract.Presenter> GetContactSyncConfig;
        private Provider<CheckShouldShowUserPersonalization> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<GetPersonalizationOptions> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SaveUserPersonalizationShown> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private final UserPersonalizationAnalyticModule NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<UserPersonalizationPresenter> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<UserPersonalizationRepository> PrepareContext;
        private Provider<CreateUserPersonalization> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<UserPersonalizationContract.View> initRecordTimeStamp;
        private final UserPersonalizationComponentImpl isLayoutRequested;
        private Provider<GlobalSearchRepository> lookAheadTest;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<FeatureConfigRepository> scheduleImpl;

        public /* synthetic */ UserPersonalizationComponentImpl(UserPersonalizationModule userPersonalizationModule, UserPersonalizationAnalyticModule userPersonalizationAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(userPersonalizationModule, userPersonalizationAnalyticModule, applicationComponent);
        }

        private UserPersonalizationComponentImpl(UserPersonalizationModule userPersonalizationModule, UserPersonalizationAnalyticModule userPersonalizationAnalyticModule, ApplicationComponent applicationComponent) {
            this.isLayoutRequested = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = userPersonalizationAnalyticModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.scheduleImpl = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.DatabaseTableConfigUtil, create);
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(UserPersonalizationModule_ProvideUserPersonalizationViewFactory.BuiltInFictitiousFunctionClassFactory(userPersonalizationModule));
            UserPersonalizationRepositoryProvider userPersonalizationRepositoryProvider = new UserPersonalizationRepositoryProvider(applicationComponent);
            this.PrepareContext = userPersonalizationRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetPersonalizationOptions_Factory.BuiltInFictitiousFunctionClassFactory(userPersonalizationRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = SaveUserPersonalizationShown_Factory.getAuthRequestContext(this.PrepareContext);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.getAuthRequestContext = CreateUserPersonalization_Factory.getAuthRequestContext(accountRepositoryProvider, this.PrepareContext);
            ProvideGlobalSearchRepositoryProvider provideGlobalSearchRepositoryProvider = new ProvideGlobalSearchRepositoryProvider(applicationComponent);
            this.lookAheadTest = provideGlobalSearchRepositoryProvider;
            CheckShouldShowUserPersonalization_Factory KClassImpl$Data$declaredNonStaticMembers$2 = CheckShouldShowUserPersonalization_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext, this.BuiltInFictitiousFunctionClassFactory, provideGlobalSearchRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            UserPersonalizationPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = UserPersonalizationPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$22;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(UserPersonalizationModule_ProvideUserPersonalizationPresenterFactory.BuiltInFictitiousFunctionClassFactory(userPersonalizationModule, KClassImpl$Data$declaredNonStaticMembers$22));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserPersonalizationRepositoryProvider implements Provider<UserPersonalizationRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserPersonalizationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserPersonalizationRepository get() {
                return (UserPersonalizationRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SchedulerPoolFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideGlobalSearchRepositoryProvider implements Provider<GlobalSearchRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideGlobalSearchRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalSearchRepository get() {
                return (GlobalSearchRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.o());
            }
        }

        @Override // id.dana.di.component.UserPersonalizationComponent
        public final void MyBillsEntityDataFactory(UserPersonalizationActivity userPersonalizationActivity) {
            ((BaseActivity) userPersonalizationActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(userPersonalizationActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(userPersonalizationActivity, DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
            UserPersonalizationActivity_MembersInjector.getAuthRequestContext(userPersonalizationActivity, this.GetContactSyncConfig.get());
            UserPersonalizationActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(userPersonalizationActivity, UserPersonalizationAnalyticModule_ProvidesUserPersonalizationAnalyticTrackerFactory.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7, (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue())));
        }
    }
}
