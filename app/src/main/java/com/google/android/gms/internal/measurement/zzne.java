package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public enum zzne {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzjd.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zzne(Object obj) {
        this.zzk = obj;
    }
}
