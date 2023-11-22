package id.dana.domain.userprofileinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UpdateProfileInfo_Factory implements Factory<UpdateProfileInfo> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserProfileInfoRepository> userProfileInfoRepositoryProvider;

    public UpdateProfileInfo_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserProfileInfoRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userProfileInfoRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final UpdateProfileInfo get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userProfileInfoRepositoryProvider.get());
    }

    public static UpdateProfileInfo_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserProfileInfoRepository> provider3) {
        return new UpdateProfileInfo_Factory(provider, provider2, provider3);
    }

    public static UpdateProfileInfo newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserProfileInfoRepository userProfileInfoRepository) {
        return new UpdateProfileInfo(threadExecutor, postExecutionThread, userProfileInfoRepository);
    }
}
