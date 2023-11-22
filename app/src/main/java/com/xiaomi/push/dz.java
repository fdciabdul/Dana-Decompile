package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dz implements ef<dz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f336a;

    /* renamed from: a  reason: collision with other field name */
    public dk f337a;

    /* renamed from: a  reason: collision with other field name */
    public String f338a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f339a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f340b;

    /* renamed from: c  reason: collision with other field name */
    public String f341c;

    /* renamed from: d  reason: collision with other field name */
    public String f342d;

    /* renamed from: e  reason: collision with other field name */
    public String f343e;

    /* renamed from: f  reason: collision with other field name */
    public String f344f;

    /* renamed from: g  reason: collision with other field name */
    public String f345g;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f335a = new eu("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7782a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 8);
    private static final em h = new em("", (byte) 11, 9);
    private static final em i = new em("", (byte) 11, 10);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f338a.compareTo(r5.f338a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f340b.compareTo(r5.f340b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f341c.compareTo(r5.f341c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f342d.compareTo(r5.f342d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f343e.compareTo(r5.f343e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f344f.compareTo(r5.f344f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r5 = r4.f345g.compareTo(r5.f345g);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dz r5) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dz.compareTo(com.xiaomi.push.dz):int");
    }

    public String a() {
        return this.f340b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m356a() {
        if (this.f340b != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'id' was not present! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m356a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f338a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f337a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f340b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f341c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f336a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f342d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f343e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f344f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f345g = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f339a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a() {
        return this.f338a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m358a(dz dzVar) {
        if (dzVar == null) {
            return false;
        }
        boolean m357a = m357a();
        boolean m357a2 = dzVar.m357a();
        if ((m357a || m357a2) && !(m357a && m357a2 && this.f338a.equals(dzVar.f338a))) {
            return false;
        }
        boolean m359b = m359b();
        boolean m359b2 = dzVar.m359b();
        if ((m359b || m359b2) && !(m359b && m359b2 && this.f337a.m289a(dzVar.f337a))) {
            return false;
        }
        boolean m360c = m360c();
        boolean m360c2 = dzVar.m360c();
        if ((m360c || m360c2) && !(m360c && m360c2 && this.f340b.equals(dzVar.f340b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dzVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f341c.equals(dzVar.f341c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f336a == dzVar.f336a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f342d.equals(dzVar.f342d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f343e.equals(dzVar.f343e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f344f.equals(dzVar.f344f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dzVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f345g.equals(dzVar.f345g);
        }
        return true;
    }

    public String b() {
        return this.f343e;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m356a();
        if (this.f338a != null && m357a()) {
            epVar.PlaceComponentResult(f7782a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f338a);
        }
        if (this.f337a != null && m359b()) {
            epVar.PlaceComponentResult(b);
            this.f337a.b(epVar);
        }
        if (this.f340b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f340b);
        }
        if (this.f341c != null && d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f341c);
        }
        if (e()) {
            epVar.PlaceComponentResult(e);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f336a);
        }
        if (this.f342d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f342d);
        }
        if (this.f343e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f343e);
        }
        if (this.f344f != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f344f);
        }
        if (this.f345g != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f345g);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m359b() {
        return this.f337a != null;
    }

    public String c() {
        return this.f345g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m360c() {
        return this.f340b != null;
    }

    public boolean d() {
        return this.f341c != null;
    }

    public boolean e() {
        return this.f339a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dz)) {
            return m358a((dz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f342d != null;
    }

    public boolean g() {
        return this.f343e != null;
    }

    public boolean h() {
        return this.f344f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f345g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m357a()) {
            sb.append("debug:");
            String str = this.f338a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m359b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f337a;
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
        String str2 = this.f340b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f341c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f336a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f342d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f343e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f344f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f345g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
