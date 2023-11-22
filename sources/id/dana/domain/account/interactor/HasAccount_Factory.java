package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HasAccount_Factory implements Factory<HasAccount> {
    private final Provider<LiteAccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public HasAccount_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final HasAccount get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static HasAccount_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        return new HasAccount_Factory(provider, provider2, provider3);
    }

    public static HasAccount newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LiteAccountRepository liteAccountRepository) {
        return new HasAccount(threadExecutor, postExecutionThread, liteAccountRepository);
    }
}
