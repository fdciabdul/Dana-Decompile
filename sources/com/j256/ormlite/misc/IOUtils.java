package com.j256.ormlite.misc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeThrowSqlException(Closeable closeable, String str) throws SQLException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("could not close ");
                sb.append(str);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        }
    }
}
