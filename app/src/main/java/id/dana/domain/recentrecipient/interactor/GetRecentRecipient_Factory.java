package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetRecentRecipient_Factory implements Factory<GetRecentRecipient> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetRecentRecipient_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.recentRecipientRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetRecentRecipient get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.recentRecipientRepositoryProvider.get());
    }

    public static GetRecentRecipient_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        return new GetRecentRecipient_Factory(provider, provider2, provider3);
    }

    public static GetRecentRecipient newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        return new GetRecentRecipient(threadExecutor, postExecutionThread, recentRecipientRepository);
    }
}
