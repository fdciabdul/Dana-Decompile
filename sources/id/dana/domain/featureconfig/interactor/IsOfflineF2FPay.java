package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class IsOfflineF2FPay extends UseCase<Boolean, Void> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public IsOfflineF2FPay(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.featureConfigRepository.isOfflineF2FPay();
    }
}
