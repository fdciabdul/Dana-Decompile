package id.dana.lib.gcontainer.app.bridge.downloadfile.network;

import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/RetrofitService;", "", "", "fileUrl", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "downloadFile", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public interface RetrofitService {
    @Streaming
    @GET
    Observable<Response<ResponseBody>> downloadFile(@Url String fileUrl);
}
