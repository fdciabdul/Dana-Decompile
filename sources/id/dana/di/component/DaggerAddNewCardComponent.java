package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.contract.payasset.AddNewCardPresenter;
import id.dana.contract.payasset.AddNewCardPresenter_Factory;
import id.dana.contract.payqr.AddNewCardModule;
import id.dana.contract.payqr.AddNewCardModule_ProvidePresenterFactory;
import id.dana.contract.payqr.AddNewCardModule_ProvideViewFactory;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.OfflinePayModule_ProvidePresenterFactory;
import id.dana.contract.payqr.OfflinePayModule_ProvideViewFactory;
import id.dana.contract.payqr.OfflinePayPresenter;
import id.dana.contract.payqr.OfflinePayPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.pay.screen.AddNewCardFragment;
import id.dana.pay.screen.AddNewCardFragment_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerAddNewCardComponent {
    private DaggerAddNewCardComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OfflinePayModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;
        public AddNewCardModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class AddNewCardComponentImpl implements AddNewCardComponent {
        private final AddNewCardComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<OfflinePayContract.View> GetContactSyncConfig;
        private Provider<AddNewCardPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<OfflinePayContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CheckEnableExpressPayFeature> PlaceComponentResult;
        private Provider<IsOfflineF2FPay> getAuthRequestContext;
        private Provider<AddNewCardContract.Presenter> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<AddNewCardContract.View> moveToNextValue;
        private Provider<OfflinePayPresenter> scheduleImpl;

        public /* synthetic */ AddNewCardComponentImpl(AddNewCardModule addNewCardModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent, byte b) {
            this(addNewCardModule, offlinePayModule, applicationComponent);
        }

        private AddNewCardComponentImpl(AddNewCardModule addNewCardModule, OfflinePayModule offlinePayModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(AddNewCardModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(addNewCardModule));
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            CheckEnableExpressPayFeature_Factory create = CheckEnableExpressPayFeature_Factory.create(this.initRecordTimeStamp, this.lookAheadTest, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            Provider<AddNewCardPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(AddNewCardPresenter_Factory.PlaceComponentResult(this.moveToNextValue, create));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(AddNewCardModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(addNewCardModule, authRequestContext));
            this.getAuthRequestContext = IsOfflineF2FPay_Factory.create(this.initRecordTimeStamp, this.lookAheadTest, this.MyBillsEntityDataFactory);
            Provider<OfflinePayContract.View> authRequestContext2 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvideViewFactory.getAuthRequestContext(offlinePayModule));
            this.GetContactSyncConfig = authRequestContext2;
            OfflinePayPresenter_Factory authRequestContext3 = OfflinePayPresenter_Factory.getAuthRequestContext(this.getAuthRequestContext, authRequestContext2);
            this.scheduleImpl = authRequestContext3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(OfflinePayModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(offlinePayModule, authRequestContext3));
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

        @Override // id.dana.di.component.AddNewCardComponent
        public final void PlaceComponentResult(AddNewCardFragment addNewCardFragment) {
            AddNewCardFragment_MembersInjector.getAuthRequestContext(addNewCardFragment, this.getErrorConfigVersion.get());
            AddNewCardFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(addNewCardFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
        }
    }
}
