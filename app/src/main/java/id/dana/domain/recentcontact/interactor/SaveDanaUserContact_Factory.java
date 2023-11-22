package id.dana.domain.recentcontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDanaUserContact_Factory implements Factory<SaveDanaUserContact> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentContactRepository> recentContactRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveDanaUserContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentContactRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.recentContactRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveDanaUserContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.recentContactRepositoryProvider.get());
    }

    public static SaveDanaUserContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentContactRepository> provider3) {
        return new SaveDanaUserContact_Factory(provider, provider2, provider3);
    }

    public static SaveDanaUserContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentContactRepository recentContactRepository) {
        return new SaveDanaUserContact(threadExecutor, postExecutionThread, recentContactRepository);
    }
}
