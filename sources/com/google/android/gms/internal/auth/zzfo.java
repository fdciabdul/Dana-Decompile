package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzfo implements zzgi {
    private static final zzfu zza = new zzfm();
    private final zzfu zzb;

    public zzfo() {
        zzfu zzfuVar;
        zzfu[] zzfuVarArr = new zzfu[2];
        zzfuVarArr[0] = zzer.zza();
        try {
            zzfuVar = (zzfu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfuVar = zza;
        }
        zzfuVarArr[1] = zzfuVar;
        zzfn zzfnVar = new zzfn(zzfuVarArr);
        zzez.zzf(zzfnVar, "messageInfoFactory");
        this.zzb = zzfnVar;
    }

    private static boolean zzb(zzft zzftVar) {
        return zzftVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final zzgh zza(Class cls) {
        zzgj.zzg(cls);
        zzft zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzeu.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzfz.zzj(cls, zzb, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), zzen.zzb(), zzfs.zzb());
                }
                return zzfz.zzj(cls, zzb, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), null, zzfs.zzb());
            } else if (zzb(zzb)) {
                return zzfz.zzj(cls, zzb, zzgc.zza(), zzfk.zzc(), zzgj.zza(), zzen.zza(), zzfs.zza());
            } else {
                return zzfz.zzj(cls, zzb, zzgc.zza(), zzfk.zzc(), zzgj.zzb(), null, zzfs.zza());
            }
        } else if (zzeu.class.isAssignableFrom(cls)) {
            return zzga.zzb(zzgj.zzc(), zzen.zzb(), zzb.zza());
        } else {
            return zzga.zzb(zzgj.zza(), zzen.zza(), zzb.zza());
        }
    }
}
