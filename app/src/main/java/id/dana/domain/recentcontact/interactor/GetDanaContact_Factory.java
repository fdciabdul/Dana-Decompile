package id.dana.domain.recentcontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaContact_Factory implements Factory<GetDanaContact> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentContactRepository> recentContactRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetDanaContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentContactRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.recentContactRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDanaContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.recentContactRepositoryProvider.get());
    }

    public static GetDanaContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentContactRepository> provider3) {
        return new GetDanaContact_Factory(provider, provider2, provider3);
    }

    public static GetDanaContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentContactRepository recentContactRepository) {
        return new GetDanaContact(threadExecutor, postExecutionThread, recentContactRepository);
    }
}
