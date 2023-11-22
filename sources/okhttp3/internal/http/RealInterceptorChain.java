package okhttp3.internal.http;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

/* loaded from: classes6.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final HttpCodec httpCodec;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = i;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Connection connection() {
        return this.connection;
    }

    @Override // okhttp3.Interceptor.Chain
    public final int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public final int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, i, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public final int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, i, timeUnit));
    }

    public final StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public final HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Call call() {
        return this.call;
    }

    public final EventListener eventListener() {
        return this.eventListener;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Response proceed(Request request) throws IOException {
        return proceed(request, this.streamAllocation, this.httpCodec, this.connection);
    }

    public final Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        if (this.httpCodec != null && !this.connection.supportsUrl(request.url())) {
            StringBuilder sb = new StringBuilder();
            sb.append("network interceptor ");
            sb.append(this.interceptors.get(this.index - 1));
            sb.append(" must retain the same host and port");
            throw new IllegalStateException(sb.toString());
        } else if (this.httpCodec != null && this.calls > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("network interceptor ");
            sb2.append(this.interceptors.get(this.index - 1));
            sb2.append(" must call proceed() exactly once");
            throw new IllegalStateException(sb2.toString());
        } else {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpCodec, realConnection, this.index + 1, request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(realInterceptorChain);
            if (httpCodec != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("network interceptor ");
                sb3.append(interceptor);
                sb3.append(" must call proceed() exactly once");
                throw new IllegalStateException(sb3.toString());
            } else if (intercept == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("interceptor ");
                sb4.append(interceptor);
                sb4.append(" returned null");
                throw new NullPointerException(sb4.toString());
            } else if (intercept.body() != null) {
                return intercept;
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("interceptor ");
                sb5.append(interceptor);
                sb5.append(" returned a response with no body");
                throw new IllegalStateException(sb5.toString());
            }
        }
    }
}
