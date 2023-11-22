package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.TncSummaryModules;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryPresenterFactory;
import id.dana.di.modules.TncSummaryModules_ProvideTncSummaryViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode_Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.tncsummary.TncSummaryActivity;
import id.dana.tncsummary.TncSummaryActivity_MembersInjector;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.TncSummaryPresenter;
import id.dana.tncsummary.TncSummaryPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerTncSummaryComponent {
    private DaggerTncSummaryComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public TncSummaryModules MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class TncSummaryComponentImpl implements TncSummaryComponent {
        private Provider<GetSummaryTncConfigWithSpaceCode> BuiltInFictitiousFunctionClassFactory;
        private Provider<TncSummaryRepository> DatabaseTableConfigUtil;
        private final TncSummaryComponentImpl GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<TncSummaryPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> getAuthRequestContext;
        private Provider<TncSummaryContract.View> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<TncSummaryContract.Presenter> lookAheadTest;
        private Provider<RecordAgreementOnlyAgreementKey> moveToNextValue;
        private Provider<UserConsentRepository> newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ TncSummaryComponentImpl(TncSummaryModules tncSummaryModules, ApplicationComponent applicationComponent, byte b) {
            this(tncSummaryModules, applicationComponent);
        }

        private TncSummaryComponentImpl(TncSummaryModules tncSummaryModules, ApplicationComponent applicationComponent) {
            this.GetContactSyncConfig = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.initRecordTimeStamp, this.scheduleImpl, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryViewFactory.getAuthRequestContext(tncSummaryModules));
            TncSummaryRepositoryProvider tncSummaryRepositoryProvider = new TncSummaryRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = tncSummaryRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetSummaryTncConfigWithSpaceCode_Factory.create(this.initRecordTimeStamp, this.scheduleImpl, tncSummaryRepositoryProvider);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.newProxyInstance = userConsentRepositoryProvider;
            this.getAuthRequestContext = ConsultAgreementOnlyParamSpaceCodes_Factory.create(userConsentRepositoryProvider);
            RecordAgreementOnlyAgreementKey_Factory create2 = RecordAgreementOnlyAgreementKey_Factory.create(this.newProxyInstance);
            this.moveToNextValue = create2;
            TncSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = TncSummaryPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(TncSummaryModules_ProvideTncSummaryPresenterFactory.PlaceComponentResult(tncSummaryModules, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class TncSummaryRepositoryProvider implements Provider<TncSummaryRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            TncSummaryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TncSummaryRepository get() {
                return (TncSummaryRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WithdrawSavedCardChannelView());
            }
        }

        @Override // id.dana.di.component.TncSummaryComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(TncSummaryActivity tncSummaryActivity) {
            ((BaseActivity) tncSummaryActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(tncSummaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(tncSummaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            TncSummaryActivity_MembersInjector.getAuthRequestContext(tncSummaryActivity, this.lookAheadTest.get());
        }
    }
}
