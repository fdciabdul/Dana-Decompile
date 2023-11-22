package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
public final class zzhg {
    private final SimpleArrayMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(SimpleArrayMap simpleArrayMap) {
        this.zza = simpleArrayMap;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri != null) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.zza.get(uri.toString());
            if (simpleArrayMap == null) {
                return null;
            }
            return (String) simpleArrayMap.get("".concat(String.valueOf(str3)));
        }
        return null;
    }
}
