package id.dana.domain.kycamledd.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubmitEddAmlKyc_Factory implements Factory<SubmitEddAmlKyc> {
    private final Provider<KycAmlEddRepository> kycAmlEddRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SubmitEddAmlKyc_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<KycAmlEddRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.kycAmlEddRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SubmitEddAmlKyc get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.kycAmlEddRepositoryProvider.get());
    }

    public static SubmitEddAmlKyc_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<KycAmlEddRepository> provider3) {
        return new SubmitEddAmlKyc_Factory(provider, provider2, provider3);
    }

    public static SubmitEddAmlKyc newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, KycAmlEddRepository kycAmlEddRepository) {
        return new SubmitEddAmlKyc(threadExecutor, postExecutionThread, kycAmlEddRepository);
    }
}
