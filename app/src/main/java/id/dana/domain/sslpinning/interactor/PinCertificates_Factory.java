package id.dana.domain.sslpinning.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinCertificates_Factory implements Factory<PinCertificates> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SSLPinningRepository> sslPinningRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public PinCertificates_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SSLPinningRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.sslPinningRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PinCertificates get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.sslPinningRepositoryProvider.get());
    }

    public static PinCertificates_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SSLPinningRepository> provider3) {
        return new PinCertificates_Factory(provider, provider2, provider3);
    }

    public static PinCertificates newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SSLPinningRepository sSLPinningRepository) {
        return new PinCertificates(threadExecutor, postExecutionThread, sSLPinningRepository);
    }
}
