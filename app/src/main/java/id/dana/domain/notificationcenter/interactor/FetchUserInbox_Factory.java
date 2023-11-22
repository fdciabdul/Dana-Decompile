package id.dana.domain.notificationcenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class FetchUserInbox_Factory implements Factory<FetchUserInbox> {
    private final Provider<NotificationCenterRepository> notificationCenterRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public FetchUserInbox_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NotificationCenterRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.notificationCenterRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final FetchUserInbox get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.notificationCenterRepositoryProvider.get());
    }

    public static FetchUserInbox_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NotificationCenterRepository> provider3) {
        return new FetchUserInbox_Factory(provider, provider2, provider3);
    }

    public static FetchUserInbox newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NotificationCenterRepository notificationCenterRepository) {
        return new FetchUserInbox(threadExecutor, postExecutionThread, notificationCenterRepository);
    }
}
