package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHomeInfo_Factory implements Factory<GetHomeInfo> {
    private final Provider<HomeInfoRepository> homeInfoRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetHomeInfo_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<HomeInfoRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.homeInfoRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetHomeInfo get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.homeInfoRepositoryProvider.get());
    }

    public static GetHomeInfo_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<HomeInfoRepository> provider3) {
        return new GetHomeInfo_Factory(provider, provider2, provider3);
    }

    public static GetHomeInfo newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, HomeInfoRepository homeInfoRepository) {
        return new GetHomeInfo(threadExecutor, postExecutionThread, homeInfoRepository);
    }
}
