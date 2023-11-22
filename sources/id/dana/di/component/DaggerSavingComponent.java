package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.SavingConfigModule;
import id.dana.di.modules.SavingConfigModule_ProvideSavingViewFactory;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SavingModule_ProvideSavingPresenterFactory;
import id.dana.di.modules.SavingModule_ProvideSavingViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility_Factory;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingEmptyState_Factory;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.GetSavingSummary_Factory;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.interactor.InitSavingCreate_Factory;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.savings.activity.OnBoardingActivity_MembersInjector;
import id.dana.savings.activity.SavingsActivity;
import id.dana.savings.activity.SavingsActivity_MembersInjector;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingConfigPresenter;
import id.dana.savings.presenter.SavingConfigPresenter_Factory;
import id.dana.savings.presenter.SavingPresenter;
import id.dana.savings.presenter.SavingPresenter_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSavingComponent {
    private DaggerSavingComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public BottomSheetOnBoardingModule MyBillsEntityDataFactory;
        public SavingConfigModule PlaceComponentResult;
        public SavingModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SavingComponentImpl implements SavingComponent {
        private Provider<UserRepository> B;
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<InitSavingCreate> DatabaseTableConfigUtil;
        private Provider<SaveDisplayBottomSheetOnBoarding> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetSavingSummary> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SavingCategoryRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<SaveSavingBalanceVisibility> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private final SavingComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<SavingConfigContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<BottomSheetOnBoardingContract.View> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<BottomSheetOnBoardingPresenter> PlaceComponentResult;
        private Provider<SavingContract.Presenter> PrepareContext;
        private Provider<SavingRepository> SubSequence;
        private Provider<CheckGoalsBalanceFeature> getAuthRequestContext;
        private Provider<ThreadExecutor> getCallingPid;
        private Provider<GetSavingBalanceVisibility> getErrorConfigVersion;
        private Provider<SavingPresenter> getSupportButtonTintMode;
        private Provider<GetUserInfoWithKyc> initRecordTimeStamp;
        private Provider<BottomSheetOnBoardingContract.Presenter> isLayoutRequested;
        private Provider<GetBottomSheetOnBoarding> lookAheadTest;
        private Provider<GetSavingEmptyState> moveToNextValue;
        private Provider<SavingContract.View> newProxyInstance;
        private Provider<SavingConfigPresenter> readMicros;
        private Provider<Context> scheduleImpl;
        private Provider<UserEducationRepository> whenAvailable;

        public /* synthetic */ SavingComponentImpl(SavingModule savingModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, SavingConfigModule savingConfigModule, ApplicationComponent applicationComponent, byte b) {
            this(savingModule, bottomSheetOnBoardingModule, savingConfigModule, applicationComponent);
        }

        private SavingComponentImpl(SavingModule savingModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, SavingConfigModule savingConfigModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.getCallingPid = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda5, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.whenAvailable = userEducationRepositoryProvider;
            this.lookAheadTest = GetBottomSheetOnBoarding_Factory.create(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create2 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.whenAvailable);
            this.FragmentBottomSheetPaymentSettingBinding = create2;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.lookAheadTest, create2);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingViewFactory.MyBillsEntityDataFactory(savingModule));
            this.SubSequence = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = savingCategoryRepositoryProvider;
            this.GetContactSyncConfig = GetSavingSummary_Factory.create(this.SubSequence, savingCategoryRepositoryProvider);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.B = userRepositoryProvider;
            this.initRecordTimeStamp = GetUserInfoWithKyc_Factory.create(this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda2, userRepositoryProvider);
            this.DatabaseTableConfigUtil = InitSavingCreate_Factory.create(this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.getAuthRequestContext = CheckGoalsBalanceFeature_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            GetSavingEmptyState_Factory create3 = GetSavingEmptyState_Factory.create(this.SubSequence);
            this.moveToNextValue = create3;
            Provider<SavingPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SavingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.newProxyInstance, this.GetContactSyncConfig, this.initRecordTimeStamp, this.DatabaseTableConfigUtil, this.getAuthRequestContext, create3));
            this.getSupportButtonTintMode = authRequestContext;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingPresenterFactory.BuiltInFictitiousFunctionClassFactory(savingModule, authRequestContext));
            this.scheduleImpl = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(SavingConfigModule_ProvideSavingViewFactory.BuiltInFictitiousFunctionClassFactory(savingConfigModule));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            this.getErrorConfigVersion = GetSavingBalanceVisibility_Factory.create(accountRepositoryProvider);
            SaveSavingBalanceVisibility_Factory create4 = SaveSavingBalanceVisibility_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = create4;
            this.readMicros = DoubleCheck.getAuthRequestContext(SavingConfigPresenter_Factory.PlaceComponentResult(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.getErrorConfigVersion, create4));
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
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getTextEndPadding());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.SavingComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SavingsActivity savingsActivity) {
            ((BaseActivity) savingsActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(savingsActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            OnBoardingActivity_MembersInjector.getAuthRequestContext(savingsActivity, this.isLayoutRequested.get());
            SavingsActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingsActivity, this.PrepareContext.get());
            savingsActivity.savingConfigPresenter = this.readMicros.get();
            SavingsActivity_MembersInjector.getAuthRequestContext(savingsActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext()));
        }
    }
}
