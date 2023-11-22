package io.opentelemetry.instrumentation.okhttp.v3_0;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.instrumentation.api.util.VirtualField;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class TracingCallFactory implements Call.Factory {
    @Nullable
    private static Method cloneMethod;
    private static final VirtualField<Request, Context> contextsByRequest = VirtualField.find(Request.class, Context.class);
    @Nullable
    private static Method timeoutMethod;
    private final OkHttpClient okHttpClient;

    static {
        try {
            timeoutMethod = Call.class.getMethod(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, new Class[0]);
        } catch (NoSuchMethodException unused) {
            timeoutMethod = null;
        }
        try {
            cloneMethod = Call.class.getDeclaredMethod("clone", new Class[0]);
        } catch (NoSuchMethodException unused2) {
            cloneMethod = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingCallFactory(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Context getCallingContextForRequest(Request request) {
        return contextsByRequest.get(request);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        Context current = Context.CC.current();
        Request build = request.newBuilder().build();
        contextsByRequest.set(build, current);
        return new TracingCall(this.okHttpClient.newCall(build), current);
    }

    /* loaded from: classes9.dex */
    static class TracingCall implements Call {
        private final Context callingContext;
        private final Call delegate;

        TracingCall(Call call, Context context) {
            this.delegate = call;
            this.callingContext = context;
        }

        @Override // okhttp3.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // okhttp3.Call
        public Call clone() throws CloneNotSupportedException {
            if (TracingCallFactory.cloneMethod == null) {
                return (Call) super.clone();
            }
            try {
                return new TracingCall((Call) TracingCallFactory.cloneMethod.invoke(this.delegate, new Object[0]), Context.CC.current());
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return (Call) super.clone();
            }
        }

        @Override // okhttp3.Call
        public void enqueue(Callback callback) {
            this.delegate.enqueue(new TracingCallback(callback, this.callingContext));
        }

        @Override // okhttp3.Call
        public Response execute() throws IOException {
            Scope makeCurrent = this.callingContext.makeCurrent();
            try {
                Response execute = this.delegate.execute();
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                return execute;
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // okhttp3.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // okhttp3.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // okhttp3.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // okhttp3.Call
        public Timeout timeout() {
            if (TracingCallFactory.timeoutMethod != null) {
                try {
                    return (Timeout) TracingCallFactory.timeoutMethod.invoke(this.delegate, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return Timeout.NONE;
                }
            }
            return Timeout.NONE;
        }

        /* loaded from: classes9.dex */
        static class TracingCallback implements Callback {
            private final Context callingContext;
            private final Callback delegate;

            public TracingCallback(Callback callback, Context context) {
                this.delegate = callback;
                this.callingContext = context;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Scope makeCurrent = this.callingContext.makeCurrent();
                try {
                    this.delegate.onFailure(call, iOException);
                    if (makeCurrent != null) {
                        makeCurrent.close();
                    }
                } catch (Throwable th) {
                    if (makeCurrent != null) {
                        try {
                            makeCurrent.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Scope makeCurrent = this.callingContext.makeCurrent();
                try {
                    this.delegate.onResponse(call, response);
                    if (makeCurrent != null) {
                        makeCurrent.close();
                    }
                } catch (Throwable th) {
                    if (makeCurrent != null) {
                        try {
                            makeCurrent.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
