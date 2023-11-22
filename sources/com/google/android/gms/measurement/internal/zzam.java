package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.PointF;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzns;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes7.dex */
public final class zzam extends zzkn {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;
    private static final String[] zza;
    private static final String[] zzb;
    private static final String[] zzc;
    private static final String[] zzd;
    private static final String[] zze;
    private static final String[] zzg;
    private static final String[] zzh;
    private static final String[] zzi;
    private final zzal zzj;
    private final zzkj zzk;

    static {
        MyBillsEntityDataFactory();
        zza = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
        zzb = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
        Object[] objArr = new Object[1];
        a(new char[]{6, 65529, '\n', 65523, 4, 4, 65525, 2, 3, 65533, 7}, TextUtils.lastIndexOf("", '0', 0) + 277, 11 - TextUtils.getOffsetAfter("", 0), true, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 7, objArr);
        zzc = new String[]{((String) objArr[0]).intern(), "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
        zzd = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
        zze = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
        zzg = new String[]{"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzh = new String[]{"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzi = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'Y' : 'E') != 'Y') {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    public zzam(zzkz zzkzVar) {
        super(zzkzVar);
        try {
            this.zzk = new zzkj(this.zzs.zzav());
            this.zzs.zzf();
            this.zzj = new zzal(this, this.zzs.zzau(), "google_app_measurement.db");
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = 269894797;
    }

    public static /* bridge */ /* synthetic */ String[] zzM() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                String[] strArr = zzi;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return strArr;
                }
                return strArr;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* bridge */ /* synthetic */ String[] zzN() {
        int i = getAuthRequestContext + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String[] strArr = zzc;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return strArr;
    }

    public static /* bridge */ /* synthetic */ String[] zzO() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String[] strArr = zza;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 92 / 0;
            return strArr;
        }
        return strArr;
    }

    public static /* bridge */ /* synthetic */ String[] zzP() {
        int i = getAuthRequestContext + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String[] strArr = zzg;
        int i3 = getAuthRequestContext + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return strArr;
        }
        return strArr;
    }

    public static /* synthetic */ String[] zzQ() {
        String[] strArr;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '4' : '=') != '=') {
            strArr = zzh;
            int i2 = 35 / 0;
        } else {
            strArr = zzh;
        }
        try {
            int i3 = getAuthRequestContext + 9;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? 'H' : '\f') != '\f') {
                Object obj = null;
                obj.hashCode();
                return strArr;
            }
            return strArr;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* bridge */ /* synthetic */ String[] zzR() {
        int i = getAuthRequestContext + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return zze;
        }
        String[] strArr = zze;
        Object[] objArr = null;
        int length = objArr.length;
        return strArr;
    }

    public static /* bridge */ /* synthetic */ String[] zzS() {
        int i = getAuthRequestContext + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 20 : (char) 28) != 28) {
            String[] strArr = zzd;
            Object[] objArr = null;
            int length = objArr.length;
            return strArr;
        }
        return zzd;
    }

    public static /* bridge */ /* synthetic */ String[] zzT() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String[] strArr = zzb;
        int i3 = getAuthRequestContext + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0050  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzZ(java.lang.String r5, java.lang.String[] r6) {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.zzh()
            r1 = 0
            android.database.Cursor r6 = r0.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            boolean r0 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2e
            if (r0 == 0) goto L24
            r0 = 0
            long r0 = r6.getLong(r0)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2e
            if (r6 == 0) goto L23
            r6.close()
            int r5 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 57
            int r6 = r5 % 128
            com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r6
            int r5 = r5 % 2
        L23:
            return r0
        L24:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2e
            java.lang.String r2 = "Database returned empty set"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2e
            throw r0     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2e
        L2c:
            r5 = move-exception
            goto L45
        L2e:
            r0 = move-exception
            goto L35
        L30:
            r5 = move-exception
            r6 = r1
            goto L45
        L33:
            r0 = move-exception
            r6 = r1
        L35:
            com.google.android.gms.measurement.internal.zzfy r2 = r4.zzs     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "Database error"
            r2.zzc(r3, r5, r0)     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.lang.Throwable -> L2c
        L45:
            r0 = 77
            if (r6 == 0) goto L4c
            r2 = 77
            goto L4e
        L4c:
            r2 = 42
        L4e:
            if (r2 != r0) goto L70
            int r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r0 = r0 + 117
            int r2 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            r2 = 50
            if (r0 == 0) goto L61
            r0 = 50
            goto L63
        L61:
            r0 = 40
        L63:
            if (r0 == r2) goto L69
            r6.close()
            goto L70
        L69:
            r6.close()
            int r6 = r1.length     // Catch: java.lang.Throwable -> L6e
            goto L70
        L6e:
            r5 = move-exception
            throw r5
        L70:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzZ(java.lang.String, java.lang.String[]):long");
    }

    public static /* bridge */ /* synthetic */ zzkj zzo(zzam zzamVar) {
        try {
            int i = getAuthRequestContext + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            zzkj zzkjVar = zzamVar.zzk;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return zzkjVar;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:362:0x01fc, code lost:
    
        r9 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0208, code lost:
    
        if (r9.hasNext() == false) goto L538;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x020a, code lost:
    
        r10 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 23;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0214, code lost:
    
        if ((r10 % 2) == 0) goto L547;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0216, code lost:
    
        r11 = 28 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0226, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzes) r9.next()).zzj() != false) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0228, code lost:
    
        r10 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x022b, code lost:
    
        r10 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x022d, code lost:
    
        if (r10 == 'A') goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x023a, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzes) r9.next()).zzj() != false) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x023c, code lost:
    
        r22.zzs.zzay().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzeo.zzn(r23), java.lang.Integer.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0255, code lost:
    
        r9 = r0.zzg().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0261, code lost:
    
        if (r9.hasNext() == false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0263, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0265, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0270, code lost:
    
        if (r10 == false) goto L553;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0272, code lost:
    
        r10 = (com.google.android.gms.internal.measurement.zzej) r9.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x028c, code lost:
    
        if (r10.zzg().isEmpty() == false) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x028e, code lost:
    
        r0 = r22.zzs.zzay().zzk();
        r9 = com.google.android.gms.measurement.internal.zzeo.zzn(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x02a0, code lost:
    
        if (r10.zzp() == false) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x02a2, code lost:
    
        r10 = java.lang.Integer.valueOf(r10.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x02ab, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x02ac, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, java.lang.Integer.valueOf(r8), java.lang.String.valueOf(r10));
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x02c1, code lost:
    
        r3 = r10.zzbv();
        r19 = r6;
        r6 = new android.content.ContentValues();
        r6.put("app_id", r23);
        r6.put("audience_id", java.lang.Integer.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x02da, code lost:
    
        if (r10.zzp() == false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x02dc, code lost:
    
        r11 = java.lang.Integer.valueOf(r10.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x02e5, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x02e6, code lost:
    
        r6.put("filter_id", r11);
        r6.put("event_name", r10.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x02f6, code lost:
    
        if (r10.zzq() == false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x02f8, code lost:
    
        r10 = java.lang.Boolean.valueOf(r10.zzn());
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0301, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0302, code lost:
    
        r6.put("session_scoped", r10);
        r6.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0316, code lost:
    
        if (zzh().insertWithOnConflict("event_filters", null, r6, 5) != (-1)) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0318, code lost:
    
        r22.zzs.zzay().zzd().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzeo.zzn(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x032b, code lost:
    
        r6 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0331, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0332, code lost:
    
        r22.zzs.zzay().zzd().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0347, code lost:
    
        r19 = r6;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0355, code lost:
    
        if (r0.hasNext() == false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0357, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0359, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x035b, code lost:
    
        if (r3 == true) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x0361, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzes) r0.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x037b, code lost:
    
        if (r3.zze().isEmpty() == false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x037d, code lost:
    
        r0 = r22.zzs.zzay().zzk();
        r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x038f, code lost:
    
        if (r3.zzj() == false) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0391, code lost:
    
        r3 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x039a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x039b, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r6, java.lang.Integer.valueOf(r8), java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x03aa, code lost:
    
        r6 = r3.zzbv();
        r9 = new android.content.ContentValues();
        r9.put("app_id", r23);
        r9.put("audience_id", java.lang.Integer.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x03c1, code lost:
    
        if (r3.zzj() == false) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x03c3, code lost:
    
        r10 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x03cc, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x03cd, code lost:
    
        r9.put("filter_id", r10);
        r21 = r0;
        r9.put("property_name", r3.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x03df, code lost:
    
        if (r3.zzk() == false) goto L428;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x03e1, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x03ea, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x03eb, code lost:
    
        r9.put("session_scoped", r0);
        r9.put("data", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x03ff, code lost:
    
        if (zzh().insertWithOnConflict("property_filters", null, r9, 5) != (-1)) goto L444;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0401, code lost:
    
        r0 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x040d, code lost:
    
        if ((r0 % 2) != 0) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x040f, code lost:
    
        r22.zzs.zzay().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzeo.zzn(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0423, code lost:
    
        r12 = 69 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0426, code lost:
    
        r22.zzs.zzay().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzeo.zzn(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x043a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x043c, code lost:
    
        r0 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0442, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0444, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0449, code lost:
    
        r22.zzs.zzay().zzd().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x045c, code lost:
    
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        r0 = zzh();
        r13 = r20;
        r0.delete("property_filters", r13, new java.lang.String[]{r23, java.lang.String.valueOf(r8)});
        r0.delete("event_filters", r13, new java.lang.String[]{r23, java.lang.String.valueOf(r8)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x04c5, code lost:
    
        r20 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x04c9, code lost:
    
        r6 = r19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzB(java.lang.String r23, java.util.List r24) {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzB(java.lang.String, java.util.List):void");
    }

    public final void zzC() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            try {
                zzW();
                zzh().setTransactionSuccessful();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        zzW();
        zzh().setTransactionSuccessful();
        int i2 = 78 / 0;
    }

    public final void zzD(zzh zzhVar) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzW();
        String zzt = zzhVar.zzt();
        Preconditions.checkNotNull(zzt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzt);
        contentValues.put("app_instance_id", zzhVar.zzu());
        contentValues.put("gmp_app_id", zzhVar.zzy());
        contentValues.put("resettable_device_id_hash", zzhVar.zzA());
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzo()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzn()));
        Object[] objArr = new Object[1];
        a(new char[]{6, 65529, '\n', 65523, 4, 4, 65525, 2, 3, 65533, 7}, View.getDefaultSize(0, 0) + 276, 10 - TextUtils.lastIndexOf("", '0'), true, View.combineMeasuredStates(0, 0) + 7, objArr);
        contentValues.put(((String) objArr[0]).intern(), zzhVar.zzw());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzm()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("day", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzg()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzf()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzd()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzc()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzl()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzb()));
        contentValues.put("firebase_instance_id", zzhVar.zzx());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zze()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("health_monitor_sample", zzhVar.zzz());
        zzhVar.zza();
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzah()));
        contentValues.put("admob_app_id", zzhVar.zzr());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzk()));
        contentValues.put("session_stitching_token", zzhVar.zzB());
        List zzC = zzhVar.zzC();
        if ((zzC != null ? '7' : 'S') == '7') {
            if (zzC.isEmpty()) {
                this.zzs.zzay().zzk().zzb("Safelisted events should not be an empty list. appId", zzt);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzC));
            }
        }
        zzns.zzc();
        Object obj = null;
        if (this.zzs.zzf().zzs(null, zzeb.zzai)) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (!contentValues.containsKey("safelisted_events")) {
                int i3 = getAuthRequestContext + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                contentValues.put("safelisted_events", (String) null);
                if (i4 != 0) {
                    int i5 = 55 / 0;
                }
                int i6 = getAuthRequestContext + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
            }
        }
        try {
            SQLiteDatabase zzh2 = zzh();
            String[] strArr = {zzt};
            a(new char[]{3, 3, 6, 65524}, 277 - ExpandableListView.getPackedPositionGroup(0L), 4 - (ViewConfiguration.getWindowTouchSlop() >> 8), false, Process.getGidForName("") + 4, new Object[1]);
            if (zzh2.update(((String) r10[0]).intern(), contentValues, "app_id = ?", strArr) == 0) {
                Object[] objArr2 = new Object[1];
                a(new char[]{3, 3, 6, 65524}, 278 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), View.getDefaultSize(0, 0) + 4, false, 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr2);
                if (zzh2.insertWithOnConflict(((String) objArr2[0]).intern(), null, contentValues, 5) == -1) {
                    int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                    getAuthRequestContext = i8 % 128;
                    if (i8 % 2 == 0) {
                        this.zzs.zzay().zzd().zzb("Failed to insert/update app (got -1). appId", zzeo.zzn(zzt));
                        obj.hashCode();
                    } else {
                        this.zzs.zzay().zzd().zzb("Failed to insert/update app (got -1). appId", zzeo.zzn(zzt));
                    }
                    int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
                    getAuthRequestContext = i9 % 128;
                    int i10 = i9 % 2;
                }
            }
        } catch (SQLiteException e) {
            this.zzs.zzay().zzd().zzc("Error storing app. appId", zzeo.zzn(zzt), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0 A[Catch: SQLiteException -> 0x00c6, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00c6, blocks: (B:39:0x0099, B:44:0x00b0), top: B:49:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzE(com.google.android.gms.measurement.internal.zzas r7) {
        /*
            r6 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            r6.zzg()
            r6.zzW()
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = r7.zza
            java.lang.String r2 = "app_id"
            r0.put(r2, r1)
            java.lang.String r1 = r7.zzb
            java.lang.String r2 = "name"
            r0.put(r2, r1)
            long r1 = r7.zzc
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "lifetime_count"
            r0.put(r2, r1)
            long r1 = r7.zzd
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "current_bundle_count"
            r0.put(r2, r1)
            long r1 = r7.zzf
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "last_fire_timestamp"
            r0.put(r2, r1)
            long r1 = r7.zzg
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "last_bundled_timestamp"
            r0.put(r2, r1)
            java.lang.Long r1 = r7.zzh
            java.lang.String r2 = "last_bundled_day"
            r0.put(r2, r1)
            java.lang.Long r1 = r7.zzi
            java.lang.String r2 = "last_sampled_complex_event_id"
            r0.put(r2, r1)
            java.lang.Long r1 = r7.zzj
            java.lang.String r2 = "last_sampling_rate"
            r0.put(r2, r1)
            long r1 = r7.zze
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "current_session_count"
            r0.put(r2, r1)
            java.lang.Boolean r1 = r7.zzk
            r2 = 0
            r3 = 2
            if (r1 == 0) goto L8a
            int r4 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r4 = r4 + 19
            int r5 = r4 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % r3
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L7f
            r1 = 0
            goto L80
        L7f:
            r1 = 1
        L80:
            if (r1 == 0) goto L83
            goto L8a
        L83:
            r4 = 1
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            goto L94
        L8a:
            int r1 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r1 = r1 + 7
            int r4 = r1 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r1 = r1 % r3
            r1 = r2
        L94:
            java.lang.String r4 = "last_exempt_from_sampling"
            r0.put(r4, r1)
            android.database.sqlite.SQLiteDatabase r1 = r6.zzh()     // Catch: android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r4 = "events"
            r5 = 5
            long r0 = r1.insertWithOnConflict(r4, r2, r0, r5)     // Catch: android.database.sqlite.SQLiteException -> Lc6
            r4 = -1
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto Lad
            r0 = 97
            goto Lae
        Lad:
            r0 = 2
        Lae:
            if (r0 == r3) goto Lc5
            com.google.android.gms.measurement.internal.zzfy r0 = r6.zzs     // Catch: android.database.sqlite.SQLiteException -> Lc6
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()     // Catch: android.database.sqlite.SQLiteException -> Lc6
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r1 = r7.zza     // Catch: android.database.sqlite.SQLiteException -> Lc6
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzeo.zzn(r1)     // Catch: android.database.sqlite.SQLiteException -> Lc6
            java.lang.String r2 = "Failed to insert/update event aggregates (got -1). appId"
            r0.zzb(r2, r1)     // Catch: android.database.sqlite.SQLiteException -> Lc6
        Lc5:
            return
        Lc6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfy r1 = r6.zzs
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzem r1 = r1.zzd()
            java.lang.String r7 = r7.zza
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeo.zzn(r7)
            java.lang.String r2 = "Error storing event aggregates. appId"
            r1.zzc(r2, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzE(com.google.android.gms.measurement.internal.zzas):void");
    }

    public final boolean zzF() {
        try {
            if ((zzZ("select count(1) > 0 from raw_events", null) != 0 ? '6' : '[') != '[') {
                int i = getAuthRequestContext + 109;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x001e, code lost:
    
        if (zzZ("select count(1) > 0 from queue where has_realtime = 1", null) != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0032, code lost:
    
        if ((zzZ("select count(1) > 0 from queue where has_realtime = 1", null) != 1 ? '(' : 22) != 22) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
    
        r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 11;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 9;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0048, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0049, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzG() {
        /*
            r8 = this;
            int r0 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            java.lang.String r4 = "select count(1) > 0 from queue where has_realtime = 1"
            if (r0 == r2) goto L21
            long r3 = r8.zzZ(r4, r3)
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L49
            goto L34
        L21:
            long r3 = r8.zzZ(r4, r3)
            r5 = 1
            r0 = 22
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L30
            r3 = 40
            goto L32
        L30:
            r3 = 22
        L32:
            if (r3 == r0) goto L49
        L34:
            int r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            int r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return r2
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzG():boolean");
    }

    public final boolean zzH() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (!(zzZ("select count(1) > 0 from raw_events where realtime = 1", null) == 0)) {
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                } catch (Exception e) {
                    throw e;
                }
            }
            return false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final boolean zzJ(String str, Long l, long j, com.google.android.gms.internal.measurement.zzfs zzfsVar) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzfsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbv = zzfsVar.zzbv();
        this.zzs.zzay().zzj().zzc("Saving complex main event, appId, data size", this.zzs.zzj().zzd(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbv);
        boolean z = false;
        try {
            if ((zzh().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1 ? (char) 27 : (char) 16) != 16) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                getAuthRequestContext = i % 128;
                if (i % 2 == 0) {
                    this.zzs.zzay().zzd().zzb("Failed to insert complex main event (got -1). appId", zzeo.zzn(str));
                    z = true;
                } else {
                    this.zzs.zzay().zzd().zzb("Failed to insert complex main event (got -1). appId", zzeo.zzn(str));
                }
                int i2 = getAuthRequestContext + 73;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return z;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzs.zzay().zzd().zzc("Error storing complex main event. appId", zzeo.zzn(str), e);
            return false;
        }
    }

    public final boolean zzL(zzle zzleVar) {
        Preconditions.checkNotNull(zzleVar);
        zzg();
        zzW();
        if ((zzp(zzleVar.zza, zzleVar.zzc) == null ? Typography.greater : '5') != '5') {
            if (zzlh.zzai(zzleVar.zzc)) {
                int i = getAuthRequestContext + 57;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzleVar.zza}) >= this.zzs.zzf().zzf(zzleVar.zza, zzeb.zzF, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzleVar.zzc)) {
                try {
                    long zzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzleVar.zza, zzleVar.zzb});
                    this.zzs.zzf();
                    if (zzZ >= 25) {
                        return false;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzleVar.zza);
        contentValues.put("origin", zzleVar.zzb);
        contentValues.put("name", zzleVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzleVar.zzd));
        zzV(contentValues, "value", zzleVar.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                int i3 = getAuthRequestContext + 5;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                this.zzs.zzay().zzd().zzb("Failed to insert/update user property (got -1). appId", zzeo.zzn(zzleVar.zza));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzay().zzd().zzc("Error storing user property. appId", zzeo.zzn(zzleVar.zza), e2);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:451:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzU(java.lang.String r23, long r24, long r26, com.google.android.gms.measurement.internal.zzkw r28) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzU(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzkw):void");
    }

    public final int zza(String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            int delete = zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return delete;
        } catch (SQLiteException e) {
            this.zzs.zzay().zzd().zzd("Error deleting conditional property", zzeo.zzn(str), this.zzs.zzj().zzf(str2), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        getAuthRequestContext = i % 128;
        return i % 2 == 0 ? false : false;
    }

    public final long zzc(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh2 = zzh();
        zzh2.beginTransaction();
        long j = 0;
        try {
            try {
                try {
                    long zzaa = zzaa("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                    if (zzaa == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        Object obj = null;
                        if ((zzh2.insertWithOnConflict("app2", null, contentValues, 5) == -1 ? (char) 7 : '(') == 7) {
                            this.zzs.zzay().zzd().zzc("Failed to insert column (got -1). appId", zzeo.zzn(str), "first_open_count");
                            zzh2.endTransaction();
                            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                            getAuthRequestContext = i % 128;
                            if ((i % 2 == 0 ? '_' : (char) 18) != 18) {
                                obj.hashCode();
                                return -1L;
                            }
                            return -1L;
                        }
                        zzaa = 0;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put("first_open_count", Long.valueOf(1 + zzaa));
                        if (((long) zzh2.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                            this.zzs.zzay().zzd().zzc("Failed to update column (got 0). appId", zzeo.zzn(str), "first_open_count");
                            return -1L;
                        }
                        zzh2.setTransactionSuccessful();
                        zzh2.endTransaction();
                        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
                        getAuthRequestContext = i2 % 128;
                        int i3 = i2 % 2;
                        return zzaa;
                    } catch (SQLiteException e) {
                        e = e;
                        j = zzaa;
                        this.zzs.zzay().zzd().zzd("Error inserting column. appId", zzeo.zzn(str), "first_open_count", e);
                        zzh2.endTransaction();
                        return j;
                    }
                } finally {
                    zzh2.endTransaction();
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public final long zzd() {
        long zzaa;
        int i = getAuthRequestContext + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            zzaa = zzaa("select max(bundle_end_timestamp) from queue", null, 1L);
        } else {
            try {
                zzaa = zzaa("select max(bundle_end_timestamp) from queue", null, 0L);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        getAuthRequestContext = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return zzaa;
        }
        int i3 = 17 / 0;
        return zzaa;
    }

    public final long zze() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Object obj = null;
        long zzaa = zzaa("select max(timestamp) from raw_events", null, 0L);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'U' : (char) 23) != 23) {
                obj.hashCode();
                return zzaa;
            }
            return zzaa;
        } catch (Exception e) {
            throw e;
        }
    }

    public final long zzf(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Preconditions.checkNotEmpty(str);
        long zzaa = zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return zzaa;
    }

    public final SQLiteDatabase zzh() {
        SQLiteDatabase writableDatabase;
        int i = getAuthRequestContext + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object obj = null;
        try {
            if ((i % 2 != 0 ? (char) 27 : (char) 30) != 30) {
                zzg();
                writableDatabase = this.zzj.getWritableDatabase();
                obj.hashCode();
            } else {
                zzg();
                writableDatabase = this.zzj.getWritableDatabase();
            }
            int i2 = getAuthRequestContext + 15;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if ((i2 % 2 != 0 ? ')' : (char) 2) != 2) {
                obj.hashCode();
                return writableDatabase;
            }
            return writableDatabase;
        } catch (SQLiteException e) {
            this.zzs.zzay().zzk().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x0129, code lost:
    
        if (r1 != null) goto L177;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0157: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:197:0x0157 */
    /* JADX WARN: Removed duplicated region for block: B:199:0x015a  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzi(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzi(java.lang.String):android.os.Bundle");
    }

    public final zzak zzl(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        long j2;
        boolean z6;
        boolean z7;
        boolean z8;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            j2 = 1;
            z6 = false;
            z7 = false;
            z8 = false;
        } else {
            j2 = 1;
            z6 = true;
            z7 = true;
            z8 = true;
        }
        zzak zzm = zzm(j, str, j2, z6, z7, z3, z8, z5);
        try {
            int i2 = getAuthRequestContext + 35;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 3 : '5') != '5') {
                int i3 = 32 / 0;
                return zzm;
            }
            return zzm;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzak zzm(long r25, java.lang.String r27, long r28, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzm(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzak");
    }

    /* JADX WARN: Removed duplicated region for block: B:224:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzas zzn(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzn(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzas");
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00e4: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:130:0x00e4 */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzle zzp(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzp(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzle");
    }

    public final List zzs(String str, String str2, String str3) {
        try {
            Preconditions.checkNotEmpty(str);
            zzg();
            zzW();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
                sb.append(" and origin=?");
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            }
            if (!(TextUtils.isEmpty(str3))) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                arrayList.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0060, code lost:
    
        r2 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0069, code lost:
    
        r2 = r26.zzs.zzay().zzd();
        r26.zzs.zzf();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0142 A[LOOP:0: B:94:0x004e->B:119:0x0142, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0145 A[EDGE_INSN: B:170:0x0145->B:120:0x0145 BREAK  A[LOOP:0: B:94:0x004e->B:119:0x0142], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzt(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzt(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List zzu(String str) {
        try {
            Preconditions.checkNotEmpty(str);
            zzg();
            zzW();
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    this.zzs.zzf();
                    Cursor query = zzh().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                    try {
                        if (!query.moveToFirst()) {
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                        do {
                            String string = query.getString(0);
                            String string2 = query.getString(1);
                            if (string2 == null) {
                                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                                getAuthRequestContext = i % 128;
                                if (i % 2 == 0) {
                                    cursor.hashCode();
                                }
                                string2 = "";
                            }
                            String str2 = string2;
                            long j = query.getLong(2);
                            Object zzq = zzq(query, 3);
                            if (zzq == null) {
                                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                                getAuthRequestContext = i2 % 128;
                                int i3 = i2 % 2;
                                this.zzs.zzay().zzd().zzb("Read invalid user property value, ignoring it. appId", zzeo.zzn(str));
                            } else {
                                arrayList.add(new zzle(str, str2, string, j, zzq));
                            }
                        } while ((!query.moveToNext() ? Typography.amp : ']') == ']');
                        if (query != null) {
                            query.close();
                            int i4 = getAuthRequestContext + 89;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                            int i5 = i4 % 2;
                        }
                        return arrayList;
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = query;
                        this.zzs.zzay().zzd().zzc("Error querying user properties. appId", zzeo.zzn(str), e);
                        List emptyList = Collections.emptyList();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return emptyList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (!(cursor == null)) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00a1, code lost:
    
        if (r4 != null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00a7, code lost:
    
        if (r4 != null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00a9, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00ac, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00c1, code lost:
    
        r0 = r23.zzs.zzay().zzd();
        r23.zzs.zzf();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00d9, code lost:
    
        r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 77;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzv(java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzv(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzx() {
        int i = getAuthRequestContext + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 4 : '9') != 4) {
            try {
                zzW();
                zzh().endTransaction();
            } catch (Exception e) {
                throw e;
            }
        } else {
            zzW();
            zzh().endTransaction();
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? '+' : 'S') != '+') {
            return;
        }
        int i3 = 84 / 0;
    }

    public final void zzz() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            zzg();
            zzW();
            if (zzI()) {
                long zza2 = this.zzf.zzs().zza.zza();
                long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
                long abs = Math.abs(elapsedRealtime - zza2);
                this.zzs.zzf();
                if (!(abs <= ((Long) zzeb.zzx.zza(null)).longValue())) {
                    this.zzf.zzs().zza.zzb(elapsedRealtime);
                    zzg();
                    zzW();
                    if (zzI()) {
                        SQLiteDatabase zzh2 = zzh();
                        this.zzs.zzf();
                        int delete = zzh2.delete(SemanticAttributes.MessagingDestinationKindValues.QUEUE, "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzs.zzav().currentTimeMillis()), String.valueOf(zzag.zzA())});
                        if (delete > 0) {
                            int i3 = getAuthRequestContext + 83;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                            this.zzs.zzay().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                            try {
                                int i5 = getAuthRequestContext + 89;
                                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                                int i6 = i5 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void zzw() {
        int i = getAuthRequestContext + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        zzW();
        zzh().beginTransaction();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? '_' : 'Z') != 'Z') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    protected final boolean zzI() {
        int i = getAuthRequestContext + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            try {
                Context zzau = this.zzs.zzau();
                this.zzs.zzf();
                boolean exists = zzau.getDatabasePath("google_app_measurement.db").exists();
                int i3 = getAuthRequestContext + 113;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return exists;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x004a, code lost:
    
        r2 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 59;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0054, code lost:
    
        if ((r2 % 2) == 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0056, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0059, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x005d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0060, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0061, code lost:
    
        if (r0 == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0063, code lost:
    
        r1 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext + 65;
        com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x006e, code lost:
    
        if ((r1 % 2) == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0070, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0071, code lost:
    
        if (r2 == true) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0073, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0077, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x007a, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x007e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0028, code lost:
    
        if ((r0.moveToFirst() ? '/' : 'O') != 'O') goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0042, code lost:
    
        if (r0.moveToFirst() != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0044, code lost:
    
        r1 = r0.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0048, code lost:
    
        if (r0 == 0) goto L108;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00a3  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzr() {
        /*
            r5 = this;
            int r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L36
            android.database.sqlite.SQLiteDatabase r0 = r5.zzh()
            android.database.Cursor r0 = r0.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L34
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2f
            r4 = 24
            int r4 = r4 / r2
            r4 = 79
            if (r1 == 0) goto L26
            r1 = 47
            goto L28
        L26:
            r1 = 79
        L28:
            if (r1 == r4) goto L61
            goto L44
        L2b:
            r1 = move-exception
            r3 = r0
            goto La0
        L2f:
            r1 = move-exception
            goto L81
        L31:
            r0 = move-exception
            goto La1
        L34:
            r0 = move-exception
            goto L7f
        L36:
            android.database.sqlite.SQLiteDatabase r0 = r5.zzh()     // Catch: java.lang.Exception -> La7
            android.database.Cursor r0 = r0.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L34
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2f
            if (r1 == 0) goto L61
        L44:
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2f
            if (r0 == 0) goto L60
            int r2 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r2 = r2 + 59
            int r4 = r2 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % 2
            if (r2 == 0) goto L5d
            r0.close()
            int r0 = r3.length     // Catch: java.lang.Throwable -> L5b
            goto L60
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            r0.close()
        L60:
            return r1
        L61:
            if (r0 == 0) goto L7e
            int r1 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r1 = r1 + 65
            int r4 = r1 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r1 = r1 % 2
            r4 = 1
            if (r1 == 0) goto L71
            r2 = 1
        L71:
            if (r2 == r4) goto L77
            r0.close()
            goto L7e
        L77:
            r0.close()
            int r0 = r3.length     // Catch: java.lang.Throwable -> L7c
            goto L7e
        L7c:
            r0 = move-exception
            throw r0
        L7e:
            return r3
        L7f:
            r1 = r0
            r0 = r3
        L81:
            com.google.android.gms.measurement.internal.zzfy r2 = r5.zzs     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzay()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzd()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = "Database error getting next bundle app id"
            r2.zzb(r4, r1)     // Catch: java.lang.Throwable -> L2b
            r1 = 86
            if (r0 == 0) goto L97
            r2 = 86
            goto L99
        L97:
            r2 = 30
        L99:
            if (r2 == r1) goto L9c
            goto L9f
        L9c:
            r0.close()
        L9f:
            return r3
        La0:
            r0 = r1
        La1:
            if (r3 == 0) goto La6
            r3.close()
        La6:
            throw r0
        La7:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzr():java.lang.String");
    }

    public final void zzA(String str, String str2) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotEmpty(str2);
            zzg();
            zzW();
            try {
                zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } catch (SQLiteException e) {
                this.zzs.zzay().zzd().zzd("Error deleting user property. appId", zzeo.zzn(str), this.zzs.zzj().zzf(str2), e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static final void zzV(ContentValues contentValues, String str, Object obj) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Preconditions.checkNotEmpty("value");
            Preconditions.checkNotNull(obj);
            if (obj instanceof String) {
                contentValues.put("value", (String) obj);
                return;
            }
            if (!(!(obj instanceof Long))) {
                contentValues.put("value", (Long) obj);
                int i3 = getAuthRequestContext + 51;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            if (obj instanceof Double) {
                int i5 = getAuthRequestContext + 11;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                boolean z = i5 % 2 != 0;
                contentValues.put("value", (Double) obj);
                if (z) {
                    int i6 = 28 / 0;
                    return;
                }
                return;
            }
            try {
                throw new IllegalArgumentException("Invalid value type");
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final long zzaa(String str, String[] strArr, long j) {
        int i = getAuthRequestContext + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = zzh().rawQuery(str, strArr);
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            int i3 = getAuthRequestContext + 9;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                            cursor.close();
                        }
                        return j;
                    }
                    long j2 = cursor.getLong(0);
                    if (cursor != null) {
                        cursor.close();
                        int i5 = getAuthRequestContext + 23;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                    }
                    return j2;
                } catch (SQLiteException e) {
                    this.zzs.zzay().zzd().zzc("Database error", str, e);
                    throw e;
                }
            } catch (Throwable th) {
                if ((cursor != null ? '\'' : '#') != '#') {
                    cursor.close();
                    int i7 = getAuthRequestContext + 103;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                    int i8 = i7 % 2;
                }
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0177  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzac zzk(java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0039, code lost:
    
        if ((r0 != 0 ? '-' : 'D') != 'D') goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.Object zzq(android.database.Cursor r6, int r7) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 32
            if (r0 == 0) goto L11
            r0 = 32
            goto L12
        L11:
            r0 = 7
        L12:
            r3 = 0
            if (r0 == r2) goto L29
            int r0 = r6.getType(r7)     // Catch: java.lang.Exception -> L26
            r2 = 11
            if (r0 == 0) goto L20
            r4 = 11
            goto L22
        L20:
            r4 = 26
        L22:
            if (r4 == r2) goto L3b
            goto La4
        L26:
            r6 = move-exception
            goto Lc7
        L29:
            int r0 = r6.getType(r7)     // Catch: java.lang.Exception -> L26
            r3.hashCode()     // Catch: java.lang.Throwable -> Lc5
            r2 = 68
            if (r0 == 0) goto L37
            r4 = 45
            goto L39
        L37:
            r4 = 68
        L39:
            if (r4 == r2) goto La4
        L3b:
            r2 = 1
            if (r0 == r2) goto L9b
            r2 = 77
            if (r0 == r1) goto L45
            r4 = 77
            goto L46
        L45:
            r4 = 2
        L46:
            if (r4 == r2) goto L51
            double r6 = r6.getDouble(r7)     // Catch: java.lang.Exception -> L26
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch: java.lang.Exception -> L26
            return r6
        L51:
            int r2 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r2 = r2 + 51
            int r4 = r2 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % r1
            r2 = 3
            if (r0 == r2) goto L8d
            r6 = 4
            r7 = 8
            if (r0 == r6) goto L65
            r6 = 84
            goto L67
        L65:
            r6 = 8
        L67:
            if (r6 == r7) goto L7d
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzd()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = "Loaded invalid unknown value type, ignoring it"
            r6.zzb(r0, r7)
            return r3
        L7d:
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzd()
            java.lang.String r7 = "Loaded invalid blob type value, ignoring it"
            r6.zza(r7)
            return r3
        L8d:
            java.lang.String r6 = r6.getString(r7)     // Catch: java.lang.Exception -> L26
            int r7 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 81
            int r0 = r7 % 128
            com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r0
            int r7 = r7 % r1
            return r6
        L9b:
            long r6 = r6.getLong(r7)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            return r6
        La4:
            com.google.android.gms.measurement.internal.zzfy r6 = r5.zzs
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzd()
            java.lang.String r7 = "Loaded invalid null value from database"
            r6.zza(r7)
            int r6 = com.google.android.gms.measurement.internal.zzam.getAuthRequestContext
            int r6 = r6 + 97
            int r7 = r6 % 128
            com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % r1
            if (r6 == 0) goto Lc4
            r3.hashCode()     // Catch: java.lang.Throwable -> Lc2
            return r3
        Lc2:
            r6 = move-exception
            throw r6
        Lc4:
            return r3
        Lc5:
            r6 = move-exception
            throw r6
        Lc7:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzq(android.database.Cursor, int):java.lang.Object");
    }

    public final void zzy(List list) {
        int i = getAuthRequestContext + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? '#' : (char) 27) != 27) {
            zzg();
            zzW();
            Preconditions.checkNotNull(list);
            Preconditions.checkNotZero(list.size());
            boolean zzI = zzI();
            int length = objArr.length;
            if (!zzI) {
                return;
            }
        } else {
            zzg();
            zzW();
            Preconditions.checkNotNull(list);
            Preconditions.checkNotZero(list.size());
            if (!zzI()) {
                return;
            }
        }
        String str = "(" + TextUtils.join(",", list) + ")";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
        sb.append(str);
        sb.append(" AND retry_count =  2147483647 LIMIT 1");
        if ((zzZ(sb.toString(), null) > 0 ? '6' : 'R') != 'R') {
            try {
                int i2 = getAuthRequestContext + 61;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if ((i2 % 2 != 0 ? 'G' : (char) 0) != 0) {
                    this.zzs.zzay().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
                    int i3 = 95 / 0;
                } else {
                    this.zzs.zzay().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
                }
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
        } catch (SQLiteException e2) {
            this.zzs.zzay().zzd().zzb("Error incrementing retry count. error", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0048, code lost:
    
        if (r7 < 1000) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005a, code lost:
    
        if (r7 < 1000) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005c, code lost:
    
        r1 = com.google.android.gms.measurement.internal.zzam.KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        com.google.android.gms.measurement.internal.zzam.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0067, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzK(com.google.android.gms.measurement.internal.zzac r10) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzK(com.google.android.gms.measurement.internal.zzac):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0211, code lost:
    
        if (r5.getInt(10) != 0) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0266 A[Catch: SQLiteException -> 0x0344, all -> 0x0365, TryCatch #1 {SQLiteException -> 0x0344, blocks: (B:94:0x0172, B:103:0x018e, B:112:0x0204, B:120:0x0221, B:124:0x026b, B:126:0x029a, B:135:0x02b6, B:139:0x02d2, B:141:0x02dd, B:142:0x02ef, B:144:0x0301, B:145:0x030a, B:151:0x0321, B:138:0x02cd, B:123:0x0266, B:115:0x020b), top: B:173:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x029a A[Catch: SQLiteException -> 0x0344, all -> 0x0365, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0344, blocks: (B:94:0x0172, B:103:0x018e, B:112:0x0204, B:120:0x0221, B:124:0x026b, B:126:0x029a, B:135:0x02b6, B:139:0x02d2, B:141:0x02dd, B:142:0x02ef, B:144:0x0301, B:145:0x030a, B:151:0x0321, B:138:0x02cd, B:123:0x0266, B:115:0x020b), top: B:173:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02cd A[Catch: SQLiteException -> 0x0344, all -> 0x0365, TryCatch #1 {SQLiteException -> 0x0344, blocks: (B:94:0x0172, B:103:0x018e, B:112:0x0204, B:120:0x0221, B:124:0x026b, B:126:0x029a, B:135:0x02b6, B:139:0x02d2, B:141:0x02dd, B:142:0x02ef, B:144:0x0301, B:145:0x030a, B:151:0x0321, B:138:0x02cd, B:123:0x0266, B:115:0x020b), top: B:173:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02dd A[Catch: SQLiteException -> 0x0344, all -> 0x0365, TryCatch #1 {SQLiteException -> 0x0344, blocks: (B:94:0x0172, B:103:0x018e, B:112:0x0204, B:120:0x0221, B:124:0x026b, B:126:0x029a, B:135:0x02b6, B:139:0x02d2, B:141:0x02dd, B:142:0x02ef, B:144:0x0301, B:145:0x030a, B:151:0x0321, B:138:0x02cd, B:123:0x0266, B:115:0x020b), top: B:173:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0301 A[Catch: SQLiteException -> 0x0344, all -> 0x0365, TryCatch #1 {SQLiteException -> 0x0344, blocks: (B:94:0x0172, B:103:0x018e, B:112:0x0204, B:120:0x0221, B:124:0x026b, B:126:0x029a, B:135:0x02b6, B:139:0x02d2, B:141:0x02dd, B:142:0x02ef, B:144:0x0301, B:145:0x030a, B:151:0x0321, B:138:0x02cd, B:123:0x0266, B:115:0x020b), top: B:173:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0369  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzh zzj(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (PlaceComponentResult ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
            int i5 = $11 + 35;
            $10 = i5 % 128;
            int i6 = i5 % 2;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i7 = $10 + 117;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
            }
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                try {
                    try {
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
