package com.ipification.mobile.sdk.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/NetworkUtils;", "", "()V", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkUtils {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/NetworkUtils$Companion;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean MyBillsEntityDataFactory(android.content.Context r2) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
                r0 = 0
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Exception -> L22
                java.lang.String r1 = "wifi"
                java.lang.Object r2 = r2.getSystemService(r1)     // Catch: java.lang.Exception -> L22
                android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch: java.lang.Exception -> L22
                r1 = 1
                if (r2 == 0) goto L1e
                boolean r2 = r2.isWifiEnabled()     // Catch: java.lang.Exception -> L22
                if (r2 != r1) goto L1e
                r2 = 1
                goto L1f
            L1e:
                r2 = 0
            L1f:
                if (r2 == 0) goto L22
                return r1
            L22:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.utils.NetworkUtils.Companion.MyBillsEntityDataFactory(android.content.Context):boolean");
        }

        public static boolean getAuthRequestContext(Context p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Object systemService = p0.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    Method declaredMethod = Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                    Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "");
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(connectivityManager, new Object[0]);
                    if (invoke instanceof Boolean) {
                        return ((Boolean) invoke).booleanValue();
                    }
                    return true;
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message != null) {
                        CellularCallback.DefaultImpls.getAuthRequestContext(LogUtils.getAuthRequestContext, message);
                    }
                    return true;
                }
            }
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }
}
