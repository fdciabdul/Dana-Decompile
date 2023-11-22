package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.parser.JSONLexer;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.text.Typography;
import o.getCallingPid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzal extends SQLiteOpenHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37311, 37308, 37294, 37310};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 42071;
    final /* synthetic */ zzam zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzam zzamVar, Context context, String str) {
        super(context, "google_app_measurement.db", (SQLiteDatabase.CursorFactory) null, 1);
        try {
            this.zza = zzamVar;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        zzam zzamVar = this.zza;
        zzkj zzo = zzam.zzo(zzamVar);
        zzamVar.zzs.zzf();
        if (!zzo.zzc(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (!(i % 2 == 0)) {
                int i2 = 90 / 0;
                return super.getWritableDatabase();
            }
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzam.zzo(this.zza).zzb();
            this.zza.zzs.zzay().zzd().zza("Opening the database failed, dropping and recreating it");
            this.zza.zzs.zzf();
            if (!this.zza.zzs.zzau().getDatabasePath("google_app_measurement.db").delete()) {
                try {
                    this.zza.zzs.zzay().zzd().zzb("Failed to delete corrupted db file", "google_app_measurement.db");
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                zzam.zzo(this.zza).zza();
                int i3 = MyBillsEntityDataFactory + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 == 0 ? 'Q' : (char) 30) != 30) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return writableDatabase;
                }
                return writableDatabase;
            } catch (SQLiteException e2) {
                this.zza.zzs.zzay().zzd().zzb("Failed to open freshly created database", e2);
                throw e2;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = MyBillsEntityDataFactory + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        int i = MyBillsEntityDataFactory + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzam.zzO());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzam.zzT());
        zzeo zzay = this.zza.zzs.zzay();
        String[] zzN = zzam.zzN();
        Object[] objArr = new Object[1];
        a(new char[]{0, 2, 1, 0}, (byte) (TextUtils.indexOf("", "") + 39), 4 - View.combineMeasuredStates(0, 0), objArr);
        zzan.zza(zzay, sQLiteDatabase, ((String) objArr[0]).intern(), "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzN);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, SemanticAttributes.MessagingDestinationKindValues.QUEUE, "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzam.zzR());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzam.zzS());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", zzam.zzP());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", zzam.zzQ());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzam.zzM());
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
        zzan.zza(this.zza.zzs.zzay(), sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = MyBillsEntityDataFactory + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = MyBillsEntityDataFactory + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? '8' : JSONLexer.EOI) != '8') {
            zzan.zzb(this.zza.zzs.zzay(), sQLiteDatabase);
        } else {
            zzan.zzb(this.zza.zzs.zzay(), sQLiteDatabase);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if ((cArr2 != null ? (char) 22 : Typography.greater) != '>') {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i4 = $11 + 99;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 28 : (char) 14) != 14) {
                i2 = i + 23;
                cArr4[i2] = (char) (cArr[i2] % b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if ((i2 <= 1 ? Typography.greater : 'c') != '>') {
            try {
                int i5 = $11 + 9;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                getcallingpid.getAuthRequestContext = 0;
                while (getcallingpid.getAuthRequestContext < i2) {
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                        } else {
                            int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        for (int i13 = 0; i13 < i; i13++) {
            cArr4[i13] = (char) (cArr4[i13] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
