package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzld implements zzlx {
    private static final zzlj zza = new zzlb();
    private final zzlj zzb;

    public zzld() {
        zzlj zzljVar;
        zzlj[] zzljVarArr = new zzlj[2];
        zzljVarArr[0] = zzjz.zza();
        try {
            zzljVar = (zzlj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzljVar = zza;
        }
        zzljVarArr[1] = zzljVar;
        zzlc zzlcVar = new zzlc(zzljVarArr);
        zzkm.zzf(zzlcVar, "messageInfoFactory");
        this.zzb = zzlcVar;
    }

    private static boolean zzb(zzli zzliVar) {
        return zzliVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final zzlw zza(Class cls) {
        zzly.zzG(cls);
        zzli zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzke.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzlo.zzl(cls, zzb, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), zzjt.zzb(), zzlh.zzb());
                }
                return zzlo.zzl(cls, zzb, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), null, zzlh.zzb());
            } else if (zzb(zzb)) {
                return zzlo.zzl(cls, zzb, zzlr.zza(), zzkz.zzc(), zzly.zzz(), zzjt.zza(), zzlh.zza());
            } else {
                return zzlo.zzl(cls, zzb, zzlr.zza(), zzkz.zzc(), zzly.zzA(), null, zzlh.zza());
            }
        } else if (zzke.class.isAssignableFrom(cls)) {
            return zzlp.zzc(zzly.zzB(), zzjt.zzb(), zzb.zza());
        } else {
            return zzlp.zzc(zzly.zzz(), zzjt.zza(), zzb.zza());
        }
    }
}
