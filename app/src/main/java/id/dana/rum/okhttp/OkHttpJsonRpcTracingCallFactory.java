package id.dana.rum.okhttp;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.instrumentation.api.util.VirtualField;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

/* loaded from: classes2.dex */
public class OkHttpJsonRpcTracingCallFactory implements Call.Factory {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static Method PlaceComponentResult;
    static final VirtualField<Request, Context> getAuthRequestContext = VirtualField.find(Request.class, Context.class);
    private final OkHttpClient KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        try {
            BuiltInFictitiousFunctionClassFactory = Call.class.getMethod(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, new Class[0]);
        } catch (NoSuchMethodException unused) {
            BuiltInFictitiousFunctionClassFactory = null;
        }
        try {
            PlaceComponentResult = Call.class.getDeclaredMethod("clone", new Class[0]);
        } catch (NoSuchMethodException unused2) {
            PlaceComponentResult = null;
        }
    }

    public OkHttpJsonRpcTracingCallFactory(OkHttpClient okHttpClient) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context PlaceComponentResult(Request request) {
        return getAuthRequestContext.get(request);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        Context current = Context.CC.current();
        Request build = request.newBuilder().build();
        getAuthRequestContext.set(build, current);
        return new TracingCall(this.KClassImpl$Data$declaredNonStaticMembers$2.newCall(build), current);
    }

    /* loaded from: classes5.dex */
    static class TracingCall implements Call {
        private final Context MyBillsEntityDataFactory;
        private final Call PlaceComponentResult;

        TracingCall(Call call, Context context) {
            this.PlaceComponentResult = call;
            this.MyBillsEntityDataFactory = context;
        }

        @Override // okhttp3.Call
        public void cancel() {
            this.PlaceComponentResult.cancel();
        }

        @Override // okhttp3.Call
        public Call clone() {
            if (OkHttpJsonRpcTracingCallFactory.PlaceComponentResult == null) {
                try {
                    return (Call) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                try {
                    return new TracingCall((Call) OkHttpJsonRpcTracingCallFactory.PlaceComponentResult.invoke(this.PlaceComponentResult, new Object[0]), Context.CC.current());
                } catch (CloneNotSupportedException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return (Call) super.clone();
            }
        }

        @Override // okhttp3.Call
        public void enqueue(Callback callback) {
            FirebasePerfOkHttpClient.enqueue(this.PlaceComponentResult, new TracingCallback(callback, this.MyBillsEntityDataFactory));
        }

        @Override // okhttp3.Call
        public Response execute() throws IOException {
            Scope makeCurrent = this.MyBillsEntityDataFactory.makeCurrent();
            try {
                Response execute = FirebasePerfOkHttpClient.execute(this.PlaceComponentResult);
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
            return this.PlaceComponentResult.isCanceled();
        }

        @Override // okhttp3.Call
        public boolean isExecuted() {
            return this.PlaceComponentResult.isExecuted();
        }

        @Override // okhttp3.Call
        public Request request() {
            return this.PlaceComponentResult.request();
        }

        @Override // okhttp3.Call
        public Timeout timeout() {
            if (OkHttpJsonRpcTracingCallFactory.BuiltInFictitiousFunctionClassFactory != null) {
                try {
                    return (Timeout) OkHttpJsonRpcTracingCallFactory.BuiltInFictitiousFunctionClassFactory.invoke(this.PlaceComponentResult, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return Timeout.NONE;
                }
            }
            return Timeout.NONE;
        }

        /* loaded from: classes5.dex */
        static class TracingCallback implements Callback {
            private final Context BuiltInFictitiousFunctionClassFactory;
            private final Callback PlaceComponentResult;

            public TracingCallback(Callback callback, Context context) {
                this.PlaceComponentResult = callback;
                this.BuiltInFictitiousFunctionClassFactory = context;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Scope makeCurrent = this.BuiltInFictitiousFunctionClassFactory.makeCurrent();
                try {
                    this.PlaceComponentResult.onFailure(call, iOException);
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
                Scope makeCurrent = this.BuiltInFictitiousFunctionClassFactory.makeCurrent();
                try {
                    this.PlaceComponentResult.onResponse(call, response);
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
