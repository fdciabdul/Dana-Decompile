package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class dx implements ef<dx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public dh f313a;

    /* renamed from: a  reason: collision with other field name */
    public dk f314a;

    /* renamed from: a  reason: collision with other field name */
    public String f315a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f317a;

    /* renamed from: b  reason: collision with other field name */
    public String f319b;

    /* renamed from: c  reason: collision with other field name */
    public String f320c;

    /* renamed from: d  reason: collision with other field name */
    public String f321d;

    /* renamed from: e  reason: collision with other field name */
    public String f322e;

    /* renamed from: f  reason: collision with other field name */
    public String f323f;

    /* renamed from: g  reason: collision with other field name */
    public String f324g;

    /* renamed from: h  reason: collision with other field name */
    public String f325h;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f312a = new eu("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7780a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 11, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 12, 8);
    private static final em i = new em("", (byte) 2, 9);
    private static final em j = new em("", (byte) 13, 10);
    private static final em k = new em("", (byte) 11, 11);
    private static final em l = new em("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f316a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f318a = true;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r2.f315a.compareTo(r3.f315a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r2.f319b.compareTo(r3.f319b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r2.f320c.compareTo(r3.f320c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r0 = r2.f321d.compareTo(r3.f321d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r2.f322e.compareTo(r3.f322e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r2.f323f.compareTo(r3.f323f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        r0 = r2.f324g.compareTo(r3.f324g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f8, code lost:
    
        r3 = r2.f325h.compareTo(r3.f325h);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dx r3) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dx.compareTo(com.xiaomi.push.dx):int");
    }

    public dh a() {
        return this.f313a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m345a() {
        return this.f319b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m346a() {
        if (this.f319b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f320c != null) {
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
                m346a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f315a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f314a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f319b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f320c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f321d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f322e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f323f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dh dhVar = new dh();
                        this.f313a = dhVar;
                        dhVar.a(epVar);
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f318a = epVar.GetContactSyncConfig();
                        a(true);
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue = epVar.moveToNextValue();
                        this.f317a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                        for (int i2 = 0; i2 < moveToNextValue.PlaceComponentResult; i2++) {
                            this.f317a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f324g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f325h = epVar.getErrorConfigVersion();
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f316a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a() {
        return this.f315a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a(dx dxVar) {
        if (dxVar == null) {
            return false;
        }
        boolean m347a = m347a();
        boolean m347a2 = dxVar.m347a();
        if ((m347a || m347a2) && !(m347a && m347a2 && this.f315a.equals(dxVar.f315a))) {
            return false;
        }
        boolean m349b = m349b();
        boolean m349b2 = dxVar.m349b();
        if ((m349b || m349b2) && !(m349b && m349b2 && this.f314a.m289a(dxVar.f314a))) {
            return false;
        }
        boolean m350c = m350c();
        boolean m350c2 = dxVar.m350c();
        if ((m350c || m350c2) && !(m350c && m350c2 && this.f319b.equals(dxVar.f319b))) {
            return false;
        }
        boolean m351d = m351d();
        boolean m351d2 = dxVar.m351d();
        if ((m351d || m351d2) && !(m351d && m351d2 && this.f320c.equals(dxVar.f320c))) {
            return false;
        }
        boolean m352e = m352e();
        boolean m352e2 = dxVar.m352e();
        if ((m352e || m352e2) && !(m352e && m352e2 && this.f321d.equals(dxVar.f321d))) {
            return false;
        }
        boolean m353f = m353f();
        boolean m353f2 = dxVar.m353f();
        if ((m353f || m353f2) && !(m353f && m353f2 && this.f322e.equals(dxVar.f322e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f323f.equals(dxVar.f323f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f313a.m272a(dxVar.f313a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f318a == dxVar.f318a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dxVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f317a.equals(dxVar.f317a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dxVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f324g.equals(dxVar.f324g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dxVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f325h.equals(dxVar.f325h);
        }
        return true;
    }

    public String b() {
        return this.f320c;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m346a();
        if (this.f315a != null && m347a()) {
            epVar.PlaceComponentResult(f7780a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f315a);
        }
        if (this.f314a != null && m349b()) {
            epVar.PlaceComponentResult(b);
            this.f314a.b(epVar);
        }
        if (this.f319b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f319b);
        }
        if (this.f320c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f320c);
        }
        if (this.f321d != null && m352e()) {
            epVar.PlaceComponentResult(e);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f321d);
        }
        if (this.f322e != null && m353f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f322e);
        }
        if (this.f323f != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f323f);
        }
        if (this.f313a != null && h()) {
            epVar.PlaceComponentResult(h);
            this.f313a.b(epVar);
        }
        if (i()) {
            epVar.PlaceComponentResult(i);
            epVar.getAuthRequestContext(this.f318a);
        }
        if (this.f317a != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f317a.size()));
            for (Map.Entry<String, String> entry : this.f317a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        if (this.f324g != null && k()) {
            epVar.PlaceComponentResult(k);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f324g);
        }
        if (this.f325h != null && l()) {
            epVar.PlaceComponentResult(l);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f325h);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m349b() {
        return this.f314a != null;
    }

    public String c() {
        return this.f322e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m350c() {
        return this.f319b != null;
    }

    public String d() {
        return this.f323f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m351d() {
        return this.f320c != null;
    }

    public String e() {
        return this.f324g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m352e() {
        return this.f321d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dx)) {
            return m348a((dx) obj);
        }
        return false;
    }

    public String f() {
        return this.f325h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m353f() {
        return this.f322e != null;
    }

    public boolean g() {
        return this.f323f != null;
    }

    public boolean h() {
        return this.f313a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f316a.get(0);
    }

    public boolean j() {
        return this.f317a != null;
    }

    public boolean k() {
        return this.f324g != null;
    }

    public boolean l() {
        return this.f325h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m347a()) {
            sb.append("debug:");
            String str = this.f315a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m349b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f314a;
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
        String str2 = this.f319b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f320c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m352e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f321d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m353f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f322e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f323f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            dh dhVar = this.f313a;
            if (dhVar == null) {
                sb.append("null");
            } else {
                sb.append(dhVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f318a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f317a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f324g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f325h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
