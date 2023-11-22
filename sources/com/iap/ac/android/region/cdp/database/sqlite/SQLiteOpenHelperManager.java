package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SQLiteOpenHelperManager {
    public static SQLiteOpenHelperManager sInstance = new SQLiteOpenHelperManager();
    public Map<String, SQLiteOpenHelperFactory> mFactoryMap = new HashMap();
    public Map<String, Set<String>> mDatabaseNamesMap = new HashMap();
    public Map<String, SQLiteOpenHelper> mHelperMap = new HashMap();

    public static SQLiteOpenHelperManager getInstance() {
        return sInstance;
    }

    public SQLiteOpenHelper get(String str, Context context) {
        synchronized (this) {
            SQLiteOpenHelper sQLiteOpenHelper = this.mHelperMap.get(str);
            if (sQLiteOpenHelper != null) {
                return sQLiteOpenHelper;
            }
            for (Map.Entry<String, SQLiteOpenHelperFactory> entry : this.mFactoryMap.entrySet()) {
                SQLiteOpenHelper create = entry.getValue().create(str, context);
                if (create != null) {
                    this.mHelperMap.put(str, create);
                    String key = entry.getKey();
                    Set<String> set = this.mDatabaseNamesMap.get(key);
                    if (set == null) {
                        set = new HashSet<>();
                    }
                    set.add(str);
                    this.mDatabaseNamesMap.put(key, set);
                    return create;
                }
            }
            return null;
        }
    }

    public SQLiteOpenHelperFactory getSQLiteOpenHelperFactory(String str) {
        SQLiteOpenHelperFactory sQLiteOpenHelperFactory;
        synchronized (this) {
            sQLiteOpenHelperFactory = this.mFactoryMap.get(str);
        }
        return sQLiteOpenHelperFactory;
    }

    public void putSQLiteOpenHelperFactory(String str, SQLiteOpenHelperFactory sQLiteOpenHelperFactory) {
        synchronized (this) {
            if (sQLiteOpenHelperFactory != null) {
                removeSQLiteOpenHelperFactory(str);
                this.mFactoryMap.put(str, sQLiteOpenHelperFactory);
            } else {
                throw new NullPointerException();
            }
        }
    }

    public SQLiteOpenHelperFactory removeSQLiteOpenHelperFactory(String str) {
        SQLiteOpenHelperFactory remove;
        synchronized (this) {
            Set<String> set = this.mDatabaseNamesMap.get(str);
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    this.mHelperMap.remove(it.next());
                }
                this.mDatabaseNamesMap.remove(str);
            }
            remove = this.mFactoryMap.remove(str);
        }
        return remove;
    }
}
