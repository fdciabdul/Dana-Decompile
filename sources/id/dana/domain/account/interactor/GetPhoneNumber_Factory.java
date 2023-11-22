package id.dana.domain.account.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPhoneNumber_Factory implements Factory<GetPhoneNumber> {
    private final Provider<LiteAccountRepository> accountRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetPhoneNumber_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.accountRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetPhoneNumber get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.accountRepositoryProvider.get());
    }

    public static GetPhoneNumber_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LiteAccountRepository> provider3) {
        return new GetPhoneNumber_Factory(provider, provider2, provider3);
    }

    public static GetPhoneNumber newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LiteAccountRepository liteAccountRepository) {
        return new GetPhoneNumber(threadExecutor, postExecutionThread, liteAccountRepository);
    }
}
