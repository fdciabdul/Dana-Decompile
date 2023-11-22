package pl.charmas.android.reactivelocation2.observables;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes6.dex */
public class GoogleAPIConnectionException extends RuntimeException {
    private final ConnectionResult connectionResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleAPIConnectionException(String str, ConnectionResult connectionResult) {
        super(str);
        this.connectionResult = connectionResult;
    }

    public ConnectionResult getConnectionResult() {
        return this.connectionResult;
    }
}
