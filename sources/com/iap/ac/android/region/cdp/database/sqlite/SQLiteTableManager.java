package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class SQLiteTableManager<T, ID> implements ISQLiteTableManager<T, ID> {
    public final Context mContext;
    public String mDatabaseName;
    public final ParsedTableInfo<T> mParsedTableInfo;

    /* renamed from: com.iap.ac.android.region.cdp.database.sqlite.SQLiteTableManager$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$region$cdp$database$sqlite$ISQLiteTableManager$Relation;

        static {
            int[] iArr = new int[ISQLiteTableManager.Relation.values().length];
            $SwitchMap$com$iap$ac$android$region$cdp$database$sqlite$ISQLiteTableManager$Relation = iArr;
            try {
                iArr[ISQLiteTableManager.Relation.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iap$ac$android$region$cdp$database$sqlite$ISQLiteTableManager$Relation[ISQLiteTableManager.Relation.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SQLiteTableManager(Class<T> cls, Context context) {
        this.mParsedTableInfo = ParsedTableInfo.create(cls);
        this.mContext = context.getApplicationContext();
    }

    public Pair<String, String[]> buildSelectionAndSelectionArgs(ISQLiteTableManager.Relation relation, String str, Object obj) {
        String obj2;
        if (relation == null || str == null || str.isEmpty()) {
            return new Pair<>(null, null);
        }
        if (obj == null) {
            int ordinal = relation.ordinal();
            if (ordinal == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" is null");
                obj2 = sb.toString();
            } else if (ordinal != 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" ");
                sb2.append(relation.getSqlOperator());
                sb2.append(" null");
                obj2 = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" is not null");
                obj2 = sb3.toString();
            }
            return new Pair<>(obj2, null);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(" ");
        sb4.append(relation.getSqlOperator());
        sb4.append(" ?");
        String obj3 = sb4.toString();
        if (relation == ISQLiteTableManager.Relation.IN || relation == ISQLiteTableManager.Relation.BETWEEN) {
            if (relation == ISQLiteTableManager.Relation.IN) {
                return buildSelectionAndSelectionArgsForIn(str, obj);
            }
            return buildSelectionAndSelectionArgsForBetween(str, obj);
        }
        return new Pair<>(obj3, new String[]{String.valueOf(obj)});
    }

    public Pair<String, String[]> buildSelectionAndSelectionArgsForBetween(String str, Object obj) {
        Object obj2;
        Object obj3;
        boolean z = obj instanceof List;
        if ((z && ((List) obj).size() >= 2) || (obj != null && obj.getClass().isArray() && Array.getLength(obj) >= 2)) {
            if (z) {
                List list = (List) obj;
                obj2 = list.get(0);
                obj3 = list.get(1);
            } else {
                obj2 = Array.get(obj, 0);
                obj3 = Array.get(obj, 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(ISQLiteTableManager.Relation.BETWEEN.getSqlOperator());
            sb.append(" ");
            sb.append(obj2);
            sb.append(" and ");
            sb.append(obj3);
            return new Pair<>(sb.toString(), null);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Value should be a List or an array with at least 2 elements if relation is between: ");
        sb2.append(obj);
        throw new IllegalArgumentException(sb2.toString());
    }

    public Pair<String, String[]> buildSelectionAndSelectionArgsForIn(String str, Object obj) {
        boolean z = obj instanceof Iterable;
        if (!z && (obj == null || !obj.getClass().isArray())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Value should be an Iterable or an array if relation is in: ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" ");
        sb2.append(ISQLiteTableManager.Relation.IN.getSqlOperator());
        sb2.append(" (");
        StringBuilder sb3 = new StringBuilder(sb2.toString());
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (T t : (Iterable) obj) {
                sb3.append("?,");
                arrayList.add(String.valueOf(t));
            }
        } else {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                sb3.append("?,");
                arrayList.add(String.valueOf(Array.get(obj, i)));
            }
        }
        if (!arrayList.isEmpty()) {
            sb3.delete(sb3.length() - 1, sb3.length());
        }
        sb3.append(")");
        return new Pair<>(sb3.toString(), arrayList.toArray(new String[arrayList.size()]));
    }

    public void checkDatabaseSet(SQLiteOpenHelper sQLiteOpenHelper) {
        if (sQLiteOpenHelper == null) {
            throw new IllegalStateException("SQLiteOpenHelper not set");
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public int clear() {
        return getWritableDatabase().delete(getTableName(), null, null);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void clearAndInsertOrReplace(Collection<T> collection) throws SQLException {
        clearAndInsertOrReplace(collection, true);
    }

    public ContentValues createContentValues(T t, boolean z) throws SQLException {
        return this.mParsedTableInfo.createContentValues(t, z);
    }

    public T createObject(Cursor cursor) throws SQLException {
        return this.mParsedTableInfo.createObject(cursor);
    }

    public List<T> createObjects(Cursor cursor) throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(createObject(cursor));
        }
        return arrayList;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void delete(T t) throws SQLException {
        if (t == null) {
            return;
        }
        deleteById(getId(t));
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void deleteById(ID id2) throws SQLException {
        if (id2 == null) {
            return;
        }
        delete(ISQLiteTableManager.Relation.EQ, getIdColumnName(), id2);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T deleteFirst(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        T first;
        synchronized (this) {
            first = getFirst(relation, str, obj);
            delete(first);
        }
        return first;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public boolean exists(ID id2) throws SQLException {
        return getById(id2) != null;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get() throws SQLException {
        return get(null, true);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getById(ID id2) throws SQLException {
        return getFirst(ISQLiteTableManager.Relation.EQ, getIdColumnName(), id2);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public String getDatabaseName() {
        String str;
        synchronized (this) {
            str = this.mDatabaseName;
        }
        return str;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getFirst(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        return getFirst(relation, str, obj, null, true);
    }

    public SQLiteOpenHelper getHelper() {
        SQLiteOpenHelper sQLiteOpenHelper = SQLiteOpenHelperManager.getInstance().get(getDatabaseName(), this.mContext);
        checkDatabaseSet(sQLiteOpenHelper);
        return sQLiteOpenHelper;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public ID getId(T t) throws SQLException {
        if (t == null) {
            return null;
        }
        return (ID) this.mParsedTableInfo.getId(t);
    }

    public String getIdColumnName() throws SQLException {
        return this.mParsedTableInfo.getIdColumnName();
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public IParsedTableInfo<T> getParsedTableInfo() {
        return this.mParsedTableInfo;
    }

    public SQLiteDatabase getReadableDatabase() {
        return getHelper().getReadableDatabase();
    }

    public String getTableName() {
        return this.mParsedTableInfo.getTableName();
    }

    public SQLiteDatabase getWritableDatabase() {
        return getHelper().getWritableDatabase();
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public long insertOrReplace(T t) throws SQLException {
        return insertOrReplace((SQLiteTableManager<T, ID>) t, true);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return getReadableDatabase().query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void setDatabase(String str) {
        synchronized (this) {
            this.mDatabaseName = str;
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void clearAndInsertOrReplace(Collection<T> collection, final boolean z) throws SQLException {
        final ArrayList arrayList;
        synchronized (this) {
            if (collection != null) {
                try {
                    if (!collection.isEmpty()) {
                        arrayList = new ArrayList(collection);
                        final SQLiteDatabase writableDatabase = getWritableDatabase();
                        TransactionHelper.callInTransaction(writableDatabase, new Callable<Void>() { // from class: com.iap.ac.android.region.cdp.database.sqlite.SQLiteTableManager.2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.concurrent.Callable
                            public Void call() throws Exception {
                                SQLiteTableManager.this.clear();
                                List list = arrayList;
                                if (list != null) {
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        if (writableDatabase.insertWithOnConflict(SQLiteTableManager.this.getTableName(), null, SQLiteTableManager.this.createContentValues(it.next(), z), 5) < 0) {
                                            throw new SQLException("An error occurred when inserting");
                                        }
                                    }
                                }
                                return null;
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            arrayList = null;
            final SQLiteDatabase writableDatabase2 = getWritableDatabase();
            TransactionHelper.callInTransaction(writableDatabase2, new Callable<Void>() { // from class: com.iap.ac.android.region.cdp.database.sqlite.SQLiteTableManager.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    SQLiteTableManager.this.clear();
                    List list = arrayList;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (writableDatabase2.insertWithOnConflict(SQLiteTableManager.this.getTableName(), null, SQLiteTableManager.this.createContentValues(it.next(), z), 5) < 0) {
                                throw new SQLException("An error occurred when inserting");
                            }
                        }
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String str, boolean z) throws SQLException {
        return get((ISQLiteTableManager.Relation) null, (String) null, (Object) null, str, z);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T getFirst(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        List<T> list = get(relation, str, obj, str2, z, (Long) 1L, (Long) 0L);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public long insertOrReplace(T t, boolean z) throws SQLException {
        if (t == null) {
            return -1L;
        }
        return getWritableDatabase().insertWithOnConflict(getTableName(), null, createContentValues(t, z), 5);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void delete(ISQLiteTableManager.Relation relation, String str, Object obj) {
        Pair<String, String[]> buildSelectionAndSelectionArgs = buildSelectionAndSelectionArgs(relation, str, obj);
        getWritableDatabase().delete(getTableName(), (String) buildSelectionAndSelectionArgs.first, (String[]) buildSelectionAndSelectionArgs.second);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public T deleteFirst(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        T first;
        synchronized (this) {
            first = getFirst(relation, str, obj, str2, z);
            delete(first);
        }
        return first;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj) throws SQLException {
        return get(relation, str, obj, (String) null, true);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, Long l, Long l2) throws SQLException {
        return get(relation, str, obj, (String) null, true, l, l2);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z) throws SQLException {
        return get(relation, str, obj, str2, z, (Long) null, (Long) null);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void insertOrReplace(Collection<T> collection) throws SQLException {
        insertOrReplace((Collection) collection, true);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(ISQLiteTableManager.Relation relation, String str, Object obj, String str2, boolean z, Long l, Long l2) throws SQLException {
        String str3;
        String str4 = null;
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" ");
            sb.append(z ? "ASC" : " DESC");
            str3 = sb.toString();
        } else {
            str3 = null;
        }
        if (l2 != null || l != null) {
            StringBuilder sb2 = new StringBuilder();
            Object obj2 = l2;
            if (l2 == null) {
                obj2 = "0";
            }
            sb2.append(obj2);
            sb2.append(", ");
            Object obj3 = l;
            if (l == null) {
                obj3 = "-1";
            }
            sb2.append(obj3);
            str4 = sb2.toString();
        }
        Pair<String, String[]> buildSelectionAndSelectionArgs = buildSelectionAndSelectionArgs(relation, str, obj);
        return get((String) buildSelectionAndSelectionArgs.first, (String[]) buildSelectionAndSelectionArgs.second, str3, str4);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public void insertOrReplace(Collection<T> collection, final boolean z) throws SQLException {
        synchronized (this) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    final ArrayList arrayList = new ArrayList(collection);
                    final SQLiteDatabase writableDatabase = getWritableDatabase();
                    TransactionHelper.callInTransaction(writableDatabase, new Callable<Void>() { // from class: com.iap.ac.android.region.cdp.database.sqlite.SQLiteTableManager.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (writableDatabase.insertWithOnConflict(SQLiteTableManager.this.getTableName(), null, SQLiteTableManager.this.createContentValues(it.next(), z), 5) < 0) {
                                    throw new SQLException("An error occurred when inserting");
                                }
                            }
                            return null;
                        }
                    });
                }
            }
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String str, String[] strArr, String str2, String str3) throws SQLException {
        return get((String[]) null, str, strArr, (String) null, (String) null, str2, str3);
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.ISQLiteTableManager
    public List<T> get(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) throws SQLException {
        Cursor cursor;
        try {
            cursor = query(strArr, str, strArr2, str2, str3, str4, str5);
            try {
                List<T> createObjects = createObjects(cursor);
                if (cursor != null) {
                    cursor.close();
                }
                return createObjects;
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
