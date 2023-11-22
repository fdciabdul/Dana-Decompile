package com.alibaba.griver.base.resource.appcenter.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public class GriverAppInfoDBHelper extends GriverAbstractDBHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f6350a;

    public GriverAppInfoDBHelper(Context context) {
        super(context, "griver_app_info", (SQLiteDatabase.CursorFactory) null, 2);
        this.f6350a = "tb_app_info";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_app_info(id INTEGER PRIMARY KEY autoincrement, appId TEXT , appInfo TEXT, lastRefreshTimestamp INTEGER, version TEXT)");
        sQLiteDatabase.execSQL("ALTER TABLE tb_app_info ADD COLUMN lastOpenTimestamp INTEGER");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE tb_app_info ADD COLUMN lastOpenTimestamp INTEGER");
        }
    }

    @Override // com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper
    public String getTableName() {
        return this.f6350a;
    }
}
