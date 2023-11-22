package id.dana.data.nearbyplaces.repository.source.network;

import id.dana.data.constant.DanaUrl;
import id.dana.data.nearbyplaces.repository.source.network.result.PlaceDetailResult;
import id.dana.data.nearbyplaces.repository.source.network.result.PlaceSearchListResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013JQ\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/NearbyPlacesApi;", "", "", "keyword", "location", "origin", "", "radius", "sessionToken", "key", "Lio/reactivex/Observable;", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceSearchListResult;", "findPlaces", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "placeId", "fields", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceDetailResult;", "getPlaceDetail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NearbyPlacesApi {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FIELDS = "fields";
    public static final String INPUT = "input";
    public static final String KEY = "key";
    public static final String LOCATION = "location";
    public static final String ORIGIN = "origin";
    public static final String PLACE_ID = "place_id";
    public static final String RADIUS = "radius";
    public static final String SESSION_TOKEN = "sessiontoken";

    @GET("place/autocomplete/json?strictbounds")
    Observable<PlaceSearchListResult> findPlaces(@Query("input") String keyword, @Query("location") String location, @Query("origin") String origin, @Query("radius") int radius, @Query("sessiontoken") String sessionToken, @Query("key") String key);

    @GET(DanaUrl.PLACE_DETAIL)
    Observable<PlaceDetailResult> getPlaceDetail(@Query("place_id") String placeId, @Query("fields") String fields, @Query("sessiontoken") String sessionToken, @Query("key") String key);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/NearbyPlacesApi$Companion;", "", "", "FIELDS", "Ljava/lang/String;", "INPUT", "KEY", "LOCATION", "ORIGIN", "PLACE_ID", "RADIUS", "SESSION_TOKEN", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String FIELDS = "fields";
        public static final String INPUT = "input";
        public static final String KEY = "key";
        public static final String LOCATION = "location";
        public static final String ORIGIN = "origin";
        public static final String PLACE_ID = "place_id";
        public static final String RADIUS = "radius";
        public static final String SESSION_TOKEN = "sessiontoken";

        private Companion() {
        }
    }
}
