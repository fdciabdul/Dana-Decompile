package com.alibaba.griver.base.resource.appcenter.predownloadstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper;

/* loaded from: classes3.dex */
public class GriverAppInfoPreDownLoadDBHelper extends GriverAbstractDBHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f6349a;

    public GriverAppInfoPreDownLoadDBHelper(Context context) {
        super(context, "griver_pre_app_info", (SQLiteDatabase.CursorFactory) null, 2);
        this.f6349a = "tb_app_pre_down_info";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_app_pre_down_info(id INTEGER PRIMARY KEY autoincrement, appId TEXT , appInfo TEXT, lastRefreshTimestamp INTEGER, version TEXT)");
        sQLiteDatabase.execSQL("ALTER TABLE tb_app_pre_down_info ADD COLUMN lastOpenTimestamp INTEGER");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE tb_app_pre_down_info ADD COLUMN lastOpenTimestamp INTEGER");
        }
    }

    @Override // com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper
    public String getTableName() {
        return this.f6349a;
    }
}
