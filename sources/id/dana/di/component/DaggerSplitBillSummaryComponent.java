package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.SplitBillDetailModule;
import id.dana.di.modules.SplitBillDetailModule_ProvidePresenterFactory;
import id.dana.di.modules.SplitBillDetailModule_ProvideViewFactory;
import id.dana.di.modules.SplitBillModule;
import id.dana.di.modules.SplitBillModule_ProvideSplitBillPresenterFactory;
import id.dana.di.modules.SplitBillModule_ProvideSplitBillViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.splitbill.interactor.ClosePayers;
import id.dana.domain.splitbill.interactor.GetSplitBillDetail;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillDetailPresenter;
import id.dana.splitbill.SplitBillPresenter;
import id.dana.splitbill.SplitBillPresenter_Factory;
import id.dana.splitbill.mapper.SplitBillDetailMapper;
import id.dana.splitbill.tracker.SplitBillMixpanelTracker;
import id.dana.splitbill.view.SplitBillSummaryActivity;
import id.dana.splitbill.view.SplitBillSummaryActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSplitBillSummaryComponent {
    private DaggerSplitBillSummaryComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public SplitBillDetailModule MyBillsEntityDataFactory;
        public SplitBillModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillSummaryComponentImpl implements SplitBillSummaryComponent {
        private Provider<AccountRepository> BuiltInFictitiousFunctionClassFactory;
        private final SplitBillDetailModule DatabaseTableConfigUtil;
        private Provider<SplitBillPresenter> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetAccount> MyBillsEntityDataFactory;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final SplitBillSummaryComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<SplitBillContract.View> lookAheadTest;
        private Provider<SSLPinningRepository> moveToNextValue;
        private Provider<SplitBillContract.Presenter> scheduleImpl;

        public /* synthetic */ SplitBillSummaryComponentImpl(SplitBillModule splitBillModule, SplitBillDetailModule splitBillDetailModule, ApplicationComponent applicationComponent, byte b) {
            this(splitBillModule, splitBillDetailModule, applicationComponent);
        }

        private SplitBillSummaryComponentImpl(SplitBillModule splitBillModule, SplitBillDetailModule splitBillDetailModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.DatabaseTableConfigUtil = splitBillDetailModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.moveToNextValue, create);
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(SplitBillModule_ProvideSplitBillViewFactory.getAuthRequestContext(splitBillModule));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = accountRepositoryProvider;
            GetAccount_Factory create2 = GetAccount_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, accountRepositoryProvider);
            this.MyBillsEntityDataFactory = create2;
            SplitBillPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = SplitBillPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, create2);
            this.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(SplitBillModule_ProvideSplitBillPresenterFactory.PlaceComponentResult(splitBillModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.SplitBillSummaryComponent
        public final void BuiltInFictitiousFunctionClassFactory(SplitBillSummaryActivity splitBillSummaryActivity) {
            ((BaseActivity) splitBillSummaryActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(splitBillSummaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(splitBillSummaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            splitBillSummaryActivity.splitBillPresenter = this.scheduleImpl.get();
            SplitBillSummaryActivity_MembersInjector.PlaceComponentResult(splitBillSummaryActivity, SplitBillDetailModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil, new SplitBillDetailPresenter(SplitBillDetailModule_ProvideViewFactory.PlaceComponentResult(this.DatabaseTableConfigUtil), new GetSplitBillDetail((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SplitBillRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ConcurrentKt())), new SplitBillDetailMapper(), new ClosePayers((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SplitBillRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ConcurrentKt())))));
            splitBillSummaryActivity.splitBillAnalyticTracker = new SplitBillMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()));
        }
    }
}
