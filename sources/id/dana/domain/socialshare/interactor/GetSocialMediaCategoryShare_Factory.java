package id.dana.domain.socialshare.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetSocialMediaCategoryShare_Factory implements Factory<GetSocialMediaCategoryShare> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetSocialMediaCategoryShare_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetSocialMediaCategoryShare get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.featureConfigRepositoryProvider.get());
    }

    public static GetSocialMediaCategoryShare_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<FeatureConfigRepository> provider3) {
        return new GetSocialMediaCategoryShare_Factory(provider, provider2, provider3);
    }

    public static GetSocialMediaCategoryShare newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        return new GetSocialMediaCategoryShare(threadExecutor, postExecutionThread, featureConfigRepository);
    }
}
