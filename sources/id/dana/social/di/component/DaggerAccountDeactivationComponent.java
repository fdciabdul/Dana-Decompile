package id.dana.social.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.zendesk.ZendeskRepository;
import id.dana.domain.zendesk.interactor.CreateZendeskTicket;
import id.dana.myprofile.AccountDeactivationActivity;
import id.dana.myprofile.AccountDeactivationPresenter;
import id.dana.social.di.module.AccountDeactivationModule;
import id.dana.social.di.module.AccountDeactivationModule_ProvideAccountDeactivationPresenterFactory;
import id.dana.social.di.module.AccountDeactivationModule_ProvideAccountDeactivationViewFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerAccountDeactivationComponent {
    private DaggerAccountDeactivationComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public AccountDeactivationModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class AccountDeactivationComponentImpl implements AccountDeactivationComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final AccountDeactivationModule MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final AccountDeactivationComponentImpl PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<SSLPinningRepository> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<IsOfflineF2FPay> scheduleImpl;

        public /* synthetic */ AccountDeactivationComponentImpl(AccountDeactivationModule accountDeactivationModule, ApplicationComponent applicationComponent, byte b) {
            this(accountDeactivationModule, applicationComponent);
        }

        private AccountDeactivationComponentImpl(AccountDeactivationModule accountDeactivationModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.MyBillsEntityDataFactory = accountDeactivationModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.getErrorConfigVersion = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, featureConfigRepositoryProvider);
            this.scheduleImpl = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.social.di.component.AccountDeactivationComponent
        public final void getAuthRequestContext(AccountDeactivationActivity accountDeactivationActivity) {
            ((BaseActivity) accountDeactivationActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(accountDeactivationActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(accountDeactivationActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            accountDeactivationActivity.accountDeactivationPresenter = AccountDeactivationModule_ProvideAccountDeactivationPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, new AccountDeactivationPresenter(AccountDeactivationModule_ProvideAccountDeactivationViewFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), new CreateZendeskTicket((ZendeskRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.onPolygonsChanged())), new GetUserId((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.AppCompatEmojiTextHelper())), new GetPhoneNumber((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.AppCompatEmojiTextHelper()))));
        }
    }
}
