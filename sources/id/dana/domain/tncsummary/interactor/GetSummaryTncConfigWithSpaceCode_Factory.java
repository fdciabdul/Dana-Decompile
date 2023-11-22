package id.dana.domain.tncsummary.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSummaryTncConfigWithSpaceCode_Factory implements Factory<GetSummaryTncConfigWithSpaceCode> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TncSummaryRepository> tncSummaryRepositoryProvider;

    public GetSummaryTncConfigWithSpaceCode_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TncSummaryRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.tncSummaryRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSummaryTncConfigWithSpaceCode get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.tncSummaryRepositoryProvider.get());
    }

    public static GetSummaryTncConfigWithSpaceCode_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TncSummaryRepository> provider3) {
        return new GetSummaryTncConfigWithSpaceCode_Factory(provider, provider2, provider3);
    }

    public static GetSummaryTncConfigWithSpaceCode newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TncSummaryRepository tncSummaryRepository) {
        return new GetSummaryTncConfigWithSpaceCode(threadExecutor, postExecutionThread, tncSummaryRepository);
    }
}
