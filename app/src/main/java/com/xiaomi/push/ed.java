package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class ed implements ef<ed, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f381a;

    /* renamed from: a  reason: collision with other field name */
    public dk f382a;

    /* renamed from: a  reason: collision with other field name */
    public String f383a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f384a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f385b;

    /* renamed from: c  reason: collision with other field name */
    public String f386c;

    /* renamed from: d  reason: collision with other field name */
    public String f387d;

    /* renamed from: e  reason: collision with other field name */
    public String f388e;

    /* renamed from: f  reason: collision with other field name */
    public String f389f;

    /* renamed from: g  reason: collision with other field name */
    public String f390g;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f380a = new eu("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7786a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 8);
    private static final em h = new em("", (byte) 11, 9);
    private static final em i = new em("", (byte) 11, 10);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f383a.compareTo(r5.f383a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f385b.compareTo(r5.f385b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f386c.compareTo(r5.f386c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f387d.compareTo(r5.f387d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f388e.compareTo(r5.f388e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0158, code lost:
    
        r0 = r4.f389f.compareTo(r5.f389f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r5 = r4.f390g.compareTo(r5.f390g);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.ed r5) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ed.compareTo(com.xiaomi.push.ed):int");
    }

    public String a() {
        return this.f385b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m368a() {
        if (this.f385b != null) {
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
                m368a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f383a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f382a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f385b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f386c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f381a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f387d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f388e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f389f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f390g = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f384a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m369a() {
        return this.f383a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m370a(ed edVar) {
        if (edVar == null) {
            return false;
        }
        boolean m369a = m369a();
        boolean m369a2 = edVar.m369a();
        if ((m369a || m369a2) && !(m369a && m369a2 && this.f383a.equals(edVar.f383a))) {
            return false;
        }
        boolean m371b = m371b();
        boolean m371b2 = edVar.m371b();
        if ((m371b || m371b2) && !(m371b && m371b2 && this.f382a.m289a(edVar.f382a))) {
            return false;
        }
        boolean m372c = m372c();
        boolean m372c2 = edVar.m372c();
        if ((m372c || m372c2) && !(m372c && m372c2 && this.f385b.equals(edVar.f385b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = edVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f386c.equals(edVar.f386c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = edVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f381a == edVar.f381a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = edVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f387d.equals(edVar.f387d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = edVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f388e.equals(edVar.f388e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = edVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f389f.equals(edVar.f389f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = edVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f390g.equals(edVar.f390g);
        }
        return true;
    }

    public String b() {
        return this.f388e;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m368a();
        if (this.f383a != null && m369a()) {
            epVar.PlaceComponentResult(f7786a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f383a);
        }
        if (this.f382a != null && m371b()) {
            epVar.PlaceComponentResult(b);
            this.f382a.b(epVar);
        }
        if (this.f385b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f385b);
        }
        if (this.f386c != null && d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f386c);
        }
        if (e()) {
            epVar.PlaceComponentResult(e);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f381a);
        }
        if (this.f387d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f387d);
        }
        if (this.f388e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f388e);
        }
        if (this.f389f != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f389f);
        }
        if (this.f390g != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f390g);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m371b() {
        return this.f382a != null;
    }

    public String c() {
        return this.f390g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m372c() {
        return this.f385b != null;
    }

    public boolean d() {
        return this.f386c != null;
    }

    public boolean e() {
        return this.f384a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ed)) {
            return m370a((ed) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f387d != null;
    }

    public boolean g() {
        return this.f388e != null;
    }

    public boolean h() {
        return this.f389f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f390g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m369a()) {
            sb.append("debug:");
            String str = this.f383a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m371b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f382a;
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
        String str2 = this.f385b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f386c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f381a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f387d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f388e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f389f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f390g;
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
