package id.dana.data.here.source.network;

import id.dana.data.here.model.HereGeocodeResponse;
import id.dana.data.here.model.HereUrlConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/here/source/network/HereGeocodeApi;", "", "", HereUrlConstant.AT, HereUrlConstant.LANG, "authorization", "Lio/reactivex/Observable;", "Lid/dana/data/here/model/HereGeocodeResponse;", "geocodeReverse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HereGeocodeApi {
    @GET("/v1/revgeocode")
    Observable<HereGeocodeResponse> geocodeReverse(@Query("at") String at2, @Query("lang") String lang, @Header("Authorization") String authorization);
}
