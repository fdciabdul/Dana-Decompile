package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetRetryIntervalGeoFence_Factory implements Factory<SetRetryIntervalGeoFence> {
    private final Provider<GeoFenceRepository> geoFenceRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SetRetryIntervalGeoFence_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.geoFenceRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SetRetryIntervalGeoFence get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.geoFenceRepositoryProvider.get());
    }

    public static SetRetryIntervalGeoFence_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        return new SetRetryIntervalGeoFence_Factory(provider, provider2, provider3);
    }

    public static SetRetryIntervalGeoFence newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        return new SetRetryIntervalGeoFence(threadExecutor, postExecutionThread, geoFenceRepository);
    }
}
