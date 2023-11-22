package com.alibaba.griver.base.resource.appcenter.storage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes3.dex */
public abstract class GriverAbstractDBHelper extends SQLiteOpenHelper {
    public abstract String getTableName();

    public GriverAbstractDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public GriverAbstractDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i, databaseErrorHandler);
    }

    public GriverAbstractDBHelper(Context context, String str, int i, SQLiteDatabase.OpenParams openParams) {
        super(context, str, i, openParams);
    }
}
