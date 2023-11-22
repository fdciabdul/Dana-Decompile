package id.dana.domain.userprofileinfo;

import id.dana.domain.userprofileinfo.response.UserProfileInfoResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserProfileInfoRepository {
    Observable<UserProfileInfoResponse> updateNicknameProfile(String str);

    Observable<UserProfileInfoResponse> updateUserProfileInfo(String str);
}
