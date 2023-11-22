package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class dr implements ef<dr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<dg> f232a;

    /* renamed from: a  reason: collision with other field name */
    private static final eu f231a = new eu("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final em f7771a = new em("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(dr drVar) {
        int authRequestContext;
        if (getClass().equals(drVar.getClass())) {
            int compareTo = Boolean.valueOf(m318a()).compareTo(Boolean.valueOf(drVar.m318a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m318a() || (authRequestContext = eg.getAuthRequestContext(this.f232a, drVar.f232a)) == 0) {
                return 0;
            }
            return authRequestContext;
        }
        return getClass().getName().compareTo(drVar.getClass().getName());
    }

    public List<dg> a() {
        return this.f232a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m317a() {
        if (this.f232a != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'customConfigs' was not present! Struct: ");
        sb.append(toString());
        throw new eq(sb.toString());
    }

    @Override // com.xiaomi.push.ef
    public void a(ep epVar) {
        while (true) {
            em PlaceComponentResult = epVar.PlaceComponentResult();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0) {
                m317a();
                return;
            } else if (PlaceComponentResult.MyBillsEntityDataFactory == 1 && PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 15) {
                en NetworkUserEntityData$$ExternalSyntheticLambda0 = epVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.f232a = new ArrayList(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i = 0; i < NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                    dg dgVar = new dg();
                    dgVar.a(epVar);
                    this.f232a.add(dgVar);
                }
            } else {
                es.BuiltInFictitiousFunctionClassFactory(epVar, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m318a() {
        return this.f232a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m319a(dr drVar) {
        if (drVar == null) {
            return false;
        }
        boolean m318a = m318a();
        boolean m318a2 = drVar.m318a();
        if (m318a || m318a2) {
            return m318a && m318a2 && this.f232a.equals(drVar.f232a);
        }
        return true;
    }

    @Override // com.xiaomi.push.ef
    public void b(ep epVar) {
        m317a();
        if (this.f232a != null) {
            epVar.PlaceComponentResult(f7771a);
            epVar.KClassImpl$Data$declaredNonStaticMembers$2(new en((byte) 12, this.f232a.size()));
            Iterator<dg> it = this.f232a.iterator();
            while (it.hasNext()) {
                it.next().b(epVar);
            }
        }
        epVar.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dr)) {
            return m319a((dr) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<dg> list = this.f232a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
