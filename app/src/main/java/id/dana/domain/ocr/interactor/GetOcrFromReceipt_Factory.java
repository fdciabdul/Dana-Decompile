package id.dana.domain.ocr.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ocr.OCRRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetOcrFromReceipt_Factory implements Factory<GetOcrFromReceipt> {
    private final Provider<OCRRepository> ocrRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetOcrFromReceipt_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OCRRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.ocrRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetOcrFromReceipt get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.ocrRepositoryProvider.get());
    }

    public static GetOcrFromReceipt_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OCRRepository> provider3) {
        return new GetOcrFromReceipt_Factory(provider, provider2, provider3);
    }

    public static GetOcrFromReceipt newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OCRRepository oCRRepository) {
        return new GetOcrFromReceipt(threadExecutor, postExecutionThread, oCRRepository);
    }
}
