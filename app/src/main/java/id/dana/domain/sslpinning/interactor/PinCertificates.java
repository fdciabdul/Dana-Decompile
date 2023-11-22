package id.dana.domain.sslpinning.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PinCertificates extends UseCase<Boolean, Void> {
    private final SSLPinningRepository sslPinningRepository;

    @Inject
    public PinCertificates(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SSLPinningRepository sSLPinningRepository) {
        super(threadExecutor, postExecutionThread);
        this.sslPinningRepository = sSLPinningRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.sslPinningRepository.pinCertificates();
    }
}
