package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserId_Factory implements Factory<GetUserId> {
    private final Provider<LiteAccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetUserId_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetUserId get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetUserId_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        return new GetUserId_Factory(provider, provider2, provider3);
    }

    public static GetUserId newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LiteAccountRepository liteAccountRepository) {
        return new GetUserId(threadExecutor, postExecutionThread, liteAccountRepository);
    }
}
