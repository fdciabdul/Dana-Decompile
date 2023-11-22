package id.dana.domain.version;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface VersionRepository {
    Observable<Version> getAppVersion();

    Observable<Integer> getAppVersionCode();

    Observable<Integer> getStorageVersion();

    Observable<Boolean> setAppVersionCode(int i);

    Observable<Boolean> setStorageVersion(int i);
}
