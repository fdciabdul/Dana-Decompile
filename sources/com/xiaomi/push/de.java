package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class de implements ef<de, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f99a;

    /* renamed from: a  reason: collision with other field name */
    public dc f100a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f101a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<dg> f102a;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f98a = new eu("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7755a = new em("", (byte) 8, 1);
    private static final em b = new em("", (byte) 15, 2);
    private static final em c = new em("", (byte) 8, 3);

    public int a() {
        return this.f99a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(de deVar) {
        int MyBillsEntityDataFactory;
        int authRequestContext;
        int PlaceComponentResult;
        if (getClass().equals(deVar.getClass())) {
            int compareTo = Boolean.valueOf(m260a()).compareTo(Boolean.valueOf(deVar.m260a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m260a() || (PlaceComponentResult = eg.PlaceComponentResult(this.f99a, deVar.f99a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(deVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (authRequestContext = eg.getAuthRequestContext(this.f102a, deVar.f102a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(deVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (MyBillsEntityDataFactory = eg.MyBillsEntityDataFactory(this.f100a, deVar.f100a)) == 0) {
                        return 0;
                    }
                    return MyBillsEntityDataFactory;
                }
                return authRequestContext;
            }
            return PlaceComponentResult;
        }
        return getClass().getName().compareTo(deVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public dc m258a() {
        return this.f100a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m259a() {
        if (this.f102a != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'configItems' was not present! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                break;
            }
            short s = PlaceComponentResult.MyBillsEntityDataFactory;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 8) {
                        this.f100a = dc.a(epVar.getAuthRequestContext());
                    }
                    es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 15) {
                    en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    this.f102a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                    for (int i = 0; i < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                        dg dgVar = new dg();
                        dgVar.a(epVar);
                        this.f102a.add(dgVar);
                    }
                } else {
                    es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                }
            } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 8) {
                this.f99a = epVar.getAuthRequestContext();
                a(true);
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (m260a()) {
            m259a();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'version' was not found in serialized data! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    public void a(boolean z) {
        this.f101a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m260a() {
        return this.f101a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m261a(de deVar) {
        if (deVar != null && this.f99a == deVar.f99a) {
            boolean b2 = b();
            boolean b3 = deVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f102a.equals(deVar.f102a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = deVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f100a.equals(deVar.f100a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m259a();
        epVar.PlaceComponentResult(f7755a);
        epVar.MyBillsEntityDataFactory(this.f99a);
        if (this.f102a != null) {
            epVar.PlaceComponentResult(b);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 12, this.f102a.size()));
            Iterator<dg> it = this.f102a.iterator();
            while (it.hasNext()) {
                it.next().b(epVar);
            }
        }
        if (this.f100a != null && c()) {
            epVar.PlaceComponentResult(c);
            epVar.MyBillsEntityDataFactory(this.f100a.a());
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean b() {
        return this.f102a != null;
    }

    public boolean c() {
        return this.f100a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof de)) {
            return m261a((de) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f99a);
        sb.append(", ");
        sb.append("configItems:");
        List<dg> list = this.f102a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            dc dcVar = this.f100a;
            if (dcVar == null) {
                sb.append("null");
            } else {
                sb.append(dcVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
