package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dv implements ef<dv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f284a;

    /* renamed from: a  reason: collision with other field name */
    public long f285a;

    /* renamed from: a  reason: collision with other field name */
    public dk f286a;

    /* renamed from: a  reason: collision with other field name */
    public String f287a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f288a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f289b;

    /* renamed from: b  reason: collision with other field name */
    public long f290b;

    /* renamed from: b  reason: collision with other field name */
    public String f291b;

    /* renamed from: c  reason: collision with other field name */
    public long f292c;

    /* renamed from: c  reason: collision with other field name */
    public String f293c;

    /* renamed from: d  reason: collision with other field name */
    public String f294d;

    /* renamed from: e  reason: collision with other field name */
    public String f295e;

    /* renamed from: f  reason: collision with other field name */
    public String f296f;

    /* renamed from: g  reason: collision with other field name */
    public String f297g;

    /* renamed from: h  reason: collision with other field name */
    public String f298h;

    /* renamed from: i  reason: collision with other field name */
    public String f299i;

    /* renamed from: j  reason: collision with other field name */
    public String f300j;

    /* renamed from: k  reason: collision with other field name */
    public String f301k;

    /* renamed from: l  reason: collision with other field name */
    public String f302l;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f283a = new eu("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7777a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 8);
    private static final em h = new em("", (byte) 11, 9);
    private static final em i = new em("", (byte) 11, 10);
    private static final em j = new em("", (byte) 10, 11);
    private static final em k = new em("", (byte) 11, 12);
    private static final em l = new em("", (byte) 11, 13);
    private static final em m = new em("", (byte) 10, 14);
    private static final em n = new em("", (byte) 11, 15);

    /* renamed from: o  reason: collision with root package name */
    private static final em f7778o = new em("", (byte) 8, 16);
    private static final em p = new em("", (byte) 11, 17);
    private static final em q = new em("", (byte) 8, 18);
    private static final em r = new em("", (byte) 11, 19);

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
    
        r0 = r4.f300j.compareTo(r5.f300j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f287a.compareTo(r5.f287a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0298, code lost:
    
        r0 = r4.f301k.compareTo(r5.f301k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02e8, code lost:
    
        r5 = r4.f302l.compareTo(r5.f302l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f291b.compareTo(r5.f291b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f293c.compareTo(r5.f293c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f294d.compareTo(r5.f294d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f295e.compareTo(r5.f295e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f296f.compareTo(r5.f296f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f297g.compareTo(r5.f297g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        r0 = r4.f298h.compareTo(r5.f298h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f8, code lost:
    
        r0 = r4.f299i.compareTo(r5.f299i);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dv r5) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dv.compareTo(com.xiaomi.push.dv):int");
    }

    public long a() {
        return this.f285a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m337a() {
        return this.f291b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m338a() {
        if (this.f291b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f293c != null) {
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                if (e()) {
                    m338a();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'errorCode' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new eq(sb.toString());
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f287a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f286a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f291b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f293c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f285a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f294d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f295e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f296f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f297g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f290b = epVar.MyBillsEntityDataFactory();
                        b(true);
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f298h = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f299i = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 14:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f292c = epVar.MyBillsEntityDataFactory();
                        c(true);
                        continue;
                    }
                case 15:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f300j = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 16:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f284a = epVar.getAuthRequestContext();
                        d(true);
                        continue;
                    }
                case 17:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f301k = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 18:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f289b = epVar.getAuthRequestContext();
                        e(true);
                        continue;
                    }
                case 19:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f302l = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f288a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        return this.f287a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m340a(dv dvVar) {
        if (dvVar == null) {
            return false;
        }
        boolean m339a = m339a();
        boolean m339a2 = dvVar.m339a();
        if ((m339a || m339a2) && !(m339a && m339a2 && this.f287a.equals(dvVar.f287a))) {
            return false;
        }
        boolean m341b = m341b();
        boolean m341b2 = dvVar.m341b();
        if ((m341b || m341b2) && !(m341b && m341b2 && this.f286a.m289a(dvVar.f286a))) {
            return false;
        }
        boolean m342c = m342c();
        boolean m342c2 = dvVar.m342c();
        if ((m342c || m342c2) && !(m342c && m342c2 && this.f291b.equals(dvVar.f291b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dvVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f293c.equals(dvVar.f293c))) || this.f285a != dvVar.f285a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dvVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f294d.equals(dvVar.f294d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dvVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f295e.equals(dvVar.f295e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dvVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f296f.equals(dvVar.f296f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dvVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f297g.equals(dvVar.f297g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dvVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f290b == dvVar.f290b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dvVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f298h.equals(dvVar.f298h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dvVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f299i.equals(dvVar.f299i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dvVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f292c == dvVar.f292c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dvVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f300j.equals(dvVar.f300j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dvVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f284a == dvVar.f284a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dvVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f301k.equals(dvVar.f301k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dvVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f289b == dvVar.f289b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dvVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f302l.equals(dvVar.f302l);
        }
        return true;
    }

    public String b() {
        return this.f296f;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m338a();
        if (this.f287a != null && m339a()) {
            epVar.PlaceComponentResult(f7777a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f287a);
        }
        if (this.f286a != null && m341b()) {
            epVar.PlaceComponentResult(b);
            this.f286a.b(epVar);
        }
        if (this.f291b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f291b);
        }
        if (this.f293c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f293c);
        }
        epVar.PlaceComponentResult(e);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f285a);
        if (this.f294d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f294d);
        }
        if (this.f295e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f295e);
        }
        if (this.f296f != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f296f);
        }
        if (this.f297g != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f297g);
        }
        if (j()) {
            epVar.PlaceComponentResult(j);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f290b);
        }
        if (this.f298h != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f298h);
        }
        if (this.f299i != null && l()) {
            epVar.PlaceComponentResult(l);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f299i);
        }
        if (m()) {
            epVar.PlaceComponentResult(m);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f292c);
        }
        if (this.f300j != null && n()) {
            epVar.PlaceComponentResult(n);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f300j);
        }
        if (o()) {
            epVar.PlaceComponentResult(f7778o);
            epVar.MyBillsEntityDataFactory(this.f284a);
        }
        if (this.f301k != null && p()) {
            epVar.PlaceComponentResult(p);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f301k);
        }
        if (q()) {
            epVar.PlaceComponentResult(q);
            epVar.MyBillsEntityDataFactory(this.f289b);
        }
        if (this.f302l != null && r()) {
            epVar.PlaceComponentResult(r);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f302l);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f288a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m341b() {
        return this.f286a != null;
    }

    public String c() {
        return this.f297g;
    }

    public void c(boolean z) {
        this.f288a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m342c() {
        return this.f291b != null;
    }

    public void d(boolean z) {
        this.f288a.set(3, z);
    }

    public boolean d() {
        return this.f293c != null;
    }

    public void e(boolean z) {
        this.f288a.set(4, z);
    }

    public boolean e() {
        return this.f288a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dv)) {
            return m340a((dv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f294d != null;
    }

    public boolean g() {
        return this.f295e != null;
    }

    public boolean h() {
        return this.f296f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f297g != null;
    }

    public boolean j() {
        return this.f288a.get(1);
    }

    public boolean k() {
        return this.f298h != null;
    }

    public boolean l() {
        return this.f299i != null;
    }

    public boolean m() {
        return this.f288a.get(2);
    }

    public boolean n() {
        return this.f300j != null;
    }

    public boolean o() {
        return this.f288a.get(3);
    }

    public boolean p() {
        return this.f301k != null;
    }

    public boolean q() {
        return this.f288a.get(4);
    }

    public boolean r() {
        return this.f302l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m339a()) {
            sb.append("debug:");
            String str = this.f287a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m341b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f286a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f291b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aw.BuiltInFictitiousFunctionClassFactory(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f293c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f285a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f294d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f295e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f297g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f290b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f298h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f299i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f292c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f300j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f284a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f301k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f289b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f302l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
