package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dw implements ef<dw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f304a;

    /* renamed from: a  reason: collision with other field name */
    public dk f305a;

    /* renamed from: a  reason: collision with other field name */
    public String f306a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f307a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f308b;

    /* renamed from: c  reason: collision with other field name */
    public String f309c;

    /* renamed from: d  reason: collision with other field name */
    public String f310d;

    /* renamed from: e  reason: collision with other field name */
    public String f311e;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f303a = new eu("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7779a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 8);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f306a.compareTo(r5.f306a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f308b.compareTo(r5.f308b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f309c.compareTo(r5.f309c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f310d.compareTo(r5.f310d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r5 = r4.f311e.compareTo(r5.f311e);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dw r5) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dw.compareTo(com.xiaomi.push.dw):int");
    }

    public void a() {
        if (this.f308b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f309c != null) {
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
                    a();
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
                        this.f306a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f305a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f308b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f309c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f304a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f310d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f311e = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f307a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m343a() {
        return this.f306a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a(dw dwVar) {
        if (dwVar == null) {
            return false;
        }
        boolean m343a = m343a();
        boolean m343a2 = dwVar.m343a();
        if ((m343a || m343a2) && !(m343a && m343a2 && this.f306a.equals(dwVar.f306a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f305a.m289a(dwVar.f305a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f308b.equals(dwVar.f308b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f309c.equals(dwVar.f309c))) || this.f304a != dwVar.f304a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f310d.equals(dwVar.f310d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dwVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f311e.equals(dwVar.f311e);
        }
        return true;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f306a != null && m343a()) {
            epVar.PlaceComponentResult(f7779a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f306a);
        }
        if (this.f305a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f305a.b(epVar);
        }
        if (this.f308b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f308b);
        }
        if (this.f309c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f309c);
        }
        epVar.PlaceComponentResult(e);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f304a);
        if (this.f310d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f310d);
        }
        if (this.f311e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f311e);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean b() {
        return this.f305a != null;
    }

    public boolean c() {
        return this.f308b != null;
    }

    public boolean d() {
        return this.f309c != null;
    }

    public boolean e() {
        return this.f307a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dw)) {
            return m344a((dw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f310d != null;
    }

    public boolean g() {
        return this.f311e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m343a()) {
            sb.append("debug:");
            String str = this.f306a;
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
            dk dkVar = this.f305a;
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
        String str2 = this.f308b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f309c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f304a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f310d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f311e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
