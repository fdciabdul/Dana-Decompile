package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.FamilyAccountOrganizerSummaryModule;
import id.dana.di.modules.FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory;
import id.dana.di.modules.FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.ApproveSendMoneyFamilyAccount;
import id.dana.domain.familyaccount.interactor.ApproveSendMoneyFamilyAccount_Factory;
import id.dana.domain.familyaccount.interactor.GetOrganizerSummary;
import id.dana.domain.familyaccount.interactor.GetOrganizerSummary_Factory;
import id.dana.domain.familyaccount.interactor.RejectSendMoneyFamilyAccount;
import id.dana.domain.familyaccount.interactor.RejectSendMoneyFamilyAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckCashierFeature;
import id.dana.domain.featureconfig.interactor.CheckCashierFeature_Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.domain.sendmoney.interactor.GetBankFreeTransferCheck;
import id.dana.domain.sendmoney.interactor.GetBankFreeTransferCheck_Factory;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import id.dana.familyaccount.contract.OrganizerSummaryPresenter;
import id.dana.familyaccount.contract.OrganizerSummaryPresenter_Factory;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule_ProvideTrackerFactory;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker_Factory;
import id.dana.familyaccount.view.summary.OrganizerSummaryActivity;
import id.dana.familyaccount.view.summary.OrganizerSummaryActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerFamilyAccountOrganizerSummaryComponent {
    private DaggerFamilyAccountOrganizerSummaryComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FamilyAccountOrganizerSummaryModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;
        public FamilyAccountTrackerModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class FamilyAccountOrganizerSummaryComponentImpl implements FamilyAccountOrganizerSummaryComponent {
        private Provider<FamilyAccountMixpanelTracker> BuiltInFictitiousFunctionClassFactory;
        private Provider<OrganizerSummaryContract.Presenter> DatabaseTableConfigUtil;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ApproveSendMoneyFamilyAccount> MyBillsEntityDataFactory;
        private final FamilyAccountOrganizerSummaryComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PromotionRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<FamilyAccountRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<RejectSendMoneyFamilyAccount> PrepareContext;
        private Provider<CheckCashierFeature> getAuthRequestContext;
        private Provider<GetBankFreeTransferCheck> getErrorConfigVersion;
        private Provider<OrganizerSummaryContract.View> initRecordTimeStamp;
        private Provider<GetOrganizerSummary> lookAheadTest;
        private Provider<OrganizerSummaryPresenter> moveToNextValue;
        private Provider<FamilyAccountAnalyticalTracker> newProxyInstance;
        private Provider<FeatureConfigRepository> scheduleImpl;

        public /* synthetic */ FamilyAccountOrganizerSummaryComponentImpl(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(familyAccountOrganizerSummaryModule, familyAccountTrackerModule, applicationComponent);
        }

        private FamilyAccountOrganizerSummaryComponentImpl(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule, FamilyAccountTrackerModule familyAccountTrackerModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory.BuiltInFictitiousFunctionClassFactory(familyAccountOrganizerSummaryModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.scheduleImpl = featureConfigRepositoryProvider;
            this.getAuthRequestContext = CheckCashierFeature_Factory.create(featureConfigRepositoryProvider);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provideFamilyAccountRepositoryProvider;
            this.lookAheadTest = GetOrganizerSummary_Factory.create(provideFamilyAccountRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            PromotionRepositoryProvider promotionRepositoryProvider = new PromotionRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = promotionRepositoryProvider;
            this.getErrorConfigVersion = GetBankFreeTransferCheck_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.GetContactSyncConfig, promotionRepositoryProvider);
            this.PrepareContext = RejectSendMoneyFamilyAccount_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            ApproveSendMoneyFamilyAccount_Factory create = ApproveSendMoneyFamilyAccount_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.MyBillsEntityDataFactory = create;
            OrganizerSummaryPresenter_Factory MyBillsEntityDataFactory = OrganizerSummaryPresenter_Factory.MyBillsEntityDataFactory(this.initRecordTimeStamp, this.getAuthRequestContext, this.lookAheadTest, this.getErrorConfigVersion, this.PrepareContext, create);
            this.moveToNextValue = MyBillsEntityDataFactory;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory.getAuthRequestContext(familyAccountOrganizerSummaryModule, MyBillsEntityDataFactory));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            FamilyAccountMixpanelTracker_Factory KClassImpl$Data$declaredNonStaticMembers$2 = FamilyAccountMixpanelTracker_Factory.KClassImpl$Data$declaredNonStaticMembers$2(contextProvider);
            this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(FamilyAccountTrackerModule_ProvideTrackerFactory.PlaceComponentResult(familyAccountTrackerModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
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
        public static final class PromotionRepositoryProvider implements Provider<PromotionRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromotionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromotionRepository get() {
                return (PromotionRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.a());
            }
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

        @Override // id.dana.di.component.FamilyAccountOrganizerSummaryComponent
        public final void BuiltInFictitiousFunctionClassFactory(OrganizerSummaryActivity organizerSummaryActivity) {
            OrganizerSummaryActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(organizerSummaryActivity, this.DatabaseTableConfigUtil.get());
            OrganizerSummaryActivity_MembersInjector.MyBillsEntityDataFactory(organizerSummaryActivity, this.newProxyInstance.get());
            OrganizerSummaryActivity_MembersInjector.PlaceComponentResult(organizerSummaryActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
        }
    }
}
