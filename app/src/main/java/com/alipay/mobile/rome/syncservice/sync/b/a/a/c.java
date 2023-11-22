package com.alipay.mobile.rome.syncservice.sync.b.a.a;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.text.TextUtils;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncUpMessage;
import com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType;
import com.j256.ormlite.field.FieldType;

/* loaded from: classes3.dex */
public class c extends a {
    public static final String b = "c";
    private static final String[] c = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "userId", MapConstant.EXTRA_BIZ, "dateTime", "sendTime", GriverConfigConstants.PARAM_PREPARE_APP_TIMEOUT, "random", "payload", "payloadPb", "sendStatus", "needCallback", "bizId"};

    @Override // com.alipay.mobile.rome.syncservice.sync.b.a.a.a
    protected final String b() {
        return "syncUplink";
    }

    public c(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS syncUplink ( _id INTEGER PRIMARY KEY AUTOINCREMENT, userId TEXT NOT NULL, biz TEXT NOT NULL, dateTime INTEGER NOT NULL, sendTime INTEGER, expireTime INTEGER, random INTEGER, payload TEXT, payloadPb BLOB, sendStatus INTEGER, needCallback INTEGER, bizId TEXT, reserve1 TEXT, reserve2 TEXT, reserve3 TEXT )");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS syncUplink_idx ON syncUplink( userId, _id, dateTime, random )");
        } catch (SQLException e) {
            String str = b;
            StringBuilder sb = new StringBuilder("excuteCreateTable:[ SQLException=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            throw e;
        }
    }

    public final long a(String str, int i, long j, SyncUpMessage syncUpMessage, SyncUplinkCallbackType syncUplinkCallbackType) {
        String str2 = b;
        StringBuilder sb = new StringBuilder("insertMessage: userId=");
        sb.append(str);
        sb.append(", syncUpMessage=");
        sb.append(syncUpMessage);
        com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
        if (syncUpMessage == null) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("userId", str);
            contentValues.put(MapConstant.EXTRA_BIZ, syncUpMessage.biz);
            contentValues.put("sendTime", Long.valueOf(syncUpMessage.sendTime));
            contentValues.put(GriverConfigConstants.PARAM_PREPARE_APP_TIMEOUT, Long.valueOf(syncUpMessage.expireTime));
            contentValues.put("payload", syncUpMessage.msgData);
            contentValues.put("payloadPb", syncUpMessage.msgData_pb);
            contentValues.put("random", Integer.valueOf(i));
            contentValues.put("dateTime", Long.valueOf(j));
            contentValues.put("needCallback", Integer.valueOf(syncUplinkCallbackType.ordinal()));
            contentValues.put("bizId", syncUpMessage.bizId);
            return a(contentValues);
        } catch (SQLiteCantOpenDatabaseException e) {
            String message = e.getMessage();
            if (TextUtils.isEmpty(message) || !message.contains("14")) {
                return -1L;
            }
            c();
            return -4L;
        } catch (SQLiteDatabaseCorruptException e2) {
            String str3 = b;
            StringBuilder sb2 = new StringBuilder("insertMessage:");
            sb2.append(e2);
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb2.toString());
            a();
            return -4L;
        } catch (SQLiteDiskIOException e3) {
            String str4 = b;
            StringBuilder sb3 = new StringBuilder("insertMessage:");
            sb3.append(e3);
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, sb3.toString());
            a();
            return -4L;
        } catch (SQLiteReadOnlyDatabaseException e4) {
            String str5 = b;
            StringBuilder sb4 = new StringBuilder("insertMessage:");
            sb4.append(e4);
            com.alipay.mobile.rome.syncsdk.util.c.d(str5, sb4.toString());
            String message2 = e4.getMessage();
            if (TextUtils.isEmpty(message2) || !message2.contains("1032")) {
                return -1L;
            }
            a();
            return -4L;
        } catch (SQLiteException e5) {
            String str6 = b;
            StringBuilder sb5 = new StringBuilder("insertMessage:");
            sb5.append(e5);
            com.alipay.mobile.rome.syncsdk.util.c.d(str6, sb5.toString());
            String message3 = e5.getMessage();
            if (!TextUtils.isEmpty(message3) && message3.contains("not an error") && message3.contains("read/write mode")) {
                c();
                return -4L;
            }
            return -1L;
        } catch (Exception e6) {
            String str7 = b;
            StringBuilder sb6 = new StringBuilder("insertMessage: [Exception=");
            sb6.append(e6);
            sb6.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str7, sb6.toString());
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
    
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r1 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.alipay.mobile.rome.syncservice.sync.d.b> b(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "queryAllMsg: userId="
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.rome.syncsdk.util.c.a(r0, r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String[] r2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.c     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r6 = "userId=?"
            android.database.Cursor r1 = r5.a(r2, r6, r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
        L29:
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r6 == 0) goto L37
            com.alipay.mobile.rome.syncservice.sync.d.b r6 = a(r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r0.add(r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            goto L29
        L37:
            if (r1 == 0) goto L5b
            goto L58
        L3a:
            r6 = move-exception
            goto L5c
        L3c:
            r6 = move-exception
            java.lang.String r2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.b     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "queryAllMsg: [ Exception="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            r3.append(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = " ]"
            r3.append(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            com.alipay.mobile.rome.syncsdk.util.c.d(r2, r6)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L5b
        L58:
            r1.close()
        L5b:
            return r0
        L5c:
            if (r1 == 0) goto L61
            r1.close()
        L61:
            goto L63
        L62:
            throw r6
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.b.a.a.c.b(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0072, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
    
        if (r1 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.alipay.mobile.rome.syncservice.sync.d.b> a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "queryMsgByStatus: uid="
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r2 = ",biz="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ",sendStatus=1"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.rome.syncsdk.util.c.a(r0, r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String[] r2 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.c     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r6 = 1
            r3[r6] = r7     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7 = 2
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r3[r7] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "userId=? AND biz=? AND sendStatus=?"
            android.database.Cursor r1 = r5.a(r2, r6, r3)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
        L40:
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r6 == 0) goto L4e
            com.alipay.mobile.rome.syncservice.sync.d.b r6 = a(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0.add(r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            goto L40
        L4e:
            if (r1 == 0) goto L72
            goto L6f
        L51:
            r6 = move-exception
            goto L73
        L53:
            r6 = move-exception
            java.lang.String r7 = com.alipay.mobile.rome.syncservice.sync.b.a.a.c.b     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "queryMsgByStatus: [ Exception="
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L51
            r2.append(r6)     // Catch: java.lang.Throwable -> L51
            java.lang.String r6 = " ]"
            r2.append(r6)     // Catch: java.lang.Throwable -> L51
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L51
            com.alipay.mobile.rome.syncsdk.util.c.d(r7, r6)     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L72
        L6f:
            r1.close()
        L72:
            return r0
        L73:
            if (r1 == 0) goto L78
            r1.close()
        L78:
            goto L7a
        L79:
            throw r6
        L7a:
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.b.a.a.c.a(java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0082, code lost:
    
        if (r2 < (r0.e + r0.expireTime)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.alipay.mobile.rome.syncservice.sync.d.b a(android.database.Cursor r8) {
        /*
            if (r8 != 0) goto L4
            r8 = 0
            return r8
        L4:
            com.alipay.mobile.rome.syncservice.sync.d.b r0 = new com.alipay.mobile.rome.syncservice.sync.d.b
            r0.<init>()
            r1 = 0
            int r1 = r8.getInt(r1)
            long r1 = (long) r1
            r0.f7301a = r1
            r1 = 1
            java.lang.String r2 = r8.getString(r1)
            r0.c = r2
            r2 = 2
            java.lang.String r2 = r8.getString(r2)
            r0.biz = r2
            r2 = 3
            long r2 = r8.getLong(r2)
            r0.e = r2
            r2 = 4
            long r2 = r8.getLong(r2)
            r0.sendTime = r2
            r2 = 5
            long r2 = r8.getLong(r2)
            r0.expireTime = r2
            r2 = 6
            int r2 = r8.getInt(r2)
            r0.d = r2
            r2 = 7
            java.lang.String r2 = r8.getString(r2)
            r0.msgData = r2
            r2 = 8
            byte[] r2 = r8.getBlob(r2)
            r0.msgData_pb = r2
            r2 = 9
            int r2 = r8.getInt(r2)
            r0.f = r2
            r2 = 10
            int r2 = r8.getInt(r2)
            com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType r2 = com.alipay.mobile.rome.syncservice.up.SyncUplinkCallbackType.toType(r2)
            r0.h = r2
            r2 = 11
            java.lang.String r8 = r8.getString(r2)
            r0.bizId = r8
            long r2 = r0.sendTime
            r4 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L84
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r0.e
            long r6 = r0.sendTime
            long r4 = r4 + r6
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L86
            long r4 = r0.e
            long r6 = r0.expireTime
            long r4 = r4 + r6
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L86
        L84:
            r0.g = r1
        L86:
            long r1 = r0.f7301a
            long r3 = r0.e
            int r8 = r0.d
            java.lang.String r8 = com.alipay.mobile.rome.syncservice.up.b.a(r1, r3, r8)
            r0.b = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.sync.b.a.a.c.a(android.database.Cursor):com.alipay.mobile.rome.syncservice.sync.d.b");
    }

    public final long a(String str, long j, long j2, int i) {
        int i2;
        String str2 = b;
        StringBuilder sb = new StringBuilder("updateSendStatus: userId=");
        sb.append(str);
        sb.append(",dateTime=");
        sb.append(j2);
        com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sendStatus", (Integer) 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("userId");
            sb2.append("=? AND ");
            sb2.append(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            sb2.append("=? AND ");
            sb2.append("dateTime");
            sb2.append("=? AND ");
            sb2.append("random");
            sb2.append("=?");
            i2 = a(contentValues, sb2.toString(), new String[]{str, Long.toString(j), Long.toString(j2), Long.toString(i)});
        } catch (Exception e) {
            String str3 = b;
            StringBuilder sb3 = new StringBuilder("updateSendStatus: [Exception=");
            sb3.append(e);
            sb3.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
            i2 = -1;
        }
        return i2;
    }

    public final long b(String str, long j, long j2, int i) {
        int i2;
        String str2 = b;
        StringBuilder sb = new StringBuilder("deleteMsg: userId=");
        sb.append(str);
        sb.append(",dateTime=");
        sb.append(j2);
        com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("userId");
            sb2.append("=? AND ");
            sb2.append(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            sb2.append("=? AND ");
            sb2.append("dateTime");
            sb2.append("=? AND ");
            sb2.append("random");
            sb2.append("=?");
            i2 = a(sb2.toString(), new String[]{str, Long.toString(j), Long.toString(j2), Integer.toString(i)});
        } catch (Exception e) {
            String str3 = b;
            StringBuilder sb3 = new StringBuilder("deleteMsg: [Exception=");
            sb3.append(e);
            sb3.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
            i2 = -1;
        }
        return i2;
    }

    public final long a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            com.alipay.mobile.rome.syncsdk.util.c.d(b, "deleteMsgByBizId : entityId or biz is empty");
            return -1L;
        }
        String str4 = b;
        StringBuilder sb = new StringBuilder("deleteMsgByBizId: biz=");
        sb.append(str2);
        sb.append(", bizId=");
        sb.append(str3);
        com.alipay.mobile.rome.syncsdk.util.c.a(str4, sb.toString());
        int i = -1;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("userId");
            sb2.append("=? AND ");
            sb2.append(MapConstant.EXTRA_BIZ);
            sb2.append("=? AND ");
            sb2.append("bizId");
            sb2.append("=?");
            i = a(sb2.toString(), new String[]{str, str2, str3});
        } catch (Exception e) {
            String str5 = b;
            StringBuilder sb3 = new StringBuilder("deleteMsgByBizId: [Exception=");
            sb3.append(e);
            sb3.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str5, sb3.toString());
        }
        return i;
    }
}
