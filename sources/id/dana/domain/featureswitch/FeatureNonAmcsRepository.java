package id.dana.domain.featureswitch;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface FeatureNonAmcsRepository {
    Observable<Boolean> isFeatureNonAMCS(String str);
}
