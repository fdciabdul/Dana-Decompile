package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeleteTwilioLocalFactor_Factory implements Factory<DeleteTwilioLocalFactor> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;

    public DeleteTwilioLocalFactor_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.twilioSdkRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final DeleteTwilioLocalFactor get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.twilioSdkRepositoryProvider.get());
    }

    public static DeleteTwilioLocalFactor_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioSdkRepository> provider3) {
        return new DeleteTwilioLocalFactor_Factory(provider, provider2, provider3);
    }

    public static DeleteTwilioLocalFactor newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioSdkRepository twilioSdkRepository) {
        return new DeleteTwilioLocalFactor(threadExecutor, postExecutionThread, twilioSdkRepository);
    }
}
