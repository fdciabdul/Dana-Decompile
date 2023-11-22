package com.j256.ormlite.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
public interface GenericRawResults<T> extends CloseableWrappedIterable<T> {
    @Override // com.j256.ormlite.dao.CloseableWrappedIterable, java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    String[] getColumnNames();

    T getFirstResult() throws SQLException;

    int getNumberColumns();

    List<T> getResults() throws SQLException;
}
