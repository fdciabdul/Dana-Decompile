package com.iap.ac.android.region.cdp.database.sqlite;

import android.util.LruCache;
import com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class CachedSQLiteTableManager<T, ID> implements ISQLiteTableManager<T, ID> {
    public final LruCache<ID, T> mLruCache;
    public final ISQLiteTableManager<T, ID> mManager;

    public CachedSQLiteTableManager(ISQLiteTableManager<T, ID> iSQLiteTableManager) {
        this(iSQLiteTableManager, 16);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public int clear() {
        int clear;
        synchronized (this) {
            clearCache();
            clear = this.mManager.clear();
        }
        return clear;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void clearAndInsertOrReplace(Collection<T> collection) throws SQLException {
        synchronized (this) {
            this.mManager.clearAndInsertOrReplace(collection);
            clearCache();
            if (isKeepId()) {
                updateCache((Collection) collection);
            }
        }
    }

    public void clearCache() {
        synchronized (this) {
            this.mLruCache.evictAll();
        }
    }

    public void clearCacheIfUniqueOrUniqueComboExists() {
        IParsedTableInfo<T> parsedTableInfo = getParsedTableInfo();
        if (parsedTableInfo.uniqueComboExists() || parsedTableInfo.uniqueComboExists()) {
            clearCache();
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void delete(T t) throws SQLException {
        synchronized (this) {
            removeCache(getId(t));
            this.mManager.delete(t);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void deleteById(ID id2) throws SQLException {
        synchronized (this) {
            removeCache(id2);
            this.mManager.deleteById(id2);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T deleteFirst(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        T deleteFirst;
        synchronized (this) {
            deleteFirst = this.mManager.deleteFirst(relation, str, obj);
            removeCache(getId(deleteFirst));
        }
        return deleteFirst;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public boolean exists(ID id2) throws SQLException {
        return this.mLruCache.get(id2) != null || this.mManager.exists(id2);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get() throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get());
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getById(ID id2) throws SQLException {
        T readCache;
        synchronized (this) {
            readCache = readCache(id2);
            if (readCache == null) {
                readCache = updateCache(this.mManager.getById(id2), id2);
            }
        }
        return readCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public String getDatabaseName() {
        String databaseName;
        synchronized (this) {
            databaseName = this.mManager.getDatabaseName();
        }
        return databaseName;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getFirst(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        T updateCache;
        synchronized (this) {
            updateCache = updateCache((CachedSQLiteTableManager<T, ID>) this.mManager.getFirst(relation, str, obj));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public ID getId(T t) throws SQLException {
        return this.mManager.getId(t);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public IParsedTableInfo<T> getParsedTableInfo() {
        return this.mManager.getParsedTableInfo();
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public long insertOrReplace(T t) throws SQLException {
        long insertOrReplace;
        synchronized (this) {
            insertOrReplace = this.mManager.insertOrReplace((ISQLiteTableManager<T, ID>) t);
            clearCacheIfUniqueOrUniqueComboExists();
            if (insertOrReplace != -1 && isKeepId()) {
                updateCache((CachedSQLiteTableManager<T, ID>) t);
            }
        }
        return insertOrReplace;
    }

    public boolean isKeepId() {
        return isKeepId(true);
    }

    public T readCache(ID id2) {
        T t;
        synchronized (this) {
            t = id2 != null ? this.mLruCache.get(id2) : null;
        }
        return t;
    }

    public void removeCache(ID id2) {
        synchronized (this) {
            if (id2 == null) {
                return;
            }
            this.mLruCache.remove(id2);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void setDatabase(String str) {
        synchronized (this) {
            this.mLruCache.evictAll();
            this.mManager.setDatabase(str);
        }
    }

    public List<T> updateCache(List<T> list) throws SQLException {
        List<T> list2;
        synchronized (this) {
            list2 = (List) updateCache((Collection) list);
        }
        return list2;
    }

    public CachedSQLiteTableManager(ISQLiteTableManager<T, ID> iSQLiteTableManager, int i) {
        if (iSQLiteTableManager != null) {
            if (iSQLiteTableManager.getParsedTableInfo().idExists()) {
                this.mManager = iSQLiteTableManager;
                this.mLruCache = new LruCache<>(i);
                return;
            }
            throw new IllegalArgumentException("only table with an id field can be cached");
        }
        throw new NullPointerException("manager must not be null");
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String str, boolean z) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(str, z));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getFirst(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        T updateCache;
        synchronized (this) {
            updateCache = updateCache((CachedSQLiteTableManager<T, ID>) this.mManager.getFirst(relation, str, obj, str2, z));
        }
        return updateCache;
    }

    public boolean isKeepId(boolean z) {
        return (z && getParsedTableInfo().isGeneratedId()) ? false : true;
    }

    public Collection<T> updateCache(Collection<T> collection) throws SQLException {
        synchronized (this) {
            if (collection != null) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    updateCache((CachedSQLiteTableManager<T, ID>) it.next());
                }
            }
        }
        return collection;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void delete(ISQLiteTableManager.Relation relation, String str, Object obj) {
        synchronized (this) {
            try {
                Iterator<T> it = this.mManager.get(relation, str, obj).iterator();
                while (it.hasNext()) {
                    removeCache(getId(it.next()));
                }
            } catch (SQLException unused) {
                clearCache();
            }
            this.mManager.delete(relation, str, obj);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T deleteFirst(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        T deleteFirst = this.mManager.deleteFirst(relation, str, obj, str2, z);
        removeCache(getId(deleteFirst));
        return deleteFirst;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(relation, str, obj));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, Long l, Long l2) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(relation, str, obj, l, l2));
        }
        return updateCache;
    }

    public T updateCache(T t) throws SQLException {
        T updateCache;
        synchronized (this) {
            updateCache = updateCache(t, null);
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void clearAndInsertOrReplace(Collection<T> collection, boolean z) throws SQLException {
        synchronized (this) {
            this.mManager.clearAndInsertOrReplace(collection, z);
            clearCache();
            if (isKeepId(z)) {
                updateCache((Collection) collection);
            }
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(relation, str, obj, str2, z));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public long insertOrReplace(T t, boolean z) throws SQLException {
        long insertOrReplace;
        synchronized (this) {
            insertOrReplace = this.mManager.insertOrReplace((ISQLiteTableManager<T, ID>) t);
            clearCacheIfUniqueOrUniqueComboExists();
            if (insertOrReplace != -1 && isKeepId(z)) {
                updateCache((CachedSQLiteTableManager<T, ID>) t);
            }
        }
        return insertOrReplace;
    }

    public T updateCache(T t, ID id2) throws SQLException {
        synchronized (this) {
            if (t != null) {
                LruCache<ID, T> lruCache = this.mLruCache;
                if (id2 == null) {
                    id2 = getId(t);
                }
                lruCache.put(id2, t);
            }
        }
        return t;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z, Long l, Long l2) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(relation, str, obj, str2, z, l, l2));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String str, String[] strArr, String str2, String str3) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(str, strArr, str2, str3));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) throws SQLException {
        List<T> updateCache;
        synchronized (this) {
            updateCache = updateCache((List) this.mManager.get(strArr, str, strArr2, str2, str3, str4, str5));
        }
        return updateCache;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void insertOrReplace(Collection<T> collection) throws SQLException {
        synchronized (this) {
            this.mManager.insertOrReplace((Collection) collection);
            clearCacheIfUniqueOrUniqueComboExists();
            if (isKeepId()) {
                updateCache((Collection) collection);
            }
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void insertOrReplace(Collection<T> collection, boolean z) throws SQLException {
        synchronized (this) {
            this.mManager.insertOrReplace((Collection) collection, z);
            clearCacheIfUniqueOrUniqueComboExists();
            if (isKeepId(z)) {
                updateCache((Collection) collection);
            }
        }
    }
}
