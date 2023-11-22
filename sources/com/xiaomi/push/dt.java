package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class dt implements ef<dt, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f236a;

    /* renamed from: a  reason: collision with other field name */
    public dk f237a;

    /* renamed from: a  reason: collision with other field name */
    public String f238a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f239a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f240a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f241a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f242a;

    /* renamed from: b  reason: collision with other field name */
    public String f243b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f244b;

    /* renamed from: c  reason: collision with other field name */
    public String f245c;

    /* renamed from: d  reason: collision with other field name */
    public String f246d;

    /* renamed from: e  reason: collision with other field name */
    public String f247e;

    /* renamed from: f  reason: collision with other field name */
    public String f248f;

    /* renamed from: g  reason: collision with other field name */
    public String f249g;

    /* renamed from: h  reason: collision with other field name */
    public String f250h;

    /* renamed from: i  reason: collision with other field name */
    public String f251i;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f235a = new eu("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7773a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 2, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 13, 8);
    private static final em i = new em("", (byte) 11, 9);
    private static final em j = new em("", (byte) 11, 10);
    private static final em k = new em("", (byte) 11, 12);
    private static final em l = new em("", (byte) 11, 13);
    private static final em m = new em("", (byte) 11, 14);
    private static final em n = new em("", (byte) 10, 15);

    /* renamed from: o  reason: collision with root package name */
    private static final em f7774o = new em("", (byte) 2, 20);

    public dt() {
        this.f240a = new BitSet(3);
        this.f242a = true;
        this.f244b = false;
    }

    public dt(String str, boolean z) {
        this();
        this.f243b = str;
        this.f242a = z;
        m326a(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f238a.compareTo(r5.f238a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f243b.compareTo(r5.f243b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f245c.compareTo(r5.f245c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r4.f246d.compareTo(r5.f246d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f247e.compareTo(r5.f247e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f248f.compareTo(r5.f248f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r0 = r4.f249g.compareTo(r5.f249g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        r0 = r4.f250h.compareTo(r5.f250h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f8, code lost:
    
        r0 = r4.f251i.compareTo(r5.f251i);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dt r5) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dt.compareTo(com.xiaomi.push.dt):int");
    }

    public dk a() {
        return this.f237a;
    }

    public dt a(String str) {
        this.f243b = str;
        return this;
    }

    public dt a(ByteBuffer byteBuffer) {
        this.f239a = byteBuffer;
        return this;
    }

    public dt a(Map<String, String> map) {
        this.f241a = map;
        return this;
    }

    public dt a(boolean z) {
        this.f242a = z;
        m326a(true);
        return this;
    }

    public dt a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m323a() {
        return this.f243b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m324a() {
        return this.f241a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m325a() {
        if (this.f243b != null) {
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
                if (f()) {
                    m325a();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'requireAck' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new eq(sb.toString());
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f238a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f237a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f243b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f245c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f246d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f242a = epVar.GetContactSyncConfig();
                        m326a(true);
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f247e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue = epVar.moveToNextValue();
                        this.f241a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                        for (int i2 = 0; i2 < moveToNextValue.PlaceComponentResult; i2++) {
                            this.f241a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f248f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f249g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f250h = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f251i = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 14:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f239a = epVar.lookAheadTest();
                        continue;
                    }
                case 15:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f236a = epVar.MyBillsEntityDataFactory();
                        b(true);
                        continue;
                    }
                case 20:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f244b = epVar.GetContactSyncConfig();
                        c(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(String str, String str2) {
        if (this.f241a == null) {
            this.f241a = new HashMap();
        }
        this.f241a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m326a(boolean z) {
        this.f240a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m327a() {
        return this.f238a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m328a(dt dtVar) {
        if (dtVar == null) {
            return false;
        }
        boolean m327a = m327a();
        boolean m327a2 = dtVar.m327a();
        if ((m327a || m327a2) && !(m327a && m327a2 && this.f238a.equals(dtVar.f238a))) {
            return false;
        }
        boolean m330b = m330b();
        boolean m330b2 = dtVar.m330b();
        if ((m330b || m330b2) && !(m330b && m330b2 && this.f237a.m289a(dtVar.f237a))) {
            return false;
        }
        boolean m331c = m331c();
        boolean m331c2 = dtVar.m331c();
        if ((m331c || m331c2) && !(m331c && m331c2 && this.f243b.equals(dtVar.f243b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dtVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f245c.equals(dtVar.f245c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dtVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f246d.equals(dtVar.f246d))) || this.f242a != dtVar.f242a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dtVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f247e.equals(dtVar.f247e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dtVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f241a.equals(dtVar.f241a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dtVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f248f.equals(dtVar.f248f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dtVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f249g.equals(dtVar.f249g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dtVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f250h.equals(dtVar.f250h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dtVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f251i.equals(dtVar.f251i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dtVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f239a.equals(dtVar.f239a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dtVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f236a == dtVar.f236a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dtVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f244b == dtVar.f244b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m329a() {
        a(eg.BuiltInFictitiousFunctionClassFactory(this.f239a));
        return this.f239a.array();
    }

    public dt b(String str) {
        this.f245c = str;
        return this;
    }

    public String b() {
        return this.f245c;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m325a();
        if (this.f238a != null && m327a()) {
            epVar.PlaceComponentResult(f7773a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f238a);
        }
        if (this.f237a != null && m330b()) {
            epVar.PlaceComponentResult(b);
            this.f237a.b(epVar);
        }
        if (this.f243b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f243b);
        }
        if (this.f245c != null && d()) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f245c);
        }
        if (this.f246d != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f246d);
        }
        epVar.PlaceComponentResult(f);
        epVar.getAuthRequestContext(this.f242a);
        if (this.f247e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f247e);
        }
        if (this.f241a != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f241a.size()));
            for (Map.Entry<String, String> entry : this.f241a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        if (this.f248f != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f248f);
        }
        if (this.f249g != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f249g);
        }
        if (this.f250h != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f250h);
        }
        if (this.f251i != null && l()) {
            epVar.PlaceComponentResult(l);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f251i);
        }
        if (this.f239a != null && m()) {
            epVar.PlaceComponentResult(m);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f239a);
        }
        if (n()) {
            epVar.PlaceComponentResult(n);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f236a);
        }
        if (o()) {
            epVar.PlaceComponentResult(f7774o);
            epVar.getAuthRequestContext(this.f244b);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f240a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m330b() {
        return this.f237a != null;
    }

    public dt c(String str) {
        this.f246d = str;
        return this;
    }

    public String c() {
        return this.f248f;
    }

    public void c(boolean z) {
        this.f240a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m331c() {
        return this.f243b != null;
    }

    public dt d(String str) {
        this.f248f = str;
        return this;
    }

    public boolean d() {
        return this.f245c != null;
    }

    public boolean e() {
        return this.f246d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dt)) {
            return m328a((dt) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f240a.get(0);
    }

    public boolean g() {
        return this.f247e != null;
    }

    public boolean h() {
        return this.f241a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f248f != null;
    }

    public boolean j() {
        return this.f249g != null;
    }

    public boolean k() {
        return this.f250h != null;
    }

    public boolean l() {
        return this.f251i != null;
    }

    public boolean m() {
        return this.f239a != null;
    }

    public boolean n() {
        return this.f240a.get(1);
    }

    public boolean o() {
        return this.f240a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m327a()) {
            sb.append("debug:");
            String str = this.f238a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m330b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f237a;
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
        String str2 = this.f243b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f245c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f246d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f242a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f247e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f241a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f248f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f249g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f250h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f251i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f239a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                eg.MyBillsEntityDataFactory(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f236a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f244b);
        }
        sb.append(")");
        return sb.toString();
    }
}
