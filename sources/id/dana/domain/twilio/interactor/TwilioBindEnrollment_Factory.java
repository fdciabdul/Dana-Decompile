package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioBindEnrollment_Factory implements Factory<TwilioBindEnrollment> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public TwilioBindEnrollment_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.twilioRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final TwilioBindEnrollment get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.twilioRepositoryProvider.get());
    }

    public static TwilioBindEnrollment_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioRepository> provider3) {
        return new TwilioBindEnrollment_Factory(provider, provider2, provider3);
    }

    public static TwilioBindEnrollment newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioRepository twilioRepository) {
        return new TwilioBindEnrollment(threadExecutor, postExecutionThread, twilioRepository);
    }
}
