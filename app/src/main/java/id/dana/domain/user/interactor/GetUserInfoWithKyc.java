package id.dana.domain.user.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetUserInfoWithKyc extends UseCase<UserInfoResponse, Params> {
    private final UserRepository userRepository;

    @Inject
    public GetUserInfoWithKyc(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<UserInfoResponse> buildUseCaseObservable(Params params) {
        if (params == null) {
            params = new Params(true);
        }
        return this.userRepository.getUserInfoWithKyc(params.needBackendUpdate).map(new Function() { // from class: id.dana.domain.user.interactor.GetUserInfoWithKyc$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetUserInfoWithKyc.lambda$buildUseCaseObservable$0((UserInfoResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserInfoResponse lambda$buildUseCaseObservable$0(UserInfoResponse userInfoResponse) throws Exception {
        if (userInfoResponse != null) {
            return userInfoResponse;
        }
        throw new Exception("UserInfo is null");
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final boolean needBackendUpdate;

        private Params(boolean z) {
            this.needBackendUpdate = z;
        }

        public static Params forParams(boolean z) {
            return new Params(z);
        }
    }
}
