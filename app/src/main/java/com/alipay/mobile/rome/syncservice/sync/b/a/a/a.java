package com.alipay.mobile.rome.syncservice.sync.b.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alipay.mobile.rome.syncservice.d.d;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected SQLiteDatabase f7293a;

    protected abstract String b();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(SQLiteDatabase sQLiteDatabase) {
        this.f7293a = sQLiteDatabase;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            this.f7293a = sQLiteDatabase;
        }
    }

    public final long a(ContentValues contentValues) {
        long insertOrThrow;
        synchronized (d.f7281a) {
            insertOrThrow = this.f7293a.insertOrThrow(b(), null, contentValues);
        }
        return insertOrThrow;
    }

    public final int a(String str, String[] strArr) {
        int delete;
        synchronized (d.f7281a) {
            delete = this.f7293a.delete(b(), str, strArr);
        }
        return delete;
    }

    public final int a(ContentValues contentValues, String str, String[] strArr) {
        int update;
        synchronized (d.f7281a) {
            update = this.f7293a.update(b(), contentValues, str, strArr);
        }
        return update;
    }

    public final Cursor a(String[] strArr, String str, String[] strArr2) {
        Cursor query;
        synchronized (d.f7281a) {
            query = this.f7293a.query(b(), strArr, str, strArr2, null, null, null);
        }
        return query;
    }

    public final Cursor b(String str, String[] strArr) {
        Cursor rawQuery;
        synchronized (d.f7281a) {
            rawQuery = this.f7293a.rawQuery(str, strArr);
        }
        return rawQuery;
    }

    public final void a(String str) {
        synchronized (d.f7281a) {
            this.f7293a.execSQL(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        synchronized (d.f7281a) {
            com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c() {
        synchronized (d.f7281a) {
            com.alipay.mobile.rome.syncservice.sync.b.a.a.a(com.alipay.mobile.rome.syncservice.d.a.f7279a).b();
        }
    }
}
