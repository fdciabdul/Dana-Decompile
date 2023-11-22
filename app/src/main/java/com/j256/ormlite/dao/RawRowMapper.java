package com.j256.ormlite.dao;

import java.sql.SQLException;

/* loaded from: classes8.dex */
public interface RawRowMapper<T> {
    T mapRow(String[] strArr, String[] strArr2) throws SQLException;
}
