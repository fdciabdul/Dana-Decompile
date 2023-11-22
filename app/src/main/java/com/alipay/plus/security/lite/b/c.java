package com.alipay.plus.security.lite.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alipay.plus.security.lite.SecureLiteSignatureDefine;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;

    public static String a(Context context, String str, String str2) {
        try {
            String a2 = a(context.getResources(), SecureLiteSignatureDefine.API_KEY_FILE_NAME);
            return TextUtils.isEmpty(a2) ? str2 : new JSONObject(a2).optString(str, str2);
        } catch (Throwable th) {
            d.a("SecurityLite-PackageUtils", th.getMessage());
            return str2;
        }
    }

    public static String b(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                String upperCase = Integer.toHexString(digest[i] & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                if (i != digest.length - 1) {
                    sb.append(":");
                }
            }
            return sb.toString();
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v8 */
    public static String a(Resources resources, String str) {
        IOException e;
        String a2;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Closeable closeable = null;
        try {
            try {
                try {
                    if (!(i % 2 != 0)) {
                        try {
                            Object[] objArr = {resources.getAssets(), str};
                            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                            if (obj == null) {
                                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 58133), TextUtils.indexOf("", "", 0, 0), 49 - Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                            }
                            InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                            a2 = a(inputStream);
                            a((Closeable) inputStream);
                            resources = inputStream;
                            return a2;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    }
                    try {
                        Object[] objArr2 = {resources.getAssets(), str};
                        Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                        if (obj2 == null) {
                            obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (ExpandableListView.getPackedPositionType(0L) + 58133), TextUtils.indexOf("", "", 0, 0), 49 - ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                            NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                        }
                        InputStream inputStream2 = (InputStream) ((Method) obj2).invoke(null, objArr2);
                        a2 = a(inputStream2);
                        a((Closeable) inputStream2);
                        resources = 7 / 0;
                        return a2;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                    resources = 0;
                } catch (Throwable th3) {
                    th = th3;
                    a(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                closeable = resources;
                th = th4;
                a(closeable);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        }
        e = e3;
        d.a("read asset exception", e.getMessage());
        a((Closeable) resources);
        return null;
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return new String(b(inputStream));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                d.a("close stream exception", e.getMessage());
            }
        }
    }

    public static byte[] b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                d.a("read exception", e.getMessage());
                return null;
            } finally {
                a((Closeable) inputStream);
            }
        }
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(SecureLiteSignatureDefine.FILE_DIR_NAME);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getAbsolutePath());
        sb2.append(SecureLiteSignatureDefine.FILE_NAME);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
                return "";
            }
        }
        return file2.getAbsolutePath();
    }
}
