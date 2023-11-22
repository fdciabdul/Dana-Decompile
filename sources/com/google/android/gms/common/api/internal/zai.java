package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
public abstract class zai {
    public final int zac;

    public zai(int i) {
        this.zac = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq<?> zabqVar) throws DeadObjectException;

    public abstract void zag(zaad zaadVar, boolean z);
}
