package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSendMoneyContact_Factory implements Factory<InitSendMoneyContact> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public InitSendMoneyContact_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.sendMoneyRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final InitSendMoneyContact get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static InitSendMoneyContact_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        return new InitSendMoneyContact_Factory(provider, provider2, provider3);
    }

    public static InitSendMoneyContact newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        return new InitSendMoneyContact(threadExecutor, postExecutionThread, sendMoneyRepository);
    }
}
