package a.a.a.a.a;

import id.co.bri.brizzi.hostService.HostUtil;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/* loaded from: classes6.dex */
public interface a {
    @POST(HostUtil.c)
    Call<ResponseBody> BuiltInFictitiousFunctionClassFactory(@Body String str, @HeaderMap Map<String, String> map);

    @POST(HostUtil.d)
    Call<ResponseBody> KClassImpl$Data$declaredNonStaticMembers$2(@Body String str, @HeaderMap Map<String, String> map);

    @POST(HostUtil.b)
    Call<ResponseBody> MyBillsEntityDataFactory(@Body String str, @HeaderMap Map<String, String> map);
}
