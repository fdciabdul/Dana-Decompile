package com.alipay.mobile.rome.syncservice.sync.b.a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.alipay.mobile.rome.syncsdk.util.c;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7294a;
    private final String b;
    private final SQLiteDatabase.CursorFactory c;
    private final int d;
    private SQLiteDatabase e;
    private boolean f;
    private final DatabaseErrorHandler g;

    public abstract void a(int i, int i2);

    public abstract void a(SQLiteDatabase sQLiteDatabase);

    public b(Context context, String str) {
        this(context, str, (byte) 0);
    }

    private b(Context context, String str, byte b) {
        this.f7294a = context;
        this.b = str;
        this.c = null;
        this.d = 1;
        this.g = null;
    }

    public final SQLiteDatabase c() {
        SQLiteDatabase a2;
        synchronized (this) {
            a2 = a();
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[Catch: all -> 0x00f9, TryCatch #3 {all -> 0x00f9, blocks: (B:14:0x0021, B:17:0x0027, B:19:0x002d, B:28:0x0075, B:30:0x007d, B:32:0x0083, B:40:0x009f, B:42:0x00a4, B:43:0x00a7, B:44:0x00a8, B:45:0x00d3, B:46:0x00d4, B:48:0x00da, B:49:0x00f2, B:22:0x004a, B:23:0x005d, B:25:0x0061, B:27:0x0066, B:53:0x00f8, B:34:0x0088, B:39:0x0097, B:35:0x008c, B:37:0x0090, B:38:0x0094), top: B:69:0x0021, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da A[Catch: all -> 0x00f9, TryCatch #3 {all -> 0x00f9, blocks: (B:14:0x0021, B:17:0x0027, B:19:0x002d, B:28:0x0075, B:30:0x007d, B:32:0x0083, B:40:0x009f, B:42:0x00a4, B:43:0x00a7, B:44:0x00a8, B:45:0x00d3, B:46:0x00d4, B:48:0x00da, B:49:0x00f2, B:22:0x004a, B:23:0x005d, B:25:0x0061, B:27:0x0066, B:53:0x00f8, B:34:0x0088, B:39:0x0097, B:35:0x008c, B:37:0x0090, B:38:0x0094), top: B:69:0x0021, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.database.sqlite.SQLiteDatabase a() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.b.a.b.a():android.database.sqlite.SQLiteDatabase");
    }

    private String b() {
        File databasePath = this.f7294a.getDatabasePath(this.b);
        try {
            File parentFile = databasePath.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Make dirs for ");
            sb.append(databasePath.getPath());
            sb.append(" Error!");
            c.a("SyncSQLiteOpenHelper", sb.toString(), e);
        }
        return databasePath.getPath();
    }

    public final void d() {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Closed during initialization");
            }
            SQLiteDatabase sQLiteDatabase = this.e;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.e.close();
                this.e = null;
            }
        }
    }

    public void b(int i, int i2) {
        StringBuilder sb = new StringBuilder("Can't downgrade database from version ");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        throw new SQLiteException(sb.toString());
    }
}
