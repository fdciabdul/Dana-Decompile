package id.dana.domain.permission;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PermissionRepository {
    Observable<Boolean> checkDeniedLocationPermission();

    Observable<Boolean> setDeniedLocationPermission(Boolean bool);
}
