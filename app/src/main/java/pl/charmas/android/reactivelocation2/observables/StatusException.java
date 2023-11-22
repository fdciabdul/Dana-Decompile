package pl.charmas.android.reactivelocation2.observables;

import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public class StatusException extends Throwable {
    private final Status status;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StatusException(com.google.android.gms.common.api.Status r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r3.getStatusCode()
            r0.append(r1)
            java.lang.String r1 = ": "
            r0.append(r1)
            java.lang.String r1 = r3.getStatusMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.status = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.charmas.android.reactivelocation2.observables.StatusException.<init>(com.google.android.gms.common.api.Status):void");
    }

    public Status getStatus() {
        return this.status;
    }
}
