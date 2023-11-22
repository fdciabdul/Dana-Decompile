package id.dana.domain.lazada.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveLazadaClickedAgree_Factory implements Factory<SaveLazadaClickedAgree> {
    private final Provider<LazadaRepository> lazadaRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SaveLazadaClickedAgree_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LazadaRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.lazadaRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveLazadaClickedAgree get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.lazadaRepositoryProvider.get());
    }

    public static SaveLazadaClickedAgree_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<LazadaRepository> provider3) {
        return new SaveLazadaClickedAgree_Factory(provider, provider2, provider3);
    }

    public static SaveLazadaClickedAgree newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LazadaRepository lazadaRepository) {
        return new SaveLazadaClickedAgree(threadExecutor, postExecutionThread, lazadaRepository);
    }
}
