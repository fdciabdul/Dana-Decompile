package com.google.android.gms.internal.auth;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public enum zzho {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzee.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zzho(Object obj) {
        this.zzk = obj;
    }
}
