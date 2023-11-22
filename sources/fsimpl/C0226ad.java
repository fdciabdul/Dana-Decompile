package fsimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.webview.WebViewTracker;
import com.fullstory.rust.RustInterface;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* renamed from: fsimpl.ad */
/* loaded from: classes.dex */
public class C0226ad implements aP, InterfaceC0335ef {

    /* renamed from: a */
    private final C0230ah f7845a;
    private final Context b;
    private final C0235am c;
    private final C0252bc d;
    private final aQ e;
    private final aK f;
    private aU g;
    private final C0231ai h;
    private final N i;
    private final WebViewTracker j;
    private final RustInterface k;
    private final C0311dh l;
    private final int m;
    private aL n;

    /* renamed from: o */
    private aL f7846o;
    private aM p;
    private aL q;
    private aT r;
    private aZ s;
    private aZ t;
    private aW u;
    private aW v;
    private boolean w;
    private int x = 0;

    public C0226ad(RustInterface rustInterface, C0230ah c0230ah, Context context, C0235am c0235am, C0252bc c0252bc, aQ aQVar, aK aKVar, aU aUVar, C0231ai c0231ai, N n, WebViewTracker webViewTracker, C0311dh c0311dh, int i) {
        this.k = rustInterface;
        this.f7845a = c0230ah;
        this.b = context;
        this.c = c0235am;
        this.d = c0252bc;
        this.e = aQVar;
        this.f = aKVar;
        this.g = aUVar;
        this.h = c0231ai;
        this.i = n;
        this.j = webViewTracker;
        this.l = c0311dh;
        this.m = i;
    }

    private int a(int i, int i2, final fi fiVar, long j, long j2) {
        Map a2 = this.n.a();
        Map a3 = this.f7846o.a();
        Map a4 = this.s.a();
        Map a5 = this.t.a();
        final Map a6 = this.p.a();
        Map a7 = this.q.a();
        int b = this.r.b();
        List a8 = this.r.a();
        int a9 = this.f.a(a2, a3, a4, a5, this.u.a(), this.v.a(), fiVar);
        final int[] iArr = new int[1];
        fb.b(new Runnable() { // from class: fsimpl.-$$Lambda$ad$sB6TKsn6nYMzHNca5yAqDKrm4e4
            @Override // java.lang.Runnable
            public final void run() {
                C0226ad.this.a(iArr, a6, fiVar);
            }
        });
        int a10 = this.e.a(a7, fiVar);
        this.g.a(a8, b);
        cD.a(fiVar);
        cD.a(fiVar, j);
        cD.b(fiVar, a9);
        cD.c(fiVar, iArr[0]);
        cD.d(fiVar, a10);
        cD.a(fiVar, i);
        cD.e(fiVar, i2);
        cD.b(fiVar, j2);
        return cD.b(fiVar);
    }

    public /* synthetic */ void a(long j, long j2) {
        this.k.a(j, j2);
        this.k.d();
    }

    public /* synthetic */ void a(int[] iArr, Map map, fi fiVar) {
        iArr[0] = this.d.a(map, fiVar);
    }

    private void c(boolean z) {
        if (z) {
            this.x = 0;
        }
        if (this.x == 0) {
            final long a2 = eT.a();
            final long a3 = eT.a(a2);
            if (eT.a(a3, a2) < this.m) {
                fb.c(new Runnable() { // from class: fsimpl.-$$Lambda$ad$e4ww3tG4lyx9MljO1Hj4j9rYjpo
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0226ad.this.a(a3, a2);
                    }
                });
            }
        }
        int i = this.x + 1;
        this.x = i;
        if (i > 9) {
            this.x = 0;
        }
    }

    private void d() {
        this.l.a();
    }

    @Override // fsimpl.InterfaceC0335ef
    public int a(int i, Object obj) {
        return a((ByteBuffer) obj, EnumC0227ae.values()[i]);
    }

    @Override // fsimpl.aP
    public int a(int i, ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.limit() == 0) {
            return 0;
        }
        return this.k.a(i, byteBuffer);
    }

    @Override // fsimpl.aP
    public int a(Bitmap bitmap) {
        return this.n.a(bitmap);
    }

    @Override // fsimpl.aP
    public int a(Path path) {
        return this.p.a(path);
    }

    @Override // fsimpl.aP
    public int a(Shader shader) {
        return this.q.a(shader);
    }

    @Override // fsimpl.aP
    public int a(Drawable drawable) {
        return this.u.a(drawable);
    }

    @Override // fsimpl.aP
    public int a(String str) {
        if (str == null) {
            return 0;
        }
        return this.r.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[Catch: all -> 0x00ba, TRY_LEAVE, TryCatch #1 {all -> 0x00ba, blocks: (B:42:0x000c, B:44:0x0012, B:47:0x0017, B:53:0x0066, B:55:0x0092, B:59:0x009b, B:52:0x001f), top: B:70:0x000c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b A[Catch: all -> 0x00ba, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ba, blocks: (B:42:0x000c, B:44:0x0012, B:47:0x0017, B:53:0x0066, B:55:0x0092, B:59:0x009b, B:52:0x001f), top: B:70:0x000c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.nio.ByteBuffer r19, fsimpl.EnumC0227ae r20) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0226ad.a(java.nio.ByteBuffer, fsimpl.ae):int");
    }

    @Override // fsimpl.InterfaceC0335ef
    public String a() {
        if (this.w) {
            return null;
        }
        return this.f7845a.u();
    }

    @Override // fsimpl.InterfaceC0335ef
    public String a(boolean z) {
        if (this.w) {
            return null;
        }
        return this.f7845a.h(z);
    }

    @Override // fsimpl.aP
    public int b(Bitmap bitmap) {
        return this.f7846o.a(bitmap);
    }

    @Override // fsimpl.aP
    public int b(Drawable drawable) {
        return this.v.a(drawable);
    }

    @Override // fsimpl.InterfaceC0335ef
    public C0230ah b() {
        if (this.w) {
            return null;
        }
        return this.f7845a;
    }

    @Override // fsimpl.InterfaceC0335ef
    public void b(boolean z) {
        C0230ah c0230ah = this.f7845a;
        if (c0230ah == null || c0230ah.d() == z) {
            return;
        }
        this.f7845a.a(z);
        d();
    }

    @Override // fsimpl.aP
    public int c(Bitmap bitmap) {
        return this.s.a(bitmap);
    }

    @Override // fsimpl.InterfaceC0335ef
    public void c() {
        synchronized (this) {
            this.j.a();
            this.w = true;
            this.n = null;
            this.f7846o = null;
            this.p = null;
            this.q = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.h.b();
        }
    }

    @Override // fsimpl.aP
    public int d(Bitmap bitmap) {
        return this.t.a(bitmap);
    }
}
