package com.j256.ormlite.android.apptools;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.StatementBuilder;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class OrmLiteCursorLoader<T> extends AsyncTaskLoader<Cursor> implements Dao.DaoObserver {
    protected Cursor cursor;
    protected Dao<T, ?> dao;
    protected PreparedQuery<T> query;

    public OrmLiteCursorLoader(Context context, Dao<T, ?> dao, PreparedQuery<T> preparedQuery) {
        super(context);
        this.dao = dao;
        this.query = preparedQuery;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        try {
            Cursor cursor = ((AndroidCompiledStatement) this.query.compile(this.dao.getConnectionSource().getReadOnlyConnection(this.dao.getTableName()), StatementBuilder.StatementType.SELECT)).getCursor();
            cursor.getCount();
            return cursor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.cursor;
        this.cursor = cursor;
        if (isStarted()) {
            super.deliverResult((OrmLiteCursorLoader<T>) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        this.dao.registerObserver(this);
        Cursor cursor = this.cursor;
        if (cursor == null) {
            forceLoad();
            return;
        }
        deliverResult(cursor);
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    @Override // android.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override // android.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // android.content.Loader
    protected void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.cursor;
        if (cursor != null) {
            if (!cursor.isClosed()) {
                this.cursor.close();
            }
            this.cursor = null;
        }
        this.dao.unregisterObserver(this);
    }

    @Override // com.j256.ormlite.dao.Dao.DaoObserver
    public void onChange() {
        onContentChanged();
    }

    public PreparedQuery<T> getQuery() {
        return this.query;
    }

    public void setQuery(PreparedQuery<T> preparedQuery) {
        this.query = preparedQuery;
    }
}
