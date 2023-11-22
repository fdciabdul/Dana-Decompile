package id.dana.domain.version.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.version.Version;
import id.dana.domain.version.VersionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetAppVersion extends UseCase<Version, Void> {
    private final VersionRepository versionRepository;

    @Inject
    public GetAppVersion(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, VersionRepository versionRepository) {
        super(threadExecutor, postExecutionThread);
        this.versionRepository = versionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Version> buildUseCaseObservable(Void r1) {
        return this.versionRepository.getAppVersion();
    }
}
