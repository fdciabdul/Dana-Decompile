package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class dm implements ef<dm, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public dk f183a;

    /* renamed from: a  reason: collision with other field name */
    public String f184a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f186a;

    /* renamed from: b  reason: collision with other field name */
    public String f187b;

    /* renamed from: c  reason: collision with other field name */
    public String f188c;

    /* renamed from: d  reason: collision with other field name */
    public String f189d;

    /* renamed from: e  reason: collision with other field name */
    public String f190e;

    /* renamed from: f  reason: collision with other field name */
    public String f191f;

    /* renamed from: g  reason: collision with other field name */
    public String f192g;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f181a = new eu("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7766a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 10, 7);
    private static final em g = new em("", (byte) 11, 8);
    private static final em h = new em("", (byte) 13, 9);
    private static final em i = new em("", (byte) 11, 10);
    private static final em j = new em("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f185a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f182a = 0;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f184a.compareTo(r5.f184a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f187b.compareTo(r5.f187b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f188c.compareTo(r5.f188c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r4.f189d.compareTo(r5.f189d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f190e.compareTo(r5.f190e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f191f.compareTo(r5.f191f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r5 = r4.f192g.compareTo(r5.f192g);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dm r5) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dm.compareTo(com.xiaomi.push.dm):int");
    }

    public dm a(long j2) {
        this.f182a = j2;
        a(true);
        return this;
    }

    public dm a(dk dkVar) {
        this.f183a = dkVar;
        return this;
    }

    public dm a(String str) {
        this.f187b = str;
        return this;
    }

    public String a() {
        return this.f187b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m292a() {
        return this.f186a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m293a() {
        if (this.f187b != null) {
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
                m293a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f184a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f183a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f187b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f188c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f189d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f182a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f190e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue = epVar.moveToNextValue();
                        this.f186a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                        for (int i2 = 0; i2 < moveToNextValue.PlaceComponentResult; i2++) {
                            this.f186a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f191f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f192g = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f185a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m294a() {
        return this.f184a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m295a(dm dmVar) {
        if (dmVar == null) {
            return false;
        }
        boolean m294a = m294a();
        boolean m294a2 = dmVar.m294a();
        if ((m294a || m294a2) && !(m294a && m294a2 && this.f184a.equals(dmVar.f184a))) {
            return false;
        }
        boolean m296b = m296b();
        boolean m296b2 = dmVar.m296b();
        if ((m296b || m296b2) && !(m296b && m296b2 && this.f183a.m289a(dmVar.f183a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dmVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f187b.equals(dmVar.f187b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dmVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f188c.equals(dmVar.f188c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dmVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f189d.equals(dmVar.f189d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dmVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f182a == dmVar.f182a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dmVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f190e.equals(dmVar.f190e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dmVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f186a.equals(dmVar.f186a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dmVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f191f.equals(dmVar.f191f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dmVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f192g.equals(dmVar.f192g);
        }
        return true;
    }

    public dm b(String str) {
        this.f188c = str;
        return this;
    }

    public String b() {
        return this.f189d;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m293a();
        if (this.f184a != null && m294a()) {
            epVar.PlaceComponentResult(f7766a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f184a);
        }
        if (this.f183a != null && m296b()) {
            epVar.PlaceComponentResult(b);
            this.f183a.b(epVar);
        }
        if (this.f187b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f187b);
        }
        if (this.f188c != null && d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f188c);
        }
        if (this.f189d != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f189d);
        }
        if (f()) {
            epVar.PlaceComponentResult(f);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f182a);
        }
        if (this.f190e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f190e);
        }
        if (this.f186a != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f186a.size()));
            for (Map.Entry<String, String> entry : this.f186a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        if (this.f191f != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f191f);
        }
        if (this.f192g != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f192g);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m296b() {
        return this.f183a != null;
    }

    public dm c(String str) {
        this.f189d = str;
        return this;
    }

    public boolean c() {
        return this.f187b != null;
    }

    public dm d(String str) {
        this.f190e = str;
        return this;
    }

    public boolean d() {
        return this.f188c != null;
    }

    public dm e(String str) {
        this.f191f = str;
        return this;
    }

    public boolean e() {
        return this.f189d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dm)) {
            return m295a((dm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f185a.get(0);
    }

    public boolean g() {
        return this.f190e != null;
    }

    public boolean h() {
        return this.f186a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f191f != null;
    }

    public boolean j() {
        return this.f192g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m294a()) {
            sb.append("debug:");
            String str = this.f184a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m296b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f183a;
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
        String str2 = this.f187b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f188c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f189d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f182a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f190e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f186a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f191f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f192g;
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
