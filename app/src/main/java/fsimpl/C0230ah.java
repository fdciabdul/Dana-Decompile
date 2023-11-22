package fsimpl;

import java.net.URL;

/* renamed from: fsimpl.ah  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0230ah {

    /* renamed from: a  reason: collision with root package name */
    private final bG f7850a;
    private boolean b;
    private C0307dd c;
    private C0307dd d;
    private C0307dd e;
    private C0307dd f;
    private C0307dd g;
    private C0307dd h;
    private String i;
    private String j;
    private String k;
    private URL l;
    private URL m;
    private URL n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7851o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u = false;

    public C0230ah(bG bGVar) {
        this.f7850a = bGVar;
    }

    private static boolean b(byte b) {
        return b != 1 && b == 2;
    }

    public String a() {
        return this.k;
    }

    public void a(byte b) {
        this.u = b(b);
    }

    public void a(C0307dd c0307dd) {
        this.c = c0307dd;
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(URL url) {
        this.l = url;
    }

    public void a(boolean z) {
        this.f7851o = z;
    }

    public String b() {
        return this.i;
    }

    public void b(C0307dd c0307dd) {
        this.d = c0307dd;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(URL url) {
        this.m = url;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public String c() {
        return this.j;
    }

    public void c(C0307dd c0307dd) {
        this.e = c0307dd;
    }

    public void c(String str) {
        this.j = str;
    }

    public void c(URL url) {
        this.n = url;
    }

    public void c(boolean z) {
        this.p = z;
    }

    public void d(C0307dd c0307dd) {
        this.f = c0307dd;
    }

    public void d(boolean z) {
        this.q = z;
    }

    public boolean d() {
        return this.f7851o;
    }

    public void e(C0307dd c0307dd) {
        this.g = c0307dd;
    }

    public void e(boolean z) {
        this.r = z;
    }

    public boolean e() {
        return this.b;
    }

    public C0307dd f() {
        return this.c;
    }

    public void f(C0307dd c0307dd) {
        this.h = c0307dd;
    }

    public void f(boolean z) {
        this.s = z;
    }

    public C0307dd g() {
        return this.d;
    }

    public void g(boolean z) {
        this.t = z;
    }

    public C0307dd h() {
        return this.e;
    }

    public String h(boolean z) {
        String str = null;
        if (e()) {
            String h = this.f7850a.h();
            String a2 = a();
            if (h != null && a2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(h);
                sb.append("/ui/");
                sb.append(a2);
                sb.append("/session/");
                sb.append(c());
                sb.append(":");
                sb.append(b());
                str = sb.toString();
                if (z) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(":");
                    sb2.append(String.valueOf(System.currentTimeMillis()));
                    return sb2.toString();
                }
            }
        }
        return str;
    }

    public C0307dd i() {
        return this.f;
    }

    public C0307dd j() {
        return this.g;
    }

    public C0307dd k() {
        return this.h;
    }

    public URL l() {
        return this.l;
    }

    public URL m() {
        return this.m;
    }

    public URL n() {
        return this.n;
    }

    public boolean o() {
        return this.p;
    }

    public boolean p() {
        return this.q;
    }

    public boolean q() {
        return this.r;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.t;
    }

    public boolean t() {
        return this.u;
    }

    public String u() {
        if (!e() || a() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(":");
        sb.append(b());
        return sb.toString();
    }
}
