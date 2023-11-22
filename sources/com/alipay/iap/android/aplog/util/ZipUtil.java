package com.alipay.iap.android.aplog.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class ZipUtil {
    private static final int BUFFER_LENGTH = 8192;

    /* loaded from: classes3.dex */
    public interface ZipFileHandler {
        String handleFileNameInZip(File file);
    }

    public static void zipFile(List<File> list, String str, File file, ZipFileHandler zipFileHandler) throws Exception {
        ZipOutputStream zipOutputStream;
        if (list == null || list.isEmpty()) {
            throw new Exception("willZipList is empty");
        }
        if (str == null || str.length() == 0) {
            throw new Exception("zipFilePath is none");
        }
        File file2 = new File(str);
        if (file2.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("zipFilePath is directory: ");
            sb.append(str);
            throw new Exception(sb.toString());
        }
        try {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
        } catch (Throwable unused) {
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            try {
                byte[] bArr = new byte[8192];
                for (int i = 0; i < list.size(); i++) {
                    File file3 = list.get(i);
                    if (file3 != null && file3.exists() && file3.isFile() && file3.length() != 0) {
                        ZipEntry zipEntry = new ZipEntry(getAbsFileName(file, file3, zipFileHandler));
                        zipEntry.setSize(file3.length());
                        zipEntry.setTime(file3.lastModified());
                        zipOutputStream.putNextEntry(zipEntry);
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file3));
                        while (true) {
                            try {
                                int read = bufferedInputStream2.read(bArr);
                                if (read != -1) {
                                    zipOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Throwable unused2) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                try {
                                    throw new Exception(th);
                                } finally {
                                }
                            }
                        }
                        bufferedInputStream2.close();
                        try {
                            zipOutputStream.flush();
                        } catch (Throwable unused3) {
                        }
                        try {
                            zipOutputStream.closeEntry();
                        } catch (Throwable unused4) {
                        }
                        bufferedInputStream = bufferedInputStream2;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                try {
                    zipOutputStream.close();
                } catch (Throwable unused6) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
    }

    private static String getAbsFileName(File file, File file2, ZipFileHandler zipFileHandler) {
        String str = null;
        if (file2 == null) {
            return null;
        }
        if (file == null) {
            file = file2.getParentFile();
        }
        if (zipFileHandler != null) {
            try {
                str = zipFileHandler.handleFileNameInZip(file2);
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = file2.getName();
        }
        while (true) {
            file2 = file2.getParentFile();
            if (file2 == null || file2.equals(file)) {
                break;
            }
            String name = file2.getName();
            if (TextUtils.isEmpty(name)) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append('/');
            sb.append(str);
            str = sb.toString();
        }
        return str;
    }

    public static byte[] unCompressGzip(InputStream inputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            byte[] bArr = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Throwable unused3) {
                    }
                }
            }
            byteArrayOutputStream.close();
            gZIPInputStream.close();
        } catch (Throwable unused4) {
            gZIPInputStream2 = gZIPInputStream;
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused5) {
            }
            if (gZIPInputStream2 != null) {
                gZIPInputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}
