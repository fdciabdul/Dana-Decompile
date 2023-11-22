package com.mixpanel.android.util;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public interface RemoteService {
    byte[] BuiltInFictitiousFunctionClassFactory(String str, Map<String, Object> map, SSLSocketFactory sSLSocketFactory) throws ServiceUnavailableException, IOException;

    boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, OfflineMode offlineMode);

    void getAuthRequestContext();

    /* loaded from: classes.dex */
    public static class ServiceUnavailableException extends Exception {
        private final int mRetryAfter;

        public ServiceUnavailableException(String str, String str2) {
            super(str);
            int i;
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                i = 0;
            }
            this.mRetryAfter = i;
        }

        public int getRetryAfter() {
            return this.mRetryAfter;
        }
    }
}
