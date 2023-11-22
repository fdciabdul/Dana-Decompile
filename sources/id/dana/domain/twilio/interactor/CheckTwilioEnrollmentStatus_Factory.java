package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckTwilioEnrollmentStatus_Factory implements Factory<CheckTwilioEnrollmentStatus> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public CheckTwilioEnrollmentStatus_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.twilioSdkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final CheckTwilioEnrollmentStatus get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.twilioSdkRepositoryProvider.get());
    }

    public static CheckTwilioEnrollmentStatus_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        return new CheckTwilioEnrollmentStatus_Factory(provider, provider2, provider3);
    }

    public static CheckTwilioEnrollmentStatus newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioSdkRepository twilioSdkRepository) {
        return new CheckTwilioEnrollmentStatus(threadExecutor, postExecutionThread, twilioSdkRepository);
    }
}
