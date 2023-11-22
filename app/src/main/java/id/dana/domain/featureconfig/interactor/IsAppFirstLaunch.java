package id.dana.domain.featureconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.AppGeneralRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class IsAppFirstLaunch extends UseCase<Boolean, Void> {
    private final AppGeneralRepository appGeneralRepository;

    @Inject
    public IsAppFirstLaunch(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, AppGeneralRepository appGeneralRepository) {
        super(threadExecutor, postExecutionThread);
        this.appGeneralRepository = appGeneralRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.appGeneralRepository.isAppFirstLaunch();
    }
}
