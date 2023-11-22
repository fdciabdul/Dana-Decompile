package id.dana.domain.featureconfig;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface AppGeneralRepository {
    Observable<Boolean> isAppFirstLaunch();
}
