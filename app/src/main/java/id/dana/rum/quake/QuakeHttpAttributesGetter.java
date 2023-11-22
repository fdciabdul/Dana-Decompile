package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/rum/quake/QuakeHttpAttributesGetter;", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpClientAttributesGetter;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuakeHttpAttributesGetter implements HttpClientAttributesGetter<Request, NetworkResponse> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    public final /* synthetic */ String flavor(Request request, NetworkResponse networkResponse) {
        Intrinsics.checkNotNullParameter(request, "");
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final /* synthetic */ String method(Object obj) {
        Intrinsics.checkNotNullParameter((Request) obj, "");
        return "POST";
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final /* synthetic */ List requestHeader(Object obj, String str) {
        String str2;
        Request request = (Request) obj;
        ArrayList arrayList = new ArrayList();
        Map<String, String> externalInfo = request != null ? request.getExternalInfo() : null;
        if (externalInfo != null && (str2 = externalInfo.get(str)) != null) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final /* synthetic */ List responseHeader(Object obj, Object obj2, String str) {
        String str2;
        String str3;
        Request request = (Request) obj;
        NetworkResponse networkResponse = (NetworkResponse) obj2;
        ArrayList arrayList = new ArrayList();
        Map<String, String> externalInfo = request != null ? request.getExternalInfo() : null;
        Map<String, String> map = networkResponse != null ? networkResponse.extData : null;
        if (externalInfo != null && (str3 = externalInfo.get(str)) != null) {
            arrayList.add(str3);
        }
        if (map != null && (str2 = map.get(str)) != null) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter
    public final /* synthetic */ Integer statusCode(Object obj, Object obj2, Throwable th) {
        Request request = (Request) obj;
        NetworkResponse networkResponse = (NetworkResponse) obj2;
        if (networkResponse != null) {
            return Integer.valueOf(networkResponse.statusCode);
        }
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesGetter
    public final /* synthetic */ String url(Request request) {
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(request2.getUrl());
        sb.append('#');
        sb.append(request2.getActionType());
        return sb.toString();
    }
}
