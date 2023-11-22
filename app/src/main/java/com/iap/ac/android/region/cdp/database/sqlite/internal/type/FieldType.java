package com.iap.ac.android.region.cdp.database.sqlite.internal.type;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public interface FieldType<T> {
    T getCursorValue(Cursor cursor, int i);

    String getSqlType();

    void put(ContentValues contentValues, String str, Object obj);
}
