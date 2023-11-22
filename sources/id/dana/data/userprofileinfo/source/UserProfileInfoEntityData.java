package id.dana.data.userprofileinfo.source;

import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface UserProfileInfoEntityData {
    Observable<UserProfileInfoResult> updateUserProfileInfo(String str, String str2);
}
