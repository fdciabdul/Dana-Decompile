package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.hms.common.PackageConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes8.dex */
public class BksUtil {
    private static final Uri getAuthRequestContext = Uri.parse("content://com.huawei.hwid");
    private static final String[] BuiltInFictitiousFunctionClassFactory = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    private BksUtil() {
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory(context));
        sb.append(File.separator);
        sb.append("hmsrootcas.bks");
        return new File(sb.toString()).exists();
    }

    public static InputStream PlaceComponentResult(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream2;
        String MyBillsEntityDataFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        FileOutputStream fileOutputStream;
        Throwable th;
        synchronized (BksUtil.class) {
            g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", "get bks from tss begin");
            if (context != null) {
                c.getAuthRequestContext(context);
            }
            Context PlaceComponentResult = c.PlaceComponentResult();
            InputStream inputStream2 = null;
            r1 = null;
            FileOutputStream fileOutputStream2 = null;
            r1 = null;
            r1 = null;
            ByteArrayInputStream byteArrayInputStream3 = null;
            if (PlaceComponentResult == null) {
                g.getAuthRequestContext("BksUtil", HummerZCodeConstant.CONTEXT_ERROR_MSG);
                return null;
            } else if (!PlaceComponentResult(h.PlaceComponentResult("com.huawei.hwid")) && !PlaceComponentResult(h.PlaceComponentResult(PackageConstants.SERVICES_PACKAGE_ALL_SCENE))) {
                StringBuilder sb = new StringBuilder();
                sb.append("hms version code is too low : ");
                sb.append(h.PlaceComponentResult("com.huawei.hwid"));
                g.getAuthRequestContext("BksUtil", sb.toString());
                return null;
            } else if (!MyBillsEntityDataFactory(PlaceComponentResult, "com.huawei.hwid") && !BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, PackageConstants.SERVICES_PACKAGE_ALL_SCENE)) {
                g.getAuthRequestContext("BksUtil", "hms sign error");
                return null;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream = PlaceComponentResult.getContentResolver().openInputStream(Uri.withAppendedPath(getAuthRequestContext, "files/hmsrootcas.bks"));
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                MyBillsEntityDataFactory = i.MyBillsEntityDataFactory("bks_hash", "", PlaceComponentResult);
                                KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(byteArrayOutputStream.toByteArray());
                            } catch (Exception unused) {
                                byteArrayInputStream3 = byteArrayInputStream2;
                                g.getAuthRequestContext("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider");
                                f.BuiltInFictitiousFunctionClassFactory(inputStream);
                                f.MyBillsEntityDataFactory(byteArrayOutputStream);
                                f.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream3);
                                return getAuthRequestContext(PlaceComponentResult);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                byteArrayInputStream = byteArrayInputStream2;
                                f.BuiltInFictitiousFunctionClassFactory(inputStream2);
                                f.MyBillsEntityDataFactory(byteArrayOutputStream);
                                f.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            InputStream inputStream3 = inputStream;
                            byteArrayInputStream = byteArrayInputStream3;
                            inputStream2 = inputStream3;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayInputStream = null;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult) && MyBillsEntityDataFactory.equals(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", "bks not update");
                    f.BuiltInFictitiousFunctionClassFactory(inputStream);
                    f.MyBillsEntityDataFactory(byteArrayOutputStream);
                    f.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream2);
                    return getAuthRequestContext(PlaceComponentResult);
                }
                g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", "update bks and sp");
                if (PlaceComponentResult != null) {
                    String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(PlaceComponentResult);
                    if (!new File(MyBillsEntityDataFactory2).exists() && !TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
                        File file = new File(MyBillsEntityDataFactory2);
                        if (file.exists()) {
                            g.MyBillsEntityDataFactory("BksUtil", "The directory  has already exists");
                        } else if (file.mkdirs()) {
                            g.PlaceComponentResult();
                        } else {
                            g.getAuthRequestContext("BksUtil", "create directory  failed");
                        }
                    }
                    File file2 = new File(MyBillsEntityDataFactory2, "hmsrootcas.bks");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        try {
                            g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", "write output stream ");
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr2 = new byte[2048];
                                while (true) {
                                    int read2 = byteArrayInputStream2.read(bArr2, 0, 2048);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr2, 0, read2);
                                }
                                f.MyBillsEntityDataFactory(fileOutputStream);
                            } catch (IOException unused4) {
                                fileOutputStream2 = fileOutputStream;
                                g.getAuthRequestContext("BksUtil", " IOException");
                                f.MyBillsEntityDataFactory(fileOutputStream2);
                                i.getAuthRequestContext(PlaceComponentResult).edit().putString("bks_hash", KClassImpl$Data$declaredNonStaticMembers$2).apply();
                                f.BuiltInFictitiousFunctionClassFactory(inputStream);
                                f.MyBillsEntityDataFactory(byteArrayOutputStream);
                                f.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream2);
                                return getAuthRequestContext(PlaceComponentResult);
                            } catch (Throwable th5) {
                                th = th5;
                                f.MyBillsEntityDataFactory(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException unused5) {
                        }
                    } catch (Throwable th6) {
                        fileOutputStream = fileOutputStream2;
                        th = th6;
                    }
                }
                i.getAuthRequestContext(PlaceComponentResult).edit().putString("bks_hash", KClassImpl$Data$declaredNonStaticMembers$2).apply();
                f.BuiltInFictitiousFunctionClassFactory(inputStream);
                f.MyBillsEntityDataFactory(byteArrayOutputStream);
                f.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream2);
                return getAuthRequestContext(PlaceComponentResult);
            }
        }
    }

    public static InputStream getAuthRequestContext(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(context)) {
            g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", "getFilesBksIS ");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(MyBillsEntityDataFactory(context));
                sb.append(File.separator);
                sb.append("hmsrootcas.bks");
                return new FileInputStream(sb.toString());
            } catch (FileNotFoundException unused) {
                g.getAuthRequestContext("BksUtil", "FileNotFoundExceptio: ");
                return null;
            }
        }
        return null;
    }

    private static boolean PlaceComponentResult(String str) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hms version code is : ");
        sb.append(str);
        g.KClassImpl$Data$declaredNonStaticMembers$2("BksUtil", sb.toString());
        String[] split = str.split("\\.");
        String[] split2 = "4.0.2.300".split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        int i = 0;
        while (i < max) {
            if (i < length) {
                try {
                    parseInt = Integer.parseInt(split[i]);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" exception : ");
                    sb2.append(e.getMessage());
                    g.getAuthRequestContext("BksUtil", sb2.toString());
                    return i >= length2;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i < length2 ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i++;
        }
        return true;
    }

    private static boolean MyBillsEntityDataFactory(Context context, String str) {
        byte[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(context, str);
        for (String str2 : BuiltInFictitiousFunctionClassFactory) {
            if (str2.equalsIgnoreCase(BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2))) {
                return true;
            }
        }
        return false;
    }

    private static String BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return MyBillsEntityDataFactory(MessageDigest.getInstance("SHA-256").digest(bArr));
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("NoSuchAlgorithmException");
                sb.append(e.getMessage());
                InstrumentInjector.log_e("BksUtil", sb.toString());
            }
        }
        return "";
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(context, str)));
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return MyBillsEntityDataFactory(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            g.getAuthRequestContext("BksUtil", "inputstraem exception");
            return "";
        }
    }

    private static String MyBillsEntityDataFactory(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.createDeviceProtectedStorageContext().getFilesDir());
            sb.append(File.separator);
            sb.append("aegis");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getApplicationContext().getFilesDir());
        sb2.append(File.separator);
        sb2.append("aegis");
        return sb2.toString();
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("PackageManager.NameNotFoundException : ");
                sb.append(e.getMessage());
                InstrumentInjector.log_e("BksUtil", sb.toString());
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get pm exception : ");
                sb2.append(e2.getMessage());
                InstrumentInjector.log_e("BksUtil", sb2.toString());
            }
            return new byte[0];
        }
        InstrumentInjector.log_e("BksUtil", "packageName is null or context is null");
        return new byte[0];
    }

    private static String MyBillsEntityDataFactory(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
