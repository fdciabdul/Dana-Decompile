package fsimpl;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

/* renamed from: fsimpl.bq  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0266bq extends HttpURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f7893a;
    private final C0268bs b;

    public C0266bq(HttpURLConnection httpURLConnection, C0268bs c0268bs) {
        super(httpURLConnection.getURL());
        this.f7893a = httpURLConnection;
        this.b = c0268bs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(String str, int i) {
        return Integer.valueOf(this.f7893a.getHeaderFieldInt(str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long a(String str, long j) {
        return Long.valueOf(this.f7893a.getHeaderFieldLong(str, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a(Class[] clsArr) {
        return this.f7893a.getContent(clsArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(int i) {
        return this.f7893a.getHeaderField(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(String str) {
        return this.f7893a.getHeaderField(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long b(String str, long j) {
        return Long.valueOf(this.f7893a.getHeaderFieldDate(str, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String b(int i) {
        return this.f7893a.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f7893a.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() {
        this.f7893a.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f7893a.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f7893a.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f7893a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return c0268bs.a(httpURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$6UC_kIVEQTu6oEF3vmSLFtl2YMw
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpURLConnection.getContent();
            }
        });
    }

    @Override // java.net.URLConnection
    public Object getContent(final Class[] clsArr) {
        return this.b.a(this.f7893a, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$bq$q3ssnDc3jH1YTsDczYBPhqGn9Rw
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                Object a2;
                a2 = C0266bq.this.a(clsArr);
                return a2;
            }
        });
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (String) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$W9E-X6WwCSf03W3Qkxlh_lup7Z4
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpURLConnection.getContentEncoding();
            }
        });
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Integer) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$KFr3svq4HAju1lF46XyF_MY-0yE
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Integer.valueOf(httpURLConnection.getContentLength());
            }
        })).intValue();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Long) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$IS44VrjIAbtAiIULXY_20rPeY6g
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpURLConnection.getContentLengthLong());
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (String) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$EQgu83l7T4epQf9kVvTlTZpkhIg
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpURLConnection.getContentType();
            }
        });
    }

    @Override // java.net.URLConnection
    public long getDate() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Long) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$tOOrWU9k7LaERutaGp_62qaWdYg
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpURLConnection.getDate());
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f7893a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f7893a.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f7893a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (InputStream) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$tx1xEYVQr8GYFYgBY-Qi1KnMpgk
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpURLConnection.getErrorStream();
            }
        });
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Long) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$W8ssrRPYPJUSneALoVzx6TMeWfc
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpURLConnection.getExpiration());
            }
        })).longValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(final int i) {
        return (String) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$FiudnkCclIHtcLL9tmSYhil4JF8
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String a2;
                a2 = C0266bq.this.a(i);
                return a2;
            }
        });
    }

    @Override // java.net.URLConnection
    public String getHeaderField(final String str) {
        return (String) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$wf6_Enf8bDcN8VQwxY7ue1lxgV8
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String a2;
                a2 = C0266bq.this.a(str);
                return a2;
            }
        });
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(final String str, final long j) {
        return ((Long) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$a6UTCTpLnd8zvRcAbjW-UrLvFtA
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Long b;
                b = C0266bq.this.b(str, j);
                return b;
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(final String str, final int i) {
        return ((Integer) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$IEO7hJJ6X7LpmJ44IRdg6C75zvQ
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Integer a2;
                a2 = C0266bq.this.a(str, i);
                return a2;
            }
        })).intValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(final int i) {
        return (String) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$riaW3Bz_6a7-yHmKQTOhYd0-U_8
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String b;
                b = C0266bq.this.b(i);
                return b;
            }
        });
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(final String str, final long j) {
        return ((Long) this.b.a(this.f7893a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bq$kQ-VEu9ViE9cVFYlHlQVUOcBiCw
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Long a2;
                a2 = C0266bq.this.a(str, j);
                return a2;
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public Map getHeaderFields() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (Map) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$JmevwkTN2ZpQZ06Q_UUl-J7yPuw
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpURLConnection.getHeaderFields();
            }
        });
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f7893a.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (InputStream) c0268bs.a(httpURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$NSKGg3ErcK0NO2LvFy3v6VT0Q7o
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpURLConnection.getInputStream();
            }
        });
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f7893a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Long) c0268bs.a(httpURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$bffjmEFLRPkVlT5pwte4ce7tHuw
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpURLConnection.getLastModified());
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        return this.f7893a.getOutputStream();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() {
        return this.f7893a.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f7893a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f7893a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map getRequestProperties() {
        return this.f7893a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f7893a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return ((Integer) c0268bs.a(httpURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$xpc-AWtC1ASTSw7NiE_c86idpSY
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return Integer.valueOf(httpURLConnection.getResponseCode());
            }
        })).intValue();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        C0268bs c0268bs = this.b;
        final HttpURLConnection httpURLConnection = this.f7893a;
        return (String) c0268bs.a(httpURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$MKkw6019WHRxI67y6v39IOI6sHg
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpURLConnection.getResponseMessage();
            }
        });
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f7893a.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f7893a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        this.f7893a.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.f7893a.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.f7893a.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.f7893a.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        this.f7893a.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.f7893a.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.f7893a.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        this.f7893a.setFixedLengthStreamingMode(j);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        this.f7893a.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.f7893a.setInstanceFollowRedirects(z);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.f7893a.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) {
        this.f7893a.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f7893a.setRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.f7893a.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f7893a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f7893a.usingProxy();
    }
}
