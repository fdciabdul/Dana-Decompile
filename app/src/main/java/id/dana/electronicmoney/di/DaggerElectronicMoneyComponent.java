package id.dana.electronicmoney.di;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ElectronicMoneyAnalyticModule;
import id.dana.di.modules.ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.interactor.ConfirmUpdateBalanceEmoney;
import id.dana.domain.electronicmoney.interactor.ConfirmUpdateBalanceEmoney_Factory;
import id.dana.domain.electronicmoney.interactor.GenerateEmoneyTransId;
import id.dana.domain.electronicmoney.interactor.GenerateEmoneyTransId_Factory;
import id.dana.domain.electronicmoney.interactor.GetBrizziAccessToken;
import id.dana.domain.electronicmoney.interactor.GetBrizziAccessToken_Factory;
import id.dana.domain.electronicmoney.interactor.GetEmoneyReversal;
import id.dana.domain.electronicmoney.interactor.GetEmoneyReversal_Factory;
import id.dana.domain.electronicmoney.interactor.GetTopUpCommandEmoney;
import id.dana.domain.electronicmoney.interactor.GetTopUpCommandEmoney_Factory;
import id.dana.domain.electronicmoney.interactor.InquireBalanceEmoney;
import id.dana.domain.electronicmoney.interactor.InquireBalanceEmoney_Factory;
import id.dana.electronicmoney.ElectronicMoneyManager;
import id.dana.electronicmoney.ElectronicMoneyManager_Factory;
import id.dana.electronicmoney.activity.ElectronicMoneyActivity;
import id.dana.electronicmoney.activity.ElectronicMoneyActivity_MembersInjector;
import id.dana.electronicmoney.bank.bri.BriBrizziManager;
import id.dana.electronicmoney.bank.bri.BriBrizziManager_Factory;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager_Factory;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerElectronicMoneyComponent {
    private DaggerElectronicMoneyComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ElectronicMoneyAnalyticModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ElectronicMoneyComponentImpl implements ElectronicMoneyComponent {
        private Provider<ElectronicMoneyManager> BuiltInFictitiousFunctionClassFactory;
        private Provider<InquireBalanceEmoney> DatabaseTableConfigUtil;
        private Provider<MandiriEmoneyManager> GetContactSyncConfig;
        private Provider<ConfirmUpdateBalanceEmoney> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<BriBrizziManager> MyBillsEntityDataFactory;
        private Provider<ElectronicmoneyRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ElectronicMoneyAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<Context> PlaceComponentResult;
        private final ElectronicMoneyComponentImpl getAuthRequestContext;
        private Provider<GenerateEmoneyTransId> getErrorConfigVersion;
        private Provider<GetBrizziAccessToken> lookAheadTest;
        private Provider<GetTopUpCommandEmoney> moveToNextValue;
        private Provider<GetEmoneyReversal> scheduleImpl;

        public /* synthetic */ ElectronicMoneyComponentImpl(ElectronicMoneyAnalyticModule electronicMoneyAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(electronicMoneyAnalyticModule, applicationComponent);
        }

        private ElectronicMoneyComponentImpl(ElectronicMoneyAnalyticModule electronicMoneyAnalyticModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            ElectronicmoneyRepositoryProvider electronicmoneyRepositoryProvider = new ElectronicmoneyRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = electronicmoneyRepositoryProvider;
            this.DatabaseTableConfigUtil = InquireBalanceEmoney_Factory.create(electronicmoneyRepositoryProvider);
            this.getErrorConfigVersion = GenerateEmoneyTransId_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.scheduleImpl = GetEmoneyReversal_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.moveToNextValue = GetTopUpCommandEmoney_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConfirmUpdateBalanceEmoney_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.PlaceComponentResult = contextProvider;
            Provider<ElectronicMoneyAnalyticTracker> authRequestContext = DoubleCheck.getAuthRequestContext(ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory.PlaceComponentResult(electronicMoneyAnalyticModule, contextProvider));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = authRequestContext;
            this.GetContactSyncConfig = MandiriEmoneyManager_Factory.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.getErrorConfigVersion, this.scheduleImpl, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext);
            GetBrizziAccessToken_Factory create = GetBrizziAccessToken_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.lookAheadTest = create;
            BriBrizziManager_Factory authRequestContext2 = BriBrizziManager_Factory.getAuthRequestContext(this.PlaceComponentResult, create, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.MyBillsEntityDataFactory = authRequestContext2;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(ElectronicMoneyManager_Factory.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ElectronicmoneyRepositoryProvider implements Provider<ElectronicmoneyRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ElectronicmoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ElectronicmoneyRepository get() {
                return (ElectronicmoneyRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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

        @Override // id.dana.electronicmoney.di.ElectronicMoneyComponent
        public final void PlaceComponentResult(ElectronicMoneyActivity electronicMoneyActivity) {
            ElectronicMoneyActivity_MembersInjector.MyBillsEntityDataFactory(electronicMoneyActivity, this.BuiltInFictitiousFunctionClassFactory.get());
            ElectronicMoneyActivity_MembersInjector.MyBillsEntityDataFactory(electronicMoneyActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}
