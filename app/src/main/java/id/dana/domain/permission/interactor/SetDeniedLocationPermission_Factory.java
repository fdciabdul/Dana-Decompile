package id.dana.domain.permission.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.permission.PermissionRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetDeniedLocationPermission_Factory implements Factory<SetDeniedLocationPermission> {
    private final Provider<PermissionRepository> permissionRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SetDeniedLocationPermission_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PermissionRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.permissionRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SetDeniedLocationPermission get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.permissionRepositoryProvider.get());
    }

    public static SetDeniedLocationPermission_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PermissionRepository> provider3) {
        return new SetDeniedLocationPermission_Factory(provider, provider2, provider3);
    }

    public static SetDeniedLocationPermission newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PermissionRepository permissionRepository) {
        return new SetDeniedLocationPermission(threadExecutor, postExecutionThread, permissionRepository);
    }
}
