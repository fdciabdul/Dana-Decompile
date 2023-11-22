package id.dana.domain.h5event.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCheckoutH5Event_Factory implements Factory<GetCheckoutH5Event> {
    private final Provider<H5EventRepository> h5EventRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetCheckoutH5Event_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<H5EventRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.h5EventRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetCheckoutH5Event get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.h5EventRepositoryProvider.get());
    }

    public static GetCheckoutH5Event_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<H5EventRepository> provider3) {
        return new GetCheckoutH5Event_Factory(provider, provider2, provider3);
    }

    public static GetCheckoutH5Event newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, H5EventRepository h5EventRepository) {
        return new GetCheckoutH5Event(threadExecutor, postExecutionThread, h5EventRepository);
    }
}
