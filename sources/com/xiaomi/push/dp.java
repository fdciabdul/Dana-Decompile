package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class dp implements ef<dp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f210a;

    /* renamed from: a  reason: collision with other field name */
    public dk f211a;

    /* renamed from: a  reason: collision with other field name */
    public String f212a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f214a;

    /* renamed from: b  reason: collision with other field name */
    public String f216b;

    /* renamed from: c  reason: collision with other field name */
    public String f217c;

    /* renamed from: d  reason: collision with other field name */
    public String f218d;

    /* renamed from: e  reason: collision with other field name */
    public String f219e;

    /* renamed from: f  reason: collision with other field name */
    public String f220f;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f209a = new eu("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7769a = new em("", (byte) 12, 2);
    private static final em b = new em("", (byte) 11, 3);
    private static final em c = new em("", (byte) 11, 4);
    private static final em d = new em("", (byte) 11, 5);
    private static final em e = new em("", (byte) 10, 7);
    private static final em f = new em("", (byte) 11, 8);
    private static final em g = new em("", (byte) 11, 9);
    private static final em h = new em("", (byte) 15, 10);
    private static final em i = new em("", (byte) 11, 12);
    private static final em j = new em("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f213a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f215a = true;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        r0 = r4.f212a.compareTo(r5.f212a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f216b.compareTo(r5.f216b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f217c.compareTo(r5.f217c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f218d.compareTo(r5.f218d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f219e.compareTo(r5.f219e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0180, code lost:
    
        r0 = r4.f220f.compareTo(r5.f220f);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.dp r5) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dp.compareTo(com.xiaomi.push.dp):int");
    }

    public String a() {
        return this.f212a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m302a() {
        return this.f214a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m303a() {
        if (this.f212a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f216b == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f217c != null) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'cmdName' was not present! Struct: ");
            sb3.append(toString());
            throw new eq(sb3.toString());
        }
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                if (e()) {
                    m303a();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'errorCode' was not found in serialized data! Struct: ");
                sb.append(toString());
                throw new eq(sb.toString());
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f211a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f212a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f216b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f217c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f210a = epVar.MyBillsEntityDataFactory();
                        a(true);
                        continue;
                    }
                case 8:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f218d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f219e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 15) {
                        break;
                    } else {
                        en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        this.f214a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                        for (int i2 = 0; i2 < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                            this.f214a.add(epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f220f = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 13:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f215a = epVar.GetContactSyncConfig();
                        b(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void a(boolean z) {
        this.f213a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m304a() {
        return this.f211a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m305a(dp dpVar) {
        if (dpVar == null) {
            return false;
        }
        boolean m304a = m304a();
        boolean m304a2 = dpVar.m304a();
        if ((m304a || m304a2) && !(m304a && m304a2 && this.f211a.m289a(dpVar.f211a))) {
            return false;
        }
        boolean m306b = m306b();
        boolean m306b2 = dpVar.m306b();
        if ((m306b || m306b2) && !(m306b && m306b2 && this.f212a.equals(dpVar.f212a))) {
            return false;
        }
        boolean m307c = m307c();
        boolean m307c2 = dpVar.m307c();
        if ((m307c || m307c2) && !(m307c && m307c2 && this.f216b.equals(dpVar.f216b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dpVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f217c.equals(dpVar.f217c))) || this.f210a != dpVar.f210a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dpVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f218d.equals(dpVar.f218d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dpVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f219e.equals(dpVar.f219e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dpVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f214a.equals(dpVar.f214a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dpVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f220f.equals(dpVar.f220f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dpVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f215a == dpVar.f215a;
        }
        return true;
    }

    public String b() {
        return this.f217c;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m303a();
        if (this.f211a != null && m304a()) {
            epVar.PlaceComponentResult(f7769a);
            this.f211a.b(epVar);
        }
        if (this.f212a != null) {
            epVar.PlaceComponentResult(b);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f212a);
        }
        if (this.f216b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f216b);
        }
        if (this.f217c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f217c);
        }
        epVar.PlaceComponentResult(e);
        epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f210a);
        if (this.f218d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f218d);
        }
        if (this.f219e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f219e);
        }
        if (this.f214a != null && h()) {
            epVar.PlaceComponentResult(h);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 11, this.f214a.size()));
            Iterator<String> it = this.f214a.iterator();
            while (it.hasNext()) {
                epVar.BuiltInFictitiousFunctionClassFactory(it.next());
            }
        }
        if (this.f220f != null && i()) {
            epVar.PlaceComponentResult(i);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f220f);
        }
        if (j()) {
            epVar.PlaceComponentResult(j);
            epVar.getAuthRequestContext(this.f215a);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f213a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m306b() {
        return this.f212a != null;
    }

    public String c() {
        return this.f220f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m307c() {
        return this.f216b != null;
    }

    public boolean d() {
        return this.f217c != null;
    }

    public boolean e() {
        return this.f213a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dp)) {
            return m305a((dp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f218d != null;
    }

    public boolean g() {
        return this.f219e != null;
    }

    public boolean h() {
        return this.f214a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f220f != null;
    }

    public boolean j() {
        return this.f213a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m304a()) {
            sb.append("target:");
            dk dkVar = this.f211a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f212a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f216b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f217c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f210a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f218d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f219e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f214a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f220f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f215a);
        }
        sb.append(")");
        return sb.toString();
    }
}
