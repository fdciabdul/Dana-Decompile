package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemQuest_Factory implements Factory<RedeemQuest> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoQuestRepository> questRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public RedeemQuest_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.questRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RedeemQuest get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.questRepositoryProvider.get());
    }

    public static RedeemQuest_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        return new RedeemQuest_Factory(provider, provider2, provider3);
    }

    public static RedeemQuest newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        return new RedeemQuest(threadExecutor, postExecutionThread, promoQuestRepository);
    }
}
