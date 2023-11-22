package com.ta.audid.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hms.push.e;
import com.ta.audid.g.j;
import com.ta.audid.g.m;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f7672a;

    /* renamed from: a  reason: collision with other field name */
    private a f46a;

    /* renamed from: a  reason: collision with other field name */
    private Future<?> f47a;

    /* renamed from: a  reason: collision with other field name */
    private AtomicInteger f48a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public c(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        this.f48a = new AtomicInteger();
        this.f46a = new a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        closeCursor(cursor);
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            try {
                if (this.f7672a == null) {
                    this.f7672a = super.getWritableDatabase();
                }
                this.f48a.incrementAndGet();
            } catch (Throwable th) {
                m.w("TAG", e.PlaceComponentResult, th);
            }
            sQLiteDatabase = this.f7672a;
        }
        return sQLiteDatabase;
    }

    public void closeWritableDatabase(SQLiteDatabase sQLiteDatabase) {
        synchronized (this) {
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.f48a.decrementAndGet() == 0) {
                    Future<?> future = this.f47a;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f47a = j.a().schedule(null, this.f46a, 30000L);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                if (c.this.f48a.get() == 0 && c.this.f7672a != null) {
                    c.this.f7672a.close();
                    c.this.f7672a = null;
                }
            }
        }
    }
}
