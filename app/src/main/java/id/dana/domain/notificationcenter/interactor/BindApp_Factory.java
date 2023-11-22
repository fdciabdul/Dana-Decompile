package id.dana.domain.notificationcenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BindApp_Factory implements Factory<BindApp> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public BindApp_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PushNotificationRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.pushNotificationRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final BindApp get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.pushNotificationRepositoryProvider.get());
    }

    public static BindApp_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PushNotificationRepository> provider3) {
        return new BindApp_Factory(provider, provider2, provider3);
    }

    public static BindApp newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PushNotificationRepository pushNotificationRepository) {
        return new BindApp(threadExecutor, postExecutionThread, pushNotificationRepository);
    }
}
