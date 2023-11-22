package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class dl implements ef<dl, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f160a;

    /* renamed from: a  reason: collision with other field name */
    public long f161a;

    /* renamed from: a  reason: collision with other field name */
    public dk f162a;

    /* renamed from: a  reason: collision with other field name */
    public dx f163a;

    /* renamed from: a  reason: collision with other field name */
    public String f164a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f166a;

    /* renamed from: a  reason: collision with other field name */
    public short f167a;

    /* renamed from: b  reason: collision with other field name */
    public String f169b;

    /* renamed from: b  reason: collision with other field name */
    public short f170b;

    /* renamed from: c  reason: collision with other field name */
    public String f171c;

    /* renamed from: d  reason: collision with other field name */
    public String f172d;

    /* renamed from: e  reason: collision with other field name */
    public String f173e;

    /* renamed from: f  reason: collision with other field name */
    public String f174f;

    /* renamed from: g  reason: collision with other field name */
    public String f175g;

    /* renamed from: h  reason: collision with other field name */
    public String f176h;

    /* renamed from: i  reason: collision with other field name */
    public String f177i;

    /* renamed from: j  reason: collision with other field name */
    public String f178j;

    /* renamed from: k  reason: collision with other field name */
    public String f179k;

    /* renamed from: l  reason: collision with other field name */
    public String f180l;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f159a = new eu("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7764a = new em("", (byte) 11, 1);
    private static final em b = new em("", (byte) 12, 2);
    private static final em c = new em("", (byte) 11, 3);
    private static final em d = new em("", (byte) 11, 4);
    private static final em e = new em("", (byte) 10, 5);
    private static final em f = new em("", (byte) 11, 6);
    private static final em g = new em("", (byte) 11, 7);
    private static final em h = new em("", (byte) 12, 8);
    private static final em i = new em("", (byte) 11, 9);
    private static final em j = new em("", (byte) 11, 10);
    private static final em k = new em("", (byte) 2, 11);
    private static final em l = new em("", (byte) 11, 12);
    private static final em m = new em("", (byte) 11, 13);
    private static final em n = new em("", (byte) 11, 14);

    /* renamed from: o  reason: collision with root package name */
    private static final em f7765o = new em("", (byte) 6, 15);
    private static final em p = new em("", (byte) 6, 16);
    private static final em q = new em("", (byte) 11, 20);
    private static final em r = new em("", (byte) 11, 21);
    private static final em s = new em("", (byte) 8, 22);
    private static final em t = new em("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f165a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f168a = false;

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0220, code lost:
    
        r0 = r4.f177i.compareTo(r5.f177i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
    
        r0 = r4.f178j.compareTo(r5.f178j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r4.f164a.compareTo(r5.f164a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02c0, code lost:
    
        r0 = r4.f179k.compareTo(r5.f179k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02e8, code lost:
    
        r0 = r4.f180l.compareTo(r5.f180l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f169b.compareTo(r5.f169b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f171c.compareTo(r5.f171c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f172d.compareTo(r5.f172d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f173e.compareTo(r5.f173e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f174f.compareTo(r5.f174f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a8, code lost:
    
        r0 = r4.f175g.compareTo(r5.f175g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f8, code lost:
    
        r0 = r4.f176h.compareTo(r5.f176h);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dl r5) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dl.compareTo(com.xiaomi.push.dl):int");
    }

    public dl a(long j2) {
        this.f161a = j2;
        a(true);
        return this;
    }

    public dl a(String str) {
        this.f169b = str;
        return this;
    }

    public dl a(short s2) {
        this.f167a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f169b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f171c != null) {
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
                sb.append("Required field 'messageTs' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new eq(sb.toString());
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 1:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f164a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f162a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f169b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f171c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f161a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f172d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f173e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dx dxVar = new dx();
                        this.f163a = dxVar;
                        dxVar.a(epVar);
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f174f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f175g = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f168a = epVar.GetContactSyncConfig();
                        b(true);
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f176h = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f177i = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 14:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f178j = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 15:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 6) {
                        break;
                    } else {
                        this.f167a = epVar.DatabaseTableConfigUtil();
                        c(true);
                        continue;
                    }
                case 16:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 6) {
                        break;
                    } else {
                        this.f170b = epVar.DatabaseTableConfigUtil();
                        d(true);
                        continue;
                    }
                case 20:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f179k = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 21:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f180l = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 22:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 8) {
                        break;
                    } else {
                        this.f160a = epVar.getAuthRequestContext();
                        e(true);
                        continue;
                    }
                case 23:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 13) {
                        break;
                    } else {
                        eo moveToNextValue = epVar.moveToNextValue();
                        this.f166a = new HashMap(moveToNextValue.PlaceComponentResult * 2);
                        for (int i2 = 0; i2 < moveToNextValue.PlaceComponentResult; i2++) {
                            this.f166a.put(epVar.getErrorConfigVersion(), epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f165a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m290a() {
        return this.f164a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m291a(dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        boolean m290a = m290a();
        boolean m290a2 = dlVar.m290a();
        if ((m290a || m290a2) && !(m290a && m290a2 && this.f164a.equals(dlVar.f164a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dlVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f162a.m289a(dlVar.f162a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dlVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f169b.equals(dlVar.f169b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dlVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f171c.equals(dlVar.f171c))) || this.f161a != dlVar.f161a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dlVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f172d.equals(dlVar.f172d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dlVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f173e.equals(dlVar.f173e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dlVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f163a.m348a(dlVar.f163a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dlVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f174f.equals(dlVar.f174f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dlVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f175g.equals(dlVar.f175g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dlVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f168a == dlVar.f168a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dlVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f176h.equals(dlVar.f176h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dlVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f177i.equals(dlVar.f177i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dlVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f178j.equals(dlVar.f178j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dlVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f167a == dlVar.f167a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dlVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f170b == dlVar.f170b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dlVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f179k.equals(dlVar.f179k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dlVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f180l.equals(dlVar.f180l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = dlVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f160a == dlVar.f160a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = dlVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f166a.equals(dlVar.f166a);
        }
        return true;
    }

    public dl b(String str) {
        this.f171c = str;
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f164a != null && m290a()) {
            epVar.PlaceComponentResult(f7764a);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f164a);
        }
        if (this.f162a != null && b()) {
            epVar.PlaceComponentResult(b);
            this.f162a.b(epVar);
        }
        if (this.f169b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f169b);
        }
        if (this.f171c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f171c);
        }
        epVar.PlaceComponentResult(e);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f161a);
        if (this.f172d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f172d);
        }
        if (this.f173e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f173e);
        }
        if (this.f163a != null && h()) {
            epVar.PlaceComponentResult(h);
            this.f163a.b(epVar);
        }
        if (this.f174f != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f174f);
        }
        if (this.f175g != null && j()) {
            epVar.PlaceComponentResult(j);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f175g);
        }
        if (k()) {
            epVar.PlaceComponentResult(k);
            epVar.getAuthRequestContext(this.f168a);
        }
        if (this.f176h != null && l()) {
            epVar.PlaceComponentResult(l);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f176h);
        }
        if (this.f177i != null && m()) {
            epVar.PlaceComponentResult(m);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f177i);
        }
        if (this.f178j != null && n()) {
            epVar.PlaceComponentResult(n);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f178j);
        }
        if (o()) {
            epVar.PlaceComponentResult(f7765o);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f167a);
        }
        if (p()) {
            epVar.PlaceComponentResult(p);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f170b);
        }
        if (this.f179k != null && q()) {
            epVar.PlaceComponentResult(q);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f179k);
        }
        if (this.f180l != null && r()) {
            epVar.PlaceComponentResult(r);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f180l);
        }
        if (s()) {
            epVar.PlaceComponentResult(s);
            epVar.MyBillsEntityDataFactory(this.f160a);
        }
        if (this.f166a != null && t()) {
            epVar.PlaceComponentResult(t);
            epVar.getAuthRequestContext(new eo((byte) 11, (byte) 11, this.f166a.size()));
            for (Map.Entry<String, String> entry : this.f166a.entrySet()) {
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getKey());
                epVar.BuiltInFictitiousFunctionClassFactory(entry.getValue());
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f165a.set(1, z);
    }

    public boolean b() {
        return this.f162a != null;
    }

    public dl c(String str) {
        this.f172d = str;
        return this;
    }

    public void c(boolean z) {
        this.f165a.set(2, z);
    }

    public boolean c() {
        return this.f169b != null;
    }

    public dl d(String str) {
        this.f173e = str;
        return this;
    }

    public void d(boolean z) {
        this.f165a.set(3, z);
    }

    public boolean d() {
        return this.f171c != null;
    }

    public void e(boolean z) {
        this.f165a.set(4, z);
    }

    public boolean e() {
        return this.f165a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dl)) {
            return m291a((dl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f172d != null;
    }

    public boolean g() {
        return this.f173e != null;
    }

    public boolean h() {
        return this.f163a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f174f != null;
    }

    public boolean j() {
        return this.f175g != null;
    }

    public boolean k() {
        return this.f165a.get(1);
    }

    public boolean l() {
        return this.f176h != null;
    }

    public boolean m() {
        return this.f177i != null;
    }

    public boolean n() {
        return this.f178j != null;
    }

    public boolean o() {
        return this.f165a.get(2);
    }

    public boolean p() {
        return this.f165a.get(3);
    }

    public boolean q() {
        return this.f179k != null;
    }

    public boolean r() {
        return this.f180l != null;
    }

    public boolean s() {
        return this.f165a.get(4);
    }

    public boolean t() {
        return this.f166a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m290a()) {
            sb.append("debug:");
            String str = this.f164a;
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
            dk dkVar = this.f162a;
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
        String str2 = this.f169b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f171c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f161a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f172d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f173e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            dx dxVar = this.f163a;
            if (dxVar == null) {
                sb.append("null");
            } else {
                sb.append(dxVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f174f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f175g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f168a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f176h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f177i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f178j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f167a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f170b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f179k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f180l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f160a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f166a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
