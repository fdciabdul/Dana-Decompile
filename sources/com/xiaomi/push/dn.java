package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes8.dex */
public class dn implements ef<dn, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f194a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f195a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f196b;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f193a = new eu("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7767a = new em("", (byte) 8, 1);
    private static final em b = new em("", (byte) 8, 2);

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(dn dnVar) {
        int PlaceComponentResult;
        int PlaceComponentResult2;
        if (getClass().equals(dnVar.getClass())) {
            int compareTo = Boolean.valueOf(m297a()).compareTo(Boolean.valueOf(dnVar.m297a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m297a() || (PlaceComponentResult2 = eg.PlaceComponentResult(this.f194a, dnVar.f194a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dnVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (PlaceComponentResult = eg.PlaceComponentResult(this.f196b, dnVar.f196b)) == 0) {
                    return 0;
                }
                return PlaceComponentResult;
            }
            return PlaceComponentResult2;
        }
        return getClass().getName().compareTo(dnVar.getClass().getName());
    }

    public dn a(int i) {
        this.f194a = i;
        a(true);
        return this;
    }

    public void a() {
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
                if (s == 2 && PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 8) {
                    this.f196b = epVar.getAuthRequestContext();
                    b(true);
                }
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 8) {
                this.f194a = epVar.getAuthRequestContext();
                a(true);
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (!m297a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'miscConfigVersion' was not found in serialized data! Struct: ");
            sb.append(toString());
            throw new eq(sb.toString());
        } else if (b()) {
            a();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'pluginConfigVersion' was not found in serialized data! Struct: ");
            sb2.append(toString());
            throw new eq(sb2.toString());
        }
    }

    public void a(boolean z) {
        this.f195a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m297a() {
        return this.f195a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m298a(dn dnVar) {
        return dnVar != null && this.f194a == dnVar.f194a && this.f196b == dnVar.f196b;
    }

    public dn b(int i) {
        this.f196b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        a();
        epVar.PlaceComponentResult(f7767a);
        epVar.MyBillsEntityDataFactory(this.f194a);
        epVar.PlaceComponentResult(b);
        epVar.MyBillsEntityDataFactory(this.f196b);
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void b(boolean z) {
        this.f195a.set(1, z);
    }

    public boolean b() {
        return this.f195a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dn)) {
            return m298a((dn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCheckClientInfo(");
        sb.append("miscConfigVersion:");
        sb.append(this.f194a);
        sb.append(", ");
        sb.append("pluginConfigVersion:");
        sb.append(this.f196b);
        sb.append(")");
        return sb.toString();
    }
}
