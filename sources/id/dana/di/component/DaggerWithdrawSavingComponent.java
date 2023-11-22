package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.WithdrawSavingModule;
import id.dana.di.modules.WithdrawSavingModule_ProvideWitdrawSavingViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetWithdrawOption;
import id.dana.domain.saving.interactor.GetWithdrawOption_Factory;
import id.dana.domain.saving.interactor.InitSavingWithdraw;
import id.dana.domain.saving.interactor.InitSavingWithdraw_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.savings.WithdrawSavingPresenter;
import id.dana.savings.WithdrawSavingPresenter_Factory;
import id.dana.savings.contract.WithdrawSavingContract;
import id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog;
import id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerWithdrawSavingComponent {
    private DaggerWithdrawSavingComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public WithdrawSavingModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class WithdrawSavingComponentImpl implements WithdrawSavingComponent {
        private Provider<InitSavingWithdraw> BuiltInFictitiousFunctionClassFactory;
        private final WithdrawSavingComponentImpl DatabaseTableConfigUtil;
        private Provider<GetWithdrawOption> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetUserInfoWithKyc> MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<WithdrawSavingPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<Context> getAuthRequestContext;
        private Provider<WithdrawSavingContract.View> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<UserRepository> moveToNextValue;
        private Provider<SavingRepository> scheduleImpl;

        public /* synthetic */ WithdrawSavingComponentImpl(WithdrawSavingModule withdrawSavingModule, ApplicationComponent applicationComponent, byte b) {
            this(withdrawSavingModule, applicationComponent);
        }

        private WithdrawSavingComponentImpl(WithdrawSavingModule withdrawSavingModule, ApplicationComponent applicationComponent) {
            this.DatabaseTableConfigUtil = this;
            this.PlaceComponentResult = applicationComponent;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(WithdrawSavingModule_ProvideWitdrawSavingViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(withdrawSavingModule));
            this.getAuthRequestContext = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.moveToNextValue = userRepositoryProvider;
            this.MyBillsEntityDataFactory = GetUserInfoWithKyc_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, userRepositoryProvider);
            SavingRepositoryProvider savingRepositoryProvider = new SavingRepositoryProvider(applicationComponent);
            this.scheduleImpl = savingRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetWithdrawOption_Factory.create(savingRepositoryProvider);
            InitSavingWithdraw_Factory create = InitSavingWithdraw_Factory.create(this.scheduleImpl);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(WithdrawSavingPresenter_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, create));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
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
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.useDaemonThreadFactory());
            }
        }

        @Override // id.dana.di.component.WithdrawSavingComponent
        public final void MyBillsEntityDataFactory(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
            WithdrawalSavingBottomSheetDialog_MembersInjector.BuiltInFictitiousFunctionClassFactory(withdrawalSavingBottomSheetDialog, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            WithdrawalSavingBottomSheetDialog_MembersInjector.getAuthRequestContext(withdrawalSavingBottomSheetDialog, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
        }
    }
}
