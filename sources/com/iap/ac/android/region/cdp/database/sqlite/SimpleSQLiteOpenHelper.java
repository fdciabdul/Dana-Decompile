package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes3.dex */
public class SimpleSQLiteOpenHelper extends SQLiteOpenHelper {
    public final Class<?>[] mClazzes;

    public SimpleSQLiteOpenHelper(Class<?>[] clsArr, Context context, String str) {
        this(clsArr, context, str, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (Class<?> cls : this.mClazzes) {
            ParsedTableInfo.create(cls).createTable(sQLiteDatabase, true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public SimpleSQLiteOpenHelper(Class<?>[] clsArr, Context context, String str, int i) {
        this(clsArr, context, str, null, i);
    }

    public SimpleSQLiteOpenHelper(Class<?>[] clsArr, Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.mClazzes = clsArr;
    }

    public SimpleSQLiteOpenHelper(Class<?>[] clsArr, Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i, databaseErrorHandler);
        this.mClazzes = clsArr;
    }
}
