package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConfirmSendMoneyContact_Factory implements Factory<ConfirmSendMoneyContact> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ConfirmSendMoneyContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.sendMoneyRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ConfirmSendMoneyContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static ConfirmSendMoneyContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        return new ConfirmSendMoneyContact_Factory(provider, provider2, provider3);
    }

    public static ConfirmSendMoneyContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        return new ConfirmSendMoneyContact(threadExecutor, postExecutionThread, sendMoneyRepository);
    }
}
