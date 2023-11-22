package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.modules.LazadaModule;
import id.dana.di.modules.LazadaModule_ProvidePresenterFactory;
import id.dana.di.modules.LazadaModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.domain.lazada.interactor.GetLazadaClickedAgree;
import id.dana.domain.lazada.interactor.GetLazadaRegistrationUrl;
import id.dana.domain.lazada.interactor.SaveLazadaClickedAgree;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.lazada.LazadaGuideActivity;
import id.dana.lazada.LazadaGuideActivity_MembersInjector;
import id.dana.lazada.LazadaGuidePresenter;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerLazadaComponent {
    private DaggerLazadaComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public LazadaModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class LazadaComponentImpl implements LazadaComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final LazadaComponentImpl MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<IsOfflineF2FPay> getAuthRequestContext;
        private Provider<ThreadExecutor> getErrorConfigVersion;
        private final LazadaModule lookAheadTest;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ LazadaComponentImpl(LazadaModule lazadaModule, ApplicationComponent applicationComponent, byte b) {
            this(lazadaModule, applicationComponent);
        }

        private LazadaComponentImpl(LazadaModule lazadaModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.PlaceComponentResult = applicationComponent;
            this.lookAheadTest = lazadaModule;
            this.getErrorConfigVersion = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, featureConfigRepositoryProvider);
            this.getAuthRequestContext = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.getErrorConfigVersion, this.scheduleImpl, create);
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
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
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

        @Override // id.dana.di.component.LazadaComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(LazadaGuideActivity lazadaGuideActivity) {
            ((BaseActivity) lazadaGuideActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(lazadaGuideActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(lazadaGuideActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            LazadaGuideActivity_MembersInjector.getAuthRequestContext(lazadaGuideActivity, LazadaModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, new LazadaGuidePresenter(LazadaModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest), new GetLazadaClickedAgree((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (LazadaRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.H())), new SaveLazadaClickedAgree((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (LazadaRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.H())), new GetLazadaRegistrationUrl((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (LazadaRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.H())), new GetAuthCode((OauthRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SummaryVoucherView$$ExternalSyntheticLambda1()), new GetEmptyUserInfo((UserConsentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.WithdrawSavedCardChannelView()))), (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7()))));
        }
    }
}
