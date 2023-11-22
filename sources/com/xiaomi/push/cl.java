package com.xiaomi.push;

import android.os.Bundle;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes8.dex */
public class cl extends cj {
    private int BuiltInFictitiousFunctionClassFactory;
    a KClassImpl$Data$declaredNonStaticMembers$2;
    private b MyBillsEntityDataFactory;
    String PlaceComponentResult;

    /* loaded from: classes8.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: classes8.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public cl(Bundle bundle) {
        super(bundle);
        this.MyBillsEntityDataFactory = b.available;
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.MyBillsEntityDataFactory = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.PlaceComponentResult = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.BuiltInFictitiousFunctionClassFactory = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    @Override // com.xiaomi.push.cj
    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        b bVar = this.MyBillsEntityDataFactory;
        if (bVar != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.PlaceComponentResult;
        if (str != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_pres_status", str);
        }
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i != Integer.MIN_VALUE) {
            KClassImpl$Data$declaredNonStaticMembers$2.putInt("ext_pres_prio", i);
        }
        a aVar = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar != null && aVar != a.available) {
            KClassImpl$Data$declaredNonStaticMembers$2.putString("ext_pres_mode", this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void MyBillsEntityDataFactory(int i) {
        if (i >= -128 && i <= 128) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Priority value ");
        sb.append(i);
        sb.append(" is not valid. Valid range is -128 through 128.");
        throw new IllegalArgumentException(sb.toString());
    }

    public cl(b bVar) {
        this.MyBillsEntityDataFactory = b.available;
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.MyBillsEntityDataFactory = bVar;
    }

    @Override // com.xiaomi.push.cj
    public final String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (moveToNextValue() != null) {
            sb.append(" xmlns=\"");
            sb.append(moveToNextValue());
            sb.append("\"");
        }
        if (getAuthRequestContext() != null) {
            sb.append(" id=\"");
            sb.append(getAuthRequestContext());
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            sb.append(" to=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7));
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            sb.append(" from=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
            sb.append("\"");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
            sb.append(" chid=\"");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            sb.append("\"");
        }
        if (this.MyBillsEntityDataFactory != null) {
            sb.append(" type=\"");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.PlaceComponentResult != null) {
            sb.append("<status>");
            sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult));
            sb.append("</status>");
        }
        if (this.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("</priority>");
        }
        a aVar = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("</show>");
        }
        sb.append(scheduleImpl());
        cn cnVar = this.isLayoutRequested;
        if (cnVar != null) {
            sb.append(cnVar.PlaceComponentResult());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
