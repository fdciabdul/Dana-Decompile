package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class ea implements ef<ea, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f347a;

    /* renamed from: a  reason: collision with other field name */
    public dk f348a;

    /* renamed from: a  reason: collision with other field name */
    public String f349a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f350a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f351a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f352b;

    /* renamed from: c  reason: collision with other field name */
    public String f353c;

    /* renamed from: d  reason: collision with other field name */
    public String f354d;

    /* renamed from: e  reason: collision with other field name */
    public String f355e;

    /* renamed from: f  reason: collision with other field name */
    public String f356f;

    /* renamed from: g  reason: collision with other field name */
    public String f357g;

    /* renamed from: h  reason: collision with other field name */
    public String f358h;

    /* renamed from: i  reason: collision with other field name */
    public String f359i;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f346a = new eu("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7783a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 11, 8);
    private static final em i = new em("", (byte) 11, 9);
    private static final em j = new em("", (byte) 11, 10);
    private static final em k = new em("", (byte) 2, 11);
    private static final em l = new em("", (byte) 10, 12);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f349a.compareTo(r5.f349a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f352b.compareTo(r5.f352b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f353c.compareTo(r5.f353c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r4.f354d.compareTo(r5.f354d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f355e.compareTo(r5.f355e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f356f.compareTo(r5.f356f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f357g.compareTo(r5.f357g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f358h.compareTo(r5.f358h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r0 = r4.f359i.compareTo(r5.f359i);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.ea r5) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ea.compareTo(com.xiaomi.push.ea):int");
    }

    public ea a(String str) {
        this.f352b = str;
        return this;
    }

    public void a() {
        if (this.f352b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f353c != null) {
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
                a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f349a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f348a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f352b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f353c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f354d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f355e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f356f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f357g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f358h = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f359i = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f351a = epVar.GetContactSyncConfig();
                        a(true);
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f347a = epVar.MyBillsEntityDataFactory();
                        b(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f350a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m361a() {
        return this.f349a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m362a(ea eaVar) {
        if (eaVar == null) {
            return false;
        }
        boolean m361a = m361a();
        boolean m361a2 = eaVar.m361a();
        if ((m361a || m361a2) && !(m361a && m361a2 && this.f349a.equals(eaVar.f349a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = eaVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f348a.m289a(eaVar.f348a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = eaVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f352b.equals(eaVar.f352b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = eaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f353c.equals(eaVar.f353c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = eaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f354d.equals(eaVar.f354d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = eaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f355e.equals(eaVar.f355e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = eaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f356f.equals(eaVar.f356f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = eaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f357g.equals(eaVar.f357g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = eaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f358h.equals(eaVar.f358h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = eaVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f359i.equals(eaVar.f359i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = eaVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f351a == eaVar.f351a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = eaVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f347a == eaVar.f347a;
        }
        return true;
    }

    public ea b(String str) {
        this.f353c = str;
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f349a != null && m361a()) {
            epVar.PlaceComponentResult(f7783a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f349a);
        }
        if (this.f348a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f348a.b(epVar);
        }
        if (this.f352b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f352b);
        }
        if (this.f353c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f353c);
        }
        if (this.f354d != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f354d);
        }
        if (this.f355e != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f355e);
        }
        if (this.f356f != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f356f);
        }
        if (this.f357g != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f357g);
        }
        if (this.f358h != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f358h);
        }
        if (this.f359i != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f359i);
        }
        if (k()) {
            epVar.PlaceComponentResult(k);
            epVar.getAuthRequestContext(this.f351a);
        }
        if (l()) {
            epVar.PlaceComponentResult(l);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f347a);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f350a.set(1, z);
    }

    public boolean b() {
        return this.f348a != null;
    }

    public ea c(String str) {
        this.f354d = str;
        return this;
    }

    public boolean c() {
        return this.f352b != null;
    }

    public ea d(String str) {
        this.f356f = str;
        return this;
    }

    public boolean d() {
        return this.f353c != null;
    }

    public ea e(String str) {
        this.f357g = str;
        return this;
    }

    public boolean e() {
        return this.f354d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ea)) {
            return m362a((ea) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f355e != null;
    }

    public boolean g() {
        return this.f356f != null;
    }

    public boolean h() {
        return this.f357g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f358h != null;
    }

    public boolean j() {
        return this.f359i != null;
    }

    public boolean k() {
        return this.f350a.get(0);
    }

    public boolean l() {
        return this.f350a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m361a()) {
            sb.append("debug:");
            String str = this.f349a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f348a;
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
        String str2 = this.f352b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f353c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f354d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f355e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f356f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f357g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f358h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f359i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f351a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f347a);
        }
        sb.append(")");
        return sb.toString();
    }
}
