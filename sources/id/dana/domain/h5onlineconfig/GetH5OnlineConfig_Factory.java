package id.dana.domain.h5onlineconfig;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetH5OnlineConfig_Factory implements Factory<GetH5OnlineConfig> {
    private final Provider<H5OnlineConfigRepository> h5OnlineConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetH5OnlineConfig_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<H5OnlineConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.h5OnlineConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetH5OnlineConfig get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.h5OnlineConfigRepositoryProvider.get());
    }

    public static GetH5OnlineConfig_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<H5OnlineConfigRepository> provider3) {
        return new GetH5OnlineConfig_Factory(provider, provider2, provider3);
    }

    public static GetH5OnlineConfig newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, H5OnlineConfigRepository h5OnlineConfigRepository) {
        return new GetH5OnlineConfig(threadExecutor, postExecutionThread, h5OnlineConfigRepository);
    }
}
