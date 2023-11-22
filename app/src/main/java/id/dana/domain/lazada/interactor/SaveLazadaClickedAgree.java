package id.dana.domain.lazada.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SaveLazadaClickedAgree extends UseCase<Boolean, Void> {
    private LazadaRepository lazadaRepository;

    @Inject
    public SaveLazadaClickedAgree(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LazadaRepository lazadaRepository) {
        super(threadExecutor, postExecutionThread);
        this.lazadaRepository = lazadaRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.lazadaRepository.saveClickedAgree();
    }
}
