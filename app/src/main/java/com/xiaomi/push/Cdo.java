package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes8.dex */
public class Cdo implements ef<Cdo, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f198a;

    /* renamed from: a  reason: collision with other field name */
    public dk f199a;

    /* renamed from: a  reason: collision with other field name */
    public String f200a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f202a;

    /* renamed from: b  reason: collision with other field name */
    public String f204b;

    /* renamed from: c  reason: collision with other field name */
    public String f206c;

    /* renamed from: d  reason: collision with other field name */
    public String f207d;

    /* renamed from: e  reason: collision with other field name */
    public String f208e;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f197a = new eu("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7768a = new em("", (byte) 12, 2);
    private static final em b = new em("", (byte) 11, 3);
    private static final em c = new em("", (byte) 11, 4);
    private static final em d = new em("", (byte) 11, 5);
    private static final em e = new em("", (byte) 15, 6);
    private static final em f = new em("", (byte) 11, 7);
    private static final em g = new em("", (byte) 11, 9);
    private static final em h = new em("", (byte) 2, 10);
    private static final em i = new em("", (byte) 2, 11);
    private static final em j = new em("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f201a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f203a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f205b = true;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        r0 = r4.f200a.compareTo(r5.f200a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        r0 = r4.f204b.compareTo(r5.f204b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
    
        r0 = r4.f206c.compareTo(r5.f206c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        r0 = r4.f207d.compareTo(r5.f207d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        r0 = r4.f208e.compareTo(r5.f208e);
     */
    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.xiaomi.push.Cdo r5) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.Cdo.compareTo(com.xiaomi.push.do):int");
    }

    public Cdo a(String str) {
        this.f200a = str;
        return this;
    }

    public void a() {
        if (this.f200a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'id' was not present! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (this.f204b == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appId' was not present! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        } else if (this.f206c != null) {
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
                a();
                return;
            }
            switch (PlaceComponentResult.MyBillsEntityDataFactory) {
                case 2:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 12) {
                        break;
                    } else {
                        dk dkVar = new dk();
                        this.f199a = dkVar;
                        dkVar.a(epVar);
                        continue;
                    }
                case 3:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f200a = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 4:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f204b = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 5:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f206c = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 6:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 15) {
                        break;
                    } else {
                        en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        this.f202a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                        for (int i2 = 0; i2 < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                            this.f202a.add(epVar.getErrorConfigVersion());
                        }
                        continue;
                    }
                case 7:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f207d = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 9:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 11) {
                        break;
                    } else {
                        this.f208e = epVar.getErrorConfigVersion();
                        continue;
                    }
                case 10:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f203a = epVar.GetContactSyncConfig();
                        a(true);
                        continue;
                    }
                case 11:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 2) {
                        break;
                    } else {
                        this.f205b = epVar.GetContactSyncConfig();
                        b(true);
                        continue;
                    }
                case 12:
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != 10) {
                        break;
                    } else {
                        this.f198a = epVar.MyBillsEntityDataFactory();
                        c(true);
                        continue;
                    }
            }
            es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m299a(String str) {
        if (this.f202a == null) {
            this.f202a = new ArrayList();
        }
        this.f202a.add(str);
    }

    public void a(boolean z) {
        this.f201a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m300a() {
        return this.f199a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m301a(Cdo cdo) {
        if (cdo == null) {
            return false;
        }
        boolean m300a = m300a();
        boolean m300a2 = cdo.m300a();
        if ((m300a || m300a2) && !(m300a && m300a2 && this.f199a.m289a(cdo.f199a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = cdo.b();
        if ((b2 || b3) && !(b2 && b3 && this.f200a.equals(cdo.f200a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = cdo.c();
        if ((c2 || c3) && !(c2 && c3 && this.f204b.equals(cdo.f204b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cdo.d();
        if ((d2 || d3) && !(d2 && d3 && this.f206c.equals(cdo.f206c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cdo.e();
        if ((e2 || e3) && !(e2 && e3 && this.f202a.equals(cdo.f202a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = cdo.f();
        if ((f2 || f3) && !(f2 && f3 && this.f207d.equals(cdo.f207d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cdo.g();
        if ((g2 || g3) && !(g2 && g3 && this.f208e.equals(cdo.f208e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cdo.h();
        if ((h2 || h3) && !(h2 && h3 && this.f203a == cdo.f203a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cdo.i();
        if ((i2 || i3) && !(i2 && i3 && this.f205b == cdo.f205b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cdo.j();
        if (j2 || j3) {
            return j2 && j3 && this.f198a == cdo.f198a;
        }
        return true;
    }

    public Cdo b(String str) {
        this.f204b = str;
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        if (this.f199a != null && m300a()) {
            epVar.PlaceComponentResult(f7768a);
            this.f199a.b(epVar);
        }
        if (this.f200a != null) {
            epVar.PlaceComponentResult(b);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f200a);
        }
        if (this.f204b != null) {
            epVar.PlaceComponentResult(c);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f204b);
        }
        if (this.f206c != null) {
            epVar.PlaceComponentResult(d);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f206c);
        }
        if (this.f202a != null && e()) {
            epVar.PlaceComponentResult(e);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 11, this.f202a.size()));
            Iterator<String> it = this.f202a.iterator();
            while (it.hasNext()) {
                epVar.BuiltInFictitiousFunctionClassFactory(it.next());
            }
        }
        if (this.f207d != null && f()) {
            epVar.PlaceComponentResult(f);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f207d);
        }
        if (this.f208e != null && g()) {
            epVar.PlaceComponentResult(g);
            epVar.BuiltInFictitiousFunctionClassFactory(this.f208e);
        }
        if (h()) {
            epVar.PlaceComponentResult(h);
            epVar.getAuthRequestContext(this.f203a);
        }
        if (i()) {
            epVar.PlaceComponentResult(i);
            epVar.getAuthRequestContext(this.f205b);
        }
        if (j()) {
            epVar.PlaceComponentResult(j);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(this.f198a);
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f201a.set(1, z);
    }

    public boolean b() {
        return this.f200a != null;
    }

    public Cdo c(String str) {
        this.f206c = str;
        return this;
    }

    public void c(boolean z) {
        this.f201a.set(2, z);
    }

    public boolean c() {
        return this.f204b != null;
    }

    public Cdo d(String str) {
        this.f207d = str;
        return this;
    }

    public boolean d() {
        return this.f206c != null;
    }

    public Cdo e(String str) {
        this.f208e = str;
        return this;
    }

    public boolean e() {
        return this.f202a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cdo)) {
            return m301a((Cdo) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f207d != null;
    }

    public boolean g() {
        return this.f208e != null;
    }

    public boolean h() {
        return this.f201a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f201a.get(1);
    }

    public boolean j() {
        return this.f201a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m300a()) {
            sb.append("target:");
            dk dkVar = this.f199a;
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
        String str = this.f200a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f204b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f206c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f202a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f207d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f208e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f203a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f205b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f198a);
        }
        sb.append(")");
        return sb.toString();
    }
}
