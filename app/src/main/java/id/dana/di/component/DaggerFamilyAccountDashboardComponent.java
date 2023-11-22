package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.FamilyAccountDashboardModule;
import id.dana.di.modules.FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory;
import id.dana.di.modules.FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CreateOrderTopUpFamilyBalance;
import id.dana.domain.familyaccount.interactor.CreateOrderTopUpFamilyBalance_Factory;
import id.dana.domain.familyaccount.interactor.DashboardFamilyAccount;
import id.dana.domain.familyaccount.interactor.DashboardFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.GetFamilyAccountMaxMember;
import id.dana.domain.familyaccount.interactor.GetFamilyAccountMaxMember_Factory;
import id.dana.domain.familyaccount.interactor.GetFamilyAvailableServices;
import id.dana.domain.familyaccount.interactor.GetFamilyAvailableServices_Factory;
import id.dana.domain.familyaccount.interactor.GetMaxMemberLimit;
import id.dana.domain.familyaccount.interactor.GetMaxMemberLimit_Factory;
import id.dana.domain.familyaccount.interactor.GetTopUpUserConsult;
import id.dana.domain.familyaccount.interactor.GetTopUpUserConsult_Factory;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.contract.FamilyDashboardPresenter;
import id.dana.familyaccount.contract.FamilyDashboardPresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.dashboard.MemberDashboardActivity;
import id.dana.familyaccount.view.dashboard.MemberDashboardActivity_MembersInjector;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity_MembersInjector;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountDashboardComponent {
    private DaggerFamilyAccountDashboardComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FamilyAccountDashboardModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private FamilyAccountTrackerModule PlaceComponentResult;
        public BottomSheetOnBoardingModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final FamilyAccountDashboardComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, BottomSheetOnBoardingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, FamilyAccountDashboardModule.class);
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new FamilyAccountTrackerModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            return new FamilyAccountDashboardComponentImpl(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountDashboardComponentImpl implements FamilyAccountDashboardComponent {
        private Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetMaxMemberLimit> DatabaseTableConfigUtil;
        private Provider<FamilyAccountRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetUserId> GetContactSyncConfig;
        private Provider<DashboardFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CreateOrderTopUpFamilyBalance> MyBillsEntityDataFactory;
        private Provider<FamilyDashboardPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetFamilyAvailableServices> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetTopUpUserConsult> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FamilyAccountAnalyticalTracker> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<SaveDisplayBottomSheetOnBoarding> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<RemoveFamilyMember> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<FamilyDashboardContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<LiteAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<FamilyDashboardContract.View> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<BottomSheetOnBoardingContract.View> PrepareContext;
        private Provider<BottomSheetOnBoardingPresenter> getAuthRequestContext;
        private final FamilyAccountDashboardComponentImpl getErrorConfigVersion;
        private Provider<UserEducationRepository> getSupportButtonTintMode;
        private Provider<InviteFamilyAccount> initRecordTimeStamp;
        private Provider<PostExecutionThread> isLayoutRequested;
        private Provider<GetBottomSheetOnBoarding> lookAheadTest;
        private Provider<FamilyAccountMixpanelTracker> moveToNextValue;
        private Provider<BottomSheetOnBoardingContract.Presenter> newProxyInstance;
        private Provider<ThreadExecutor> readMicros;
        private Provider<GetFamilyAccountMaxMember> scheduleImpl;
        private Provider<UserRepository> whenAvailable;

        /* synthetic */ FamilyAccountDashboardComponentImpl(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, FamilyAccountDashboardModule familyAccountDashboardModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(bottomSheetOnBoardingModule, familyAccountDashboardModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountDashboardComponentImpl(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, FamilyAccountDashboardModule familyAccountDashboardModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.readMicros = new ThreadExecutorProvider(applicationComponent);
            this.isLayoutRequested = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = userEducationRepositoryProvider;
            this.lookAheadTest = GetBottomSheetOnBoarding_Factory.create(this.readMicros, this.isLayoutRequested, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create = SaveDisplayBottomSheetOnBoarding_Factory.create(this.readMicros, this.isLayoutRequested, this.getSupportButtonTintMode);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = create;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.PrepareContext, this.lookAheadTest, create);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleCheck.getAuthRequestContext(FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(familyAccountDashboardModule));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = provideFamilyAccountRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DashboardFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetFamilyAvailableServices_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = liteAccountRepositoryProvider;
            this.GetContactSyncConfig = GetUserId_Factory.create(this.readMicros, this.isLayoutRequested, liteAccountRepositoryProvider);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.whenAvailable = userRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetTopUpUserConsult_Factory.create(this.FragmentBottomSheetPaymentSettingBinding, userRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = RemoveFamilyMember_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.DatabaseTableConfigUtil = GetMaxMemberLimit_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.scheduleImpl = GetFamilyAccountMaxMember_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.initRecordTimeStamp = InviteFamilyAccount_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            this.MyBillsEntityDataFactory = CreateOrderTopUpFamilyBalance_Factory.create(this.FragmentBottomSheetPaymentSettingBinding);
            DeviceInformationProviderProvider deviceInformationProviderProvider = new DeviceInformationProviderProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = deviceInformationProviderProvider;
            FamilyDashboardPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = FamilyDashboardPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil, this.scheduleImpl, this.initRecordTimeStamp, this.MyBillsEntityDataFactory, deviceInformationProviderProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DoubleCheck.getAuthRequestContext(FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory.MyBillsEntityDataFactory(familyAccountDashboardModule, BuiltInFictitiousFunctionClassFactory2));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

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

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent getAuthRequestContext;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent getAuthRequestContext;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue());
            }
        }

        @Override // id.dana.di.component.FamilyAccountDashboardComponent
        public final void getAuthRequestContext(MemberDashboardActivity memberDashboardActivity) {
            MemberDashboardActivity_MembersInjector.MyBillsEntityDataFactory(memberDashboardActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
        }

        @Override // id.dana.di.component.FamilyAccountDashboardComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(OrganizerDashboardActivity organizerDashboardActivity) {
            OrganizerDashboardActivity_MembersInjector.getAuthRequestContext(organizerDashboardActivity, this.newProxyInstance.get());
            OrganizerDashboardActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(organizerDashboardActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
            organizerDashboardActivity.familyAccountAnalyticalTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda3.get();
        }
    }
}
