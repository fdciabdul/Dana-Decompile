package id.dana.domain.twilio.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TwilioVerifySecurityProduct_Factory implements Factory<TwilioVerifySecurityProduct> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<TwilioRepository> twilioRepositoryProvider;

    public TwilioVerifySecurityProduct_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.twilioRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final TwilioVerifySecurityProduct get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.twilioRepositoryProvider.get());
    }

    public static TwilioVerifySecurityProduct_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<TwilioRepository> provider3) {
        return new TwilioVerifySecurityProduct_Factory(provider, provider2, provider3);
    }

    public static TwilioVerifySecurityProduct newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioRepository twilioRepository) {
        return new TwilioVerifySecurityProduct(threadExecutor, postExecutionThread, twilioRepository);
    }
}
