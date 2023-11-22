package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.FamilyAccountInvitationModule;
import id.dana.di.modules.FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory;
import id.dana.di.modules.FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.GetQuestionnaireData;
import id.dana.domain.familyaccount.interactor.GetQuestionnaireData_Factory;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.RecordAgreementFamilyAccount;
import id.dana.domain.familyaccount.interactor.RecordAgreementFamilyAccount_Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.ConsultAgreement_Factory;
import id.dana.familyaccount.contract.FamilyInvitationContract;
import id.dana.familyaccount.contract.FamilyInvitationPresenter;
import id.dana.familyaccount.contract.FamilyInvitationPresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.invite.FamilyInviteMemberActivity;
import id.dana.familyaccount.view.invite.FamilyInviteMemberActivity_MembersInjector;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountInvitationComponent {
    private DaggerFamilyAccountInvitationComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private FamilyAccountTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public FamilyAccountInvitationModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final FamilyAccountInvitationComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, FamilyAccountInvitationModule.class);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new FamilyAccountTrackerModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new FamilyAccountInvitationComponentImpl(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountInvitationComponentImpl implements FamilyAccountInvitationComponent {
        private Provider<FamilyInvitationPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<RecordAgreementFamilyAccount> DatabaseTableConfigUtil;
        private Provider<FamilyAccountAnalyticalTracker> GetContactSyncConfig;
        private Provider<FamilyAccountMixpanelTracker> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<InviteFamilyAccount> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<UserConsentRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ConsultAgreement> PlaceComponentResult;
        private final FamilyAccountInvitationComponentImpl getAuthRequestContext;
        private Provider<GetQuestionnaireData> getErrorConfigVersion;
        private Provider<FamilyInvitationContract.Presenter> lookAheadTest;
        private Provider<FamilyAccountRepository> moveToNextValue;
        private Provider<FamilyInvitationContract.View> scheduleImpl;

        /* synthetic */ FamilyAccountInvitationComponentImpl(FamilyAccountInvitationModule familyAccountInvitationModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(familyAccountInvitationModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountInvitationComponentImpl(FamilyAccountInvitationModule familyAccountInvitationModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(FamilyAccountInvitationModule_ProvideFamilyAccountViewFactory.BuiltInFictitiousFunctionClassFactory(familyAccountInvitationModule));
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.moveToNextValue = provideFamilyAccountRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = InviteFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            this.getErrorConfigVersion = GetQuestionnaireData_Factory.create(this.moveToNextValue);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = userConsentRepositoryProvider;
            this.PlaceComponentResult = ConsultAgreement_Factory.create(userConsentRepositoryProvider);
            RecordAgreementFamilyAccount_Factory create = RecordAgreementFamilyAccount_Factory.create(this.moveToNextValue);
            this.DatabaseTableConfigUtil = create;
            FamilyInvitationPresenter_Factory PlaceComponentResult = FamilyInvitationPresenter_Factory.PlaceComponentResult(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, this.PlaceComponentResult, create);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(FamilyAccountInvitationModule_ProvideFamilyAccountPresenterFactory.getAuthRequestContext(familyAccountInvitationModule, PlaceComponentResult));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.k());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        @Override // id.dana.di.component.FamilyAccountInvitationComponent
        public final void PlaceComponentResult(FamilyInviteMemberActivity familyInviteMemberActivity) {
            FamilyInviteMemberActivity_MembersInjector.getAuthRequestContext(familyInviteMemberActivity, this.lookAheadTest.get());
        }

        @Override // id.dana.di.component.FamilyAccountInvitationComponent
        public final void getAuthRequestContext(FamilyTncConsentActivity familyTncConsentActivity) {
            FamilyTncConsentActivity_MembersInjector.PlaceComponentResult(familyTncConsentActivity, this.lookAheadTest.get());
            FamilyTncConsentActivity_MembersInjector.getAuthRequestContext(familyTncConsentActivity, this.GetContactSyncConfig.get());
        }
    }
}
