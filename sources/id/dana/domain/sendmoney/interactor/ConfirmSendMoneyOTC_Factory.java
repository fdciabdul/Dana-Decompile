package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConfirmSendMoneyOTC_Factory implements Factory<ConfirmSendMoneyOTC> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ConfirmSendMoneyOTC_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.sendMoneyRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ConfirmSendMoneyOTC get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static ConfirmSendMoneyOTC_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        return new ConfirmSendMoneyOTC_Factory(provider, provider2, provider3);
    }

    public static ConfirmSendMoneyOTC newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        return new ConfirmSendMoneyOTC(threadExecutor, postExecutionThread, sendMoneyRepository);
    }
}
