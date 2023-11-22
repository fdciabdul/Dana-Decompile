package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class TransactionHelper {
    public static <T> T callInTransaction(Context context, String str, Callable<T> callable) throws SQLException {
        if (context != null && str != null && callable != null) {
            SQLiteOpenHelper sQLiteOpenHelper = SQLiteOpenHelperManager.getInstance().get(str, context);
            if (sQLiteOpenHelper != null) {
                return (T) callInTransaction(sQLiteOpenHelper.getWritableDatabase(), callable);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can not get a SQLiteOpenHelper for database ");
            sb.append(str);
            throw new SQLException(sb.toString());
        }
        throw null;
    }

    public static <T> T callInTransaction(SQLiteDatabase sQLiteDatabase, Callable<T> callable) throws SQLException {
        if (sQLiteDatabase != null && callable != null) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    T call = callable.call();
                    sQLiteDatabase.setTransactionSuccessful();
                    return call;
                } catch (SQLException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SQLException(e2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        throw null;
    }
}
