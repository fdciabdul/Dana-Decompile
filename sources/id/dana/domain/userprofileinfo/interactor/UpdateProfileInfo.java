package id.dana.domain.userprofileinfo.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import id.dana.domain.userprofileinfo.response.UserProfileInfoResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class UpdateProfileInfo extends UseCase<UserProfileInfoResponse, Params> {
    private final UserProfileInfoRepository userProfileInfoRepository;

    @Inject
    public UpdateProfileInfo(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserProfileInfoRepository userProfileInfoRepository) {
        super(threadExecutor, postExecutionThread);
        this.userProfileInfoRepository = userProfileInfoRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<UserProfileInfoResponse> buildUseCaseObservable(Params params) {
        return this.userProfileInfoRepository.updateUserProfileInfo(params.avatarUrl);
    }

    /* loaded from: classes8.dex */
    public static class Params {
        String avatarUrl;
        String nickName;

        private Params(String str, String str2) {
            this.avatarUrl = str;
            this.nickName = str2;
        }

        public static Params forUpdateProfile(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
