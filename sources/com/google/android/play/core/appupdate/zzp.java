package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes3.dex */
final class zzp extends zzo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnCompleteUpdateCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzb(Bundle bundle) throws RemoteException {
        int i;
        int i2;
        super.zzb(bundle);
        i = bundle.getInt("error.code", -2);
        if (i != 0) {
            TaskCompletionSource taskCompletionSource = this.zzb;
            i2 = bundle.getInt("error.code", -2);
            taskCompletionSource.trySetException(new InstallException(i2));
            return;
        }
        this.zzb.trySetResult(null);
    }
}
