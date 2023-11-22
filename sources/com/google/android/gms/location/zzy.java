package com.google.android.gms.location;

import com.google.android.gms.common.Feature;

/* loaded from: classes3.dex */
public final class zzy {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature[] zzj;

    static {
        Feature feature = new Feature("name_ulr_private", 1L);
        zza = feature;
        Feature feature2 = new Feature("name_sleep_segment_request", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("get_last_activity_feature_id", 1L);
        zzc = feature3;
        Feature feature4 = new Feature("support_context_feature_id", 1L);
        zzd = feature4;
        Feature feature5 = new Feature("get_current_location", 2L);
        zze = feature5;
        Feature feature6 = new Feature("get_last_location_with_request", 1L);
        zzf = feature6;
        Feature feature7 = new Feature("set_mock_mode_with_callback", 1L);
        zzg = feature7;
        Feature feature8 = new Feature("set_mock_location_with_callback", 1L);
        zzh = feature8;
        Feature feature9 = new Feature("inject_location_with_callback", 1L);
        zzi = feature9;
        zzj = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9};
    }
}
