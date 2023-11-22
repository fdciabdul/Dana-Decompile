package id.dana.domain.maintenance.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.maintenance.model.MaintenanceBroadcast;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ObserveMaintenanceBroadcast extends UseCase<MaintenanceBroadcast, Void> {
    private FeatureConfigRepository featureConfigRepository;

    @Inject
    public ObserveMaintenanceBroadcast(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<MaintenanceBroadcast> buildUseCaseObservable(Void r1) {
        return this.featureConfigRepository.observeMaintenanceBroadcast();
    }
}
