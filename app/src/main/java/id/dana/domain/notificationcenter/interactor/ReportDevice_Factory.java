package id.dana.domain.notificationcenter.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReportDevice_Factory implements Factory<ReportDevice> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ReportDevice_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PushNotificationRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.pushNotificationRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ReportDevice get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.pushNotificationRepositoryProvider.get());
    }

    public static ReportDevice_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PushNotificationRepository> provider3) {
        return new ReportDevice_Factory(provider, provider2, provider3);
    }

    public static ReportDevice newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PushNotificationRepository pushNotificationRepository) {
        return new ReportDevice(threadExecutor, postExecutionThread, pushNotificationRepository);
    }
}
