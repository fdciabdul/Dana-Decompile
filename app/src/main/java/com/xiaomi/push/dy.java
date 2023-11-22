package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class dy implements ef<dy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public dk f327a;

    /* renamed from: a  reason: collision with other field name */
    public String f328a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f329a;

    /* renamed from: b  reason: collision with other field name */
    public String f330b;

    /* renamed from: c  reason: collision with other field name */
    public String f331c;

    /* renamed from: d  reason: collision with other field name */
    public String f332d;

    /* renamed from: e  reason: collision with other field name */
    public String f333e;

    /* renamed from: f  reason: collision with other field name */
    public String f334f;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f326a = new eu("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7781a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 15, 8);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r2.f328a.compareTo(r3.f328a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r2.f330b.compareTo(r3.f330b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r2.f331c.compareTo(r3.f331c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r2.f332d.compareTo(r3.f332d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r2.f333e.compareTo(r3.f333e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r2.f334f.compareTo(r3.f334f);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dy r3) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dy.compareTo(com.xiaomi.push.dy):int");
    }

    public dy a(String str) {
        this.f330b = str;
        return this;
    }

    public void a() {
        if (this.f330b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f331c == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f332d != null) {
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
                        this.f328a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f327a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f330b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f331c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f332d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f333e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f334f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 15) {
                        break;
                    } else {
                        en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        this.f329a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                        for (int i = 0; i < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                            this.f329a.add(epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m354a() {
        return this.f328a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m355a(dy dyVar) {
        if (dyVar == null) {
            return false;
        }
        boolean m354a = m354a();
        boolean m354a2 = dyVar.m354a();
        if ((m354a || m354a2) && !(m354a && m354a2 && this.f328a.equals(dyVar.f328a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dyVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f327a.m289a(dyVar.f327a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dyVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f330b.equals(dyVar.f330b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f331c.equals(dyVar.f331c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f332d.equals(dyVar.f332d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f333e.equals(dyVar.f333e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f334f.equals(dyVar.f334f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dyVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f329a.equals(dyVar.f329a);
        }
        return true;
    }

    public dy b(String str) {
        this.f331c = str;
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f328a != null && m354a()) {
            epVar.PlaceComponentResult(f7781a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f328a);
        }
        if (this.f327a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f327a.b(epVar);
        }
        if (this.f330b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f330b);
        }
        if (this.f331c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f331c);
        }
        if (this.f332d != null) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f332d);
        }
        if (this.f333e != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f333e);
        }
        if (this.f334f != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f334f);
        }
        if (this.f329a != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 11, this.f329a.size()));
            Iterator<String> it = this.f329a.iterator();
            while (it.hasNext()) {
                epVar.BuiltInFictitiousFunctionClassFactory(it.next());
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean b() {
        return this.f327a != null;
    }

    public dy c(String str) {
        this.f332d = str;
        return this;
    }

    public boolean c() {
        return this.f330b != null;
    }

    public dy d(String str) {
        this.f333e = str;
        return this;
    }

    public boolean d() {
        return this.f331c != null;
    }

    public dy e(String str) {
        this.f334f = str;
        return this;
    }

    public boolean e() {
        return this.f332d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dy)) {
            return m355a((dy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f333e != null;
    }

    public boolean g() {
        return this.f334f != null;
    }

    public boolean h() {
        return this.f329a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m354a()) {
            sb.append("debug:");
            String str = this.f328a;
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
            dk dkVar = this.f327a;
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
        String str2 = this.f330b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f331c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f332d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f333e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f334f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f329a;
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
