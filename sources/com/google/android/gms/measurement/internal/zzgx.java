package com.google.android.gms.measurement.internal;

import com.google.firebase.messaging.Constants;
import com.j256.ormlite.field.FieldType;
import id.dana.data.account.repository.source.SecuredAccountPreferences;

/* loaded from: classes7.dex */
public final class zzgx {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", SecuredAccountPreferences.Key.USER_ID, "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};
    public static final String[] zzb = {Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", FieldType.FOREIGN_ID_FIELD_SUFFIX, "_lair", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};
}
