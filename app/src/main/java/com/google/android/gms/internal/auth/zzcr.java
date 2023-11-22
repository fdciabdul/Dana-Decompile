package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* loaded from: classes7.dex */
public final class zzcr {
    private static final ArrayMap zza = new ArrayMap();

    public static Uri zza(String str) {
        synchronized (zzcr.class) {
            ArrayMap arrayMap = zza;
            Uri uri = (Uri) arrayMap.get("com.google.android.gms.auth_account");
            if (uri == null) {
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
                arrayMap.put("com.google.android.gms.auth_account", parse);
                return parse;
            }
            return uri;
        }
    }
}
