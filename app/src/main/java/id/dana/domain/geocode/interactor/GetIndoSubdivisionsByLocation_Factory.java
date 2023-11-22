package id.dana.domain.geocode.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetIndoSubdivisionsByLocation_Factory implements Factory<GetIndoSubdivisionsByLocation> {
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetIndoSubdivisionsByLocation_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeocodeRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.geocodeRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetIndoSubdivisionsByLocation get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.geocodeRepositoryProvider.get());
    }

    public static GetIndoSubdivisionsByLocation_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<GeocodeRepository> provider3) {
        return new GetIndoSubdivisionsByLocation_Factory(provider, provider2, provider3);
    }

    public static GetIndoSubdivisionsByLocation newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeocodeRepository geocodeRepository) {
        return new GetIndoSubdivisionsByLocation(threadExecutor, postExecutionThread, geocodeRepository);
    }
}
