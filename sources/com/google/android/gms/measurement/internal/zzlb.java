package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzlk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import o.C;

/* loaded from: classes7.dex */
public final class zzlb extends zzkn {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 46197;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 10910;
    private static char PlaceComponentResult = 10095;
    private static char getAuthRequestContext = 14835;
    private static int lookAheadTest = 1;

    public zzlb(zzkz zzkzVar) {
        super(zzkzVar);
    }

    public static final com.google.android.gms.internal.measurement.zzfw zzB(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str) {
        boolean z;
        com.google.android.gms.internal.measurement.zzfw zzfwVar;
        Iterator it = zzfsVar.zzi().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                int i = lookAheadTest + 101;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                Object obj = null;
                if (i % 2 != 0) {
                    obj.hashCode();
                    return null;
                }
                return null;
            }
            zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it.next();
            if (zzfwVar.zzg().equals(str)) {
                z = true;
            }
        } while (!z);
        int i2 = lookAheadTest + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        int i4 = lookAheadTest + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
        return zzfwVar;
    }

    private static final void zzF(StringBuilder sb, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                return;
            }
            sb.append("  ");
            i4++;
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
            lookAheadTest = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private static final String zzG(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if ((z ? (char) 22 : '6') != '6') {
            try {
                sb.append("Dynamic ");
            } catch (Exception e) {
                throw e;
            }
        }
        if (z2) {
            int i = lookAheadTest + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            sb.append("Sequence ");
        }
        if ((z3 ? (char) 18 : '2') == 18) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzH(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzgh zzghVar) {
        Integer num;
        Iterator it;
        int i2;
        Integer num2;
        if (zzghVar == null) {
            return;
        }
        zzF(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        char c = 'A';
        if ((zzghVar.zzb() != 0 ? '\t' : '`') == '\t') {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            zzF(sb, 4);
            sb.append("results: ");
            Iterator it2 = zzghVar.zzk().iterator();
            int i5 = 0;
            while (true) {
                if ((it2.hasNext() ? (char) 23 : 'A') != 23) {
                    break;
                }
                Long l = (Long) it2.next();
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i5++;
                c = 'A';
            }
            sb.append('\n');
        }
        if (zzghVar.zzd() != 0) {
            zzF(sb, 4);
            sb.append("status: ");
            int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            lookAheadTest = i6 % 128;
            int i7 = i6 % 2;
            int i8 = 0;
            for (Long l2 : zzghVar.zzn()) {
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i8++;
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                lookAheadTest = i9 % 128;
                int i10 = i9 % 2;
            }
            sb.append('\n');
        }
        Object[] objArr = null;
        if ((zzghVar.zza() != 0 ? '1' : '-') != '-') {
            int i11 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
            lookAheadTest = i11 % 128;
            if (!(i11 % 2 != 0)) {
                try {
                    zzF(sb, 3);
                    sb.append("dynamic_filter_timestamps: {");
                    it = zzghVar.zzj().iterator();
                    i2 = 1;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                zzF(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                it = zzghVar.zzj().iterator();
                i2 = 0;
            }
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfq zzfqVar = (com.google.android.gms.internal.measurement.zzfq) it.next();
                if (i2 != 0) {
                    int i12 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                    lookAheadTest = i12 % 128;
                    if (i12 % 2 == 0) {
                        sb.append(", ");
                        int i13 = 67 / 0;
                    } else {
                        sb.append(", ");
                    }
                }
                if (zzfqVar.zzh()) {
                    int i14 = lookAheadTest + 125;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i14 % 128;
                    int i15 = i14 % 2;
                    num2 = Integer.valueOf(zzfqVar.zza());
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(":");
                sb.append(zzfqVar.zzg() ? Long.valueOf(zzfqVar.zzb()) : null);
                i2++;
            }
            sb.append("}\n");
        }
        if (zzghVar.zzc() != 0) {
            zzF(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i16 = 0;
            for (com.google.android.gms.internal.measurement.zzgj zzgjVar : zzghVar.zzm()) {
                if (i16 != 0) {
                    int i17 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
                    lookAheadTest = i17 % 128;
                    if ((i17 % 2 == 0 ? 'L' : '=') != 'L') {
                        try {
                            sb.append(", ");
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        sb.append(", ");
                        int length = objArr.length;
                    }
                }
                if ((zzgjVar.zzi() ? (char) 7 : 'A') != c) {
                    int i18 = lookAheadTest + 125;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i18 % 128;
                    if (i18 % 2 != 0) {
                        num = Integer.valueOf(zzgjVar.zzb());
                        objArr.hashCode();
                    } else {
                        num = Integer.valueOf(zzgjVar.zzb());
                    }
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(": [");
                Iterator it3 = zzgjVar.zzf().iterator();
                int i19 = 0;
                while (it3.hasNext()) {
                    long longValue = ((Long) it3.next()).longValue();
                    if (!(i19 == 0)) {
                        int i20 = lookAheadTest + 125;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i20 % 128;
                        boolean z = i20 % 2 != 0;
                        sb.append(", ");
                        if (z) {
                            int i21 = 99 / 0;
                        } else {
                            continue;
                        }
                    }
                    sb.append(longValue);
                    i19++;
                }
                sb.append("]");
                i16++;
                c = 'A';
            }
            sb.append("}\n");
        }
        zzF(sb, 3);
        sb.append("}\n");
    }

    private static final void zzI(StringBuilder sb, int i, String str, Object obj) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        lookAheadTest = i2 % 128;
        Object[] objArr = null;
        if (i2 % 2 == 0) {
            int length = objArr.length;
            if (obj == null) {
                return;
            }
        } else if (obj == null) {
            return;
        }
        zzF(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
        int i3 = lookAheadTest + 27;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'E' : 'K') != 'K') {
            objArr.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x005e, code lost:
    
        if (r7 == 4) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0060, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0061, code lost:
    
        if (r0 == true) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0063, code lost:
    
        r7 = "EQUAL";
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0066, code lost:
    
        r7 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r7 % 128;
        r7 = r7 % 2;
        r7 = "BETWEEN";
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0072, code lost:
    
        r7 = "LESS_THAN";
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0075, code lost:
    
        r7 = "UNKNOWN_COMPARISON_TYPE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0035, code lost:
    
        if (r7 != 1) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x003f, code lost:
    
        if (r7 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0041, code lost:
    
        if (r7 == 2) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0044, code lost:
    
        if (r7 == 3) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0046, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0048, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0049, code lost:
    
        if (r3 == true) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x004b, code lost:
    
        r7 = "GREATER_THAN";
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x004e, code lost:
    
        r3 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0057, code lost:
    
        if ((r3 % 2) != 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x005a, code lost:
    
        if (r7 == 5) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzJ(java.lang.StringBuilder r5, int r6, java.lang.String r7, com.google.android.gms.internal.measurement.zzeq r8) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzJ(java.lang.StringBuilder, int, java.lang.String, com.google.android.gms.internal.measurement.zzeq):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0036, code lost:
    
        r3 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x003b, code lost:
    
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x003d, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0040, code lost:
    
        if ((r3 % 2) == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0042, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0048, code lost:
    
        r3 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 9;
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0052, code lost:
    
        if ((r3 % 2) == 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0054, code lost:
    
        r3 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0057, code lost:
    
        r3 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0059, code lost:
    
        if (r3 == 17) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x005b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005c, code lost:
    
        r3 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x005d, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(com.google.android.gms.internal.measurement.zzgb r3, java.lang.String r4) {
        /*
            r0 = 46
            if (r3 == 0) goto L7
            r1 = 46
            goto L9
        L7:
            r1 = 78
        L9:
            if (r1 == r0) goto Lc
            goto L1c
        Lc:
            r0 = 0
        Ld:
            int r1 = r3.zzb()     // Catch: java.lang.Exception -> L65
            r2 = 97
            if (r0 >= r1) goto L18
            r1 = 97
            goto L1a
        L18:
            r1 = 88
        L1a:
            if (r1 == r2) goto L1e
        L1c:
            r3 = -1
            return r3
        L1e:
            com.google.android.gms.internal.measurement.zzgl r1 = r3.zzao(r0)
            java.lang.String r1 = r1.zzf()
            boolean r1 = r4.equals(r1)
            r2 = 11
            if (r1 == 0) goto L30
            r1 = 3
            goto L32
        L30:
            r1 = 11
        L32:
            if (r1 == r2) goto L62
            int r3 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest     // Catch: java.lang.Exception -> L60
            r4 = 17
            int r3 = r3 + r4
            int r1 = r3 % 128
            com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L65
            int r3 = r3 % 2
            r1 = 0
            if (r3 == 0) goto L48
            r1.hashCode()     // Catch: java.lang.Throwable -> L46
            goto L48
        L46:
            r3 = move-exception
            throw r3
        L48:
            int r3 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest
            int r3 = r3 + 9
            int r2 = r3 % 128
            com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r3 = r3 % 2
            if (r3 == 0) goto L57
            r3 = 17
            goto L59
        L57:
            r3 = 81
        L59:
            if (r3 == r4) goto L5c
            return r0
        L5c:
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5e
            return r0
        L5e:
            r3 = move-exception
            throw r3
        L60:
            r3 = move-exception
            throw r3
        L62:
            int r0 = r0 + 1
            goto Ld
        L65:
            r3 = move-exception
            goto L68
        L67:
            throw r3
        L68:
            goto L67
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zza(com.google.android.gms.internal.measurement.zzgb, java.lang.String):int");
    }

    public static zzlk zzl(zzlk zzlkVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzko {
        try {
            com.google.android.gms.internal.measurement.zzjq zza = com.google.android.gms.internal.measurement.zzjq.zza();
            if (!(zza == null)) {
                int i = lookAheadTest + 59;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                zzlk zzaA = zzlkVar.zzaA(bArr, zza);
                int i3 = lookAheadTest + 119;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return zzaA;
            }
            try {
                zzlk zzaz = zzlkVar.zzaz(bArr);
                int i5 = lookAheadTest + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                return zzaz;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static List zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            int i2 = lookAheadTest + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            long j = i2 % 2 != 0 ? 1L : 0L;
            int i3 = 0;
            while (true) {
                if ((i3 < 64 ? '\t' : '!') != '!') {
                    int i4 = lookAheadTest + 59;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    int i5 = i4 % 2;
                    int i6 = (i * 64) + i3;
                    if (i6 >= bitSet.length()) {
                        break;
                    }
                    if (bitSet.get(i6)) {
                        j |= 1 << i3;
                    }
                    i3++;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static boolean zzx(String str) {
        if (str != null) {
            int i = lookAheadTest + 101;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if (str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                if (str.length() <= 310) {
                    try {
                        int i5 = lookAheadTest + 89;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        return !(i5 % 2 != 0);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        lookAheadTest = i6 % 128;
        if (i6 % 2 != 0) {
            return false;
        }
        Object obj = null;
        obj.hashCode();
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        int i = lookAheadTest + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        return false;
    }

    final Bundle zzf(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                int i = lookAheadTest + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                    try {
                        bundle.putString(str, null);
                        int i2 = 82 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    bundle.putString(str, null);
                }
            } else if (obj instanceof Long) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                lookAheadTest = i3 % 128;
                if ((i3 % 2 == 0 ? 'F' : '.') != '.') {
                    bundle.putLong(str, ((Long) obj).longValue());
                    int i4 = 83 / 0;
                } else {
                    try {
                        bundle.putLong(str, ((Long) obj).longValue());
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                lookAheadTest = i5 % 128;
                int i6 = i5 % 2;
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i7 = 0;
                while (true) {
                    if ((i7 < size ? (char) 15 : '7') == '7') {
                        break;
                    }
                    arrayList2.add(zzf((Map) arrayList.get(i7), false));
                    i7++;
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzaw zzi(com.google.android.gms.internal.measurement.zzaa r9) {
        /*
            r8 = this;
            java.util.Map r0 = r9.zze()
            r1 = 1
            android.os.Bundle r0 = r8.zzf(r0, r1)
            java.lang.String r1 = "_o"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L2a
            int r2 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest     // Catch: java.lang.Exception -> L28
            int r2 = r2 + 31
            int r3 = r2 % 128
            com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r3     // Catch: java.lang.Exception -> L26
            int r2 = r2 % 2
            java.lang.Object r1 = r0.get(r1)
            if (r1 == 0) goto L2a
            java.lang.String r1 = r1.toString()
            goto L2c
        L26:
            r9 = move-exception
            throw r9
        L28:
            r9 = move-exception
            goto L7d
        L2a:
            java.lang.String r1 = "app"
        L2c:
            r5 = r1
            java.lang.String r1 = r9.zzd()
            java.lang.String r1 = com.google.android.gms.measurement.internal.zzgv.zzb(r1)
            r2 = 44
            if (r1 != 0) goto L3c
            r3 = 44
            goto L3e
        L3c:
            r3 = 78
        L3e:
            if (r3 == r2) goto L42
        L40:
            r3 = r1
            goto L51
        L42:
            int r1 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest
            int r1 = r1 + 119
            int r2 = r1 % 128
            com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            java.lang.String r1 = r9.zzd()     // Catch: java.lang.Exception -> L28
            goto L40
        L51:
            com.google.android.gms.measurement.internal.zzaw r1 = new com.google.android.gms.measurement.internal.zzaw
            com.google.android.gms.measurement.internal.zzau r4 = new com.google.android.gms.measurement.internal.zzau
            r4.<init>(r0)
            long r6 = r9.zza()
            r2 = r1
            r2.<init>(r3, r4, r5, r6)
            int r9 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest
            int r9 = r9 + 41
            int r0 = r9 % 128
            com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r9 = r9 % 2
            r0 = 60
            if (r9 == 0) goto L71
            r9 = 60
            goto L73
        L71:
            r9 = 34
        L73:
            if (r9 == r0) goto L76
            return r1
        L76:
            r9 = 52
            int r9 = r9 / 0
            return r1
        L7b:
            r9 = move-exception
            throw r9
        L7d:
            goto L7f
        L7e:
            throw r9
        L7f:
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzi(com.google.android.gms.internal.measurement.zzaa):com.google.android.gms.measurement.internal.zzaw");
    }

    public final com.google.android.gms.internal.measurement.zzfs zzj(zzar zzarVar) {
        com.google.android.gms.internal.measurement.zzfr zze = com.google.android.gms.internal.measurement.zzfs.zze();
        zze.zzl(zzarVar.zze);
        zzat zzatVar = new zzat(zzarVar.zzf);
        int i = lookAheadTest + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        while (true) {
            if ((zzatVar.hasNext() ? ',' : (char) 5) == ',') {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                String next = zzatVar.next();
                com.google.android.gms.internal.measurement.zzfv zze2 = com.google.android.gms.internal.measurement.zzfw.zze();
                zze2.zzj(next);
                Object zzf = zzarVar.zzf.zzf(next);
                Preconditions.checkNotNull(zzf);
                zzt(zze2, zzf);
                zze.zze(zze2);
            } else {
                return (com.google.android.gms.internal.measurement.zzfs) zze.zzaE();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:220:0x0043, code lost:
    
        if (r4.zzbj() != false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0050, code lost:
    
        if (r4.zzbj() != false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0052, code lost:
    
        zzI(r2, 1, "protocol_version", java.lang.Integer.valueOf(r4.zzd()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x005f, code lost:
    
        com.google.android.gms.internal.measurement.zzoz.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x006f, code lost:
    
        if (r17.zzs.zzf().zzs(null, com.google.android.gms.measurement.internal.zzeb.zzar) == false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0075, code lost:
    
        if (r4.zzbm() == false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0077, code lost:
    
        zzI(r2, 1, "session_stitching_token", r4.zzK());
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0080, code lost:
    
        zzI(r2, 1, com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, r4.zzI());
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x008f, code lost:
    
        if (r4.zzbf() == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0091, code lost:
    
        r6 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0094, code lost:
    
        r6 = '(';
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0096, code lost:
    
        if (r6 == '4') goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0099, code lost:
    
        zzI(r2, 1, "gmp_version", java.lang.Long.valueOf(r4.zzm()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x00aa, code lost:
    
        if (r4.zzbq() == false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x00ac, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 19;
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x00b7, code lost:
    
        if ((r6 % 2) == 0) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x00b9, code lost:
    
        zzI(r2, 0, "uploading_gmp_version", java.lang.Long.valueOf(r4.zzr()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x00c5, code lost:
    
        zzI(r2, 1, "uploading_gmp_version", java.lang.Long.valueOf(r4.zzr()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x00d4, code lost:
    
        if (r4.zzbd() == false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x00d6, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r6 % 128;
        r6 = r6 % 2;
        zzI(r2, 1, "dynamite_version", java.lang.Long.valueOf(r4.zzj()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x00f0, code lost:
    
        if (r4.zzba() == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x00f2, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r6 % 128;
        r6 = r6 % 2;
        zzI(r2, 1, "config_version", java.lang.Long.valueOf(r4.zzh()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0108, code lost:
    
        zzI(r2, 1, "gmp_app_id", r4.zzF());
        zzI(r2, 1, "admob_app_id", r4.zzw());
        zzI(r2, 1, "app_id", r4.zzx());
        r6 = r4.zzA();
        r14 = new java.lang.Object[1];
        a(11 - android.text.TextUtils.indexOf("", "", 0, 0), new char[]{61783, 36323, 40611, 3638, 31979, 42716, 32420, 40842, 22294, 17649, 54549, 20357}, r14);
        zzI(r2, 1, ((java.lang.String) r14[0]).intern(), r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x014a, code lost:
    
        if (r4.zzaY() == false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x014c, code lost:
    
        zzI(r2, 1, "app_version_major", java.lang.Integer.valueOf(r4.zza()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0159, code lost:
    
        zzI(r2, 1, "firebase_instance_id", r4.zzE());
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0166, code lost:
    
        if (r4.zzbc() == false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0168, code lost:
    
        zzI(r2, 1, "dev_cert_hash", java.lang.Long.valueOf(r4.zzi()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0175, code lost:
    
        zzI(r2, 1, "app_store", r4.zzz());
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0182, code lost:
    
        if (r4.zzbp() == false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0184, code lost:
    
        zzI(r2, 1, "upload_timestamp_millis", java.lang.Long.valueOf(r4.zzq()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0195, code lost:
    
        if (r4.zzbn() == false) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0197, code lost:
    
        zzI(r2, 1, "start_timestamp_millis", java.lang.Long.valueOf(r4.zzp()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x01a8, code lost:
    
        if (r4.zzbe() == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x01aa, code lost:
    
        zzI(r2, 1, "end_timestamp_millis", java.lang.Long.valueOf(r4.zzk()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x01bb, code lost:
    
        if (r4.zzbi() == false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x01bd, code lost:
    
        zzI(r2, 1, "previous_bundle_start_timestamp_millis", java.lang.Long.valueOf(r4.zzo()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x01ce, code lost:
    
        if (r4.zzbh() == false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x01d0, code lost:
    
        zzI(r2, 1, "previous_bundle_end_timestamp_millis", java.lang.Long.valueOf(r4.zzn()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x01dd, code lost:
    
        zzI(r2, 1, "app_instance_id", r4.zzy());
        zzI(r2, 1, "resettable_device_id", r4.zzJ());
        zzI(r2, 1, "ds_id", r4.zzD());
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x01fe, code lost:
    
        if (r4.zzbg() == false) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0200, code lost:
    
        r6 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0203, code lost:
    
        r6 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0205, code lost:
    
        if (r6 == '_') goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0207, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 1;
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
        r6 = r6 % 2;
        zzI(r2, 1, "limited_ad_tracking", java.lang.Boolean.valueOf(r4.zzaW()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x021c, code lost:
    
        zzI(r2, 1, "os_version", r4.zzH());
        zzI(r2, 1, "device_model", r4.zzC());
        zzI(r2, 1, "user_default_language", r4.zzL());
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x023b, code lost:
    
        if (r4.zzbo() == false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x023d, code lost:
    
        zzI(r2, 1, "time_zone_offset_minutes", java.lang.Integer.valueOf(r4.zzf()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x024e, code lost:
    
        if (r4.zzaZ() == false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0250, code lost:
    
        zzI(r2, 1, "bundle_sequential_index", java.lang.Integer.valueOf(r4.zzb()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0261, code lost:
    
        if (r4.zzbl() == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0263, code lost:
    
        zzI(r2, 1, "service_upload", java.lang.Boolean.valueOf(r4.zzaX()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0270, code lost:
    
        zzI(r2, 1, "health_monitor", r4.zzG());
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x027d, code lost:
    
        if (r4.zzbk() == false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x027f, code lost:
    
        zzI(r2, 1, "retry_counter", java.lang.Integer.valueOf(r4.zze()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0290, code lost:
    
        if (r4.zzbb() == false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0292, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0294, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0297, code lost:
    
        if (r6 == true) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0299, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x02a3, code lost:
    
        if ((r6 % 2) != 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x02a5, code lost:
    
        r6 = r4.zzB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x02aa, code lost:
    
        r6 = r4.zzB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x02ae, code lost:
    
        zzI(r2, 1, "consent_signals", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x02b1, code lost:
    
        r6 = r4.zzO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x02b9, code lost:
    
        if (r6 != null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x02bc, code lost:
    
        r6 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x02c4, code lost:
    
        if (r6.hasNext() == false) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x02c6, code lost:
    
        r15 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x02c8, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x02c9, code lost:
    
        if (r15 == r10) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x02cb, code lost:
    
        r6 = r4.zzM();
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x02cf, code lost:
    
        if (r6 != null) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x02d2, code lost:
    
        r6 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x02da, code lost:
    
        if (r6.hasNext() == false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x02dc, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.zzfo) r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x02e2, code lost:
    
        if (r8 == null) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x02e4, code lost:
    
        zzF(r2, 2);
        r2.append("audience_membership {\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x02f0, code lost:
    
        if (r8.zzk() == false) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x02f2, code lost:
    
        zzI(r2, 2, "audience_id", java.lang.Integer.valueOf(r8.zza()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0305, code lost:
    
        if (r8.zzm() == false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0307, code lost:
    
        r11 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x030a, code lost:
    
        r11 = 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x030c, code lost:
    
        if (r11 == 23) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x030e, code lost:
    
        r11 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r11 % 128;
        r11 = r11 % 2;
        zzI(r2, 2, "new_audience", java.lang.Boolean.valueOf(r8.zzj()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0324, code lost:
    
        zzH(r2, 2, "current_data", r8.zzd());
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0331, code lost:
    
        if (r8.zzn() == false) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0333, code lost:
    
        zzH(r2, 2, "previous_data", r8.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x033c, code lost:
    
        zzF(r2, 2);
        r2.append("}\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0343, code lost:
    
        r4 = r4.zzN();
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0347, code lost:
    
        if (r4 != null) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x034b, code lost:
    
        r4 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0353, code lost:
    
        if (r4.hasNext() == false) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0355, code lost:
    
        r6 = (com.google.android.gms.internal.measurement.zzfs) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x035b, code lost:
    
        if (r6 == null) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x035d, code lost:
    
        r8 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r8 % 128;
        r8 = r8 % 2;
        zzF(r2, 2);
        r2.append("event {\n");
        zzI(r2, 2, "name", r17.zzs.zzj().zzd(r6.zzh()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0383, code lost:
    
        if (r6.zzu() == false) goto L340;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0385, code lost:
    
        zzI(r2, 2, "timestamp_millis", java.lang.Long.valueOf(r6.zzd()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0396, code lost:
    
        if (r6.zzt() == false) goto L347;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0398, code lost:
    
        r8 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 87;
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x03a2, code lost:
    
        if ((r8 % 2) == 0) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x03a4, code lost:
    
        r15 = r6.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x03a9, code lost:
    
        r15 = r6.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x03ad, code lost:
    
        zzI(r2, 2, "previous_timestamp_millis", java.lang.Long.valueOf(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x03ba, code lost:
    
        if (r6.zzs() == false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x03bc, code lost:
    
        r8 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x03bf, code lost:
    
        r8 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x03c1, code lost:
    
        if (r8 == 'J') goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x03c3, code lost:
    
        zzI(r2, 2, "count", java.lang.Integer.valueOf(r6.zza()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x03d4, code lost:
    
        if (r6.zzb() == 0) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x03d6, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x03d8, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x03d9, code lost:
    
        if (r8 == r10) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x03dc, code lost:
    
        zzD(r2, 2, r6.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x03e3, code lost:
    
        zzF(r2, 2);
        r2.append("}\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x03eb, code lost:
    
        zzF(r2, r10);
        r2.append("}\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x03f3, code lost:
    
        r15 = (com.google.android.gms.internal.measurement.zzgl) r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x03f9, code lost:
    
        if (r15 == null) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x03fb, code lost:
    
        r8 = com.google.android.gms.measurement.internal.zzlb.lookAheadTest + 105;
        com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0406, code lost:
    
        if ((r8 % 2) == 0) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0408, code lost:
    
        r8 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x040b, code lost:
    
        r8 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x040f, code lost:
    
        if (r8 == 'Z') goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0411, code lost:
    
        zzF(r2, 2);
        r2.append("user_property {\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x041b, code lost:
    
        if (r15.zzs() == false) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x041e, code lost:
    
        zzF(r2, 2);
        r2.append("user_property {\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0428, code lost:
    
        if (r15.zzs() == false) goto L376;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x042a, code lost:
    
        r8 = 'a';
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x042d, code lost:
    
        r8 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x042f, code lost:
    
        if (r8 == 'W') goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0431, code lost:
    
        r8 = java.lang.Long.valueOf(r15.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x043a, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x043b, code lost:
    
        zzI(r2, 2, "set_timestamp_millis", r8);
        zzI(r2, 2, "name", r17.zzs.zzj().zzf(r15.zzf()));
        zzI(r2, 2, "string_value", r15.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0460, code lost:
    
        if (r15.zzr() == false) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0462, code lost:
    
        r8 = ']';
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0465, code lost:
    
        r8 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0467, code lost:
    
        if (r8 == ']') goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0469, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x046b, code lost:
    
        r8 = java.lang.Long.valueOf(r15.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0473, code lost:
    
        zzI(r2, 2, "int_value", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x047c, code lost:
    
        if (r15.zzq() == false) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x047e, code lost:
    
        r8 = java.lang.Double.valueOf(r15.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0487, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0488, code lost:
    
        zzI(r2, 2, "double_value", r8);
        zzF(r2, 2);
        r2.append("}\n");
        r10 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzm(com.google.android.gms.internal.measurement.zzga r18) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzm(com.google.android.gms.internal.measurement.zzga):java.lang.String");
    }

    public final String zzo(com.google.android.gms.internal.measurement.zzej zzejVar) {
        if (zzejVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzejVar.zzp()) {
            int i = lookAheadTest + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            zzI(sb, 0, "filter_id", Integer.valueOf(zzejVar.zzb()));
        }
        try {
            zzI(sb, 0, "event_name", this.zzs.zzj().zzd(zzejVar.zzg()));
            String zzG = zzG(zzejVar.zzk(), zzejVar.zzm(), zzejVar.zzn());
            if ((!zzG.isEmpty() ? (char) 23 : '*') != '*') {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                zzI(sb, 0, "filter_type", zzG);
            }
            if (zzejVar.zzo()) {
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                lookAheadTest = i5 % 128;
                if (i5 % 2 == 0) {
                }
                zzJ(sb, 1, "event_count_filter", zzejVar.zzf());
            }
            if (!(zzejVar.zza() <= 0)) {
                int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                lookAheadTest = i6 % 128;
                int i7 = i6 % 2;
                sb.append("  filters {\n");
                Iterator it = zzejVar.zzh().iterator();
                while (it.hasNext()) {
                    int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                    lookAheadTest = i8 % 128;
                    if (i8 % 2 == 0) {
                        zzE(sb, 3, (com.google.android.gms.internal.measurement.zzel) it.next());
                    } else {
                        zzE(sb, 2, (com.google.android.gms.internal.measurement.zzel) it.next());
                    }
                }
            }
            zzF(sb, 1);
            sb.append("}\n}\n");
            return sb.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    public final List zzq(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzs.zzay().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (!(intValue < arrayList.size())) {
                    this.zzs.zzay().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        int i4 = lookAheadTest + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            int i6 = size2;
            i = size;
            size = i6;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public final Map zzs(Bundle bundle, boolean z) {
        Parcelable parcelable;
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (!z2 && !(obj instanceof ArrayList)) {
                if (obj instanceof Bundle) {
                    int i = lookAheadTest + 79;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                } else if (obj != null) {
                    hashMap.put(str, obj);
                }
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                if ((z2 ? (char) 23 : (char) 16) != 16) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    int length = parcelableArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                        lookAheadTest = i4 % 128;
                        if (i4 % 2 == 0) {
                            parcelable = parcelableArr[i3];
                            boolean z3 = parcelable instanceof Bundle;
                            Object obj2 = null;
                            obj2.hashCode();
                            try {
                                try {
                                    if (!(z3)) {
                                        continue;
                                    }
                                    arrayList.add(zzs((Bundle) parcelable, false));
                                } catch (Exception e) {
                                    throw e;
                                }
                            } catch (Exception e2) {
                                throw e2;
                            }
                        } else {
                            parcelable = parcelableArr[i3];
                            if (!(parcelable instanceof Bundle)) {
                                continue;
                            }
                            arrayList.add(zzs((Bundle) parcelable, false));
                        }
                    }
                } else if (obj instanceof ArrayList) {
                    int i5 = lookAheadTest + 83;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                    ArrayList arrayList2 = (ArrayList) obj;
                    int size = arrayList2.size();
                    int i7 = 0;
                    while (true) {
                        if ((i7 < size ? 'B' : 'G') == 'G') {
                            break;
                        }
                        Object obj3 = arrayList2.get(i7);
                        if (obj3 instanceof Bundle) {
                            arrayList.add(zzs((Bundle) obj3, false));
                            int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                            lookAheadTest = i8 % 128;
                            int i9 = i8 % 2;
                        }
                        i7++;
                    }
                } else if (obj instanceof Bundle) {
                    int i10 = lookAheadTest + 79;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                    int i11 = i10 % 2;
                    arrayList.add(zzs((Bundle) obj, false));
                }
                hashMap.put(str, arrayList);
            } else {
                continue;
            }
        }
        return hashMap;
    }

    public final void zzu(com.google.android.gms.internal.measurement.zzgk zzgkVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgkVar.zzc();
        zzgkVar.zzb();
        zzgkVar.zza();
        if (obj instanceof String) {
            zzgkVar.zzh((String) obj);
            return;
        }
        try {
            if ((obj instanceof Long ? '\f' : 'A') == '\f') {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
                lookAheadTest = i % 128;
                if (i % 2 != 0) {
                    zzgkVar.zze(((Long) obj).longValue());
                    return;
                }
                zzgkVar.zze(((Long) obj).longValue());
                int i2 = 41 / 0;
                return;
            }
            if (!(obj instanceof Double)) {
                try {
                    this.zzs.zzay().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = lookAheadTest + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            zzgkVar.zzd(((Double) obj).doubleValue());
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final byte[] zzy(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int i = lookAheadTest + 77;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return byteArray;
        } catch (IOException e) {
            this.zzs.zzay().zzd().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    public static boolean zzv(List list, int i) {
        try {
            int i2 = lookAheadTest + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            if ((i < list.size() * 64 ? (char) 20 : '2') == 20) {
                int i4 = lookAheadTest + 29;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                if ((((Long) list.get(i / 64)).longValue() & (1 << (i % 64))) != 0) {
                    return true;
                }
            }
            try {
                int i6 = lookAheadTest + 45;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                if (i6 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return false;
                }
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String zzp(com.google.android.gms.internal.measurement.zzes zzesVar) {
        int i = lookAheadTest + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (!(zzesVar == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nproperty_filter {\n");
            if (zzesVar.zzj()) {
                zzI(sb, 0, "filter_id", Integer.valueOf(zzesVar.zza()));
            }
            zzI(sb, 0, "property_name", this.zzs.zzj().zzf(zzesVar.zze()));
            String zzG = zzG(zzesVar.zzg(), zzesVar.zzh(), zzesVar.zzi());
            if (!zzG.isEmpty()) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                lookAheadTest = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    zzI(sb, 1, "filter_type", zzG);
                } else {
                    try {
                        zzI(sb, 0, "filter_type", zzG);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            try {
                zzE(sb, 1, zzesVar.zzb());
                sb.append("}\n");
                return sb.toString();
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i4 = lookAheadTest + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        int i5 = i4 % 2;
        return "null";
    }

    public final boolean zzw(long j, long j2) {
        try {
            int i = lookAheadTest + 125;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if (j != 0) {
                if ((j2 > 0 ? (char) 3 : 'J') != 3) {
                    return true;
                }
                int i3 = lookAheadTest + 95;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                return (i3 % 2 != 0 ? ')' : JSONLexer.EOI) != ')' ? Math.abs(this.zzs.zzav().currentTimeMillis() - j) > j2 : Math.abs(this.zzs.zzav().currentTimeMillis() % j) > j2;
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final boolean zzA(zzaw zzawVar, zzq zzqVar) {
        int i = lookAheadTest + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotNull(zzqVar);
        Object[] objArr = null;
        if (TextUtils.isEmpty(zzqVar.zzb)) {
            int i3 = lookAheadTest + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? '\t' : 'O') != 'O') {
                boolean isEmpty = TextUtils.isEmpty(zzqVar.zzq);
                int length = objArr.length;
                if ((isEmpty ? ']' : (char) 27) != 27) {
                    return false;
                }
            } else if (TextUtils.isEmpty(zzqVar.zzq)) {
                return false;
            }
        }
        int i4 = lookAheadTest + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 != 0) {
            int length2 = objArr.length;
            return true;
        }
        return true;
    }

    public static final Object zzC(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        com.google.android.gms.internal.measurement.zzfw zzB = zzB(zzfsVar, str);
        Object obj = null;
        if (zzB != null) {
            try {
                if (zzB.zzy()) {
                    return zzB.zzh();
                }
                if (zzB.zzw()) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
                    lookAheadTest = i3 % 128;
                    int i4 = i3 % 2;
                    return Long.valueOf(zzB.zzd());
                } else if (zzB.zzu()) {
                    int i5 = lookAheadTest + 19;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                    return Double.valueOf(zzB.zza());
                } else if (zzB.zzc() > 0) {
                    List zzi = zzB.zzi();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = zzi.iterator();
                    while (true) {
                        if ((it.hasNext() ? '!' : '#') == '#') {
                            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
                        }
                        com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it.next();
                        if (zzfwVar != null) {
                            Bundle bundle = new Bundle();
                            Iterator it2 = zzfwVar.zzi().iterator();
                            while (true) {
                                if ((it2.hasNext() ? 'V' : '9') != 'V') {
                                    break;
                                }
                                try {
                                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
                                    lookAheadTest = i7 % 128;
                                    int i8 = i7 % 2;
                                    com.google.android.gms.internal.measurement.zzfw zzfwVar2 = (com.google.android.gms.internal.measurement.zzfw) it2.next();
                                    if (zzfwVar2.zzy()) {
                                        int i9 = lookAheadTest + 109;
                                        KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
                                        if ((i9 % 2 != 0 ? (char) 21 : '3') != 21) {
                                            bundle.putString(zzfwVar2.zzg(), zzfwVar2.zzh());
                                        } else {
                                            bundle.putString(zzfwVar2.zzg(), zzfwVar2.zzh());
                                            obj.hashCode();
                                        }
                                    } else if (zzfwVar2.zzw()) {
                                        bundle.putLong(zzfwVar2.zzg(), zzfwVar2.zzd());
                                    } else {
                                        if (zzfwVar2.zzu()) {
                                            bundle.putDouble(zzfwVar2.zzg(), zzfwVar2.zza());
                                        }
                                    }
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            if (!bundle.isEmpty()) {
                                arrayList.add(bundle);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return null;
    }

    public static final void zzz(com.google.android.gms.internal.measurement.zzfr zzfrVar, String str, Object obj) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            List zzp = zzfrVar.zzp();
            int i3 = 0;
            int i4 = lookAheadTest + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
            while (true) {
                if (i3 >= zzp.size()) {
                    i3 = -1;
                    break;
                } else if (str.equals(((com.google.android.gms.internal.measurement.zzfw) zzp.get(i3)).zzg())) {
                    break;
                } else {
                    i3++;
                }
            }
            com.google.android.gms.internal.measurement.zzfv zze = com.google.android.gms.internal.measurement.zzfw.zze();
            zze.zzj(str);
            if (obj instanceof Long) {
                zze.zzi(((Long) obj).longValue());
                int i6 = lookAheadTest + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
            }
            if ((i3 >= 0 ? '[' : 'A') == '[') {
                int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                try {
                    lookAheadTest = i8 % 128;
                    int i9 = i8 % 2;
                    zzfrVar.zzj(i3, zze);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            zzfrVar.zze(zze);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void zzD(StringBuilder sb, int i, List list) {
        String str;
        Long valueOf;
        try {
            int i2 = lookAheadTest + 15;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            if (list == null) {
                return;
            }
            int i4 = i + 1;
            Iterator it = list.iterator();
            int i5 = lookAheadTest + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            while (true) {
                if (!it.hasNext()) {
                    return;
                }
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                lookAheadTest = i7 % 128;
                int i8 = i7 % 2;
                com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it.next();
                if (zzfwVar != null) {
                    zzF(sb, i4);
                    sb.append("param {\n");
                    Object[] objArr = null;
                    zzI(sb, i4, "name", zzfwVar.zzx() ? this.zzs.zzj().zze(zzfwVar.zzg()) : null);
                    if (!(!zzfwVar.zzy())) {
                        int i9 = lookAheadTest + 59;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i9 % 128;
                        int i10 = i9 % 2;
                        str = zzfwVar.zzh();
                    } else {
                        str = null;
                    }
                    zzI(sb, i4, "string_value", str);
                    if (!zzfwVar.zzw()) {
                        valueOf = null;
                    } else {
                        int i11 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                        lookAheadTest = i11 % 128;
                        int i12 = i11 % 2;
                        valueOf = Long.valueOf(zzfwVar.zzd());
                    }
                    zzI(sb, i4, "int_value", valueOf);
                    zzI(sb, i4, "double_value", zzfwVar.zzu() ? Double.valueOf(zzfwVar.zza()) : null);
                    if (!(zzfwVar.zzc() <= 0)) {
                        int i13 = lookAheadTest + 103;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i13 % 128;
                        if (i13 % 2 != 0) {
                            zzD(sb, i4, zzfwVar.zzi());
                            int length = objArr.length;
                        } else {
                            zzD(sb, i4, zzfwVar.zzi());
                        }
                    }
                    zzF(sb, i4);
                    sb.append("}\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final Parcelable zzh(byte[] bArr, Parcelable.Creator creator) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if (bArr == null) {
            int i3 = lookAheadTest + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 35 / 0;
            }
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                Parcelable parcelable = (Parcelable) creator.createFromParcel(obtain);
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                lookAheadTest = i5 % 128;
                if ((i5 % 2 == 0 ? 'I' : '%') != 'I') {
                    return parcelable;
                }
                int i6 = 3 / 0;
                return parcelable;
            } catch (SafeParcelReader.ParseException unused) {
                this.zzs.zzay().zzd().zza("Failed to load parcelable from buffer");
                return null;
            } finally {
                obtain.recycle();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final long zzd(byte[] bArr) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Preconditions.checkNotNull(bArr);
        this.zzs.zzv().zzg();
        MessageDigest zzF = zzlh.zzF();
        if (zzF == null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            try {
                try {
                    this.zzs.zzay().zzd().zza("Failed to get MD5");
                    return 0L;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return zzlh.zzp(zzF.digest(bArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzE(java.lang.StringBuilder r9, int r10, com.google.android.gms.internal.measurement.zzel r11) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzE(java.lang.StringBuilder, int, com.google.android.gms.internal.measurement.zzel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x003c, code lost:
    
        if ((!(r15 instanceof java.lang.String)) != true) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x003e, code lost:
    
        r14.zzk((java.lang.String) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0046, code lost:
    
        if ((r15 instanceof java.lang.Long) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0048, code lost:
    
        r14.zzi(((java.lang.Long) r15).longValue());
        r14 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r14 % 128;
        r14 = r14 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x005e, code lost:
    
        if ((r15 instanceof java.lang.Double) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0060, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0062, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0063, code lost:
    
        if (r0 == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0065, code lost:
    
        r14.zzh(((java.lang.Double) r15).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x006e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x006f, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0074, code lost:
    
        if ((r15 instanceof android.os.Bundle[]) == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0076, code lost:
    
        r15 = (android.os.Bundle[]) r15;
        r0 = new java.util.ArrayList();
        r4 = r15.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x007f, code lost:
    
        if (r5 >= r4) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0081, code lost:
    
        r6 = r15[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0083, code lost:
    
        if (r6 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0087, code lost:
    
        r7 = com.google.android.gms.internal.measurement.zzfw.zze();
        r8 = r6.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0097, code lost:
    
        if (r8.hasNext() == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0099, code lost:
    
        r9 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00a3, code lost:
    
        r9 = r8.next();
        r10 = com.google.android.gms.internal.measurement.zzfw.zze();
        r10.zzj(r9);
        r9 = r6.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00b6, code lost:
    
        if ((r9 instanceof java.lang.Long) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00b8, code lost:
    
        r11 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00c2, code lost:
    
        if ((r11 % 2) != 0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00c4, code lost:
    
        r10.zzi(((java.lang.Long) r9).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00cd, code lost:
    
        r9 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00d1, code lost:
    
        r10.zzi(((java.lang.Long) r9).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00dd, code lost:
    
        if ((r9 instanceof java.lang.String) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00df, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00e1, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00e2, code lost:
    
        if (r11 == true) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00e4, code lost:
    
        r10.zzk((java.lang.String) r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00ec, code lost:
    
        if ((r9 instanceof java.lang.Double) == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00ee, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00f0, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x00f1, code lost:
    
        if (r11 == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00f4, code lost:
    
        r10.zzh(((java.lang.Double) r9).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00fd, code lost:
    
        r7.zzc(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0101, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0106, code lost:
    
        if (r7.zza() <= 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0108, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzlb.KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        com.google.android.gms.measurement.internal.zzlb.lookAheadTest = r6 % 128;
        r6 = r6 % 2;
        r0.add((com.google.android.gms.internal.measurement.zzfw) r7.zzaE());
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x011b, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x011f, code lost:
    
        r14.zzb(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0122, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0123, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0124, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0125, code lost:
    
        r13.zzs.zzay().zzd().zzb("Ignoring invalid (type) event param value", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0134, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0021, code lost:
    
        if (r0 != false) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzt(com.google.android.gms.internal.measurement.zzfv r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzt(com.google.android.gms.internal.measurement.zzfv, java.lang.Object):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '-' : 'I') != 'I') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = 0;
                while (true) {
                    if (i3 < 16) {
                        int i4 = $10 + 87;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                        i2 -= 40503;
                        i3++;
                        int i6 = $11 + 39;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
