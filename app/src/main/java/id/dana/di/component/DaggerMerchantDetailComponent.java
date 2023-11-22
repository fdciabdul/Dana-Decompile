package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.MerchantDetailModule;
import id.dana.di.modules.MerchantDetailModule_ProvidePresenterFactory;
import id.dana.di.modules.MerchantDetailModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.nearbyme.di.module.NearbyTrackerModule;
import id.dana.nearbyme.di.module.NearbyTrackerModule_ProvideMerchantDetailTrackerFactory;
import id.dana.nearbyme.di.module.NearbyTrackerModule_ProvideTrackerFactory;
import id.dana.nearbyme.merchantdetail.MerchantDetailActivity;
import id.dana.nearbyme.merchantdetail.MerchantDetailActivity_MembersInjector;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailPresenter;
import id.dana.nearbyme.merchantdetail.MerchantDetailPresenter_Factory;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDetailMapper_Factory;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers_Factory;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantDetailComponent {
    private DaggerMerchantDetailComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantDetailModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;
        public NearbyTrackerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantDetailComponentImpl implements MerchantDetailComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantDetailContract.Presenter> DatabaseTableConfigUtil;
        private Provider<NearbyAnalyticTracker> GetContactSyncConfig;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<MerchantDetailMixpanelTrackers> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<NearbyDefaultTracker> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<MerchantDetailAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetMerchantInfo> PlaceComponentResult;
        private Provider<SSLPinningRepository> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<MerchantDetailPresenter> getErrorConfigVersion;
        private Provider<PostExecutionThread> initRecordTimeStamp;
        private Provider<MerchantDetailContract.View> isLayoutRequested;
        private Provider<MerchantInfoRepository> lookAheadTest;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<ThreadExecutor> newProxyInstance;
        private final MerchantDetailComponentImpl scheduleImpl;

        public /* synthetic */ MerchantDetailComponentImpl(MerchantDetailModule merchantDetailModule, NearbyTrackerModule nearbyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDetailModule, nearbyTrackerModule, applicationComponent);
        }

        private MerchantDetailComponentImpl(MerchantDetailModule merchantDetailModule, NearbyTrackerModule nearbyTrackerModule, ApplicationComponent applicationComponent) {
            this.scheduleImpl = this;
            this.getAuthRequestContext = applicationComponent;
            this.newProxyInstance = new ThreadExecutorProvider(applicationComponent);
            this.PrepareContext = new SSLPinningRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.newProxyInstance, this.initRecordTimeStamp, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.newProxyInstance, this.PrepareContext, create);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = contextProvider;
            MerchantDetailMixpanelTrackers_Factory authRequestContext = MerchantDetailMixpanelTrackers_Factory.getAuthRequestContext(contextProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoubleCheck.getAuthRequestContext(NearbyTrackerModule_ProvideMerchantDetailTrackerFactory.getAuthRequestContext(nearbyTrackerModule, authRequestContext));
            NearbyDefaultTracker_Factory BuiltInFictitiousFunctionClassFactory = NearbyDefaultTracker_Factory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
            this.GetContactSyncConfig = DoubleCheck.getAuthRequestContext(NearbyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(nearbyTrackerModule, BuiltInFictitiousFunctionClassFactory));
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(MerchantDetailModule_ProvideViewFactory.PlaceComponentResult(merchantDetailModule));
            MerchantInfoRepositoryProvider merchantInfoRepositoryProvider = new MerchantInfoRepositoryProvider(applicationComponent);
            this.lookAheadTest = merchantInfoRepositoryProvider;
            GetMerchantInfo_Factory create2 = GetMerchantInfo_Factory.create(merchantInfoRepositoryProvider);
            this.PlaceComponentResult = create2;
            MerchantDetailPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MerchantDetailPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, create2, MerchantDetailMapper_Factory.BuiltInFictitiousFunctionClassFactory());
            this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(MerchantDetailModule_ProvidePresenterFactory.MyBillsEntityDataFactory(merchantDetailModule, KClassImpl$Data$declaredNonStaticMembers$2));
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
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.M());
            }
        }

        @Override // id.dana.di.component.MerchantDetailComponent
        public final void MyBillsEntityDataFactory(MerchantDetailActivity merchantDetailActivity) {
            ((BaseActivity) merchantDetailActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(merchantDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            MerchantDetailActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantDetailActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
            MerchantDetailActivity_MembersInjector.MyBillsEntityDataFactory(merchantDetailActivity, this.GetContactSyncConfig.get());
            MerchantDetailActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantDetailActivity, this.DatabaseTableConfigUtil.get());
        }
    }
}
