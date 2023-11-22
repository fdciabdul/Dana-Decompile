package com.iap.ac.android.rpc.http.impl;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import com.iap.ac.android.rpc.http.error.HttpError;
import com.iap.ac.android.rpc.http.utils.HttpTransportUtils;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class OkHttpTransport implements AbstractHttpTransport {
    public static final int DEFAULT_TIMEOUT_MS = 30;
    public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static final String TAG = "OkHttpTransport";
    public OkHttpClient client;
    public CookieManager cookieManager;

    /* loaded from: classes3.dex */
    public interface OkHttpTransportFactory {
        public static final OkHttpTransport mInstance = new OkHttpTransport();
    }

    public static void addHeaderAcceptLanguage(Map<String, String> map) {
        if (map.containsKey("Accept-Language")) {
            return;
        }
        map.put("Accept-Language", HttpTransportUtils.getLanguage());
    }

    private void addHeaderCookie(Map<String, String> map, URL url) {
        CookieManager cookieManager = this.cookieManager;
        if (cookieManager == null) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        String cookie = cookieManager.getCookie(url.toString());
        if (TextUtils.isEmpty(cookie)) {
            return;
        }
        map.put("Cookie", cookie);
    }

    public static void addHeaders(Request.Builder builder, Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            builder.header(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public static OkHttpTransport getInstance() {
        return OkHttpTransportFactory.mInstance;
    }

    private boolean hasResponseBody(int i) {
        return (i < 200 || i == 204 || i == 304) ? false : true;
    }

    private void setCookie(HttpResponse httpResponse, String str) {
        if (this.cookieManager == null) {
            ACLog.e(TAG, "cookieManager is null!");
            return;
        }
        Map<String, List<String>> map = httpResponse.headers;
        if (map == null) {
            return;
        }
        List<String> list = map.get("Set-Cookie");
        List<String> list2 = map.get(HttpHeaders.SET_COOKIE2);
        List<String> list3 = map.get("set-cookie");
        List<String> list4 = map.get("set-cookie2");
        HashSet hashSet = new HashSet();
        if (list != null) {
            hashSet.addAll(list);
        }
        if (list2 != null) {
            hashSet.addAll(list2);
        }
        if (list3 != null) {
            hashSet.addAll(list3);
        }
        if (list4 != null) {
            hashSet.addAll(list4);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.cookieManager.setCookie(str, (String) it.next());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.cookieManager.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport
    public HttpResponse performRequest(HttpRequest httpRequest) throws Exception {
        HttpResponse httpResponse;
        if (!TextUtils.isEmpty(httpRequest.url)) {
            Request.Builder url = new Request.Builder().url(httpRequest.url);
            Map<String, String> map = httpRequest.headers;
            if (map == null) {
                map = new HashMap<>();
            }
            addHeaderCookie(map, new URL(httpRequest.url));
            addHeaderAcceptLanguage(map);
            addHeaders(url, map);
            if (httpRequest.method != null) {
                String str = httpRequest.data;
                if (str == null) {
                    str = "";
                }
                Response execute = this.client.newCall(url.method(httpRequest.method.method, RequestBody.create(JSON, str)).build()).execute();
                if (hasResponseBody(execute.code())) {
                    httpResponse = new HttpResponse(execute.code(), execute.message(), execute.body().bytes(), execute.headers().toMultimap());
                } else {
                    httpResponse = new HttpResponse(execute.code(), execute.message(), null, execute.headers().toMultimap());
                }
                setCookie(httpResponse, httpRequest.url);
                return httpResponse;
            }
            throw HttpTransportUtils.createException(HttpError.Unknown, "method is empty!");
        }
        throw HttpTransportUtils.createException(HttpError.UrlIsEmpty, "request url is empty!");
    }

    public OkHttpTransport() {
        this.cookieManager = CookieManager.getInstance();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        this.client = builder.connectTimeout(30L, TimeUnit.SECONDS).protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2))).build();
    }
}
