package com.alipay.mobile.rome.syncservice.sync.b.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.text.TextUtils;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.rome.syncservice.model.ResultCodeEnum;
import com.alipay.mobile.rome.syncservice.model.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b extends a {
    private static final String b = "b";
    private volatile Map<String, Integer> c;
    private volatile boolean d;

    @Override // com.alipay.mobile.rome.syncservice.sync.b.a.a.a
    public final String b() {
        return "sync_dispatch";
    }

    public b(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        this.c = new ConcurrentHashMap();
        this.d = false;
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sync_dispatch` ( `userId` VARCHAR NOT NULL, `biz` VARCHAR NOT NULL, `sKey` VARCHAR NOT NULL, `pf` VARCHAR , `hm` VARCHAR , `md` VARCHAR , `sendNum` INTEGER ,  `localTime` BIGINT , `reserv1` VARCHAR, `reserv2` VARCHAR, `id` INTEGER PRIMARY KEY AUTOINCREMENT );");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `sync_dispatch_idx` ON `sync_dispatch` ( `userId`, `biz`, `sKey`)");
        } catch (SQLException e) {
            String str = b;
            StringBuilder sb = new StringBuilder("excuteCreateTable:[ SQLException=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            throw e;
        }
    }

    public final int a(String str, String str2, int i) {
        try {
            return a("userId = ? AND biz = ? AND id = ? ", new String[]{str, str2, String.valueOf(i)});
        } catch (Exception e) {
            String str3 = b;
            StringBuilder sb = new StringBuilder("deleteMsgItem: ");
            sb.append(e);
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb.toString());
            return 0;
        }
    }

    public final int a(String str, String str2) {
        try {
            return a("userId = ? AND biz = ? ", new String[]{str, str2});
        } catch (Exception e) {
            String str3 = b;
            StringBuilder sb = new StringBuilder("deleteDownlinkMsgItem: ");
            sb.append(e);
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb.toString());
            return 0;
        }
    }

    public final d a(com.alipay.mobile.rome.syncservice.sync.d.a aVar) {
        if (aVar == null) {
            return new d(ResultCodeEnum.ERROR);
        }
        long j = -1;
        if (aVar != null) {
            try {
            } catch (SQLiteCantOpenDatabaseException e) {
                String message = e.getMessage();
                if (!TextUtils.isEmpty(message) && message.contains("14")) {
                    c();
                    return new d(ResultCodeEnum.DB_CRUPT, String.valueOf(e));
                }
                return new d(ResultCodeEnum.ERROR, String.valueOf(e));
            } catch (SQLiteConstraintException e2) {
                if (a(aVar.b, aVar.c, aVar.d)) {
                    String str = b;
                    StringBuilder sb = new StringBuilder("insertDownlinkMsgItem: has same index:");
                    sb.append(aVar.d);
                    com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
                    return new d(ResultCodeEnum.REPEATED_ITEM);
                }
                String str2 = b;
                StringBuilder sb2 = new StringBuilder("insertDownlinkMsgItem: ");
                sb2.append(aVar.d);
                sb2.append(",error reason: ");
                sb2.append(e2);
                com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb2.toString());
            } catch (SQLiteDatabaseCorruptException e3) {
                String str3 = b;
                StringBuilder sb3 = new StringBuilder("insertDownlinkMsgItem:");
                sb3.append(e3);
                com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
                a();
                return new d(ResultCodeEnum.DB_CRUPT, String.valueOf(e3));
            } catch (SQLiteDiskIOException e4) {
                String str4 = b;
                StringBuilder sb4 = new StringBuilder("insertDownlinkMsgItem:");
                sb4.append(e4);
                com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb4.toString());
                a();
                return new d(ResultCodeEnum.DB_CRUPT, String.valueOf(e4));
            } catch (SQLiteReadOnlyDatabaseException e5) {
                String str5 = b;
                StringBuilder sb5 = new StringBuilder("insertDownlinkMsgItem:");
                sb5.append(e5);
                com.alipay.mobile.rome.syncsdk.util.c.d(str5, sb5.toString());
                String message2 = e5.getMessage();
                if (!TextUtils.isEmpty(message2) && message2.contains("1032")) {
                    a();
                    return new d(ResultCodeEnum.DB_CRUPT, String.valueOf(e5));
                }
                return new d(ResultCodeEnum.ERROR, String.valueOf(e5));
            } catch (SQLiteException e6) {
                String str6 = b;
                StringBuilder sb6 = new StringBuilder("insertDownlinkMsgItem:");
                sb6.append(e6);
                com.alipay.mobile.rome.syncsdk.util.c.d(str6, sb6.toString());
                String message3 = e6.getMessage();
                if (!TextUtils.isEmpty(message3) && message3.contains("not an error") && message3.contains("read/write mode")) {
                    c();
                    return new d(ResultCodeEnum.DB_CRUPT, String.valueOf(e6));
                }
                return new d(ResultCodeEnum.ERROR, String.valueOf(e6));
            } catch (Exception e7) {
                String str7 = b;
                StringBuilder sb7 = new StringBuilder("insertDownlinkMsgItem: ");
                sb7.append(e7);
                com.alipay.mobile.rome.syncsdk.util.c.d(str7, sb7.toString());
                return new d(ResultCodeEnum.ERROR, String.valueOf(e7));
            }
            if (!TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.d)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userId", aVar.b);
                contentValues.put(MapConstant.EXTRA_BIZ, aVar.c);
                contentValues.put("sKey", aVar.d);
                contentValues.put("hm", aVar.e);
                contentValues.put("md", aVar.f);
                contentValues.put("sendNum", Integer.valueOf(aVar.g));
                contentValues.put("localTime", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("reserv1", aVar.j);
                contentValues.put("reserv2", aVar.k);
                j = a(contentValues);
                String str8 = b;
                StringBuilder sb8 = new StringBuilder("insertDownlinkMsgItem[dbid=");
                sb8.append(j);
                sb8.append("] [sKey=");
                sb8.append(aVar.d);
                sb8.append("]");
                com.alipay.mobile.rome.syncsdk.util.c.a(str8, sb8.toString());
                return j > 0 ? new d(ResultCodeEnum.SUCCESS) : new d(ResultCodeEnum.ERROR);
            }
        }
        StringBuilder sb9 = new StringBuilder("string empty[biz:");
        sb9.append(aVar.c);
        sb9.append(",skey:");
        sb9.append(aVar.d);
        sb9.append("]");
        throw new Exception(sb9.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01d0  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.alipay.mobile.rome.syncservice.sync.d.a b(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.b.a.a.b.b(java.lang.String, java.lang.String):com.alipay.mobile.rome.syncservice.sync.d.a");
    }

    private boolean a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT userId,biz,sKey FROM ");
        sb.append("sync_dispatch");
        sb.append(" WHERE userId = ? AND biz = ? AND sKey = ?");
        String[] strArr = {str, str2, str3};
        Cursor cursor = null;
        try {
            try {
                cursor = b(sb.toString(), strArr);
                boolean z = cursor.getCount() > 0;
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Exception e) {
                String str4 = b;
                StringBuilder sb2 = new StringBuilder("hasMsgItem: [ Exception=");
                sb2.append(e);
                sb2.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb2.toString());
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
