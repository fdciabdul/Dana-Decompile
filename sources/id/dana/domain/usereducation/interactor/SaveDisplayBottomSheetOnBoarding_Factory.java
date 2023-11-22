package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDisplayBottomSheetOnBoarding_Factory implements Factory<SaveDisplayBottomSheetOnBoarding> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public SaveDisplayBottomSheetOnBoarding_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserEducationRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userEducationRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SaveDisplayBottomSheetOnBoarding get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userEducationRepositoryProvider.get());
    }

    public static SaveDisplayBottomSheetOnBoarding_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserEducationRepository> provider3) {
        return new SaveDisplayBottomSheetOnBoarding_Factory(provider, provider2, provider3);
    }

    public static SaveDisplayBottomSheetOnBoarding newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserEducationRepository userEducationRepository) {
        return new SaveDisplayBottomSheetOnBoarding(threadExecutor, postExecutionThread, userEducationRepository);
    }
}
