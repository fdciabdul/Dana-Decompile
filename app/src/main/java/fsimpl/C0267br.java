package fsimpl;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: fsimpl.br  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0267br extends HttpsURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final HttpsURLConnection f7894a;
    private final C0268bs b;

    public C0267br(HttpsURLConnection httpsURLConnection, C0268bs c0268bs) {
        super(httpsURLConnection.getURL());
        this.f7894a = httpsURLConnection;
        this.b = c0268bs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(String str, int i) {
        return Integer.valueOf(this.f7894a.getHeaderFieldInt(str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long a(String str, long j) {
        return Long.valueOf(this.f7894a.getHeaderFieldLong(str, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a(Class[] clsArr) {
        return this.f7894a.getContent(clsArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(int i) {
        return this.f7894a.getHeaderField(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(String str) {
        return this.f7894a.getHeaderField(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long b(String str, long j) {
        return Long.valueOf(this.f7894a.getHeaderFieldDate(str, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String b(int i) {
        return this.f7894a.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f7894a.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() {
        this.f7894a.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f7894a.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f7894a.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.f7894a.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f7894a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return c0268bs.a(httpsURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$NAIDoHAl-gi_Zi9lqKQacbxbfyE
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpsURLConnection.getContent();
            }
        });
    }

    @Override // java.net.URLConnection
    public Object getContent(final Class[] clsArr) {
        return this.b.a(this.f7894a, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$br$TCGoyEu38hxSKDMKKLv7gM1tp-Q
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                Object a2;
                a2 = C0267br.this.a(clsArr);
                return a2;
            }
        });
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (String) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$9_4auCR_s6rhr5L-Z1iw55IxE5s
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpsURLConnection.getContentEncoding();
            }
        });
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Integer) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$0incYH9dHBB9fKZbfrMv6acfGAQ
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Integer.valueOf(httpsURLConnection.getContentLength());
            }
        })).intValue();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Long) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$m1FxqkbP6gqvefci_A2WcK2PY04
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpsURLConnection.getContentLengthLong());
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (String) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$VkKmR7jlx0MEUE6AKh5aCpCV1UQ
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpsURLConnection.getContentType();
            }
        });
    }

    @Override // java.net.URLConnection
    public long getDate() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Long) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$soMbc2OPh9wum61GOcxk8_nnEwA
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpsURLConnection.getDate());
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f7894a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f7894a.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f7894a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (InputStream) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$gxvTPTvYSjENCjB7-wKUtoqPjuE
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpsURLConnection.getErrorStream();
            }
        });
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Long) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$rpV8QG7NyiqbABOs1z9M9osWMEs
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpsURLConnection.getExpiration());
            }
        })).longValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(final int i) {
        return (String) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$Erdic3CmSIgtkBO-HJ2N00h5L-U
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String a2;
                a2 = C0267br.this.a(i);
                return a2;
            }
        });
    }

    @Override // java.net.URLConnection
    public String getHeaderField(final String str) {
        return (String) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$Sfh8hZ8A030Zc6OVIxW0g4WkdgM
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String a2;
                a2 = C0267br.this.a(str);
                return a2;
            }
        });
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(final String str, final long j) {
        return ((Long) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$CE78FjcTWLlLpOflyaVuTAWAAMU
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Long b;
                b = C0267br.this.b(str, j);
                return b;
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(final String str, final int i) {
        return ((Integer) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$bfN23YxVzXCI1n_9RewWT05qJ1k
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Integer a2;
                a2 = C0267br.this.a(str, i);
                return a2;
            }
        })).intValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(final int i) {
        return (String) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$6q_aPWYzev3aXA5MJ7jJMklqyjQ
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                String b;
                b = C0267br.this.b(i);
                return b;
            }
        });
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(final String str, final long j) {
        return ((Long) this.b.a(this.f7894a, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$br$S1bxCCSm5SiDwzvkeQ3DX8SMHr4
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                Long a2;
                a2 = C0267br.this.a(str, j);
                return a2;
            }
        })).longValue();
    }

    @Override // java.net.URLConnection
    public Map getHeaderFields() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (Map) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$xZXGFHpQx3HO-P5pliouYs2ea-8
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return httpsURLConnection.getHeaderFields();
            }
        });
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.f7894a.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f7894a.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (InputStream) c0268bs.a(httpsURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$ciXTEsDV-_nsMZdotzJ-jo4aq_Y
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpsURLConnection.getInputStream();
            }
        });
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f7894a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Long) c0268bs.a(httpsURLConnection, new InterfaceC0270bu() { // from class: fsimpl.-$$Lambda$jmu4pt4bAXfk4olzUNtF7BGwMC8
            @Override // fsimpl.InterfaceC0270bu
            public final Object get() {
                return Long.valueOf(httpsURLConnection.getLastModified());
            }
        })).longValue();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.f7894a.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.f7894a.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        return this.f7894a.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() {
        return this.f7894a.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() {
        return this.f7894a.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f7894a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f7894a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map getRequestProperties() {
        return this.f7894a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f7894a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return ((Integer) c0268bs.a(httpsURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$LMsupOu4GrWwFVVje-nbl1Fo3Pk
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return Integer.valueOf(httpsURLConnection.getResponseCode());
            }
        })).intValue();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        C0268bs c0268bs = this.b;
        final HttpsURLConnection httpsURLConnection = this.f7894a;
        return (String) c0268bs.a(httpsURLConnection, new InterfaceC0269bt() { // from class: fsimpl.-$$Lambda$Z2niwYKwJ0CgBrO6FQigIRXRIIk
            @Override // fsimpl.InterfaceC0269bt
            public final Object get() {
                return httpsURLConnection.getResponseMessage();
            }
        });
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.f7894a.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() {
        return this.f7894a.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f7894a.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f7894a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        this.f7894a.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.f7894a.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.f7894a.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.f7894a.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        this.f7894a.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.f7894a.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.f7894a.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        this.f7894a.setFixedLengthStreamingMode(j);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f7894a.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        this.f7894a.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.f7894a.setInstanceFollowRedirects(z);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.f7894a.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) {
        this.f7894a.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f7894a.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f7894a.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.f7894a.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f7894a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f7894a.usingProxy();
    }
}
