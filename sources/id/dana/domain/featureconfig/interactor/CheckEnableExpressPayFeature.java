package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CheckEnableExpressPayFeature extends UseCase<ExpressPayInfo, Void> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckEnableExpressPayFeature(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ExpressPayInfo> buildUseCaseObservable(Void r1) {
        return this.featureConfigRepository.getEnableExpressPayInfo();
    }
}
