package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzes;
import com.google.android.gms.internal.auth.zzeu;

/* loaded from: classes7.dex */
public class zzes<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzes<MessageType, BuilderType>> extends zzdo<MessageType, BuilderType> {
    protected zzeu zza;
    protected boolean zzb = false;
    private final zzeu zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzes(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzeu) messagetype.zzi(4, null, null);
    }

    private static final void zzj(zzeu zzeuVar, zzeu zzeuVar2) {
        zzge.zza().zzb(zzeuVar.getClass()).zzf(zzeuVar, zzeuVar2);
    }

    @Override // com.google.android.gms.internal.auth.zzdo
    protected final /* synthetic */ zzdo zzb(zzdp zzdpVar) {
        zze((zzeu) zzdpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.auth.zzdo
    /* renamed from: zzd  reason: merged with bridge method [inline-methods] */
    public final zzes clone() {
        zzes zzesVar = (zzes) this.zzc.zzi(5, null, null);
        zzesVar.zze(zzg());
        return zzesVar;
    }

    public final zzes zze(zzeu zzeuVar) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzj(this.zza, zzeuVar);
        return this;
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    /* renamed from: zzf  reason: merged with bridge method [inline-methods] */
    public MessageType zzg() {
        if (this.zzb) {
            return (MessageType) this.zza;
        }
        zzeu zzeuVar = this.zza;
        zzge.zza().zzb(zzeuVar.getClass()).zze(zzeuVar);
        this.zzb = true;
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfx
    public final /* synthetic */ zzfw zzh() {
        return this.zzc;
    }

    protected void zzi() {
        zzeu zzeuVar = (zzeu) this.zza.zzi(4, null, null);
        zzj(zzeuVar, this.zza);
        this.zza = zzeuVar;
    }
}
