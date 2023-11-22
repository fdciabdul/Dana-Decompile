package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SavingModule_ProvideSavingPresenterFactory;
import id.dana.di.modules.SavingModule_ProvideSavingViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingEmptyState_Factory;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.GetSavingSummary_Factory;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.interactor.InitSavingCreate_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.richview.boundcard.DanaBalanceCardView;
import id.dana.richview.boundcard.DanaBalanceCardView_MembersInjector;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingPresenter;
import id.dana.savings.presenter.SavingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerWalletComponent {
    private DaggerWalletComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;
        public SavingModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final WalletComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, SavingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, ApplicationComponent.class);
            return new WalletComponentImpl(this.getAuthRequestContext, this.PlaceComponentResult, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class WalletComponentImpl implements WalletComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<UserRepository> DatabaseTableConfigUtil;
        private Provider<SavingCategoryRepository> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CheckGoalsBalanceFeature> MyBillsEntityDataFactory;
        private Provider<InitSavingCreate> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SavingRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SavingPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetSavingEmptyState> PlaceComponentResult;
        private Provider<GetSavingSummary> getAuthRequestContext;
        private Provider<SavingContract.View> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<GetUserInfoWithKyc> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private final WalletComponentImpl newProxyInstance;
        private Provider<SavingContract.Presenter> scheduleImpl;

        /* synthetic */ WalletComponentImpl(SavingModule savingModule, ApplicationComponent applicationComponent, byte b) {
            this(savingModule, applicationComponent);
        }

        private WalletComponentImpl(SavingModule savingModule, ApplicationComponent applicationComponent) {
            this.newProxyInstance = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingViewFactory.MyBillsEntityDataFactory(savingModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = savingCategoryRepositoryProvider;
            this.getAuthRequestContext = GetSavingSummary_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, savingCategoryRepositoryProvider);
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = userRepositoryProvider;
            this.lookAheadTest = GetUserInfoWithKyc_Factory.create(this.initRecordTimeStamp, this.moveToNextValue, userRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = InitSavingCreate_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.GetContactSyncConfig);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckGoalsBalanceFeature_Factory.create(featureConfigRepositoryProvider);
            GetSavingEmptyState_Factory create = GetSavingEmptyState_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.PlaceComponentResult = create;
            Provider<SavingPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SavingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.getAuthRequestContext, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, create));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingPresenterFactory.BuiltInFictitiousFunctionClassFactory(savingModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.useDaemonThreadFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getTextEndPadding());
            }
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
            private final ApplicationComponent getAuthRequestContext;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        @Override // id.dana.di.component.WalletComponent
        public final void PlaceComponentResult(DanaBalanceCardView danaBalanceCardView) {
            DanaBalanceCardView_MembersInjector.BuiltInFictitiousFunctionClassFactory(danaBalanceCardView, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
            DanaBalanceCardView_MembersInjector.getAuthRequestContext(danaBalanceCardView, this.scheduleImpl.get());
        }
    }
}
