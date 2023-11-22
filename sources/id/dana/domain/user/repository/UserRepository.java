package id.dana.domain.user.repository;

import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.user.MiniProgramUserInfoResponse;
import id.dana.domain.user.UserInfoResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;

/* loaded from: classes2.dex */
public interface UserRepository {
    Observable<Map<String, String>> checkUserInfo(String str, String str2, String str3);

    Observable<Boolean> checkUserInfoCacheExpired(String str);

    Observable<CurrencyAmount> getBalance();

    Observable<DanaHomeBalanceConfigModel> getDanaHomeBalanceConfig();

    Observable<UserInfoResponse> getFaceAuthInfo(boolean z);

    Observable<String> getHomeLandmarkUrl(String str);

    Observable<MiniProgramUserInfoResponse> getMiniProgramUserInfo(String str, String str2);

    Observable<CurrencyAmount> getSingleBalance(boolean z);

    Observable<Unit> getUserCohort();

    Observable<UserInfoResponse> getUserInfo(boolean z);

    Observable<UserInfoResponse> getUserInfoForKyb(boolean z);

    Observable<UserInfoResponse> getUserInfoWithKyc(boolean z);

    Observable<UserInfoResponse> getUserInfoWithUserPan();

    Observable<UserInfoResponse> getUserInfoWithUserPanForCPM();

    Observable<UserInfoResponse> getUserStatusInfo(boolean z);

    Observable<Boolean> isHomePersonalizedEnable();
}
