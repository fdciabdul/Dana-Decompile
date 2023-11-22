package id.dana.data.storage;

import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000b\u0010\u0005J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u000eJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/storage/GeneralPreferencesData;", "", "Lio/reactivex/Observable;", "", "getIsSessionChecked", "()Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "getLoginRegisterConfigResult", "()Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "getRegistrationTokenStatus", "isAppFirstLaunch", "isLocationPermissionDenied", "isSessionChecked", "saveIsSessionChecked", "(Z)Lio/reactivex/Observable;", "loginRegisterConfigResult", "saveLoginRegisterConfigResult", "(Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;)Lio/reactivex/Observable;", "status", "saveTokenRegistrationStatus", "isDeniedAndNeverAskAgain", "setLocationPermissionDenied"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeneralPreferencesData {
    Observable<Boolean> getIsSessionChecked();

    LoginRegisterConfigResult getLoginRegisterConfigResult();

    Observable<Boolean> getRegistrationTokenStatus();

    Observable<Boolean> isAppFirstLaunch();

    Observable<Boolean> isLocationPermissionDenied();

    Observable<Boolean> saveIsSessionChecked(boolean isSessionChecked);

    Observable<LoginRegisterConfigResult> saveLoginRegisterConfigResult(LoginRegisterConfigResult loginRegisterConfigResult);

    Observable<Boolean> saveTokenRegistrationStatus(boolean status);

    Observable<Boolean> setLocationPermissionDenied(boolean isDeniedAndNeverAskAgain);
}
