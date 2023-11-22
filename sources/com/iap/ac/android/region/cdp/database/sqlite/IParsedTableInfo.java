package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface IParsedTableInfo<T> {

    /* loaded from: classes8.dex */
    public interface GetFieldValueCallback {
        Object getFieldValue(String str);
    }

    ContentValues createContentValues(T t, boolean z) throws SQLException;

    T createObject(Cursor cursor) throws SQLException;

    T createObject(GetFieldValueCallback getFieldValueCallback) throws SQLException;

    void createTable(SQLiteDatabase sQLiteDatabase, boolean z);

    void dropTable(SQLiteDatabase sQLiteDatabase, boolean z);

    <ID> ID getId(T t) throws SQLException;

    String getIdColumnName() throws SQLException;

    String getTableName();

    boolean idExists();

    boolean isGeneratedId();

    boolean uniqueComboExists();

    boolean uniqueExists();
}
