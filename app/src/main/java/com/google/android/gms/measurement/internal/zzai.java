package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class zzai {
    public static final zzai zza = new zzai(null, null);
    private final EnumMap zzb;

    public zzai(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzah.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzah.AD_STORAGE, (zzah) bool);
        enumMap.put((EnumMap) zzah.ANALYTICS_STORAGE, (zzah) bool2);
    }

    public static zzai zza(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            enumMap.put((EnumMap) zzahVar, (zzah) zzn(bundle.getString(zzahVar.zzd)));
        }
        return new zzai(enumMap);
    }

    public static zzai zzb(String str) {
        EnumMap enumMap = new EnumMap(zzah.class);
        if (str != null) {
            int i = 0;
            while (true) {
                int length = zzah.zzc.length;
                if (i >= 2) {
                    break;
                }
                zzah zzahVar = zzah.zzc[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put((EnumMap) zzahVar, (zzah) bool);
                }
                i++;
            }
        }
        return new zzai(enumMap);
    }

    public static String zzg(Bundle bundle) {
        String string;
        for (zzah zzahVar : zzah.values()) {
            if (bundle.containsKey(zzahVar.zzd) && (string = bundle.getString(zzahVar.zzd)) != null && zzn(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean zzj(int i, int i2) {
        return i <= i2;
    }

    static final int zzm(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean zzn(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzai) {
            zzai zzaiVar = (zzai) obj;
            for (zzah zzahVar : zzah.values()) {
                if (zzm((Boolean) this.zzb.get(zzahVar)) != zzm((Boolean) zzaiVar.zzb.get(zzahVar))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Iterator it = this.zzb.values().iterator();
        int i = 17;
        while (it.hasNext()) {
            i = (i * 31) + zzm((Boolean) it.next());
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        zzah[] values = zzah.values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            zzah zzahVar = values[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(zzahVar.name());
            sb.append("=");
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                sb.append(true != bool.booleanValue() ? "denied" : "granted");
            }
        }
        return sb.toString();
    }

    public final zzai zzc(zzai zzaiVar) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put((EnumMap) zzahVar, (zzah) bool);
        }
        return new zzai(enumMap);
    }

    public final zzai zzd(zzai zzaiVar) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                bool = (Boolean) zzaiVar.zzb.get(zzahVar);
            }
            enumMap.put((EnumMap) zzahVar, (zzah) bool);
        }
        return new zzai(enumMap);
    }

    public final Boolean zze() {
        return (Boolean) this.zzb.get(zzah.AD_STORAGE);
    }

    public final Boolean zzf() {
        return (Boolean) this.zzb.get(zzah.ANALYTICS_STORAGE);
    }

    public final String zzh() {
        char c;
        StringBuilder sb = new StringBuilder("G1");
        zzah[] zzahVarArr = zzah.zzc;
        int length = zzahVarArr.length;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.zzb.get(zzahVarArr[i]);
            if (bool == null) {
                c = '-';
            } else {
                c = bool.booleanValue() ? '1' : '0';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final boolean zzi(zzah zzahVar) {
        Boolean bool = (Boolean) this.zzb.get(zzahVar);
        return bool == null || bool.booleanValue();
    }

    public final boolean zzk(zzai zzaiVar) {
        return zzl(zzaiVar, (zzah[]) this.zzb.keySet().toArray(new zzah[0]));
    }

    public final boolean zzl(zzai zzaiVar, zzah... zzahVarArr) {
        for (zzah zzahVar : zzahVarArr) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (bool == Boolean.FALSE && bool2 != Boolean.FALSE) {
                return true;
            }
        }
        return false;
    }

    public zzai(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzah.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
