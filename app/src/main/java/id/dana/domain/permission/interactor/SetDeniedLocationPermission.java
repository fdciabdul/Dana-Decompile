package id.dana.domain.permission.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.permission.PermissionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SetDeniedLocationPermission extends UseCase<Boolean, Params> {
    private final PermissionRepository permissionRepository;

    @Inject
    public SetDeniedLocationPermission(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PermissionRepository permissionRepository) {
        super(threadExecutor, postExecutionThread);
        this.permissionRepository = permissionRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return this.permissionRepository.setDeniedLocationPermission(Boolean.valueOf(params.isPermissionDenied));
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private boolean isPermissionDenied;

        private Params(boolean z) {
            this.isPermissionDenied = z;
        }

        public static Params forDenyLocationPermission(boolean z) {
            return new Params(z);
        }
    }
}
