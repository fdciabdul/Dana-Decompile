package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideSplitBillPresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideSplitBillViewFactory;
import id.dana.contract.deeplink.generation.SplitBillQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.SplitBillQrDeepLinkPresenter_Factory;
import id.dana.di.modules.SplitBillModule;
import id.dana.di.modules.SplitBillModule_ProvideSplitBillPresenterFactory;
import id.dana.di.modules.SplitBillModule_ProvideSplitBillViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.account.interactor.GetAccount_Factory;
import id.dana.domain.deeplink.interactor.GenerateSplitBillQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateSplitBillQrDeepLink_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillPresenter;
import id.dana.splitbill.SplitBillPresenter_Factory;
import id.dana.splitbill.mapper.RecipientModelMapper_Factory;
import id.dana.splitbill.mapper.SplitBillPayerListMapper;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;
import id.dana.splitbill.mapper.SplitBillPayerToRecipientModelMapper_Factory;
import id.dana.splitbill.tracker.SplitBillMixpanelTracker;
import id.dana.splitbill.view.SplitBillActivity;
import id.dana.splitbill.view.SplitBillActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSplitBillComponent {
    private DaggerSplitBillComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SplitBillModule KClassImpl$Data$declaredNonStaticMembers$2;
        public GenerateDeepLinkModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillComponentImpl implements SplitBillComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<SSLPinningRepository> DatabaseTableConfigUtil;
        private Provider<SplitBillContract.View> GetContactSyncConfig;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<GenerateSplitBillQrDeepLink> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GenerateDeepLinkContract.SplitBillPresenter> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GenerateDeepLinkContract.SplitBillView> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<SplitBillPresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<AccountRepository> PlaceComponentResult;
        private Provider<SplitBillQrDeepLinkPresenter> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<IsOfflineF2FPay> getErrorConfigVersion;
        private Provider<SplitBillContract.Presenter> initRecordTimeStamp;
        private Provider<ThreadExecutor> isLayoutRequested;
        private Provider<GetAccount> lookAheadTest;
        private Provider<GenerateLinkRepository> moveToNextValue;
        private final SplitBillComponentImpl newProxyInstance;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ SplitBillComponentImpl(GenerateDeepLinkModule generateDeepLinkModule, SplitBillModule splitBillModule, ApplicationComponent applicationComponent, byte b) {
            this(generateDeepLinkModule, splitBillModule, applicationComponent);
        }

        private SplitBillComponentImpl(GenerateDeepLinkModule generateDeepLinkModule, SplitBillModule splitBillModule, ApplicationComponent applicationComponent) {
            this.newProxyInstance = this;
            this.getAuthRequestContext = applicationComponent;
            this.isLayoutRequested = new ThreadExecutorProvider(applicationComponent);
            this.DatabaseTableConfigUtil = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.isLayoutRequested, this.scheduleImpl, featureConfigRepositoryProvider);
            this.getErrorConfigVersion = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.isLayoutRequested, this.DatabaseTableConfigUtil, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContextProvider(applicationComponent);
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.moveToNextValue = generateLinkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GenerateSplitBillQrDeepLink_Factory.create(this.isLayoutRequested, this.scheduleImpl, generateLinkRepositoryProvider);
            Provider<GenerateDeepLinkContract.SplitBillView> authRequestContext = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideSplitBillViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
            Provider<SplitBillQrDeepLinkPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(SplitBillQrDeepLinkPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, authRequestContext));
            this.PrepareContext = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideSplitBillPresenterFactory.getAuthRequestContext(generateDeepLinkModule, authRequestContext2));
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(SplitBillModule_ProvideSplitBillViewFactory.getAuthRequestContext(splitBillModule));
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = accountRepositoryProvider;
            GetAccount_Factory create2 = GetAccount_Factory.create(this.isLayoutRequested, this.scheduleImpl, accountRepositoryProvider);
            this.lookAheadTest = create2;
            SplitBillPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = SplitBillPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.initRecordTimeStamp = DoubleCheck.getAuthRequestContext(SplitBillModule_ProvideSplitBillPresenterFactory.PlaceComponentResult(splitBillModule, KClassImpl$Data$declaredNonStaticMembers$2));
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.SplitBillComponent
        public final void PlaceComponentResult(SplitBillActivity splitBillActivity) {
            ((BaseActivity) splitBillActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(splitBillActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(splitBillActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            SplitBillActivity_MembersInjector.MyBillsEntityDataFactory(splitBillActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            SplitBillActivity_MembersInjector.PlaceComponentResult(splitBillActivity, this.initRecordTimeStamp.get());
            SplitBillActivity_MembersInjector.PlaceComponentResult(splitBillActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
            SplitBillActivity_MembersInjector.PlaceComponentResult(splitBillActivity, RecipientModelMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            splitBillActivity.splitBillPayerMapper = new SplitBillPayerListMapper();
            SplitBillActivity_MembersInjector.MyBillsEntityDataFactory(splitBillActivity, SplitBillPayerToRecipientModelMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            SplitBillActivity_MembersInjector.MyBillsEntityDataFactory(splitBillActivity, new SplitBillPayerToPayerModelMapper());
            SplitBillActivity_MembersInjector.getAuthRequestContext(splitBillActivity, new SplitBillMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue())));
        }
    }
}
