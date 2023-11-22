package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserConfig_Factory implements Factory<GetUserConfig> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetUserConfig_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.recentRecipientRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetUserConfig get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.recentRecipientRepositoryProvider.get());
    }

    public static GetUserConfig_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        return new GetUserConfig_Factory(provider, provider2, provider3);
    }

    public static GetUserConfig newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        return new GetUserConfig(threadExecutor, postExecutionThread, recentRecipientRepository);
    }
}
