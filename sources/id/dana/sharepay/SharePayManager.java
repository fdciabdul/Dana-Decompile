package id.dana.sharepay;

import android.net.Uri;

/* loaded from: classes3.dex */
public class SharePayManager {
    private static SharePayManager BuiltInFictitiousFunctionClassFactory;
    public Uri KClassImpl$Data$declaredNonStaticMembers$2;

    private SharePayManager() {
    }

    public static SharePayManager getAuthRequestContext() {
        SharePayManager sharePayManager;
        synchronized (SharePayManager.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = new SharePayManager();
            }
            sharePayManager = BuiltInFictitiousFunctionClassFactory;
        }
        return sharePayManager;
    }
}
