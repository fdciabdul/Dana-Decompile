package com.alibaba.griver.base.resource.appcenter.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAppSQLiteStorage implements GriverAppStorageProxy {
    protected static final String THREAD_NAME = "GriverAppSQLiteStorage";

    /* renamed from: a  reason: collision with root package name */
    private GriverAbstractDBHelper f6353a;
    private SQLiteDatabase b;
    private GriverAppInfoModelMemoryCache c;

    public GriverAppSQLiteStorage(GriverAbstractDBHelper griverAbstractDBHelper) {
        if (ProcessUtils.isMainProcess()) {
            this.f6353a = griverAbstractDBHelper;
            this.c = new GriverAppInfoModelMemoryCache();
            try {
                this.b = griverAbstractDBHelper.getWritableDatabase();
            } catch (Exception e) {
                MonitorMap.Builder builder = new MonitorMap.Builder();
                builder.message(e.getMessage());
                GriverMonitor.error(GriverMonitorConstants.ERROR_GET_PRE_DOWNLOAD_DATABASE, "GriverAppContainer", builder.build());
            }
        }
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public boolean insertOrUpdateInfo(final AppInfoDao appInfoDao) {
        if (this.b != null) {
            if (this.c.canCache()) {
                if (selectAppInfo(appInfoDao.getAppId(), appInfoDao.getVersion()) == null) {
                    GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appcenter.storage.GriverAppSQLiteStorage.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GriverAppSQLiteStorage.this.a(appInfoDao);
                        }
                    });
                } else {
                    GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appcenter.storage.GriverAppSQLiteStorage.2
                        @Override // java.lang.Runnable
                        public void run() {
                            GriverAppSQLiteStorage.this.b(appInfoDao);
                        }
                    });
                }
                this.c.setAppInfo(appInfoDao);
                return true;
            } else if (selectAppInfo(appInfoDao.getAppId(), appInfoDao.getVersion()) == null) {
                a(appInfoDao);
                return false;
            } else {
                b(appInfoDao);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AppInfoDao appInfoDao) {
        this.b.insert(this.f6353a.getTableName(), null, c(appInfoDao));
        return true;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public boolean updateInfo(final AppInfoDao appInfoDao) {
        if (this.b != null) {
            if (this.c.canCache()) {
                this.c.setAppInfo(appInfoDao);
                GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appcenter.storage.GriverAppSQLiteStorage.3
                    @Override // java.lang.Runnable
                    public void run() {
                        GriverAppSQLiteStorage.this.b(appInfoDao);
                    }
                });
                return true;
            }
            return b(appInfoDao);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(AppInfoDao appInfoDao) {
        StringBuilder sb = new StringBuilder();
        sb.append("update app info appId ");
        sb.append(appInfoDao.getAppId());
        sb.append(" version: ");
        sb.append(appInfoDao.getVersion());
        GriverLogger.d(THREAD_NAME, sb.toString());
        this.b.update(this.f6353a.getTableName(), c(appInfoDao), "appId=? and version=?", new String[]{appInfoDao.getAppId(), appInfoDao.getVersion()});
        return true;
    }

    private ContentValues c(AppInfoDao appInfoDao) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", appInfoDao.getAppId());
        contentValues.put("version", appInfoDao.getVersion());
        contentValues.put("appInfo", JSON.toJSONString(appInfoDao.getAppInfo()));
        contentValues.put("lastRefreshTimestamp", Long.valueOf(appInfoDao.getLastRefreshTimestamp()));
        contentValues.put(AppInfoDao.COLUMN_LAST_OPEN_TIMESTAMP, Long.valueOf(appInfoDao.getLastOpenTimestamp()));
        return contentValues;
    }

    private AppInfoDao a(Cursor cursor) {
        AppInfoDao appInfoDao = new AppInfoDao();
        appInfoDao.setAppId(cursor.getString(cursor.getColumnIndex("appId")));
        appInfoDao.setVersion(cursor.getString(cursor.getColumnIndex("version")));
        appInfoDao.setLastRefreshTimestamp(cursor.getLong(cursor.getColumnIndex("lastRefreshTimestamp")));
        appInfoDao.setLastOpenTimestamp(cursor.getLong(cursor.getColumnIndex(AppInfoDao.COLUMN_LAST_OPEN_TIMESTAMP)));
        try {
            appInfoDao.setAppInfo((AppModel) JSON.parseObject(cursor.getString(cursor.getColumnIndex("appInfo")), AppModel.class));
        } catch (Exception e) {
            GriverLogger.w(THREAD_NAME, "parse appinfo failed", e);
        }
        return appInfoDao;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public boolean insertOrUpdateInfo(List<AppInfoDao> list) {
        if (this.b != null) {
            Iterator<AppInfoDao> it = list.iterator();
            while (it.hasNext()) {
                insertOrUpdateInfo(it.next());
            }
            return true;
        }
        return false;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public boolean deleteAppInfo(final AppInfoDao appInfoDao) {
        if (this.b != null) {
            if (this.c.canCache()) {
                this.c.removeAppInfo(appInfoDao);
                GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appcenter.storage.GriverAppSQLiteStorage.4
                    @Override // java.lang.Runnable
                    public void run() {
                        GriverAppSQLiteStorage.this.d(appInfoDao);
                    }
                });
                return true;
            }
            return d(appInfoDao);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(AppInfoDao appInfoDao) {
        this.b.delete(this.f6353a.getTableName(), "appId=? and version=?", new String[]{appInfoDao.getAppId(), appInfoDao.getVersion()});
        return true;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public boolean deleteAppInfoById(final String str) {
        if (this.b != null) {
            if (this.c.canCache()) {
                this.c.removeAppInfo(str, "");
                GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME).execute(new Runnable() { // from class: com.alibaba.griver.base.resource.appcenter.storage.GriverAppSQLiteStorage.5
                    @Override // java.lang.Runnable
                    public void run() {
                        GriverAppSQLiteStorage.this.a(str);
                    }
                });
                return true;
            }
            return a(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        this.b.delete(this.f6353a.getTableName(), "appId=?", new String[]{str});
        return true;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public AppInfoDao selectAppInfo(String str, String str2) {
        if (this.b != null) {
            AppInfoDao appInfo = this.c.getAppInfo(str, str2);
            if (appInfo != null) {
                return appInfo;
            }
            Cursor query = this.b.query(this.f6353a.getTableName(), null, "appId=? and version=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                r1 = query.moveToNext() ? a(query) : null;
                query.close();
                this.c.setAppInfo(r1);
            }
        }
        return r1;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public AppInfoDao selectAppInfoWithHighestVersion(String str) {
        AppInfoDao appInfo = this.c.getAppInfo(str);
        if (appInfo != null) {
            return appInfo;
        }
        List<AppInfoDao> selectAllAppInfo = selectAllAppInfo(str);
        if (selectAllAppInfo == null || selectAllAppInfo.size() <= 0) {
            return null;
        }
        AppInfoDao appInfoDao = selectAllAppInfo.get(0);
        this.c.setAppInfo(appInfoDao);
        return appInfoDao;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public List<AppInfoDao> selectAllAppInfo(String str) {
        Cursor query;
        List<AppInfoDao> appInfoList = this.c.getAppInfoList(str);
        if (appInfoList != null) {
            return appInfoList;
        }
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase != null && (query = sQLiteDatabase.query(this.f6353a.getTableName(), null, "appId=?", new String[]{str}, null, null, null)) != null) {
            while (query.moveToNext()) {
                arrayList.add(a(query));
            }
            query.close();
            if (arrayList.size() > 0) {
                Collections.sort(arrayList, AppInfoUtils.getAppInfoDaoDescComparator());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.c.setAppInfo((AppInfoDao) it.next());
            }
        }
        return arrayList;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public List<AppInfoDao> selectAllAppInfos() {
        ArrayList arrayList = new ArrayList();
        if (this.b != null) {
            GriverLogger.d(THREAD_NAME, "select all appInfos");
            Cursor query = this.b.query(this.f6353a.getTableName(), null, null, null, null, null, null);
            while (query.moveToNext()) {
                AppInfoDao a2 = a(query);
                arrayList.add(a2);
                this.c.setAppInfo(a2);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // com.alibaba.griver.api.resource.appcenter.storage.GriverAppStorageProxy
    public List<String> queryLastOpenAppIds(long j, int i) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase != null) {
            Cursor query = sQLiteDatabase.query(this.f6353a.getTableName(), null, "lastOpenTimestamp>?", new String[]{String.valueOf(j)}, null, null, "lastOpenTimestamp DESC");
            while (query.moveToNext()) {
                AppInfoDao a2 = a(query);
                this.c.setAppInfo(a2);
                if (arrayList.size() == i) {
                    break;
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).equals(a2.getAppId())) {
                            break;
                        }
                    } else {
                        arrayList.add(a2.getAppId());
                        break;
                    }
                }
            }
            query.close();
        }
        return arrayList;
    }

    public Map getEventContent() {
        return this.c.getEventContent();
    }
}
