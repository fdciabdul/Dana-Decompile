package id.dana.lib.gcontainer.app.bridge.downloadfile.network;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/RetrofitNetworkApi;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/NetworkApi;", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "downloadImage", "()Lio/reactivex/Observable;", "", "url", "", IAPSyncCommand.COMMAND_INIT, "(Ljava/lang/String;)V", "pathString", "Ljava/lang/String;", "getPathString", "()Ljava/lang/String;", "setPathString", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/RetrofitService;", "retrofitService", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/RetrofitService;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class RetrofitNetworkApi implements NetworkApi {
    private String pathString = "";
    private RetrofitService retrofitService;

    @JvmName(name = "getPathString")
    public final String getPathString() {
        return this.pathString;
    }

    @JvmName(name = "setPathString")
    public final void setPathString(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pathString = str;
    }

    public final void init(String url) throws MalformedURLException {
        URL url2 = new URL(url);
        StringBuilder sb = new StringBuilder();
        sb.append(url2.getProtocol());
        sb.append("://");
        sb.append(url2.getHost());
        sb.append("/");
        String path = url2.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        this.pathString = path;
        String query = url2.getQuery();
        if (!(query == null || query.length() == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.pathString);
            sb2.append('?');
            sb2.append((Object) url2.getQuery());
            this.pathString = sb2.toString();
        }
        Retrofit.Builder builder = new Retrofit.Builder();
        String obj = sb.toString();
        Objects.requireNonNull(obj, "baseUrl == null");
        Retrofit.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(obj));
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder2);
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(builder2.build(), "client == null"), "factory == null");
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.add((CallAdapter.Factory) Objects.requireNonNull(RxJava2CallAdapterFactory.KClassImpl$Data$declaredNonStaticMembers$2(), "factory == null"));
        this.retrofitService = (RetrofitService) BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(RetrofitService.class);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.network.NetworkApi
    public final Observable<Response<ResponseBody>> downloadImage() {
        RetrofitService retrofitService = this.retrofitService;
        if (retrofitService == null) {
            return null;
        }
        return retrofitService.downloadFile(this.pathString);
    }
}
