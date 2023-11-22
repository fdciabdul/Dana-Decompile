package id.dana.domain.geofence.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PoiNotify_Factory implements Factory<PoiNotify> {
    private final Provider<GeoFenceRepository> geoFenceRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public PoiNotify_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.geoFenceRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PoiNotify get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.geoFenceRepositoryProvider.get());
    }

    public static PoiNotify_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        return new PoiNotify_Factory(provider, provider2, provider3);
    }

    public static PoiNotify newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        return new PoiNotify(threadExecutor, postExecutionThread, geoFenceRepository);
    }
}
