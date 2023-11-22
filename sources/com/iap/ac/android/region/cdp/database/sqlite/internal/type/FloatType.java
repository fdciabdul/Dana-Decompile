package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class FloatType implements FieldType<Float> {
    public static final FloatType sFloatType = new FloatType();

    public static FloatType getInstance() {
        return sFloatType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "REAL";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Float) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Float getCursorValue(Cursor cursor, int i) {
        return Float.valueOf(cursor.getFloat(i));
    }
}
