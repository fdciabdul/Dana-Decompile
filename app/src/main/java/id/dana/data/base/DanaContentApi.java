package id.dana.data.base;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/base/DanaContentApi;", "", "", "url", "Lio/reactivex/Observable;", "Lcom/alibaba/fastjson/JSONObject;", "getMerchantCategoriesContent", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DanaContentApi {
    @GET
    Observable<JSONObject> getMerchantCategoriesContent(@Url String url);
}
