package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class IntegerType implements FieldType<Integer> {
    public static final IntegerType sIntegerType = new IntegerType();

    public static IntegerType getInstance() {
        return sIntegerType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "INTEGER";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Integer) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Integer getCursorValue(Cursor cursor, int i) {
        return Integer.valueOf(cursor.getInt(i));
    }
}
