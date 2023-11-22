package id.dana.domain.version.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.version.VersionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetStorageVersion_Factory implements Factory<GetStorageVersion> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<VersionRepository> versionRepositoryProvider;

    public GetStorageVersion_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<VersionRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.versionRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetStorageVersion get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.versionRepositoryProvider.get());
    }

    public static GetStorageVersion_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<VersionRepository> provider3) {
        return new GetStorageVersion_Factory(provider, provider2, provider3);
    }

    public static GetStorageVersion newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, VersionRepository versionRepository) {
        return new GetStorageVersion(threadExecutor, postExecutionThread, versionRepository);
    }
}
