package id.dana.domain.recentbank.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRecentBank_Factory implements Factory<GetRecentBank> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentRecipientRepository> repositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetRecentBank_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.repositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetRecentBank get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.repositoryProvider.get());
    }

    public static GetRecentBank_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        return new GetRecentBank_Factory(provider, provider2, provider3);
    }

    public static GetRecentBank newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        return new GetRecentBank(threadExecutor, postExecutionThread, recentRecipientRepository);
    }
}
