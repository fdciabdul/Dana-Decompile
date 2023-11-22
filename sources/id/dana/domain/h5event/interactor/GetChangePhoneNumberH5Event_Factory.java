package id.dana.domain.h5event.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.h5event.ChangePhoneNumberH5EventRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetChangePhoneNumberH5Event_Factory implements Factory<GetChangePhoneNumberH5Event> {
    private final Provider<ChangePhoneNumberH5EventRepository> changePhoneNumberH5EventRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public GetChangePhoneNumberH5Event_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ChangePhoneNumberH5EventRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.changePhoneNumberH5EventRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final GetChangePhoneNumberH5Event get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.changePhoneNumberH5EventRepositoryProvider.get());
    }

    public static GetChangePhoneNumberH5Event_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ChangePhoneNumberH5EventRepository> provider3) {
        return new GetChangePhoneNumberH5Event_Factory(provider, provider2, provider3);
    }

    public static GetChangePhoneNumberH5Event newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ChangePhoneNumberH5EventRepository changePhoneNumberH5EventRepository) {
        return new GetChangePhoneNumberH5Event(threadExecutor, postExecutionThread, changePhoneNumberH5EventRepository);
    }
}
