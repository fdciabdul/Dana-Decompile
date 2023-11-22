package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class du implements ef<du, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f253a;

    /* renamed from: a  reason: collision with other field name */
    public long f254a;

    /* renamed from: a  reason: collision with other field name */
    public dj f255a;

    /* renamed from: a  reason: collision with other field name */
    public dk f256a;

    /* renamed from: a  reason: collision with other field name */
    public String f257a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f259a;

    /* renamed from: b  reason: collision with other field name */
    public int f261b;

    /* renamed from: b  reason: collision with other field name */
    public long f262b;

    /* renamed from: b  reason: collision with other field name */
    public String f263b;

    /* renamed from: c  reason: collision with other field name */
    public int f265c;

    /* renamed from: c  reason: collision with other field name */
    public String f266c;

    /* renamed from: d  reason: collision with other field name */
    public String f268d;

    /* renamed from: e  reason: collision with other field name */
    public String f269e;

    /* renamed from: f  reason: collision with other field name */
    public String f270f;

    /* renamed from: g  reason: collision with other field name */
    public String f271g;

    /* renamed from: h  reason: collision with other field name */
    public String f272h;

    /* renamed from: i  reason: collision with other field name */
    public String f273i;

    /* renamed from: j  reason: collision with other field name */
    public String f274j;

    /* renamed from: k  reason: collision with other field name */
    public String f275k;

    /* renamed from: l  reason: collision with other field name */
    public String f276l;

    /* renamed from: m  reason: collision with other field name */
    public String f277m;

    /* renamed from: n  reason: collision with other field name */
    public String f278n;

    /* renamed from: o  reason: collision with other field name */
    public String f279o;

    /* renamed from: p  reason: collision with other field name */
    public String f280p;

    /* renamed from: q  reason: collision with other field name */
    public String f281q;

    /* renamed from: r  reason: collision with other field name */
    public String f282r;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f252a = new eu("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7775a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 11, 8);
    private static final em i = new em("", (byte) 11, 9);
    private static final em j = new em("", (byte) 11, 10);
    private static final em k = new em("", (byte) 11, 11);
    private static final em l = new em("", (byte) 11, 12);
    private static final em m = new em("", (byte) 8, 13);
    private static final em n = new em("", (byte) 8, 14);

    /* renamed from: o  reason: collision with root package name */
    private static final em f7776o = new em("", (byte) 11, 15);
    private static final em p = new em("", (byte) 11, 16);
    private static final em q = new em("", (byte) 11, 17);
    private static final em r = new em("", (byte) 11, 18);
    private static final em s = new em("", (byte) 8, 19);
    private static final em t = new em("", (byte) 8, 20);
    private static final em u = new em("", (byte) 2, 21);
    private static final em v = new em("", (byte) 10, 22);
    private static final em w = new em("", (byte) 10, 23);
    private static final em x = new em("", (byte) 11, 24);
    private static final em y = new em("", (byte) 11, 25);
    private static final em z = new em("", (byte) 2, 26);
    private static final em A = new em("", (byte) 13, 100);
    private static final em B = new em("", (byte) 2, 101);
    private static final em C = new em("", (byte) 11, 102);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f258a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public boolean f260a = true;

    /* renamed from: c  reason: collision with other field name */
    public boolean f267c = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f264b = false;

    public boolean A() {
        return this.f259a != null;
    }

    public boolean B() {
        return this.f258a.get(7);
    }

    public boolean C() {
        return this.f282r != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f257a.compareTo(r5.f257a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0270, code lost:
    
        r0 = r4.f276l.compareTo(r5.f276l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0298, code lost:
    
        r0 = r4.f277m.compareTo(r5.f277m);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02c0, code lost:
    
        r0 = r4.f278n.compareTo(r5.f278n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02e8, code lost:
    
        r0 = r4.f279o.compareTo(r5.f279o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03d8, code lost:
    
        r0 = r4.f280p.compareTo(r5.f280p);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0400, code lost:
    
        r0 = r4.f281q.compareTo(r5.f281q);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04a0, code lost:
    
        r5 = r4.f282r.compareTo(r5.f282r);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f263b.compareTo(r5.f263b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f266c.compareTo(r5.f266c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r4.f268d.compareTo(r5.f268d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f269e.compareTo(r5.f269e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f270f.compareTo(r5.f270f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f271g.compareTo(r5.f271g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f272h.compareTo(r5.f272h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r0 = r4.f273i.compareTo(r5.f273i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        r0 = r4.f274j.compareTo(r5.f274j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f8, code lost:
    
        r0 = r4.f275k.compareTo(r5.f275k);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.du r5) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.du.compareTo(com.xiaomi.push.du):int");
    }

    public du a(int i2) {
        this.f253a = i2;
        a(true);
        return this;
    }

    public du a(dj djVar) {
        this.f255a = djVar;
        return this;
    }

    public du a(String str) {
        this.f263b = str;
        return this;
    }

    public String a() {
        return this.f263b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m332a() {
        if (this.f263b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f266c == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f270f != null) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'token' was not present! Struct: ");
            sb3.append(toString());
            throw new eq(sb3.toString());
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m332a();
                return;
            }
            short s2 = PlaceComponentResult.MyBillsEntityDataFactory;
            switch (s2) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f257a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f256a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f263b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f266c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f268d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f269e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f270f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f271g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f272h = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f273i = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f274j = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f275k = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f253a = epVar.getAuthRequestContext();
                        a(true);
                        continue;
                    }
                case 14:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f261b = epVar.getAuthRequestContext();
                        b(true);
                        continue;
                    }
                case 15:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f276l = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 16:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f277m = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 17:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f278n = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 18:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f279o = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 19:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f265c = epVar.getAuthRequestContext();
                        c(true);
                        continue;
                    }
                case 20:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f255a = dj.a(epVar.getAuthRequestContext());
                        continue;
                    }
                case 21:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f260a = epVar.GetContactSyncConfig();
                        d(true);
                        continue;
                    }
                case 22:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f254a = epVar.MyBillsEntityDataFactory();
                        e(true);
                        continue;
                    }
                case 23:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f262b = epVar.MyBillsEntityDataFactory();
                        f(true);
                        continue;
                    }
                case 24:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f280p = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 25:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f281q = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 26:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f264b = epVar.GetContactSyncConfig();
                        g(true);
                        continue;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 13) {
                                eo moveToNextValue = epVar.moveToNextValue();
                                this.f259a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                                for (int i2 = 0; i2 < moveToNextValue.PlaceComponentResult; i2++) {
                                    this.f259a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                                }
                                break;
                            } else {
                                break;
                            }
                        case 101:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                                break;
                            } else {
                                this.f267c = epVar.GetContactSyncConfig();
                                h(true);
                                continue;
                            }
                        case 102:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                                this.f282r = epVar.getErrorConfigVersion();
                                break;
                            } else {
                                break;
                            }
                    }
                    break;
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z2) {
        this.f258a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m333a() {
        return this.f257a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m334a(du duVar) {
        if (duVar == null) {
            return false;
        }
        boolean m333a = m333a();
        boolean m333a2 = duVar.m333a();
        if ((m333a || m333a2) && !(m333a && m333a2 && this.f257a.equals(duVar.f257a))) {
            return false;
        }
        boolean m335b = m335b();
        boolean m335b2 = duVar.m335b();
        if ((m335b || m335b2) && !(m335b && m335b2 && this.f256a.m289a(duVar.f256a))) {
            return false;
        }
        boolean m336c = m336c();
        boolean m336c2 = duVar.m336c();
        if ((m336c || m336c2) && !(m336c && m336c2 && this.f263b.equals(duVar.f263b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = duVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f266c.equals(duVar.f266c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = duVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f268d.equals(duVar.f268d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = duVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f269e.equals(duVar.f269e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = duVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f270f.equals(duVar.f270f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = duVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f271g.equals(duVar.f271g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = duVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f272h.equals(duVar.f272h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = duVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f273i.equals(duVar.f273i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = duVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f274j.equals(duVar.f274j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = duVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f275k.equals(duVar.f275k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = duVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f253a == duVar.f253a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = duVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f261b == duVar.f261b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = duVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f276l.equals(duVar.f276l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = duVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f277m.equals(duVar.f277m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = duVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f278n.equals(duVar.f278n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = duVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f279o.equals(duVar.f279o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = duVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f265c == duVar.f265c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = duVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f255a.equals(duVar.f255a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = duVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f260a == duVar.f260a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = duVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f254a == duVar.f254a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = duVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f262b == duVar.f262b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = duVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f280p.equals(duVar.f280p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = duVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f281q.equals(duVar.f281q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = duVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f264b == duVar.f264b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = duVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f259a.equals(duVar.f259a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = duVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f267c == duVar.f267c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = duVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f282r.equals(duVar.f282r);
        }
        return true;
    }

    public du b(int i2) {
        this.f261b = i2;
        b(true);
        return this;
    }

    public du b(String str) {
        this.f266c = str;
        return this;
    }

    public String b() {
        return this.f266c;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m332a();
        if (this.f257a != null && m333a()) {
            epVar.PlaceComponentResult(f7775a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f257a);
        }
        if (this.f256a != null && m335b()) {
            epVar.PlaceComponentResult(b);
            this.f256a.b(epVar);
        }
        if (this.f263b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f263b);
        }
        if (this.f266c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f266c);
        }
        if (this.f268d != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f268d);
        }
        if (this.f269e != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f269e);
        }
        if (this.f270f != null) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f270f);
        }
        if (this.f271g != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f271g);
        }
        if (this.f272h != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f272h);
        }
        if (this.f273i != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f273i);
        }
        if (this.f274j != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f274j);
        }
        if (this.f275k != null && l()) {
            epVar.PlaceComponentResult(l);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f275k);
        }
        if (m()) {
            epVar.PlaceComponentResult(m);
            epVar.MyBillsEntityDataFactory(this.f253a);
        }
        if (n()) {
            epVar.PlaceComponentResult(n);
            epVar.MyBillsEntityDataFactory(this.f261b);
        }
        if (this.f276l != null && o()) {
            epVar.PlaceComponentResult(f7776o);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f276l);
        }
        if (this.f277m != null && p()) {
            epVar.PlaceComponentResult(p);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f277m);
        }
        if (this.f278n != null && q()) {
            epVar.PlaceComponentResult(q);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f278n);
        }
        if (this.f279o != null && r()) {
            epVar.PlaceComponentResult(r);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f279o);
        }
        if (s()) {
            epVar.PlaceComponentResult(s);
            epVar.MyBillsEntityDataFactory(this.f265c);
        }
        if (this.f255a != null && t()) {
            epVar.PlaceComponentResult(t);
            epVar.MyBillsEntityDataFactory(this.f255a.a());
        }
        if (u()) {
            epVar.PlaceComponentResult(u);
            epVar.getAuthRequestContext(this.f260a);
        }
        if (v()) {
            epVar.PlaceComponentResult(v);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f254a);
        }
        if (w()) {
            epVar.PlaceComponentResult(w);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f262b);
        }
        if (this.f280p != null && x()) {
            epVar.PlaceComponentResult(x);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f280p);
        }
        if (this.f281q != null && y()) {
            epVar.PlaceComponentResult(y);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f281q);
        }
        if (z()) {
            epVar.PlaceComponentResult(z);
            epVar.getAuthRequestContext(this.f264b);
        }
        if (this.f259a != null && A()) {
            epVar.PlaceComponentResult(A);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f259a.size()));
            for (Map.Entry<String, String> entry : this.f259a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        if (B()) {
            epVar.PlaceComponentResult(B);
            epVar.getAuthRequestContext(this.f267c);
        }
        if (this.f282r != null && C()) {
            epVar.PlaceComponentResult(C);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f282r);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z2) {
        this.f258a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m335b() {
        return this.f256a != null;
    }

    public du c(int i2) {
        this.f265c = i2;
        c(true);
        return this;
    }

    public du c(String str) {
        this.f268d = str;
        return this;
    }

    public String c() {
        return this.f270f;
    }

    public void c(boolean z2) {
        this.f258a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m336c() {
        return this.f263b != null;
    }

    public du d(String str) {
        this.f269e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f258a.set(3, z2);
    }

    public boolean d() {
        return this.f266c != null;
    }

    public du e(String str) {
        this.f270f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f258a.set(4, z2);
    }

    public boolean e() {
        return this.f268d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof du)) {
            return m334a((du) obj);
        }
        return false;
    }

    public du f(String str) {
        this.f271g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f258a.set(5, z2);
    }

    public boolean f() {
        return this.f269e != null;
    }

    public du g(String str) {
        this.f272h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f258a.set(6, z2);
    }

    public boolean g() {
        return this.f270f != null;
    }

    public du h(String str) {
        this.f275k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f258a.set(7, z2);
    }

    public boolean h() {
        return this.f271g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f272h != null;
    }

    public boolean j() {
        return this.f273i != null;
    }

    public boolean k() {
        return this.f274j != null;
    }

    public boolean l() {
        return this.f275k != null;
    }

    public boolean m() {
        return this.f258a.get(0);
    }

    public boolean n() {
        return this.f258a.get(1);
    }

    public boolean o() {
        return this.f276l != null;
    }

    public boolean p() {
        return this.f277m != null;
    }

    public boolean q() {
        return this.f278n != null;
    }

    public boolean r() {
        return this.f279o != null;
    }

    public boolean s() {
        return this.f258a.get(2);
    }

    public boolean t() {
        return this.f255a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m333a()) {
            sb.append("debug:");
            String str = this.f257a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m335b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f256a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f263b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aw.BuiltInFictitiousFunctionClassFactory(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f266c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f268d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f269e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f270f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f271g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f272h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f273i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f274j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f275k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f253a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f261b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f276l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f277m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f278n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f279o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f265c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            dj djVar = this.f255a;
            if (djVar == null) {
                sb.append("null");
            } else {
                sb.append(djVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f260a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f254a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f262b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f280p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f281q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f264b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f259a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f267c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f282r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f258a.get(3);
    }

    public boolean v() {
        return this.f258a.get(4);
    }

    public boolean w() {
        return this.f258a.get(5);
    }

    public boolean x() {
        return this.f280p != null;
    }

    public boolean y() {
        return this.f281q != null;
    }

    public boolean z() {
        return this.f258a.get(6);
    }
}
