package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemMission_Factory implements Factory<RedeemMission> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoQuestRepository> questRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public RedeemMission_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.questRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RedeemMission get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.questRepositoryProvider.get());
    }

    public static RedeemMission_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        return new RedeemMission_Factory(provider, provider2, provider3);
    }

    public static RedeemMission newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        return new RedeemMission(threadExecutor, postExecutionThread, promoQuestRepository);
    }
}
