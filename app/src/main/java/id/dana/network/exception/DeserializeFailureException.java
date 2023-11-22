package id.dana.network.exception;

/* loaded from: classes5.dex */
public class DeserializeFailureException extends RuntimeException {
    public DeserializeFailureException(String str) {
        super(str);
    }

    public DeserializeFailureException(String str, Throwable th) {
        super(str, th);
    }

    public DeserializeFailureException(Throwable th) {
        super(th);
    }

    public DeserializeFailureException() {
    }
}
