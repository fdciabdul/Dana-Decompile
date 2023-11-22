package id.dana.domain.notificationcenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HasNewInbox_Factory implements Factory<HasNewInbox> {
    private final Provider<NotificationCenterRepository> notificationCenterRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public HasNewInbox_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NotificationCenterRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.notificationCenterRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final HasNewInbox get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.notificationCenterRepositoryProvider.get());
    }

    public static HasNewInbox_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<NotificationCenterRepository> provider3) {
        return new HasNewInbox_Factory(provider, provider2, provider3);
    }

    public static HasNewInbox newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NotificationCenterRepository notificationCenterRepository) {
        return new HasNewInbox(threadExecutor, postExecutionThread, notificationCenterRepository);
    }
}
