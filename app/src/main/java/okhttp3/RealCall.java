package okhttp3;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

/* loaded from: classes6.dex */
public final class RealCall implements Call {
    final OkHttpClient client;
    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: okhttp3.RealCall.1
            {
                RealCall.this = this;
            }

            @Override // okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public final Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public final Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException timeoutExit = timeoutExit(e);
                this.eventListener.callFailed(this, timeoutExit);
                throw timeoutExit;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    @Nullable
    public final IOException timeoutExit(@Nullable IOException iOException) {
        if (this.timeout.exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return iOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    @Override // okhttp3.Call
    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public final void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // okhttp3.Call
    public final Timeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public final boolean isExecuted() {
        boolean z;
        synchronized (this) {
            z = this.executed;
        }
        return z;
    }

    @Override // okhttp3.Call
    public final boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // okhttp3.Call
    public final RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public final StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    /* loaded from: classes6.dex */
    public final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AsyncCall(Callback callback) {
            super("OkHttp %s", r3.redactedUrl());
            RealCall.this = r3;
            this.responseCallback = callback;
        }

        public final String host() {
            return RealCall.this.originalRequest.url().host();
        }

        final Request request() {
            return RealCall.this.originalRequest;
        }

        public final RealCall get() {
            return RealCall.this;
        }

        public final void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        public final void execute() {
            Throwable th;
            IOException e;
            RealCall.this.timeout.enter();
            boolean z = true;
            try {
                try {
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                try {
                    this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                } catch (IOException e3) {
                    e = e3;
                    IOException timeoutExit = RealCall.this.timeoutExit(e);
                    if (!z) {
                        RealCall.this.eventListener.callFailed(RealCall.this, timeoutExit);
                        this.responseCallback.onFailure(RealCall.this, timeoutExit);
                    } else {
                        Platform platform = Platform.get();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Callback failure for ");
                        sb.append(RealCall.this.toLoggableString());
                        platform.log(4, sb.toString(), timeoutExit);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    RealCall.this.cancel();
                    if (!z) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("canceled due to ");
                        sb2.append(th);
                        this.responseCallback.onFailure(RealCall.this, new IOException(sb2.toString()));
                    }
                    throw th;
                }
            } finally {
                RealCall.this.client.dispatcher().finished(this);
            }
        }
    }

    final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    final Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Response proceed = new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (this.retryAndFollowUpInterceptor.isCanceled()) {
            Util.closeQuietly(proceed);
            throw new IOException("Canceled");
        }
        return proceed;
    }
}
