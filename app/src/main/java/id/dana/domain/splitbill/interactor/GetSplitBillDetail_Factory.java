package id.dana.domain.splitbill.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetSplitBillDetail_Factory implements Factory<GetSplitBillDetail> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SplitBillRepository> splitBillRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetSplitBillDetail_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SplitBillRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.splitBillRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSplitBillDetail get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.splitBillRepositoryProvider.get());
    }

    public static GetSplitBillDetail_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SplitBillRepository> provider3) {
        return new GetSplitBillDetail_Factory(provider, provider2, provider3);
    }

    public static GetSplitBillDetail newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SplitBillRepository splitBillRepository) {
        return new GetSplitBillDetail(threadExecutor, postExecutionThread, splitBillRepository);
    }
}
