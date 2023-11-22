package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class zzds {
    public static final zzdr zza(InputStream inputStream, zzdu zzduVar) throws zzdl {
        try {
            return zzb(inputStream, zzduVar);
        } finally {
            try {
                zzduVar.close();
            } catch (IOException unused) {
            }
        }
    }

    private static final zzdr zzb(InputStream inputStream, zzdu zzduVar) throws zzdl {
        try {
            zzdt zzd = zzduVar.zzd();
            if (zzd != null) {
                try {
                    byte zza = zzd.zza();
                    byte zzb = zzd.zzb();
                    int i = 0;
                    if (zzb == Byte.MIN_VALUE) {
                        long zza2 = zzduVar.zza();
                        if (zza2 > 1000) {
                            throw new zzdl("Parser being asked to read a large CBOR array");
                        }
                        zzc(zza, zza2, inputStream, zzduVar);
                        zzdr[] zzdrVarArr = new zzdr[(int) zza2];
                        while (i < zza2) {
                            zzdrVarArr[i] = zzb(inputStream, zzduVar);
                            i++;
                        }
                        return new zzdi(zzaz.zzi(zzdrVarArr));
                    } else if (zzb != -96) {
                        if (zzb != -64) {
                            if (zzb != -32) {
                                if (zzb == 0 || zzb == 32) {
                                    long zzb2 = zzduVar.zzb();
                                    zzc(zza, zzb2 > 0 ? zzb2 : (-1) ^ zzb2, inputStream, zzduVar);
                                    return new zzdm(zzb2);
                                } else if (zzb == 64) {
                                    byte[] zzg = zzduVar.zzg();
                                    int length = zzg.length;
                                    zzc(zza, length, inputStream, zzduVar);
                                    return new zzdk(zzcz.zzl(zzg, 0, length));
                                } else if (zzb == 96) {
                                    String zze = zzduVar.zze();
                                    zzc(zza, zze.length(), inputStream, zzduVar);
                                    return new zzdp(zze);
                                } else {
                                    throw new zzdl("Unidentifiable major type: " + zzd.zzc());
                                }
                            }
                            return new zzdj(zzduVar.zzf());
                        }
                        throw new zzdl("Tags are currently unsupported");
                    } else {
                        long zzc = zzduVar.zzc();
                        if (zzc > 1000) {
                            throw new zzdl("Parser being asked to read a large CBOR map");
                        }
                        zzc(zza, zzc, inputStream, zzduVar);
                        int i2 = (int) zzc;
                        zzdn[] zzdnVarArr = new zzdn[i2];
                        zzdr zzdrVar = null;
                        int i3 = 0;
                        while (i3 < zzc) {
                            zzdr zzb3 = zzb(inputStream, zzduVar);
                            if (zzdrVar != null && zzb3.compareTo(zzdrVar) <= 0) {
                                throw new zzdh(String.format("Keys in CBOR Map not in strictly ascending natural order:\nPrevious key: %s\nCurrent key: %s", zzdrVar.toString(), zzb3.toString()));
                            }
                            zzdnVarArr[i3] = new zzdn(zzb3, zzb(inputStream, zzduVar));
                            i3++;
                            zzdrVar = zzb3;
                        }
                        TreeMap treeMap = new TreeMap();
                        while (i < i2) {
                            zzdn zzdnVar = zzdnVarArr[i];
                            if (!treeMap.containsKey(zzdnVar.zza())) {
                                treeMap.put(zzdnVar.zza(), zzdnVar.zzb());
                                i++;
                            } else {
                                throw new zzdh("Attempted to add duplicate key to canonical CBOR Map.");
                            }
                        }
                        return new zzdo(zzbg.zzf(treeMap));
                    }
                } catch (IOException | RuntimeException e) {
                    throw new zzdl("Error in decoding CborValue from bytes", e);
                }
            }
            throw new zzdl("Parser being asked to parse an empty input stream");
        } catch (IOException e2) {
            throw new zzdl("Error in decoding CborValue from bytes", e2);
        }
    }

    private static final void zzc(byte b, long j, InputStream inputStream, zzdu zzduVar) throws IOException {
        switch (b) {
            case 24:
                if (j >= 24) {
                    return;
                }
                throw new zzdh("Integer value " + j + " after add info could have been represented in 0 additional bytes, but used 1");
            case 25:
                if (j >= 256) {
                    return;
                }
                throw new zzdh("Integer value " + j + " after add info could have been represented in 0-1 additional bytes, but used 2");
            case 26:
                if (j >= 65536) {
                    return;
                }
                throw new zzdh("Integer value " + j + " after add info could have been represented in 0-2 additional bytes, but used 4");
            case 27:
                if (j >= 4294967296L) {
                    return;
                }
                throw new zzdh("Integer value " + j + " after add info could have been represented in 0-4 additional bytes, but used 8");
            default:
                return;
        }
    }
}
