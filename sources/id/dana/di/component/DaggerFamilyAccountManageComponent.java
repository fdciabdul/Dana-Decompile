package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.FamilyAccountManageModule;
import id.dana.di.modules.FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory;
import id.dana.di.modules.FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember_Factory;
import id.dana.domain.familyaccount.interactor.SetLimitAndServicesFamilyAccount;
import id.dana.domain.familyaccount.interactor.SetLimitAndServicesFamilyAccount_Factory;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.contract.FamilyManagePresenter;
import id.dana.familyaccount.contract.FamilyManagePresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.managefamily.ManageMemberActivity;
import id.dana.familyaccount.view.managefamily.ManageMemberActivity_MembersInjector;
import id.dana.familyaccount.view.managefamily.ManageOrganizerActivity;
import id.dana.familyaccount.view.managefamily.ManageOrganizerActivity_MembersInjector;
import id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity;
import id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountManageComponent {
    private DaggerFamilyAccountManageComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private FamilyAccountTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FamilyAccountManageModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final FamilyAccountManageComponent PlaceComponentResult() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, FamilyAccountManageModule.class);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new FamilyAccountTrackerModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new FamilyAccountManageComponentImpl(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountManageComponentImpl implements FamilyAccountManageComponent {
        private Provider<FamilyManageContract.Presenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<FamilyAccountMixpanelTracker> KClassImpl$Data$declaredNonStaticMembers$2;
        private final FamilyAccountManageComponentImpl MyBillsEntityDataFactory;
        private Provider<RemoveFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SetLimitAndServicesFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Context> PlaceComponentResult;
        private Provider<FamilyManagePresenter> getAuthRequestContext;
        private Provider<RemoveFamilyMember> getErrorConfigVersion;
        private Provider<FamilyManageContract.View> lookAheadTest;
        private Provider<FamilyAccountAnalyticalTracker> moveToNextValue;
        private Provider<FamilyAccountRepository> scheduleImpl;

        /* synthetic */ FamilyAccountManageComponentImpl(FamilyAccountManageModule familyAccountManageModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(familyAccountManageModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountManageComponentImpl(FamilyAccountManageModule familyAccountManageModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory.getAuthRequestContext(familyAccountManageModule));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.scheduleImpl = provideFamilyAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = SetLimitAndServicesFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RemoveFamilyAccount_Factory.create(this.scheduleImpl);
            RemoveFamilyMember_Factory create = RemoveFamilyMember_Factory.create(this.scheduleImpl);
            this.getErrorConfigVersion = create;
            FamilyManagePresenter_Factory BuiltInFictitiousFunctionClassFactory = FamilyManagePresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory.BuiltInFictitiousFunctionClassFactory(familyAccountManageModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent PlaceComponentResult;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.k());
            }
        }

        @Override // id.dana.di.component.FamilyAccountManageComponent
        public final void BuiltInFictitiousFunctionClassFactory(ManageMemberActivity manageMemberActivity) {
            ManageMemberActivity_MembersInjector.PlaceComponentResult(manageMemberActivity, this.moveToNextValue.get());
            ManageMemberActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(manageMemberActivity, this.BuiltInFictitiousFunctionClassFactory.get());
        }

        @Override // id.dana.di.component.FamilyAccountManageComponent
        public final void MyBillsEntityDataFactory(ManageOrganizerActivity manageOrganizerActivity) {
            ManageOrganizerActivity_MembersInjector.MyBillsEntityDataFactory(manageOrganizerActivity, this.BuiltInFictitiousFunctionClassFactory.get());
            ManageOrganizerActivity_MembersInjector.PlaceComponentResult(manageOrganizerActivity, this.moveToNextValue.get());
        }

        @Override // id.dana.di.component.FamilyAccountManageComponent
        public final void MyBillsEntityDataFactory(ManageMemberLimitActivity manageMemberLimitActivity) {
            ManageMemberLimitActivity_MembersInjector.getAuthRequestContext(manageMemberLimitActivity, this.BuiltInFictitiousFunctionClassFactory.get());
        }
    }
}
