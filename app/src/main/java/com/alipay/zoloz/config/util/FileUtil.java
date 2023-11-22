package com.alipay.zoloz.config.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class FileUtil {
    private static final int IO_BUFFER_SIZE = 16384;
    public static final String TAG = "FileUtil";

    public static boolean create(String str) {
        return create(str, false);
    }

    public static boolean create(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (exists(str)) {
            return true;
        }
        mkdirs(getParent(str), z);
        try {
            return new File(str).createNewFile();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean mkdirs(String str) {
        return mkdirs(str, false);
    }

    public static boolean mkdirs(String str, boolean z) {
        File file = new File(str);
        if (exists(str) && !isFolder(str)) {
            if (!z) {
                return false;
            }
            delete(file);
        }
        try {
            file.mkdirs();
        } catch (Exception unused) {
        }
        return exists(file);
    }

    public static boolean move(String str, String str2) {
        return move(str, str2, false);
    }

    public static boolean move(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !exists(str)) {
            return false;
        }
        if (exists(str2)) {
            if (!z) {
                return false;
            }
            delete(str2);
        }
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return delete(new File(str));
    }

    public static boolean delete(File file) {
        boolean z = true;
        if (exists(file)) {
            if (file.isFile()) {
                return file.delete();
            }
            for (File file2 : file.listFiles()) {
                z |= delete(file2);
            }
            return file.delete() | z;
        }
        return true;
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return exists(new File(str));
    }

    public static boolean exists(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static final String getParent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getParent(new File(cleanPath(str)));
    }

    public static final String getParent(File file) {
        if (file == null) {
            return null;
        }
        return file.getParent();
    }

    public static boolean childOf(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String cleanPath = cleanPath(str);
        String cleanPath2 = cleanPath(str2);
        StringBuilder sb = new StringBuilder();
        sb.append(cleanPath2);
        sb.append(File.separator);
        return cleanPath.startsWith(sb.toString());
    }

    public static int childCount(String str) {
        File[] listFiles;
        if (!exists(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
            return 0;
        }
        return listFiles.length;
    }

    public static String cleanPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (Exception unused) {
            return str;
        }
    }

    public static long size(String str) {
        if (str == null) {
            return 0L;
        }
        return size(new File(str));
    }

    public static long size(File file) {
        long j = 0;
        if (exists(file)) {
            if (isFile(file)) {
                return file.length();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    j += size(file2);
                }
            }
            return j;
        }
        return 0L;
    }

    public static boolean copy(String str, String str2) {
        return copy(str, str2, false);
    }

    public static boolean copy(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(str2)) {
                return true;
            }
            if (exists(str) && isFile(str)) {
                if (exists(str2)) {
                    if (!z) {
                        return false;
                    }
                    delete(str2);
                }
                if (!create(str2)) {
                    return false;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[IO_BUFFER_SIZE];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        try {
                            fileInputStream.close();
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                        return true;
                    } catch (Exception unused2) {
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                }
            }
        }
        return false;
    }

    public static String fileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(cleanPath(str)).getName();
    }

    public static String parentPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        cleanPath(str);
        File file = new File(str);
        return file.getParent() == null ? "" : file.getParent();
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        return getExtension(file.getName());
    }

    public static String getExtension(String str) {
        int lastIndexOf;
        return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : "";
    }

    public static String getMimeType(File file) {
        return file == null ? "*/*" : getMimeType(file.getName());
    }

    public static String getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "*/*";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(getExtension(str));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "*/*" : mimeTypeFromExtension;
    }

    public static final boolean isFile(String str) {
        if (exists(str)) {
            return isFile(new File(str));
        }
        return false;
    }

    public static final boolean isFile(File file) {
        if (file == null) {
            return false;
        }
        return file.isFile();
    }

    public static final boolean isFolder(String str) {
        if (exists(str)) {
            return new File(str).isDirectory();
        }
        return false;
    }

    public static final String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf + 1, str.length());
    }

    public static final String getFileStem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : "";
    }

    public static String getFileSHA1(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byte[] bArr = new byte[IO_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                str2 = SecurityUtil.bytes2Hex(messageDigest.digest());
            } catch (Exception unused2) {
                fileInputStream.close();
            }
        } catch (IOException unused3) {
        }
        return !TextUtils.isEmpty(str2) ? str2.trim() : str2;
    }

    public static String getFileMD5(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
                byte[] bArr = new byte[IO_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                str2 = SecurityUtil.bytes2Hex(messageDigest.digest());
            } catch (Exception unused2) {
                fileInputStream.close();
            }
        } catch (IOException unused3) {
        }
        return !TextUtils.isEmpty(str2) ? str2.trim() : str2;
    }

    public static String getText(String str) {
        if (!exists(str)) {
            return null;
        }
        File file = new File(str);
        int length = (int) file.length();
        if (length > 20480) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 1024);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
