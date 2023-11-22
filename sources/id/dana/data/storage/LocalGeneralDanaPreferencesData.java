package id.dana.data.storage;

import dagger.Lazy;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/data/storage/LocalGeneralDanaPreferencesData;", "Lid/dana/data/storage/GeneralPreferencesData;", "Lio/reactivex/Observable;", "", "getIsSessionChecked", "()Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "getLoginRegisterConfigResult", "()Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "getRegistrationTokenStatus", "isAppFirstLaunch", "isLocationPermissionDenied", "isSessionChecked", "saveIsSessionChecked", "(Z)Lio/reactivex/Observable;", "loginRegisterConfigResult", "saveLoginRegisterConfigResult", "(Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;)Lio/reactivex/Observable;", "status", "saveTokenRegistrationStatus", "isDeniedAndNeverAskAgain", "setLocationPermissionDenied", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalGeneralDanaPreferencesData implements GeneralPreferencesData {
    private final Lazy<GeneralPreferences> generalPreferences;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveLoginRegisterConfigResult$lambda-6  reason: not valid java name */
    public static final LoginRegisterConfigResult m2064saveLoginRegisterConfigResult$lambda6(LoginRegisterConfigResult loginRegisterConfigResult, Unit unit) {
        Intrinsics.checkNotNullParameter(loginRegisterConfigResult, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return loginRegisterConfigResult;
    }

    @Inject
    public LocalGeneralDanaPreferencesData(Lazy<GeneralPreferences> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.generalPreferences = lazy;
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> saveTokenRegistrationStatus(final boolean status) {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2065saveTokenRegistrationStatus$lambda0;
                m2065saveTokenRegistrationStatus$lambda0 = LocalGeneralDanaPreferencesData.m2065saveTokenRegistrationStatus$lambda0(LocalGeneralDanaPreferencesData.this, status);
                return m2065saveTokenRegistrationStatus$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveTokenRegistrationStatus$lambda-0  reason: not valid java name */
    public static final Boolean m2065saveTokenRegistrationStatus$lambda0(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData, boolean z) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData.generalPreferences.get().saveNotificationRegistrationToken(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRegistrationTokenStatus$lambda-1  reason: not valid java name */
    public static final Boolean m2059getRegistrationTokenStatus$lambda1(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData.generalPreferences.get().getNotificationRegistrationToken();
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> getRegistrationTokenStatus() {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2059getRegistrationTokenStatus$lambda1;
                m2059getRegistrationTokenStatus$lambda1 = LocalGeneralDanaPreferencesData.m2059getRegistrationTokenStatus$lambda1(LocalGeneralDanaPreferencesData.this);
                return m2059getRegistrationTokenStatus$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isLocationPermissionDenied$lambda-2  reason: not valid java name */
    public static final Boolean m2061isLocationPermissionDenied$lambda2(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData.generalPreferences.get().isLocationPermissionDenied();
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> isLocationPermissionDenied() {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2061isLocationPermissionDenied$lambda2;
                m2061isLocationPermissionDenied$lambda2 = LocalGeneralDanaPreferencesData.m2061isLocationPermissionDenied$lambda2(LocalGeneralDanaPreferencesData.this);
                return m2061isLocationPermissionDenied$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> setLocationPermissionDenied(final boolean isDeniedAndNeverAskAgain) {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2066setLocationPermissionDenied$lambda3;
                m2066setLocationPermissionDenied$lambda3 = LocalGeneralDanaPreferencesData.m2066setLocationPermissionDenied$lambda3(LocalGeneralDanaPreferencesData.this, isDeniedAndNeverAskAgain);
                return m2066setLocationPermissionDenied$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setLocationPermissionDenied$lambda-3  reason: not valid java name */
    public static final Boolean m2066setLocationPermissionDenied$lambda3(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData, boolean z) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData.generalPreferences.get().setLocationPermissionDenied(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isAppFirstLaunch$lambda-4  reason: not valid java name */
    public static final Boolean m2060isAppFirstLaunch$lambda4(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return Boolean.valueOf(localGeneralDanaPreferencesData.generalPreferences.get().isAppFirstLaunch());
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> isAppFirstLaunch() {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2060isAppFirstLaunch$lambda4;
                m2060isAppFirstLaunch$lambda4 = LocalGeneralDanaPreferencesData.m2060isAppFirstLaunch$lambda4(LocalGeneralDanaPreferencesData.this);
                return m2060isAppFirstLaunch$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<LoginRegisterConfigResult> saveLoginRegisterConfigResult(final LoginRegisterConfigResult loginRegisterConfigResult) {
        Intrinsics.checkNotNullParameter(loginRegisterConfigResult, "");
        Observable<LoginRegisterConfigResult> map = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m2063saveLoginRegisterConfigResult$lambda5;
                m2063saveLoginRegisterConfigResult$lambda5 = LocalGeneralDanaPreferencesData.m2063saveLoginRegisterConfigResult$lambda5(LocalGeneralDanaPreferencesData.this, loginRegisterConfigResult);
                return m2063saveLoginRegisterConfigResult$lambda5;
            }
        }).map(new Function() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                LoginRegisterConfigResult m2064saveLoginRegisterConfigResult$lambda6;
                m2064saveLoginRegisterConfigResult$lambda6 = LocalGeneralDanaPreferencesData.m2064saveLoginRegisterConfigResult$lambda6(LoginRegisterConfigResult.this, (Unit) obj);
                return m2064saveLoginRegisterConfigResult$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveLoginRegisterConfigResult$lambda-5  reason: not valid java name */
    public static final Unit m2063saveLoginRegisterConfigResult$lambda5(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData, LoginRegisterConfigResult loginRegisterConfigResult) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        Intrinsics.checkNotNullParameter(loginRegisterConfigResult, "");
        localGeneralDanaPreferencesData.generalPreferences.get().saveLoginRegisterConfigResult(loginRegisterConfigResult);
        return Unit.INSTANCE;
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final LoginRegisterConfigResult getLoginRegisterConfigResult() {
        LoginRegisterConfigResult loginRegisterConfigResult = this.generalPreferences.get().getLoginRegisterConfigResult();
        return loginRegisterConfigResult == null ? new LoginRegisterConfigResult(null, null, null, 7, null) : loginRegisterConfigResult;
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> saveIsSessionChecked(final boolean isSessionChecked) {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2062saveIsSessionChecked$lambda8;
                m2062saveIsSessionChecked$lambda8 = LocalGeneralDanaPreferencesData.m2062saveIsSessionChecked$lambda8(LocalGeneralDanaPreferencesData.this, isSessionChecked);
                return m2062saveIsSessionChecked$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveIsSessionChecked$lambda-8  reason: not valid java name */
    public static final Boolean m2062saveIsSessionChecked$lambda8(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData, boolean z) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        localGeneralDanaPreferencesData.generalPreferences.get().saveIsSessionChecked(Boolean.valueOf(z));
        return Boolean.valueOf(z);
    }

    @Override // id.dana.data.storage.GeneralPreferencesData
    public final Observable<Boolean> getIsSessionChecked() {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.storage.LocalGeneralDanaPreferencesData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m2058getIsSessionChecked$lambda9;
                m2058getIsSessionChecked$lambda9 = LocalGeneralDanaPreferencesData.m2058getIsSessionChecked$lambda9(LocalGeneralDanaPreferencesData.this);
                return m2058getIsSessionChecked$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIsSessionChecked$lambda-9  reason: not valid java name */
    public static final Boolean m2058getIsSessionChecked$lambda9(LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData) {
        Intrinsics.checkNotNullParameter(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData.generalPreferences.get().getIsSessionChecked();
    }
}
