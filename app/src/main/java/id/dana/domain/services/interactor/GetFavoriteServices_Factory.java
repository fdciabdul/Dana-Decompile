package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.services.ServicesRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFavoriteServices_Factory implements Factory<GetFavoriteServices> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetFavoriteServices_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ServicesRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.servicesRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetFavoriteServices get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static GetFavoriteServices_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ServicesRepository> provider3) {
        return new GetFavoriteServices_Factory(provider, provider2, provider3);
    }

    public static GetFavoriteServices newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        return new GetFavoriteServices(threadExecutor, postExecutionThread, servicesRepository);
    }
}
