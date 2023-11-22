package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetAccountLite_Factory implements Factory<GetAccountLite> {
    private final Provider<LiteAccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetAccountLite_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetAccountLite get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetAccountLite_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        return new GetAccountLite_Factory(provider, provider2, provider3);
    }

    public static GetAccountLite newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LiteAccountRepository liteAccountRepository) {
        return new GetAccountLite(threadExecutor, postExecutionThread, liteAccountRepository);
    }
}
