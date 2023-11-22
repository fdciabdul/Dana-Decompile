package com.alipay.a.a.a.a;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public class z implements HttpRequestRetryHandler {

    /* renamed from: a  reason: collision with root package name */
    static final String f6845a = "z";

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        if (i >= 3) {
            return false;
        }
        if (iOException instanceof NoHttpResponseException) {
            InstrumentInjector.log_v(f6845a, "exception instanceof NoHttpResponseException");
            return true;
        } else if (((iOException instanceof SocketException) || (iOException instanceof SSLException)) && iOException.getMessage() != null && iOException.getMessage().contains("Broken pipe")) {
            InstrumentInjector.log_v(f6845a, "exception instanceof SocketException:Broken pipe");
            return true;
        } else {
            return false;
        }
    }
}
