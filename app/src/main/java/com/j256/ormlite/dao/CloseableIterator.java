package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.io.Closeable;
import java.sql.SQLException;
import java.util.Iterator;

/* loaded from: classes8.dex */
public interface CloseableIterator<T> extends Iterator<T>, Closeable {
    void closeQuietly();

    T current() throws SQLException;

    T first() throws SQLException;

    DatabaseResults getRawResults();

    T moveRelative(int i) throws SQLException;

    void moveToNext();

    T nextThrow() throws SQLException;

    T previous() throws SQLException;
}
