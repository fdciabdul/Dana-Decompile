package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.GeofenceModule;
import id.dana.di.modules.GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory;
import id.dana.di.modules.GeofenceModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime;
import id.dana.domain.featureconfig.interactor.GetCurrentPOICacheTime_Factory;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig;
import id.dana.domain.featureconfig.interactor.GetGeoFenceConfig_Factory;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence;
import id.dana.domain.featureconfig.interactor.SetRetryIntervalGeoFence_Factory;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.domain.geofence.interactor.GetListPoi;
import id.dana.domain.geofence.interactor.GetListPoi_Factory;
import id.dana.domain.geofence.interactor.PoiNotify;
import id.dana.domain.geofence.interactor.PoiNotify_Factory;
import id.dana.geofence.GeoFencePresenter;
import id.dana.geofence.GeoFencePresenter_Factory;
import id.dana.geofence.GeoFenceTransitionsJobIntentService;
import id.dana.geofence.GeoFenceTransitionsJobIntentService_MembersInjector;
import id.dana.geofence.GeofenceContract;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerGeofenceComponent {
    private DaggerGeofenceComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GeofenceModule MyBillsEntityDataFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class GeofenceComponentImpl implements GeofenceComponent {
        private final GeofenceModule BuiltInFictitiousFunctionClassFactory;
        private Provider<GeofenceContract.View> DatabaseTableConfigUtil;
        private Provider<ThreadExecutor> GetContactSyncConfig;
        private Provider<GeoFencePresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private final GeofenceComponentImpl MyBillsEntityDataFactory;
        private Provider<GetGeoFenceConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;
        private Provider<PoiNotify> getErrorConfigVersion;
        private Provider<SetRetryIntervalGeoFence> initRecordTimeStamp;
        private Provider<GetCurrentPOICacheTime> lookAheadTest;
        private Provider<GetListPoi> moveToNextValue;
        private Provider<GeoFenceRepository> scheduleImpl;

        public /* synthetic */ GeofenceComponentImpl(GeofenceModule geofenceModule, ApplicationComponent applicationComponent, byte b) {
            this(geofenceModule, applicationComponent);
        }

        private GeofenceComponentImpl(GeofenceModule geofenceModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.BuiltInFictitiousFunctionClassFactory = geofenceModule;
            this.getAuthRequestContext = applicationComponent;
            this.GetContactSyncConfig = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            GeofenceRepositoryProvider geofenceRepositoryProvider = new GeofenceRepositoryProvider(applicationComponent);
            this.scheduleImpl = geofenceRepositoryProvider;
            this.getErrorConfigVersion = PoiNotify_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, geofenceRepositoryProvider);
            this.moveToNextValue = GetListPoi_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetGeoFenceConfig_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            this.lookAheadTest = GetCurrentPOICacheTime_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl);
            this.initRecordTimeStamp = SetRetryIntervalGeoFence_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl);
            GeofenceModule_ProvideView$app_productionReleaseFactory PlaceComponentResult = GeofenceModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(geofenceModule);
            this.DatabaseTableConfigUtil = PlaceComponentResult;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DoubleCheck.getAuthRequestContext(GeoFencePresenter_Factory.MyBillsEntityDataFactory(this.getErrorConfigVersion, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.initRecordTimeStamp, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class GeofenceRepositoryProvider implements Provider<GeoFenceRepository> {
            private final ApplicationComponent PlaceComponentResult;

            GeofenceRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeoFenceRepository get() {
                return (GeoFenceRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.readMicros());
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

        @Override // id.dana.di.component.GeofenceComponent
        public final void MyBillsEntityDataFactory(GeoFenceTransitionsJobIntentService geoFenceTransitionsJobIntentService) {
            GeoFenceTransitionsJobIntentService_MembersInjector.getAuthRequestContext(geoFenceTransitionsJobIntentService, this.KClassImpl$Data$declaredNonStaticMembers$2.get());
            GeoFenceTransitionsJobIntentService_MembersInjector.getAuthRequestContext(geoFenceTransitionsJobIntentService, GeofenceModule_ProvideGeofenceManager$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue())));
        }
    }
}
