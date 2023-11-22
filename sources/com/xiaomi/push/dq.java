package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dq implements ef<dq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public cz f222a;

    /* renamed from: a  reason: collision with other field name */
    public di f223a;

    /* renamed from: a  reason: collision with other field name */
    public dk f224a;

    /* renamed from: a  reason: collision with other field name */
    public String f225a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f226a;

    /* renamed from: b  reason: collision with other field name */
    public String f229b;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f221a = new eu("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7770a = new em("", (byte) 8, 1);
    private static final em b = new em("", (byte) 2, 2);
    private static final em c = new em("", (byte) 2, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 12, 7);
    private static final em h = new em("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f227a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f228a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f230b = true;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r2.f225a.compareTo(r3.f225a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r2.f229b.compareTo(r3.f229b);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dq r3) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dq.compareTo(com.xiaomi.push.dq):int");
    }

    public cz a() {
        return this.f222a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public di m308a() {
        return this.f223a;
    }

    public dq a(cz czVar) {
        this.f222a = czVar;
        return this;
    }

    public dq a(di diVar) {
        this.f223a = diVar;
        return this;
    }

    public dq a(dk dkVar) {
        this.f224a = dkVar;
        return this;
    }

    public dq a(String str) {
        this.f225a = str;
        return this;
    }

    public dq a(ByteBuffer byteBuffer) {
        this.f226a = byteBuffer;
        return this;
    }

    public dq a(boolean z) {
        this.f228a = z;
        m311a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m309a() {
        return this.f225a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m310a() {
        if (this.f222a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'action' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f226a == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'pushAction' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f224a != null) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'target' was not present! Struct: ");
            sb3.append(toString());
            throw new eq(sb3.toString());
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                if (!c()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Required field 'encryptAction' was not found in serialized data! Struct: ");
                    sb.append(toString());
                    throw new eq(sb.toString());
                } else if (d()) {
                    m310a();
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Required field 'isRequest' was not found in serialized data! Struct: ");
                    sb2.append(toString());
                    throw new eq(sb2.toString());
                }
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f222a = cz.a(epVar.getAuthRequestContext());
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f228a = epVar.GetContactSyncConfig();
                        m311a(true);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f230b = epVar.GetContactSyncConfig();
                        m315b(true);
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f226a = epVar.lookAheadTest();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f225a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f229b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f224a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        di diVar = new di();
                        this.f223a = diVar;
                        diVar.a(epVar);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m311a(boolean z) {
        this.f227a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m312a() {
        return this.f222a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m313a(dq dqVar) {
        if (dqVar == null) {
            return false;
        }
        boolean m312a = m312a();
        boolean m312a2 = dqVar.m312a();
        if (((!m312a && !m312a2) || (m312a && m312a2 && this.f222a.equals(dqVar.f222a))) && this.f228a == dqVar.f228a && this.f230b == dqVar.f230b) {
            boolean e2 = e();
            boolean e3 = dqVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f226a.equals(dqVar.f226a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = dqVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f225a.equals(dqVar.f225a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = dqVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f229b.equals(dqVar.f229b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = dqVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f224a.m289a(dqVar.f224a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = dqVar.i();
            if (i || i2) {
                return i && i2 && this.f223a.m281a(dqVar.f223a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m314a() {
        a(eg.BuiltInFictitiousFunctionClassFactory(this.f226a));
        return this.f226a.array();
    }

    public dq b(String str) {
        this.f229b = str;
        return this;
    }

    public dq b(boolean z) {
        this.f230b = z;
        m315b(true);
        return this;
    }

    public String b() {
        return this.f229b;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m310a();
        if (this.f222a != null) {
            epVar.PlaceComponentResult(f7770a);
            epVar.MyBillsEntityDataFactory(this.f222a.a());
        }
        epVar.PlaceComponentResult(b);
        epVar.getAuthRequestContext(this.f228a);
        epVar.PlaceComponentResult(c);
        epVar.getAuthRequestContext(this.f230b);
        if (this.f226a != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f226a);
        }
        if (this.f225a != null && f()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f225a);
        }
        if (this.f229b != null && g()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f229b);
        }
        if (this.f224a != null) {
            epVar.PlaceComponentResult(g);
            this.f224a.b(epVar);
        }
        if (this.f223a != null && i()) {
            epVar.PlaceComponentResult(h);
            this.f223a.b(epVar);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m315b(boolean z) {
        this.f227a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m316b() {
        return this.f228a;
    }

    public boolean c() {
        return this.f227a.get(0);
    }

    public boolean d() {
        return this.f227a.get(1);
    }

    public boolean e() {
        return this.f226a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dq)) {
            return m313a((dq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f225a != null;
    }

    public boolean g() {
        return this.f229b != null;
    }

    public boolean h() {
        return this.f224a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f223a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        cz czVar = this.f222a;
        if (czVar == null) {
            sb.append("null");
        } else {
            sb.append(czVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f228a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f230b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f225a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f229b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        dk dkVar = this.f224a;
        if (dkVar == null) {
            sb.append("null");
        } else {
            sb.append(dkVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            di diVar = this.f223a;
            if (diVar == null) {
                sb.append("null");
            } else {
                sb.append(diVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
