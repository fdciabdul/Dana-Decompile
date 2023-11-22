package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: classes6.dex */
public class NetworkStream extends InputStream {
    public static final String TAG = "AriverRes:NetworkStream";

    /* renamed from: a  reason: collision with root package name */
    private String f6205a;
    private InputStream b;
    private HttpURLConnection c;
    private Listener d;
    private int e;
    private boolean f;
    private Map<String, String> g;

    /* loaded from: classes6.dex */
    public interface Listener {
        void onInputClose(NetworkStream networkStream);

        void onInputException();

        void onInputOpen(NetworkStream networkStream);

        void onResourceError(NetworkStream networkStream, int i);
    }

    public NetworkStream(String str, Listener listener) {
        this(str, false, listener);
    }

    public NetworkStream(String str, boolean z, Listener listener) {
        this.f6205a = str;
        this.d = listener;
        this.f = z;
        this.b = a();
    }

    public NetworkStream(String str, boolean z, Listener listener, Map map) {
        this.f6205a = str;
        this.d = listener;
        this.f = z;
        this.g = map;
        this.b = a();
    }

    public int getStatusCode() {
        return this.e;
    }

    public InputStream getRealStream() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            try {
                return inputStream.read();
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("read stream in ");
                sb.append(this.f6205a);
                sb.append(" exception!");
                RVLogger.e(TAG, sb.toString(), th);
                return -1;
            }
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            return inputStream.available();
        }
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        } else {
            super.close();
        }
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.c = null;
        Listener listener = this.d;
        if (listener != null) {
            listener.onInputClose(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.mark(i);
        } else {
            super.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            InputStream inputStream = this.b;
            if (inputStream != null) {
                inputStream.reset();
            } else {
                super.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return super.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            InputStream inputStream = this.b;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            return super.read(bArr, i, i2);
        } catch (Throwable unused) {
            RVLogger.e(TAG, "read stream error!");
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0097 A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:14:0x0046, B:15:0x0071, B:17:0x0097, B:19:0x009b, B:20:0x009e, B:22:0x00b3, B:24:0x00b7, B:26:0x00bb), top: B:36:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7 A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:14:0x0046, B:15:0x0071, B:17:0x0097, B:19:0x009b, B:20:0x009e, B:22:0x00b3, B:24:0x00b7, B:26:0x00bb), top: B:36:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream a() {
        /*
            r6 = this;
            java.lang.String r0 = "yes"
            java.lang.String r1 = "AriverRes:NetworkStream"
            r2 = 0
            java.lang.Class<com.alibaba.ariver.kernel.common.network.RVTransportService> r3 = com.alibaba.ariver.kernel.common.network.RVTransportService.class
            java.lang.Object r3 = com.alibaba.ariver.kernel.common.RVProxy.get(r3)     // Catch: java.lang.Exception -> Lc2
            com.alibaba.ariver.kernel.common.network.RVTransportService r3 = (com.alibaba.ariver.kernel.common.network.RVTransportService) r3     // Catch: java.lang.Exception -> Lc2
            if (r3 == 0) goto L42
            com.alibaba.ariver.kernel.common.network.http.RVHttpRequest$Builder r4 = com.alibaba.ariver.kernel.common.network.http.RVHttpRequest.newBuilder()     // Catch: java.lang.Exception -> Lc2
            java.lang.String r5 = r6.f6205a     // Catch: java.lang.Exception -> Lc2
            com.alibaba.ariver.kernel.common.network.http.RVHttpRequest$Builder r4 = r4.url(r5)     // Catch: java.lang.Exception -> Lc2
            boolean r5 = r6.f     // Catch: java.lang.Exception -> Lc2
            com.alibaba.ariver.kernel.common.network.http.RVHttpRequest$Builder r4 = r4.setPackageRequest(r5)     // Catch: java.lang.Exception -> Lc2
            r5 = 1
            com.alibaba.ariver.kernel.common.network.http.RVHttpRequest$Builder r4 = r4.useCache(r5)     // Catch: java.lang.Exception -> Lc2
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.g     // Catch: java.lang.Exception -> Lc2
            if (r5 == 0) goto L2c
            r4.headers(r5)     // Catch: java.lang.Exception -> Lc2
        L2c:
            com.alibaba.ariver.kernel.common.network.http.RVHttpRequest r4 = r4.build()     // Catch: java.lang.Exception -> Lc2
            com.alibaba.ariver.kernel.common.network.http.RVHttpResponse r3 = r3.httpRequest(r4)     // Catch: java.lang.Exception -> Lc2
            if (r3 == 0) goto L42
            java.io.InputStream r4 = r3.getResStream()     // Catch: java.lang.Exception -> Lc2
            int r3 = r3.getStatusCode()     // Catch: java.lang.Exception -> Lc2
            r6.e = r3     // Catch: java.lang.Exception -> Lc2
            r3 = r4
            goto L44
        L42:
            r3 = r2
            r4 = r3
        L44:
            if (r3 != 0) goto L71
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Exception -> Lbf
            java.lang.String r5 = r6.f6205a     // Catch: java.lang.Exception -> Lbf
            r3.<init>(r5)     // Catch: java.lang.Exception -> Lbf
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Exception -> Lbf
            java.net.URLConnection r3 = com.fullstory.instrumentation.InstrumentInjector.urlconnection_wrapInstance(r3)     // Catch: java.lang.Exception -> Lbf
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch: java.lang.Exception -> Lbf
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch: java.lang.Exception -> Lbf
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Exception -> Lbf
            r6.c = r3     // Catch: java.lang.Exception -> Lbf
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Exception -> Lbf
            java.net.HttpURLConnection r5 = r6.c     // Catch: java.lang.Exception -> Lbf
            int r5 = r5.getResponseCode()     // Catch: java.lang.Exception -> Lbf
            r6.e = r5     // Catch: java.lang.Exception -> Lbf
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> Lbf
            r5.<init>(r3)     // Catch: java.lang.Exception -> Lbf
            r4 = r5
        L71:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbf
            r3.<init>()     // Catch: java.lang.Exception -> Lbf
            java.lang.String r5 = "initStream "
            r3.append(r5)     // Catch: java.lang.Exception -> Lbf
            java.lang.String r5 = r6.f6205a     // Catch: java.lang.Exception -> Lbf
            r3.append(r5)     // Catch: java.lang.Exception -> Lbf
            java.lang.String r5 = " get statusCode: "
            r3.append(r5)     // Catch: java.lang.Exception -> Lbf
            int r5 = r6.e     // Catch: java.lang.Exception -> Lbf
            r3.append(r5)     // Catch: java.lang.Exception -> Lbf
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lbf
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r3)     // Catch: java.lang.Exception -> Lbf
            int r3 = r6.e     // Catch: java.lang.Exception -> Lbf
            r5 = 400(0x190, float:5.6E-43)
            if (r3 < r5) goto Lb7
            com.alibaba.ariver.resource.api.content.NetworkStream$Listener r5 = r6.d     // Catch: java.lang.Exception -> Lbf
            if (r5 == 0) goto L9e
            r5.onResourceError(r6, r3)     // Catch: java.lang.Exception -> Lbf
        L9e:
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVConfigService> r3 = com.alibaba.ariver.kernel.common.service.RVConfigService.class
            java.lang.Object r3 = com.alibaba.ariver.kernel.common.RVProxy.get(r3)     // Catch: java.lang.Exception -> Lbf
            com.alibaba.ariver.kernel.common.service.RVConfigService r3 = (com.alibaba.ariver.kernel.common.service.RVConfigService) r3     // Catch: java.lang.Exception -> Lbf
            java.lang.String r5 = "ta_fix_GZipInputStream_leak"
            java.lang.String r3 = r3.getConfigWithProcessCache(r5, r0)     // Catch: java.lang.Exception -> Lbf
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch: java.lang.Exception -> Lbf
            if (r0 == 0) goto Lb6
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r4)     // Catch: java.lang.Exception -> Lbf
        Lb6:
            return r2
        Lb7:
            com.alibaba.ariver.resource.api.content.NetworkStream$Listener r0 = r6.d     // Catch: java.lang.Exception -> Lbf
            if (r0 == 0) goto Le1
            r0.onInputOpen(r6)     // Catch: java.lang.Exception -> Lbf
            goto Le1
        Lbf:
            r0 = move-exception
            r2 = r4
            goto Lc3
        Lc2:
            r0 = move-exception
        Lc3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.f6205a
            r3.append(r4)
            java.lang.String r4 = " failed to init stream "
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r3, r0)
            com.alibaba.ariver.resource.api.content.NetworkStream$Listener r0 = r6.d
            if (r0 == 0) goto Le0
            r0.onInputException()
        Le0:
            r4 = r2
        Le1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.api.content.NetworkStream.a():java.io.InputStream");
    }
}
