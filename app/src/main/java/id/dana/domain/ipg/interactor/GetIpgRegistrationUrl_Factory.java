package id.dana.domain.ipg.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ipg.IpgRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetIpgRegistrationUrl_Factory implements Factory<GetIpgRegistrationUrl> {
    private final Provider<IpgRepository> ipgRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetIpgRegistrationUrl_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<IpgRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.ipgRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetIpgRegistrationUrl get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.ipgRepositoryProvider.get());
    }

    public static GetIpgRegistrationUrl_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<IpgRepository> provider3) {
        return new GetIpgRegistrationUrl_Factory(provider, provider2, provider3);
    }

    public static GetIpgRegistrationUrl newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IpgRepository ipgRepository) {
        return new GetIpgRegistrationUrl(threadExecutor, postExecutionThread, ipgRepository);
    }
}
