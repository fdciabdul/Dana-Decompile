package id.dana.domain.login.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/VerifyPushLogin;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/VerifyPushLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/login/interactor/VerifyPushLogin$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPushLogin extends UseCase<LoginResponse, Params> {
    private final LoginRepository loginRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public VerifyPushLogin(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, LoginRepository loginRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<LoginResponse> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<LoginResponse> verifyPushLogin = this.loginRepository.verifyPushLogin(params.getVerifyAnswer(), params.getLoginType(), params.getRetryTreshold(), params.getHitApiDelayTime());
        Intrinsics.checkNotNullExpressionValue(verifyPushLogin, "");
        return verifyPushLogin;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/domain/login/interactor/VerifyPushLogin$Params;", "", "", "hitApiDelayTime", "I", "getHitApiDelayTime", "()I", "", "loginType", "Ljava/lang/String;", "getLoginType", "()Ljava/lang/String;", "retryTreshold", "getRetryTreshold", "verifyAnswer", "getVerifyAnswer", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final int hitApiDelayTime;
        private final String loginType;
        private final int retryTreshold;
        private final String verifyAnswer;

        public Params(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.verifyAnswer = str;
            this.loginType = str2;
            this.retryTreshold = i;
            this.hitApiDelayTime = i2;
        }

        @JvmName(name = "getVerifyAnswer")
        public final String getVerifyAnswer() {
            return this.verifyAnswer;
        }

        @JvmName(name = "getLoginType")
        public final String getLoginType() {
            return this.loginType;
        }

        @JvmName(name = "getRetryTreshold")
        public final int getRetryTreshold() {
            return this.retryTreshold;
        }

        @JvmName(name = "getHitApiDelayTime")
        public final int getHitApiDelayTime() {
            return this.hitApiDelayTime;
        }
    }
}
