package id.dana.domain.kycamledd.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKycAmlEddConsult_Factory implements Factory<GetKycAmlEddConsult> {
    private final Provider<KycAmlEddRepository> kycAmlEddRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetKycAmlEddConsult_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<KycAmlEddRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.kycAmlEddRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetKycAmlEddConsult get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.kycAmlEddRepositoryProvider.get());
    }

    public static GetKycAmlEddConsult_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<KycAmlEddRepository> provider3) {
        return new GetKycAmlEddConsult_Factory(provider, provider2, provider3);
    }

    public static GetKycAmlEddConsult newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, KycAmlEddRepository kycAmlEddRepository) {
        return new GetKycAmlEddConsult(threadExecutor, postExecutionThread, kycAmlEddRepository);
    }
}
