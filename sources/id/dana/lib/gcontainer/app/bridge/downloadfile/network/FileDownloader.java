package id.dana.lib.gcontainer.app.bridge.downloadfile.network;

import com.alibaba.ariver.engine.api.common.log.IgnoreLogUtils;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/FileDownloader;", "", "Lio/reactivex/Observable;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "downloadFile", "()Lio/reactivex/Observable;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/NetworkApi;", IgnoreLogUtils.TYPE_API, "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/NetworkApi;", "", "url", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class FileDownloader {
    private final NetworkApi api;

    public FileDownloader(String str) {
        RetrofitNetworkApi retrofitNetworkApi = new RetrofitNetworkApi();
        this.api = retrofitNetworkApi;
        retrofitNetworkApi.init(str);
    }

    public final Observable<Response<ResponseBody>> downloadFile() {
        return this.api.downloadImage();
    }
}
