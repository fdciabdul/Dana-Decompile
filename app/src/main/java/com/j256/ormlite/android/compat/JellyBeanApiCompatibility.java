package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.j256.ormlite.android.compat.ApiCompatibility;

/* loaded from: classes8.dex */
public class JellyBeanApiCompatibility extends BasicApiCompatibility {
    @Override // com.j256.ormlite.android.compat.BasicApiCompatibility, com.j256.ormlite.android.compat.ApiCompatibility
    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        if (cancellationHook == null) {
            return sQLiteDatabase.rawQuery(str, strArr);
        }
        return sQLiteDatabase.rawQuery(str, strArr, ((JellyBeanCancellationHook) cancellationHook).cancellationSignal);
    }

    @Override // com.j256.ormlite.android.compat.BasicApiCompatibility, com.j256.ormlite.android.compat.ApiCompatibility
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return new JellyBeanCancellationHook();
    }

    /* loaded from: classes8.dex */
    protected static class JellyBeanCancellationHook implements ApiCompatibility.CancellationHook {
        private final CancellationSignal cancellationSignal = new CancellationSignal();

        @Override // com.j256.ormlite.android.compat.ApiCompatibility.CancellationHook
        public void cancel() {
            this.cancellationSignal.cancel();
        }
    }
}
