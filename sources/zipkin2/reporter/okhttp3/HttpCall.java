package zipkin2.reporter.okhttp3;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import zipkin2.Call;
import zipkin2.Callback;

/* loaded from: classes6.dex */
final class HttpCall extends Call<Void> {
    final okhttp3.Call MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCall(okhttp3.Call call) {
        this.MyBillsEntityDataFactory = call;
    }

    @Override // zipkin2.Call
    public final void getAuthRequestContext(Callback<Void> callback) {
        FirebasePerfOkHttpClient.enqueue(this.MyBillsEntityDataFactory, new V2CallbackAdapter(callback));
    }

    /* loaded from: classes6.dex */
    static class V2CallbackAdapter<V> implements okhttp3.Callback {
        final Callback<V> PlaceComponentResult;

        V2CallbackAdapter(Callback<V> callback) {
            this.PlaceComponentResult = callback;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, IOException iOException) {
            this.PlaceComponentResult.onError(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, Response response) {
            try {
                HttpCall.getAuthRequestContext(response);
                this.PlaceComponentResult.onSuccess(null);
            } catch (Throwable th) {
                Call.KClassImpl$Data$declaredNonStaticMembers$2(th);
                this.PlaceComponentResult.onError(th);
            }
        }
    }

    static void getAuthRequestContext(Response response) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            if (response.isSuccessful()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("response failed: ");
            sb.append(response);
            throw new RuntimeException(sb.toString());
        }
        try {
            BufferedSource source = body.source();
            if (HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP.equalsIgnoreCase(response.header("Content-Encoding"))) {
                source = Okio.KClassImpl$Data$declaredNonStaticMembers$2(new GzipSource(body.source()));
            }
            if (response.isSuccessful()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("response for ");
            sb2.append(response.request().tag());
            sb2.append(" failed: ");
            sb2.append(source.FragmentBottomSheetPaymentSettingBinding());
            throw new RuntimeException(sb2.toString());
        } finally {
            body.close();
        }
    }

    @Override // zipkin2.Call
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new HttpCall(this.MyBillsEntityDataFactory.clone());
    }

    @Override // zipkin2.Call
    /* renamed from: MyBillsEntityDataFactory */
    public final /* synthetic */ Call<Void> clone() {
        return new HttpCall(this.MyBillsEntityDataFactory.clone());
    }

    @Override // zipkin2.Call
    public final /* synthetic */ Void PlaceComponentResult() throws IOException {
        getAuthRequestContext(FirebasePerfOkHttpClient.execute(this.MyBillsEntityDataFactory));
        return null;
    }
}
