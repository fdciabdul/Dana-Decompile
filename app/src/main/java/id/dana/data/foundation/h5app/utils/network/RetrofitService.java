package id.dana.data.foundation.h5app.utils.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* loaded from: classes4.dex */
public interface RetrofitService {
    @Streaming
    @GET
    Observable<Response<ResponseBody>> PlaceComponentResult(@Url String str);
}
