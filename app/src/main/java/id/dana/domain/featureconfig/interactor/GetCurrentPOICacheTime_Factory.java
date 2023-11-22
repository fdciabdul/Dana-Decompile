package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCurrentPOICacheTime_Factory implements Factory<GetCurrentPOICacheTime> {
    private final Provider<GeoFenceRepository> geofenceConfigFactoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetCurrentPOICacheTime_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.geofenceConfigFactoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetCurrentPOICacheTime get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.geofenceConfigFactoryProvider.get());
    }

    public static GetCurrentPOICacheTime_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        return new GetCurrentPOICacheTime_Factory(provider, provider2, provider3);
    }

    public static GetCurrentPOICacheTime newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        return new GetCurrentPOICacheTime(threadExecutor, postExecutionThread, geoFenceRepository);
    }
}
