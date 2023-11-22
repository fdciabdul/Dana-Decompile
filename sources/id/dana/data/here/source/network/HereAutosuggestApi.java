package id.dana.data.here.source.network;

import id.dana.data.here.model.HereAutoCompleteResponse;
import id.dana.data.here.model.HereUrlConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JQ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ[\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/here/source/network/HereAutosuggestApi;", "", "", HereUrlConstant.AT, HereUrlConstant.LANG, HereUrlConstant.LIMIT, HereUrlConstant.QUERY, "in", "authorization", "Lio/reactivex/Observable;", "Lid/dana/data/here/model/HereAutoCompleteResponse;", "autoSuggest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "ontology", "discover", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HereAutosuggestApi {
    @GET("/v1/autosuggest")
    Observable<HereAutoCompleteResponse> autoSuggest(@Query("at") String at2, @Query("lang") String lang, @Query("limit") String limit, @Query("q") String q, @Query("in") String in2, @Header("Authorization") String authorization);

    @GET("/v1/discover")
    Observable<HereAutoCompleteResponse> discover(@Query("at") String at2, @Query("lang") String lang, @Query("_ontology") String ontology, @Query("limit") String limit, @Query("q") String q, @Query("in") String in2, @Header("Authorization") String authorization);
}
