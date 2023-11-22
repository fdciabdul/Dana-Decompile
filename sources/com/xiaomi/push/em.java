package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes8.dex */
public class em {
    public final byte BuiltInFictitiousFunctionClassFactory;
    public final short MyBillsEntityDataFactory;
    public final String PlaceComponentResult;

    public em() {
        this("", (byte) 0, (short) 0);
    }

    public em(String str, byte b, short s) {
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = b;
        this.MyBillsEntityDataFactory = s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<TField name:'");
        sb.append(this.PlaceComponentResult);
        sb.append("' type:");
        sb.append((int) this.BuiltInFictitiousFunctionClassFactory);
        sb.append(" field-id:");
        sb.append((int) this.MyBillsEntityDataFactory);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
