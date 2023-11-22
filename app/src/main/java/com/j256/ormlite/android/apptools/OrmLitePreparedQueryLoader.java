package com.j256.ormlite.android.apptools;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class OrmLitePreparedQueryLoader<T, ID> extends BaseOrmLiteLoader<T, ID> {
    private PreparedQuery<T> preparedQuery;

    public OrmLitePreparedQueryLoader(Context context) {
        super(context);
    }

    public OrmLitePreparedQueryLoader(Context context, Dao<T, ID> dao, PreparedQuery<T> preparedQuery) {
        super(context, dao);
        this.preparedQuery = preparedQuery;
    }

    @Override // android.content.AsyncTaskLoader
    public List<T> loadInBackground() {
        if (this.dao == null) {
            throw new IllegalStateException("Dao is not initialized.");
        }
        if (this.preparedQuery == null) {
            throw new IllegalStateException("PreparedQuery is not initialized.");
        }
        try {
            return this.dao.query(this.preparedQuery);
        } catch (SQLException unused) {
            return Collections.emptyList();
        }
    }

    public void setPreparedQuery(PreparedQuery<T> preparedQuery) {
        this.preparedQuery = preparedQuery;
    }

    public PreparedQuery<T> getPreparedQuery() {
        return this.preparedQuery;
    }
}
