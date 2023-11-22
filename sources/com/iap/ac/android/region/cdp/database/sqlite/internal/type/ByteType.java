package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public class ByteType implements FieldType<Byte> {
    public static final ByteType sByteType = new ByteType();

    public static ByteType getInstance() {
        return sByteType;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public String getSqlType() {
        return "INTEGER";
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public void put(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, (Byte) obj);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType
    public Byte getCursorValue(Cursor cursor, int i) {
        return Byte.valueOf((byte) cursor.getInt(i));
    }
}
