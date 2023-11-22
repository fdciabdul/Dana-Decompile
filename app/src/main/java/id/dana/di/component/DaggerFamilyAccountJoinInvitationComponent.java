package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.FamilyAccountJoinInvitationModule;
import id.dana.di.modules.FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory;
import id.dana.di.modules.FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation_Factory;
import id.dana.domain.familyaccount.interactor.RejectFamilyInvitation;
import id.dana.domain.familyaccount.interactor.RejectFamilyInvitation_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.familyaccount.contract.FamilyJoinInvitationContract;
import id.dana.familyaccount.contract.FamilyJoinInvitationPresenter;
import id.dana.familyaccount.contract.FamilyJoinInvitationPresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.joininvitation.JoinInvitationActivity;
import id.dana.familyaccount.view.joininvitation.JoinInvitationActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountJoinInvitationComponent {
    private DaggerFamilyAccountJoinInvitationComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FamilyAccountJoinInvitationModule BuiltInFictitiousFunctionClassFactory;
        public FamilyAccountTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountJoinInvitationComponentImpl implements FamilyAccountJoinInvitationComponent {
        private Provider<FamilyJoinInvitationPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<RejectFamilyInvitation> GetContactSyncConfig;
        private Provider<FamilyAccountMixpanelTracker> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<AcceptFamilyInvitation> MyBillsEntityDataFactory;
        private Provider<FamilyAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<UserRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Context> PlaceComponentResult;
        private final FamilyAccountJoinInvitationComponentImpl getAuthRequestContext;
        private Provider<GetUserInfoWithKyc> getErrorConfigVersion;
        private Provider<FamilyAccountAnalyticalTracker> initRecordTimeStamp;
        private Provider<FamilyJoinInvitationContract.View> lookAheadTest;
        private Provider<FamilyJoinInvitationContract.Presenter> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ FamilyAccountJoinInvitationComponentImpl(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(familyAccountJoinInvitationModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountJoinInvitationComponentImpl(FamilyAccountJoinInvitationModule familyAccountJoinInvitationModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationViewFactory.BuiltInFictitiousFunctionClassFactory(familyAccountJoinInvitationModule));
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = userRepositoryProvider;
            this.getErrorConfigVersion = GetUserInfoWithKyc_Factory.create(this.DatabaseTableConfigUtil, this.scheduleImpl, userRepositoryProvider);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provideFamilyAccountRepositoryProvider;
            this.MyBillsEntityDataFactory = AcceptFamilyInvitation_Factory.create(provideFamilyAccountRepositoryProvider);
            RejectFamilyInvitation_Factory create = RejectFamilyInvitation_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.GetContactSyncConfig = create;
            FamilyJoinInvitationPresenter_Factory MyBillsEntityDataFactory = FamilyJoinInvitationPresenter_Factory.MyBillsEntityDataFactory(this.lookAheadTest, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, create);
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(FamilyAccountJoinInvitationModule_ProvideFamilyAccountJoinInvitationPresenterFactory.PlaceComponentResult(familyAccountJoinInvitationModule, MyBillsEntityDataFactory));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
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
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.k());
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

        @Override // id.dana.di.component.FamilyAccountJoinInvitationComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(JoinInvitationActivity joinInvitationActivity) {
            JoinInvitationActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(joinInvitationActivity, this.moveToNextValue.get());
            joinInvitationActivity.familyAccountAnalyticalTracker = this.initRecordTimeStamp.get();
        }
    }
}
