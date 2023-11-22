package id.dana.domain.ipg.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ipg.IpgRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetIpgClickedAgree_Factory implements Factory<GetIpgClickedAgree> {
    private final Provider<IpgRepository> ipgRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetIpgClickedAgree_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<IpgRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.ipgRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetIpgClickedAgree get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.ipgRepositoryProvider.get());
    }

    public static GetIpgClickedAgree_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<IpgRepository> provider3) {
        return new GetIpgClickedAgree_Factory(provider, provider2, provider3);
    }

    public static GetIpgClickedAgree newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IpgRepository ipgRepository) {
        return new GetIpgClickedAgree(threadExecutor, postExecutionThread, ipgRepository);
    }
}
