package androidx.browser.trusted;

import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* loaded from: classes6.dex */
public class TrustedWebActivityCallbackRemote {
    private final ITrustedWebActivityCallback BuiltInFictitiousFunctionClassFactory;

    private TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.BuiltInFictitiousFunctionClassFactory = iTrustedWebActivityCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrustedWebActivityCallbackRemote BuiltInFictitiousFunctionClassFactory(IBinder iBinder) {
        ITrustedWebActivityCallback asInterface = iBinder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(asInterface);
    }
}
