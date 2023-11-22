package com.j256.ormlite.table;

import java.lang.reflect.Constructor;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public interface ObjectFactory<T> {
    T createObject(Constructor<T> constructor, Class<T> cls) throws SQLException;
}
