package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReadDeepLinkProperties_Factory implements Factory<ReadDeepLinkProperties> {
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public ReadDeepLinkProperties_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReadDeepLinkProperties get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get());
    }

    public static ReadDeepLinkProperties_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2) {
        return new ReadDeepLinkProperties_Factory(provider, provider2);
    }

    public static ReadDeepLinkProperties newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new ReadDeepLinkProperties(threadExecutor, postExecutionThread);
    }
}
