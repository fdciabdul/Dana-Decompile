package com.google.android.gms.common.util;

import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class HttpUtils {
    private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private HttpUtils() {
    }

    public static Map<String, String> parse(URI uri, String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new HashMap<>();
            zzx zzc2 = zzx.zzc(zzo.zzb('='));
            Iterator it = zzx.zzc(zzo.zzb(Typography.amp)).zzb().zzd(rawQuery).iterator();
            while (it.hasNext()) {
                List zzf = zzc2.zzf((String) it.next());
                if (!zzf.isEmpty() && zzf.size() <= 2) {
                    emptyMap.put(zza((String) zzf.get(0), str), zzf.size() == 2 ? zza((String) zzf.get(1), str) : null);
                } else {
                    throw new IllegalArgumentException("bad parameter");
                }
            }
        }
        return emptyMap;
    }

    private static String zza(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
