package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.SavingTopUpHistoryModule;
import id.dana.di.modules.SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory;
import id.dana.di.modules.SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.domain.saving.interactor.GetSavingDetail_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.savings.activity.SavingHistoryActivity;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import id.dana.savings.presenter.SavingTopUpHistoryPresenter;
import id.dana.savings.presenter.SavingTopUpHistoryPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerSavingTopUpHistoryComponent {
    private DaggerSavingTopUpHistoryComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public SavingTopUpHistoryModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SavingTopUpHistoryComponentImpl implements SavingTopUpHistoryComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private final SavingTopUpHistoryComponentImpl DatabaseTableConfigUtil;
        private Provider<SavingRepository> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SavingCategoryRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SavingTopUpHistoryPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<GetSavingDetail> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<SSLPinningRepository> lookAheadTest;
        private Provider<SavingTopUpHistoryContract.View> moveToNextValue;
        private Provider<SavingTopUpHistoryContract.Presenter> scheduleImpl;

        public /* synthetic */ SavingTopUpHistoryComponentImpl(SavingTopUpHistoryModule savingTopUpHistoryModule, ApplicationComponent applicationComponent, byte b) {
            this(savingTopUpHistoryModule, applicationComponent);
        }

        private SavingTopUpHistoryComponentImpl(SavingTopUpHistoryModule savingTopUpHistoryModule, ApplicationComponent applicationComponent) {
            this.DatabaseTableConfigUtil = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.initRecordTimeStamp, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.initRecordTimeStamp, this.lookAheadTest, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContextProvider(applicationComponent);
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(SavingTopUpHistoryModule_ProvideSavingTopUpHistoryViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(savingTopUpHistoryModule));
            this.GetContactSyncConfig = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = savingCategoryRepositoryProvider;
            GetSavingDetail_Factory create2 = GetSavingDetail_Factory.create(this.GetContactSyncConfig, savingCategoryRepositoryProvider);
            this.getAuthRequestContext = create2;
            Provider<SavingTopUpHistoryPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SavingTopUpHistoryPresenter_Factory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory.PlaceComponentResult(savingTopUpHistoryModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
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
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.useDaemonThreadFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getTextEndPadding());
            }
        }

        @Override // id.dana.di.component.SavingTopUpHistoryComponent
        public final void PlaceComponentResult(SavingHistoryActivity savingHistoryActivity) {
            ((BaseActivity) savingHistoryActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(savingHistoryActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(savingHistoryActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            savingHistoryActivity.savingTopUpHistoryPresenter = this.scheduleImpl.get();
        }
    }
}
