package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FinishFirstTime_Factory implements Factory<FinishFirstTime> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public FinishFirstTime_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final FinishFirstTime get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static FinishFirstTime_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        return new FinishFirstTime_Factory(provider, provider2, provider3);
    }

    public static FinishFirstTime newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        return new FinishFirstTime(threadExecutor, postExecutionThread, accountRepository);
    }
}
