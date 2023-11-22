package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class ByteArrayType implements FieldType<byte[]> {
    public static final ByteArrayType sByteArrayType = new ByteArrayType();

    public static ByteArrayType getInstance() {
        return sByteArrayType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "BLOB";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (byte[]) obj);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public byte[] getCursorValue(Cursor cursor, int i) {
        return cursor.getBlob(i);
    }
}
