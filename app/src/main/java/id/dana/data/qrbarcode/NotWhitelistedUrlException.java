package id.dana.data.qrbarcode;

/* loaded from: classes4.dex */
public class NotWhitelistedUrlException extends Exception {
    public NotWhitelistedUrlException() {
        super("Scan result url is not whitelisted");
    }
}
