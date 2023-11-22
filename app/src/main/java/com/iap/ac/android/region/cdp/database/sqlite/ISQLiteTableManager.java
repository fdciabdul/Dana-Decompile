package com.iap.ac.android.region.cdp.database.sqlite;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public interface ISQLiteTableManager<T, ID> {

    /* loaded from: classes3.dex */
    public enum Relation {
        EQ("="),
        NE(SimpleComparison.NOT_EQUAL_TO_OPERATION),
        GE(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION),
        GT(SimpleComparison.GREATER_THAN_OPERATION),
        LE(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION),
        LT(SimpleComparison.LESS_THAN_OPERATION),
        IN("IN"),
        BETWEEN("BETWEEN"),
        LIKE(SimpleComparison.LIKE_OPERATION);

        public String mSqlOperator;

        Relation(String str) {
            this.mSqlOperator = str;
        }

        public final String getSqlOperator() {
            return this.mSqlOperator;
        }
    }

    int clear();

    void clearAndInsertOrReplace(Collection<T> collection) throws SQLException;

    void clearAndInsertOrReplace(Collection<T> collection, boolean z) throws SQLException;

    void delete(Relation relation, String str, Object obj);

    void delete(T t) throws SQLException;

    void deleteById(ID id2) throws SQLException;

    T deleteFirst(Relation relation, String str, Object obj) throws SQLException;

    T deleteFirst(Relation relation, String str, Object obj, String str2, boolean z) throws SQLException;

    boolean exists(ID id2) throws SQLException;

    List<T> get() throws SQLException;

    List<T> get(Relation relation, String str, Object obj) throws SQLException;

    List<T> get(Relation relation, String str, Object obj, Long l, Long l2) throws SQLException;

    List<T> get(Relation relation, String str, Object obj, String str2, boolean z) throws SQLException;

    List<T> get(Relation relation, String str, Object obj, String str2, boolean z, Long l, Long l2) throws SQLException;

    List<T> get(String str, boolean z) throws SQLException;

    List<T> get(String str, String[] strArr, String str2, String str3) throws SQLException;

    List<T> get(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) throws SQLException;

    T getById(ID id2) throws SQLException;

    String getDatabaseName();

    T getFirst(Relation relation, String str, Object obj) throws SQLException;

    T getFirst(Relation relation, String str, Object obj, String str2, boolean z) throws SQLException;

    ID getId(T t) throws SQLException;

    IParsedTableInfo<T> getParsedTableInfo();

    long insertOrReplace(T t) throws SQLException;

    long insertOrReplace(T t, boolean z) throws SQLException;

    void insertOrReplace(Collection<T> collection) throws SQLException;

    void insertOrReplace(Collection<T> collection, boolean z) throws SQLException;

    void setDatabase(String str);
}
