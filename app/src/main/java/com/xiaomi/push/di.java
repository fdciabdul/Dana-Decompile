package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class di implements ef<di, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f135a;

    /* renamed from: a  reason: collision with other field name */
    public long f136a;

    /* renamed from: a  reason: collision with other field name */
    public String f137a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f138a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f139a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f140a;

    /* renamed from: b  reason: collision with other field name */
    public int f141b;

    /* renamed from: b  reason: collision with other field name */
    public String f142b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f143b;

    /* renamed from: c  reason: collision with other field name */
    public int f144c;

    /* renamed from: c  reason: collision with other field name */
    public String f145c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f146c;

    /* renamed from: d  reason: collision with other field name */
    public String f147d;

    /* renamed from: e  reason: collision with other field name */
    public String f148e;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f134a = new eu("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7761a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 10, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 8, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 8, 8);
    private static final em i = new em("", (byte) 8, 9);
    private static final em j = new em("", (byte) 13, 10);
    private static final em k = new em("", (byte) 13, 11);
    private static final em l = new em("", (byte) 2, 12);
    private static final em m = new em("", (byte) 13, 13);

    public di() {
        this.f138a = new BitSet(5);
        this.f140a = false;
    }

    public di(di diVar) {
        BitSet bitSet = new BitSet(5);
        this.f138a = bitSet;
        bitSet.clear();
        this.f138a.or(diVar.f138a);
        if (diVar.m280a()) {
            this.f137a = diVar.f137a;
        }
        this.f136a = diVar.f136a;
        if (diVar.m286c()) {
            this.f142b = diVar.f142b;
        }
        if (diVar.m287d()) {
            this.f145c = diVar.f145c;
        }
        if (diVar.e()) {
            this.f147d = diVar.f147d;
        }
        this.f135a = diVar.f135a;
        if (diVar.g()) {
            this.f148e = diVar.f148e;
        }
        this.f141b = diVar.f141b;
        this.f144c = diVar.f144c;
        if (diVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : diVar.f139a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f139a = hashMap;
        }
        if (diVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : diVar.f143b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f143b = hashMap2;
        }
        this.f140a = diVar.f140a;
        if (diVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : diVar.f146c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f146c = hashMap3;
        }
    }

    public int a() {
        return this.f135a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f137a.compareTo(r5.f137a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f142b.compareTo(r5.f142b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f145c.compareTo(r5.f145c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r4.f147d.compareTo(r5.f147d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f148e.compareTo(r5.f148e);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.di r5) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.di.compareTo(com.xiaomi.push.di):int");
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m275a() {
        return this.f136a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public di m276a() {
        return new di(this);
    }

    public di a(int i2) {
        this.f135a = i2;
        b(true);
        return this;
    }

    public di a(String str) {
        this.f137a = str;
        return this;
    }

    public di a(Map<String, String> map) {
        this.f139a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m277a() {
        return this.f137a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m278a() {
        return this.f139a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m279a() {
        if (this.f137a != null) {
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
                if (m284b()) {
                    m279a();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'messageTs' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new eq(sb.toString());
            }
            int i2 = 0;
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f137a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f136a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f142b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f145c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f147d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f135a = epVar.getAuthRequestContext();
                        b(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f148e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f141b = epVar.getAuthRequestContext();
                        c(true);
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f144c = epVar.getAuthRequestContext();
                        d(true);
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue = epVar.moveToNextValue();
                        this.f139a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                        while (i2 < moveToNextValue.PlaceComponentResult) {
                            this.f139a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                            i2++;
                        }
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue2 = epVar.moveToNextValue();
                        this.f143b = new HashMap(moveToNextValue2.PlaceComponentResult * 2);
                        while (i2 < moveToNextValue2.PlaceComponentResult) {
                            this.f143b.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                            i2++;
                        }
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f140a = epVar.GetContactSyncConfig();
                        e(true);
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue3 = epVar.moveToNextValue();
                        this.f146c = new HashMap(moveToNextValue3.PlaceComponentResult * 2);
                        while (i2 < moveToNextValue3.PlaceComponentResult) {
                            this.f146c.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                            i2++;
                        }
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(String str, String str2) {
        if (this.f139a == null) {
            this.f139a = new HashMap();
        }
        this.f139a.put(str, str2);
    }

    public void a(boolean z) {
        this.f138a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m280a() {
        return this.f137a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m281a(di diVar) {
        if (diVar == null) {
            return false;
        }
        boolean m280a = m280a();
        boolean m280a2 = diVar.m280a();
        if (((m280a || m280a2) && !(m280a && m280a2 && this.f137a.equals(diVar.f137a))) || this.f136a != diVar.f136a) {
            return false;
        }
        boolean m286c = m286c();
        boolean m286c2 = diVar.m286c();
        if ((m286c || m286c2) && !(m286c && m286c2 && this.f142b.equals(diVar.f142b))) {
            return false;
        }
        boolean m287d = m287d();
        boolean m287d2 = diVar.m287d();
        if ((m287d || m287d2) && !(m287d && m287d2 && this.f145c.equals(diVar.f145c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = diVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f147d.equals(diVar.f147d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = diVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f135a == diVar.f135a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = diVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f148e.equals(diVar.f148e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = diVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f141b == diVar.f141b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = diVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f144c == diVar.f144c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = diVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f139a.equals(diVar.f139a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = diVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f143b.equals(diVar.f143b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = diVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f140a == diVar.f140a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = diVar.n();
        if (n || n2) {
            return n && n2 && this.f146c.equals(diVar.f146c);
        }
        return true;
    }

    public int b() {
        return this.f141b;
    }

    public di b(int i2) {
        this.f141b = i2;
        c(true);
        return this;
    }

    public di b(String str) {
        this.f142b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m282b() {
        return this.f142b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m283b() {
        return this.f143b;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m279a();
        if (this.f137a != null) {
            epVar.PlaceComponentResult(f7761a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f137a);
        }
        epVar.PlaceComponentResult(b);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f136a);
        if (this.f142b != null && m286c()) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f142b);
        }
        if (this.f145c != null && m287d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f145c);
        }
        if (this.f147d != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f147d);
        }
        if (f()) {
            epVar.PlaceComponentResult(f);
            epVar.MyBillsEntityDataFactory(this.f135a);
        }
        if (this.f148e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f148e);
        }
        if (h()) {
            epVar.PlaceComponentResult(h);
            epVar.MyBillsEntityDataFactory(this.f141b);
        }
        if (i()) {
            epVar.PlaceComponentResult(i);
            epVar.MyBillsEntityDataFactory(this.f144c);
        }
        if (this.f139a != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f139a.size()));
            for (Map.Entry<String, String> entry : this.f139a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        if (this.f143b != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f143b.size()));
            for (Map.Entry<String, String> entry2 : this.f143b.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry2.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry2.getValue());
            }
        }
        if (m()) {
            epVar.PlaceComponentResult(l);
            epVar.getAuthRequestContext(this.f140a);
        }
        if (this.f146c != null && n()) {
            epVar.PlaceComponentResult(m);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f146c.size()));
            for (Map.Entry<String, String> entry3 : this.f146c.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry3.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry3.getValue());
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f138a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m284b() {
        return this.f138a.get(0);
    }

    public int c() {
        return this.f144c;
    }

    public di c(int i2) {
        this.f144c = i2;
        d(true);
        return this;
    }

    public di c(String str) {
        this.f145c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m285c() {
        return this.f145c;
    }

    public void c(boolean z) {
        this.f138a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m286c() {
        return this.f142b != null;
    }

    public di d(String str) {
        this.f147d = str;
        return this;
    }

    public String d() {
        return this.f147d;
    }

    public void d(boolean z) {
        this.f138a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m287d() {
        return this.f145c != null;
    }

    public void e(boolean z) {
        this.f138a.set(4, z);
    }

    public boolean e() {
        return this.f147d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof di)) {
            return m281a((di) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f138a.get(1);
    }

    public boolean g() {
        return this.f148e != null;
    }

    public boolean h() {
        return this.f138a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f138a.get(3);
    }

    public boolean j() {
        return this.f139a != null;
    }

    public boolean k() {
        return this.f143b != null;
    }

    public boolean l() {
        return this.f140a;
    }

    public boolean m() {
        return this.f138a.get(4);
    }

    public boolean n() {
        return this.f146c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f137a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aw.BuiltInFictitiousFunctionClassFactory(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f136a);
        if (m286c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f142b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m287d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f145c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f147d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f135a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f148e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f141b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f144c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f139a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f143b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f140a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f146c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
