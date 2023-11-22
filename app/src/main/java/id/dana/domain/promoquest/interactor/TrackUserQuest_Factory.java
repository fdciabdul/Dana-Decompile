package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TrackUserQuest_Factory implements Factory<TrackUserQuest> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<PromoQuestRepository> promoQuestRepositoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public TrackUserQuest_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.promoQuestRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final TrackUserQuest get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.promoQuestRepositoryProvider.get());
    }

    public static TrackUserQuest_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<PromoQuestRepository> provider3) {
        return new TrackUserQuest_Factory(provider, provider2, provider3);
    }

    public static TrackUserQuest newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        return new TrackUserQuest(threadExecutor, postExecutionThread, promoQuestRepository);
    }
}
