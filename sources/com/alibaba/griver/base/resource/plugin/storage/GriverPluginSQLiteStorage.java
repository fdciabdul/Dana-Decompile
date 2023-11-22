package com.alibaba.griver.base.resource.plugin.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverPluginSQLiteStorage implements GriverPluginStorageProxy {

    /* renamed from: a  reason: collision with root package name */
    private GriverAbstractDBHelper f6372a;
    private SQLiteDatabase b;

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public List<PluginDao> selectAllPluginInfos() {
        return null;
    }

    public GriverPluginSQLiteStorage(GriverAbstractDBHelper griverAbstractDBHelper) {
        this.f6372a = griverAbstractDBHelper;
        this.b = griverAbstractDBHelper.getWritableDatabase();
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public boolean insertOrUpdateInfo(PluginDao pluginDao) {
        if (this.b == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return false;
        }
        PluginDao selectPluginInfo = selectPluginInfo(pluginDao.getPluginId(), pluginDao.getVersion());
        ContentValues contentValues = new ContentValues();
        contentValues.put("pluginId", pluginDao.getPluginId());
        contentValues.put("version", pluginDao.getVersion());
        contentValues.put(PluginDao.COLUMN_PLUG_INFO, JSON.toJSONString(pluginDao.getPluginInfo()));
        contentValues.put("lastRefreshTimestamp", Long.valueOf(System.currentTimeMillis()));
        if (selectPluginInfo == null || selectPluginInfo.getPluginId() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("insert plugin info pluginId ");
            sb.append(pluginDao.getPluginId());
            sb.append(" version: ");
            sb.append(pluginDao.getVersion());
            GriverLogger.d("GriverPluginSQLiteStorage", sb.toString());
            this.b.insert(this.f6372a.getTableName(), null, contentValues);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("update plugin info pluginId ");
            sb2.append(pluginDao.getPluginId());
            sb2.append(" version: ");
            sb2.append(pluginDao.getVersion());
            GriverLogger.d("GriverPluginSQLiteStorage", sb2.toString());
            this.b.update(this.f6372a.getTableName(), contentValues, "pluginId=? and version=?", new String[]{pluginDao.getPluginId(), pluginDao.getVersion()});
        }
        return true;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public boolean updateInfo(PluginDao pluginDao) {
        if (this.b == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pluginId", pluginDao.getPluginId());
        contentValues.put("version", pluginDao.getVersion());
        contentValues.put(PluginDao.COLUMN_PLUG_INFO, JSON.toJSONString(pluginDao.getPluginInfo()));
        contentValues.put("lastRefreshTimestamp", Long.valueOf(pluginDao.getLastRefreshTimestamp()));
        this.b.update(this.f6372a.getTableName(), contentValues, "pluginId=? and version=?", new String[]{pluginDao.getPluginId(), pluginDao.getVersion()});
        return true;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public boolean insertOrUpdateInfo(List<PluginDao> list) {
        if (this.b == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return false;
        }
        Iterator<PluginDao> it = list.iterator();
        while (it.hasNext()) {
            insertOrUpdateInfo(it.next());
        }
        return true;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public boolean deletePluginInfo(PluginDao pluginDao) {
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return false;
        }
        sQLiteDatabase.delete(this.f6372a.getTableName(), "pluginId=? and version=?", new String[]{pluginDao.getPluginId(), pluginDao.getVersion()});
        return true;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public boolean deletePluginInfoById(String str) {
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return false;
        }
        sQLiteDatabase.delete(this.f6372a.getTableName(), "pluginId=?", new String[]{str});
        return true;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public PluginDao selectPluginInfo(String str, String str2) {
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return null;
        }
        Cursor query = sQLiteDatabase.query(this.f6372a.getTableName(), null, "pluginId=? and version=?", new String[]{str, str2}, null, null, null);
        if (query == null) {
            return null;
        }
        PluginDao pluginDao = new PluginDao();
        if (query.moveToNext()) {
            pluginDao = new PluginDao();
            pluginDao.setPluginId(query.getString(query.getColumnIndex("pluginId")));
            pluginDao.setVersion(query.getString(query.getColumnIndex("version")));
            pluginDao.setLastRefreshTimestamp(query.getLong(query.getColumnIndex("lastRefreshTimestamp")));
            try {
                pluginDao.setPluginInfo((PluginModel) JSON.parseObject(query.getString(query.getColumnIndex(PluginDao.COLUMN_PLUG_INFO)), PluginModel.class));
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse pluginInfo failed for");
                sb.append(str);
                GriverLogger.d("GriverPluginSQLiteStorage", sb.toString());
            }
        }
        query.close();
        return pluginDao;
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public PluginDao selectPluginInfoWithHighestVersion(String str) {
        Cursor query;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null || (query = sQLiteDatabase.query(this.f6372a.getTableName(), null, "pluginId=?", new String[]{str}, null, null, null)) == null) {
            return null;
        }
        while (query.moveToNext()) {
            PluginDao pluginDao = new PluginDao();
            pluginDao.setPluginId(query.getString(query.getColumnIndex("pluginId")));
            pluginDao.setVersion(query.getString(query.getColumnIndex("version")));
            pluginDao.setLastRefreshTimestamp(query.getLong(query.getColumnIndex("lastRefreshTimestamp")));
            try {
                pluginDao.setPluginInfo((PluginModel) JSON.parseObject(query.getString(query.getColumnIndex(PluginDao.COLUMN_PLUG_INFO)), PluginModel.class));
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse pluginInfo failed pluginId: ");
                sb.append(str);
                GriverLogger.d("GriverPluginSQLiteStorage", sb.toString());
            }
            arrayList.add(pluginDao);
        }
        query.close();
        if (arrayList.size() > 0) {
            Collections.sort(arrayList, new Comparator<PluginDao>() { // from class: com.alibaba.griver.base.resource.plugin.storage.GriverPluginSQLiteStorage.1
                @Override // java.util.Comparator
                public int compare(PluginDao pluginDao2, PluginDao pluginDao3) {
                    return RVResourceUtils.compareVersion(pluginDao3.getVersion(), pluginDao2.getVersion());
                }
            });
        }
        return (PluginDao) arrayList.get(0);
    }

    @Override // com.alibaba.griver.base.resource.plugin.storage.GriverPluginStorageProxy
    public List<PluginDao> selectAllPluginInfo(String str) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null) {
            GriverLogger.w("GriverPluginSQLiteStorage", "sqlite database is not ready, do nothing");
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query(this.f6372a.getTableName(), null, "appId=?", new String[]{str}, null, null, null);
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            PluginDao pluginDao = new PluginDao();
            pluginDao.setPluginId(query.getString(query.getColumnIndex("pluginId")));
            pluginDao.setVersion(query.getString(query.getColumnIndex("version")));
            pluginDao.setLastRefreshTimestamp(query.getLong(query.getColumnIndex("lastRefreshTimestamp")));
            pluginDao.setPluginInfo((PluginModel) JSON.parseObject(query.getString(query.getColumnIndex(PluginDao.COLUMN_PLUG_INFO)), PluginModel.class));
            arrayList.add(pluginDao);
        }
        query.close();
        return arrayList;
    }
}
