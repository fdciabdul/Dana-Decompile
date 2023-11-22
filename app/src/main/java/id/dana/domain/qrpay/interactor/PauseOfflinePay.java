package id.dana.domain.qrpay.interactor;

import id.dana.domain.SynchronizedUseCase;
import id.dana.domain.qrpay.QrPayRepository;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PauseOfflinePay extends SynchronizedUseCase<Boolean, Void> {
    private final QrPayRepository qrPayRepository;

    @Inject
    public PauseOfflinePay(QrPayRepository qrPayRepository) {
        this.qrPayRepository = qrPayRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.SynchronizedUseCase
    public Boolean buildUseCaseObservable(Void r1) {
        return this.qrPayRepository.pause();
    }
}
