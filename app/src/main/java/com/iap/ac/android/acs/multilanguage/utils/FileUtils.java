package com.iap.ac.android.acs.multilanguage.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Process;
import android.view.ViewConfiguration;
import com.iap.ac.android.common.log.ACLog;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class FileUtils {
    private static int PlaceComponentResult = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7533a = LanguagePackageUtil.logTag(com.alibaba.griver.image.framework.utils.FileUtils.TAG);
    private static int getAuthRequestContext;

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                String str = f7533a;
                StringBuilder sb = new StringBuilder();
                sb.append("closeStream() failed, error: ");
                sb.append(e);
                ACLog.d(str, sb.toString());
            }
        }
    }

    public static boolean deleteFile(String str, String str2) {
        if (isFileExists(str, str2)) {
            return new File(str, str2).delete();
        }
        return false;
    }

    public static boolean isFileExists(String str, String str2) {
        File file = new File(str, str2);
        return file.exists() && file.length() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00e7: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:51:0x00e5 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    public static String readConfigFromAsset(Context context, String str) {
        ?? r9;
        Closeable closeable;
        Exception e;
        BufferedReader bufferedReader;
        try {
            ?? assets = context.getAssets();
            Closeable closeable2 = null;
            try {
                try {
                    ?? r2 = {assets, str};
                    Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj == null) {
                        obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (((Process.getThreadPriority(0) + 20) >> 6) + 58133), Color.alpha(0), 49 - (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                    }
                    assets = (InputStream) ((Method) obj).invoke(null, r2);
                    try {
                        r9 = new InputStreamReader(assets);
                        try {
                            bufferedReader = new BufferedReader(r9);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = null;
                        } catch (Throwable th) {
                            th = th;
                            a(closeable2);
                            a(r9);
                            a(assets);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        assets = assets;
                        r9 = 0;
                        bufferedReader = null;
                        String str2 = f7533a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("readConfigFromAsset failed: ");
                        sb.append(e);
                        ACLog.e(str2, sb.toString());
                        a(bufferedReader);
                        a(r9);
                        a(assets);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        assets = assets;
                        r9 = 0;
                        a(closeable2);
                        a(r9);
                        a(assets);
                        throw th;
                    }
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            int i = getAuthRequestContext + 25;
                            PlaceComponentResult = i % 128;
                            int i2 = i % 2;
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if ((readLine != null ? (char) 21 : 'Y') == 'Y') {
                                    String obj2 = sb2.toString();
                                    a(bufferedReader);
                                    a(r9);
                                    a(assets);
                                    return obj2;
                                }
                                int i3 = getAuthRequestContext + 19;
                                PlaceComponentResult = i3 % 128;
                                int i4 = i3 % 2;
                                sb2.append(readLine);
                            }
                        } catch (Exception e4) {
                            throw e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        String str22 = f7533a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("readConfigFromAsset failed: ");
                        sb3.append(e);
                        ACLog.e(str22, sb3.toString());
                        a(bufferedReader);
                        a(r9);
                        a(assets);
                        return null;
                    }
                } catch (Throwable th3) {
                    try {
                        Throwable cause = th3.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th3;
                    } catch (Exception e6) {
                        e = e6;
                        assets = 0;
                        r9 = 0;
                        bufferedReader = null;
                        String str222 = f7533a;
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append("readConfigFromAsset failed: ");
                        sb32.append(e);
                        ACLog.e(str222, sb32.toString());
                        a(bufferedReader);
                        a(r9);
                        a(assets);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        assets = 0;
                        r9 = 0;
                        a(closeable2);
                        a(r9);
                        a(assets);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                r9 = str;
                closeable2 = closeable;
            }
        } catch (Exception e7) {
            throw e7;
        }
    }

    public static String readStringFromFile(String str, String str2) {
        Throwable th;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(new File(str, str2));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String obj = sb.toString();
                            a(bufferedReader2);
                            a(fileInputStream);
                            return obj;
                        }
                    }
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                    a(bufferedReader);
                    a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    public static void writeStringToFile(String str, String str2, String str3) {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file = new File(str);
            String str4 = f7533a;
            StringBuilder sb = new StringBuilder();
            sb.append("writeStringToFile() dir = ");
            sb.append(file.getAbsolutePath());
            ACLog.d(str4, sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        try {
            bufferedOutputStream.write(str3.getBytes());
            a(bufferedOutputStream);
            a(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = bufferedOutputStream;
            a(bufferedOutputStream2);
            a(fileOutputStream);
            throw th;
        }
    }
}
