package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.DanaAppWidgetPresenter;
import id.dana.appwidget.DanaAppWidgetPresenter_Factory;
import id.dana.appwidget.DanaIncomeWidgetProvider;
import id.dana.appwidget.DanaIncomeWidgetProvider_MembersInjector;
import id.dana.appwidget.DanaQuickActionMediumWidgetProvider;
import id.dana.appwidget.DanaQuickActionMediumWidgetProvider_MembersInjector;
import id.dana.appwidget.DanaQuickActionWidgetProvider;
import id.dana.appwidget.DanaQuickActionWidgetProvider_MembersInjector;
import id.dana.appwidget.DanaStatementLargeWidgetProvider;
import id.dana.appwidget.DanaStatementLargeWidgetProvider_MembersInjector;
import id.dana.appwidget.DanaStatementMediumWidgetProvider;
import id.dana.appwidget.DanaStatementMediumWidgetProvider_MembersInjector;
import id.dana.appwidget.DanaStatementWidgetProvider;
import id.dana.appwidget.DanaStatementWidgetProvider_MembersInjector;
import id.dana.appwidget.collectionview.StatementListRemoteViewsFactory;
import id.dana.appwidget.collectionview.StatementListRemoteViewsFactory_MembersInjector;
import id.dana.appwidget.mapper.IncomeAndExpenseEntryChartModelMapper_Factory;
import id.dana.di.modules.DanaAppWidgetModule;
import id.dana.di.modules.DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.DanaAppWidgetModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.account.interactor.HasAccount_Factory;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummarySynchronously;
import id.dana.domain.statement.interactor.GetAllStatementSummarySynchronously_Factory;
import id.dana.domain.statement.interactor.GetAllStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetCustomStatementSummary;
import id.dana.domain.statement.interactor.GetCustomStatementSummary_Factory;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetBalance_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerDanaWidgetComponent {
    private DaggerDanaWidgetComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public DanaAppWidgetModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final DanaWidgetComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, DanaAppWidgetModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new DanaWidgetComponentImpl(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class DanaWidgetComponentImpl implements DanaWidgetComponent {
        private Provider<GetAllStatementSummary> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<UserStatementRepository> GetContactSyncConfig;
        private Provider<DanaAppWidgetPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private final DanaWidgetComponentImpl MyBillsEntityDataFactory;
        private Provider<GetBalance> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DanaAppWidgetContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetAllStatementSummarySynchronously> PlaceComponentResult;
        private Provider<GetAllStatementDetail> getAuthRequestContext;
        private Provider<GetCustomStatementSummary> getErrorConfigVersion;
        private Provider<DanaAppWidgetContract.View> initRecordTimeStamp;
        private Provider<HasAccount> lookAheadTest;
        private Provider<LiteAccountRepository> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        /* synthetic */ DanaWidgetComponentImpl(DanaAppWidgetModule danaAppWidgetModule, ApplicationComponent applicationComponent, byte b) {
            this(danaAppWidgetModule, applicationComponent);
        }

        private DanaWidgetComponentImpl(DanaAppWidgetModule danaAppWidgetModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(DanaAppWidgetModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(danaAppWidgetModule));
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = userRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetBalance_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, userRepositoryProvider);
            UserStatementRepositoryProvider userStatementRepositoryProvider = new UserStatementRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = userStatementRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetAllStatementSummary_Factory.create(userStatementRepositoryProvider);
            this.getAuthRequestContext = GetAllStatementDetail_Factory.create(this.GetContactSyncConfig);
            this.getErrorConfigVersion = GetCustomStatementSummary_Factory.create(this.GetContactSyncConfig);
            this.PlaceComponentResult = GetAllStatementSummarySynchronously_Factory.create(this.GetContactSyncConfig);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.moveToNextValue = liteAccountRepositoryProvider;
            this.lookAheadTest = HasAccount_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, liteAccountRepositoryProvider);
            DanaAppWidgetPresenter_Factory MyBillsEntityDataFactory = DanaAppWidgetPresenter_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda0, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.getErrorConfigVersion, this.PlaceComponentResult, IncomeAndExpenseEntryChartModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(), this.lookAheadTest);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(danaAppWidgetModule, MyBillsEntityDataFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DanaQuickActionWidgetProvider danaQuickActionWidgetProvider) {
            DanaQuickActionWidgetProvider_MembersInjector.BuiltInFictitiousFunctionClassFactory(danaQuickActionWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DanaStatementWidgetProvider danaStatementWidgetProvider) {
            DanaStatementWidgetProvider_MembersInjector.getAuthRequestContext(danaStatementWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DanaIncomeWidgetProvider danaIncomeWidgetProvider) {
            DanaIncomeWidgetProvider_MembersInjector.MyBillsEntityDataFactory(danaIncomeWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void BuiltInFictitiousFunctionClassFactory(DanaStatementLargeWidgetProvider danaStatementLargeWidgetProvider) {
            DanaStatementLargeWidgetProvider_MembersInjector.BuiltInFictitiousFunctionClassFactory(danaStatementLargeWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(DanaStatementMediumWidgetProvider danaStatementMediumWidgetProvider) {
            DanaStatementMediumWidgetProvider_MembersInjector.PlaceComponentResult(danaStatementMediumWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void PlaceComponentResult(DanaQuickActionMediumWidgetProvider danaQuickActionMediumWidgetProvider) {
            DanaQuickActionMediumWidgetProvider_MembersInjector.getAuthRequestContext(danaQuickActionMediumWidgetProvider, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }

        @Override // id.dana.di.component.DanaWidgetComponent
        public final void MyBillsEntityDataFactory(StatementListRemoteViewsFactory statementListRemoteViewsFactory) {
            StatementListRemoteViewsFactory_MembersInjector.BuiltInFictitiousFunctionClassFactory(statementListRemoteViewsFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
