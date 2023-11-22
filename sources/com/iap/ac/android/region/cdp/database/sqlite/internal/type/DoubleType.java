package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class DoubleType implements FieldType<Double> {
    public static final DoubleType sDoubleType = new DoubleType();

    public static DoubleType getInstance() {
        return sDoubleType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "REAL";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Double) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Double getCursorValue(Cursor cursor, int i) {
        return Double.valueOf(cursor.getDouble(i));
    }
}
