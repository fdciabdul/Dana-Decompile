package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDecodedQrisTopUp_Factory implements Factory<GetDecodedQrisTopUp> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<QrBarcodeRepository> qrBarcodeRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetDecodedQrisTopUp_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<QrBarcodeRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.qrBarcodeRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetDecodedQrisTopUp get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.qrBarcodeRepositoryProvider.get());
    }

    public static GetDecodedQrisTopUp_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<QrBarcodeRepository> provider3) {
        return new GetDecodedQrisTopUp_Factory(provider, provider2, provider3);
    }

    public static GetDecodedQrisTopUp newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, QrBarcodeRepository qrBarcodeRepository) {
        return new GetDecodedQrisTopUp(threadExecutor, postExecutionThread, qrBarcodeRepository);
    }
}
