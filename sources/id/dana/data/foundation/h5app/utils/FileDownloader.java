package id.dana.data.foundation.h5app.utils;

import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.foundation.h5app.utils.network.NetworkApi;
import id.dana.data.foundation.h5app.utils.network.RetrofitNetworkApi;
import id.dana.data.foundation.h5app.utils.network.RetrofitService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes4.dex */
public class FileDownloader {
    public NetworkApi KClassImpl$Data$declaredNonStaticMembers$2;

    public FileDownloader(String str) throws MalformedURLException {
        RetrofitNetworkApi retrofitNetworkApi = new RetrofitNetworkApi();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = retrofitNetworkApi;
        URL url = new URL(str);
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append("://");
        sb.append(url.getHost());
        sb.append("/");
        retrofitNetworkApi.BuiltInFictitiousFunctionClassFactory = url.getPath();
        Retrofit.Builder builder = new Retrofit.Builder();
        String obj = sb.toString();
        Objects.requireNonNull(obj, "baseUrl == null");
        Retrofit.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(obj));
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder2);
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(builder2.build(), "client == null"), "factory == null");
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.add((CallAdapter.Factory) Objects.requireNonNull(RxJava2CallAdapterFactory.KClassImpl$Data$declaredNonStaticMembers$2(), "factory == null"));
        retrofitNetworkApi.PlaceComponentResult = (RetrofitService) BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(RetrofitService.class);
    }
}
