package id.dana.domain.permission.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.permission.PermissionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CheckDeniedLocationPermission extends UseCase<Boolean, Void> {
    private final PermissionRepository permissionRepository;

    @Inject
    public CheckDeniedLocationPermission(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PermissionRepository permissionRepository) {
        super(threadExecutor, postExecutionThread);
        this.permissionRepository = permissionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Void r1) {
        return this.permissionRepository.checkDeniedLocationPermission();
    }
}
