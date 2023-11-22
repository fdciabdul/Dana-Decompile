package com.alibaba.jsi.standard;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class Util {
    private static final int kArgsCountError = 2;
    private static final int kJSEnginePathIsNull = 3;
    private static final int kLoadJSEngineSoFailed = 5;
    private static final int kNoError = 0;
    private static final int kNoImplemention = 1;
    private static final int kOpenJSEngineSoFailed = 4;
    private static String sAppDataDir = null;
    private static final String sJSEngineSoName = "libwebviewuc.so";
    private static String sJSEngineSoPathName = null;
    static String sJSIDataDir = null;
    private static boolean sJSISoIsLoaded = false;
    private static final String sJSISoName = "libjsi.so";
    private static String sJSISoPathName = null;
    private static String sLibraryDir = null;
    private static boolean sNeedCacheSoPaths = true;
    private static String sSoPathFilePathName = null;
    private static final String sSplitter = "`";
    private static boolean sV8SoIsLoaded;

    Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(Object obj) {
        if (sAppDataDir != null) {
            return;
        }
        sAppDataDir = OSUtil.getDataDir(obj);
        StringBuilder sb = new StringBuilder();
        sb.append(sAppDataDir);
        sb.append("/app_jsi");
        sJSIDataDir = sb.toString();
        sLibraryDir = OSUtil.getNativeLibDir(obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sJSIDataDir);
        sb2.append("/sopaths");
        sSoPathFilePathName = sb2.toString();
        File file = new File(sJSIDataDir);
        if (file.isFile()) {
            file.delete();
        }
        if (file.exists() || file.mkdirs()) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Make JSI data dir failed: ");
        sb3.append(sJSIDataDir);
        OSUtil.e(sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean loadSo(String str, String str2, String str3) {
        if (sJSISoIsLoaded && sV8SoIsLoaded) {
            return true;
        }
        boolean z = str3 == null || str3.isEmpty() || "v8".equals(str3);
        locateSo(str, str2, z);
        String str4 = sJSISoPathName;
        if (str4 == null) {
            throw new RuntimeException("Can not locate jsi so: libjsi.so");
        }
        if (!sJSISoIsLoaded) {
            System.load(str4);
            sJSISoIsLoaded = true;
        }
        String engineType = JSEngineBase.getEngineType();
        boolean z2 = z && engineType != null && engineType.contains("v8");
        String str5 = sJSEngineSoPathName;
        if (str5 == null && z2) {
            throw new RuntimeException("Can not locate JS engine so: libwebviewuc.so");
        }
        if (z2 && !sV8SoIsLoaded) {
            long nativeCommand = JNIBridge.nativeCommand(1L, 0L, new Object[]{str5});
            if (nativeCommand == 0) {
                sV8SoIsLoaded = true;
            } else if (nativeCommand != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Load JS engine '");
                sb.append(sJSEngineSoPathName);
                sb.append("' failed, code: ");
                sb.append(nativeCommand);
                sb.append(", message: ");
                sb.append(getSoLoadError(true));
                throw new RuntimeException(sb.toString());
            } else {
                OSUtil.i("UC linker is disabled, loaded JS engine so by default.");
            }
        }
        if (sNeedCacheSoPaths) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sJSISoPathName);
            sb2.append(sSplitter);
            sb2.append(sJSEngineSoPathName);
            sb2.append(sSplitter);
            sb2.append(String.valueOf(new File(sJSISoPathName).length()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sSoPathFilePathName);
            sb3.append(".tmp");
            File file = new File(sb3.toString());
            writeFile(file, sb2.toString());
            File file2 = new File(sSoPathFilePathName);
            try {
                file2.delete();
                file.renameTo(file2);
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static String getSoLoadError(boolean z) {
        Object[] objArr = new Object[1];
        if (JNIBridge.nativeCommand(4L, z ? 1L : 0L, objArr) == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    private static void locateSo(String str, String str2, boolean z) {
        if (sJSISoPathName == null && str != null && new File(str).isFile()) {
            sJSISoPathName = str;
        }
        if (sJSEngineSoPathName == null && str2 != null && new File(str2).isFile()) {
            sJSEngineSoPathName = str2;
        }
        if (sJSISoPathName != null && (!z || sJSEngineSoPathName != null)) {
            sNeedCacheSoPaths = false;
        } else if (parseFromFile(z)) {
        } else {
            if (sJSISoPathName == null) {
                File file = new File(sLibraryDir, sJSISoName);
                if (file.isFile()) {
                    sJSISoPathName = file.getPath();
                }
            }
            if (sJSEngineSoPathName == null) {
                File file2 = new File(sLibraryDir, sJSEngineSoName);
                if (file2.isFile()) {
                    sJSEngineSoPathName = file2.getPath();
                }
            }
            if (sJSISoPathName == null || (z && sJSEngineSoPathName == null)) {
                File file3 = new File(sAppDataDir, "app_h5container");
                if (file3.isDirectory() && searchForAlipay(file3, z)) {
                    return;
                }
                File file4 = new File(sAppDataDir, "app_ucmsdk");
                if (file4.isDirectory()) {
                    searchForCommon(file4, z);
                }
            }
        }
    }

    private static boolean searchForAlipay(File file, boolean z) {
        File[] listFiles;
        File file2 = new File(file, "uc");
        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3.isDirectory() && findSoInDir(new File(file3, "so/lib"), z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean searchForCommon(File file, boolean z) {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3 = file.listFiles();
        if (listFiles3 == null) {
            return false;
        }
        for (File file2 : listFiles3) {
            if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                for (File file3 : listFiles) {
                    if (file3.isDirectory() && (listFiles2 = file3.listFiles()) != null) {
                        for (File file4 : listFiles2) {
                            File file5 = new File(file4, "lib");
                            if (findSoInDir(file5, z)) {
                                return true;
                            }
                            File[] listFiles4 = file5.listFiles();
                            if (listFiles4 != null) {
                                for (File file6 : listFiles4) {
                                    if (findSoInDir(file6, z)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean findSoInDir(File file, boolean z) {
        if (file.isDirectory()) {
            File file2 = new File(file, sJSISoName);
            if (file2.isFile()) {
                sJSISoPathName = file2.getPath();
            }
            File file3 = new File(file, sJSEngineSoName);
            if (file3.isFile()) {
                sJSEngineSoPathName = file3.getPath();
            }
            if (sJSISoPathName != null) {
                return (z && sJSEngineSoPathName == null) ? false : true;
            }
            return false;
        }
        return false;
    }

    private static boolean parseFromFile(boolean z) {
        String readFileContents;
        long j;
        File file = new File(sSoPathFilePathName);
        if (file.isFile() && (readFileContents = readFileContents(file)) != null) {
            String[] split = readFileContents.trim().split(sSplitter);
            if (split.length != 3) {
                return false;
            }
            try {
                j = Long.parseLong(split[2]);
            } catch (NumberFormatException unused) {
                j = 0;
            }
            if (j == 0) {
                return false;
            }
            File file2 = new File(split[0]);
            if (file2.isFile() && file2.getName().equals(sJSISoName) && file2.length() == j) {
                sJSISoPathName = split[0];
                if (new File(split[1]).isFile()) {
                    sJSEngineSoPathName = split[1];
                    sNeedCacheSoPaths = false;
                }
                return (z && sJSEngineSoPathName == null) ? false : true;
            }
            return false;
        }
        return false;
    }

    private static String readFileContents(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                    } else {
                        String obj = sb.toString();
                        safeClose(fileInputStream);
                        return obj;
                    }
                }
            } catch (Throwable unused) {
                safeClose(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    private static boolean writeFile(File file, String str) {
        FileWriter fileWriter;
        boolean z = false;
        try {
            fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str, 0, str.length());
                z = true;
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileWriter = null;
        }
        safeClose(fileWriter);
        return z;
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
