package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.UserStatementModule;
import id.dana.di.modules.UserStatementModule_ProvidePresenterFactory;
import id.dana.di.modules.UserStatementModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement_Factory;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetStatementDetail;
import id.dana.domain.statement.interactor.GetStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementDisableDetail;
import id.dana.domain.statement.interactor.GetStatementDisableDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementSummary;
import id.dana.domain.statement.interactor.GetStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetTotalStatements;
import id.dana.domain.statement.interactor.GetTotalStatements_Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.statement.StatementActivity;
import id.dana.statement.StatementActivity_MembersInjector;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementPresenter;
import id.dana.statement.UserStatementPresenter_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerUserStatementComponent {
    private DaggerUserStatementComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public BottomSheetOnBoardingModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public UserStatementModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class UserStatementComponentImpl implements UserStatementComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> DatabaseTableConfigUtil;
        private Provider<UserStatementContract.Presenter> GetContactSyncConfig;
        private Provider<GetAllStatementDetail> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<BottomSheetOnBoardingPresenter> MyBillsEntityDataFactory;
        private Provider<GetStatementDetail> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<BottomSheetOnBoardingContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<BottomSheetOnBoardingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<UserStatementRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private final UserStatementComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetAllStatementSummary> PlaceComponentResult;
        private Provider<UserEducationRepository> PrepareContext;
        private Provider<CheckFeatureDownloadStatement> getAuthRequestContext;
        private Provider<GetTotalStatements> getErrorConfigVersion;
        private Provider<UserStatementContract.View> initRecordTimeStamp;
        private Provider<SaveDisplayBottomSheetOnBoarding> isLayoutRequested;
        private Provider<GetBottomSheetOnBoarding> lookAheadTest;
        private Provider<GetStatementSummary> moveToNextValue;
        private Provider<UserStatementPresenter> newProxyInstance;
        private Provider<GetStatementDisableDetail> scheduleImpl;

        public /* synthetic */ UserStatementComponentImpl(UserStatementModule userStatementModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent, byte b) {
            this(userStatementModule, bottomSheetOnBoardingModule, applicationComponent);
        }

        private UserStatementComponentImpl(UserStatementModule userStatementModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvideViewFactory.getAuthRequestContext(userStatementModule));
            UserStatementRepositoryProvider userStatementRepositoryProvider = new UserStatementRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = userStatementRepositoryProvider;
            this.moveToNextValue = GetStatementSummary_Factory.create(userStatementRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetStatementDetail_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.PlaceComponentResult = GetAllStatementSummary_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.getErrorConfigVersion = GetTotalStatements_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetAllStatementDetail_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.getAuthRequestContext = CheckFeatureDownloadStatement_Factory.create(featureConfigRepositoryProvider);
            GetStatementDisableDetail_Factory create = GetStatementDisableDetail_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.scheduleImpl = create;
            Provider<UserStatementPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(UserStatementPresenter_Factory.getAuthRequestContext(this.initRecordTimeStamp, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, create));
            this.newProxyInstance = authRequestContext;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(userStatementModule, authRequestContext));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.PrepareContext = userEducationRepositoryProvider;
            this.lookAheadTest = GetBottomSheetOnBoarding_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.DatabaseTableConfigUtil, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create2 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.DatabaseTableConfigUtil, this.PrepareContext);
            this.isLayoutRequested = create2;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.lookAheadTest, create2);
            this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserStatementRepositoryProvider implements Provider<UserStatementRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserStatementRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserStatementRepository get() {
                return (UserStatementRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.DebugCoroutineInfoImpl());
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
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$1());
            }
        }

        @Override // id.dana.di.component.UserStatementComponent
        public final void MyBillsEntityDataFactory(StatementActivity statementActivity) {
            StatementActivity_MembersInjector.getAuthRequestContext(statementActivity, this.GetContactSyncConfig.get());
            StatementActivity_MembersInjector.MyBillsEntityDataFactory(statementActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
