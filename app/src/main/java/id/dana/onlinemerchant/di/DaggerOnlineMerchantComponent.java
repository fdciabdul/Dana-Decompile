package id.dana.onlinemerchant.di;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.onlinemerchant.OnlineMerchantPresenter;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.di.modules.OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.onlinemerchant.OnlineMerchantActivity;
import id.dana.onlinemerchant.OnlineMerchantActivity_MembersInjector;
import id.dana.onlinemerchant.di.module.OnlineMerchantModule;
import id.dana.onlinemerchant.di.module.OnlineMerchantModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.onlinemerchant.di.module.OnlineMerchantModule_ProvideView$app_productionReleaseFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerOnlineMerchantComponent {
    private DaggerOnlineMerchantComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public OnlineMerchantModule BuiltInFictitiousFunctionClassFactory;
        public OnlineMerchantAnalyticModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class OnlineMerchantComponentImpl implements OnlineMerchantComponent {
        private Provider<IsOfflineF2FPay> BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final OnlineMerchantAnalyticModule MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<SSLPinningRepository> lookAheadTest;
        private final OnlineMerchantModule moveToNextValue;
        private final OnlineMerchantComponentImpl scheduleImpl;

        public /* synthetic */ OnlineMerchantComponentImpl(OnlineMerchantModule onlineMerchantModule, OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(onlineMerchantModule, onlineMerchantAnalyticModule, applicationComponent);
        }

        private OnlineMerchantComponentImpl(OnlineMerchantModule onlineMerchantModule, OnlineMerchantAnalyticModule onlineMerchantAnalyticModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.moveToNextValue = onlineMerchantModule;
            this.MyBillsEntityDataFactory = onlineMerchantAnalyticModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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

        @Override // id.dana.onlinemerchant.di.OnlineMerchantComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(OnlineMerchantActivity onlineMerchantActivity) {
            ((BaseActivity) onlineMerchantActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(onlineMerchantActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(onlineMerchantActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            OnlineMerchantActivity_MembersInjector.getAuthRequestContext(onlineMerchantActivity, OnlineMerchantModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(this.moveToNextValue, new OnlineMerchantPresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), OnlineMerchantModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue), new GetOnlineMerchant((GlobalSearchRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.o())), new GetOnlineMerchant((GlobalSearchRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.o())))));
            OnlineMerchantActivity_MembersInjector.PlaceComponentResult(onlineMerchantActivity, OnlineMerchantAnalyticModule_ProvideOnlineMerchantMixpanelTracker$app_productionReleaseFactory.PlaceComponentResult(this.MyBillsEntityDataFactory, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
        }
    }
}
