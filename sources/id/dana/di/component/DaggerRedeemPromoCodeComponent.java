package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.RedeemPromoCodeModule;
import id.dana.di.modules.RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.promocode.interactor.ApplyPromoCode;
import id.dana.domain.promocode.interactor.ApplyPromoCode_Factory;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.promocode.RedeemPromoCodeContract;
import id.dana.promocode.RedeemPromoCodePresenter;
import id.dana.promocode.RedeemPromoCodePresenter_Factory;
import id.dana.promocode.views.RedeemPromoCodeActivity;
import id.dana.promocode.views.RedeemPromoCodeActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerRedeemPromoCodeComponent {
    private DaggerRedeemPromoCodeComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public RedeemPromoCodeModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class RedeemPromoCodeComponentImpl implements RedeemPromoCodeComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<SSLPinningRepository> GetContactSyncConfig;
        private Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<PromoCodeRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<RedeemPromoCodePresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ApplyPromoCode> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<RedeemPromoCodeContract.View> getErrorConfigVersion;
        private Provider<PostExecutionThread> lookAheadTest;
        private Provider<RedeemPromoCodeContract.Presenter> moveToNextValue;
        private final RedeemPromoCodeComponentImpl scheduleImpl;

        public /* synthetic */ RedeemPromoCodeComponentImpl(RedeemPromoCodeModule redeemPromoCodeModule, ApplicationComponent applicationComponent, byte b) {
            this(redeemPromoCodeModule, applicationComponent);
        }

        private RedeemPromoCodeComponentImpl(RedeemPromoCodeModule redeemPromoCodeModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new SSLPinningRepositoryProvider(applicationComponent);
            this.lookAheadTest = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.DatabaseTableConfigUtil, this.lookAheadTest, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.DatabaseTableConfigUtil, this.GetContactSyncConfig, create);
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(RedeemPromoCodeModule_ProvideView$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(redeemPromoCodeModule));
            PromoCodeRepositoryProvider promoCodeRepositoryProvider = new PromoCodeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoCodeRepositoryProvider;
            ApplyPromoCode_Factory create2 = ApplyPromoCode_Factory.create(promoCodeRepositoryProvider);
            this.PlaceComponentResult = create2;
            RedeemPromoCodePresenter_Factory PlaceComponentResult = RedeemPromoCodePresenter_Factory.PlaceComponentResult(this.getErrorConfigVersion, create2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = PlaceComponentResult;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(RedeemPromoCodeModule_ProvidePresenter$app_productionReleaseFactory.PlaceComponentResult(redeemPromoCodeModule, PlaceComponentResult));
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
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PromoCodeRepositoryProvider implements Provider<PromoCodeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PromoCodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoCodeRepository get() {
                return (PromoCodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.b());
            }
        }

        @Override // id.dana.di.component.RedeemPromoCodeComponent
        public final void MyBillsEntityDataFactory(RedeemPromoCodeActivity redeemPromoCodeActivity) {
            ((BaseActivity) redeemPromoCodeActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(redeemPromoCodeActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(redeemPromoCodeActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            RedeemPromoCodeActivity_MembersInjector.MyBillsEntityDataFactory(redeemPromoCodeActivity, this.moveToNextValue.get());
            RedeemPromoCodeActivity_MembersInjector.getAuthRequestContext(redeemPromoCodeActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext()));
        }
    }
}
