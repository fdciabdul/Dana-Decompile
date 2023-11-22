package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zze implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzf zzfVar, Task task) {
        this.zzb = zzfVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar;
        zzw zzwVar2;
        zzw zzwVar3;
        Continuation continuation;
        try {
            continuation = this.zzb.zzb;
            Task task = (Task) continuation.then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zza, this.zzb);
            task.addOnFailureListener(TaskExecutors.zza, this.zzb);
            task.addOnCanceledListener(TaskExecutors.zza, this.zzb);
        } catch (RuntimeExecutionException e) {
            if (!(e.getCause() instanceof Exception)) {
                zzwVar2 = this.zzb.zzc;
                zzwVar2.zza(e);
                return;
            }
            zzwVar3 = this.zzb.zzc;
            zzwVar3.zza((Exception) e.getCause());
        } catch (Exception e2) {
            zzwVar = this.zzb.zzc;
            zzwVar.zza(e2);
        }
    }
}
