package id.dana.passkey.exception;

/* loaded from: classes5.dex */
public class UserCancellationException extends PasskeyException {
    public UserCancellationException(Throwable th) {
        super("User cancelling request", th);
    }
}
