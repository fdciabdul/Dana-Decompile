package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes8.dex */
public class a {
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final HostnameVerifier MyBillsEntityDataFactory = new StrictHostnameVerifier();
    private static int getAuthRequestContext = 1;

    public static SSLSocketFactory KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            AssetManager assets = context.getAssets();
            StringBuilder sb = new StringBuilder();
            sb.append(GrsApp.getInstance().getBrand("/"));
            sb.append("grs_sp.bks");
            try {
                Object[] objArr = {assets, sb.toString()};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58132 - TextUtils.lastIndexOf("", '0')), ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new SecureX509TrustManager((InputStream) ((Method) obj).invoke(null, objArr), ""));
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 65;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    return secureSSLSocketFactoryNew;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}
