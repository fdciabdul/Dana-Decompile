package id.dana.data.uploadfiles;

import com.alibaba.ariver.permission.PermissionConstant;
import id.dana.data.uploadfiles.model.PresignedUrlRequest;
import id.dana.data.uploadfiles.model.PresignedUrlResponse;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\tH'¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/uploadfiles/UploadFilesApi;", "", "Lid/dana/data/uploadfiles/model/PresignedUrlRequest;", "request", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/uploadfiles/model/PresignedUrlResponse;", "getPresignedUrl", "(Lid/dana/data/uploadfiles/model/PresignedUrlRequest;)Lio/reactivex/Observable;", "", "url", "Lokhttp3/RequestBody;", "body", InvoiceConstant.HEADER, "Lretrofit2/Response;", "Ljava/lang/Void;", PermissionConstant.UPLOAD_FILE, "(Ljava/lang/String;Lokhttp3/RequestBody;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UploadFilesApi {
    @POST("/h/alipayplus.home.upload.generatePresignedUrl.json")
    Observable<ResultResponse<PresignedUrlResponse>> getPresignedUrl(@Body PresignedUrlRequest request);

    @PUT
    Observable<Response<Void>> uploadFile(@Url String url, @Body RequestBody body, @Header("Content-type") String header);
}
