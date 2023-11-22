package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class BooleanType implements FieldType<Boolean> {
    public static final BooleanType sBooleanType = new BooleanType();

    public static BooleanType getInstance() {
        return sBooleanType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "INTEGER";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Boolean) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Boolean getCursorValue(Cursor cursor, int i) {
        return Boolean.valueOf(cursor.getInt(i) != 0);
    }
}
