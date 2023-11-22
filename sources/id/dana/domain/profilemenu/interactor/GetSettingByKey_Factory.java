package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSettingByKey_Factory implements Factory<GetSettingByKey> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SettingRepository> settingRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetSettingByKey_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SettingRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.settingRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSettingByKey get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.settingRepositoryProvider.get());
    }

    public static GetSettingByKey_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SettingRepository> provider3) {
        return new GetSettingByKey_Factory(provider, provider2, provider3);
    }

    public static GetSettingByKey newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SettingRepository settingRepository) {
        return new GetSettingByKey(threadExecutor, postExecutionThread, settingRepository);
    }
}
