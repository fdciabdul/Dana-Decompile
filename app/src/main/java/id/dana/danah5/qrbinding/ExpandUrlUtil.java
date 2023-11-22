package id.dana.danah5.qrbinding;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danah5/qrbinding/ExpandUrlUtil;", "", "Ljava/net/URL;", "url", BridgeDSL.INVOKE, "(Ljava/net/URL;)Ljava/net/URL;", "", "DEFAULT_CONNECT_TIMEOUT", "I", "DEFAULT_READ_TIMEOUT", "", "HEADER_LOCATION", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExpandUrlUtil {
    private static final int DEFAULT_CONNECT_TIMEOUT = 1000;
    private static final int DEFAULT_READ_TIMEOUT = 1000;
    private static final String HEADER_LOCATION = "Location";
    public static final ExpandUrlUtil INSTANCE = new ExpandUrlUtil();

    private ExpandUrlUtil() {
    }

    public final URL invoke(URL url) {
        Intrinsics.checkNotNullParameter(url, "");
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(Proxy.NO_PROXY));
        if (uRLConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(1000);
        httpURLConnection.connect();
        String headerField = httpURLConnection.getHeaderField("Location");
        String str = headerField;
        return !(str == null || str.length() == 0) ? new URL(headerField) : url;
    }
}
