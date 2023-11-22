package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CursorAdapter;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public abstract class OrmLiteCursorAdapter<T, ViewType extends View> extends CursorAdapter {
    protected PreparedQuery<T> preparedQuery;

    public abstract void bindView(ViewType viewtype, Context context, T t);

    public OrmLiteCursorAdapter(Context context) {
        super(context, (Cursor) null, false);
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        doBindView(view, context, cursor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doBindView(View view, Context context, Cursor cursor) {
        try {
            bindView((OrmLiteCursorAdapter<T, ViewType>) view, context, (Context) cursorToObject(cursor));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T getTypedItem(int i) {
        try {
            return cursorToObject((Cursor) super.getItem(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected T cursorToObject(Cursor cursor) throws SQLException {
        return this.preparedQuery.mapRow(new AndroidDatabaseResults(cursor, null, true));
    }

    @Override // android.widget.CursorAdapter
    public final void changeCursor(Cursor cursor) {
        throw new UnsupportedOperationException("Please use OrmLiteCursorAdapter.changeCursor(Cursor,PreparedQuery) instead");
    }

    public void changeCursor(Cursor cursor, PreparedQuery<T> preparedQuery) {
        setPreparedQuery(preparedQuery);
        super.changeCursor(cursor);
    }

    public void setPreparedQuery(PreparedQuery<T> preparedQuery) {
        this.preparedQuery = preparedQuery;
    }
}
