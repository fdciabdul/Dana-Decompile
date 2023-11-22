package fsimpl;

import android.content.Context;
import com.fullstory.instrumentation.webview.WebViewTracker;
import com.fullstory.rust.RustInterface;
import java.nio.ByteBuffer;

/* renamed from: fsimpl.af */
/* loaded from: classes.dex */
public class C0228af {

    /* renamed from: a */
    private final Context f7848a;
    private final bG b;
    private final C0320dr c;
    private final C0376z d;
    private final C0240ar e;
    private final C0360j f;
    private final RustInterface g;
    private final C0232aj h;
    private final N i;
    private final WebViewTracker j;
    private final aA k;
    private final A l;
    private final boolean m;

    public C0228af(Context context, bG bGVar, C0320dr c0320dr, C0376z c0376z, C0240ar c0240ar, C0360j c0360j, RustInterface rustInterface, C0232aj c0232aj, N n, WebViewTracker webViewTracker, aA aAVar, A a2, boolean z) {
        this.f7848a = context;
        this.b = bGVar;
        this.c = c0320dr;
        this.d = c0376z;
        this.e = c0240ar;
        this.f = c0360j;
        this.g = rustInterface;
        this.h = c0232aj;
        this.i = n;
        this.j = webViewTracker;
        this.k = aAVar;
        this.l = a2;
        this.m = z;
    }

    public C0226ad a(C0230ah c0230ah) {
        if (this.b.b(this.f7848a)) {
            C0252bc c0252bc = new C0252bc();
            aQ aQVar = new aQ(new aI());
            aD aDVar = new aD();
            aO aOVar = new aO();
            C0311dh c0311dh = new C0311dh(this.k, this.b.u());
            this.k.a(c0311dh);
            C0367q c0367q = new C0367q(this.b, c0230ah, c0311dh);
            C0366p c0366p = new C0366p();
            C0244av.a();
            C c = new C(this.f, this.g, c0367q);
            J j = new J(this.g, c, c0366p);
            C0315dl c0315dl = new C0315dl(this.g, c0230ah, this.c);
            C0231ai c0231ai = new C0231ai(j, c, c0315dl);
            c0231ai.a();
            C0275bz c0275bz = new C0275bz();
            bA bAVar = new bA(this.b);
            aX aXVar = new aX();
            cQ cQVar = new cQ(ByteBuffer.allocate(3072));
            aK aKVar = new aK(new aE(c0230ah, this.c, c0275bz, c0315dl, this.d), bAVar, c0275bz, aXVar);
            aU aUVar = new aU(this.g);
            return new C0226ad(this.g, c0230ah, this.f7848a, new C0235am(c0275bz, this.e, this.j, c0366p, c0367q, new C0224ab(this.b, c0275bz, aDVar, this.h, aOVar, cQVar, bAVar, this.m), c0311dh, c0230ah.t(), this.b.u(), this.l.getFragmentSupport()), c0252bc, aQVar, aKVar, aUVar, c0231ai, this.i, this.j, c0311dh, this.b.r());
        }
        return null;
    }
}
