package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dh implements ef<dh, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f115a;

    /* renamed from: a  reason: collision with other field name */
    public di f116a;

    /* renamed from: a  reason: collision with other field name */
    public dk f117a;

    /* renamed from: a  reason: collision with other field name */
    public String f118a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f119a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f120a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f121b;

    /* renamed from: b  reason: collision with other field name */
    public String f122b;

    /* renamed from: c  reason: collision with other field name */
    public long f123c;

    /* renamed from: c  reason: collision with other field name */
    public String f124c;

    /* renamed from: d  reason: collision with other field name */
    public String f125d;

    /* renamed from: e  reason: collision with other field name */
    public String f126e;

    /* renamed from: f  reason: collision with other field name */
    public String f127f;

    /* renamed from: g  reason: collision with other field name */
    public String f128g;

    /* renamed from: h  reason: collision with other field name */
    public String f129h;

    /* renamed from: i  reason: collision with other field name */
    public String f130i;

    /* renamed from: j  reason: collision with other field name */
    public String f131j;

    /* renamed from: k  reason: collision with other field name */
    public String f132k;

    /* renamed from: l  reason: collision with other field name */
    public String f133l;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f114a = new eu("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7759a = new em("", (byte) 12, 1);
    private static final em b = new em("", (byte) 11, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 5);
    private static final em f = new em("", (byte) 10, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 11, 8);
    private static final em i = new em("", (byte) 11, 9);
    private static final em j = new em("", (byte) 11, 10);
    private static final em k = new em("", (byte) 11, 11);
    private static final em l = new em("", (byte) 12, 12);
    private static final em m = new em("", (byte) 11, 13);
    private static final em n = new em("", (byte) 2, 14);

    /* renamed from: o  reason: collision with root package name */
    private static final em f7760o = new em("", (byte) 11, 15);
    private static final em p = new em("", (byte) 10, 16);
    private static final em q = new em("", (byte) 11, 20);
    private static final em r = new em("", (byte) 11, 21);

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0220, code lost:
    
        r0 = r4.f130i.compareTo(r5.f130i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0270, code lost:
    
        r0 = r4.f131j.compareTo(r5.f131j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02c0, code lost:
    
        r0 = r4.f132k.compareTo(r5.f132k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02e8, code lost:
    
        r5 = r4.f133l.compareTo(r5.f133l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        r0 = r4.f118a.compareTo(r5.f118a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f122b.compareTo(r5.f122b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f124c.compareTo(r5.f124c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f125d.compareTo(r5.f125d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f126e.compareTo(r5.f126e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f127f.compareTo(r5.f127f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r0 = r4.f128g.compareTo(r5.f128g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        r0 = r4.f129h.compareTo(r5.f129h);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dh r5) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dh.compareTo(com.xiaomi.push.dh):int");
    }

    public long a() {
        return this.f115a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m269a() {
        return this.f118a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m270a() {
        if (this.f118a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f122b == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f124c != null) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'payload' was not present! Struct: ");
            sb3.append(toString());
            throw new eq(sb3.toString());
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m270a();
                return;
            }
            short s = PlaceComponentResult.MyBillsEntityDataFactory;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                dk dkVar = new dk();
                                this.f117a = dkVar;
                                dkVar.a(epVar);
                                break;
                            }
                        case 2:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f118a = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 3:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f122b = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 4:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f124c = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 5:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f115a = epVar.MyBillsEntityDataFactory();
                                a(true);
                                break;
                            }
                        case 6:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f121b = epVar.MyBillsEntityDataFactory();
                                b(true);
                                break;
                            }
                        case 7:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f125d = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 8:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f126e = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 9:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f127f = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 10:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f128g = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 11:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f129h = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 12:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                di diVar = new di();
                                this.f116a = diVar;
                                diVar.a(epVar);
                                break;
                            }
                        case 13:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f130i = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 14:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f120a = epVar.GetContactSyncConfig();
                                c(true);
                                break;
                            }
                        case 15:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f131j = epVar.getErrorConfigVersion();
                                break;
                            }
                        case 16:
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                                break;
                            } else {
                                this.f123c = epVar.MyBillsEntityDataFactory();
                                d(true);
                                break;
                            }
                        default:
                            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                            break;
                    }
                } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                    this.f133l = epVar.getErrorConfigVersion();
                } else {
                    es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                }
            } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 11) {
                this.f132k = epVar.getErrorConfigVersion();
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public void a(boolean z) {
        this.f119a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m271a() {
        return this.f117a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m272a(dh dhVar) {
        if (dhVar == null) {
            return false;
        }
        boolean m271a = m271a();
        boolean m271a2 = dhVar.m271a();
        if ((m271a || m271a2) && !(m271a && m271a2 && this.f117a.m289a(dhVar.f117a))) {
            return false;
        }
        boolean m273b = m273b();
        boolean m273b2 = dhVar.m273b();
        if ((m273b || m273b2) && !(m273b && m273b2 && this.f118a.equals(dhVar.f118a))) {
            return false;
        }
        boolean m274c = m274c();
        boolean m274c2 = dhVar.m274c();
        if ((m274c || m274c2) && !(m274c && m274c2 && this.f122b.equals(dhVar.f122b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dhVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f124c.equals(dhVar.f124c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dhVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f115a == dhVar.f115a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dhVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f121b == dhVar.f121b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dhVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f125d.equals(dhVar.f125d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dhVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f126e.equals(dhVar.f126e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dhVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f127f.equals(dhVar.f127f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dhVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f128g.equals(dhVar.f128g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dhVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f129h.equals(dhVar.f129h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dhVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f116a.m281a(dhVar.f116a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dhVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f130i.equals(dhVar.f130i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dhVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f120a == dhVar.f120a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dhVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f131j.equals(dhVar.f131j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dhVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f123c == dhVar.f123c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dhVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f132k.equals(dhVar.f132k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dhVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f133l.equals(dhVar.f133l);
        }
        return true;
    }

    public String b() {
        return this.f122b;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m270a();
        if (this.f117a != null && m271a()) {
            epVar.PlaceComponentResult(f7759a);
            this.f117a.b(epVar);
        }
        if (this.f118a != null) {
            epVar.PlaceComponentResult(b);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f118a);
        }
        if (this.f122b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f122b);
        }
        if (this.f124c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f124c);
        }
        if (e()) {
            epVar.PlaceComponentResult(e);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f115a);
        }
        if (f()) {
            epVar.PlaceComponentResult(f);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f121b);
        }
        if (this.f125d != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f125d);
        }
        if (this.f126e != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f126e);
        }
        if (this.f127f != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f127f);
        }
        if (this.f128g != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f128g);
        }
        if (this.f129h != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f129h);
        }
        if (this.f116a != null && l()) {
            epVar.PlaceComponentResult(l);
            this.f116a.b(epVar);
        }
        if (this.f130i != null && m()) {
            epVar.PlaceComponentResult(m);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f130i);
        }
        if (n()) {
            epVar.PlaceComponentResult(n);
            epVar.getAuthRequestContext(this.f120a);
        }
        if (this.f131j != null && o()) {
            epVar.PlaceComponentResult(f7760o);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f131j);
        }
        if (p()) {
            epVar.PlaceComponentResult(p);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f123c);
        }
        if (this.f132k != null && q()) {
            epVar.PlaceComponentResult(q);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f132k);
        }
        if (this.f133l != null && r()) {
            epVar.PlaceComponentResult(r);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f133l);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f119a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m273b() {
        return this.f118a != null;
    }

    public String c() {
        return this.f124c;
    }

    public void c(boolean z) {
        this.f119a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m274c() {
        return this.f122b != null;
    }

    public void d(boolean z) {
        this.f119a.set(3, z);
    }

    public boolean d() {
        return this.f124c != null;
    }

    public boolean e() {
        return this.f119a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dh)) {
            return m272a((dh) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f119a.get(1);
    }

    public boolean g() {
        return this.f125d != null;
    }

    public boolean h() {
        return this.f126e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f127f != null;
    }

    public boolean j() {
        return this.f128g != null;
    }

    public boolean k() {
        return this.f129h != null;
    }

    public boolean l() {
        return this.f116a != null;
    }

    public boolean m() {
        return this.f130i != null;
    }

    public boolean n() {
        return this.f119a.get(2);
    }

    public boolean o() {
        return this.f131j != null;
    }

    public boolean p() {
        return this.f119a.get(3);
    }

    public boolean q() {
        return this.f132k != null;
    }

    public boolean r() {
        return this.f133l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m271a()) {
            sb.append("to:");
            dk dkVar = this.f117a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f118a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f122b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f124c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f115a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f121b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f125d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f126e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f127f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f128g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f129h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            di diVar = this.f116a;
            if (diVar == null) {
                sb.append("null");
            } else {
                sb.append(diVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f130i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f120a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f131j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f123c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f132k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f133l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
