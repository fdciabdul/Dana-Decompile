package fsimpl;

import com.alipay.griver.ccdn.CCDNH5CacheManager;
import com.fullstory.rust.RustInterface;
import java.net.HttpURLConnection;

/* renamed from: fsimpl.bs  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0268bs {

    /* renamed from: a  reason: collision with root package name */
    private final RustInterface f7895a;
    private boolean b;

    public C0268bs(RustInterface rustInterface) {
        this.f7895a = rustInterface;
    }

    private static long a(HttpURLConnection httpURLConnection) {
        String requestProperty = httpURLConnection.getRequestProperty(CCDNH5CacheManager.CONTENT_LENGTH);
        if (requestProperty != null) {
            return Long.parseLong(requestProperty);
        }
        return 0L;
    }

    private Object a(HttpURLConnection httpURLConnection, Object obj, long j) {
        int responseCode;
        try {
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable unused) {
        }
        if (responseCode == -1) {
            return obj;
        }
        this.b = true;
        if (C0256bg.d()) {
            this.f7895a.a(new C0342em(httpURLConnection.getURL().toString(), httpURLConnection.getRequestMethod(), eU.a(j), responseCode, a(httpURLConnection), httpURLConnection.getContentLengthLong(), b(httpURLConnection)));
            return obj;
        }
        return obj;
    }

    private static int b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Android-Response-Source");
        return (headerField == null || !headerField.startsWith("CACHE")) ? 1 : 2;
    }

    public Object a(HttpURLConnection httpURLConnection, InterfaceC0269bt interfaceC0269bt) {
        if (this.b) {
            return interfaceC0269bt.get();
        }
        return a(httpURLConnection, interfaceC0269bt.get(), System.nanoTime());
    }

    public Object a(HttpURLConnection httpURLConnection, InterfaceC0270bu interfaceC0270bu) {
        if (this.b) {
            return interfaceC0270bu.get();
        }
        return a(httpURLConnection, interfaceC0270bu.get(), System.nanoTime());
    }
}
