package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMissionSummary_Factory implements Factory<GetMissionSummary> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoQuestRepository> promoQuestRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetMissionSummary_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promoQuestRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetMissionSummary get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promoQuestRepositoryProvider.get());
    }

    public static GetMissionSummary_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        return new GetMissionSummary_Factory(provider, provider2, provider3);
    }

    public static GetMissionSummary newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        return new GetMissionSummary(threadExecutor, postExecutionThread, promoQuestRepository);
    }
}
