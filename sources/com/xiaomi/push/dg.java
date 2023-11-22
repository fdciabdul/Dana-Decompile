package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dg implements ef<dg, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f106a;

    /* renamed from: a  reason: collision with other field name */
    public long f107a;

    /* renamed from: a  reason: collision with other field name */
    public String f108a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f109a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f110a;

    /* renamed from: b  reason: collision with other field name */
    public int f111b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f112b;

    /* renamed from: c  reason: collision with other field name */
    public int f113c;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f105a = new eu("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7758a = new em("", (byte) 8, 1);
    private static final em b = new em("", (byte) 8, 2);
    private static final em c = new em("", (byte) 2, 3);
    private static final em d = new em("", (byte) 8, 4);
    private static final em e = new em("", (byte) 10, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 2, 7);

    public int a() {
        return this.f106a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f108a.compareTo(r5.f108a);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dg r5) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dg.compareTo(com.xiaomi.push.dg):int");
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m262a() {
        return this.f107a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m263a() {
        return this.f108a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m264a() {
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m264a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f106a = epVar.getAuthRequestContext();
                        a(true);
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f111b = epVar.getAuthRequestContext();
                        b(true);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f110a = epVar.GetContactSyncConfig();
                        c(true);
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f113c = epVar.getAuthRequestContext();
                        d(true);
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f107a = epVar.MyBillsEntityDataFactory();
                        e(true);
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f108a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f112b = epVar.GetContactSyncConfig();
                        f(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f109a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m265a() {
        return this.f109a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m266a(dg dgVar) {
        if (dgVar == null) {
            return false;
        }
        boolean m265a = m265a();
        boolean m265a2 = dgVar.m265a();
        if ((m265a || m265a2) && !(m265a && m265a2 && this.f106a == dgVar.f106a)) {
            return false;
        }
        boolean m267b = m267b();
        boolean m267b2 = dgVar.m267b();
        if ((m267b || m267b2) && !(m267b && m267b2 && this.f111b == dgVar.f111b)) {
            return false;
        }
        boolean m268c = m268c();
        boolean m268c2 = dgVar.m268c();
        if ((m268c || m268c2) && !(m268c && m268c2 && this.f110a == dgVar.f110a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dgVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f113c == dgVar.f113c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dgVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f107a == dgVar.f107a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dgVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f108a.equals(dgVar.f108a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = dgVar.h();
        if (h || h2) {
            return h && h2 && this.f112b == dgVar.f112b;
        }
        return true;
    }

    public int b() {
        return this.f111b;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m264a();
        if (m265a()) {
            epVar.PlaceComponentResult(f7758a);
            epVar.MyBillsEntityDataFactory(this.f106a);
        }
        if (m267b()) {
            epVar.PlaceComponentResult(b);
            epVar.MyBillsEntityDataFactory(this.f111b);
        }
        if (m268c()) {
            epVar.PlaceComponentResult(c);
            epVar.getAuthRequestContext(this.f110a);
        }
        if (d()) {
            epVar.PlaceComponentResult(d);
            epVar.MyBillsEntityDataFactory(this.f113c);
        }
        if (e()) {
            epVar.PlaceComponentResult(e);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f107a);
        }
        if (this.f108a != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f108a);
        }
        if (h()) {
            epVar.PlaceComponentResult(g);
            epVar.getAuthRequestContext(this.f112b);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f109a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m267b() {
        return this.f109a.get(1);
    }

    public int c() {
        return this.f113c;
    }

    public void c(boolean z) {
        this.f109a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m268c() {
        return this.f109a.get(2);
    }

    public void d(boolean z) {
        this.f109a.set(3, z);
    }

    public boolean d() {
        return this.f109a.get(3);
    }

    public void e(boolean z) {
        this.f109a.set(4, z);
    }

    public boolean e() {
        return this.f109a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dg)) {
            return m266a((dg) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f109a.set(5, z);
    }

    public boolean f() {
        return this.f108a != null;
    }

    public boolean g() {
        return this.f112b;
    }

    public boolean h() {
        return this.f109a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m265a()) {
            sb.append("key:");
            sb.append(this.f106a);
            z = false;
        } else {
            z = true;
        }
        if (m267b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f111b);
            z = false;
        }
        if (m268c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f110a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f113c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f107a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f108a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f112b);
        }
        sb.append(")");
        return sb.toString();
    }
}
