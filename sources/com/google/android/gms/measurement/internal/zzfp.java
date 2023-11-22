package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes7.dex */
public final class zzfp extends zzkn implements zzaf {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static int getAuthRequestContext = 269894733;
    final Map zza;
    final Map zzb;
    final Map zzc;
    final LruCache zzd;
    final com.google.android.gms.internal.measurement.zzr zze;
    private final Map zzg;
    private final Map zzh;
    private final Map zzi;
    private final Map zzj;
    private final Map zzk;
    private final Map zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfp(zzkz zzkzVar) {
        super(zzkzVar);
        try {
            this.zzg = new ArrayMap();
            this.zza = new ArrayMap();
            this.zzb = new ArrayMap();
            this.zzc = new ArrayMap();
            this.zzh = new ArrayMap();
            this.zzj = new ArrayMap();
            this.zzk = new ArrayMap();
            this.zzl = new ArrayMap();
            this.zzi = new ArrayMap();
            this.zzd = new zzfm(this, 20);
            this.zze = new zzfn(this);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[LOOP:1: B:21:0x005f->B:23:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0174 A[EDGE_INSN: B:74:0x0174->B:72:0x0174 BREAK  A[LOOP:0: B:25:0x007d->B:71:0x0170], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzB(java.lang.String r14, com.google.android.gms.internal.measurement.zzfd r15) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzB(java.lang.String, com.google.android.gms.internal.measurement.zzfd):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x012c, code lost:
    
        if (r6 == null) goto L55;
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x01b6: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:62:0x01b6 */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzC(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzC(java.lang.String):void");
    }

    private final void zzD(final String str, com.google.android.gms.internal.measurement.zzfe zzfeVar) {
        if (zzfeVar.zza() == 0) {
            this.zzd.remove(str);
            return;
        }
        this.zzs.zzay().zzj().zzb("EES programs found", Integer.valueOf(zzfeVar.zza()));
        com.google.android.gms.internal.measurement.zzgs zzgsVar = (com.google.android.gms.internal.measurement.zzgs) zzfeVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.zzd("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfj
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzfo(zzfp.this, str));
                }
            });
            zzcVar.zzd("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfk
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzfp zzfpVar = zzfp.this;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfi
                        private static int $10 = 0;
                        private static int $11 = 1;
                        private static int BuiltInFictitiousFunctionClassFactory = 0;
                        private static int MyBillsEntityDataFactory = 269894663;
                        private static int getAuthRequestContext = 1;

                        /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
                        
                            if ((r0 == null) != true) goto L21;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
                        
                            if ((r0 == null) != true) goto L21;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
                        
                            r5 = com.google.android.gms.measurement.internal.zzfi.getAuthRequestContext + 3;
                            com.google.android.gms.measurement.internal.zzfi.BuiltInFictitiousFunctionClassFactory = r5 % 128;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
                        
                            if ((r5 % 2) == 0) goto L24;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
                        
                            r1 = new java.lang.Object[1];
                            a(new char[]{3, 2, 65525, 4, 4, 65523, '\n', 65529, 6, 7, 65533}, 13347 % (android.view.ViewConfiguration.getLongPressTimeout() - 90), (android.view.ViewConfiguration.getScrollDefaultDelay() >> 125) + 73, false, 4 << android.view.View.resolveSize(1, 0), r1);
                            r1 = r1[0];
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:24:0x0099, code lost:
                        
                            r1 = new java.lang.Object[1];
                            a(new char[]{3, 2, 65525, 4, 4, 65523, '\n', 65529, 6, 7, 65533}, 142 - (android.view.ViewConfiguration.getLongPressTimeout() >> 16), (android.view.ViewConfiguration.getScrollDefaultDelay() >> 16) + 11, false, android.view.View.resolveSize(0, 0) + 2, r1);
                            r1 = r1[0];
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
                        
                            r3.put(((java.lang.String) r1).intern(), r0);
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c9, code lost:
                        
                            r3.put("app_version_int", java.lang.Long.valueOf(r2.zzb()));
                            r3.put("dynamite_version", java.lang.Long.valueOf(r2.zzk()));
                         */
                        @Override // java.util.concurrent.Callable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object call() {
                            /*
                                Method dump skipped, instructions count: 273
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.call():java.lang.Object");
                        }

                        private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
                            A a2 = new A();
                            char[] cArr2 = new char[i2];
                            a2.MyBillsEntityDataFactory = 0;
                            while (true) {
                                if (a2.MyBillsEntityDataFactory >= i2) {
                                    break;
                                }
                                int i4 = $10 + 51;
                                $11 = i4 % 128;
                                int i5 = i4 % 2;
                                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                                int i6 = a2.MyBillsEntityDataFactory;
                                cArr2[i6] = (char) (cArr2[i6] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                                a2.MyBillsEntityDataFactory++;
                            }
                            if ((i3 > 0 ? 'Y' : 'M') == 'Y') {
                                int i7 = $10 + 119;
                                $11 = i7 % 128;
                                int i8 = i7 % 2;
                                a2.BuiltInFictitiousFunctionClassFactory = i3;
                                char[] cArr3 = new char[i2];
                                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                            }
                            if ((z ? 'J' : '[') == 'J') {
                                char[] cArr4 = new char[i2];
                                a2.MyBillsEntityDataFactory = 0;
                                while (true) {
                                    try {
                                        if (a2.MyBillsEntityDataFactory >= i2) {
                                            break;
                                        }
                                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                                        a2.MyBillsEntityDataFactory++;
                                    } catch (Exception e) {
                                        throw e;
                                    }
                                }
                                cArr2 = cArr4;
                            }
                            objArr[0] = new String(cArr2);
                        }
                    });
                }
            });
            zzcVar.zzd("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfl
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzt(zzfp.this.zze);
                }
            });
            zzcVar.zzc(zzgsVar);
            this.zzd.put(str, zzcVar);
            this.zzs.zzay().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgsVar.zza().zza()));
            Iterator it = zzgsVar.zza().zzd().iterator();
            while (true) {
                if (!it.hasNext()) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    return;
                }
                try {
                    int i3 = MyBillsEntityDataFactory + 21;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        this.zzs.zzay().zzj().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zzgq) it.next()).zzb());
                        int i4 = 83 / 0;
                    } else {
                        this.zzs.zzay().zzj().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zzgq) it.next()).zzb());
                    }
                } catch (Exception e) {
                    throw e;
                }
                throw e;
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.zzs.zzay().zzd().zzb("Failed to load EES program. appId", str);
        }
    }

    private static final Map zzE(com.google.android.gms.internal.measurement.zzfe zzfeVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfeVar != null) {
            Iterator it = zzfeVar.zzn().iterator();
            while (true) {
                try {
                    if (!it.hasNext()) {
                        break;
                    }
                    int i = MyBillsEntityDataFactory + 25;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    com.google.android.gms.internal.measurement.zzfi zzfiVar = (com.google.android.gms.internal.measurement.zzfi) it.next();
                    arrayMap.put(zzfiVar.zzb(), zzfiVar.zzc());
                    int i3 = MyBillsEntityDataFactory + 83;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.internal.measurement.zzc zzd(zzfp zzfpVar, String str) {
        zzfpVar.zzW();
        Preconditions.checkNotEmpty(str);
        Object[] objArr = null;
        if (zzfpVar.zzo(str)) {
            if ((zzfpVar.zzh.containsKey(str) ? (char) 4 : 'D') == 'D' || zzfpVar.zzh.get(str) == null) {
                zzfpVar.zzC(str);
            } else {
                zzfpVar.zzD(str, (com.google.android.gms.internal.measurement.zzfe) zzfpVar.zzh.get(str));
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
            }
            return (com.google.android.gms.internal.measurement.zzc) zzfpVar.zzd.snapshot().get(str);
        }
        int i3 = MyBillsEntityDataFactory + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            int length = objArr.length;
        }
        try {
            int i4 = MyBillsEntityDataFactory + 39;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map zzj(zzfp zzfpVar) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 != 0 ? 'b' : (char) 25;
        Map map = zzfpVar.zzg;
        if (c == 'b') {
            Object obj = null;
            obj.hashCode();
        }
        return map;
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    protected final boolean zzb() {
        int i = MyBillsEntityDataFactory + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        MyBillsEntityDataFactory = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 86 / 0;
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set zzk(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzg();
        zzC(str);
        Set set = (Set) this.zza.get(str);
        int i3 = MyBillsEntityDataFactory + 21;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzg();
        this.zzk.put(str, null);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 35 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzm(String str) {
        try {
            int i = MyBillsEntityDataFactory + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                zzg();
                this.zzh.remove(str);
            } else {
                zzg();
                this.zzh.remove(str);
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = MyBillsEntityDataFactory + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzg();
        com.google.android.gms.internal.measurement.zzfe zze = zze(str);
        if (!(zze == null)) {
            return zze.zzq();
        }
        int i3 = MyBillsEntityDataFactory + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        return !(i3 % 2 != 0);
    }

    public final boolean zzo(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) this.zzh.get(str);
                if (zzfeVar != null) {
                    if (!(zzfeVar.zza() == 0)) {
                        int i = MyBillsEntityDataFactory + 87;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        if ((i % 2 == 0 ? '[' : (char) 5) != '[') {
                            return true;
                        }
                    }
                    return false;
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                MyBillsEntityDataFactory = i2 % 128;
                if (i2 % 2 != 0) {
                }
                int i3 = MyBillsEntityDataFactory + 89;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    return false;
                }
                return false;
            }
            int i4 = MyBillsEntityDataFactory + 65;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            int i5 = i4 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            boolean equals = "1".equals(zza(str, "measurement.upload.blacklist_internal"));
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 != 0 ? 'Y' : '-') != 'Y') {
                    return equals;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return equals;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str, String str2) {
        zzg();
        zzC(str);
        if (zzp(str)) {
            try {
                if (zzlh.zzah(str2)) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                    MyBillsEntityDataFactory = i % 128;
                    if (i % 2 != 0) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return true;
                    }
                    return true;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        if ((zzs(str) ? 'U' : (char) 4) == 'U' && zzlh.zzai(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map != null) {
            try {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                Boolean bool = (Boolean) map.get(str2);
                if (bool == null) {
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                    MyBillsEntityDataFactory = i4 % 128;
                    int i5 = i4 % 2;
                    return false;
                }
                boolean booleanValue = bool.booleanValue();
                int i6 = MyBillsEntityDataFactory + 53;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                int i7 = i6 % 2;
                return booleanValue;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'N' : '7') != 'N') {
            try {
                return "1".equals(zza(str, "measurement.upload.blacklist_public"));
            } catch (Exception e) {
                throw e;
            }
        }
        boolean equals = "1".equals(zza(str, "measurement.upload.blacklist_public"));
        Object obj = null;
        obj.hashCode();
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzt(String str, byte[] bArr, String str2, String str3) {
        byte[] bArr2;
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzfd zzfdVar = (com.google.android.gms.internal.measurement.zzfd) zzA(str, bArr).zzby();
        Object[] objArr = null;
        if ((zzfdVar == null ? 'Q' : (char) 20) == 'Q') {
            int i = MyBillsEntityDataFactory + 111;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? '6' : 'R') != 'R') {
                int length = objArr.length;
                return false;
            }
            return false;
        }
        zzB(str, zzfdVar);
        zzD(str, (com.google.android.gms.internal.measurement.zzfe) zzfdVar.zzaE());
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzfe) zzfdVar.zzaE());
        this.zzj.put(str, zzfdVar.zze());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzg.put(str, zzE((com.google.android.gms.internal.measurement.zzfe) zzfdVar.zzaE()));
        this.zzf.zzi().zzB(str, new ArrayList(zzfdVar.zzf()));
        try {
            zzfdVar.zzc();
            bArr2 = ((com.google.android.gms.internal.measurement.zzfe) zzfdVar.zzaE()).zzbv();
        } catch (RuntimeException e) {
            this.zzs.zzay().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzeo.zzn(str), e);
            bArr2 = bArr;
        }
        zzam zzi = this.zzf.zzi();
        Preconditions.checkNotEmpty(str);
        zzi.zzg();
        zzi.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        contentValues.put("config_last_modified_time", str2);
        if (zzi.zzs.zzf().zzs(null, zzeb.zzaw)) {
            int i2 = MyBillsEntityDataFactory + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            contentValues.put("e_tag", str3);
            if (i3 == 0) {
                objArr.hashCode();
            }
        }
        try {
            SQLiteDatabase zzh = zzi.zzh();
            String[] strArr = {str};
            Object[] objArr2 = new Object[1];
            a(new char[]{3, 6, 65524, 3}, (Process.myPid() >> 22) + 213, 3 - MotionEvent.axisFromString(""), false, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2, objArr2);
            if ((((long) zzh.update(((String) objArr2[0]).intern(), contentValues, "app_id = ?", strArr)) == 0 ? 'D' : Typography.less) != '<') {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                MyBillsEntityDataFactory = i4 % 128;
                if (i4 % 2 != 0) {
                    zzi.zzs.zzay().zzd().zzb("Failed to update remote config (got 0). appId", zzeo.zzn(str));
                    int i5 = 86 / 0;
                } else {
                    zzi.zzs.zzay().zzd().zzb("Failed to update remote config (got 0). appId", zzeo.zzn(str));
                }
            }
        } catch (SQLiteException e2) {
            zzi.zzs.zzay().zzd().zzc("Error storing remote config. appId", zzeo.zzn(str), e2);
        }
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzfe) zzfdVar.zzaE());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if ((!((java.util.Set) r5.zza.get(r6)).contains("device_model")) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r0 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (((java.util.Set) r5.zza.get(r6)).contains("device_info") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        r6 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory + 9;
        com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzv(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzg()
            r5.zzC(r6)
            java.util.Map r0 = r5.zza
            java.lang.Object r0 = r0.get(r6)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L6b
            int r0 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 53
            int r3 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r3
            int r0 = r0 % 2
            r3 = 59
            if (r0 == 0) goto L21
            r0 = 59
            goto L23
        L21:
            r0 = 64
        L23:
            java.lang.String r4 = "device_model"
            if (r0 == r3) goto L3b
            java.util.Map r0 = r5.zza
            java.lang.Object r0 = r0.get(r6)
            java.util.Set r0 = (java.util.Set) r0
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = 0
        L38:
            if (r0 == 0) goto L67
            goto L4b
        L3b:
            java.util.Map r0 = r5.zza
            java.lang.Object r0 = r0.get(r6)
            java.util.Set r0 = (java.util.Set) r0
            boolean r0 = r0.contains(r4)
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L67
        L4b:
            java.util.Map r0 = r5.zza
            java.lang.Object r6 = r0.get(r6)
            java.util.Set r6 = (java.util.Set) r6
            java.lang.String r0 = "device_info"
            boolean r6 = r6.contains(r0)
            if (r6 != 0) goto L5c
            goto L6b
        L5c:
            int r6 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory
            int r6 = r6 + 9
            int r0 = r6 % 128
            com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            return r2
        L67:
            r1 = 1
            goto L75
        L69:
            r6 = move-exception
            throw r6
        L6b:
            int r6 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory
            int r6 = r6 + 89
            int r0 = r6 % 128
            com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzv(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzz(String str) {
        zzg();
        zzC(str);
        if ((this.zza.get(str) != null ? (char) 19 : '+') != '+' && ((Set) this.zza.get(str)).contains(SecuredAccountPreferences.Key.USER_ID)) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return true;
        }
        int i3 = MyBillsEntityDataFactory + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 == 0 ? '*' : (char) 16) != '*') {
            return false;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzf(String str) {
        String str2;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
            try {
                MyBillsEntityDataFactory = i % 128;
                Object[] objArr = null;
                if ((i % 2 != 0 ? '\b' : '`') != '\b') {
                    zzg();
                    str2 = (String) this.zzl.get(str);
                } else {
                    zzg();
                    str2 = (String) this.zzl.get(str);
                    int length = objArr.length;
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                MyBillsEntityDataFactory = i2 % 128;
                if ((i2 % 2 != 0 ? '+' : '\r') != '+') {
                    return str2;
                }
                objArr.hashCode();
                return str2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzh(String str) {
        int i = MyBillsEntityDataFactory + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        zzg();
        String str2 = (String) this.zzk.get(str);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 18 : Typography.dollar) != 18) {
            return str2;
        }
        Object obj = null;
        obj.hashCode();
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzi(String str) {
        int i = MyBillsEntityDataFactory + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            zzg();
            zzC(str);
            return (String) this.zzj.get(str);
        }
        zzg();
        zzC(str);
        int i2 = 87 / 0;
        return (String) this.zzj.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if ((r4.zza.get(r5) == null) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r4.zza.get(r5) != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        r0 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 + 107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (((java.util.Set) r4.zza.get(r5)).contains("enhanced_user_id") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        r5 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        r5 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r5 == '$') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzw(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L2b
            r4.zzg()
            r4.zzC(r5)
            java.util.Map r0 = r4.zza
            java.lang.Object r0 = r0.get(r5)
            r3 = 4
            int r3 = r3 / r2
            if (r0 == 0) goto L25
            r0 = 0
            goto L26
        L25:
            r0 = 1
        L26:
            if (r0 == 0) goto L39
            goto L5e
        L29:
            r5 = move-exception
            throw r5
        L2b:
            r4.zzg()     // Catch: java.lang.Exception -> L5f
            r4.zzC(r5)     // Catch: java.lang.Exception -> L5f
            java.util.Map r0 = r4.zza     // Catch: java.lang.Exception -> L5f
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Exception -> L5f
            if (r0 == 0) goto L5e
        L39:
            int r0 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L5f
            int r0 = r0 + 107
            int r3 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L5f
            int r0 = r0 % 2
            java.util.Map r0 = r4.zza
            java.lang.Object r5 = r0.get(r5)
            java.util.Set r5 = (java.util.Set) r5
            java.lang.String r0 = "enhanced_user_id"
            boolean r5 = r5.contains(r0)
            r0 = 36
            if (r5 == 0) goto L58
            r5 = 36
            goto L5a
        L58:
            r5 = 11
        L5a:
            if (r5 == r0) goto L5d
            goto L5e
        L5d:
            return r1
        L5e:
            return r2
        L5f:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzw(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4.zza.get(r5) == null) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if ((r4.zza.get(r5) != null ? 'C' : 3) != 'C') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r0 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory + 15;
        com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        if (((java.util.Set) r4.zza.get(r5)).contains("google_signals") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzx(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 63
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 93
            if (r0 == 0) goto L11
            r0 = 99
            goto L13
        L11:
            r0 = 93
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L30
            r4.zzg()
            r4.zzC(r5)
            java.util.Map r0 = r4.zza
            java.lang.Object r0 = r0.get(r5)
            r1 = 16
            int r1 = r1 / r3
            if (r0 == 0) goto L2a
            r0 = 0
            goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L47
            goto L62
        L2e:
            r5 = move-exception
            throw r5
        L30:
            r4.zzg()     // Catch: java.lang.Exception -> L6f
            r4.zzC(r5)     // Catch: java.lang.Exception -> L6f
            java.util.Map r0 = r4.zza     // Catch: java.lang.Exception -> L6f
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Exception -> L6f
            r1 = 67
            if (r0 == 0) goto L43
            r0 = 67
            goto L44
        L43:
            r0 = 3
        L44:
            if (r0 == r1) goto L47
            goto L62
        L47:
            int r0 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6d
            int r0 = r0 + 15
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L6d
            int r0 = r0 % 2
            java.util.Map r0 = r4.zza
            java.lang.Object r5 = r0.get(r5)
            java.util.Set r5 = (java.util.Set) r5
            java.lang.String r0 = "google_signals"
            boolean r5 = r5.contains(r0)
            if (r5 == 0) goto L62
            return r2
        L62:
            int r5 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 115
            int r0 = r5 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            return r3
        L6d:
            r5 = move-exception
            throw r5
        L6f:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzx(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final String zza(String str, String str2) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            zzg();
            zzC(str);
            Map map = (Map) this.zzg.get(str);
            if (!(map == null)) {
                String str3 = (String) map.get(str2);
                int i3 = MyBillsEntityDataFactory + 87;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return str3;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzg();
        zzC(str);
        if (!(this.zza.get(str) == null)) {
            int i3 = MyBillsEntityDataFactory + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            try {
                if ((((Set) this.zza.get(str)).contains("app_instance_id") ? (char) 22 : '+') != '+') {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                    MyBillsEntityDataFactory = i5 % 128;
                    return i5 % 2 == 0;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy(String str) {
        boolean z;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            try {
                zzg();
                zzC(str);
                if (this.zza.get(str) == null) {
                    return false;
                }
                z = false;
            } catch (Exception e) {
                throw e;
            }
        } else {
            zzg();
            zzC(str);
            if (this.zza.get(str) == null) {
                return false;
            }
            z = true;
        }
        if (((Set) this.zza.get(str)).contains("os_version")) {
            return z;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 != 0 ? '\n' : (char) 5) == '\n') {
            boolean contains = ((Set) this.zza.get(str)).contains("device_info");
            Object[] objArr = null;
            int length = objArr.length;
            if (!contains) {
                return false;
            }
        } else if (!((Set) this.zza.get(str)).contains("device_info")) {
            return false;
        }
        return true;
    }

    private final com.google.android.gms.internal.measurement.zzfe zzA(String str, byte[] bArr) {
        Long valueOf;
        if (bArr == null) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            try {
                return com.google.android.gms.internal.measurement.zzfe.zzg();
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) ((com.google.android.gms.internal.measurement.zzfd) zzlb.zzl(com.google.android.gms.internal.measurement.zzfe.zze(), bArr)).zzaE();
            zzem zzj = this.zzs.zzay().zzj();
            String str2 = null;
            if (!zzfeVar.zzs()) {
                valueOf = null;
            } else {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                valueOf = Long.valueOf(zzfeVar.zzc());
                int i5 = MyBillsEntityDataFactory + 111;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
            }
            if ((zzfeVar.zzr() ? 'W' : '-') == 'W') {
                str2 = zzfeVar.zzh();
            }
            zzj.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzfeVar;
        } catch (com.google.android.gms.internal.measurement.zzko e2) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzeo.zzn(str), e2);
            return com.google.android.gms.internal.measurement.zzfe.zzg();
        } catch (RuntimeException e3) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzeo.zzn(str), e3);
            return com.google.android.gms.internal.measurement.zzfe.zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzc(String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        zzg();
        zzC(str);
        Map map = (Map) this.zzi.get(str);
        if (!(map == null)) {
            try {
                int i3 = MyBillsEntityDataFactory + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                Integer num = (Integer) map.get(str2);
                if (num != null) {
                    try {
                        return num.intValue();
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return 1;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.internal.measurement.zzfe zze(String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            try {
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 != 0 ? 'Z' : 'S') == 'S') {
                    zzW();
                    zzg();
                    Preconditions.checkNotEmpty(str);
                    zzC(str);
                    return (com.google.android.gms.internal.measurement.zzfe) this.zzh.get(str);
                }
                zzW();
                zzg();
                Preconditions.checkNotEmpty(str);
                zzC(str);
                int i2 = 82 / 0;
                return (com.google.android.gms.internal.measurement.zzfe) this.zzh.get(str);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if ((r0 ? '?' : 29) != 29) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if ("ecommerce_purchase".equals(r6) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        r5 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (com.google.firebase.analytics.FirebaseAnalytics.Event.PURCHASE.equals(r6) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (com.google.firebase.analytics.FirebaseAnalytics.Event.REFUND.equals(r6) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        r5 = (java.util.Map) r4.zzc.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r5 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r1 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 + 37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if ((r1 % 2) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r1 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        r1 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
    
        if (r1 == '^') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
    
        r5 = (java.lang.Boolean) r5.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        if (r5 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
    
        r5 = (java.lang.Boolean) r5.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        if (r5 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
    
        r5 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory + 115;
        com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        if ((r5 % 2) != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        r5 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0098, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        return r5.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a7, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzq(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "ecommerce_purchase"
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L2b
            r4.zzg()
            r4.zzC(r5)
            boolean r0 = r1.equals(r6)
            r3.hashCode()     // Catch: java.lang.Throwable -> L29
            r1 = 29
            if (r0 == 0) goto L24
            r0 = 63
            goto L26
        L24:
            r0 = 29
        L26:
            if (r0 == r1) goto L42
            goto L37
        L29:
            r5 = move-exception
            throw r5
        L2b:
            r4.zzg()
            r4.zzC(r5)
            boolean r0 = r1.equals(r6)
            if (r0 == 0) goto L42
        L37:
            int r5 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 17
            int r6 = r5 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
            return r2
        L42:
            java.lang.String r0 = "purchase"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto La7
            java.lang.String r0 = "refund"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L53
            goto La7
        L53:
            java.util.Map r0 = r4.zzc     // Catch: java.lang.Exception -> La5
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Exception -> La3
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> La3
            r0 = 0
            if (r5 == 0) goto L5f
            r2 = 0
        L5f:
            if (r2 == 0) goto L62
            return r0
        L62:
            int r1 = com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> La5
            int r1 = r1 + 37
            int r2 = r1 % 128
            com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> La5
            int r1 = r1 % 2
            r2 = 94
            if (r1 == 0) goto L73
            r1 = 94
            goto L75
        L73:
            r1 = 22
        L75:
            if (r1 == r2) goto L80
            java.lang.Object r5 = r5.get(r6)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L9c
            goto L8b
        L80:
            java.lang.Object r5 = r5.get(r6)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r3.hashCode()     // Catch: java.lang.Throwable -> La1
            if (r5 != 0) goto L9c
        L8b:
            int r5 = com.google.android.gms.measurement.internal.zzfp.MyBillsEntityDataFactory
            int r5 = r5 + 115
            int r6 = r5 % 128
            com.google.android.gms.measurement.internal.zzfp.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L9b
            int r5 = r3.length     // Catch: java.lang.Throwable -> L99
            return r0
        L99:
            r5 = move-exception
            throw r5
        L9b:
            return r0
        L9c:
            boolean r5 = r5.booleanValue()
            return r5
        La1:
            r5 = move-exception
            throw r5
        La3:
            r5 = move-exception
            throw r5
        La5:
            r5 = move-exception
            throw r5
        La7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfp.zzq(java.lang.String, java.lang.String):boolean");
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? 'M' : (char) 18) == 18) {
                    break;
                }
                int i4 = $10 + 77;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i6 = a2.MyBillsEntityDataFactory;
                cArr3[i6] = (char) (cArr3[i6] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
                int i7 = $10 + 121;
                $11 = i7 % 128;
                int i8 = i7 % 2;
            }
            if ((i3 > 0 ? 'W' : 'H') == 'W') {
                int i9 = $11 + 27;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr4 = new char[i2];
                System.arraycopy(cArr3, 0, cArr4, 0, i2);
                System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                int i11 = $11 + 115;
                $10 = i11 % 128;
                if (i11 % 2 != 0) {
                    cArr2 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                } else {
                    cArr2 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                }
                while (a2.MyBillsEntityDataFactory < i2) {
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                    int i12 = $11 + 77;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                }
                cArr3 = cArr2;
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e) {
            throw e;
        }
    }
}
