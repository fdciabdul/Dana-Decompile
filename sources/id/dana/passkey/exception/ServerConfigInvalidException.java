package id.dana.passkey.exception;

/* loaded from: classes5.dex */
public class ServerConfigInvalidException extends PasskeyException {
    public ServerConfigInvalidException(Throwable th) {
        super("Please ensure your .well-known/assetlinks.json correctly configured", th);
    }
}
