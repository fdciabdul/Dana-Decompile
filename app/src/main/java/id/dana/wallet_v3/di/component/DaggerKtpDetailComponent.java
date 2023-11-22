package id.dana.wallet_v3.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo_Factory;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp_Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.wallet_v3.di.module.KtpDetailModule;
import id.dana.wallet_v3.di.module.KtpDetailModule_ProvidePresenterFactory;
import id.dana.wallet_v3.di.module.KtpDetailModule_ProvideViewFactory;
import id.dana.wallet_v3.identity.view.KtpDetailActivity;
import id.dana.wallet_v3.identity.view.KtpDetailActivity_MembersInjector;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import id.dana.wallet_v3.presenter.KtpDetailPresenter;
import id.dana.wallet_v3.presenter.KtpDetailPresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerKtpDetailComponent {
    private DaggerKtpDetailComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        private ApplicationComponent applicationComponent;
        private KtpDetailModule ktpDetailModule;

        private Builder() {
        }

        public final Builder ktpDetailModule(KtpDetailModule ktpDetailModule) {
            this.ktpDetailModule = (KtpDetailModule) Preconditions.getAuthRequestContext(ktpDetailModule);
            return this;
        }

        public final Builder applicationComponent(ApplicationComponent applicationComponent) {
            this.applicationComponent = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            return this;
        }

        public final KtpDetailComponent build() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.ktpDetailModule, KtpDetailModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.applicationComponent, ApplicationComponent.class);
            return new KtpDetailComponentImpl(this.ktpDetailModule, this.applicationComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class KtpDetailComponentImpl implements KtpDetailComponent {
        private final ApplicationComponent applicationComponent;
        private Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
        private Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
        private Provider<GetKtpInfo> getKtpInfoProvider;
        private Provider<IsOfflineF2FPay> isOfflineF2FPayProvider;
        private final KtpDetailComponentImpl ktpDetailComponentImpl;
        private Provider<KtpDetailPresenter> ktpDetailPresenterProvider;
        private Provider<PostExecutionThread> postExecutionThreadProvider;
        private Provider<PersonalTabRepository> providePersonalTabRepositoryProvider;
        private Provider<KtpDetailContract.Presenter> providePresenterProvider;
        private Provider<KtpDetailContract.View> provideViewProvider;
        private Provider<SSLPinningRepository> sSLPinningRepositoryProvider;
        private Provider<SaveKtpConsultPopUp> saveKtpConsultPopUpProvider;
        private Provider<ThreadExecutor> threadExecutorProvider;

        private KtpDetailComponentImpl(KtpDetailModule ktpDetailModule, ApplicationComponent applicationComponent) {
            this.ktpDetailComponentImpl = this;
            this.applicationComponent = applicationComponent;
            initialize(ktpDetailModule, applicationComponent);
        }

        private void initialize(KtpDetailModule ktpDetailModule, ApplicationComponent applicationComponent) {
            this.threadExecutorProvider = new ThreadExecutorProvider(applicationComponent);
            this.sSLPinningRepositoryProvider = new SSLPinningRepositoryProvider(applicationComponent);
            this.postExecutionThreadProvider = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.featureConfigRepositoryProvider = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.threadExecutorProvider, this.postExecutionThreadProvider, featureConfigRepositoryProvider);
            this.isOfflineF2FPayProvider = create;
            this.connectionStatusReceiverProvider = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.threadExecutorProvider, this.sSLPinningRepositoryProvider, create);
            this.provideViewProvider = DoubleCheck.getAuthRequestContext(KtpDetailModule_ProvideViewFactory.create(ktpDetailModule));
            ProvidePersonalTabRepositoryProvider providePersonalTabRepositoryProvider = new ProvidePersonalTabRepositoryProvider(applicationComponent);
            this.providePersonalTabRepositoryProvider = providePersonalTabRepositoryProvider;
            this.saveKtpConsultPopUpProvider = SaveKtpConsultPopUp_Factory.create(providePersonalTabRepositoryProvider);
            GetKtpInfo_Factory create2 = GetKtpInfo_Factory.create(this.providePersonalTabRepositoryProvider);
            this.getKtpInfoProvider = create2;
            KtpDetailPresenter_Factory create3 = KtpDetailPresenter_Factory.create(this.provideViewProvider, this.saveKtpConsultPopUpProvider, create2);
            this.ktpDetailPresenterProvider = create3;
            this.providePresenterProvider = DoubleCheck.getAuthRequestContext(KtpDetailModule_ProvidePresenterFactory.create(ktpDetailModule, create3));
        }

        @Override // id.dana.wallet_v3.di.component.KtpDetailComponent
        public final void inject(KtpDetailActivity ktpDetailActivity) {
            injectKtpDetailActivity(ktpDetailActivity);
        }

        private KtpDetailActivity injectKtpDetailActivity(KtpDetailActivity ktpDetailActivity) {
            ((BaseActivity) ktpDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.applicationComponent.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
            KtpDetailActivity_MembersInjector.injectKtpDetailPresenter(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.providePresenterProvider));
            return ktpDetailActivity;
        }

        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent applicationComponent;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.applicationComponent.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent applicationComponent;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.applicationComponent.getRawPath());
            }
        }

        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent applicationComponent;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.applicationComponent.isAuto());
            }
        }

        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent applicationComponent;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.applicationComponent.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes5.dex */
        public static final class ProvidePersonalTabRepositoryProvider implements Provider<PersonalTabRepository> {
            private final ApplicationComponent applicationComponent;

            ProvidePersonalTabRepositoryProvider(ApplicationComponent applicationComponent) {
                this.applicationComponent = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final PersonalTabRepository get() {
                return (PersonalTabRepository) Preconditions.PlaceComponentResult(this.applicationComponent.RequestMoneyQrContract$View());
            }
        }
    }
}
