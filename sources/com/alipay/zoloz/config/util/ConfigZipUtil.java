package com.alipay.zoloz.config.util;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes7.dex */
public class ConfigZipUtil {
    private static final String ATTACK_PREFIX_PATH = "../";
    private static final int BUFFER_SIZE = 8192;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, 58, -28, -63, -30, -19, -27, 33, -53, -21, -11, 4, -53, Ascii.FS, -55, -27, 56, -19, -9};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 98;
    private static int MyBillsEntityDataFactory = 0;
    private static final String TAG = "ConfigZipUtil";
    private static int getAuthRequestContext = 1;

    public static boolean unzip(String str, String str2) {
        if (!FileUtil.exists(str)) {
            ConfigLog.e(TAG, "zip path not exists!");
            return false;
        } else if (!FileUtil.mkdirs(str2, true)) {
            ConfigLog.e(TAG, "failed to create unzip folder.");
            return false;
        } else {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        StringBuilder sb = new StringBuilder();
                        sb.append("unzip entry ");
                        sb.append(name);
                        ConfigLog.d(TAG, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("/");
                        sb2.append(name);
                        String obj = sb2.toString();
                        if (name.startsWith(ATTACK_PREFIX_PATH)) {
                            return false;
                        }
                        if (FileUtil.childOf(obj, str2)) {
                            if (nextEntry.isDirectory()) {
                                FileUtil.mkdirs(obj);
                            } else if (!FileUtil.create(obj, true)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("failed to create file ");
                                sb3.append(obj);
                                ConfigLog.e(TAG, sb3.toString());
                            } else {
                                FileOutputStream fileOutputStream = new FileOutputStream(obj);
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                zipInputStream.closeEntry();
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return true;
                    }
                }
            } catch (Exception e) {
                ConfigLog.e("unzip exception", e);
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x011f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0114 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean unzip(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.config.util.ConfigZipUtil.unzip(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static boolean copyAssetsToTarget(Context context, String str, String str2) {
        try {
            if (Arrays.asList(context.getAssets().list(FileUtil.parentPath(str))).contains(str)) {
                return copyAssetsFiles(context, str, str2);
            }
            return true;
        } catch (IOException unused) {
            return true;
        }
    }

    private static boolean copyAssetsFiles(Context context, String str, String str2) {
        String obj;
        try {
            String[] list = context.getAssets().list(str);
            if (list.length == 0) {
                copyFile(context, str, str2);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            new File(sb.toString()).mkdirs();
            for (String str3 : list) {
                if (str.equals("")) {
                    obj = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("/");
                    obj = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append(str3);
                copyAssetsFiles(context, sb3.toString(), str2);
            }
            return true;
        } catch (IOException e) {
            InstrumentInjector.log_e(TAG, "I/O Exception", e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bd, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("endsWith", java.lang.String.class).invoke(r10, ".jpg")).booleanValue() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void copyFile(android.content.Context r9, java.lang.String r10, java.lang.String r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.config.util.ConfigZipUtil.copyFile(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
