package id.dana.data.qrbarcode;

/* loaded from: classes4.dex */
public class ScanSelfException extends Exception {
    public ScanSelfException() {
        super("Sender and Receiver of DANA should be different account");
    }
}
