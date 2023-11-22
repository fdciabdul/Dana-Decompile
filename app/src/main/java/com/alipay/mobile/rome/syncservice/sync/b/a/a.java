package com.alipay.mobile.rome.syncservice.sync.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncservice.d.e;
import com.alipay.mobile.rome.syncservice.sync.b.a.a.c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7292a = "a";
    private static volatile a e;
    public c b;
    public com.alipay.mobile.rome.syncservice.sync.b.a.a.b c;
    public AtomicBoolean d;
    private Context f;

    public static a a(Context context) {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a(context, "sync_dispatch.db");
                }
            }
        }
        return e;
    }

    private a(Context context, String str) {
        super(context, str);
        SQLiteDatabase c;
        this.d = new AtomicBoolean(false);
        this.f = context;
        try {
            c = c();
        } catch (SQLiteCantOpenDatabaseException e2) {
            String str2 = f7292a;
            StringBuilder sb = new StringBuilder("SyncDbManager error:");
            sb.append(e2);
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            String message = e2.getMessage();
            if (!TextUtils.isEmpty(message) && message.contains("14")) {
                b();
                c = c();
            } else {
                this.f.deleteDatabase("sync_dispatch.db");
                c = c();
            }
        } catch (SQLiteException e3) {
            String str3 = f7292a;
            StringBuilder sb2 = new StringBuilder("Could not open the database:");
            sb2.append(e3);
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb2.toString());
            String message2 = e3.getMessage();
            if (!TextUtils.isEmpty(message2) && message2.contains("not an error") && message2.contains("read/write mode")) {
                b();
                c = c();
            } else {
                this.f.deleteDatabase("sync_dispatch.db");
                c = c();
            }
        } catch (Exception e4) {
            String str4 = f7292a;
            StringBuilder sb3 = new StringBuilder("Could not open the database, need recreate: ");
            sb3.append(e4);
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb3.toString());
            this.f.deleteDatabase("sync_dispatch.db");
            c = c();
        }
        this.c = new com.alipay.mobile.rome.syncservice.sync.b.a.a.b(c);
        this.b = new c(c);
    }

    @Override // com.alipay.mobile.rome.syncservice.sync.b.a.b
    public final void a(SQLiteDatabase sQLiteDatabase) {
        com.alipay.mobile.rome.syncsdk.util.c.a(f7292a, "onCreate");
        com.alipay.mobile.rome.syncservice.sync.b.a.a.b bVar = this.c;
        if (bVar != null) {
            bVar.a(sQLiteDatabase);
            this.b.a(sQLiteDatabase);
        }
        com.alipay.mobile.rome.syncservice.sync.b.a.a.b.b(sQLiteDatabase);
        c.b(sQLiteDatabase);
    }

    @Override // com.alipay.mobile.rome.syncservice.sync.b.a.b
    public final void a(int i, int i2) {
        String str = f7292a;
        StringBuilder sb = new StringBuilder("onUpgrade: oldVersion = ");
        sb.append(i);
        sb.append(", newVersion=");
        sb.append(i2);
        com.alipay.mobile.rome.syncsdk.util.c.c(str, sb.toString());
    }

    @Override // com.alipay.mobile.rome.syncservice.sync.b.a.b
    public final void b(int i, int i2) {
        com.alipay.mobile.rome.syncsdk.util.c.c(f7292a, "onDowngrade");
    }

    public final boolean a() {
        boolean z = true;
        this.d.set(true);
        try {
            d();
            this.f.deleteDatabase("sync_dispatch.db");
            c();
        } catch (Exception e2) {
            String str = f7292a;
            StringBuilder sb = new StringBuilder("deleteAndRecreateDB:");
            sb.append(e2);
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            z = false;
        }
        this.d.set(false);
        return z;
    }

    public final long a(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (this.d.get()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7292a, "deleteMsg...db recreating~");
            return 0L;
        }
        c cVar = this.b;
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.d(c.b, "deleteMsg : uplinkMsgItem is null");
            return -1L;
        }
        return cVar.b(bVar.c, bVar.f7301a, bVar.e, bVar.d);
    }

    public final int a(String str, String str2, int i) {
        if (this.d.get()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7292a, "deleteDownlinkMsgItem...db recreating~");
            return 0;
        }
        return this.c.a(str, str2, i);
    }

    public final void b() {
        try {
            String path = this.f.getDatabasePath("sync_dispatch.db").getPath();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("chmod 660 ");
            sb.append(path);
            arrayList.add(sb.toString());
            StringBuilder sb2 = new StringBuilder("chmod 660 ");
            sb2.append(path);
            sb2.append("-journal");
            arrayList.add(sb2.toString());
            if (!e.a(arrayList)) {
                String str = f7292a;
                StringBuilder sb3 = new StringBuilder("changeDBReadWrite failed path=");
                sb3.append(path);
                sb3.append(", DO deleteAndRecreateDB!");
                com.alipay.mobile.rome.syncsdk.util.c.a(str, sb3.toString());
                a();
                return;
            }
            String str2 = f7292a;
            StringBuilder sb4 = new StringBuilder("changeDBReadWrite success path=");
            sb4.append(path);
            com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb4.toString());
        } catch (Throwable th) {
            String str3 = f7292a;
            StringBuilder sb5 = new StringBuilder("changeDBReadWrite path=");
            sb5.append((String) null);
            sb5.append(" error: ");
            sb5.append(th);
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb5.toString());
        }
    }
}
