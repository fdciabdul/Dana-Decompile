package com.alibaba.griver.base.resource.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper;

/* loaded from: classes3.dex */
public class GriverCacheDBHelper extends GriverAbstractDBHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f6355a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public GriverCacheDBHelper(Context context) {
        super(context, "griver_cache", (SQLiteDatabase.CursorFactory) null, 1);
        this.f6355a = "griver_tb_cache";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS griver_tb_cache(id INTEGER PRIMARY KEY autoincrement, cacheName TEXT , cacheKey TEXT, cacheValue TEXT,cacheType TEXT,cacheSize LONG, expiredTimeStamp LONG,createTimeStamp LONG,extra TEXT)");
    }

    @Override // com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper
    public String getTableName() {
        return this.f6355a;
    }
}
