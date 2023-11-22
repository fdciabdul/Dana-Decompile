package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class ec implements ef<ec, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public dk f372a;

    /* renamed from: a  reason: collision with other field name */
    public String f373a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f374a;

    /* renamed from: b  reason: collision with other field name */
    public String f375b;

    /* renamed from: c  reason: collision with other field name */
    public String f376c;

    /* renamed from: d  reason: collision with other field name */
    public String f377d;

    /* renamed from: e  reason: collision with other field name */
    public String f378e;

    /* renamed from: f  reason: collision with other field name */
    public String f379f;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f371a = new eu("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7785a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 15, 8);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r2.f373a.compareTo(r3.f373a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r2.f375b.compareTo(r3.f375b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r2.f376c.compareTo(r3.f376c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r2.f377d.compareTo(r3.f377d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r2.f378e.compareTo(r3.f378e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r2.f379f.compareTo(r3.f379f);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.ec r3) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ec.compareTo(com.xiaomi.push.ec):int");
    }

    public ec a(String str) {
        this.f375b = str;
        return this;
    }

    public void a() {
        if (this.f375b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f376c == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f377d != null) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'topic' was not present! Struct: ");
            sb3.append(toString());
            throw new eq(sb3.toString());
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
                        this.f373a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f372a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f375b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f376c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f377d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f378e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f379f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 15) {
                        break;
                    } else {
                        en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        this.f374a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                        for (int i = 0; i < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                            this.f374a.add(epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a() {
        return this.f373a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m367a(ec ecVar) {
        if (ecVar == null) {
            return false;
        }
        boolean m366a = m366a();
        boolean m366a2 = ecVar.m366a();
        if ((m366a || m366a2) && !(m366a && m366a2 && this.f373a.equals(ecVar.f373a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ecVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f372a.m289a(ecVar.f372a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ecVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f375b.equals(ecVar.f375b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ecVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f376c.equals(ecVar.f376c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ecVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f377d.equals(ecVar.f377d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ecVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f378e.equals(ecVar.f378e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ecVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f379f.equals(ecVar.f379f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ecVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f374a.equals(ecVar.f374a);
        }
        return true;
    }

    public ec b(String str) {
        this.f376c = str;
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f373a != null && m366a()) {
            epVar.PlaceComponentResult(f7785a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f373a);
        }
        if (this.f372a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f372a.b(epVar);
        }
        if (this.f375b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f375b);
        }
        if (this.f376c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f376c);
        }
        if (this.f377d != null) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f377d);
        }
        if (this.f378e != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f378e);
        }
        if (this.f379f != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f379f);
        }
        if (this.f374a != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 11, this.f374a.size()));
            Iterator<String> it = this.f374a.iterator();
            while (it.hasNext()) {
                epVar.BuiltInFictitiousFunctionClassFactory(it.next());
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean b() {
        return this.f372a != null;
    }

    public ec c(String str) {
        this.f377d = str;
        return this;
    }

    public boolean c() {
        return this.f375b != null;
    }

    public ec d(String str) {
        this.f378e = str;
        return this;
    }

    public boolean d() {
        return this.f376c != null;
    }

    public ec e(String str) {
        this.f379f = str;
        return this;
    }

    public boolean e() {
        return this.f377d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ec)) {
            return m367a((ec) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f378e != null;
    }

    public boolean g() {
        return this.f379f != null;
    }

    public boolean h() {
        return this.f374a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m366a()) {
            sb.append("debug:");
            String str = this.f373a;
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
            dk dkVar = this.f372a;
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
        String str2 = this.f375b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f376c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f377d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f378e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f379f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f374a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
