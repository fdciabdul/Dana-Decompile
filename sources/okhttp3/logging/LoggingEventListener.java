package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes9.dex */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    @Override // okhttp3.EventListener
    public final void callStart(Call call) {
        this.startNs = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append("callStart: ");
        sb.append(call.request());
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void dnsStart(Call call, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("dnsStart: ");
        sb.append(str);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void dnsEnd(Call call, String str, List<InetAddress> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("dnsEnd: ");
        sb.append(list);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        StringBuilder sb = new StringBuilder();
        sb.append("connectStart: ");
        sb.append(inetSocketAddress);
        sb.append(" ");
        sb.append(proxy);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void secureConnectStart(Call call) {
        logWithTime("secureConnectStart");
    }

    @Override // okhttp3.EventListener
    public final void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        logWithTime("secureConnectEnd");
    }

    @Override // okhttp3.EventListener
    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        StringBuilder sb = new StringBuilder();
        sb.append("connectEnd: ");
        sb.append(protocol);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        StringBuilder sb = new StringBuilder();
        sb.append("connectFailed: ");
        sb.append(protocol);
        sb.append(" ");
        sb.append(iOException);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void connectionAcquired(Call call, Connection connection) {
        StringBuilder sb = new StringBuilder();
        sb.append("connectionAcquired: ");
        sb.append(connection);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void connectionReleased(Call call, Connection connection) {
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersStart(Call call) {
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public final void requestHeadersEnd(Call call, Request request) {
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public final void requestBodyStart(Call call) {
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public final void requestBodyEnd(Call call, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("requestBodyEnd: byteCount=");
        sb.append(j);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersStart(Call call) {
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public final void responseHeadersEnd(Call call, Response response) {
        StringBuilder sb = new StringBuilder();
        sb.append("responseHeadersEnd: ");
        sb.append(response);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void responseBodyStart(Call call) {
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public final void responseBodyEnd(Call call, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("responseBodyEnd: byteCount=");
        sb.append(j);
        logWithTime(sb.toString());
    }

    @Override // okhttp3.EventListener
    public final void callEnd(Call call) {
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public final void callFailed(Call call, IOException iOException) {
        StringBuilder sb = new StringBuilder();
        sb.append("callFailed: ");
        sb.append(iOException);
        logWithTime(sb.toString());
    }

    private void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(millis);
        sb.append(" ms] ");
        sb.append(str);
        logger.log(sb.toString());
    }

    /* loaded from: classes9.dex */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(HttpLoggingInterceptor.Logger.DEFAULT);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            this.logger = logger;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            return new LoggingEventListener(this.logger);
        }
    }
}
