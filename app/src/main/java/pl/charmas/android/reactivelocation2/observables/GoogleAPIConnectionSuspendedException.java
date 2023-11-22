package pl.charmas.android.reactivelocation2.observables;

/* loaded from: classes6.dex */
public class GoogleAPIConnectionSuspendedException extends RuntimeException {
    private final int cause;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleAPIConnectionSuspendedException(int i) {
        this.cause = i;
    }

    public int getErrorCause() {
        return this.cause;
    }
}
