package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class ds implements ef<ds, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<de> f234a;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f233a = new eu("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7772a = new em("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(ds dsVar) {
        int authRequestContext;
        if (getClass().equals(dsVar.getClass())) {
            int compareTo = Boolean.valueOf(m321a()).compareTo(Boolean.valueOf(dsVar.m321a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m321a() || (authRequestContext = eg.getAuthRequestContext(this.f234a, dsVar.f234a)) == 0) {
                return 0;
            }
            return authRequestContext;
        }
        return getClass().getName().compareTo(dsVar.getClass().getName());
    }

    public List<de> a() {
        return this.f234a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m320a() {
        if (this.f234a != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'normalConfigs' was not present! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m320a();
                return;
            } else if (PlaceComponentResult.MyBillsEntityDataFactory == 1 && PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 15) {
                en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.f234a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i = 0; i < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                    de deVar = new de();
                    deVar.a(epVar);
                    this.f234a.add(deVar);
                }
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m321a() {
        return this.f234a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m322a(ds dsVar) {
        if (dsVar == null) {
            return false;
        }
        boolean m321a = m321a();
        boolean m321a2 = dsVar.m321a();
        if (m321a || m321a2) {
            return m321a && m321a2 && this.f234a.equals(dsVar.f234a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m320a();
        if (this.f234a != null) {
            epVar.PlaceComponentResult(f7772a);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 12, this.f234a.size()));
            Iterator<de> it = this.f234a.iterator();
            while (it.hasNext()) {
                it.next().b(epVar);
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ds)) {
            return m322a((ds) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<de> list = this.f234a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
