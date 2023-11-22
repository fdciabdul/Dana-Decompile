package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetUserUUID_Factory implements Factory<GetUserUUID> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetUserUUID_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetUserUUID get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetUserUUID_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        return new GetUserUUID_Factory(provider, provider2, provider3);
    }

    public static GetUserUUID newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        return new GetUserUUID(threadExecutor, postExecutionThread, accountRepository);
    }
}
