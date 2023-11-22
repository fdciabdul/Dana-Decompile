package id.dana.domain.geofence;

import id.dana.domain.geofence.model.Poi;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/geofence/GeoFenceRepository;", "", "Lio/reactivex/Observable;", "", "getCurrentPOICacheTime", "()Lio/reactivex/Observable;", "", "location", "", "Lid/dana/domain/geofence/model/Poi;", "getListPoi", "(Ljava/lang/String;)Lio/reactivex/Observable;", "poiIds", "", "notifyPOIs", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "maxRetry", "setRetryInterval", "(I)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeoFenceRepository {
    Observable<Long> getCurrentPOICacheTime();

    Observable<List<Poi>> getListPoi(String location);

    Observable<Boolean> notifyPOIs(List<String> poiIds);

    Observable<Boolean> setRetryInterval(int maxRetry);
}
