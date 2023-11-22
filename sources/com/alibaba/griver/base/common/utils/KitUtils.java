package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Gravity;
import android.view.ViewConfiguration;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class KitUtils {
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int PlaceComponentResult = 1;

    public static String getAssetUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("file:///android_asset/");
        sb.append(str);
        return sb.toString();
    }

    public static String base64(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(Base64.encode(bArr, 0));
        } catch (Exception e) {
            GriverLogger.e("KitUtils", "", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cf, code lost:
    
        if (r13 != null) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getAssetBytesContent(android.content.Context r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.KitUtils.getAssetBytesContent(android.content.Context, java.lang.String):byte[]");
    }

    public static String getAssetContent(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        Object obj = null;
        try {
            if ((context == null ? (char) 2 : (char) 4) == 2) {
                int i = BuiltInFictitiousFunctionClassFactory + 25;
                PlaceComponentResult = i % 128;
                if (i % 2 == 0) {
                    context = GriverEnv.getApplicationContext();
                    obj.hashCode();
                } else {
                    context = GriverEnv.getApplicationContext();
                }
            }
            try {
                Object[] objArr = {context.getAssets(), str};
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj2 == null) {
                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - Color.argb(0, 0, 0, 0)), Gravity.getAbsoluteGravity(0, 0), 49 - (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream) ((Method) obj2).invoke(null, objArr)));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if ((readLine != null ? (char) 4 : 'P') == 'P') {
                        break;
                    }
                    int i2 = PlaceComponentResult + 1;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    if (i2 % 2 != 0) {
                        sb.append(readLine);
                        sb.append("\r\n");
                        obj.hashCode();
                    } else {
                        sb.append(readLine);
                        sb.append("\r\n");
                    }
                }
                bufferedReader.close();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Exception e) {
            GriverLogger.e("KitUtils", "", e);
        }
        try {
            return sb.toString();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String domain = getDomain(str2);
        if (TextUtils.isEmpty(domain)) {
            return false;
        }
        if (domain.equals(str)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(str);
        return domain.endsWith(sb.toString());
    }

    public static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length()) ? str : str.substring(lastIndexOf + 1, str.length());
    }
}
