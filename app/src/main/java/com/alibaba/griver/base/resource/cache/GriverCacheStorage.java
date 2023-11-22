package com.alibaba.griver.base.resource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAbstractDBHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GriverCacheStorage {
    public static volatile GriverCacheStorage instance;

    /* renamed from: a  reason: collision with root package name */
    private GriverAbstractDBHelper f6358a;
    private SQLiteDatabase b;

    private GriverCacheStorage() {
    }

    public static GriverCacheStorage getInstance() {
        if (instance == null) {
            synchronized (GriverCacheStorage.class) {
                if (instance == null) {
                    instance = new GriverCacheStorage();
                    instance.f6358a = new GriverCacheDBHelper(GriverEnv.getApplicationContext());
                    GriverCacheStorage griverCacheStorage = instance;
                    griverCacheStorage.b = griverCacheStorage.f6358a.getWritableDatabase();
                }
            }
        }
        try {
            if (!instance.b.isOpen()) {
                GriverCacheStorage griverCacheStorage2 = instance;
                griverCacheStorage2.b = griverCacheStorage2.f6358a.getWritableDatabase();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("griver cache try getWritableDatabase() failed , error message is ");
            sb.append(e.getMessage());
            GriverLogger.d("GriverCacheStorage", sb.toString());
        }
        return instance;
    }

    public static boolean insertOrUpdateCache(String str, String str2, String str3, String str4, Long l, String str5) {
        if (getInstance().b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            GriverCacheDao cacheDaoByKey = getCacheDaoByKey(str, str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put(GriverCacheDao.COLUMN_CACHE_NAME, str);
            contentValues.put("cacheKey", str2);
            contentValues.put(GriverCacheDao.COLUMN_CACHE_VALUE, str4);
            long j = 0;
            long longValue = l.longValue() > 0 ? l.longValue() + currentTimeMillis : -1L;
            if (CacheTypeDef.CACHE_TYPE_FILE.equals(str3)) {
                File file = new File(str4);
                if (file.exists() && file.isFile()) {
                    j = file.length();
                }
            } else if (CacheTypeDef.CACHE_TYPE_STRING.equals(str3)) {
                j = str4.length();
            }
            contentValues.put(GriverCacheDao.COLUMN_CACHE_TYPE, str3);
            contentValues.put(GriverCacheDao.COLUMN_CACHE_SIZE, Long.valueOf(j));
            contentValues.put(GriverCacheDao.COLUMN_CACHE_EXPIRED_TIMESTAMP, Long.valueOf(longValue));
            contentValues.put(GriverCacheDao.COLUMN_CACHE_EXTRA, str5);
            if (cacheDaoByKey == null) {
                contentValues.put(GriverCacheDao.COLUMN_CACHE_CREATE_TIMESTAMP, Long.valueOf(currentTimeMillis));
                StringBuilder sb = new StringBuilder();
                sb.append("insert cache cacheName: ");
                sb.append(str);
                sb.append(" cacheKey: ");
                sb.append(str2);
                GriverLogger.d("GriverCacheStorage", sb.toString());
                getInstance().b.insert(getInstance().f6358a.getTableName(), null, contentValues);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("update cache cacheName: ");
                sb2.append(str);
                sb2.append(" cacheKey: ");
                sb2.append(str2);
                GriverLogger.d("GriverCacheStorage", sb2.toString());
                getInstance().b.update(getInstance().f6358a.getTableName(), contentValues, "cacheName=? and cacheKey=?", new String[]{str, str2});
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("insert or update cache cacheName ");
            sb3.append(str);
            sb3.append(" cacheKey: ");
            sb3.append(str2);
            sb3.append(" success cost: ");
            sb3.append(System.currentTimeMillis() - currentTimeMillis);
            GriverLogger.d("GriverCacheStorage", sb3.toString());
            return true;
        }
        GriverLogger.w("GriverCacheStorage", "sqlite database is not ready, do nothing");
        return false;
    }

    public static GriverCacheDao getCacheDaoByKey(String str, String str2) {
        GriverCacheDao griverCacheDao = null;
        if (getInstance().b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = getInstance().b.query(getInstance().f6358a.getTableName(), null, "cacheName=? and cacheKey=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                if (query.moveToNext()) {
                    griverCacheDao = new GriverCacheDao();
                    griverCacheDao.setId(Integer.valueOf(query.getInt(query.getColumnIndex("id"))));
                    griverCacheDao.setCacheName(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_NAME)));
                    griverCacheDao.setCacheKey(query.getString(query.getColumnIndex("cacheKey")));
                    griverCacheDao.setCacheValue(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_VALUE)));
                    griverCacheDao.setCacheType(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_TYPE)));
                    griverCacheDao.setCacheSize(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_SIZE))));
                    griverCacheDao.setExpiredTimeStamp(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_EXPIRED_TIMESTAMP))));
                    griverCacheDao.setCreateTimeStamp(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_CREATE_TIMESTAMP))));
                    griverCacheDao.setExtra(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_EXTRA)));
                }
                query.close();
                StringBuilder sb = new StringBuilder();
                sb.append("query cache cacheName: ");
                sb.append(str);
                sb.append(" cacheKey: ");
                sb.append(str2);
                sb.append(" success cost: ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                GriverLogger.d("GriverCacheStorage", sb.toString());
            }
        }
        return griverCacheDao;
    }

    public static String getStringValueByKey(String str, String str2) {
        if (getInstance().b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = getInstance().b.query(getInstance().f6358a.getTableName(), null, "cacheName=? and cacheKey=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                r1 = query.moveToNext() ? query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_VALUE)) : null;
                query.close();
                StringBuilder sb = new StringBuilder();
                sb.append("query cache value cacheName: ");
                sb.append(str);
                sb.append(" cacheKey: ");
                sb.append(str2);
                sb.append(" success cost: ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                GriverLogger.d("GriverCacheStorage", sb.toString());
            }
        }
        return r1;
    }

    public static boolean removeByKey(String str, String str2) {
        if (getInstance().b != null) {
            getInstance().b.delete(getInstance().f6358a.getTableName(), "cacheName=? and cacheKey=?", new String[]{str, str2});
        }
        return false;
    }

    public static boolean removeAll(String str) {
        try {
            if (getInstance().b != null) {
                getInstance().b.delete(getInstance().f6358a.getTableName(), "cacheName=?", new String[]{str});
            }
            return true;
        } catch (Throwable th) {
            GriverLogger.d("GriverCacheStorage", String.format("GriverCacheStorage#removeAll, cacheName: %s, exception: %s", str, th));
            return false;
        }
    }

    public static boolean removeAll() {
        try {
            if (getInstance().b != null) {
                getInstance().b.delete(getInstance().f6358a.getTableName(), null, null);
            }
            return true;
        } catch (Throwable th) {
            GriverLogger.d("GriverCacheStorage", String.format("GriverCacheStorage#removeAll, exception: %s", th));
            return false;
        }
    }

    public static List<GriverCacheDao> getCacheListByName(String str) {
        ArrayList arrayList = null;
        if (getInstance().b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = getInstance().b.query(getInstance().f6358a.getTableName(), null, "cacheName=?", new String[]{str}, null, null, null);
            if (query != null) {
                arrayList = new ArrayList();
                while (query.moveToNext()) {
                    GriverCacheDao griverCacheDao = new GriverCacheDao();
                    griverCacheDao.setId(Integer.valueOf(query.getInt(query.getColumnIndex("id"))));
                    griverCacheDao.setCacheName(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_NAME)));
                    griverCacheDao.setCacheKey(query.getString(query.getColumnIndex("cacheKey")));
                    griverCacheDao.setCacheValue(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_VALUE)));
                    griverCacheDao.setCacheType(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_TYPE)));
                    griverCacheDao.setCacheSize(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_SIZE))));
                    griverCacheDao.setExpiredTimeStamp(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_EXPIRED_TIMESTAMP))));
                    griverCacheDao.setCreateTimeStamp(Long.valueOf(query.getLong(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_CREATE_TIMESTAMP))));
                    griverCacheDao.setExtra(query.getString(query.getColumnIndex(GriverCacheDao.COLUMN_CACHE_EXTRA)));
                    arrayList.add(griverCacheDao);
                }
                query.close();
                StringBuilder sb = new StringBuilder();
                sb.append("query cache list cacheName: ");
                sb.append(str);
                sb.append(" success cost: ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                GriverLogger.d("GriverCacheStorage", sb.toString());
            }
        }
        return arrayList;
    }

    public static void removeExpiredCache(String str) {
        if (getInstance().b != null) {
            getInstance().b.delete(getInstance().f6358a.getTableName(), "cacheName=? and expiredTimeStamp >= 0 and (expiredTimeStamp<?)", new String[]{str, String.valueOf(System.currentTimeMillis())});
        }
    }

    public static long getCacheCount(String str) {
        if (getInstance().b != null) {
            SQLiteDatabase sQLiteDatabase = getInstance().b;
            StringBuilder sb = new StringBuilder();
            sb.append("select count(1) from ");
            sb.append(getInstance().f6358a.getTableName());
            sb.append(" where cacheName = ?");
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), new String[]{str});
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                return 0L;
            }
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        }
        return 0L;
    }

    public static void removeOldestCache(String str) {
        if (getInstance().b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ( select id from ");
            sb.append(getInstance().f6358a.getTableName());
            sb.append(" where cacheName = '");
            sb.append(str);
            sb.append("' order by id asc limit 1)");
            String obj = sb.toString();
            SQLiteDatabase sQLiteDatabase = getInstance().b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete from ");
            sb2.append(getInstance().f6358a.getTableName());
            sb2.append(" where id in ");
            sb2.append(obj);
            sQLiteDatabase.execSQL(sb2.toString());
        }
    }
}
