package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.FamilyAccountIntroModule;
import id.dana.di.modules.FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory;
import id.dana.di.modules.FamilyAccountIntroModule_ProvideFamilyAccountViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.ActivateFamilyAccount;
import id.dana.domain.familyaccount.interactor.ActivateFamilyAccount_Factory;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.familyaccount.contract.FamilyActivationContract;
import id.dana.familyaccount.contract.FamilyActivationPresenter;
import id.dana.familyaccount.contract.FamilyActivationPresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.intro.FamilyAccountIntroActivity;
import id.dana.familyaccount.view.intro.FamilyAccountIntroActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountIntroComponent {
    private DaggerFamilyAccountIntroComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FamilyAccountIntroModule MyBillsEntityDataFactory;
        public FamilyAccountTrackerModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountIntroComponentImpl implements FamilyAccountIntroComponent {
        private Provider<ActivateFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<FamilyActivationContract.View> DatabaseTableConfigUtil;
        private Provider<FamilyAccountRepository> GetContactSyncConfig;
        private final FamilyAccountIntroComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<GetPhoneNumber> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FamilyActivationContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<FamilyAccountMixpanelTracker> PlaceComponentResult;
        private Provider<Context> getAuthRequestContext;
        private Provider<GetUserInfo> getErrorConfigVersion;
        private Provider<FamilyAccountAnalyticalTracker> initRecordTimeStamp;
        private Provider<LiteAccountRepository> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private Provider<FamilyActivationPresenter> scheduleImpl;

        public /* synthetic */ FamilyAccountIntroComponentImpl(FamilyAccountIntroModule familyAccountIntroModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(familyAccountIntroModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountIntroComponentImpl(FamilyAccountIntroModule familyAccountIntroModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(FamilyAccountIntroModule_ProvideFamilyAccountViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(familyAccountIntroModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = userRepositoryProvider;
            this.getErrorConfigVersion = GetUserInfo_Factory.create(userRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.lookAheadTest = liteAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetPhoneNumber_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, liteAccountRepositoryProvider);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = provideFamilyAccountRepositoryProvider;
            ActivateFamilyAccount_Factory create = ActivateFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            FamilyActivationPresenter_Factory authRequestContext = FamilyActivationPresenter_Factory.getAuthRequestContext(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
            this.scheduleImpl = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory.BuiltInFictitiousFunctionClassFactory(familyAccountIntroModule, authRequestContext));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.getAuthRequestContext = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.k());
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

        @Override // id.dana.di.component.FamilyAccountIntroComponent
        public final void BuiltInFictitiousFunctionClassFactory(FamilyAccountIntroActivity familyAccountIntroActivity) {
            FamilyAccountIntroActivity_MembersInjector.PlaceComponentResult(familyAccountIntroActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            FamilyAccountIntroActivity_MembersInjector.getAuthRequestContext(familyAccountIntroActivity, this.initRecordTimeStamp.get());
            FamilyAccountIntroActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(familyAccountIntroActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext()));
        }
    }
}
