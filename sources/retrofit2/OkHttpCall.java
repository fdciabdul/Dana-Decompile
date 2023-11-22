package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import retrofit2.RequestBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class OkHttpCall<T> implements Call<T> {
    private final Object[] BuiltInFictitiousFunctionClassFactory;
    @Nullable
    private Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    private final Call.Factory MyBillsEntityDataFactory;
    private final Converter<ResponseBody, T> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean PlaceComponentResult;
    private volatile boolean getAuthRequestContext;
    private final RequestFactory moveToNextValue;
    @Nullable
    private okhttp3.Call scheduleImpl;

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.moveToNextValue = requestFactory;
        this.BuiltInFictitiousFunctionClassFactory = objArr;
        this.MyBillsEntityDataFactory = factory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = converter;
    }

    @Override // retrofit2.Call
    public final Request KClassImpl$Data$declaredNonStaticMembers$2() {
        Request request;
        synchronized (this) {
            try {
                request = NetworkUserEntityData$$ExternalSyntheticLambda0().request();
            } catch (IOException e) {
                throw new RuntimeException("Unable to create request.", e);
            }
        }
        return request;
    }

    private okhttp3.Call NetworkUserEntityData$$ExternalSyntheticLambda0() throws IOException {
        okhttp3.Call call = this.scheduleImpl;
        if (call != null) {
            return call;
        }
        Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            okhttp3.Call errorConfigVersion = getErrorConfigVersion();
            this.scheduleImpl = errorConfigVersion;
            return errorConfigVersion;
        } catch (IOException | Error | RuntimeException e) {
            Utils.getAuthRequestContext(e);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public final void MyBillsEntityDataFactory(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (this.PlaceComponentResult) {
                throw new IllegalStateException("Already executed.");
            }
            this.PlaceComponentResult = true;
            call = this.scheduleImpl;
            th = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (call == null && th == null) {
                try {
                    okhttp3.Call errorConfigVersion = getErrorConfigVersion();
                    this.scheduleImpl = errorConfigVersion;
                    call = errorConfigVersion;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.getAuthRequestContext(th);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
                }
            }
        }
        if (th != null) {
            callback.KClassImpl$Data$declaredNonStaticMembers$2(this, th);
            return;
        }
        if (this.getAuthRequestContext) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            {
                OkHttpCall.this = this;
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) {
                try {
                    try {
                        callback.PlaceComponentResult(OkHttpCall.this, OkHttpCall.this.BuiltInFictitiousFunctionClassFactory(response));
                    } catch (Throwable th3) {
                        Utils.getAuthRequestContext(th3);
                    }
                } catch (Throwable th4) {
                    Utils.getAuthRequestContext(th4);
                    try {
                        callback.KClassImpl$Data$declaredNonStaticMembers$2(OkHttpCall.this, th4);
                    } catch (Throwable th5) {
                        Utils.getAuthRequestContext(th5);
                    }
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                try {
                    callback.KClassImpl$Data$declaredNonStaticMembers$2(OkHttpCall.this, iOException);
                } catch (Throwable th3) {
                    Utils.getAuthRequestContext(th3);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public final Response<T> PlaceComponentResult() throws IOException {
        okhttp3.Call NetworkUserEntityData$$ExternalSyntheticLambda0;
        synchronized (this) {
            if (this.PlaceComponentResult) {
                throw new IllegalStateException("Already executed.");
            }
            this.PlaceComponentResult = true;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
        if (this.getAuthRequestContext) {
            NetworkUserEntityData$$ExternalSyntheticLambda0.cancel();
        }
        return BuiltInFictitiousFunctionClassFactory(FirebasePerfOkHttpClient.execute(NetworkUserEntityData$$ExternalSyntheticLambda0));
    }

    private okhttp3.Call getErrorConfigVersion() throws IOException {
        HttpUrl resolve;
        Call.Factory factory = this.MyBillsEntityDataFactory;
        RequestFactory requestFactory = this.moveToNextValue;
        Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
        ParameterHandler<?>[] parameterHandlerArr = requestFactory.moveToNextValue;
        int length = objArr.length;
        if (length != parameterHandlerArr.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Argument count (");
            sb.append(length);
            sb.append(") doesn't match expected count (");
            sb.append(parameterHandlerArr.length);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        RequestBuilder requestBuilder = new RequestBuilder(requestFactory.PlaceComponentResult, requestFactory.MyBillsEntityDataFactory, requestFactory.initRecordTimeStamp, requestFactory.BuiltInFictitiousFunctionClassFactory, requestFactory.KClassImpl$Data$declaredNonStaticMembers$2, requestFactory.getAuthRequestContext, requestFactory.lookAheadTest, requestFactory.getErrorConfigVersion);
        if (requestFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            parameterHandlerArr[i].MyBillsEntityDataFactory(requestBuilder, objArr[i]);
        }
        HttpUrl.Builder builder = requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = requestBuilder.PlaceComponentResult.resolve(requestBuilder.getErrorConfigVersion);
            if (resolve == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Malformed URL. Base: ");
                sb2.append(requestBuilder.PlaceComponentResult);
                sb2.append(", Relative: ");
                sb2.append(requestBuilder.getErrorConfigVersion);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        RequestBuilder.ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = requestBuilder.getAuthRequestContext;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = requestBuilder.MyBillsEntityDataFactory;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.build();
                } else if (requestBuilder.lookAheadTest) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = requestBuilder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new RequestBuilder.ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                requestBuilder.scheduleImpl.add("Content-Type", mediaType.toString());
            }
        }
        okhttp3.Call newCall = factory.newCall(requestBuilder.initRecordTimeStamp.url(resolve).headers(requestBuilder.scheduleImpl.build()).method(requestBuilder.moveToNextValue, contentTypeOverridingRequestBody).tag(Invocation.class, new Invocation(requestFactory.scheduleImpl, arrayList)).build());
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    final Response<T> BuiltInFictitiousFunctionClassFactory(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.PlaceComponentResult(Utils.BuiltInFictitiousFunctionClassFactory(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.getAuthRequestContext(null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e) {
                IOException iOException = exceptionCatchingResponseBody.MyBillsEntityDataFactory;
                if (iOException == null) {
                    throw e;
                }
                throw iOException;
            }
        }
    }

    @Override // retrofit2.Call
    public final void getAuthRequestContext() {
        okhttp3.Call call;
        this.getAuthRequestContext = true;
        synchronized (this) {
            call = this.scheduleImpl;
        }
        if (call != null) {
            call.cancel();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x000f, code lost:
    
        if (r0.isCanceled() != false) goto L31;
     */
    @Override // retrofit2.Call
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory() {
        /*
            r2 = this;
            boolean r0 = r2.getAuthRequestContext
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            monitor-enter(r2)
            okhttp3.Call r0 = r2.scheduleImpl     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L12
            boolean r0 = r0.isCanceled()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L12
            goto L13
        L12:
            r1 = 0
        L13:
            monitor-exit(r2)
            return r1
        L15:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.OkHttpCall.MyBillsEntityDataFactory():boolean");
    }

    /* loaded from: classes6.dex */
    public static final class NoContentResponseBody extends ResponseBody {
        @Nullable
        private final MediaType MyBillsEntityDataFactory;
        private final long getAuthRequestContext;

        NoContentResponseBody(@Nullable MediaType mediaType, long j) {
            this.MyBillsEntityDataFactory = mediaType;
            this.getAuthRequestContext = j;
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.getAuthRequestContext;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* loaded from: classes6.dex */
    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final BufferedSource KClassImpl$Data$declaredNonStaticMembers$2;
        @Nullable
        IOException MyBillsEntityDataFactory;
        private final ResponseBody PlaceComponentResult;

        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.PlaceComponentResult = responseBody;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(new ForwardingSource(responseBody.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                {
                    ExceptionCatchingResponseBody.this = this;
                }

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.MyBillsEntityDataFactory = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.PlaceComponentResult.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.PlaceComponentResult.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.PlaceComponentResult.close();
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new OkHttpCall(this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // retrofit2.Call
    public final /* synthetic */ Call BuiltInFictitiousFunctionClassFactory() {
        return new OkHttpCall(this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
