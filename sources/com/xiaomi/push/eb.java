package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class eb implements ef<eb, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f361a;

    /* renamed from: a  reason: collision with other field name */
    public dk f362a;

    /* renamed from: a  reason: collision with other field name */
    public String f363a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f364a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f365b;

    /* renamed from: b  reason: collision with other field name */
    public String f366b;

    /* renamed from: c  reason: collision with other field name */
    public long f367c;

    /* renamed from: c  reason: collision with other field name */
    public String f368c;

    /* renamed from: d  reason: collision with other field name */
    public String f369d;

    /* renamed from: e  reason: collision with other field name */
    public String f370e;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f360a = new eu("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7784a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 8);
    private static final em h = new em("", (byte) 10, 9);
    private static final em i = new em("", (byte) 10, 10);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f363a.compareTo(r5.f363a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f366b.compareTo(r5.f366b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f368c.compareTo(r5.f368c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f369d.compareTo(r5.f369d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f370e.compareTo(r5.f370e);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.eb r5) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.eb.compareTo(com.xiaomi.push.eb):int");
    }

    public String a() {
        return this.f370e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m363a() {
        if (this.f366b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f368c != null) {
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
                    m363a();
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
                        this.f363a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f362a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f366b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f368c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f361a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f369d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f370e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f365b = epVar.MyBillsEntityDataFactory();
                        b(true);
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f367c = epVar.MyBillsEntityDataFactory();
                        c(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f364a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a() {
        return this.f363a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a(eb ebVar) {
        if (ebVar == null) {
            return false;
        }
        boolean m364a = m364a();
        boolean m364a2 = ebVar.m364a();
        if ((m364a || m364a2) && !(m364a && m364a2 && this.f363a.equals(ebVar.f363a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ebVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f362a.m289a(ebVar.f362a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ebVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f366b.equals(ebVar.f366b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ebVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f368c.equals(ebVar.f368c))) || this.f361a != ebVar.f361a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ebVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f369d.equals(ebVar.f369d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ebVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f370e.equals(ebVar.f370e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ebVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f365b == ebVar.f365b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ebVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f367c == ebVar.f367c;
        }
        return true;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m363a();
        if (this.f363a != null && m364a()) {
            epVar.PlaceComponentResult(f7784a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f363a);
        }
        if (this.f362a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f362a.b(epVar);
        }
        if (this.f366b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f366b);
        }
        if (this.f368c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f368c);
        }
        epVar.PlaceComponentResult(e);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f361a);
        if (this.f369d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f369d);
        }
        if (this.f370e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f370e);
        }
        if (h()) {
            epVar.PlaceComponentResult(h);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f365b);
        }
        if (i()) {
            epVar.PlaceComponentResult(i);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f367c);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f364a.set(1, z);
    }

    public boolean b() {
        return this.f362a != null;
    }

    public void c(boolean z) {
        this.f364a.set(2, z);
    }

    public boolean c() {
        return this.f366b != null;
    }

    public boolean d() {
        return this.f368c != null;
    }

    public boolean e() {
        return this.f364a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof eb)) {
            return m365a((eb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f369d != null;
    }

    public boolean g() {
        return this.f370e != null;
    }

    public boolean h() {
        return this.f364a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f364a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m364a()) {
            sb.append("debug:");
            String str = this.f363a;
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
            dk dkVar = this.f362a;
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
        String str2 = this.f366b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f368c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f361a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f369d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f370e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f365b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f367c);
        }
        sb.append(")");
        return sb.toString();
    }
}
