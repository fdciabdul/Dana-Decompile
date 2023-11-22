package io.branch.referral;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
class DeferredAppLinkDataHandler {
    public static final byte[] PlaceComponentResult = {8, 17, -121, -18, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 166;

    /* loaded from: classes.dex */
    public interface AppLinkFetchEvents {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r10) {
        /*
            byte[] r0 = io.branch.referral.DeferredAppLinkDataHandler.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 0
            r5 = 4
            if (r0 != 0) goto L11
            r5 = 23
            r6 = 4
            r7 = 0
            goto L27
        L11:
            r6 = 0
        L12:
            int r7 = r6 + 1
            byte r8 = (byte) r3
            r2[r6] = r8
            if (r7 != r1) goto L21
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r4)
            r10[r4] = r0
            return
        L21:
            r6 = r0[r5]
            r9 = r5
            r5 = r3
            r3 = r6
            r6 = r9
        L27:
            int r3 = -r3
            int r5 = r5 + r3
            int r3 = r5 + (-8)
            int r5 = r6 + 1
            r6 = r7
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.DeferredAppLinkDataHandler.a(java.lang.Object[]):void");
    }

    DeferredAppLinkDataHandler() {
    }

    public static Boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, final AppLinkFetchEvents appLinkFetchEvents) {
        Method method;
        Object newProxyInstance;
        String string;
        boolean z = true;
        try {
            Class<?> cls = Class.forName("com.facebook.FacebookSdk");
            Object[] objArr = new Object[1];
            a(objArr);
            cls.getMethod("sdkInitialize", Class.forName((String) objArr[0])).invoke(null, context);
            final Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls3 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Object[] objArr2 = new Object[1];
            a(objArr2);
            method = cls2.getMethod("fetchDeferredAppLinkData", Class.forName((String) objArr2[0]), String.class, cls3);
            newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new InvocationHandler() { // from class: io.branch.referral.DeferredAppLinkDataHandler.1
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr3) throws Throwable {
                    Object obj2;
                    if (method2.getName().equals("onDeferredAppLinkDataFetched") && (obj2 = objArr3[0]) != null) {
                        Bundle bundle = (Bundle) Bundle.class.cast(cls2.getMethod("getArgumentBundle", new Class[0]).invoke(cls2.cast(obj2), new Object[0]));
                        String string2 = bundle != null ? bundle.getString("com.facebook.platform.APPLINK_NATIVE_URL") : null;
                        AppLinkFetchEvents appLinkFetchEvents2 = appLinkFetchEvents;
                        if (appLinkFetchEvents2 != null) {
                            appLinkFetchEvents2.KClassImpl$Data$declaredNonStaticMembers$2(string2);
                        }
                    } else {
                        AppLinkFetchEvents appLinkFetchEvents3 = appLinkFetchEvents;
                        if (appLinkFetchEvents3 != null) {
                            appLinkFetchEvents3.KClassImpl$Data$declaredNonStaticMembers$2(null);
                        }
                    }
                    return null;
                }
            });
            string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(string)) {
            method.invoke(null, context, string, newProxyInstance);
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
