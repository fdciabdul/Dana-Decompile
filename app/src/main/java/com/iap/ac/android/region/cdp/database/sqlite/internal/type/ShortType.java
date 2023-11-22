package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class ShortType implements FieldType<Short> {
    public static final ShortType sShortType = new ShortType();

    public static ShortType getInstance() {
        return sShortType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "INTEGER";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Short) obj);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Short getCursorValue(Cursor cursor, int i) {
        return Short.valueOf(cursor.getShort(i));
    }
}
