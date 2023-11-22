package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSendMoneyOption_Factory implements Factory<GetSendMoneyOption> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetSendMoneyOption_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.sendMoneyRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSendMoneyOption get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.sendMoneyRepositoryProvider.get());
    }

    public static GetSendMoneyOption_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<SendMoneyRepository> provider3) {
        return new GetSendMoneyOption_Factory(provider, provider2, provider3);
    }

    public static GetSendMoneyOption newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        return new GetSendMoneyOption(threadExecutor, postExecutionThread, sendMoneyRepository);
    }
}
