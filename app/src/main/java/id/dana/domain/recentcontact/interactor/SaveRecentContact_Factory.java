package id.dana.domain.recentcontact.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveRecentContact_Factory implements Factory<SaveRecentContact> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveRecentContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.recentRecipientRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveRecentContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.recentRecipientRepositoryProvider.get());
    }

    public static SaveRecentContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<RecentRecipientRepository> provider3) {
        return new SaveRecentContact_Factory(provider, provider2, provider3);
    }

    public static SaveRecentContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        return new SaveRecentContact(threadExecutor, postExecutionThread, recentRecipientRepository);
    }
}
