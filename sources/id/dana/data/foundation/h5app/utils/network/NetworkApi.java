package id.dana.data.foundation.h5app.utils.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes4.dex */
public interface NetworkApi {
    Observable<Response<ResponseBody>> MyBillsEntityDataFactory();
}
