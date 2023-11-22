package com.mixpanel.android.mpmetrics;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.j256.ormlite.field.FieldType;
import com.mixpanel.android.util.MPLog;
import id.dana.tracker.constant.TrackerType;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MPDbAdapter {
    private static final String BuiltInFictitiousFunctionClassFactory;
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private static final String MyBillsEntityDataFactory;
    private static final Map<Context, MPDbAdapter> NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap();
    private static final String PlaceComponentResult;
    private static final String getErrorConfigVersion;
    private static final String lookAheadTest;
    private static final String moveToNextValue;
    private static final String scheduleImpl;
    final MPDatabaseHelper getAuthRequestContext;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(Table.EVENTS.getName());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("data");
        sb.append(" STRING NOT NULL, ");
        sb.append("created_at");
        sb.append(" INTEGER NOT NULL, ");
        sb.append("automatic_data");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("token");
        sb.append(" STRING NOT NULL DEFAULT '')");
        PlaceComponentResult = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        sb2.append(Table.PEOPLE.getName());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("data");
        sb2.append(" STRING NOT NULL, ");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL, ");
        sb2.append("automatic_data");
        sb2.append(" INTEGER DEFAULT 0, ");
        sb2.append("token");
        sb2.append(" STRING NOT NULL DEFAULT '')");
        scheduleImpl = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE ");
        sb3.append(Table.GROUPS.getName());
        sb3.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb3.append("data");
        sb3.append(" STRING NOT NULL, ");
        sb3.append("created_at");
        sb3.append(" INTEGER NOT NULL, ");
        sb3.append("automatic_data");
        sb3.append(" INTEGER DEFAULT 0, ");
        sb3.append("token");
        sb3.append(" STRING NOT NULL DEFAULT '')");
        MyBillsEntityDataFactory = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE TABLE ");
        sb4.append(Table.ANONYMOUS_PEOPLE.getName());
        sb4.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb4.append("data");
        sb4.append(" STRING NOT NULL, ");
        sb4.append("created_at");
        sb4.append(" INTEGER NOT NULL, ");
        sb4.append("automatic_data");
        sb4.append(" INTEGER DEFAULT 0, ");
        sb4.append("token");
        sb4.append(" STRING NOT NULL DEFAULT '')");
        BuiltInFictitiousFunctionClassFactory = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb5.append(Table.EVENTS.getName());
        sb5.append(" (");
        sb5.append("created_at");
        sb5.append(");");
        getErrorConfigVersion = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb6.append(Table.PEOPLE.getName());
        sb6.append(" (");
        sb6.append("created_at");
        sb6.append(");");
        moveToNextValue = sb6.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb7.append(Table.GROUPS.getName());
        sb7.append(" (");
        sb7.append("created_at");
        sb7.append(");");
        lookAheadTest = sb7.toString();
        StringBuilder sb8 = new StringBuilder();
        sb8.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb8.append(Table.ANONYMOUS_PEOPLE.getName());
        sb8.append(" (");
        sb8.append("created_at");
        sb8.append(");");
        KClassImpl$Data$declaredNonStaticMembers$2 = sb8.toString();
    }

    /* loaded from: classes.dex */
    public enum Table {
        EVENTS("events"),
        PEOPLE("people"),
        ANONYMOUS_PEOPLE("anonymous_people"),
        GROUPS("groups");

        private final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public final String getName() {
            return this.mTableName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MPDatabaseHelper extends SQLiteOpenHelper {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, -98, 98, -100, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 21;
        private final MPConfig MyBillsEntityDataFactory;
        private final Context PlaceComponentResult;
        final File getAuthRequestContext;

        private static void a(int i, short s, byte b, Object[] objArr) {
            int i2 = 23 - (i * 5);
            int i3 = b + 4;
            byte[] bArr = BuiltInFictitiousFunctionClassFactory;
            int i4 = 103 - (s * 6);
            byte[] bArr2 = new byte[i2];
            int i5 = -1;
            int i6 = i2 - 1;
            if (bArr == null) {
                i4 = (i4 + (-i3)) - 8;
                i3 = i3;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i5 = -1;
            }
            while (true) {
                int i7 = i5 + 1;
                int i8 = i3 + 1;
                bArr2[i7] = (byte) i4;
                if (i7 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                Object[] objArr2 = objArr;
                byte[] bArr3 = bArr2;
                byte[] bArr4 = bArr;
                i4 = (i4 + (-bArr[i8])) - 8;
                i3 = i8;
                objArr = objArr2;
                bArr = bArr4;
                bArr2 = bArr3;
                i5 = i7;
            }
        }

        MPDatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 7);
            this.getAuthRequestContext = context.getDatabasePath(str);
            this.MyBillsEntityDataFactory = MPConfig.getAuthRequestContext(context);
            this.PlaceComponentResult = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
            sQLiteDatabase.execSQL(MPDbAdapter.PlaceComponentResult);
            sQLiteDatabase.execSQL(MPDbAdapter.scheduleImpl);
            sQLiteDatabase.execSQL(MPDbAdapter.MyBillsEntityDataFactory);
            sQLiteDatabase.execSQL(MPDbAdapter.BuiltInFictitiousFunctionClassFactory);
            sQLiteDatabase.execSQL(MPDbAdapter.getErrorConfigVersion);
            sQLiteDatabase.execSQL(MPDbAdapter.moveToNextValue);
            sQLiteDatabase.execSQL(MPDbAdapter.lookAheadTest);
            sQLiteDatabase.execSQL(MPDbAdapter.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int i3;
            int i4;
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
            if (i < 4 || i2 > 7) {
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(Table.EVENTS.getName());
                sQLiteDatabase.execSQL(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DROP TABLE IF EXISTS ");
                sb2.append(Table.PEOPLE.getName());
                sQLiteDatabase.execSQL(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("DROP TABLE IF EXISTS ");
                sb3.append(Table.GROUPS.getName());
                sQLiteDatabase.execSQL(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("DROP TABLE IF EXISTS ");
                sb4.append(Table.ANONYMOUS_PEOPLE.getName());
                sQLiteDatabase.execSQL(sb4.toString());
                sQLiteDatabase.execSQL(MPDbAdapter.PlaceComponentResult);
                sQLiteDatabase.execSQL(MPDbAdapter.scheduleImpl);
                sQLiteDatabase.execSQL(MPDbAdapter.MyBillsEntityDataFactory);
                sQLiteDatabase.execSQL(MPDbAdapter.BuiltInFictitiousFunctionClassFactory);
                sQLiteDatabase.execSQL(MPDbAdapter.getErrorConfigVersion);
                sQLiteDatabase.execSQL(MPDbAdapter.moveToNextValue);
                sQLiteDatabase.execSQL(MPDbAdapter.lookAheadTest);
                sQLiteDatabase.execSQL(MPDbAdapter.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            if (i == 4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ALTER TABLE ");
                sb5.append(Table.EVENTS.getName());
                sb5.append(" ADD COLUMN ");
                sb5.append("automatic_data");
                sb5.append(" INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("ALTER TABLE ");
                sb6.append(Table.PEOPLE.getName());
                sb6.append(" ADD COLUMN ");
                sb6.append("automatic_data");
                sb6.append(" INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("ALTER TABLE ");
                sb7.append(Table.EVENTS.getName());
                sb7.append(" ADD COLUMN ");
                sb7.append("token");
                sb7.append(" STRING NOT NULL DEFAULT ''");
                sQLiteDatabase.execSQL(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("ALTER TABLE ");
                sb8.append(Table.PEOPLE.getName());
                sb8.append(" ADD COLUMN ");
                sb8.append("token");
                sb8.append(" STRING NOT NULL DEFAULT ''");
                sQLiteDatabase.execSQL(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append("SELECT * FROM ");
                sb9.append(Table.EVENTS.getName());
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb9.toString(), null);
                while (rawQuery.moveToNext()) {
                    try {
                        String string = new JSONObject(rawQuery.getString(rawQuery.getColumnIndex("data"))).getJSONObject("properties").getString("token");
                        i4 = rawQuery.getInt(rawQuery.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                        try {
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("UPDATE ");
                            sb10.append(Table.EVENTS.getName());
                            sb10.append(" SET ");
                            sb10.append("token");
                            sb10.append(" = '");
                            sb10.append(string);
                            sb10.append("' WHERE _id = ");
                            sb10.append(i4);
                            sQLiteDatabase.execSQL(sb10.toString());
                        } catch (JSONException unused) {
                            String name = Table.EVENTS.getName();
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append("_id = ");
                            sb11.append(i4);
                            sQLiteDatabase.delete(name, sb11.toString(), null);
                        }
                    } catch (JSONException unused2) {
                        i4 = 0;
                    }
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("SELECT * FROM ");
                sb12.append(Table.PEOPLE.getName());
                Cursor rawQuery2 = sQLiteDatabase.rawQuery(sb12.toString(), null);
                while (rawQuery2.moveToNext()) {
                    try {
                        String string2 = new JSONObject(rawQuery2.getString(rawQuery2.getColumnIndex("data"))).getString("$token");
                        i3 = rawQuery2.getInt(rawQuery2.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                        try {
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append("UPDATE ");
                            sb13.append(Table.PEOPLE.getName());
                            sb13.append(" SET ");
                            sb13.append("token");
                            sb13.append(" = '");
                            sb13.append(string2);
                            sb13.append("' WHERE _id = ");
                            sb13.append(i3);
                            sQLiteDatabase.execSQL(sb13.toString());
                        } catch (JSONException unused3) {
                            String name2 = Table.PEOPLE.getName();
                            StringBuilder sb14 = new StringBuilder();
                            sb14.append("_id = ");
                            sb14.append(i3);
                            sQLiteDatabase.delete(name2, sb14.toString(), null);
                        }
                    } catch (JSONException unused4) {
                        i3 = 0;
                    }
                }
                sQLiteDatabase.execSQL(MPDbAdapter.MyBillsEntityDataFactory);
                sQLiteDatabase.execSQL(MPDbAdapter.lookAheadTest);
                MyBillsEntityDataFactory(sQLiteDatabase);
            }
            if (i == 5) {
                sQLiteDatabase.execSQL(MPDbAdapter.MyBillsEntityDataFactory);
                sQLiteDatabase.execSQL(MPDbAdapter.lookAheadTest);
                MyBillsEntityDataFactory(sQLiteDatabase);
            }
            if (i == 6) {
                MyBillsEntityDataFactory(sQLiteDatabase);
            }
        }

        public final boolean PlaceComponentResult() {
            return !this.getAuthRequestContext.exists() || Math.max(this.getAuthRequestContext.getUsableSpace(), (long) this.MyBillsEntityDataFactory.initRecordTimeStamp) >= this.getAuthRequestContext.length();
        }

        private void MyBillsEntityDataFactory(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(MPDbAdapter.BuiltInFictitiousFunctionClassFactory);
            sQLiteDatabase.execSQL(MPDbAdapter.KClassImpl$Data$declaredNonStaticMembers$2);
            Context context = this.PlaceComponentResult;
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[41];
                byte b2 = (byte) (b + 1);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (-b2), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 3), BuiltInFictitiousFunctionClassFactory[41], (byte) KClassImpl$Data$declaredNonStaticMembers$2, objArr2);
                File file = new File(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).dataDir, "shared_prefs");
                if (file.exists() && file.isDirectory()) {
                    for (String str : file.list(new FilenameFilter() { // from class: com.mixpanel.android.mpmetrics.MPDbAdapter.MPDatabaseHelper.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str2) {
                            return str2.startsWith("com.mixpanel.android.mpmetrics.MixpanelAPI_");
                        }
                    })) {
                        SharedPreferences sharedPreferences = this.PlaceComponentResult.getSharedPreferences(str.split("\\.xml")[0], 0);
                        String string = sharedPreferences.getString("waiting_array", null);
                        if (string != null) {
                            try {
                                JSONArray jSONArray = new JSONArray(string);
                                sQLiteDatabase.beginTransaction();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    try {
                                        try {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            String string2 = jSONObject.getString("$token");
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("data", jSONObject.toString());
                                            contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                                            contentValues.put("automatic_data", Boolean.FALSE);
                                            contentValues.put("token", string2);
                                            sQLiteDatabase.insert(Table.ANONYMOUS_PEOPLE.getName(), null, contentValues);
                                        } catch (JSONException unused) {
                                        }
                                    } catch (Throwable th) {
                                        sQLiteDatabase.endTransaction();
                                        throw th;
                                        break;
                                    }
                                }
                                sQLiteDatabase.setTransactionSuccessful();
                                sQLiteDatabase.endTransaction();
                            } catch (JSONException unused2) {
                            }
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.remove("waiting_array");
                            edit.apply();
                        }
                    }
                }
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    private MPDbAdapter(Context context) {
        this(context, TrackerType.MIXPANEL);
    }

    private MPDbAdapter(Context context, String str) {
        this.getAuthRequestContext = new MPDatabaseHelper(context, str);
    }

    public static MPDbAdapter getAuthRequestContext(Context context) {
        MPDbAdapter mPDbAdapter;
        Map<Context, MPDbAdapter> map = NetworkUserEntityData$$ExternalSyntheticLambda0;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                mPDbAdapter = new MPDbAdapter(applicationContext);
                map.put(applicationContext, mPDbAdapter);
            } else {
                mPDbAdapter = map.get(applicationContext);
            }
        }
        return mPDbAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int MyBillsEntityDataFactory(org.json.JSONObject r8, java.lang.String r9, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r10, boolean r11) {
        /*
            r7 = this;
            boolean r0 = r7.lookAheadTest()
            java.lang.String r1 = "MixpanelAPI.Database"
            if (r0 != 0) goto Lf
            java.lang.String r8 = "There is not enough space left on the device to store Mixpanel data, so data was discarded"
            com.mixpanel.android.util.MPLog.getAuthRequestContext(r1, r8)
            r8 = -2
            return r8
        Lf:
            java.lang.String r10 = r10.getName()
            r0 = -1
            r2 = 0
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r3 = r7.getAuthRequestContext     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4.<init>()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = "data"
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4.put(r5, r8)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r8 = "created_at"
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4.put(r8, r5)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r8 = "automatic_data"
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4.put(r8, r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r8 = "token"
            r4.put(r8, r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r3.insert(r10, r2, r4)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.<init>()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r11 = "SELECT COUNT(*) FROM "
            r8.append(r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.append(r10)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r11 = " WHERE token='"
            r8.append(r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.append(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r9 = "'"
            r8.append(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r8 = r3.rawQuery(r8, r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r8.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> Lb3
            r9 = 0
            int r0 = r8.getInt(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> Lb3
            if (r8 == 0) goto Lad
            r8.close()
            goto Lad
        L77:
            r9 = move-exception
            goto L7e
        L79:
            r8 = move-exception
            goto Lb6
        L7b:
            r8 = move-exception
            r9 = r8
            r8 = r2
        L7e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r11.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "Could not add Mixpanel data to table "
            r11.append(r3)     // Catch: java.lang.Throwable -> Lb3
            r11.append(r10)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r10 = ". Re-initializing database."
            r11.append(r10)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> Lb3
            com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r10, r9)     // Catch: java.lang.Throwable -> Lb3
            if (r8 == 0) goto L9d
            r8.close()     // Catch: java.lang.Throwable -> Lb3
            goto L9e
        L9d:
            r2 = r8
        L9e:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r8 = r7.getAuthRequestContext     // Catch: java.lang.Throwable -> L79
            r8.close()     // Catch: java.lang.Throwable -> L79
            java.io.File r8 = r8.getAuthRequestContext     // Catch: java.lang.Throwable -> L79
            r8.delete()     // Catch: java.lang.Throwable -> L79
            if (r2 == 0) goto Lad
            r2.close()
        Lad:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r8 = r7.getAuthRequestContext
            r8.close()
            return r0
        Lb3:
            r9 = move-exception
            r2 = r8
            r8 = r9
        Lb6:
            if (r2 == 0) goto Lbb
            r2.close()
        Lbb:
            com.mixpanel.android.mpmetrics.MPDbAdapter$MPDatabaseHelper r9 = r7.getAuthRequestContext
            r9.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.MyBillsEntityDataFactory(org.json.JSONObject, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0130  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int PlaceComponentResult(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.PlaceComponentResult(java.lang.String, java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r7v1, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAuthRequestContext(java.util.Map<java.lang.String, java.lang.String> r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.getAuthRequestContext(java.util.Map, java.lang.String):int");
    }

    public final void getAuthRequestContext(String str, Table table, String str2, boolean z) {
        String name = table.getName();
        try {
            try {
                SQLiteDatabase writableDatabase = this.getAuthRequestContext.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("_id <= ");
                sb.append(str);
                sb.append(" AND ");
                sb.append("token");
                sb.append(" = '");
                sb.append(str2);
                sb.append("'");
                StringBuffer stringBuffer = new StringBuffer(sb.toString());
                if (!z) {
                    stringBuffer.append(" AND automatic_data=0");
                }
                writableDatabase.delete(name, stringBuffer.toString(), null);
            } catch (SQLiteException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not clean sent Mixpanel records from ");
                sb2.append(name);
                sb2.append(". Re-initializing database.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", sb2.toString(), e);
                MPDatabaseHelper mPDatabaseHelper = this.getAuthRequestContext;
                mPDatabaseHelper.close();
                mPDatabaseHelper.getAuthRequestContext.delete();
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown exception. Could not clean sent Mixpanel records from ");
                sb3.append(name);
                sb3.append(".Re-initializing database.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", sb3.toString(), e2);
                MPDatabaseHelper mPDatabaseHelper2 = this.getAuthRequestContext;
                mPDatabaseHelper2.close();
                mPDatabaseHelper2.getAuthRequestContext.delete();
            }
            this.getAuthRequestContext.close();
        } catch (Throwable th) {
            this.getAuthRequestContext.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void BuiltInFictitiousFunctionClassFactory(long j, Table table) {
        String name = table.getName();
        try {
            try {
                SQLiteDatabase writableDatabase = this.getAuthRequestContext.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("created_at <= ");
                sb.append(j);
                writableDatabase.delete(name, sb.toString(), null);
            } catch (SQLiteException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not clean timed-out Mixpanel records from ");
                sb2.append(name);
                sb2.append(". Re-initializing database.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", sb2.toString(), e);
                MPDatabaseHelper mPDatabaseHelper = this.getAuthRequestContext;
                mPDatabaseHelper.close();
                mPDatabaseHelper.getAuthRequestContext.delete();
            }
            this.getAuthRequestContext.close();
        } catch (Throwable th) {
            this.getAuthRequestContext.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Table table, String str) {
        String name = table.getName();
        try {
            try {
                SQLiteDatabase writableDatabase = this.getAuthRequestContext.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("token = '");
                sb.append(str);
                sb.append("'");
                writableDatabase.delete(name, sb.toString(), null);
            } catch (SQLiteException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not clean timed-out Mixpanel records from ");
                sb2.append(name);
                sb2.append(". Re-initializing database.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", sb2.toString(), e);
                MPDatabaseHelper mPDatabaseHelper = this.getAuthRequestContext;
                mPDatabaseHelper.close();
                mPDatabaseHelper.getAuthRequestContext.delete();
            }
            this.getAuthRequestContext.close();
        } catch (Throwable th) {
            this.getAuthRequestContext.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public final void PlaceComponentResult(Table table, String str) {
        String name = table.getName();
        try {
            try {
                SQLiteDatabase writableDatabase = this.getAuthRequestContext.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("automatic_data = 1 AND token = '");
                sb.append(str);
                sb.append("'");
                writableDatabase.delete(name, sb.toString(), null);
            } catch (SQLiteException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not clean automatic Mixpanel records from ");
                sb2.append(name);
                sb2.append(". Re-initializing database.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Database", sb2.toString(), e);
                MPDatabaseHelper mPDatabaseHelper = this.getAuthRequestContext;
                mPDatabaseHelper.close();
                mPDatabaseHelper.getAuthRequestContext.delete();
            }
            this.getAuthRequestContext.close();
        } catch (Throwable th) {
            this.getAuthRequestContext.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] getAuthRequestContext(com.mixpanel.android.mpmetrics.MPDbAdapter.Table r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MPDbAdapter.getAuthRequestContext(com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String, boolean):java.lang.String[]");
    }

    private boolean lookAheadTest() {
        return this.getAuthRequestContext.PlaceComponentResult();
    }
}
