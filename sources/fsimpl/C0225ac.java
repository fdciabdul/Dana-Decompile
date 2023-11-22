package fsimpl;

import android.content.Context;
import com.fullstory.instrumentation.webview.WebViewTracker;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: fsimpl.ac  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0225ac implements InterfaceC0333ed {

    /* renamed from: a  reason: collision with root package name */
    boolean f7844a = false;
    private final RustInterface b;
    private final Context c;
    private final bG d;
    private final C0229ag e;
    private final WebViewTracker f;
    private final C0228af g;
    private final P h;
    private final C0376z i;
    private final C0320dr j;
    private final boolean k;

    public C0225ac(RustInterface rustInterface, Context context, bG bGVar, C0229ag c0229ag, C0228af c0228af, P p, C0376z c0376z, WebViewTracker webViewTracker, C0320dr c0320dr, boolean z) {
        this.b = rustInterface;
        this.c = context;
        this.d = bGVar;
        this.e = c0229ag;
        this.g = c0228af;
        this.h = p;
        this.i = c0376z;
        this.f = webViewTracker;
        this.j = c0320dr;
        this.k = z;
    }

    private void a(final long j, final byte[] bArr, final String str, final String str2) {
        C0351ev.a(new Runnable() { // from class: fsimpl.-$$Lambda$ac$A4LiF3RYWMM9XQRYb6ndEpLD8dE
            @Override // java.lang.Runnable
            public final void run() {
                C0225ac.this.a(bArr, str, str2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr, String str, String str2, long j) {
        cU a2 = cT.a(bArr, str, str2);
        if (!(a2 instanceof cX)) {
            Throwable a3 = ((cW) a2).a();
            int i = a3 instanceof IOException ? -1 : -2;
            StringBuilder sb = new StringBuilder();
            sb.append("performHttpRequest failed with exType=");
            sb.append(i);
            Log.logAlways(sb.toString());
            Log.e("performHttpRequest failed: ", a3);
            if (i != -1) {
                C0354ey.a(a3);
            }
            this.b.a(j, i, new byte[0]);
            return;
        }
        cX cXVar = (cX) a2;
        int a4 = cXVar.a();
        byte[] b = cXVar.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FullStory session response: ");
        sb2.append(a4);
        Log.logAlways(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Response: ");
        sb3.append(a4);
        sb3.append(" length=");
        sb3.append(b.length);
        Log.d(sb3.toString());
        this.b.a(j, a4, b);
    }

    private void h(String str) {
    }

    @Override // fsimpl.InterfaceC0333ed
    public InterfaceC0335ef a(byte[] bArr) {
        try {
            h("createScanner");
            C0230ah a2 = this.e.a(bArr);
            if (!a2.e()) {
                Log.e("FullStory session is invalid");
                return null;
            }
            C0226ad a3 = this.g.a(a2);
            C0354ey.a(a2, this.d);
            String a4 = a3.a(false);
            if (this.d.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("FullStory session started: ");
                sb.append(a4);
                Log.logAlways(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("FullStory session started: ");
                sb2.append(a4);
                Log.i(sb2.toString());
            }
            return a3;
        } catch (Throwable th) {
            Log.e("Exception in gotSession", th);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // fsimpl.InterfaceC0333ed
    public String a(String str) {
        char c;
        h("readConfigKey");
        switch (str.hashCode()) {
            case -1821959325:
                if (str.equals(HttpHeaders.SERVER)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -807149818:
                if (str.equals("AppScheme")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 79556:
                if (str.equals("Org")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 150373893:
                if (str.equals("PluginVersion")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 236511225:
                if (str.equals("TempDir")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1895597065:
                if (str.equals("BuildId")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? "" : "1.41.0" : this.i.a().getAbsolutePath() : this.d.g() : this.d.f() : this.d.i() : this.d.j();
    }

    @Override // fsimpl.InterfaceC0333ed
    public void a(long j, String str, byte[] bArr, String str2, String str3, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("httpRequest; isTransactional=");
        sb.append(z);
        h(sb.toString());
        if (z) {
            a(j, bArr, str2, str3);
            return;
        }
        this.f7844a = z2;
        String d = fa.d(str);
        if (d == null || this.j == null) {
            Log.w("Internal upload error: session or uploader was missing");
            this.b.a(j, 404, new byte[0]);
            return;
        }
        File a2 = this.i.a("bin");
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(a2);
                try {
                    C0344eo.a().a(new ByteArrayInputStream(bArr), fileOutputStream);
                    fileOutputStream.close();
                    this.j.a(d, a2, new URL(str2), str3, dF.NORMAL, EnumC0323du.ENCRYPTED, dG.READY, null);
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (GeneralSecurityException e) {
                Log.e("Failed to encrypt frame data, so skipping this upload", e);
            }
            a2.delete();
            this.b.a(j, 200, new byte[0]);
        } catch (Throwable th2) {
            a2.delete();
            throw th2;
        }
    }

    @Override // fsimpl.InterfaceC0333ed
    public void a(String str, Boolean bool) {
        h("writeKeyBool");
        this.h.a(str, bool);
    }

    @Override // fsimpl.InterfaceC0333ed
    public void a(String str, Long l) {
        h("writeKeyLong");
        this.h.a(str, l);
    }

    @Override // fsimpl.InterfaceC0333ed
    public void a(String str, String str2) {
        h("writeKey");
        this.h.a(str, str2);
    }

    @Override // fsimpl.InterfaceC0333ed
    public boolean a(long j, String str, String str2) {
        return this.f.a(j, str, str2);
    }

    byte[] a() {
        if (C0344eo.a(this.c)) {
            fi fiVar = new fi();
            fiVar.h(C0299cw.a(fiVar, (byte) 2, C0365o.a(this.c, fiVar, this.d), C0365o.a(fiVar, this.k, this.d)));
            ByteBuffer slice = fl.a(fiVar).slice();
            int remaining = slice.remaining();
            byte[] bArr = new byte[remaining];
            slice.get(bArr, 0, remaining);
            return bArr;
        }
        return new byte[0];
    }

    @Override // fsimpl.InterfaceC0333ed
    public boolean b(String str) {
        char c;
        h("readConfigKeyBool");
        int hashCode = str.hashCode();
        if (hashCode != -1655724014) {
            if (hashCode == 204775274 && str.equals("UseProxyServer")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("RecordOnStart")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                return false;
            }
            return this.d.K();
        }
        return this.d.q();
    }

    @Override // fsimpl.InterfaceC0333ed
    public int c(String str) {
        char c;
        h("readConfigKeyInt");
        int hashCode = str.hashCode();
        if (hashCode == -1022705348) {
            if (str.equals("ViewScanType")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != -157490462) {
            if (hashCode == 755811072 && str.equals("ProtocolVersion")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("SessionSetupDelayMs")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return 0;
                }
                return this.d.H();
            }
            return this.d.e();
        }
        return 1692721242;
    }

    @Override // fsimpl.InterfaceC0333ed
    public byte[] d(String str) {
        char c;
        h("readConfigKeyBuffer");
        int hashCode = str.hashCode();
        if (hashCode != 443088107) {
            if (hashCode == 1963152051 && str.equals("PlatformBuffer")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("CanvasDefinition")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                return null;
            }
            return cR.a();
        }
        return a();
    }

    @Override // fsimpl.InterfaceC0333ed
    public String e(String str) {
        h("readKey");
        return this.h.a(str);
    }

    @Override // fsimpl.InterfaceC0333ed
    public Boolean f(String str) {
        h("readKeyBoolean");
        return this.h.b(str);
    }

    @Override // fsimpl.InterfaceC0333ed
    public Long g(String str) {
        h("readKeyLong");
        return this.h.c(str);
    }
}
