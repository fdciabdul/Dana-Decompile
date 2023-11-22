package id.dana.domain.services.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.services.ServicesRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetServicesByName_Factory implements Factory<GetServicesByName> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ServicesRepository> servicesRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetServicesByName_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ServicesRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.servicesRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetServicesByName get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.servicesRepositoryProvider.get());
    }

    public static GetServicesByName_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ServicesRepository> provider3) {
        return new GetServicesByName_Factory(provider, provider2, provider3);
    }

    public static GetServicesByName newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ServicesRepository servicesRepository) {
        return new GetServicesByName(threadExecutor, postExecutionThread, servicesRepository);
    }
}
