package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;

/* loaded from: classes8.dex */
public class a extends SQLiteOpenHelper {
    public static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private static final String[] MyBillsEntityDataFactory = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};
    private static int PlaceComponentResult = 1;

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, PlaceComponentResult);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            try {
                StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
                int i = 0;
                while (true) {
                    String[] strArr = MyBillsEntityDataFactory;
                    if (i >= strArr.length - 1) {
                        break;
                    }
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append(strArr[i]);
                    sb.append(" ");
                    sb.append(strArr[i + 1]);
                    i += 2;
                }
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (SQLException e) {
                b.getAuthRequestContext(e);
            }
        }
    }
}
