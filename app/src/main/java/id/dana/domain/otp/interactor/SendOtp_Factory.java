package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.otp.OtpRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendOtp_Factory implements Factory<SendOtp> {
    private final Provider<OtpRepository> otpRepositoryProvider;
    private final Provider<PostExecutionThread> postExecutionThreadProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public SendOtp_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OtpRepository> provider3) {
        this.threadExecutorProvider = provider;
        this.postExecutionThreadProvider = provider2;
        this.otpRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final SendOtp get() {
        return newInstance(this.threadExecutorProvider.get(), this.postExecutionThreadProvider.get(), this.otpRepositoryProvider.get());
    }

    public static SendOtp_Factory create(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<OtpRepository> provider3) {
        return new SendOtp_Factory(provider, provider2, provider3);
    }

    public static SendOtp newInstance(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OtpRepository otpRepository) {
        return new SendOtp(threadExecutor, postExecutionThread, otpRepository);
    }
}
