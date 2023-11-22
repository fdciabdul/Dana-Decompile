package id.dana.data.geocode.repository.source.network;

import id.dana.data.constant.DanaUrl;
import id.dana.data.geocode.model.GeocoderResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/geocode/repository/source/network/GeocoderApi;", "", "", "lat", "key", "Lio/reactivex/Observable;", "Lid/dana/data/geocode/model/GeocoderResult;", "reverseGeocode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeocoderApi {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String PARAM_KEY = "key";
    public static final String PARAM_LATLNG = "latlng";

    @GET(DanaUrl.GEOCODER_API)
    Observable<GeocoderResult> reverseGeocode(@Query("latlng") String lat, @Query("key") String key);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/data/geocode/repository/source/network/GeocoderApi$Companion;", "", "", "PARAM_KEY", "Ljava/lang/String;", "PARAM_LATLNG", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PARAM_KEY = "key";
        public static final String PARAM_LATLNG = "latlng";

        private Companion() {
        }
    }
}
