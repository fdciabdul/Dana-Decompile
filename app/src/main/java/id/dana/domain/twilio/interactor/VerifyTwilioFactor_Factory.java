package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class VerifyTwilioFactor_Factory implements Factory<VerifyTwilioFactor> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public VerifyTwilioFactor_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.twilioSdkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final VerifyTwilioFactor get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.twilioSdkRepositoryProvider.get());
    }

    public static VerifyTwilioFactor_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        return new VerifyTwilioFactor_Factory(provider, provider2, provider3);
    }

    public static VerifyTwilioFactor newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioSdkRepository twilioSdkRepository) {
        return new VerifyTwilioFactor(threadExecutor, postExecutionThread, twilioSdkRepository);
    }
}
