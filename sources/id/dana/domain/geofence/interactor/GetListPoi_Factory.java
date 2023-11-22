package id.dana.domain.geofence.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetListPoi_Factory implements Factory<GetListPoi> {
    private final Provider<GeoFenceRepository> geoFenceRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetListPoi_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.geoFenceRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetListPoi get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.geoFenceRepositoryProvider.get());
    }

    public static GetListPoi_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeoFenceRepository> provider3) {
        return new GetListPoi_Factory(provider, provider2, provider3);
    }

    public static GetListPoi newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoFenceRepository geoFenceRepository) {
        return new GetListPoi(threadExecutor, postExecutionThread, geoFenceRepository);
    }
}
