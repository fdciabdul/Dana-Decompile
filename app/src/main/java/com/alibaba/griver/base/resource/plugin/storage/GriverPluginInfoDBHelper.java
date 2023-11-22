package com.alibaba.griver.base.resource.plugin.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper;

/* loaded from: classes6.dex */
public class GriverPluginInfoDBHelper extends GriverAbstractDBHelper {

    /* renamed from: a  reason: collision with root package name */
    private final String f6369a;

    @Override // com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper
    public String getTableName() {
        return "tb_plugin_info";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public GriverPluginInfoDBHelper(Context context) {
        super(context, "griver_plugin_info", (SQLiteDatabase.CursorFactory) null, 1);
        this.f6369a = "tb_plugin_info";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_plugin_info(id INTEGER PRIMARY KEY autoincrement, pluginId TEXT , plugInfo TEXT , lastRefreshTimestamp INTEGER, version TEXT)");
    }
}
