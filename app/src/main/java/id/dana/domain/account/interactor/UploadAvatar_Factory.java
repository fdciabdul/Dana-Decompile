package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UploadAvatar_Factory implements Factory<UploadAvatar> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public UploadAvatar_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final UploadAvatar get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static UploadAvatar_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<AccountRepository> provider3) {
        return new UploadAvatar_Factory(provider, provider2, provider3);
    }

    public static UploadAvatar newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AccountRepository accountRepository) {
        return new UploadAvatar(threadExecutor, postExecutionThread, accountRepository);
    }
}
