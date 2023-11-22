package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConfirmSendMoneyBank_Factory implements Factory<ConfirmSendMoneyBank> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SendMoneyRepository> repositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ConfirmSendMoneyBank_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.repositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ConfirmSendMoneyBank get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.repositoryProvider.get());
    }

    public static ConfirmSendMoneyBank_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        return new ConfirmSendMoneyBank_Factory(provider, provider2, provider3);
    }

    public static ConfirmSendMoneyBank newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        return new ConfirmSendMoneyBank(threadExecutor, postExecutionThread, sendMoneyRepository);
    }
}
