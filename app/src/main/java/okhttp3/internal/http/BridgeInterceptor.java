package okhttp3.internal.http;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes6.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(com.google.common.net.HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
            } else {
                newBuilder.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header(com.google.common.net.HttpHeaders.HOST) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.CONNECTION, com.google.common.net.HttpHeaders.KEEP_ALIVE);
        }
        if (request.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && request.header(com.google.common.net.HttpHeaders.RANGE) == null) {
            z = true;
            newBuilder.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", cookieHeader(loadForRequest));
        }
        if (request.header(com.google.common.net.HttpHeaders.USER_AGENT) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.USER_AGENT, Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP.equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll(com.google.common.net.HttpHeaders.CONTENT_LENGTH).build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1L, Okio.KClassImpl$Data$declaredNonStaticMembers$2(gzipSource)));
        }
        return request2.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
}
