package id.dana.domain.usersecurityquestions.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSecurityQuestionState_Factory implements Factory<GetSecurityQuestionState> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;
    private final Provider<UserSecurityQuestionStateRepository> userSecurityQuestionStateRepositoryProvider;

    public GetSecurityQuestionState_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserSecurityQuestionStateRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.userSecurityQuestionStateRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSecurityQuestionState get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.userSecurityQuestionStateRepositoryProvider.get());
    }

    public static GetSecurityQuestionState_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<UserSecurityQuestionStateRepository> provider3) {
        return new GetSecurityQuestionState_Factory(provider, provider2, provider3);
    }

    public static GetSecurityQuestionState newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserSecurityQuestionStateRepository userSecurityQuestionStateRepository) {
        return new GetSecurityQuestionState(threadExecutor, postExecutionThread, userSecurityQuestionStateRepository);
    }
}
