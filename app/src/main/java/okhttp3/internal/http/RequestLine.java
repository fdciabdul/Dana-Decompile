package okhttp3.internal.http;

import id.dana.cashier.view.InputCardNumberView;
import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* loaded from: classes6.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(InputCardNumberView.DIVIDER);
        if (includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(encodedPath);
            sb.append('?');
            sb.append(encodedQuery);
            return sb.toString();
        }
        return encodedPath;
    }
}
