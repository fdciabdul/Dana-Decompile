package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.MerchantManagementModule;
import id.dana.di.modules.MerchantManagementModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.MerchantManagementModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.interactor.CheckUnbindEligibility;
import id.dana.domain.merchantmanagement.interactor.ConsultUnbind;
import id.dana.domain.merchantmanagement.interactor.GetHomeShoppingBanner;
import id.dana.domain.merchantmanagement.interactor.GetLinkedMerchants;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.merchantmanagement.MerchantManagementPresenter;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import id.dana.merchantmanagement.view.MerchantManagementActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantManagementComponent {
    private DaggerMerchantManagementComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantManagementModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantManagementComponentImpl implements MerchantManagementComponent {
        private final MerchantManagementComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<ConnectionStatusReceiver> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private final MerchantManagementModule lookAheadTest;
        private Provider<ThreadExecutor> moveToNextValue;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ MerchantManagementComponentImpl(MerchantManagementModule merchantManagementModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantManagementModule, applicationComponent);
        }

        private MerchantManagementComponentImpl(MerchantManagementModule merchantManagementModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.getAuthRequestContext = applicationComponent;
            this.lookAheadTest = merchantManagementModule;
            this.moveToNextValue = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.moveToNextValue, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
            this.PlaceComponentResult = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.moveToNextValue, this.scheduleImpl, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.MerchantManagementComponent
        public final void MyBillsEntityDataFactory(MerchantManagementActivity merchantManagementActivity) {
            ((BaseActivity) merchantManagementActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantManagementActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(merchantManagementActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            merchantManagementActivity.presenter = MerchantManagementModule_ProvidePresenter$app_productionReleaseFactory.PlaceComponentResult(this.lookAheadTest, new MerchantManagementPresenter(MerchantManagementModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest), new GetLinkedMerchants((MerchantManagementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.O())), new GetHomeShoppingBanner((PromotionRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.a())), new ConsultUnbind((MerchantManagementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.O())), new CheckUnbindEligibility((MerchantManagementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.O()))));
            MerchantManagementActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantManagementActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PrepareContext()));
        }
    }
}
