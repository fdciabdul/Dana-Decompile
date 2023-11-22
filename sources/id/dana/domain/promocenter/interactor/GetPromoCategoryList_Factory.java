package id.dana.domain.promocenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoCategoryList_Factory implements Factory<GetPromoCategoryList> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoCenterRepository> promoCenterRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetPromoCategoryList_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoCenterRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promoCenterRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetPromoCategoryList get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promoCenterRepositoryProvider.get());
    }

    public static GetPromoCategoryList_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoCenterRepository> provider3) {
        return new GetPromoCategoryList_Factory(provider, provider2, provider3);
    }

    public static GetPromoCategoryList newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoCenterRepository promoCenterRepository) {
        return new GetPromoCategoryList(threadExecutor, postExecutionThread, promoCenterRepository);
    }
}
