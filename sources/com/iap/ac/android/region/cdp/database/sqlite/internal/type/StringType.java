package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class StringType implements FieldType<String> {
    public static final StringType sStringType = new StringType();

    public static StringType getInstance() {
        return sStringType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "TEXT";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (String) obj);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getCursorValue(Cursor cursor, int i) {
        return cursor.getString(i);
    }
}
