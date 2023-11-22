package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.compat.ApiCompatibility;

/* loaded from: classes8.dex */
public class BasicApiCompatibility implements ApiCompatibility {
    @Override // com.j256.ormlite.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return null;
    }

    @Override // com.j256.ormlite.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        return sQLiteDatabase.rawQuery(str, strArr);
    }
}
